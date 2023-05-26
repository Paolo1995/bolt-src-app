package ee.mtakso.driver.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import ee.mtakso.driver.service.pollerv2.DynamicPollingService;
import ee.mtakso.driver.service.pollerv2.FixedPollingService;

/* compiled from: PollerBindings.kt */
@Module
/* loaded from: classes3.dex */
public interface PollerBindings {
    @Binds
    @IntoSet
    DynamicPollingService a(DynamicPollingService dynamicPollingService);

    @Binds
    @IntoSet
    FixedPollingService b(FixedPollingService fixedPollingService);
}
