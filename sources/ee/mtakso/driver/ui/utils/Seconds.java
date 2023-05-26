package ee.mtakso.driver.ui.utils;

import android.content.Context;
import ee.mtakso.driver.R;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes5.dex */
public class Seconds {
    public static String a(Context context, long j8) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return String.format(Locale.getDefault(), "%1$d%2$s %3$d%4$s", Long.valueOf(timeUnit.toHours(j8)), context.getString(R.string.hours_short), Long.valueOf(timeUnit.toMinutes(j8 % TimeUnit.HOURS.toSeconds(1L))), context.getString(R.string.minutes_short));
    }
}
