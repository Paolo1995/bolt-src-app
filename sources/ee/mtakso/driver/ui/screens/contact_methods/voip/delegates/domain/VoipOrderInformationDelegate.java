package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetailsKt;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.service.voip.VoipConnectionExtKt;
import ee.mtakso.driver.service.voip.lifecycle.observers.VoipRxLifecycleTransfromer;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.voip_client.VoipCall;
import eu.bolt.driver.voip.service.order.CurrentOrderInfo;
import eu.bolt.driver.voip.service.order.CurrentOrderInfoProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipOrderInformationDelegate.kt */
/* loaded from: classes3.dex */
public final class VoipOrderInformationDelegate implements CurrentOrderInfoProvider {

    /* renamed from: d  reason: collision with root package name */
    private static final Companion f27936d = new Companion(null);
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    private static final VoipOrderInfo f27937e = new VoipOrderInfo(null, null, null);

    /* renamed from: a  reason: collision with root package name */
    private final VoipCache f27938a;

    /* renamed from: b  reason: collision with root package name */
    private final OrderProvider f27939b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipRxLifecycleTransfromer f27940c;

    /* compiled from: VoipOrderInformationDelegate.kt */
    /* loaded from: classes3.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: VoipOrderInformationDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class VoipCallAndOrderInfo {

        /* renamed from: a  reason: collision with root package name */
        private final VoipRxLifecycleTransfromer.CallWithStateAndEndReason f27941a;

        /* renamed from: b  reason: collision with root package name */
        private final VoipOrderInfo f27942b;

        public VoipCallAndOrderInfo(VoipRxLifecycleTransfromer.CallWithStateAndEndReason callInfo, VoipOrderInfo voipOrderInfo) {
            Intrinsics.f(callInfo, "callInfo");
            this.f27941a = callInfo;
            this.f27942b = voipOrderInfo;
        }

        public final VoipRxLifecycleTransfromer.CallWithStateAndEndReason a() {
            return this.f27941a;
        }

        public final VoipOrderInfo b() {
            return this.f27942b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VoipCallAndOrderInfo) {
                VoipCallAndOrderInfo voipCallAndOrderInfo = (VoipCallAndOrderInfo) obj;
                return Intrinsics.a(this.f27941a, voipCallAndOrderInfo.f27941a) && Intrinsics.a(this.f27942b, voipCallAndOrderInfo.f27942b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f27941a.hashCode() * 31;
            VoipOrderInfo voipOrderInfo = this.f27942b;
            return hashCode + (voipOrderInfo == null ? 0 : voipOrderInfo.hashCode());
        }

        public String toString() {
            VoipRxLifecycleTransfromer.CallWithStateAndEndReason callWithStateAndEndReason = this.f27941a;
            VoipOrderInfo voipOrderInfo = this.f27942b;
            return "VoipCallAndOrderInfo(callInfo=" + callWithStateAndEndReason + ", orderInfo=" + voipOrderInfo + ")";
        }
    }

    /* compiled from: VoipOrderInformationDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class VoipOrderInfo {

        /* renamed from: a  reason: collision with root package name */
        private final String f27943a;

        /* renamed from: b  reason: collision with root package name */
        private final Long f27944b;

        /* renamed from: c  reason: collision with root package name */
        private final OrderHandle f27945c;

        public VoipOrderInfo(String str, Long l8, OrderHandle orderHandle) {
            this.f27943a = str;
            this.f27944b = l8;
            this.f27945c = orderHandle;
        }

        public final String a() {
            return this.f27943a;
        }

        public final OrderHandle b() {
            return this.f27945c;
        }

        public final Long c() {
            return this.f27944b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VoipOrderInfo) {
                VoipOrderInfo voipOrderInfo = (VoipOrderInfo) obj;
                return Intrinsics.a(this.f27943a, voipOrderInfo.f27943a) && Intrinsics.a(this.f27944b, voipOrderInfo.f27944b) && Intrinsics.a(this.f27945c, voipOrderInfo.f27945c);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f27943a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l8 = this.f27944b;
            int hashCode2 = (hashCode + (l8 == null ? 0 : l8.hashCode())) * 31;
            OrderHandle orderHandle = this.f27945c;
            return hashCode2 + (orderHandle != null ? orderHandle.hashCode() : 0);
        }

