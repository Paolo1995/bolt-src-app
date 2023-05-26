package eu.bolt.android.engine.html.util;

import android.content.Context;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextExt.kt */
/* loaded from: classes5.dex */
public final class ContextExtKt {
    public static final float a(Context context, float f8) {
        Intrinsics.f(context, "<this>");
        return TypedValue.applyDimension(2, f8, context.getResources().getDisplayMetrics());
    }
}
