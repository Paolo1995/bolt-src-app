package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public final class SendElementWithUndeliveredHandler<E> extends SendElement<E> {

    /* renamed from: k  reason: collision with root package name */
    public final Function1<E, Unit> f51425k;

    /* JADX WARN: Multi-variable type inference failed */
    public SendElementWithUndeliveredHandler(E e8, CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super E, Unit> function1) {
        super(e8, cancellableContinuation);
        this.f51425k = function1;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean Q() {
        if (!super.Q()) {
            return false;
        }
        Z();
        return true;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void Z() {
        OnUndeliveredElementKt.b(this.f51425k, W(), this.f51424j.getContext());
    }
}
