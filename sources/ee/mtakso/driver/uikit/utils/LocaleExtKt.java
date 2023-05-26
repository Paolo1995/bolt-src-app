package ee.mtakso.driver.uikit.utils;

import androidx.core.text.TextUtilsCompat;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocaleExt.kt */
/* loaded from: classes5.dex */
public final class LocaleExtKt {
    public static final boolean a() {
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        return b(locale);
    }

    public static final boolean b(Locale locale) {
        Intrinsics.f(locale, "<this>");
        if (TextUtilsCompat.a(locale) == 0) {
            return true;
        }
        return false;
    }
}
