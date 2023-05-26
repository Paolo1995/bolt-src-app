package com.hivemq.client.mqtt.mqtt5.auth;

import com.hivemq.client.mqtt.datatypes.MqttUtf8String;
import com.hivemq.client.mqtt.mqtt5.Mqtt5ClientConfig;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5Auth;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5AuthBuilder;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5EnhancedAuthBuilder;
import com.hivemq.client.mqtt.mqtt5.message.connect.Mqtt5Connect;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;
import java.util.concurrent.CompletableFuture;

/* loaded from: classes3.dex */
public interface Mqtt5EnhancedAuthMechanism {
    CompletableFuture<Boolean> a(Mqtt5ClientConfig mqtt5ClientConfig, Mqtt5Auth mqtt5Auth, Mqtt5AuthBuilder mqtt5AuthBuilder);

    void b(Mqtt5ClientConfig mqtt5ClientConfig, Throwable th);

    int c();

    CompletableFuture<Void> d(Mqtt5ClientConfig mqtt5ClientConfig, Mqtt5Connect mqtt5Connect, Mqtt5EnhancedAuthBuilder mqtt5EnhancedAuthBuilder);

    void e(Mqtt5ClientConfig mqtt5ClientConfig, Throwable th);

    void f(Mqtt5ClientConfig mqtt5ClientConfig, Mqtt5Disconnect mqtt5Disconnect);

    void g(Mqtt5ClientConfig mqtt5ClientConfig, Mqtt5ConnAck mqtt5ConnAck);

    MqttUtf8String getMethod();

    CompletableFuture<Boolean> h(Mqtt5ClientConfig mqtt5ClientConfig, Mqtt5ConnAck mqtt5ConnAck);

    CompletableFuture<Boolean> i(Mqtt5ClientConfig mqtt5ClientConfig, Mqtt5Auth mqtt5Auth);

    CompletableFuture<Boolean> j(Mqtt5ClientConfig mqtt5ClientConfig, Mqtt5Auth mqtt5Auth, Mqtt5AuthBuilder mqtt5AuthBuilder);
}
