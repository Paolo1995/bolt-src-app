package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.mqtt.message.connect.connack.mqtt3.Mqtt3ConnAckView;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAckReturnCode;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3ConnAckDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttConnAck a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        boolean z7 = false;
        MqttMessageDecoderUtil.a(0, i8);
        MqttMessageDecoderUtil.b(2, byteBuf.readableBytes());
        byte readByte = byteBuf.readByte();
        if ((readByte & 254) == 0) {
            if ((readByte & 1) == 1) {
                z7 = true;
            }
            Mqtt3ConnAckReturnCode a8 = Mqtt3ConnAckReturnCode.a(byteBuf.readUnsignedByte());
            if (a8 != null) {
                if (a8 != Mqtt3ConnAckReturnCode.SUCCESS && z7) {
                    throw new MqttDecoderException("session present must be 0 if return code is not SUCCESS");
                }
                return Mqtt3ConnAckView.b(a8, z7);
            }
            throw Mqtt3MessageDecoderUtil.a();
        }
        throw new MqttDecoderException("wrong CONNACK flags, bits 7-1 must be 0");
    }
}
