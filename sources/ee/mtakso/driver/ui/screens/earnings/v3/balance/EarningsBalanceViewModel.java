package ee.mtakso.driver.ui.screens.earnings.v3.balance;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceContent;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceState;
import ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.driver.earnings.network.BalanceHistory;
import eu.bolt.driver.earnings.network.BalanceHistoryTab;
import eu.bolt.driver.earnings.network.BalanceScreen;
import eu.bolt.driver.earnings.network.EarningsBalanceClient;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsBalanceViewModel.kt */
/* loaded from: classes3.dex */
public final class EarningsBalanceViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsBalanceClient f28847f;

    /* renamed from: g  reason: collision with root package name */
    private final EarningsBalanceHeaderMapper f28848g;

    /* renamed from: h  reason: collision with root package name */
    private final EarningsBalanceHistoryMapper f28849h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<State> f28850i;

    /* renamed from: j  reason: collision with root package name */
    private Disposable f28851j;

    @Inject
    public EarningsBalanceViewModel(EarningsBalanceClient earningsBalanceClient, EarningsBalanceHeaderMapper balanceHeaderMapper, EarningsBalanceHistoryMapper balanceHistoryMapper) {
        Intrinsics.f(earningsBalanceClient, "earningsBalanceClient");
        Intrinsics.f(balanceHeaderMapper, "balanceHeaderMapper");
        Intrinsics.f(balanceHistoryMapper, "balanceHistoryMapper");
        this.f28847f = earningsBalanceClient;
        this.f28848g = balanceHeaderMapper;
        this.f28849h = balanceHistoryMapper;
        this.f28850i = new MutableLiveData<>(new State(null, null, null, false, 15, null));
    }

    private final void K() {
        Single l8 = l(SingleExtKt.d(this.f28847f.c()));
        final Function1<BalanceScreen, Unit> function1 = new Function1<BalanceScreen, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel$loadHeader$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(BalanceScreen balanceScreen) {
                EarningsBalanceHeaderMapper earningsBalanceHeaderMapper;
                Text.Value value;
                int v7;
                Object obj;
                String str;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                earningsBalanceHeaderMapper = EarningsBalanceViewModel.this.f28848g;
                EarningsBalanceState.PayoutHeader a8 = earningsBalanceHeaderMapper.a(balanceScreen.b());
                String c8 = balanceScreen.c();
                if (c8 != null) {
                    value = new Text.Value(c8);
                } else {
                    value = null;
                }
                List<BalanceHistoryTab> d8 = balanceScreen.d();
                v7 = CollectionsKt__IterablesKt.v(d8, 10);
                ArrayList arrayList = new ArrayList(v7);
                for (BalanceHistoryTab balanceHistoryTab : d8) {
                    arrayList.add(new EarningsBalanceState.HistorySection(balanceHistoryTab.a(), new Text.Value(balanceHistoryTab.b()), balanceHistoryTab.c()));
                }
                EarningsBalanceState.HistoryHeader historyHeader = new EarningsBalanceState.HistoryHeader(value, arrayList);
                Iterator<T> it = balanceScreen.d().iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((BalanceHistoryTab) obj).c()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                BalanceHistoryTab balanceHistoryTab2 = (BalanceHistoryTab) obj;
                if (balanceHistoryTab2 != null) {
                    str = balanceHistoryTab2.a();
                } else {
                    str = null;
                }
                mutableLiveData = EarningsBalanceViewModel.this.f28850i;
                EarningsBalanceViewModel.State state = (EarningsBalanceViewModel.State) LiveDataExtKt.b(mutableLiveData);
                mutableLiveData2 = EarningsBalanceViewModel.this.f28850i;
                mutableLiveData2.o(state.a(state.f().a(balanceScreen.a(), new EarningsBalanceContent.Success(a8), new EarningsBalanceContent.Success(historyHeader), new EarningsBalanceContent.Loading(null, 1, null)), str, null, false));
                EarningsBalanceViewModel.this.N();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BalanceScreen balanceScreen) {
                b(balanceScreen);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsBalanceViewModel.L(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel$loadHeader$2
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
            public final void invoke2(Throwable error) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                EarningsBalanceViewModel earningsBalanceViewModel = EarningsBalanceViewModel.this;
                Intrinsics.e(error, "error");
                earningsBalanceViewModel.z(error, "Failed to load balance header");
                mutableLiveData = EarningsBalanceViewModel.this.f28850i;
                EarningsBalanceViewModel.State state = (EarningsBalanceViewModel.State) LiveDataExtKt.b(mutableLiveData);
                mutableLiveData2 = EarningsBalanceViewModel.this.f28850i;
                Intrinsics.e(state, "state");
                mutableLiveData2.o(EarningsBalanceViewModel.State.b(state, EarningsBalanceState.b(state.f(), null, new EarningsBalanceContent.Error(error, null, 2, null), new EarningsBalanceContent.Error(error, null, 2, null), new EarningsBalanceContent.Error(error, null, 2, null), 1, null), null, null, false, 14, null));
            }
        };
        Disposable I = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EarningsBalanceViewModel.M(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "private fun loadHeader()…     .autoDispose()\n    }");
        v(I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        K();
    }

    public final void N() {
        State state = (State) LiveDataExtKt.b(this.f28850i);
        EarningsBalanceState.History a8 = state.f().d().a();
        boolean z7 = true;
        if ((a8 == null || !a8.c()) ? false : false) {
            return;
        }
        if (state.e() == null) {
            Kalev.l("Section id is null!");
        } else if (state.c()) {
        } else {
            EarningsBalanceState.History a9 = state.f().d().a();
            if (a9 == null) {
                a9 = new EarningsBalanceState.History(null, false, 3, null);
            }
            final EarningsBalanceState.History history = a9;
            MutableLiveData<State> mutableLiveData = this.f28850i;
            Intrinsics.e(state, "state");
            mutableLiveData.o(State.b(state, EarningsBalanceState.b(state.f(), null, null, null, new EarningsBalanceContent.Loading(history), 7, null), null, null, true, 6, null));
            final State state2 = (State) LiveDataExtKt.b(this.f28850i);
            Disposable disposable = this.f28851j;
            if (disposable != null) {
                DisposableExtKt.a(disposable);
            }
            Single d8 = SingleExtKt.d(this.f28847f.b(state.e(), state.d()));
            final Function1<BalanceHistory, Unit> function1 = new Function1<BalanceHistory, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel$loadNextPage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(BalanceHistory page) {
                    MutableLiveData mutableLiveData2;
                    EarningsBalanceHistoryMapper earningsBalanceHistoryMapper;
                    MutableLiveData mutableLiveData3;
                    List<? extends ListModel> n02;
                    mutableLiveData2 = EarningsBalanceViewModel.this.f28850i;
                    EarningsBalanceViewModel.State currentState = (EarningsBalanceViewModel.State) LiveDataExtKt.b(mutableLiveData2);
                    if (Intrinsics.a(currentState, state2)) {
                        earningsBalanceHistoryMapper = EarningsBalanceViewModel.this.f28849h;
                        Intrinsics.e(page, "page");
                        List<ListModel> a10 = earningsBalanceHistoryMapper.a(page);
                        mutableLiveData3 = EarningsBalanceViewModel.this.f28850i;
                        Intrinsics.e(currentState, "currentState");
                        EarningsBalanceState f8 = currentState.f();
                        EarningsBalanceState.History history2 = history;
                        n02 = CollectionsKt___CollectionsKt.n0(history2.b(), a10);
                        mutableLiveData3.o(EarningsBalanceViewModel.State.b(currentState, EarningsBalanceState.b(f8, null, null, null, new EarningsBalanceContent.Success(history2.a(n02, a10.isEmpty())), 7, null), null, page.a(), false, 2, null));
                        return;
                    }
                    Kalev.l("Unexpected state changes");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BalanceHistory balanceHistory) {
                    b(balanceHistory);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    EarningsBalanceViewModel.O(Function1.this, obj);
                }
            };
            final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel$loadNextPage$2
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
                public final void invoke2(Throwable error) {
                    MutableLiveData mutableLiveData2;
                    MutableLiveData mutableLiveData3;
                    EarningsBalanceViewModel earningsBalanceViewModel = EarningsBalanceViewModel.this;
                    Intrinsics.e(error, "error");
                    earningsBalanceViewModel.z(error, "Failed to load balance history");
                    mutableLiveData2 = EarningsBalanceViewModel.this.f28850i;
                    EarningsBalanceViewModel.State currentState = (EarningsBalanceViewModel.State) LiveDataExtKt.b(mutableLiveData2);
                    if (Intrinsics.a(currentState, state2)) {
                        mutableLiveData3 = EarningsBalanceViewModel.this.f28850i;
                        Intrinsics.e(currentState, "currentState");
                        mutableLiveData3.o(EarningsBalanceViewModel.State.b(currentState, EarningsBalanceState.b(currentState.f(), null, null, null, new EarningsBalanceContent.Error(error, history), 7, null), null, null, false, 6, null));
                        return;
                    }
                    Kalev.l("Unexpected state changes");
                }
            };
            this.f28851j = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.l
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    EarningsBalanceViewModel.P(Function1.this, obj);
                }
            });
        }
    }

    public final LiveData<EarningsBalanceState> Q() {
        LiveData b8 = Transformations.b(this.f28850i, new Function() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.balance.EarningsBalanceViewModel$observeState$$inlined$map$1
            @Override // androidx.arch.core.util.Function
            public final EarningsBalanceState apply(EarningsBalanceViewModel.State state) {
                return state.f();
            }
        });
        Intrinsics.e(b8, "crossinline transform: (…p(this) { transform(it) }");
        LiveData<EarningsBalanceState> a8 = Transformations.a(b8);
        Intrinsics.e(a8, "distinctUntilChanged(this)");
        return a8;
    }

    public final void R() {
        State state = (State) LiveDataExtKt.b(this.f28850i);
        MutableLiveData<State> mutableLiveData = this.f28850i;
        Intrinsics.e(state, "state");
        mutableLiveData.o(State.b(state, EarningsBalanceState.b(state.f(), null, new EarningsBalanceContent.LoadingByRetry(null, 1, null), new EarningsBalanceContent.LoadingByRetry(null, 1, null), new EarningsBalanceContent.LoadingByRetry(null, 1, null), 1, null), null, null, false, 6, null));
        K();
    }

    public final void S(EarningsBalanceState.HistorySection section) {
        Object obj;
        String str;
        int v7;
        Intrinsics.f(section, "section");
        State state = (State) LiveDataExtKt.b(this.f28850i);
        EarningsBalanceState.HistoryHeader a8 = state.f().e().a();
        if (a8 == null) {
            return;
        }
        Iterator<T> it = a8.c().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((EarningsBalanceState.HistorySection) obj).d()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        EarningsBalanceState.HistorySection historySection = (EarningsBalanceState.HistorySection) obj;
        if (historySection != null) {
            str = historySection.c();
        } else {
            str = null;
        }
        if (Intrinsics.a(str, section.c())) {
            return;
        }
        MutableLiveData<State> mutableLiveData = this.f28850i;
        EarningsBalanceState f8 = state.f();
        List<EarningsBalanceState.HistorySection> c8 = a8.c();
        v7 = CollectionsKt__IterablesKt.v(c8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (EarningsBalanceState.HistorySection historySection2 : c8) {
            arrayList.add(EarningsBalanceState.HistorySection.b(historySection2, null, null, Intrinsics.a(historySection2.c(), section.c()), 3, null));
        }
        mutableLiveData.o(state.a(EarningsBalanceState.b(f8, null, null, new EarningsBalanceContent.Success(EarningsBalanceState.HistoryHeader.b(a8, null, arrayList, 1, null)), new EarningsBalanceContent.Loading(null, 1, null), 3, null), section.c(), null, false));
        N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28851j;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EarningsBalanceViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class State {

        /* renamed from: a  reason: collision with root package name */
        private final EarningsBalanceState f28852a;

        /* renamed from: b  reason: collision with root package name */
        private final String f28853b;

        /* renamed from: c  reason: collision with root package name */
        private final String f28854c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f28855d;

        public State() {
            this(null, null, null, false, 15, null);
        }

        public State(EarningsBalanceState uiState, String str, String str2, boolean z7) {
            Intrinsics.f(uiState, "uiState");
            this.f28852a = uiState;
            this.f28853b = str;
            this.f28854c = str2;
            this.f28855d = z7;
        }

        public static /* synthetic */ State b(State state, EarningsBalanceState earningsBalanceState, String str, String str2, boolean z7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                earningsBalanceState = state.f28852a;
            }
            if ((i8 & 2) != 0) {
                str = state.f28853b;
            }
            if ((i8 & 4) != 0) {
                str2 = state.f28854c;
            }
            if ((i8 & 8) != 0) {
                z7 = state.f28855d;
            }
            return state.a(earningsBalanceState, str, str2, z7);
        }

        public final State a(EarningsBalanceState uiState, String str, String str2, boolean z7) {
            Intrinsics.f(uiState, "uiState");
            return new State(uiState, str, str2, z7);
        }

        public final boolean c() {
            return this.f28855d;
        }

        public final String d() {
            return this.f28854c;
        }

        public final String e() {
            return this.f28853b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof State) {
                State state = (State) obj;
                return Intrinsics.a(this.f28852a, state.f28852a) && Intrinsics.a(this.f28853b, state.f28853b) && Intrinsics.a(this.f28854c, state.f28854c) && this.f28855d == state.f28855d;
            }
            return false;
        }

        public final EarningsBalanceState f() {
            return this.f28852a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.f28852a.hashCode() * 31;
            String str = this.f28853b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f28854c;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z7 = this.f28855d;
            int i8 = z7;
            if (z7 != 0) {
                i8 = 1;
            }
            return hashCode3 + i8;
        }

        public String toString() {
            EarningsBalanceState earningsBalanceState = this.f28852a;
            String str = this.f28853b;
            String str2 = this.f28854c;
            boolean z7 = this.f28855d;
            return "State(uiState=" + earningsBalanceState + ", historySectionId=" + str + ", historyPageId=" + str2 + ", historyLoading=" + z7 + ")";
        }

        public /* synthetic */ State(EarningsBalanceState earningsBalanceState, String str, String str2, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? new EarningsBalanceState(null, null, null, null, 15, null) : earningsBalanceState, (i8 & 2) != 0 ? null : str, (i8 & 4) != 0 ? null : str2, (i8 & 8) != 0 ? false : z7);
        }
    }
}
