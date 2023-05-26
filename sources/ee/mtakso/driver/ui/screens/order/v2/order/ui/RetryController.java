package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryController.kt */
/* loaded from: classes3.dex */
public final class RetryController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f32419a;

    public RetryController(ViewGroup containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f32419a = containerView;
        ((TextView) containerView.findViewById(R.id.retryTitle)).setText(containerView.getResources().getString(R.string.error_ride_details));
        ((TextView) containerView.findViewById(R.id.retrySubtitle)).setText(containerView.getResources().getString(R.string.error_not_internet_connection_message));
    }

    public final void a(View view, boolean z7) {
        Intrinsics.f(view, "view");
        ViewGroup viewGroup = this.f32419a;
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.c0(this.f32419a.getResources().getInteger(17694721));
        changeBounds.c(view);
        TransitionManager.b(viewGroup, changeBounds);
        ViewExtKt.d(view, z7, 0, 2, null);
    }
}
