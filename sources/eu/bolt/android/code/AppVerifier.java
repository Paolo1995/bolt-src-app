package eu.bolt.android.code;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AppVerifier.kt */
/* loaded from: classes5.dex */
public final class AppVerifier {

    /* renamed from: a  reason: collision with root package name */
    public static final AppVerifier f36733a = new AppVerifier();

    private AppVerifier() {
    }

    private final boolean a(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static final AppVerificationStatus b(Context context, String flavor, String buildType) {
        boolean O;
        boolean O2;
        Intrinsics.f(context, "context");
        Intrinsics.f(flavor, "flavor");
        Intrinsics.f(buildType, "buildType");
        O = StringsKt__StringsKt.O(flavor, "prelive", true);
        if (!O) {
            O2 = StringsKt__StringsKt.O(buildType, "smoketest", true);
            if (!O2) {
                AppVerifier appVerifier = f36733a;
                if (!appVerifier.c(context)) {
                    return AppVerificationStatus.PACKAGE_NAME_FAILED;
                }
                if (!appVerifier.d(context)) {
                    return AppVerificationStatus.SIGNATURE_FAILED;
                }
                if (!appVerifier.e(context)) {
                    return AppVerificationStatus.INSTALLER_FAILED;
                }
                if (appVerifier.a(context)) {
                    return AppVerificationStatus.DEBUGGABLE_FAILED;
                }
                return AppVerificationStatus.VERIFIED;
            }
        }
        return AppVerificationStatus.VERIFIED;
    }

    private final boolean c(Context context) {
        return Intrinsics.a(context.getPackageName(), "ee.mtakso.driver");
    }

    private final boolean d(Context context) {
        return true;
    }

    private final boolean e(Context context) {
        boolean L;
        boolean L2;
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName != null) {
            L = StringsKt__StringsJVMKt.L(installerPackageName, "com.android.vending", false, 2, null);
            if (!L) {
                L2 = StringsKt__StringsJVMKt.L(installerPackageName, "com.huawei.appmarket", false, 2, null);
                if (!L2) {
                    return false;
                }
            }
        }
        return true;
    }
}
