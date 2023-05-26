package eu.bolt.chat.chatcore.hivemq;

import eu.bolt.chat.chatcore.network.model.MqttEventResponse;
import eu.bolt.chat.chatcore.network.repo.ChatEvent;
import eu.bolt.chat.chatcore.network.repo.MqttChatEventMapper;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HiveMqttController.kt */
/* loaded from: classes5.dex */
/* synthetic */ class HiveMqttController$subscribeNewChatEvents$4 extends FunctionReferenceImpl implements Function1<MqttEventResponse, ChatEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HiveMqttController$subscribeNewChatEvents$4(Object obj) {
        super(1, obj, MqttChatEventMapper.class, "toChatEvent", "toChatEvent(Leu/bolt/chat/chatcore/network/model/MqttEventResponse;)Leu/bolt/chat/chatcore/network/repo/ChatEvent;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final ChatEvent invoke(MqttEventResponse p02) {
        Intrinsics.f(p02, "p0");
        return ((MqttChatEventMapper) this.f50989g).c(p02);
    }
}
