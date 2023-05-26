package com.hivemq.client.internal.mqtt.codec.encoder;

import com.hivemq.client.internal.mqtt.message.MqttMessage;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public abstract class MqttMessageEncoder<M extends MqttMessage> {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ByteBuf a(MqttMessage mqttMessage, MqttEncoderContext mqttEncoderContext) {
        return b(mqttMessage, mqttEncoderContext);
    }

    protected abstract ByteBuf b(M m8, MqttEncoderContext mqttEncoderContext);
}
