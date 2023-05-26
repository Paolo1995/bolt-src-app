package ee.mtakso.driver.di.authorised;

import dagger.Module;
import dagger.Provides;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.service.modules.order.v2.DynamicStopDetailsService;
import ee.mtakso.driver.service.modules.order.v2.StaticStopDetailsService;
import ee.mtakso.driver.service.modules.order.v2.StopDetailsService;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorisedServicesModule.kt */
@Module(includes = {AuthorisedServicesBindings.class})
/* loaded from: classes3.dex */
public final class AuthorisedServicesModule {
    @Provides
    public final StopDetailsService a(StaticStopDetailsService staicImpl, DynamicStopDetailsService dynamicImpl, Features features) {
        Intrinsics.f(staicImpl, "staicImpl");
        Intrinsics.f(dynamicImpl, "dynamicImpl");
        Intrinsics.f(features, "features");
        if (features.b(Feature.Type.DYNAMIC_STOP_POLLER)) {
            return dynamicImpl;
        }
        return staicImpl;
    }
}
