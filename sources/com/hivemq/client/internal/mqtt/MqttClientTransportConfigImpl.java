package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.util.InetSocketAddressUtil;
import java.net.InetSocketAddress;
import java.util.Objects;

/* loaded from: classes3.dex */
public class MqttClientTransportConfigImpl {

    /* renamed from: g  reason: collision with root package name */
    public static final MqttClientTransportConfigImpl f17815g = new MqttClientTransportConfigImpl(InetSocketAddressUtil.a("localhost", 1883), null, null, null, null, 10000, 60000);

    /* renamed from: a  reason: collision with root package name */
    private final InetSocketAddress f17816a;

    /* renamed from: b  reason: collision with root package name */
    private final InetSocketAddress f17817b;

    /* renamed from: c  reason: collision with root package name */
    private final MqttClientSslConfigImpl f17818c;

    /* renamed from: d  reason: collision with root package name */
    private final MqttWebSocketConfigImpl f17819d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17820e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17821f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttClientTransportConfigImpl(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, MqttClientSslConfigImpl mqttClientSslConfigImpl, MqttWebSocketConfigImpl mqttWebSocketConfigImpl, MqttProxyConfigImpl mqttProxyConfigImpl, int i8, int i9) {
        this.f17816a = inetSocketAddress;
        this.f17817b = inetSocketAddress2;
        this.f17818c = mqttClientSslConfigImpl;
        this.f17819d = mqttWebSocketConfigImpl;
        this.f17820e = i8;
        this.f17821f = i9;
    }

    public int a() {
        return this.f17821f;
    }

    public InetSocketAddress b() {
        return this.f17817b;
    }

    public MqttProxyConfigImpl c() {
        return null;
    }

    public MqttClientSslConfigImpl d() {
        return this.f17818c;
    }

    public MqttWebSocketConfigImpl e() {
        return this.f17819d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttClientTransportConfigImpl)) {
            return false;
        }
        MqttClientTransportConfigImpl mqttClientTransportConfigImpl = (MqttClientTransportConfigImpl) obj;
        if (this.f17816a.equals(mqttClientTransportConfigImpl.f17816a) && Objects.equals(this.f17817b, mqttClientTransportConfigImpl.f17817b) && Objects.equals(this.f17818c, mqttClientTransportConfigImpl.f17818c) && Objects.equals(this.f17819d, mqttClientTransportConfigImpl.f17819d) && this.f17820e == mqttClientTransportConfigImpl.f17820e && this.f17821f == mqttClientTransportConfigImpl.f17821f) {
            return true;
        }
        return false;
    }

    public InetSocketAddress f() {
        return this.f17816a;
    }

    public InetSocketAddress g() {
        return this.f17816a;
    }

    public int h() {
        return this.f17820e;
    }

    public int hashCode() {
        return (((((((((((this.f17816a.hashCode() * 31) + Objects.hashCode(this.f17817b)) * 31) + Objects.hashCode(this.f17818c)) * 31) + Objects.hashCode(this.f17819d)) * 31) + 0) * 31) + this.f17820e) * 31) + this.f17821f;
    }
}
