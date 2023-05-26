package com.hivemq.client.internal.mqtt.message.connect;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.datatypes.MqttClientIdentifierImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.mqtt.message.auth.MqttEnhancedAuth;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.publish.MqttWillPublish;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.mqtt.mqtt5.auth.Mqtt5EnhancedAuthMechanism;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.connect.Mqtt5Connect;
import java.util.Objects;
import x0.a;

/* loaded from: classes3.dex */
public class MqttConnect extends MqttMessageWithUserProperties implements Mqtt5Connect {

    /* renamed from: i  reason: collision with root package name */
    public static final MqttConnect f18491i = new MqttConnect(60, true, 0, MqttConnectRestrictions.f18498i, null, null, null, MqttUserPropertiesImpl.f17992c);

    /* renamed from: c  reason: collision with root package name */
    private final int f18492c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f18493d;

    /* renamed from: e  reason: collision with root package name */
    private final long f18494e;

    /* renamed from: f  reason: collision with root package name */
    private final MqttConnectRestrictions f18495f;

    /* renamed from: g  reason: collision with root package name */
    private final MqttSimpleAuth f18496g;

    /* renamed from: h  reason: collision with root package name */
    private final Mqtt5EnhancedAuthMechanism f18497h;

    public MqttConnect(int i8, boolean z7, long j8, MqttConnectRestrictions mqttConnectRestrictions, MqttSimpleAuth mqttSimpleAuth, Mqtt5EnhancedAuthMechanism mqtt5EnhancedAuthMechanism, MqttWillPublish mqttWillPublish, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(mqttUserPropertiesImpl);
        this.f18492c = i8;
        this.f18493d = z7;
        this.f18494e = j8;
        this.f18495f = mqttConnectRestrictions;
        this.f18496g = mqttSimpleAuth;
        this.f18497h = mqtt5EnhancedAuthMechanism;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    public String e() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("keepAlive=");
        sb.append(this.f18492c);
        sb.append(", cleanStart=");
        sb.append(this.f18493d);
        sb.append(", sessionExpiryInterval=");
        sb.append(this.f18494e);
        if (this.f18495f == MqttConnectRestrictions.f18498i) {
            str = "";
        } else {
            str = ", restrictions=" + this.f18495f;
        }
        sb.append(str);
        if (this.f18496g == null) {
            str2 = "";
        } else {
            str2 = ", simpleAuth=" + this.f18496g;
        }
        sb.append(str2);
        if (this.f18497h == null) {
            str3 = "";
        } else {
            str3 = ", enhancedAuthMechanism=" + this.f18497h;
        }
        sb.append(str3);
        sb.append("");
        sb.append(StringUtil.a(", ", super.e()));
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttConnect)) {
            return false;
        }
        MqttConnect mqttConnect = (MqttConnect) obj;
        if (c(mqttConnect) && this.f18492c == mqttConnect.f18492c && this.f18493d == mqttConnect.f18493d && this.f18494e == mqttConnect.f18494e && this.f18495f.equals(mqttConnect.f18495f) && Objects.equals(this.f18496g, mqttConnect.f18496g) && Objects.equals(this.f18497h, mqttConnect.f18497h)) {
            return true;
        }
        return false;
    }

    public MqttStatefulConnect f(MqttClientIdentifierImpl mqttClientIdentifierImpl, MqttEnhancedAuth mqttEnhancedAuth) {
        return new MqttStatefulConnect(this, mqttClientIdentifierImpl, mqttEnhancedAuth);
    }

    public int g() {
        return this.f18492c;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public Mqtt5EnhancedAuthMechanism h() {
        return this.f18497h;
    }

    public int hashCode() {
        return (((((((((((((d() * 31) + this.f18492c) * 31) + e0.a.a(this.f18493d)) * 31) + i0.a.a(this.f18494e)) * 31) + this.f18495f.hashCode()) * 31) + Objects.hashCode(this.f18496g)) * 31) + Objects.hashCode(this.f18497h)) * 31) + 0;
    }

    public MqttSimpleAuth i() {
        return this.f18496g;
    }

    public MqttWillPublish j() {
        return null;
    }

    public MqttConnectRestrictions k() {
        return this.f18495f;
    }

    public long l() {
        return this.f18494e;
    }

    public boolean m() {
        return this.f18493d;
    }

    public MqttConnect n(MqttClientConfig mqttClientConfig) {
        MqttSimpleAuth mqttSimpleAuth;
        Mqtt5EnhancedAuthMechanism mqtt5EnhancedAuthMechanism;
        MqttClientConfig.ConnectDefaults f8 = mqttClientConfig.f();
        MqttSimpleAuth b8 = f8.b();
        Mqtt5EnhancedAuthMechanism a8 = f8.a();
        f8.c();
        if ((b8 != null && this.f18496g == null) || (a8 != null && this.f18497h == null)) {
            int i8 = this.f18492c;
            boolean z7 = this.f18493d;
            long j8 = this.f18494e;
            MqttConnectRestrictions mqttConnectRestrictions = this.f18495f;
            MqttSimpleAuth mqttSimpleAuth2 = this.f18496g;
            if (mqttSimpleAuth2 == null) {
                mqttSimpleAuth = b8;
            } else {
                mqttSimpleAuth = mqttSimpleAuth2;
            }
            Mqtt5EnhancedAuthMechanism mqtt5EnhancedAuthMechanism2 = this.f18497h;
            if (mqtt5EnhancedAuthMechanism2 == null) {
                mqtt5EnhancedAuthMechanism = a8;
            } else {
                mqtt5EnhancedAuthMechanism = mqtt5EnhancedAuthMechanism2;
            }
            return new MqttConnect(i8, z7, j8, mqttConnectRestrictions, mqttSimpleAuth, mqtt5EnhancedAuthMechanism, null, b());
        }
        return this;
    }

    public String toString() {
        return "MqttConnect{" + e() + '}';
    }
}
