package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertyImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5DisconnectDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttDisconnect a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        MqttUtf8StringImpl mqttUtf8StringImpl;
        MqttUtf8StringImpl mqttUtf8StringImpl2;
        long j8;
        MqttMessageDecoderUtil.a(0, i8);
        Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode = Mqtt5Disconnect.f18845a;
        ImmutableList.Builder<MqttUserPropertyImpl> builder = null;
        MqttUtf8StringImpl mqttUtf8StringImpl3 = null;
        if (byteBuf.isReadable()) {
            mqtt5DisconnectReasonCode = Mqtt5DisconnectReasonCode.c(byteBuf.readUnsignedByte());
            if (mqtt5DisconnectReasonCode != null) {
                if (byteBuf.isReadable()) {
                    Mqtt5MessageDecoderUtil.c(byteBuf);
                    MqttUtf8StringImpl mqttUtf8StringImpl4 = null;
                    j8 = -1;
                    ImmutableList.Builder<MqttUserPropertyImpl> builder2 = null;
                    while (byteBuf.isReadable()) {
                        int g8 = Mqtt5MessageDecoderUtil.g(byteBuf);
                        if (g8 != 17) {
                            if (g8 != 28) {
                                if (g8 != 31) {
                                    if (g8 == 38) {
                                        builder2 = Mqtt5MessageDecoderUtil.n(builder2, byteBuf);
                                    } else {
                                        throw Mqtt5MessageDecoderUtil.x(g8);
                                    }
                                } else {
                                    mqttUtf8StringImpl4 = Mqtt5MessageDecoderUtil.i(mqttUtf8StringImpl4, byteBuf);
                                }
                            } else {
                                mqttUtf8StringImpl3 = Mqtt5MessageDecoderUtil.k(mqttUtf8StringImpl3, byteBuf);
                            }
                        } else {
                            j8 = Mqtt5MessageDecoderUtil.l(j8, byteBuf);
                        }
                    }
                    mqttUtf8StringImpl2 = mqttUtf8StringImpl4;
                    mqttUtf8StringImpl = mqttUtf8StringImpl3;
                    builder = builder2;
                    return new MqttDisconnect(mqtt5DisconnectReasonCode, j8, mqttUtf8StringImpl, mqttUtf8StringImpl2, MqttUserPropertiesImpl.b(builder));
                }
            } else {
                throw Mqtt5MessageDecoderUtil.y();
            }
        }
        mqttUtf8StringImpl = null;
        mqttUtf8StringImpl2 = null;
        j8 = -1;
        return new MqttDisconnect(mqtt5DisconnectReasonCode, j8, mqttUtf8StringImpl, mqttUtf8StringImpl2, MqttUserPropertiesImpl.b(builder));
    }
}
