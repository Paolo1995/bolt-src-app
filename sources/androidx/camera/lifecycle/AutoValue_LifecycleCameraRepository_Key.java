package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes.dex */
final class AutoValue_LifecycleCameraRepository_Key extends LifecycleCameraRepository.Key {

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleOwner f4051a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraUseCaseAdapter.CameraId f4052b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LifecycleCameraRepository_Key(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        if (lifecycleOwner != null) {
            this.f4051a = lifecycleOwner;
            if (cameraId != null) {
                this.f4052b = cameraId;
                return;
            }
            throw new NullPointerException("Null cameraId");
        }
        throw new NullPointerException("Null lifecycleOwner");
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public CameraUseCaseAdapter.CameraId b() {
        return this.f4052b;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public LifecycleOwner c() {
        return this.f4051a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LifecycleCameraRepository.Key)) {
            return false;
        }
        LifecycleCameraRepository.Key key = (LifecycleCameraRepository.Key) obj;
        if (this.f4051a.equals(key.c()) && this.f4052b.equals(key.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4051a.hashCode() ^ 1000003) * 1000003) ^ this.f4052b.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.f4051a + ", cameraId=" + this.f4052b + "}";
    }
}
