package androidx.camera.core;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_SurfaceRequest_TransformationInfo extends SurfaceRequest.TransformationInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f3041a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3042b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3043c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SurfaceRequest_TransformationInfo(Rect rect, int i8, int i9) {
        if (rect != null) {
            this.f3041a = rect;
            this.f3042b = i8;
            this.f3043c = i9;
            return;
        }
        throw new NullPointerException("Null cropRect");
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    @NonNull
    public Rect a() {
        return this.f3041a;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public int b() {
        return this.f3042b;
    }

    @Override // androidx.camera.core.SurfaceRequest.TransformationInfo
    public int c() {
        return this.f3043c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.TransformationInfo)) {
            return false;
        }
        SurfaceRequest.TransformationInfo transformationInfo = (SurfaceRequest.TransformationInfo) obj;
        if (this.f3041a.equals(transformationInfo.a()) && this.f3042b == transformationInfo.b() && this.f3043c == transformationInfo.c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3041a.hashCode() ^ 1000003) * 1000003) ^ this.f3042b) * 1000003) ^ this.f3043c;
    }

    public String toString() {
        return "TransformationInfo{cropRect=" + this.f3041a + ", rotationDegrees=" + this.f3042b + ", targetRotation=" + this.f3043c + "}";
    }
}
