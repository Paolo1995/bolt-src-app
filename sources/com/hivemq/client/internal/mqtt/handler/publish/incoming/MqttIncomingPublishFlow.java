package com.hivemq.client.internal.mqtt.handler.publish.incoming;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.util.FlowWithEventLoop;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import io.reactivex.Emitter;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class MqttIncomingPublishFlow extends FlowWithEventLoop implements Emitter<Mqtt5Publish>, Subscription, Runnable {

    /* renamed from: i  reason: collision with root package name */
    final Subscriber<? super Mqtt5Publish> f18192i;

    /* renamed from: j  reason: collision with root package name */
    final MqttIncomingPublishService f18193j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f18194k;

    /* renamed from: l  reason: collision with root package name */
    private long f18195l;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicLong f18196m;

    /* renamed from: n  reason: collision with root package name */
    private final AtomicInteger f18197n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f18198o;

    /* renamed from: p  reason: collision with root package name */
    private Throwable f18199p;

    /* renamed from: q  reason: collision with root package name */
    private int f18200q;

    /* renamed from: r  reason: collision with root package name */
    private int f18201r;

    /* renamed from: s  reason: collision with root package name */
    private long f18202s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f18203t;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttIncomingPublishFlow(Subscriber<? super Mqtt5Publish> subscriber, MqttClientConfig mqttClientConfig, MqttIncomingQosHandler mqttIncomingQosHandler, boolean z7) {
        super(mqttClientConfig);
        this.f18196m = new AtomicLong();
        this.f18197n = new AtomicInteger(0);
        this.f18192i = subscriber;
        this.f18193j = mqttIncomingQosHandler.f18221i;
        this.f18194k = z7;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.FlowWithEventLoop
    protected void e() {
        this.f18352g.execute(new Runnable() { // from class: com.hivemq.client.internal.mqtt.handler.publish.incoming.a
            @Override // java.lang.Runnable
            public final void run() {
                MqttIncomingPublishFlow.this.o();
            }
        });
    }

    public void f(long j8) {
        if (j8 > 0 && !isCancelled()) {
            BackpressureHelper.a(this.f18196m, j8);
            if (this.f18197n.getAndSet(1) == 2) {
                this.f18352g.execute(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hivemq.client.internal.mqtt.handler.util.FlowWithEventLoop
    public boolean g() {
        if (this.f18200q == 0 && this.f18201r == 0 && super.g()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z7) {
        if (z7) {
            this.f18193j.a();
        }
        int i8 = this.f18201r - 1;
        this.f18201r = i8;
        if (i8 == 0) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (this.f18198o && g()) {
            Throwable th = this.f18199p;
            if (th != null) {
                this.f18192i.onError(th);
            } else {
                this.f18192i.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        int i8 = this.f18200q - 1;
        this.f18200q = i8;
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        this.f18201r++;
    }

    public void l(Mqtt5Publish mqtt5Publish) {
        this.f18192i.onNext(mqtt5Publish);
        long j8 = this.f18195l;
        if (j8 != Long.MAX_VALUE) {
            this.f18195l = j8 - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        int i8 = this.f18200q + 1;
        this.f18200q = i8;
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long n(long j8) {
        long j9 = this.f18195l;
        if (j9 <= 0) {
            if (this.f18203t && this.f18202s != j8) {
                this.f18203t = false;
            }
            if (this.f18203t) {
                return -1L;
            }
            while (!this.f18197n.compareAndSet(0, 2)) {
                this.f18197n.set(0);
                long andSet = this.f18196m.getAndSet(0L);
                if (andSet > 0) {
                    long b8 = BackpressureHelper.b(this.f18195l, andSet);
                    this.f18195l = b8;
                    return b8;
                }
            }
            this.f18202s = j8;
            this.f18203t = true;
            return 0L;
        }
        return j9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.f18200q > 0) {
            this.f18193j.a();
        }
    }

    @Override // io.reactivex.Emitter
    public void onComplete() {
        if (this.f18198o) {
            return;
        }
        this.f18198o = true;
        if (g()) {
            this.f18192i.onComplete();
        } else {
            this.f18193j.a();
        }
    }

    public void onError(Throwable th) {
        if (this.f18198o) {
            if (th != this.f18199p) {
                RxJavaPlugins.s(th);
                return;
            }
            return;
        }
        this.f18199p = th;
        this.f18198o = true;
        if (g()) {
            this.f18192i.onError(th);
        } else {
            this.f18193j.a();
        }
    }

    public void run() {
        if (this.f18200q > 0) {
            this.f18193j.a();
        }
    }
}
