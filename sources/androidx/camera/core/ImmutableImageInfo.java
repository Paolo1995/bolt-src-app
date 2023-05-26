package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* loaded from: classes.dex */
public abstract class ImmutableImageInfo implements ImageInfo {
    @NonNull
    public static ImageInfo f(@NonNull TagBundle tagBundle, long j8, int i8, @NonNull Matrix matrix) {
        return new AutoValue_ImmutableImageInfo(tagBundle, j8, i8, matrix);
    }

    @Override // androidx.camera.core.ImageInfo
    public void a(@NonNull ExifData.Builder builder) {
        builder.m(c());
    }

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public abstract TagBundle b();

    @Override // androidx.camera.core.ImageInfo
    public abstract int c();

    @Override // androidx.camera.core.ImageInfo
    public abstract long d();

    @Override // androidx.camera.core.ImageInfo
    @NonNull
    public abstract Matrix e();
}
