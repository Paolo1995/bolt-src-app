package com.hivemq.client.internal.mqtt.handler.subscribe;

import com.hivemq.client.internal.mqtt.message.unsubscribe.MqttUnsubscribe;
import com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback.MqttUnsubAck;

/* loaded from: classes3.dex */
class MqttUnsubscribeWithFlow extends MqttSubOrUnsubWithFlow {

    /* renamed from: d  reason: collision with root package name */
    final MqttUnsubscribe f18346d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubOrUnsubWithFlow
    public /* bridge */ /* synthetic */ MqttSubscriptionFlow c() {
        d();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttSubOrUnsubAckFlow<MqttUnsubAck> d() {
        return null;
    }
}
