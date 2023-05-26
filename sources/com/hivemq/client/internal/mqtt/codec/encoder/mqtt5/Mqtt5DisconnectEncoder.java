package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.buffer.ByteBuf;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5DisconnectEncoder extends Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode<MqttDisconnect, Mqtt5DisconnectReasonCode> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17966a = Mqtt5MessageType.DISCONNECT.c() << 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
    /* renamed from: C */
    public int q(MqttDisconnect mqttDisconnect) {
        return Mqtt5MessageEncoderUtil.k(mqttDisconnect.l(), -1L) + Mqtt5MessageEncoderUtil.l(mqttDisconnect.k());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
    /* renamed from: D */
    public void t(MqttDisconnect mqttDisconnect, ByteBuf byteBuf) {
        Mqtt5MessageEncoderUtil.c(17, mqttDisconnect.l(), -1L, byteBuf);
        Mqtt5MessageEncoderUtil.d(28, mqttDisconnect.k(), byteBuf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
    /* renamed from: E */
    public Mqtt5DisconnectReasonCode x() {
        return Mqtt5Disconnect.f18845a;
    }

    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
    int y() {
        return f17966a;
    }
}
