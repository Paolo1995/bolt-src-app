package com.hivemq.client.internal.mqtt.codec.encoder.mqtt5;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttPingReqEncoder;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt5ClientMessageEncoders extends MqttMessageEncoders {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public Mqtt5ClientMessageEncoders(Mqtt5ConnectEncoder mqtt5ConnectEncoder, Mqtt5PublishEncoder mqtt5PublishEncoder, Mqtt5PubAckEncoder mqtt5PubAckEncoder, Mqtt5PubRecEncoder mqtt5PubRecEncoder, Mqtt5PubRelEncoder mqtt5PubRelEncoder, Mqtt5PubCompEncoder mqtt5PubCompEncoder, Mqtt5SubscribeEncoder mqtt5SubscribeEncoder, Mqtt5UnsubscribeEncoder mqtt5UnsubscribeEncoder, MqttPingReqEncoder mqttPingReqEncoder, Mqtt5DisconnectEncoder mqtt5DisconnectEncoder, Mqtt5AuthEncoder mqtt5AuthEncoder) {
        this.f17919a[Mqtt5MessageType.CONNECT.c()] = mqtt5ConnectEncoder;
        this.f17919a[Mqtt5MessageType.PUBLISH.c()] = mqtt5PublishEncoder;
        this.f17919a[Mqtt5MessageType.PUBACK.c()] = mqtt5PubAckEncoder;
        this.f17919a[Mqtt5MessageType.PUBREC.c()] = mqtt5PubRecEncoder;
        this.f17919a[Mqtt5MessageType.PUBREL.c()] = mqtt5PubRelEncoder;
        this.f17919a[Mqtt5MessageType.PUBCOMP.c()] = mqtt5PubCompEncoder;
        this.f17919a[Mqtt5MessageType.SUBSCRIBE.c()] = mqtt5SubscribeEncoder;
        this.f17919a[Mqtt5MessageType.UNSUBSCRIBE.c()] = mqtt5UnsubscribeEncoder;
        this.f17919a[Mqtt5MessageType.PINGREQ.c()] = mqttPingReqEncoder;
        this.f17919a[Mqtt5MessageType.DISCONNECT.c()] = mqtt5DisconnectEncoder;
        this.f17919a[Mqtt5MessageType.AUTH.c()] = mqtt5AuthEncoder;
    }
}
