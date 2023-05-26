package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.QoS;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: MqttClient.kt */
/* loaded from: classes5.dex */
public interface MqttClient {
    Flow<ConnectionEvent> a();

    Flow<SubscriptionEvent> c(String str, QoS qoS);

    Object d(MqttMessage mqttMessage, QoS qoS, Continuation<? super PublishingEvent> continuation);

    void disconnect();
}
