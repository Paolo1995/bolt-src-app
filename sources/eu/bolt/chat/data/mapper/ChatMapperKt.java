package eu.bolt.chat.data.mapper;

import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.ChatStatus;
import eu.bolt.chat.data.EndChatInfo;
import eu.bolt.chat.data.OrderHandle;
import eu.bolt.chat.network.data.ActiveChatNet;
import eu.bolt.chat.network.data.ChatDetailsNet;
import eu.bolt.chat.network.data.ChatStatusNet;
import eu.bolt.chat.network.data.EndChatEvent;
import eu.bolt.chat.network.data.StartChatEvent;
import eu.bolt.chat.util.DateTimeUtilsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMapper.kt */
/* loaded from: classes5.dex */
public final class ChatMapperKt {

    /* compiled from: ChatMapper.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38973a;

        static {
            int[] iArr = new int[ChatStatusNet.values().length];
            try {
                iArr[ChatStatusNet.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatStatusNet.ABORTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChatStatusNet.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38973a = iArr;
        }
    }

    public static final Chat a(ActiveChatNet activeChatNet) {
        Intrinsics.f(activeChatNet, "<this>");
        return new Chat(activeChatNet.a(), activeChatNet.e(), activeChatNet.b(), activeChatNet.d(), OrderHandleMapperKt.a(activeChatNet.c()), ChatStatus.STARTED);
    }

    public static final Chat b(ChatDetailsNet chatDetailsNet, String id, EndChatEvent endChatEvent) {
        ChatStatus d8;
        ChatStatusNet g8;
        ChatStatus d9;
        Intrinsics.f(chatDetailsNet, "<this>");
        Intrinsics.f(id, "id");
        String e8 = chatDetailsNet.e();
        String b8 = chatDetailsNet.b();
        String d10 = chatDetailsNet.d();
        OrderHandle a8 = OrderHandleMapperKt.a(chatDetailsNet.c());
        if (endChatEvent != null && (g8 = endChatEvent.g()) != null && (d9 = d(g8)) != null) {
            d8 = d9;
        } else {
            d8 = d(chatDetailsNet.a());
        }
        return new Chat(id, e8, b8, d10, a8, d8);
    }

    public static final Chat c(StartChatEvent startChatEvent, String chatId) {
        Intrinsics.f(startChatEvent, "<this>");
        Intrinsics.f(chatId, "chatId");
        return new Chat(chatId, startChatEvent.i(), startChatEvent.e(), startChatEvent.h(), OrderHandleMapperKt.a(startChatEvent.g()), ChatStatus.STARTED);
    }

    private static final ChatStatus d(ChatStatusNet chatStatusNet) {
        int i8 = WhenMappings.f38973a[chatStatusNet.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return ChatStatus.FINISHED;
                }
                throw new NoWhenBranchMatchedException();
            }
            return ChatStatus.ABORTED;
        }
        return ChatStatus.STARTED;
    }

    public static final EndChatInfo e(EndChatEvent endChatEvent) {
        Intrinsics.f(endChatEvent, "<this>");
        return new EndChatInfo(endChatEvent.e(), DateTimeUtilsKt.b(endChatEvent.b()), endChatEvent.f(), d(endChatEvent.g()));
    }
}
