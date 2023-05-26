package com.hivemq.client.internal.mqtt.message.auth;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5AuthBuilder;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5AuthReasonCode;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class MqttAuthBuilder implements Mqtt5AuthBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final MqttUtf8StringImpl f18477a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f18478b;

    /* renamed from: c  reason: collision with root package name */
    private final Mqtt5AuthReasonCode f18479c;

    /* renamed from: d  reason: collision with root package name */
    private MqttUtf8StringImpl f18480d;

    /* renamed from: e  reason: collision with root package name */
    private MqttUserPropertiesImpl f18481e = MqttUserPropertiesImpl.f17992c;

    public MqttAuthBuilder(Mqtt5AuthReasonCode mqtt5AuthReasonCode, MqttUtf8StringImpl mqttUtf8StringImpl) {
        Checks.j(mqtt5AuthReasonCode, "Reason code");
        Checks.j(mqttUtf8StringImpl, "Method");
        this.f18479c = mqtt5AuthReasonCode;
        this.f18477a = mqttUtf8StringImpl;
    }

    public MqttAuth a() {
        return new MqttAuth(this.f18479c, this.f18477a, this.f18478b, this.f18480d, this.f18481e);
    }
}
