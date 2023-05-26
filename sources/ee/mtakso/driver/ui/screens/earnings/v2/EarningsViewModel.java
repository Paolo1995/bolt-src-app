package ee.mtakso.driver.ui.screens.earnings.v2;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.earnings.EarningsClient;
import ee.mtakso.driver.network.client.earnings.EarningsReportPeriod;
import ee.mtakso.driver.network.client.earnings.EarningsReportScreenConfig;
import ee.mtakso.driver.network.client.earnings.EarningsScreenType;
import ee.mtakso.driver.network.client.earnings.Interval;
import ee.mtakso.driver.network.client.earnings.PaymentButton;
import ee.mtakso.driver.network.client.earnings.ReportIntervals;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.EarningsAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.EarningsV2Analytics;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.common.generictreeviewstate.GenericViewTreeState;
import ee.mtakso.driver.ui.interactor.income.report.ReportPageData;
import ee.mtakso.driver.ui.interactor.income.report.ReportPageInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayToBoltLinkInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutPayToBoltInfoInteractor;
import ee.mtakso.driver.ui.screens.earnings.v2.helper.ReportPageLiveData;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfo;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayInfoState;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayToBoltInfo;
import ee.mtakso.driver.ui.screens.earnings.v2.pay_to_bolt.PayoutEvent;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import eu.bolt.kalev.fast.FastLog;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsViewModel.kt */
/* loaded from: classes3.dex */
public final class EarningsViewModel extends BaseViewModel {
    private Disposable A;
    private int B;
    private final Map<String, ReportPageLiveData<ReportPageData>> C;

    /* renamed from: f  reason: collision with root package name */
    private final EarningsInteractor f28519f;

    /* renamed from: g  reason: collision with root package name */
    private final PayToBoltLinkInteractor f28520g;

    /* renamed from: h  reason: collision with root package name */
    private final PayoutPayToBoltInfoInteractor f28521h;

    /* renamed from: i  reason: collision with root package name */
    private final EarningsAnalytics f28522i;

    /* renamed from: j  reason: collision with root package name */
    private final EarningsV2Analytics f28523j;

    /* renamed from: k  reason: collision with root package name */
    private final PayoutAnalytics f28524k;

    /* renamed from: l  reason: collision with root package name */
    private final EarningsClient f28525l;

    /* renamed from: m  reason: collision with root package name */
    private final DriverSettings f28526m;

    /* renamed from: n  reason: collision with root package name */
    private final ReportPageInteractor f28527n;

    /* renamed from: o  reason: collision with root package name */
    private final DriverFeatures f28528o;

    /* renamed from: p  reason: collision with root package name */
    private Disposable f28529p;

    /* renamed from: q  reason: collision with root package name */
    private Disposable f28530q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f28531r;

    /* renamed from: s  reason: collision with root package name */
    private final MutableLiveData<PayInfoState> f28532s;

    /* renamed from: t  reason: collision with root package name */
    private final LiveEvent<PayoutEvent> f28533t;

    /* renamed from: u  reason: collision with root package name */
    private final MutableLiveData<Optional<PayToBoltInfo>> f28534u;

    /* renamed from: v  reason: collision with root package name */
    private final MutableLiveData<EarningsReportScreenConfig> f28535v;

    /* renamed from: w  reason: collision with root package name */
    private Disposable f28536w;

    /* renamed from: x  reason: collision with root package name */
    private final MutableLiveData<EarningsReportPeriod> f28537x;

    /* renamed from: y  reason: collision with root package name */
    private final MutableLiveData<EarningsScreenType> f28538y;

    /* renamed from: z  reason: collision with root package name */
    private final MutableLiveData<List<Interval>> f28539z;

