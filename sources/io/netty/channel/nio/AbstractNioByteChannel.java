package io.netty.channel.nio;

import com.google.android.gms.common.api.Api;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* loaded from: classes5.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private final Runnable flushTask;
    private boolean inputClosedSeenErrorOnRead;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        /* JADX INFO: Access modifiers changed from: protected */
        public NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (AbstractNioByteChannel.this.isInputShutdown0()) {
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
            } else if (AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                AbstractNioByteChannel.this.shutdownInput();
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
            } else {
                close(voidPromise());
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z7, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead(byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z7 || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
            r5.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
            if (r7.lastBytesRead() >= 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
            r8 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
            if (r8 == false) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
            r9.this$0.readPending = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
            r5 = r1;
            r4 = null;
            r6 = r8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
            r4 = r8;
         */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0094 A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void read() {
            /*
                r9 = this;
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelConfig r0 = r0.config()
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.shouldBreakReadReady(r0)
                if (r1 == 0) goto L14
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                r0.clearReadPending()
                return
            L14:
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                io.netty.channel.RecvByteBufAllocator$Handle r7 = r9.recvBufAllocHandle()
                r7.reset(r0)
            L25:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r7.allocate(r1)     // Catch: java.lang.Throwable -> L86
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L81
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> L81
                r7.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L81
                int r6 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L81
                r8 = 1
                if (r6 > 0) goto L54
                r5.release()     // Catch: java.lang.Throwable -> L81
                int r1 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L86
                if (r1 >= 0) goto L45
                goto L46
            L45:
                r8 = 0
            L46:
                if (r8 == 0) goto L52
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L4d
                r1.readPending = r4     // Catch: java.lang.Throwable -> L4d
                goto L52
            L4d:
                r1 = move-exception
                r5 = r1
                r4 = r2
                r6 = r8
                goto L8a
            L52:
                r4 = r8
                goto L64
            L54:
                r7.incMessagesRead(r8)     // Catch: java.lang.Throwable -> L81
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L81
                r6.readPending = r4     // Catch: java.lang.Throwable -> L81
                r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> L81
                boolean r5 = r7.continueReading()     // Catch: java.lang.Throwable -> L86
                if (r5 != 0) goto L25
            L64:
                r7.readComplete()     // Catch: java.lang.Throwable -> L7c
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L7c
                if (r4 == 0) goto L6f
                r9.closeOnRead(r3)     // Catch: java.lang.Throwable -> L7c
            L6f:
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L9d
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L9d
                goto L9a
            L7c:
                r1 = move-exception
                r5 = r1
                r6 = r4
                r4 = r2
                goto L8a
            L81:
                r1 = move-exception
                r4 = r5
                r6 = 0
                r5 = r1
                goto L8a
            L86:
                r1 = move-exception
                r5 = r1
                r4 = r2
                r6 = 0
            L8a:
                r2 = r9
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9e
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L9d
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L9d
            L9a:
                r9.removeReadOp()
            L9d:
                return
            L9e:
                r1 = move-exception
                io.netty.channel.nio.AbstractNioByteChannel r2 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r2 = r2.readPending
                if (r2 != 0) goto Lae
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto Lae
                r9.removeReadOp()
            Lae:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe.read():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
        this.flushTask = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
            }
        };
    }

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int doWriteBytes = doWriteBytes(byteBuf);
            if (doWriteBytes > 0) {
                channelOutboundBuffer.progress(doWriteBytes);
                if (!byteBuf.isReadable()) {
                    channelOutboundBuffer.remove();
                }
                return 1;
            }
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else if (obj instanceof FileRegion) {
            FileRegion fileRegion = (FileRegion) obj;
            if (fileRegion.transferred() >= fileRegion.count()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            long doWriteFileRegion = doWriteFileRegion(fileRegion);
            if (doWriteFileRegion > 0) {
                channelOutboundBuffer.progress(doWriteFileRegion);
                if (fileRegion.transferred() >= fileRegion.count()) {
                    channelOutboundBuffer.remove();
                }
                return 1;
            }
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            throw new Error();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        if ((channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (!selectionKey.isValid()) {
            return;
        }
        int interestOps = selectionKey.interestOps();
        if ((interestOps & 4) != 0) {
            selectionKey.interestOps(interestOps & (-5));
        }
    }

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        boolean z7;
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object current = channelOutboundBuffer.current();
            if (current == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(channelOutboundBuffer, current);
        } while (writeSpinCount > 0);
        if (writeSpinCount < 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        incompleteWrite(z7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    protected abstract int doWriteBytes(ByteBuf byteBuf) throws Exception;

    protected abstract long doWriteFileRegion(FileRegion fileRegion) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (byteBuf.isDirect()) {
                return obj;
            }
            return newDirectBuffer(byteBuf);
        } else if (obj instanceof FileRegion) {
            return obj;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void incompleteWrite(boolean z7) {
        if (z7) {
            setOpWrite();
            return;
        }
        clearOpWrite();
        eventLoop().execute(this.flushTask);
    }

    protected boolean isInputShutdown0() {
        return false;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    protected final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (!selectionKey.isValid()) {
            return;
        }
        int interestOps = selectionKey.interestOps();
        if ((interestOps & 4) == 0) {
            selectionKey.interestOps(interestOps | 4);
        }
    }

    final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        if (isInputShutdown0() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig))) {
            return true;
        }
        return false;
    }

    protected abstract ChannelFuture shutdownInput();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }
}
