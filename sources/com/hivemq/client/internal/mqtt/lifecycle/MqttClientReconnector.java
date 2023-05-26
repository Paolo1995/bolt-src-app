package com.hivemq.client.internal.mqtt.lifecycle;

import com.hivemq.client.internal.mqtt.MqttClientTransportConfigImpl;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.util.MqttChecks;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.mqtt5.message.connect.Mqtt5Connect;
import io.netty.channel.EventLoop;
import j$.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MqttClientReconnector implements com.hivemq.client.mqtt.lifecycle.MqttClientReconnector {

    /* renamed from: a  reason: collision with root package name */
    private final EventLoop f18428a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18429b;

    /* renamed from: d  reason: collision with root package name */
    private CompletableFuture<?> f18431d;

    /* renamed from: h  reason: collision with root package name */
    private MqttClientTransportConfigImpl f18435h;

    /* renamed from: i  reason: collision with root package name */
    private MqttConnect f18436i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18437j;

    /* renamed from: c  reason: collision with root package name */
    private boolean f18430c = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18432e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18433f = false;

    /* renamed from: g  reason: collision with root package name */
    private long f18434g = TimeUnit.MILLISECONDS.toNanos(0);

    public MqttClientReconnector(EventLoop eventLoop, int i8, MqttConnect mqttConnect, MqttClientTransportConfigImpl mqttClientTransportConfigImpl) {
        this.f18428a = eventLoop;
        this.f18429b = i8;
        this.f18436i = mqttConnect;
        this.f18435h = mqttClientTransportConfigImpl;
    }

    private void f() {
        Checks.k(this.f18428a.inEventLoop(), "MqttClientReconnector must be called from the eventLoop.");
    }

    private void g(String str) {
        f();
        if (!this.f18437j) {
            return;
        }
        throw new UnsupportedOperationException(str + " must only be called in onDisconnected.");
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientReconnector
    public int c() {
        f();
        return this.f18429b;
    }

    public void e() {
        this.f18437j = true;
    }

    public MqttClientReconnector h(Mqtt5Connect mqtt5Connect) {
        f();
        this.f18436i = MqttChecks.d(mqtt5Connect);
        return this;
    }

    public MqttConnect i() {
        f();
        return this.f18436i;
    }

    public long j(TimeUnit timeUnit) {
        f();
        Checks.j(timeUnit, "Time unit");
        return timeUnit.convert(this.f18434g, TimeUnit.NANOSECONDS);
    }

    public CompletableFuture<?> k() {
        f();
        CompletableFuture<?> completableFuture = this.f18431d;
        if (completableFuture == null) {
            return CompletableFuture.completedFuture(null);
        }
        return completableFuture;
    }

    public MqttClientTransportConfigImpl l() {
        f();
        return this.f18435h;
    }

    public boolean m() {
        f();
        return this.f18430c;
    }

    public boolean n() {
        f();
        return this.f18433f;
    }

    public boolean o() {
        f();
        return this.f18432e;
    }

    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientReconnector
    /* renamed from: p */
    public MqttClientReconnector b(boolean z7) {
        f();
        this.f18430c = z7;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hivemq.client.mqtt.lifecycle.MqttClientReconnector
    /* renamed from: q */
    public <T> MqttClientReconnector d(CompletableFuture<T> completableFuture, BiConsumer<? super T, ? super Throwable> biConsumer) {
        CompletableFuture whenCompleteAsync;
        g("reconnectWhen");
        Checks.j(completableFuture, "Future");
        this.f18430c = true;
        CompletableFuture completableFuture2 = completableFuture;
        if (biConsumer != null) {
            whenCompleteAsync = completableFuture.whenCompleteAsync(BiConsumer.Wrapper.convert(biConsumer), (Executor) this.f18428a);
            completableFuture2 = (CompletableFuture<T>) whenCompleteAsync;
        }
        CompletableFuture<?> completableFuture3 = this.f18431d;
        CompletableFuture completableFuture4 = completableFuture2;
        if (completableFuture3 != null) {
            completableFuture4 = CompletableFuture.allOf(completableFuture3, completableFuture2);
        }
        this.f18431d = completableFuture4;
        return this;
    }
}
