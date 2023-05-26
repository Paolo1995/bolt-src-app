package com.hivemq.client.internal.mqtt.ioc;

import com.hivemq.client.internal.mqtt.handler.MqttChannelInitializer;
import com.hivemq.client.internal.mqtt.handler.auth.MqttAuthHandler;
import com.hivemq.client.internal.mqtt.handler.auth.MqttConnectAuthHandler;
import com.hivemq.client.internal.mqtt.handler.auth.MqttDisconnectOnAuthHandler;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.netty.NettyEventLoopProvider;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFactory;

@Module
/* loaded from: classes3.dex */
abstract class ConnectionModule {
    ConnectionModule() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static MqttAuthHandler a(MqttConnect mqttConnect, Lazy<MqttConnectAuthHandler> lazy, Lazy<MqttDisconnectOnAuthHandler> lazy2) {
        if (mqttConnect.h() == null) {
            return lazy2.get();
        }
        return lazy.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static Bootstrap b(MqttChannelInitializer mqttChannelInitializer) {
        return new Bootstrap().channelFactory((ChannelFactory) NettyEventLoopProvider.f18635e.c()).handler(mqttChannelInitializer);
    }
}
