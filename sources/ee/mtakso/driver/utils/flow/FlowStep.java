package ee.mtakso.driver.utils.flow;

import io.reactivex.Observable;

/* compiled from: FlowStep.kt */
/* loaded from: classes5.dex */
public interface FlowStep<T> {
    Observable<T> call();
}
