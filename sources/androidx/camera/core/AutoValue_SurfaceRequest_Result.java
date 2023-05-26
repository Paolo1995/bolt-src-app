package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_SurfaceRequest_Result extends SurfaceRequest.Result {

    /* renamed from: a  reason: collision with root package name */
    private final int f3039a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f3040b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SurfaceRequest_Result(int i8, Surface surface) {
        this.f3039a = i8;
        if (surface != null) {
            this.f3040b = surface;
            return;
        }
        throw new NullPointerException("Null surface");
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    public int a() {
        return this.f3039a;
    }

    @Override // androidx.camera.core.SurfaceRequest.Result
    @NonNull
    public Surface b() {
        return this.f3040b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.Result)) {
            return false;
        }
        SurfaceRequest.Result result = (SurfaceRequest.Result) obj;
        if (this.f3039a == result.a() && this.f3040b.equals(result.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3039a ^ 1000003) * 1000003) ^ this.f3040b.hashCode();
    }

    public String toString() {
        return "Result{resultCode=" + this.f3039a + ", surface=" + this.f3040b + "}";
    }
}
