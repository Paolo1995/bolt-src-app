package com.hivemq.client.internal.mqtt;

import com.hivemq.client.mqtt.MqttWebSocketConfig;

/* loaded from: classes3.dex */
public class MqttWebSocketConfigImpl implements MqttWebSocketConfig {

    /* renamed from: e  reason: collision with root package name */
    static final MqttWebSocketConfigImpl f17837e = new MqttWebSocketConfigImpl("", "", "mqtt", 10000);

    /* renamed from: a  reason: collision with root package name */
    private final String f17838a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17839b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17840c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17841d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttWebSocketConfigImpl(String str, String str2, String str3, int i8) {
        this.f17838a = str;
        this.f17839b = str2;
        this.f17840c = str3;
        this.f17841d = i8;
    }

    public int a() {
        return this.f17841d;
    }

    public String b() {
        return this.f17839b;
    }

    public String c() {
        return this.f17838a;
    }

    public String d() {
        return this.f17840c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttWebSocketConfigImpl)) {
            return false;
        }
        MqttWebSocketConfigImpl mqttWebSocketConfigImpl = (MqttWebSocketConfigImpl) obj;
        if (this.f17838a.equals(mqttWebSocketConfigImpl.f17838a) && this.f17839b.equals(mqttWebSocketConfigImpl.f17839b) && this.f17840c.equals(mqttWebSocketConfigImpl.f17840c) && this.f17841d == mqttWebSocketConfigImpl.f17841d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f17838a.hashCode() * 31) + this.f17839b.hashCode()) * 31) + this.f17840c.hashCode()) * 31) + this.f17841d;
    }
}
