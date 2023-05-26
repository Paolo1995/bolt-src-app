package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* compiled from: SharedFlow.kt */
/* loaded from: classes5.dex */
public final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    public long f51639a = -1;

    /* renamed from: b  reason: collision with root package name */
    public Continuation<? super Unit> f51640b;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: c */
    public boolean a(SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f51639a >= 0) {
            return false;
        }
        this.f51639a = sharedFlowImpl.X();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: d */
    public Continuation<Unit>[] b(SharedFlowImpl<?> sharedFlowImpl) {
        long j8 = this.f51639a;
        this.f51639a = -1L;
        this.f51640b = null;
        return sharedFlowImpl.W(j8);
    }
}
