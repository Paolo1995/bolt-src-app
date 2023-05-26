package android.graphics;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.util.Size;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final /* synthetic */ class ImageDecoder implements AutoCloseable {

    /* loaded from: classes.dex */
    public /* synthetic */ class ImageInfo {
        static {
            throw new NoClassDefFoundError();
        }

        @Nullable
        public native /* synthetic */ ColorSpace getColorSpace();

        @NonNull
        public native /* synthetic */ Size getSize();
    }

    /* loaded from: classes.dex */
    public /* synthetic */ interface OnHeaderDecodedListener {
        static {
            throw new NoClassDefFoundError();
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ interface OnPartialImageListener {
        static {
            throw new NoClassDefFoundError();
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class Source {
        static {
            throw new NoClassDefFoundError();
        }
    }

    static {
        throw new NoClassDefFoundError();
    }

    @NonNull
    public static native /* synthetic */ Source createSource(@NonNull ByteBuffer byteBuffer);

    @NonNull
    public static native /* synthetic */ Bitmap decodeBitmap(@NonNull Source source, @NonNull OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    public native /* synthetic */ void setAllocator(int i8);

    public native /* synthetic */ void setMemorySizePolicy(int i8);

    public native /* synthetic */ void setOnPartialImageListener(@Nullable OnPartialImageListener onPartialImageListener);

    public native /* synthetic */ void setTargetColorSpace(ColorSpace colorSpace);

    public native /* synthetic */ void setTargetSize(int i8, int i9);
}
