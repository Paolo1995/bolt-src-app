package com.hivemq.client.internal.mqtt.handler.publish.outgoing;

import com.hivemq.client.internal.mqtt.MqttClientConfig;
import com.hivemq.client.internal.mqtt.exceptions.MqttClientStateExceptions;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PublishResult;
import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public class MqttAckSingleFlowable extends Flowable<Mqtt5PublishResult> {

    /* renamed from: g  reason: collision with root package name */
    private final MqttClientConfig f18268g;

    /* renamed from: h  reason: collision with root package name */
    private final MqttPublish f18269h;

    /* loaded from: classes3.dex */
    private static class Flow extends MqttAckFlow implements Subscription, Runnable {

        /* renamed from: i  reason: collision with root package name */
        private final Subscriber<? super Mqtt5PublishResult> f18270i;

        /* renamed from: j  reason: collision with root package name */
        private final MqttOutgoingQosHandler f18271j;

        /* renamed from: k  reason: collision with root package name */
        private final AtomicInteger f18272k;

        /* renamed from: l  reason: collision with root package name */
        private MqttPublishResult f18273l;

        Flow(Subscriber<? super Mqtt5PublishResult> subscriber, MqttClientConfig mqttClientConfig, MqttOutgoingQosHandler mqttOutgoingQosHandler) {
            super(mqttClientConfig);
            this.f18272k = new AtomicInteger(0);
            this.f18270i = subscriber;
            this.f18271j = mqttOutgoingQosHandler;
            init();
        }

        private void j(MqttPublishResult mqttPublishResult) {
            if (mqttPublishResult.a()) {
                h(1L);
            }
        }

        @Override // com.hivemq.client.internal.mqtt.handler.util.FlowWithEventLoop
        protected void e() {
            if (this.f18272k.getAndSet(3) == 1) {
                this.f18352g.execute(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void f(long j8) {
            if (j8 > 0 && this.f18272k.getAndSet(2) == 1) {
                this.f18352g.execute(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttAckFlow
        public void h(long j8) {
            if (g()) {
                this.f18270i.onComplete();
            }
            this.f18271j.z(1L);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttAckFlow
        public void i(MqttPublishResult mqttPublishResult) {
            int i8 = this.f18272k.get();
            if (i8 != 0) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        j(mqttPublishResult);
                        return;
                    }
                    return;
                }
                this.f18270i.onNext(mqttPublishResult);
                j(mqttPublishResult);
            } else if (this.f18272k.compareAndSet(0, 1)) {
                this.f18273l = mqttPublishResult;
            } else {
                i(mqttPublishResult);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            MqttPublishResult mqttPublishResult = this.f18273l;
            if (mqttPublishResult != null) {
                this.f18273l = null;
                if (!isCancelled()) {
                    this.f18270i.onNext(mqttPublishResult);
                }
                j(mqttPublishResult);
            }
        }
    }

    public MqttAckSingleFlowable(MqttClientConfig mqttClientConfig, MqttPublish mqttPublish) {
        this.f18268g = mqttClientConfig;
        this.f18269h = mqttPublish;
    }

    @Override // io.reactivex.Flowable
    protected void Z(Subscriber<? super Mqtt5PublishResult> subscriber) {
        if (this.f18268g.getState().a()) {
            MqttOutgoingQosHandler b8 = this.f18268g.e().b();
            MqttPublishFlowables m8 = b8.m();
            Flow flow = new Flow(subscriber, this.f18268g, b8);
            subscriber.c(flow);
            m8.h0(Flowable.I(new MqttPublishWithFlow(this.f18269h, flow)));
            return;
        }
        EmptySubscription.e(MqttClientStateExceptions.b(), subscriber);
    }
}
