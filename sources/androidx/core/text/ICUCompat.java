package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ICUCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f5881a;

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* loaded from: classes.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f5881a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    private ICUCompat() {
    }

    public static String a(@NonNull Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.c(Api24Impl.a(Api24Impl.b(locale)));
        }
        try {
            return Api21Impl.a((Locale) f5881a.invoke(null, locale));
        } catch (IllegalAccessException e8) {
            Log.w("ICUCompat", e8);
            return Api21Impl.a(locale);
        } catch (InvocationTargetException e9) {
            Log.w("ICUCompat", e9);
            return Api21Impl.a(locale);
        }
    }
}
