package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class OutputSurface {
    @NonNull
    public static OutputSurface a(@NonNull Surface surface, @NonNull Size size, int i8) {
        return new AutoValue_OutputSurface(surface, size, i8);
    }

    public abstract int b();

    @NonNull
    public abstract Size c();

    @NonNull
    public abstract Surface d();
}
