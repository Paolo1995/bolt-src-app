package eu.bolt.driver.core.ui.translation.v2;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import eu.bolt.driver.core.language.Language;
import eu.bolt.driver.core.language.LanguageUtils;
import eu.bolt.driver.core.ui.translation.v2.dynamic.DynamicTranslatedContext;
import eu.bolt.driver.core.ui.translation.v2.dynamic.DynamicTranslatedResources;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationHelper.kt */
/* loaded from: classes5.dex */
public final class TranslationHelper {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f41242a;

    public TranslationHelper(boolean z7) {
        this.f41242a = z7;
    }

    public final Context a(Context base, Locale locale) {
        Intrinsics.f(base, "base");
        Intrinsics.f(locale, "locale");
        return DynamicTranslatedContext.f41243b.a(c(base, locale));
    }

    public final Resources b(Resources base) {
        Intrinsics.f(base, "base");
        return new DynamicTranslatedResources(base);
    }

    public final Context c(Context base, Locale locale) {
        Intrinsics.f(base, "base");
        Intrinsics.f(locale, "locale");
        Locale.setDefault(locale);
        Configuration configuration = new Configuration(base.getResources().getConfiguration());
        configuration.setLocale(locale);
        Context createConfigurationContext = base.createConfigurationContext(configuration);
        Intrinsics.e(createConfigurationContext, "base.createConfigurationContext(configuration)");
        return createConfigurationContext;
    }

    public final Context d(Context base, Language language) {
        Intrinsics.f(base, "base");
        Intrinsics.f(language, "language");
        Locale a8 = LanguageUtils.f40820a.a(language);
        if (this.f41242a) {
            return a(base, a8);
        }
        return c(base, a8);
    }

    public final Resources e(Resources base) {
        Intrinsics.f(base, "base");
        if (this.f41242a) {
            return b(base);
        }
        return base;
    }
}
