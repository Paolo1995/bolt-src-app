package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder;
import com.hivemq.client.internal.mqtt.message.publish.pubrec.MqttPubRec;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3PubRecEncoder extends Mqtt3MessageEncoder.Mqtt3MessageWithIdEncoder<MqttPubRec> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17940a = Mqtt3MessageType.PUBREC.a() << 4;

    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder.Mqtt3MessageWithIdEncoder
    int g() {
        return f17940a;
    }
}
