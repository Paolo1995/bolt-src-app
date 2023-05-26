package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import ee.mtakso.driver.ui.screens.priority.DriverPriorityFragment;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: PriorityDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class PriorityDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.DriverPriority> {
    @Inject
    public PriorityDeeplinkMapper() {
        super(DriverPriorityFragment.class, false, null, null, 12, null);
    }
}
