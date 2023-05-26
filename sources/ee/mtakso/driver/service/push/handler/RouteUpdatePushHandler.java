package ee.mtakso.driver.service.push.handler;

import com.google.gson.Gson;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderHandleKt;
import ee.mtakso.driver.platform.push.Push;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.push.PushHandler;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.service.push.PushType;
import ee.mtakso.driver.utils.BackgroundManager;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouteUpdatePushHandler.kt */
/* loaded from: classes3.dex */
public final class RouteUpdatePushHandler implements PushHandler {

    /* renamed from: a  reason: collision with root package name */
    private final BackgroundManager f25701a;

    /* renamed from: b  reason: collision with root package name */
    private final PushNotificationManager f25702b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderProvider f25703c;

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f25704d;

    @Inject
    public RouteUpdatePushHandler(BackgroundManager backgroundManager, PushNotificationManager pushNotificationManager, OrderProvider orderProvider) {
        Lazy b8;
        Intrinsics.f(backgroundManager, "backgroundManager");
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        Intrinsics.f(orderProvider, "orderProvider");
        this.f25701a = backgroundManager;
        this.f25702b = pushNotificationManager;
        this.f25703c = orderProvider;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: ee.mtakso.driver.service.push.handler.RouteUpdatePushHandler$gson$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.f25704d = b8;
    }

    private final Gson g() {
        return (Gson) this.f25704d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public int a() {
        return PushHandler.DefaultImpls.a(this);
    }

    @Override // ee.mtakso.driver.service.push.PushHandler
    public boolean b(final Push push) {
        Intrinsics.f(push, "push");
        if (Intrinsics.a(push.b().get("type"), PushType.ROUTE_UPDATED.getId())) {
            String str = push.b().get("order_handle");
            if (str == null) {
                str = "";
            }
            final OrderHandle c8 = OrderHandleKt.c(str, g());
            Single<OrderDetails> w7 = OrderProviderUtils.w(this.f25703c, new Function1<OrderDetails, Boolean>() { // from class: ee.mtakso.driver.service.push.handler.RouteUpdatePushHandler$handlePush$ignored$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(OrderDetails it) {
                    Intrinsics.f(it, "it");
                    return Boolean.valueOf(Intrinsics.a(it.a(), OrderHandle.this));
                }
            });
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Single<OrderDetails> L = w7.h(3L, timeUnit).L(30L, timeUnit);
            Intrinsics.e(L, "orderHandle: OrderHandle…out(30, TimeUnit.SECONDS)");
            Single d8 = SingleExtKt.d(L);
            final Function1<OrderDetails, Unit> function1 = new Function1<OrderDetails, Unit>() { // from class: ee.mtakso.driver.service.push.handler.RouteUpdatePushHandler$handlePush$ignored$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(OrderDetails orderDetails) {
                    BackgroundManager backgroundManager;
                    PushNotificationManager pushNotificationManager;
                    backgroundManager = RouteUpdatePushHandler.this.f25701a;
                    if (backgroundManager.g()) {
                        pushNotificationManager = RouteUpdatePushHandler.this.f25702b;
                        pushNotificationManager.f(push);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(OrderDetails orderDetails) {
                    b(orderDetails);
                    return Unit.f50853a;
                }
            };
            Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.push.handler.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RouteUpdatePushHandler.h(Function1.this, obj);
                }
            };
            final RouteUpdatePushHandler$handlePush$ignored$3 routeUpdatePushHandler$handlePush$ignored$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.push.handler.RouteUpdatePushHandler$handlePush$ignored$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable err) {
                    Intrinsics.e(err, "err");
                    Kalev.e(err, "Error fetching order OR timed out");
                }
            };
            Intrinsics.e(d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.push.handler.d
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    RouteUpdatePushHandler.i(Function1.this, obj);
                }
            }), "override fun handlePush(…       return false\n    }");
            return true;
        }
        return false;
    }
}
