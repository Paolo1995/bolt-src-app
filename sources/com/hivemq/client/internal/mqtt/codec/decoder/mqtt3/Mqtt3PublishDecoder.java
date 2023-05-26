package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderContext;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttDecoderException;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoderUtil;
import com.hivemq.client.internal.mqtt.datatypes.MqttTopicImpl;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.internal.mqtt.message.publish.mqtt3.Mqtt3PublishView;
import com.hivemq.client.internal.util.ByteBufferUtil;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3PublishDecoder implements MqttMessageDecoder {
    @Override // com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoder
    /* renamed from: b */
    public MqttStatefulPublish a(int i8, ByteBuf byteBuf, MqttDecoderContext mqttDecoderContext) throws MqttDecoderException {
        boolean z7;
        boolean z8 = true;
        if ((i8 & 8) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        MqttQos d8 = MqttMessageDecoderUtil.d(i8, z7);
        if ((i8 & 1) == 0) {
            z8 = false;
        }
        if (byteBuf.readableBytes() >= 2) {
            MqttTopicImpl s7 = MqttTopicImpl.s(byteBuf);
            if (s7 != null) {
                int c8 = MqttMessageDecoderUtil.c(d8, byteBuf);
                int readableBytes = byteBuf.readableBytes();
                ByteBuffer byteBuffer = null;
                if (readableBytes > 0) {
                    byteBuffer = ByteBufferUtil.a(readableBytes, mqttDecoderContext.g());
                    byteBuf.readBytes(byteBuffer);
                    byteBuffer.position(0);
                }
                return Mqtt3PublishView.j(Mqtt3PublishView.c(s7, byteBuffer, d8, z8), c8, z7);
            }
            throw MqttMessageDecoderUtil.e();
        }
        throw MqttMessageDecoderUtil.g();
    }
}
