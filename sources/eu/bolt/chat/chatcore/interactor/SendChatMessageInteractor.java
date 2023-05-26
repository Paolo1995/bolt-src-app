package eu.bolt.chat.chatcore.interactor;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageStatus;
import eu.bolt.chat.chatcore.entity.ChatMessageType;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.chatcore.user.UserInfoProvider;
import eu.bolt.chat.tools.logger.Logger;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SendChatMessageInteractor.kt */
/* loaded from: classes5.dex */
public final class SendChatMessageInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final InternalChatRepo f38270a;

    /* renamed from: b  reason: collision with root package name */
    private final IdGenerator f38271b;

    /* renamed from: c  reason: collision with root package name */
    private final UserInfoProvider f38272c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f38273d;

    @Inject
    public SendChatMessageInteractor(InternalChatRepo chatRepo, IdGenerator idGenerator, UserInfoProvider userInfoProvider, Logger logger) {
        Intrinsics.f(chatRepo, "chatRepo");
        Intrinsics.f(idGenerator, "idGenerator");
        Intrinsics.f(userInfoProvider, "userInfoProvider");
        Intrinsics.f(logger, "logger");
        this.f38270a = chatRepo;
        this.f38271b = idGenerator;
        this.f38272c = userInfoProvider;
        this.f38273d = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SendChatMessageInteractor this$0, MessageArgs args) {
        List k8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        Logger logger = this$0.f38273d;
        logger.b("Sending new message " + args);
        InternalChatRepo internalChatRepo = this$0.f38270a;
        String b8 = args.b();
        if (b8 == null) {
            b8 = this$0.f38271b.a();
        }
        String a8 = args.a();
        ChatMessageType chatMessageType = ChatMessageType.TEXT;
        k8 = CollectionsKt__CollectionsKt.k();
        internalChatRepo.m(new ChatMessageEntity(b8, a8, chatMessageType, k8, args.d(), args.c(), this$0.f38272c.k(), this$0.f38272c.l(), System.currentTimeMillis(), ChatMessageStatus.Sending.f38166b, true, 15, false, null, 4096, null));
    }

    public final Completable b(final MessageArgs args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: l6.d
            @Override // io.reactivex.functions.Action
            public final void run() {
                SendChatMessageInteractor.c(SendChatMessageInteractor.this, args);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …)\n            )\n        }");
        return u7;
    }

    /* compiled from: SendChatMessageInteractor.kt */
    /* loaded from: classes5.dex */
    public static final class MessageArgs {

        /* renamed from: a  reason: collision with root package name */
        private final String f38274a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38275b;

        /* renamed from: c  reason: collision with root package name */
        private final String f38276c;

        /* renamed from: d  reason: collision with root package name */
        private final String f38277d;

        public MessageArgs(String str, String chatId, String text, String str2) {
            Intrinsics.f(chatId, "chatId");
            Intrinsics.f(text, "text");
            this.f38274a = str;
            this.f38275b = chatId;
            this.f38276c = text;
            this.f38277d = str2;
        }

        public final String a() {
            return this.f38275b;
        }

        public final String b() {
            return this.f38274a;
        }

        public final String c() {
            return this.f38277d;
        }

        public final String d() {
            return this.f38276c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MessageArgs) {
                MessageArgs messageArgs = (MessageArgs) obj;
                return Intrinsics.a(this.f38274a, messageArgs.f38274a) && Intrinsics.a(this.f38275b, messageArgs.f38275b) && Intrinsics.a(this.f38276c, messageArgs.f38276c) && Intrinsics.a(this.f38277d, messageArgs.f38277d);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f38274a;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.f38275b.hashCode()) * 31) + this.f38276c.hashCode()) * 31;
            String str2 = this.f38277d;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "MessageArgs(messageId=" + this.f38274a + ", chatId=" + this.f38275b + ", text=" + this.f38276c + ", quickReplyId=" + this.f38277d + ')';
        }

        public /* synthetic */ MessageArgs(String str, String str2, String str3, String str4, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? null : str, str2, str3, (i8 & 8) != 0 ? null : str4);
        }
    }
}
