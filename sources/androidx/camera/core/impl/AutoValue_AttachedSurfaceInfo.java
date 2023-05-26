package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AutoValue_AttachedSurfaceInfo extends AttachedSurfaceInfo {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceConfig f3523a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3524b;

    /* renamed from: c  reason: collision with root package name */
    private final Size f3525c;

    /* renamed from: d  reason: collision with root package name */
    private final Range<Integer> f3526d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AttachedSurfaceInfo(SurfaceConfig surfaceConfig, int i8, Size size, Range<Integer> range) {
        if (surfaceConfig != null) {
            this.f3523a = surfaceConfig;
            this.f3524b = i8;
            if (size != null) {
                this.f3525c = size;
                this.f3526d = range;
                return;
            }
            throw new NullPointerException("Null size");
        }
        throw new NullPointerException("Null surfaceConfig");
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public int b() {
        return this.f3524b;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    @NonNull
    public Size c() {
        return this.f3525c;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    @NonNull
    public SurfaceConfig d() {
        return this.f3523a;
    }

    @Override // androidx.camera.core.impl.AttachedSurfaceInfo
    public Range<Integer> e() {
        return this.f3526d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttachedSurfaceInfo)) {
            return false;
        }
        AttachedSurfaceInfo attachedSurfaceInfo = (AttachedSurfaceInfo) obj;
        if (this.f3523a.equals(attachedSurfaceInfo.d()) && this.f3524b == attachedSurfaceInfo.b() && this.f3525c.equals(attachedSurfaceInfo.c())) {
            Range<Integer> range = this.f3526d;
            if (range == null) {
                if (attachedSurfaceInfo.e() == null) {
                    return true;
                }
            } else if (range.equals(attachedSurfaceInfo.e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((((this.f3523a.hashCode() ^ 1000003) * 1000003) ^ this.f3524b) * 1000003) ^ this.f3525c.hashCode()) * 1000003;
        Range<Integer> range = this.f3526d;
        if (range == null) {
            hashCode = 0;
        } else {
            hashCode = range.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "AttachedSurfaceInfo{surfaceConfig=" + this.f3523a + ", imageFormat=" + this.f3524b + ", size=" + this.f3525c + ", targetFrameRate=" + this.f3526d + "}";
    }
}
