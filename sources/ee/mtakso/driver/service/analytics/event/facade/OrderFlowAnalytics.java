package ee.mtakso.driver.service.analytics.event.facade;

import ee.mtakso.driver.model.CancellationReason;
import ee.mtakso.driver.network.client.OrderState;

/* compiled from: OrderFlowAnalytics.kt */
/* loaded from: classes3.dex */
public interface OrderFlowAnalytics {

    /* compiled from: OrderFlowAnalytics.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void a(OrderFlowAnalytics orderFlowAnalytics, boolean z7, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    z7 = false;
                }
                orderFlowAnalytics.b0(z7);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackArriveToClient");
        }

        public static /* synthetic */ void b(OrderFlowAnalytics orderFlowAnalytics, boolean z7, boolean z8, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 2) != 0) {
                    z8 = false;
                }
                orderFlowAnalytics.k(z7, z8);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackArriveToDestination");
        }

        public static /* synthetic */ void c(OrderFlowAnalytics orderFlowAnalytics, boolean z7, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    z7 = false;
                }
                orderFlowAnalytics.t2(z7);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackClientArrived");
        }

        public static /* synthetic */ void d(OrderFlowAnalytics orderFlowAnalytics, boolean z7, int i8, Object obj) {
            if (obj == null) {
                if ((i8 & 1) != 0) {
                    z7 = false;
                }
                orderFlowAnalytics.O(z7);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackNextStopSwiped");
        }
    }

    void A();

    void B2(boolean z7);

    void D(boolean z7);

    void E3();

    void F();

    void F2();

    void G2(String str);

    void H1(boolean z7);

    void I3(boolean z7);

    void J();

    void J1(String str);

    void J2(boolean z7, boolean z8);

    void K0();

    void L0();

    void L1();

    void M();

    void M2();

    void N2();

    void O(boolean z7);

    void Q0();

    void S0();

    void S1();

    void W0();

    void X0();

    void X1();

    void a2(boolean z7);

    void a3();

    void b0(boolean z7);

    void b2();

    void c2();

    void d0();

    void e1();

    void f1(OrderState orderState);

    void g4();

    void j();

    void k(boolean z7, boolean z8);

    void k1();

    void n2(String str, String str2);

    void p();

    void q0(boolean z7);

    void q2();

    void r();

    void t();

    void t2(boolean z7);

    void u1();

    void u2();

    void v3();

    void w();

    void w1();

    void w3();

    void x0();

    void z0(boolean z7, CancellationReason cancellationReason);
}
