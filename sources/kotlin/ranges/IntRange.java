package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes5.dex */
public final class IntRange extends IntProgression implements ClosedRange<Integer> {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f51059j = new Companion(null);

    /* renamed from: k  reason: collision with root package name */
    private static final IntRange f51060k = new IntRange(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntRange a() {
            return IntRange.f51060k;
        }
    }

    public IntRange(int i8, int i9) {
        super(i8, i9, 1);
    }

    @Override // kotlin.ranges.IntProgression
    public boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (g() != intRange.g() || i() != intRange.i()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + i();
    }

    @Override // kotlin.ranges.IntProgression
    public boolean isEmpty() {
        if (g() > i()) {
            return true;
        }
        return false;
    }

    public boolean o(int i8) {
        if (g() <= i8 && i8 <= i()) {
            return true;
        }
        return false;
    }

    public Integer p() {
        return Integer.valueOf(i());
    }

    public Integer r() {
        return Integer.valueOf(g());
    }

    @Override // kotlin.ranges.IntProgression
    public String toString() {
        return g() + ".." + i();
    }
}
