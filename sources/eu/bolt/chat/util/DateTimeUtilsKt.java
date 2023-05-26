package eu.bolt.chat.util;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock$System;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DateTimeUtils.kt */
/* loaded from: classes5.dex */
public final class DateTimeUtilsKt {
    public static final LocalDateTime a(LocalDateTime.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return TimeZoneKt.b(Clock$System.f52030a.a(), TimeZone.Companion.a());
    }

    public static final LocalDateTime b(long j8) {
        return TimeZoneKt.b(Instant.Companion.b(j8), TimeZone.Companion.a());
    }

    public static final long c(LocalDateTime localDateTime) {
        Intrinsics.f(localDateTime, "<this>");
        return TimeZoneKt.a(localDateTime, TimeZone.Companion.a()).e();
    }
}
