package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class AttachedSurfaceInfo {
    @NonNull
    public static AttachedSurfaceInfo a(@NonNull SurfaceConfig surfaceConfig, int i8, @NonNull Size size, Range<Integer> range) {
        return new AutoValue_AttachedSurfaceInfo(surfaceConfig, i8, size, range);
    }

    public abstract int b();

    @NonNull
    public abstract Size c();

    @NonNull
    public abstract SurfaceConfig d();

    public abstract Range<Integer> e();
}
