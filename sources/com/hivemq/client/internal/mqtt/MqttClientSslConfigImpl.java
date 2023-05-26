package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.MqttClientSslConfig;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes3.dex */
public class MqttClientSslConfigImpl implements MqttClientSslConfig {

    /* renamed from: g  reason: collision with root package name */
    static final HostnameVerifier f17801g;

    /* renamed from: h  reason: collision with root package name */
    static final MqttClientSslConfigImpl f17802h;

    /* renamed from: a  reason: collision with root package name */
    private final KeyManagerFactory f17803a;

    /* renamed from: b  reason: collision with root package name */
    private final TrustManagerFactory f17804b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<String> f17805c;

    /* renamed from: d  reason: collision with root package name */
    private final ImmutableList<String> f17806d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17807e;

    /* renamed from: f  reason: collision with root package name */
    private final HostnameVerifier f17808f;

    static {
        HostnameVerifier defaultHostnameVerifier;
        try {
            new SSLParameters().setEndpointIdentificationAlgorithm("HTTPS");
            defaultHostnameVerifier = null;
        } catch (NoSuchMethodError unused) {
            defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        }
        HostnameVerifier hostnameVerifier = defaultHostnameVerifier;
        f17801g = hostnameVerifier;
        f17802h = new MqttClientSslConfigImpl(null, null, null, null, 10000, hostnameVerifier);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttClientSslConfigImpl(KeyManagerFactory keyManagerFactory, TrustManagerFactory trustManagerFactory, ImmutableList<String> immutableList, ImmutableList<String> immutableList2, int i8, HostnameVerifier hostnameVerifier) {
        this.f17803a = keyManagerFactory;
        this.f17804b = trustManagerFactory;
        this.f17805c = immutableList;
        this.f17806d = immutableList2;
        this.f17807e = i8;
        this.f17808f = hostnameVerifier;
    }

    public long a() {
        return this.f17807e;
    }

    public ImmutableList<String> b() {
        return this.f17805c;
    }

    public HostnameVerifier c() {
        return this.f17808f;
    }

    public KeyManagerFactory d() {
        return this.f17803a;
    }

    public ImmutableList<String> e() {
        return this.f17806d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttClientSslConfigImpl)) {
            return false;
        }
        MqttClientSslConfigImpl mqttClientSslConfigImpl = (MqttClientSslConfigImpl) obj;
        if (Objects.equals(this.f17803a, mqttClientSslConfigImpl.f17803a) && Objects.equals(this.f17804b, mqttClientSslConfigImpl.f17804b) && Objects.equals(this.f17805c, mqttClientSslConfigImpl.f17805c) && Objects.equals(this.f17806d, mqttClientSslConfigImpl.f17806d) && this.f17807e == mqttClientSslConfigImpl.f17807e && Objects.equals(this.f17808f, mqttClientSslConfigImpl.f17808f)) {
            return true;
        }
        return false;
    }

    public TrustManagerFactory f() {
        return this.f17804b;
    }

    public int hashCode() {
        return (((((((((Objects.hashCode(this.f17803a) * 31) + Objects.hashCode(this.f17804b)) * 31) + Objects.hashCode(this.f17805c)) * 31) + Objects.hashCode(this.f17806d)) * 31) + this.f17807e) * 31) + Objects.hashCode(this.f17808f);
    }
}
