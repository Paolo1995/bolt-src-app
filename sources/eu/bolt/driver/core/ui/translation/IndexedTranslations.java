package eu.bolt.driver.core.ui.translation;

import eu.bolt.driver.core.ui.translation.Translations;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranslationManager.kt */
/* loaded from: classes5.dex */
public final class IndexedTranslations {

    /* renamed from: a  reason: collision with root package name */
    private final Translations f41183a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f41184b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Translations.Plurals> f41185c;

    public IndexedTranslations(Translations translations, Map<String, String> translationList, Map<String, Translations.Plurals> pluralsTranslationList) {
        Intrinsics.f(translations, "translations");
        Intrinsics.f(translationList, "translationList");
        Intrinsics.f(pluralsTranslationList, "pluralsTranslationList");
        this.f41183a = translations;
        this.f41184b = translationList;
        this.f41185c = pluralsTranslationList;
    }

    public final Map<String, Translations.Plurals> a() {
        return this.f41185c;
    }

    public final Map<String, String> b() {
        return this.f41184b;
    }

    public final Translations c() {
        return this.f41183a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IndexedTranslations) {
            IndexedTranslations indexedTranslations = (IndexedTranslations) obj;
            return Intrinsics.a(this.f41183a, indexedTranslations.f41183a) && Intrinsics.a(this.f41184b, indexedTranslations.f41184b) && Intrinsics.a(this.f41185c, indexedTranslations.f41185c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41183a.hashCode() * 31) + this.f41184b.hashCode()) * 31) + this.f41185c.hashCode();
    }

    public String toString() {
        Translations translations = this.f41183a;
        Map<String, String> map = this.f41184b;
        Map<String, Translations.Plurals> map2 = this.f41185c;
        return "IndexedTranslations(translations=" + translations + ", translationList=" + map + ", pluralsTranslationList=" + map2 + ")";
    }
}
