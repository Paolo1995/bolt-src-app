package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f  reason: collision with root package name */
    private static final GifDecoderFactory f10518f = new GifDecoderFactory();

    /* renamed from: g  reason: collision with root package name */
    private static final GifHeaderParserPool f10519g = new GifHeaderParserPool();

    /* renamed from: a  reason: collision with root package name */
    private final Context f10520a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f10521b;

    /* renamed from: c  reason: collision with root package name */
    private final GifHeaderParserPool f10522c;

    /* renamed from: d  reason: collision with root package name */
    private final GifDecoderFactory f10523d;

    /* renamed from: e  reason: collision with root package name */
    private final GifBitmapProvider f10524e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        GifDecoder a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i8) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GifHeaderParserPool {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<GifHeaderParser> f10525a = Util.f(0);

        GifHeaderParserPool() {
        }

        synchronized GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.f10525a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.p(byteBuffer);
        }

        synchronized void b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.a();
            this.f10525a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f10519g, f10518f);
    }

    private GifDrawableResource c(ByteBuffer byteBuffer, int i8, int i9, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long b8 = LogTime.b();
        try {
            GifHeader c8 = gifHeaderParser.c();
            if (c8.b() > 0 && c8.c() == 0) {
                if (options.c(GifOptions.f10566a) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                GifDecoder a8 = this.f10523d.a(this.f10524e, c8, byteBuffer, e(c8, i8, i9));
                a8.c(config);
                a8.a();
                Bitmap nextFrame = a8.getNextFrame();
                if (nextFrame == null) {
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f10520a, a8, UnitTransformation.c(), i8, i9, nextFrame));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b8));
                }
                return gifDrawableResource;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b8));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b8));
            }
        }
    }

    private static int e(GifHeader gifHeader, int i8, int i9) {
        int highestOneBit;
        int min = Math.min(gifHeader.a() / i9, gifHeader.d() / i8);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i8 + "x" + i9 + "], actual dimens: [" + gifHeader.d() + "x" + gifHeader.a() + "]");
        }
        return max;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public GifDrawableResource b(@NonNull ByteBuffer byteBuffer, int i8, int i9, @NonNull Options options) {
        GifHeaderParser a8 = this.f10522c.a(byteBuffer);
        try {
            return c(byteBuffer, i8, i9, a8, options);
        } finally {
            this.f10522c.b(a8);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: f */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        if (!((Boolean) options.c(GifOptions.f10567b)).booleanValue() && ImageHeaderParserUtils.f(this.f10521b, byteBuffer) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }

    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.f10520a = context.getApplicationContext();
        this.f10521b = list;
        this.f10523d = gifDecoderFactory;
        this.f10524e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f10522c = gifHeaderParserPool;
    }
}
