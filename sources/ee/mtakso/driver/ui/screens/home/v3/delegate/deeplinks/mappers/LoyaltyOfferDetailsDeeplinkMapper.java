package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.service.analytics.event.facade.PartnerOffersAnalytics;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.boltclub.BoltClubOfferDetailsFragment;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoyaltyOfferDetailsDeeplinkMapper.kt */
@Singleton
/* loaded from: classes3.dex */
public final class LoyaltyOfferDetailsDeeplinkMapper {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f29986b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final PartnerOffersAnalytics f29987a;

    /* compiled from: LoyaltyOfferDetailsDeeplinkMapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public LoyaltyOfferDetailsDeeplinkMapper(PartnerOffersAnalytics partnerOffersAnalytics) {
        Intrinsics.f(partnerOffersAnalytics, "partnerOffersAnalytics");
        this.f29987a = partnerOffersAnalytics;
    }

    public RoutingCommand.ActivityClass a(DeeplinkCall.LoyaltyOfferDetails deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        this.f29987a.b("main screen");
        return SimpleActivity.Companion.f(SimpleActivity.f27004l, BoltClubOfferDetailsFragment.class, BoltClubOfferDetailsFragment.Companion.b(BoltClubOfferDetailsFragment.f27134s, deeplink.b(), null, 2, null), false, 0, 12, null);
    }
}
