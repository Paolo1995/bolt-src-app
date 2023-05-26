package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class SelectAwaitOnCompletion<T, R> extends JobNode {

    /* renamed from: j  reason: collision with root package name */
    private final SelectInstance<R> f51330j;

    /* renamed from: k  reason: collision with root package name */
    private final Function2<T, Continuation<? super R>, Object> f51331k;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectAwaitOnCompletion(SelectInstance<? super R> selectInstance, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        this.f51330j = selectInstance;
        this.f51331k = function2;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void V(Throwable th) {
        if (this.f51330j.n()) {
            W().S0(this.f51330j, this.f51331k);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        V(th);
        return Unit.f50853a;
    }
}
