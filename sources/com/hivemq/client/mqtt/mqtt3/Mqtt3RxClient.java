package com.hivemq.client.mqtt.mqtt3;

import com.hivemq.client.mqtt.MqttClient;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3Connect;
import com.hivemq.client.mqtt.mqtt3.message.connect.Mqtt3ConnectBuilder;
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishResult;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3Subscribe;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.Mqtt3SubscribeBuilder$Publishes$Start;
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck;
import com.hivemq.client.rx.FlowableWithSingle;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

/* loaded from: classes3.dex */
public interface Mqtt3RxClient extends MqttClient {
    Mqtt3ConnectBuilder.Nested<Single<Mqtt3ConnAck>> a();

    Mqtt3SubscribeBuilder$Publishes$Start<FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck>> b();

    Single<Mqtt3ConnAck> c(Mqtt3Connect mqtt3Connect);

    Completable disconnect();

    FlowableWithSingle<Mqtt3Publish, Mqtt3SubAck> e(Mqtt3Subscribe mqtt3Subscribe);

    Flowable<Mqtt3PublishResult> f(Flowable<Mqtt3Publish> flowable);
}
