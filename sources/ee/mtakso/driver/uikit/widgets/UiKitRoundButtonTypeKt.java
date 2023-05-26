package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UiKitRoundButtonType.kt */
/* loaded from: classes5.dex */
public final class UiKitRoundButtonTypeKt {
    public static final void a(RoundButton roundButton, UiKitRoundButtonSize size) {
        Intrinsics.f(roundButton, "<this>");
        Intrinsics.f(size, "size");
        int dimension = (int) roundButton.getResources().getDimension(size.e().d());
        roundButton.setTextAppearance(size.f());
        roundButton.setMinimumHeight((int) roundButton.getResources().getDimension(size.c()));
        roundButton.setPadding((int) roundButton.getResources().getDimension(size.e().b()), dimension, (int) roundButton.getResources().getDimension(size.e().c()), (int) roundButton.getResources().getDimension(size.e().a()));
    }

    public static final void b(RoundButton roundButton, UiKitRoundButtonType type) {
        Intrinsics.f(roundButton, "<this>");
        Intrinsics.f(type, "type");
        Color c8 = type.c();
        Context context = roundButton.getContext();
        Intrinsics.e(context, "context");
        roundButton.setBgColor(ColorKt.a(c8, context));
        Color j8 = type.j();
        Context context2 = roundButton.getContext();
        Intrinsics.e(context2, "context");
        roundButton.setTextColor(ColorKt.a(j8, context2));
        Color h8 = type.h();
        Context context3 = roundButton.getContext();
        Intrinsics.e(context3, "context");
        roundButton.setRippleColor(ColorKt.a(h8, context3));
        Color e8 = type.e();
        Context context4 = roundButton.getContext();
        Intrinsics.e(context4, "context");
        roundButton.setProgressBgColor(ColorKt.a(e8, context4));
        Color f8 = type.f();
        Context context5 = roundButton.getContext();
        Intrinsics.e(context5, "context");
        roundButton.setProgressColor(ColorKt.a(f8, context5));
    }
}
