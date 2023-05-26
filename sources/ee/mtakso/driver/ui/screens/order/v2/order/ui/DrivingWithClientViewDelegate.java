package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DrivingWithClientViewDelegate.kt */
/* loaded from: classes3.dex */
public final class DrivingWithClientViewDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f32379a;

    /* renamed from: b  reason: collision with root package name */
    private final PaymentTypeDrawer f32380b;

    /* renamed from: c  reason: collision with root package name */
    private String f32381c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f32382d;

    public DrivingWithClientViewDelegate(View containerView, PaymentTypeDrawer paymentTypeDrawer) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(paymentTypeDrawer, "paymentTypeDrawer");
        this.f32382d = new LinkedHashMap();
        this.f32379a = containerView;
        this.f32380b = paymentTypeDrawer;
        this.f32381c = "";
    }

    private final void b(String str) {
        if (Intrinsics.a(this.f32381c, str)) {
            if (this.f32381c != null) {
                ((TextView) a(R.id.active_order_destination_title)).setVisibility(0);
                return;
            }
            return;
        }
        ((TextView) a(R.id.active_order_client_name)).setVisibility(8);
        if (str == null) {
            ((TextView) a(R.id.active_order_destination_title)).setVisibility(8);
            ((TextView) a(R.id.active_order_set_destination_name)).setVisibility(0);
            return;
        }
        int i8 = R.id.active_order_destination_title;
        ((TextView) a(i8)).setVisibility(0);
        ((TextView) a(R.id.active_order_set_destination_name)).setVisibility(8);
        ((TextView) a(i8)).setText(str);
        this.f32381c = str;
    }

    private final void c(Long l8) {
        String format;
        if (l8 != null && l8.longValue() >= 1) {
            int i8 = R.id.active_order_timer_text;
            ((AppCompatTextView) a(i8)).setVisibility(0);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long minutes = timeUnit.toMinutes(l8.longValue()) % 60;
            long hours = timeUnit.toHours(l8.longValue());
            if (hours > 0) {
                if (minutes > 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
                    format = String.format("%s %s %s %s", Arrays.copyOf(new Object[]{Long.valueOf(hours), e().getContext().getString(R.string.time_format_hours), Long.valueOf(minutes), e().getContext().getString(R.string.minutes)}, 4));
                    Intrinsics.e(format, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.f51021a;
                    format = String.format("%s %s", Arrays.copyOf(new Object[]{Long.valueOf(hours), e().getContext().getString(R.string.time_format_hours)}, 2));
                    Intrinsics.e(format, "format(format, *args)");
                }
            } else if (minutes >= 1) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.f51021a;
                format = String.format("%s %s", Arrays.copyOf(new Object[]{Long.valueOf(minutes), e().getContext().getString(R.string.minutes)}, 2));
                Intrinsics.e(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.f51021a;
                format = String.format("<1 %s", Arrays.copyOf(new Object[]{e().getContext().getString(R.string.minutes)}, 1));
                Intrinsics.e(format, "format(format, *args)");
            }
            ((AppCompatTextView) a(i8)).setText(format);
            return;
        }
        ((AppCompatTextView) a(R.id.active_order_timer_text)).setVisibility(8);
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32382d;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View e8 = e();
            if (e8 == null || (findViewById = e8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void d(OrderData.DrivingWithClientData data) {
        Intrinsics.f(data, "data");
        ((Group) a(R.id.on_stop)).setVisibility(8);
        b(data.c());
        c(data.e());
        LinearLayout additionClientInformationSection = (LinearLayout) a(R.id.additionClientInformationSection);
        Intrinsics.e(additionClientInformationSection, "additionClientInformationSection");
        ViewExtKt.e(additionClientInformationSection, false, 0, 2, null);
        this.f32380b.b(data.f());
        TextView categoryPriceInfo = (TextView) a(R.id.categoryPriceInfo);
        Intrinsics.e(categoryPriceInfo, "categoryPriceInfo");
        ViewExtKt.e(categoryPriceInfo, false, 0, 2, null);
    }

    public View e() {
        return this.f32379a;
    }
}
