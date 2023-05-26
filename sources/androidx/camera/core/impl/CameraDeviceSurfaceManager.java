package androidx.camera.core.impl;

import android.content.Context;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public interface CameraDeviceSurfaceManager {

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        CameraDeviceSurfaceManager a(@NonNull Context context, Object obj, @NonNull Set<String> set) throws InitializationException;
    }

    SurfaceConfig a(@NonNull String str, int i8, @NonNull Size size);

    @NonNull
    Map<UseCaseConfig<?>, Size> b(@NonNull String str, @NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2);
}
