package ee.mtakso.driver.service.auth;

import android.content.Context;
import ee.mtakso.driver.service.auth.AuthManager;
import ee.mtakso.driver.service.auth.AuthStepResult;
import ee.mtakso.driver.ui.screens.launch.LauncherActivity;
import ee.mtakso.driver.utils.flow.Flow;
import ee.mtakso.driver.utils.flow.FlowStep;
import eu.bolt.driver.core.permission.PermissionManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LightAuthFlow.kt */
/* loaded from: classes3.dex */
public final class LightAuthFlow extends Flow<AuthStepResult> {

    /* renamed from: d  reason: collision with root package name */
    private final AuthStepFactory f23724d;

    /* renamed from: e  reason: collision with root package name */
    private final AuthManager f23725e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f23726f;

    /* renamed from: g  reason: collision with root package name */
    private Context f23727g;

    /* renamed from: h  reason: collision with root package name */
    private FlowState f23728h;

    @Inject
    public LightAuthFlow(AuthStepFactory factory, AuthManager authManager) {
        Intrinsics.f(factory, "factory");
        Intrinsics.f(authManager, "authManager");
        this.f23724d = factory;
        this.f23725e = authManager;
        this.f23728h = FlowState.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: s */
    public AuthStepResult.Error e(Throwable throwable) {
        Intrinsics.f(throwable, "throwable");
        return new AuthStepResult.Error(throwable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.utils.flow.Flow
    /* renamed from: t */
    public FlowStep<AuthStepResult> m(AuthStepResult result) {
        Intrinsics.f(result, "result");
        if (result instanceof AuthStepResult.Error) {
            this.f23728h = FlowState.FINISHED;
            Context context = this.f23727g;
            if (context != null) {
                LauncherActivity.f30387y.a(context);
            }
            return null;
        } else if (result instanceof AuthStepResult.LocationPermission) {
            if (((AuthStepResult.LocationPermission) result).a().d() == PermissionManager.PermissionStatus.DENIED) {
                Context context2 = this.f23727g;
                if (context2 != null) {
                    LauncherActivity.f30387y.a(context2);
                }
                this.f23728h = FlowState.FINISHED;
                return null;
            }
            return this.f23724d.g();
        } else {
            if (result instanceof AuthStepResult.DriverConfigurationResult) {
                this.f23725e.v(AuthManager.LoginOption.ByRefreshToken.f23577a);
                g(AuthStepResult.LoginFinished.f23686a);
            } else if (result instanceof AuthStepResult.LoginFinished) {
                this.f23728h = FlowState.FINISHED;
            }
            return null;
        }
    }

    public final void u(Context context) {
        this.f23727g = context;
        FlowState flowState = this.f23728h;
        FlowState flowState2 = FlowState.RUNNING;
        if (flowState == flowState2) {
            return;
        }
        this.f23728h = flowState2;
        Observable<AuthStepResult> k8 = k();
        final LightAuthFlow$start$1 lightAuthFlow$start$1 = new Function1<AuthStepResult, Unit>() { // from class: ee.mtakso.driver.service.auth.LightAuthFlow$start$1
            public final void b(AuthStepResult authStepResult) {
                Kalev.n("event", authStepResult).a("Auth flow event");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthStepResult authStepResult) {
                b(authStepResult);
                return Unit.f50853a;
            }
        };
        Consumer<? super AuthStepResult> consumer = new Consumer() { // from class: ee.mtakso.driver.service.auth.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LightAuthFlow.v(Function1.this, obj);
            }
        };
        final LightAuthFlow$start$2 lightAuthFlow$start$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.auth.LightAuthFlow$start$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Auth flow error");
            }
        };
        this.f23726f = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.auth.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LightAuthFlow.w(Function1.this, obj);
            }
        });
        h(n(this.f23724d.h()));
    }
}
