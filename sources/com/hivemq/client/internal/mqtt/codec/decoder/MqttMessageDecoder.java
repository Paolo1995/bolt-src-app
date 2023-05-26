package com.hivemq.client.internal.mqtt.codec.decoder;

import com.hivemq.client.internal.mqtt.message.MqttMessage;
import io.netty.buffer.ByteBuf;

/* loaded from: classes3.dex */
public interface MqttMessageDecoder {
    MqttMessage a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException;
}
