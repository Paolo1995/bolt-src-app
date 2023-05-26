package ee.mtakso.driver.ui.screens.sos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.SosSentEvent;
import ee.mtakso.driver.service.analytics.event.facade.OrderFlowAnalytics;
import ee.mtakso.driver.service.modules.incident.IncidentReportingService;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.screens.sos.SosDialogViewModel;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SosDialogViewModel.kt */
/* loaded from: classes5.dex */
public final class SosDialogViewModel extends BaseViewModel {

    /* renamed from: p  reason: collision with root package name */
    public static final Companion f33398p = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final TrueTimeProvider f33399f;

    /* renamed from: g  reason: collision with root package name */
    private final IncidentReportingService f33400g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverProvider f33401h;

    /* renamed from: i  reason: collision with root package name */
    private final OrderFlowAnalytics f33402i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f33403j;

    /* renamed from: k  reason: collision with root package name */
    private Disposable f33404k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f33405l;

    /* renamed from: m  reason: collision with root package name */
    private final MutableLiveData<Integer> f33406m;

    /* renamed from: n  reason: collision with root package name */
    private final MutableLiveData<SosDialogAction> f33407n;

    /* renamed from: o  reason: collision with root package name */
    private final MutableLiveData<String> f33408o;

    /* compiled from: SosDialogViewModel.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SosDialogViewModel.kt */
    /* loaded from: classes5.dex */
    public enum SosDialogAction {
        CLOSE,
        CALL_EMERGENCY,
        SHOW_TOO_MANY_REQUESTS,
        SHOW_ALREADY_IN_PROCESS
    }

    @Inject
    public SosDialogViewModel(TrueTimeProvider trueTimeProvider, IncidentReportingService incidentReportingService, DriverProvider driverProvider, OrderFlowAnalytics orderFlowAnalytics) {
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(incidentReportingService, "incidentReportingService");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(orderFlowAnalytics, "orderFlowAnalytics");
        this.f33399f = trueTimeProvider;
        this.f33400g = incidentReportingService;
        this.f33401h = driverProvider;
        this.f33402i = orderFlowAnalytics;
        this.f33406m = new MutableLiveData<>();
        this.f33407n = new MutableLiveData<>();
        this.f33408o = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(boolean z7) {
        SosDialogAction sosDialogAction;
        MutableLiveData<SosDialogAction> mutableLiveData = this.f33407n;
        if (z7) {
            sosDialogAction = SosDialogAction.CLOSE;
        } else if (!z7) {
            sosDialogAction = SosDialogAction.CALL_EMERGENCY;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        mutableLiveData.o(sosDialogAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q() {
        Integer f8 = this.f33406m.f();
        if (f8 != null && f8.intValue() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void X() {
        Observable fromArray = Observable.fromArray(3, 2, 1, 0);
        final SosDialogViewModel$startCountdown$1 sosDialogViewModel$startCountdown$1 = new Function1<Integer, ObservableSource<? extends Integer>>() { // from class: ee.mtakso.driver.ui.screens.sos.SosDialogViewModel$startCountdown$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends Integer> invoke(Integer it) {
                Intrinsics.f(it, "it");
                return Observable.just(it).delay(1000L, TimeUnit.MILLISECONDS);
            }
        };
        Observable concatMap = fromArray.concatMap(new Function() { // from class: ee.mtakso.driver.ui.screens.sos.f
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource Y;
                Y = SosDialogViewModel.Y(Function1.this, obj);
                return Y;
            }
        });
        Intrinsics.e(concatMap, "fromArray(*arrayOf(3, 2,… TimeUnit.MILLISECONDS) }");
        Observable f8 = ObservableExtKt.f(concatMap);
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: ee.mtakso.driver.ui.screens.sos.SosDialogViewModel$startCountdown$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Integer num) {
                MutableLiveData mutableLiveData;
                mutableLiveData = SosDialogViewModel.this.f33406m;
                mutableLiveData.o(num);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                b(num);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.sos.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SosDialogViewModel.Z(Function1.this, obj);
            }
        };
        final SosDialogViewModel$startCountdown$3 sosDialogViewModel$startCountdown$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.sos.SosDialogViewModel$startCountdown$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable err) {
                Intrinsics.e(err, "err");
                Kalev.e(err, "Failed to start countdown!");
            }
        };
        this.f33403j = f8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.sos.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SosDialogViewModel.a0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource Y(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f33408o.o(this.f33401h.m().s());
        X();
    }

    public final void O() {
        boolean z7;
        long b8 = this.f33399f.b();
        List<SosSentEvent> z8 = this.f33401h.t().z();
        ArrayList arrayList = new ArrayList();
        for (Object obj : z8) {
            if (b8 - ((SosSentEvent) obj).a() < 3600000) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        this.f33401h.t().U(arrayList);
        if (size >= 3) {
            this.f33407n.o(SosDialogAction.SHOW_TOO_MANY_REQUESTS);
        } else if (this.f33400g.w()) {
            this.f33407n.o(SosDialogAction.SHOW_ALREADY_IN_PROCESS);
        } else {
            U();
        }
    }

    public final LiveData<String> R() {
        return this.f33408o;
    }

    public final LiveData<Integer> S() {
        return this.f33406m;
    }

    public final LiveData<SosDialogAction> T() {
        return this.f33407n;
    }

    public final void U() {
        y().o(Boolean.TRUE);
        Single<Boolean> B = this.f33400g.B();
        final SosDialogViewModel$reportIncindent$1 sosDialogViewModel$reportIncindent$1 = new SosDialogViewModel$reportIncindent$1(this);
        Consumer<? super Boolean> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.sos.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SosDialogViewModel.V(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.sos.SosDialogViewModel$reportIncindent$2
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
            public final void invoke2(Throwable err) {
                SosDialogViewModel sosDialogViewModel = SosDialogViewModel.this;
                Intrinsics.e(err, "err");
                BaseViewModel.A(sosDialogViewModel, err, null, 2, null);
                SosDialogViewModel.this.P(false);
            }
        };
        this.f33404k = B.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.sos.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SosDialogViewModel.W(Function1.this, obj);
            }
        });
    }

    public final void b0() {
        Disposable disposable = this.f33403j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Observable observeOn = Observable.just(Boolean.TRUE).delay(500L, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.a()).observeOn(AndroidSchedulers.a());
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.ui.screens.sos.SosDialogViewModel$stopCountdown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                boolean Q;
                MutableLiveData mutableLiveData;
                Q = SosDialogViewModel.this.Q();
                if (!Q) {
                    mutableLiveData = SosDialogViewModel.this.f33407n;
                    mutableLiveData.o(SosDialogViewModel.SosDialogAction.CLOSE);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.sos.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SosDialogViewModel.c0(Function1.this, obj);
            }
        };
        final SosDialogViewModel$stopCountdown$2 sosDialogViewModel$stopCountdown$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.sos.SosDialogViewModel$stopCountdown$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable err) {
                Intrinsics.e(err, "err");
                Kalev.e(err, "Error stopping countdown");
            }
        };
        this.f33405l = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.sos.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SosDialogViewModel.d0(Function1.this, obj);
            }
        });
    }

    public final void e0() {
        this.f33402i.u1();
    }

    public final void f0() {
        this.f33402i.d0();
    }

    public final void g0() {
        this.f33402i.w();
    }

    public final void h0() {
        this.f33402i.W0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.f33403j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f33404k;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.f33405l;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
        super.onCleared();
    }
}
