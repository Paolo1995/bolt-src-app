package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertyImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.publish.puback.MqttPubAck;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.publish.puback.Mqtt5PubAckReasonCode;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5PubAckDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttPubAck a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        MqttUtf8StringImpl mqttUtf8StringImpl;
        MqttMessageDecoderUtil.a(0, i8);
        if (byteBuf.readableBytes() >= 2) {
            int readUnsignedShort = byteBuf.readUnsignedShort();
            Mqtt5PubAckReasonCode mqtt5PubAckReasonCode = MqttPubAck.f18577f;
            ImmutableList.Builder<MqttUserPropertyImpl> builder = null;
            MqttUtf8StringImpl mqttUtf8StringImpl2 = null;
            if (byteBuf.isReadable()) {
                mqtt5PubAckReasonCode = Mqtt5PubAckReasonCode.c(byteBuf.readUnsignedByte());
                if (mqtt5PubAckReasonCode != null) {
                    if (byteBuf.isReadable()) {
                        Mqtt5MessageDecoderUtil.c(byteBuf);
                        ImmutableList.Builder<MqttUserPropertyImpl> builder2 = null;
                        while (byteBuf.isReadable()) {
                            int g8 = Mqtt5MessageDecoderUtil.g(byteBuf);
                            if (g8 != 31) {
                                if (g8 == 38) {
                                    builder2 = Mqtt5MessageDecoderUtil.o(builder2, byteBuf, mqttDecoderContext);
                                } else {
                                    throw Mqtt5MessageDecoderUtil.x(g8);
                                }
                            } else {
                                mqttUtf8StringImpl2 = Mqtt5MessageDecoderUtil.j(mqttUtf8StringImpl2, byteBuf, mqttDecoderContext);
                            }
                        }
                        mqttUtf8StringImpl = mqttUtf8StringImpl2;
                        builder = builder2;
                        return new MqttPubAck(readUnsignedShort, mqtt5PubAckReasonCode, mqttUtf8StringImpl, MqttUserPropertiesImpl.b(builder));
                    }
                } else {
                    throw Mqtt5MessageDecoderUtil.y();
                }
            }
            mqttUtf8StringImpl = null;
            return new MqttPubAck(readUnsignedShort, mqtt5PubAckReasonCode, mqttUtf8StringImpl, MqttUserPropertiesImpl.b(builder));
        }
        throw MqttMessageDecoderUtil.g();
    }
}
