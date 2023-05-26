package eu.bolt.chat.network.engine;

import android.annotation.SuppressLint;
import com.hivemq.client.mqtt.MqttWebSocketConfig;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedContext;
import com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener;
import com.hivemq.client.mqtt.mqtt3.Mqtt3ClientBuilder;
import com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient;
import eu.bolt.chat.network.CredentialsProvider;
import eu.bolt.chat.network.data.MqttConnection;
import eu.bolt.chat.network.engine.AndroidMqttClientFactory;
import eu.bolt.chat.network.engine.PlatformMqttClientDelegate;
import eu.bolt.chat.network.mapper.ExceptionMapper;
import kotlin.jvm.internal.Intrinsics;
import p0.c;
import q0.a;

/* compiled from: AndroidMqttClientFactory.kt */
/* loaded from: classes5.dex */
public final class AndroidMqttClientFactory implements PlatformMqttClientFactory {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PlatformMqttClientDelegate delegate, MqttClientConnectedContext it) {
        Intrinsics.f(delegate, "$delegate");
        Intrinsics.f(it, "it");
        delegate.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(PlatformMqttClientDelegate delegate, ExceptionMapper exceptionMapper, MqttClientDisconnectedContext it) {
        Intrinsics.f(delegate, "$delegate");
        Intrinsics.f(exceptionMapper, "$exceptionMapper");
        Intrinsics.f(it, "it");
        Throwable b8 = it.b();
        Intrinsics.e(b8, "it.cause");
        delegate.c(exceptionMapper.c(b8));
    }

    private final MqttWebSocketConfig f(String str, String str2) {
        MqttWebSocketConfig build = c.a().a(str).b(str2).build();
        Intrinsics.e(build, "builder()\n            .s…ery)\n            .build()");
        return build;
    }

    @Override // eu.bolt.chat.network.engine.PlatformMqttClientFactory
    @SuppressLint({"CheckResult"})
    public PlatformMqttClient a(MqttConnection connection, CredentialsProvider credentialsProvider, final PlatformMqttClientDelegate delegate) {
        Intrinsics.f(connection, "connection");
        Intrinsics.f(credentialsProvider, "credentialsProvider");
        Intrinsics.f(delegate, "delegate");
        final ExceptionMapper exceptionMapper = new ExceptionMapper();
        Mqtt3ClientBuilder a8 = a.a();
        a8.f(connection.b());
        a8.c(connection.d());
        a8.h(connection.f() & 65535);
        if (connection.c()) {
            a8.e();
        }
        eu.bolt.chat.network.data.MqttWebSocketConfig g8 = connection.g();
        if (g8 != null) {
            a8.d(f(g8.a(), g8.b()));
        }
        a8.b(new MqttClientConnectedListener() { // from class: n6.f
            @Override // com.hivemq.client.mqtt.lifecycle.MqttClientConnectedListener
            public final void a(MqttClientConnectedContext mqttClientConnectedContext) {
                AndroidMqttClientFactory.d(PlatformMqttClientDelegate.this, mqttClientConnectedContext);
            }
        });
        a8.i(new MqttClientDisconnectedListener() { // from class: n6.g
            @Override // com.hivemq.client.mqtt.lifecycle.MqttClientDisconnectedListener
            public final void a(MqttClientDisconnectedContext mqttClientDisconnectedContext) {
                AndroidMqttClientFactory.e(PlatformMqttClientDelegate.this, exceptionMapper, mqttClientDisconnectedContext);
            }
        });
        Mqtt3RxClient j8 = a8.j();
        Intrinsics.e(j8, "builder().apply {\n      …e)) }\n        }.buildRx()");
        return new AndroidMqttClient(j8, credentialsProvider, exceptionMapper, connection, delegate);
    }
}
