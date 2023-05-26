package ee.mtakso.driver.ui.screens.work;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.ConfirmationDialog;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.uikit.widgets.UiKitRoundButtonType;
import ee.mtakso.driver.utils.AssertUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationRequiredDialogDelegate.kt */
/* loaded from: classes5.dex */
public final class LocationRequiredDialogDelegate {

    /* renamed from: c  reason: collision with root package name */
    private static final Companion f33645c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private Function0<Unit> f33646a = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.LocationRequiredDialogDelegate$actionListener$1
        public final void b() {
            AssertUtils.a("actionListener should be assigned ");
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private Function0<Unit> f33647b = new Function0<Unit>() { // from class: ee.mtakso.driver.ui.screens.work.LocationRequiredDialogDelegate$cancelListener$1
        public final void b() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.f50853a;
        }
    };

    /* compiled from: LocationRequiredDialogDelegate.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(DialogFragment dialogFragment, View view, Object obj) {
        if (Intrinsics.a(obj, "confirm")) {
            dialogFragment.dismissAllowingStateLoss();
            this.f33646a.invoke();
        } else if (Intrinsics.a(obj, "cancel")) {
            dialogFragment.dismissAllowingStateLoss();
            this.f33647b.invoke();
        } else if (Intrinsics.a(obj, "dialog_cancel")) {
            this.f33647b.invoke();
        }
    }

    public final void c(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, fragment.getChildFragmentManager(), "location_required", null, new LocationRequiredDialogDelegate$restoreCallbacks$1(this), 4, null);
    }

    public final void d(Function0<Unit> function0) {
        Intrinsics.f(function0, "<set-?>");
        this.f33646a = function0;
    }

    public final void e(Function0<Unit> function0) {
        Intrinsics.f(function0, "<set-?>");
        this.f33647b = function0;
    }

    public final void f(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        if (fragment.getChildFragmentManager().findFragmentByTag("location_required") != null) {
            return;
        }
        ConfirmationDialog.Companion companion = ConfirmationDialog.f28256p;
        String string = fragment.getString(R.string.location_permission);
        Intrinsics.e(string, "fragment.getString(R.string.location_permission)");
        String string2 = fragment.getString(R.string.location_required_message);
        Intrinsics.e(string2, "fragment.getString(R.str…ocation_required_message)");
        String string3 = fragment.getString(R.string.permission_request_enable_location);
        Intrinsics.e(string3, "fragment.getString(R.str…_request_enable_location)");
        FragmentUtils.b(ConfirmationDialog.Companion.b(companion, string, string2, string3, null, UiKitRoundButtonType.f36161k, fragment.getString(R.string.action_cancel), null, null, new LocationRequiredDialogDelegate$showLocationRequire$1(this), 200, null), fragment, "location_required");
    }
}
