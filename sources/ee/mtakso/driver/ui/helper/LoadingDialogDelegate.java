package ee.mtakso.driver.ui.helper;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ee.mtakso.driver.ui.fragments.ProgressDialogFragment;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import eu.bolt.kalev.Kalev;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class LoadingDialogDelegate {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f26409c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final FragmentActivity f26410a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f26411b;

    /* compiled from: LoadingDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LoadingDialogDelegate(FragmentActivity activity) {
        Intrinsics.f(activity, "activity");
        this.f26410a = activity;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.e(supportFragmentManager, "activity.supportFragmentManager");
        this.f26411b = supportFragmentManager;
    }

    public final void a() {
        try {
            DialogFragment dialogFragment = (DialogFragment) this.f26411b.findFragmentByTag("loadingDialog");
            if (dialogFragment != null) {
                dialogFragment.dismissAllowingStateLoss();
            }
            if (!this.f26411b.isDestroyed()) {
                this.f26411b.executePendingTransactions();
            }
        } catch (Exception e8) {
            Kalev.e(e8, "Failed to hide loading dialog!");
        }
    }

    public final void b() {
        if (this.f26411b.findFragmentByTag("loadingDialog") != null) {
            return;
        }
        DialogFragment loadingDialogFragment = ProgressDialogFragment.D();
        Intrinsics.e(loadingDialogFragment, "loadingDialogFragment");
        FragmentUtils.c(loadingDialogFragment, this.f26410a, "loadingDialog");
        try {
            this.f26411b.executePendingTransactions();
        } catch (IllegalStateException e8) {
            Kalev.e(e8, "Failed to show loading dialog!");
        }
    }
}
