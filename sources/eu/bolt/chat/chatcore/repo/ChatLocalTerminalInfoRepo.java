package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.entity.TerminationInfo;
import io.reactivex.Completable;
import io.reactivex.Single;

/* compiled from: ChatLocalTerminalInfoRepo.kt */
/* loaded from: classes5.dex */
public interface ChatLocalTerminalInfoRepo {
    Single<TerminationInfo> a(String str);

    Completable b(TerminationInfo terminationInfo);

    Single<Boolean> c(String str);

    void d(TerminationInfo terminationInfo);
}
