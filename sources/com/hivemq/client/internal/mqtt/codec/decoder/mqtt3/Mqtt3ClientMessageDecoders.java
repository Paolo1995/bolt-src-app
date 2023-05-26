package com.hivemq.client.internal.mqtt.codec.decoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttPingRespDecoder;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3ClientMessageDecoders extends MqttMessageDecoders {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public Mqtt3ClientMessageDecoders(Mqtt3ConnAckDecoder mqtt3ConnAckDecoder, Mqtt3PublishDecoder mqtt3PublishDecoder, Mqtt3PubAckDecoder mqtt3PubAckDecoder, Mqtt3PubRecDecoder mqtt3PubRecDecoder, Mqtt3PubRelDecoder mqtt3PubRelDecoder, Mqtt3PubCompDecoder mqtt3PubCompDecoder, Mqtt3SubAckDecoder mqtt3SubAckDecoder, Mqtt3UnsubAckDecoder mqtt3UnsubAckDecoder, MqttPingRespDecoder mqttPingRespDecoder) {
        this.f17872a[Mqtt3MessageType.CONNACK.a()] = mqtt3ConnAckDecoder;
        this.f17872a[Mqtt3MessageType.PUBLISH.a()] = mqtt3PublishDecoder;
        this.f17872a[Mqtt3MessageType.PUBACK.a()] = mqtt3PubAckDecoder;
        this.f17872a[Mqtt3MessageType.PUBREC.a()] = mqtt3PubRecDecoder;
        this.f17872a[Mqtt3MessageType.PUBREL.a()] = mqtt3PubRelDecoder;
        this.f17872a[Mqtt3MessageType.PUBCOMP.a()] = mqtt3PubCompDecoder;
        this.f17872a[Mqtt3MessageType.SUBACK.a()] = mqtt3SubAckDecoder;
        this.f17872a[Mqtt3MessageType.UNSUBACK.a()] = mqtt3UnsubAckDecoder;
        this.f17872a[Mqtt3MessageType.PINGRESP.a()] = mqttPingRespDecoder;
    }
}
