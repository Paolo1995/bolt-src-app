package com.hivemq.client.internal.mqtt.message.connect.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.internal.mqtt.message.auth.mqtt3.Mqtt3SimpleAuthView;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnectRestrictions;
import com.hivemq.client.internal.mqtt.message.publish.MqttWillPublish;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3Connect;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectRestrictions;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;

/* loaded from: classes3.dex */
public class Mqtt3ConnectView implements Mqtt3Connect {

    /* renamed from: b  reason: collision with root package name */
    public static final Mqtt3ConnectView f18530b = h(60, true, MqttConnectRestrictions.f18498i, null, null);

    /* renamed from: a  reason: collision with root package name */
    private final MqttConnect f18531a;

    private Mqtt3ConnectView(MqttConnect mqttConnect) {
        this.f18531a = mqttConnect;
    }

    private static MqttConnect a(int i8, boolean z7, MqttConnectRestrictions mqttConnectRestrictions, MqttSimpleAuth mqttSimpleAuth, MqttWillPublish mqttWillPublish) {
        long j8;
        if (z7) {
            j8 = 0;
        } else {
            j8 = 4294967295L;
        }
        return new MqttConnect(i8, z7, j8, mqttConnectRestrictions, mqttSimpleAuth, null, mqttWillPublish, MqttUserPropertiesImpl.f17992c);
    }

    private Mqtt3SimpleAuth d() {
        MqttSimpleAuth i8 = this.f18531a.i();
        if (i8 == null) {
            return null;
        }
        return Mqtt3SimpleAuthView.d(i8);
    }

    private Mqtt3Publish e() {
        this.f18531a.j();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mqtt3ConnectView h(int i8, boolean z7, MqttConnectRestrictions mqttConnectRestrictions, MqttSimpleAuth mqttSimpleAuth, MqttWillPublish mqttWillPublish) {
        return new Mqtt3ConnectView(a(i8, z7, mqttConnectRestrictions, mqttSimpleAuth, mqttWillPublish));
    }

    public static Mqtt3ConnectView i(MqttConnect mqttConnect) {
        return new Mqtt3ConnectView(mqttConnect);
    }

    private String j() {
        String str;
        Mqtt3SimpleAuth d8 = d();
        Mqtt3Publish e8 = e();
        Mqtt3ConnectRestrictions f8 = f();
        StringBuilder sb = new StringBuilder();
        sb.append("keepAlive=");
        sb.append(c());
        sb.append(", cleanSession=");
        sb.append(g());
        sb.append(", restrictions=");
        sb.append(f8);
        String str2 = "";
        if (d8 == null) {
            str = "";
        } else {
            str = ", simpleAuth=" + d8;
        }
        sb.append(str);
        if (e8 != null) {
            str2 = ", willPublish=" + e8;
        }
        sb.append(str2);
        return sb.toString();
    }

    public MqttConnect b() {
        return this.f18531a;
    }

    public int c() {
        return this.f18531a.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3ConnectView)) {
            return false;
        }
        return this.f18531a.equals(((Mqtt3ConnectView) obj).f18531a);
    }

    public Mqtt3ConnectRestrictions f() {
        return this.f18531a.k();
    }

    public boolean g() {
        return this.f18531a.m();
    }

    public int hashCode() {
        return this.f18531a.hashCode();
    }

    public String toString() {
        return "MqttConnect{" + j() + '}';
    }
}
