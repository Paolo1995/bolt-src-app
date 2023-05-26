package ee.mtakso.driver.ui.screens;

import androidx.fragment.app.FragmentFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import eu.bolt.driver.core.theme.AppThemeManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class AnonymousSimpleActivity_MembersInjector implements MembersInjector<AnonymousSimpleActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.AnonymousSimpleActivity.appThemeManager")
    public static void a(AnonymousSimpleActivity anonymousSimpleActivity, AppThemeManager appThemeManager) {
        anonymousSimpleActivity.f26997g = appThemeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.AnonymousSimpleActivity.fragmentFactory")
    public static void b(AnonymousSimpleActivity anonymousSimpleActivity, FragmentFactory fragmentFactory) {
        anonymousSimpleActivity.f26996f = fragmentFactory;
    }
}
