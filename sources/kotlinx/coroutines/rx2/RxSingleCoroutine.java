package kotlinx.coroutines.rx2;

import io.reactivex.SingleEmitter;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxSingle.kt */
/* loaded from: classes5.dex */
public final class RxSingleCoroutine<T> extends AbstractCoroutine<T> {

    /* renamed from: h  reason: collision with root package name */
    private final SingleEmitter<T> f51921h;

    public RxSingleCoroutine(CoroutineContext coroutineContext, SingleEmitter<T> singleEmitter) {
        super(coroutineContext, false, true);
        this.f51921h = singleEmitter;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void h1(Throwable th, boolean z7) {
        try {
            if (this.f51921h.a(th)) {
                return;
            }
        } catch (Throwable th2) {
            ExceptionsKt__ExceptionsKt.a(th, th2);
        }
        RxCancellableKt.a(th, getContext());
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void i1(T t7) {
        try {
            this.f51921h.onSuccess(t7);
        } catch (Throwable th) {
            RxCancellableKt.a(th, getContext());
        }
    }
}
