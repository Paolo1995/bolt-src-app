package com.hivemq.client.internal.mqtt.message.disconnect;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnectBuilder;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import java.util.Objects;
import z0.a;

/* loaded from: classes3.dex */
public class MqttDisconnect extends MqttMessageWithUserProperties.WithReason.WithCode<Mqtt5DisconnectReasonCode> implements Mqtt5Disconnect {

    /* renamed from: g  reason: collision with root package name */
    public static final MqttDisconnect f18537g = new MqttDisconnect(Mqtt5Disconnect.f18845a, -1, null, null, MqttUserPropertiesImpl.f17992c);

    /* renamed from: e  reason: collision with root package name */
    private final long f18538e;

    /* renamed from: f  reason: collision with root package name */
    private final MqttUtf8StringImpl f18539f;

    public MqttDisconnect(Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode, long j8, MqttUtf8StringImpl mqttUtf8StringImpl, MqttUtf8StringImpl mqttUtf8StringImpl2, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(mqtt5DisconnectReasonCode, mqttUtf8StringImpl2, mqttUserPropertiesImpl);
        this.f18538e = j8;
        this.f18539f = mqttUtf8StringImpl;
    }

    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties.WithReason, com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    protected String e() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("reasonCode=");
        sb.append(h());
        String str2 = "";
        if (this.f18538e == -1) {
            str = "";
        } else {
            str = ", sessionExpiryInterval=" + this.f18538e;
        }
        sb.append(str);
        if (this.f18539f != null) {
            str2 = ", serverReference=" + this.f18539f;
        }
        sb.append(str2);
        sb.append(StringUtil.a(", ", super.e()));
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttDisconnect)) {
            return false;
        }
        MqttDisconnect mqttDisconnect = (MqttDisconnect) obj;
        if (i(mqttDisconnect) && this.f18538e == mqttDisconnect.f18538e && Objects.equals(this.f18539f, mqttDisconnect.f18539f)) {
            return true;
        }
        return false;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return (((d() * 31) + i0.a.a(this.f18538e)) * 31) + Objects.hashCode(this.f18539f);
    }

    public MqttDisconnectBuilder.Default j() {
        return new MqttDisconnectBuilder.Default(this);
    }

    public MqttUtf8StringImpl k() {
        return this.f18539f;
    }

    public long l() {
        return this.f18538e;
    }

    public String toString() {
        return "MqttDisconnect{" + e() + '}';
    }
}
