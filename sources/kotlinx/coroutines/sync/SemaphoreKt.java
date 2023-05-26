package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

/* compiled from: Semaphore.kt */
/* loaded from: classes5.dex */
public final class SemaphoreKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f52023a;

    /* renamed from: b  reason: collision with root package name */
    private static final Symbol f52024b;

    /* renamed from: c  reason: collision with root package name */
    private static final Symbol f52025c;

    /* renamed from: d  reason: collision with root package name */
    private static final Symbol f52026d;

    /* renamed from: e  reason: collision with root package name */
    private static final Symbol f52027e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f52028f;

    static {
        int d8;
        int d9;
        d8 = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f52023a = d8;
        f52024b = new Symbol("PERMIT");
        f52025c = new Symbol("TAKEN");
        f52026d = new Symbol("BROKEN");
        f52027e = new Symbol("CANCELLED");
        d9 = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f52028f = d9;
    }

    public static final Semaphore a(int i8, int i9) {
        return new SemaphoreImpl(i8, i9);
    }

    public static /* synthetic */ Semaphore b(int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        return a(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SemaphoreSegment j(long j8, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j8, semaphoreSegment, 0);
    }
}
