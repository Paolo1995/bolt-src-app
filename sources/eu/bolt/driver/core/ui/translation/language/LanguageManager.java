package eu.bolt.driver.core.ui.translation.language;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import eu.bolt.driver.core.language.Language;
import eu.bolt.driver.core.language.LanguageUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: LanguageManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class LanguageManager {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f41231e = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private static final Map<Language, Integer> f41232f = new LinkedHashMap();

    /* renamed from: g  reason: collision with root package name */
    private static final Map<Language, String> f41233g = new LinkedHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final LanguageListProvider f41234a;

    /* renamed from: b  reason: collision with root package name */
    private final LanguageSettingsStorage f41235b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f41236c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f41237d;

    /* compiled from: LanguageManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public LanguageManager(LanguageListProvider languageListProvider, LanguageSettingsStorage languageSettingsStorage, Context context) {
        Lazy b8;
        Intrinsics.f(languageListProvider, "languageListProvider");
        Intrinsics.f(languageSettingsStorage, "languageSettingsStorage");
        Intrinsics.f(context, "context");
        this.f41234a = languageListProvider;
        this.f41235b = languageSettingsStorage;
        this.f41236c = context;
        b8 = LazyKt__LazyJVMKt.b(new Function0<List<? extends Language>>() { // from class: eu.bolt.driver.core.ui.translation.language.LanguageManager$languages$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Language> invoke() {
                LanguageListProvider languageListProvider2;
                languageListProvider2 = LanguageManager.this.f41234a;
                return languageListProvider2.b();
            }
        });
        this.f41237d = b8;
    }

    private final Language c(String str, String str2) {
        Object W;
        Object W2;
        boolean w7;
        boolean w8;
        List<Language> j8 = j();
        ArrayList arrayList = new ArrayList();
        for (Object obj : j8) {
            w8 = StringsKt__StringsJVMKt.w(((Language) obj).b(), str, true);
            if (w8) {
                arrayList.add(obj);
            }
        }
        Language language = null;
        if (arrayList.size() > 1) {
            if (str2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    w7 = StringsKt__StringsJVMKt.w(str2, ((Language) obj2).a(), true);
                    if (w7) {
                        arrayList2.add(obj2);
                    }
                }
                arrayList = arrayList2;
            } else {
                W2 = CollectionsKt___CollectionsKt.W(arrayList);
                language = (Language) W2;
            }
        }
        if (!arrayList.isEmpty()) {
            W = CollectionsKt___CollectionsKt.W(arrayList);
            language = (Language) W;
        }
        if (language == null) {
            return this.f41234a.a();
        }
        return language;
    }

    private final String g(Language language) {
        Map<Language, String> map = f41233g;
        String str = map.get(language);
        if (str == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            String a8 = language.a();
            Locale locale = Locale.getDefault();
            Intrinsics.e(locale, "getDefault()");
            String lowerCase = a8.toLowerCase(locale);
            Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            str = String.format("%s-%s", Arrays.copyOf(new Object[]{language.b(), lowerCase}, 2));
            Intrinsics.e(str, "format(format, *args)");
            map.put(language, str);
        }
        return str;
    }

    private final Language i() {
        Locale locale;
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = this.f41236c.getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = this.f41236c.getResources().getConfiguration().locale;
        }
        String language = locale.getLanguage();
        Intrinsics.e(language, "locale.language");
        return c(language, locale.getCountry());
    }

    private final void n(Language language) {
        Locale.setDefault(LanguageUtils.f40820a.a(language));
    }

    public final Context b(Context context) {
        Intrinsics.f(context, "context");
        Language f8 = f();
        Locale a8 = LanguageUtils.f40820a.a(f8);
        n(f8);
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(a8);
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.e(createConfigurationContext, "context.createConfigurationContext(configuration)");
        return createConfigurationContext;
    }

    public final Map<Language, Integer> d() {
        int v7;
        Map<Language, Integer> q8;
        List<Language> j8 = j();
        v7 = CollectionsKt__IterablesKt.v(j8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Language language : j8) {
            arrayList.add(TuplesKt.a(language, Integer.valueOf(h(language))));
        }
        q8 = MapsKt__MapsKt.q(arrayList);
        return q8;
    }

    public final String e() {
        return g(f());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final eu.bolt.driver.core.language.Language f() {
        /*
            r2 = this;
            eu.bolt.driver.core.ui.translation.language.LanguageSettingsStorage r0 = r2.f41235b
            java.lang.String r0 = r0.a()
            if (r0 == 0) goto L11
            boolean r1 = kotlin.text.StringsKt.y(r0)
            if (r1 == 0) goto Lf
            goto L11
        Lf:
            r1 = 0
            goto L12
        L11:
            r1 = 1
        L12:
            if (r1 == 0) goto L19
            eu.bolt.driver.core.language.Language r0 = r2.i()
            goto L1d
        L19:
            eu.bolt.driver.core.language.Language r0 = r2.k(r0)
        L1d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.core.ui.translation.language.LanguageManager.f():eu.bolt.driver.core.language.Language");
    }

    public final int h(Language language) {
        Intrinsics.f(language, "language");
        Map<Language, Integer> map = f41232f;
        Integer num = map.get(language);
        if (num == null) {
            Resources resources = this.f41236c.getResources();
            String a8 = language.a();
            Locale locale = Locale.getDefault();
            Intrinsics.e(locale, "getDefault()");
            String lowerCase = a8.toLowerCase(locale);
            Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            num = Integer.valueOf(resources.getIdentifier("flag_" + lowerCase, "drawable", this.f41236c.getPackageName()));
            map.put(language, num);
        }
        return num.intValue();
    }

    public final List<Language> j() {
        return (List) this.f41237d.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final eu.bolt.driver.core.language.Language k(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto Lc
            boolean r1 = kotlin.text.StringsKt.y(r7)
            if (r1 == 0) goto La
            goto Lc
        La:
            r1 = 0
            goto Ld
        Lc:
            r1 = 1
        Ld:
            if (r1 == 0) goto L14
            eu.bolt.driver.core.language.Language r7 = r6.i()
            return r7
        L14:
            r1 = 0
            int r2 = r7.length()
            r3 = 2
            r4 = 6
            java.lang.String r5 = "this as java.lang.String…ing(startIndex, endIndex)"
            if (r2 != r4) goto L2f
            r1 = 4
            java.lang.String r1 = r7.substring(r1, r4)
            kotlin.jvm.internal.Intrinsics.e(r1, r5)
            java.lang.String r7 = r7.substring(r0, r3)
            kotlin.jvm.internal.Intrinsics.e(r7, r5)
            goto L45
        L2f:
            int r2 = r7.length()
            r4 = 5
            if (r2 != r4) goto L45
            r1 = 3
            java.lang.String r1 = r7.substring(r1, r4)
            kotlin.jvm.internal.Intrinsics.e(r1, r5)
            java.lang.String r7 = r7.substring(r0, r3)
            kotlin.jvm.internal.Intrinsics.e(r7, r5)
        L45:
            eu.bolt.driver.core.language.Language r7 = r6.c(r7, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.driver.core.ui.translation.language.LanguageManager.k(java.lang.String):eu.bolt.driver.core.language.Language");
    }

    public final void l() {
        n(f());
    }

    public final void m(Language language) {
        Intrinsics.f(language, "language");
        this.f41235b.b(g(language));
        n(language);
    }
}
