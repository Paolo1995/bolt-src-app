package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f10568a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceDecoder<ByteBuffer, GifDrawable> f10569b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f10570c;

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.f10568a = list;
        this.f10569b = resourceDecoder;
        this.f10570c = arrayPool;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e8) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e8);
                return null;
            }
            return null;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<GifDrawable> b(@NonNull InputStream inputStream, int i8, int i9, @NonNull Options options) throws IOException {
        byte[] e8 = e(inputStream);
        if (e8 == null) {
            return null;
        }
        return this.f10569b.b(ByteBuffer.wrap(e8), i8, i9, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull Options options) throws IOException {
        if (!((Boolean) options.c(GifOptions.f10567b)).booleanValue() && ImageHeaderParserUtils.e(this.f10568a, inputStream, this.f10570c) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }
}
