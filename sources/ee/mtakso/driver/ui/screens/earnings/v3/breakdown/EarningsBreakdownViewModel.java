package ee.mtakso.driver.ui.screens.earnings.v3.breakdown;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.earnings.network.EarningBreakdownIntervals;
import eu.bolt.driver.earnings.network.EarningBreakdownScreen;
import eu.bolt.driver.earnings.network.EarningsClient;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBreakdownViewModel.kt */
/* loaded from: classes3.dex */
public final class EarningsBreakdownViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsClient f28946f;

    /* renamed from: g  reason: collision with root package name */
    private final EarningsBreakdownMapper f28947g;

    /* renamed from: h  reason: collision with root package name */
    private final EarningsBreakdownStubFactory f28948h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<EarningsBreakdownState> f28949i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f28950j;

    /* renamed from: k  reason: collision with root package name */
    private Disposable f28951k;

    @Inject
    public EarningsBreakdownViewModel(EarningsClient earningsClient, EarningsBreakdownMapper earningsBreakdownMapper, EarningsBreakdownStubFactory earningsBreakdownStubFactory) {
        Intrinsics.f(earningsClient, "earningsClient");
        Intrinsics.f(earningsBreakdownMapper, "earningsBreakdownMapper");
        Intrinsics.f(earningsBreakdownStubFactory, "earningsBreakdownStubFactory");
        this.f28946f = earningsClient;
        this.f28947g = earningsBreakdownMapper;
        this.f28948h = earningsBreakdownStubFactory;
        this.f28949i = new MutableLiveData<>(new EarningsBreakdownState(null, null, 0, 0, null, EarningsBreakdownStubFactory.b(earningsBreakdownStubFactory, null, 1, null), 31, null));
    }

    private final void N(int i8) {
        EarningsBreakdownState state = (EarningsBreakdownState) LiveDataExtKt.b(this.f28949i);
        if (state.d() == i8) {
            return;
        }
        MutableLiveData<EarningsBreakdownState> mutableLiveData = this.f28949i;
        Text.Resource resource = new Text.Resource(R.string.earnings_breakdown, null, 2, null);
        List<ListModel> a8 = this.f28948h.a(state.c());
        Intrinsics.e(state, "state");
        mutableLiveData.o(EarningsBreakdownState.b(state, null, null, 0, i8, resource, a8, 6, null));
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int O(List<EarningBreakdownIntervals.Mode> list) {
        if (!list.isEmpty()) {
            int i8 = 0;
            Iterator<EarningBreakdownIntervals.Mode> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().c()) {
                        break;
                    }
                    i8++;
                } else {
                    i8 = -1;
                    break;
                }
            }
            if (i8 < 0) {
                i8 = CollectionsKt__CollectionsKt.m(list);
            }
            if (i8 >= 0) {
                return i8;
            }
            throw new IllegalArgumentException("Couldn't find default interval mode");
        }
        throw new IllegalArgumentException("Interval modes is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P(List<EarningBreakdownIntervals.Interval> list) {
        if (!list.isEmpty()) {
            int i8 = 0;
            Iterator<EarningBreakdownIntervals.Interval> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().d()) {
                        break;
                    }
                    i8++;
                } else {
                    i8 = -1;
                    break;
                }
            }
            if (i8 < 0) {
                i8 = CollectionsKt__CollectionsKt.m(list);
            }
            if (i8 >= 0) {
                return i8;
            }
            throw new IllegalArgumentException("Couldn't find default period");
        }
        throw new IllegalArgumentException("Periods is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        EarningsBreakdownStateExt earningsBreakdownStateExt = EarningsBreakdownStateExt.f28944a;
        Object b8 = LiveDataExtKt.b(this.f28949i);
        Intrinsics.e(b8, "stateData.requireValue()");
        final EarningBreakdownIntervals.Interval a8 = earningsBreakdownStateExt.a((EarningsBreakdownState) b8);
        if (a8 != null) {
            Disposable disposable = this.f28951k;
            if (disposable != null) {
                DisposableExtKt.a(disposable);
            }
            Single l8 = l(SingleExtKt.d(this.f28946f.c(a8.b(), a8.a())));
            final Function1<EarningBreakdownScreen, Unit> function1 = new Function1<EarningBreakdownScreen, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownViewModel$loadBreakdown$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(EarningBreakdownScreen screen) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    EarningsBreakdownMapper earningsBreakdownMapper;
                    mutableLiveData = EarningsBreakdownViewModel.this.f28949i;
                    EarningsBreakdownState state = (EarningsBreakdownState) LiveDataExtKt.b(mutableLiveData);
                    EarningsBreakdownStateExt earningsBreakdownStateExt2 = EarningsBreakdownStateExt.f28944a;
                    Intrinsics.e(state, "state");
                    if (Intrinsics.a(earningsBreakdownStateExt2.a(state), a8)) {
                        mutableLiveData2 = EarningsBreakdownViewModel.this.f28949i;
                        Text.Value value = new Text.Value(screen.d());
                        earningsBreakdownMapper = EarningsBreakdownViewModel.this.f28947g;
                        Intrinsics.e(screen, "screen");
                        mutableLiveData2.o(EarningsBreakdownState.b(state, screen, null, 0, 0, value, earningsBreakdownMapper.a(screen), 14, null));
                        return;
                    }
                    Kalev.m(new IllegalStateException("Interval changed"), "Interval changed");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EarningBreakdownScreen earningBreakdownScreen) {
                    b(earningBreakdownScreen);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    EarningsBreakdownViewModel.R(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownViewModel$loadBreakdown$2
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
                    EarningsBreakdownViewModel earningsBreakdownViewModel = EarningsBreakdownViewModel.this;
                    Intrinsics.e(it, "it");
                    BaseViewModel.A(earningsBreakdownViewModel, it, null, 2, null);
                }
            };
            this.f28951k = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    EarningsBreakdownViewModel.S(Function1.this, obj);
                }
            });
            return;
        }
        throw new IllegalStateException("Period isn't selected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void T() {
        Disposable disposable = this.f28950j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single l8 = l(SingleExtKt.d(this.f28946f.b()));
        final Function1<EarningBreakdownIntervals, Unit> function1 = new Function1<EarningBreakdownIntervals, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownViewModel$loadIntervals$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(EarningBreakdownIntervals earningBreakdownIntervals) {
                int O;
                int P;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                List<EarningBreakdownIntervals.Mode> a8 = earningBreakdownIntervals.a();
                O = EarningsBreakdownViewModel.this.O(a8);
                P = EarningsBreakdownViewModel.this.P(a8.get(O).a());
                mutableLiveData = EarningsBreakdownViewModel.this.f28949i;
                mutableLiveData2 = EarningsBreakdownViewModel.this.f28949i;
                Object b8 = LiveDataExtKt.b(mutableLiveData2);
                Intrinsics.e(b8, "stateData.requireValue()");
                mutableLiveData.o(EarningsBreakdownState.b((EarningsBreakdownState) b8, null, earningBreakdownIntervals, O, P, new Text.Resource(R.string.earnings_breakdown, null, 2, null), null, 33, null));
                EarningsBreakdownViewModel.this.Q();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EarningBreakdownIntervals earningBreakdownIntervals) {
                b(earningBreakdownIntervals);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsBreakdownViewModel.U(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.EarningsBreakdownViewModel$loadIntervals$2
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
                EarningsBreakdownViewModel earningsBreakdownViewModel = EarningsBreakdownViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(earningsBreakdownViewModel, it, null, 2, null);
            }
        };
        this.f28950j = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.breakdown.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsBreakdownViewModel.V(Function1.this, obj);
            }
        });
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
        T();
    }

    public final void M(int i8) {
        EarningsBreakdownState state = (EarningsBreakdownState) LiveDataExtKt.b(this.f28949i);
        if (state.g() == i8) {
            return;
        }
        EarningBreakdownIntervals e8 = state.e();
        if (e8 != null) {
            int P = P(e8.a().get(i8).a());
            MutableLiveData<EarningsBreakdownState> mutableLiveData = this.f28949i;
            Text.Resource resource = new Text.Resource(R.string.earnings_breakdown, null, 2, null);
            List<ListModel> a8 = this.f28948h.a(state.c());
            Intrinsics.e(state, "state");
            mutableLiveData.o(EarningsBreakdownState.b(state, null, null, i8, P, resource, a8, 2, null));
            Q();
            return;
        }
        throw new IllegalStateException("Intervals isn't loaded");
    }

    public final void W() {
        EarningsBreakdownState state = (EarningsBreakdownState) LiveDataExtKt.b(this.f28949i);
        EarningsBreakdownStateExt earningsBreakdownStateExt = EarningsBreakdownStateExt.f28944a;
        Intrinsics.e(state, "state");
        if (earningsBreakdownStateExt.c(state)) {
            N(state.d() + 1);
        }
    }

    public final LiveData<EarningsBreakdownState> X() {
        return this.f28949i;
    }

    public final void Y() {
        EarningsBreakdownState state = (EarningsBreakdownState) LiveDataExtKt.b(this.f28949i);
        EarningsBreakdownStateExt earningsBreakdownStateExt = EarningsBreakdownStateExt.f28944a;
        Intrinsics.e(state, "state");
        if (earningsBreakdownStateExt.d(state)) {
            N(state.d() - 1);
        }
    }

    public final void Z() {
        if (((EarningsBreakdownState) LiveDataExtKt.b(this.f28949i)).e() == null) {
            T();
        } else {
            Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28950j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f28951k;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
