package ee.mtakso.driver.service.order.details;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.order.Order;
import ee.mtakso.driver.service.order.ActiveOrderBackOff;
import ee.mtakso.driver.service.order.LinearBackOff;
import ee.mtakso.driver.utils.coroutines.DispatcherProvider;
import eu.bolt.driver.core.util.BackOffCalculator;
import eu.bolt.driver.core.util.RetryBuilderKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OrderManager.kt */
@DebugMetadata(c = "ee.mtakso.driver.service.order.details.OrderManager$fetchActiveOrder$fetchJob$1", f = "OrderManager.kt", l = {145, 149}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class OrderManager$fetchActiveOrder$fetchJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f25441g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ OrderSummary f25442h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ OrderManager f25443i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ OrderHandle f25444j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OrderManager.kt */
    @DebugMetadata(c = "ee.mtakso.driver.service.order.details.OrderManager$fetchActiveOrder$fetchJob$1$1", f = "OrderManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ee.mtakso.driver.service.order.details.OrderManager$fetchActiveOrder$fetchJob$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f25445g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ OrderManager f25446h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ OrderSummary f25447i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Order f25448j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(OrderManager orderManager, OrderSummary orderSummary, Order order, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.f25446h = orderManager;
            this.f25447i = orderSummary;
            this.f25448j = order;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.f25446h, this.f25447i, this.f25448j, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f25445g == 0) {
                ResultKt.b(obj);
                this.f25446h.q(this.f25447i, this.f25448j);
                return Unit.f50853a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: OrderManager.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25449a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_WAITING_DRIVER_CONFIRMATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f25449a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderManager$fetchActiveOrder$fetchJob$1(OrderSummary orderSummary, OrderManager orderManager, OrderHandle orderHandle, Continuation<? super OrderManager$fetchActiveOrder$fetchJob$1> continuation) {
        super(2, continuation);
        this.f25442h = orderSummary;
        this.f25443i = orderManager;
        this.f25444j = orderHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OrderManager$fetchActiveOrder$fetchJob$1(this.f25442h, this.f25443i, this.f25444j, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: h */
    public final Object s(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OrderManager$fetchActiveOrder$fetchJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        BackOffCalculator activeOrderBackOff;
        OrderTryAgainManager orderTryAgainManager;
        OrderTryAgainManager orderTryAgainManager2;
        DispatcherProvider dispatcherProvider;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f25441g;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    ResultKt.b(obj);
                    return Unit.f50853a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        } else {
            ResultKt.b(obj);
            if (WhenMappings.f25449a[this.f25442h.f().ordinal()] == 1) {
                activeOrderBackOff = new LinearBackOff();
            } else {
                activeOrderBackOff = new ActiveOrderBackOff();
            }
            orderTryAgainManager = this.f25443i.f25436f;
            orderTryAgainManager.d();
            OrderManager$fetchActiveOrder$fetchJob$1$order$1 orderManager$fetchActiveOrder$fetchJob$1$order$1 = new OrderManager$fetchActiveOrder$fetchJob$1$order$1(this.f25443i, this.f25444j, null);
            this.f25441g = 1;
            obj = RetryBuilderKt.a(activeOrderBackOff, orderManager$fetchActiveOrder$fetchJob$1$order$1, this);
            if (obj == d8) {
                return d8;
            }
        }
        orderTryAgainManager2 = this.f25443i.f25436f;
        orderTryAgainManager2.b();
        dispatcherProvider = this.f25443i.f25431a;
        CoroutineDispatcher b8 = dispatcherProvider.b();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f25443i, this.f25442h, (Order) obj, null);
        this.f25441g = 2;
        if (BuildersKt.g(b8, anonymousClass1, this) == d8) {
            return d8;
        }
        return Unit.f50853a;
    }
}
