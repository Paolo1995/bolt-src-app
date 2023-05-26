package com.hivemq.client.internal.mqtt.handler;

import com.hivemq.client.internal.mqtt.MqttClientConnectionConfig;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingQosHandler;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttOutgoingQosHandler;
import com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionHandler;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.mqtt.exceptions.MqttSessionExpiredException;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5ConnAckException;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MqttSession {

    /* renamed from: a  reason: collision with root package name */
    private final MqttSubscriptionHandler f18021a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttIncomingQosHandler f18022b;

    /* renamed from: c  reason: collision with root package name */
    private final MqttOutgoingQosHandler f18023c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18024d;

    /* renamed from: e  reason: collision with root package name */
    private ScheduledFuture<?> f18025e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MqttSession(MqttSubscriptionHandler mqttSubscriptionHandler, MqttIncomingQosHandler mqttIncomingQosHandler, MqttOutgoingQosHandler mqttOutgoingQosHandler) {
        this.f18021a = mqttSubscriptionHandler;
        this.f18022b = mqttIncomingQosHandler;
        this.f18023c = mqttOutgoingQosHandler;
    }

    private void c(Throwable th) {
        if (this.f18024d) {
            this.f18024d = false;
            this.f18023c.b(th);
            this.f18022b.b(th);
            this.f18021a.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Throwable th) {
        c(new MqttSessionExpiredException("Session expired as connection was closed.", th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Throwable th) {
        if (this.f18025e != null) {
            this.f18025e = null;
            c(new MqttSessionExpiredException("Session expired after expiry interval", th));
        }
    }

    public void d(final Throwable th, MqttClientConnectionConfig mqttClientConnectionConfig, EventLoop eventLoop) {
        long k8 = mqttClientConnectionConfig.k();
        if (k8 == 0) {
            eventLoop.execute(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.d
                @Override // java.lang.Runnable
                public final void run() {
                    MqttSession.this.e(th);
                }
            });
        } else if (k8 != 4294967295L) {
            this.f18025e = eventLoop.schedule(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.e
                @Override // java.lang.Runnable
                public final void run() {
                    MqttSession.this.f(th);
                }
            }, (long) (TimeUnit.SECONDS.toMillis(k8) * 1.1d), TimeUnit.MILLISECONDS);
        }
    }

    public void g(MqttConnAck mqttConnAck, MqttClientConnectionConfig mqttClientConnectionConfig, ChannelPipeline channelPipeline, EventLoop eventLoop) {
        if (this.f18024d && !mqttConnAck.o()) {
            c(new MqttSessionExpiredException("Session expired as CONNACK did not contain the session present flag.", new Mqtt5ConnAckException(mqttConnAck, "Session expired as CONNACK did not contain the session present flag.")));
        }
        this.f18024d = true;
        ScheduledFuture<?> scheduledFuture = this.f18025e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f18025e = null;
        }
        channelPipeline.addAfter("decoder", "subscription", this.f18021a);
        channelPipeline.addAfter("decoder", "qos.incoming", this.f18022b);
        channelPipeline.addAfter("decoder", "qos.outgoing", this.f18023c);
        this.f18021a.d(mqttClientConnectionConfig, eventLoop);
        this.f18022b.d(mqttClientConnectionConfig, eventLoop);
        this.f18023c.d(mqttClientConnectionConfig, eventLoop);
    }
}
