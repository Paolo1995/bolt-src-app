package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes5.dex */
public abstract class Receive<E> extends LockFreeLinkedListNode implements ReceiveOrClosed<E> {
    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    /* renamed from: V */
    public Symbol b() {
        return AbstractChannelKt.f51382b;
    }

    public Function1<Throwable, Unit> W(E e8) {
        return null;
    }

    public abstract void X(Closed<?> closed);
}
