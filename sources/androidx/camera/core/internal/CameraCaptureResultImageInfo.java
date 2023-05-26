package androidx.camera.core.internal;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* loaded from: classes.dex */
public final class CameraCaptureResultImageInfo implements ImageInfo {

    /* renamed from: a  reason: collision with root package name */
    private final CameraCaptureResult f3892a;

    public CameraCaptureResultImageInfo(@NonNull CameraCaptureResult cameraCaptureResult) {
        this.f3892a = cameraCaptureResult;
    }

    @Override // androidx.camera.core.ImageInfo
    public void a(@NonNull ExifData.Builder builder) {
        this.f3892a.a(builder);
    }

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public TagBundle b() {
        return this.f3892a.b();
    }

    @Override // androidx.camera.core.ImageInfo
    public int c() {
        return 0;
    }

    @Override // androidx.camera.core.ImageInfo
    public long d() {
        return this.f3892a.d();
    }

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public Matrix e() {
        return new Matrix();
    }

    @NonNull
    public CameraCaptureResult f() {
        return this.f3892a;
    }
}
