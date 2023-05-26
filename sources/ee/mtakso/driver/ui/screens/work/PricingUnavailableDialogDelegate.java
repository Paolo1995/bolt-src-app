package ee.mtakso.driver.ui.screens.work;

import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.dialogs.NotificationDialog;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PricingUnavailableDialogDelegate.kt */
/* loaded from: classes5.dex */
public final class PricingUnavailableDialogDelegate {

    /* renamed from: a  reason: collision with root package name */
    private static final Companion f33666a = new Companion(null);

    /* compiled from: PricingUnavailableDialogDelegate.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void a(Fragment fragment) {
        Intrinsics.f(fragment, "fragment");
        NotificationDialog.Companion companion = NotificationDialog.f28313n;
        String string = fragment.getString(R.string.driver_pricing_error_title);
        String string2 = fragment.getString(R.string.driver_pricing_error_became_unavailable_message_proceed);
        String string3 = fragment.getString(R.string.close);
        Intrinsics.e(string3, "fragment.getString(R.string.close)");
        FragmentUtils.b(NotificationDialog.Companion.f(companion, string, string2, string3, 0, null, null, 48, null), fragment, "pricing_unavailable");
    }
}
