package androidx.core.os;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
final class LocaleListCompatWrapper implements LocaleListInterface {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f5805c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f5806d = new Locale("en", "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f5807e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f5808f = LocaleListCompat.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f5809a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f5810b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListCompatWrapper(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f5809a = f5805c;
            this.f5810b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 < localeArr.length; i8++) {
            Locale locale = localeArr[i8];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    c(sb, locale2);
                    if (i8 < localeArr.length - 1) {
                        sb.append(',');
                    }
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException("list[" + i8 + "] is null");
            }
        }
        this.f5809a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f5810b = sb.toString();
    }

    static void c(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public String a() {
        return this.f5810b;
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListCompatWrapper)) {
            return false;
        }
        Locale[] localeArr = ((LocaleListCompatWrapper) obj).f5809a;
        if (this.f5809a.length != localeArr.length) {
            return false;
        }
        int i8 = 0;
        while (true) {
            Locale[] localeArr2 = this.f5809a;
            if (i8 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i8].equals(localeArr[i8])) {
                return false;
            }
            i8++;
        }
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i8) {
        if (i8 >= 0) {
            Locale[] localeArr = this.f5809a;
            if (i8 < localeArr.length) {
                return localeArr[i8];
            }
        }
        return null;
    }

    public int hashCode() {
        int i8 = 1;
        for (Locale locale : this.f5809a) {
            i8 = (i8 * 31) + locale.hashCode();
        }
        return i8;
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        if (this.f5809a.length == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f5809a.length;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i8 = 0;
        while (true) {
            Locale[] localeArr = this.f5809a;
            if (i8 < localeArr.length) {
                sb.append(localeArr[i8]);
                if (i8 < this.f5809a.length - 1) {
                    sb.append(',');
                }
                i8++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
