package com.hivemq.client.internal.mqtt.handler;

import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/* loaded from: classes3.dex */
public abstract class MqttConnectionAwareHandler extends ChannelInboundHandlerAdapter {

    /* renamed from: f  reason: collision with root package name */
    protected ChannelHandlerContext f18020f;

    protected abstract void a(ChannelHandlerContext channelHandlerContext, MqttDisconnectEvent mqttDisconnectEvent);

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.f18020f = channelHandlerContext;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return false;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        if ((obj instanceof MqttDisconnectEvent) && this.f18020f != null) {
            this.f18020f = null;
            a(channelHandlerContext, (MqttDisconnectEvent) obj);
        }
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
