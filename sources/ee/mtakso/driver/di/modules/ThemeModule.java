package ee.mtakso.driver.di.modules;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.theme.ThemeHelperImpl;
import eu.bolt.driver.core.theme.ThemeHelper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeModule.kt */
@Module
/* loaded from: classes3.dex */
public final class ThemeModule {
    @Provides
    public final ThemeHelper a(DriverProvider driverProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        return new ThemeHelperImpl(driverProvider);
    }
}
