package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import android.view.View;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.ui.screens.earnings.v3.goal.EarningsGoalExpensesFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EarningsGoalExpensesFragment.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesFragment$renderSuggestedExpenses$2 extends Lambda implements Function2<EarningsGoalExpensesFragment.ChipViewHolder, Integer, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ EarningsGoalExpensesState f29147f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ EarningsGoalExpensesFragment f29148g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsGoalExpensesFragment$renderSuggestedExpenses$2(EarningsGoalExpensesState earningsGoalExpensesState, EarningsGoalExpensesFragment earningsGoalExpensesFragment) {
        super(2);
        this.f29147f = earningsGoalExpensesState;
        this.f29148g = earningsGoalExpensesFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(EarningsGoalExpensesFragment this$0, EarningsGoalExpensesEdit edit, View view) {
        EarningsGoalExpensesViewModel l02;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(edit, "$edit");
        l02 = this$0.l0();
        l02.D(edit.d().f());
    }

    public final void c(EarningsGoalExpensesFragment.ChipViewHolder holder, int i8) {
        Intrinsics.f(holder, "holder");
        final EarningsGoalExpensesEdit earningsGoalExpensesEdit = this.f29147f.c().get(i8);
        holder.a().setText(earningsGoalExpensesEdit.d().e());
        Chip a8 = holder.a();
        final EarningsGoalExpensesFragment earningsGoalExpensesFragment = this.f29148g;
        a8.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.earnings.v3.goal.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EarningsGoalExpensesFragment$renderSuggestedExpenses$2.d(EarningsGoalExpensesFragment.this, earningsGoalExpensesEdit, view);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit s(EarningsGoalExpensesFragment.ChipViewHolder chipViewHolder, Integer num) {
        c(chipViewHolder, num.intValue());
        return Unit.f50853a;
    }
}
