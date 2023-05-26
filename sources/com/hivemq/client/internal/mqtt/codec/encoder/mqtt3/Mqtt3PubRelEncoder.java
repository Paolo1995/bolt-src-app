package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder;
import com.hivemq.client.internal.mqtt.message.publish.pubrel.MqttPubRel;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3PubRelEncoder extends Mqtt3MessageEncoder.Mqtt3MessageWithIdEncoder<MqttPubRel> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17942a = (Mqtt3MessageType.PUBREL.a() << 4) | 2;

    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder.Mqtt3MessageWithIdEncoder
    int g() {
        return f17942a;
    }
}
