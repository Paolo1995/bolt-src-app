package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpense;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpensesState.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesStateKt {
    public static final boolean a(EarningsGoalExpensesState earningsGoalExpensesState) {
        Intrinsics.f(earningsGoalExpensesState, "<this>");
        if (earningsGoalExpensesState.e().isEmpty()) {
            return false;
        }
        List<EarningsGoalExpensesEdit> e8 = earningsGoalExpensesState.e();
        if ((e8 instanceof Collection) && e8.isEmpty()) {
            return false;
        }
        for (EarningsGoalExpensesEdit earningsGoalExpensesEdit : e8) {
            if (earningsGoalExpensesEdit.d().d() instanceof EarningsGoalExpense.State.Set) {
                return true;
            }
        }
        return false;
    }

    public static final BigDecimal b(EarningsGoalExpensesState earningsGoalExpensesState) {
        Intrinsics.f(earningsGoalExpensesState, "<this>");
        List<EarningsGoalExpensesEdit> e8 = earningsGoalExpensesState.e();
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.e(valueOf, "valueOf(this.toLong())");
        for (EarningsGoalExpensesEdit earningsGoalExpensesEdit : e8) {
            BigDecimal e9 = earningsGoalExpensesEdit.e();
            if (e9 == null) {
                e9 = BigDecimal.ZERO;
            }
            Intrinsics.e(e9, "it.value ?: BigDecimal.ZERO");
            valueOf = valueOf.add(e9);
            Intrinsics.e(valueOf, "this.add(other)");
        }
        return valueOf;
    }
}
