package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.logging.InternalLogger;
import com.hivemq.client.internal.logging.InternalLoggerFactory;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class MqttPublishFlowableAckLink extends Flowable<MqttPublishWithFlow> {

    /* renamed from: g  reason: collision with root package name */
    private final Flowable<MqttPublish> f18294g;

    /* renamed from: h  reason: collision with root package name */
    private final MqttAckFlowableFlow f18295h;

    /* loaded from: classes3.dex */
    private static class AckLinkSubscriber implements FlowableSubscriber<MqttPublish>, Subscription, LinkedFlow {

        /* renamed from: l  reason: collision with root package name */
        private static final InternalLogger f18296l = InternalLoggerFactory.a(AckLinkSubscriber.class);

        /* renamed from: f  reason: collision with root package name */
        private final Subscriber<? super MqttPublishWithFlow> f18297f;

        /* renamed from: g  reason: collision with root package name */
        private final MqttAckFlowableFlow f18298g;

        /* renamed from: h  reason: collision with root package name */
        private Subscription f18299h;

        /* renamed from: i  reason: collision with root package name */
        private final AtomicInteger f18300i = new AtomicInteger(0);

        /* renamed from: j  reason: collision with root package name */
        private final AtomicInteger f18301j = new AtomicInteger(0);

        /* renamed from: k  reason: collision with root package name */
        private long f18302k;

        AckLinkSubscriber(Subscriber<? super MqttPublishWithFlow> subscriber, MqttAckFlowableFlow mqttAckFlowableFlow) {
            this.f18297f = subscriber;
            this.f18298g = mqttAckFlowableFlow;
        }

        private void b() {
            if (this.f18301j.getAndSet(3) == 0) {
                this.f18299h.cancel();
            }
            this.f18297f.onComplete();
        }

        @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttPublishFlowableAckLink.LinkedFlow
        public void a() {
            if (this.f18300i.getAndSet(3) == 0) {
                b();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void c(Subscription subscription) {
            this.f18299h = subscription;
            this.f18297f.c(this);
            this.f18298g.l(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            f18296l.error("MqttPublishFlowables is global and must never cancel. This must not happen and is a bug.");
        }

        @Override // org.reactivestreams.Subscriber
        /* renamed from: d */
        public void onNext(MqttPublish mqttPublish) {
            if (this.f18300i.compareAndSet(0, 1)) {
                this.f18297f.onNext(new MqttPublishWithFlow(mqttPublish, this.f18298g));
                this.f18302k++;
                if (!this.f18300i.compareAndSet(1, 0)) {
                    b();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (this.f18301j.compareAndSet(0, 1)) {
                this.f18299h.f(j8);
                if (!this.f18301j.compareAndSet(1, 0)) {
                    this.f18299h.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f18300i.compareAndSet(0, 2)) {
                this.f18297f.onComplete();
                this.f18298g.m(this.f18302k);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f18300i.compareAndSet(0, 2)) {
                this.f18297f.onComplete();
                this.f18298g.n(th, this.f18302k);
                return;
            }
            RxJavaPlugins.s(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface LinkedFlow {

        /* renamed from: a  reason: collision with root package name */
        public static final LinkedFlow f18303a = new LinkedFlow() { // from class: com.hivemq.client.internal.mqtt.handler.publish.outgoing.c
            @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttPublishFlowableAckLink.LinkedFlow
            public final void a() {
                d.a();
            }
        };

        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MqttPublishFlowableAckLink(Flowable<MqttPublish> flowable, MqttAckFlowableFlow mqttAckFlowableFlow) {
        this.f18294g = flowable;
        this.f18295h = mqttAckFlowableFlow;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super MqttPublishWithFlow> subscriber) {
        this.f18294g.Y(new AckLinkSubscriber(subscriber, this.f18295h));
    }
}
