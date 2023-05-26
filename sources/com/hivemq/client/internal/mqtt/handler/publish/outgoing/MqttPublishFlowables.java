package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import io.reactivex.Flowable;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class MqttPublishFlowables extends Flowable<Flowable<MqttPublishWithFlow>> implements Subscription {

    /* renamed from: i  reason: collision with root package name */
    private static final InternalLogger f18304i = InternalLoggerFactory.a(MqttPublishFlowables.class);

    /* renamed from: g  reason: collision with root package name */
    private Subscriber<? super Flowable<MqttPublishWithFlow>> f18305g;

    /* renamed from: h  reason: collision with root package name */
    private long f18306h;

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super Flowable<MqttPublishWithFlow>> subscriber) {
        this.f18305g = subscriber;
        subscriber.c(this);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f18305g = null;
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        synchronized (this) {
            long b8 = BackpressureHelper.b(this.f18306h, j8);
            this.f18306h = b8;
            if (b8 == j8) {
                notifyAll();
            }
        }
    }

    public void h0(Flowable<MqttPublishWithFlow> flowable) {
        synchronized (this) {
            while (this.f18306h == 0) {
                try {
                    wait();
                } catch (InterruptedException e8) {
                    f18304i.error("thread interrupted while waiting to publish.", (Throwable) e8);
                    return;
                }
            }
            this.f18305g.onNext(flowable);
            this.f18306h--;
        }
    }
}
