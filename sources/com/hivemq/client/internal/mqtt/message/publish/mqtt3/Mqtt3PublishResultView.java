package com.hivemq.client.internal.mqtt.message.publish.mqtt3;

import com.hivemq.client.internal.mqtt.exceptions.mqtt3.Mqtt3ExceptionFactory;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublishResult;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishResult;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5PublishResult;
import io.reactivex.functions.Function;
import j$.util.Optional;

/* loaded from: classes3.dex */
public class Mqtt3PublishResultView implements Mqtt3PublishResult {

    /* renamed from: b  reason: collision with root package name */
    public static final Function<Mqtt5PublishResult, Mqtt3PublishResult> f18568b = new Function() { // from class: com.hivemq.client.internal.mqtt.message.publish.mqtt3.a
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return Mqtt3PublishResultView.b((Mqtt5PublishResult) obj);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final MqttPublishResult f18569a;

    private Mqtt3PublishResultView(MqttPublishResult mqttPublishResult) {
        this.f18569a = mqttPublishResult;
    }

    public static Mqtt3PublishResultView b(Mqtt5PublishResult mqtt5PublishResult) {
        return new Mqtt3PublishResultView((MqttPublishResult) mqtt5PublishResult);
    }

    private String c() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("publish=");
        sb.append(a());
        if (!getError().isPresent()) {
            str = "";
        } else {
            str = ", error=" + getError().get();
        }
        sb.append(str);
        return sb.toString();
    }

    public Mqtt3Publish a() {
        return Mqtt3PublishView.h(this.f18569a.d());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3PublishResultView)) {
            return false;
        }
        return this.f18569a.equals(((Mqtt3PublishResultView) obj).f18569a);
    }

    @Override // com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishResult
    public Optional<Throwable> getError() {
        return this.f18569a.c().map(Mqtt3ExceptionFactory.f18002b);
    }

    public int hashCode() {
        return this.f18569a.hashCode();
    }

    public String toString() {
        return "MqttPublishResult{" + c() + '}';
    }
}
