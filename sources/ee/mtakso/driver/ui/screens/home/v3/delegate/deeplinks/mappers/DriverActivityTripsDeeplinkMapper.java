package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import android.os.Bundle;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.ActivityMode;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverActivityTripsDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DriverActivityTripsDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.ActivityTrips> {
    @Inject
    public DriverActivityTripsDeeplinkMapper() {
        super(DriverActivityFragment.class, true, null, new Function1<DeeplinkCall.ActivityTrips, Bundle>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityTripsDeeplinkMapper.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Bundle invoke(DeeplinkCall.ActivityTrips deepLink) {
                Intrinsics.f(deepLink, "deepLink");
                return DriverActivityFragment.f29623u.a(ActivityMode.RIDES);
            }
        }, 4, null);
    }
}
