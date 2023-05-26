package ee.mtakso.driver.utils;

import java.util.Locale;

/* loaded from: classes5.dex */
public class NumberUtils {
    public static String a(Double d8) {
        if (d8 == null) {
            return "";
        }
        double doubleValue = d8.doubleValue();
        if (doubleValue == ((long) doubleValue)) {
            return String.format(Locale.ENGLISH, "%.1f", Double.valueOf(doubleValue));
        }
        return String.format(Locale.ENGLISH, "%.2f", Double.valueOf(doubleValue));
    }
}
