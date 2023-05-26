package androidx.camera.core.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ImageUtil {

    /* loaded from: classes.dex */
    public static final class CodecFailedException extends Exception {

        /* renamed from: f  reason: collision with root package name */
        private FailureType f3932f;

        /* loaded from: classes.dex */
        public enum FailureType {
            ENCODE_FAILED,
            DECODE_FAILED,
            UNKNOWN
        }

        CodecFailedException(@NonNull String str, @NonNull FailureType failureType) {
            super(str);
            this.f3932f = failureType;
        }

        @NonNull
        public FailureType a() {
            return this.f3932f;
        }
    }

    private ImageUtil() {
    }

    public static Rect a(@NonNull Size size, @NonNull Rational rational) {
        int i8;
        if (!f(rational)) {
            Logger.k("ImageUtil", "Invalid view ratio.");
            return null;
        }
        int width = size.getWidth();
        int height = size.getHeight();
        float f8 = width;
        float f9 = height;
        int numerator = rational.getNumerator();
        int denominator = rational.getDenominator();
        int i9 = 0;
        if (rational.floatValue() > f8 / f9) {
            int round = Math.round((f8 / numerator) * denominator);
            i8 = (height - round) / 2;
            height = round;
        } else {
            int round2 = Math.round((f9 / denominator) * numerator);
            i9 = (width - round2) / 2;
            width = round2;
            i8 = 0;
        }
        return new Rect(i9, i8, width + i9, height + i8);
    }

    @NonNull
    public static Rect b(@NonNull Rect rect, int i8, @NonNull Size size, int i9) {
        Matrix matrix = new Matrix();
        matrix.setRotate(i9 - i8);
        float[] o8 = o(size);
        matrix.mapPoints(o8);
        matrix.postTranslate(-k(o8[0], o8[2], o8[4], o8[6]), -k(o8[1], o8[3], o8[5], o8[7]));
        matrix.invert(matrix);
        RectF rectF = new RectF();
        matrix.mapRect(rectF, new RectF(rect));
        rectF.sort();
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @NonNull
    private static byte[] c(@NonNull byte[] bArr, @NonNull Rect rect, int i8) throws CodecFailedException {
        try {
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false);
            Bitmap decodeRegion = newInstance.decodeRegion(rect, new BitmapFactory.Options());
            newInstance.recycle();
            if (decodeRegion != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decodeRegion.compress(Bitmap.CompressFormat.JPEG, i8, byteArrayOutputStream)) {
                    decodeRegion.recycle();
                    return byteArrayOutputStream.toByteArray();
                }
                throw new CodecFailedException("Encode bitmap failed.", CodecFailedException.FailureType.ENCODE_FAILED);
            }
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IOException unused) {
            throw new CodecFailedException("Decode byte array failed.", CodecFailedException.FailureType.DECODE_FAILED);
        } catch (IllegalArgumentException e8) {
            throw new CodecFailedException("Decode byte array failed with illegal argument." + e8, CodecFailedException.FailureType.DECODE_FAILED);
        }
    }

    @NonNull
    public static Rational d(int i8, @NonNull Rational rational) {
        if (i8 != 90 && i8 != 270) {
            return new Rational(rational.getNumerator(), rational.getDenominator());
        }
        return e(rational);
    }

    private static Rational e(Rational rational) {
        if (rational == null) {
            return rational;
        }
        return new Rational(rational.getDenominator(), rational.getNumerator());
    }

    public static boolean f(Rational rational) {
        if (rational != null && rational.floatValue() > 0.0f && !rational.isNaN()) {
            return true;
        }
        return false;
    }

    public static boolean g(@NonNull Size size, Rational rational) {
        if (rational != null && rational.floatValue() > 0.0f && h(size, rational) && !rational.isNaN()) {
            return true;
        }
        return false;
    }

    private static boolean h(@NonNull Size size, @NonNull Rational rational) {
        int width = size.getWidth();
        int height = size.getHeight();
        float numerator = rational.getNumerator();
        float denominator = rational.getDenominator();
        if (height == Math.round((width / numerator) * denominator) && width == Math.round((height / denominator) * numerator)) {
            return false;
        }
        return true;
    }

    @NonNull
    public static byte[] i(@NonNull ImageProxy imageProxy) {
        if (imageProxy.getFormat() == 256) {
            ByteBuffer b8 = imageProxy.n0()[0].b();
            byte[] bArr = new byte[b8.capacity()];
            b8.rewind();
            b8.get(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }

    @NonNull
    public static byte[] j(@NonNull ImageProxy imageProxy, @NonNull Rect rect, int i8) throws CodecFailedException {
        if (imageProxy.getFormat() == 256) {
            return c(i(imageProxy), rect, i8);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }

    public static float k(float f8, float f9, float f10, float f11) {
        return Math.min(Math.min(f8, f9), Math.min(f10, f11));
    }

    private static byte[] l(@NonNull byte[] bArr, int i8, int i9, Rect rect, int i10) throws CodecFailedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        YuvImage yuvImage = new YuvImage(bArr, 17, i8, i9, null);
        if (rect == null) {
            rect = new Rect(0, 0, i8, i9);
        }
        if (yuvImage.compressToJpeg(rect, i10, byteArrayOutputStream)) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new CodecFailedException("YuvImage failed to encode jpeg.", CodecFailedException.FailureType.ENCODE_FAILED);
    }

    public static boolean m(int i8, int i9, int i10, int i11) {
        return (i8 == i10 && i9 == i11) ? false : true;
    }

    public static boolean n(@NonNull ImageProxy imageProxy) {
        return m(imageProxy.getWidth(), imageProxy.getHeight(), imageProxy.x0().width(), imageProxy.x0().height());
    }

    @NonNull
    public static float[] o(@NonNull Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }

    @NonNull
    public static byte[] p(@NonNull ImageProxy imageProxy, Rect rect, int i8) throws CodecFailedException {
        if (imageProxy.getFormat() == 35) {
            return l(q(imageProxy), imageProxy.getWidth(), imageProxy.getHeight(), rect, i8);
        }
        throw new IllegalArgumentException("Incorrect image format of the input image proxy: " + imageProxy.getFormat());
    }

    @NonNull
    public static byte[] q(@NonNull ImageProxy imageProxy) {
        ImageProxy.PlaneProxy planeProxy = imageProxy.n0()[0];
        ImageProxy.PlaneProxy planeProxy2 = imageProxy.n0()[1];
        ImageProxy.PlaneProxy planeProxy3 = imageProxy.n0()[2];
        ByteBuffer b8 = planeProxy.b();
        ByteBuffer b9 = planeProxy2.b();
        ByteBuffer b10 = planeProxy3.b();
        b8.rewind();
        b9.rewind();
        b10.rewind();
        int remaining = b8.remaining();
        byte[] bArr = new byte[((imageProxy.getWidth() * imageProxy.getHeight()) / 2) + remaining];
        int i8 = 0;
        for (int i9 = 0; i9 < imageProxy.getHeight(); i9++) {
            b8.get(bArr, i8, imageProxy.getWidth());
            i8 += imageProxy.getWidth();
            b8.position(Math.min(remaining, (b8.position() - imageProxy.getWidth()) + planeProxy.c()));
        }
        int height = imageProxy.getHeight() / 2;
        int width = imageProxy.getWidth() / 2;
        int c8 = planeProxy3.c();
        int c9 = planeProxy2.c();
        int d8 = planeProxy3.d();
        int d9 = planeProxy2.d();
        byte[] bArr2 = new byte[c8];
        byte[] bArr3 = new byte[c9];
        for (int i10 = 0; i10 < height; i10++) {
            b10.get(bArr2, 0, Math.min(c8, b10.remaining()));
            b9.get(bArr3, 0, Math.min(c9, b9.remaining()));
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < width; i13++) {
                int i14 = i8 + 1;
                bArr[i8] = bArr2[i11];
                i8 = i14 + 1;
                bArr[i14] = bArr3[i12];
                i11 += d8;
                i12 += d9;
            }
        }
        return bArr;
    }
}
