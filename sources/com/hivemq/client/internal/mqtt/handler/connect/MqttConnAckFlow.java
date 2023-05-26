package com.hivemq.client.internal.mqtt.handler.connect;

import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/* loaded from: classes3.dex */
public class MqttConnAckFlow {

    /* renamed from: a  reason: collision with root package name */
    private final SingleObserver<? super Mqtt5ConnAck> f18099a;

    /* renamed from: b  reason: collision with root package name */
    private final Disposable f18100b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18101c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18102d;

    /* loaded from: classes3.dex */
    private static class MqttConnAckDisposable implements Disposable {

        /* renamed from: f  reason: collision with root package name */
        private volatile boolean f18103f;

        private MqttConnAckDisposable() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f18103f = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f18103f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttConnAckFlow(SingleObserver<? super Mqtt5ConnAck> singleObserver) {
        this.f18099a = singleObserver;
        this.f18100b = new MqttConnAckDisposable();
        this.f18101c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f18101c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Disposable b() {
        return this.f18100b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Throwable th) {
        SingleObserver<? super Mqtt5ConnAck> singleObserver = this.f18099a;
        if (singleObserver != null) {
            singleObserver.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Mqtt5ConnAck mqtt5ConnAck) {
        SingleObserver<? super Mqtt5ConnAck> singleObserver = this.f18099a;
        if (singleObserver != null) {
            singleObserver.onSuccess(mqtt5ConnAck);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        if (this.f18102d) {
            return false;
        }
        this.f18102d = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttConnAckFlow(MqttConnAckFlow mqttConnAckFlow) {
        if (mqttConnAckFlow == null) {
            this.f18099a = null;
            this.f18100b = new MqttConnAckDisposable();
            this.f18101c = 0;
            return;
        }
        this.f18099a = mqttConnAckFlow.f18099a;
        this.f18100b = mqttConnAckFlow.f18100b;
        this.f18101c = mqttConnAckFlow.f18101c + 1;
    }
}
