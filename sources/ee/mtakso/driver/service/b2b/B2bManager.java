package ee.mtakso.driver.service.b2b;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.order.DriverOrderClient;
import ee.mtakso.driver.network.response.EmptyServerResponse;
import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import ee.mtakso.driver.service.b2b.B2bManager;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: B2bManager.kt */
/* loaded from: classes3.dex */
public final class B2bManager {

    /* renamed from: k  reason: collision with root package name */
    private static final Companion f23924k = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f23925a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderAnalytics f23926b;

    /* renamed from: c  reason: collision with root package name */
    private final TrueTimeProvider f23927c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverOrderClient f23928d;

    /* renamed from: e  reason: collision with root package name */
    private final BehaviorSubject<Boolean> f23929e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f23930f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f23931g;

    /* renamed from: h  reason: collision with root package name */
    private Long f23932h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f23933i;

    /* renamed from: j  reason: collision with root package name */
    private final List<CurrentAndB2bHandles> f23934j;

    /* compiled from: B2bManager.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public B2bManager(DriverClient driverApiClient, OrderAnalytics orderAnalytics, TrueTimeProvider trueTimeProvider, DriverOrderClient driverOrderClient) {
        Intrinsics.f(driverApiClient, "driverApiClient");
        Intrinsics.f(orderAnalytics, "orderAnalytics");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(driverOrderClient, "driverOrderClient");
        this.f23925a = driverApiClient;
        this.f23926b = orderAnalytics;
        this.f23927c = trueTimeProvider;
        this.f23928d = driverOrderClient;
        BehaviorSubject<Boolean> f8 = BehaviorSubject.f(Boolean.FALSE);
        Intrinsics.e(f8, "createDefault(false)");
        this.f23929e = f8;
        this.f23930f = new AtomicInteger(0);
        this.f23934j = new ArrayList();
    }

    private final void i(CurrentAndB2bHandles currentAndB2bHandles, Boolean bool, Boolean bool2) {
        long j8;
        this.f23934j.add(currentAndB2bHandles);
        Kalev.k("Got unexpected b2b order: " + currentAndB2bHandles + ". b2b state: { sent: " + bool + " received " + bool2 + "}");
        OrderAnalytics orderAnalytics = this.f23926b;
        OrderHandle b8 = currentAndB2bHandles.b();
        OrderHandle a8 = currentAndB2bHandles.a();
        Long l8 = this.f23932h;
        if (l8 != null) {
            j8 = l8.longValue();
        } else {
            j8 = -1;
        }
        orderAnalytics.R3(b8, a8, bool2, j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Completable e(long j8) {
        return this.f23928d.b(j8);
    }

    public final Boolean f() {
        return this.f23933i;
    }

    public final void g(OrderHandle currentOrderHandle, OrderHandle b2bOrderHandle) {
        Intrinsics.f(currentOrderHandle, "currentOrderHandle");
        Intrinsics.f(b2bOrderHandle, "b2bOrderHandle");
        CurrentAndB2bHandles currentAndB2bHandles = new CurrentAndB2bHandles(currentOrderHandle, b2bOrderHandle);
        Boolean bool = this.f23931g;
        Boolean bool2 = this.f23933i;
        if (this.f23934j.contains(currentAndB2bHandles)) {
            Kalev.k("This pair already processed");
        } else if (!Intrinsics.a(bool, Boolean.FALSE)) {
            Kalev.k("Got B2B in expected state.");
        } else {
            i(currentAndB2bHandles, bool, bool2);
        }
    }

    public final void h(Boolean bool) {
        this.f23933i = bool;
        if (bool != null && !Intrinsics.a(this.f23929e.g(), bool) && this.f23930f.decrementAndGet() <= 0) {
            this.f23929e.onNext(bool);
            this.f23930f.set(1);
        }
    }

    public final Completable j(final boolean z7) {
        Single<EmptyServerResponse> y7 = this.f23925a.y(z7);
        final Function1<EmptyServerResponse, Unit> function1 = new Function1<EmptyServerResponse, Unit>() { // from class: ee.mtakso.driver.service.b2b.B2bManager$setBack2BackOrderAcceptance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(EmptyServerResponse emptyServerResponse) {
                TrueTimeProvider trueTimeProvider;
                B2bManager.this.f23931g = Boolean.valueOf(z7);
                B2bManager b2bManager = B2bManager.this;
                trueTimeProvider = b2bManager.f23927c;
                b2bManager.f23932h = Long.valueOf(trueTimeProvider.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EmptyServerResponse emptyServerResponse) {
                b(emptyServerResponse);
                return Unit.f50853a;
            }
        };
        Completable v7 = y7.o(new Consumer() { // from class: d2.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                B2bManager.k(Function1.this, obj);
            }
        }).v();
        Intrinsics.e(v7, "fun setBack2BackOrderAcc…   .ignoreElement()\n    }");
        return v7;
    }
}
