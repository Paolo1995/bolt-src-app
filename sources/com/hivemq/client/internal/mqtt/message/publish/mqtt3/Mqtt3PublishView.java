package com.hivemq.client.internal.mqtt.message.publish.mqtt3;

import com.hivemq.client.internal.mqtt.datatypes.MqttTopicImpl;
import com.hivemq.client.internal.mqtt.datatypes.MqttUserPropertiesImpl;
import com.hivemq.client.internal.mqtt.message.publish.MqttPublish;
import com.hivemq.client.internal.mqtt.message.publish.MqttStatefulPublish;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.datatypes.MqttTopic;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import io.reactivex.functions.Function;
import j$.util.function.Function;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class Mqtt3PublishView implements Mqtt3Publish {

    /* renamed from: c  reason: collision with root package name */
    public static final Function<Mqtt5Publish, Mqtt3Publish> f18570c = new Function() { // from class: com.hivemq.client.internal.mqtt.message.publish.mqtt3.b
        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return Mqtt3PublishView.i((Mqtt5Publish) obj);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final j$.util.function.Function<Mqtt5Publish, Mqtt3Publish> f18571d = new j$.util.function.Function() { // from class: com.hivemq.client.internal.mqtt.message.publish.mqtt3.c
        @Override // j$.util.function.Function
        public /* synthetic */ j$.util.function.Function andThen(j$.util.function.Function function) {
            return Function.CC.$default$andThen(this, function);
        }

        @Override // j$.util.function.Function
        public final Object apply(Object obj) {
            return Mqtt3PublishView.i((Mqtt5Publish) obj);
        }

        @Override // j$.util.function.Function
        public /* synthetic */ j$.util.function.Function compose(j$.util.function.Function function) {
            return Function.CC.$default$compose(this, function);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final MqttPublish f18572b;

    private Mqtt3PublishView(MqttPublish mqttPublish) {
        this.f18572b = mqttPublish;
    }

    public static MqttPublish c(MqttTopicImpl mqttTopicImpl, ByteBuffer byteBuffer, MqttQos mqttQos, boolean z7) {
        return new MqttPublish(mqttTopicImpl, byteBuffer, mqttQos, z7, Long.MAX_VALUE, null, null, null, null, MqttUserPropertiesImpl.f17992c, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Mqtt3PublishView g(MqttTopicImpl mqttTopicImpl, ByteBuffer byteBuffer, MqttQos mqttQos, boolean z7) {
        return new Mqtt3PublishView(c(mqttTopicImpl, byteBuffer, mqttQos, z7));
    }

    public static Mqtt3PublishView h(MqttPublish mqttPublish) {
        return new Mqtt3PublishView(mqttPublish);
    }

    public static Mqtt3PublishView i(Mqtt5Publish mqtt5Publish) {
        return new Mqtt3PublishView((MqttPublish) mqtt5Publish);
    }

    public static MqttStatefulPublish j(MqttPublish mqttPublish, int i8, boolean z7) {
        return mqttPublish.g(i8, z7, 0, MqttStatefulPublish.f18564g);
    }

    private String k() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("topic=");
        sb.append(b());
        if (this.f18572b.n() == null) {
            str = "";
        } else {
            str = ", payload=" + this.f18572b.n().remaining() + "byte";
        }
        sb.append(str);
        sb.append(", qos=");
        sb.append(e());
        sb.append(", retain=");
        sb.append(f());
        return sb.toString();
    }

    @Override // com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish
    public byte[] a() {
        return this.f18572b.i();
    }

    @Override // com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish
    public MqttTopic b() {
        return this.f18572b.q();
    }

    public MqttPublish d() {
        return this.f18572b;
    }

    public MqttQos e() {
        return this.f18572b.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mqtt3PublishView)) {
            return false;
        }
        return this.f18572b.equals(((Mqtt3PublishView) obj).f18572b);
    }

    public boolean f() {
        return this.f18572b.r();
    }

    public int hashCode() {
        return this.f18572b.hashCode();
    }

    public String toString() {
        return "MqttPublish{" + k() + '}';
    }
}
