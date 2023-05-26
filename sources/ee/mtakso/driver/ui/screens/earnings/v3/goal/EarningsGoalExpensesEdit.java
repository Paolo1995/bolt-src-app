package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import ee.mtakso.driver.uikit.utils.Text;
import java.math.BigDecimal;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpensesEdit.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesEdit {

    /* renamed from: a  reason: collision with root package name */
    private final EarningsGoalExpense f29104a;

    /* renamed from: b  reason: collision with root package name */
    private final BigDecimal f29105b;

    /* renamed from: c  reason: collision with root package name */
    private final Text f29106c;

    public EarningsGoalExpensesEdit(EarningsGoalExpense expense, BigDecimal bigDecimal, Text text) {
        Intrinsics.f(expense, "expense");
        this.f29104a = expense;
        this.f29105b = bigDecimal;
        this.f29106c = text;
    }

    public static /* synthetic */ EarningsGoalExpensesEdit b(EarningsGoalExpensesEdit earningsGoalExpensesEdit, EarningsGoalExpense earningsGoalExpense, BigDecimal bigDecimal, Text text, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            earningsGoalExpense = earningsGoalExpensesEdit.f29104a;
        }
        if ((i8 & 2) != 0) {
            bigDecimal = earningsGoalExpensesEdit.f29105b;
        }
        if ((i8 & 4) != 0) {
            text = earningsGoalExpensesEdit.f29106c;
        }
        return earningsGoalExpensesEdit.a(earningsGoalExpense, bigDecimal, text);
    }

    public final EarningsGoalExpensesEdit a(EarningsGoalExpense expense, BigDecimal bigDecimal, Text text) {
        Intrinsics.f(expense, "expense");
        return new EarningsGoalExpensesEdit(expense, bigDecimal, text);
    }

    public final Text c() {
        return this.f29106c;
    }

    public final EarningsGoalExpense d() {
        return this.f29104a;
    }

    public final BigDecimal e() {
        return this.f29105b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalExpensesEdit) {
            EarningsGoalExpensesEdit earningsGoalExpensesEdit = (EarningsGoalExpensesEdit) obj;
            return Intrinsics.a(this.f29104a, earningsGoalExpensesEdit.f29104a) && Intrinsics.a(this.f29105b, earningsGoalExpensesEdit.f29105b) && Intrinsics.a(this.f29106c, earningsGoalExpensesEdit.f29106c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f29104a.hashCode() * 31;
        BigDecimal bigDecimal = this.f29105b;
        int hashCode2 = (hashCode + (bigDecimal == null ? 0 : bigDecimal.hashCode())) * 31;
        Text text = this.f29106c;
        return hashCode2 + (text != null ? text.hashCode() : 0);
    }

    public String toString() {
        EarningsGoalExpense earningsGoalExpense = this.f29104a;
        BigDecimal bigDecimal = this.f29105b;
        Text text = this.f29106c;
        return "EarningsGoalExpensesEdit(expense=" + earningsGoalExpense + ", value=" + bigDecimal + ", error=" + text + ")";
    }

    public /* synthetic */ EarningsGoalExpensesEdit(EarningsGoalExpense earningsGoalExpense, BigDecimal bigDecimal, Text text, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(earningsGoalExpense, bigDecimal, (i8 & 4) != 0 ? null : text);
    }
}
