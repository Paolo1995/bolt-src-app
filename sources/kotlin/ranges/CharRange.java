package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes5.dex */
public final class CharRange extends CharProgression implements ClosedRange<Character> {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f51047j = new Companion(null);

    /* renamed from: k  reason: collision with root package name */
    private static final CharRange f51048k = new CharRange(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CharRange(char c8, char c9) {
        super(c8, c9, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CharRange) {
            if (!isEmpty() || !((CharRange) obj).isEmpty()) {
                CharRange charRange = (CharRange) obj;
                if (g() != charRange.g() || i() != charRange.i()) {
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
        return (g() * 31) + i();
    }

    public boolean isEmpty() {
        if (Intrinsics.h(g(), i()) > 0) {
            return true;
        }
        return false;
    }

    public boolean m(char c8) {
        if (Intrinsics.h(g(), c8) <= 0 && Intrinsics.h(c8, i()) <= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return g() + ".." + i();
    }
}
