package com.hivemq.client.internal.mqtt.lifecycle.mqtt3;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.connack.MqttConnAck;
import com.hivemq.client.internal.mqtt.message.connect.connack.mqtt3.Mqtt3ConnAckView;
import com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectView;
import com.hivemq.client.internal.mqtt.mqtt3.Mqtt3ClientConfigView;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedContext;

/* loaded from: classes3.dex */
public class Mqtt3ClientConnectedContextView implements MqttClientConnectedContext {

    /* renamed from: a  reason: collision with root package name */
    private final Mqtt3ClientConfigView f18438a;

    /* renamed from: b  reason: collision with root package name */
    private final Mqtt3ConnectView f18439b;

    /* renamed from: c  reason: collision with root package name */
    private final Mqtt3ConnAckView f18440c;

    private Mqtt3ClientConnectedContextView(Mqtt3ClientConfigView mqtt3ClientConfigView, Mqtt3ConnectView mqtt3ConnectView, Mqtt3ConnAckView mqtt3ConnAckView) {
        this.f18438a = mqtt3ClientConfigView;
        this.f18439b = mqtt3ConnectView;
        this.f18440c = mqtt3ConnAckView;
    }

    public static MqttClientConnectedContext c(MqttClientConfig mqttClientConfig, MqttConnect mqttConnect, MqttConnAck mqttConnAck) {
        return new Mqtt3ClientConnectedContextView(new Mqtt3ClientConfigView(mqttClientConfig), Mqtt3ConnectView.i(mqttConnect), Mqtt3ConnAckView.e(mqttConnAck));
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientConnectedContext
    /* renamed from: b */
    public Mqtt3ClientConfigView a() {
        return this.f18438a;
    }
}
