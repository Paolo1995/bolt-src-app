package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
final class InvokeOnCancelling extends JobCancellingNode {

    /* renamed from: k  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51293k = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: j  reason: collision with root package name */
    private final Function1<Throwable, Unit> f51294j;

    /* JADX WARN: Multi-variable type inference failed */
    public InvokeOnCancelling(Function1<? super Throwable, Unit> function1) {
        this.f51294j = function1;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void V(Throwable th) {
        if (f51293k.compareAndSet(this, 0, 1)) {
            this.f51294j.invoke(th);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        V(th);
        return Unit.f50853a;
    }
}
