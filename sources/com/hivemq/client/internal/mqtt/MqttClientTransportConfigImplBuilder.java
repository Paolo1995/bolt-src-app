package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.mqtt.MqttClientTransportConfigImplBuilder;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.internal.util.InetSocketAddressUtil;
import com.hivemq.client.mqtt.MqttClientSslConfig;
import com.hivemq.client.mqtt.MqttWebSocketConfig;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* loaded from: classes3.dex */
public abstract class MqttClientTransportConfigImplBuilder<B extends MqttClientTransportConfigImplBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private InetSocketAddress f17822a;

    /* renamed from: d  reason: collision with root package name */
    private InetSocketAddress f17825d;

    /* renamed from: e  reason: collision with root package name */
    private MqttClientSslConfigImpl f17826e;

    /* renamed from: f  reason: collision with root package name */
    private MqttWebSocketConfigImpl f17827f;

    /* renamed from: b  reason: collision with root package name */
    private Object f17823b = "localhost";

    /* renamed from: c  reason: collision with root package name */
    private int f17824c = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f17828g = 10000;

    /* renamed from: h  reason: collision with root package name */
    private int f17829h = 60000;

    private InetSocketAddress l() {
        InetSocketAddress inetSocketAddress = this.f17822a;
        if (inetSocketAddress != null) {
            return inetSocketAddress;
        }
        Object obj = this.f17823b;
        if (obj instanceof InetAddress) {
            return new InetSocketAddress((InetAddress) this.f17823b, m());
        }
        return InetSocketAddressUtil.a((String) obj, m());
    }

    private int m() {
        int i8 = this.f17824c;
        if (i8 != -1) {
            return i8;
        }
        if (this.f17826e == null) {
            if (this.f17827f == null) {
                return 1883;
            }
            return 80;
        } else if (this.f17827f == null) {
            return 8883;
        } else {
            return 443;
        }
    }

    private void q(Object obj) {
        this.f17823b = obj;
        InetSocketAddress inetSocketAddress = this.f17822a;
        if (inetSocketAddress != null) {
            this.f17824c = inetSocketAddress.getPort();
            this.f17822a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttClientTransportConfigImpl k() {
        return new MqttClientTransportConfigImpl(l(), this.f17825d, this.f17826e, this.f17827f, null, this.f17828g, this.f17829h);
    }

    abstract B n();

    public B o(String str) {
        q(Checks.f(str, "Server host"));
        return n();
    }

    public B p(int i8) {
        this.f17824c = Checks.n(i8, "Server port");
        InetSocketAddress inetSocketAddress = this.f17822a;
        if (inetSocketAddress != null) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                this.f17823b = address;
            } else {
                this.f17823b = this.f17822a.getHostString();
            }
            this.f17822a = null;
        }
        return n();
    }

    public B r(MqttClientSslConfig mqttClientSslConfig) {
        this.f17826e = (MqttClientSslConfigImpl) Checks.i(mqttClientSslConfig, MqttClientSslConfigImpl.class, "SSL config");
        return n();
    }

    public B s() {
        this.f17826e = MqttClientSslConfigImpl.f17802h;
        return n();
    }

    public B t(MqttWebSocketConfig mqttWebSocketConfig) {
        this.f17827f = (MqttWebSocketConfigImpl) Checks.i(mqttWebSocketConfig, MqttWebSocketConfigImpl.class, "WebSocket config");
        return n();
    }
}
