package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertyImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.auth.MqttAuth;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5AuthReasonCode;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5AuthDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttAuth a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        MqttMessageDecoderUtil.a(0, i8);
        if (byteBuf.readableBytes() >= 2) {
            Mqtt5AuthReasonCode c8 = Mqtt5AuthReasonCode.c(byteBuf.readUnsignedByte());
            if (c8 != null) {
                Mqtt5MessageDecoderUtil.c(byteBuf);
                ImmutableList.Builder<MqttUserPropertyImpl> builder = null;
                MqttUtf8StringImpl mqttUtf8StringImpl = null;
                ByteBuffer byteBuffer = null;
                MqttUtf8StringImpl mqttUtf8StringImpl2 = null;
                while (byteBuf.isReadable()) {
                    int g8 = Mqtt5MessageDecoderUtil.g(byteBuf);
                    if (g8 != 21) {
                        if (g8 != 22) {
                            if (g8 != 31) {
                                if (g8 == 38) {
                                    builder = Mqtt5MessageDecoderUtil.o(builder, byteBuf, mqttDecoderContext);
                                } else {
                                    throw Mqtt5MessageDecoderUtil.x(g8);
                                }
                            } else {
                                mqttUtf8StringImpl2 = Mqtt5MessageDecoderUtil.j(mqttUtf8StringImpl2, byteBuf, mqttDecoderContext);
                            }
                        } else {
                            byteBuffer = Mqtt5MessageDecoderUtil.d(byteBuffer, byteBuf, mqttDecoderContext);
                        }
                    } else {
                        mqttUtf8StringImpl = Mqtt5MessageDecoderUtil.e(mqttUtf8StringImpl, byteBuf);
                    }
                }
                if (mqttUtf8StringImpl != null) {
                    return new MqttAuth(c8, mqttUtf8StringImpl, byteBuffer, mqttUtf8StringImpl2, MqttUserPropertiesImpl.b(builder));
                }
                throw new MqttDecoderException(Mqtt5DisconnectReasonCode.PROTOCOL_ERROR, "must not omit authentication method");
            }
            throw Mqtt5MessageDecoderUtil.y();
        }
        throw MqttMessageDecoderUtil.g();
    }
}
