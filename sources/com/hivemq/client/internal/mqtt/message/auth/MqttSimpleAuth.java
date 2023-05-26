package com.hivemq.client.internal.mqtt.message.auth;

import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes3.dex */
public class MqttSimpleAuth {

    /* renamed from: a  reason: collision with root package name */
    private final MqttUtf8StringImpl f18486a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteBuffer f18487b;

    public MqttSimpleAuth(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuffer byteBuffer) {
        this.f18486a = mqttUtf8StringImpl;
        this.f18487b = byteBuffer;
    }

    private String c() {
        if (this.f18486a == null) {
            if (this.f18487b == null) {
                return "";
            }
            return "password";
        } else if (this.f18487b == null) {
            return "username";
        } else {
            return "username and password";
        }
    }

    public ByteBuffer a() {
        return this.f18487b;
    }

    public MqttUtf8StringImpl b() {
        return this.f18486a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttSimpleAuth)) {
            return false;
        }
        MqttSimpleAuth mqttSimpleAuth = (MqttSimpleAuth) obj;
        if (Objects.equals(this.f18486a, mqttSimpleAuth.f18486a) && Objects.equals(this.f18487b, mqttSimpleAuth.f18487b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hashCode(this.f18486a) * 31) + Objects.hashCode(this.f18487b);
    }

    public String toString() {
        return "MqttSimpleAuth{" + c() + '}';
    }
}
