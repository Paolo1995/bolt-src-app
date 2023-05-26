package ee.mtakso.driver.utils.urlcomand;

import android.annotation.SuppressLint;
import ee.mtakso.driver.ui.screens.settings.MagicLinkInteractor;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import eu.bolt.driver.core.ui.routing.Coordinator;
import eu.bolt.driver.core.ui.routing.command.RoutingCommand;
import eu.bolt.driver.core.util.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPortalUrlCoordinator.kt */
@Singleton
/* loaded from: classes5.dex */
public final class DriverPortalUrlCoordinator implements Coordinator {

    /* renamed from: f  reason: collision with root package name */
    private final CompositeUrlLauncher f36471f;

    /* renamed from: g  reason: collision with root package name */
    private final MagicLinkInteractor f36472g;

    @Inject
    public DriverPortalUrlCoordinator(CompositeUrlLauncher urlLauncher, MagicLinkInteractor magicLinkInteractor) {
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(magicLinkInteractor, "magicLinkInteractor");
        this.f36471f = urlLauncher;
        this.f36472g = magicLinkInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.core.ui.routing.Coordinator
    @SuppressLint({"CheckResult"})
    public boolean b(RoutingCommand command) {
        Intrinsics.f(command, "command");
        if (!(command instanceof DriverPortalUrlRoutingCommand)) {
            return false;
        }
        Single a8 = SingleExtKt.a(this.f36472g.d(((DriverPortalUrlRoutingCommand) command).c()));
        final DriverPortalUrlCoordinator$processCommand$1 driverPortalUrlCoordinator$processCommand$1 = new DriverPortalUrlCoordinator$processCommand$1(this.f36471f);
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.utils.urlcomand.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverPortalUrlCoordinator.d(Function1.this, obj);
            }
        };
        final DriverPortalUrlCoordinator$processCommand$2 driverPortalUrlCoordinator$processCommand$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.utils.urlcomand.DriverPortalUrlCoordinator$processCommand$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Error fetching DP token");
            }
        };
        a8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.utils.urlcomand.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DriverPortalUrlCoordinator.e(Function1.this, obj);
            }
        });
        return true;
    }
}
