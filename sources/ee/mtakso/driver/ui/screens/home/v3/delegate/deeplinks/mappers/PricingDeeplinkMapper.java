package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsFragment;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingDeeplinkMapper.kt */
/* loaded from: classes3.dex */
public final class PricingDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.DriverPricing> {
    @Inject
    public PricingDeeplinkMapper() {
        super(PricingSettingsFragment.class, true, new Function1<DeeplinkCall, Boolean>() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PricingDeeplinkMapper.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(DeeplinkCall it) {
                Intrinsics.f(it, "it");
                return Boolean.TRUE;
            }
        }, null, 8, null);
    }
}
