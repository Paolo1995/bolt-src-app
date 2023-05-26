package com.hivemq.client.internal.mqtt.codec.encoder.mqtt3;

import com.hivemq.client.internal.mqtt.codec.encoder.MqttMessageEncoders;
import com.hivemq.client.internal.mqtt.codec.encoder.MqttPingReqEncoder;
import com.hivemq.client.mqtt.mqtt3.message.Mqtt3MessageType;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes3.dex */
public class Mqtt3ClientMessageEncoders extends MqttMessageEncoders {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public Mqtt3ClientMessageEncoders(Mqtt3ConnectEncoder mqtt3ConnectEncoder, Mqtt3PublishEncoder mqtt3PublishEncoder, Mqtt3PubAckEncoder mqtt3PubAckEncoder, Mqtt3PubRecEncoder mqtt3PubRecEncoder, Mqtt3PubRelEncoder mqtt3PubRelEncoder, Mqtt3PubCompEncoder mqtt3PubCompEncoder, Mqtt3SubscribeEncoder mqtt3SubscribeEncoder, Mqtt3UnsubscribeEncoder mqtt3UnsubscribeEncoder, MqttPingReqEncoder mqttPingReqEncoder, Mqtt3DisconnectEncoder mqtt3DisconnectEncoder) {
        this.f17919a[Mqtt3MessageType.CONNECT.a()] = mqtt3ConnectEncoder;
        this.f17919a[Mqtt3MessageType.PUBLISH.a()] = mqtt3PublishEncoder;
        this.f17919a[Mqtt3MessageType.PUBACK.a()] = mqtt3PubAckEncoder;
        this.f17919a[Mqtt3MessageType.PUBREC.a()] = mqtt3PubRecEncoder;
        this.f17919a[Mqtt3MessageType.PUBREL.a()] = mqtt3PubRelEncoder;
        this.f17919a[Mqtt3MessageType.PUBCOMP.a()] = mqtt3PubCompEncoder;
        this.f17919a[Mqtt3MessageType.SUBSCRIBE.a()] = mqtt3SubscribeEncoder;
        this.f17919a[Mqtt3MessageType.UNSUBSCRIBE.a()] = mqtt3UnsubscribeEncoder;
        this.f17919a[Mqtt3MessageType.PINGREQ.a()] = mqttPingReqEncoder;
        this.f17919a[Mqtt3MessageType.DISCONNECT.a()] = mqtt3DisconnectEncoder;
    }
}
