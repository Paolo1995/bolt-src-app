package eu.bolt.driver.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateTimeFormatter.kt */
@Singleton
/* loaded from: classes5.dex */
public final class DateTimeFormatter {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f41301b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, SimpleDateFormat> f41302a = new LinkedHashMap();

    /* compiled from: DateTimeFormatter.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String a(long j8) {
        long j9 = j8 * 1000;
        Calendar calendar = Calendar.getInstance();
        int i8 = calendar.get(1);
        calendar.setTimeInMillis(j9);
        if (i8 - calendar.get(1) < 1) {
            String format = b("dd MMM, HH:mm").format(Long.valueOf(j9));
            Intrinsics.e(format, "getDateFormat(FORMAT_DAY…E).format(dateTimeMillis)");
            return format;
        }
        String format2 = b("dd MMM yyyy, HH:mm").format(Long.valueOf(j9));
        Intrinsics.e(format2, "getDateFormat(FORMAT_DAY…E).format(dateTimeMillis)");
        return format2;
    }

    public final SimpleDateFormat b(String dateFormatStr) {
        Intrinsics.f(dateFormatStr, "dateFormatStr");
        Map<String, SimpleDateFormat> map = this.f41302a;
        SimpleDateFormat simpleDateFormat = map.get(dateFormatStr);
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(dateFormatStr, Locale.getDefault());
            map.put(dateFormatStr, simpleDateFormat);
        }
        return simpleDateFormat;
    }

    public final String c(long j8) {
        if (TimeUnit.DAYS.convert(Math.abs(System.currentTimeMillis() - j8), TimeUnit.MILLISECONDS) > 0) {
            String format = b("dd.MM").format(Long.valueOf(j8));
            Intrinsics.e(format, "{ // Draw date\n         …dateTimeMillis)\n        }");
            return format;
        }
        String format2 = b("HH:mm").format(Long.valueOf(j8));
        Intrinsics.e(format2, "{ // Draw time\n         …dateTimeMillis)\n        }");
        return format2;
    }

    public final void d() {
        this.f41302a.clear();
    }
}
