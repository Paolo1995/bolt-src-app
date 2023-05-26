package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LocaleListCompat {

    /* renamed from: b  reason: collision with root package name */
    private static final LocaleListCompat f5802b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    private final LocaleListInterface f5803a;

    /* loaded from: classes.dex */
    static class Api21Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Locale[] f5804a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        private Api21Impl() {
        }

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f5804a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String a8 = ICUCompat.a(locale);
            if (a8.isEmpty()) {
                String country = locale.getCountry();
                if (country.isEmpty() || country.equals(locale2.getCountry())) {
                    return true;
                }
                return false;
            }
            return a8.equals(ICUCompat.a(locale2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.f5803a = localeListInterface;
    }

    @NonNull
    public static LocaleListCompat a(@NonNull Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return i(Api24Impl.a(localeArr));
        }
        return new LocaleListCompat(new LocaleListCompatWrapper(localeArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (str.contains("_")) {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        } else {
            return new Locale(str);
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static LocaleListCompat c(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i8 = 0; i8 < length; i8++) {
                localeArr[i8] = Api21Impl.a(split[i8]);
            }
            return a(localeArr);
        }
        return e();
    }

    @NonNull
    public static LocaleListCompat e() {
        return f5802b;
    }

    @NonNull
    public static LocaleListCompat i(@NonNull LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    public Locale d(int i8) {
        return this.f5803a.get(i8);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof LocaleListCompat) && this.f5803a.equals(((LocaleListCompat) obj).f5803a)) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f5803a.isEmpty();
    }

    public int g() {
        return this.f5803a.size();
    }

    @NonNull
    public String h() {
        return this.f5803a.a();
    }

    public int hashCode() {
        return this.f5803a.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f5803a.toString();
    }
}
