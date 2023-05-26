package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList a(@NonNull Context context, int i8) {
        return ContextCompat.getColorStateList(context, i8);
    }

    public static Drawable b(@NonNull Context context, int i8) {
        return ResourceManagerInternal.h().j(context, i8);
    }
}
