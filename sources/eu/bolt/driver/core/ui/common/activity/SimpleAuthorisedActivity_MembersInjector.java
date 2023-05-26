package eu.bolt.driver.core.ui.common.activity;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import eu.bolt.driver.core.ui.theme.ThemeProvider;
import eu.bolt.driver.core.ui.translation.language.LanguageManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class SimpleAuthorisedActivity_MembersInjector implements MembersInjector<SimpleAuthorisedActivity> {
    @InjectedFieldSignature("eu.bolt.driver.core.ui.common.activity.SimpleAuthorisedActivity.languageManager")
    public static void a(SimpleAuthorisedActivity simpleAuthorisedActivity, LanguageManager languageManager) {
        simpleAuthorisedActivity.f41069o = languageManager;
    }

    @InjectedFieldSignature("eu.bolt.driver.core.ui.common.activity.SimpleAuthorisedActivity.themeProvider")
    public static void b(SimpleAuthorisedActivity simpleAuthorisedActivity, ThemeProvider themeProvider) {
        simpleAuthorisedActivity.f41068n = themeProvider;
    }
}
