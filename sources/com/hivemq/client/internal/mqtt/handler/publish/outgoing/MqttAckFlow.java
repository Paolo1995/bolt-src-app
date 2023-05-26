package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.util.FlowWithEventLoop;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult;

/* loaded from: classes3.dex */
abstract class MqttAckFlow extends FlowWithEventLoop {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttAckFlow(MqttClientConfig mqttClientConfig) {
        super(mqttClientConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void h(long j8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(MqttPublishResult mqttPublishResult);
}
