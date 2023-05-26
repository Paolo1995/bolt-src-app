package com.hivemq.client.internal.mqtt.message.disconnect;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUtf8StringImpl;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnectBuilder;
import com.hivemq.client.internal.mqtt.util.MqttChecks;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;

/* loaded from: classes3.dex */
public abstract class MqttDisconnectBuilder<B extends MqttDisconnectBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private Mqtt5DisconnectReasonCode f18540a;

    /* renamed from: b  reason: collision with root package name */
    private long f18541b;

    /* renamed from: c  reason: collision with root package name */
    private MqttUtf8StringImpl f18542c;

    /* renamed from: d  reason: collision with root package name */
    private MqttUtf8StringImpl f18543d;

    /* renamed from: e  reason: collision with root package name */
    private MqttUserPropertiesImpl f18544e;

    /* loaded from: classes3.dex */
    public static class Default extends MqttDisconnectBuilder<Default> {
        public Default() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnectBuilder
        /* renamed from: f */
        public Default d() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Default(MqttDisconnect mqttDisconnect) {
            super(mqttDisconnect);
        }
    }

    MqttDisconnectBuilder() {
        this.f18540a = Mqtt5Disconnect.f18845a;
        this.f18541b = -1L;
        this.f18544e = MqttUserPropertiesImpl.f17992c;
    }

    public MqttDisconnect a() {
        return new MqttDisconnect(this.f18540a, this.f18541b, this.f18542c, this.f18543d, this.f18544e);
    }

    public B b(Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode) {
        this.f18540a = (Mqtt5DisconnectReasonCode) Checks.j(mqtt5DisconnectReasonCode, "Reason Code");
        return d();
    }

    public B c(String str) {
        this.f18543d = MqttChecks.h(str);
        return d();
    }

    abstract B d();

    public B e(long j8) {
        this.f18541b = Checks.m(j8, "Session expiry interval");
        return d();
    }

    MqttDisconnectBuilder(MqttDisconnect mqttDisconnect) {
        this.f18540a = Mqtt5Disconnect.f18845a;
        this.f18541b = -1L;
        this.f18544e = MqttUserPropertiesImpl.f17992c;
        this.f18540a = mqttDisconnect.h();
        this.f18541b = mqttDisconnect.l();
        this.f18542c = mqttDisconnect.k();
        this.f18543d = mqttDisconnect.f();
        this.f18544e = mqttDisconnect.b();
    }
}
