package ee.mtakso.driver.ui.screens.home.v3.delegate;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.car_chooser.CarChooserActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeViewModel;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.ConfirmationWithIconDialog;
import eu.bolt.driver.core.ui.common.dialog.NotificationWithIconDialog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CarUnavailableDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class CarUnavailableDialogDelegate {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f29864b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final CarUnavailableDialogDelegate$dialogCallback$1 f29865a = new DialogCallback() { // from class: ee.mtakso.driver.ui.screens.home.v3.delegate.CarUnavailableDialogDelegate$dialogCallback$1
        @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
        public void a(BaseDialogFragment dialog, View view, Object payload) {
            Intrinsics.f(dialog, "dialog");
            Intrinsics.f(view, "view");
            Intrinsics.f(payload, "payload");
            String tag = dialog.getTag();
            if (tag != null && tag.hashCode() == 915815387 && tag.equals("TAG_CAR_UNAVILABLE")) {
                CarUnavailableDialogDelegate carUnavailableDialogDelegate = CarUnavailableDialogDelegate.this;
                boolean a8 = Intrinsics.a(payload, "ITEM_CONFIRM_TAG");
                Context context = view.getContext();
                Intrinsics.e(context, "view.context");
                carUnavailableDialogDelegate.b(a8, context);
            }
        }

        @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
        public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
            Intrinsics.f(dialog, "dialog");
            Intrinsics.f(event, "event");
        }
    };

    /* compiled from: CarUnavailableDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z7, Context context) {
        if (z7) {
            CarChooserActivity.f27656u.a(context);
        }
    }

    public final void c(FragmentActivity activity) {
        Intrinsics.f(activity, "activity");
        BaseDialogFragment.f41026i.a(activity.getSupportFragmentManager(), "TAG_CAR_UNAVILABLE", this.f29865a);
    }

    public final void d(HomeViewModel.CarUnavailableDialog event, FragmentActivity activity) {
        ConfirmationWithIconDialog a8;
        Intrinsics.f(event, "event");
        Intrinsics.f(activity, "activity");
        if (activity.getSupportFragmentManager().findFragmentByTag("TAG_CAR_UNAVILABLE") != null) {
            return;
        }
        if (event.b()) {
            ConfirmationWithIconDialog.Companion companion = ConfirmationWithIconDialog.f41082m;
            String string = activity.getString(R.string.car_unavailable_title);
            Intrinsics.e(string, "activity.getString(R.string.car_unavailable_title)");
            String string2 = activity.getString(R.string.car_unavailable_message, event.a());
            Intrinsics.e(string2, "activity.getString(R.str…e_message, event.carName)");
            String string3 = activity.getString(R.string.car_unavailable_choose);
            Intrinsics.e(string3, "activity.getString(R.str…g.car_unavailable_choose)");
            String string4 = activity.getString(R.string.close);
            Intrinsics.e(string4, "activity.getString(R.string.close)");
            a8 = companion.a(R.drawable.ic_error, string, string2, string3, (r20 & 16) != 0 ? UiKitRoundButtonType.f36161k : null, string4, this.f29865a, (r20 & 128) != 0 ? null : null);
            FragmentUtils.c(a8, activity, "TAG_CAR_UNAVILABLE");
            return;
        }
        NotificationWithIconDialog.Companion companion2 = NotificationWithIconDialog.f41101m;
        String string5 = activity.getString(R.string.car_unavailable_title);
        Intrinsics.e(string5, "activity.getString(R.string.car_unavailable_title)");
        String string6 = activity.getString(R.string.car_unavailable_message, event.a());
        Intrinsics.e(string6, "activity.getString(R.str…e_message, event.carName)");
        String string7 = activity.getString(R.string.close);
        Intrinsics.e(string7, "activity.getString(R.string.close)");
        FragmentUtils.c(companion2.a(R.drawable.ic_error, string5, string6, string7, this.f29865a), activity, "TAG_CAR_UNAVILABLE");
    }
}
