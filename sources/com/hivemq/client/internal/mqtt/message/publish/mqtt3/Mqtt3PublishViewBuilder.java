package com.hivemq.client.internal.mqtt.message.publish.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicImpl;
import com.hivemq.client.internal.mqtt.message.publish.mqtt3.Mqtt3PublishViewBuilder;
import com.hivemq.client.internal.util.ByteBufferUtil;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilder;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class Mqtt3PublishViewBuilder<B extends Mqtt3PublishViewBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    MqttTopicImpl f18573a;

    /* renamed from: b  reason: collision with root package name */
    ByteBuffer f18574b;

    /* renamed from: c  reason: collision with root package name */
    MqttQos f18575c = Mqtt3Publish.f18786a;

    /* renamed from: d  reason: collision with root package name */
    boolean f18576d;

    /* loaded from: classes3.dex */
    private static abstract class Base<B extends Base<B>> extends Mqtt3PublishViewBuilder<B> {
        Base() {
        }

        public Mqtt3PublishView g() {
            Checks.j(this.f18573a, "Topic");
            return Mqtt3PublishView.g(this.f18573a, this.f18574b, this.f18575c, this.f18576d);
        }

        public B h(byte[] bArr) {
            this.f18574b = ByteBufferUtil.d(bArr);
            return (B) e();
        }
    }

    /* loaded from: classes3.dex */
    public static class Default extends Base<Default> implements Mqtt3PublishBuilder.Complete {
        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilder$Complete, com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase$Complete] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase.Complete
        public /* bridge */ /* synthetic */ Mqtt3PublishBuilder.Complete a(MqttQos mqttQos) {
            return (Mqtt3PublishBuilderBase.Complete) super.d(mqttQos);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilder$Complete, com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase$Complete] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase.Complete
        public /* bridge */ /* synthetic */ Mqtt3PublishBuilder.Complete b(byte[] bArr) {
            return (Mqtt3PublishBuilderBase.Complete) super.h(bArr);
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilder.Complete
        public /* bridge */ /* synthetic */ Mqtt3Publish build() {
            return super.g();
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilder$Complete, com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase$Complete] */
        @Override // com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase
        public /* bridge */ /* synthetic */ Mqtt3PublishBuilder.Complete c(String str) {
            return (Mqtt3PublishBuilderBase.Complete) super.f(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.hivemq.client.internal.mqtt.message.publish.mqtt3.Mqtt3PublishViewBuilder
        /* renamed from: i */
        public Default e() {
            return this;
        }
    }

    Mqtt3PublishViewBuilder() {
    }

    public B d(MqttQos mqttQos) {
        this.f18575c = (MqttQos) Checks.j(mqttQos, "QoS");
        return e();
    }

    protected abstract B e();

    public B f(String str) {
        this.f18573a = MqttTopicImpl.t(str);
        return e();
    }
}
