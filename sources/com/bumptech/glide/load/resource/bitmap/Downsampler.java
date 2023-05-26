package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes.dex */
public final class Downsampler {

    /* renamed from: f  reason: collision with root package name */
    public static final Option<DecodeFormat> f10446f = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f9907h);

    /* renamed from: g  reason: collision with root package name */
    public static final Option<PreferredColorSpace> f10447g = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f10448h = DownsampleStrategy.f10441h;

    /* renamed from: i  reason: collision with root package name */
    public static final Option<Boolean> f10449i;

    /* renamed from: j  reason: collision with root package name */
    public static final Option<Boolean> f10450j;

    /* renamed from: k  reason: collision with root package name */
    private static final Set<String> f10451k;

    /* renamed from: l  reason: collision with root package name */
    private static final DecodeCallbacks f10452l;

    /* renamed from: m  reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f10453m;

    /* renamed from: n  reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f10454n;

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f10455a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f10456b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f10457c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f10458d;

    /* renamed from: e  reason: collision with root package name */
    private final HardwareConfigState f10459e = HardwareConfigState.b();

    /* loaded from: classes.dex */
    public interface DecodeCallbacks {
        void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f10449i = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f10450j = Option.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f10451k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f10452l = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void a(BitmapPool bitmapPool, Bitmap bitmap) {
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void b() {
            }
        };
        f10453m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f10454n = Util.f(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f10458d = list;
        this.f10456b = (DisplayMetrics) Preconditions.d(displayMetrics);
        this.f10455a = (BitmapPool) Preconditions.d(bitmapPool);
        this.f10457c = (ArrayPool) Preconditions.d(arrayPool);
    }

    private static int a(double d8) {
        int l8 = l(d8);
        int x7 = x(l8 * d8);
        return x((d8 / (x7 / l8)) * x7);
    }

    private void b(ImageReader imageReader, DecodeFormat decodeFormat, boolean z7, boolean z8, BitmapFactory.Options options, int i8, int i9) {
        Bitmap.Config config;
        if (this.f10459e.i(i8, i9, options, z7, z8)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
            boolean z9 = false;
            try {
                z9 = imageReader.d().hasAlpha();
            } catch (IOException e8) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e8);
                }
            }
            if (z9) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i8, int i9, int i10, int i11, int i12, BitmapFactory.Options options) throws IOException {
        int i13;
        int i14;
        int min;
        int i15;
        int floor;
        double floor2;
        int i16;
        if (i9 > 0 && i10 > 0) {
            if (r(i8)) {
                i14 = i9;
                i13 = i10;
            } else {
                i13 = i9;
                i14 = i10;
            }
            float b8 = downsampleStrategy.b(i13, i14, i11, i12);
            if (b8 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding a8 = downsampleStrategy.a(i13, i14, i11, i12);
                if (a8 != null) {
                    float f8 = i13;
                    float f9 = i14;
                    int x7 = i13 / x(b8 * f8);
                    int x8 = i14 / x(b8 * f9);
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (a8 == sampleSizeRounding) {
                        min = Math.max(x7, x8);
                    } else {
                        min = Math.min(x7, x8);
                    }
                    int i17 = Build.VERSION.SDK_INT;
                    if (i17 > 23 || !f10451k.contains(options.outMimeType)) {
                        int max = Math.max(1, Integer.highestOneBit(min));
                        if (a8 == sampleSizeRounding && max < 1.0f / b8) {
                            max <<= 1;
                        }
                        i15 = max;
                    } else {
                        i15 = 1;
                    }
                    options.inSampleSize = i15;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min2 = Math.min(i15, 8);
                        floor = (int) Math.ceil(f8 / min2);
                        i16 = (int) Math.ceil(f9 / min2);
                        int i18 = i15 / 8;
                        if (i18 > 0) {
                            floor /= i18;
                            i16 /= i18;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                                if (i17 >= 24) {
                                    float f10 = i15;
                                    floor = Math.round(f8 / f10);
                                    i16 = Math.round(f9 / f10);
                                } else {
                                    float f11 = i15;
                                    floor = (int) Math.floor(f8 / f11);
                                    floor2 = Math.floor(f9 / f11);
                                }
                            } else if (i13 % i15 == 0 && i14 % i15 == 0) {
                                floor = i13 / i15;
                                i16 = i14 / i15;
                            } else {
                                int[] m8 = m(imageReader, options, decodeCallbacks, bitmapPool);
                                floor = m8[0];
                                i16 = m8[1];
                            }
                        } else {
                            float f12 = i15;
                            floor = (int) Math.floor(f8 / f12);
                            floor2 = Math.floor(f9 / f12);
                        }
                        i16 = (int) floor2;
                    }
                    double b9 = downsampleStrategy.b(floor, i16, i11, i12);
                    options.inTargetDensity = a(b9);
                    options.inDensity = l(b9);
                    if (s(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculate scaling, source: [" + i9 + "x" + i10 + "], degreesToRotate: " + i8 + ", target: [" + i11 + "x" + i12 + "], power of two scaled: [" + floor + "x" + i16 + "], exact scale factor: " + b8 + ", power of 2 sample size: " + i15 + ", adjusted scale factor: " + b9 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + b8 + " from: " + downsampleStrategy + ", source: [" + i9 + "x" + i10 + "], target: [" + i11 + "x" + i12 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i11 + "x" + i12 + "]");
        }
    }

    private Resource<Bitmap> e(ImageReader imageReader, int i8, int i9, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        boolean z7;
        byte[] bArr = (byte[]) this.f10457c.c(65536, byte[].class);
        BitmapFactory.Options k8 = k();
        k8.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options.c(f10446f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.c(f10447g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f10441h);
        boolean booleanValue = ((Boolean) options.c(f10449i)).booleanValue();
        Option<Boolean> option = f10450j;
        if (options.c(option) != null && ((Boolean) options.c(option)).booleanValue()) {
            z7 = true;
        } else {
            z7 = false;
        }
        try {
            return BitmapResource.f(h(imageReader, k8, downsampleStrategy, decodeFormat, preferredColorSpace, z7, i8, i9, booleanValue, decodeCallbacks), this.f10455a);
        } finally {
            v(k8);
            this.f10457c.put(bArr);
        }
    }

    private Bitmap h(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z7, int i8, int i9, boolean z8, DecodeCallbacks decodeCallbacks) throws IOException {
        boolean z9;
        int i10;
        int i11;
        int i12;
        String str;
        int i13;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        float f8;
        int round;
        int round2;
        long b8 = LogTime.b();
        int[] m8 = m(imageReader, options, decodeCallbacks, this.f10455a);
        boolean z10 = false;
        int i14 = m8[0];
        int i15 = m8[1];
        String str2 = options.outMimeType;
        if (i14 != -1 && i15 != -1) {
            z9 = z7;
        } else {
            z9 = false;
        }
        int c8 = imageReader.c();
        int j8 = TransformationUtils.j(c8);
        boolean m9 = TransformationUtils.m(c8);
        if (i8 == Integer.MIN_VALUE) {
            i10 = i9;
            if (r(j8)) {
                i11 = i15;
            } else {
                i11 = i14;
            }
        } else {
            i10 = i9;
            i11 = i8;
        }
        if (i10 == Integer.MIN_VALUE) {
            if (r(j8)) {
                i12 = i14;
            } else {
                i12 = i15;
            }
        } else {
            i12 = i10;
        }
        ImageHeaderParser.ImageType d8 = imageReader.d();
        c(d8, imageReader, decodeCallbacks, this.f10455a, downsampleStrategy, j8, i14, i15, i11, i12, options);
        b(imageReader, decodeFormat, z9, m9, options, i11, i12);
        int i16 = Build.VERSION.SDK_INT;
        int i17 = options.inSampleSize;
        if (!z(d8)) {
            str = "Downsampler";
        } else {
            if (i14 >= 0 && i15 >= 0 && z8) {
                str = "Downsampler";
                round = i11;
                round2 = i12;
            } else {
                if (s(options)) {
                    f8 = options.inTargetDensity / options.inDensity;
                } else {
                    f8 = 1.0f;
                }
                int i18 = options.inSampleSize;
                float f9 = i18;
                round = Math.round(((int) Math.ceil(i14 / f9)) * f8);
                round2 = Math.round(((int) Math.ceil(i15 / f9)) * f8);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + round + "x" + round2 + "] for source [" + i14 + "x" + i15 + "], sampleSize: " + i18 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f8);
                }
            }
            if (round > 0 && round2 > 0) {
                y(options, this.f10455a, round, round2);
            }
        }
        if (i16 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z10 = true;
            }
            if (z10) {
                named = ColorSpace.Named.DISPLAY_P3;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            options.inPreferredColorSpace = ColorSpace.get(named);
        } else if (i16 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap i19 = i(imageReader, options, decodeCallbacks, this.f10455a);
        decodeCallbacks.a(this.f10455a, i19);
        if (Log.isLoggable(str, 2)) {
            i13 = c8;
            t(i14, i15, str2, options, i19, i8, i9, b8);
        } else {
            i13 = c8;
        }
        Bitmap bitmap = null;
        if (i19 != null) {
            i19.setDensity(this.f10456b.densityDpi);
            bitmap = TransformationUtils.n(this.f10455a, i19, i13);
            if (!i19.equals(bitmap)) {
                this.f10455a.c(i19);
            }
        }
        return bitmap;
    }

    private static Bitmap i(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        if (!options.inJustDecodeBounds) {
            decodeCallbacks.b();
            imageReader.b();
        }
        int i8 = options.outWidth;
        int i9 = options.outHeight;
        String str = options.outMimeType;
        TransformationUtils.i().lock();
        try {
            try {
                Bitmap a8 = imageReader.a(options);
                TransformationUtils.i().unlock();
                return a8;
            } catch (IllegalArgumentException e8) {
                IOException u7 = u(e8, i8, i9, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", u7);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        bitmapPool.c(bitmap);
                        options.inBitmap = null;
                        Bitmap i10 = i(imageReader, options, decodeCallbacks, bitmapPool);
                        TransformationUtils.i().unlock();
                        return i10;
                    } catch (IOException unused) {
                        throw u7;
                    }
                }
                throw u7;
            }
        } catch (Throwable th) {
            TransformationUtils.i().unlock();
            throw th;
        }
    }

    @TargetApi(19)
    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = f10454n;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    private static int l(double d8) {
        if (d8 > 1.0d) {
            d8 = 1.0d / d8;
        }
        return (int) Math.round(d8 * 2.147483647E9d);
    }

    private static int[] m(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        options.inJustDecodeBounds = true;
        i(imageReader, options, decodeCallbacks, bitmapPool);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i8) {
        return i8 == 90 || i8 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i8;
        int i9 = options.inTargetDensity;
        if (i9 > 0 && (i8 = options.inDensity) > 0 && i9 != i8) {
            return true;
        }
        return false;
    }

    private static void t(int i8, int i9, String str, BitmapFactory.Options options, Bitmap bitmap, int i10, int i11, long j8) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i8 + "x" + i9 + "] " + str + " with inBitmap " + n(options) + " for [" + i10 + "x" + i11 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.a(j8));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i8, int i9, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i8 + ", outHeight: " + i9 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f10454n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d8) {
        return (int) (d8 + 0.5d);
    }

    @TargetApi(26)
    private static void y(BitmapFactory.Options options, BitmapPool bitmapPool, int i8, int i9) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26) {
            if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return;
            }
            config = options.outConfig;
        } else {
            config = null;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool.e(i8, i9, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i8, int i9, Options options) throws IOException {
        return e(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.f10458d, this.f10457c), i8, i9, options, f10452l);
    }

    public Resource<Bitmap> f(InputStream inputStream, int i8, int i9, Options options) throws IOException {
        return g(inputStream, i8, i9, options, f10452l);
    }

    public Resource<Bitmap> g(InputStream inputStream, int i8, int i9, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return e(new ImageReader.InputStreamImageReader(inputStream, this.f10458d, this.f10457c), i8, i9, options, decodeCallbacks);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
