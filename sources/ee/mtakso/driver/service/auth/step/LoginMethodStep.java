package ee.mtakso.driver.service.auth.step;

import ee.mtakso.driver.deeplink.DeepLinkManager;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.utils.flow.FlowStep;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginMethodStep.kt */
/* loaded from: classes3.dex */
public final class LoginMethodStep implements FlowStep<AuthStepResult> {

    /* renamed from: a  reason: collision with root package name */
    private final DeviceSettings f23844a;

    /* renamed from: b  reason: collision with root package name */
    private final DeepLinkManager f23845b;

    @Inject
    public LoginMethodStep(DeviceSettings deviceSettings, DeepLinkManager deepLinkManager) {
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(deepLinkManager, "deepLinkManager");
        this.f23844a = deviceSettings;
        this.f23845b = deepLinkManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthStepResult b(LoginMethodStep this$0) {
        Intrinsics.f(this$0, "this$0");
        return this$0.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final ee.mtakso.driver.service.auth.AuthStepResult c() {
        /*
            r3 = this;
            ee.mtakso.driver.param.DeviceSettings r0 = r3.f23844a
            java.lang.String r0 = r0.l()
            ee.mtakso.driver.deeplink.DeepLinkManager r1 = r3.f23845b
            java.lang.Class<ee.mtakso.driver.deeplink.DeeplinkCall$MagicLogin> r2 = ee.mtakso.driver.deeplink.DeeplinkCall.MagicLogin.class
            boolean r1 = r1.f(r2)
            if (r1 == 0) goto L22
            if (r0 == 0) goto L1a
            ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod r0 = new ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod
            ee.mtakso.driver.service.auth.LoginWay r1 = ee.mtakso.driver.service.auth.LoginWay.BY_MAGIC_WITH_LOGOUT
            r0.<init>(r1)
            return r0
        L1a:
            ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod r0 = new ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod
            ee.mtakso.driver.service.auth.LoginWay r1 = ee.mtakso.driver.service.auth.LoginWay.BY_MAGIC
            r0.<init>(r1)
            return r0
        L22:
            if (r0 == 0) goto L2d
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L2b
            goto L2d
        L2b:
            r0 = 0
            goto L2e
        L2d:
            r0 = 1
        L2e:
            if (r0 != 0) goto L38
            ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod r0 = new ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod
            ee.mtakso.driver.service.auth.LoginWay r1 = ee.mtakso.driver.service.auth.LoginWay.BY_REFRESH
            r0.<init>(r1)
            return r0
        L38:
            ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod r0 = new ee.mtakso.driver.service.auth.AuthStepResult$LoginMethod
            ee.mtakso.driver.service.auth.LoginWay r1 = ee.mtakso.driver.service.auth.LoginWay.BY_PASSWORD
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.service.auth.step.LoginMethodStep.c():ee.mtakso.driver.service.auth.AuthStepResult");
    }

    @Override // ee.mtakso.driver.utils.flow.FlowStep
    public Observable<AuthStepResult> call() {
        Observable<AuthStepResult> mergeWith = Observable.just(new AuthStepResult.Message("Logging in...")).mergeWith(Single.u(new Callable() { // from class: ee.mtakso.driver.service.auth.step.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                AuthStepResult b8;
                b8 = LoginMethodStep.b(LoginMethodStep.this);
                return b8;
            }
        }));
        Intrinsics.e(mergeWith, "just<AuthStepResult>(Aut…lable { loginMethod() } )");
        return mergeWith;
    }
}
