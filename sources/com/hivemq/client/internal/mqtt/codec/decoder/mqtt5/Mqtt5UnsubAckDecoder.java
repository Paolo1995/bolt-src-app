package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertyImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.unsubscribe.unsuback.MqttUnsubAck;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.unsuback.Mqtt5UnsubAckReasonCode;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5UnsubAckDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttUnsubAck a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        MqttMessageDecoderUtil.a(0, i8);
        if (byteBuf.readableBytes() >= 3) {
            int readUnsignedShort = byteBuf.readUnsignedShort();
            int h8 = Mqtt5MessageDecoderUtil.h(byteBuf);
            int readerIndex = byteBuf.readerIndex();
            MqttUtf8StringImpl mqttUtf8StringImpl = null;
            ImmutableList.Builder<MqttUserPropertyImpl> builder = null;
            while (true) {
                int readerIndex2 = byteBuf.readerIndex() - readerIndex;
                if (readerIndex2 < h8) {
                    int g8 = Mqtt5MessageDecoderUtil.g(byteBuf);
                    if (g8 != 31) {
                        if (g8 == 38) {
                            builder = Mqtt5MessageDecoderUtil.o(builder, byteBuf, mqttDecoderContext);
                        } else {
                            throw Mqtt5MessageDecoderUtil.x(g8);
                        }
                    } else {
                        mqttUtf8StringImpl = Mqtt5MessageDecoderUtil.j(mqttUtf8StringImpl, byteBuf, mqttDecoderContext);
                    }
                } else if (readerIndex2 == h8) {
                    int readableBytes = byteBuf.readableBytes();
                    if (readableBytes != 0) {
                        ImmutableList.Builder w7 = b.w(readableBytes);
                        for (int i9 = 0; i9 < readableBytes; i9++) {
                            Mqtt5UnsubAckReasonCode c8 = Mqtt5UnsubAckReasonCode.c(byteBuf.readUnsignedByte());
                            if (c8 != null) {
                                w7.a(c8);
                            } else {
                                throw Mqtt5MessageDecoderUtil.y();
                            }
                        }
                        return new MqttUnsubAck(readUnsignedShort, w7.b(), mqttUtf8StringImpl, MqttUserPropertiesImpl.b(builder));
                    }
                    throw Mqtt5MessageDecoderUtil.r();
                } else {
                    throw Mqtt5MessageDecoderUtil.p();
                }
            }
        } else {
            throw MqttMessageDecoderUtil.g();
        }
    }
}
