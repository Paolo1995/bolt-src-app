package com.hivemq.client.internal.mqtt.ioc;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingQosHandler;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttOutgoingQosHandler;
import com.hivemq.client.internal.mqtt.handler.subscribe.MqttSubscriptionHandler;
import com.hivemq.client.internal.mqtt.ioc.ConnectionComponent;
import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = {ClientModule.class})
/* loaded from: classes3.dex */
public interface ClientComponent {

    @Subcomponent.Builder
    /* loaded from: classes3.dex */
    public interface Builder {
        @BindsInstance
        Builder a(MqttClientConfig mqttClientConfig);

        ClientComponent build();
    }

    MqttSubscriptionHandler a();

    MqttOutgoingQosHandler b();

    MqttIncomingQosHandler c();

    ConnectionComponent.Builder d();
}
