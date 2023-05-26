package ee.mtakso.driver.ui.utils;

import androidx.annotation.NonNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes5.dex */
public class Dates {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f34302a;

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f34303b;

    static {
        Locale locale = Locale.US;
        f34302a = new SimpleDateFormat("yyyy-MM", locale);
        f34303b = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static String a(String str) {
        return b(str, f34302a, 2);
    }

    private static String b(String str, SimpleDateFormat simpleDateFormat, int i8) {
        Date d8 = d(simpleDateFormat, str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d8);
        return calendar.getDisplayName(i8, 1, Locale.getDefault());
    }

    public static String c(String str) {
        return b(str, f34303b, 7);
    }

    private static Date d(SimpleDateFormat simpleDateFormat, String str) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            throw new IllegalStateException("Unsupported date format: " + str);
        }
    }

    public static Date e(@NonNull String str) {
        return d(f34303b, str);
    }
}
