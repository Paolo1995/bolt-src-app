package com.hivemq.client.internal.mqtt.message.subscribe.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.internal.util.collections.b;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscribe;

/* loaded from: classes3.dex */
public class Mqtt3SubscribeView implements Mqtt3Subscribe {

    /* renamed from: a  reason: collision with root package name */
    private final MqttSubscribe f18608a;

    private Mqtt3SubscribeView(MqttSubscribe mqttSubscribe) {
        this.f18608a = mqttSubscribe;
    }

    private static MqttSubscribe a(ImmutableList<MqttSubscription> immutableList) {
        return new MqttSubscribe(immutableList, MqttUserPropertiesImpl.f17992c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mqtt3SubscribeView d(ImmutableList<MqttSubscription> immutableList) {
        return new Mqtt3SubscribeView(a(immutableList));
    }

    private String e() {
        return "subscriptions=" + c();
    }

    public MqttSubscribe b() {
        return this.f18608a;
    }

    public ImmutableList<Mqtt3SubscriptionView> c() {
        ImmutableList<MqttSubscription> g8 = this.f18608a.g();
        ImmutableList.Builder w7 = b.w(g8.size());
        for (int i8 = 0; i8 < g8.size(); i8++) {
            w7.a(Mqtt3SubscriptionView.f(g8.get(i8)));
        }
        return w7.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3SubscribeView)) {
            return false;
        }
        return this.f18608a.equals(((Mqtt3SubscribeView) obj).f18608a);
    }

    public int hashCode() {
        return this.f18608a.hashCode();
    }

    public String toString() {
        return "MqttSubscribe{" + e() + '}';
    }
}
