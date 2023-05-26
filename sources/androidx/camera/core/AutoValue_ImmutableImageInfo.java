package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.TagBundle;

/* loaded from: classes.dex */
final class AutoValue_ImmutableImageInfo extends ImmutableImageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final TagBundle f3033a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3034b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3035c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f3036d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ImmutableImageInfo(TagBundle tagBundle, long j8, int i8, Matrix matrix) {
        if (tagBundle != null) {
            this.f3033a = tagBundle;
            this.f3034b = j8;
            this.f3035c = i8;
            if (matrix != null) {
                this.f3036d = matrix;
                return;
            }
            throw new NullPointerException("Null sensorToBufferTransformMatrix");
        }
        throw new NullPointerException("Null tagBundle");
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    @NonNull
    public TagBundle b() {
        return this.f3033a;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public int c() {
        return this.f3035c;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public long d() {
        return this.f3034b;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    @NonNull
    public Matrix e() {
        return this.f3036d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableImageInfo)) {
            return false;
        }
        ImmutableImageInfo immutableImageInfo = (ImmutableImageInfo) obj;
        if (this.f3033a.equals(immutableImageInfo.b()) && this.f3034b == immutableImageInfo.d() && this.f3035c == immutableImageInfo.c() && this.f3036d.equals(immutableImageInfo.e())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f3034b;
        return ((((((this.f3033a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f3035c) * 1000003) ^ this.f3036d.hashCode();
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.f3033a + ", timestamp=" + this.f3034b + ", rotationDegrees=" + this.f3035c + ", sensorToBufferTransformMatrix=" + this.f3036d + "}";
    }
}
