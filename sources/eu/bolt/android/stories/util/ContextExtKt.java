package eu.bolt.android.stories.util;

import android.app.Activity;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextExt.kt */
/* loaded from: classes5.dex */
public final class ContextExtKt {
    public static final boolean a(Context context) {
        Intrinsics.f(context, "<this>");
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return false;
            }
        }
        return true;
    }
}
