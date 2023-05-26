package ee.mtakso.driver.service;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseObservableServiceImpl.kt */
/* loaded from: classes3.dex */
public abstract class BaseObservableServiceImpl<T> extends BaseServiceImpl implements ObservableService<T> {

    /* renamed from: b  reason: collision with root package name */
    private final Subject<T> f23401b;

    public BaseObservableServiceImpl() {
        this(null, 1, null);
    }

    public BaseObservableServiceImpl(Subject<T> subject) {
        Intrinsics.f(subject, "subject");
        this.f23401b = subject;
    }

    @Override // ee.mtakso.driver.service.ObservableService
    public Observable<T> c() {
        Observable<T> observeOn = this.f23401b.observeOn(Schedulers.a());
        Intrinsics.e(observeOn, "subject.observeOn(Schedulers.computation())");
        return observeOn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Subject<T> f() {
        return this.f23401b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ BaseObservableServiceImpl(io.reactivex.subjects.Subject r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Ld
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.e()
            java.lang.String r2 = "create()"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
        Ld:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.BaseObservableServiceImpl.<init>(io.reactivex.subjects.Subject, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
