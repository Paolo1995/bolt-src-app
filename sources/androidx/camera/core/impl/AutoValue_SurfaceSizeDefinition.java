package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class AutoValue_SurfaceSizeDefinition extends SurfaceSizeDefinition {

    /* renamed from: a  reason: collision with root package name */
    private final Size f3546a;

    /* renamed from: b  reason: collision with root package name */
    private final Size f3547b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f3548c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SurfaceSizeDefinition(Size size, Size size2, Size size3) {
        if (size != null) {
            this.f3546a = size;
            if (size2 != null) {
                this.f3547b = size2;
                if (size3 != null) {
                    this.f3548c = size3;
                    return;
                }
                throw new NullPointerException("Null recordSize");
            }
            throw new NullPointerException("Null previewSize");
        }
        throw new NullPointerException("Null analysisSize");
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    @NonNull
    public Size b() {
        return this.f3546a;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    @NonNull
    public Size c() {
        return this.f3547b;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    @NonNull
    public Size d() {
        return this.f3548c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceSizeDefinition)) {
            return false;
        }
        SurfaceSizeDefinition surfaceSizeDefinition = (SurfaceSizeDefinition) obj;
        if (this.f3546a.equals(surfaceSizeDefinition.b()) && this.f3547b.equals(surfaceSizeDefinition.c()) && this.f3548c.equals(surfaceSizeDefinition.d())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3546a.hashCode() ^ 1000003) * 1000003) ^ this.f3547b.hashCode()) * 1000003) ^ this.f3548c.hashCode();
    }

    public String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.f3546a + ", previewSize=" + this.f3547b + ", recordSize=" + this.f3548c + "}";
    }
}
