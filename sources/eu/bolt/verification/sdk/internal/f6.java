package eu.bolt.verification.sdk.internal;

import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f6<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Scheduler f42964a;

    /* renamed from: b  reason: collision with root package name */
    private final BehaviorRelay<T> f42965b;

    public f6(Scheduler scheduler, T t7) {
        BehaviorRelay<T> f8;
        String str;
        Intrinsics.f(scheduler, "scheduler");
        this.f42964a = scheduler;
        if (t7 == null) {
            f8 = BehaviorRelay.e();
            str = "{\n        BehaviorRelay.create()\n    }";
        } else {
            f8 = BehaviorRelay.f(t7);
            str = "{\n        BehaviorRelay.…fault(defaultValue)\n    }";
        }
        Intrinsics.e(f8, str);
        this.f42965b = f8;
    }

    public final synchronized T a() {
        return this.f42965b.g();
    }

    public final synchronized void b(T t7) {
        this.f42965b.accept(t7);
    }

    public final synchronized Observable<T> c() {
        Observable<T> observeOn;
        observeOn = this.f42965b.observeOn(this.f42964a);
        Intrinsics.e(observeOn, "relay.observeOn(scheduler)");
        return observeOn;
    }
}
