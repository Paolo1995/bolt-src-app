package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimeZoneJvm.kt */
/* loaded from: classes5.dex */
public final /* synthetic */ class TimeZoneKt__TimeZoneJvmKt {
    public static final /* synthetic */ boolean a(ZoneId zoneId) {
        return b(zoneId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(ZoneId zoneId) {
        try {
            return zoneId.getRules().isFixedOffset();
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    public static final Instant c(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.f(localDateTime, "<this>");
        Intrinsics.f(timeZone, "timeZone");
        return new Instant(localDateTime.c().atZone(timeZone.b()).toInstant());
    }

    public static final LocalDateTime d(Instant instant, TimeZone timeZone) {
        Intrinsics.f(instant, "<this>");
        Intrinsics.f(timeZone, "timeZone");
        try {
            return new LocalDateTime(j$.time.LocalDateTime.ofInstant(instant.c(), timeZone.b()));
        } catch (DateTimeException e8) {
            throw new DateTimeArithmeticException(e8);
        }
    }
}
