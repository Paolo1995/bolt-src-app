package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
/* loaded from: classes5.dex */
public final class LazyStandaloneCoroutine extends StandaloneCoroutine {

    /* renamed from: h  reason: collision with root package name */
    private final Continuation<Unit> f51323h;

    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        Continuation<Unit> b8;
        b8 = IntrinsicsKt__IntrinsicsJvmKt.b(function2, this, this);
        this.f51323h = b8;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void N0() {
        CancellableKt.b(this.f51323h, this);
    }
}
