package ee.mtakso.driver.service.deeplinks;

import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.service.earnings.EarningsManager;
import ee.mtakso.driver.service.order.ScheduledOrderManager;
import ee.mtakso.driver.service.restriction.DriverTrainingRestrictionManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExecutableDeeplinkManager.kt */
/* loaded from: classes3.dex */
public final class ExecutableDeeplinkManager {

    /* renamed from: a  reason: collision with root package name */
    private final DeepLinkManager f24276a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledOrderManager f24277b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverTrainingRestrictionManager f24278c;

    /* renamed from: d  reason: collision with root package name */
    private final EarningsManager f24279d;

    @Inject
    public ExecutableDeeplinkManager(DeepLinkManager deeplinkManager, ScheduledOrderManager scheduledOrderManager, DriverTrainingRestrictionManager driverTrainingRestrictionManager, EarningsManager earningsManager) {
        Intrinsics.f(deeplinkManager, "deeplinkManager");
        Intrinsics.f(scheduledOrderManager, "scheduledOrderManager");
        Intrinsics.f(driverTrainingRestrictionManager, "driverTrainingRestrictionManager");
        Intrinsics.f(earningsManager, "earningsManager");
        this.f24276a = deeplinkManager;
        this.f24277b = scheduledOrderManager;
        this.f24278c = driverTrainingRestrictionManager;
        this.f24279d = earningsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        Kalev.b("Earnings goal's kept");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final boolean c(DeeplinkCall call) {
        Intrinsics.f(call, "call");
        boolean z7 = true;
        if (call instanceof DeeplinkCall.RideStartDriving) {
            this.f24277b.j(((DeeplinkCall.RideStartDriving) call).b());
        } else if (call instanceof DeeplinkCall.TrainingShow) {
            this.f24278c.a();
        } else if (call instanceof DeeplinkCall.EarningsGoalKeep) {
            Completable i8 = this.f24279d.i();
            Action action = new Action() { // from class: ee.mtakso.driver.service.deeplinks.a
                @Override // io.reactivex.functions.Action
                public final void run() {
                    ExecutableDeeplinkManager.d();
                }
            };
            final ExecutableDeeplinkManager$dispatch$consumed$2 executableDeeplinkManager$dispatch$consumed$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.deeplinks.ExecutableDeeplinkManager$dispatch$consumed$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to keep earnings goal");
                }
            };
            i8.G(action, new Consumer() { // from class: ee.mtakso.driver.service.deeplinks.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ExecutableDeeplinkManager.e(Function1.this, obj);
                }
            });
        } else {
            z7 = false;
        }
        if (z7) {
            this.f24276a.b(call);
        }
        return z7;
    }
}
