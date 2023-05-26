package ee.mtakso.driver.ui.screens.campaigns.v2;

import androidx.lifecycle.LiveData;
import ee.mtakso.driver.network.client.campaign.ActiveAndPendingCampaignsV2;
import ee.mtakso.driver.network.client.campaign.CampaignClient;
import ee.mtakso.driver.network.client.campaign.CampaignV2Group;
import ee.mtakso.driver.network.client.campaign.CircleKClient;
import ee.mtakso.driver.network.client.campaign.CircleKLoyaltySignUpMagicLink;
import ee.mtakso.driver.network.client.campaign.OptInGroupSummary;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverReferralCampaignManager;
import ee.mtakso.driver.service.analytics.event.facade.CampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.OptInCampaignAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.service.campaign.CampaignManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.LiveDataNotification;
import ee.mtakso.driver.ui.base.mvvm.lifecycle.ObservableLiveData;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActiveCampaignsViewModel.kt */
/* loaded from: classes3.dex */
public final class ActiveCampaignsViewModel extends BaseViewModel {

    /* renamed from: s  reason: collision with root package name */
    public static final Companion f27232s = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final CircleKClient f27233f;

    /* renamed from: g  reason: collision with root package name */
    private final CampaignClient f27234g;

    /* renamed from: h  reason: collision with root package name */
    private final CampaignManager f27235h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverReferralCampaignManager f27236i;

    /* renamed from: j  reason: collision with root package name */
    private final DriverConfig f27237j;

    /* renamed from: k  reason: collision with root package name */
    private final CampaignAnalytics f27238k;

    /* renamed from: l  reason: collision with root package name */
    private final OptInCampaignAnalytics f27239l;

    /* renamed from: m  reason: collision with root package name */
    private final CampaignFactory f27240m;

    /* renamed from: n  reason: collision with root package name */
    private final FutureCampaignFactory f27241n;

    /* renamed from: o  reason: collision with root package name */
    private final ReferralCampaignsAnalytics f27242o;

    /* renamed from: p  reason: collision with root package name */
    private final ObservableLiveData<List<ListModel>> f27243p;

    /* renamed from: q  reason: collision with root package name */
    private final LiveEvent<LiveDataNotification<String>> f27244q;

    /* renamed from: r  reason: collision with root package name */
    private Disposable f27245r;

