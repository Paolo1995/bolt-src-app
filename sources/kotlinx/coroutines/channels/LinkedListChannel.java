package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: LinkedListChannel.kt */
/* loaded from: classes5.dex */
public class LinkedListChannel<E> extends AbstractChannel<E> {
    public LinkedListChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean O() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean P() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void T(Object obj, Closed<?> closed) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                Send send = (Send) obj;
                if (send instanceof AbstractSendChannel.SendBuffered) {
                    Function1<E, Unit> function1 = this.f51388f;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.c(function1, ((AbstractSendChannel.SendBuffered) send).f51391i, null);
                    }
                } else {
                    send.X(closed);
                }
            } else {
                ArrayList arrayList = (ArrayList) obj;
                UndeliveredElementException undeliveredElementException2 = null;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    Send send2 = (Send) arrayList.get(size);
                    if (send2 instanceof AbstractSendChannel.SendBuffered) {
                        Function1<E, Unit> function12 = this.f51388f;
                        if (function12 != null) {
                            undeliveredElementException2 = OnUndeliveredElementKt.c(function12, ((AbstractSendChannel.SendBuffered) send2).f51391i, undeliveredElementException2);
                        } else {
                            undeliveredElementException2 = null;
                        }
                    } else {
                        send2.X(closed);
                    }
                }
                undeliveredElementException = undeliveredElementException2;
            }
        }
        if (undeliveredElementException == null) {
            return;
        }
        throw undeliveredElementException;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean q() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object t(E e8) {
        ReceiveOrClosed<?> y7;
        do {
            Object t7 = super.t(e8);
            Symbol symbol = AbstractChannelKt.f51382b;
            if (t7 == symbol) {
                return symbol;
            }
            if (t7 == AbstractChannelKt.f51383c) {
                y7 = y(e8);
                if (y7 == null) {
                    return symbol;
                }
            } else if (t7 instanceof Closed) {
                return t7;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + t7).toString());
            }
        } while (!(y7 instanceof Closed));
        return y7;
    }
}
