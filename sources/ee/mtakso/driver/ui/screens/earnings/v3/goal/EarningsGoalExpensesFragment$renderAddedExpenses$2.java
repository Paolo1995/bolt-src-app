package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyEdit;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uikit.utils.Text;
import ee.mtakso.driver.uikit.utils.TextKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import java.math.BigDecimal;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EarningsGoalExpensesFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesFragment$renderAddedExpenses$2 extends Lambda implements Function2<EarningsGoalExpensesFragment.EditViewHolder, Integer, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ EarningsGoalExpensesState f29140f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ EarningsGoalExpensesFragment f29141g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsGoalExpensesFragment$renderAddedExpenses$2(EarningsGoalExpensesState earningsGoalExpensesState, EarningsGoalExpensesFragment earningsGoalExpensesFragment) {
        super(2);
        this.f29140f = earningsGoalExpensesState;
        this.f29141g = earningsGoalExpensesFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EarningsGoalExpensesFragment this$0, EarningsGoalExpensesEdit edit, View view) {
        EarningsGoalExpensesViewModel l02;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(edit, "$edit");
        l02 = this$0.l0();
        l02.G(edit.d().f());
    }

    public final void c(EarningsGoalExpensesFragment.EditViewHolder holder, int i8) {
        boolean z7;
        Intrinsics.f(holder, "holder");
        final EarningsGoalExpensesEdit earningsGoalExpensesEdit = this.f29140f.e().get(i8);
        int i9 = R.id.expenseEdit;
        ((TextInputView) holder.a(i9)).setHint(earningsGoalExpensesEdit.d().e());
        TextInputView textInputView = (TextInputView) holder.a(i9);
        boolean z8 = true;
        if (earningsGoalExpensesEdit.c() != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        textInputView.setError(z7);
        int i10 = R.id.expenseEditError;
        TextView textView = (TextView) holder.a(i10);
        Intrinsics.e(textView, "holder.expenseEditError");
        if (earningsGoalExpensesEdit.c() == null) {
            z8 = false;
        }
        CharSequence charSequence = null;
        ViewExtKt.d(textView, z8, 0, 2, null);
        TextView textView2 = (TextView) holder.a(i10);
        Text c8 = earningsGoalExpensesEdit.c();
        if (c8 != null) {
            Context requireContext = this.f29141g.requireContext();
            Intrinsics.e(requireContext, "requireContext()");
            charSequence = TextKt.a(c8, requireContext);
        }
        textView2.setText(charSequence);
        holder.c().d(earningsGoalExpensesEdit.e(), this.f29140f.d());
        CurrencyEdit c9 = holder.c();
        final EarningsGoalExpensesFragment earningsGoalExpensesFragment = this.f29141g;
        c9.i(new Function1<BigDecimal, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment$renderAddedExpenses$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(BigDecimal bigDecimal) {
                EarningsGoalExpensesViewModel l02;
                l02 = EarningsGoalExpensesFragment.this.l0();
                l02.J(earningsGoalExpensesEdit.d().f(), bigDecimal);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BigDecimal bigDecimal) {
                b(bigDecimal);
                return Unit.f50853a;
            }
        });
        final EarningsGoalExpensesFragment earningsGoalExpensesFragment2 = this.f29141g;
        ((ImageButton) holder.a(R.id.expenseDelete)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsGoalExpensesFragment$renderAddedExpenses$2.d(EarningsGoalExpensesFragment.this, earningsGoalExpensesEdit, view);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit s(EarningsGoalExpensesFragment.EditViewHolder editViewHolder, Integer num) {
        c(editViewHolder, num.intValue());
        return Unit.f50853a;
    }
}
