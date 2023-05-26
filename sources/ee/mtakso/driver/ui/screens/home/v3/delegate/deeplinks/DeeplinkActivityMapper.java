package ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks;

import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.BalanceDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignListDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignOptInDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CampaignRefferralsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.ChatDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.CircleKDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityCancelsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityHoursDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverActivityTripsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverPortalDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverPortalRootDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverPortalWithHashDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.DriverScoreDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.EarningsBreakdownDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.EarningsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.EarningsGoalDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.FallbackWebPageDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.HomeMapSettingsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.IdentityVerificationDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.LoyaltyOfferDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.LoyaltyOffersListDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.NewsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.NewsInboxDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutConfirmationDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutRequirementsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutsDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PayoutsHistoryDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PricingDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.PriorityDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.RejectRideDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.RequestWebUrlDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.RideDetailsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SettingsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.StoryDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SupportDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.SupportTicketDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.UpcommingRideDetialsDeeplinkMapper;
import ee.mtakso.driver.ui.screens.home.v3.delegate.deeplinks.mappers.UpcommingRidesDeeplinkMapper;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeeplinkActivityMapper.kt */
/* loaded from: classes3.dex */
public final class DeeplinkActivityMapper {
    private final PayoutsHistoryDeeplinkMapper A;
    private final PayoutRequirementsDeeplinkMapper B;
    private final PayoutConfirmationDeeplinkMapper C;
    private final NewsInboxDeeplinkMapper D;
    private final NewsDeeplinkMapper E;
    private final DriverPortalDeeplinkMapper F;
    private final DriverPortalWithHashDeeplinkMapper G;
    private final DriverPortalRootDeeplinkMapper H;
    private final LoyaltyOffersListDeeplinkMapper I;
    private final LoyaltyOfferDetailsDeeplinkMapper J;
    private final FallbackWebPageDeeplinkMapper K;
    private final RequestWebUrlDeeplinkMapper L;
    private final HomeMapSettingsDeeplinkMapper M;
    private final StoryDeeplinkMapper N;

    /* renamed from: a  reason: collision with root package name */
    private final SupportDeeplinkMapper f29929a;

    /* renamed from: b  reason: collision with root package name */
    private final SupportTicketDeeplinkMapper f29930b;

    /* renamed from: c  reason: collision with root package name */
    private final SettingsDeeplinkMapper f29931c;

    /* renamed from: d  reason: collision with root package name */
    private final PriorityDeeplinkMapper f29932d;

    /* renamed from: e  reason: collision with root package name */
    private final BalanceDeeplinkMapper f29933e;

    /* renamed from: f  reason: collision with root package name */
    private final RideDetailsDeeplinkMapper f29934f;

    /* renamed from: g  reason: collision with root package name */
    private final RejectRideDeeplinkMapper f29935g;

    /* renamed from: h  reason: collision with root package name */
    private final IdentityVerificationDetailsDeeplinkMapper f29936h;

    /* renamed from: i  reason: collision with root package name */
    private final UpcommingRideDetialsDeeplinkMapper f29937i;

    /* renamed from: j  reason: collision with root package name */
    private final UpcommingRidesDeeplinkMapper f29938j;

    /* renamed from: k  reason: collision with root package name */
    private final ChatDeeplinkMapper f29939k;

    /* renamed from: l  reason: collision with root package name */
    private final DriverScoreDeeplinkMapper f29940l;

    /* renamed from: m  reason: collision with root package name */
    private final PricingDeeplinkMapper f29941m;

    /* renamed from: n  reason: collision with root package name */
    private final CircleKDeeplinkMapper f29942n;

    /* renamed from: o  reason: collision with root package name */
    private final DriverActivityDeeplinkMapper f29943o;

    /* renamed from: p  reason: collision with root package name */
    private final DriverActivityHoursDeeplinkMapper f29944p;

    /* renamed from: q  reason: collision with root package name */
    private final DriverActivityTripsDeeplinkMapper f29945q;

