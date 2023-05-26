package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.mqtt.advanced.MqttClientAdvancedConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttClientIdentifierImpl;
import com.hivemq.client.internal.mqtt.ioc.ClientComponent;
import com.hivemq.client.internal.mqtt.ioc.SingletonComponent;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.publish.MqttWillPublish;
import com.hivemq.client.internal.netty.NettyEventLoopProvider;
import com.hivemq.client.internal.util.ExecutorUtil;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.MqttVersion;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener;
import com.hivemq.client.mqtt.mqtt5.Mqtt5ClientConfig;
import com.hivemq.client.mqtt.mqtt5.auth.Mqtt5EnhancedAuthMechanism;
import io.netty.channel.EventLoop;
import io.netty.handler.ssl.SslContext;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public class MqttClientConfig implements Mqtt5ClientConfig {

    /* renamed from: a  reason: collision with root package name */
    private final MqttVersion f17763a;

    /* renamed from: b  reason: collision with root package name */
    private volatile MqttClientIdentifierImpl f17764b;

    /* renamed from: c  reason: collision with root package name */
    private final MqttClientTransportConfigImpl f17765c;

    /* renamed from: d  reason: collision with root package name */
    private final MqttClientExecutorConfigImpl f17766d;

    /* renamed from: e  reason: collision with root package name */
    private final MqttClientAdvancedConfig f17767e;

    /* renamed from: f  reason: collision with root package name */
    private final ConnectDefaults f17768f;

    /* renamed from: g  reason: collision with root package name */
    private final ImmutableList<MqttClientConnectedListener> f17769g;

    /* renamed from: h  reason: collision with root package name */
    private final ImmutableList<MqttClientDisconnectedListener> f17770h;

    /* renamed from: j  reason: collision with root package name */
    private volatile EventLoop f17772j;

    /* renamed from: k  reason: collision with root package name */
    private int f17773k;

    /* renamed from: l  reason: collision with root package name */
    private long f17774l;

    /* renamed from: n  reason: collision with root package name */
    private volatile MqttClientConnectionConfig f17776n;

    /* renamed from: o  reason: collision with root package name */
    private MqttClientTransportConfigImpl f17777o;

    /* renamed from: p  reason: collision with root package name */
    private SslContext f17778p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f17779q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f17780r;

    /* renamed from: i  reason: collision with root package name */
    private final ClientComponent f17771i = SingletonComponent.f18420a.a().a(this).build();

    /* renamed from: m  reason: collision with root package name */
    private final AtomicReference<MqttClientState> f17775m = new AtomicReference<>(MqttClientState.DISCONNECTED);

    /* loaded from: classes3.dex */
    public static class ConnectDefaults {

        /* renamed from: c  reason: collision with root package name */
        private static final ConnectDefaults f17781c = new ConnectDefaults(null, null, null);

        /* renamed from: a  reason: collision with root package name */
        final MqttSimpleAuth f17782a;

        /* renamed from: b  reason: collision with root package name */
        final Mqtt5EnhancedAuthMechanism f17783b;

        private ConnectDefaults(MqttSimpleAuth mqttSimpleAuth, Mqtt5EnhancedAuthMechanism mqtt5EnhancedAuthMechanism, MqttWillPublish mqttWillPublish) {
            this.f17782a = mqttSimpleAuth;
            this.f17783b = mqtt5EnhancedAuthMechanism;
        }

        public static ConnectDefaults d(MqttSimpleAuth mqttSimpleAuth, Mqtt5EnhancedAuthMechanism mqtt5EnhancedAuthMechanism, MqttWillPublish mqttWillPublish) {
            if (mqttSimpleAuth == null && mqtt5EnhancedAuthMechanism == null) {
                return f17781c;
            }
            return new ConnectDefaults(mqttSimpleAuth, mqtt5EnhancedAuthMechanism, mqttWillPublish);
        }

        public Mqtt5EnhancedAuthMechanism a() {
            return this.f17783b;
        }

        public MqttSimpleAuth b() {
            return this.f17782a;
        }

        public MqttWillPublish c() {
            return null;
        }
    }

    public MqttClientConfig(MqttVersion mqttVersion, MqttClientIdentifierImpl mqttClientIdentifierImpl, MqttClientTransportConfigImpl mqttClientTransportConfigImpl, MqttClientExecutorConfigImpl mqttClientExecutorConfigImpl, MqttClientAdvancedConfig mqttClientAdvancedConfig, ConnectDefaults connectDefaults, ImmutableList<MqttClientConnectedListener> immutableList, ImmutableList<MqttClientDisconnectedListener> immutableList2) {
        this.f17763a = mqttVersion;
        this.f17764b = mqttClientIdentifierImpl;
        this.f17765c = mqttClientTransportConfigImpl;
        this.f17766d = mqttClientExecutorConfigImpl;
        this.f17767e = mqttClientAdvancedConfig;
        this.f17768f = connectDefaults;
        this.f17769g = immutableList;
        this.f17770h = immutableList2;
        this.f17777o = mqttClientTransportConfigImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(long j8) {
        synchronized (this.f17775m) {
            if (j8 == this.f17774l) {
                this.f17772j = null;
                NettyEventLoopProvider.f18635e.e(this.f17766d.b());
            }
        }
    }

    public EventLoop b() {
        EventLoop eventLoop;
        synchronized (this.f17775m) {
            this.f17773k++;
            this.f17774l++;
            eventLoop = this.f17772j;
            if (eventLoop == null) {
                eventLoop = NettyEventLoopProvider.f18635e.b(this.f17766d.b(), this.f17766d.c());
                this.f17772j = eventLoop;
            }
        }
        return eventLoop;
    }

    public boolean c(Runnable runnable) {
        EventLoop eventLoop = this.f17772j;
        if (eventLoop == null) {
            return false;
        }
        return ExecutorUtil.a(eventLoop, runnable);
    }

    public MqttClientAdvancedConfig d() {
        return this.f17767e;
    }

    public ClientComponent e() {
        return this.f17771i;
    }

    public ConnectDefaults f() {
        return this.f17768f;
    }

    public ImmutableList<MqttClientConnectedListener> g() {
        return this.f17769g;
    }

    @Override // com.hivemq.client.mqtt.MqttClientConfig
    public MqttClientState getState() {
        return this.f17775m.get();
    }

    public SslContext h() {
        return this.f17778p;
    }

    public MqttClientTransportConfigImpl i() {
        return this.f17777o;
    }

    public ImmutableList<MqttClientDisconnectedListener> j() {
        return this.f17770h;
    }

    public MqttClientExecutorConfigImpl k() {
        return this.f17766d;
    }

    public MqttVersion l() {
        return this.f17763a;
    }

    public MqttClientIdentifierImpl m() {
        return this.f17764b;
    }

    public MqttClientConnectionConfig n() {
        return this.f17776n;
    }

    public AtomicReference<MqttClientState> o() {
        return this.f17775m;
    }

    public boolean p() {
        return this.f17780r;
    }

    public boolean q() {
        return this.f17779q;
    }

    public void s() {
        synchronized (this.f17775m) {
            int i8 = this.f17773k - 1;
            this.f17773k = i8;
            if (i8 == 0) {
                EventLoop eventLoop = this.f17772j;
                final long j8 = this.f17774l;
                eventLoop.execute(new Runnable() { // from class: com.hivemq.client.internal.mqtt.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        MqttClientConfig.this.r(j8);
                    }
                });
            }
        }
    }

    public void t(MqttClientIdentifierImpl mqttClientIdentifierImpl) {
        this.f17764b = mqttClientIdentifierImpl;
    }

    public void u(MqttClientConnectionConfig mqttClientConnectionConfig) {
        this.f17776n = mqttClientConnectionConfig;
    }

    public void v(SslContext sslContext) {
        this.f17778p = sslContext;
    }

    public void w(MqttClientTransportConfigImpl mqttClientTransportConfigImpl) {
        if (!this.f17777o.equals(mqttClientTransportConfigImpl)) {
            this.f17777o = mqttClientTransportConfigImpl;
            this.f17778p = null;
        }
    }

    public void x(boolean z7) {
        this.f17780r = z7;
    }

    public void y(boolean z7) {
        this.f17779q = z7;
    }
}
