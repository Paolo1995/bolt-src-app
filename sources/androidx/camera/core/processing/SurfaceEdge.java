package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SurfaceEdge {
    @NonNull
    public static SurfaceEdge a(@NonNull List<SettableSurface> list) {
        return new AutoValue_SurfaceEdge(list);
    }

    @NonNull
    public abstract List<SettableSurface> b();
}
