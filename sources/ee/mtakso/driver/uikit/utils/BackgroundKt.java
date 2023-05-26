package ee.mtakso.driver.uikit.utils;

import android.content.Context;
import android.view.View;
import ee.mtakso.driver.uikit.utils.Background;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Background.kt */
/* loaded from: classes5.dex */
public final class BackgroundKt {
    public static final int a(Background background, Context context) {
        Intrinsics.f(background, "<this>");
        Intrinsics.f(context, "context");
        if (background instanceof Background.Res) {
            return ((Background.Res) background).a();
        }
        if (background instanceof Background.Attr) {
            return ContextUtilsKt.d(context, ((Background.Attr) background).a());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void b(Background background, View view) {
        Intrinsics.f(view, "view");
        if (background != null) {
            Context context = view.getContext();
            Intrinsics.e(context, "view.context");
            view.setBackgroundResource(a(background, context));
        }
    }
}
