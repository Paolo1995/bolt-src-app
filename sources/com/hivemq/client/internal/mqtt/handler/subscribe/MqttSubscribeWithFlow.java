package com.hivemq.client.internal.mqtt.handler.subscribe;

import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.MqttSubAck;

/* loaded from: classes3.dex */
class MqttSubscribeWithFlow extends MqttSubOrUnsubWithFlow {

    /* renamed from: d  reason: collision with root package name */
    final MqttSubscribe f18330d;

    /* renamed from: e  reason: collision with root package name */
    final int f18331e;

    /* renamed from: f  reason: collision with root package name */
    private final MqttSubscriptionFlow<MqttSubAck> f18332f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttSubscribeWithFlow(MqttSubscribe mqttSubscribe, int i8, MqttSubscriptionFlow<MqttSubAck> mqttSubscriptionFlow) {
        this.f18330d = mqttSubscribe;
        this.f18331e = i8;
        this.f18332f = mqttSubscriptionFlow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubOrUnsubWithFlow
    public MqttSubscriptionFlow<MqttSubAck> c() {
        return this.f18332f;
    }
}
