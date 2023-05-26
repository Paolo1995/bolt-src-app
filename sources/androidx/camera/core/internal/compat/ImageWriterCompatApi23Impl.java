package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
final class ImageWriterCompatApi23Impl {
    private ImageWriterCompatApi23Impl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static ImageWriter a(@NonNull Surface surface, int i8) {
        return ImageWriter.newInstance(surface, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        imageWriter.queueInputImage(image);
    }
}
