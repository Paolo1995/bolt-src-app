package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionHandler;
import com.hivemq.client.internal.mqtt.ioc.ClientComponent;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAck;
import com.hivemq.client.rx.FlowableWithSingle;
import com.hivemq.client.rx.reactivestreams.WithSingleSubscriber;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public class MqttSubscribedPublishFlowable extends FlowableWithSingle<Mqtt5Publish, Mqtt5SubAck> {

    /* renamed from: g  reason: collision with root package name */
    private final MqttSubscribe f18250g;

    /* renamed from: h  reason: collision with root package name */
    private final MqttClientConfig f18251h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f18252i;

    public MqttSubscribedPublishFlowable(MqttSubscribe mqttSubscribe, MqttClientConfig mqttClientConfig, boolean z7) {
        this.f18250g = mqttSubscribe;
        this.f18251h = mqttClientConfig;
        this.f18252i = z7;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super Mqtt5Publish> subscriber) {
        ClientComponent e8 = this.f18251h.e();
        MqttIncomingQosHandler c8 = e8.c();
        MqttSubscriptionHandler a8 = e8.a();
        MqttSubscribedPublishFlow mqttSubscribedPublishFlow = new MqttSubscribedPublishFlow(subscriber, this.f18251h, c8, this.f18252i);
        subscriber.c(mqttSubscribedPublishFlow);
        a8.q(this.f18250g, mqttSubscribedPublishFlow);
    }

    @Override // com.hivemq.client.rx.FlowableWithSingle
    protected void p0(WithSingleSubscriber<? super Mqtt5Publish, ? super Mqtt5SubAck> withSingleSubscriber) {
        Z(withSingleSubscriber);
    }
}
