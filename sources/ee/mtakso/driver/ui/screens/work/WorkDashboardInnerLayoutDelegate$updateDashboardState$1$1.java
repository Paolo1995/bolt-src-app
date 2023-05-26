package ee.mtakso.driver.ui.screens.work;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkDashboardInnerLayoutDelegate.kt */
/* loaded from: classes5.dex */
public final class WorkDashboardInnerLayoutDelegate$updateDashboardState$1$1 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ RecyclerView f33676f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ WorkDashboardInnerLayoutDelegate f33677g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkDashboardInnerLayoutDelegate$updateDashboardState$1$1(RecyclerView recyclerView, WorkDashboardInnerLayoutDelegate workDashboardInnerLayoutDelegate) {
        super(1);
        this.f33676f = recyclerView;
        this.f33677g = workDashboardInnerLayoutDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RecyclerView this_apply, WorkDashboardInnerLayoutDelegate this$0) {
        Function0 function0;
        Intrinsics.f(this_apply, "$this_apply");
        Intrinsics.f(this$0, "this$0");
        this_apply.requestLayout();
        function0 = this$0.f33669b;
        function0.invoke();
    }

    public final void c(int i8) {
        int paddingTop = i8 + this.f33676f.getPaddingTop() + this.f33676f.getPaddingBottom();
        if (this.f33676f.getMeasuredHeight() != paddingTop) {
            RecyclerView recyclerView = this.f33676f;
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            layoutParams.height = paddingTop;
            recyclerView.setLayoutParams(layoutParams);
            final RecyclerView recyclerView2 = this.f33676f;
            final WorkDashboardInnerLayoutDelegate workDashboardInnerLayoutDelegate = this.f33677g;
            recyclerView2.post(new Runnable() { // from class: ee.mtakso.driver.ui.screens.work.b
                @Override // java.lang.Runnable
                public final void run() {
                    WorkDashboardInnerLayoutDelegate$updateDashboardState$1$1.d(RecyclerView.this, workDashboardInnerLayoutDelegate);
                }
            });
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        c(num.intValue());
        return Unit.f50853a;
    }
}
