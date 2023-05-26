package androidx.appcompat.resources;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class Compatibility$Api15Impl {
    private Compatibility$Api15Impl() {
    }

    public static void a(@NonNull Resources resources, int i8, int i9, @NonNull TypedValue typedValue, boolean z7) {
        resources.getValueForDensity(i8, i9, typedValue, z7);
    }
}
