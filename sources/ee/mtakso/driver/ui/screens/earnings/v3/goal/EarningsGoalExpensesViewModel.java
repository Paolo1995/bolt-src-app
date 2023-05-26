package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.analytics.event.facade.EarningsGoalAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfig;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpense;
import ee.mtakso.driver.uikit.utils.Text;
import eu.bolt.kalev.Kalev;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpensesViewModel.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final EarningsGoalAnalytics f29157f;

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<EarningsGoalExpensesState> f29158g;

    @Inject
    public EarningsGoalExpensesViewModel(EarningsGoalAnalytics earningsGoalAnalytics) {
        Intrinsics.f(earningsGoalAnalytics, "earningsGoalAnalytics");
        this.f29157f = earningsGoalAnalytics;
        this.f29158g = new MutableLiveData<>(new EarningsGoalExpensesState(null, null, null, null, 15, null));
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void D(String type) {
        Object obj;
        List o02;
        Intrinsics.f(type, "type");
        EarningsGoalExpensesState state = (EarningsGoalExpensesState) LiveDataExtKt.b(this.f29158g);
        Iterator<T> it = state.c().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.a(((EarningsGoalExpensesEdit) obj).d().f(), type)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        EarningsGoalExpensesEdit earningsGoalExpensesEdit = (EarningsGoalExpensesEdit) obj;
        if (earningsGoalExpensesEdit == null) {
            String str = "Failed to look up expense " + type + " to add";
            Kalev.c(new IllegalStateException(str), str);
            return;
        }
        MutableLiveData<EarningsGoalExpensesState> mutableLiveData = this.f29158g;
        Intrinsics.e(state, "state");
        o02 = CollectionsKt___CollectionsKt.o0(state.e(), earningsGoalExpensesEdit);
        List<EarningsGoalExpensesEdit> c8 = state.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : c8) {
            if (!Intrinsics.a(((EarningsGoalExpensesEdit) obj2).d().f(), earningsGoalExpensesEdit.d().f())) {
                arrayList.add(obj2);
            }
        }
        mutableLiveData.o(EarningsGoalExpensesState.b(state, o02, arrayList, null, null, 12, null));
    }

    public final void E() {
        boolean z7;
        int v7;
        int v8;
        List n02;
        EarningsGoalExpensesState b8;
        int v9;
        EarningsGoalExpensesState state = (EarningsGoalExpensesState) LiveDataExtKt.b(this.f29158g);
        List<EarningsGoalExpensesEdit> e8 = state.e();
        MutableLiveData<EarningsGoalExpensesState> mutableLiveData = this.f29158g;
        int i8 = 0;
        if (!(e8 instanceof Collection) || !e8.isEmpty()) {
            int i9 = 0;
            for (EarningsGoalExpensesEdit earningsGoalExpensesEdit : e8) {
                if (earningsGoalExpensesEdit.e() != null && !Intrinsics.a(earningsGoalExpensesEdit.e(), BigDecimal.ZERO)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (z7 && (i9 = i9 + 1) < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
            }
            i8 = i9;
        }
        if (i8 > 0) {
            Intrinsics.e(state, "state");
            List<EarningsGoalExpensesEdit> e9 = state.e();
            v9 = CollectionsKt__IterablesKt.v(e9, 10);
            ArrayList arrayList = new ArrayList(v9);
            for (EarningsGoalExpensesEdit earningsGoalExpensesEdit2 : e9) {
                if (earningsGoalExpensesEdit2.e() == null || Intrinsics.a(earningsGoalExpensesEdit2.e(), BigDecimal.ZERO)) {
                    earningsGoalExpensesEdit2 = EarningsGoalExpensesEdit.b(earningsGoalExpensesEdit2, null, null, new Text.Resource(R.string.fill_the_expense_field, null, 2, null), 3, null);
                }
                arrayList.add(earningsGoalExpensesEdit2);
            }
            b8 = EarningsGoalExpensesState.b(state, arrayList, null, null, null, 14, null);
        } else {
            Intrinsics.e(state, "state");
            List<EarningsGoalExpensesEdit> e10 = state.e();
            v7 = CollectionsKt__IterablesKt.v(e10, 10);
            ArrayList arrayList2 = new ArrayList(v7);
            for (EarningsGoalExpensesEdit earningsGoalExpensesEdit3 : e10) {
                EarningsGoalExpense d8 = earningsGoalExpensesEdit3.d();
                BigDecimal e11 = earningsGoalExpensesEdit3.e();
                if (e11 == null) {
                    e11 = BigDecimal.ZERO;
                }
                Intrinsics.e(e11, "edit.value ?: BigDecimal.ZERO");
                arrayList2.add(EarningsGoalExpense.b(d8, null, null, null, new EarningsGoalExpense.State.Set(e11), 7, null));
            }
            List<EarningsGoalExpensesEdit> c8 = state.c();
            v8 = CollectionsKt__IterablesKt.v(c8, 10);
            ArrayList arrayList3 = new ArrayList(v8);
            for (EarningsGoalExpensesEdit earningsGoalExpensesEdit4 : c8) {
                arrayList3.add(EarningsGoalExpense.b(earningsGoalExpensesEdit4.d(), null, null, null, EarningsGoalExpense.State.None.f29099f, 7, null));
            }
            n02 = CollectionsKt___CollectionsKt.n0(arrayList2, arrayList3);
            b8 = EarningsGoalExpensesState.b(state, null, null, null, n02, 7, null);
        }
        mutableLiveData.o(b8);
    }

    public final void F() {
        List<EarningsGoalExpensesEdit> n02;
        int v7;
        EarningsGoalExpensesState state = (EarningsGoalExpensesState) LiveDataExtKt.b(this.f29158g);
        n02 = CollectionsKt___CollectionsKt.n0(state.e(), state.c());
        v7 = CollectionsKt__IterablesKt.v(n02, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (EarningsGoalExpensesEdit earningsGoalExpensesEdit : n02) {
            arrayList.add(EarningsGoalExpense.b(earningsGoalExpensesEdit.d(), null, null, null, EarningsGoalExpense.State.None.f29099f, 7, null));
        }
        MutableLiveData<EarningsGoalExpensesState> mutableLiveData = this.f29158g;
        Intrinsics.e(state, "state");
        mutableLiveData.o(EarningsGoalExpensesState.b(state, null, null, null, arrayList, 7, null));
    }

    public final void G(String type) {
        Object obj;
        List o02;
        Intrinsics.f(type, "type");
        EarningsGoalExpensesState state = (EarningsGoalExpensesState) LiveDataExtKt.b(this.f29158g);
        Iterator<T> it = state.e().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.a(((EarningsGoalExpensesEdit) obj).d().f(), type)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        EarningsGoalExpensesEdit earningsGoalExpensesEdit = (EarningsGoalExpensesEdit) obj;
        if (earningsGoalExpensesEdit == null) {
            String str = "Failed to look up expense " + type + " to delete";
            Kalev.c(new IllegalStateException(str), str);
            return;
        }
        MutableLiveData<EarningsGoalExpensesState> mutableLiveData = this.f29158g;
        Intrinsics.e(state, "state");
        List<EarningsGoalExpensesEdit> e8 = state.e();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : e8) {
            if (!Intrinsics.a(((EarningsGoalExpensesEdit) obj2).d().f(), earningsGoalExpensesEdit.d().f())) {
                arrayList.add(obj2);
            }
        }
        o02 = CollectionsKt___CollectionsKt.o0(state.c(), EarningsGoalExpensesEdit.b(earningsGoalExpensesEdit, null, null, null, 3, null));
        mutableLiveData.o(EarningsGoalExpensesState.b(state, arrayList, o02, null, null, 12, null));
    }

    public final void H(List<EarningsGoalExpense> expenses, CurrencyConfig currencyConfig) {
        EarningsGoalExpensesEdit earningsGoalExpensesEdit;
        Intrinsics.f(expenses, "expenses");
        Intrinsics.f(currencyConfig, "currencyConfig");
        EarningsGoalExpensesState state = (EarningsGoalExpensesState) LiveDataExtKt.b(this.f29158g);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = expenses.iterator();
        while (true) {
            EarningsGoalExpensesEdit earningsGoalExpensesEdit2 = null;
            if (it.hasNext()) {
                EarningsGoalExpense earningsGoalExpense = (EarningsGoalExpense) it.next();
                EarningsGoalExpense.State d8 = earningsGoalExpense.d();
                if (d8 instanceof EarningsGoalExpense.State.Set) {
                    earningsGoalExpensesEdit2 = new EarningsGoalExpensesEdit(earningsGoalExpense, ((EarningsGoalExpense.State.Set) earningsGoalExpense.d()).a(), null, 4, null);
                } else if (d8 instanceof EarningsGoalExpense.State.Default) {
                    earningsGoalExpensesEdit2 = new EarningsGoalExpensesEdit(earningsGoalExpense, null, null, 4, null);
                } else if (!(d8 instanceof EarningsGoalExpense.State.None)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (earningsGoalExpensesEdit2 != null) {
                    arrayList.add(earningsGoalExpensesEdit2);
                }
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (EarningsGoalExpense earningsGoalExpense2 : expenses) {
                    if (earningsGoalExpense2.d() instanceof EarningsGoalExpense.State.None) {
                        earningsGoalExpensesEdit = new EarningsGoalExpensesEdit(earningsGoalExpense2, null, null, 4, null);
                    } else {
                        earningsGoalExpensesEdit = null;
                    }
                    if (earningsGoalExpensesEdit != null) {
                        arrayList2.add(earningsGoalExpensesEdit);
                    }
                }
                MutableLiveData<EarningsGoalExpensesState> mutableLiveData = this.f29158g;
                Intrinsics.e(state, "state");
                mutableLiveData.o(EarningsGoalExpensesState.b(state, arrayList, arrayList2, currencyConfig, null, 8, null));
                return;
            }
        }
    }

    public final LiveData<EarningsGoalExpensesState> I() {
        return this.f29158g;
    }

    public final void J(String type, BigDecimal bigDecimal) {
        int v7;
        Intrinsics.f(type, "type");
        EarningsGoalExpensesState state = (EarningsGoalExpensesState) LiveDataExtKt.b(this.f29158g);
        MutableLiveData<EarningsGoalExpensesState> mutableLiveData = this.f29158g;
        Intrinsics.e(state, "state");
        List<EarningsGoalExpensesEdit> e8 = state.e();
        v7 = CollectionsKt__IterablesKt.v(e8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (EarningsGoalExpensesEdit earningsGoalExpensesEdit : e8) {
            if (Intrinsics.a(earningsGoalExpensesEdit.d().f(), type)) {
                earningsGoalExpensesEdit = EarningsGoalExpensesEdit.b(earningsGoalExpensesEdit, null, bigDecimal, null, 1, null);
            }
            arrayList.add(earningsGoalExpensesEdit);
        }
        mutableLiveData.o(EarningsGoalExpensesState.b(state, arrayList, null, null, null, 14, null));
    }

    public final void K(Function1<? super EarningsGoalAnalytics, Unit> track) {
        Intrinsics.f(track, "track");
        track.invoke(this.f29157f);
    }
}
