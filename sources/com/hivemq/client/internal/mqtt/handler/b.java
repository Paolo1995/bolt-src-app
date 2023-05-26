package com.hivemq.client.internal.mqtt.handler;

import io.netty.channel.Channel;
import j$.util.function.BiConsumer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MqttChannelInitializer f18097a;

    public /* synthetic */ b(MqttChannelInitializer mqttChannelInitializer) {
        this.f18097a = mqttChannelInitializer;
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        MqttChannelInitializer.a(this.f18097a, (Channel) obj, (Throwable) obj2);
    }

    @Override // j$.util.function.BiConsumer
    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer.CC.$default$andThen(this, biConsumer);
    }
}
