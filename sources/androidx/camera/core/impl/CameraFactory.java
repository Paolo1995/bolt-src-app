package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import java.util.Set;

/* loaded from: classes.dex */
public interface CameraFactory {

    /* loaded from: classes.dex */
    public interface Provider {
        @NonNull
        CameraFactory a(@NonNull Context context, @NonNull CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) throws InitializationException;
    }

    @NonNull
    CameraInternal a(@NonNull String str) throws CameraUnavailableException;

    @NonNull
    Set<String> b();

    Object c();
}
