package io.netty.handler.codec;

import com.google.android.gms.common.api.Api;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class ByteToMessageDecoder extends ChannelInboundHandlerAdapter {
    ByteBuf cumulation;
    private Cumulator cumulator = MERGE_CUMULATOR;
    private byte decodeState = 0;
    private int discardAfterReads = 16;
    private boolean firedChannelRead;
    private boolean first;
    private int numReads;
    private boolean singleDecode;
    public static final Cumulator MERGE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.1
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            if (!byteBuf.isReadable() && byteBuf2.isContiguous()) {
                byteBuf.release();
                return byteBuf2;
            }
            try {
                int readableBytes = byteBuf2.readableBytes();
                if (readableBytes <= byteBuf.maxWritableBytes() && ((readableBytes <= byteBuf.maxFastWritableBytes() || byteBuf.refCnt() <= 1) && !byteBuf.isReadOnly())) {
                    byteBuf.writeBytes(byteBuf2, byteBuf2.readerIndex(), readableBytes);
                    byteBuf2.readerIndex(byteBuf2.writerIndex());
                    return byteBuf;
                }
                return ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2);
            } finally {
                byteBuf2.release();
            }
        }
    };
    public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.2
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            Throwable th;
            CompositeByteBuf compositeByteBuf;
            if (!byteBuf.isReadable()) {
                byteBuf.release();
                return byteBuf2;
            }
            CompositeByteBuf compositeByteBuf2 = null;
            try {
                if ((byteBuf instanceof CompositeByteBuf) && byteBuf.refCnt() == 1) {
                    compositeByteBuf = (CompositeByteBuf) byteBuf;
                    try {
                        if (compositeByteBuf.writerIndex() != compositeByteBuf.capacity()) {
                            compositeByteBuf.capacity(compositeByteBuf.writerIndex());
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteBuf2 != null) {
                            byteBuf2.release();
                            if (compositeByteBuf != null && compositeByteBuf != byteBuf) {
                                compositeByteBuf.release();
                            }
                        }
                        throw th;
                    }
                } else {
                    compositeByteBuf = byteBufAllocator.compositeBuffer(Api.BaseClientBuilder.API_PRIORITY_OTHER).addFlattenedComponents(true, byteBuf);
                }
                compositeByteBuf2 = compositeByteBuf;
                compositeByteBuf2.addFlattenedComponents(true, byteBuf2);
                return compositeByteBuf2;
            } catch (Throwable th3) {
                CompositeByteBuf compositeByteBuf3 = compositeByteBuf2;
                th = th3;
                compositeByteBuf = compositeByteBuf3;
            }
        }
    };

    /* loaded from: classes5.dex */
    public interface Cumulator {
        ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteToMessageDecoder() {
        ensureNotSharable();
    }

    private void channelInputClosed(ChannelHandlerContext channelHandlerContext, boolean z7) {
        CodecOutputList newInstance = CodecOutputList.newInstance();
        try {
            try {
                channelInputClosed(channelHandlerContext, newInstance);
                try {
                    ByteBuf byteBuf = this.cumulation;
                    if (byteBuf != null) {
                        byteBuf.release();
                        this.cumulation = null;
                    }
                    int size = newInstance.size();
                    fireChannelRead(channelHandlerContext, newInstance, size);
                    if (size > 0) {
                        channelHandlerContext.fireChannelReadComplete();
                    }
                    if (z7) {
                        channelHandlerContext.fireChannelInactive();
                    }
                } finally {
                }
            } catch (DecoderException e8) {
                throw e8;
            } catch (Exception e9) {
                throw new DecoderException(e9);
            }
        } catch (Throwable th) {
            try {
                ByteBuf byteBuf2 = this.cumulation;
                if (byteBuf2 != null) {
                    byteBuf2.release();
                    this.cumulation = null;
                }
                int size2 = newInstance.size();
                fireChannelRead(channelHandlerContext, newInstance, size2);
                if (size2 > 0) {
                    channelHandlerContext.fireChannelReadComplete();
                }
                if (z7) {
                    channelHandlerContext.fireChannelInactive();
                }
                throw th;
            } finally {
            }
        }
    }

    static ByteBuf expandCumulation(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
        int readableBytes = byteBuf.readableBytes();
        int readableBytes2 = byteBuf2.readableBytes();
        int i8 = readableBytes + readableBytes2;
        ByteBuf buffer = byteBufAllocator.buffer(byteBufAllocator.calculateNewCapacity(i8, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        try {
            buffer.setBytes(0, byteBuf, byteBuf.readerIndex(), readableBytes).setBytes(readableBytes, byteBuf2, byteBuf2.readerIndex(), readableBytes2).writerIndex(i8);
            byteBuf2.readerIndex(byteBuf2.writerIndex());
            byteBuf.release();
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fireChannelRead(ChannelHandlerContext channelHandlerContext, List<Object> list, int i8) {
        if (list instanceof CodecOutputList) {
            fireChannelRead(channelHandlerContext, (CodecOutputList) list, i8);
            return;
        }
        for (int i9 = 0; i9 < i8; i9++) {
            channelHandlerContext.fireChannelRead(list.get(i9));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        while (byteBuf.isReadable()) {
            try {
                int size = list.size();
                if (size > 0) {
                    fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (!channelHandlerContext.isRemoved()) {
                        size = 0;
                    } else {
                        return;
                    }
                }
                int readableBytes = byteBuf.readableBytes();
                decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
                if (!channelHandlerContext.isRemoved()) {
                    if (size == list.size()) {
                        if (readableBytes == byteBuf.readableBytes()) {
                            return;
                        }
                    } else if (readableBytes != byteBuf.readableBytes()) {
                        if (isSingleDecode()) {
                            return;
                        }
                    } else {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() did not read anything but decoded a message.");
                    }
                } else {
                    return;
                }
            } catch (DecoderException e8) {
                throw e8;
            } catch (Exception e9) {
                throw new DecoderException(e9);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelInputClosed(channelHandlerContext, true);
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        boolean z7;
        ByteBuf byteBuf;
        if (obj instanceof ByteBuf) {
            CodecOutputList newInstance = CodecOutputList.newInstance();
            try {
                try {
                    try {
                        if (this.cumulation == null) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        this.first = z7;
                        Cumulator cumulator = this.cumulator;
                        ByteBufAllocator alloc = channelHandlerContext.alloc();
                        if (this.first) {
                            byteBuf = Unpooled.EMPTY_BUFFER;
                        } else {
                            byteBuf = this.cumulation;
                        }
                        ByteBuf cumulate = cumulator.cumulate(alloc, byteBuf, (ByteBuf) obj);
                        this.cumulation = cumulate;
                        callDecode(channelHandlerContext, cumulate, newInstance);
                        ByteBuf byteBuf2 = this.cumulation;
                        if (byteBuf2 != null && !byteBuf2.isReadable()) {
                            this.numReads = 0;
                            this.cumulation.release();
                            this.cumulation = null;
                        } else {
                            int i8 = this.numReads + 1;
                            this.numReads = i8;
                            if (i8 >= this.discardAfterReads) {
                                this.numReads = 0;
                                discardSomeReadBytes();
                            }
                        }
                        int size = newInstance.size();
                        this.firedChannelRead |= newInstance.insertSinceRecycled();
                        fireChannelRead(channelHandlerContext, newInstance, size);
                        newInstance.recycle();
                        return;
                    } catch (Exception e8) {
                        throw new DecoderException(e8);
                    }
                } catch (DecoderException e9) {
                    throw e9;
                }
            } catch (Throwable th) {
                ByteBuf byteBuf3 = this.cumulation;
                if (byteBuf3 != null && !byteBuf3.isReadable()) {
                    this.numReads = 0;
                    this.cumulation.release();
                    this.cumulation = null;
                } else {
                    int i9 = this.numReads + 1;
                    this.numReads = i9;
                    if (i9 >= this.discardAfterReads) {
                        this.numReads = 0;
                        discardSomeReadBytes();
                    }
                }
                int size2 = newInstance.size();
                this.firedChannelRead |= newInstance.insertSinceRecycled();
                fireChannelRead(channelHandlerContext, newInstance, size2);
                newInstance.recycle();
                throw th;
            }
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.numReads = 0;
        discardSomeReadBytes();
        if (!this.firedChannelRead && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        this.firedChannelRead = false;
        channelHandlerContext.fireChannelReadComplete();
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.isReadable()) {
            decodeRemovalReentryProtection(channelHandlerContext, byteBuf, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void decodeRemovalReentryProtection(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        boolean z7 = true;
        this.decodeState = (byte) 1;
        try {
            decode(channelHandlerContext, byteBuf, list);
        } finally {
            if (this.decodeState != 2) {
                z7 = false;
            }
            this.decodeState = (byte) 0;
            if (z7) {
                fireChannelRead(channelHandlerContext, list, list.size());
                list.clear();
                handlerRemoved(channelHandlerContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void discardSomeReadBytes() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null && !this.first && byteBuf.refCnt() == 1) {
            this.cumulation.discardSomeReadBytes();
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.decodeState == 1) {
            this.decodeState = (byte) 2;
            return;
        }
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            this.cumulation = null;
            this.numReads = 0;
            if (byteBuf.readableBytes() > 0) {
                channelHandlerContext.fireChannelRead(byteBuf);
                channelHandlerContext.fireChannelReadComplete();
            } else {
                byteBuf.release();
            }
        }
        handlerRemoved0(channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuf internalBuffer() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            return byteBuf;
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public boolean isSingleDecode() {
        return this.singleDecode;
    }

    public void setCumulator(Cumulator cumulator) {
        this.cumulator = (Cumulator) ObjectUtil.checkNotNull(cumulator, "cumulator");
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof ChannelInputShutdownEvent) {
            channelInputClosed(channelHandlerContext, false);
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    static void fireChannelRead(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            channelHandlerContext.fireChannelRead(codecOutputList.getUnsafe(i9));
        }
    }

    void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            callDecode(channelHandlerContext, byteBuf, list);
            decodeLast(channelHandlerContext, this.cumulation, list);
            return;
        }
        decodeLast(channelHandlerContext, Unpooled.EMPTY_BUFFER, list);
    }
}
