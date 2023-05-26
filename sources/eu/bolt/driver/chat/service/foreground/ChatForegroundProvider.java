package eu.bolt.driver.chat.service.foreground;

import eu.bolt.chat.chatcore.foreground.ForegroundStateProvider;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatForegroundProvider.kt */
@Singleton
/* loaded from: classes5.dex */
public final class ChatForegroundProvider implements ForegroundStateProvider {

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f40495a;

    @Inject
    public ChatForegroundProvider() {
        BehaviorSubject<Boolean> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<Boolean>()");
        this.f40495a = e8;
    }

    @Override // eu.bolt.chat.chatcore.foreground.ForegroundStateProvider
    public Observable<Boolean> a() {
        return this.f40495a;
    }

    public final void b(boolean z7) {
        this.f40495a.onNext(Boolean.valueOf(z7));
    }
}
