package eu.bolt.chat.chatcore.network.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageTranslation;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.entity.TranslationAttribution;
import eu.bolt.chat.chatcore.network.model.AttributionNetworkModel;
import eu.bolt.chat.chatcore.network.model.ChatEventRequest;
import eu.bolt.chat.chatcore.network.model.ChatEventResponse;
import eu.bolt.chat.chatcore.network.model.OrderHandleNetworkModel;
import eu.bolt.chat.chatcore.network.model.TranslationNetworkModel;
import eu.bolt.chat.chatcore.network.repo.ChatEvent;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: ChatEventMapper.kt */
/* loaded from: classes5.dex */
public final class ChatEventMapper {

    /* renamed from: a  reason: collision with root package name */
    private final UserInfoProvider f38362a;

    @Inject
    public ChatEventMapper(UserInfoProvider userInfoProvider) {
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        this.f38362a = userInfoProvider;
    }

    private final ChatEventRequest.Message a(ChatMessageEntity chatMessageEntity) {
        List k8;
        String d8 = chatMessageEntity.d();
        String j8 = chatMessageEntity.j();
        k8 = CollectionsKt__CollectionsKt.k();
        return new ChatEventRequest.Message(d8, j8, k8);
    }

    private final ChatEventRequest.QuickReplyMessage b(ChatMessageEntity chatMessageEntity) {
        List k8;
        String d8 = chatMessageEntity.d();
        String j8 = chatMessageEntity.j();
        k8 = CollectionsKt__CollectionsKt.k();
        return new ChatEventRequest.QuickReplyMessage(d8, j8, chatMessageEntity.e(), k8);
    }

    private final QuickReplyEntity d(ChatEventResponse.QuickReplies.QuickReplySuggestion quickReplySuggestion) {
        return new QuickReplyEntity(quickReplySuggestion.a(), quickReplySuggestion.b());
    }

    private final TranslationAttribution m(AttributionNetworkModel attributionNetworkModel) {
        return new TranslationAttribution(attributionNetworkModel.b(), attributionNetworkModel.a());
    }

    public final ChatMessageTranslation c(TranslationNetworkModel model) {
        TranslationAttribution translationAttribution;
        Intrinsics.f(model, "model");
        String b8 = model.b();
        AttributionNetworkModel a8 = model.a();
        if (a8 != null) {
            translationAttribution = m(a8);
        } else {
            translationAttribution = null;
        }
        return new ChatMessageTranslation(b8, translationAttribution);
    }

    public final ChatEvent.MessagesSeenConfirmation e(ChatEventResponse.MessagesSeenConfirmation event) {
        Intrinsics.f(event, "event");
        return new ChatEvent.MessagesSeenConfirmation(event.b());
    }

    public final ChatEventRequest f(ChatMessageEntity messageEntity) {
        boolean y7;
        Intrinsics.f(messageEntity, "messageEntity");
        String e8 = messageEntity.e();
        boolean z7 = false;
        if (e8 != null) {
            y7 = StringsKt__StringsJVMKt.y(e8);
            if (!y7) {
                z7 = true;
            }
        }
        if (z7) {
            return b(messageEntity);
        }
        return a(messageEntity);
    }

    public final ChatEvent.NewMessage g(String chatId, ChatEventResponse.NewMessage event) {
        List k8;
        ChatMessageTranslation chatMessageTranslation;
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(event, "event");
        String b8 = event.b();
        ChatMessageType chatMessageType = ChatMessageType.TEXT;
        long a8 = event.a();
        String d8 = event.d();
        k8 = CollectionsKt__CollectionsKt.k();
        String a9 = event.c().a();
        String b9 = event.c().b();
        ChatMessageStatus.DeliveredToBackend deliveredToBackend = ChatMessageStatus.DeliveredToBackend.f38163b;
        boolean a10 = Intrinsics.a(event.c().a(), this.f38362a.k());
        TranslationNetworkModel e8 = event.e();
        if (e8 != null) {
            chatMessageTranslation = c(e8);
        } else {
            chatMessageTranslation = null;
        }
        return new ChatEvent.NewMessage(new ChatMessageEntity(b8, chatId, chatMessageType, k8, d8, null, a9, b9, a8, deliveredToBackend, a10, 15, false, chatMessageTranslation, 4128, null));
    }

    public final OrderHandleEntity h(OrderHandleNetworkModel model) {
        Intrinsics.f(model, "model");
        return new OrderHandleEntity(model.b(), model.c(), model.a());
    }

    public final ChatEvent.QuickReplies i(ChatEventResponse.QuickReplies event) {
        int v7;
        Intrinsics.f(event, "event");
        List<ChatEventResponse.QuickReplies.QuickReplySuggestion> b8 = event.b();
        v7 = CollectionsKt__IterablesKt.v(b8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (ChatEventResponse.QuickReplies.QuickReplySuggestion quickReplySuggestion : b8) {
            arrayList.add(d(quickReplySuggestion));
        }
        return new ChatEvent.QuickReplies(arrayList);
    }

    public final ChatEvent.ServiceMessage j(String chatId, ChatEventResponse.ServiceMessageEvent event) {
        List k8;
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(event, "event");
        String b8 = event.b();
        ChatMessageType chatMessageType = ChatMessageType.SERVICE;
        long a8 = event.a();
        k8 = CollectionsKt__CollectionsKt.k();
        return new ChatEvent.ServiceMessage(new ChatMessageEntity(b8, chatId, chatMessageType, k8, event.c(), null, "", "", a8, ChatMessageStatus.DeliveredToBackend.f38163b, false, 0, event.d(), null, 32, null));
    }

    public final ChatEvent.StartChat k(String chatId, ChatEventResponse.StartEvent event) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(event, "event");
        return new ChatEvent.StartChat(new ChatEntity(chatId, event.d(), event.e(), event.b(), event.a(), h(event.c())));
    }

    public final ChatEvent.TerminalMessage l(String chatId, ChatEventResponse.TerminalEvent event) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(event, "event");
        return new ChatEvent.TerminalMessage(new TerminationInfo(event.b(), chatId, event.c(), event.d(), event.a()));
    }
}
