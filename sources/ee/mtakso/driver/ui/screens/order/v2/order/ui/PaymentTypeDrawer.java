package ee.mtakso.driver.ui.screens.order.v2.order.ui;

import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.order.PaymentType;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import eu.bolt.kalev.Kalev;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentTypeDrawer.kt */
/* loaded from: classes3.dex */
public final class PaymentTypeDrawer {

    /* renamed from: a  reason: collision with root package name */
    private final View f32415a;

    /* renamed from: b  reason: collision with root package name */
    private PaymentType f32416b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, View> f32417c;

    /* compiled from: PaymentTypeDrawer.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32418a;

        static {
            int[] iArr = new int[PaymentType.values().length];
            try {
                iArr[PaymentType.IN_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentType.CASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f32418a = iArr;
        }
    }

    public PaymentTypeDrawer(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f32417c = new LinkedHashMap();
        this.f32415a = containerView;
    }

    public View a(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f32417c;
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

    public final void b(PaymentType paymentType) {
        Intrinsics.f(paymentType, "paymentType");
        if (paymentType == this.f32416b) {
            return;
        }
        int i8 = R.id.active_order_payment_method;
        ((ImageView) a(i8)).setVisibility(0);
        int i9 = WhenMappings.f32418a[paymentType.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                Kalev.d("payment type is unknown");
                ((ImageView) a(i8)).setVisibility(8);
            } else {
                ((ImageView) a(i8)).setImageResource(R.drawable.ic_cash_active_ride);
                ((ImageView) a(i8)).setBackground(ContextCompat.getDrawable(c().getContext(), R.drawable.bg_payment_cash));
                ImageView active_order_payment_method = (ImageView) a(i8);
                Intrinsics.e(active_order_payment_method, "active_order_payment_method");
                ViewExtKt.b(active_order_payment_method, new Color.Attr(R.attr.dynamicGreen02));
            }
        } else {
            ((ImageView) a(i8)).setImageResource(R.drawable.ic_card_active_ride);
            ((ImageView) a(i8)).setBackground(ContextCompat.getDrawable(c().getContext(), R.drawable.bg_payment_card));
            ImageView active_order_payment_method2 = (ImageView) a(i8);
            Intrinsics.e(active_order_payment_method2, "active_order_payment_method");
            ViewExtKt.b(active_order_payment_method2, new Color.Attr(R.attr.dynamicRed));
        }
        this.f32416b = paymentType;
    }

    public View c() {
        return this.f32415a;
    }
}
