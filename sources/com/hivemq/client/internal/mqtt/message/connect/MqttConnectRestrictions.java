package com.hivemq.client.internal.mqtt.message.connect;

import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectRestrictions;
import e0.a;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class MqttConnectRestrictions implements Mqtt3ConnectRestrictions {

    /* renamed from: i  reason: collision with root package name */
    public static final MqttConnectRestrictions f18498i = new MqttConnectRestrictions(Settings.DEFAULT_INITIAL_WINDOW_SIZE, Settings.DEFAULT_INITIAL_WINDOW_SIZE, 268435460, 268435460, 0, 16, true, false);

    /* renamed from: a  reason: collision with root package name */
    private final int f18499a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18500b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18501c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18502d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18503e;

    /* renamed from: f  reason: collision with root package name */
    private final int f18504f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f18505g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f18506h;

    public MqttConnectRestrictions(int i8, int i9, int i10, int i11, int i12, int i13, boolean z7, boolean z8) {
        this.f18499a = i8;
        this.f18500b = i9;
        this.f18501c = i10;
        this.f18502d = i11;
        this.f18503e = i12;
        this.f18504f = i13;
        this.f18505g = z7;
        this.f18506h = z8;
    }

    private String i() {
        return "receiveMaximum=" + this.f18499a + ", sendMaximum=" + this.f18500b + ", maximumPacketSize=" + this.f18501c + ", sendMaximumPacketSize=" + this.f18502d + ", topicAliasMaximum=" + this.f18503e + ", sendTopicAliasMaximum=" + this.f18504f + ", requestProblemInformation=" + this.f18505g + ", requestResponseInformation=" + this.f18506h;
    }

    public int a() {
        return this.f18501c;
    }

    public int b() {
        return this.f18499a;
    }

    public int c() {
        return this.f18500b;
    }

    public int d() {
        return this.f18502d;
    }

    public int e() {
        return this.f18504f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttConnectRestrictions)) {
            return false;
        }
        MqttConnectRestrictions mqttConnectRestrictions = (MqttConnectRestrictions) obj;
        if (this.f18499a == mqttConnectRestrictions.f18499a && this.f18500b == mqttConnectRestrictions.f18500b && this.f18501c == mqttConnectRestrictions.f18501c && this.f18502d == mqttConnectRestrictions.f18502d && this.f18503e == mqttConnectRestrictions.f18503e && this.f18504f == mqttConnectRestrictions.f18504f && this.f18505g == mqttConnectRestrictions.f18505g && this.f18506h == mqttConnectRestrictions.f18506h) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f18503e;
    }

    public boolean g() {
        return this.f18505g;
    }

    public boolean h() {
        return this.f18506h;
    }

    public int hashCode() {
        return (((((((((((((this.f18499a * 31) + this.f18500b) * 31) + this.f18501c) * 31) + this.f18502d) * 31) + this.f18503e) * 31) + this.f18504f) * 31) + a.a(this.f18505g)) * 31) + a.a(this.f18506h);
    }

    public String toString() {
        return "MqttConnectRestrictions{" + i() + '}';
    }
}
