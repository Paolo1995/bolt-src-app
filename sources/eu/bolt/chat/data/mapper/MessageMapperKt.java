package eu.bolt.chat.data.mapper;

import eu.bolt.chat.data.ChatStatus;
import eu.bolt.chat.data.EndChatInfo;
import eu.bolt.chat.data.QuickReplySuggestion;
import eu.bolt.chat.data.message.AttributionInfo;
import eu.bolt.chat.data.message.ChatMessage;
import eu.bolt.chat.data.message.EndingServiceMessage;
import eu.bolt.chat.data.message.MessageImportance;
import eu.bolt.chat.data.message.MessageSender;
import eu.bolt.chat.data.message.MessageStatus;
import eu.bolt.chat.data.message.ServiceTextMessage;
import eu.bolt.chat.data.message.TranslationInfo;
import eu.bolt.chat.data.message.UserMessage;
import eu.bolt.chat.data.message.UserTextMessage;
import eu.bolt.chat.data.util.MessageDirectionDetector;
import eu.bolt.chat.network.data.AttributionInfoNet;
import eu.bolt.chat.network.data.ChatMessageSender;
import eu.bolt.chat.network.data.MessageEventBase;
import eu.bolt.chat.network.data.MessageStatusNet;
import eu.bolt.chat.network.data.QuickReplySuggestionNet;
import eu.bolt.chat.network.data.ServiceMessageEvent;
import eu.bolt.chat.network.data.TranslationInfoNet;
import eu.bolt.chat.network.data.UnknownMessageEvent;
import eu.bolt.chat.network.data.UserMessageEvent;
import eu.bolt.chat.util.DateTimeUtilsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;

/* compiled from: MessageMapper.kt */
/* loaded from: classes5.dex */
public final class MessageMapperKt {

    /* compiled from: MessageMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38974a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f38975b;

        static {
            int[] iArr = new int[MessageStatusNet.values().length];
            try {
                iArr[MessageStatusNet.DELIVERED_TO_BACKEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MessageStatusNet.DELIVERED_TO_RECIPIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MessageStatusNet.SEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38974a = iArr;
            int[] iArr2 = new int[ChatStatus.values().length];
            try {
                iArr2[ChatStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ChatStatus.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ChatStatus.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ChatStatus.ABORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            f38975b = iArr2;
        }
    }

    public static final QuickReplySuggestion a(QuickReplySuggestionNet quickReplySuggestionNet) {
        Intrinsics.f(quickReplySuggestionNet, "<this>");
        return new QuickReplySuggestion(quickReplySuggestionNet.a(), quickReplySuggestionNet.b());
    }

    private static final AttributionInfo b(AttributionInfoNet attributionInfoNet) {
        return new AttributionInfo(attributionInfoNet.b(), attributionInfoNet.a());
    }

    public static final ChatMessage c(MessageEventBase messageEventBase, String chatId, MessageDirectionDetector directionDetector) {
        Intrinsics.f(messageEventBase, "<this>");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(directionDetector, "directionDetector");
        if (messageEventBase instanceof UserMessageEvent) {
            return h((UserMessageEvent) messageEventBase, chatId, directionDetector);
        }
        if (messageEventBase instanceof ServiceMessageEvent) {
            return f((ServiceMessageEvent) messageEventBase, chatId);
        }
        if (messageEventBase instanceof UnknownMessageEvent) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final MessageSender d(ChatMessageSender chatMessageSender) {
        return new MessageSender(chatMessageSender.a(), chatMessageSender.b());
    }

    private static final MessageStatus e(MessageStatusNet messageStatusNet) {
        int i8 = WhenMappings.f38974a[messageStatusNet.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return MessageStatus.SEEN;
                }
                throw new NoWhenBranchMatchedException();
            }
            return MessageStatus.DELIVERED_TO_RECIPIENT;
        }
        return MessageStatus.DELIVERED_TO_BACKEND;
    }

    public static final ServiceTextMessage f(ServiceMessageEvent serviceMessageEvent, String chatId) {
        Intrinsics.f(serviceMessageEvent, "<this>");
        Intrinsics.f(chatId, "chatId");
        return new ServiceTextMessage(serviceMessageEvent.e(), chatId, DateTimeUtilsKt.b(serviceMessageEvent.b()), e(serviceMessageEvent.f()), serviceMessageEvent.g(), serviceMessageEvent.h());
    }

    private static final TranslationInfo g(TranslationInfoNet translationInfoNet) {
        return new TranslationInfo(translationInfoNet.b(), b(translationInfoNet.a()));
    }

    public static final UserMessage h(UserMessageEvent userMessageEvent, String chatId, MessageDirectionDetector directionDetector) {
        Intrinsics.f(userMessageEvent, "<this>");
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(directionDetector, "directionDetector");
        TranslationInfo translationInfo = null;
        if (userMessageEvent.h() == null || userMessageEvent.c() == null) {
            return null;
        }
        String f8 = userMessageEvent.f();
        LocalDateTime b8 = DateTimeUtilsKt.b(userMessageEvent.b());
        MessageStatus e8 = e(userMessageEvent.g());
        String h8 = userMessageEvent.h();
        boolean a8 = directionDetector.a(userMessageEvent);
        MessageSender d8 = d(userMessageEvent.c());
        String e9 = userMessageEvent.e();
        TranslationInfoNet i8 = userMessageEvent.i();
        if (i8 != null) {
            translationInfo = g(i8);
        }
        return new UserTextMessage(f8, chatId, b8, e8, h8, a8, d8, e9, translationInfo);
    }

    private static final MessageImportance i(ChatStatus chatStatus) {
        int i8 = WhenMappings.f38975b[chatStatus.ordinal()];
        if (i8 != 1 && i8 != 2 && i8 != 3) {
            if (i8 == 4) {
                return MessageImportance.HIGH;
            }
            throw new NoWhenBranchMatchedException();
        }
        return MessageImportance.LOW;
    }

    public static final EndingServiceMessage j(EndChatInfo endChatInfo, String chatId) {
        Intrinsics.f(endChatInfo, "<this>");
        Intrinsics.f(chatId, "chatId");
        return new EndingServiceMessage(endChatInfo.b(), chatId, endChatInfo.a(), MessageStatus.DELIVERED_TO_BACKEND, i(endChatInfo.d()), endChatInfo.c());
    }
}
