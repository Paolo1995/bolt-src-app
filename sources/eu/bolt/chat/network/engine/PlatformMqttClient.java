package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.QoS;

/* compiled from: PlatformMqttClient.kt */
/* loaded from: classes5.dex */
public interface PlatformMqttClient {
    void a();

    void b();

    void c(String str, QoS qoS);

    int d(MqttMessage mqttMessage, QoS qoS);

    void disconnect();
}
