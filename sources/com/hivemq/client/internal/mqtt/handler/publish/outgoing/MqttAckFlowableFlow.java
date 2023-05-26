package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttPublishFlowableAckLink;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult;
import com.hivemq.client.internal.util.collections.ChunkedArrayQueue;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
class MqttAckFlowableFlow extends MqttAckFlow implements Subscription, Runnable {

    /* renamed from: i  reason: collision with root package name */
    private final Subscriber<? super MqttPublishResult> f18258i;

    /* renamed from: j  reason: collision with root package name */
    private final MqttOutgoingQosHandler f18259j;

    /* renamed from: k  reason: collision with root package name */
    private long f18260k;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicLong f18261l;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicInteger f18262m;

    /* renamed from: n  reason: collision with root package name */
    private volatile long f18263n;

    /* renamed from: o  reason: collision with root package name */
    private final AtomicLong f18264o;

    /* renamed from: p  reason: collision with root package name */
    private Throwable f18265p;

    /* renamed from: q  reason: collision with root package name */
    private final ChunkedArrayQueue<MqttPublishResult> f18266q;

    /* renamed from: r  reason: collision with root package name */
    private final AtomicReference<MqttPublishFlowableAckLink.LinkedFlow> f18267r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttAckFlowableFlow(Subscriber<? super MqttPublishResult> subscriber, MqttClientConfig mqttClientConfig, MqttOutgoingQosHandler mqttOutgoingQosHandler) {
        super(mqttClientConfig);
        this.f18261l = new AtomicLong();
        this.f18262m = new AtomicInteger(0);
        this.f18264o = new AtomicLong();
        this.f18266q = new ChunkedArrayQueue<>(32);
        this.f18267r = new AtomicReference<>();
        this.f18258i = subscriber;
        this.f18259j = mqttOutgoingQosHandler;
        init();
    }

    private long j() {
        while (!this.f18262m.compareAndSet(0, 2)) {
            this.f18262m.set(0);
            long andSet = this.f18261l.getAndSet(0L);
            if (andSet > 0) {
                long b8 = BackpressureHelper.b(this.f18260k, andSet);
                this.f18260k = b8;
                return b8;
            }
        }
        return 0L;
    }

    private void k() {
        MqttPublishFlowableAckLink.LinkedFlow andSet = this.f18267r.getAndSet(MqttPublishFlowableAckLink.LinkedFlow.f18303a);
        if (andSet != null) {
            andSet.a();
        }
    }

    private long o() {
        long j8 = this.f18260k;
        if (j8 <= 0) {
            return j();
        }
        return j8;
    }

    @Override // com.hivemq.client.internal.mqtt.handler.util.FlowWithEventLoop
    protected void e() {
        if (this.f18262m.get() == 2) {
            this.f18352g.execute(this);
        }
        k();
    }

    @Override // org.reactivestreams.Subscription
    public void f(long j8) {
        if (j8 > 0 && !isCancelled()) {
            BackpressureHelper.a(this.f18261l, j8);
            if (this.f18262m.getAndSet(1) == 2) {
                this.f18352g.execute(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttAckFlow
    public void h(long j8) {
        if (j8 > 0) {
            long j9 = this.f18263n + j8;
            this.f18263n = j9;
            if (j9 == this.f18264o.get() && g()) {
                Throwable th = this.f18265p;
                if (th != null) {
                    this.f18258i.onError(th);
                } else {
                    this.f18258i.onComplete();
                }
            }
            this.f18259j.z(j8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttAckFlow
    public void i(MqttPublishResult mqttPublishResult) {
        this.f18266q.m(mqttPublishResult);
        run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(MqttPublishFlowableAckLink.LinkedFlow linkedFlow) {
        if (!androidx.camera.view.e.a(this.f18267r, null, linkedFlow)) {
            linkedFlow.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(long j8) {
        if (this.f18264o.compareAndSet(0L, j8) && this.f18263n == j8 && g()) {
            this.f18258i.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Throwable th, long j8) {
        this.f18265p = th;
        if (!this.f18264o.compareAndSet(0L, j8)) {
            RxJavaPlugins.s(th);
        } else if (this.f18263n == j8 && g()) {
            this.f18258i.onError(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (isCancelled() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r9.f18266q.poll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        if (r0.a() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        r4 = r4 + 1;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r9 = this;
            long r0 = r9.o()
            r2 = 0
            r4 = r2
        L7:
            int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r6 >= 0) goto L46
        Lb:
            com.hivemq.client.internal.util.collections.ChunkedArrayQueue<com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult> r6 = r9.f18266q
            java.lang.Object r6 = r6.poll()
            com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult r6 = (com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult) r6
            if (r6 != 0) goto L16
            goto L46
        L16:
            org.reactivestreams.Subscriber<? super com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult> r7 = r9.f18258i
            r7.onNext(r6)
            boolean r6 = r6.a()
            r7 = 1
            if (r6 == 0) goto L24
            long r4 = r4 + r7
        L24:
            long r2 = r2 + r7
            int r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r6 < 0) goto Lb
            boolean r0 = r9.isCancelled()
            if (r0 == 0) goto L41
        L2f:
            com.hivemq.client.internal.util.collections.ChunkedArrayQueue<com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult> r0 = r9.f18266q
            java.lang.Object r0 = r0.poll()
            com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult r0 = (com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult) r0
            if (r0 == 0) goto L46
            boolean r0 = r0.a()
            if (r0 == 0) goto L2f
            long r4 = r4 + r7
            goto L2f
        L41:
            long r0 = r9.j()
            goto L7
        L46:
            long r0 = r9.f18260k
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 == 0) goto L54
            long r0 = r0 - r2
            r9.f18260k = r0
        L54:
            r9.h(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttAckFlowableFlow.run():void");
    }
}
