package io.ktor.util.date;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateJvm.kt */
/* loaded from: classes5.dex */
public final class DateJvmKt {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeZone f47064a = DesugarTimeZone.getTimeZone("GMT");

    public static final GMTDate a(int i8, int i9, int i10, int i11, Month month, int i12) {
        Intrinsics.f(month, "month");
        Calendar calendar = Calendar.getInstance(f47064a, Locale.ROOT);
        Intrinsics.c(calendar);
        calendar.set(1, i12);
        calendar.set(2, month.ordinal());
        calendar.set(5, i11);
        calendar.set(11, i10);
        calendar.set(12, i9);
        calendar.set(13, i8);
        calendar.set(14, 0);
        return e(calendar, null);
    }

    public static final GMTDate b(Long l8) {
        Calendar calendar = Calendar.getInstance(f47064a, Locale.ROOT);
        Intrinsics.c(calendar);
        return e(calendar, l8);
    }

    public static /* synthetic */ GMTDate c(Long l8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            l8 = null;
        }
        return b(l8);
    }

    public static final long d() {
        return System.currentTimeMillis();
    }

    public static final GMTDate e(Calendar calendar, Long l8) {
        Intrinsics.f(calendar, "<this>");
        if (l8 != null) {
            calendar.setTimeInMillis(l8.longValue());
        }
        return new GMTDate(calendar.get(13), calendar.get(12), calendar.get(11), WeekDay.f47099g.a(((calendar.get(7) + 7) - 2) % 7), calendar.get(5), calendar.get(6), Month.f47084g.a(calendar.get(2)), calendar.get(1), calendar.getTimeInMillis());
    }
}
