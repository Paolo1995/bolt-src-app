package ee.mtakso.driver.ui.interactor.score;

import ee.mtakso.driver.network.client.score.DriverScoreClient;
import ee.mtakso.driver.network.client.score.DriverScoreLabel;
import ee.mtakso.driver.network.client.score.DriverScoreResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.DriverScoreAnalytics;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.RetryWithDelaySingle;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScoreManager.kt */
/* loaded from: classes3.dex */
public final class DriverScoreManager {

    /* renamed from: a  reason: collision with root package name */
    private final DriverScoreClient f26846a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f26847b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverScoreAnalytics f26848c;

    /* renamed from: d  reason: collision with root package name */
    private final BehaviorSubject<Optional<DriverScoreItem>> f26849d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f26850e;

    /* renamed from: f  reason: collision with root package name */
    private Disposable f26851f;

    @Inject
    public DriverScoreManager(DriverScoreClient driverScoreClient, DriverProvider driverProvider, DriverScoreAnalytics driverScoreAnalytics) {
        Intrinsics.f(driverScoreClient, "driverScoreClient");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(driverScoreAnalytics, "driverScoreAnalytics");
        this.f26846a = driverScoreClient;
        this.f26847b = driverProvider;
        this.f26848c = driverScoreAnalytics;
        BehaviorSubject<Optional<DriverScoreItem>> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<Optional<DriverScoreItem>>()");
        this.f26849d = e8;
        this.f26850e = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DriverScoreItem k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (DriverScoreItem) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DriverScoreManager this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f26850e.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Single<Optional<DriverScoreItem>> j(boolean z7) {
        if (this.f26847b.q().k() && this.f26847b.n().e()) {
            if (!this.f26850e.getAndSet(true) && (!this.f26849d.h() || z7)) {
                Single F = SingleExtKt.d(this.f26846a.h()).F(new RetryWithDelaySingle(3, 2000L));
                final Function1<DriverScoreResponse, DriverScoreItem> function1 = new Function1<DriverScoreResponse, DriverScoreItem>() { // from class: ee.mtakso.driver.ui.interactor.score.DriverScoreManager$fetchDriverScore$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r1v1 */
                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: b */
                    public final DriverScoreItem invoke(DriverScoreResponse response) {
                        DriverProvider driverProvider;
                        Intrinsics.f(response, "response");
                        driverProvider = DriverScoreManager.this.f26847b;
                        boolean z8 = !driverProvider.w().q();
                        List<DriverScoreLabel> b8 = response.b();
                        Object obj = 0;
                        if (b8 != null) {
                            Iterator it = b8.iterator();
                            if (it.hasNext()) {
                                obj = it.next();
                                if (it.hasNext()) {
                                    int ordinal = ((DriverScoreLabel) obj).b().ordinal();
                                    do {
                                        Object next = it.next();
                                        int ordinal2 = ((DriverScoreLabel) next).b().ordinal();
                                        if (ordinal < ordinal2) {
                                            obj = next;
                                            ordinal = ordinal2;
                                        }
                                    } while (it.hasNext());
                                }
                            }
                            obj = (DriverScoreLabel) obj;
                        }
                        return new DriverScoreItem(response.a(), response.c(), z8, obj);
                    }
                };
                Single x7 = F.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.score.a
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        DriverScoreItem k8;
                        k8 = DriverScoreManager.k(Function1.this, obj);
                        return k8;
                    }
                });
                final DriverScoreManager$fetchDriverScore$2 driverScoreManager$fetchDriverScore$2 = new Function1<DriverScoreItem, Optional<DriverScoreItem>>() { // from class: ee.mtakso.driver.ui.interactor.score.DriverScoreManager$fetchDriverScore$2
                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: b */
                    public final Optional<DriverScoreItem> invoke(DriverScoreItem it) {
                        Intrinsics.f(it, "it");
                        return Optional.f(it);
                    }
                };
                Single x8 = x7.x(new Function() { // from class: ee.mtakso.driver.ui.interactor.score.b
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        Optional l8;
                        l8 = DriverScoreManager.l(Function1.this, obj);
                        return l8;
                    }
                });
                final Function1<Optional<DriverScoreItem>, Unit> function12 = new Function1<Optional<DriverScoreItem>, Unit>() { // from class: ee.mtakso.driver.ui.interactor.score.DriverScoreManager$fetchDriverScore$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void b(Optional<DriverScoreItem> optional) {
                        DriverScoreAnalytics driverScoreAnalytics;
                        DriverScoreItem c8 = optional.c();
                        if (c8 != null) {
                            driverScoreAnalytics = DriverScoreManager.this.f26848c;
                            driverScoreAnalytics.N1(c8.d());
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Optional<DriverScoreItem> optional) {
                        b(optional);
                        return Unit.f50853a;
                    }
                };
                Single j8 = x8.o(new Consumer() { // from class: ee.mtakso.driver.ui.interactor.score.c
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        DriverScoreManager.m(Function1.this, obj);
                    }
                }).j(new Action() { // from class: ee.mtakso.driver.ui.interactor.score.d
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        DriverScoreManager.n(DriverScoreManager.this);
                    }
                });
                final Function1<Optional<DriverScoreItem>, Unit> function13 = new Function1<Optional<DriverScoreItem>, Unit>() { // from class: ee.mtakso.driver.ui.interactor.score.DriverScoreManager$fetchDriverScore$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final void b(Optional<DriverScoreItem> optional) {
                        BehaviorSubject behaviorSubject;
                        behaviorSubject = DriverScoreManager.this.f26849d;
                        behaviorSubject.onNext(optional);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Optional<DriverScoreItem> optional) {
                        b(optional);
                        return Unit.f50853a;
                    }
                };
                Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.interactor.score.e
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        DriverScoreManager.o(Function1.this, obj);
                    }
                };
                final DriverScoreManager$fetchDriverScore$6 driverScoreManager$fetchDriverScore$6 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.interactor.score.DriverScoreManager$fetchDriverScore$6
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.f50853a;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable throwable) {
                        Intrinsics.e(throwable, "throwable");
                        Kalev.e(throwable, "Cannot fetch the driver score");
                    }
                };
                this.f26851f = j8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.interactor.score.f
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        DriverScoreManager.p(Function1.this, obj);
                    }
                });
            }
            Single<Optional<DriverScoreItem>> firstOrError = this.f26849d.firstOrError();
            Intrinsics.e(firstOrError, "driverScoreSubject.firstOrError()");
            return firstOrError;
        }
        Single<Optional<DriverScoreItem>> w7 = Single.w(Optional.a());
        Intrinsics.e(w7, "just(Optional.empty())");
        return w7;
    }
}
