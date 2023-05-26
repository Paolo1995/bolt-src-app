package eu.bolt.chat.chatcore.chatsdk.mapper;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageTranslation;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.entity.TerminationInfoStatus;
import eu.bolt.chat.chatcore.entity.TranslationAttribution;
import eu.bolt.chat.data.QuickReplySuggestion;
import eu.bolt.chat.data.message.AttributionInfo;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.data.message.EndingServiceMessage;
import eu.bolt.chat.data.message.MessageImportance;
import eu.bolt.chat.data.message.MessageStatus;
import eu.bolt.chat.data.message.ServiceTextMessage;
import eu.bolt.chat.data.message.TranslationInfo;
import eu.bolt.chat.data.message.UserTextMessage;
import eu.bolt.chat.util.DateTimeUtilsAndroid;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageMapper.kt */
/* loaded from: classes5.dex */
public final class MessageMapper {

    /* compiled from: MessageMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38064a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f38065b;

        static {
            int[] iArr = new int[MessageStatus.values().length];
            try {
                iArr[MessageStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageStatus.SENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageStatus.SENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MessageStatus.DELIVERED_TO_BACKEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MessageStatus.DELIVERED_TO_RECIPIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MessageStatus.SEEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f38064a = iArr;
            int[] iArr2 = new int[MessageImportance.values().length];
            try {
                iArr2[MessageImportance.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MessageImportance.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[MessageImportance.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            f38065b = iArr2;
        }
    }

    private final ChatMessageEntity b(EndingServiceMessage endingServiceMessage) {
        List k8;
        String id = endingServiceMessage.getId();
        String d8 = endingServiceMessage.d();
        ChatMessageType chatMessageType = ChatMessageType.SERVICE;
        String j8 = endingServiceMessage.j();
        long time = DateTimeUtilsAndroid.a(endingServiceMessage.b()).getTime();
        ChatMessageStatus e8 = e(endingServiceMessage.getStatus());
        boolean f8 = endingServiceMessage.f();
        k8 = CollectionsKt__CollectionsKt.k();
        return new ChatMessageEntity(id, d8, chatMessageType, k8, j8, null, "", "", time, e8, false, 15, f8, null, 32, null);
    }

    private final ChatMessageEntity c(ServiceTextMessage serviceTextMessage) {
        List k8;
        String id = serviceTextMessage.getId();
        String d8 = serviceTextMessage.d();
        ChatMessageType chatMessageType = ChatMessageType.SERVICE;
        String i8 = serviceTextMessage.i();
        long time = DateTimeUtilsAndroid.a(serviceTextMessage.b()).getTime();
        ChatMessageStatus e8 = e(serviceTextMessage.getStatus());
        boolean f8 = serviceTextMessage.f();
        k8 = CollectionsKt__CollectionsKt.k();
        return new ChatMessageEntity(id, d8, chatMessageType, k8, i8, null, "", "", time, e8, false, 15, f8, null, 32, null);
    }

    private final ChatMessageEntity d(UserTextMessage userTextMessage) {
        ChatMessageTranslation chatMessageTranslation;
        List k8;
        String id = userTextMessage.getId();
        String d8 = userTextMessage.d();
        ChatMessageType chatMessageType = ChatMessageType.TEXT;
        String j8 = userTextMessage.j();
        String a8 = userTextMessage.i().a();
        String b8 = userTextMessage.i().b();
        boolean e8 = userTextMessage.e();
        long time = DateTimeUtilsAndroid.a(userTextMessage.b()).getTime();
        ChatMessageStatus e9 = e(userTextMessage.getStatus());
        TranslationInfo k9 = userTextMessage.k();
        if (k9 != null) {
            chatMessageTranslation = f(k9);
        } else {
            chatMessageTranslation = null;
        }
        k8 = CollectionsKt__CollectionsKt.k();
        return new ChatMessageEntity(id, d8, chatMessageType, k8, j8, null, a8, b8, time, e9, e8, 15, false, chatMessageTranslation, 32, null);
    }

    private final ChatMessageStatus e(MessageStatus messageStatus) {
        switch (WhenMappings.f38064a[messageStatus.ordinal()]) {
            case 1:
                return ChatMessageStatus.SendingError.f38167b;
            case 2:
                return ChatMessageStatus.Sending.f38166b;
            case 3:
                return ChatMessageStatus.PreliminaryDeliveredToBackend.f38164b;
            case 4:
                return ChatMessageStatus.DeliveredToBackend.f38163b;
            case 5:
                return ChatMessageStatus.DeliveredToBackend.f38163b;
            case 6:
                return new ChatMessageStatus.SeenByRecipient(false, 1, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final ChatMessageTranslation f(TranslationInfo translationInfo) {
        return new ChatMessageTranslation(translationInfo.b(), i(translationInfo.a()));
    }

    private final TerminationInfoStatus h(MessageImportance messageImportance) {
        int i8 = WhenMappings.f38065b[messageImportance.ordinal()];
        if (i8 != 1 && i8 != 2) {
            if (i8 == 3) {
                return TerminationInfoStatus.CANCELLED;
            }
            throw new NoWhenBranchMatchedException();
        }
        return TerminationInfoStatus.FINISHED;
    }

    private final TranslationAttribution i(AttributionInfo attributionInfo) {
        return new TranslationAttribution(attributionInfo.b(), attributionInfo.a());
    }

    public final ChatMessageEntity a(ChatMessage message) {
        Intrinsics.f(message, "message");
        if (message instanceof UserTextMessage) {
            return d((UserTextMessage) message);
        }
        if (message instanceof ServiceTextMessage) {
            return c((ServiceTextMessage) message);
        }
        if (message instanceof EndingServiceMessage) {
            return b((EndingServiceMessage) message);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final QuickReplyEntity g(QuickReplySuggestion quickReply) {
        Intrinsics.f(quickReply, "quickReply");
        return new QuickReplyEntity(quickReply.a(), quickReply.b());
    }

    public final TerminationInfo j(EndingServiceMessage message) {
        Intrinsics.f(message, "message");
        return new TerminationInfo(message.getId(), message.d(), message.j(), h(message.i()).c(), DateTimeUtilsAndroid.a(message.b()).getTime());
    }
}
