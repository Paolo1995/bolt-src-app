package com.hivemq.client.internal.mqtt.lifecycle.mqtt3;

import com.hivemq.client.internal.mqtt.lifecycle.MqttClientReconnector;
import com.hivemq.client.internal.mqtt.lifecycle.mqtt3.Mqtt3ClientReconnectorView;
import com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectView;
import com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectViewBuilder;
import com.hivemq.client.internal.mqtt.util.MqttChecks;
import com.hivemq.client.mqtt.mqtt3.lifecycle.Mqtt3ClientReconnector;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3Connect;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import java.util.concurrent.CompletableFuture;

/* loaded from: classes3.dex */
public class Mqtt3ClientReconnectorView implements Mqtt3ClientReconnector {

    /* renamed from: a  reason: collision with root package name */
    private final MqttClientReconnector f18445a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mqtt3ClientReconnectorView(MqttClientReconnector mqttClientReconnector) {
        this.f18445a = mqttClientReconnector;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientReconnector
    public int c() {
        return this.f18445a.c();
    }

    public Mqtt3ClientReconnectorView e(Mqtt3Connect mqtt3Connect) {
        this.f18445a.h(MqttChecks.c(mqtt3Connect));
        return this;
    }

    @Override // com.hivemq.client.mqtt.mqtt3.lifecycle.Mqtt3ClientReconnector
    /* renamed from: f */
    public Mqtt3ConnectViewBuilder.Nested<Mqtt3ClientReconnectorView> a() {
        return new Mqtt3ConnectViewBuilder.Nested<>(g(), new Function() { // from class: h0.a
            @Override // j$.util.function.Function
            public /* synthetic */ Function andThen(Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return Mqtt3ClientReconnectorView.this.e((Mqtt3ConnectView) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ Function compose(Function function) {
                return Function.CC.$default$compose(this, function);
            }
        });
    }

    public Mqtt3ConnectView g() {
        return Mqtt3ConnectView.i(this.f18445a.i());
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientReconnector
    /* renamed from: h */
    public Mqtt3ClientReconnectorView b(boolean z7) {
        this.f18445a.b(z7);
        return this;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientReconnector
    /* renamed from: i */
    public <T> Mqtt3ClientReconnectorView d(CompletableFuture<T> completableFuture, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f18445a.d(completableFuture, biConsumer);
        return this;
    }
}
