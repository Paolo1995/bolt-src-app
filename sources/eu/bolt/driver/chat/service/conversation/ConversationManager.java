package eu.bolt.driver.chat.service.conversation;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.entity.QuickReplyEntity;
import eu.bolt.chat.chatcore.entity.TerminationInfo;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.interactor.SendChatMessageInteractor;
import eu.bolt.chat.chatcore.repo.ChatRepo;
import eu.bolt.driver.core.util.Optional;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationManager.kt */
/* loaded from: classes5.dex */
public final class ConversationManager {

    /* renamed from: a  reason: collision with root package name */
    private final String f40483a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatRepo f40484b;

    /* renamed from: c  reason: collision with root package name */
    private final SendChatMessageInteractor f40485c;

    /* renamed from: d  reason: collision with root package name */
    private final RequestReplySuggestionsInteractor f40486d;

    /* renamed from: e  reason: collision with root package name */
    private final PublishSubject<List<QuickReplyEntity>> f40487e;

    public ConversationManager(String chatId, ChatRepo chatRepo, SendChatMessageInteractor sendChatMessageInteractor, RequestReplySuggestionsInteractor quickReplyRequestor) {
        Intrinsics.f(chatId, "chatId");
        Intrinsics.f(chatRepo, "chatRepo");
        Intrinsics.f(sendChatMessageInteractor, "sendChatMessageInteractor");
        Intrinsics.f(quickReplyRequestor, "quickReplyRequestor");
        this.f40483a = chatId;
        this.f40484b = chatRepo;
        this.f40485c = sendChatMessageInteractor;
        this.f40486d = quickReplyRequestor;
        PublishSubject<List<QuickReplyEntity>> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<List<QuickReplyEntity>>()");
        this.f40487e = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConversationData e(List<ChatMessageEntity> list, List<QuickReplyEntity> list2, Optional<TerminationInfo> optional) {
        if (!optional.c()) {
            list2 = CollectionsKt__CollectionsKt.k();
        }
        return new ConversationData(list, list2, optional.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConversationData i(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ConversationData) tmp0.l(obj, obj2, obj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ConversationManager this$0) {
        List<QuickReplyEntity> k8;
        Intrinsics.f(this$0, "this$0");
        PublishSubject<List<QuickReplyEntity>> publishSubject = this$0.f40487e;
        k8 = CollectionsKt__CollectionsKt.k();
        publishSubject.onNext(k8);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.util.List<eu.bolt.chat.chatcore.entity.ChatMessageEntity> r7, java.util.List<eu.bolt.chat.chatcore.entity.ChatMessageEntity> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "newMessages"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            r0 = 1
            r1 = 0
            r2 = 0
            if (r7 == 0) goto L41
            int r3 = r7.size()
            java.util.ListIterator r7 = r7.listIterator(r3)
        L12:
            boolean r3 = r7.hasPrevious()
            if (r3 == 0) goto L37
            java.lang.Object r3 = r7.previous()
            r4 = r3
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r4 = (eu.bolt.chat.chatcore.entity.ChatMessageEntity) r4
            boolean r5 = r4.n()
            if (r5 != 0) goto L33
            eu.bolt.chat.chatcore.entity.ChatMessageStatus r4 = r4.i()
            eu.bolt.chat.chatcore.entity.ChatMessageStatus$DeliveredToBackend r5 = eu.bolt.chat.chatcore.entity.ChatMessageStatus.DeliveredToBackend.f38163b
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r4, r5)
            if (r4 == 0) goto L33
            r4 = 1
            goto L34
        L33:
            r4 = 0
        L34:
            if (r4 == 0) goto L12
            goto L38
        L37:
            r3 = r2
        L38:
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r3 = (eu.bolt.chat.chatcore.entity.ChatMessageEntity) r3
            if (r3 == 0) goto L41
            java.lang.String r7 = r3.d()
            goto L42
        L41:
            r7 = r2
        L42:
            int r3 = r8.size()
            java.util.ListIterator r8 = r8.listIterator(r3)
        L4a:
            boolean r3 = r8.hasPrevious()
            if (r3 == 0) goto L6f
            java.lang.Object r3 = r8.previous()
            r4 = r3
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r4 = (eu.bolt.chat.chatcore.entity.ChatMessageEntity) r4
            boolean r5 = r4.n()
            if (r5 != 0) goto L6b
            eu.bolt.chat.chatcore.entity.ChatMessageStatus r4 = r4.i()
            eu.bolt.chat.chatcore.entity.ChatMessageStatus$DeliveredToBackend r5 = eu.bolt.chat.chatcore.entity.ChatMessageStatus.DeliveredToBackend.f38163b
            boolean r4 = kotlin.jvm.internal.Intrinsics.a(r4, r5)
            if (r4 == 0) goto L6b
            r4 = 1
            goto L6c
        L6b:
            r4 = 0
        L6c:
            if (r4 == 0) goto L4a
            goto L70
        L6f:
            r3 = r2
        L70:
            eu.bolt.chat.chatcore.entity.ChatMessageEntity r3 = (eu.bolt.chat.chatcore.entity.ChatMessageEntity) r3
            if (r3 == 0) goto L78
            java.lang.String r2 = r3.d()
        L78:
            boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r2)
            if (r7 != 0) goto L81
            if (r2 == 0) goto L81
            goto L82
        L81:
            r0 = 0
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.chat.service.conversation.ConversationManager.f(java.util.List, java.util.List):boolean");
    }

    public final Observable<ConversationData> g() {
        Observable<List<ChatMessageEntity>> f02 = this.f40484b.b(this.f40483a).f0();
        Observable<List<QuickReplyEntity>> mergeWith = this.f40484b.h(this.f40483a).f0().mergeWith(this.f40487e);
        Single<TerminationInfo> n8 = this.f40484b.n(this.f40483a);
        final ConversationManager$observeConversation$terminalInfo$1 conversationManager$observeConversation$terminalInfo$1 = new Function1<TerminationInfo, Optional<TerminationInfo>>() { // from class: eu.bolt.driver.chat.service.conversation.ConversationManager$observeConversation$terminalInfo$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<TerminationInfo> invoke(TerminationInfo it) {
                Intrinsics.f(it, "it");
                return Optional.f41306b.b(it);
            }
        };
        Observable startWith = n8.x(new Function() { // from class: eu.bolt.driver.chat.service.conversation.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional h8;
                h8 = ConversationManager.h(Function1.this, obj);
                return h8;
            }
        }).R().startWith((Observable) Optional.f41306b.a());
        final ConversationManager$observeConversation$1 conversationManager$observeConversation$1 = new ConversationManager$observeConversation$1(this);
        Observable<ConversationData> combineLatest = Observable.combineLatest(f02, mergeWith, startWith, new io.reactivex.functions.Function3() { // from class: eu.bolt.driver.chat.service.conversation.c
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                ConversationData i8;
                i8 = ConversationManager.i(Function3.this, obj, obj2, obj3);
                return i8;
            }
        });
        Intrinsics.e(combineLatest, "combineLatest(messages, …s, terminalInfo, ::build)");
        return combineLatest;
    }

    public final Completable j() {
        return this.f40486d.b(this.f40483a);
    }

    public final Completable k(String text, String str) {
        Intrinsics.f(text, "text");
        Completable n8 = this.f40485c.b(new SendChatMessageInteractor.MessageArgs(null, this.f40483a, text, str, 1, null)).n(new Action() { // from class: eu.bolt.driver.chat.service.conversation.a
            @Override // io.reactivex.functions.Action
            public final void run() {
                ConversationManager.l(ConversationManager.this);
            }
        });
        Intrinsics.e(n8, "sendChatMessageInteracto…xt(emptyList())\n        }");
        return n8;
    }
}
