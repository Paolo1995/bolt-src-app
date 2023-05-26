package com.hivemq.client.mqtt.mqtt3.message.publish;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.datatypes.MqttTopic;

/* loaded from: classes3.dex */
public interface Mqtt3Publish {

    /* renamed from: a  reason: collision with root package name */
    public static final MqttQos f18786a = MqttQos.AT_MOST_ONCE;

    byte[] a();

    MqttTopic b();
}
