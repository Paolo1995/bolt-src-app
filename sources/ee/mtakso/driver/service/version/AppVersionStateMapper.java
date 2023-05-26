package ee.mtakso.driver.service.version;

import ee.mtakso.driver.service.auth.AppVersionState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppVersionStateMapper.kt */
/* loaded from: classes3.dex */
public final class AppVersionStateMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final AppVersionStateMapper f26098a = new AppVersionStateMapper();

    private AppVersionStateMapper() {
    }

    public final AppVersionState a(String appVersionState) {
        Intrinsics.f(appVersionState, "appVersionState");
        int hashCode = appVersionState.hashCode();
        if (hashCode != -1632344653) {
            if (hashCode != 3548) {
                if (hashCode != 270940796) {
                    if (hashCode == 1959784951 && appVersionState.equals("invalid")) {
                        return AppVersionState.INVALID;
                    }
                } else if (appVersionState.equals("disabled")) {
                    return AppVersionState.DISABLED;
                }
            } else if (appVersionState.equals("ok")) {
                return AppVersionState.OK;
            }
        } else if (appVersionState.equals("deprecated")) {
            return AppVersionState.DEPRECATED;
        }
        return AppVersionState.INVALID;
    }
}
