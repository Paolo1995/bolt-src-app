package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SurfaceConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_SurfaceConfig extends SurfaceConfig {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceConfig.ConfigType f3544a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceConfig.ConfigSize f3545b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SurfaceConfig(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize) {
        if (configType != null) {
            this.f3544a = configType;
            if (configSize != null) {
                this.f3545b = configSize;
                return;
            }
            throw new NullPointerException("Null configSize");
        }
        throw new NullPointerException("Null configType");
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    @NonNull
    public SurfaceConfig.ConfigSize b() {
        return this.f3545b;
    }

    @Override // androidx.camera.core.impl.SurfaceConfig
    @NonNull
    public SurfaceConfig.ConfigType c() {
        return this.f3544a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
        if (this.f3544a.equals(surfaceConfig.c()) && this.f3545b.equals(surfaceConfig.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3544a.hashCode() ^ 1000003) * 1000003) ^ this.f3545b.hashCode();
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.f3544a + ", configSize=" + this.f3545b + "}";
    }
}
