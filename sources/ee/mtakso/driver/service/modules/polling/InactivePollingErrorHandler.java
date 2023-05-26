package ee.mtakso.driver.service.modules.polling;

import android.app.Activity;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.ui.screens.SimpleActivity;
import ee.mtakso.driver.ui.screens.home.v3.HomeFragment;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import ee.mtakso.driver.ui.screens.login.v2.LoginActivity;
import ee.mtakso.driver.ui.screens.order.incoming.v2.IncomingOrderActivity;
import ee.mtakso.driver.ui.screens.order.v2.ActiveRideActivity;
import ee.mtakso.driver.utils.ext.ApiExceptionUtils;
import eu.bolt.driver.core.ui.routing.RoutingCommand;
import eu.bolt.driver.core.ui.routing.RoutingManager;
import eu.bolt.driver.core.ui.routing.state.RoutingState;
import eu.bolt.kalev.Kalev;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InactivePollingErrorHandler.kt */
/* loaded from: classes3.dex */
public final class InactivePollingErrorHandler implements Consumer<Throwable> {

    /* renamed from: f  reason: collision with root package name */
    private final AuthManager f25096f;

    /* renamed from: g  reason: collision with root package name */
    private final RoutingManager f25097g;

    @Inject
    public InactivePollingErrorHandler(AuthManager authManager, RoutingManager routingManager) {
        Intrinsics.f(authManager, "authManager");
        Intrinsics.f(routingManager, "routingManager");
        this.f25096f = authManager;
        this.f25097g = routingManager;
    }

    @Override // io.reactivex.functions.Consumer
    /* renamed from: a */
    public void accept(Throwable throwable) {
        Class<? extends Activity> cls;
        boolean a8;
        boolean a9;
        Intrinsics.f(throwable, "throwable");
        Kalev.e(throwable, "Polling unsuccessful, " + throwable.getMessage());
        if (ApiExceptionUtils.m(throwable, 22, 23)) {
            this.f25096f.q();
            return;
        }
        boolean z7 = true;
        if (!ApiExceptionUtils.m(throwable, 503) && !(throwable instanceof IllegalStateException)) {
            RoutingState f8 = this.f25097g.f();
            if (f8 != null) {
                cls = f8.a();
            } else {
                cls = null;
            }
            if (Intrinsics.a(cls, IncomingOrderActivity.class)) {
                a8 = true;
            } else {
                a8 = Intrinsics.a(cls, ActiveRideActivity.class);
            }
            if (a8) {
                a9 = true;
            } else {
                a9 = Intrinsics.a(cls, LauncherActivity.class);
            }
            if (!a9) {
                z7 = Intrinsics.a(cls, LoginActivity.class);
            }
            if (!z7) {
                return;
            }
            RoutingManager.d(this.f25097g, new RoutingCommand.ActivityClass(new RoutingState(SimpleActivity.class, null, 2, null), SimpleActivity.class, SimpleActivity.Companion.d(SimpleActivity.f27004l, HomeFragment.class, null, false, 6, null), 536870912), false, 2, null);
        }
    }
}
