package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.CredentialsProvider;
import eu.bolt.chat.network.data.MqttConnection;

/* compiled from: PlatformMqttClientFactory.kt */
/* loaded from: classes5.dex */
public interface PlatformMqttClientFactory {
    PlatformMqttClient a(MqttConnection mqttConnection, CredentialsProvider credentialsProvider, PlatformMqttClientDelegate platformMqttClientDelegate);
}
