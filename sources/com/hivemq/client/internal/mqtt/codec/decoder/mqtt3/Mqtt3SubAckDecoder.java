package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.MqttSubAck;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.mqtt3.Mqtt3SubAckView;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAckReturnCode;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3SubAckDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttSubAck a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        MqttMessageDecoderUtil.a(0, i8);
        if (byteBuf.readableBytes() >= 3) {
            int readUnsignedShort = byteBuf.readUnsignedShort();
            int readableBytes = byteBuf.readableBytes();
            ImmutableList.Builder w7 = b.w(readableBytes);
            for (int i9 = 0; i9 < readableBytes; i9++) {
                Mqtt3SubAckReturnCode a8 = Mqtt3SubAckReturnCode.a(byteBuf.readUnsignedByte());
                if (a8 != null) {
                    w7.a(a8);
                } else {
                    throw Mqtt3MessageDecoderUtil.a();
                }
            }
            return Mqtt3SubAckView.b(readUnsignedShort, w7.b());
        }
        throw MqttMessageDecoderUtil.g();
    }
}
