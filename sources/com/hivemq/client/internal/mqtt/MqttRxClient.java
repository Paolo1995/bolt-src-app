package com.hivemq.client.internal.mqtt;

import com.hivemq.client.internal.mqtt.handler.connect.MqttConnAckSingle;
import com.hivemq.client.internal.mqtt.handler.disconnect.MqttDisconnectCompletable;
import com.hivemq.client.internal.mqtt.handler.publish.incoming.MqttSubscribedPublishFlowable;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttAckFlowable;
import com.hivemq.client.internal.mqtt.handler.publish.outgoing.MqttAckSingleFlowable;
import com.hivemq.client.internal.mqtt.message.connect.MqttConnect;
import com.hivemq.client.internal.mqtt.message.disconnect.MqttDisconnect;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.subscribe.MqttSubscribe;
import com.hivemq.client.internal.mqtt.util.MqttChecks;
import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.MqttClientState;
import com.hivemq.client.mqtt.mqtt5.message.connect.Mqtt5Connect;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import com.hivemq.client.mqtt.mqtt5.message.disconnect.Mqtt5Disconnect;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PublishResult;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.Mqtt5Subscribe;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAck;
import com.hivemq.client.rx.FlowableWithSingle;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ScalarCallable;

/* loaded from: classes3.dex */
public class MqttRxClient implements MqttClient {

    /* renamed from: b  reason: collision with root package name */
    private static final Function<Mqtt5Publish, MqttPublish> f17830b = new Function() { // from class: com.hivemq.client.internal.mqtt.c
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return MqttChecks.g((Mqtt5Publish) obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MqttClientConfig f17831a;

    public MqttRxClient(MqttClientConfig mqttClientConfig) {
        this.f17831a = mqttClientConfig;
    }

    Single<Mqtt5ConnAck> g(MqttConnect mqttConnect) {
        return i(mqttConnect).z(this.f17831a.k().a());
    }

    @Override // com.hivemq.client.mqtt.MqttClient
    public /* synthetic */ MqttClientState getState() {
        return p0.a.a(this);
    }

    public Single<Mqtt5ConnAck> h(Mqtt5Connect mqtt5Connect) {
        return g(MqttChecks.d(mqtt5Connect));
    }

    Single<Mqtt5ConnAck> i(MqttConnect mqttConnect) {
        return new MqttConnAckSingle(this.f17831a, mqttConnect);
    }

    Completable j(MqttDisconnect mqttDisconnect) {
        return l(mqttDisconnect).z(this.f17831a.k().a());
    }

    public Completable k(Mqtt5Disconnect mqtt5Disconnect) {
        return j(MqttChecks.e(mqtt5Disconnect));
    }

    Completable l(MqttDisconnect mqttDisconnect) {
        return new MqttDisconnectCompletable(this.f17831a, mqttDisconnect);
    }

    @Override // com.hivemq.client.mqtt.MqttClient
    /* renamed from: m */
    public MqttClientConfig d() {
        return this.f17831a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <P> Flowable<Mqtt5PublishResult> n(Flowable<P> flowable, Function<P, MqttPublish> function) {
        Scheduler a8 = this.f17831a.k().a();
        if (flowable instanceof ScalarCallable) {
            Object call = ((ScalarCallable) flowable).call();
            if (call == null) {
                return Flowable.r();
            }
            try {
                return new MqttAckSingleFlowable(this.f17831a, (MqttPublish) function.apply(call)).M(a8, true);
            } catch (Throwable th) {
                return Flowable.s(th);
            }
        }
        return new MqttAckFlowable(this.f17831a, flowable.a0(a8).J(function)).M(a8, true);
    }

    FlowableWithSingle<Mqtt5Publish, Mqtt5SubAck> o(MqttSubscribe mqttSubscribe, boolean z7) {
        return q(mqttSubscribe, z7).m0(this.f17831a.k().a(), true);
    }

    public FlowableWithSingle<Mqtt5Publish, Mqtt5SubAck> p(Mqtt5Subscribe mqtt5Subscribe, boolean z7) {
        return o(MqttChecks.k(mqtt5Subscribe), z7);
    }

    FlowableWithSingle<Mqtt5Publish, Mqtt5SubAck> q(MqttSubscribe mqttSubscribe, boolean z7) {
        return new MqttSubscribedPublishFlowable(mqttSubscribe, this.f17831a, z7);
    }
}
