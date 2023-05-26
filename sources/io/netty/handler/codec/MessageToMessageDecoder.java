package io.netty.handler.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class MessageToMessageDecoder<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher = TypeParameterMatcher.find(this, MessageToMessageDecoder.class, "I");

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        CodecOutputList newInstance = CodecOutputList.newInstance();
        int i8 = 0;
        try {
            try {
                if (acceptInboundMessage(obj)) {
                    try {
                        decode(channelHandlerContext, obj, newInstance);
                        ReferenceCountUtil.release(obj);
                    } catch (Throwable th) {
                        ReferenceCountUtil.release(obj);
                        throw th;
                    }
                } else {
                    newInstance.add(obj);
                }
            } catch (DecoderException e8) {
                throw e8;
            } catch (Exception e9) {
                throw new DecoderException(e9);
            }
        } finally {
            int size = newInstance.size();
            while (i8 < size) {
                channelHandlerContext.fireChannelRead(newInstance.getUnsafe(i8));
                i8++;
            }
            newInstance.recycle();
        }
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, I i8, List<Object> list) throws Exception;
}
