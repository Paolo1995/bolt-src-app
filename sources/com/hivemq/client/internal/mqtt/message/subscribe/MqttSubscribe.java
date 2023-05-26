package com.hivemq.client.internal.mqtt.message.subscribe;

import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.Mqtt5Subscribe;
import g1.a;

/* loaded from: classes3.dex */
public class MqttSubscribe extends MqttMessageWithUserProperties implements Mqtt5Subscribe {

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<MqttSubscription> f18602c;

    public MqttSubscribe(ImmutableList<MqttSubscription> immutableList, MqttUserPropertiesImpl mqttUserPropertiesImpl) {
        super(mqttUserPropertiesImpl);
        this.f18602c = immutableList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    public String e() {
        return "subscriptions=" + this.f18602c + StringUtil.a(", ", super.e());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttSubscribe)) {
            return false;
        }
        MqttSubscribe mqttSubscribe = (MqttSubscribe) obj;
        if (c(mqttSubscribe) && this.f18602c.equals(mqttSubscribe.f18602c)) {
            return true;
        }
        return false;
    }

    public MqttStatefulSubscribe f(int i8, int i9) {
        return new MqttStatefulSubscribe(this, i8, i9);
    }

    public ImmutableList<MqttSubscription> g() {
        return this.f18602c;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return (d() * 31) + this.f18602c.hashCode();
    }

    public String toString() {
        return "MqttSubscribe{" + e() + '}';
    }
}
