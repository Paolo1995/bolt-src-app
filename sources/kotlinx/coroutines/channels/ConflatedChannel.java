package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

/* compiled from: ConflatedChannel.kt */
/* loaded from: classes5.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {

    /* renamed from: i  reason: collision with root package name */
    private final ReentrantLock f51415i;

    /* renamed from: j  reason: collision with root package name */
    private Object f51416j;

    public ConflatedChannel(Function1<? super E, Unit> function1) {
        super(function1);
        this.f51415i = new ReentrantLock();
        this.f51416j = AbstractChannelKt.f51381a;
    }

    private final UndeliveredElementException c0(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.f51416j;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != AbstractChannelKt.f51381a && (function1 = this.f51388f) != null) {
            undeliveredElementException = OnUndeliveredElementKt.d(function1, obj2, null, 2, null);
        }
        this.f51416j = obj;
        return undeliveredElementException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean M(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.f51415i;
        reentrantLock.lock();
        try {
            return super.M(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean O() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean P() {
        boolean z7;
        ReentrantLock reentrantLock = this.f51415i;
        reentrantLock.lock();
        try {
            if (this.f51416j == AbstractChannelKt.f51381a) {
                z7 = true;
            } else {
                z7 = false;
            }
            return z7;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void S(boolean z7) {
        ReentrantLock reentrantLock = this.f51415i;
        reentrantLock.lock();
        try {
            UndeliveredElementException c02 = c0(AbstractChannelKt.f51381a);
            Unit unit = Unit.f50853a;
            reentrantLock.unlock();
            super.S(z7);
            if (c02 == null) {
                return;
            }
            throw c02;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object W() {
        ReentrantLock reentrantLock = this.f51415i;
        reentrantLock.lock();
        try {
            Object obj = this.f51416j;
            Symbol symbol = AbstractChannelKt.f51381a;
            if (obj == symbol) {
                Object i8 = i();
                if (i8 == null) {
                    i8 = AbstractChannelKt.f51384d;
                }
                return i8;
            }
            this.f51416j = symbol;
            Unit unit = Unit.f50853a;
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object X(SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.f51415i;
        reentrantLock.lock();
        try {
            Object obj = this.f51416j;
            Symbol symbol = AbstractChannelKt.f51381a;
            if (obj == symbol) {
                Object i8 = i();
                if (i8 == null) {
                    i8 = AbstractChannelKt.f51384d;
                }
                return i8;
            } else if (!selectInstance.n()) {
                return SelectKt.d();
            } else {
                Object obj2 = this.f51416j;
                this.f51416j = symbol;
                Unit unit = Unit.f50853a;
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String g() {
        ReentrantLock reentrantLock = this.f51415i;
        reentrantLock.lock();
        try {
            return "(value=" + this.f51416j + ')';
        } finally {
            reentrantLock.unlock();
        }
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
        ReceiveOrClosed<E> C;
        ReentrantLock reentrantLock = this.f51415i;
        reentrantLock.lock();
        try {
            Closed<?> i8 = i();
            if (i8 != null) {
                return i8;
            }
            if (this.f51416j == AbstractChannelKt.f51381a) {
                do {
                    C = C();
                    if (C != null) {
                        if (C instanceof Closed) {
                            return C;
                        }
                        Intrinsics.c(C);
                    }
                } while (C.w(e8, null) == null);
                Unit unit = Unit.f50853a;
                reentrantLock.unlock();
                C.j(e8);
                return C.b();
            }
            UndeliveredElementException c02 = c0(e8);
            if (c02 == null) {
                return AbstractChannelKt.f51382b;
            }
            throw c02;
        } finally {
            reentrantLock.unlock();
        }
    }
}
