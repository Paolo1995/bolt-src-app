package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttTopicAliasAutoMapping;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttTopicAliasMapping;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.auth.Mqtt5EnhancedAuthMechanism;
import io.netty.channel.Channel;
import j$.util.Spliterator;

/* loaded from: classes3.dex */
public class MqttClientConnectionConfig {

    /* renamed from: a  reason: collision with root package name */
    private final MqttClientTransportConfigImpl f17784a;

    /* renamed from: b  reason: collision with root package name */
    private final short f17785b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f17786c;

    /* renamed from: d  reason: collision with root package name */
    private final Mqtt5EnhancedAuthMechanism f17787d;

    /* renamed from: e  reason: collision with root package name */
    private final short f17788e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17789f;

    /* renamed from: g  reason: collision with root package name */
    private final short f17790g;

    /* renamed from: h  reason: collision with root package name */
    private final short f17791h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17792i;

    /* renamed from: j  reason: collision with root package name */
    private final MqttTopicAliasMapping f17793j;

    /* renamed from: k  reason: collision with root package name */
    private final MqttQos f17794k;

    /* renamed from: l  reason: collision with root package name */
    private final Channel f17795l;

    /* renamed from: m  reason: collision with root package name */
    private final int f17796m;

    public MqttClientConnectionConfig(MqttClientTransportConfigImpl mqttClientTransportConfigImpl, int i8, boolean z7, boolean z8, long j8, boolean z9, boolean z10, Mqtt5EnhancedAuthMechanism mqtt5EnhancedAuthMechanism, int i9, int i10, int i11, boolean z11, boolean z12, int i12, int i13, int i14, MqttQos mqttQos, boolean z13, boolean z14, boolean z15, boolean z16, Channel channel) {
        MqttTopicAliasAutoMapping mqttTopicAliasAutoMapping;
        int i15;
        this.f17784a = mqttClientTransportConfigImpl;
        this.f17785b = (short) i8;
        this.f17786c = (int) j8;
        this.f17787d = mqtt5EnhancedAuthMechanism;
        this.f17788e = (short) i9;
        this.f17789f = i10;
        this.f17790g = (short) i11;
        this.f17791h = (short) i12;
        this.f17792i = i13;
        if (i14 == 0) {
            mqttTopicAliasAutoMapping = null;
        } else {
            mqttTopicAliasAutoMapping = new MqttTopicAliasAutoMapping(i14);
        }
        this.f17793j = mqttTopicAliasAutoMapping;
        this.f17794k = mqttQos;
        this.f17795l = channel;
        if (z10) {
            i15 = (z9 ? 1 : 0) | 2;
        } else {
            i15 = z9 ? 1 : 0;
        }
        i15 = z11 ? i15 | 4 : i15;
        i15 = z12 ? i15 | 8 : i15;
        i15 = z13 ? i15 | 16 : i15;
        i15 = z14 ? i15 | 32 : i15;
        i15 = z15 ? i15 | 64 : i15;
        i15 = z16 ? i15 | 128 : i15;
        i15 = z7 ? i15 | Spliterator.NONNULL : i15;
        this.f17796m = z8 ? i15 | 512 : i15;
    }

    public boolean a() {
        if ((this.f17796m & 128) != 0) {
            return true;
        }
        return false;
    }

    public Channel b() {
        return this.f17795l;
    }

    public int c() {
        return this.f17785b & 65535;
    }

    public int d() {
        return this.f17789f;
    }

    public Mqtt5EnhancedAuthMechanism e() {
        return this.f17787d;
    }

    public int f() {
        return this.f17788e & 65535;
    }

    public int g() {
        return this.f17791h & 65535;
    }

    public int h() {
        return this.f17792i;
    }

    public MqttTopicAliasMapping i() {
        return this.f17793j;
    }

    public int j() {
        MqttTopicAliasMapping mqttTopicAliasMapping = this.f17793j;
        if (mqttTopicAliasMapping == null) {
            return 0;
        }
        return mqttTopicAliasMapping.a();
    }

    public long k() {
        return this.f17786c & 4294967295L;
    }

    public int l() {
        return this.f17790g & 65535;
    }

    public boolean m() {
        if ((this.f17796m & 512) != 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if ((this.f17796m & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if ((this.f17796m & 8) != 0) {
            return true;
        }
        return false;
    }

    public void p(long j8) {
        this.f17786c = (int) j8;
    }
}
