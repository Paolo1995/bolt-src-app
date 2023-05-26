package io.netty.buffer;

import com.google.android.gms.common.api.Api;
import io.netty.util.ByteProcessor;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    private final ByteBufAllocator alloc;
    private int componentCount;
    private Component[] components;
    private final boolean direct;
    private boolean freed;
    private Component lastAccessed;
    private final int maxNumComponents;
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.emptyList().iterator();
    static final ByteWrapper<byte[]> BYTE_ARRAY_WRAPPER = new ByteWrapper<byte[]>() { // from class: io.netty.buffer.CompositeByteBuf.1
    };
    static final ByteWrapper<ByteBuffer> BYTE_BUFFER_WRAPPER = new ByteWrapper<ByteBuffer>() { // from class: io.netty.buffer.CompositeByteBuf.2
    };

    /* loaded from: classes5.dex */
    interface ByteWrapper<T> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Component {
        int adjustment;
        final ByteBuf buf;
        int endOffset;
        int offset;
        private ByteBuf slice;
        int srcAdjustment;
        final ByteBuf srcBuf;

        Component(ByteBuf byteBuf, int i8, ByteBuf byteBuf2, int i9, int i10, int i11, ByteBuf byteBuf3) {
            this.srcBuf = byteBuf;
            this.srcAdjustment = i8 - i10;
            this.buf = byteBuf2;
            this.adjustment = i9 - i10;
            this.offset = i10;
            this.endOffset = i10 + i11;
            this.slice = byteBuf3;
        }

        void free() {
            this.slice = null;
            this.srcBuf.release();
        }

        int idx(int i8) {
            return i8 + this.adjustment;
        }

        ByteBuffer internalNioBuffer(int i8, int i9) {
            return this.srcBuf.internalNioBuffer(srcIdx(i8), i9);
        }

        int length() {
            return this.endOffset - this.offset;
        }

        void reposition(int i8) {
            int i9 = i8 - this.offset;
            this.endOffset += i9;
            this.srcAdjustment -= i9;
            this.adjustment -= i9;
            this.offset = i8;
        }

        ByteBuf slice() {
            ByteBuf byteBuf = this.slice;
            if (byteBuf == null) {
                ByteBuf slice = this.srcBuf.slice(srcIdx(this.offset), length());
                this.slice = slice;
                return slice;
            }
            return byteBuf;
        }

        int srcIdx(int i8) {
            return i8 + this.srcAdjustment;
        }

        void transferTo(ByteBuf byteBuf) {
            byteBuf.writeBytes(this.buf, idx(this.offset), length());
            free();
        }
    }

    /* loaded from: classes5.dex */
    private final class CompositeByteBufIterator implements Iterator<ByteBuf>, j$.util.Iterator {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = CompositeByteBuf.this.numComponents();
        }

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super ByteBuf> consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public boolean hasNext() {
            if (this.size > this.index) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }

        @Override // java.util.Iterator, j$.util.Iterator
        public ByteBuf next() {
            if (this.size == CompositeByteBuf.this.numComponents()) {
                if (hasNext()) {
                    try {
                        Component[] componentArr = CompositeByteBuf.this.components;
                        int i8 = this.index;
                        this.index = i8 + 1;
                        return componentArr[i8].slice();
                    } catch (IndexOutOfBoundsException unused) {
                        throw new ConcurrentModificationException();
                    }
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }
    }

    private CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z7, int i8, int i9) {
        super(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        if (i8 >= 1) {
            this.direct = z7;
            this.maxNumComponents = i8;
            this.components = newCompArray(i9, i8);
            return;
        }
        throw new IllegalArgumentException("maxNumComponents: " + i8 + " (expected: >= 1)");
    }

    private void addComp(int i8, Component component) {
        shiftComps(i8, 1);
        this.components[i8] = component;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031 A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #1 {all -> 0x001f, blocks: (B:5:0x0016, B:7:0x001b, B:13:0x0031, B:11:0x0024), top: B:21:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int addComponent0(boolean r6, int r7, io.netty.buffer.ByteBuf r8) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            r5.checkComponentIndex(r7)     // Catch: java.lang.Throwable -> L37
            io.netty.buffer.ByteBuf r2 = ensureAccessible(r8)     // Catch: java.lang.Throwable -> L37
            io.netty.buffer.CompositeByteBuf$Component r2 = r5.newComponent(r2, r0)     // Catch: java.lang.Throwable -> L37
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L37
            r5.addComp(r7, r2)     // Catch: java.lang.Throwable -> L37
            if (r3 <= 0) goto L22
            int r0 = r5.componentCount     // Catch: java.lang.Throwable -> L1f
            int r0 = r0 - r1
            if (r7 >= r0) goto L22
            r5.updateComponentOffsets(r7)     // Catch: java.lang.Throwable -> L1f
            goto L2f
        L1f:
            r6 = move-exception
            r0 = 1
            goto L38
        L22:
            if (r7 <= 0) goto L2f
            io.netty.buffer.CompositeByteBuf$Component[] r0 = r5.components     // Catch: java.lang.Throwable -> L1f
            int r4 = r7 + (-1)
            r0 = r0[r4]     // Catch: java.lang.Throwable -> L1f
            int r0 = r0.endOffset     // Catch: java.lang.Throwable -> L1f
            r2.reposition(r0)     // Catch: java.lang.Throwable -> L1f
        L2f:
            if (r6 == 0) goto L36
            int r6 = r5.writerIndex     // Catch: java.lang.Throwable -> L1f
            int r6 = r6 + r3
            r5.writerIndex = r6     // Catch: java.lang.Throwable -> L1f
        L36:
            return r7
        L37:
            r6 = move-exception
        L38:
            if (r0 != 0) goto L3d
            r8.release()
        L3d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.addComponent0(boolean, int, io.netty.buffer.ByteBuf):int");
    }

    private ByteBuf allocBuffer(int i8) {
        if (this.direct) {
            return alloc().directBuffer(i8);
        }
        return alloc().heapBuffer(i8);
    }

    private void checkComponentIndex(int i8) {
        ensureAccessible();
        if (i8 >= 0 && i8 <= this.componentCount) {
            return;
        }
        throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", Integer.valueOf(i8), Integer.valueOf(this.componentCount)));
    }

    private void clearComps() {
        removeCompRange(0, this.componentCount);
    }

    private void consolidate0(int i8, int i9) {
        int i10;
        if (i9 <= 1) {
            return;
        }
        int i11 = i8 + i9;
        if (i8 != 0) {
            i10 = this.components[i8].offset;
        } else {
            i10 = 0;
        }
        ByteBuf allocBuffer = allocBuffer(this.components[i11 - 1].endOffset - i10);
        for (int i12 = i8; i12 < i11; i12++) {
            this.components[i12].transferTo(allocBuffer);
        }
        this.lastAccessed = null;
        removeCompRange(i8 + 1, i11);
        this.components[i8] = newComponent(allocBuffer, 0);
        if (i8 != 0 || i9 != this.componentCount) {
            updateComponentOffsets(i8);
        }
    }

    private void consolidateIfNeeded() {
        int i8 = this.componentCount;
        if (i8 > this.maxNumComponents) {
            consolidate0(0, i8);
        }
    }

    private static ByteBuf ensureAccessible(ByteBuf byteBuf) {
        if (AbstractByteBuf.checkAccessible && !byteBuf.isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
        return byteBuf;
    }

    private Component findComponent(int i8) {
        Component component = this.lastAccessed;
        if (component != null && i8 >= component.offset && i8 < component.endOffset) {
            ensureAccessible();
            return component;
        }
        checkIndex(i8);
        return findIt(i8);
    }

    private Component findComponent0(int i8) {
        Component component = this.lastAccessed;
        if (component != null && i8 >= component.offset && i8 < component.endOffset) {
            return component;
        }
        return findIt(i8);
    }

    private Component findIt(int i8) {
        int i9 = this.componentCount;
        int i10 = 0;
        while (i10 <= i9) {
            int i11 = (i10 + i9) >>> 1;
            Component component = this.components[i11];
            if (i8 >= component.endOffset) {
                i10 = i11 + 1;
            } else if (i8 < component.offset) {
                i9 = i11 - 1;
            } else {
                this.lastAccessed = component;
                return component;
            }
        }
        throw new Error("should not reach here");
    }

    private static Component[] newCompArray(int i8, int i9) {
        return new Component[Math.max(i8, Math.min(16, i9))];
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.buffer.CompositeByteBuf.Component newComponent(io.netty.buffer.ByteBuf r10, int r11) {
        /*
            r9 = this;
            int r2 = r10.readerIndex()
            int r6 = r10.readableBytes()
            r0 = r10
        L9:
            boolean r1 = r0 instanceof io.netty.buffer.WrappedByteBuf
            if (r1 != 0) goto L5e
            boolean r1 = r0 instanceof io.netty.buffer.SwappedByteBuf
            if (r1 == 0) goto L12
            goto L5e
        L12:
            boolean r1 = r0 instanceof io.netty.buffer.AbstractUnpooledSlicedByteBuf
            if (r1 == 0) goto L25
            r1 = r0
            io.netty.buffer.AbstractUnpooledSlicedByteBuf r1 = (io.netty.buffer.AbstractUnpooledSlicedByteBuf) r1
            r3 = 0
            int r1 = r1.idx(r3)
            int r1 = r1 + r2
            io.netty.buffer.ByteBuf r0 = r0.unwrap()
        L23:
            r4 = r1
            goto L41
        L25:
            boolean r1 = r0 instanceof io.netty.buffer.PooledSlicedByteBuf
            if (r1 == 0) goto L34
            r1 = r0
            io.netty.buffer.PooledSlicedByteBuf r1 = (io.netty.buffer.PooledSlicedByteBuf) r1
            int r1 = r1.adjustment
            int r1 = r1 + r2
            io.netty.buffer.ByteBuf r0 = r0.unwrap()
            goto L23
        L34:
            boolean r1 = r0 instanceof io.netty.buffer.DuplicatedByteBuf
            if (r1 != 0) goto L3c
            boolean r1 = r0 instanceof io.netty.buffer.PooledDuplicatedByteBuf
            if (r1 == 0) goto L40
        L3c:
            io.netty.buffer.ByteBuf r0 = r0.unwrap()
        L40:
            r4 = r2
        L41:
            int r1 = r10.capacity()
            if (r1 != r6) goto L49
            r7 = r10
            goto L4b
        L49:
            r1 = 0
            r7 = r1
        L4b:
            io.netty.buffer.CompositeByteBuf$Component r8 = new io.netty.buffer.CompositeByteBuf$Component
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            io.netty.buffer.ByteBuf r10 = r10.order(r1)
            io.netty.buffer.ByteBuf r3 = r0.order(r1)
            r0 = r8
            r1 = r10
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r8
        L5e:
            io.netty.buffer.ByteBuf r0 = r0.unwrap()
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.newComponent(io.netty.buffer.ByteBuf, int):io.netty.buffer.CompositeByteBuf$Component");
    }

    private void removeComp(int i8) {
        removeCompRange(i8, i8 + 1);
    }

    private void removeCompRange(int i8, int i9) {
        if (i8 >= i9) {
            return;
        }
        int i10 = this.componentCount;
        if (i9 < i10) {
            Component[] componentArr = this.components;
            System.arraycopy(componentArr, i9, componentArr, i8, i10 - i9);
        }
        int i11 = (i10 - i9) + i8;
        for (int i12 = i11; i12 < i10; i12++) {
            this.components[i12] = null;
        }
        this.componentCount = i11;
    }

    private void shiftComps(int i8, int i9) {
        Component[] componentArr;
        int i10 = this.componentCount;
        int i11 = i10 + i9;
        Component[] componentArr2 = this.components;
        if (i11 > componentArr2.length) {
            int max = Math.max((i10 >> 1) + i10, i11);
            if (i8 == i10) {
                componentArr = (Component[]) Arrays.copyOf(this.components, max, Component[].class);
            } else {
                Component[] componentArr3 = new Component[max];
                if (i8 > 0) {
                    System.arraycopy(this.components, 0, componentArr3, 0, i8);
                }
                if (i8 < i10) {
                    System.arraycopy(this.components, i8, componentArr3, i9 + i8, i10 - i8);
                }
                componentArr = componentArr3;
            }
            this.components = componentArr;
        } else if (i8 < i10) {
            System.arraycopy(componentArr2, i8, componentArr2, i9 + i8, i10 - i8);
        }
        this.componentCount = i11;
    }

    private int toComponentIndex0(int i8) {
        int i9 = this.componentCount;
        int i10 = 0;
        if (i8 == 0) {
            for (int i11 = 0; i11 < i9; i11++) {
                if (this.components[i11].endOffset > 0) {
                    return i11;
                }
            }
        }
        if (i9 <= 2) {
            if (i9 == 1 || i8 < this.components[0].endOffset) {
                return 0;
            }
            return 1;
        }
        while (i10 <= i9) {
            int i12 = (i10 + i9) >>> 1;
            Component component = this.components[i12];
            if (i8 >= component.endOffset) {
                i10 = i12 + 1;
            } else if (i8 >= component.offset) {
                return i12;
            } else {
                i9 = i12 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private void updateComponentOffsets(int i8) {
        int i9;
        int i10 = this.componentCount;
        if (i10 <= i8) {
            return;
        }
        if (i8 > 0) {
            i9 = this.components[i8 - 1].endOffset;
        } else {
            i9 = 0;
        }
        while (i8 < i10) {
            Component component = this.components[i8];
            component.reposition(i9);
            i9 = component.endOffset;
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i8) {
        Component findComponent0 = findComponent0(i8);
        return findComponent0.buf.getByte(findComponent0.idx(i8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i8) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 4 <= findComponent0.endOffset) {
            return findComponent0.buf.getInt(findComponent0.idx(i8));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i8 + 2) & 65535) | ((_getShort(i8) & 65535) << 16);
        }
        return ((_getShort(i8 + 2) & 65535) << 16) | (_getShort(i8) & 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i8) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 4 <= findComponent0.endOffset) {
            return findComponent0.buf.getIntLE(findComponent0.idx(i8));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i8 + 2) & 65535) << 16) | (_getShortLE(i8) & 65535);
        }
        return (_getShortLE(i8 + 2) & 65535) | ((_getShortLE(i8) & 65535) << 16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i8) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 8 <= findComponent0.endOffset) {
            return findComponent0.buf.getLong(findComponent0.idx(i8));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getInt(i8) & 4294967295L) << 32) | (_getInt(i8 + 4) & 4294967295L);
        }
        return (_getInt(i8) & 4294967295L) | ((4294967295L & _getInt(i8 + 4)) << 32);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i8) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 2 <= findComponent0.endOffset) {
            return findComponent0.buf.getShort(findComponent0.idx(i8));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i8 + 1) & 255) | ((_getByte(i8) & 255) << 8));
        }
        return (short) (((_getByte(i8 + 1) & 255) << 8) | (_getByte(i8) & 255));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i8) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 2 <= findComponent0.endOffset) {
            return findComponent0.buf.getShortLE(findComponent0.idx(i8));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i8 + 1) & 255) << 8) | (_getByte(i8) & 255));
        }
        return (short) ((_getByte(i8 + 1) & 255) | ((_getByte(i8) & 255) << 8));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i8) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 3 <= findComponent0.endOffset) {
            return findComponent0.buf.getUnsignedMedium(findComponent0.idx(i8));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i8 + 2) & 255) | ((_getShort(i8) & 65535) << 8);
        }
        return ((_getByte(i8 + 2) & 255) << 16) | (_getShort(i8) & 65535);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i8, int i9) {
        Component findComponent0 = findComponent0(i8);
        findComponent0.buf.setByte(findComponent0.idx(i8), i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i8, int i9) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 4 <= findComponent0.endOffset) {
            findComponent0.buf.setInt(findComponent0.idx(i8), i9);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i8, (short) (i9 >>> 16));
            _setShort(i8 + 2, (short) i9);
        } else {
            _setShort(i8, (short) i9);
            _setShort(i8 + 2, (short) (i9 >>> 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i8, long j8) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 8 <= findComponent0.endOffset) {
            findComponent0.buf.setLong(findComponent0.idx(i8), j8);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setInt(i8, (int) (j8 >>> 32));
            _setInt(i8 + 4, (int) j8);
        } else {
            _setInt(i8, (int) j8);
            _setInt(i8 + 4, (int) (j8 >>> 32));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i8, int i9) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 3 <= findComponent0.endOffset) {
            findComponent0.buf.setMedium(findComponent0.idx(i8), i9);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i8, (short) (i9 >> 8));
            _setByte(i8 + 2, (byte) i9);
        } else {
            _setShort(i8, (short) i9);
            _setByte(i8 + 2, (byte) (i9 >>> 16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i8, int i9) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 3 <= findComponent0.endOffset) {
            findComponent0.buf.setMediumLE(findComponent0.idx(i8), i9);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i8, (short) i9);
            _setByte(i8 + 2, (byte) (i9 >>> 16));
        } else {
            _setShortLE(i8, (short) (i9 >> 8));
            _setByte(i8 + 2, (byte) i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i8, int i9) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 2 <= findComponent0.endOffset) {
            findComponent0.buf.setShort(findComponent0.idx(i8), i9);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i8, (byte) (i9 >>> 8));
            _setByte(i8 + 1, (byte) i9);
        } else {
            _setByte(i8, (byte) i9);
            _setByte(i8 + 1, (byte) (i9 >>> 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i8, int i9) {
        Component findComponent0 = findComponent0(i8);
        if (i8 + 2 <= findComponent0.endOffset) {
            findComponent0.buf.setShortLE(findComponent0.idx(i8), i9);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i8, (byte) i9);
            _setByte(i8 + 1, (byte) (i9 >>> 8));
        } else {
            _setByte(i8, (byte) (i9 >>> 8));
            _setByte(i8 + 1, (byte) i9);
        }
    }

    public CompositeByteBuf addComponent(boolean z7, ByteBuf byteBuf) {
        return addComponent(z7, this.componentCount, byteBuf);
    }

    public CompositeByteBuf addFlattenedComponents(boolean z7, ByteBuf byteBuf) {
        int i8;
        Component[] componentArr;
        int i9;
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        if (readerIndex == writerIndex) {
            byteBuf.release();
            return this;
        } else if (!(byteBuf instanceof CompositeByteBuf)) {
            addComponent0(z7, this.componentCount, byteBuf);
            consolidateIfNeeded();
            return this;
        } else {
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
            int i10 = writerIndex - readerIndex;
            compositeByteBuf.checkIndex(readerIndex, i10);
            Component[] componentArr2 = compositeByteBuf.components;
            int i11 = this.componentCount;
            int i12 = this.writerIndex;
            try {
                int componentIndex0 = compositeByteBuf.toComponentIndex0(readerIndex);
                int capacity = capacity();
                while (true) {
                    Component component = componentArr2[componentIndex0];
                    int max = Math.max(readerIndex, component.offset);
                    int min = Math.min(writerIndex, component.endOffset);
                    int i13 = min - max;
                    if (i13 > 0) {
                        i8 = readerIndex;
                        componentArr = componentArr2;
                        i9 = min;
                        addComp(this.componentCount, new Component(component.srcBuf.retain(), component.srcIdx(max), component.buf, component.idx(max), capacity, i13, null));
                    } else {
                        i8 = readerIndex;
                        componentArr = componentArr2;
                        i9 = min;
                    }
                    if (writerIndex == i9) {
                        break;
                    }
                    capacity += i13;
                    componentIndex0++;
                    readerIndex = i8;
                    componentArr2 = componentArr;
                }
                if (z7) {
                    this.writerIndex = i10 + i12;
                }
                consolidateIfNeeded();
                byteBuf.release();
                return this;
            } catch (Throwable th) {
                if (z7) {
                    this.writerIndex = i12;
                }
                for (int i14 = this.componentCount - 1; i14 >= i11; i14--) {
                    this.components[i14].free();
                    removeComp(i14);
                }
                throw th;
            }
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int i8 = this.componentCount;
        if (i8 != 0) {
            if (i8 == 1) {
                return this.components[0].buf.array();
            }
            throw new UnsupportedOperationException();
        }
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int i8 = this.componentCount;
        if (i8 == 0) {
            return 0;
        }
        if (i8 == 1) {
            Component component = this.components[0];
            return component.idx(component.buf.arrayOffset());
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        if (this.freed) {
            return;
        }
        this.freed = true;
        int i8 = this.componentCount;
        for (int i9 = 0; i9 < i8; i9++) {
            this.components[i9].free();
        }
    }

    public CompositeByteBuf discardReadComponents() {
        ensureAccessible();
        int readerIndex = readerIndex();
        if (readerIndex == 0) {
            return this;
        }
        int writerIndex = writerIndex();
        if (readerIndex == writerIndex && writerIndex == capacity()) {
            int i8 = this.componentCount;
            for (int i9 = 0; i9 < i8; i9++) {
                this.components[i9].free();
            }
            this.lastAccessed = null;
            clearComps();
            setIndex(0, 0);
            adjustMarkers(readerIndex);
            return this;
        }
        int i10 = this.componentCount;
        Component component = null;
        int i11 = 0;
        while (i11 < i10) {
            component = this.components[i11];
            if (component.endOffset > readerIndex) {
                break;
            }
            component.free();
            i11++;
        }
        if (i11 == 0) {
            return this;
        }
        Component component2 = this.lastAccessed;
        if (component2 != null && component2.endOffset <= readerIndex) {
            this.lastAccessed = null;
        }
        removeCompRange(0, i11);
        int i12 = component.offset;
        updateComponentOffsets(0);
        setIndex(readerIndex - i12, writerIndex - i12);
        adjustMarkers(i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    protected int forEachByteAsc0(int i8, int i9, ByteProcessor byteProcessor) throws Exception {
        int forEachByte;
        if (i9 <= i8) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i8);
        int i10 = i9 - i8;
        while (i10 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int idx = component.idx(i8);
                int min = Math.min(i10, component.endOffset - i8);
                if (byteBuf instanceof AbstractByteBuf) {
                    forEachByte = ((AbstractByteBuf) byteBuf).forEachByteAsc0(idx, idx + min, byteProcessor);
                } else {
                    forEachByte = byteBuf.forEachByte(idx, min, byteProcessor);
                }
                if (forEachByte != -1) {
                    return forEachByte - component.adjustment;
                }
                i8 += min;
                i10 -= min;
            }
            componentIndex0++;
        }
        return -1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i8) {
        Component findComponent = findComponent(i8);
        return findComponent.buf.getByte(findComponent.idx(i8));
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int i8 = this.componentCount;
        if (i8 == 0) {
            return true;
        }
        if (i8 != 1) {
            return false;
        }
        return this.components[0].buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int i8 = this.componentCount;
        if (i8 != 0) {
            if (i8 != 1) {
                return false;
            }
            return this.components[0].buf.hasMemoryAddress();
        }
        return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
    }

    public ByteBuf internalComponent(int i8) {
        checkComponentIndex(i8);
        return this.components[i8].slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i8, int i9) {
        int i10 = this.componentCount;
        if (i10 != 0) {
            if (i10 == 1) {
                return this.components[0].internalNioBuffer(i8, i9);
            }
            throw new UnsupportedOperationException();
        }
        return EMPTY_NIO_BUFFER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf
    public boolean isAccessible() {
        return !this.freed;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        int i8 = this.componentCount;
        if (i8 == 0) {
            return false;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            if (!this.components[i9].buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    public java.util.Iterator<ByteBuf> iterator() {
        ensureAccessible();
        if (this.componentCount == 0) {
            return EMPTY_ITERATOR;
        }
        return new CompositeByteBufIterator();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int i8 = this.componentCount;
        if (i8 != 0) {
            if (i8 == 1) {
                Component component = this.components[0];
                return component.buf.memoryAddress() + component.adjustment;
            }
            throw new UnsupportedOperationException();
        }
        return Unpooled.EMPTY_BUFFER.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i8, int i9) {
        checkIndex(i8, i9);
        int i10 = this.componentCount;
        if (i10 != 0) {
            if (i10 == 1) {
                Component component = this.components[0];
                ByteBuf byteBuf = component.buf;
                if (byteBuf.nioBufferCount() == 1) {
                    return byteBuf.nioBuffer(component.idx(i8), i9);
                }
            }
            ByteBuffer[] nioBuffers = nioBuffers(i8, i9);
            if (nioBuffers.length == 1) {
                return nioBuffers[0];
            }
            ByteBuffer order = ByteBuffer.allocate(i9).order(order());
            for (ByteBuffer byteBuffer : nioBuffers) {
                order.put(byteBuffer);
            }
            order.flip();
            return order;
        }
        return EMPTY_NIO_BUFFER;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        int i8 = this.componentCount;
        if (i8 == 0) {
            return 1;
        }
        if (i8 != 1) {
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                i9 += this.components[i10].buf.nioBufferCount();
            }
            return i9;
        }
        return this.components[0].buf.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i8, int i9) {
        checkIndex(i8, i9);
        if (i9 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(this.componentCount);
        try {
            int componentIndex0 = toComponentIndex0(i8);
            while (i9 > 0) {
                Component component = this.components[componentIndex0];
                ByteBuf byteBuf = component.buf;
                int min = Math.min(i9, component.endOffset - i8);
                int nioBufferCount = byteBuf.nioBufferCount();
                if (nioBufferCount == 0) {
                    throw new UnsupportedOperationException();
                }
                if (nioBufferCount != 1) {
                    Collections.addAll(newInstance, byteBuf.nioBuffers(component.idx(i8), min));
                } else {
                    newInstance.add(byteBuf.nioBuffer(component.idx(i8), min));
                }
                i8 += min;
                i9 -= min;
                componentIndex0++;
            }
            return (ByteBuffer[]) newInstance.toArray(new ByteBuffer[0]);
        } finally {
            newInstance.recycle();
        }
    }

    public int numComponents() {
        return this.componentCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        String abstractByteBuf = super.toString();
        String substring = abstractByteBuf.substring(0, abstractByteBuf.length() - 1);
        return substring + ", components=" + this.componentCount + ')';
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf touch(Object obj) {
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    public CompositeByteBuf addComponent(boolean z7, int i8, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z7, i8, byteBuf);
        consolidateIfNeeded();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        int i8 = this.componentCount;
        if (i8 > 0) {
            return this.components[i8 - 1].endOffset;
        }
        return 0;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf clear() {
        super.clear();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        return discardReadComponents();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf ensureWritable(int i8) {
        super.ensureWritable(i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf markReaderIndex() {
        super.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readerIndex(int i8) {
        super.readerIndex(i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf resetReaderIndex() {
        super.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setByte(int i8, int i9) {
        Component findComponent = findComponent(i8);
        findComponent.buf.setByte(findComponent.idx(i8), i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setIndex(int i8, int i9) {
        super.setIndex(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setInt(int i8, int i9) {
        checkIndex(i8, 4);
        _setInt(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setLong(int i8, long j8) {
        checkIndex(i8, 8);
        _setLong(i8, j8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setMedium(int i8, int i9) {
        checkIndex(i8, 3);
        _setMedium(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setShort(int i8, int i9) {
        checkIndex(i8, 2);
        _setShort(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf setZero(int i8, int i9) {
        super.setZero(i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf skipBytes(int i8) {
        super.skipBytes(i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeByte(int i8) {
        ensureWritable0(1);
        int i9 = this.writerIndex;
        this.writerIndex = i9 + 1;
        _setByte(i9, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeInt(int i8) {
        super.writeInt(i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeLong(long j8) {
        super.writeLong(j8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeMedium(int i8) {
        super.writeMedium(i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeShort(int i8) {
        super.writeShort(i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writerIndex(int i8) {
        super.writerIndex(i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf, io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public CompositeByteBuf retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf capacity(int i8) {
        checkNewCapacity(i8);
        int i9 = this.componentCount;
        int capacity = capacity();
        if (i8 > capacity) {
            int i10 = i8 - capacity;
            addComponent0(false, i9, allocBuffer(i10).setIndex(0, i10));
            if (this.componentCount >= this.maxNumComponents) {
                consolidateIfNeeded();
            }
        } else if (i8 < capacity) {
            this.lastAccessed = null;
            int i11 = i9 - 1;
            int i12 = capacity - i8;
            while (true) {
                if (i11 < 0) {
                    break;
                }
                Component component = this.components[i11];
                int length = component.length();
                if (i12 < length) {
                    component.endOffset -= i12;
                    ByteBuf byteBuf = component.slice;
                    if (byteBuf != null) {
                        component.slice = byteBuf.slice(0, component.length());
                    }
                } else {
                    component.free();
                    i12 -= length;
                    i11--;
                }
            }
            removeCompRange(i11 + 1, i9);
            if (readerIndex() > i8) {
                setIndex0(i8, i8);
            } else if (this.writerIndex > i8) {
                this.writerIndex = i8;
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i8, byte[] bArr, int i9, int i10) {
        checkDstIndex(i8, i10, i9, bArr.length);
        if (i10 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i8);
        while (i10 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i10, component.endOffset - i8);
            component.buf.getBytes(component.idx(i8), bArr, i9, min);
            i8 += min;
            i9 += min;
            i10 -= min;
            componentIndex0++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i8, byte[] bArr, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, bArr.length);
        if (i10 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i8);
        while (i10 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i10, component.endOffset - i8);
            component.buf.setBytes(component.idx(i8), bArr, i9, min);
            i8 += min;
            i9 += min;
            i10 -= min;
            componentIndex0++;
        }
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z7, int i8) {
        this(byteBufAllocator, z7, i8, 0);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        super.readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        super.writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = null;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i8) {
        super.readBytes(byteBuf, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i8) {
        super.writeBytes(byteBuf, i8);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i8, int i9) {
        super.readBytes(byteBuf, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i8, int i9) {
        super.writeBytes(byteBuf, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i8, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i8, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i8);
        while (remaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int min = Math.min(remaining, component.endOffset - i8);
                byteBuffer.limit(byteBuffer.position() + min);
                component.buf.getBytes(component.idx(i8), byteBuffer);
                i8 += min;
                remaining -= min;
                componentIndex0++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr) {
        super.readBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i8, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i8, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i8);
        while (remaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int min = Math.min(remaining, component.endOffset - i8);
                byteBuffer.limit(byteBuffer.position() + min);
                component.buf.setBytes(component.idx(i8), byteBuffer);
                i8 += min;
                remaining -= min;
                componentIndex0++;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr) {
        super.writeBytes(bArr, 0, bArr.length);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(byte[] bArr, int i8, int i9) {
        super.readBytes(bArr, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(byte[] bArr, int i8, int i9) {
        super.writeBytes(bArr, i8, i9);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        super.readBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        super.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return nioBuffers(readerIndex(), readableBytes());
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkDstIndex(i8, i10, i9, byteBuf.capacity());
        if (i10 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i8);
        while (i10 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i10, component.endOffset - i8);
            component.buf.getBytes(component.idx(i8), byteBuf, i9, min);
            i8 += min;
            i9 += min;
            i10 -= min;
            componentIndex0++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public CompositeByteBuf setBytes(int i8, ByteBuf byteBuf, int i9, int i10) {
        checkSrcIndex(i8, i10, i9, byteBuf.capacity());
        if (i10 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i8);
        while (i10 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i10, component.endOffset - i8);
            component.buf.setBytes(component.idx(i8), byteBuf, i9, min);
            i8 += min;
            i9 += min;
            i10 -= min;
            componentIndex0++;
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i8, GatheringByteChannel gatheringByteChannel, int i9) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i8, i9));
        }
        long write = gatheringByteChannel.write(nioBuffers(i8, i9));
        return write > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) write;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[EDGE_INSN: B:22:0x003c->B:21:0x003c ?: BREAK  , SYNTHETIC] */
    @Override // io.netty.buffer.ByteBuf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int setBytes(int r6, java.nio.channels.ScatteringByteChannel r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r5.checkIndex(r6, r8)
            if (r8 != 0) goto Lc
            java.nio.ByteBuffer r6 = io.netty.buffer.CompositeByteBuf.EMPTY_NIO_BUFFER
            int r6 = r7.read(r6)
            return r6
        Lc:
            int r0 = r5.toComponentIndex0(r6)
            r1 = 0
        L11:
            io.netty.buffer.CompositeByteBuf$Component[] r2 = r5.components
            r2 = r2[r0]
            int r3 = r2.endOffset
            int r3 = r3 - r6
            int r3 = java.lang.Math.min(r8, r3)
            if (r3 != 0) goto L21
        L1e:
            int r0 = r0 + 1
            goto L3a
        L21:
            io.netty.buffer.ByteBuf r4 = r2.buf
            int r2 = r2.idx(r6)
            int r2 = r4.setBytes(r2, r7, r3)
            if (r2 != 0) goto L2e
            goto L3c
        L2e:
            if (r2 >= 0) goto L34
            if (r1 != 0) goto L3c
            r6 = -1
            return r6
        L34:
            int r6 = r6 + r2
            int r8 = r8 - r2
            int r1 = r1 + r2
            if (r2 != r3) goto L3a
            goto L1e
        L3a:
            if (r8 > 0) goto L11
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.setBytes(int, java.nio.channels.ScatteringByteChannel, int):int");
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public CompositeByteBuf getBytes(int i8, byte[] bArr) {
        return getBytes(i8, bArr, 0, bArr.length);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public CompositeByteBuf setBytes(int i8, byte[] bArr) {
        return setBytes(i8, bArr, 0, bArr.length);
    }
}
