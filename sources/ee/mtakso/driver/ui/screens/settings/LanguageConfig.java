package ee.mtakso.driver.ui.screens.settings;

import eu.bolt.driver.core.language.Language;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsScreenState.kt */
/* loaded from: classes5.dex */
public final class LanguageConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Language f33004a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33005b;

    public LanguageConfig(Language language, int i8) {
        Intrinsics.f(language, "language");
        this.f33004a = language;
        this.f33005b = i8;
    }

    public final Language a() {
        return this.f33004a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LanguageConfig) {
            LanguageConfig languageConfig = (LanguageConfig) obj;
            return Intrinsics.a(this.f33004a, languageConfig.f33004a) && this.f33005b == languageConfig.f33005b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f33004a.hashCode() * 31) + this.f33005b;
    }

    public String toString() {
        Language language = this.f33004a;
        int i8 = this.f33005b;
        return "LanguageConfig(language=" + language + ", drawableResId=" + i8 + ")";
    }
}
