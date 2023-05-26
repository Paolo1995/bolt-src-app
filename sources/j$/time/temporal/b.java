package j$.time.temporal;

import j$.time.Duration;

/* loaded from: classes2.dex */
public enum b implements r {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");
    

    /* renamed from: a  reason: collision with root package name */
    private final String f50094a;

    static {
        Duration.g(1L);
        Duration.g(1000L);
        Duration.g(1000000L);
        Duration.h();
    }

    b(String str) {
        this.f50094a = str;
    }

    @Override // j$.time.temporal.r
    public final k d(k kVar, long j8) {
        return kVar.i(j8, this);
    }

    @Override // j$.time.temporal.r
    public final boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f50094a;
    }
}
