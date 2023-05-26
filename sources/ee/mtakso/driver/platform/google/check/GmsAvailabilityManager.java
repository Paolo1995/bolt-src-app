package ee.mtakso.driver.platform.google.check;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.common.GoogleApiAvailability;
import ee.mtakso.driver.platform.check.PlatformAvailabilityManager;
import ee.mtakso.driver.platform.check.PlatformServicesState;
import ee.mtakso.driver.platform.google.check.GmsAvailabilityManager;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GmsAvailabilityManager.kt */
/* loaded from: classes3.dex */
public final class GmsAvailabilityManager implements PlatformAvailabilityManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23295a;

    @Inject
    public GmsAvailabilityManager(Context context) {
        Intrinsics.f(context, "context");
        this.f23295a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 action, DialogInterface dialogInterface) {
        Intrinsics.f(action, "$action");
        action.invoke();
    }

    @Override // ee.mtakso.driver.platform.check.PlatformAvailabilityManager
    public PlatformServicesState a() {
        return new PlatformServicesState(GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.f23295a));
    }

    @Override // ee.mtakso.driver.platform.check.PlatformAvailabilityManager
    public boolean b(PlatformServicesState state) {
        Intrinsics.f(state, "state");
        return GoogleApiAvailability.getInstance().isUserResolvableError(state.a());
    }

    @Override // ee.mtakso.driver.platform.check.PlatformAvailabilityManager
    public boolean c(PlatformServicesState state) {
        Intrinsics.f(state, "state");
        if (state.a() == 0) {
            return true;
        }
        return false;
    }

    @Override // ee.mtakso.driver.platform.check.PlatformAvailabilityManager
    public void d(Activity activity, PlatformServicesState state, int i8, final Function0<Unit> action) {
        Intrinsics.f(activity, "activity");
        Intrinsics.f(state, "state");
        Intrinsics.f(action, "action");
        GoogleApiAvailability.getInstance().showErrorDialogFragment(activity, state.a(), i8, new DialogInterface.OnCancelListener() { // from class: z1.a
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                GmsAvailabilityManager.f(Function0.this, dialogInterface);
            }
        });
    }
}
