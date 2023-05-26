package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
class TimeSource {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeSource f13378c = new TimeSource(null, null);

    /* renamed from: a  reason: collision with root package name */
    private final Long f13379a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f13380b;

    private TimeSource(Long l8, TimeZone timeZone) {
        this.f13379a = l8;
        this.f13380b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TimeSource c() {
        return f13378c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f13380b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l8 = this.f13379a;
        if (l8 != null) {
            calendar.setTimeInMillis(l8.longValue());
        }
        return calendar;
    }
}
