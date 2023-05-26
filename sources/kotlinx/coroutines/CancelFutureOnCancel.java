package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Unit;

/* compiled from: Future.kt */
/* loaded from: classes5.dex */
final class CancelFutureOnCancel extends CancelHandler {

    /* renamed from: f  reason: collision with root package name */
    private final Future<?> f51218f;

    public CancelFutureOnCancel(Future<?> future) {
        this.f51218f = future;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void b(Throwable th) {
        if (th != null) {
            this.f51218f.cancel(false);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        b(th);
        return Unit.f50853a;
    }

    public String toString() {
        return "CancelFutureOnCancel[" + this.f51218f + ']';
    }
}
