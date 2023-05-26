package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfig;
import ee.mtakso.driver.ui.screens.earnings.v3.common.DriverNormalImageMapper;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpense;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.driver.core.util.SingleExtKt;
import eu.bolt.driver.earnings.network.DriverImage;
import eu.bolt.driver.earnings.network.EarningsGoal;
import eu.bolt.driver.earnings.network.EarningsGoalExpenseCategory;
import eu.bolt.driver.earnings.network.GetEarningsGoalResponse;
import eu.bolt.driver.earnings.network.SetEarningsGoalRequest;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import j$.util.Spliterator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: EarningsGoalViewModel.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsManager f29210f;

    /* renamed from: g  reason: collision with root package name */
    private final DriverNormalImageMapper f29211g;

    /* renamed from: h  reason: collision with root package name */
    private final EarningsGoalAnalytics f29212h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<EarningsGoalState> f29213i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f29214j;

    /* renamed from: k  reason: collision with root package name */
    private Disposable f29215k;

    @Inject
    public EarningsGoalViewModel(EarningsManager earningsManager, DriverNormalImageMapper normalImageMapper, EarningsGoalAnalytics earningsGoalAnalytics) {
        Intrinsics.f(earningsManager, "earningsManager");
        Intrinsics.f(normalImageMapper, "normalImageMapper");
        Intrinsics.f(earningsGoalAnalytics, "earningsGoalAnalytics");
        this.f29210f = earningsManager;
        this.f29211g = normalImageMapper;
        this.f29212h = earningsGoalAnalytics;
        this.f29213i = new MutableLiveData<>(new EarningsGoalState(null, null, null, null, null, null, null, false, null, null, 1023, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(EarningsGoalViewModel this$0) {
        EarningsGoalState a8;
        Intrinsics.f(this$0, "this$0");
        MutableLiveData<EarningsGoalState> mutableLiveData = this$0.f29213i;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "stateData.requireValue()");
        a8 = r2.a((r22 & 1) != 0 ? r2.f29200a : null, (r22 & 2) != 0 ? r2.f29201b : null, (r22 & 4) != 0 ? r2.f29202c : EarningsGoalActionStatus.SUCCESS, (r22 & 8) != 0 ? r2.f29203d : null, (r22 & 16) != 0 ? r2.f29204e : null, (r22 & 32) != 0 ? r2.f29205f : null, (r22 & 64) != 0 ? r2.f29206g : null, (r22 & 128) != 0 ? r2.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? r2.f29208i : null, (r22 & 512) != 0 ? ((EarningsGoalState) b8).f29209j : null);
        mutableLiveData.o(a8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(EarningsGoalViewModel this$0) {
        EarningsGoalState a8;
        Intrinsics.f(this$0, "this$0");
        MutableLiveData<EarningsGoalState> mutableLiveData = this$0.f29213i;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "stateData.requireValue()");
        a8 = r2.a((r22 & 1) != 0 ? r2.f29200a : null, (r22 & 2) != 0 ? r2.f29201b : EarningsGoalActionStatus.SUCCESS, (r22 & 4) != 0 ? r2.f29202c : null, (r22 & 8) != 0 ? r2.f29203d : null, (r22 & 16) != 0 ? r2.f29204e : null, (r22 & 32) != 0 ? r2.f29205f : null, (r22 & 64) != 0 ? r2.f29206g : null, (r22 & 128) != 0 ? r2.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? r2.f29208i : null, (r22 & 512) != 0 ? ((EarningsGoalState) b8).f29209j : null);
        mutableLiveData.o(a8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        O();
    }

    public final void L() {
        EarningsGoalState a8;
        if (!DisposableExtKt.b(this.f29215k)) {
            Kalev.m(new IllegalStateException("Failed to delete goal, modification is in progress"), "Failed to delete goal, modification is in progress");
            return;
        }
        EarningsGoalState state = (EarningsGoalState) LiveDataExtKt.b(this.f29213i);
        if (!state.e()) {
            Kalev.m(new IllegalStateException("Failed to delete goal, didn't set"), "Failed to delete goal, didn't set");
            return;
        }
        MutableLiveData<EarningsGoalState> mutableLiveData = this.f29213i;
        Intrinsics.e(state, "state");
        a8 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : null, (r22 & 4) != 0 ? state.f29202c : EarningsGoalActionStatus.LOADING, (r22 & 8) != 0 ? state.f29203d : null, (r22 & 16) != 0 ? state.f29204e : null, (r22 & 32) != 0 ? state.f29205f : null, (r22 & 64) != 0 ? state.f29206g : null, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
        mutableLiveData.o(a8);
        Completable j8 = j(this.f29210f.f());
        Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.u
            @Override // io.reactivex.functions.Action
            public final void run() {
                EarningsGoalViewModel.M(EarningsGoalViewModel.this);
            }
        };
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalViewModel$deleteGoal$2
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
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                EarningsGoalState a9;
                EarningsGoalViewModel earningsGoalViewModel = EarningsGoalViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(earningsGoalViewModel, it, null, 2, null);
                mutableLiveData2 = EarningsGoalViewModel.this.f29213i;
                mutableLiveData3 = EarningsGoalViewModel.this.f29213i;
                Object b8 = LiveDataExtKt.b(mutableLiveData3);
                Intrinsics.e(b8, "stateData.requireValue()");
                a9 = r1.a((r22 & 1) != 0 ? r1.f29200a : null, (r22 & 2) != 0 ? r1.f29201b : null, (r22 & 4) != 0 ? r1.f29202c : EarningsGoalActionStatus.ERROR, (r22 & 8) != 0 ? r1.f29203d : null, (r22 & 16) != 0 ? r1.f29204e : null, (r22 & 32) != 0 ? r1.f29205f : null, (r22 & 64) != 0 ? r1.f29206g : null, (r22 & 128) != 0 ? r1.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? r1.f29208i : null, (r22 & 512) != 0 ? ((EarningsGoalState) b8).f29209j : it);
                mutableLiveData2.o(a9);
            }
        };
        this.f29215k = j8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsGoalViewModel.N(Function1.this, obj);
            }
        });
    }

    public final void O() {
        EarningsGoalState a8;
        MutableLiveData<EarningsGoalState> mutableLiveData = this.f29213i;
        Object b8 = LiveDataExtKt.b(mutableLiveData);
        Intrinsics.e(b8, "stateData.requireValue()");
        a8 = r4.a((r22 & 1) != 0 ? r4.f29200a : EarningsGoalActionStatus.LOADING, (r22 & 2) != 0 ? r4.f29201b : null, (r22 & 4) != 0 ? r4.f29202c : null, (r22 & 8) != 0 ? r4.f29203d : null, (r22 & 16) != 0 ? r4.f29204e : null, (r22 & 32) != 0 ? r4.f29205f : null, (r22 & 64) != 0 ? r4.f29206g : null, (r22 & 128) != 0 ? r4.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? r4.f29208i : null, (r22 & 512) != 0 ? ((EarningsGoalState) b8).f29209j : null);
        mutableLiveData.o(a8);
        Disposable disposable = this.f29214j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single a9 = SingleExtKt.a(this.f29210f.h());
        final Function1<GetEarningsGoalResponse, Unit> function1 = new Function1<GetEarningsGoalResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalViewModel$loadGoal$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(GetEarningsGoalResponse getEarningsGoalResponse) {
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                BigDecimal bigDecimal;
                int v7;
                int v8;
                boolean z7;
                boolean z8;
                EarningsGoalState a10;
                Map<String, BigDecimal> map;
                BigDecimal bigDecimal2;
                EarningsGoalExpense.State state;
                Image image;
                DriverNormalImageMapper driverNormalImageMapper;
                Map<String, BigDecimal> a11;
                Text.Resource resource;
                Text.Resource resource2;
                boolean c8;
                String b9;
                mutableLiveData2 = EarningsGoalViewModel.this.f29213i;
                EarningsGoalState state2 = (EarningsGoalState) LiveDataExtKt.b(mutableLiveData2);
                mutableLiveData3 = EarningsGoalViewModel.this.f29213i;
                Intrinsics.e(state2, "state");
                EarningsGoalActionStatus earningsGoalActionStatus = EarningsGoalActionStatus.SUCCESS;
                EarningsGoal d8 = getEarningsGoalResponse.d();
                if (d8 != null) {
                    bigDecimal = d8.c();
                } else {
                    bigDecimal = null;
                }
                List<eu.bolt.driver.earnings.network.EarningsGoalPeriod> e8 = getEarningsGoalResponse.e();
                v7 = CollectionsKt__IterablesKt.v(e8, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (eu.bolt.driver.earnings.network.EarningsGoalPeriod earningsGoalPeriod : e8) {
                    String b10 = earningsGoalPeriod.b();
                    String a12 = earningsGoalPeriod.a();
                    String b11 = earningsGoalPeriod.b();
                    if (Intrinsics.a(b11, "weekly")) {
                        resource = new Text.Resource(R.string.weekly_target, null, 2, null);
                    } else if (Intrinsics.a(b11, "daily")) {
                        resource = new Text.Resource(R.string.daily_target, null, 2, null);
                    } else {
                        resource = new Text.Resource(R.string.target, null, 2, null);
                    }
                    Text.Resource resource3 = resource;
                    String b12 = earningsGoalPeriod.b();
                    if (Intrinsics.a(b12, "weekly")) {
                        resource2 = new Text.Resource(R.string.fill_the_weekly_target_field, null, 2, null);
                    } else if (Intrinsics.a(b12, "daily")) {
                        resource2 = new Text.Resource(R.string.fill_the_daily_target_field, null, 2, null);
                    } else {
                        resource2 = new Text.Resource(R.string.fill_the_target_field, null, 2, null);
                    }
                    EarningsGoal d9 = getEarningsGoalResponse.d();
                    if (d9 != null && (b9 = d9.b()) != null) {
                        c8 = Intrinsics.a(b9, earningsGoalPeriod.b());
                    } else {
                        c8 = earningsGoalPeriod.c();
                    }
                    arrayList.add(new EarningsGoalPeriod(b10, a12, resource3, resource2, c8));
                }
                List<EarningsGoalExpenseCategory> c9 = getEarningsGoalResponse.c();
                EarningsGoalViewModel earningsGoalViewModel = EarningsGoalViewModel.this;
                v8 = CollectionsKt__IterablesKt.v(c9, 10);
                ArrayList arrayList2 = new ArrayList(v8);
                Iterator<T> it = c9.iterator();
                while (true) {
                    z7 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    EarningsGoalExpenseCategory earningsGoalExpenseCategory = (EarningsGoalExpenseCategory) it.next();
                    EarningsGoal d10 = getEarningsGoalResponse.d();
                    if (d10 != null) {
                        map = d10.a();
                    } else {
                        map = null;
                    }
                    if (map != null && !map.isEmpty()) {
                        z7 = false;
                    }
                    EarningsGoal d11 = getEarningsGoalResponse.d();
                    if (d11 != null && (a11 = d11.a()) != null) {
                        bigDecimal2 = a11.get(earningsGoalExpenseCategory.c());
                    } else {
                        bigDecimal2 = null;
                    }
                    if (z7 && Intrinsics.a(earningsGoalExpenseCategory.d(), Boolean.TRUE)) {
                        state = EarningsGoalExpense.State.Default.f29098f;
                    } else if (bigDecimal2 != null) {
                        state = new EarningsGoalExpense.State.Set(bigDecimal2);
                    } else {
                        state = EarningsGoalExpense.State.None.f29099f;
                    }
                    String c10 = earningsGoalExpenseCategory.c();
                    String b13 = earningsGoalExpenseCategory.b();
                    DriverImage.Normal a13 = earningsGoalExpenseCategory.a();
                    if (a13 != null) {
                        driverNormalImageMapper = earningsGoalViewModel.f29211g;
                        image = driverNormalImageMapper.a(a13);
                    } else {
                        image = null;
                    }
                    arrayList2.add(new EarningsGoalExpense(c10, b13, image, state));
                }
                if (getEarningsGoalResponse.d() != null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                String a14 = getEarningsGoalResponse.a();
                if (a14 == null) {
                    a14 = getEarningsGoalResponse.b();
                }
                if (a14 != null) {
                    if (getEarningsGoalResponse.a() == null) {
                        z7 = false;
                    }
                    a10 = state2.a((r22 & 1) != 0 ? state2.f29200a : earningsGoalActionStatus, (r22 & 2) != 0 ? state2.f29201b : null, (r22 & 4) != 0 ? state2.f29202c : null, (r22 & 8) != 0 ? state2.f29203d : bigDecimal, (r22 & 16) != 0 ? state2.f29204e : null, (r22 & 32) != 0 ? state2.f29205f : arrayList, (r22 & 64) != 0 ? state2.f29206g : arrayList2, (r22 & 128) != 0 ? state2.f29207h : z8, (r22 & Spliterator.NONNULL) != 0 ? state2.f29208i : new CurrencyConfig(a14, z7), (r22 & 512) != 0 ? state2.f29209j : null);
                    mutableLiveData3.o(a10);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GetEarningsGoalResponse getEarningsGoalResponse) {
                b(getEarningsGoalResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsGoalViewModel.P(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalViewModel$loadGoal$2
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
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                EarningsGoalState a10;
                EarningsGoalViewModel earningsGoalViewModel = EarningsGoalViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(earningsGoalViewModel, it, null, 2, null);
                mutableLiveData2 = EarningsGoalViewModel.this.f29213i;
                mutableLiveData3 = EarningsGoalViewModel.this.f29213i;
                Object b9 = LiveDataExtKt.b(mutableLiveData3);
                Intrinsics.e(b9, "stateData.requireValue()");
                a10 = r1.a((r22 & 1) != 0 ? r1.f29200a : EarningsGoalActionStatus.ERROR, (r22 & 2) != 0 ? r1.f29201b : null, (r22 & 4) != 0 ? r1.f29202c : null, (r22 & 8) != 0 ? r1.f29203d : null, (r22 & 16) != 0 ? r1.f29204e : null, (r22 & 32) != 0 ? r1.f29205f : null, (r22 & 64) != 0 ? r1.f29206g : null, (r22 & 128) != 0 ? r1.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? r1.f29208i : null, (r22 & 512) != 0 ? ((EarningsGoalState) b9).f29209j : it);
                mutableLiveData2.o(a10);
            }
        };
        this.f29214j = a9.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsGoalViewModel.Q(Function1.this, obj);
            }
        });
    }

    public final LiveData<EarningsGoalState> R() {
        return this.f29213i;
    }

    public final void S(String type) {
        int v7;
        EarningsGoalState a8;
        Intrinsics.f(type, "type");
        EarningsGoalState state = (EarningsGoalState) LiveDataExtKt.b(this.f29213i);
        Intrinsics.e(state, "state");
        if (Intrinsics.a(EarningsGoalStateKt.d(state), type)) {
            return;
        }
        List<EarningsGoalPeriod> h8 = state.h();
        v7 = CollectionsKt__IterablesKt.v(h8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (EarningsGoalPeriod earningsGoalPeriod : h8) {
            arrayList.add(EarningsGoalPeriod.b(earningsGoalPeriod, null, null, null, null, Intrinsics.a(earningsGoalPeriod.f(), type), 15, null));
        }
        MutableLiveData<EarningsGoalState> mutableLiveData = this.f29213i;
        if (Intrinsics.a(type, "daily")) {
            a8 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : null, (r22 & 4) != 0 ? state.f29202c : null, (r22 & 8) != 0 ? state.f29203d : null, (r22 & 16) != 0 ? state.f29204e : null, (r22 & 32) != 0 ? state.f29205f : arrayList, (r22 & 64) != 0 ? state.f29206g : null, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
        } else if (Intrinsics.a(type, "weekly")) {
            a8 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : null, (r22 & 4) != 0 ? state.f29202c : null, (r22 & 8) != 0 ? state.f29203d : null, (r22 & 16) != 0 ? state.f29204e : null, (r22 & 32) != 0 ? state.f29205f : arrayList, (r22 & 64) != 0 ? state.f29206g : null, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
        } else {
            a8 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : null, (r22 & 4) != 0 ? state.f29202c : null, (r22 & 8) != 0 ? state.f29203d : null, (r22 & 16) != 0 ? state.f29204e : null, (r22 & 32) != 0 ? state.f29205f : arrayList, (r22 & 64) != 0 ? state.f29206g : null, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
        }
        mutableLiveData.o(a8);
    }

    public final void T(List<EarningsGoalExpense> expenses) {
        EarningsGoalState a8;
        Intrinsics.f(expenses, "expenses");
        EarningsGoalState state = (EarningsGoalState) LiveDataExtKt.b(this.f29213i);
        MutableLiveData<EarningsGoalState> mutableLiveData = this.f29213i;
        Intrinsics.e(state, "state");
        a8 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : null, (r22 & 4) != 0 ? state.f29202c : null, (r22 & 8) != 0 ? state.f29203d : null, (r22 & 16) != 0 ? state.f29204e : null, (r22 & 32) != 0 ? state.f29205f : null, (r22 & 64) != 0 ? state.f29206g : expenses, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
        mutableLiveData.o(a8);
    }

    public final void U() {
        Text text;
        EarningsGoalState a8;
        EarningsGoalState a9;
        int v7;
        int b8;
        int d8;
        if (!DisposableExtKt.b(this.f29215k)) {
            Kalev.m(new IllegalStateException("Failed to set goal, modification is in progress"), "Failed to set goal, modification is in progress");
            return;
        }
        EarningsGoalState state = (EarningsGoalState) LiveDataExtKt.b(this.f29213i);
        BigDecimal i8 = state.i();
        if (i8 != null && !Intrinsics.a(i8, BigDecimal.ZERO)) {
            Intrinsics.e(state, "state");
            String d9 = EarningsGoalStateKt.d(state);
            if (d9 == null) {
                Kalev.e(new IllegalStateException("Period isn't set"), "Period isn't set");
                return;
            }
            MutableLiveData<EarningsGoalState> mutableLiveData = this.f29213i;
            a9 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : EarningsGoalActionStatus.LOADING, (r22 & 4) != 0 ? state.f29202c : null, (r22 & 8) != 0 ? state.f29203d : null, (r22 & 16) != 0 ? state.f29204e : null, (r22 & 32) != 0 ? state.f29205f : null, (r22 & 64) != 0 ? state.f29206g : null, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
            mutableLiveData.o(a9);
            EarningsManager earningsManager = this.f29210f;
            List<EarningsGoalExpense> a10 = EarningsGoalStateKt.a(state);
            v7 = CollectionsKt__IterablesKt.v(a10, 10);
            b8 = MapsKt__MapsJVMKt.b(v7);
            d8 = RangesKt___RangesKt.d(b8, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(d8);
            for (EarningsGoalExpense earningsGoalExpense : a10) {
                Pair a11 = TuplesKt.a(earningsGoalExpense.f(), EarningsGoalExpenseKt.a(earningsGoalExpense));
                linkedHashMap.put(a11.d(), a11.e());
            }
            Completable j8 = j(earningsManager.m(new SetEarningsGoalRequest(d9, i8, linkedHashMap)));
            Action action = new Action() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.w
                @Override // io.reactivex.functions.Action
                public final void run() {
                    EarningsGoalViewModel.V(EarningsGoalViewModel.this);
                }
            };
            final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalViewModel$setGoal$3
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
                    MutableLiveData mutableLiveData2;
                    MutableLiveData mutableLiveData3;
                    EarningsGoalState a12;
                    EarningsGoalViewModel earningsGoalViewModel = EarningsGoalViewModel.this;
                    Intrinsics.e(it, "it");
                    BaseViewModel.A(earningsGoalViewModel, it, null, 2, null);
                    mutableLiveData2 = EarningsGoalViewModel.this.f29213i;
                    mutableLiveData3 = EarningsGoalViewModel.this.f29213i;
                    Object b9 = LiveDataExtKt.b(mutableLiveData3);
                    Intrinsics.e(b9, "stateData.requireValue()");
                    a12 = r1.a((r22 & 1) != 0 ? r1.f29200a : null, (r22 & 2) != 0 ? r1.f29201b : EarningsGoalActionStatus.ERROR, (r22 & 4) != 0 ? r1.f29202c : null, (r22 & 8) != 0 ? r1.f29203d : null, (r22 & 16) != 0 ? r1.f29204e : null, (r22 & 32) != 0 ? r1.f29205f : null, (r22 & 64) != 0 ? r1.f29206g : null, (r22 & 128) != 0 ? r1.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? r1.f29208i : null, (r22 & 512) != 0 ? ((EarningsGoalState) b9).f29209j : it);
                    mutableLiveData2.o(a12);
                }
            };
            this.f29215k = j8.G(action, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.x
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    EarningsGoalViewModel.W(Function1.this, obj);
                }
            });
            return;
        }
        MutableLiveData<EarningsGoalState> mutableLiveData2 = this.f29213i;
        Intrinsics.e(state, "state");
        EarningsGoalPeriod c8 = EarningsGoalStateKt.c(state);
        if (c8 != null) {
            text = c8.c();
        } else {
            text = null;
        }
        a8 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : null, (r22 & 4) != 0 ? state.f29202c : null, (r22 & 8) != 0 ? state.f29203d : null, (r22 & 16) != 0 ? state.f29204e : text, (r22 & 32) != 0 ? state.f29205f : null, (r22 & 64) != 0 ? state.f29206g : null, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
        mutableLiveData2.o(a8);
    }

    public final void X(BigDecimal bigDecimal) {
        EarningsGoalState a8;
        EarningsGoalState state = (EarningsGoalState) LiveDataExtKt.b(this.f29213i);
        MutableLiveData<EarningsGoalState> mutableLiveData = this.f29213i;
        Intrinsics.e(state, "state");
        a8 = state.a((r22 & 1) != 0 ? state.f29200a : null, (r22 & 2) != 0 ? state.f29201b : null, (r22 & 4) != 0 ? state.f29202c : null, (r22 & 8) != 0 ? state.f29203d : bigDecimal, (r22 & 16) != 0 ? state.f29204e : null, (r22 & 32) != 0 ? state.f29205f : null, (r22 & 64) != 0 ? state.f29206g : null, (r22 & 128) != 0 ? state.f29207h : false, (r22 & Spliterator.NONNULL) != 0 ? state.f29208i : null, (r22 & 512) != 0 ? state.f29209j : null);
        mutableLiveData.o(a8);
    }

    public final void Y(Function1<? super EarningsGoalAnalytics, Unit> track) {
        Intrinsics.f(track, "track");
        track.invoke(this.f29212h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f29214j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.f29215k;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
    }
}
