package kotlin.time;

import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Duration.kt */
/* loaded from: classes5.dex */
public final class DurationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j8, int i8) {
        return Duration.l((j8 << 1) + i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j8) {
        return Duration.l((j8 << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j8) {
        long k8;
        if (new LongRange(-4611686018426L, 4611686018426L).m(j8)) {
            return l(n(j8));
        }
        k8 = RangesKt___RangesKt.k(j8, -4611686018427387903L, 4611686018427387903L);
        return j(k8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j8) {
        return Duration.l(j8 << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j8) {
        if (new LongRange(-4611686018426999999L, 4611686018426999999L).m(j8)) {
            return l(j8);
        }
        return j(o(j8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n(long j8) {
        return j8 * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(long j8) {
        return j8 / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00a6 A[EDGE_INSN: B:170:0x00a6->B:49:0x00a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0098 A[LOOP:1: B:36:0x006c->B:47:0x0098, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long p(java.lang.String r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.p(java.lang.String, boolean):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final long q(java.lang.String r9) {
        /*
            int r0 = r9.length()
            r1 = 0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L18
            char r5 = r9.charAt(r4)
            java.lang.String r6 = "+-"
            boolean r5 = kotlin.text.StringsKt.P(r6, r5, r4, r2, r1)
            if (r5 == 0) goto L18
            r5 = 1
            goto L19
        L18:
            r5 = 0
        L19:
            int r0 = r0 - r5
            r6 = 16
            if (r0 <= r6) goto L6e
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r6 = kotlin.text.StringsKt.V(r9)
            r0.<init>(r5, r6)
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L36
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L36
        L34:
            r0 = 1
            goto L5b
        L36:
            java.util.Iterator r0 = r0.iterator()
        L3a:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L34
            r5 = r0
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            kotlin.ranges.CharRange r6 = new kotlin.ranges.CharRange
            r7 = 48
            r8 = 57
            r6.<init>(r7, r8)
            char r5 = r9.charAt(r5)
            boolean r5 = r6.m(r5)
            if (r5 != 0) goto L3a
            r0 = 0
        L5b:
            if (r0 == 0) goto L6e
            char r9 = r9.charAt(r4)
            r0 = 45
            if (r9 != r0) goto L68
            r0 = -9223372036854775808
            goto L6d
        L68:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L6d:
            return r0
        L6e:
            java.lang.String r0 = "+"
            boolean r0 = kotlin.text.StringsKt.L(r9, r0, r4, r2, r1)
            if (r0 == 0) goto L7a
            java.lang.String r9 = kotlin.text.StringsKt.a1(r9, r3)
        L7a:
            long r0 = java.lang.Long.parseLong(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.DurationKt.q(java.lang.String):long");
    }

    public static final long r(double d8, DurationUnit unit) {
        long c8;
        long c9;
        Intrinsics.f(unit, "unit");
        double a8 = DurationUnitKt__DurationUnitJvmKt.a(d8, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(a8)) {
            c8 = MathKt__MathJVMKt.c(a8);
            if (new LongRange(-4611686018426999999L, 4611686018426999999L).m(c8)) {
                return l(c8);
            }
            c9 = MathKt__MathJVMKt.c(DurationUnitKt__DurationUnitJvmKt.a(d8, unit, DurationUnit.MILLISECONDS));
            return k(c9);
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long s(int i8, DurationUnit unit) {
        Intrinsics.f(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return l(DurationUnitKt__DurationUnitJvmKt.c(i8, unit, DurationUnit.NANOSECONDS));
        }
        return t(i8, unit);
    }

    public static final long t(long j8, DurationUnit unit) {
        long k8;
        Intrinsics.f(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long c8 = DurationUnitKt__DurationUnitJvmKt.c(4611686018426999999L, durationUnit, unit);
        if (new LongRange(-c8, c8).m(j8)) {
            return l(DurationUnitKt__DurationUnitJvmKt.c(j8, unit, durationUnit));
        }
        k8 = RangesKt___RangesKt.k(DurationUnitKt__DurationUnitJvmKt.b(j8, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L);
        return j(k8);
    }
}
