package ee.mtakso.driver.ui.interactor.call;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerCallCache;
import ee.mtakso.driver.service.voip.noanswer.NoAnswerIncomingCall;
import ee.mtakso.driver.ui.interactor.call.NoAnswerIncomingCallInteractor;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoAnswerIncomingCallInteractor.kt */
/* loaded from: classes3.dex */
public final class NoAnswerIncomingCallInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f26416a;

    /* renamed from: b  reason: collision with root package name */
    private final NoAnswerCallCache f26417b;

    @Inject
    public NoAnswerIncomingCallInteractor(OrderProvider orderProvider, NoAnswerCallCache noAnswerCallCache) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(noAnswerCallCache, "noAnswerCallCache");
        this.f26416a = orderProvider;
        this.f26417b = noAnswerCallCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    public final Observable<NoAnswerIncomingCall> c() {
        Observable<NoAnswerIncomingCall> a8 = this.f26417b.a();
        final Function1<NoAnswerIncomingCall, Boolean> function1 = new Function1<NoAnswerIncomingCall, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.call.NoAnswerIncomingCallInteractor$observeNoAnswerIncomingCall$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(NoAnswerIncomingCall call) {
                OrderProvider orderProvider;
                OrderHandle orderHandle;
                Intrinsics.f(call, "call");
                orderProvider = NoAnswerIncomingCallInteractor.this.f26416a;
                ActiveOrderDetails i8 = OrderProviderUtils.i(orderProvider.f());
                OrderHandle a9 = call.a();
                if (i8 != null) {
                    orderHandle = i8.a();
                } else {
                    orderHandle = null;
                }
                return Boolean.valueOf(Intrinsics.a(a9, orderHandle));
            }
        };
        Observable<NoAnswerIncomingCall> filter = a8.filter(new Predicate() { // from class: p2.a
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean d8;
                d8 = NoAnswerIncomingCallInteractor.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(filter, "fun observeNoAnswerIncom…andle\n            }\n    }");
        return filter;
    }
}
