package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates;

import android.view.View;
import ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProblemWithPriceUiDelegateFactory.kt */
/* loaded from: classes3.dex */
public final class ProblemWithPriceUiDelegateFactory {

    /* renamed from: a  reason: collision with root package name */
    private final View f31172a;

    /* renamed from: b  reason: collision with root package name */
    private final GivenPriceInfo f31173b;

    public ProblemWithPriceUiDelegateFactory(View containerView, GivenPriceInfo givenPriceInfo) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(givenPriceInfo, "givenPriceInfo");
        this.f31172a = containerView;
        this.f31173b = givenPriceInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r0.equals("driver_set_other") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r0.equals("driver_set_additional_fees_problem") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r0.equals("driver_set_client_did_not_pay") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
        return new ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.InaccuratePriceUiDelegate(r3.f31172a, r3.f31173b, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return new ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ClientDidNotPayUiDelegate(r3.f31172a, r3.f31173b, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r0.equals("driver_set_wrong_price") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r0.equals("driver_set_ride_did_not_happen") != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate a(ee.mtakso.driver.network.client.price.PriceReviewReason r4) {
        /*
            r3 = this;
            java.lang.String r0 = "priceReviewReason"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = r4.a()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1533946884: goto L52;
                case -1248868316: goto L3f;
                case -1071202639: goto L2c;
                case -359543396: goto L23;
                case 331337089: goto L1a;
                case 1770258883: goto L11;
                default: goto L10;
            }
        L10:
            goto L65
        L11:
            java.lang.String r1 = "driver_set_wrong_price"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L35
            goto L65
        L1a:
            java.lang.String r1 = "driver_set_ride_did_not_happen"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L65
            goto L5b
        L23:
            java.lang.String r1 = "driver_set_other"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L35
            goto L65
        L2c:
            java.lang.String r1 = "driver_set_additional_fees_problem"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L35
            goto L65
        L35:
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.InaccuratePriceUiDelegate r0 = new ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.InaccuratePriceUiDelegate
            android.view.View r1 = r3.f31172a
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo r2 = r3.f31173b
            r0.<init>(r1, r2, r4)
            goto L86
        L3f:
            java.lang.String r1 = "driver_set_client_underpaid"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L48
            goto L65
        L48:
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ClientPaidLessUiDelegate r0 = new ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ClientPaidLessUiDelegate
            android.view.View r1 = r3.f31172a
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo r2 = r3.f31173b
            r0.<init>(r1, r2, r4)
            goto L86
        L52:
            java.lang.String r1 = "driver_set_client_did_not_pay"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5b
            goto L65
        L5b:
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ClientDidNotPayUiDelegate r0 = new ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ClientDidNotPayUiDelegate
            android.view.View r1 = r3.f31172a
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo r2 = r3.f31173b
            r0.<init>(r1, r2, r4)
            goto L86
        L65:
            java.lang.String r0 = r4.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot find give reason code "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            ee.mtakso.driver.utils.AssertUtils.a(r0)
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.InaccuratePriceUiDelegate r0 = new ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.InaccuratePriceUiDelegate
            android.view.View r1 = r3.f31172a
            ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.GivenPriceInfo r2 = r3.f31173b
            r0.<init>(r1, r2, r4)
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegateFactory.a(ee.mtakso.driver.network.client.price.PriceReviewReason):ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price.delegates.ProblemWithPriceUiDelegate");
    }
}
