package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    public static final Option<Long> f10503d = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.1

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10509a = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        /* renamed from: b */
        public void a(@NonNull byte[] bArr, @NonNull Long l8, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f10509a) {
                this.f10509a.position(0);
                messageDigest.update(this.f10509a.putLong(l8.longValue()).array());
            }
        }
    });

    /* renamed from: e  reason: collision with root package name */
    public static final Option<Integer> f10504e = Option.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.2

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f10510a = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        /* renamed from: b */
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f10510a) {
                this.f10510a.position(0);
                messageDigest.update(this.f10510a.putInt(num.intValue()).array());
            }
        }
    });

    /* renamed from: f  reason: collision with root package name */
    private static final MediaMetadataRetrieverFactory f10505f = new MediaMetadataRetrieverFactory();

    /* renamed from: a  reason: collision with root package name */
    private final MediaMetadataRetrieverInitializer<T> f10506a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapPool f10507b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaMetadataRetrieverFactory f10508c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        ByteBufferInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, final ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new MediaDataSource() { // from class: com.bumptech.glide.load.resource.bitmap.VideoDecoder.ByteBufferInitializer.1
                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                public long getSize() {
                    return byteBuffer.limit();
                }

                public int readAt(long j8, byte[] bArr, int i8, int i9) {
                    if (j8 >= byteBuffer.limit()) {
                        return -1;
                    }
                    byteBuffer.position((int) j8);
                    int min = Math.min(i9, byteBuffer.remaining());
                    byteBuffer.get(bArr, i8, min);
                    return min;
                }
            });
        }
    }

    /* loaded from: classes.dex */
    static class MediaMetadataRetrieverFactory {
        MediaMetadataRetrieverFactory() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MediaMetadataRetrieverInitializer<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        ParcelFileDescriptorInitializer() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.MediaMetadataRetrieverInitializer
        /* renamed from: b */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class VideoDecoderException extends RuntimeException {
        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool, mediaMetadataRetrieverInitializer, f10505f);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> c(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new AssetFileDescriptorInitializer());
    }

    public static ResourceDecoder<ByteBuffer, Bitmap> d(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ByteBufferInitializer());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j8, int i8, int i9, int i10, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT >= 27 && i9 != Integer.MIN_VALUE && i10 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.f10439f) {
            bitmap = g(mediaMetadataRetriever, j8, i8, i9, i10, downsampleStrategy);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = f(mediaMetadataRetriever, j8, i8);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j8, int i8) {
        return mediaMetadataRetriever.getFrameAtTime(j8, i8);
    }

    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j8, int i8, int i9, int i10, DownsampleStrategy downsampleStrategy) {
        Bitmap scaledFrameAtTime;
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b8 = downsampleStrategy.b(parseInt, parseInt2, i9, i10);
            scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j8, i8, Math.round(parseInt * b8), Math.round(b8 * parseInt2));
            return scaledFrameAtTime;
        } catch (Throwable th) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                return null;
            }
            return null;
        }
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> h(BitmapPool bitmapPool) {
        return new VideoDecoder(bitmapPool, new ParcelFileDescriptorInitializer());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(@NonNull T t7, @NonNull Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> b(@NonNull T t7, int i8, int i9, @NonNull Options options) throws IOException {
        long longValue = ((Long) options.c(f10503d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) options.c(f10504e);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f10441h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f10440g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a8 = this.f10508c.a();
        try {
            this.f10506a.a(a8, t7);
            Bitmap e8 = e(a8, longValue, num.intValue(), i8, i9, downsampleStrategy2);
            a8.release();
            return BitmapResource.f(e8, this.f10507b);
        } catch (Throwable th) {
            a8.release();
            throw th;
        }
    }

    VideoDecoder(BitmapPool bitmapPool, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.f10507b = bitmapPool;
        this.f10506a = mediaMetadataRetrieverInitializer;
        this.f10508c = mediaMetadataRetrieverFactory;
    }
}
