package eu.bolt.chat.network.engine;

import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.exception.MqttException;
import eu.bolt.chat.network.exception.PublishingException;
import eu.bolt.chat.network.exception.SubscriptionException;

/* compiled from: PlatformMqttClientDelegate.kt */
/* loaded from: classes5.dex */
public interface PlatformMqttClientDelegate {
    void a(int i8, PublishingException publishingException);

    void c(MqttException mqttException);

    void e(String str);

    void f();

    void h(int i8);

    void i(MqttMessage mqttMessage);

    void l(String str, SubscriptionException subscriptionException);
}
