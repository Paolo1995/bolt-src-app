package androidx.camera.core;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static int f3201a = 3;

    private Logger() {
    }

    public static void a(@NonNull String str, @NonNull String str2) {
        String j8 = j(str);
        if (g(j8, 3)) {
            Log.d(j8, str2);
        }
    }

    public static void b(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String j8 = j(str);
        if (g(j8, 3)) {
            Log.d(j8, str2, th);
        }
    }

    public static void c(@NonNull String str, @NonNull String str2) {
        String j8 = j(str);
        if (g(j8, 6)) {
            Log.e(j8, str2);
        }
    }

    public static void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String j8 = j(str);
        if (g(j8, 6)) {
            Log.e(j8, str2, th);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        String j8 = j(str);
        if (g(j8, 4)) {
            Log.i(j8, str2);
        }
    }

    public static boolean f(@NonNull String str) {
        return g(j(str), 3);
    }

    private static boolean g(@NonNull String str, int i8) {
        if (f3201a > i8 && !Log.isLoggable(str, i8)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h() {
        f3201a = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(int i8) {
        f3201a = i8;
    }

    @NonNull
    private static String j(@NonNull String str) {
        if (Build.VERSION.SDK_INT <= 25 && 23 < str.length()) {
            return str.substring(0, 23);
        }
        return str;
    }

    public static void k(@NonNull String str, @NonNull String str2) {
        String j8 = j(str);
        if (g(j8, 5)) {
            Log.w(j8, str2);
        }
    }

    public static void l(@NonNull String str, @NonNull String str2, @NonNull Throwable th) {
        String j8 = j(str);
        if (g(j8, 5)) {
            Log.w(j8, str2, th);
        }
    }
}
