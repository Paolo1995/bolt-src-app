package kotlinx.coroutines.rx2;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.rx2.RxSingleKt;

/* compiled from: RxSingle.kt */
/* loaded from: classes5.dex */
public final class RxSingleKt {
    public static final <T> Single<T> b(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        boolean z7;
        if (coroutineContext.g(Job.f51296d) == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return d(GlobalScope.f51286f, coroutineContext, function2);
        }
        throw new IllegalArgumentException(("Single context cannot contain job in it.Its lifecycle should be managed via Disposable handle. Had " + coroutineContext).toString());
    }

    public static /* synthetic */ Single c(CoroutineContext coroutineContext, Function2 function2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f50912f;
        }
        return b(coroutineContext, function2);
    }

    private static final <T> Single<T> d(final CoroutineScope coroutineScope, final CoroutineContext coroutineContext, final Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        return Single.f(new SingleOnSubscribe() { // from class: o7.d
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                RxSingleKt.e(CoroutineScope.this, coroutineContext, function2, singleEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, SingleEmitter singleEmitter) {
        RxSingleCoroutine rxSingleCoroutine = new RxSingleCoroutine(CoroutineContextKt.e(coroutineScope, coroutineContext), singleEmitter);
        singleEmitter.b(new RxCancellable(rxSingleCoroutine));
        rxSingleCoroutine.j1(CoroutineStart.DEFAULT, rxSingleCoroutine, function2);
    }
}
