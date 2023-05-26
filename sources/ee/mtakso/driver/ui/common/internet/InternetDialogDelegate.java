package ee.mtakso.driver.ui.common.internet;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import ee.mtakso.driver.R;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InternetDialogDelegate.kt */
/* loaded from: classes3.dex */
public final class InternetDialogDelegate {

    /* renamed from: a  reason: collision with root package name */
    private NetworkConnectionStatus f26372a = NetworkConnectionStatus.UNDEFINED;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f26373b;

    /* compiled from: InternetDialogDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26374a;

        static {
            int[] iArr = new int[NetworkConnectionStatus.values().length];
            try {
                iArr[NetworkConnectionStatus.CONNECTION_ISSUES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkConnectionStatus.INTERNET_NOT_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkConnectionStatus.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f26374a = iArr;
        }
    }

    private final void d() {
        Dialog dialog = this.f26373b;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f26373b = null;
    }

    private final void f(final Activity activity) {
        d();
        AlertDialog a8 = new AlertDialog.Builder(activity).d(false).f(R.drawable.ic_planet).l(R.string.settings_uppercase, new DialogInterface.OnClickListener() { // from class: ee.mtakso.driver.ui.common.internet.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i8) {
                InternetDialogDelegate.g(activity, dialogInterface, i8);
            }
        }).j(R.string.ok_lowercase, new DialogInterface.OnClickListener() { // from class: ee.mtakso.driver.ui.common.internet.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i8) {
                InternetDialogDelegate.h(dialogInterface, i8);
            }
        }).n(R.string.network_disabled).h(R.string.network_disabled_desc).a();
        a8.show();
        this.f26373b = a8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Activity activity, DialogInterface dialogInterface, int i8) {
        Intrinsics.f(activity, "$activity");
        dialogInterface.dismiss();
        Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
        intent.addFlags(335544320);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DialogInterface dialogInterface, int i8) {
        dialogInterface.dismiss();
    }

    private final void i(Activity activity) {
        d();
        AlertDialog a8 = new AlertDialog.Builder(activity).d(false).f(R.drawable.ic_planet).n(R.string.noConnection).h(R.string.no_internet_desc).j(R.string.ok_lowercase, new DialogInterface.OnClickListener() { // from class: ee.mtakso.driver.ui.common.internet.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i8) {
                InternetDialogDelegate.j(dialogInterface, i8);
            }
        }).a();
        a8.show();
        this.f26373b = a8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DialogInterface dialogInterface, int i8) {
        dialogInterface.dismiss();
    }

    private final void k(NetworkConnectionStatus networkConnectionStatus, NetworkConnectionStatus networkConnectionStatus2, Activity activity) {
        if (networkConnectionStatus == networkConnectionStatus2) {
            return;
        }
        int i8 = WhenMappings.f26374a[networkConnectionStatus2.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    d();
                    return;
                }
                return;
            }
            f(activity);
            return;
        }
        i(activity);
    }

    public final void e(NetworkConnectionStatus status, Activity activity) {
        Intrinsics.f(status, "status");
        Intrinsics.f(activity, "activity");
        k(this.f26372a, status, activity);
    }
}
