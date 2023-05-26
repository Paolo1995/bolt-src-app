package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: ArrayChannel.kt */
/* loaded from: classes5.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {

    /* renamed from: i  reason: collision with root package name */
    private final int f51392i;

    /* renamed from: j  reason: collision with root package name */
    private final BufferOverflow f51393j;

    /* renamed from: k  reason: collision with root package name */
    private final ReentrantLock f51394k;

    /* renamed from: l  reason: collision with root package name */
    private Object[] f51395l;

    /* renamed from: m  reason: collision with root package name */
    private int f51396m;
    private volatile /* synthetic */ int size;

    /* compiled from: ArrayChannel.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51397a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f51397a = iArr;
        }
    }

    public ArrayChannel(int i8, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.f51392i = i8;
        this.f51393j = bufferOverflow;
        if (i8 >= 1) {
            this.f51394k = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i8, 8)];
            ArraysKt___ArraysJvmKt.o(objArr, AbstractChannelKt.f51381a, 0, 0, 6, null);
            this.f51395l = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i8 + " was specified").toString());
    }

    private final void c0(int i8, E e8) {
        if (i8 < this.f51392i) {
            d0(i8);
            Object[] objArr = this.f51395l;
            objArr[(this.f51396m + i8) % objArr.length] = e8;
            return;
        }
        Object[] objArr2 = this.f51395l;
        int i9 = this.f51396m;
        objArr2[i9 % objArr2.length] = null;
        objArr2[(i8 + i9) % objArr2.length] = e8;
        this.f51396m = (i9 + 1) % objArr2.length;
    }

    private final void d0(int i8) {
        Object[] objArr = this.f51395l;
        if (i8 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f51392i);
            Object[] objArr2 = new Object[min];
            for (int i9 = 0; i9 < i8; i9++) {
                Object[] objArr3 = this.f51395l;
                objArr2[i9] = objArr3[(this.f51396m + i9) % objArr3.length];
            }
            ArraysKt___ArraysJvmKt.m(objArr2, AbstractChannelKt.f51381a, i8, min);
            this.f51395l = objArr2;
            this.f51396m = 0;
        }
    }

    private final Symbol e0(int i8) {
        if (i8 < this.f51392i) {
            this.size = i8 + 1;
            return null;
        }
        int i9 = WhenMappings.f51397a[this.f51393j.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return AbstractChannelKt.f51382b;
        }
        return AbstractChannelKt.f51383c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean M(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.f51394k;
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
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean Q() {
        ReentrantLock reentrantLock = this.f51394k;
        reentrantLock.lock();
        try {
            return super.Q();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void S(boolean z7) {
        Function1<E, Unit> function1 = this.f51388f;
        ReentrantLock reentrantLock = this.f51394k;
        reentrantLock.lock();
        try {
            int i8 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i9 = 0; i9 < i8; i9++) {
                Object obj = this.f51395l[this.f51396m];
                if (function1 != null && obj != AbstractChannelKt.f51381a) {
                    undeliveredElementException = OnUndeliveredElementKt.c(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.f51395l;
                int i10 = this.f51396m;
                objArr[i10] = AbstractChannelKt.f51381a;
                this.f51396m = (i10 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.f50853a;
            reentrantLock.unlock();
            super.S(z7);
            if (undeliveredElementException == null) {
                return;
            }
            throw undeliveredElementException;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object W() {
        ReentrantLock reentrantLock = this.f51394k;
        reentrantLock.lock();
        try {
            int i8 = this.size;
            if (i8 == 0) {
                Object i9 = i();
                if (i9 == null) {
                    i9 = AbstractChannelKt.f51384d;
                }
                return i9;
            }
            Object[] objArr = this.f51395l;
            int i10 = this.f51396m;
            Object obj = objArr[i10];
            Send send = null;
            objArr[i10] = null;
            this.size = i8 - 1;
            Object obj2 = AbstractChannelKt.f51384d;
            boolean z7 = false;
            if (i8 == this.f51392i) {
                Send send2 = null;
                while (true) {
                    Send F = F();
                    if (F == null) {
                        send = send2;
                        break;
                    }
                    Intrinsics.c(F);
                    if (F.Y(null) != null) {
                        obj2 = F.W();
                        send = F;
                        z7 = true;
                        break;
                    }
                    F.Z();
                    send2 = F;
                }
            }
            if (obj2 != AbstractChannelKt.f51384d && !(obj2 instanceof Closed)) {
                this.size = i8;
                Object[] objArr2 = this.f51395l;
                objArr2[(this.f51396m + i8) % objArr2.length] = obj2;
            }
            this.f51396m = (this.f51396m + 1) % this.f51395l.length;
            Unit unit = Unit.f50853a;
            if (z7) {
                Intrinsics.c(send);
                send.V();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009a A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #0 {all -> 0x00c3, blocks: (B:3:0x0005, B:5:0x0009, B:7:0x000f, B:10:0x0015, B:12:0x0029, B:14:0x0033, B:31:0x0080, B:33:0x0084, B:35:0x0088, B:41:0x00aa, B:36:0x0094, B:38:0x009a, B:16:0x0043, B:18:0x0047, B:20:0x004b, B:22:0x0051, B:25:0x005d, B:28:0x0064, B:29:0x007e), top: B:49:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object X(kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f51394k
            r0.lock()
            int r1 = r8.size     // Catch: java.lang.Throwable -> Lc3
            if (r1 != 0) goto L15
            kotlinx.coroutines.channels.Closed r9 = r8.i()     // Catch: java.lang.Throwable -> Lc3
            if (r9 != 0) goto L11
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.AbstractChannelKt.f51384d     // Catch: java.lang.Throwable -> Lc3
        L11:
            r0.unlock()
            return r9
        L15:
            java.lang.Object[] r2 = r8.f51395l     // Catch: java.lang.Throwable -> Lc3
            int r3 = r8.f51396m     // Catch: java.lang.Throwable -> Lc3
            r4 = r2[r3]     // Catch: java.lang.Throwable -> Lc3
            r5 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> Lc3
            int r2 = r1 + (-1)
            r8.size = r2     // Catch: java.lang.Throwable -> Lc3
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.f51384d     // Catch: java.lang.Throwable -> Lc3
            int r3 = r8.f51392i     // Catch: java.lang.Throwable -> Lc3
            r6 = 1
            if (r1 != r3) goto L7f
        L29:
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r3 = r8.K()     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r7 = r9.v(r3)     // Catch: java.lang.Throwable -> Lc3
            if (r7 != 0) goto L43
            java.lang.Object r5 = r3.o()     // Catch: java.lang.Throwable -> Lc3
            kotlin.jvm.internal.Intrinsics.c(r5)     // Catch: java.lang.Throwable -> Lc3
            r2 = r5
            kotlinx.coroutines.channels.Send r2 = (kotlinx.coroutines.channels.Send) r2     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r2 = r2.W()     // Catch: java.lang.Throwable -> Lc3
        L41:
            r3 = 1
            goto L80
        L43:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.AbstractChannelKt.f51384d     // Catch: java.lang.Throwable -> Lc3
            if (r7 == r3) goto L7f
            java.lang.Object r3 = kotlinx.coroutines.internal.AtomicKt.f51775b     // Catch: java.lang.Throwable -> Lc3
            if (r7 == r3) goto L29
            java.lang.Object r2 = kotlinx.coroutines.selects.SelectKt.d()     // Catch: java.lang.Throwable -> Lc3
            if (r7 != r2) goto L5d
            r8.size = r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = r8.f51395l     // Catch: java.lang.Throwable -> Lc3
            int r1 = r8.f51396m     // Catch: java.lang.Throwable -> Lc3
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc3
            r0.unlock()
            return r7
        L5d:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto L64
            r2 = r7
            r5 = r2
            goto L41
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r1.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r2 = "performAtomicTrySelect(describeTryOffer) returned "
            r1.append(r2)     // Catch: java.lang.Throwable -> Lc3
            r1.append(r7)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc3
            r9.<init>(r1)     // Catch: java.lang.Throwable -> Lc3
            throw r9     // Catch: java.lang.Throwable -> Lc3
        L7f:
            r3 = 0
        L80:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.AbstractChannelKt.f51384d     // Catch: java.lang.Throwable -> Lc3
            if (r2 == r7) goto L94
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> Lc3
            if (r7 != 0) goto L94
            r8.size = r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = r8.f51395l     // Catch: java.lang.Throwable -> Lc3
            int r7 = r8.f51396m     // Catch: java.lang.Throwable -> Lc3
            int r7 = r7 + r1
            int r1 = r9.length     // Catch: java.lang.Throwable -> Lc3
            int r7 = r7 % r1
            r9[r7] = r2     // Catch: java.lang.Throwable -> Lc3
            goto Laa
        L94:
            boolean r9 = r9.n()     // Catch: java.lang.Throwable -> Lc3
            if (r9 != 0) goto Laa
            r8.size = r1     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object[] r9 = r8.f51395l     // Catch: java.lang.Throwable -> Lc3
            int r1 = r8.f51396m     // Catch: java.lang.Throwable -> Lc3
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc3
            java.lang.Object r9 = kotlinx.coroutines.selects.SelectKt.d()     // Catch: java.lang.Throwable -> Lc3
            r0.unlock()
            return r9
        Laa:
            int r9 = r8.f51396m     // Catch: java.lang.Throwable -> Lc3
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f51395l     // Catch: java.lang.Throwable -> Lc3
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lc3
            int r9 = r9 % r1
            r8.f51396m = r9     // Catch: java.lang.Throwable -> Lc3
            kotlin.Unit r9 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> Lc3
            r0.unlock()
            if (r3 == 0) goto Lc2
            kotlin.jvm.internal.Intrinsics.c(r5)
            kotlinx.coroutines.channels.Send r5 = (kotlinx.coroutines.channels.Send) r5
            r5.V()
        Lc2:
            return r4
        Lc3:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.X(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object f(Send send) {
        ReentrantLock reentrantLock = this.f51394k;
        reentrantLock.lock();
        try {
            return super.f(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String g() {
        return "(buffer:capacity=" + this.f51392i + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean q() {
        if (this.size == this.f51392i && this.f51393j == BufferOverflow.SUSPEND) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object t(E e8) {
        ReceiveOrClosed<E> C;
        ReentrantLock reentrantLock = this.f51394k;
        reentrantLock.lock();
        try {
            int i8 = this.size;
            Closed<?> i9 = i();
            if (i9 != null) {
                return i9;
            }
            Symbol e02 = e0(i8);
            if (e02 != null) {
                return e02;
            }
            if (i8 == 0) {
                do {
                    C = C();
                    if (C != null) {
                        if (C instanceof Closed) {
                            this.size = i8;
                            return C;
                        }
                        Intrinsics.c(C);
                    }
                } while (C.w(e8, null) == null);
                this.size = i8;
                Unit unit = Unit.f50853a;
                reentrantLock.unlock();
                C.j(e8);
                return C.b();
            }
            c0(i8, e8);
            return AbstractChannelKt.f51382b;
        } finally {
            reentrantLock.unlock();
        }
    }
}
