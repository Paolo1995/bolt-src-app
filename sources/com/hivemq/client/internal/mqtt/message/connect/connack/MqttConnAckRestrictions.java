package com.hivemq.client.internal.mqtt.message.connect.connack;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAckRestrictions;
import e0.a;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MqttConnAckRestrictions implements Mqtt5ConnAckRestrictions {

    /* renamed from: j  reason: collision with root package name */
    public static final MqttConnAckRestrictions f18517j = new MqttConnAckRestrictions(Settings.DEFAULT_INITIAL_WINDOW_SIZE, 268435460, 0, Mqtt5ConnAckRestrictions.f18844a, true, true, true, true);

    /* renamed from: b  reason: collision with root package name */
    private final int f18518b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18519c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18520d;

    /* renamed from: e  reason: collision with root package name */
    private final MqttQos f18521e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f18522f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f18523g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f18524h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f18525i;

    public MqttConnAckRestrictions(int i8, int i9, int i10, MqttQos mqttQos, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f18518b = i8;
        this.f18519c = i9;
        this.f18520d = i10;
        this.f18521e = mqttQos;
        this.f18522f = z7;
        this.f18523g = z8;
        this.f18524h = z9;
        this.f18525i = z10;
    }

    private String i() {
        return "receiveMaximum=" + this.f18518b + ", maximumPacketSize=" + this.f18519c + ", topicAliasMaximum=" + this.f18520d + ", maximumQos=" + this.f18521e + ", retainAvailable=" + this.f18522f + ", wildcardSubscriptionAvailable=" + this.f18523g + ", sharedSubscriptionAvailable=" + this.f18524h + ", subscriptionIdentifiersAvailable=" + this.f18525i;
    }

    public boolean a() {
        return this.f18525i;
    }

    public int b() {
        return this.f18519c;
    }

    public MqttQos c() {
        return this.f18521e;
    }

    public int d() {
        return this.f18518b;
    }

    public int e() {
        return this.f18520d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttConnAckRestrictions)) {
            return false;
        }
        MqttConnAckRestrictions mqttConnAckRestrictions = (MqttConnAckRestrictions) obj;
        if (this.f18518b == mqttConnAckRestrictions.f18518b && this.f18519c == mqttConnAckRestrictions.f18519c && this.f18520d == mqttConnAckRestrictions.f18520d && this.f18521e == mqttConnAckRestrictions.f18521e && this.f18522f == mqttConnAckRestrictions.f18522f && this.f18523g == mqttConnAckRestrictions.f18523g && this.f18524h == mqttConnAckRestrictions.f18524h && this.f18525i == mqttConnAckRestrictions.f18525i) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f18522f;
    }

    public boolean g() {
        return this.f18524h;
    }

    public boolean h() {
        return this.f18523g;
    }

    public int hashCode() {
        return (((((((((((((this.f18518b * 31) + this.f18519c) * 31) + this.f18520d) * 31) + this.f18521e.hashCode()) * 31) + a.a(this.f18522f)) * 31) + a.a(this.f18523g)) * 31) + a.a(this.f18524h)) * 31) + a.a(this.f18525i);
    }

    public String toString() {
        return "MqttConnAckRestrictions{" + i() + '}';
    }
}
