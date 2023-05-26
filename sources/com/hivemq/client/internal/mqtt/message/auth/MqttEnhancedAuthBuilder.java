package com.hivemq.client.internal.mqtt.message.auth;

import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5EnhancedAuthBuilder;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class MqttEnhancedAuthBuilder implements Mqtt5EnhancedAuthBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final MqttUtf8StringImpl f18484a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f18485b;

    public MqttEnhancedAuthBuilder(MqttUtf8StringImpl mqttUtf8StringImpl) {
        Checks.j(mqttUtf8StringImpl, "Method");
        this.f18484a = mqttUtf8StringImpl;
    }

    public MqttEnhancedAuth a() {
        return new MqttEnhancedAuth(this.f18484a, this.f18485b);
    }
}
