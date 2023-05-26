package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.exceptions.MqttClientStateExceptions;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PublishResult;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public class MqttAckFlowable extends Flowable<Mqtt5PublishResult> {

    /* renamed from: g  reason: collision with root package name */
    private final MqttClientConfig f18256g;

    /* renamed from: h  reason: collision with root package name */
    private final Flowable<MqttPublish> f18257h;

    public MqttAckFlowable(MqttClientConfig mqttClientConfig, Flowable<MqttPublish> flowable) {
        this.f18256g = mqttClientConfig;
        this.f18257h = flowable;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super Mqtt5PublishResult> subscriber) {
        if (this.f18256g.getState().a()) {
            MqttOutgoingQosHandler b8 = this.f18256g.e().b();
            MqttPublishFlowables m8 = b8.m();
            MqttAckFlowableFlow mqttAckFlowableFlow = new MqttAckFlowableFlow(subscriber, this.f18256g, b8);
            subscriber.c(mqttAckFlowableFlow);
            m8.h0(new MqttPublishFlowableAckLink(this.f18257h, mqttAckFlowableFlow));
            return;
        }
        EmptySubscription.e(MqttClientStateExceptions.b(), subscriber);
    }
}
