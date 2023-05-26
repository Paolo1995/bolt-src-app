package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import ee.mtakso.driver.ui.screens.settings.SettingsFragment;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: SettingsDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class SettingsDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.Settings> {
    @Inject
    public SettingsDeeplinkMapper() {
        super(SettingsFragment.class, true, null, null, 12, null);
    }
}
