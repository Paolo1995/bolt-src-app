package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.Spliterator;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes5.dex */
public final class ChannelOutboundBuffer {
    private final Channel channel;
    private volatile Runnable fireChannelWritabilityChangedTask;
    private int flushed;
    private Entry flushedEntry;
    private boolean inFail;
    private int nioBufferCount;
    private long nioBufferSize;
    private Entry tailEntry;
    private volatile long totalPendingSize;
    private Entry unflushedEntry;
    private volatile int unwritable;
    static final int CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.outboundBufferEntrySizeOverhead", 96);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelOutboundBuffer.class);
    private static final FastThreadLocal<ByteBuffer[]> NIO_BUFFERS = new FastThreadLocal<ByteBuffer[]>() { // from class: io.netty.channel.ChannelOutboundBuffer.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public ByteBuffer[] initialValue() throws Exception {
            return new ByteBuffer[Spliterator.IMMUTABLE];
        }
    };
    private static final AtomicLongFieldUpdater<ChannelOutboundBuffer> TOTAL_PENDING_SIZE_UPDATER = AtomicLongFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "totalPendingSize");
    private static final AtomicIntegerFieldUpdater<ChannelOutboundBuffer> UNWRITABLE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ChannelOutboundBuffer.class, "unwritable");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Entry {
        private static final ObjectPool<Entry> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<Entry>() { // from class: io.netty.channel.ChannelOutboundBuffer.Entry.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public Entry newObject(ObjectPool.Handle<Entry> handle) {
                return new Entry(handle);
            }
        });
        ByteBuffer buf;
        ByteBuffer[] bufs;
        boolean cancelled;
        int count;
        private final ObjectPool.Handle<Entry> handle;
        Object msg;
        Entry next;
        int pendingSize;
        long progress;
        ChannelPromise promise;
        long total;

        static Entry newInstance(Object obj, int i8, long j8, ChannelPromise channelPromise) {
            Entry entry = RECYCLER.get();
            entry.msg = obj;
            entry.pendingSize = i8 + ChannelOutboundBuffer.CHANNEL_OUTBOUND_BUFFER_ENTRY_OVERHEAD;
            entry.total = j8;
            entry.promise = channelPromise;
            return entry;
        }

        int cancel() {
            if (this.cancelled) {
                return 0;
            }
            this.cancelled = true;
            int i8 = this.pendingSize;
            ReferenceCountUtil.safeRelease(this.msg);
            this.msg = Unpooled.EMPTY_BUFFER;
            this.pendingSize = 0;
            this.total = 0L;
            this.progress = 0L;
            this.bufs = null;
            this.buf = null;
            return i8;
        }

        void recycle() {
            this.next = null;
            this.bufs = null;
            this.buf = null;
            this.msg = null;
            this.promise = null;
            this.progress = 0L;
            this.total = 0L;
            this.pendingSize = 0;
            this.count = -1;
            this.cancelled = false;
            this.handle.recycle(this);
        }

        Entry recycleAndGetNext() {
            Entry entry = this.next;
            recycle();
            return entry;
        }

        private Entry(ObjectPool.Handle<Entry> handle) {
            this.count = -1;
            this.handle = handle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelOutboundBuffer(AbstractChannel abstractChannel) {
        this.channel = abstractChannel;
    }

    private void clearNioBuffers() {
        int i8 = this.nioBufferCount;
        if (i8 > 0) {
            this.nioBufferCount = 0;
            Arrays.fill(NIO_BUFFERS.get(), 0, i8, (Object) null);
        }
    }

    private static ByteBuffer[] expandNioBufferArray(ByteBuffer[] byteBufferArr, int i8, int i9) {
        int length = byteBufferArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i8 > length);
        ByteBuffer[] byteBufferArr2 = new ByteBuffer[length];
        System.arraycopy(byteBufferArr, 0, byteBufferArr2, 0, i9);
        return byteBufferArr2;
    }

    private void fireChannelWritabilityChanged(boolean z7) {
        final ChannelPipeline pipeline = this.channel.pipeline();
        if (z7) {
            Runnable runnable = this.fireChannelWritabilityChangedTask;
            if (runnable == null) {
                runnable = new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pipeline.fireChannelWritabilityChanged();
                    }
                };
                this.fireChannelWritabilityChangedTask = runnable;
            }
            this.channel.eventLoop().execute(runnable);
            return;
        }
        pipeline.fireChannelWritabilityChanged();
    }

    private boolean isFlushedEntry(Entry entry) {
        if (entry != null && entry != this.unflushedEntry) {
            return true;
        }
        return false;
    }

    private boolean remove0(Throwable th, boolean z7) {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i8 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeFail(channelPromise, th);
            decrementPendingOutboundBytes(i8, false, z7);
        }
        entry.recycle();
        return true;
    }

    private void removeEntry(Entry entry) {
        int i8 = this.flushed - 1;
        this.flushed = i8;
        if (i8 == 0) {
            this.flushedEntry = null;
            if (entry == this.tailEntry) {
                this.tailEntry = null;
                this.unflushedEntry = null;
                return;
            }
            return;
        }
        this.flushedEntry = entry.next;
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        InternalLogger internalLogger;
        if (channelPromise instanceof VoidChannelPromise) {
            internalLogger = null;
        } else {
            internalLogger = logger;
        }
        PromiseNotificationUtil.tryFailure(channelPromise, th, internalLogger);
    }

    private static void safeSuccess(ChannelPromise channelPromise) {
        InternalLogger internalLogger;
        if (channelPromise instanceof VoidChannelPromise) {
            internalLogger = null;
        } else {
            internalLogger = logger;
        }
        PromiseNotificationUtil.trySuccess(channelPromise, null, internalLogger);
    }

    private void setUnwritable(boolean z7) {
        int i8;
        int i9;
        do {
            i8 = this.unwritable;
            i9 = i8 | 1;
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i8, i9));
        if (i8 == 0 && i9 != 0) {
            fireChannelWritabilityChanged(z7);
        }
    }

    private void setWritable(boolean z7) {
        int i8;
        int i9;
        do {
            i8 = this.unwritable;
            i9 = i8 & (-2);
        } while (!UNWRITABLE_UPDATER.compareAndSet(this, i8, i9));
        if (i8 != 0 && i9 == 0) {
            fireChannelWritabilityChanged(z7);
        }
    }

    private static long total(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        if (obj instanceof ByteBufHolder) {
            return ((ByteBufHolder) obj).content().readableBytes();
        }
        return -1L;
    }

    public void addFlush() {
        Entry entry = this.unflushedEntry;
        if (entry != null) {
            if (this.flushedEntry == null) {
                this.flushedEntry = entry;
            }
            do {
                this.flushed++;
                if (!entry.promise.setUncancellable()) {
                    decrementPendingOutboundBytes(entry.cancel(), false, true);
                }
                entry = entry.next;
            } while (entry != null);
            this.unflushedEntry = null;
        }
    }

    public void addMessage(Object obj, int i8, ChannelPromise channelPromise) {
        Entry newInstance = Entry.newInstance(obj, i8, total(obj), channelPromise);
        Entry entry = this.tailEntry;
        if (entry == null) {
            this.flushedEntry = null;
        } else {
            entry.next = newInstance;
        }
        this.tailEntry = newInstance;
        if (this.unflushedEntry == null) {
            this.unflushedEntry = newInstance;
        }
        incrementPendingOutboundBytes(newInstance.pendingSize, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close(final Throwable th, final boolean z7) {
        if (this.inFail) {
            this.channel.eventLoop().execute(new Runnable() { // from class: io.netty.channel.ChannelOutboundBuffer.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelOutboundBuffer.this.close(th, z7);
                }
            });
            return;
        }
        this.inFail = true;
        if (!z7 && this.channel.isOpen()) {
            throw new IllegalStateException("close() must be invoked after the channel is closed.");
        }
        if (isEmpty()) {
            try {
                for (Entry entry = this.unflushedEntry; entry != null; entry = entry.recycleAndGetNext()) {
                    TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -entry.pendingSize);
                    if (!entry.cancelled) {
                        ReferenceCountUtil.safeRelease(entry.msg);
                        safeFail(entry.promise, th);
                    }
                }
                this.inFail = false;
                clearNioBuffers();
                return;
            } catch (Throwable th2) {
                this.inFail = false;
                throw th2;
            }
        }
        throw new IllegalStateException("close() must be invoked after all flushed writes are handled.");
    }

    public Object current() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            return null;
        }
        return entry.msg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void decrementPendingOutboundBytes(long j8) {
        decrementPendingOutboundBytes(j8, true, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void failFlushed(Throwable th, boolean z7) {
        if (this.inFail) {
            return;
        }
        try {
            this.inFail = true;
            do {
            } while (remove0(th, z7));
        } finally {
            this.inFail = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void incrementPendingOutboundBytes(long j8) {
        incrementPendingOutboundBytes(j8, true);
    }

    public boolean isEmpty() {
        if (this.flushed == 0) {
            return true;
        }
        return false;
    }

    public boolean isWritable() {
        if (this.unwritable == 0) {
            return true;
        }
        return false;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public long nioBufferSize() {
        return this.nioBufferSize;
    }

    public ByteBuffer[] nioBuffers(int i8, long j8) {
        ByteBuf byteBuf;
        int readerIndex;
        int writerIndex;
        long j9 = 0;
        int i9 = 0;
        InternalThreadLocalMap internalThreadLocalMap = InternalThreadLocalMap.get();
        ByteBuffer[] byteBufferArr = NIO_BUFFERS.get(internalThreadLocalMap);
        for (Entry entry = this.flushedEntry; isFlushedEntry(entry); entry = entry.next) {
            Object obj = entry.msg;
            if (!(obj instanceof ByteBuf)) {
                break;
            }
            if (!entry.cancelled && (writerIndex = byteBuf.writerIndex() - (readerIndex = (byteBuf = (ByteBuf) obj).readerIndex())) > 0) {
                long j10 = writerIndex;
                if (j8 - j10 < j9 && i9 != 0) {
                    break;
                }
                j9 += j10;
                int i10 = entry.count;
                if (i10 == -1) {
                    i10 = byteBuf.nioBufferCount();
                    entry.count = i10;
                }
                int min = Math.min(i8, i9 + i10);
                if (min > byteBufferArr.length) {
                    byteBufferArr = expandNioBufferArray(byteBufferArr, min, i9);
                    NIO_BUFFERS.set(internalThreadLocalMap, byteBufferArr);
                }
                if (i10 == 1) {
                    ByteBuffer byteBuffer = entry.buf;
                    if (byteBuffer == null) {
                        byteBuffer = byteBuf.internalNioBuffer(readerIndex, writerIndex);
                        entry.buf = byteBuffer;
                    }
                    byteBufferArr[i9] = byteBuffer;
                    i9++;
                } else {
                    i9 = nioBuffers(entry, byteBuf, byteBufferArr, i9, i8);
                }
                if (i9 == i8) {
                    break;
                }
            }
        }
        this.nioBufferCount = i9;
        this.nioBufferSize = j9;
        return byteBufferArr;
    }

    public void progress(long j8) {
        Entry entry = this.flushedEntry;
        ChannelPromise channelPromise = entry.promise;
        long j9 = entry.progress + j8;
        entry.progress = j9;
        if (channelPromise instanceof ChannelProgressivePromise) {
            ((ChannelProgressivePromise) channelPromise).tryProgress(j9, entry.total);
        }
    }

    public boolean remove() {
        Entry entry = this.flushedEntry;
        if (entry == null) {
            clearNioBuffers();
            return false;
        }
        Object obj = entry.msg;
        ChannelPromise channelPromise = entry.promise;
        int i8 = entry.pendingSize;
        removeEntry(entry);
        if (!entry.cancelled) {
            ReferenceCountUtil.safeRelease(obj);
            safeSuccess(channelPromise);
            decrementPendingOutboundBytes(i8, false, true);
        }
        entry.recycle();
        return true;
    }

    public void removeBytes(long j8) {
        while (true) {
            Object current = current();
            if (!(current instanceof ByteBuf)) {
                break;
            }
            ByteBuf byteBuf = (ByteBuf) current;
            int readerIndex = byteBuf.readerIndex();
            long writerIndex = byteBuf.writerIndex() - readerIndex;
            if (writerIndex <= j8) {
                if (j8 != 0) {
                    progress(writerIndex);
                    j8 -= writerIndex;
                }
                remove();
            } else if (j8 != 0) {
                byteBuf.readerIndex(readerIndex + ((int) j8));
                progress(j8);
            }
        }
        clearNioBuffers();
    }

    private void decrementPendingOutboundBytes(long j8, boolean z7, boolean z8) {
        if (j8 == 0) {
            return;
        }
        long addAndGet = TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, -j8);
        if (!z8 || addAndGet >= this.channel.config().getWriteBufferLowWaterMark()) {
            return;
        }
        setWritable(z7);
    }

    private void incrementPendingOutboundBytes(long j8, boolean z7) {
        if (j8 != 0 && TOTAL_PENDING_SIZE_UPDATER.addAndGet(this, j8) > this.channel.config().getWriteBufferHighWaterMark()) {
            setUnwritable(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close(ClosedChannelException closedChannelException) {
        close(closedChannelException, false);
    }

    private static int nioBuffers(Entry entry, ByteBuf byteBuf, ByteBuffer[] byteBufferArr, int i8, int i9) {
        ByteBuffer byteBuffer;
        ByteBuffer[] byteBufferArr2 = entry.bufs;
        if (byteBufferArr2 == null) {
            byteBufferArr2 = byteBuf.nioBuffers();
            entry.bufs = byteBufferArr2;
        }
        for (int i10 = 0; i10 < byteBufferArr2.length && i8 < i9 && (byteBuffer = byteBufferArr2[i10]) != null; i10++) {
            if (byteBuffer.hasRemaining()) {
                byteBufferArr[i8] = byteBuffer;
                i8++;
            }
        }
        return i8;
    }
}
