package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import androidx.lifecycle.LiveData;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.InviteCampaignV2Summary;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.SingleLiveData;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReferralCampaignDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class ReferralCampaignDetailsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CampaignClient f27528f;

    /* renamed from: g  reason: collision with root package name */
    private final ReferralCampaignsAnalytics f27529g;

    /* renamed from: h  reason: collision with root package name */
    private final ReferralCampaignMapper f27530h;

    /* renamed from: i  reason: collision with root package name */
    private final SingleLiveData<ReferralCampaignState> f27531i;

    @Inject
    public ReferralCampaignDetailsViewModel(CampaignClient campaignClient, ReferralCampaignsAnalytics referralCampaignsAnalytics, ReferralCampaignMapper referralCampaignMapper) {
        Intrinsics.f(campaignClient, "campaignClient");
        Intrinsics.f(referralCampaignsAnalytics, "referralCampaignsAnalytics");
        Intrinsics.f(referralCampaignMapper, "referralCampaignMapper");
        this.f27528f = campaignClient;
        this.f27529g = referralCampaignsAnalytics;
        this.f27530h = referralCampaignMapper;
        this.f27531i = new SingleLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReferralCampaignState G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ReferralCampaignState) tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        SingleLiveData<ReferralCampaignState> singleLiveData = this.f27531i;
        Single<InviteCampaignV2Summary> r7 = this.f27528f.r();
        final Function1<InviteCampaignV2Summary, ReferralCampaignState> function1 = new Function1<InviteCampaignV2Summary, ReferralCampaignState>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ReferralCampaignState invoke(InviteCampaignV2Summary it) {
                ReferralCampaignMapper referralCampaignMapper;
                Intrinsics.f(it, "it");
                referralCampaignMapper = ReferralCampaignDetailsViewModel.this.f27530h;
                return referralCampaignMapper.d(it);
            }
        };
        Single<R> x7 = r7.x(new Function() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ReferralCampaignState G;
                G = ReferralCampaignDetailsViewModel.G(Function1.this, obj);
                return G;
            }
        });
        Intrinsics.e(x7, "override fun onStart() {…r(it)\n            }\n    }");
        singleLiveData.t(l(SingleExtKt.d(x7)), new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.ReferralCampaignDetailsViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.f(it, "it");
                BaseViewModel.A(ReferralCampaignDetailsViewModel.this, it, null, 2, null);
            }
        });
    }

    public final LiveData<ReferralCampaignState> F() {
        return this.f27531i;
    }

    public final void H() {
        this.f27529g.t3();
    }

    public final void I() {
        this.f27529g.B1();
    }

    public final void J() {
        this.f27529g.g2();
    }

    public final void K() {
        this.f27529g.N();
    }

    public final void L(long j8) {
        this.f27529g.L2(j8);
    }

    public final void M() {
        this.f27529g.Z1();
    }

    public final void N() {
        this.f27529g.s0();
    }
}
