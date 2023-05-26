package com.hivemq.client.mqtt.mqtt3.message.connect;

/* loaded from: classes3.dex */
public interface Mqtt3ConnectBuilder extends Mqtt3ConnectBuilderBase<Mqtt3ConnectBuilder> {

    /* loaded from: classes3.dex */
    public interface Nested<P> extends Mqtt3ConnectBuilderBase<Nested<P>> {
        P b();
    }

    Mqtt3Connect build();
}
