package com.hivemq.client.mqtt.mqtt3.message.publish;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilderBase.Complete;

/* loaded from: classes3.dex */
public interface Mqtt3PublishBuilderBase<C extends Complete<C>> {

    /* loaded from: classes3.dex */
    public interface Complete<C extends Complete<C>> extends Mqtt3PublishBuilderBase<C> {
        C a(MqttQos mqttQos);

        C b(byte[] bArr);
    }

    C c(String str);
}
