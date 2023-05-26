package ee.mtakso.driver.ui.screens.login.v3.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.FragmentUtils;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.driver.core.ui.base.dialog.BaseDialogFragment;
import eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback;
import eu.bolt.driver.core.ui.base.dialog.DialogCallback;
import eu.bolt.driver.core.ui.common.dialog.ActionDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginPermissionsDelegate.kt */
/* loaded from: classes3.dex */
public final class LoginPermissionsDelegate {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f30647e = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f30648a;

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Throwable, Unit> f30649b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<Unit> f30650c;

    /* renamed from: d  reason: collision with root package name */
    private final DefaultDialogCallback f30651d;

    /* compiled from: LoginPermissionsDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoginPermissionsDelegate(Fragment fragment, Function1<? super Throwable, Unit> onError, Function0<Unit> onLocationAsked) {
        Intrinsics.f(fragment, "fragment");
        Intrinsics.f(onError, "onError");
        Intrinsics.f(onLocationAsked, "onLocationAsked");
        this.f30648a = fragment;
        this.f30649b = onError;
        this.f30650c = onLocationAsked;
        this.f30651d = new DefaultDialogCallback() { // from class: ee.mtakso.driver.ui.screens.login.v3.common.LoginPermissionsDelegate$dialogCallback$1
            @Override // eu.bolt.driver.core.ui.base.dialog.DefaultDialogCallback, eu.bolt.driver.core.ui.base.dialog.DialogCallback
            public void a(BaseDialogFragment dialog, View view, Object payload) {
                Function0 function0;
                Fragment fragment2;
                Fragment fragment3;
                Intrinsics.f(dialog, "dialog");
                Intrinsics.f(view, "view");
                Intrinsics.f(payload, "payload");
                if (Intrinsics.a(payload, "negative")) {
                    dialog.dismissAllowingStateLoss();
                } else if (Intrinsics.a(payload, "positive")) {
                    function0 = LoginPermissionsDelegate.this.f30650c;
                    function0.invoke();
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    fragment2 = LoginPermissionsDelegate.this.f30648a;
                    intent.setData(Uri.fromParts("package", fragment2.requireContext().getPackageName(), null));
                    fragment3 = LoginPermissionsDelegate.this.f30648a;
                    fragment3.startActivityForResult(intent, 5500);
                }
            }
        };
    }

    private final void e(Fragment fragment, DialogCallback dialogCallback) {
        Context requireContext = fragment.requireContext();
        Intrinsics.e(requireContext, "fragment.requireContext()");
        ActionDialog.Companion companion = ActionDialog.f41071m;
        String string = requireContext.getString(R.string.location_permission);
        Intrinsics.e(string, "context.getString(R.string.location_permission)");
        String string2 = requireContext.getString(R.string.location_permission_explain);
        Intrinsics.e(string2, "context.getString(R.stri…ation_permission_explain)");
        String string3 = requireContext.getString(R.string.permission_request_enable_location);
        Intrinsics.e(string3, "context.getString(R.stri…_request_enable_location)");
        String string4 = requireContext.getString(R.string.permission_request_cancel);
        Intrinsics.e(string4, "context.getString(R.stri…ermission_request_cancel)");
        FragmentUtils.b(companion.a(string, string2, string3, string4, dialogCallback), fragment, "TAG_LOCATION");
    }

    public final void c() {
        BaseDialogFragment.f41026i.a(this.f30648a.getChildFragmentManager(), "TAG_LOCATION", this.f30651d);
    }

    public final void d(PermissionManager.PermissionInfo permission) {
        Intrinsics.f(permission, "permission");
        if (Intrinsics.a(permission.b(), "android.permission.ACCESS_FINE_LOCATION")) {
            e(this.f30648a, this.f30651d);
            return;
        }
        Function1<Throwable, Unit> function1 = this.f30649b;
        String b8 = permission.b();
        function1.invoke(new IllegalStateException("Unknown permission " + b8));
    }
}
