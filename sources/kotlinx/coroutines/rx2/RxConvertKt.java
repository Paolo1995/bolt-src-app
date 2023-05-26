package kotlinx.coroutines.rx2;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.reactive.ReactiveFlowKt;
import kotlinx.coroutines.rx2.RxConvertKt;

/* compiled from: RxConvert.kt */
/* loaded from: classes5.dex */
public final class RxConvertKt {
    public static final <T> Flow<T> b(ObservableSource<T> observableSource) {
        return FlowKt.d(new RxConvertKt$asFlow$1(observableSource, null));
    }

    public static final <T> Flowable<T> c(Flow<? extends T> flow, CoroutineContext coroutineContext) {
        return Flowable.H(ReactiveFlowKt.a(flow, coroutineContext));
    }

    public static final <T> Observable<T> d(final Flow<? extends T> flow, final CoroutineContext coroutineContext) {
        return Observable.create(new ObservableOnSubscribe() { // from class: o7.b
            @Override // io.reactivex.ObservableOnSubscribe
            public final void a(ObservableEmitter observableEmitter) {
                RxConvertKt.f(CoroutineContext.this, flow, observableEmitter);
            }
        });
    }

    public static /* synthetic */ Observable e(Flow flow, CoroutineContext coroutineContext, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        return d(flow, coroutineContext);
    }

    public static final void f(CoroutineContext coroutineContext, Flow flow, ObservableEmitter observableEmitter) {
        observableEmitter.b(new RxCancellable(BuildersKt.c(GlobalScope.f51286f, Dispatchers.d().s0(coroutineContext), CoroutineStart.ATOMIC, new RxConvertKt$asObservable$1$job$1(flow, observableEmitter, null))));
    }
}
