package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import android.os.Bundle;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrderDetailsFragment;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcommingRideDetialsDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class UpcommingRideDetialsDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.UpcomingRideDetails> {
    @Inject
    public UpcommingRideDetialsDeeplinkMapper() {
        super(ScheduledOrderDetailsFragment.class, false, null, new Function1<DeeplinkCall.UpcomingRideDetails, Bundle>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.UpcommingRideDetialsDeeplinkMapper.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Bundle invoke(DeeplinkCall.UpcomingRideDetails it) {
                Intrinsics.f(it, "it");
                return ScheduledOrderDetailsFragment.f31679y.a(it.b());
            }
        }, 6, null);
    }
}
