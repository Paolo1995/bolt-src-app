package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageProxy extends AutoCloseable {

    /* loaded from: classes.dex */
    public interface PlaneProxy {
        @NonNull
        ByteBuffer b();

        int c();

        int d();
    }

    @NonNull
    ImageInfo O0();

    Image V0();

    void W(Rect rect);

    @Override // java.lang.AutoCloseable
    void close();

    int getFormat();

    int getHeight();

    int getWidth();

    @NonNull
    @SuppressLint({"ArrayReturn"})
    PlaneProxy[] n0();

    @NonNull
    Rect x0();
}
