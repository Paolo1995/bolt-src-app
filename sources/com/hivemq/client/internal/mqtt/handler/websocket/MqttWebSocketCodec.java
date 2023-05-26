package com.hivemq.client.internal.mqtt.handler.websocket;

import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import javax.inject.Singleton;

@Singleton
@ChannelHandler.Sharable
/* loaded from: classes3.dex */
public class MqttWebSocketCodec extends ChannelDuplexHandler {
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof WebSocketFrame) {
            WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
            if (!(obj instanceof BinaryWebSocketFrame) && !(obj instanceof ContinuationWebSocketFrame)) {
                if (obj instanceof TextWebSocketFrame) {
                    webSocketFrame.release();
                    MqttDisconnectUtil.a(channelHandlerContext.channel(), "Must not receive text websocket frames");
                    return;
                } else if (obj instanceof CloseWebSocketFrame) {
                    webSocketFrame.release();
                    channelHandlerContext.close();
                    return;
                } else if (obj instanceof PingWebSocketFrame) {
                    channelHandlerContext.channel().writeAndFlush(new PongWebSocketFrame(webSocketFrame.content()));
                    return;
                } else {
                    webSocketFrame.release();
                    return;
                }
            }
            channelHandlerContext.fireChannelRead(webSocketFrame.content());
            return;
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return true;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (obj instanceof ByteBuf) {
            channelHandlerContext.write(new BinaryWebSocketFrame((ByteBuf) obj), channelPromise);
        } else {
            channelHandlerContext.write(obj, channelPromise);
        }
    }
}