    @Inject
    public EarningsViewModel(EarningsInteractor earningsInteractor, PayToBoltLinkInteractor payToBoltLinkInteractor, PayoutPayToBoltInfoInteractor payoutPayToBoltInfoInteractor, EarningsAnalytics earningsAnalytics, EarningsV2Analytics earningsV2Analytics, PayoutAnalytics payoutAnalytics, EarningsClient earningsClient, DriverSettings driverSettings, ReportPageInteractor reportPageInteractor, DriverFeatures driverFeatures) {
        Intrinsics.f(earningsInteractor, "earningsInteractor");
        Intrinsics.f(payToBoltLinkInteractor, "payToBoltLinkInteractor");
        Intrinsics.f(payoutPayToBoltInfoInteractor, "payoutPayToBoltInfoInteractor");
        Intrinsics.f(earningsAnalytics, "earningsAnalytics");
        Intrinsics.f(earningsV2Analytics, "earningsV2Analytics");
        Intrinsics.f(payoutAnalytics, "payoutAnalytics");
        Intrinsics.f(earningsClient, "earningsClient");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(reportPageInteractor, "reportPageInteractor");
        Intrinsics.f(driverFeatures, "driverFeatures");
        this.f28519f = earningsInteractor;
        this.f28520g = payToBoltLinkInteractor;
        this.f28521h = payoutPayToBoltInfoInteractor;
        this.f28522i = earningsAnalytics;
        this.f28523j = earningsV2Analytics;
        this.f28524k = payoutAnalytics;
        this.f28525l = earningsClient;
        this.f28526m = driverSettings;
        this.f28527n = reportPageInteractor;
        this.f28528o = driverFeatures;
        this.f28531r = true;
        this.f28532s = new MutableLiveData<>();
        this.f28533t = new LiveEvent<>();
        this.f28534u = new MutableLiveData<>();
        this.f28535v = new MutableLiveData<>();
        this.f28537x = new MutableLiveData<>();
        this.f28538y = new MutableLiveData<>();
        this.f28539z = new MutableLiveData<>();
        this.B = -1;
        this.C = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(boolean z7) {
        MutableLiveData<PayInfoState> mutableLiveData = this.f28532s;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "paymentInfoLiveData.requireValue()");
        mutableLiveData.o(PayInfoState.b((PayInfoState) b8, null, z7, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0() {
        Single d8 = SingleExtKt.d(this.f28525l.b(((EarningsReportPeriod) LiveDataExtKt.b(this.f28537x)).a()));
        final Function1<ReportIntervals, Unit> function1 = new Function1<ReportIntervals, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$updateIntervals$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ReportIntervals reportIntervals) {
                List v02;
                MutableLiveData mutableLiveData;
                FastLog g8 = Kalev.f41674e.g();
                if (g8 != null) {
                    FastLog.DefaultImpls.a(g8, "Got intervals: " + reportIntervals, null, 2, null);
                }
                v02 = CollectionsKt___CollectionsKt.v0(reportIntervals.a(), new Comparator() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$updateIntervals$1$invoke$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t7, T t8) {
                        int a8;
                        a8 = ComparisonsKt__ComparisonsKt.a(Integer.valueOf(((Interval) t7).c()), Integer.valueOf(((Interval) t8).c()));
                        return a8;
                    }
                });
                mutableLiveData = EarningsViewModel.this.f28539z;
                mutableLiveData.o(v02);
                EarningsViewModel earningsViewModel = EarningsViewModel.this;
                int i8 = 0;
                Iterator it = v02.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((Interval) it.next()).d()) {
                            break;
                        }
                        i8++;
                    } else {
                        i8 = -1;
                        break;
                    }
                }
                earningsViewModel.B = i8;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ReportIntervals reportIntervals) {
                b(reportIntervals);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.G0(Function1.this, obj);
            }
        };
        final EarningsViewModel$updateIntervals$2 earningsViewModel$updateIntervals$2 = new EarningsViewModel$updateIntervals$2(this);
        this.A = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.H0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String a0(String str, EarningsScreenType earningsScreenType) {
        String internalId = earningsScreenType.getInternalId();
        return internalId + "_" + str;
    }

    private final ReportPageLiveData<ReportPageData> d0(String str, EarningsScreenType earningsScreenType) {
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            String internalId = earningsScreenType.getInternalId();
            FastLog.DefaultImpls.a(g8, "Loading page info: key: " + str + ", mode: " + internalId, null, 2, null);
        }
        ReportPageLiveData<ReportPageData> reportPageLiveData = new ReportPageLiveData<>();
        reportPageLiveData.t(this.f28527n.l(str, earningsScreenType), new EarningsViewModel$loadPage$1$1(this));
        return reportPageLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void r0(EarningsViewModel earningsViewModel, EarningsScreenType earningsScreenType, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = true;
        }
        earningsViewModel.q0(earningsScreenType, z7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void A0(boolean z7) {
        this.f28531r = z7;
        c0();
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        C0();
        Single d8 = SingleExtKt.d(this.f28525l.e());
        final Function1<EarningsReportScreenConfig, Unit> function1 = new Function1<EarningsReportScreenConfig, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningsReportScreenConfig loadedConfig) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                DriverSettings driverSettings;
                FastLog g8 = Kalev.f41674e.g();
                Object obj = null;
                if (g8 != null) {
                    FastLog.DefaultImpls.a(g8, "Got config: " + loadedConfig, null, 2, null);
                }
                mutableLiveData = EarningsViewModel.this.f28535v;
                Intrinsics.e(loadedConfig, "loadedConfig");
                List<EarningsScreenType> d9 = loadedConfig.d();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = d9.iterator();
                while (true) {
                    boolean z7 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((EarningsScreenType) next) == EarningsScreenType.FULL) {
                        z7 = false;
                    }
                    if (z7) {
                        arrayList.add(next);
                    }
                }
                mutableLiveData.o(EarningsReportScreenConfig.b(loadedConfig, null, arrayList, 1, null));
                List<EarningsReportPeriod> c8 = loadedConfig.c();
                EarningsViewModel earningsViewModel = EarningsViewModel.this;
                Iterator<T> it2 = c8.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    String a8 = ((EarningsReportPeriod) next2).a();
                    driverSettings = earningsViewModel.f28526m;
                    if (Intrinsics.a(a8, driverSettings.h().a())) {
                        obj = next2;
                        break;
                    }
                }
                EarningsReportPeriod earningsReportPeriod = (EarningsReportPeriod) obj;
                if (earningsReportPeriod == null) {
                    mutableLiveData3 = EarningsViewModel.this.f28537x;
                    for (Object obj2 : loadedConfig.c()) {
                        if (((EarningsReportPeriod) obj2).c()) {
                            mutableLiveData3.o(obj2);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                mutableLiveData2 = EarningsViewModel.this.f28537x;
                mutableLiveData2.o(earningsReportPeriod);
                EarningsViewModel.this.F0();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningsReportScreenConfig earningsReportScreenConfig) {
                b(earningsReportScreenConfig);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.s0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$onStart$2
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
                EarningsViewModel earningsViewModel = EarningsViewModel.this;
                Intrinsics.e(it, "it");
                earningsViewModel.z(it, "Failed to load income report config");
            }
        };
        this.f28536w = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.t0(Function1.this, obj);
            }
        });
    }

    public final void C0() {
        this.f28522i.f();
    }

    public final void D0() {
        this.f28524k.H();
    }

    public final void E0() {
        this.f28524k.b4();
    }

    public final LiveData<EarningsReportScreenConfig> Y() {
        return this.f28535v;
    }

    public final LiveData<EarningsReportPeriod> Z() {
        return this.f28537x;
    }

    public final LiveData<List<Interval>> b0() {
        return this.f28539z;
    }

    public final void c0() {
        if (this.f28528o.F()) {
            i0();
        } else {
            f0();
        }
    }

    public final LiveData<ReportPageData> e0(String key, EarningsScreenType mode) {
        Intrinsics.f(key, "key");
        Intrinsics.f(mode, "mode");
        String a02 = a0(key, mode);
        FastLog g8 = Kalev.f41674e.g();
        if (g8 != null) {
            FastLog.DefaultImpls.a(g8, "Getting page info: " + a02, null, 2, null);
        }
        Map<String, ReportPageLiveData<ReportPageData>> map = this.C;
        ReportPageLiveData<ReportPageData> reportPageLiveData = map.get(a02);
        if (reportPageLiveData == null) {
            reportPageLiveData = d0(key, mode);
            map.put(a02, reportPageLiveData);
        }
        return reportPageLiveData;
    }

    public final void f0() {
        Single d8 = SingleExtKt.d(this.f28519f.c(this.f28538y.f()));
        final Function1<Optional<PayToBoltInfo>, Unit> function1 = new Function1<Optional<PayToBoltInfo>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$loadPayToBoltInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<PayToBoltInfo> optional) {
                MutableLiveData mutableLiveData;
                mutableLiveData = EarningsViewModel.this.f28534u;
                mutableLiveData.o(optional);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<PayToBoltInfo> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.g0(Function1.this, obj);
            }
        };
        final EarningsViewModel$loadPayToBoltInfo$2 earningsViewModel$loadPayToBoltInfo$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$loadPayToBoltInfo$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to get payToBolt information!");
            }
        };
        this.f28529p = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.h0(Function1.this, obj);
            }
        });
    }

    public final void i0() {
        Single d8 = SingleExtKt.d(this.f28521h.g(this.f28538y.f(), this.f28531r));
        final Function1<Optional<PayInfo>, Unit> function1 = new Function1<Optional<PayInfo>, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$loadPaymentInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<PayInfo> payToBoltInfo) {
                MutableLiveData mutableLiveData;
                PayInfo payInfo;
                MutableLiveData mutableLiveData2;
                PayInfo c8;
                PayoutAnalytics payoutAnalytics;
                Optional<PayInfo> c9;
                mutableLiveData = EarningsViewModel.this.f28532s;
                PayInfoState payInfoState = (PayInfoState) mutableLiveData.f();
                if (payInfoState != null && (c9 = payInfoState.c()) != null) {
                    payInfo = c9.c();
                } else {
                    payInfo = null;
                }
                if (payInfo == null && (c8 = payToBoltInfo.c()) != null) {
                    EarningsViewModel earningsViewModel = EarningsViewModel.this;
                    if (c8.c() && c8.b() == PaymentButton.REQUEST_PAYOUT) {
                        payoutAnalytics = earningsViewModel.f28524k;
                        payoutAnalytics.Q();
                    }
                }
                mutableLiveData2 = EarningsViewModel.this.f28532s;
                Intrinsics.e(payToBoltInfo, "payToBoltInfo");
                mutableLiveData2.o(new PayInfoState(payToBoltInfo, false));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<PayInfo> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.k0(Function1.this, obj);
            }
        };
        final EarningsViewModel$loadPaymentInfo$2 earningsViewModel$loadPaymentInfo$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$loadPaymentInfo$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to get payToBolt information!");
            }
        };
        this.f28529p = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.j0(Function1.this, obj);
            }
        });
    }

    public final LiveData<Optional<PayToBoltInfo>> l0() {
        return this.f28534u;
    }

    public final LiveData<PayInfoState> m0() {
        return this.f28532s;
    }

    public final LiveEvent<PayoutEvent> n0() {
        return this.f28533t;
    }

    public final LiveData<EarningsScreenType> o0() {
        return this.f28538y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28536w;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.A;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f28529p;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
        Disposable disposable4 = this.f28530q;
        if (disposable4 != null) {
            DisposableExtKt.a(disposable4);
        }
    }

    public final void p0(String key, ListModel model) {
        ReportPageData f8;
        GenericViewTreeState b8;
        Intrinsics.f(key, "key");
        Intrinsics.f(model, "model");
        EarningsScreenType screenType = (EarningsScreenType) LiveDataExtKt.b(this.f28538y);
        Intrinsics.e(screenType, "screenType");
        ReportPageLiveData<ReportPageData> reportPageLiveData = this.C.get(a0(key, screenType));
        if (reportPageLiveData != null && (f8 = reportPageLiveData.f()) != null && (b8 = f8.b()) != null) {
            b8.c(model.m());
        }
        if (reportPageLiveData != null) {
            reportPageLiveData.w();
        }
    }

    public final void q0(EarningsScreenType screenType, boolean z7) {
        Intrinsics.f(screenType, "screenType");
        if (z7) {
            if (screenType == EarningsScreenType.BALANCE) {
                this.f28523j.v1();
            } else if (screenType == EarningsScreenType.EARNINGS) {
                this.f28523j.e4();
            }
        }
        this.f28538y.o(screenType);
        c0();
    }

    public final void u0(int i8) {
        String str;
        ReportPageData f8;
        GenericViewTreeState b8;
        Interval interval;
        EarningsScreenType f9 = this.f28538y.f();
        if (f9 == null) {
            return;
        }
        EarningsReportPeriod f10 = this.f28537x.f();
        if (f10 != null) {
            str = f10.a();
        } else {
            str = null;
        }
        if (str != null) {
            this.f28523j.o3(f9.getInternalId(), str);
        }
        int i9 = this.B;
        if (i8 == i9) {
            return;
        }
        if (i9 != -1) {
            List<Interval> f11 = this.f28539z.f();
            String a02 = a0((f11 == null || (interval = f11.get(this.B)) == null || (r1 = interval.a()) == null) ? "" : "", f9);
            ReportPageLiveData<ReportPageData> reportPageLiveData = this.C.get(a02);
            if (reportPageLiveData != null && (f8 = reportPageLiveData.f()) != null && (b8 = f8.b()) != null) {
                b8.a();
            }
            ReportPageLiveData<ReportPageData> reportPageLiveData2 = this.C.get(a02);
            if (reportPageLiveData2 != null) {
                reportPageLiveData2.w();
            }
        }
        this.B = i8;
    }

    public final void v0() {
        String str;
        EarningsScreenType f8 = this.f28538y.f();
        String str2 = null;
        if (f8 != null) {
            str = f8.getInternalId();
        } else {
            str = null;
        }
        EarningsReportPeriod f9 = this.f28537x.f();
        if (f9 != null) {
            str2 = f9.a();
        }
        if (str != null && str2 != null) {
            this.f28523j.H2(str, str2);
        }
    }

    public final void w0() {
        this.f28524k.O2();
        B0(true);
        Single d8 = SingleExtKt.d(this.f28520g.b());
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$requestPayToBoltLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String url) {
                LiveEvent liveEvent;
                EarningsViewModel.this.B0(false);
                liveEvent = EarningsViewModel.this.f28533t;
                Intrinsics.e(url, "url");
                liveEvent.o(new PayoutEvent.PayToBoltLinkReady(url));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.x0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.EarningsViewModel$requestPayToBoltLink$2
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
                EarningsViewModel.this.B0(false);
                EarningsViewModel earningsViewModel = EarningsViewModel.this;
                Intrinsics.e(it, "it");
                earningsViewModel.z(it, "Failed to get payToBolt Link information!");
            }
        };
        this.f28530q = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsViewModel.y0(Function1.this, obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z0(String periodId) {
        List<EarningsReportPeriod> c8;
        String internalId;
        Intrinsics.f(periodId, "periodId");
        EarningsScreenType f8 = this.f28538y.f();
        if (f8 != null && (internalId = f8.getInternalId()) != null) {
            this.f28523j.z3(internalId, periodId);
        }
        this.f28526m.h().b(periodId);
        MutableLiveData<EarningsReportPeriod> mutableLiveData = this.f28537x;
        EarningsReportScreenConfig f9 = this.f28535v.f();
        EarningsReportPeriod earningsReportPeriod = null;
        if (f9 != null && (c8 = f9.c()) != null) {
            Iterator<T> it = c8.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.a(((EarningsReportPeriod) next).a(), periodId)) {
                    earningsReportPeriod = next;
                    break;
                }
            }
            earningsReportPeriod = earningsReportPeriod;
        }
        mutableLiveData.o(earningsReportPeriod);
        F0();
    }
}
