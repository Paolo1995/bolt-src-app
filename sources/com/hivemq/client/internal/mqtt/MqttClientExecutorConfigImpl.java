package com.hivemq.client.internal.mqtt;

import com.hivemq.client.mqtt.MqttClientExecutorConfig;
import io.reactivex.Scheduler;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class MqttClientExecutorConfigImpl implements MqttClientExecutorConfig {

    /* renamed from: e  reason: collision with root package name */
    public static final MqttClientExecutorConfigImpl f17797e = new MqttClientExecutorConfigImpl(null, 0, MqttClientExecutorConfig.f18735a);

    /* renamed from: b  reason: collision with root package name */
    private final Executor f17798b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17799c;

    /* renamed from: d  reason: collision with root package name */
    private final Scheduler f17800d;

    MqttClientExecutorConfigImpl(Executor executor, int i8, Scheduler scheduler) {
        this.f17798b = executor;
        this.f17799c = i8;
        this.f17800d = scheduler;
    }

    public Scheduler a() {
        return this.f17800d;
    }

    public Executor b() {
        return this.f17798b;
    }

    public int c() {
        return this.f17799c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MqttClientExecutorConfigImpl)) {
            return false;
        }
        MqttClientExecutorConfigImpl mqttClientExecutorConfigImpl = (MqttClientExecutorConfigImpl) obj;
        if (Objects.equals(this.f17798b, mqttClientExecutorConfigImpl.f17798b) && this.f17799c == mqttClientExecutorConfigImpl.f17799c && this.f17800d.equals(mqttClientExecutorConfigImpl.f17800d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((Objects.hashCode(this.f17798b) * 31) + this.f17799c) * 31) + this.f17800d.hashCode();
    }
}
