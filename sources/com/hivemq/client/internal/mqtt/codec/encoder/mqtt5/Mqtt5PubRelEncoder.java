package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder;
import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRel;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.publish.pubrel.Mqtt5PubRelReasonCode;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5PubRelEncoder extends Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode.WithId<MqttPubRel, Mqtt5PubRelReasonCode> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17974a = (Mqtt5MessageType.PUBREL.c() << 4) | 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
    /* renamed from: E */
    public Mqtt5PubRelReasonCode x() {
        return MqttPubRel.f18595f;
    }

    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt5.Mqtt5MessageWithUserPropertiesEncoder.WithReason.WithOmissibleCode
    int y() {
        return f17974a;
    }
}
