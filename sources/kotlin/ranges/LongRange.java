package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes5.dex */
public final class LongRange extends LongProgression implements ClosedRange<Long> {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f51069j = new Companion(null);

    /* renamed from: k  reason: collision with root package name */
    private static final LongRange f51070k = new LongRange(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LongRange(long j8, long j9) {
        super(j8, j9, 1L);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongRange) {
            if (!isEmpty() || !((LongRange) obj).isEmpty()) {
                LongRange longRange = (LongRange) obj;
                if (g() != longRange.g() || i() != longRange.i()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (g() ^ (g() >>> 32))) + (i() ^ (i() >>> 32)));
    }

    public boolean isEmpty() {
        if (g() > i()) {
            return true;
        }
        return false;
    }

    public boolean m(long j8) {
        if (g() <= j8 && j8 <= i()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return g() + ".." + i();
    }
}
