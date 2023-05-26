package ee.mtakso.driver.ui.interactor.dashboard;

import ee.mtakso.driver.network.client.dashboard.DriverHomeScreenResponse;
import ee.mtakso.driver.service.dashboard.DashboardService;
import ee.mtakso.driver.ui.interactor.dashboard.GetDashboardInteractor;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetDashboardInteractor.kt */
/* loaded from: classes3.dex */
public final class GetDashboardInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DashboardService f26421a;

    @Inject
    public GetDashboardInteractor(DashboardService dashboardService) {
        Intrinsics.f(dashboardService, "dashboardService");
        this.f26421a = dashboardService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GetDashboardInteractor this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f26421a.stop();
    }

    public final Observable<DriverHomeScreenResponse> d() {
        Observable<DriverHomeScreenResponse> c8 = this.f26421a.c();
        final Function1<Disposable, Unit> function1 = new Function1<Disposable, Unit>() { // from class: ee.mtakso.driver.ui.interactor.dashboard.GetDashboardInteractor$observeDashboard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Disposable disposable) {
                DashboardService dashboardService;
                dashboardService = GetDashboardInteractor.this.f26421a;
                dashboardService.start();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Disposable disposable) {
                b(disposable);
                return Unit.f50853a;
            }
        };
        Observable<DriverHomeScreenResponse> doFinally = c8.doOnSubscribe(new Consumer() { // from class: q2.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GetDashboardInteractor.e(Function1.this, obj);
            }
        }).subscribeOn(AndroidSchedulers.a()).observeOn(AndroidSchedulers.a()).doFinally(new Action() { // from class: q2.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                GetDashboardInteractor.f(GetDashboardInteractor.this);
            }
        });
        Intrinsics.e(doFinally, "fun observeDashboard(): …top()\n            }\n    }");
        return doFinally;
    }
}
