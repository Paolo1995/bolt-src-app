package com.hivemq.client.internal.mqtt.message.auth;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5Auth;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5AuthReasonCode;
import java.nio.ByteBuffer;
import java.util.Objects;
import w0.a;

/* loaded from: classes3.dex */
public class MqttAuth extends MqttMessageWithUserProperties.WithReason.WithCode<Mqtt5AuthReasonCode> implements Mqtt5Auth {

    /* renamed from: e  reason: collision with root package name */
    private final MqttUtf8StringImpl f18475e;

    /* renamed from: f  reason: collision with root package name */
    private final ByteBuffer f18476f;

    public MqttAuth(Mqtt5AuthReasonCode mqtt5AuthReasonCode, MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuffer byteBuffer, MqttUtf8StringImpl mqttUtf8StringImpl2, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(mqtt5AuthReasonCode, mqttUtf8StringImpl2, mqttUserPropertiesImpl);
        this.f18475e = mqttUtf8StringImpl;
        this.f18476f = byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    public String e() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("reasonCode= ");
        sb.append(h());
        sb.append(", method=");
        sb.append(this.f18475e);
        if (this.f18476f == null) {
            str = "";
        } else {
            str = ", data=" + this.f18476f.remaining() + "byte";
        }
        sb.append(str);
        sb.append(StringUtil.a(", ", super.e()));
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttAuth)) {
            return false;
        }
        MqttAuth mqttAuth = (MqttAuth) obj;
        if (i(mqttAuth) && this.f18475e.equals(mqttAuth.f18475e) && Objects.equals(this.f18476f, mqttAuth.f18476f)) {
            return true;
        }
        return false;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return (((d() * 31) + this.f18475e.hashCode()) * 31) + Objects.hashCode(this.f18476f);
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5EnhancedAuth
    /* renamed from: j */
    public MqttUtf8StringImpl getMethod() {
        return this.f18475e;
    }

    public ByteBuffer k() {
        return this.f18476f;
    }

    public String toString() {
        return "MqttAuth{" + e() + '}';
    }
}
