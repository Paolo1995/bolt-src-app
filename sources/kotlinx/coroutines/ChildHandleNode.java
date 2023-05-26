package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes5.dex */
public final class ChildHandleNode extends JobCancellingNode implements ChildHandle {

    /* renamed from: j  reason: collision with root package name */
    public final ChildJob f51227j;

    public ChildHandleNode(ChildJob childJob) {
        this.f51227j = childJob;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void V(Throwable th) {
        this.f51227j.O(W());
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean e(Throwable th) {
        return W().a0(th);
    }

    @Override // kotlinx.coroutines.ChildHandle
    public Job getParent() {
        return W();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        V(th);
        return Unit.f50853a;
    }
}
