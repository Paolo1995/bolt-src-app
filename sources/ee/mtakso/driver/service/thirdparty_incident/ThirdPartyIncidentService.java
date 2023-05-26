package ee.mtakso.driver.service.thirdparty_incident;

import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.param.DriverSettings;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;

/* compiled from: ThirdPartyIncidentService.kt */
/* loaded from: classes3.dex */
public final class ThirdPartyIncidentService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final EmergencyAssistManager f26007b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverSettings f26008c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverProvider f26009d;

    @Inject
    public ThirdPartyIncidentService(EmergencyAssistManager emergencyAssistManager, DriverSettings driverSettings, DriverProvider driverProvider) {
        Intrinsics.f(emergencyAssistManager, "emergencyAssistManager");
        Intrinsics.f(driverSettings, "driverSettings");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f26007b = emergencyAssistManager;
        this.f26008c = driverSettings;
        this.f26009d = driverProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        Observable<Boolean> distinctUntilChanged = this.f26007b.y().distinctUntilChanged();
        final Function1<Boolean, Boolean> function1 = new Function1<Boolean, Boolean>() { // from class: ee.mtakso.driver.service.thirdparty_incident.ThirdPartyIncidentService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Boolean it) {
                DriverSettings driverSettings;
                boolean z7;
                DriverProvider driverProvider;
                Intrinsics.f(it, "it");
                Ref$LongRef ref$LongRef2 = Ref$LongRef.this;
                driverSettings = this.f26008c;
                ref$LongRef2.f51015f = driverSettings.b();
                if (it.booleanValue() && Ref$LongRef.this.f51015f != 0) {
                    driverProvider = this.f26009d;
                    if (driverProvider.q().J()) {
                        z7 = true;
                        return Boolean.valueOf(z7);
                    }
                }
                z7 = false;
                return Boolean.valueOf(z7);
            }
        };
        Observable<Boolean> filter = distinctUntilChanged.filter(new Predicate() { // from class: ee.mtakso.driver.service.thirdparty_incident.a
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean l8;
                l8 = ThirdPartyIncidentService.l(Function1.this, obj);
                return l8;
            }
        });
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: ee.mtakso.driver.service.thirdparty_incident.ThirdPartyIncidentService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Boolean bool) {
                EmergencyAssistManager emergencyAssistManager;
                emergencyAssistManager = ThirdPartyIncidentService.this.f26007b;
                emergencyAssistManager.J(ref$LongRef.f51015f);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                b(bool);
                return Unit.f50853a;
            }
        };
        Consumer<? super Boolean> consumer = new Consumer() { // from class: ee.mtakso.driver.service.thirdparty_incident.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ThirdPartyIncidentService.m(Function1.this, obj);
            }
        };
        final ThirdPartyIncidentService$doStart$3 thirdPartyIncidentService$doStart$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.thirdparty_incident.ThirdPartyIncidentService$doStart$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Kalev.d("Exception in ThirdPartyIncidentService");
            }
        };
        Disposable subscribe = filter.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.thirdparty_incident.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ThirdPartyIncidentService.n(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …\") }\n            )\n\n    }");
        return subscribe;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        this.f26007b.r();
    }
}
