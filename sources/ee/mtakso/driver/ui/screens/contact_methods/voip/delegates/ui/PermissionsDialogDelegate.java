package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import ee.mtakso.driver.ui.screens.contact_methods.voip.permission.VoipPermissionDialogFactory;
import ee.mtakso.driver.uicore.components.dialogs.BaseDialogFragment;
import ee.mtakso.driver.uicore.components.dialogs.RestoreableDialogFragment;
import eu.bolt.driver.core.permission.PermissionManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionsDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class PermissionsDialogDelegate {

    /* renamed from: g */
    private static final Companion f27974g = new Companion(null);

    /* renamed from: a */
    private final Context f27975a;

    /* renamed from: b */
    private final VoipPermissionDialogFactory f27976b;

    /* renamed from: c */
    private final FragmentManager f27977c;

    /* renamed from: d */
    private final PermissionManager f27978d;

    /* renamed from: e */
    private BaseDialogFragment f27979e;

    /* renamed from: f */
    private Function3<? super DialogFragment, ? super View, Object, Unit> f27980f;

    /* compiled from: PermissionsDialogDelegate.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionsDialogDelegate(Context context, VoipPermissionDialogFactory voipPermissionDialogFactory, FragmentManager fragmentManager, PermissionManager permissionManager) {
        Intrinsics.f(context, "context");
        Intrinsics.f(voipPermissionDialogFactory, "voipPermissionDialogFactory");
        Intrinsics.f(permissionManager, "permissionManager");
        this.f27975a = context;
        this.f27976b = voipPermissionDialogFactory;
        this.f27977c = fragmentManager;
        this.f27978d = permissionManager;
        this.f27980f = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.PermissionsDialogDelegate$onViewClickListener$1
            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                throw new IllegalStateException("Callback should be assigned by restoreCallbacks");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(PermissionsDialogDelegate permissionsDialogDelegate, Function0 function0, Function0 function02, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            function02 = null;
        }
        permissionsDialogDelegate.d(function0, function02);
    }

    public final void b() {
        BaseDialogFragment baseDialogFragment = this.f27979e;
        if (baseDialogFragment != null) {
            baseDialogFragment.dismissAllowingStateLoss();
        }
        this.f27979e = null;
    }

    public final boolean c() {
        boolean z7;
        boolean z8;
        PermissionManager.PermissionStatus d8 = this.f27978d.o("android.permission.RECORD_AUDIO").d();
        PermissionManager.PermissionStatus permissionStatus = PermissionManager.PermissionStatus.GRANTED;
        if (d8 == permissionStatus) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (Build.VERSION.SDK_INT >= 31 && this.f27978d.o("android.permission.BLUETOOTH_CONNECT").d() != permissionStatus) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z7 || !z8) {
            return false;
        }
        return true;
    }

    public final void d(final Function0<Unit> onPermissionRequestedClick, final Function0<Unit> function0) {
        Intrinsics.f(onPermissionRequestedClick, "onPermissionRequestedClick");
        Function3<DialogFragment, View, Object, Unit> function3 = new Function3<DialogFragment, View, Object, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.ui.PermissionsDialogDelegate$restoreCallbacks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final void b(DialogFragment dialogFragment, View view, Object obj) {
                Function0<Unit> function02;
                Context context;
                Context context2;
                Intrinsics.f(dialogFragment, "<anonymous parameter 0>");
                if (Intrinsics.a(obj, "dialog_leads_to_settings")) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    context = PermissionsDialogDelegate.this.f27975a;
                    intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                    context2 = PermissionsDialogDelegate.this.f27975a;
                    context2.startActivity(intent);
                    Function0<Unit> function03 = function0;
                    if (function03 != null) {
                        function03.invoke();
                    }
                } else if (Intrinsics.a(obj, "dialog_request_permission")) {
                    onPermissionRequestedClick.invoke();
                } else if (Intrinsics.a(obj, "dialog_deny_request_permission") && (function02 = function0) != null) {
                    function02.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit l(DialogFragment dialogFragment, View view, Object obj) {
                b(dialogFragment, view, obj);
                return Unit.f50853a;
            }
        };
        this.f27980f = function3;
        RestoreableDialogFragment.Companion.b(RestoreableDialogFragment.f34751j, this.f27977c, "permission_dialog_tag", function3, null, 8, null);
    }

    public final void f() {
        BaseDialogFragment baseDialogFragment;
        b();
        BaseDialogFragment a8 = this.f27976b.a();
        this.f27979e = a8;
        if (a8 != null) {
            a8.K(this.f27980f);
        }
        FragmentManager fragmentManager = this.f27977c;
        if (fragmentManager != null && (baseDialogFragment = this.f27979e) != null) {
            baseDialogFragment.show(fragmentManager, "permission_dialog_tag");
        }
    }
}
