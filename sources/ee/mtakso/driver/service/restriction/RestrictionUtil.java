package ee.mtakso.driver.service.restriction;

import ee.mtakso.driver.network.client.device.DriverAppDisabledReason;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RestrictionUtill.kt */
/* loaded from: classes3.dex */
public final class RestrictionUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final RestrictionUtil f25859a = new RestrictionUtil();

    private RestrictionUtil() {
    }

    public final boolean a(DriverAppDisabledReason appDisabledReason) {
        Intrinsics.f(appDisabledReason, "appDisabledReason");
        if (appDisabledReason != DriverAppDisabledReason.VERIFICATION_DEBUGGABLE_APP && appDisabledReason != DriverAppDisabledReason.VERIFICATION_PACKAGE_NAME && appDisabledReason != DriverAppDisabledReason.VERIFICATION_INSTALLER && appDisabledReason != DriverAppDisabledReason.VERIFICATION_SIGNATURE) {
            return false;
        }
        return true;
    }
}
