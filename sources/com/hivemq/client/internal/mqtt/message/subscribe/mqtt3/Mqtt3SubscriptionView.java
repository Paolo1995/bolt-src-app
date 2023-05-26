package com.hivemq.client.internal.mqtt.message.subscribe.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.datatypes.MqttTopicFilter;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscription;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.Mqtt5RetainHandling;

/* loaded from: classes3.dex */
public class Mqtt3SubscriptionView implements Mqtt3Subscription {

    /* renamed from: b  reason: collision with root package name */
    private final MqttSubscription f18612b;

    private Mqtt3SubscriptionView(MqttSubscription mqttSubscription) {
        this.f18612b = mqttSubscription;
    }

    private static MqttSubscription a(MqttTopicFilterImpl mqttTopicFilterImpl, MqttQos mqttQos) {
        return new MqttSubscription(mqttTopicFilterImpl, mqttQos, false, Mqtt5RetainHandling.SEND, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mqtt3SubscriptionView e(MqttTopicFilterImpl mqttTopicFilterImpl, MqttQos mqttQos) {
        return new Mqtt3SubscriptionView(a(mqttTopicFilterImpl, mqttQos));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mqtt3SubscriptionView f(MqttSubscription mqttSubscription) {
        return new Mqtt3SubscriptionView(mqttSubscription);
    }

    private String g() {
        return "topicFilter=" + d() + ", qos=" + c();
    }

    public MqttSubscription b() {
        return this.f18612b;
    }

    public MqttQos c() {
        return this.f18612b.f();
    }

    public MqttTopicFilter d() {
        return this.f18612b.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3SubscriptionView)) {
            return false;
        }
        return this.f18612b.equals(((Mqtt3SubscriptionView) obj).f18612b);
    }

    public int hashCode() {
        return this.f18612b.hashCode();
    }

    public String toString() {
        return "MqttSubscription{" + g() + '}';
    }
}
