package eu.bolt.chat.chatcore.hivemq;

import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish;
import eu.bolt.chat.chatcore.network.model.MqttEventResponse;
import io.reactivex.Flowable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HiveMqttController.kt */
/* loaded from: classes5.dex */
/* synthetic */ class HiveMqttController$subscribeNewChatEvents$2 extends FunctionReferenceImpl implements Function1<Mqtt3Publish, Flowable<MqttEventResponse>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HiveMqttController$subscribeNewChatEvents$2(Object obj) {
        super(1, obj, HiveMqttController.class, "handleEvent", "handleEvent(Lcom/hivemq/client/mqtt/mqtt3/message/publish/Mqtt3Publish;)Lio/reactivex/Flowable;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final Flowable<MqttEventResponse> invoke(Mqtt3Publish p02) {
        Flowable<MqttEventResponse> z7;
        Intrinsics.f(p02, "p0");
        z7 = ((HiveMqttController) this.f50989g).z(p02);
        return z7;
    }
}
