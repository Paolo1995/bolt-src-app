package com.hivemq.client.internal.mqtt.message.auth;

import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5EnhancedAuth;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes3.dex */
public class MqttEnhancedAuth implements Mqtt5EnhancedAuth {

    /* renamed from: b  reason: collision with root package name */
    private final MqttUtf8StringImpl f18482b;

    /* renamed from: c  reason: collision with root package name */
    private final ByteBuffer f18483c;

    public MqttEnhancedAuth(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuffer byteBuffer) {
        this.f18482b = mqttUtf8StringImpl;
        this.f18483c = byteBuffer;
    }

    private String c() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("method=");
        sb.append(this.f18482b);
        if (this.f18483c == null) {
            str = "";
        } else {
            str = ", data=" + this.f18483c.remaining() + "byte";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5EnhancedAuth
    /* renamed from: a */
    public MqttUtf8StringImpl getMethod() {
        return this.f18482b;
    }

    public ByteBuffer b() {
        return this.f18483c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttEnhancedAuth)) {
            return false;
        }
        MqttEnhancedAuth mqttEnhancedAuth = (MqttEnhancedAuth) obj;
        if (this.f18482b.equals(mqttEnhancedAuth.f18482b) && Objects.equals(this.f18483c, mqttEnhancedAuth.f18483c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f18482b.hashCode() * 31) + Objects.hashCode(this.f18483c);
    }

    public String toString() {
        return "MqttEnhancedAuth{" + c() + '}';
    }
}
