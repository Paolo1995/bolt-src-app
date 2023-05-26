package eu.bolt.driver.chat.service.repo;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatHistoryEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageTranslation;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.entity.TranslationAttribution;
import eu.bolt.chat.chatcore.network.model.AttributionNetworkModel;
import eu.bolt.chat.chatcore.network.model.ChatMessageSender;
import eu.bolt.chat.chatcore.network.model.TranslationNetworkModel;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.driver.chat.network.ChatHistory;
import eu.bolt.driver.chat.network.ChatHistoryMessage;
import eu.bolt.driver.chat.network.MessageType;
import eu.bolt.driver.chat.network.TerminateChatEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatHistoryMapper.kt */
/* loaded from: classes5.dex */
public final class ChatHistoryMapper {

    /* renamed from: a  reason: collision with root package name */
    private final UserInfoProvider f40505a;

    /* compiled from: ChatHistoryMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40506a;

        static {
            int[] iArr = new int[MessageType.values().length];
            try {
                iArr[MessageType.SERVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f40506a = iArr;
        }
    }

    @Inject
    public ChatHistoryMapper(UserInfoProvider chatUserInfoProvider) {
        Intrinsics.f(chatUserInfoProvider, "chatUserInfoProvider");
        this.f40505a = chatUserInfoProvider;
    }

    private final ChatEntity a(String str, ChatHistory chatHistory) {
        return new ChatEntity(str, chatHistory.a().d(), chatHistory.a().e(), chatHistory.a().a(), chatHistory.a().c(), UtilKt.a(chatHistory.a().b()));
    }

    private final ChatMessageEntity c(ChatHistoryMessage chatHistoryMessage, String str) {
        String str2;
        List k8;
        String str3;
        String b8;
        String a8;
        ChatMessageType e8 = e(chatHistoryMessage.g());
        ChatMessageTranslation chatMessageTranslation = null;
        if (e8 == null) {
            return null;
        }
        ChatMessageSender c8 = chatHistoryMessage.c();
        if (c8 == null || (a8 = c8.a()) == null) {
            str2 = "";
        } else {
            str2 = a8;
        }
        String b9 = chatHistoryMessage.b();
        k8 = CollectionsKt__CollectionsKt.k();
        String e9 = chatHistoryMessage.e();
        ChatMessageSender c9 = chatHistoryMessage.c();
        if (c9 == null || (b8 = c9.b()) == null) {
            str3 = "";
        } else {
            str3 = b8;
        }
        long a9 = chatHistoryMessage.a();
        ChatMessageStatus a10 = ChatMessageStatus.f38162a.a(chatHistoryMessage.d());
        boolean a11 = Intrinsics.a(this.f40505a.k(), str2);
        boolean h8 = chatHistoryMessage.h();
        TranslationNetworkModel f8 = chatHistoryMessage.f();
        if (f8 != null) {
            chatMessageTranslation = d(f8);
        }
        return new ChatMessageEntity(b9, str, e8, k8, e9, null, str2, str3, a9, a10, a11, 15, h8, chatMessageTranslation);
    }

    private final ChatMessageTranslation d(TranslationNetworkModel translationNetworkModel) {
        TranslationAttribution translationAttribution;
        String b8 = translationNetworkModel.b();
        AttributionNetworkModel a8 = translationNetworkModel.a();
        if (a8 != null) {
            translationAttribution = h(a8);
        } else {
            translationAttribution = null;
        }
        return new ChatMessageTranslation(b8, translationAttribution);
    }

    private final ChatMessageType e(MessageType messageType) {
        int i8 = WhenMappings.f40506a[messageType.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return ChatMessageType.TEXT;
        }
        return ChatMessageType.SERVICE;
    }

    private final List<ChatMessageEntity> f(ChatHistory chatHistory, String str) {
        List<ChatMessageEntity> k8;
        List<ChatHistoryMessage> b8 = chatHistory.b();
        if (b8 != null) {
            ArrayList arrayList = new ArrayList();
            for (ChatHistoryMessage chatHistoryMessage : b8) {
                ChatMessageEntity c8 = c(chatHistoryMessage, str);
                if (c8 != null) {
                    arrayList.add(c8);
                }
            }
            return arrayList;
        }
        k8 = CollectionsKt__CollectionsKt.k();
        return k8;
    }

    private final TerminationInfo g(ChatHistory chatHistory, String str) {
        TerminateChatEvent c8 = chatHistory.c();
        if (c8 != null) {
            return new TerminationInfo(c8.b(), str, c8.c(), c8.d(), c8.a());
        }
        return null;
    }

    private final TranslationAttribution h(AttributionNetworkModel attributionNetworkModel) {
        return new TranslationAttribution(attributionNetworkModel.b(), attributionNetworkModel.a());
    }

    public final ChatHistoryEntity b(String chatId, ChatHistory historyResponse) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(historyResponse, "historyResponse");
        return new ChatHistoryEntity(a(chatId, historyResponse), f(historyResponse, chatId), g(historyResponse, chatId));
    }
}
