package ee.mtakso.driver.ui.interactor.settings;

import eu.bolt.driver.core.language.Language;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageSettings.kt */
/* loaded from: classes3.dex */
public final class LanguageSettings {

    /* renamed from: a  reason: collision with root package name */
    private final List<Language> f26907a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Language, Integer> f26908b;

    /* renamed from: c  reason: collision with root package name */
    private final Language f26909c;

    public LanguageSettings(List<Language> languages, Map<Language, Integer> languageFlags, Language selectedLanguage) {
        Intrinsics.f(languages, "languages");
        Intrinsics.f(languageFlags, "languageFlags");
        Intrinsics.f(selectedLanguage, "selectedLanguage");
        this.f26907a = languages;
        this.f26908b = languageFlags;
        this.f26909c = selectedLanguage;
    }

    public final Map<Language, Integer> a() {
        return this.f26908b;
    }

    public final List<Language> b() {
        return this.f26907a;
    }

    public final Language c() {
        return this.f26909c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LanguageSettings) {
            LanguageSettings languageSettings = (LanguageSettings) obj;
            return Intrinsics.a(this.f26907a, languageSettings.f26907a) && Intrinsics.a(this.f26908b, languageSettings.f26908b) && Intrinsics.a(this.f26909c, languageSettings.f26909c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f26907a.hashCode() * 31) + this.f26908b.hashCode()) * 31) + this.f26909c.hashCode();
    }

    public String toString() {
        List<Language> list = this.f26907a;
        Map<Language, Integer> map = this.f26908b;
        Language language = this.f26909c;
        return "LanguageSettings(languages=" + list + ", languageFlags=" + map + ", selectedLanguage=" + language + ")";
    }
}
