package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionFlow;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.MqttSubAck;
import com.hivemq.client.internal.util.collections.HandleList;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.hivemq.client.rx.FlowableWithSingleSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public class MqttSubscribedPublishFlow extends MqttIncomingPublishFlow implements MqttSubscriptionFlow<MqttSubAck> {

    /* renamed from: u  reason: collision with root package name */
    private final HandleList<MqttTopicFilterImpl> f18233u;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttSubscribedPublishFlow(Subscriber<? super Mqtt5Publish> subscriber, MqttClientConfig mqttClientConfig, MqttIncomingQosHandler mqttIncomingQosHandler, boolean z7) {
        super(subscriber, mqttClientConfig, mqttIncomingQosHandler, z7);
        this.f18233u = new HandleList<>();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow, org.reactivestreams.Subscription
    public /* bridge */ /* synthetic */ void f(long j8) {
        super.f(j8);
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow
    public /* bridge */ /* synthetic */ void l(Mqtt5Publish mqtt5Publish) {
        super.l(mqtt5Publish);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow
    public void o() {
        this.f18193j.f18209b.b(this);
        super.o();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow, io.reactivex.Emitter
    public /* bridge */ /* synthetic */ void onComplete() {
        super.onComplete();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow, io.reactivex.Emitter
    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        super.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandleList<MqttTopicFilterImpl> p() {
        return this.f18233u;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionFlow
    /* renamed from: q */
    public void onSuccess(MqttSubAck mqttSubAck) {
        Subscriber<? super Mqtt5Publish> subscriber = this.f18192i;
        if (subscriber instanceof FlowableWithSingleSubscriber) {
            ((FlowableWithSingleSubscriber) subscriber).e(mqttSubAck);
        }
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
