package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder;
import com.hivemq.client.internal.mqtt.message.publish.puback.MqttPubAck;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3PubAckEncoder extends Mqtt3MessageEncoder.Mqtt3MessageWithIdEncoder<MqttPubAck> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17936a = Mqtt3MessageType.PUBACK.a() << 4;

    @Override // com.hivemq.client.internal.mqtt.codec.encoder.mqtt3.Mqtt3MessageEncoder.Mqtt3MessageWithIdEncoder
    int g() {
        return f17936a;
    }
}