        public String toString() {
            String str = this.f27943a;
            Long l8 = this.f27944b;
            OrderHandle orderHandle = this.f27945c;
            return "VoipOrderInfo(address=" + str + ", secondsToDestination=" + l8 + ", orderHandle=" + orderHandle + ")";
        }
    }

    @Inject
    public VoipOrderInformationDelegate(VoipCache voipCache, OrderProvider orderProvider, VoipRxLifecycleTransfromer rxVoipRxLifecycleTransfromer) {
        Intrinsics.f(voipCache, "voipCache");
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(rxVoipRxLifecycleTransfromer, "rxVoipRxLifecycleTransfromer");
        this.f27938a = voipCache;
        this.f27939b = orderProvider;
        this.f27940c = rxVoipRxLifecycleTransfromer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActiveOrderDetails k(List<? extends OrderDetails> list) {
        int v7;
        Object obj;
        boolean z7;
        ArrayList<OrderDetails> arrayList = new ArrayList();
        for (Object obj2 : list) {
            OrderDetails orderDetails = (OrderDetails) obj2;
            if (!OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ACCEPTED) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_DRIVING_WITH_CLIENT) && !OrderDetailsKt.a(orderDetails, OrderState.ORDER_STATE_WAITING_ON_STOP)) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                arrayList.add(obj2);
            }
        }
        v7 = CollectionsKt__IterablesKt.v(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (OrderDetails orderDetails2 : arrayList) {
            Intrinsics.d(orderDetails2, "null cannot be cast to non-null type ee.mtakso.driver.service.order.details.ActiveOrderDetails");
            arrayList2.add((ActiveOrderDetails) orderDetails2);
        }
        Iterator it = arrayList2.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (!it.hasNext()) {
                obj = next;
            } else {
                int priority = ((ActiveOrderDetails) next).b().getPriority();
                do {
                    Object next2 = it.next();
                    int priority2 = ((ActiveOrderDetails) next2).b().getPriority();
                    if (priority > priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it.hasNext());
                obj = next;
            }
        }
        return (ActiveOrderDetails) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<VoipOrderInfo> l(VoipCall voipCall) {
        if (Intrinsics.a(VoipConnectionExtKt.c(voipCall.g()), Boolean.FALSE)) {
            return o();
        }
        Observable<VoipOrderInfo> just = Observable.just(f27937e);
        Intrinsics.e(just, "just(EMPTY_CALLING_DATA)");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<VoipOrderInfo> m() {
        Observable<VoipOrderInfo> o8 = o();
        final Function1<VoipOrderInfo, VoipOrderInfo> function1 = new Function1<VoipOrderInfo, VoipOrderInfo>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate$getOutgoingCallOrderInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final VoipOrderInformationDelegate.VoipOrderInfo invoke(VoipOrderInformationDelegate.VoipOrderInfo orderInfo) {
                VoipCache voipCache;
                Intrinsics.f(orderInfo, "orderInfo");
                voipCache = VoipOrderInformationDelegate.this.f27938a;
                OrderHandle a8 = voipCache.a();
                if (!Intrinsics.a(orderInfo.b(), a8)) {
                    return new VoipOrderInformationDelegate.VoipOrderInfo(null, null, a8);
                }
                return orderInfo;
            }
        };
        Observable map = o8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.o
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VoipOrderInformationDelegate.VoipOrderInfo n8;
                n8 = VoipOrderInformationDelegate.n(Function1.this, obj);
                return n8;
            }
        });
        Intrinsics.e(map, "private fun getOutgoingC…    }\n            }\n    }");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VoipOrderInfo n(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VoipOrderInfo) tmp0.invoke(obj);
    }

    private final Observable<VoipOrderInfo> o() {
        Observable<ActiveOrderDetails> s7 = s();
        final VoipOrderInformationDelegate$getVoipOrder$1 voipOrderInformationDelegate$getVoipOrder$1 = new Function1<ActiveOrderDetails, VoipOrderInfo>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate$getVoipOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final VoipOrderInformationDelegate.VoipOrderInfo invoke(ActiveOrderDetails orderDetails) {
                String c8;
                Long d8;
                Intrinsics.f(orderDetails, "orderDetails");
                c8 = VoipOrderInformationDelegateKt.c(orderDetails);
                d8 = VoipOrderInformationDelegateKt.d(orderDetails);
                return new VoipOrderInformationDelegate.VoipOrderInfo(c8, d8, orderDetails.a());
            }
        };
        Observable<VoipOrderInfo> startWith = s7.map(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.p
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VoipOrderInformationDelegate.VoipOrderInfo p8;
                p8 = VoipOrderInformationDelegate.p(Function1.this, obj);
                return p8;
            }
        }).startWith((Observable<R>) f27937e);
        Intrinsics.e(startWith, "observeActiveOrder()\n   …tWith(EMPTY_CALLING_DATA)");
        return startWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VoipOrderInfo p(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VoipOrderInfo) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    private final Observable<ActiveOrderDetails> s() {
        return ObservableExtKt.k(this.f27939b.a(), new Function1<List<? extends OrderDetails>, ActiveOrderDetails>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate$observeActiveOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ActiveOrderDetails invoke(List<? extends OrderDetails> it) {
                ActiveOrderDetails k8;
                Intrinsics.f(it, "it");
                k8 = VoipOrderInformationDelegate.this.k(it);
                return k8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CurrentOrderInfo v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CurrentOrderInfo) tmp0.invoke(obj);
    }

    @Override // eu.bolt.driver.voip.service.order.CurrentOrderInfoProvider
    public Observable<CurrentOrderInfo> a() {
        Observable<ActiveOrderDetails> s7 = s();
        final VoipOrderInformationDelegate$observeCurrentOrder$1 voipOrderInformationDelegate$observeCurrentOrder$1 = new Function1<ActiveOrderDetails, CurrentOrderInfo>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate$observeCurrentOrder$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final CurrentOrderInfo invoke(ActiveOrderDetails orderDetails) {
                String c8;
                Long d8;
                Intrinsics.f(orderDetails, "orderDetails");
                c8 = VoipOrderInformationDelegateKt.c(orderDetails);
                d8 = VoipOrderInformationDelegateKt.d(orderDetails);
                return new CurrentOrderInfo(c8, d8);
            }
        };
        Observable map = s7.map(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.n
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CurrentOrderInfo v7;
                v7 = VoipOrderInformationDelegate.v(Function1.this, obj);
                return v7;
            }
        });
        Intrinsics.e(map, "observeActiveOrder()\n   …          )\n            }");
        return map;
    }

    public final Observable<VoipOrderInfo> q() {
        Single<VoipRxLifecycleTransfromer.CallWithStateAndEndReason> firstOrError = this.f27940c.e().firstOrError();
        final Function1<VoipRxLifecycleTransfromer.CallWithStateAndEndReason, ObservableSource<? extends VoipOrderInfo>> function1 = new Function1<VoipRxLifecycleTransfromer.CallWithStateAndEndReason, ObservableSource<? extends VoipOrderInfo>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate$getVoipOrderRelatedInfo$1

            /* compiled from: VoipOrderInformationDelegate.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f27949a;

                static {
                    int[] iArr = new int[VoipCall.Type.values().length];
                    try {
                        iArr[VoipCall.Type.INCOMING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[VoipCall.Type.OUTGOING.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f27949a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ObservableSource<? extends VoipOrderInformationDelegate.VoipOrderInfo> invoke(VoipRxLifecycleTransfromer.CallWithStateAndEndReason callAndStatus) {
                Observable l8;
                Observable m8;
                Intrinsics.f(callAndStatus, "callAndStatus");
                VoipCall a8 = callAndStatus.a();
                int i8 = WhenMappings.f27949a[a8.getType().ordinal()];
                if (i8 == 1) {
                    l8 = VoipOrderInformationDelegate.this.l(a8);
                    return l8;
                } else if (i8 == 2) {
                    m8 = VoipOrderInformationDelegate.this.m();
                    return m8;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        };
        Observable t7 = firstOrError.t(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource r7;
                r7 = VoipOrderInformationDelegate.r(Function1.this, obj);
                return r7;
            }
        });
        Intrinsics.e(t7, "fun getVoipOrderRelatedI…    }\n            }\n    }");
        return t7;
    }

    public final Observable<Optional<OrderHandle>> t() {
        Observable<List<OrderDetails>> a8 = this.f27939b.a();
        final Function1<List<? extends OrderDetails>, Optional<OrderHandle>> function1 = new Function1<List<? extends OrderDetails>, Optional<OrderHandle>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOrderInformationDelegate$observeActiveOrderHandleOrNull$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<OrderHandle> invoke(List<? extends OrderDetails> it) {
                ActiveOrderDetails k8;
                Intrinsics.f(it, "it");
                k8 = VoipOrderInformationDelegate.this.k(it);
                if (k8 == null) {
                    return Optional.a();
                }
                return Optional.f(k8.a());
            }
        };
        Observable map = a8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.l
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional u7;
                u7 = VoipOrderInformationDelegate.u(Function1.this, obj);
                return u7;
            }
        });
        Intrinsics.e(map, "fun observeActiveOrderHa…ndle)\n            }\n    }");
        return map;
    }
}
