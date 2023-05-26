package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttEncoderContext;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3DisconnectEncoder extends MqttMessageEncoder<MqttDisconnect> {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteBuf f17934a = UnpooledByteBufAllocator.DEFAULT.ioBuffer(2).writeByte(Mqtt3MessageType.DISCONNECT.a() << 4).writeByte(0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoder
    /* renamed from: c */
    public ByteBuf b(MqttDisconnect mqttDisconnect, MqttEncoderContext mqttEncoderContext) {
        return f17934a.retainedDuplicate();
    }
}
