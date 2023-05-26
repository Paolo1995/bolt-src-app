package eu.bolt.chat.chatcore.interactor;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.chat.chatcore.interactor.ReadMessageInteractor;
import eu.bolt.chat.chatcore.repo.InternalChatRepo;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReadMessageInteractor.kt */
/* loaded from: classes5.dex */
public final class ReadMessageInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final InternalChatRepo f38267a;

    @Inject
    public ReadMessageInteractor(InternalChatRepo chatRepo) {
        Intrinsics.f(chatRepo, "chatRepo");
        this.f38267a = chatRepo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ReadMessageInteractor this$0, List chatMessageEntities) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(chatMessageEntities, "$chatMessageEntities");
        this$0.f38267a.f(chatMessageEntities);
    }

    public final Completable b(final List<ChatMessageEntity> chatMessageEntities) {
        Intrinsics.f(chatMessageEntities, "chatMessageEntities");
        Completable u7 = Completable.u(new Action() { // from class: l6.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                ReadMessageInteractor.c(ReadMessageInteractor.this, chatMessageEntities);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …essageEntities)\n        }");
        return u7;
    }
}