    /* renamed from: r  reason: collision with root package name */
    private final DriverActivityCancelsDeeplinkMapper f29946r;

    /* renamed from: s  reason: collision with root package name */
    private final EarningsDeeplinkMapper f29947s;

    /* renamed from: t  reason: collision with root package name */
    private final EarningsBreakdownDeeplinkMapper f29948t;

    /* renamed from: u  reason: collision with root package name */
    private final EarningsGoalDeeplinkMapper f29949u;

    /* renamed from: v  reason: collision with root package name */
    private final CampaignListDeeplinkMapper f29950v;

    /* renamed from: w  reason: collision with root package name */
    private final CampaignDetailsDeeplinkMapper f29951w;

    /* renamed from: x  reason: collision with root package name */
    private final CampaignOptInDeeplinkMapper f29952x;

    /* renamed from: y  reason: collision with root package name */
    private final CampaignRefferralsDeeplinkMapper f29953y;

    /* renamed from: z  reason: collision with root package name */
    private final PayoutsDetailsDeeplinkMapper f29954z;

    @Inject
    public DeeplinkActivityMapper(SupportDeeplinkMapper supportDeeplinkMapper, SupportTicketDeeplinkMapper supportTicketDeeplinkMapper, SettingsDeeplinkMapper settingsDeeplinkMapper, PriorityDeeplinkMapper priorityDeeplinkMapper, BalanceDeeplinkMapper balanceDeeplinkMapper, RideDetailsDeeplinkMapper rideDetailsDeeplinkMapper, RejectRideDeeplinkMapper rejectRideDeeplinkMapper, IdentityVerificationDetailsDeeplinkMapper identityVerificationDetailsDeeplinkMapper, UpcommingRideDetialsDeeplinkMapper upcommingRideDetialsDeeplinkMapper, UpcommingRidesDeeplinkMapper upcommingRidesDeeplinkMapper, ChatDeeplinkMapper chatDeeplinkMapper, DriverScoreDeeplinkMapper driverScoreDeeplinkMapper, PricingDeeplinkMapper pricingDeeplinkMapper, CircleKDeeplinkMapper circleKDeeplinkMapper, DriverActivityDeeplinkMapper driverActivityDeeplinkMapper, DriverActivityHoursDeeplinkMapper driverActivityHoursDeeplinkMapper, DriverActivityTripsDeeplinkMapper driverActivityTripsDeeplinkMapper, DriverActivityCancelsDeeplinkMapper driverActivityCancelsDeeplinkMapper, EarningsDeeplinkMapper earningsDeeplinkMapper, EarningsBreakdownDeeplinkMapper earningsBreakdownDeeplinkMapper, EarningsGoalDeeplinkMapper earningsGoalDeeplinkMapper, CampaignListDeeplinkMapper campaignListDeeplinkMapper, CampaignDetailsDeeplinkMapper campaignDetailsDeeplinkMapper, CampaignOptInDeeplinkMapper campaignOptInDeeplinkMapper, CampaignRefferralsDeeplinkMapper campaignRefferralsDeeplinkMapper, PayoutsDetailsDeeplinkMapper payoutsDetailsDeeplinkMapper, PayoutsHistoryDeeplinkMapper payoutsHistoryDeeplinkMapper, PayoutRequirementsDeeplinkMapper payoutRequirementsDeeplinkMapper, PayoutConfirmationDeeplinkMapper payoutConfirmationDeeplinkMapper, NewsInboxDeeplinkMapper newsInboxDeeplinkMapper, NewsDeeplinkMapper newsDeeplinkMapper, DriverPortalDeeplinkMapper driverPortalDeeplinkMapper, DriverPortalWithHashDeeplinkMapper driverPortalWithHashDeeplinkMapper, DriverPortalRootDeeplinkMapper driverPortalRootDeeplinkMapper, LoyaltyOffersListDeeplinkMapper loyaltyOffersListDeeplinkMapper, LoyaltyOfferDetailsDeeplinkMapper loyaltyOfferDetailsDeeplinkMapper, FallbackWebPageDeeplinkMapper fallbackWebPageDeeplinkMapper, RequestWebUrlDeeplinkMapper requestWebUrlDeeplinkMapper, HomeMapSettingsDeeplinkMapper homeMapSettings, StoryDeeplinkMapper storyDeeplinkMapper) {
        Intrinsics.f(supportDeeplinkMapper, "supportDeeplinkMapper");
        Intrinsics.f(supportTicketDeeplinkMapper, "supportTicketDeeplinkMapper");
        Intrinsics.f(settingsDeeplinkMapper, "settingsDeeplinkMapper");
        Intrinsics.f(priorityDeeplinkMapper, "priorityDeeplinkMapper");
        Intrinsics.f(balanceDeeplinkMapper, "balanceDeeplinkMapper");
        Intrinsics.f(rideDetailsDeeplinkMapper, "rideDetailsDeeplinkMapper");
        Intrinsics.f(rejectRideDeeplinkMapper, "rejectRideDeeplinkMapper");
        Intrinsics.f(identityVerificationDetailsDeeplinkMapper, "identityVerificationDetailsDeeplinkMapper");
        Intrinsics.f(upcommingRideDetialsDeeplinkMapper, "upcommingRideDetialsDeeplinkMapper");
        Intrinsics.f(upcommingRidesDeeplinkMapper, "upcommingRidesDeeplinkMapper");
        Intrinsics.f(chatDeeplinkMapper, "chatDeeplinkMapper");
        Intrinsics.f(driverScoreDeeplinkMapper, "driverScoreDeeplinkMapper");
        Intrinsics.f(pricingDeeplinkMapper, "pricingDeeplinkMapper");
        Intrinsics.f(circleKDeeplinkMapper, "circleKDeeplinkMapper");
        Intrinsics.f(driverActivityDeeplinkMapper, "driverActivityDeeplinkMapper");
        Intrinsics.f(driverActivityHoursDeeplinkMapper, "driverActivityHoursDeeplinkMapper");
        Intrinsics.f(driverActivityTripsDeeplinkMapper, "driverActivityTripsDeeplinkMapper");
        Intrinsics.f(driverActivityCancelsDeeplinkMapper, "driverActivityCancelsDeeplinkMapper");
        Intrinsics.f(earningsDeeplinkMapper, "earningsDeeplinkMapper");
        Intrinsics.f(earningsBreakdownDeeplinkMapper, "earningsBreakdownDeeplinkMapper");
        Intrinsics.f(earningsGoalDeeplinkMapper, "earningsGoalDeeplinkMapper");
        Intrinsics.f(campaignListDeeplinkMapper, "campaignListDeeplinkMapper");
        Intrinsics.f(campaignDetailsDeeplinkMapper, "campaignDetailsDeeplinkMapper");
        Intrinsics.f(campaignOptInDeeplinkMapper, "campaignOptInDeeplinkMapper");
        Intrinsics.f(campaignRefferralsDeeplinkMapper, "campaignRefferralsDeeplinkMapper");
        Intrinsics.f(payoutsDetailsDeeplinkMapper, "payoutsDetailsDeeplinkMapper");
        Intrinsics.f(payoutsHistoryDeeplinkMapper, "payoutsHistoryDeeplinkMapper");
        Intrinsics.f(payoutRequirementsDeeplinkMapper, "payoutRequirementsDeeplinkMapper");
        Intrinsics.f(payoutConfirmationDeeplinkMapper, "payoutConfirmationDeeplinkMapper");
        Intrinsics.f(newsInboxDeeplinkMapper, "newsInboxDeeplinkMapper");
        Intrinsics.f(newsDeeplinkMapper, "newsDeeplinkMapper");
        Intrinsics.f(driverPortalDeeplinkMapper, "driverPortalDeeplinkMapper");
        Intrinsics.f(driverPortalWithHashDeeplinkMapper, "driverPortalWithHashDeeplinkMapper");
        Intrinsics.f(driverPortalRootDeeplinkMapper, "driverPortalRootDeeplinkMapper");
        Intrinsics.f(loyaltyOffersListDeeplinkMapper, "loyaltyOffersListDeeplinkMapper");
        Intrinsics.f(loyaltyOfferDetailsDeeplinkMapper, "loyaltyOfferDetailsDeeplinkMapper");
        Intrinsics.f(fallbackWebPageDeeplinkMapper, "fallbackWebPageDeeplinkMapper");
        Intrinsics.f(requestWebUrlDeeplinkMapper, "requestWebUrlDeeplinkMapper");
        Intrinsics.f(homeMapSettings, "homeMapSettings");
        Intrinsics.f(storyDeeplinkMapper, "storyDeeplinkMapper");
        this.f29929a = supportDeeplinkMapper;
        this.f29930b = supportTicketDeeplinkMapper;
        this.f29931c = settingsDeeplinkMapper;
        this.f29932d = priorityDeeplinkMapper;
        this.f29933e = balanceDeeplinkMapper;
        this.f29934f = rideDetailsDeeplinkMapper;
        this.f29935g = rejectRideDeeplinkMapper;
        this.f29936h = identityVerificationDetailsDeeplinkMapper;
        this.f29937i = upcommingRideDetialsDeeplinkMapper;
        this.f29938j = upcommingRidesDeeplinkMapper;
        this.f29939k = chatDeeplinkMapper;
        this.f29940l = driverScoreDeeplinkMapper;
        this.f29941m = pricingDeeplinkMapper;
        this.f29942n = circleKDeeplinkMapper;
        this.f29943o = driverActivityDeeplinkMapper;
        this.f29944p = driverActivityHoursDeeplinkMapper;
        this.f29945q = driverActivityTripsDeeplinkMapper;
        this.f29946r = driverActivityCancelsDeeplinkMapper;
        this.f29947s = earningsDeeplinkMapper;
        this.f29948t = earningsBreakdownDeeplinkMapper;
        this.f29949u = earningsGoalDeeplinkMapper;
        this.f29950v = campaignListDeeplinkMapper;
        this.f29951w = campaignDetailsDeeplinkMapper;
        this.f29952x = campaignOptInDeeplinkMapper;
        this.f29953y = campaignRefferralsDeeplinkMapper;
        this.f29954z = payoutsDetailsDeeplinkMapper;
        this.A = payoutsHistoryDeeplinkMapper;
        this.B = payoutRequirementsDeeplinkMapper;
        this.C = payoutConfirmationDeeplinkMapper;
        this.D = newsInboxDeeplinkMapper;
        this.E = newsDeeplinkMapper;
        this.F = driverPortalDeeplinkMapper;
        this.G = driverPortalWithHashDeeplinkMapper;
        this.H = driverPortalRootDeeplinkMapper;
        this.I = loyaltyOffersListDeeplinkMapper;
        this.J = loyaltyOfferDetailsDeeplinkMapper;
        this.K = fallbackWebPageDeeplinkMapper;
        this.L = requestWebUrlDeeplinkMapper;
        this.M = homeMapSettings;
        this.N = storyDeeplinkMapper;
    }

