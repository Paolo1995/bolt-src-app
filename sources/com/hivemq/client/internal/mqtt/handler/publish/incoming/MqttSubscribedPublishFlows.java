package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicFilterImpl;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscription;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface MqttSubscribedPublishFlows {
    void a(MqttStatefulPublishWithFlows mqttStatefulPublishWithFlows);

    void b(MqttSubscription mqttSubscription, int i8, MqttSubscribedPublishFlow mqttSubscribedPublishFlow);

    void c(MqttTopicFilterImpl mqttTopicFilterImpl, int i8, boolean z7);

    void d(Throwable th);

    Map<Integer, List<MqttSubscription>> e();

    void f(MqttTopicFilterImpl mqttTopicFilterImpl);

    void g(MqttSubscribedPublishFlow mqttSubscribedPublishFlow);
}
