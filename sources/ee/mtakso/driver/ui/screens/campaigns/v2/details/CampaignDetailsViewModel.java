package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CampaignV2Details;
import ee.mtakso.driver.network.client.campaign.DriverCampaignV2;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.util.Optional;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CampaignDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class CampaignDetailsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CampaignClient f27454f;

    /* renamed from: g  reason: collision with root package name */
    private final CampaignAnalytics f27455g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f27456h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<Optional<CampaignDetailsState>> f27457i;

    @Inject
    public CampaignDetailsViewModel(CampaignClient campaignClient, CampaignAnalytics campaignAnalytics) {
        Intrinsics.f(campaignClient, "campaignClient");
        Intrinsics.f(campaignAnalytics, "campaignAnalytics");
        this.f27454f = campaignClient;
        this.f27455g = campaignAnalytics;
        this.f27457i = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional J(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CampaignDetailsState M(CampaignV2Details campaignV2Details) {
        DriverCampaignV2 a8 = campaignV2Details.a();
        if (a8 == null) {
            return null;
        }
        return new CampaignDetailsState(a8);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void I(long j8) {
        Disposable disposable = this.f27456h;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single<CampaignV2Details> o8 = this.f27454f.o(j8);
        final Function1<CampaignV2Details, Optional<CampaignDetailsState>> function1 = new Function1<CampaignV2Details, Optional<CampaignDetailsState>>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsViewModel$loadCampaign$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<CampaignDetailsState> invoke(CampaignV2Details it) {
                CampaignDetailsState M;
                Intrinsics.f(it, "it");
                Optional.Companion companion = Optional.f41306b;
                M = CampaignDetailsViewModel.this.M(it);
                return companion.b(M);
            }
        };
        Single<R> x7 = o8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional J;
                J = CampaignDetailsViewModel.J(Function1.this, obj);
                return J;
            }
        });
        Intrinsics.e(x7, "fun loadCampaign(campaig…it) }\n            )\n    }");
        Single l8 = l(SingleExtKt.d(x7));
        final Function1<Optional<CampaignDetailsState>, Unit> function12 = new Function1<Optional<CampaignDetailsState>, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsViewModel$loadCampaign$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<CampaignDetailsState> optional) {
                MutableLiveData mutableLiveData;
                mutableLiveData = CampaignDetailsViewModel.this.f27457i;
                mutableLiveData.o(optional);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<CampaignDetailsState> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignDetailsViewModel.K(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.CampaignDetailsViewModel$loadCampaign$3
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
                CampaignDetailsViewModel campaignDetailsViewModel = CampaignDetailsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(campaignDetailsViewModel, it, null, 2, null);
            }
        };
        this.f27456h = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CampaignDetailsViewModel.L(Function1.this, obj);
            }
        });
    }

    public final LiveData<Optional<CampaignDetailsState>> N() {
        return this.f27457i;
    }

    public final void O(long j8) {
        this.f27455g.K3(j8);
    }

    public final void P() {
        this.f27455g.e2();
    }
}
