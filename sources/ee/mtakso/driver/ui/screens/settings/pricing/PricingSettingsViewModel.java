package ee.mtakso.driver.ui.screens.settings.pricing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.driver.DriverPricingConfiguration;
import ee.mtakso.driver.network.client.driver.DriverPricingConfigurationClient;
import ee.mtakso.driver.network.client.settings.DriverPricingHint;
import ee.mtakso.driver.network.client.settings.DriverPricingSetup;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.analytics.event.facade.DriverPricingAnalytics;
import ee.mtakso.driver.service.settings.DispatchSettingsManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettings;
import ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: PricingSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class PricingSettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverPricingConfigurationClient f33276f;

    /* renamed from: g  reason: collision with root package name */
    private final DispatchSettingsManager f33277g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverProvider f33278h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverPricingAnalytics f33279i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<PricingSettings> f33280j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveEvent<PricingSettingsCloseReason> f33281k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f33282l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f33283m;

    /* compiled from: PricingSettingsViewModel.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33284a;

        static {
            int[] iArr = new int[DriverPricingState.values().length];
            try {
                iArr[DriverPricingState.CUSTOM_PRICING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverPricingState.STANDARD_PRICING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f33284a = iArr;
        }
    }

    @Inject
    public PricingSettingsViewModel(DriverPricingConfigurationClient driverPricingConfigurationClient, DispatchSettingsManager dispatchSettingsManager, DriverProvider driverProvider, DriverPricingAnalytics analytics) {
        List k8;
        List k9;
        Intrinsics.f(driverPricingConfigurationClient, "driverPricingConfigurationClient");
        Intrinsics.f(dispatchSettingsManager, "dispatchSettingsManager");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(analytics, "analytics");
        this.f33276f = driverPricingConfigurationClient;
        this.f33277g = dispatchSettingsManager;
        this.f33278h = driverProvider;
        this.f33279i = analytics;
        k8 = CollectionsKt__CollectionsKt.k();
        k9 = CollectionsKt__CollectionsKt.k();
        this.f33280j = new MutableLiveData<>(new PricingSettings(null, k8, null, null, -1, k9));
        this.f33281k = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(PricingSettingsViewModel this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f33281k.o(PricingSettingsCloseReason.UPDATED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Disposable disposable = this.f33282l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single l8 = l(SingleExtKt.d(this.f33276f.b()));
        final Function1<DriverPricingConfiguration, Unit> function1 = new Function1<DriverPricingConfiguration, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverPricingConfiguration driverPricingConfiguration) {
                MutableLiveData mutableLiveData;
                int c8;
                IntRange o8;
                int v7;
                MutableLiveData mutableLiveData2;
                DriverPricingHint d8;
                String str;
                DriverPricingSetup b8 = driverPricingConfiguration.b();
                mutableLiveData = PricingSettingsViewModel.this.f33280j;
                PricingSettings pricingSettings = (PricingSettings) LiveDataExtKt.b(mutableLiveData);
                BigDecimal c9 = b8.d().c();
                BigDecimal b9 = b8.d().b();
                BigDecimal d9 = b8.d().d();
                BigDecimal add = d9.add(b9);
                Intrinsics.e(add, "this.add(other)");
                BigDecimal subtract = add.subtract(c9);
                Intrinsics.e(subtract, "this.subtract(other)");
                int intValue = subtract.divide(d9).intValue();
                c8 = PricingSettingsViewModelKt.c(b8);
                o8 = RangesKt___RangesKt.o(0, intValue);
                v7 = CollectionsKt__IterablesKt.v(o8, 10);
                ArrayList arrayList = new ArrayList(v7);
                Iterator<Integer> it = o8.iterator();
                while (it.hasNext()) {
                    BigDecimal multiply = d9.multiply(new BigDecimal(((IntIterator) it).nextInt()));
                    Intrinsics.e(multiply, "step.multiply(BigDecimal(i))");
                    BigDecimal add2 = multiply.add(c9);
                    Intrinsics.e(add2, "this.add(other)");
                    BigDecimal value = c9.max(b9.min(add2));
                    Intrinsics.e(value, "value");
                    d8 = PricingSettingsViewModelKt.d(b8, value);
                    if (d8 != null) {
                        str = d8.b();
                    } else {
                        str = null;
                    }
                    arrayList.add(new PricingSettings.Rate(value, str));
                }
                DriverPricingState g8 = pricingSettings.g();
                if (g8 == null) {
                    g8 = b8.b();
                }
                mutableLiveData2 = PricingSettingsViewModel.this.f33280j;
                mutableLiveData2.o(pricingSettings.a(new Text.Value(driverPricingConfiguration.c()), driverPricingConfiguration.a(), b8, g8, c8, arrayList));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverPricingConfiguration driverPricingConfiguration) {
                b(driverPricingConfiguration);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: d5.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PricingSettingsViewModel.S(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModel$onStart$2
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
            public final void invoke2(Throwable throwable) {
                LiveEvent liveEvent;
                Intrinsics.e(throwable, "throwable");
                if (ApiExceptionUtils.m(throwable, 400, 999)) {
                    liveEvent = PricingSettingsViewModel.this.f33281k;
                    liveEvent.o(PricingSettingsCloseReason.UNAVAILABLE);
                    return;
                }
                BaseViewModel.A(PricingSettingsViewModel.this, throwable, null, 2, null);
            }
        };
        this.f33282l = l8.I(consumer, new Consumer() { // from class: d5.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PricingSettingsViewModel.T(Function1.this, obj);
            }
        });
    }

    public final LiveData<PricingSettingsCloseReason> J() {
        return this.f33281k;
    }

    public final LiveData<PricingSettings> K() {
        return this.f33280j;
    }

    public final void L() {
        PricingSettings state;
        DriverPricingState g8;
        BigDecimal bigDecimal;
        if (!DisposableExtKt.b(this.f33283m) || (g8 = (state = (PricingSettings) LiveDataExtKt.b(this.f33280j)).g()) == null) {
            return;
        }
        if (WhenMappings.f33284a[g8.ordinal()] == 1) {
            Intrinsics.e(state, "state");
            bigDecimal = PricingSettingsKt.b(state);
        } else {
            bigDecimal = null;
        }
        DriverSettings v7 = this.f33278h.v();
        if (g8 == DriverPricingState.STANDARD_PRICING && !v7.K()) {
            v7.k0(true);
        }
        Disposable disposable = this.f33283m;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Completable j8 = j(this.f33277g.J(state.g(), bigDecimal));
        Action action = new Action() { // from class: d5.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                PricingSettingsViewModel.M(PricingSettingsViewModel.this);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.settings.pricing.PricingSettingsViewModel$onConfirm$2
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
                PricingSettingsViewModel pricingSettingsViewModel = PricingSettingsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(pricingSettingsViewModel, it, null, 2, null);
            }
        };
        this.f33283m = j8.G(action, new Consumer() { // from class: d5.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PricingSettingsViewModel.N(Function1.this, obj);
            }
        });
    }

    public final void O() {
        if (Intrinsics.a(y().f(), Boolean.TRUE)) {
            return;
        }
        R(((PricingSettings) LiveDataExtKt.b(this.f33280j)).f() - 1);
    }

    public final void P() {
        if (Intrinsics.a(y().f(), Boolean.TRUE)) {
            return;
        }
        R(((PricingSettings) LiveDataExtKt.b(this.f33280j)).f() + 1);
    }

    public final void Q(DriverPricingState driverPricingState) {
        DriverPricingState driverPricingState2;
        DriverPricingState driverPricingState3;
        if (Intrinsics.a(y().f(), Boolean.TRUE)) {
            return;
        }
        PricingSettings pricingSettings = (PricingSettings) LiveDataExtKt.b(this.f33280j);
        if (pricingSettings.g() == driverPricingState) {
            DriverPricingSetup c8 = pricingSettings.c();
            if (c8 != null) {
                driverPricingState3 = c8.b();
            } else {
                driverPricingState3 = null;
            }
            if (driverPricingState3 == DriverPricingState.NOT_CHOSEN) {
                driverPricingState2 = null;
                MutableLiveData<PricingSettings> mutableLiveData = this.f33280j;
                Object b8 = LiveDataExtKt.b(mutableLiveData);
                Intrinsics.e(b8, "pricingSettingsLiveData.requireValue()");
                mutableLiveData.o(PricingSettings.b((PricingSettings) b8, null, null, null, driverPricingState2, 0, null, 55, null));
            }
        }
        driverPricingState2 = driverPricingState;
        MutableLiveData<PricingSettings> mutableLiveData2 = this.f33280j;
        Object b82 = LiveDataExtKt.b(mutableLiveData2);
        Intrinsics.e(b82, "pricingSettingsLiveData.requireValue()");
        mutableLiveData2.o(PricingSettings.b((PricingSettings) b82, null, null, null, driverPricingState2, 0, null, 55, null));
    }

    public final void R(int i8) {
        if (Intrinsics.a(y().f(), Boolean.TRUE)) {
            return;
        }
        PricingSettings state = (PricingSettings) LiveDataExtKt.b(this.f33280j);
        if (i8 >= 0 && i8 < state.e().size()) {
            MutableLiveData<PricingSettings> mutableLiveData = this.f33280j;
            Intrinsics.e(state, "state");
            mutableLiveData.o(PricingSettings.b(state, null, null, null, null, i8, null, 47, null));
        }
    }

    public final void U() {
        DriverPricingState g8 = ((PricingSettings) LiveDataExtKt.b(this.f33280j)).g();
        if (g8 == null) {
            return;
        }
        int i8 = WhenMappings.f33284a[g8.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                String str = "trackConfirmed unsupported DriverPricingState=" + g8;
                Kalev.e(new IllegalArgumentException(str), str);
                return;
            }
            this.f33279i.T();
            return;
        }
        DriverPricingAnalytics driverPricingAnalytics = this.f33279i;
        Object b8 = LiveDataExtKt.b(this.f33280j);
        Intrinsics.e(b8, "pricingSettingsLiveData.requireValue()");
        driverPricingAnalytics.S(PricingSettingsKt.b((PricingSettings) b8));
    }

    public final void V() {
        BigDecimal bigDecimal;
        DriverPricingAnalytics driverPricingAnalytics = this.f33279i;
        PricingSettings f8 = this.f33280j.f();
        if (f8 != null) {
            bigDecimal = PricingSettingsKt.b(f8);
        } else {
            bigDecimal = null;
        }
        driverPricingAnalytics.k2(bigDecimal);
    }

    public final void W() {
        BigDecimal bigDecimal;
        DriverPricingAnalytics driverPricingAnalytics = this.f33279i;
        PricingSettings f8 = this.f33280j.f();
        if (f8 != null) {
            bigDecimal = PricingSettingsKt.b(f8);
        } else {
            bigDecimal = null;
        }
        driverPricingAnalytics.r2(bigDecimal);
    }

    public final void X() {
        BigDecimal bigDecimal;
        DriverPricingAnalytics driverPricingAnalytics = this.f33279i;
        PricingSettings f8 = this.f33280j.f();
        if (f8 != null) {
            bigDecimal = PricingSettingsKt.b(f8);
        } else {
            bigDecimal = null;
        }
        driverPricingAnalytics.c0(bigDecimal);
    }

    public final void Y() {
        DriverPricingState g8 = ((PricingSettings) LiveDataExtKt.b(this.f33280j)).g();
        if (g8 == null) {
            return;
        }
        int i8 = WhenMappings.f33284a[g8.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                String str = "trackCanceled unsupported DriverPricingState=" + g8;
                Kalev.e(new IllegalArgumentException(str), str);
                return;
            }
            this.f33279i.N3();
            return;
        }
        this.f33279i.s1();
    }

    public final void Z() {
        DriverPricingState g8 = ((PricingSettings) LiveDataExtKt.b(this.f33280j)).g();
        if (g8 == null) {
            return;
        }
        int i8 = WhenMappings.f33284a[g8.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                String str = "trackModalConfirmed unsupported DriverPricingState=" + g8;
                Kalev.e(new IllegalArgumentException(str), str);
                return;
            }
            this.f33279i.n();
            return;
        }
        DriverPricingAnalytics driverPricingAnalytics = this.f33279i;
        Object b8 = LiveDataExtKt.b(this.f33280j);
        Intrinsics.e(b8, "pricingSettingsLiveData.requireValue()");
        driverPricingAnalytics.P1(PricingSettingsKt.b((PricingSettings) b8));
    }

    public final void a0() {
        this.f33279i.h3();
    }

    public final void b0() {
        DriverPricingState g8 = ((PricingSettings) LiveDataExtKt.b(this.f33280j)).g();
        if (g8 == null) {
            return;
        }
        int i8 = WhenMappings.f33284a[g8.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                String str = "trackPriceMethodSelected unsupported DriverPricingState=" + g8;
                Kalev.e(new IllegalArgumentException(str), str);
                return;
            }
            this.f33279i.r3();
            return;
        }
        this.f33279i.R0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f33282l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f33283m;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
