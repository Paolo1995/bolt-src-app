package ee.mtakso.driver.service.analytics.event.facade;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;

/* compiled from: OrderAnalytics.kt */
/* loaded from: classes3.dex */
public interface OrderAnalytics {

    /* compiled from: OrderAnalytics.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(OrderAnalytics orderAnalytics, OrderState orderState, String str, String str2, String str3, boolean z7, int i8, Object obj) {
            boolean z8;
            if (obj == null) {
                if ((i8 & 16) != 0) {
                    z8 = false;
                } else {
                    z8 = z7;
                }
                orderAnalytics.d4(orderState, str, str2, str3, z8);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackNavigator");
        }
    }

    /* compiled from: OrderAnalytics.kt */
    /* loaded from: classes3.dex */
    public enum EventSource {
        SETTINGS("settings"),
        PROMPT("prompt");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f23508f;

        EventSource(String str) {
            this.f23508f = str;
        }

        public final String c() {
            return this.f23508f;
        }
    }

    void G();

    void R3(OrderHandle orderHandle, OrderHandle orderHandle2, Boolean bool, long j8);

    void a(boolean z7, EventSource eventSource);

    void d4(OrderState orderState, String str, String str2, String str3, boolean z7);

    void i0(OrderState orderState);

    void l1(OrderState orderState);
}
