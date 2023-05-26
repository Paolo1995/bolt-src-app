package com.hivemq.client.internal.mqtt.message.connect.connack;

import com.hivemq.client.internal.mqtt.datatypes.MqttClientIdentifierImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5EnhancedAuth;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAckReasonCode;
import java.util.Objects;
import y0.a;

/* loaded from: classes3.dex */
public class MqttConnAck extends MqttMessageWithUserProperties.WithReason.WithCode<Mqtt5ConnAckReasonCode> implements Mqtt5ConnAck {

    /* renamed from: e  reason: collision with root package name */
    private final boolean f18509e;

    /* renamed from: f  reason: collision with root package name */
    private final long f18510f;

    /* renamed from: g  reason: collision with root package name */
    private final int f18511g;

    /* renamed from: h  reason: collision with root package name */
    private final MqttClientIdentifierImpl f18512h;

    /* renamed from: i  reason: collision with root package name */
    private final Mqtt5EnhancedAuth f18513i;

    /* renamed from: j  reason: collision with root package name */
    private final MqttConnAckRestrictions f18514j;

    /* renamed from: k  reason: collision with root package name */
    private final MqttUtf8StringImpl f18515k;

    /* renamed from: l  reason: collision with root package name */
    private final MqttUtf8StringImpl f18516l;

    public MqttConnAck(Mqtt5ConnAckReasonCode mqtt5ConnAckReasonCode, boolean z7, long j8, int i8, MqttClientIdentifierImpl mqttClientIdentifierImpl, Mqtt5EnhancedAuth mqtt5EnhancedAuth, MqttConnAckRestrictions mqttConnAckRestrictions, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUtf8StringImpl mqttUtf8StringImpl2, MqttUtf8StringImpl mqttUtf8StringImpl3, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(mqtt5ConnAckReasonCode, mqttUtf8StringImpl3, mqttUserPropertiesImpl);
        this.f18509e = z7;
        this.f18510f = j8;
        this.f18511g = i8;
        this.f18512h = mqttClientIdentifierImpl;
        this.f18513i = mqtt5EnhancedAuth;
        this.f18514j = mqttConnAckRestrictions;
        this.f18515k = mqttUtf8StringImpl;
        this.f18516l = mqttUtf8StringImpl2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    public String e() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        StringBuilder sb = new StringBuilder();
        sb.append("reasonCode=");
        sb.append(h());
        sb.append(", sessionPresent=");
        sb.append(this.f18509e);
        String str7 = "";
        if (this.f18510f == -1) {
            str = "";
        } else {
            str = ", sessionExpiryInterval=" + this.f18510f;
        }
        sb.append(str);
        if (this.f18511g == -1) {
            str2 = "";
        } else {
            str2 = ", serverKeepAlive=" + this.f18511g;
        }
        sb.append(str2);
        if (this.f18512h == null) {
            str3 = "";
        } else {
            str3 = ", assignedClientIdentifier=" + this.f18512h;
        }
        sb.append(str3);
        if (this.f18513i == null) {
            str4 = "";
        } else {
            str4 = ", enhancedAuth=" + this.f18513i;
        }
        sb.append(str4);
        if (this.f18514j == MqttConnAckRestrictions.f18517j) {
            str5 = "";
        } else {
            str5 = ", restrictions=" + this.f18514j;
        }
        sb.append(str5);
        if (this.f18515k == null) {
            str6 = "";
        } else {
            str6 = ", responseInformation=" + this.f18515k;
        }
        sb.append(str6);
        if (this.f18516l != null) {
            str7 = ", serverReference=" + this.f18516l;
        }
        sb.append(str7);
        sb.append(StringUtil.a(", ", super.e()));
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttConnAck)) {
            return false;
        }
        MqttConnAck mqttConnAck = (MqttConnAck) obj;
        if (i(mqttConnAck) && this.f18509e == mqttConnAck.f18509e && this.f18510f == mqttConnAck.f18510f && this.f18511g == mqttConnAck.f18511g && Objects.equals(this.f18512h, mqttConnAck.f18512h) && Objects.equals(this.f18513i, mqttConnAck.f18513i) && this.f18514j.equals(mqttConnAck.f18514j) && Objects.equals(this.f18515k, mqttConnAck.f18515k) && Objects.equals(this.f18516l, mqttConnAck.f18516l)) {
            return true;
        }
        return false;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return (((((((((((((((d() * 31) + e0.a.a(this.f18509e)) * 31) + i0.a.a(this.f18510f)) * 31) + this.f18511g) * 31) + Objects.hashCode(this.f18512h)) * 31) + Objects.hashCode(this.f18513i)) * 31) + this.f18514j.hashCode()) * 31) + Objects.hashCode(this.f18515k)) * 31) + Objects.hashCode(this.f18516l);
    }

    public MqttClientIdentifierImpl j() {
        return this.f18512h;
    }

    public Mqtt5EnhancedAuth k() {
        return this.f18513i;
    }

    public int l() {
        return this.f18511g;
    }

    public long m() {
        return this.f18510f;
    }

    public MqttConnAckRestrictions n() {
        return this.f18514j;
    }

    public boolean o() {
        return this.f18509e;
    }

    public String toString() {
        return "MqttConnAck{" + e() + '}';
    }
}
