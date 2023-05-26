package eu.bolt.driver.core.language;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import eu.bolt.driver.core.field.SimpleField;
import eu.bolt.kalev.Kalev;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: LanguageManager.kt */
/* loaded from: classes5.dex */
public final class LanguageManager {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f40815e = {Reflection.d(new MutablePropertyReference1Impl(LanguageManager.class, "language", "getLanguage()Ljava/lang/String;", 0))};

    /* renamed from: a  reason: collision with root package name */
    private final Context f40816a;

    /* renamed from: b  reason: collision with root package name */
    private final Language f40817b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Language> f40818c;

    /* renamed from: d  reason: collision with root package name */
    private final SimpleField f40819d;

    public LanguageManager(SimpleField<String> languageField, Context context, Language defaultLanguage, List<Language> availableLanguages) {
        Intrinsics.f(languageField, "languageField");
        Intrinsics.f(context, "context");
        Intrinsics.f(defaultLanguage, "defaultLanguage");
        Intrinsics.f(availableLanguages, "availableLanguages");
        this.f40816a = context;
        this.f40817b = defaultLanguage;
        this.f40818c = availableLanguages;
        this.f40819d = languageField;
    }

    private final Language a(String str) {
        Pair a8;
        int length = str.length();
        if (length != 5) {
            if (length != 6) {
                a8 = TuplesKt.a(str, null);
            } else {
                String substring = str.substring(0, 2);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = str.substring(4, 6);
                Intrinsics.e(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                a8 = TuplesKt.a(substring, substring2);
            }
        } else {
            String substring3 = str.substring(0, 2);
            Intrinsics.e(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring4 = str.substring(3, 5);
            Intrinsics.e(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
            a8 = TuplesKt.a(substring3, substring4);
        }
        return b((String) a8.a(), (String) a8.b(), this.f40818c, this.f40817b);
    }

    private final Language b(String str, String str2, List<Language> list, Language language) {
        int v7;
        Object t02;
        boolean w7;
        List<Language> arrayList = new ArrayList<>();
        for (Object obj : list) {
            w7 = StringsKt__StringsJVMKt.w(((Language) obj).b(), str, true);
            if (w7) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                return c(str2, arrayList);
            }
            t02 = CollectionsKt___CollectionsKt.t0(arrayList);
            return (Language) t02;
        }
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (Language language2 : list) {
            arrayList2.add(language2.b());
        }
        Kalev.e(new IllegalStateException("Failed to find language by code: " + str + ". Available codes: " + arrayList2), "Failed to find language");
        return language;
    }

    private final Language c(String str, List<Language> list) {
        Object W;
        int v7;
        Object t02;
        boolean w7;
        W = CollectionsKt___CollectionsKt.W(list);
        Language language = (Language) W;
        if (str == null) {
            Kalev.e(new IllegalStateException("Multiple languages by code found. Country is null"), "Failed to find language");
            return language;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            w7 = StringsKt__StringsJVMKt.w(str, ((Language) obj).a(), true);
            if (w7) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (size != 0) {
            if (size != 1) {
                Kalev.e(new IllegalStateException("Multiple languages by code and country found"), "Failed to find language");
                return language;
            }
            t02 = CollectionsKt___CollectionsKt.t0(arrayList);
            return (Language) t02;
        }
        v7 = CollectionsKt__IterablesKt.v(list, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (Language language2 : list) {
            arrayList2.add(language2.a());
        }
        Kalev.e(new IllegalStateException("Failed to find language by country: " + str + ". Available countries: " + arrayList2), "Failed to find language");
        return language;
    }

    private final String e() {
        return (String) this.f40819d.a(this, f40815e[0]);
    }

    private final Language f() {
        Locale locale;
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = this.f40816a.getResources().getConfiguration().getLocales();
            locale = locales.get(0);
        } else {
            locale = this.f40816a.getResources().getConfiguration().locale;
        }
        String language = locale.getLanguage();
        Intrinsics.e(language, "locale.language");
        return b(language, locale.getCountry(), this.f40818c, this.f40817b);
    }

    public final Language d() {
        boolean z7;
        String e8 = e();
        if (e8.length() == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return f();
        }
        return a(e8);
    }
}
