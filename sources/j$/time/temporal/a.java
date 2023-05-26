package j$.time.temporal;

import j$.time.format.y;
import java.util.HashMap;

/* loaded from: classes2.dex */
public enum a implements o {
    NANO_OF_SECOND("NanoOfSecond", t.i(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", t.i(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", t.i(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", t.i(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", t.i(0, 999)),
    MILLI_OF_DAY("MilliOfDay", t.i(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", t.i(0, 59), 0),
    SECOND_OF_DAY("SecondOfDay", t.i(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", t.i(0, 59), 0),
    MINUTE_OF_DAY("MinuteOfDay", t.i(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", t.i(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", t.i(1, 12)),
    HOUR_OF_DAY("HourOfDay", t.i(0, 23), 0),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", t.i(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", t.i(0, 1), 0),
    DAY_OF_WEEK("DayOfWeek", t.i(1, 7), 0),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", t.i(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", t.i(1, 7)),
    DAY_OF_MONTH("DayOfMonth", t.j(28, 31), 0),
    DAY_OF_YEAR("DayOfYear", t.j(365, 366)),
    EPOCH_DAY("EpochDay", t.i(-365249999634L, 365249999634L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", t.j(4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", t.i(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", t.i(1, 12), 0),
    PROLEPTIC_MONTH("ProlepticMonth", t.i(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", t.j(999999999, 1000000000)),
    YEAR("Year", t.i(-999999999, 999999999), 0),
    ERA("Era", t.i(0, 1), 0),
    INSTANT_SECONDS("InstantSeconds", t.i(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", t.i(-64800, 64800));
    

    /* renamed from: a  reason: collision with root package name */
    private final String f50091a;

    /* renamed from: b  reason: collision with root package name */
    private final t f50092b;

    static {
        b bVar = b.NANOS;
    }

    a(String str, t tVar) {
        this.f50091a = str;
        this.f50092b = tVar;
    }

    a(String str, t tVar, int i8) {
        this.f50091a = str;
        this.f50092b = tVar;
    }

    @Override // j$.time.temporal.o
    public final boolean d(l lVar) {
        return lVar.k(this);
    }

    @Override // j$.time.temporal.o
    public final t e(l lVar) {
        return lVar.h(this);
    }

    @Override // j$.time.temporal.o
    public final t g() {
        return this.f50092b;
    }

    @Override // j$.time.temporal.o
    public final /* synthetic */ l h(HashMap hashMap, l lVar, y yVar) {
        return null;
    }

    @Override // j$.time.temporal.o
    public final long i(l lVar) {
        return lVar.n(this);
    }

    @Override // j$.time.temporal.o
    public final boolean isDateBased() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    @Override // j$.time.temporal.o
    public final boolean isTimeBased() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    @Override // j$.time.temporal.o
    public final k j(k kVar, long j8) {
        return kVar.d(j8, this);
    }

    public final int k(long j8) {
        return this.f50092b.a(j8, this);
    }

    public final void n(long j8) {
        this.f50092b.b(j8, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f50091a;
    }
}
