package kotlinx.coroutines.rx2;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.rx2.RxCompletableKt;

/* compiled from: RxCompletable.kt */
/* loaded from: classes5.dex */
public final class RxCompletableKt {
    public static final Completable b(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        boolean z7;
        if (coroutineContext.g(Job.f51296d) == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return c(GlobalScope.f51286f, coroutineContext, function2);
        }
        throw new IllegalArgumentException(("Completable context cannot contain job in it. Its lifecycle should be managed via Disposable handle. Had " + coroutineContext).toString());
    }

    private static final Completable c(final CoroutineScope coroutineScope, final CoroutineContext coroutineContext, final Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return Completable.i(new CompletableOnSubscribe() { // from class: o7.a
            @Override // io.reactivex.CompletableOnSubscribe
            public final void a(CompletableEmitter completableEmitter) {
                RxCompletableKt.d(CoroutineScope.this, coroutineContext, function2, completableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, CompletableEmitter completableEmitter) {
        RxCompletableCoroutine rxCompletableCoroutine = new RxCompletableCoroutine(CoroutineContextKt.e(coroutineScope, coroutineContext), completableEmitter);
        completableEmitter.b(new RxCancellable(rxCompletableCoroutine));
        rxCompletableCoroutine.j1(CoroutineStart.DEFAULT, rxCompletableCoroutine, function2);
    }
}
