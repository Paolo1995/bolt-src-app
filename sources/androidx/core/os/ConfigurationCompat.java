package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ConfigurationCompat {

    /* loaded from: classes.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(Configuration configuration) {
            LocaleList locales;
            locales = configuration.getLocales();
            return locales;
        }
    }

    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat a(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.i(Api24Impl.a(configuration));
        }
        return LocaleListCompat.a(configuration.locale);
    }
}
