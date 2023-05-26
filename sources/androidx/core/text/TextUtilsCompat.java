package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TextUtilsCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final Locale f5907a = new Locale("", "");

    /* loaded from: classes.dex */
    static class Api17Impl {
        private Api17Impl() {
        }

        static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    private TextUtilsCompat() {
    }

    public static int a(Locale locale) {
        return Api17Impl.a(locale);
    }

    @NonNull
    public static String b(@NonNull String str) {
        return TextUtils.htmlEncode(str);
    }
}
