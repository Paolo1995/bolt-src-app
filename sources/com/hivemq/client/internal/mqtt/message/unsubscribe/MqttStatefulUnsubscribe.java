package com.hivemq.client.internal.mqtt.message.unsubscribe;

import com.hivemq.client.internal.mqtt.message.MqttStatefulMessage;

/* loaded from: classes3.dex */
public class MqttStatefulUnsubscribe extends MqttStatefulMessage.WithId<MqttUnsubscribe> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttStatefulUnsubscribe(MqttUnsubscribe mqttUnsubscribe, int i8) {
        super(mqttUnsubscribe, i8);
    }

    public String toString() {
        return "MqttStatefulUnsubscribe{" + d() + "}";
    }
}
