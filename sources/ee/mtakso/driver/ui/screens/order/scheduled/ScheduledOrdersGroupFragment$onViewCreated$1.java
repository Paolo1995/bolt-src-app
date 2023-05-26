package ee.mtakso.driver.ui.screens.order.scheduled;

import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ScheduledOrdersGroupFragment.kt */
/* loaded from: classes3.dex */
final class ScheduledOrdersGroupFragment$onViewCreated$1 extends Lambda implements Function1<ScheduledOrdersGroupState, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ScheduledOrdersGroupFragment f31777f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScheduledOrdersGroupFragment$onViewCreated$1(ScheduledOrdersGroupFragment scheduledOrdersGroupFragment) {
        super(1);
        this.f31777f = scheduledOrdersGroupFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ScheduledOrdersGroupState state, ScheduledOrdersGroupFragment this$0) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(state, "state");
        if (ScheduledOrdersGroupStateKt.a(state)) {
            ((RecyclerView) this$0.S(R.id.H9)).x1(state.c());
        }
    }

    public final void c(final ScheduledOrdersGroupState scheduledOrdersGroupState) {
        DiffAdapter diffAdapter;
        diffAdapter = this.f31777f.f31774p;
        List<ListModel> b8 = scheduledOrdersGroupState.b();
        final ScheduledOrdersGroupFragment scheduledOrdersGroupFragment = this.f31777f;
        diffAdapter.U(b8, new Runnable() { // from class: ee.mtakso.driver.ui.screens.order.scheduled.p
            @Override // java.lang.Runnable
            public final void run() {
                ScheduledOrdersGroupFragment$onViewCreated$1.d(ScheduledOrdersGroupState.this, scheduledOrdersGroupFragment);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScheduledOrdersGroupState scheduledOrdersGroupState) {
        c(scheduledOrdersGroupState);
        return Unit.f50853a;
    }
}
