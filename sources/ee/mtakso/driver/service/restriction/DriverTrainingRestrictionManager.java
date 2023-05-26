package ee.mtakso.driver.service.restriction;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverTrainingRestrictionManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DriverTrainingRestrictionManager {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<Object> f25839a;

    @Inject
    public DriverTrainingRestrictionManager() {
        PublishSubject<Object> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Any>()");
        this.f25839a = e8;
    }

    public final void a() {
        this.f25839a.onNext(new Object());
    }

    public final Observable<Object> b() {
        return this.f25839a;
    }
}
