package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRec;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.mqtt3.Mqtt3PubRecView;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3PubRecDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttPubRec a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        MqttMessageDecoderUtil.a(0, i8);
        MqttMessageDecoderUtil.b(2, byteBuf.readableBytes());
        return Mqtt3PubRecView.a(byteBuf.readUnsignedShort());
    }
}
