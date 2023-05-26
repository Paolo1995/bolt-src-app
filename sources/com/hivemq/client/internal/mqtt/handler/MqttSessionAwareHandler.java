package com.hivemq.client.internal.mqtt.handler;

import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;

/* loaded from: classes3.dex */
public abstract class MqttSessionAwareHandler extends MqttConnectionAwareHandler {

    /* renamed from: g  reason: collision with root package name */
    protected boolean f18026g;

    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler
    protected void a(ChannelHandlerContext channelHandlerContext, MqttDisconnectEvent mqttDisconnectEvent) {
    }

    public void b(Throwable th) {
        this.f18026g = false;
    }

    public void d(MqttClientConnectionConfig mqttClientConnectionConfig, EventLoop eventLoop) {
        this.f18026g = true;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler, io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        if (this.f18020f == null) {
            return true;
        }
        return false;
    }
}
