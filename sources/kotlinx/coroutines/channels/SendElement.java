package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public class SendElement<E> extends Send {

    /* renamed from: i  reason: collision with root package name */
    private final E f51423i;

    /* renamed from: j  reason: collision with root package name */
    public final CancellableContinuation<Unit> f51424j;

    /* JADX WARN: Multi-variable type inference failed */
    public SendElement(E e8, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f51423i = e8;
        this.f51424j = cancellableContinuation;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void V() {
        this.f51424j.G(CancellableContinuationImplKt.f51224a);
    }

    @Override // kotlinx.coroutines.channels.Send
    public E W() {
        return this.f51423i;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void X(Closed<?> closed) {
        CancellableContinuation<Unit> cancellableContinuation = this.f51424j;
        Result.Companion companion = Result.f50818g;
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(closed.d0())));
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol Y(LockFreeLinkedListNode.PrepareOp prepareOp) {
        LockFreeLinkedListNode.AbstractAtomicDesc abstractAtomicDesc;
        CancellableContinuation<Unit> cancellableContinuation = this.f51424j;
        Unit unit = Unit.f50853a;
        if (prepareOp != null) {
            abstractAtomicDesc = prepareOp.f51805c;
        } else {
            abstractAtomicDesc = null;
        }
        if (cancellableContinuation.i(unit, abstractAtomicDesc) == null) {
            return null;
        }
        if (prepareOp != null) {
            prepareOp.d();
        }
        return CancellableContinuationImplKt.f51224a;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this) + '(' + W() + ')';
    }
}
