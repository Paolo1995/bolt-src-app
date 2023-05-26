package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.order.v2.order.OrderData;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.utils.TimeUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingOnStopDelegate.kt */
/* loaded from: classes3.dex */
public final class WaitingOnStopDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final View f32429a;

    /* renamed from: b  reason: collision with root package name */
    private final PaymentTypeDrawer f32430b;

    /* renamed from: c  reason: collision with root package name */
    private final Spanned f32431c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, View> f32432d;

    public WaitingOnStopDelegate(View containerView, PaymentTypeDrawer paymentTypeDrawer) {
        Intrinsics.f(containerView, "containerView");
        Intrinsics.f(paymentTypeDrawer, "paymentTypeDrawer");
        this.f32432d = new LinkedHashMap();
        this.f32429a = containerView;
        this.f32430b = paymentTypeDrawer;
        SpannableString spannableString = new SpannableString(" • ");
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(f().getResources().getDimensionPixelSize(R.dimen.uikit_text_size_24sp));
        Context context = f().getContext();
        Intrinsics.e(context, "containerView.context");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextUtilsKt.b(context, R.attr.colorBorderNeutralSecondary));
        spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 17);
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 17);
        this.f32431c = spannableString;
    }

    private final void c(String str) {
        ((TextView) a(R.id.waiting_price)).setText(str);
    }

    private final void d(OrderData.WaitingOnStopData waitingOnStopData) {
        ((TextView) a(R.id.active_order_client_name)).setVisibility(8);
        ((TextView) a(R.id.stop_timer)).setText(e(waitingOnStopData.f(), waitingOnStopData.c()));
    }

    private final SpannableStringBuilder e(long j8, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(TimeUtils.a(j8));
        if (str != null) {
            spannableStringBuilder.append((CharSequence) this.f32431c).append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    private final void g() {
        ((Group) a(R.id.on_stop)).setVisibility(0);
        ((AppCompatTextView) a(R.id.active_order_timer_text)).setVisibility(8);
        ((TextView) a(R.id.active_order_destination_title)).setVisibility(8);
        ((TextView) a(R.id.title_separator)).setText(this.f32431c);
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32432d;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View f8 = f();
            if (f8 == null || (findViewById = f8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void b(OrderData.WaitingOnStopData order) {
        Intrinsics.f(order, "order");
        if (((Group) a(R.id.on_stop)).getVisibility() != 0) {
            g();
        }
        this.f32430b.b(order.d());
        d(order);
        c(order.e());
    }

    public View f() {
        return this.f32429a;
    }
}
