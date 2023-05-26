package com.hivemq.client.internal.mqtt.message.subscribe.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscriptionViewBuilder;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscription;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscriptionBuilderBase;

/* loaded from: classes3.dex */
public abstract class Mqtt3SubscriptionViewBuilder<B extends Mqtt3SubscriptionViewBuilder<B>> {

    /* renamed from: a  reason: collision with root package name */
    private MqttTopicFilterImpl f18613a;

    /* renamed from: b  reason: collision with root package name */
    private MqttQos f18614b = Mqtt3Subscription.f18787a;

    /* loaded from: classes3.dex */
    public static class Default extends Mqtt3SubscriptionViewBuilder<Default> implements Mqtt3SubscriptionBuilderBase, Mqtt3SubscriptionBuilderBase.Complete {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscriptionViewBuilder
        /* renamed from: g */
        public Default e() {
            return this;
        }
    }

    Mqtt3SubscriptionViewBuilder() {
    }

    public Mqtt3SubscriptionView c() {
        Checks.j(this.f18613a, "Topic filter");
        return Mqtt3SubscriptionView.e(this.f18613a, this.f18614b);
    }

    public B d(MqttQos mqttQos) {
        this.f18614b = (MqttQos) Checks.j(mqttQos, "QoS");
        return e();
    }

    abstract B e();

    public B f(String str) {
        this.f18613a = MqttTopicFilterImpl.t(str);
        return e();
    }
}
