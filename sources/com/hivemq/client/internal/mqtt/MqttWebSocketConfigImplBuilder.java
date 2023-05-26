package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.mqtt.MqttWebSocketConfigImplBuilder;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.MqttWebSocketConfig;
import com.hivemq.client.mqtt.MqttWebSocketConfigBuilder;
import com.hivemq.client.mqtt.MqttWebSocketConfigBuilderBase;

/* loaded from: classes3.dex */
public abstract class MqttWebSocketConfigImplBuilder<B extends MqttWebSocketConfigImplBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private String f17842a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f17843b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f17844c = "mqtt";

    /* renamed from: d  reason: collision with root package name */
    private int f17845d = 10000;

    /* loaded from: classes3.dex */
    public static class Default extends MqttWebSocketConfigImplBuilder<Default> implements MqttWebSocketConfigBuilder {
        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.MqttWebSocketConfigBuilder, com.hivemq.client.mqtt.MqttWebSocketConfigBuilderBase] */
        @Override // com.hivemq.client.mqtt.MqttWebSocketConfigBuilderBase
        public /* bridge */ /* synthetic */ MqttWebSocketConfigBuilder a(String str) {
            return (MqttWebSocketConfigBuilderBase) super.f(str);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.MqttWebSocketConfigBuilder, com.hivemq.client.mqtt.MqttWebSocketConfigBuilderBase] */
        @Override // com.hivemq.client.mqtt.MqttWebSocketConfigBuilderBase
        public /* bridge */ /* synthetic */ MqttWebSocketConfigBuilder b(String str) {
            return (MqttWebSocketConfigBuilderBase) super.d(str);
        }

        @Override // com.hivemq.client.mqtt.MqttWebSocketConfigBuilder
        public /* bridge */ /* synthetic */ MqttWebSocketConfig build() {
            return super.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.MqttWebSocketConfigImplBuilder
        /* renamed from: g */
        public Default e() {
            return this;
        }
    }

    MqttWebSocketConfigImplBuilder() {
    }

    public MqttWebSocketConfigImpl c() {
        return new MqttWebSocketConfigImpl(this.f17842a, this.f17843b, this.f17844c, this.f17845d);
    }

    public B d(String str) {
        this.f17843b = (String) Checks.j(str, "Query string");
        return e();
    }

    abstract B e();

    public B f(String str) {
        this.f17842a = ((String) Checks.j(str, "Server path")).replaceAll("^/+", "");
        return e();
    }
}
