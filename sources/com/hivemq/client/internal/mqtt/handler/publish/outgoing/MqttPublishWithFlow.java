package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;

/* loaded from: classes3.dex */
class MqttPublishWithFlow extends MqttPubOrRelWithFlow {

    /* renamed from: e  reason: collision with root package name */
    private final MqttPublish f18307e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttPublishWithFlow(MqttPublish mqttPublish, MqttAckFlow mqttAckFlow) {
        super(mqttAckFlow);
        this.f18307e = mqttPublish;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttPublish d() {
        return this.f18307e;
    }
}
