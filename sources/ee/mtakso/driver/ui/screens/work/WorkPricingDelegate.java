package ee.mtakso.driver.ui.screens.work;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.network.client.settings.DriverPricing;
import ee.mtakso.driver.network.client.settings.DriverPricingState;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkPricingDelegate.kt */
/* loaded from: classes5.dex */
public final class WorkPricingDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f33757a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f33758b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f33759c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f33760d;

    /* compiled from: WorkPricingDelegate.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33761a;

        static {
            int[] iArr = new int[DriverPricingState.values().length];
            try {
                iArr[DriverPricingState.STANDARD_PRICING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DriverPricingState.CUSTOM_PRICING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f33761a = iArr;
        }
    }

    public WorkPricingDelegate(ViewGroup pricingLayout, TextView pricingText, ImageView pricingImage) {
        Intrinsics.f(pricingLayout, "pricingLayout");
        Intrinsics.f(pricingText, "pricingText");
        Intrinsics.f(pricingImage, "pricingImage");
        this.f33757a = pricingLayout;
        this.f33758b = pricingText;
        this.f33759c = pricingImage;
    }

    private final void e(int i8, int i9) {
        ViewGroup viewGroup = this.f33757a;
        Context context = viewGroup.getContext();
        Intrinsics.e(context, "pricingLayout.context");
        ViewCompat.x0(viewGroup, ContextUtilsKt.c(context, i8));
        TextView textView = this.f33758b;
        Context context2 = textView.getContext();
        Intrinsics.e(context2, "pricingText.context");
        textView.setTextColor(ContextUtilsKt.c(context2, i9));
        ImageView imageView = this.f33759c;
        Context context3 = this.f33758b.getContext();
        Intrinsics.e(context3, "pricingText.context");
        ImageViewCompat.c(imageView, ContextUtilsKt.c(context3, i9));
    }

    private final void f(int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = this.f33757a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = i8;
        }
        this.f33757a.setLayoutParams(marginLayoutParams);
    }

    public final void a() {
        f(Dimens.c(24));
    }

    public final void b() {
        f(Dimens.c(12));
    }

    public final void c(View.OnClickListener onClickListener) {
        this.f33760d = onClickListener;
        this.f33757a.setOnClickListener(onClickListener);
    }

    public final void d(DriverPricing driverPricing) {
        DriverPricingState driverPricingState;
        int i8;
        if (driverPricing != null) {
            driverPricingState = driverPricing.a();
        } else {
            driverPricingState = null;
        }
        if (driverPricingState == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f33761a[driverPricingState.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                ViewExtKt.e(this.f33757a, false, 0, 2, null);
                return;
            }
            e(R.attr.dynamicPurple02, R.attr.dynamicWhite);
            this.f33758b.setText(driverPricing.b());
            ViewExtKt.e(this.f33757a, true, 0, 2, null);
            return;
        }
        e(R.attr.accentNeutral, R.attr.contentInverted);
        this.f33758b.setText(driverPricing.b());
        ViewExtKt.e(this.f33757a, true, 0, 2, null);
    }
}
