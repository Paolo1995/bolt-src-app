package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreLoginTargetingStep.kt */
/* loaded from: classes3.dex */
public final class PreLoginTargetingStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final AnonymousAuthClient f23864a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceSettings f23865b;

    public PreLoginTargetingStep(AnonymousAuthClient client, DeviceSettings deviceSettings) {
        Intrinsics.f(client, "client");
        Intrinsics.f(deviceSettings, "deviceSettings");
        this.f23864a = client;
        this.f23865b = deviceSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult.PreLoginTargeting b(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AuthStepResult.PreLoginTargeting) tmp0.invoke(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    @Override // ee.mtakso.driver.utils.flow.FlowStep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.reactivex.Observable<ee.mtakso.driver.service.auth.AuthStepResult> call() {
        /*
            r5 = this;
            ee.mtakso.driver.param.DeviceSettings r0 = r5.f23865b
            java.lang.String r0 = r0.l()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L13
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L11
            goto L13
        L11:
            r0 = 0
            goto L14
        L13:
            r0 = 1
        L14:
            if (r0 != 0) goto L30
            r0 = 2
            ee.mtakso.driver.service.auth.AuthStepResult[] r0 = new ee.mtakso.driver.service.auth.AuthStepResult[r0]
            ee.mtakso.driver.service.auth.AuthStepResult$Message r3 = new ee.mtakso.driver.service.auth.AuthStepResult$Message
            java.lang.String r4 = "Driver is logged in - skip loading pre-login targeting..."
            r3.<init>(r4)
            r0[r1] = r3
            ee.mtakso.driver.service.auth.AuthStepResult$DeviceTargetingSaved r1 = ee.mtakso.driver.service.auth.AuthStepResult.DeviceTargetingSaved.f23681a
            r0[r2] = r1
            io.reactivex.Observable r0 = io.reactivex.Observable.fromArray(r0)
            java.lang.String r1 = "{\n            Observable…d\n            )\n        }"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            goto L66
        L30:
            ee.mtakso.driver.service.auth.AuthStepResult$Message r0 = new ee.mtakso.driver.service.auth.AuthStepResult$Message
            java.lang.String r1 = "Loading pre-login targeting..."
            r0.<init>(r1)
            io.reactivex.Observable r0 = io.reactivex.Observable.just(r0)
            ee.mtakso.driver.network.client.auth.anonymous.AnonymousAuthClient r1 = r5.f23864a
            io.reactivex.Single r1 = r1.E()
            ee.mtakso.driver.network.client.targeting.TargetingParameters r2 = new ee.mtakso.driver.network.client.targeting.TargetingParameters
            java.util.Map r3 = kotlin.collections.MapsKt.f()
            r2.<init>(r3)
            io.reactivex.Single r1 = r1.D(r2)
            ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1 r2 = new kotlin.jvm.functions.Function1<ee.mtakso.driver.network.client.targeting.TargetingParameters, ee.mtakso.driver.service.auth.AuthStepResult.PreLoginTargeting>() { // from class: ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1
                static {
                    /*
                        ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1 r0 = new ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1) ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1.f ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ee.mtakso.driver.service.auth.AuthStepResult.PreLoginTargeting invoke(ee.mtakso.driver.network.client.targeting.TargetingParameters r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.f(r2, r0)
                        ee.mtakso.driver.service.auth.AuthStepResult$PreLoginTargeting r0 = new ee.mtakso.driver.service.auth.AuthStepResult$PreLoginTargeting
                        r0.<init>(r2)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1.invoke(ee.mtakso.driver.network.client.targeting.TargetingParameters):ee.mtakso.driver.service.auth.AuthStepResult$PreLoginTargeting");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ ee.mtakso.driver.service.auth.AuthStepResult.PreLoginTargeting invoke(ee.mtakso.driver.network.client.targeting.TargetingParameters r1) {
                    /*
                        r0 = this;
                        ee.mtakso.driver.network.client.targeting.TargetingParameters r1 = (ee.mtakso.driver.network.client.targeting.TargetingParameters) r1
                        ee.mtakso.driver.service.auth.AuthStepResult$PreLoginTargeting r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.auth.step.PreLoginTargetingStep$call$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
            ee.mtakso.driver.service.auth.step.b0 r3 = new ee.mtakso.driver.service.auth.step.b0
            r3.<init>()
            io.reactivex.Single r1 = r1.x(r3)
            io.reactivex.Observable r0 = r0.mergeWith(r1)
            java.lang.String r1 = "just<AuthStepResult>(Aut…g(it) }\n                )"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            io.reactivex.Observable r0 = ee.mtakso.driver.utils.ObservableExtKt.g(r0)
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.auth.step.PreLoginTargetingStep.call():io.reactivex.Observable");
    }
}
