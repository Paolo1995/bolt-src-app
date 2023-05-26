package com.hivemq.client.internal.mqtt.handler.util;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import io.netty.channel.EventLoop;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class FlowWithEventLoop {

    /* renamed from: f  reason: collision with root package name */
    private final MqttClientConfig f18351f;

    /* renamed from: g  reason: collision with root package name */
    protected final EventLoop f18352g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f18353h = new AtomicInteger(0);

    public FlowWithEventLoop(MqttClientConfig mqttClientConfig) {
        this.f18351f = mqttClientConfig;
        this.f18352g = mqttClientConfig.b();
    }

    public void cancel() {
        if (this.f18353h.getAndSet(3) == 1) {
            e();
            this.f18351f.s();
        }
    }

    public EventLoop d() {
        return this.f18352g;
    }

    protected abstract void e();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        if (this.f18353h.compareAndSet(1, 2)) {
            this.f18351f.s();
            return true;
        }
        return false;
    }

    public boolean init() {
        if (this.f18353h.compareAndSet(0, 1)) {
            return true;
        }
        this.f18351f.s();
        return false;
    }

    public boolean isCancelled() {
        if (this.f18353h.get() == 3) {
            return true;
        }
        return false;
    }
}
