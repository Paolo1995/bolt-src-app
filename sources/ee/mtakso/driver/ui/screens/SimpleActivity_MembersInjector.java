package ee.mtakso.driver.ui.screens;

import androidx.fragment.app.FragmentFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import ee.mtakso.driver.ui.views.drawer.DebugDrawerInitializer;
import eu.bolt.driver.core.theme.AppThemeManager;

@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class SimpleActivity_MembersInjector implements MembersInjector<SimpleActivity> {
    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.SimpleActivity.appThemeManager")
    public static void a(SimpleActivity simpleActivity, AppThemeManager appThemeManager) {
        simpleActivity.f27008h = appThemeManager;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.SimpleActivity.debugDrawerInitializer")
    public static void b(SimpleActivity simpleActivity, DebugDrawerInitializer debugDrawerInitializer) {
        simpleActivity.f27007g = debugDrawerInitializer;
    }

    @InjectedFieldSignature("ee.mtakso.driver.ui.screens.SimpleActivity.fragmentFactory")
    public static void c(SimpleActivity simpleActivity, FragmentFactory fragmentFactory) {
        simpleActivity.f27006f = fragmentFactory;
    }
}
