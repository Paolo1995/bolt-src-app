package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class CameraRepository {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3602a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, CameraInternal> f3603b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Set<CameraInternal> f3604c = new HashSet();

    @NonNull
    public LinkedHashSet<CameraInternal> a() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.f3602a) {
            linkedHashSet = new LinkedHashSet<>(this.f3603b.values());
        }
        return linkedHashSet;
    }

    public void b(@NonNull CameraFactory cameraFactory) throws InitializationException {
        synchronized (this.f3602a) {
            try {
                try {
                    for (String str : cameraFactory.b()) {
                        Logger.a("CameraRepository", "Added camera: " + str);
                        this.f3603b.put(str, cameraFactory.a(str));
                    }
                } catch (CameraUnavailableException e8) {
                    throw new InitializationException(e8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
