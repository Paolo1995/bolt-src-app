package androidx.camera.core.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class AutoValue_CameraThreadConfig extends CameraThreadConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3527a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3528b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CameraThreadConfig(Executor executor, Handler handler) {
        if (executor != null) {
            this.f3527a = executor;
            if (handler != null) {
                this.f3528b = handler;
                return;
            }
            throw new NullPointerException("Null schedulerHandler");
        }
        throw new NullPointerException("Null cameraExecutor");
    }

    @Override // androidx.camera.core.impl.CameraThreadConfig
    @NonNull
    public Executor b() {
        return this.f3527a;
    }

    @Override // androidx.camera.core.impl.CameraThreadConfig
    @NonNull
    public Handler c() {
        return this.f3528b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraThreadConfig)) {
            return false;
        }
        CameraThreadConfig cameraThreadConfig = (CameraThreadConfig) obj;
        if (this.f3527a.equals(cameraThreadConfig.b()) && this.f3528b.equals(cameraThreadConfig.c())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3527a.hashCode() ^ 1000003) * 1000003) ^ this.f3528b.hashCode();
    }

    public String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.f3527a + ", schedulerHandler=" + this.f3528b + "}";
    }
}
