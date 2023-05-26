package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.view.View;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoingToPickupViewDelegate.kt */
/* loaded from: classes3.dex */
public final class GoingToPickupViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f32383a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f32384b;

    /* renamed from: c  reason: collision with root package name */
    private Long f32385c;

    /* renamed from: d  reason: collision with root package name */
    private final DrivingToClientViewDelegate f32386d;

    /* renamed from: e  reason: collision with root package name */
    private final CategoryAndPriceDelegate f32387e;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f32388f;

    public GoingToPickupViewDelegate(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f32388f = new LinkedHashMap();
        this.f32383a = containerView;
        this.f32386d = new DrivingToClientViewDelegate(c());
        TextView categoryPriceInfo = (TextView) a(R.id.categoryPriceInfo);
        Intrinsics.e(categoryPriceInfo, "categoryPriceInfo");
        this.f32387e = new CategoryAndPriceDelegate(categoryPriceInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if ((!r0) == true) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void d(ee.mtakso.driver.ui.screens.order.v2.order.OrderData.GoingToPickupData r5) {
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
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.order.ui.GoingToPickupViewDelegate.d(ee.mtakso.driver.ui.screens.order.v2.order.OrderData$GoingToPickupData):void");
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

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void f(ee.mtakso.driver.ui.screens.order.v2.order.OrderData.GoingToPickupData r12) {
        /*
            r11 = this;
            java.lang.Long r12 = r12.h()
            java.lang.Long r0 = r11.f32385c
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r12, r0)
            if (r0 == 0) goto Ld
            return
        Ld:
            r0 = 0
            r1 = 1
            if (r12 != 0) goto L13
        L11:
            r2 = 1
            goto L1f
        L13:
            r2 = 0
            long r4 = r12.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L1e
            goto L11
        L1e:
            r2 = 0
        L1f:
            r2 = r2 ^ r1
            if (r12 == 0) goto L85
            r12.longValue()
            long r3 = r12.longValue()
            r5 = 60
            java.lang.String r7 = "format(format, *args)"
            r8 = 2131953302(0x7f130696, float:1.9543071E38)
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L65
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.f51021a
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            long r9 = r12.longValue()
            long r5 = r5.toMinutes(r9)
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r4[r0] = r5
            android.view.View r5 = r11.c()
            android.content.Context r5 = r5.getContext()
            java.lang.String r5 = r5.getString(r8)
            r4[r1] = r5
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r4, r3)
            java.lang.String r4 = "%s %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            kotlin.jvm.internal.Intrinsics.e(r3, r7)
            goto L87
        L65:
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.f51021a
            java.lang.Object[] r3 = new java.lang.Object[r1]
            android.view.View r4 = r11.c()
            android.content.Context r4 = r4.getContext()
            java.lang.String r4 = r4.getString(r8)
            r3[r0] = r4
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r1)
            java.lang.String r4 = "<1 %s"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            kotlin.jvm.internal.Intrinsics.e(r3, r7)
            goto L87
        L85:
            java.lang.String r3 = ""
        L87:
            int r4 = ee.mtakso.driver.R.id.active_order_timer_text
            android.view.View r5 = r11.a(r4)
            androidx.appcompat.widget.AppCompatTextView r5 = (androidx.appcompat.widget.AppCompatTextView) r5
            r5.setText(r3)
            android.view.View r4 = r11.a(r4)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            if (r2 == 0) goto La7
            int r2 = r3.length()
            if (r2 <= 0) goto La2
            r2 = 1
            goto La3
        La2:
            r2 = 0
        La3:
            if (r2 == 0) goto La7
            r2 = 1
            goto La8
        La7:
            r2 = 0
        La8:
            if (r2 != r1) goto Lab
            goto Laf
        Lab:
            if (r2 != 0) goto Lb5
            r0 = 8
        Laf:
            r4.setVisibility(r0)
            r11.f32385c = r12
            return
        Lb5:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.ui.screens.order.v2.order.ui.GoingToPickupViewDelegate.f(ee.mtakso.driver.ui.screens.order.v2.order.OrderData$GoingToPickupData):void");
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32388f;
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

    public final void b(OrderData.GoingToPickupData data) {
        boolean z7;
        Intrinsics.f(data, "data");
        if (!this.f32384b) {
            d(data);
            this.f32384b = true;
        }
        f(data);
        this.f32387e.a(data.d());
        this.f32386d.f(data.f(), data.g());
        int i8 = R.id.pickUpPointDescription;
        TextView pickUpPointDescription = (TextView) a(i8);
        Intrinsics.e(pickUpPointDescription, "pickUpPointDescription");
        String i9 = data.i();
        if (i9 != null && i9.length() != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        ViewExtKt.e(pickUpPointDescription, true ^ z7, 0, 2, null);
        ((TextView) a(i8)).setText(data.i());
    }

    public View c() {
        return this.f32383a;
    }
}
