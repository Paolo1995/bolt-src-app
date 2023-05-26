package ee.mtakso.driver.ui.helper;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogLifecycleEvent;
import eu.bolt.driver.core.ui.common.dialog.InfoDialog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class ErrorDialogDelegate {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f26403c = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final FragmentActivity f26404a;

    /* renamed from: b  reason: collision with root package name */
    private final ErrorDialogDelegate$dialogCallback$1 f26405b;

    /* compiled from: ErrorDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [ee.mtakso.driver.ui.helper.ErrorDialogDelegate$dialogCallback$1] */
    public ErrorDialogDelegate(FragmentActivity activity) {
        Intrinsics.f(activity, "activity");
        this.f26404a = activity;
        this.f26405b = new DialogCallback() { // from class: ee.mtakso.driver.ui.helper.ErrorDialogDelegate$dialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
            }

            @Override // eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void b(BaseDialogFragment dialog, DialogLifecycleEvent event, Object obj) {
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(event, "event");
            }
        };
    }

    public final void a(Throwable error) {
        Intrinsics.f(error, "error");
        InfoDialog.Companion companion = InfoDialog.f41099m;
        String string = this.f26404a.getString(R.string.error);
        String k8 = ApiExceptionUtils.k(error, this.f26404a);
        String string2 = this.f26404a.getString(R.string.ok_lowercase);
        ErrorDialogDelegate$dialogCallback$1 errorDialogDelegate$dialogCallback$1 = this.f26405b;
        Intrinsics.e(string, "getString(R.string.error)");
        Intrinsics.e(string2, "getString(R.string.ok_lowercase)");
        FragmentUtils.c(companion.a(string, null, k8, string2, errorDialogDelegate$dialogCallback$1), this.f26404a, "errorDialog");
    }
}
