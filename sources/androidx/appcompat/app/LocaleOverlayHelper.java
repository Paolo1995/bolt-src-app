package androidx.appcompat.app;

import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: classes.dex */
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        Locale d8;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i8 = 0; i8 < localeListCompat.g() + localeListCompat2.g(); i8++) {
            if (i8 < localeListCompat.g()) {
                d8 = localeListCompat.d(i8);
            } else {
                d8 = localeListCompat2.d(i8 - localeListCompat.g());
            }
            if (d8 != null) {
                linkedHashSet.add(d8);
            }
        }
        return LocaleListCompat.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocaleListCompat b(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat != null && !localeListCompat.f()) {
            return a(localeListCompat, localeListCompat2);
        }
        return LocaleListCompat.e();
    }
}
