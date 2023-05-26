package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import ee.mtakso.driver.ui.screens.order.scheduled.ScheduledOrdersFragment;
import javax.inject.Inject;

/* compiled from: UpcommingRidesDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class UpcommingRidesDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.UpcomingRides> {
    @Inject
    public UpcommingRidesDeeplinkMapper() {
        super(ScheduledOrdersFragment.class, false, null, null, 12, null);
    }
}
