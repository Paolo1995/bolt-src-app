package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class SurfaceSizeDefinition {
    @NonNull
    public static SurfaceSizeDefinition a(@NonNull Size size, @NonNull Size size2, @NonNull Size size3) {
        return new AutoValue_SurfaceSizeDefinition(size, size2, size3);
    }

    @NonNull
    public abstract Size b();

    @NonNull
    public abstract Size c();

    @NonNull
    public abstract Size d();
}
