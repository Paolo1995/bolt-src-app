package ee.mtakso.driver.ui.notification;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.BaseServiceImpl;
import ee.mtakso.driver.service.modules.polling.PollingSigned;
import ee.mtakso.driver.service.pollerv2.PollerSource;
import ee.mtakso.driver.service.push.PushType;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationCleanerService.kt */
/* loaded from: classes3.dex */
public final class NotificationCleanerService extends BaseServiceImpl {

    /* renamed from: b  reason: collision with root package name */
    private final PollerSource f26967b;

    /* renamed from: c  reason: collision with root package name */
    private final UiNotificationManager f26968c;

    @Inject
    public NotificationCleanerService(PollerSource poller, UiNotificationManager notificationManager) {
        Intrinsics.f(poller, "poller");
        Intrinsics.f(notificationManager, "notificationManager");
        this.f26967b = poller;
        this.f26968c = notificationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(PollingResult pollingResult) {
        Object next;
        List<OrderSummary> j8 = pollingResult.j();
        OrderState orderState = null;
        if (j8 != null) {
            Iterator<T> it = j8.iterator();
            if (!it.hasNext()) {
                next = null;
            } else {
                next = it.next();
                if (it.hasNext()) {
                    int priority = ((OrderSummary) next).f().getPriority();
                    do {
                        Object next2 = it.next();
                        int priority2 = ((OrderSummary) next2).f().getPriority();
                        if (priority > priority2) {
                            next = next2;
                            priority = priority2;
                        }
                    } while (it.hasNext());
                }
            }
            OrderSummary orderSummary = (OrderSummary) next;
            if (orderSummary != null) {
                orderState = orderSummary.f();
            }
        }
        if (orderState != OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION) {
            this.f26968c.n();
            this.f26968c.o(PushType.ORDER_IS_AVAILABLE.getId());
        }
        if (orderState != OrderState.ORDER_STATE_ARRIVED_TO_DESTINATION) {
            this.f26968c.o(PushType.ORDER_CANCELLED.getId(), PushType.ORDER_FINISHED_EARLIER.getId());
        }
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl
    public Disposable e() {
        Observable<PollingSigned<PollingResult>> e8 = this.f26967b.e();
        final Function1<PollingSigned<PollingResult>, Unit> function1 = new Function1<PollingSigned<PollingResult>, Unit>() { // from class: ee.mtakso.driver.ui.notification.NotificationCleanerService$doStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PollingSigned<PollingResult> pollingSigned) {
                NotificationCleanerService.this.k(pollingSigned.a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PollingSigned<PollingResult> pollingSigned) {
                b(pollingSigned);
                return Unit.f50853a;
            }
        };
        Consumer<? super PollingSigned<PollingResult>> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.notification.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NotificationCleanerService.i(Function1.this, obj);
            }
        };
        final NotificationCleanerService$doStart$2 notificationCleanerService$doStart$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.notification.NotificationCleanerService$doStart$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Notification cleaner error");
            }
        };
        Disposable subscribe = e8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.notification.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NotificationCleanerService.j(Function1.this, obj);
            }
        });
        Intrinsics.e(subscribe, "override fun doStart(): …or\")\n            })\n    }");
        return subscribe;
    }

    @Override // ee.mtakso.driver.service.BaseServiceImpl, ee.mtakso.driver.service.BaseService
    public void stop() {
        super.stop();
        this.f26968c.m();
    }
}
