package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.SessionConfig;

/* loaded from: classes.dex */
interface ZslControl {
    void a(@NonNull SessionConfig.Builder builder);

    boolean b();

    void c(boolean z7);

    void d(boolean z7);

    ImageProxy e();

    boolean f(@NonNull ImageProxy imageProxy);

    boolean g();
}
