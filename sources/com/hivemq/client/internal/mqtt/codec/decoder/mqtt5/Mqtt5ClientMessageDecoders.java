package com.hivemq.client.internal.mqtt.codec.decoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.decoder.MqttMessageDecoders;
import com.hivemq.client.internal.mqtt.codec.decoder.MqttPingRespDecoder;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5ClientMessageDecoders extends MqttMessageDecoders {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public Mqtt5ClientMessageDecoders(Mqtt5ConnAckDecoder mqtt5ConnAckDecoder, Mqtt5PublishDecoder mqtt5PublishDecoder, Mqtt5PubAckDecoder mqtt5PubAckDecoder, Mqtt5PubRecDecoder mqtt5PubRecDecoder, Mqtt5PubRelDecoder mqtt5PubRelDecoder, Mqtt5PubCompDecoder mqtt5PubCompDecoder, Mqtt5SubAckDecoder mqtt5SubAckDecoder, Mqtt5UnsubAckDecoder mqtt5UnsubAckDecoder, MqttPingRespDecoder mqttPingRespDecoder, Mqtt5DisconnectDecoder mqtt5DisconnectDecoder, Mqtt5AuthDecoder mqtt5AuthDecoder) {
        this.f17872a[Mqtt5MessageType.CONNACK.c()] = mqtt5ConnAckDecoder;
        this.f17872a[Mqtt5MessageType.PUBLISH.c()] = mqtt5PublishDecoder;
        this.f17872a[Mqtt5MessageType.PUBACK.c()] = mqtt5PubAckDecoder;
        this.f17872a[Mqtt5MessageType.PUBREC.c()] = mqtt5PubRecDecoder;
        this.f17872a[Mqtt5MessageType.PUBREL.c()] = mqtt5PubRelDecoder;
        this.f17872a[Mqtt5MessageType.PUBCOMP.c()] = mqtt5PubCompDecoder;
        this.f17872a[Mqtt5MessageType.SUBACK.c()] = mqtt5SubAckDecoder;
        this.f17872a[Mqtt5MessageType.UNSUBACK.c()] = mqtt5UnsubAckDecoder;
        this.f17872a[Mqtt5MessageType.PINGRESP.c()] = mqttPingRespDecoder;
        this.f17872a[Mqtt5MessageType.DISCONNECT.c()] = mqtt5DisconnectDecoder;
        this.f17872a[Mqtt5MessageType.AUTH.c()] = mqtt5AuthDecoder;
    }
}
