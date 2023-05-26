package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import io.reactivex.Completable;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatRepo.kt */
/* loaded from: classes5.dex */
public /* synthetic */ class DefaultChatRepo$resendPendingSeenConfirmations$1 extends FunctionReferenceImpl implements Function1<List<? extends ChatMessageEntity>, Completable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChatRepo$resendPendingSeenConfirmations$1(Object obj) {
        super(1, obj, DefaultChatRepo.class, "resendMessageSeenConfirmations", "resendMessageSeenConfirmations(Ljava/util/List;)Lio/reactivex/Completable;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: j */
    public final Completable invoke(List<ChatMessageEntity> p02) {
        Completable X0;
        Intrinsics.f(p02, "p0");
        X0 = ((DefaultChatRepo) this.f50989g).X0(p02);
        return X0;
    }
}
