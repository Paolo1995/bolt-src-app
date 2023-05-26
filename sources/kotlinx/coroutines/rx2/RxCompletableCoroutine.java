package kotlinx.coroutines.rx2;

import io.reactivex.CompletableEmitter;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxCompletable.kt */
/* loaded from: classes5.dex */
public final class RxCompletableCoroutine extends AbstractCoroutine<Unit> {

    /* renamed from: h  reason: collision with root package name */
    private final CompletableEmitter f51902h;

    public RxCompletableCoroutine(CoroutineContext coroutineContext, CompletableEmitter completableEmitter) {
        super(coroutineContext, false, true);
        this.f51902h = completableEmitter;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void h1(Throwable th, boolean z7) {
        try {
            if (this.f51902h.a(th)) {
                return;
            }
        } catch (Throwable th2) {
            ExceptionsKt__ExceptionsKt.a(th, th2);
        }
        RxCancellableKt.a(th, getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    /* renamed from: k1 */
    public void i1(Unit unit) {
        try {
            this.f51902h.onComplete();
        } catch (Throwable th) {
            RxCancellableKt.a(th, getContext());
        }
    }
}
