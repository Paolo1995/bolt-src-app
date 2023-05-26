package ee.mtakso.driver.service.modules.emergencyassist;

import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyAssistHelpProviderService.kt */
/* loaded from: classes3.dex */
public final class EmergencyAssistHelpProviderService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f24673b;

    /* renamed from: c  reason: collision with root package name */
    private final EmergencyAssistManager f24674c;

    @Inject
    public EmergencyAssistHelpProviderService(PollerSource pollerSource, EmergencyAssistManager emergencyAssistManager) {
        Intrinsics.f(pollerSource, "pollerSource");
        Intrinsics.f(emergencyAssistManager, "emergencyAssistManager");
        this.f24673b = pollerSource;
        this.f24674c = emergencyAssistManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f24673b.e();
        final EmergencyAssistHelpProviderService$doStart$1 emergencyAssistHelpProviderService$doStart$1 = new Function1<PollingSigned<PollingResult>, String>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistHelpProviderService$doStart$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(PollingSigned<PollingResult> it) {
                Intrinsics.f(it, "it");
                return it.a().d();
            }
        };
        Observable distinctUntilChanged = e8.map(new Function() { // from class: ee.mtakso.driver.service.modules.emergencyassist.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String i8;
                i8 = EmergencyAssistHelpProviderService.i(Function1.this, obj);
                return i8;
            }
        }).distinctUntilChanged();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.service.modules.emergencyassist.EmergencyAssistHelpProviderService$doStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                EmergencyAssistManager emergencyAssistManager;
                emergencyAssistManager = EmergencyAssistHelpProviderService.this.f24674c;
                emergencyAssistManager.A();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Disposable subscribe = distinctUntilChanged.subscribe(new Consumer() { // from class: ee.mtakso.driver.service.modules.emergencyassist.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                EmergencyAssistHelpProviderService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …ged()\n            }\n    }");
        return subscribe;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        super.stop();
        this.f24674c.P();
    }
}
