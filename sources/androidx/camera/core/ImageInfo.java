package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/* loaded from: classes.dex */
public interface ImageInfo {
    void a(@NonNull ExifData.Builder builder);

    @NonNull
    TagBundle b();

    int c();

    long d();

    @NonNull
    Matrix e();
}
