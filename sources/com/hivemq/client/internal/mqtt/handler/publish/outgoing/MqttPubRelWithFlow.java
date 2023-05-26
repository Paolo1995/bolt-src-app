package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRel;
import j$.util.function.BooleanSupplier;

/* loaded from: classes3.dex */
abstract class MqttPubRelWithFlow extends MqttPubOrRelWithFlow {

    /* renamed from: e  reason: collision with root package name */
    private final MqttPubRel f18292e;

    /* loaded from: classes3.dex */
    static class MqttQos2IntermediateWithFlow extends MqttPubRelWithFlow implements BooleanSupplier {

        /* renamed from: f  reason: collision with root package name */
        private int f18293f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MqttQos2IntermediateWithFlow(MqttPubRel mqttPubRel, MqttAckFlow mqttAckFlow) {
            super(mqttPubRel, mqttAckFlow);
        }

        @Override // j$.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            int i8 = this.f18293f + 1;
            this.f18293f = i8;
            if (i8 == 2) {
                return true;
            }
            return false;
        }
    }

    MqttPubRelWithFlow(MqttPubRel mqttPubRel, MqttAckFlow mqttAckFlow) {
        super(mqttAckFlow);
        this.f18292e = mqttPubRel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttPubRel d() {
        return this.f18292e;
    }
}