    /* compiled from: ActiveCampaignsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ActiveCampaignsViewModel(CircleKClient circleKClient, CampaignClient campaignClient, CampaignManager campaignManager, DriverReferralCampaignManager driverReferralCampaignManager, DriverConfig driver, CampaignAnalytics campaignAnalytics, OptInCampaignAnalytics optInCampaignAnalytics, CampaignFactory campaignFactory, FutureCampaignFactory futureCampaignFactory, ReferralCampaignsAnalytics referralCampaignsAnalytics) {
        Intrinsics.f(circleKClient, "circleKClient");
        Intrinsics.f(campaignClient, "campaignClient");
        Intrinsics.f(campaignManager, "campaignManager");
        Intrinsics.f(driverReferralCampaignManager, "driverReferralCampaignManager");
        Intrinsics.f(driver, "driver");
        Intrinsics.f(campaignAnalytics, "campaignAnalytics");
        Intrinsics.f(optInCampaignAnalytics, "optInCampaignAnalytics");
        Intrinsics.f(campaignFactory, "campaignFactory");
        Intrinsics.f(futureCampaignFactory, "futureCampaignFactory");
        Intrinsics.f(referralCampaignsAnalytics, "referralCampaignsAnalytics");
        this.f27233f = circleKClient;
        this.f27234g = campaignClient;
        this.f27235h = campaignManager;
        this.f27236i = driverReferralCampaignManager;
        this.f27237j = driver;
        this.f27238k = campaignAnalytics;
        this.f27239l = optInCampaignAnalytics;
        this.f27240m = campaignFactory;
        this.f27241n = futureCampaignFactory;
        this.f27242o = referralCampaignsAnalytics;
        this.f27243p = new ObservableLiveData<>();
        this.f27244q = new LiveEvent<>();
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
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b5, code lost:
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.R(r2, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ee.mtakso.driver.uikit.recyclerview.ListModel> P(ee.mtakso.driver.network.client.campaign.ActiveAndPendingCampaignsV2 r46) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel.P(ee.mtakso.driver.network.client.campaign.ActiveAndPendingCampaignsV2):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    private final boolean U(ActiveAndPendingCampaignsV2 activeAndPendingCampaignsV2) {
        boolean z7;
        boolean z8;
        int v7;
        int y02;
        if (activeAndPendingCampaignsV2.b() && this.f27236i.c() != null) {
            return true;
        }
        List<OptInGroupSummary> c8 = activeAndPendingCampaignsV2.c();
        if (c8 != null && !c8.isEmpty()) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            return true;
        }
        List<CampaignV2Group> a8 = activeAndPendingCampaignsV2.a();
        if (a8 != null) {
            v7 = CollectionsKt__IterablesKt.v(a8, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (CampaignV2Group campaignV2Group : a8) {
                arrayList.add(Integer.valueOf(campaignV2Group.c().size()));
            }
            y02 = CollectionsKt___CollectionsKt.y0(arrayList);
            if (y02 == 0) {
                z8 = true;
                if (!z8 && activeAndPendingCampaignsV2.d() == null) {
                    return false;
                }
            }
        }
        z8 = false;
        return !z8 ? true : true;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        ObservableLiveData<List<ListModel>> observableLiveData = this.f27243p;
        Observable<ActiveAndPendingCampaignsV2> R = this.f27234g.i().R();
        final Function1<Observable<Object>, ObservableSource<?>> function1 = new Function1<Observable<Object>, ObservableSource<?>>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<?> invoke(Observable<Object> it) {
                CampaignManager campaignManager;
                Intrinsics.f(it, "it");
                campaignManager = ActiveCampaignsViewModel.this.f27235h;
                return campaignManager.L();
            }
        };
        Observable<ActiveAndPendingCampaignsV2> repeatWhen = R.repeatWhen(new Function() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource S;
                S = ActiveCampaignsViewModel.S(Function1.this, obj);
                return S;
            }
        });
        final Function1<ActiveAndPendingCampaignsV2, List<? extends ListModel>> function12 = new Function1<ActiveAndPendingCampaignsV2, List<? extends ListModel>>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ListModel> invoke(ActiveAndPendingCampaignsV2 it) {
                List<ListModel> P;
                Intrinsics.f(it, "it");
                P = ActiveCampaignsViewModel.this.P(it);
                return P;
            }
        };
        Observable<R> map = repeatWhen.map(new Function() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List T;
                T = ActiveCampaignsViewModel.T(Function1.this, obj);
                return T;
            }
        });
        Intrinsics.e(map, "override fun onStart() {…Error(it)\n        }\n    }");
        ObservableLiveData.t(observableLiveData, k(ObservableExtKt.g(map)), null, new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel$onStart$3
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
                BaseViewModel.A(ActiveCampaignsViewModel.this, it, null, 2, null);
            }
        }, 2, null);
    }

    public final void L() {
        if (!DisposableExtKt.b(this.f27245r)) {
            return;
        }
        Single d8 = SingleExtKt.d(this.f27233f.d());
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel$loadCircleKLoyaltyCampaignMagicLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                LiveEvent liveEvent;
                liveEvent = ActiveCampaignsViewModel.this.f27244q;
                liveEvent.o(LiveDataNotification.f26294d.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Single n8 = d8.n(new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ActiveCampaignsViewModel.M(Function1.this, obj);
            }
        });
        final Function1<CircleKLoyaltySignUpMagicLink, Unit> function12 = new Function1<CircleKLoyaltySignUpMagicLink, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel$loadCircleKLoyaltyCampaignMagicLink$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CircleKLoyaltySignUpMagicLink circleKLoyaltySignUpMagicLink) {
                LiveEvent liveEvent;
                liveEvent = ActiveCampaignsViewModel.this.f27244q;
                liveEvent.o(LiveDataNotification.f26294d.c(circleKLoyaltySignUpMagicLink.a()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CircleKLoyaltySignUpMagicLink circleKLoyaltySignUpMagicLink) {
                b(circleKLoyaltySignUpMagicLink);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ActiveCampaignsViewModel.N(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.ActiveCampaignsViewModel$loadCircleKLoyaltyCampaignMagicLink$3
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
                LiveEvent liveEvent;
                liveEvent = ActiveCampaignsViewModel.this.f27244q;
                LiveDataNotification.Companion companion = LiveDataNotification.f26294d;
                Intrinsics.e(it, "it");
                liveEvent.o(companion.a(it));
            }
        };
        this.f27245r = n8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.campaigns.v2.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ActiveCampaignsViewModel.O(Function1.this, obj);
            }
        });
    }

    public final LiveData<List<ListModel>> Q() {
        return this.f27243p;
    }

    public final LiveData<LiveDataNotification<String>> R() {
        return this.f27244q;
    }

    public final void V() {
        this.f27238k.y2();
    }

    public final void W(long j8) {
        this.f27238k.M1(j8);
    }

    public final void X() {
        this.f27238k.v2();
    }

    public final void Y() {
        this.f27238k.a0();
    }

    public final void Z(long j8) {
        this.f27239l.t1(j8);
    }

    public final void a0(long j8) {
        this.f27239l.W1(j8);
    }

    public final void b0() {
        this.f27238k.c1();
    }

    public final void c0(long j8) {
        this.f27242o.h0(j8);
    }

    public final void d0() {
        Long a8 = this.f27236i.a();
        if (a8 != null) {
            this.f27242o.P(a8.longValue());
        }
    }
}
