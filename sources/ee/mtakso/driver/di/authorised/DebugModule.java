package ee.mtakso.driver.di.authorised;

import dagger.Binds;
import dagger.Module;
import ee.mtakso.driver.ui.DebugTweaksMenu;
import ee.mtakso.driver.ui.screens.settings.TweaksMenu;
import ee.mtakso.driver.ui.views.drawer.DebugDrawerInitializer;
import ee.mtakso.driver.ui.views.drawer.DebugDrawerInitializerImpl;

/* compiled from: DebugModule.kt */
@Module
/* loaded from: classes3.dex */
public interface DebugModule {
    @Binds
    DebugDrawerInitializer a(DebugDrawerInitializerImpl debugDrawerInitializerImpl);

    @Binds
    TweaksMenu b(DebugTweaksMenu debugTweaksMenu);
}
