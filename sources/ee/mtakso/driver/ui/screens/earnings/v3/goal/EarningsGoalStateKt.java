package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpense;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalState.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalStateKt {
    public static final List<EarningsGoalExpense> a(EarningsGoalState earningsGoalState) {
        Intrinsics.f(earningsGoalState, "<this>");
        List<EarningsGoalExpense> g8 = earningsGoalState.g();
        ArrayList arrayList = new ArrayList();
        for (Object obj : g8) {
            if (((EarningsGoalExpense) obj).d() instanceof EarningsGoalExpense.State.Set) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final BigDecimal b(EarningsGoalState earningsGoalState) {
        Intrinsics.f(earningsGoalState, "<this>");
        BigDecimal e8 = e(earningsGoalState);
        BigDecimal i8 = earningsGoalState.i();
        if (i8 == null) {
            i8 = BigDecimal.ZERO;
        }
        Intrinsics.e(i8, "target ?: BigDecimal.ZERO");
        BigDecimal add = e8.add(i8);
        Intrinsics.e(add, "this.add(other)");
        return add;
    }

    public static final EarningsGoalPeriod c(EarningsGoalState earningsGoalState) {
        Object obj;
        Intrinsics.f(earningsGoalState, "<this>");
        Iterator<T> it = earningsGoalState.h().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((EarningsGoalPeriod) obj).g()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (EarningsGoalPeriod) obj;
    }

    public static final String d(EarningsGoalState earningsGoalState) {
        Object obj;
        Intrinsics.f(earningsGoalState, "<this>");
        Iterator<T> it = earningsGoalState.h().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((EarningsGoalPeriod) obj).g()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        EarningsGoalPeriod earningsGoalPeriod = (EarningsGoalPeriod) obj;
        if (earningsGoalPeriod == null) {
            return null;
        }
        return earningsGoalPeriod.f();
    }

    public static final BigDecimal e(EarningsGoalState earningsGoalState) {
        Intrinsics.f(earningsGoalState, "<this>");
        List<EarningsGoalExpense> a8 = a(earningsGoalState);
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.e(valueOf, "valueOf(this.toLong())");
        for (EarningsGoalExpense earningsGoalExpense : a8) {
            BigDecimal a9 = EarningsGoalExpenseKt.a(earningsGoalExpense);
            if (a9 == null) {
                a9 = BigDecimal.ZERO;
            }
            Intrinsics.e(a9, "it.value ?: BigDecimal.ZERO");
            valueOf = valueOf.add(a9);
            Intrinsics.e(valueOf, "this.add(other)");
        }
        return valueOf;
    }
}
