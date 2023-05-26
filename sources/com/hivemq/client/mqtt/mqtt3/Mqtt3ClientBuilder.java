package com.hivemq.client.mqtt.mqtt3;

import com.hivemq.client.mqtt.MqttClientBuilderBase;
import com.hivemq.client.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;

/* loaded from: classes3.dex */
public interface Mqtt3ClientBuilder extends MqttClientBuilderBase<Mqtt3ClientBuilder> {
    Mqtt3ClientBuilder a(Mqtt3SimpleAuth mqtt3SimpleAuth);

    Mqtt3RxClient j();
}
