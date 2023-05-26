package kotlin.text;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Strings.kt */
/* loaded from: classes5.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker, j$.util.Iterator {

    /* renamed from: f  reason: collision with root package name */
    private int f51147f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f51148g;

    /* renamed from: h  reason: collision with root package name */
    private int f51149h;

    /* renamed from: i  reason: collision with root package name */
    private IntRange f51150i;

    /* renamed from: j  reason: collision with root package name */
    private int f51151j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ DelimitedRangesSequence f51152k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        int i8;
        CharSequence charSequence;
        int j8;
        this.f51152k = delimitedRangesSequence;
        i8 = delimitedRangesSequence.f51144b;
        charSequence = delimitedRangesSequence.f51143a;
        j8 = RangesKt___RangesKt.j(i8, 0, charSequence.length());
        this.f51148g = j8;
        this.f51149h = j8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r0 < r4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b() {
        /*
            r6 = this;
            int r0 = r6.f51149h
            r1 = 0
            if (r0 >= 0) goto Lc
            r6.f51147f = r1
            r0 = 0
            r6.f51150i = r0
            goto L9e
        Lc:
            kotlin.text.DelimitedRangesSequence r0 = r6.f51152k
            int r0 = kotlin.text.DelimitedRangesSequence.d(r0)
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L23
            int r0 = r6.f51151j
            int r0 = r0 + r3
            r6.f51151j = r0
            kotlin.text.DelimitedRangesSequence r4 = r6.f51152k
            int r4 = kotlin.text.DelimitedRangesSequence.d(r4)
            if (r0 >= r4) goto L31
        L23:
            int r0 = r6.f51149h
            kotlin.text.DelimitedRangesSequence r4 = r6.f51152k
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.c(r4)
            int r4 = r4.length()
            if (r0 <= r4) goto L47
        L31:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.f51148g
            kotlin.text.DelimitedRangesSequence r4 = r6.f51152k
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.c(r4)
            int r4 = kotlin.text.StringsKt.V(r4)
            r0.<init>(r1, r4)
            r6.f51150i = r0
            r6.f51149h = r2
            goto L9c
        L47:
            kotlin.text.DelimitedRangesSequence r0 = r6.f51152k
            kotlin.jvm.functions.Function2 r0 = kotlin.text.DelimitedRangesSequence.b(r0)
            kotlin.text.DelimitedRangesSequence r4 = r6.f51152k
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.c(r4)
            int r5 = r6.f51149h
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.s(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L77
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.f51148g
            kotlin.text.DelimitedRangesSequence r4 = r6.f51152k
            java.lang.CharSequence r4 = kotlin.text.DelimitedRangesSequence.c(r4)
            int r4 = kotlin.text.StringsKt.V(r4)
            r0.<init>(r1, r4)
            r6.f51150i = r0
            r6.f51149h = r2
            goto L9c
        L77:
            java.lang.Object r2 = r0.a()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.b()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.f51148g
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.o(r4, r2)
            r6.f51150i = r4
            int r2 = r2 + r0
            r6.f51148g = r2
            if (r0 != 0) goto L99
            r1 = 1
        L99:
            int r2 = r2 + r1
            r6.f51149h = r2
        L9c:
            r6.f51147f = r3
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.b():void");
    }

    @Override // java.util.Iterator, j$.util.Iterator
    /* renamed from: c */
    public IntRange next() {
        if (this.f51147f == -1) {
            b();
        }
        if (this.f51147f != 0) {
            IntRange intRange = this.f51150i;
            Intrinsics.d(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f51150i = null;
            this.f51147f = -1;
            return intRange;
        }
        throw new NoSuchElementException();
    }

    @Override // j$.util.Iterator
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    @Override // java.util.Iterator
    public /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super IntRange> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public boolean hasNext() {
        if (this.f51147f == -1) {
            b();
        }
        if (this.f51147f == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator, j$.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