    public final RoutingCommand a(DeeplinkCall deeplink) {
        Intrinsics.f(deeplink, "deeplink");
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.c(g8, "Mapping pending deep link...", null, 2, null);
        }
        if (deeplink instanceof DeeplinkCall.Support) {
            return this.f29929a.a((DeeplinkCall.Support) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.SupportTicket) {
            return this.f29930b.a((DeeplinkCall.SupportTicket) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.Settings) {
            return this.f29931c.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.DriverPriority) {
            return this.f29932d.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.Balance) {
            return this.f29933e.a((DeeplinkCall.Balance) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.Chat) {
            return this.f29939k.a((DeeplinkCall.Chat) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.DriverScoreDetails) {
            return this.f29940l.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.DriverPricing) {
            return this.f29941m.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.CircleK) {
            return this.f29942n.a((DeeplinkCall.CircleK) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.IdentityVerification) {
            return this.f29936h.a((DeeplinkCall.IdentityVerification) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.Earnings) {
            return this.f29947s.a((DeeplinkCall.Earnings) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.EarningsBreakdown) {
            return this.f29948t.a((DeeplinkCall.EarningsBreakdown) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.EarningsGoal) {
            return this.f29949u.a((DeeplinkCall.EarningsGoal) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.EarningsGoalKeep) {
            return null;
        }
        if (deeplink instanceof DeeplinkCall.RideDetails) {
            return this.f29934f.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.RideStartDriving) {
            return null;
        }
        if (deeplink instanceof DeeplinkCall.RideReject) {
            return this.f29935g.a((DeeplinkCall.RideReject) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.UpcomingRideDetails) {
            return this.f29937i.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.UpcomingRides) {
            return this.f29938j.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.CampaignList) {
            return this.f29950v.a((DeeplinkCall.CampaignList) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.CampaignDetails) {
            return this.f29951w.a((DeeplinkCall.CampaignDetails) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.CampaignOptIn) {
            return this.f29952x.a((DeeplinkCall.CampaignOptIn) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.CampaignReferrals) {
            return this.f29953y.c((DeeplinkCall.CampaignReferrals) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.PayoutDetails) {
            return this.f29954z.a((DeeplinkCall.PayoutDetails) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.PayoutHistory) {
            return this.A.a((DeeplinkCall.PayoutHistory) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.PayoutRequirements) {
            return this.B.a((DeeplinkCall.PayoutRequirements) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.PayoutConfirmation) {
            return this.C.a((DeeplinkCall.PayoutConfirmation) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.RequestWebUrl) {
            return this.L.a((DeeplinkCall.RequestWebUrl) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.NewsInbox) {
            return this.D.a((DeeplinkCall.NewsInbox) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.News) {
            return this.E.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.LoyaltyOfferList) {
            return this.I.c((DeeplinkCall.LoyaltyOfferList) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.LoyaltyOfferDetails) {
            return this.J.a((DeeplinkCall.LoyaltyOfferDetails) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.Activity) {
            return this.f29943o.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.ActivityHours) {
            return this.f29944p.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.ActivityTrips) {
            return this.f29945q.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.ActivityCancels) {
            return this.f29946r.a(deeplink);
        }
        if (deeplink instanceof DeeplinkCall.DriverPortal) {
            return this.F.a((DeeplinkCall.DriverPortal) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.DriverPortalWithHash) {
            return this.G.a((DeeplinkCall.DriverPortalWithHash) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.DriverPortalRoot) {
            return this.H.a((DeeplinkCall.DriverPortalRoot) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.Story) {
            return this.N.a((DeeplinkCall.Story) deeplink);
        }
        if ((deeplink instanceof DeeplinkCall.TrainingStart) || (deeplink instanceof DeeplinkCall.MagicLogin) || (deeplink instanceof DeeplinkCall.PartnerSignupRefreshToken) || (deeplink instanceof DeeplinkCall.PartnerConvertLogin) || (deeplink instanceof DeeplinkCall.TrainingShow)) {
            return null;
        }
        if (deeplink instanceof DeeplinkCall.FallbackWebPage) {
            return this.K.a((DeeplinkCall.FallbackWebPage) deeplink);
        }
        if (deeplink instanceof DeeplinkCall.HomeMapSettings) {
            return this.M.a((DeeplinkCall.HomeMapSettings) deeplink);
        }
        throw new NoWhenBranchMatchedException();
    }
}
