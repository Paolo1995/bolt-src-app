package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class AutoValue_OutputSurface extends OutputSurface {

    /* renamed from: a  reason: collision with root package name */
    private final Surface f3533a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f3534b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3535c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_OutputSurface(Surface surface, Size size, int i8) {
        if (surface != null) {
            this.f3533a = surface;
            if (size != null) {
                this.f3534b = size;
                this.f3535c = i8;
                return;
            }
            throw new NullPointerException("Null size");
        }
        throw new NullPointerException("Null surface");
    }

    @Override // androidx.camera.core.impl.OutputSurface
    public int b() {
        return this.f3535c;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    @NonNull
    public Size c() {
        return this.f3534b;
    }

    @Override // androidx.camera.core.impl.OutputSurface
    @NonNull
    public Surface d() {
        return this.f3533a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OutputSurface)) {
            return false;
        }
        OutputSurface outputSurface = (OutputSurface) obj;
        if (this.f3533a.equals(outputSurface.d()) && this.f3534b.equals(outputSurface.c()) && this.f3535c == outputSurface.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3533a.hashCode() ^ 1000003) * 1000003) ^ this.f3534b.hashCode()) * 1000003) ^ this.f3535c;
    }

    public String toString() {
        return "OutputSurface{surface=" + this.f3533a + ", size=" + this.f3534b + ", imageFormat=" + this.f3535c + "}";
    }
}
