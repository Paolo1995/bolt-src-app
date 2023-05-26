package com.hivemq.client.internal.mqtt.codec.encoder;

import com.hivemq.client.internal.mqtt.message.ping.MqttPingReq;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class MqttPingReqEncoder extends MqttMessageEncoder<MqttPingReq> {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteBuf f17920a = UnpooledByteBufAllocator.DEFAULT.ioBuffer(2).writeByte(Mqtt5MessageType.PINGREQ.c() << 4).writeByte(0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
    /* renamed from: c */
    public ByteBuf b(MqttPingReq mqttPingReq, MqttEncoderContext mqttEncoderContext) {
        return f17920a.retainedDuplicate();
    }
}
