package ee.mtakso.driver.ui.screens.home.v2.subpage.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.driver.DriverActivityData;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.interactor.activity.DriverActivityInteractor;
import ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.driver.core.network.client.driver.DriverAppConfig;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverActivityViewModel.kt */
/* loaded from: classes3.dex */
public final class DriverActivityViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverActivityInteractor f29636f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverProvider f29637g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<Optional<ActivityMode>> f29638h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<RidesMode> f29639i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<DriverActivityData> f29640j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveData<DriverActivityData> f29641k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f29642l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<DriverActivityData> f29643m;

    /* renamed from: n  reason: collision with root package name */
    private final LiveData<DriverActivityData> f29644n;

    /* renamed from: o  reason: collision with root package name */
    private Disposable f29645o;

    /* compiled from: DriverActivityViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29646a;

        static {
            int[] iArr = new int[RidesMode.values().length];
            try {
                iArr[RidesMode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RidesMode.PERCENTAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f29646a = iArr;
        }
    }

    @Inject
    public DriverActivityViewModel(DriverActivityInteractor driverActivityInteractor, DriverProvider driverProvider) {
        Intrinsics.f(driverActivityInteractor, "driverActivityInteractor");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f29636f = driverActivityInteractor;
        this.f29637g = driverProvider;
        this.f29638h = new MutableLiveData<>(L());
        this.f29639i = new MutableLiveData<>(RidesMode.NUMERIC);
        MutableLiveData<DriverActivityData> mutableLiveData = new MutableLiveData<>();
        this.f29640j = mutableLiveData;
        this.f29641k = mutableLiveData;
        MutableLiveData<DriverActivityData> mutableLiveData2 = new MutableLiveData<>();
        this.f29643m = mutableLiveData2;
        this.f29644n = mutableLiveData2;
    }

    private final Optional<ActivityMode> L() {
        DriverAppConfig.Activity b8 = this.f29637g.m().b();
        if (b8 == null) {
            Optional<ActivityMode> f8 = Optional.f(ActivityMode.RIDES);
            Intrinsics.e(f8, "of(ActivityMode.RIDES)");
            return f8;
        } else if (b8.c()) {
            Optional<ActivityMode> f9 = Optional.f(ActivityMode.RIDES);
            Intrinsics.e(f9, "{\n                 Optio…Mode.RIDES)\n            }");
            return f9;
        } else if (b8.b()) {
            Optional<ActivityMode> f10 = Optional.f(ActivityMode.HOURS);
            Intrinsics.e(f10, "{\n                 Optio…Mode.HOURS)\n            }");
            return f10;
        } else if (b8.a()) {
            Optional<ActivityMode> f11 = Optional.f(ActivityMode.CANCELS);
            Intrinsics.e(f11, "{\n                 Optio…de.CANCELS)\n            }");
            return f11;
        } else {
            Optional<ActivityMode> a8 = Optional.a();
            Intrinsics.e(a8, "empty()");
            return a8;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        y().o(Boolean.TRUE);
        Single<DriverActivityData> b8 = this.f29636f.b("week");
        final Function1<DriverActivityData, Unit> function1 = new Function1<DriverActivityData, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverActivityData driverActivityData) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                y7 = DriverActivityViewModel.this.y();
                y7.o(Boolean.FALSE);
                mutableLiveData = DriverActivityViewModel.this.f29640j;
                mutableLiveData.o(driverActivityData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverActivityData driverActivityData) {
                b(driverActivityData);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverActivityData> consumer = new Consumer() { // from class: v3.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverActivityViewModel.U(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel$onStart$2
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
                MutableLiveData y7;
                y7 = DriverActivityViewModel.this.y();
                y7.o(Boolean.FALSE);
                DriverActivityViewModel driverActivityViewModel = DriverActivityViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverActivityViewModel, it, null, 2, null);
            }
        };
        this.f29642l = b8.I(consumer, new Consumer() { // from class: v3.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverActivityViewModel.V(Function1.this, obj);
            }
        });
    }

    public final void K(ActivityMode mode) {
        Intrinsics.f(mode, "mode");
        this.f29638h.o(Optional.f(mode));
    }

    public final DriverProvider M() {
        return this.f29637g;
    }

    public final LiveData<DriverActivityData> N() {
        return this.f29644n;
    }

    public final MutableLiveData<RidesMode> O() {
        return this.f29639i;
    }

    public final MutableLiveData<Optional<ActivityMode>> P() {
        return this.f29638h;
    }

    public final LiveData<DriverActivityData> Q() {
        return this.f29641k;
    }

    public final void R() {
        y().o(Boolean.TRUE);
        Single<DriverActivityData> b8 = this.f29636f.b("all");
        final Function1<DriverActivityData, Unit> function1 = new Function1<DriverActivityData, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel$loadMonthlyData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverActivityData driverActivityData) {
                MutableLiveData y7;
                MutableLiveData mutableLiveData;
                y7 = DriverActivityViewModel.this.y();
                y7.o(Boolean.FALSE);
                mutableLiveData = DriverActivityViewModel.this.f29643m;
                mutableLiveData.o(driverActivityData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverActivityData driverActivityData) {
                b(driverActivityData);
                return Unit.f50853a;
            }
        };
        Consumer<? super DriverActivityData> consumer = new Consumer() { // from class: v3.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverActivityViewModel.S(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.home.v2.subpage.activity.DriverActivityViewModel$loadMonthlyData$2
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
                MutableLiveData y7;
                y7 = DriverActivityViewModel.this.y();
                y7.o(Boolean.FALSE);
                DriverActivityViewModel driverActivityViewModel = DriverActivityViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(driverActivityViewModel, it, null, 2, null);
            }
        };
        this.f29645o = b8.I(consumer, new Consumer() { // from class: v3.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverActivityViewModel.T(Function1.this, obj);
            }
        });
    }

    public final void W() {
        int i8;
        RidesMode ridesMode;
        MutableLiveData<RidesMode> mutableLiveData = this.f29639i;
        RidesMode ridesMode2 = (RidesMode) LiveDataExtKt.b(mutableLiveData);
        if (ridesMode2 == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f29646a[ridesMode2.ordinal()];
        }
        if (i8 != 1) {
            if (i8 == 2) {
                ridesMode = RidesMode.NUMERIC;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            ridesMode = RidesMode.PERCENTAGE;
        }
        mutableLiveData.o(ridesMode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f29642l;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f29645o;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
