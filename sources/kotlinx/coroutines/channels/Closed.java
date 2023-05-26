package kotlinx.coroutines.channels;

import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {

    /* renamed from: i  reason: collision with root package name */
    public final Throwable f51414i;

    public Closed(Throwable th) {
        this.f51414i = th;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void V() {
    }

    @Override // kotlinx.coroutines.channels.Send
    public void X(Closed<?> closed) {
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol Y(LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.f51224a;
        if (prepareOp != null) {
            prepareOp.d();
        }
        return symbol;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    /* renamed from: a0 */
    public Closed<E> b() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    /* renamed from: b0 */
    public Closed<E> W() {
        return this;
    }

    public final Throwable c0() {
        Throwable th = this.f51414i;
        if (th == null) {
            return new ClosedReceiveChannelException("Channel was closed");
        }
        return th;
    }

    public final Throwable d0() {
        Throwable th = this.f51414i;
        if (th == null) {
            return new ClosedSendChannelException("Channel was closed");
        }
        return th;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void j(E e8) {
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "Closed@" + DebugStringsKt.b(this) + '[' + this.f51414i + ']';
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Symbol w(E e8, LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.f51224a;
        if (prepareOp != null) {
            prepareOp.d();
        }
        return symbol;
    }
}
