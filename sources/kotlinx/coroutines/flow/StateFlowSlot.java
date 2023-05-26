package kotlinx.coroutines.flow;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
/* loaded from: classes5.dex */
public final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f51652a = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: c */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        Symbol symbol;
        if (this._state == null) {
            symbol = StateFlowKt.f51650a;
            this._state = symbol;
            return true;
        }
        return false;
    }

    public final Object d(Continuation<? super Unit> continuation) {
        Continuation c8;
        Symbol symbol;
        Object d8;
        Object d9;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51652a;
        symbol = StateFlowKt.f51650a;
        if (!a.a(atomicReferenceFieldUpdater, this, symbol, cancellableContinuationImpl)) {
            Result.Companion companion = Result.f50818g;
            cancellableContinuationImpl.resumeWith(Result.b(Unit.f50853a));
        }
        Object v7 = cancellableContinuationImpl.v();
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d8) {
            DebugProbesKt.c(continuation);
        }
        d9 = IntrinsicsKt__IntrinsicsKt.d();
        if (v7 == d9) {
            return v7;
        }
        return Unit.f50853a;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: e */
    public Continuation<Unit>[] b(StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return AbstractSharedFlowKt.f51666a;
    }

    public final void f() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        while (true) {
            Object obj = this._state;
            if (obj != null) {
                symbol = StateFlowKt.f51651b;
                if (obj != symbol) {
                    symbol2 = StateFlowKt.f51650a;
                    if (obj == symbol2) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51652a;
                        symbol3 = StateFlowKt.f51651b;
                        if (a.a(atomicReferenceFieldUpdater, this, obj, symbol3)) {
                            return;
                        }
                    } else {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f51652a;
                        symbol4 = StateFlowKt.f51650a;
                        if (a.a(atomicReferenceFieldUpdater2, this, obj, symbol4)) {
                            Result.Companion companion = Result.f50818g;
                            ((CancellableContinuationImpl) obj).resumeWith(Result.b(Unit.f50853a));
                            return;
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean g() {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51652a;
        symbol = StateFlowKt.f51650a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, symbol);
        Intrinsics.c(andSet);
        symbol2 = StateFlowKt.f51651b;
        if (andSet == symbol2) {
            return true;
        }
        return false;
    }
}
