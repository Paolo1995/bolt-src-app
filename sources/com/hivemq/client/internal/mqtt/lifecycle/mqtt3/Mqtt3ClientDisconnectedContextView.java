package com.hivemq.client.internal.mqtt.lifecycle.mqtt3;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.exceptions.mqtt3.Mqtt3ExceptionFactory;
import com.hivemq.client.internal.mqtt.lifecycle.MqttClientReconnector;
import com.hivemq.client.internal.mqtt.mqtt3.Mqtt3ClientConfigView;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;

/* loaded from: classes3.dex */
public class Mqtt3ClientDisconnectedContextView implements MqttClientDisconnectedContext {

    /* renamed from: a  reason: collision with root package name */
    private final Mqtt3ClientConfigView f18441a;

    /* renamed from: b  reason: collision with root package name */
    private final MqttDisconnectSource f18442b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f18443c;

    /* renamed from: d  reason: collision with root package name */
    private final Mqtt3ClientReconnectorView f18444d;

    private Mqtt3ClientDisconnectedContextView(Mqtt3ClientConfigView mqtt3ClientConfigView, MqttDisconnectSource mqttDisconnectSource, Throwable th, Mqtt3ClientReconnectorView mqtt3ClientReconnectorView) {
        this.f18441a = mqtt3ClientConfigView;
        this.f18442b = mqttDisconnectSource;
        this.f18443c = th;
        this.f18444d = mqtt3ClientReconnectorView;
    }

    public static MqttClientDisconnectedContext f(MqttClientConfig mqttClientConfig, MqttDisconnectSource mqttDisconnectSource, Throwable th, MqttClientReconnector mqttClientReconnector) {
        return new Mqtt3ClientDisconnectedContextView(new Mqtt3ClientConfigView(mqttClientConfig), mqttDisconnectSource, Mqtt3ExceptionFactory.c(th), new Mqtt3ClientReconnectorView(mqttClientReconnector));
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    public Throwable b() {
        return this.f18443c;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    /* renamed from: d */
    public Mqtt3ClientConfigView a() {
        return this.f18441a;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    /* renamed from: e */
    public Mqtt3ClientReconnectorView c() {
        return this.f18444d;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext
    public MqttDisconnectSource getSource() {
        return this.f18442b;
    }
}
