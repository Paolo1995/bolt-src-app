package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        

        /* renamed from: f  reason: collision with root package name */
        private final boolean f9914f;

        ImageType(boolean z7) {
            this.f9914f = z7;
        }

        public boolean hasAlpha() {
            return this.f9914f;
        }
    }

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException;

    @NonNull
    ImageType b(@NonNull InputStream inputStream) throws IOException;

    int c(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException;
}
