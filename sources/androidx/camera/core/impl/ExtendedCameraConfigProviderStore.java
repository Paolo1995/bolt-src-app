package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ExtendedCameraConfigProviderStore {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3650a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Object, CameraConfigProvider> f3651b = new HashMap();

    private ExtendedCameraConfigProviderStore() {
    }

    @NonNull
    public static CameraConfigProvider a(@NonNull Object obj) {
        CameraConfigProvider cameraConfigProvider;
        synchronized (f3650a) {
            cameraConfigProvider = f3651b.get(obj);
        }
        if (cameraConfigProvider == null) {
            return CameraConfigProvider.f3589a;
        }
        return cameraConfigProvider;
    }
}
