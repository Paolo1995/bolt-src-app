package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public class BuildCompat {
    private BuildCompat() {
    }

    protected static boolean a(@NonNull String str, @NonNull String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        if (str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) < 0) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    @SuppressLint({"RestrictedApi"})
    @Deprecated
    public static boolean c() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 31 && (i8 < 30 || !a("S", Build.VERSION.CODENAME))) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 33 && (i8 < 32 || !a("Tiramisu", Build.VERSION.CODENAME))) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 33 && a("UpsideDownCake", Build.VERSION.CODENAME)) {
            return true;
        }
        return false;
    }
}
