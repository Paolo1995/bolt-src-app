package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpense;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpense.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpenseKt {
    public static final BigDecimal a(EarningsGoalExpense earningsGoalExpense) {
        EarningsGoalExpense.State.Set set;
        Intrinsics.f(earningsGoalExpense, "<this>");
        EarningsGoalExpense.State d8 = earningsGoalExpense.d();
        if (d8 instanceof EarningsGoalExpense.State.Set) {
            set = (EarningsGoalExpense.State.Set) d8;
        } else {
            set = null;
        }
        if (set == null) {
            return null;
        }
        return set.a();
    }
}
