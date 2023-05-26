package com.hivemq.client.internal.mqtt.ioc;

import com.hivemq.client.internal.mqtt.handler.MqttChannelInitializer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.netty.bootstrap.Bootstrap;

/* loaded from: classes3.dex */
public final class ConnectionModule_ProvideBootstrapFactory implements Factory<Bootstrap> {
    public static Bootstrap a(MqttChannelInitializer mqttChannelInitializer) {
        return (Bootstrap) Preconditions.checkNotNull(ConnectionModule.b(mqttChannelInitializer), "Cannot return null from a non-@Nullable @Provides method");
    }
}
