package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubListingFragment;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.SimpleDeeplinkMapper;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoyaltyOffersListDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class LoyaltyOffersListDeeplinkMapper extends SimpleDeeplinkMapper<DeeplinkCall.LoyaltyOfferList> {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f29989f = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private final PartnerOffersAnalytics f29990e;

    /* compiled from: LoyaltyOffersListDeeplinkMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public LoyaltyOffersListDeeplinkMapper(PartnerOffersAnalytics partnerOffersAnalytics) {
        super(BoltClubListingFragment.class, true, null, null, 12, null);
        Intrinsics.f(partnerOffersAnalytics, "partnerOffersAnalytics");
        this.f29990e = partnerOffersAnalytics;
    }

    public RoutingCommand.ActivityClass c(DeeplinkCall.LoyaltyOfferList deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        RoutingCommand.ActivityClass a8 = super.a(deeplink);
        this.f29990e.b("main screen");
        return a8;
    }
}
