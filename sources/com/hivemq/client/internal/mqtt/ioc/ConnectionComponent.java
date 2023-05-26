package com.hivemq.client.internal.mqtt.ioc;

import com.hivemq.client.internal.mqtt.codec.MqttCodecModule;
import com.hivemq.client.internal.mqtt.handler.connect.MqttConnAckFlow;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import dagger.BindsInstance;
import dagger.Subcomponent;
import io.netty.bootstrap.Bootstrap;

@Subcomponent(modules = {ConnectionModule.class, MqttCodecModule.class})
/* loaded from: classes3.dex */
public interface ConnectionComponent {

    @Subcomponent.Builder
    /* loaded from: classes3.dex */
    public interface Builder {
        @BindsInstance
        Builder a(MqttConnAckFlow mqttConnAckFlow);

        @BindsInstance
        Builder b(MqttConnect mqttConnect);

        ConnectionComponent build();
    }

    Bootstrap a();
}
