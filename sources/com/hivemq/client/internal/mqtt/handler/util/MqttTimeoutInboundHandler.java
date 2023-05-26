package com.hivemq.client.internal.mqtt.handler.util;

import com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectEvent;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectUtil;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.ScheduledFuture;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class MqttTimeoutInboundHandler extends MqttConnectionAwareHandler implements Runnable, ChannelFutureListener {

    /* renamed from: g  reason: collision with root package name */
    private ScheduledFuture<?> f18354g;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.handler.MqttConnectionAwareHandler
    public void a(ChannelHandlerContext channelHandlerContext, MqttDisconnectEvent mqttDisconnectEvent) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        ScheduledFuture<?> scheduledFuture = this.f18354g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f18354g = null;
        }
    }

    protected abstract long d();

    protected abstract Mqtt5DisconnectReasonCode f();

    protected abstract String g();

    @Override // io.netty.util.concurrent.GenericFutureListener
    /* renamed from: i */
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (this.f18020f == null) {
            return;
        }
        Throwable cause = channelFuture.cause();
        if (cause == null) {
            j(this.f18020f);
        } else if (!(cause instanceof IOException)) {
            exceptionCaught(this.f18020f, cause);
        }
    }

    protected void j(ChannelHandlerContext channelHandlerContext) {
        k(channelHandlerContext.channel());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(Channel channel) {
        long d8 = d();
        if (d8 > 0) {
            this.f18354g = channel.eventLoop().schedule((Runnable) this, d8, TimeUnit.MILLISECONDS);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ChannelHandlerContext channelHandlerContext = this.f18020f;
        if (channelHandlerContext == null) {
            return;
        }
        Channel channel = channelHandlerContext.channel();
        if (channel.isActive()) {
            MqttDisconnectUtil.c(channel, f(), g());
        } else {
            MqttDisconnectUtil.a(channel, g());
        }
    }
}
