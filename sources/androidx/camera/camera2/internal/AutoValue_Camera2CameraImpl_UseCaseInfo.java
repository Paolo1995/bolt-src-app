package androidx.camera.camera2.internal;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_Camera2CameraImpl_UseCaseInfo extends Camera2CameraImpl.UseCaseInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f2378a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f2379b;

    /* renamed from: c  reason: collision with root package name */
    private final SessionConfig f2380c;

    /* renamed from: d  reason: collision with root package name */
    private final UseCaseConfig<?> f2381d;

    /* renamed from: e  reason: collision with root package name */
    private final Size f2382e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Camera2CameraImpl_UseCaseInfo(String str, Class<?> cls, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, Size size) {
        if (str != null) {
            this.f2378a = str;
            if (cls != null) {
                this.f2379b = cls;
                if (sessionConfig != null) {
                    this.f2380c = sessionConfig;
                    if (useCaseConfig != null) {
                        this.f2381d = useCaseConfig;
                        this.f2382e = size;
                        return;
                    }
                    throw new NullPointerException("Null useCaseConfig");
                }
                throw new NullPointerException("Null sessionConfig");
            }
            throw new NullPointerException("Null useCaseType");
        }
        throw new NullPointerException("Null useCaseId");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @NonNull
    public SessionConfig c() {
        return this.f2380c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    public Size d() {
        return this.f2382e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @NonNull
    public UseCaseConfig<?> e() {
        return this.f2381d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Camera2CameraImpl.UseCaseInfo)) {
            return false;
        }
        Camera2CameraImpl.UseCaseInfo useCaseInfo = (Camera2CameraImpl.UseCaseInfo) obj;
        if (this.f2378a.equals(useCaseInfo.f()) && this.f2379b.equals(useCaseInfo.g()) && this.f2380c.equals(useCaseInfo.c()) && this.f2381d.equals(useCaseInfo.e())) {
            Size size = this.f2382e;
            if (size == null) {
                if (useCaseInfo.d() == null) {
                    return true;
                }
            } else if (size.equals(useCaseInfo.d())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @NonNull
    public String f() {
        return this.f2378a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.camera2.internal.Camera2CameraImpl.UseCaseInfo
    @NonNull
    public Class<?> g() {
        return this.f2379b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((((((this.f2378a.hashCode() ^ 1000003) * 1000003) ^ this.f2379b.hashCode()) * 1000003) ^ this.f2380c.hashCode()) * 1000003) ^ this.f2381d.hashCode()) * 1000003;
        Size size = this.f2382e;
        if (size == null) {
            hashCode = 0;
        } else {
            hashCode = size.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "UseCaseInfo{useCaseId=" + this.f2378a + ", useCaseType=" + this.f2379b + ", sessionConfig=" + this.f2380c + ", useCaseConfig=" + this.f2381d + ", surfaceResolution=" + this.f2382e + "}";
    }
}
