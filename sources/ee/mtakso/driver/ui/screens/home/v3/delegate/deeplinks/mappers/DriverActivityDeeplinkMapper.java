package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityFragment;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: DriverActivityDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DriverActivityDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.Activity> {
    @Inject
    public DriverActivityDeeplinkMapper() {
        super(DriverActivityFragment.class, true, null, null, 12, null);
    }
}
