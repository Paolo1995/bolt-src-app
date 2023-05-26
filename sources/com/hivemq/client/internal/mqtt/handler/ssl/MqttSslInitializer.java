package com.hivemq.client.internal.mqtt.handler.ssl;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.MqttClientSslConfigImpl;
import com.hivemq.client.internal.util.collections.ImmutableList;
import io.netty.channel.Channel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import j$.util.function.BiConsumer;
import j$.util.function.Consumer;
import java.net.InetSocketAddress;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;

/* loaded from: classes3.dex */
public final class MqttSslInitializer {
    private MqttSslInitializer() {
    }

    static SslContext a(MqttClientSslConfigImpl mqttClientSslConfigImpl) throws SSLException {
        String[] strArr;
        ImmutableList<String> e8 = mqttClientSslConfigImpl.e();
        SslContextBuilder keyManager = SslContextBuilder.forClient().trustManager(mqttClientSslConfigImpl.f()).keyManager(mqttClientSslConfigImpl.d());
        if (e8 == null) {
            strArr = null;
        } else {
            strArr = (String[]) e8.toArray(new String[0]);
        }
        return keyManager.protocols(strArr).ciphers(mqttClientSslConfigImpl.b(), SupportedCipherSuiteFilter.INSTANCE).build();
    }

    public static void b(Channel channel, MqttClientConfig mqttClientConfig, MqttClientSslConfigImpl mqttClientSslConfigImpl, Consumer<Channel> consumer, BiConsumer<Channel, Throwable> biConsumer) {
        InetSocketAddress g8 = mqttClientConfig.i().g();
        try {
            SslContext h8 = mqttClientConfig.h();
            if (h8 == null) {
                h8 = a(mqttClientSslConfigImpl);
                mqttClientConfig.v(h8);
            }
            SslHandler newHandler = h8.newHandler(channel.alloc(), g8.getHostString(), g8.getPort());
            newHandler.setHandshakeTimeoutMillis(mqttClientSslConfigImpl.a());
            HostnameVerifier c8 = mqttClientSslConfigImpl.c();
            if (c8 == null) {
                SSLParameters sSLParameters = newHandler.engine().getSSLParameters();
                sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
                newHandler.engine().setSSLParameters(sSLParameters);
            }
            channel.pipeline().addLast("ssl", newHandler).addLast("ssl.adapter", new MqttSslAdapterHandler(newHandler, g8.getHostString(), c8, consumer, biConsumer));
        } catch (Throwable th) {
            biConsumer.accept(channel, th);
        }
    }
}
