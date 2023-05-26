package ee.mtakso.driver.service.modules.reminder;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.modules.distance.OrderWithDistance;
import ee.mtakso.driver.service.modules.distance.OrderWithOptionalDistance;
import ee.mtakso.driver.service.modules.distance.OrderWithOptionalDistanceKt;
import ee.mtakso.driver.service.modules.distance.UpcomingStopDistanceService;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetailsKt;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.RxUtils;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoReminderImpl.kt */
/* loaded from: classes3.dex */
public final class AutoReminderImpl implements AutoReminder {

    /* renamed from: a  reason: collision with root package name */
    private final UpcomingStopDistanceService f25196a;

    /* renamed from: b  reason: collision with root package name */
    private OrderHandle f25197b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25198c;

    /* renamed from: d  reason: collision with root package name */
    private CompositeDisposable f25199d;

    /* renamed from: e  reason: collision with root package name */
    private final PublishSubject<Boolean> f25200e;

    @Inject
    public AutoReminderImpl(UpcomingStopDistanceService distanceService) {
        Intrinsics.f(distanceService, "distanceService");
        this.f25196a = distanceService;
        PublishSubject<Boolean> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Boolean>()");
        this.f25200e = e8;
    }

    private final boolean n(OrderHandle orderHandle) {
        if (orderHandle != null && !Intrinsics.a(orderHandle, this.f25197b)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o(OrderWithDistance orderWithDistance) {
        ActiveOrderDetails b8 = orderWithDistance.b();
        if (OrderDetailsKt.a(b8, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) && b8.l() > b8.i().B() && orderWithDistance.a() > 300.0d) {
            return !n(b8.a());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OrderHandle s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (OrderHandle) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.modules.reminder.AutoReminder
    public Observable<Boolean> d() {
        return this.f25200e;
    }

    public void p() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<OrderWithOptionalDistance> c8 = this.f25196a.c();
        final AutoReminderImpl$startOrderAutoReminder$1$1 autoReminderImpl$startOrderAutoReminder$1$1 = new Function1<OrderWithOptionalDistance, Optional<OrderWithDistance>>() { // from class: ee.mtakso.driver.service.modules.reminder.AutoReminderImpl$startOrderAutoReminder$1$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderWithDistance> invoke(OrderWithOptionalDistance it) {
                Intrinsics.f(it, "it");
                return OrderWithOptionalDistanceKt.a(it);
            }
        };
        Observable<R> map = c8.map(new Function() { // from class: ee.mtakso.driver.service.modules.reminder.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional q8;
                q8 = AutoReminderImpl.q(Function1.this, obj);
                return q8;
            }
        });
        Intrinsics.e(map, "distanceService.observeR…t.toOrderWithDistance() }");
        Observable h8 = ObservableExtKt.h(map);
        final Function1<OrderWithDistance, Boolean> function1 = new Function1<OrderWithDistance, Boolean>() { // from class: ee.mtakso.driver.service.modules.reminder.AutoReminderImpl$startOrderAutoReminder$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(OrderWithDistance it) {
                boolean o8;
                Intrinsics.f(it, "it");
                o8 = AutoReminderImpl.this.o(it);
                return Boolean.valueOf(o8);
            }
        };
        Observable distinctUntilChanged = h8.filter(new Predicate() { // from class: ee.mtakso.driver.service.modules.reminder.b
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean r7;
                r7 = AutoReminderImpl.r(Function1.this, obj);
                return r7;
            }
        }).distinctUntilChanged();
        final AutoReminderImpl$startOrderAutoReminder$1$3 autoReminderImpl$startOrderAutoReminder$1$3 = new Function1<OrderWithDistance, OrderHandle>() { // from class: ee.mtakso.driver.service.modules.reminder.AutoReminderImpl$startOrderAutoReminder$1$3
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final OrderHandle invoke(OrderWithDistance orderWithDistance) {
                Intrinsics.f(orderWithDistance, "orderWithDistance");
                return orderWithDistance.b().a();
            }
        };
        Observable map2 = distinctUntilChanged.map(new Function() { // from class: ee.mtakso.driver.service.modules.reminder.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderHandle s7;
                s7 = AutoReminderImpl.s(Function1.this, obj);
                return s7;
            }
        });
        final Function1<OrderHandle, Unit> function12 = new Function1<OrderHandle, Unit>() { // from class: ee.mtakso.driver.service.modules.reminder.AutoReminderImpl$startOrderAutoReminder$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OrderHandle orderHandle) {
                PublishSubject publishSubject;
                AutoReminderImpl.this.f25198c = true;
                AutoReminderImpl.this.f25197b = orderHandle;
                publishSubject = AutoReminderImpl.this.f25200e;
                publishSubject.onNext(Boolean.TRUE);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OrderHandle orderHandle) {
                b(orderHandle);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.reminder.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoReminderImpl.t(Function1.this, obj);
            }
        };
        final AutoReminderImpl$startOrderAutoReminder$1$5 autoReminderImpl$startOrderAutoReminder$1$5 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.reminder.AutoReminderImpl$startOrderAutoReminder$1$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to subscribe Auto Reminder!");
            }
        };
        compositeDisposable.b(map2.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.reminder.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AutoReminderImpl.u(Function1.this, obj);
            }
        }));
        this.f25199d = compositeDisposable;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        p();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        v();
    }

    public void v() {
        RxUtils.d(this.f25199d);
    }
}
