package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.utils.TimeUtils;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: WaitingForClientViewDelegate.kt */
/* loaded from: classes3.dex */
public final class WaitingForClientViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f32423a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f32424b;

    /* renamed from: c  reason: collision with root package name */
    private OrderData.WaitingForClientData.WaitingTime f32425c;

    /* renamed from: d  reason: collision with root package name */
    private final DrivingToClientViewDelegate f32426d;

    /* renamed from: e  reason: collision with root package name */
    private final CategoryAndPriceDelegate f32427e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f32428f;

    public WaitingForClientViewDelegate(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f32428f = new LinkedHashMap();
        this.f32423a = containerView;
        this.f32426d = new DrivingToClientViewDelegate(c());
        TextView categoryPriceInfo = (TextView) a(R.id.categoryPriceInfo);
        Intrinsics.e(categoryPriceInfo, "categoryPriceInfo");
        this.f32427e = new CategoryAndPriceDelegate(categoryPriceInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if ((!r0) == true) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void d(ee.mtakso.driver.ui.screens.order.v2.order.OrderData.WaitingForClientData r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.e()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            java.lang.CharSequence r0 = kotlin.text.StringsKt.Y0(r0)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L1a
            boolean r0 = kotlin.text.StringsKt.y(r0)
            r0 = r0 ^ r1
            if (r0 != r1) goto L1a
            goto L1b
        L1a:
            r1 = 0
        L1b:
            if (r1 == 0) goto L35
            int r0 = ee.mtakso.driver.R.id.active_order_client_name
            android.view.View r1 = r4.a(r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r3 = r5.e()
            r1.setText(r3)
            android.view.View r0 = r4.a(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r2)
        L35:
            java.lang.String r5 = r5.c()
            r4.e(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.order.ui.WaitingForClientViewDelegate.d(ee.mtakso.driver.ui.screens.order.v2.order.OrderData$WaitingForClientData):void");
    }

    private final void e(String str) {
        if (str == null) {
            TextView active_order_destination_title = (TextView) a(R.id.active_order_destination_title);
            Intrinsics.e(active_order_destination_title, "active_order_destination_title");
            ViewExtKt.e(active_order_destination_title, false, 0, 2, null);
            return;
        }
        int i8 = R.id.active_order_destination_title;
        TextView active_order_destination_title2 = (TextView) a(i8);
        Intrinsics.e(active_order_destination_title2, "active_order_destination_title");
        ViewExtKt.e(active_order_destination_title2, true, 0, 2, null);
        ((TextView) a(i8)).setText(str);
    }

    private final void f(OrderData.WaitingForClientData waitingForClientData) {
        String format;
        if (Intrinsics.a(waitingForClientData.h(), this.f32425c)) {
            return;
        }
        String a8 = TimeUtils.a(waitingForClientData.h().a());
        OrderData.WaitingForClientData.WaitingTime h8 = waitingForClientData.h();
        if (h8 instanceof OrderData.WaitingForClientData.WaitingTime.PickUp) {
            format = c().getContext().getString(R.string.pickup_in_time, a8);
        } else if (h8 instanceof OrderData.WaitingForClientData.WaitingTime.Free) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
            format = String.format("%s %s", Arrays.copyOf(new Object[]{a8, c().getContext().getString(R.string.waiting)}, 2));
            Intrinsics.e(format, "format(format, *args)");
        } else if (h8 instanceof OrderData.WaitingForClientData.WaitingTime.Paid) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
            format = String.format("%s %s", Arrays.copyOf(new Object[]{a8, c().getContext().getString(R.string.paid_waiting)}, 2));
            Intrinsics.e(format, "format(format, *args)");
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.e(format, "when (data.waitingTime) …              )\n        }");
        int i8 = R.id.active_order_timer_text;
        ((AppCompatTextView) a(i8)).setText(format);
        ((AppCompatTextView) a(i8)).setVisibility(0);
        this.f32425c = waitingForClientData.h();
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32428f;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View c8 = c();
            if (c8 == null || (findViewById = c8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void b(OrderData.WaitingForClientData data) {
        Intrinsics.f(data, "data");
        if (!this.f32424b) {
            d(data);
            this.f32424b = true;
        }
        f(data);
        this.f32427e.a(data.d());
        this.f32426d.f(data.f(), data.g());
        TextView pickUpPointDescription = (TextView) a(R.id.pickUpPointDescription);
        Intrinsics.e(pickUpPointDescription, "pickUpPointDescription");
        ViewExtKt.e(pickUpPointDescription, false, 0, 2, null);
    }

    public View c() {
        return this.f32423a;
    }
}
