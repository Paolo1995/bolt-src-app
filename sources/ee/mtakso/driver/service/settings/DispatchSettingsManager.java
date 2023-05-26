package ee.mtakso.driver.service.settings;

import ee.mtakso.driver.network.client.settings.AutoOrderAcceptance;
import ee.mtakso.driver.network.client.settings.DriverPricing;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import ee.mtakso.driver.network.client.settings.SearchCategories;
import ee.mtakso.driver.network.client.settings.SearchCategory;
import ee.mtakso.driver.network.client.settings.SearchCategorySelection;
import ee.mtakso.driver.network.client.settings.SetDriverPricingStateRequest;
import ee.mtakso.driver.network.client.settings.SettingsClient;
import ee.mtakso.driver.network.client.settings.SettingsResponse;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchSettingsManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DispatchSettingsManager {

    /* renamed from: a */
    private final SettingsClient f25940a;

    /* renamed from: b */
    private final DriverProvider f25941b;

    /* renamed from: c */
    private final SettingsAnalytics f25942c;

    /* renamed from: d */
    private final BehaviorSubject<CategorySelectionAutoAcceptanceState> f25943d;

    /* renamed from: e */
    private final PublishSubject<String> f25944e;

    /* renamed from: f */
    private final BehaviorSubject<CategorySelectionSignal> f25945f;

    /* renamed from: g */
    private final BehaviorSubject<Optional<SearchCategories>> f25946g;

    /* renamed from: h */
    private final BehaviorSubject<Optional<DriverPricing>> f25947h;

    /* renamed from: i */
    private final PublishSubject<Boolean> f25948i;

    /* renamed from: j */
    private SearchCategories f25949j;

    /* renamed from: k */
    private AutoOrderAcceptance f25950k;

    /* renamed from: l */
    private DriverPricing f25951l;

    /* renamed from: m */
    private Disposable f25952m;

    /* compiled from: DispatchSettingsManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a */
        public static final /* synthetic */ int[] f25953a;

        static {
            int[] iArr = new int[AutoOrderAcceptance.values().length];
            try {
                iArr[AutoOrderAcceptance.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AutoOrderAcceptance.MANUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25953a = iArr;
        }
    }

    @Inject
    public DispatchSettingsManager(SettingsClient driverApiClient, DriverProvider driverProvider, SettingsAnalytics settingsAnalytics) {
        Intrinsics.f(driverApiClient, "driverApiClient");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(settingsAnalytics, "settingsAnalytics");
        this.f25940a = driverApiClient;
        this.f25941b = driverProvider;
        this.f25942c = settingsAnalytics;
        BehaviorSubject<CategorySelectionAutoAcceptanceState> f8 = BehaviorSubject.f(new CategorySelectionAutoAcceptanceState(CategorySelectionState.DISABLED, AutoAcceptanceState.DISABLED));
        Intrinsics.e(f8, "createDefault(CategorySe…cceptanceState.DISABLED))");
        this.f25943d = f8;
        PublishSubject<String> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<String>()");
        this.f25944e = e8;
        BehaviorSubject<CategorySelectionSignal> e9 = BehaviorSubject.e();
        Intrinsics.e(e9, "create<CategorySelectionSignal>()");
        this.f25945f = e9;
        BehaviorSubject<Optional<SearchCategories>> f9 = BehaviorSubject.f(Optional.a());
        Intrinsics.e(f9, "createDefault(Optional.empty<SearchCategories>())");
        this.f25946g = f9;
        BehaviorSubject<Optional<DriverPricing>> f10 = BehaviorSubject.f(Optional.a());
        Intrinsics.e(f10, "createDefault(Optional.empty<DriverPricing>())");
        this.f25947h = f10;
        PublishSubject<Boolean> e10 = PublishSubject.e();
        Intrinsics.e(e10, "create<Boolean>()");
        this.f25948i = e10;
    }

    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x00a5, code lost:
        if (r1.isEmpty() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0112, code lost:
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void E(ee.mtakso.driver.utils.Optional<ee.mtakso.driver.network.client.settings.SettingsResponse> r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.settings.DispatchSettingsManager.E(ee.mtakso.driver.utils.Optional, boolean, boolean):void");
    }

    public static /* synthetic */ void F(DispatchSettingsManager dispatchSettingsManager, Optional optional, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            z8 = false;
        }
        dispatchSettingsManager.E(optional, z7, z8);
    }

    public final Single<Optional<SettingsResponse>> G() {
        Single d8 = SingleExtKt.d(r());
        final Function1<Optional<SettingsResponse>, Unit> function1 = new Function1<Optional<SettingsResponse>, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$refreshSettings$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<SettingsResponse> it) {
                DispatchSettingsManager dispatchSettingsManager = DispatchSettingsManager.this;
                Intrinsics.e(it, "it");
                DispatchSettingsManager.F(dispatchSettingsManager, it, false, false, 6, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<SettingsResponse> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Single<Optional<SettingsResponse>> o8 = d8.o(new Consumer() { // from class: ee.mtakso.driver.service.settings.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsManager.H(Function1.this, obj);
            }
        });
        Intrinsics.e(o8, "private fun refreshSetti…e(it)\n            }\n    }");
        return o8;
    }

    public static final void H(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I(List<SearchCategory> list) {
        String str;
        DriverSettings y7;
        DriverFeatures e8 = this.f25941b.e();
        boolean z7 = true;
        if (((e8 == null || !e8.O()) ? false : false) && (y7 = this.f25941b.y()) != null) {
            str = y7.u();
        } else {
            str = null;
        }
        if (list == null) {
            this.f25942c.G1(null, str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SearchCategory searchCategory : list) {
            if (searchCategory.e()) {
                arrayList.add(searchCategory.d());
            }
        }
        this.f25942c.G1(arrayList, str);
    }

    public static final SingleSource K(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Single M(DispatchSettingsManager dispatchSettingsManager, List list, AutoOrderAcceptance autoOrderAcceptance, int i8, Object obj) {
        List<SearchCategory> list2 = list;
        if ((i8 & 1) != 0) {
            SearchCategories searchCategories = dispatchSettingsManager.f25949j;
            if (searchCategories != null) {
                list2 = searchCategories.a();
            } else {
                list2 = null;
            }
        }
        if ((i8 & 2) != 0) {
            autoOrderAcceptance = dispatchSettingsManager.f25950k;
        }
        return dispatchSettingsManager.L(list2, autoOrderAcceptance);
    }

    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final String O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    private final CategorySelectionAutoAcceptanceState m(SearchCategories searchCategories, AutoOrderAcceptance autoOrderAcceptance) {
        CategorySelectionState categorySelectionState;
        int i8;
        AutoAcceptanceState autoAcceptanceState;
        if (searchCategories == null) {
            categorySelectionState = CategorySelectionState.DISABLED;
        } else if (this.f25941b.t().j().a() < 3) {
            categorySelectionState = CategorySelectionState.PROMOTED;
        } else {
            categorySelectionState = CategorySelectionState.ENABLED;
        }
        if (autoOrderAcceptance == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f25953a[autoOrderAcceptance.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                autoAcceptanceState = AutoAcceptanceState.DISABLED;
            } else {
                autoAcceptanceState = AutoAcceptanceState.DEACTIVATED;
            }
        } else {
            autoAcceptanceState = AutoAcceptanceState.ACTIVATED;
        }
        return new CategorySelectionAutoAcceptanceState(categorySelectionState, autoAcceptanceState);
    }

    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final Optional s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public static final boolean z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final void A() {
        CategorySelectionState categorySelectionState;
        int a8 = this.f25941b.t().j().a() + 1;
        this.f25941b.t().j().b(a8);
        if (a8 > 3) {
            CategorySelectionAutoAcceptanceState g8 = this.f25943d.g();
            if (g8 != null) {
                categorySelectionState = g8.b();
            } else {
                categorySelectionState = null;
            }
            if (categorySelectionState == CategorySelectionState.PROMOTED) {
                this.f25943d.onNext(m(this.f25949j, this.f25950k));
            }
        }
    }

    public final void B(final String id) {
        Intrinsics.f(id, "id");
        if (this.f25941b.t().x().a() == null) {
            this.f25941b.t().x().b(id);
        } else if (!Intrinsics.a(this.f25941b.t().x().a(), id) && DisposableExtKt.b(this.f25952m)) {
            Single d8 = SingleExtKt.d(r());
            final Function1<Optional<SettingsResponse>, Unit> function1 = new Function1<Optional<SettingsResponse>, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$onRegionChange$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(Optional<SettingsResponse> it) {
                    DriverProvider driverProvider;
                    driverProvider = DispatchSettingsManager.this.f25941b;
                    driverProvider.t().x().b(id);
                    DispatchSettingsManager dispatchSettingsManager = DispatchSettingsManager.this;
                    Intrinsics.e(it, "it");
                    DispatchSettingsManager.F(dispatchSettingsManager, it, true, false, 4, null);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Optional<SettingsResponse> optional) {
                    b(optional);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.settings.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DispatchSettingsManager.C(Function1.this, obj);
                }
            };
            final DispatchSettingsManager$onRegionChange$2 dispatchSettingsManager$onRegionChange$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$onRegionChange$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to load driver car categories after region change detected!");
                }
            };
            this.f25952m = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.settings.i
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    DispatchSettingsManager.D(Function1.this, obj);
                }
            });
        }
    }

    public final Completable J(DriverPricingState state, BigDecimal bigDecimal) {
        Intrinsics.f(state, "state");
        Single d8 = SingleExtKt.d(this.f25940a.q(new SetDriverPricingStateRequest(state, bigDecimal)));
        final DispatchSettingsManager$updateDriverPricing$1 dispatchSettingsManager$updateDriverPricing$1 = new DispatchSettingsManager$updateDriverPricing$1(this);
        Completable v7 = d8.r(new Function() { // from class: ee.mtakso.driver.service.settings.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource K;
                K = DispatchSettingsManager.K(Function1.this, obj);
                return K;
            }
        }).v();
        Intrinsics.e(v7, "fun updateDriverPricing(…   .ignoreElement()\n    }");
        return v7;
    }

    public final Single<String> L(List<SearchCategory> list, AutoOrderAcceptance autoOrderAcceptance) {
        ArrayList arrayList;
        int v7;
        SettingsClient settingsClient = this.f25940a;
        if (list != null) {
            v7 = CollectionsKt__IterablesKt.v(list, 10);
            arrayList = new ArrayList(v7);
            for (SearchCategory searchCategory : list) {
                arrayList.add(new SearchCategorySelection(searchCategory.c(), searchCategory.e()));
            }
        } else {
            arrayList = null;
        }
        Single<Optional<SettingsResponse>> u7 = settingsClient.u(arrayList, autoOrderAcceptance);
        final Function1<Optional<SettingsResponse>, Unit> function1 = new Function1<Optional<SettingsResponse>, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$updateSettings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<SettingsResponse> it) {
                DispatchSettingsManager dispatchSettingsManager = DispatchSettingsManager.this;
                Intrinsics.e(it, "it");
                DispatchSettingsManager.F(dispatchSettingsManager, it, false, false, 6, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<SettingsResponse> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Single<Optional<SettingsResponse>> o8 = u7.o(new Consumer() { // from class: ee.mtakso.driver.service.settings.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DispatchSettingsManager.N(Function1.this, obj);
            }
        });
        final DispatchSettingsManager$updateSettings$3 dispatchSettingsManager$updateSettings$3 = new Function1<Optional<SettingsResponse>, String>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$updateSettings$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(Optional<SettingsResponse> it) {
                String str;
                Intrinsics.f(it, "it");
                SettingsResponse c8 = it.c();
                if (c8 != null) {
                    str = c8.c();
                } else {
                    str = null;
                }
                if (str == null) {
                    return "";
                }
                return str;
            }
        };
        Single x7 = o8.x(new Function() { // from class: ee.mtakso.driver.service.settings.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String O;
                O = DispatchSettingsManager.O(Function1.this, obj);
                return O;
            }
        });
        Intrinsics.e(x7, "fun updateSettings(selec…dStatus.orEmpty() }\n    }");
        return x7;
    }

    public final void n(final boolean z7) {
        if (DisposableExtKt.b(this.f25952m)) {
            if (z7 || (this.f25949j == null && this.f25950k == null)) {
                Single d8 = SingleExtKt.d(r());
                final Function1<Optional<SettingsResponse>, Unit> function1 = new Function1<Optional<SettingsResponse>, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$checkCategorySelectionAvailability$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(Optional<SettingsResponse> it) {
                        DispatchSettingsManager dispatchSettingsManager = DispatchSettingsManager.this;
                        Intrinsics.e(it, "it");
                        DispatchSettingsManager.F(dispatchSettingsManager, it, false, z7, 2, null);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Optional<SettingsResponse> optional) {
                        b(optional);
                        return Unit.f50853a;
                    }
                };
                Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.settings.f
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        DispatchSettingsManager.o(Function1.this, obj);
                    }
                };
                final DispatchSettingsManager$checkCategorySelectionAvailability$2 dispatchSettingsManager$checkCategorySelectionAvailability$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$checkCategorySelectionAvailability$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.f50853a;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable it) {
                        Intrinsics.e(it, "it");
                        Kalev.e(it, "Failed to load driver car categories!");
                    }
                };
                this.f25952m = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.settings.g
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        DispatchSettingsManager.p(Function1.this, obj);
                    }
                });
            }
        }
    }

    public final void q() {
        Disposable disposable = this.f25952m;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f25952m = null;
        this.f25949j = null;
        this.f25950k = null;
        this.f25943d.onNext(new CategorySelectionAutoAcceptanceState(CategorySelectionState.DISABLED, AutoAcceptanceState.DISABLED));
        this.f25944e.onNext("");
        this.f25945f.onNext(new CategorySelectionSignal(false, false));
    }

    public final Single<Optional<SettingsResponse>> r() {
        Single<Optional<SettingsResponse>> n8 = this.f25940a.n();
        final DispatchSettingsManager$loadSearchCategories$1 dispatchSettingsManager$loadSearchCategories$1 = new Function1<Optional<SettingsResponse>, Optional<SettingsResponse>>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$loadSearchCategories$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<SettingsResponse> invoke(Optional<SettingsResponse> response) {
                Intrinsics.f(response, "response");
                return response;
            }
        };
        Single x7 = n8.x(new Function() { // from class: ee.mtakso.driver.service.settings.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional s7;
                s7 = DispatchSettingsManager.s(Function1.this, obj);
                return s7;
            }
        });
        Intrinsics.e(x7, "driverApiClient.getSetti…esponse\n                }");
        return x7;
    }

    public final Observable<Boolean> t() {
        return this.f25948i;
    }

    public final Observable<Optional<SearchCategories>> u() {
        return this.f25946g;
    }

    public final Observable<CategorySelectionAutoAcceptanceState> v() {
        return this.f25943d;
    }

    public final Observable<String> w() {
        return this.f25944e;
    }

    public final Observable<Optional<DriverPricing>> x() {
        return this.f25947h;
    }

    public final Observable<CategorySelectionSignal> y() {
        BehaviorSubject<CategorySelectionSignal> behaviorSubject = this.f25945f;
        final DispatchSettingsManager$observeRequiredSelectionNotification$1 dispatchSettingsManager$observeRequiredSelectionNotification$1 = new Function1<CategorySelectionSignal, Boolean>() { // from class: ee.mtakso.driver.service.settings.DispatchSettingsManager$observeRequiredSelectionNotification$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(CategorySelectionSignal it) {
                boolean z7;
                Intrinsics.f(it, "it");
                if (it.a() && !it.b()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<CategorySelectionSignal> filter = behaviorSubject.filter(new Predicate() { // from class: ee.mtakso.driver.service.settings.e
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean z7;
                z7 = DispatchSettingsManager.z(Function1.this, obj);
                return z7;
            }
        });
        Intrinsics.e(filter, "pendingCategorySelection…ignal && !it.isConsumed }");
        return filter;
    }
}
