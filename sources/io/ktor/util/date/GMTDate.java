package io.ktor.util.date;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Date.kt */
/* loaded from: classes5.dex */
public final class GMTDate implements Comparable<GMTDate> {

    /* renamed from: o  reason: collision with root package name */
    public static final Companion f47065o = new Companion(null);

    /* renamed from: p  reason: collision with root package name */
    private static final GMTDate f47066p = DateJvmKt.b(0L);

    /* renamed from: f  reason: collision with root package name */
    private final int f47067f;

    /* renamed from: g  reason: collision with root package name */
    private final int f47068g;

    /* renamed from: h  reason: collision with root package name */
    private final int f47069h;

    /* renamed from: i  reason: collision with root package name */
    private final WeekDay f47070i;

    /* renamed from: j  reason: collision with root package name */
    private final int f47071j;

    /* renamed from: k  reason: collision with root package name */
    private final int f47072k;

    /* renamed from: l  reason: collision with root package name */
    private final Month f47073l;

    /* renamed from: m  reason: collision with root package name */
    private final int f47074m;

    /* renamed from: n  reason: collision with root package name */
    private final long f47075n;

    /* compiled from: Date.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GMTDate(int i8, int i9, int i10, WeekDay dayOfWeek, int i11, int i12, Month month, int i13, long j8) {
        Intrinsics.f(dayOfWeek, "dayOfWeek");
        Intrinsics.f(month, "month");
        this.f47067f = i8;
        this.f47068g = i9;
        this.f47069h = i10;
        this.f47070i = dayOfWeek;
        this.f47071j = i11;
        this.f47072k = i12;
        this.f47073l = month;
        this.f47074m = i13;
        this.f47075n = j8;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(GMTDate other) {
        Intrinsics.f(other, "other");
        return Intrinsics.i(this.f47075n, other.f47075n);
    }

    public final long c() {
        return this.f47075n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GMTDate) {
            GMTDate gMTDate = (GMTDate) obj;
            return this.f47067f == gMTDate.f47067f && this.f47068g == gMTDate.f47068g && this.f47069h == gMTDate.f47069h && this.f47070i == gMTDate.f47070i && this.f47071j == gMTDate.f47071j && this.f47072k == gMTDate.f47072k && this.f47073l == gMTDate.f47073l && this.f47074m == gMTDate.f47074m && this.f47075n == gMTDate.f47075n;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((this.f47067f * 31) + this.f47068g) * 31) + this.f47069h) * 31) + this.f47070i.hashCode()) * 31) + this.f47071j) * 31) + this.f47072k) * 31) + this.f47073l.hashCode()) * 31) + this.f47074m) * 31) + a.a(this.f47075n);
    }

    public String toString() {
        return "GMTDate(seconds=" + this.f47067f + ", minutes=" + this.f47068g + ", hours=" + this.f47069h + ", dayOfWeek=" + this.f47070i + ", dayOfMonth=" + this.f47071j + ", dayOfYear=" + this.f47072k + ", month=" + this.f47073l + ", year=" + this.f47074m + ", timestamp=" + this.f47075n + ')';
    }
}
