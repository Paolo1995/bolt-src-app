package eu.bolt.driver.core.language;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Language.kt */
/* loaded from: classes5.dex */
public final class Language {

    /* renamed from: a  reason: collision with root package name */
    private final String f40812a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40813b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40814c;

    public Language(String languageCode, String countryCode, String languageName) {
        Intrinsics.f(languageCode, "languageCode");
        Intrinsics.f(countryCode, "countryCode");
        Intrinsics.f(languageName, "languageName");
        this.f40812a = languageCode;
        this.f40813b = countryCode;
        this.f40814c = languageName;
    }

    public final String a() {
        return this.f40813b;
    }

    public final String b() {
        return this.f40812a;
    }

    public final String c() {
        return this.f40814c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Language) {
            Language language = (Language) obj;
            return Intrinsics.a(this.f40812a, language.f40812a) && Intrinsics.a(this.f40813b, language.f40813b) && Intrinsics.a(this.f40814c, language.f40814c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f40812a.hashCode() * 31) + this.f40813b.hashCode()) * 31) + this.f40814c.hashCode();
    }

    public String toString() {
        String str = this.f40812a;
        String str2 = this.f40813b;
        String str3 = this.f40814c;
        return "Language(languageCode=" + str + ", countryCode=" + str2 + ", languageName=" + str3 + ")";
    }
}
