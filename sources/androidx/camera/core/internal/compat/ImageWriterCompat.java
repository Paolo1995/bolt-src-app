package androidx.camera.core.internal.compat;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class ImageWriterCompat {
    private ImageWriterCompat() {
    }

    @NonNull
    public static ImageWriter a(@NonNull Surface surface, int i8) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 23) {
            return ImageWriterCompatApi23Impl.a(surface, i8);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int) on API " + i9 + ". Version 23 or higher required.");
    }

    @NonNull
    public static ImageWriter b(@NonNull Surface surface, int i8, int i9) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            return ImageWriterCompatApi29Impl.a(surface, i8, i9);
        }
        if (i10 >= 26) {
            return ImageWriterCompatApi26Impl.a(surface, i8, i9);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + i10 + ". Version 26 or higher required.");
    }

    public static void c(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 23) {
            ImageWriterCompatApi23Impl.b(imageWriter, image);
            return;
        }
        throw new RuntimeException("Unable to call queueInputImage() on API " + i8 + ". Version 23 or higher required.");
    }
}
