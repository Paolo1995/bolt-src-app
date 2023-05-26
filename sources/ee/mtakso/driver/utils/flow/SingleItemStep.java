package ee.mtakso.driver.utils.flow;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleItemStep.kt */
/* loaded from: classes5.dex */
public final class SingleItemStep<T> implements FlowStep<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f36435a;

    public SingleItemStep(T item) {
        Intrinsics.f(item, "item");
        this.f36435a = item;
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<T> call() {
        Observable<T> just = Observable.just(this.f36435a);
        Intrinsics.e(just, "just(item)");
        return just;
    }
}
