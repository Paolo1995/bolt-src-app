package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import j$.util.Spliterator;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class MessageAggregator<I, S, C extends ByteBufHolder, O extends ByteBufHolder> extends MessageToMessageDecoder<I> {
    private boolean aggregating;
    private ChannelFutureListener continueResponseWriteListener;
    private ChannelHandlerContext ctx;
    private O currentMessage;
    private boolean handlingOversizedMessage;
    private final int maxContentLength;
    private int maxCumulationBufferComponents = Spliterator.IMMUTABLE;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageAggregator(int i8) {
        validateMaxContentLength(i8);
        this.maxContentLength = i8;
    }

    private static void appendPartialContent(CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            compositeByteBuf.addComponent(true, byteBuf.retain());
        }
    }

    private void finishAggregation0(O o8) throws Exception {
        this.aggregating = false;
        finishAggregation(o8);
    }

    private void invokeHandleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s7) throws Exception {
        this.handlingOversizedMessage = true;
        this.currentMessage = null;
        try {
            handleOversizedMessage(channelHandlerContext, s7);
        } finally {
            ReferenceCountUtil.release(s7);
        }
    }

    private void releaseCurrentMessage() {
        O o8 = this.currentMessage;
        if (o8 != null) {
            o8.release();
            this.currentMessage = null;
            this.handlingOversizedMessage = false;
            this.aggregating = false;
        }
    }

    private static void validateMaxContentLength(int i8) {
        ObjectUtil.checkPositiveOrZero(i8, "maxContentLength");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        if (!super.acceptInboundMessage(obj) || isAggregated(obj)) {
            return false;
        }
        if (isStartMessage(obj)) {
            this.aggregating = true;
            return true;
        } else if (!this.aggregating || !isContentMessage(obj)) {
            return false;
        } else {
            return true;
        }
    }

    protected void aggregate(O o8, C c8) throws Exception {
    }

    protected abstract O beginAggregation(S s7, ByteBuf byteBuf) throws Exception;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            super.channelInactive(channelHandlerContext);
        } finally {
            releaseCurrentMessage();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.currentMessage != null && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    protected abstract boolean closeAfterContinueResponse(Object obj) throws Exception;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    protected void decode(final ChannelHandlerContext channelHandlerContext, I i8, List<Object> list) throws Exception {
        boolean isLastContentMessage;
        ByteBufHolder beginAggregation;
        if (isStartMessage(i8)) {
            this.handlingOversizedMessage = false;
            O o8 = this.currentMessage;
            if (o8 == null) {
                Object newContinueResponse = newContinueResponse(i8, this.maxContentLength, channelHandlerContext.pipeline());
                if (newContinueResponse != null) {
                    ChannelFutureListener channelFutureListener = this.continueResponseWriteListener;
                    if (channelFutureListener == null) {
                        channelFutureListener = new ChannelFutureListener() { // from class: io.netty.handler.codec.MessageAggregator.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isSuccess()) {
                                    return;
                                }
                                channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                            }
                        };
                        this.continueResponseWriteListener = channelFutureListener;
                    }
                    boolean closeAfterContinueResponse = closeAfterContinueResponse(newContinueResponse);
                    this.handlingOversizedMessage = ignoreContentAfterContinueResponse(newContinueResponse);
                    Future<Void> addListener = channelHandlerContext.writeAndFlush(newContinueResponse).addListener((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
                    if (closeAfterContinueResponse) {
                        addListener.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                        return;
                    } else if (this.handlingOversizedMessage) {
                        return;
                    }
                } else if (isContentLengthInvalid(i8, this.maxContentLength)) {
                    invokeHandleOversizedMessage(channelHandlerContext, i8);
                    return;
                }
                if ((i8 instanceof DecoderResultProvider) && !((DecoderResultProvider) i8).decoderResult().isSuccess()) {
                    if (i8 instanceof ByteBufHolder) {
                        beginAggregation = beginAggregation(i8, ((ByteBufHolder) i8).content().retain());
                    } else {
                        beginAggregation = beginAggregation(i8, Unpooled.EMPTY_BUFFER);
                    }
                    finishAggregation0(beginAggregation);
                    list.add(beginAggregation);
                    return;
                }
                CompositeByteBuf compositeBuffer = channelHandlerContext.alloc().compositeBuffer(this.maxCumulationBufferComponents);
                if (i8 instanceof ByteBufHolder) {
                    appendPartialContent(compositeBuffer, ((ByteBufHolder) i8).content());
                }
                this.currentMessage = (O) beginAggregation(i8, compositeBuffer);
                return;
            }
            o8.release();
            this.currentMessage = null;
            throw new MessageAggregationException();
        } else if (isContentMessage(i8)) {
            O o9 = this.currentMessage;
            if (o9 == null) {
                return;
            }
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) o9.content();
            ByteBufHolder byteBufHolder = (ByteBufHolder) i8;
            if (compositeByteBuf.readableBytes() > this.maxContentLength - byteBufHolder.content().readableBytes()) {
                invokeHandleOversizedMessage(channelHandlerContext, this.currentMessage);
                return;
            }
            appendPartialContent(compositeByteBuf, byteBufHolder.content());
            aggregate(this.currentMessage, byteBufHolder);
            if (byteBufHolder instanceof DecoderResultProvider) {
                DecoderResult decoderResult = ((DecoderResultProvider) byteBufHolder).decoderResult();
                if (!decoderResult.isSuccess()) {
                    O o10 = this.currentMessage;
                    if (o10 instanceof DecoderResultProvider) {
                        ((DecoderResultProvider) o10).setDecoderResult(DecoderResult.failure(decoderResult.cause()));
                    }
                    isLastContentMessage = true;
                } else {
                    isLastContentMessage = isLastContentMessage(byteBufHolder);
                }
            } else {
                isLastContentMessage = isLastContentMessage(byteBufHolder);
            }
            if (isLastContentMessage) {
                finishAggregation0(this.currentMessage);
                list.add(this.currentMessage);
                this.currentMessage = null;
            }
        } else {
            throw new MessageAggregationException();
        }
    }

    protected void finishAggregation(O o8) throws Exception {
    }

    protected void handleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s7) throws Exception {
        channelHandlerContext.fireExceptionCaught(new TooLongFrameException("content length exceeded " + maxContentLength() + " bytes."));
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            super.handlerRemoved(channelHandlerContext);
        } finally {
            releaseCurrentMessage();
        }
    }

    protected abstract boolean ignoreContentAfterContinueResponse(Object obj) throws Exception;

    protected abstract boolean isAggregated(I i8) throws Exception;

    protected abstract boolean isContentLengthInvalid(S s7, int i8) throws Exception;

    protected abstract boolean isContentMessage(I i8) throws Exception;

    protected abstract boolean isLastContentMessage(C c8) throws Exception;

    protected abstract boolean isStartMessage(I i8) throws Exception;

    public final int maxContentLength() {
        return this.maxContentLength;
    }

    protected abstract Object newContinueResponse(S s7, int i8, ChannelPipeline channelPipeline) throws Exception;
}
