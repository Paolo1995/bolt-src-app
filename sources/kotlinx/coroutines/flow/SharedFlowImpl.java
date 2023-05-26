package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: SharedFlow.kt */
/* loaded from: classes5.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, Flow {

    /* renamed from: j  reason: collision with root package name */
    private final int f51618j;

    /* renamed from: k  reason: collision with root package name */
    private final int f51619k;

    /* renamed from: l  reason: collision with root package name */
    private final BufferOverflow f51620l;

    /* renamed from: m  reason: collision with root package name */
    private Object[] f51621m;

    /* renamed from: n  reason: collision with root package name */
    private long f51622n;

    /* renamed from: o  reason: collision with root package name */
    private long f51623o;

    /* renamed from: p  reason: collision with root package name */
    private int f51624p;

    /* renamed from: q  reason: collision with root package name */
    private int f51625q;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SharedFlow.kt */
    /* loaded from: classes5.dex */
    public static final class Emitter implements DisposableHandle {

        /* renamed from: f  reason: collision with root package name */
        public final SharedFlowImpl<?> f51626f;

        /* renamed from: g  reason: collision with root package name */
        public long f51627g;

        /* renamed from: h  reason: collision with root package name */
        public final Object f51628h;

        /* renamed from: i  reason: collision with root package name */
        public final Continuation<Unit> f51629i;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> sharedFlowImpl, long j8, Object obj, Continuation<? super Unit> continuation) {
            this.f51626f = sharedFlowImpl;
            this.f51627g = j8;
            this.f51628h = obj;
            this.f51629i = continuation;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            this.f51626f.y(this);
        }
    }

    /* compiled from: SharedFlow.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51630a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f51630a = iArr;
        }
    }

    public SharedFlowImpl(int i8, int i9, BufferOverflow bufferOverflow) {
        this.f51618j = i8;
        this.f51619k = i9;
        this.f51620l = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|(3:(6:(1:(1:11)(2:41|42))(1:43)|12|13|14|15|(3:16|(3:28|29|(2:31|32)(1:33))(4:18|(1:20)|21|(2:23|24)(1:26))|27))(4:44|45|46|47)|37|38)(5:53|54|55|(2:57|(1:59))|61)|48|49|15|(3:16|(0)(0)|27)))|64|6|(0)(0)|48|49|15|(3:16|(0)(0)|27)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d3, code lost:
        r5 = r8;
        r8 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object A(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.A(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void B(long j8) {
        AbstractSharedFlowSlot[] f8;
        if (AbstractSharedFlow.c(this) != 0 && (f8 = AbstractSharedFlow.f(this)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : f8) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j9 = sharedFlowSlot.f51639a;
                    if (j9 >= 0 && j9 < j8) {
                        sharedFlowSlot.f51639a = j8;
                    }
                }
            }
        }
        this.f51623o = j8;
    }

    private final void E() {
        Object[] objArr = this.f51621m;
        Intrinsics.c(objArr);
        SharedFlowKt.f(objArr, K(), null);
        this.f51624p--;
        long K = K() + 1;
        if (this.f51622n < K) {
            this.f51622n = K;
        }
        if (this.f51623o < K) {
            B(K);
        }
    }

    static /* synthetic */ Object F(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        Object d8;
        if (sharedFlowImpl.d(obj)) {
            return Unit.f50853a;
        }
        Object G = sharedFlowImpl.G(obj, continuation);
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        if (G == d8) {
            return G;
        }
        return Unit.f50853a;
    }

    private final Object G(T t7, Continuation<? super Unit> continuation) {
        Continuation c8;
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        Object d8;
        Object d9;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.f51666a;
        synchronized (this) {
            if (R(t7)) {
                Result.Companion companion = Result.f50818g;
                cancellableContinuationImpl.resumeWith(Result.b(Unit.f50853a));
                continuationArr = I(continuationArr2);
                emitter = null;
            } else {
                Emitter emitter2 = new Emitter(this, P() + K(), t7, cancellableContinuationImpl);
                H(emitter2);
                this.f51625q++;
                if (this.f51619k == 0) {
                    continuationArr2 = I(continuationArr2);
                }
                continuationArr = continuationArr2;
                emitter = emitter2;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.a(cancellableContinuationImpl, emitter);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.f50818g;
                continuation2.resumeWith(Result.b(Unit.f50853a));
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(Object obj) {
        int P = P();
        Object[] objArr = this.f51621m;
        if (objArr == null) {
            objArr = Q(null, 0, 2);
        } else if (P >= objArr.length) {
            objArr = Q(objArr, P, objArr.length * 2);
        }
        SharedFlowKt.f(objArr, K() + P, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    public final Continuation<Unit>[] I(Continuation<Unit>[] continuationArr) {
        AbstractSharedFlowSlot[] f8;
        SharedFlowSlot sharedFlowSlot;
        Continuation<? super Unit> continuation;
        int length = continuationArr.length;
        if (AbstractSharedFlow.c(this) != 0 && (f8 = AbstractSharedFlow.f(this)) != null) {
            int i8 = 0;
            int length2 = f8.length;
            continuationArr = continuationArr;
            while (i8 < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = f8[i8];
                if (abstractSharedFlowSlot != null && (continuation = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).f51640b) != null && T(sharedFlowSlot) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? copyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.e(copyOf, "copyOf(this, newSize)");
                        continuationArr = copyOf;
                    }
                    continuationArr[length] = continuation;
                    sharedFlowSlot.f51640b = null;
                    length++;
                }
                i8++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    private final long J() {
        return K() + this.f51624p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long K() {
        return Math.min(this.f51623o, this.f51622n);
    }

    private final Object M(long j8) {
        Object e8;
        Object[] objArr = this.f51621m;
        Intrinsics.c(objArr);
        e8 = SharedFlowKt.e(objArr, j8);
        if (e8 instanceof Emitter) {
            return ((Emitter) e8).f51628h;
        }
        return e8;
    }

    private final long N() {
        return K() + this.f51624p + this.f51625q;
    }

    private final int O() {
        return (int) ((K() + this.f51624p) - this.f51622n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P() {
        return this.f51624p + this.f51625q;
    }

    private final Object[] Q(Object[] objArr, int i8, int i9) {
        boolean z7;
        Object e8;
        if (i9 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            Object[] objArr2 = new Object[i9];
            this.f51621m = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long K = K();
            for (int i10 = 0; i10 < i8; i10++) {
                long j8 = i10 + K;
                e8 = SharedFlowKt.e(objArr, j8);
                SharedFlowKt.f(objArr2, j8, e8);
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R(T t7) {
        if (l() == 0) {
            return S(t7);
        }
        if (this.f51624p >= this.f51619k && this.f51623o <= this.f51622n) {
            int i8 = WhenMappings.f51630a[this.f51620l.ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    return true;
                }
            } else {
                return false;
            }
        }
        H(t7);
        int i9 = this.f51624p + 1;
        this.f51624p = i9;
        if (i9 > this.f51619k) {
            E();
        }
        if (O() > this.f51618j) {
            V(this.f51622n + 1, this.f51623o, J(), N());
        }
        return true;
    }

    private final boolean S(T t7) {
        if (this.f51618j == 0) {
            return true;
        }
        H(t7);
        int i8 = this.f51624p + 1;
        this.f51624p = i8;
        if (i8 > this.f51618j) {
            E();
        }
        this.f51623o = K() + this.f51624p;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T(SharedFlowSlot sharedFlowSlot) {
        long j8 = sharedFlowSlot.f51639a;
        if (j8 < J()) {
            return j8;
        }
        if (this.f51619k > 0 || j8 > K() || this.f51625q == 0) {
            return -1L;
        }
        return j8;
    }

    private final Object U(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.f51666a;
        synchronized (this) {
            long T = T(sharedFlowSlot);
            if (T < 0) {
                obj = SharedFlowKt.f51638a;
            } else {
                long j8 = sharedFlowSlot.f51639a;
                Object M = M(T);
                sharedFlowSlot.f51639a = T + 1;
                continuationArr = W(j8);
                obj = M;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.f50818g;
                continuation.resumeWith(Result.b(Unit.f50853a));
            }
        }
        return obj;
    }

    private final void V(long j8, long j9, long j10, long j11) {
        long min = Math.min(j9, j8);
        for (long K = K(); K < min; K++) {
            Object[] objArr = this.f51621m;
            Intrinsics.c(objArr);
            SharedFlowKt.f(objArr, K, null);
        }
        this.f51622n = j8;
        this.f51623o = j9;
        this.f51624p = (int) (j10 - min);
        this.f51625q = (int) (j11 - j10);
    }

    private final Object x(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        Continuation c8;
        Object d8;
        Object d9;
        c8 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c8, 1);
        cancellableContinuationImpl.y();
        synchronized (this) {
            if (T(sharedFlowSlot) < 0) {
                sharedFlowSlot.f51640b = cancellableContinuationImpl;
            } else {
                Result.Companion companion = Result.f50818g;
                cancellableContinuationImpl.resumeWith(Result.b(Unit.f50853a));
            }
            Unit unit = Unit.f50853a;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Emitter emitter) {
        Object e8;
        synchronized (this) {
            if (emitter.f51627g < K()) {
                return;
            }
            Object[] objArr = this.f51621m;
            Intrinsics.c(objArr);
            e8 = SharedFlowKt.e(objArr, emitter.f51627g);
            if (e8 == emitter) {
                SharedFlowKt.f(objArr, emitter.f51627g, SharedFlowKt.f51638a);
                z();
                Unit unit = Unit.f50853a;
            }
        }
    }

    private final void z() {
        Object e8;
        if (this.f51619k == 0 && this.f51625q <= 1) {
            return;
        }
        Object[] objArr = this.f51621m;
        Intrinsics.c(objArr);
        while (this.f51625q > 0) {
            e8 = SharedFlowKt.e(objArr, (K() + P()) - 1);
            if (e8 == SharedFlowKt.f51638a) {
                this.f51625q--;
                SharedFlowKt.f(objArr, K() + P(), null);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: C */
    public SharedFlowSlot i() {
        return new SharedFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: D */
    public SharedFlowSlot[] j(int i8) {
        return new SharedFlowSlot[i8];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T L() {
        Object e8;
        Object[] objArr = this.f51621m;
        Intrinsics.c(objArr);
        e8 = SharedFlowKt.e(objArr, (this.f51622n + O()) - 1);
        return (T) e8;
    }

    public final Continuation<Unit>[] W(long j8) {
        int i8;
        long j9;
        long j10;
        long j11;
        boolean z7;
        Object e8;
        Object e9;
        long j12;
        AbstractSharedFlowSlot[] f8;
        if (j8 > this.f51623o) {
            return AbstractSharedFlowKt.f51666a;
        }
        long K = K();
        long j13 = this.f51624p + K;
        if (this.f51619k == 0 && this.f51625q > 0) {
            j13++;
        }
        if (AbstractSharedFlow.c(this) != 0 && (f8 = AbstractSharedFlow.f(this)) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : f8) {
                if (abstractSharedFlowSlot != null) {
                    long j14 = ((SharedFlowSlot) abstractSharedFlowSlot).f51639a;
                    if (j14 >= 0 && j14 < j13) {
                        j13 = j14;
                    }
                }
            }
        }
        if (j13 <= this.f51623o) {
            return AbstractSharedFlowKt.f51666a;
        }
        long J = J();
        if (l() > 0) {
            i8 = Math.min(this.f51625q, this.f51619k - ((int) (J - j13)));
        } else {
            i8 = this.f51625q;
        }
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.f51666a;
        long j15 = this.f51625q + J;
        if (i8 > 0) {
            continuationArr = new Continuation[i8];
            Object[] objArr = this.f51621m;
            Intrinsics.c(objArr);
            long j16 = J;
            int i9 = 0;
            while (true) {
                if (J < j15) {
                    e9 = SharedFlowKt.e(objArr, J);
                    j9 = j13;
                    Symbol symbol = SharedFlowKt.f51638a;
                    if (e9 != symbol) {
                        if (e9 != null) {
                            Emitter emitter = (Emitter) e9;
                            int i10 = i9 + 1;
                            j10 = j15;
                            continuationArr[i9] = emitter.f51629i;
                            SharedFlowKt.f(objArr, J, symbol);
                            SharedFlowKt.f(objArr, j16, emitter.f51628h);
                            j12 = 1;
                            j16++;
                            if (i10 >= i8) {
                                break;
                            }
                            i9 = i10;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                        }
                    } else {
                        j10 = j15;
                        j12 = 1;
                    }
                    J += j12;
                    j13 = j9;
                    j15 = j10;
                } else {
                    j9 = j13;
                    j10 = j15;
                    break;
                }
            }
            J = j16;
        } else {
            j9 = j13;
            j10 = j15;
        }
        int i11 = (int) (J - K);
        if (l() == 0) {
            j11 = J;
        } else {
            j11 = j9;
        }
        long max = Math.max(this.f51622n, J - Math.min(this.f51618j, i11));
        if (this.f51619k == 0 && max < j10) {
            Object[] objArr2 = this.f51621m;
            Intrinsics.c(objArr2);
            e8 = SharedFlowKt.e(objArr2, max);
            if (Intrinsics.a(e8, SharedFlowKt.f51638a)) {
                J++;
                max++;
            }
        }
        V(max, j11, J, j10);
        z();
        if (continuationArr.length == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return I(continuationArr);
        }
        return continuationArr;
    }

    public final long X() {
        long j8 = this.f51622n;
        if (j8 < this.f51623o) {
            this.f51623o = j8;
        }
        return j8;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object a(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        return A(this, flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object b(T t7, Continuation<? super Unit> continuation) {
        return F(this, t7, continuation);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean d(T t7) {
        int i8;
        boolean z7;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.f51666a;
        synchronized (this) {
            if (R(t7)) {
                continuationArr = I(continuationArr);
                z7 = true;
            } else {
                z7 = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.f50818g;
                continuation.resumeWith(Result.b(Unit.f50853a));
            }
        }
        return z7;
    }
}
