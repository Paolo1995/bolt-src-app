package t0;

import com.hivemq.client.internal.mqtt.message.publish.mqtt3.Mqtt3PublishViewBuilder;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3PublishBuilder;

/* compiled from: Mqtt3Publish.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    static {
        MqttQos mqttQos = Mqtt3Publish.f18786a;
    }

    public static Mqtt3PublishBuilder a() {
        return new Mqtt3PublishViewBuilder.Default();
    }
}
