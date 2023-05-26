package j$.time.temporal;

import j$.time.Duration;

/* loaded from: classes2.dex */
enum i implements r {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f50099a;

    static {
        Duration duration = Duration.f49956c;
    }

    i(String str) {
        this.f50099a = str;
    }

    @Override // j$.time.temporal.r
    public final k d(k kVar, long j8) {
        int i8 = c.f50095a[ordinal()];
        if (i8 == 1) {
            o oVar = j.f50102c;
            return kVar.d(j$.time.a.c(kVar.e(oVar), j8), oVar);
        } else if (i8 == 2) {
            return kVar.i(j8 / 256, b.YEARS).i((j8 % 256) * 3, b.MONTHS);
        } else {
            throw new IllegalStateException("Unreachable");
        }
    }

    @Override // j$.time.temporal.r
    public final boolean isDateBased() {
        return true;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f50099a;
    }
}
