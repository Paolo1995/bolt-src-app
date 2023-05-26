package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.content.res.TypedArray;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class vl {
    public static final String a(TypedArray typedArray, int i8, Context context) {
        Intrinsics.f(typedArray, "<this>");
        Intrinsics.f(context, "context");
        int resourceId = typedArray.getResourceId(i8, -1);
        return resourceId != -1 ? context.getResources().getString(resourceId) : typedArray.getString(i8);
    }
}
