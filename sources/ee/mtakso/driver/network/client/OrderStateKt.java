package ee.mtakso.driver.network.client;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderState.kt */
/* loaded from: classes3.dex */
public final class OrderStateKt {

    /* compiled from: OrderState.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21324a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_DID_NOT_RESPOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[OrderState.ORDER_STATE_CLIENT_DID_NOT_SHOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[OrderState.ORDER_STATE_PAYMENT_BOOKING_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f21324a = iArr;
        }
    }

    public static final boolean a(OrderState orderState) {
        Intrinsics.f(orderState, "<this>");
        int i8 = WhenMappings.f21324a[orderState.ordinal()];
        if (i8 == 3 || i8 == 4 || i8 == 5 || i8 == 6) {
            return true;
        }
        return false;
    }

    public static final boolean b(OrderState orderState) {
        Intrinsics.f(orderState, "<this>");
        int i8 = WhenMappings.f21324a[orderState.ordinal()];
        if (i8 == 1 || i8 == 2) {
            return true;
        }
        return a(orderState);
    }
}
