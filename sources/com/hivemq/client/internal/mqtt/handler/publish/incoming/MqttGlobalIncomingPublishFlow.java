package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.util.collections.HandleList;
import com.hivemq.client.mqtt.MqttGlobalPublishFilter;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;

/* loaded from: classes3.dex */
public class MqttGlobalIncomingPublishFlow extends MqttIncomingPublishFlow {

    /* renamed from: u  reason: collision with root package name */
    private final MqttGlobalPublishFilter f18186u;

    /* renamed from: v  reason: collision with root package name */
    private HandleList.Handle<MqttGlobalIncomingPublishFlow> f18187v;

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow, org.reactivestreams.Subscription
    public /* bridge */ /* synthetic */ void f(long j8) {
        super.f(j8);
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow
    public /* bridge */ /* synthetic */ void l(Mqtt5Publish mqtt5Publish) {
        super.l(mqtt5Publish);
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow
    void o() {
        this.f18193j.f18209b.c(this);
        super.o();
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow, io.reactivex.Emitter
    public /* bridge */ /* synthetic */ void onError(Throwable th) {
        super.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttGlobalPublishFilter p() {
        return this.f18186u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandleList.Handle<MqttGlobalIncomingPublishFlow> q() {
        return this.f18187v;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttIncomingPublishFlow, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
