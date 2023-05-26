package eu.bolt.chat.chatcore.push;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageTranslation;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import eu.bolt.chat.chatcore.network.model.ChatPushDomain;
import eu.bolt.chat.chatcore.network.model.TranslationNetworkModel;
import eu.bolt.chat.chatcore.network.repo.ChatEventMapper;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.extensions.ChatRxExtensionsKt;
import eu.bolt.chat.tools.deps.RxSchedulers;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Completable;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ChatPushHandlerImpl.kt */
/* loaded from: classes5.dex */
public final class ChatPushHandlerImpl implements ChatPushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final InternalChatRepo f38378a;

    /* renamed from: b  reason: collision with root package name */
    private final UserInfoProvider f38379b;

    /* renamed from: c  reason: collision with root package name */
    private final Logger f38380c;

    /* renamed from: d  reason: collision with root package name */
    private final Gson f38381d;

    /* renamed from: e  reason: collision with root package name */
    private final RxSchedulers f38382e;

    /* renamed from: f  reason: collision with root package name */
    private final ChatEventMapper f38383f;

    public ChatPushHandlerImpl(InternalChatRepo chatRepo, UserInfoProvider userInfoProvider, Logger logger, Gson gson, RxSchedulers deps, ChatEventMapper chatEventMapper) {
        Intrinsics.f(chatRepo, "chatRepo");
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        Intrinsics.f(logger, "logger");
        Intrinsics.f(gson, "gson");
        Intrinsics.f(deps, "deps");
        Intrinsics.f(chatEventMapper, "chatEventMapper");
        this.f38378a = chatRepo;
        this.f38379b = userInfoProvider;
        this.f38380c = logger;
        this.f38381d = gson;
        this.f38382e = deps;
        this.f38383f = chatEventMapper;
    }

    private final ChatPushDomain c(Map<String, String> map) {
        if (!Intrinsics.a(map.get("domain"), "chat")) {
            return null;
        }
        try {
            return (ChatPushDomain) this.f38381d.fromJson(map.get("chat"), (Class<Object>) ChatPushDomain.class);
        } catch (JsonSyntaxException e8) {
            this.f38380c.a(e8, "Fail to parse chat domain JSON");
            return null;
        }
    }

    private final Completable d(ChatPushDomain chatPushDomain) {
        if (chatPushDomain.c() instanceof ChatPushDomain.Event.Message) {
            return e(chatPushDomain, (ChatPushDomain.Event.Message) chatPushDomain.c());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Completable e(ChatPushDomain chatPushDomain, ChatPushDomain.Event.Message message) {
        List k8;
        ChatMessageTranslation chatMessageTranslation;
        String b8 = message.b();
        String a8 = chatPushDomain.a();
        ChatMessageType chatMessageType = ChatMessageType.TEXT;
        k8 = CollectionsKt__CollectionsKt.k();
        String d8 = message.d();
        String a9 = message.c().a();
        String b9 = message.c().b();
        long a10 = message.a();
        ChatMessageStatus.DeliveredToBackend deliveredToBackend = ChatMessageStatus.DeliveredToBackend.f38163b;
        boolean a11 = Intrinsics.a(message.c().a(), this.f38379b.k());
        TranslationNetworkModel e8 = message.e();
        if (e8 != null) {
            chatMessageTranslation = this.f38383f.c(e8);
        } else {
            chatMessageTranslation = null;
        }
        Completable z7 = this.f38378a.g(new ChatMessageEntity(b8, a8, chatMessageType, k8, d8, null, a9, b9, a10, deliveredToBackend, a11, 15, false, chatMessageTranslation, 4096, null)).z(this.f38382e.c());
        Intrinsics.e(z7, "chatRepo.addChatMessage(…    .observeOn(deps.main)");
        return z7;
    }

    private final ChatEntity f(ChatPushDomain chatPushDomain) {
        return new ChatEntity(chatPushDomain.a(), chatPushDomain.f(), chatPushDomain.g(), chatPushDomain.b(), chatPushDomain.e(), this.f38383f.h(chatPushDomain.d()));
    }

    @Override // eu.bolt.chat.chatcore.push.ChatPushHandler
    public boolean a(final Map<String, String> data) {
        Intrinsics.f(data, "data");
        try {
            ChatPushDomain c8 = c(data);
            if (c8 == null) {
                return false;
            }
            Completable d8 = this.f38378a.c(f(c8)).I(this.f38382e.b()).d(d(c8));
            Intrinsics.e(d8, "chatRepo.addOrUpdateChat…en(handleEvent(chatData))");
            ChatRxExtensionsKt.x(d8, new Function0<Unit>() { // from class: eu.bolt.chat.chatcore.push.ChatPushHandlerImpl$handleRemoteMessageData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void b() {
                    Logger logger;
                    logger = ChatPushHandlerImpl.this.f38380c;
                    logger.b("Push " + data.get(Name.MARK) + " handled successfully");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    b();
                    return Unit.f50853a;
                }
            }, new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.chatcore.push.ChatPushHandlerImpl$handleRemoteMessageData$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Logger logger;
                    Intrinsics.f(it, "it");
                    logger = ChatPushHandlerImpl.this.f38380c;
                    logger.a(it, "Fail to handle push " + data);
                }
            }, null, 4, null);
            return true;
        } catch (Exception e8) {
            this.f38380c.a(e8, "Exception during parsing chat push event");
            return false;
        }
    }
}
