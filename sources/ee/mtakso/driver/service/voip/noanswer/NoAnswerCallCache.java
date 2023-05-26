package ee.mtakso.driver.service.voip.noanswer;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerCallCache.kt */
@Singleton
/* loaded from: classes3.dex */
public final class NoAnswerCallCache {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<NoAnswerIncomingCall> f26183a;

    @Inject
    public NoAnswerCallCache() {
        PublishSubject<NoAnswerIncomingCall> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<NoAnswerIncomingCall>()");
        this.f26183a = e8;
    }

    public final Observable<NoAnswerIncomingCall> a() {
        return this.f26183a;
    }

    public final void b(NoAnswerIncomingCall call) {
        Intrinsics.f(call, "call");
        this.f26183a.onNext(call);
    }
}
