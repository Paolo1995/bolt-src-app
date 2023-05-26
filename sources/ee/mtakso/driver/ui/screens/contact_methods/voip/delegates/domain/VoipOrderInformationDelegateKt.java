package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.order.OrderKt;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;

/* compiled from: VoipOrderInformationDelegate.kt */
/* loaded from: classes3.dex */
public final class VoipOrderInformationDelegateKt {

    /* compiled from: VoipOrderInformationDelegate.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27953a;

        static {
            int[] iArr = new int[OrderState.values().length];
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderState.ORDER_STATE_DRIVER_ARRIVED_TO_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f27953a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(ActiveOrderDetails activeOrderDetails) {
        int i8 = WhenMappings.f27953a[activeOrderDetails.b().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                return null;
            }
            return OrderKt.d(activeOrderDetails.i());
        }
        return OrderKt.d(activeOrderDetails.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long d(ActiveOrderDetails activeOrderDetails) {
        if (WhenMappings.f27953a[activeOrderDetails.b().ordinal()] == 1) {
            return activeOrderDetails.n();
        }
        return null;
    }
}
