package com.hivemq.client.internal.mqtt.advanced;

import com.hivemq.client.internal.mqtt.advanced.interceptor.MqttClientInterceptors;
import e0.a;

/* loaded from: classes3.dex */
public class MqttClientAdvancedConfig {

    /* renamed from: c  reason: collision with root package name */
    public static final MqttClientAdvancedConfig f17848c = new MqttClientAdvancedConfig(false, false, null);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17849a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17850b;

    MqttClientAdvancedConfig(boolean z7, boolean z8, MqttClientInterceptors mqttClientInterceptors) {
        this.f17849a = z7;
        this.f17850b = z8;
    }

    public MqttClientInterceptors a() {
        return null;
    }

    public boolean b() {
        return this.f17849a;
    }

    public boolean c() {
        return this.f17850b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttClientAdvancedConfig)) {
            return false;
        }
        MqttClientAdvancedConfig mqttClientAdvancedConfig = (MqttClientAdvancedConfig) obj;
        if (this.f17849a == mqttClientAdvancedConfig.f17849a && this.f17850b == mqttClientAdvancedConfig.f17850b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((a.a(this.f17849a) * 31) + a.a(this.f17850b)) * 31) + 0;
    }
}
