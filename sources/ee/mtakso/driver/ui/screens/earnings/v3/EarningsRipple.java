package ee.mtakso.driver.ui.screens.earnings.v3;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.RippleProvider;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Dimens;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsRipple.kt */
/* loaded from: classes3.dex */
public final class EarningsRipple {

    /* renamed from: a  reason: collision with root package name */
    public static final EarningsRipple f28765a = new EarningsRipple();

    private EarningsRipple() {
    }

    public final void a(View view) {
        Intrinsics.f(view, "<this>");
        RippleProvider rippleProvider = RippleProvider.f35730a;
        Context context = view.getContext();
        Intrinsics.e(context, "context");
        int b8 = ContextUtilsKt.b(context, R.attr.backPrimary);
        Context context2 = view.getContext();
        Intrinsics.e(context2, "context");
        int b9 = ContextUtilsKt.b(context2, R.attr.dynamicNeutral01);
        float b10 = Dimens.b(16.0f);
        Paint.Style style = Paint.Style.FILL;
        view.setBackground(rippleProvider.d(b8, b9, new RippleProvider.CornerRadiuses(b10, b10, b10, b10), 0.0f, Paint.Style.FILL));
    }
}
