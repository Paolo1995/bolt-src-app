package com.hivemq.client.internal.mqtt.message;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessage;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;

/* loaded from: classes3.dex */
public abstract class MqttStatefulMessage<M extends MqttMessageWithUserProperties> implements MqttMessage.WithUserProperties {

    /* renamed from: b  reason: collision with root package name */
    private final M f18473b;

    /* loaded from: classes3.dex */
    public static abstract class WithId<M extends MqttMessageWithUserProperties> extends MqttStatefulMessage<M> implements MqttMessage.WithId {

        /* renamed from: c  reason: collision with root package name */
        private final int f18474c;

        /* JADX INFO: Access modifiers changed from: protected */
        public WithId(M m8, int i8) {
            super(m8);
            this.f18474c = i8;
        }

        @Override // com.hivemq.client.internal.mqtt.message.MqttMessage.WithId
        public int a() {
            return this.f18474c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hivemq.client.internal.mqtt.message.MqttStatefulMessage
        public String d() {
            return super.d() + ", packetIdentifier=" + this.f18474c;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MqttStatefulMessage(M m8) {
        this.f18473b = m8;
    }

    @Override // com.hivemq.client.internal.mqtt.message.MqttMessage.WithUserProperties
    public MqttUserPropertiesImpl b() {
        return this.f18473b.b();
    }

    public M c() {
        return this.f18473b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return "stateless=" + this.f18473b;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public Mqtt5MessageType getType() {
        return this.f18473b.getType();
    }
}
