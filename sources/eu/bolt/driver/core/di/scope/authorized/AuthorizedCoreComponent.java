package eu.bolt.driver.core.di.scope.authorized;

import eu.bolt.driver.core.language.LanguageManager;
import eu.bolt.driver.core.ui.common.activity.SimpleAuthorisedActivity;
import eu.bolt.driver.core.ui.translation.v2.TranslationHelper;

/* compiled from: AuthorizedCoreComponent.kt */
/* loaded from: classes5.dex */
public interface AuthorizedCoreComponent {
    TranslationHelper H();

    LanguageManager a();

    void v(SimpleAuthorisedActivity simpleAuthorisedActivity);
}
