package com.hivemq.client.internal.mqtt.message.unsubscribe;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties;
import com.hivemq.client.internal.util.StringUtil;
import com.hivemq.client.internal.util.collections.ImmutableList;
import com.hivemq.client.mqtt.mqtt5.message.Mqtt5MessageType;
import com.hivemq.client.mqtt.mqtt5.message.unsubscribe.Mqtt5Unsubscribe;
import i1.a;

/* loaded from: classes3.dex */
public class MqttUnsubscribe extends MqttMessageWithUserProperties implements Mqtt5Unsubscribe {

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<MqttTopicFilterImpl> f18619c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.message.MqttMessageWithUserProperties
    public String e() {
        return "topicFilters=" + this.f18619c + StringUtil.a(", ", super.e());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttUnsubscribe)) {
            return false;
        }
        MqttUnsubscribe mqttUnsubscribe = (MqttUnsubscribe) obj;
        if (c(mqttUnsubscribe) && this.f18619c.equals(mqttUnsubscribe.f18619c)) {
            return true;
        }
        return false;
    }

    public MqttStatefulUnsubscribe f(int i8) {
        return new MqttStatefulUnsubscribe(this, i8);
    }

    public ImmutableList<MqttTopicFilterImpl> g() {
        return this.f18619c;
    }

    @Override // com.hivemq.client.mqtt.mqtt5.message.Mqtt5Message
    public /* synthetic */ Mqtt5MessageType getType() {
        return a.a(this);
    }

    public int hashCode() {
        return (d() * 31) + this.f18619c.hashCode();
    }

    public String toString() {
        return "MqttUnsubscribe{" + e() + '}';
    }
}
