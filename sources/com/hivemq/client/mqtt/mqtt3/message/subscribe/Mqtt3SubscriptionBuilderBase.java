package com.hivemq.client.mqtt.mqtt3.message.subscribe;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscriptionBuilderBase.Complete;

/* loaded from: classes3.dex */
public interface Mqtt3SubscriptionBuilderBase<C extends Complete<C>> {

    /* loaded from: classes3.dex */
    public interface Complete<C extends Complete<C>> extends Mqtt3SubscriptionBuilderBase<C> {
        C a(MqttQos mqttQos);
    }

    C b(String str);
}
