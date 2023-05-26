package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class s9 {
    public static final Drawable a(TypedArray typedArray, Context context, int i8) {
        Intrinsics.f(typedArray, "<this>");
        Intrinsics.f(context, "context");
        int resourceId = typedArray.getResourceId(i8, 0);
        if (resourceId != 0) {
            return AppCompatResources.b(context, resourceId);
        }
        return null;
    }
}
