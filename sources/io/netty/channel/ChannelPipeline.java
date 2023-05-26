package io.netty.channel;

import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public interface ChannelPipeline extends ChannelOutboundInvoker, Iterable<Map.Entry<String, ChannelHandler>> {
    ChannelPipeline addAfter(String str, String str2, ChannelHandler channelHandler);

    ChannelPipeline addLast(String str, ChannelHandler channelHandler);

    ChannelPipeline addLast(ChannelHandler... channelHandlerArr);

    ChannelHandlerContext context(ChannelHandler channelHandler);

    ChannelHandlerContext context(Class<? extends ChannelHandler> cls);

    ChannelPipeline fireChannelActive();

    ChannelPipeline fireChannelRead(Object obj);

    ChannelPipeline fireChannelReadComplete();

    ChannelPipeline fireChannelRegistered();

    ChannelPipeline fireChannelWritabilityChanged();

    ChannelPipeline fireExceptionCaught(Throwable th);

    ChannelPipeline fireUserEventTriggered(Object obj);

    <T extends ChannelHandler> T get(Class<T> cls);

    ChannelHandler get(String str);

    List<String> names();

    <T extends ChannelHandler> T remove(Class<T> cls);

    ChannelPipeline remove(ChannelHandler channelHandler);

    ChannelPipeline replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2);
}
