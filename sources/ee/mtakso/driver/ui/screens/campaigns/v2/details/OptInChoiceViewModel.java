package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.campaign.OptInChoiceV2;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.core.util.Optional;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptInChoiceViewModel.kt */
/* loaded from: classes3.dex */
public final class OptInChoiceViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CampaignManager f27509f;

    /* renamed from: g  reason: collision with root package name */
    private final CampaignAnalytics f27510g;

    /* renamed from: h  reason: collision with root package name */
    private final OptInCampaignAnalytics f27511h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<OptInChoiceState> f27512i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f27513j;

    @Inject
    public OptInChoiceViewModel(CampaignManager campaignManager, CampaignAnalytics campaignAnalytics, OptInCampaignAnalytics optInCampaignAnalytics) {
        Intrinsics.f(campaignManager, "campaignManager");
        Intrinsics.f(campaignAnalytics, "campaignAnalytics");
        Intrinsics.f(optInCampaignAnalytics, "optInCampaignAnalytics");
        this.f27509f = campaignManager;
        this.f27510g = campaignAnalytics;
        this.f27511h = optInCampaignAnalytics;
        this.f27512i = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void G(long j8, long j9) {
        Disposable disposable = this.f27513j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single l8 = l(SingleExtKt.d(this.f27509f.w(j8, j9)));
        final Function1<Optional<OptInChoiceV2>, Unit> function1 = new Function1<Optional<OptInChoiceV2>, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceViewModel$loadOptInChoice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<OptInChoiceV2> optional) {
                MutableLiveData mutableLiveData;
                OptInChoiceV2 b8 = optional.b();
                if (b8 != null) {
                    mutableLiveData = OptInChoiceViewModel.this.f27512i;
                    mutableLiveData.o(new OptInChoiceState(b8));
                    return;
                }
                BaseViewModel.A(OptInChoiceViewModel.this, new NullPointerException("Opt-in choice not found"), null, 2, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<OptInChoiceV2> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OptInChoiceViewModel.H(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.OptInChoiceViewModel$loadOptInChoice$2
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
                OptInChoiceViewModel optInChoiceViewModel = OptInChoiceViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(optInChoiceViewModel, it, null, 2, null);
            }
        };
        this.f27513j = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.details.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OptInChoiceViewModel.I(Function1.this, obj);
            }
        });
    }

    public final LiveData<OptInChoiceState> J() {
        return this.f27512i;
    }

    public final void K() {
        this.f27510g.e2();
    }

    public final void L(long j8) {
        this.f27511h.K(j8);
    }
}
