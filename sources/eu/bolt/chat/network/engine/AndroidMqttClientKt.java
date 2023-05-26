package eu.bolt.chat.network.engine;

import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import eu.bolt.chat.network.data.MqttMessage;
import eu.bolt.chat.network.data.QoS;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import t0.a;

/* compiled from: AndroidMqttClient.kt */
/* loaded from: classes5.dex */
public final class AndroidMqttClientKt {

    /* compiled from: AndroidMqttClient.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39393a;

        static {
            int[] iArr = new int[QoS.values().length];
            try {
                iArr[QoS.AT_MOST_ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QoS.AT_LEAST_ONCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QoS.EXACTLY_ONCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f39393a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MqttQos d(QoS qoS) {
        int i8 = WhenMappings.f39393a[qoS.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return MqttQos.EXACTLY_ONCE;
                }
                throw new NoWhenBranchMatchedException();
            }
            return MqttQos.AT_LEAST_ONCE;
        }
        return MqttQos.AT_MOST_ONCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mqtt3Publish e(MqttMessage mqttMessage, MqttQos mqttQos) {
        Mqtt3Publish build = a.a().c(mqttMessage.c()).a(mqttQos).b(mqttMessage.a()).build();
        Intrinsics.e(build, "builder()\n        .topic…payload)\n        .build()");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MqttMessage f(Mqtt3Publish mqtt3Publish) {
        String obj = mqtt3Publish.b().toString();
        byte[] payloadAsBytes = mqtt3Publish.a();
        Intrinsics.e(payloadAsBytes, "payloadAsBytes");
        return new MqttMessage(obj, payloadAsBytes);
    }
}
