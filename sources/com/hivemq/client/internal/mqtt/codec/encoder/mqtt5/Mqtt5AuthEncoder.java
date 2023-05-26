package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder;
import com.hivemq.client.internal.mqtt.datatypes.MqttVariableByteInteger;
import com.hivemq.client.internal.mqtt.message.auth.MqttAuth;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5AuthEncoder extends Mqtt5MessageWithUserPropertiesEncoder.WithReason<MqttAuth> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17950a = Mqtt5MessageType.AUTH.c() << 4;

    private void r(ByteBuf byteBuf, int i8) {
        byteBuf.writeByte(f17950a);
        MqttVariableByteInteger.b(i8, byteBuf);
    }

    private void s(MqttAuth mqttAuth, ByteBuf byteBuf, int i8, int i9) {
        MqttVariableByteInteger.b(i8, byteBuf);
        Mqtt5MessageEncoderUtil.g(21, mqttAuth.getMethod(), byteBuf);
        Mqtt5MessageEncoderUtil.f(22, mqttAuth.k(), byteBuf);
        m(mqttAuth, byteBuf, i9);
    }

    private void t(MqttAuth mqttAuth, ByteBuf byteBuf, int i8, int i9) {
        byteBuf.writeByte(mqttAuth.h().getCode());
        s(mqttAuth, byteBuf, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: q */
    public void e(MqttAuth mqttAuth, ByteBuf byteBuf, int i8, int i9, int i10) {
        r(byteBuf, i8);
        t(mqttAuth, byteBuf, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: u */
    public int h(MqttAuth mqttAuth) {
        return Mqtt5MessageEncoderUtil.o(mqttAuth.getMethod()) + 0 + Mqtt5MessageEncoderUtil.n(mqttAuth.k()) + n(mqttAuth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder
    /* renamed from: v */
    public int l(MqttAuth mqttAuth) {
        return 1;
    }
}
