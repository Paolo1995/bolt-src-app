package com.hivemq.client.internal.mqtt.message.auth.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class Mqtt3SimpleAuthView implements Mqtt3SimpleAuth {

    /* renamed from: a  reason: collision with root package name */
    private final MqttSimpleAuth f18488a;

    private Mqtt3SimpleAuthView(MqttSimpleAuth mqttSimpleAuth) {
        this.f18488a = mqttSimpleAuth;
    }

    private static MqttSimpleAuth a(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuffer byteBuffer) {
        return new MqttSimpleAuth(mqttUtf8StringImpl, byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mqtt3SimpleAuthView c(MqttUtf8StringImpl mqttUtf8StringImpl, ByteBuffer byteBuffer) {
        return new Mqtt3SimpleAuthView(a(mqttUtf8StringImpl, byteBuffer));
    }

    public static Mqtt3SimpleAuthView d(MqttSimpleAuth mqttSimpleAuth) {
        return new Mqtt3SimpleAuthView(mqttSimpleAuth);
    }

    public MqttSimpleAuth b() {
        return this.f18488a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3SimpleAuthView)) {
            return false;
        }
        return this.f18488a.equals(((Mqtt3SimpleAuthView) obj).f18488a);
    }

    public int hashCode() {
        return this.f18488a.hashCode();
    }

    public String toString() {
        return this.f18488a.toString();
    }
}
