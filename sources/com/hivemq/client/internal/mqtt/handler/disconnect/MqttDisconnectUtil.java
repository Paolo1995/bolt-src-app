package com.hivemq.client.internal.mqtt.handler.disconnect;

import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnectBuilder;
import com.hivemq.client.mqtt.exceptions.ConnectionClosedException;
import com.hivemq.client.mqtt.lifecycle.MqttDisconnectSource;
import com.hivemq.client.mqtt.mqtt5.exceptions.Mqtt5DisconnectException;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5DisconnectReasonCode;
import io.netty.channel.Channel;

/* loaded from: classes3.dex */
public final class MqttDisconnectUtil {
    private MqttDisconnectUtil() {
    }

    public static void a(Channel channel, String str) {
        f(channel, new ConnectionClosedException(str), MqttDisconnectSource.CLIENT);
    }

    public static void b(Channel channel, Throwable th) {
        f(channel, th, MqttDisconnectSource.CLIENT);
    }

    public static void c(Channel channel, Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode, String str) {
        f(channel, new Mqtt5DisconnectException(new MqttDisconnectBuilder.Default().b(mqtt5DisconnectReasonCode).c(str).a(), str), MqttDisconnectSource.CLIENT);
    }

    public static void d(Channel channel, Mqtt5DisconnectReasonCode mqtt5DisconnectReasonCode, Throwable th) {
        f(channel, new Mqtt5DisconnectException(new MqttDisconnectBuilder.Default().b(mqtt5DisconnectReasonCode).c(th.getMessage()).a(), th), MqttDisconnectSource.CLIENT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Channel channel, MqttDisconnectEvent mqttDisconnectEvent) {
        channel.pipeline().fireUserEventTriggered(mqttDisconnectEvent);
    }

    public static void f(Channel channel, Throwable th, MqttDisconnectSource mqttDisconnectSource) {
        e(channel, new MqttDisconnectEvent(th, mqttDisconnectSource));
    }
}
