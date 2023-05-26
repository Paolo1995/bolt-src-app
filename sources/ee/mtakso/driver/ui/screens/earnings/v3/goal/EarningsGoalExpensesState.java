package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfig;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpensesState.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesState {

    /* renamed from: a  reason: collision with root package name */
    private final List<EarningsGoalExpensesEdit> f29153a;

    /* renamed from: b  reason: collision with root package name */
    private final List<EarningsGoalExpensesEdit> f29154b;

    /* renamed from: c  reason: collision with root package name */
    private final CurrencyConfig f29155c;

    /* renamed from: d  reason: collision with root package name */
    private final List<EarningsGoalExpense> f29156d;

    public EarningsGoalExpensesState() {
        this(null, null, null, null, 15, null);
    }

    public EarningsGoalExpensesState(List<EarningsGoalExpensesEdit> edits, List<EarningsGoalExpensesEdit> chips, CurrencyConfig currencyConfig, List<EarningsGoalExpense> result) {
        Intrinsics.f(edits, "edits");
        Intrinsics.f(chips, "chips");
        Intrinsics.f(currencyConfig, "currencyConfig");
        Intrinsics.f(result, "result");
        this.f29153a = edits;
        this.f29154b = chips;
        this.f29155c = currencyConfig;
        this.f29156d = result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EarningsGoalExpensesState b(EarningsGoalExpensesState earningsGoalExpensesState, List list, List list2, CurrencyConfig currencyConfig, List list3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = earningsGoalExpensesState.f29153a;
        }
        if ((i8 & 2) != 0) {
            list2 = earningsGoalExpensesState.f29154b;
        }
        if ((i8 & 4) != 0) {
            currencyConfig = earningsGoalExpensesState.f29155c;
        }
        if ((i8 & 8) != 0) {
            list3 = earningsGoalExpensesState.f29156d;
        }
        return earningsGoalExpensesState.a(list, list2, currencyConfig, list3);
    }

    public final EarningsGoalExpensesState a(List<EarningsGoalExpensesEdit> edits, List<EarningsGoalExpensesEdit> chips, CurrencyConfig currencyConfig, List<EarningsGoalExpense> result) {
        Intrinsics.f(edits, "edits");
        Intrinsics.f(chips, "chips");
        Intrinsics.f(currencyConfig, "currencyConfig");
        Intrinsics.f(result, "result");
        return new EarningsGoalExpensesState(edits, chips, currencyConfig, result);
    }

    public final List<EarningsGoalExpensesEdit> c() {
        return this.f29154b;
    }

    public final CurrencyConfig d() {
        return this.f29155c;
    }

    public final List<EarningsGoalExpensesEdit> e() {
        return this.f29153a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalExpensesState) {
            EarningsGoalExpensesState earningsGoalExpensesState = (EarningsGoalExpensesState) obj;
            return Intrinsics.a(this.f29153a, earningsGoalExpensesState.f29153a) && Intrinsics.a(this.f29154b, earningsGoalExpensesState.f29154b) && Intrinsics.a(this.f29155c, earningsGoalExpensesState.f29155c) && Intrinsics.a(this.f29156d, earningsGoalExpensesState.f29156d);
        }
        return false;
    }

    public final List<EarningsGoalExpense> f() {
        return this.f29156d;
    }

    public int hashCode() {
        return (((((this.f29153a.hashCode() * 31) + this.f29154b.hashCode()) * 31) + this.f29155c.hashCode()) * 31) + this.f29156d.hashCode();
    }

    public String toString() {
        List<EarningsGoalExpensesEdit> list = this.f29153a;
        List<EarningsGoalExpensesEdit> list2 = this.f29154b;
        CurrencyConfig currencyConfig = this.f29155c;
        List<EarningsGoalExpense> list3 = this.f29156d;
        return "EarningsGoalExpensesState(edits=" + list + ", chips=" + list2 + ", currencyConfig=" + currencyConfig + ", result=" + list3 + ")";
    }

    public /* synthetic */ EarningsGoalExpensesState(List list, List list2, CurrencyConfig currencyConfig, List list3, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list, (i8 & 2) != 0 ? CollectionsKt__CollectionsKt.k() : list2, (i8 & 4) != 0 ? new CurrencyConfig(null, false, 3, null) : currencyConfig, (i8 & 8) != 0 ? CollectionsKt__CollectionsKt.k() : list3);
    }
}
