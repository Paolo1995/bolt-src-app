package eu.bolt.chat.chatcore.interactor;

import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.chat.chatcore.interactor.CreateChatInteractor;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import i0.a;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateChatInteractor.kt */
/* loaded from: classes5.dex */
public final class CreateChatInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final InternalChatRepo f38259a;

    /* compiled from: CreateChatInteractor.kt */
    /* loaded from: classes5.dex */
    public static final class ChatArgs {

        /* renamed from: a  reason: collision with root package name */
        private final String f38260a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38261b;

        /* renamed from: c  reason: collision with root package name */
        private final String f38262c;

        /* renamed from: d  reason: collision with root package name */
        private final String f38263d;

        /* renamed from: e  reason: collision with root package name */
        private final long f38264e;

        /* renamed from: f  reason: collision with root package name */
        private final OrderHandleEntity f38265f;

        /* renamed from: g  reason: collision with root package name */
        private final List<ChatMessageEntity> f38266g;

        public ChatArgs(String chatId, String str, String title, String str2, long j8, OrderHandleEntity orderHandle, List<ChatMessageEntity> initialMessages) {
            Intrinsics.f(chatId, "chatId");
            Intrinsics.f(title, "title");
            Intrinsics.f(orderHandle, "orderHandle");
            Intrinsics.f(initialMessages, "initialMessages");
            this.f38260a = chatId;
            this.f38261b = str;
            this.f38262c = title;
            this.f38263d = str2;
            this.f38264e = j8;
            this.f38265f = orderHandle;
            this.f38266g = initialMessages;
        }

        public final String a() {
            return this.f38260a;
        }

        public final String b() {
            return this.f38263d;
        }

        public final List<ChatMessageEntity> c() {
            return this.f38266g;
        }

        public final OrderHandleEntity d() {
            return this.f38265f;
        }

        public final long e() {
            return this.f38264e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChatArgs) {
                ChatArgs chatArgs = (ChatArgs) obj;
                return Intrinsics.a(this.f38260a, chatArgs.f38260a) && Intrinsics.a(this.f38261b, chatArgs.f38261b) && Intrinsics.a(this.f38262c, chatArgs.f38262c) && Intrinsics.a(this.f38263d, chatArgs.f38263d) && this.f38264e == chatArgs.f38264e && Intrinsics.a(this.f38265f, chatArgs.f38265f) && Intrinsics.a(this.f38266g, chatArgs.f38266g);
            }
            return false;
        }

        public final String f() {
            return this.f38261b;
        }

        public final String g() {
            return this.f38262c;
        }

        public int hashCode() {
            int hashCode = this.f38260a.hashCode() * 31;
            String str = this.f38261b;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f38262c.hashCode()) * 31;
            String str2 = this.f38263d;
            return ((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + a.a(this.f38264e)) * 31) + this.f38265f.hashCode()) * 31) + this.f38266g.hashCode();
        }

        public String toString() {
            return "ChatArgs(chatId=" + this.f38260a + ", thumbnail=" + this.f38261b + ", title=" + this.f38262c + ", description=" + this.f38263d + ", startDate=" + this.f38264e + ", orderHandle=" + this.f38265f + ", initialMessages=" + this.f38266g + ')';
        }
    }

    @Inject
    public CreateChatInteractor(InternalChatRepo chatRepo) {
        Intrinsics.f(chatRepo, "chatRepo");
        this.f38259a = chatRepo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CreateChatInteractor this$0, ChatArgs args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        this$0.f38259a.k(new ChatEntity(args.a(), args.f(), args.g(), args.b(), args.e(), args.d()), args.c());
    }

    public final Completable b(final ChatArgs args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: l6.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                CreateChatInteractor.c(CreateChatInteractor.this, args);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …s\n            )\n        }");
        return u7;
    }
}
