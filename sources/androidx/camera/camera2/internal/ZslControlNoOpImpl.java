package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

/* loaded from: classes.dex */
public class ZslControlNoOpImpl implements ZslControl {
    @Override // androidx.camera.camera2.internal.ZslControl
    public void a(@NonNull SessionConfig.Builder builder) {
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean b() {
        return false;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void c(boolean z7) {
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void d(boolean z7) {
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public ImageProxy e() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean f(@NonNull ImageProxy imageProxy) {
        return false;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean g() {
        return false;
    }
}
