package androidx.camera.core;

import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageReaderProxy;

/* loaded from: classes.dex */
public final class ImageReaderProxys {
    private ImageReaderProxys() {
    }

    @NonNull
    public static ImageReaderProxy a(int i8, int i9, int i10, int i11) {
        return new AndroidImageReaderProxy(ImageReader.newInstance(i8, i9, i10, i11));
    }
}
