package com.hivemq.client.internal.mqtt.mqtt3;

import com.hivemq.client.internal.mqtt.MqttRxClient;
import com.hivemq.client.internal.mqtt.exceptions.mqtt3.Mqtt3ExceptionFactory;
import com.hivemq.client.internal.mqtt.message.connect.connack.mqtt3.Mqtt3ConnAckView;
import com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectView;
import com.hivemq.client.internal.mqtt.message.connect.mqtt3.Mqtt3ConnectViewBuilder;
import com.hivemq.client.internal.mqtt.message.disconnect.mqtt3.Mqtt3DisconnectView;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.mqtt3.Mqtt3PublishResultView;
import com.hivemq.client.internal.mqtt.message.publish.mqtt3.Mqtt3PublishView;
import com.hivemq.client.internal.mqtt.message.subscribe.mqtt3.Mqtt3SubscribeViewBuilder;
import com.hivemq.client.internal.mqtt.message.subscribe.suback.mqtt3.Mqtt3SubAckView;
import com.hivemq.client.internal.mqtt.mqtt3.Mqtt3RxClientView;
import com.hivemq.client.internal.mqtt.util.MqttChecks;
import com.hivemq.client.internal.util.Checks;
import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3Connect;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishResult;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscribe;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PublishResult;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAck;
import com.hivemq.client.rx.FlowableWithSingle;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import j$.util.function.Function;
import p0.a;

/* loaded from: classes3.dex */
public class Mqtt3RxClientView implements Mqtt3RxClient {

    /* renamed from: c  reason: collision with root package name */
    private static final Function<Mqtt3Publish, MqttPublish> f18623c = new Function() { // from class: l0.a
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return MqttChecks.f((Mqtt3Publish) obj);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Function<Throwable, Completable> f18624d = new Function() { // from class: l0.b
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            Completable n8;
            n8 = Mqtt3RxClientView.n((Throwable) obj);
            return n8;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Function<Throwable, Single<Mqtt5ConnAck>> f18625e = new Function() { // from class: l0.c
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            Single o8;
            o8 = Mqtt3RxClientView.o((Throwable) obj);
            return o8;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final Function<Throwable, Single<Mqtt5SubAck>> f18626f = new Function() { // from class: l0.d
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            Single p8;
            p8 = Mqtt3RxClientView.p((Throwable) obj);
            return p8;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final Function<Throwable, Flowable<Mqtt5Publish>> f18627g = new Function() { // from class: l0.e
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            Flowable q8;
            q8 = Mqtt3RxClientView.q((Throwable) obj);
            return q8;
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private static final Function<Throwable, Flowable<Mqtt5PublishResult>> f18628h = new Function() { // from class: l0.f
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            Flowable r7;
            r7 = Mqtt3RxClientView.r((Throwable) obj);
            return r7;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MqttRxClient f18629a;

    /* renamed from: b  reason: collision with root package name */
    private final Mqtt3ClientConfigView f18630b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class Mqtt3SubscribeViewPublishesBuilder extends Mqtt3SubscribeViewBuilder.Publishes<FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck>> {
        private Mqtt3SubscribeViewPublishesBuilder() {
        }

        @Override // com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Publishes$Args
        /* renamed from: l */
        public FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck> c() {
            return Mqtt3RxClientView.this.s(d(), this.f18611c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mqtt3RxClientView(MqttRxClient mqttRxClient) {
        this.f18629a = mqttRxClient;
        this.f18630b = new Mqtt3ClientConfigView(mqttRxClient.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Completable n(Throwable th) throws Exception {
        return Completable.t(Mqtt3ExceptionFactory.c(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Single o(Throwable th) throws Exception {
        return Single.error(Mqtt3ExceptionFactory.c(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Single p(Throwable th) throws Exception {
        return Single.error(Mqtt3ExceptionFactory.c(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Flowable q(Throwable th) throws Exception {
        return Flowable.s(Mqtt3ExceptionFactory.c(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Flowable r(Throwable th) throws Exception {
        return Flowable.s(Mqtt3ExceptionFactory.c(th));
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient
    public Single<Mqtt3ConnAck> c(Mqtt3Connect mqtt3Connect) {
        return this.f18629a.h(MqttChecks.c(mqtt3Connect)).B(f18625e).x(Mqtt3ConnAckView.f18526b);
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient
    public Completable disconnect() {
        return this.f18629a.k(Mqtt3DisconnectView.f18545a).C(f18624d);
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient
    public FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck> e(Mqtt3Subscribe mqtt3Subscribe) {
        return s(mqtt3Subscribe, false);
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient
    public Flowable<Mqtt3PublishResult> f(Flowable<Mqtt3Publish> flowable) {
        Checks.j(flowable, "Publish flowable");
        return this.f18629a.n(flowable, f18623c).S(f18628h).J(Mqtt3PublishResultView.f18568b);
    }

    @Override // com.hivemq.client.mqtt.MqttClient
    public /* synthetic */ MqttClientState getState() {
        return a.a(this);
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient
    /* renamed from: l */
    public Mqtt3ConnectViewBuilder.Nested<Single<Mqtt3ConnAck>> a() {
        return new Mqtt3ConnectViewBuilder.Nested<>(new j$.util.function.Function() { // from class: l0.g
            @Override // j$.util.function.Function
            public /* synthetic */ j$.util.function.Function andThen(j$.util.function.Function function) {
                return Function.CC.$default$andThen(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return Mqtt3RxClientView.this.c((Mqtt3ConnectView) obj);
            }

            @Override // j$.util.function.Function
            public /* synthetic */ j$.util.function.Function compose(j$.util.function.Function function) {
                return Function.CC.$default$compose(this, function);
            }
        });
    }

    @Override // com.hivemq.client.mqtt.MqttClient
    /* renamed from: m */
    public Mqtt3ClientConfigView d() {
        return this.f18630b;
    }

    public FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck> s(Mqtt3Subscribe mqtt3Subscribe, boolean z7) {
        return this.f18629a.p(MqttChecks.j(mqtt3Subscribe), z7).l0(Mqtt3ExceptionFactory.f18001a).k0(Mqtt3PublishView.f18570c, Mqtt3SubAckView.f18615b);
    }

    @Override // com.hivemq.client.mqtt.mqtt3.Mqtt3RxClient
    /* renamed from: t */
    public Mqtt3SubscribeViewPublishesBuilder b() {
        return new Mqtt3SubscribeViewPublishesBuilder();
    }
}
