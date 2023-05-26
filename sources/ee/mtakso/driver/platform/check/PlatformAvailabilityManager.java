package ee.mtakso.driver.platform.check;

import android.app.Activity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: PlatformAvailabilityManager.kt */
/* loaded from: classes3.dex */
public interface PlatformAvailabilityManager {
    PlatformServicesState a();

    boolean b(PlatformServicesState platformServicesState);

    boolean c(PlatformServicesState platformServicesState);

    void d(Activity activity, PlatformServicesState platformServicesState, int i8, Function0<Unit> function0);
}
