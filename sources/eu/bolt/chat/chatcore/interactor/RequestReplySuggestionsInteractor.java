package eu.bolt.chat.chatcore.interactor;

import eu.bolt.chat.chatcore.entity.ChatRequestReplySuggestionsEntity;
import eu.bolt.chat.chatcore.interactor.RequestReplySuggestionsInteractor;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import eu.bolt.chat.tools.uniqueid.IdGenerator;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestReplySuggestionsInteractor.kt */
/* loaded from: classes5.dex */
public final class RequestReplySuggestionsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final InternalChatRepo f38268a;

    /* renamed from: b  reason: collision with root package name */
    private final IdGenerator f38269b;

    @Inject
    public RequestReplySuggestionsInteractor(InternalChatRepo chatRepo, IdGenerator idGenerator) {
        Intrinsics.f(chatRepo, "chatRepo");
        Intrinsics.f(idGenerator, "idGenerator");
        this.f38268a = chatRepo;
        this.f38269b = idGenerator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(RequestReplySuggestionsInteractor this$0, String chatId) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(chatId, "$chatId");
        this$0.f38268a.a(new ChatRequestReplySuggestionsEntity(this$0.f38269b.a(), chatId));
    }

    public final Completable b(final String chatId) {
        Intrinsics.f(chatId, "chatId");
        Completable u7 = Completable.u(new Action() { // from class: l6.c
            @Override // io.reactivex.functions.Action
            public final void run() {
                RequestReplySuggestionsInteractor.c(RequestReplySuggestionsInteractor.this, chatId);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …)\n            )\n        }");
        return u7;
    }
}
