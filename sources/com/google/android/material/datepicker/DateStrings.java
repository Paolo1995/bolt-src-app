package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DateStrings {
    private DateStrings() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, long j8, boolean z7, boolean z8, boolean z9) {
        String d8 = d(j8);
        if (z7) {
            d8 = String.format(context.getString(R$string.mtrl_picker_today_description), d8);
        }
        if (z8) {
            return String.format(context.getString(R$string.mtrl_picker_start_date_description), d8);
        }
        if (z9) {
            return String.format(context.getString(R$string.mtrl_picker_end_date_description), d8);
        }
        return d8;
    }

    static String b(long j8) {
        return c(j8, Locale.getDefault());
    }

    static String c(long j8, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.b(locale).format(new Date(j8));
        }
        return UtcDates.f(locale).format(new Date(j8));
    }

    static String d(long j8) {
        if (i(j8)) {
            return b(j8);
        }
        return g(j8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Context context, int i8) {
        if (UtcDates.i().get(1) == i8) {
            return String.format(context.getString(R$string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i8));
        }
        return String.format(context.getString(R$string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(long j8) {
        return DateUtils.formatDateTime(null, j8, 8228);
    }

    static String g(long j8) {
        return h(j8, Locale.getDefault());
    }

    static String h(long j8, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.m(locale).format(new Date(j8));
        }
        return UtcDates.f(locale).format(new Date(j8));
    }

    private static boolean i(long j8) {
        Calendar i8 = UtcDates.i();
        Calendar k8 = UtcDates.k();
        k8.setTimeInMillis(j8);
        if (i8.get(1) == k8.get(1)) {
            return true;
        }
        return false;
    }
}
