package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class ImageWriterCompatApi29Impl {
    private ImageWriterCompatApi29Impl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static ImageWriter a(@NonNull Surface surface, int i8, int i9) {
        ImageWriter newInstance;
        newInstance = ImageWriter.newInstance(surface, i8, i9);
        return newInstance;
    }
}
