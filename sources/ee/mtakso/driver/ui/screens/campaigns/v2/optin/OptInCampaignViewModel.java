package ee.mtakso.driver.ui.screens.campaigns.v2.optin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.helper.DateTimeConverter;
import ee.mtakso.driver.network.client.campaign.OptInCampaign;
import ee.mtakso.driver.network.client.campaign.OptInCampaignChoice;
import ee.mtakso.driver.network.client.campaign.OptInGroupV2;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel;
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

/* compiled from: OptInCampaignViewModel.kt */
/* loaded from: classes3.dex */
public final class OptInCampaignViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CampaignManager f27611f;

    /* renamed from: g  reason: collision with root package name */
    private final OptInCampaignAnalytics f27612g;

    /* renamed from: h  reason: collision with root package name */
    private final DateTimeConverter f27613h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f27614i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f27615j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<OptInCampaign> f27616k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<Boolean> f27617l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<Boolean> f27618m;

    /* renamed from: n  reason: collision with root package name */
    private OptInCampaign f27619n;

    /* renamed from: o  reason: collision with root package name */
    private OptInCampaignChoice f27620o;

    @Inject
    public OptInCampaignViewModel(CampaignManager campaignManager, OptInCampaignAnalytics optInCampaignAnalytics, DateTimeConverter dateTimeConverter) {
        Intrinsics.f(campaignManager, "campaignManager");
        Intrinsics.f(optInCampaignAnalytics, "optInCampaignAnalytics");
        Intrinsics.f(dateTimeConverter, "dateTimeConverter");
        this.f27611f = campaignManager;
        this.f27612g = optInCampaignAnalytics;
        this.f27613h = dateTimeConverter;
        this.f27616k = new MutableLiveData<>();
        this.f27617l = new MutableLiveData<>();
        this.f27618m = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void L(final long j8, final OptInCampaignChoice optInChoice) {
        Intrinsics.f(optInChoice, "optInChoice");
        Single d8 = SingleExtKt.d(this.f27611f.q(j8, optInChoice.getId()));
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel$activateOptInChoice$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OptInCampaignViewModel.this.f27618m;
                mutableLiveData.o(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = d8.n(new Consumer() { // from class: y2.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OptInCampaignViewModel.M(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel$activateOptInChoice$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = OptInCampaignViewModel.this.f27618m;
                mutableLiveData.o(Boolean.FALSE);
                mutableLiveData2 = OptInCampaignViewModel.this.f27617l;
                mutableLiveData2.o(bool);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: y2.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OptInCampaignViewModel.N(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel$activateOptInChoice$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MutableLiveData mutableLiveData;
                mutableLiveData = OptInCampaignViewModel.this.f27618m;
                mutableLiveData.o(Boolean.FALSE);
                OptInCampaignViewModel optInCampaignViewModel = OptInCampaignViewModel.this;
                Intrinsics.e(it, "it");
                long j9 = j8;
                OptInCampaignChoice optInCampaignChoice = optInChoice;
                optInCampaignViewModel.z(it, "error activating opt-in group " + j9 + " choice " + optInCampaignChoice);
            }
        };
        this.f27615j = n8.I(consumer, new Consumer() { // from class: y2.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OptInCampaignViewModel.O(Function1.this, obj);
            }
        });
    }

    public final DateTimeConverter P() {
        return this.f27613h;
    }

    public final OptInCampaign Q() {
        return this.f27619n;
    }

    public final OptInCampaignChoice R() {
        return this.f27620o;
    }

    public final void S(long j8) {
        OptInCampaign optInCampaign = this.f27619n;
        if (optInCampaign != null) {
            this.f27616k.o(optInCampaign);
            return;
        }
        Single l8 = l(SingleExtKt.d(this.f27611f.z(j8)));
        final Function1<Optional<OptInGroupV2>, Unit> function1 = new Function1<Optional<OptInGroupV2>, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel$loadOptInGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<OptInGroupV2> optional) {
                MutableLiveData mutableLiveData;
                OptInCampaignViewModel.this.Y(optional.b());
                if (!optional.c()) {
                    mutableLiveData = OptInCampaignViewModel.this.f27616k;
                    mutableLiveData.o(optional.a());
                    return;
                }
                OptInCampaignViewModel.this.z(new NullPointerException("No opt-in campaign with id"), "No opt-in campaign with id");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<OptInGroupV2> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: y2.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OptInCampaignViewModel.T(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.optin.OptInCampaignViewModel$loadOptInGroup$3
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
                OptInCampaignViewModel.this.Y(null);
                OptInCampaignViewModel optInCampaignViewModel = OptInCampaignViewModel.this;
                Intrinsics.e(it, "it");
                optInCampaignViewModel.z(it, "error fetching opt-in campaign");
            }
        };
        this.f27614i = l8.I(consumer, new Consumer() { // from class: y2.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OptInCampaignViewModel.U(Function1.this, obj);
            }
        });
    }

    public final LiveData<Boolean> V() {
        return this.f27617l;
    }

    public final LiveData<Boolean> W() {
        return this.f27618m;
    }

    public final LiveData<OptInCampaign> X() {
        return this.f27616k;
    }

    public final void Y(OptInCampaign optInCampaign) {
        this.f27619n = optInCampaign;
    }

    public final void Z(OptInCampaignChoice optInCampaignChoice) {
        this.f27620o = optInCampaignChoice;
    }

    public final void a0() {
        this.f27612g.p3();
    }

    public final void b0(long j8) {
        this.f27612g.D0(j8);
    }

    public final void c0(long j8) {
        this.f27612g.m(j8);
    }

    public final void d0(long j8) {
        this.f27612g.p0(j8);
    }

    public final void e0(long j8) {
        this.f27612g.g(j8);
    }

    public final void f0(long j8) {
        this.f27612g.f0(j8);
    }

    public final void g0(long j8) {
        this.f27612g.D3(j8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f27614i;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f27615j;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        super.onCleared();
    }
}
