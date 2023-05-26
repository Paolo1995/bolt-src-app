package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* loaded from: classes.dex */
public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<PathMeasure> f9653a = new ThreadLocal<PathMeasure>() { // from class: com.airbnb.lottie.utils.Utils.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<Path> f9654b = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<Path> f9655c = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Path initialValue() {
            return new Path();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<float[]> f9656d = new ThreadLocal<float[]>() { // from class: com.airbnb.lottie.utils.Utils.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public float[] initialValue() {
            return new float[4];
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final float f9657e = (float) (Math.sqrt(2.0d) / 2.0d);

    private Utils() {
    }

    public static void a(Path path, float f8, float f9, float f10) {
        L.a("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = f9653a.get();
        Path path2 = f9654b.get();
        Path path3 = f9655c.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f8 == 1.0f && f9 == 0.0f) {
            L.b("applyTrimPathIfNeeded");
        } else if (length >= 1.0f && Math.abs((f9 - f8) - 1.0f) >= 0.01d) {
            float f11 = f8 * length;
            float f12 = f9 * length;
            float f13 = f10 * length;
            float min = Math.min(f11, f12) + f13;
            float max = Math.max(f11, f12) + f13;
            if (min >= length && max >= length) {
                min = MiscUtils.f(min, length);
                max = MiscUtils.f(max, length);
            }
            if (min < 0.0f) {
                min = MiscUtils.f(min, length);
            }
            if (max < 0.0f) {
                max = MiscUtils.f(max, length);
            }
            int i8 = (min > max ? 1 : (min == max ? 0 : -1));
            if (i8 == 0) {
                path.reset();
                L.b("applyTrimPathIfNeeded");
                return;
            }
            if (i8 >= 0) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            L.b("applyTrimPathIfNeeded");
        } else {
            L.b("applyTrimPathIfNeeded");
        }
    }

    public static void b(Path path, TrimPathContent trimPathContent) {
        if (trimPathContent != null && !trimPathContent.k()) {
            a(path, ((FloatKeyframeAnimation) trimPathContent.i()).p() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.e()).p() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.g()).p() / 360.0f);
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e8) {
                throw e8;
            } catch (Exception unused) {
            }
        }
    }

    public static Path d(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
            float f8 = pointF.x;
            float f9 = pointF2.x;
            float f10 = pointF2.y;
            path.cubicTo(pointF3.x + f8, pointF.y + pointF3.y, f9 + pointF4.x, f10 + pointF4.y, f9, f10);
        } else {
            path.lineTo(pointF2.x, pointF2.y);
        }
        return path;
    }

    public static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float f(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static float g(Matrix matrix) {
        float[] fArr = f9656d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f8 = f9657e;
        fArr[2] = f8;
        fArr[3] = f8;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static boolean h(Matrix matrix) {
        float[] fArr = f9656d.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] != fArr[2] && fArr[1] != fArr[3]) {
            return false;
        }
        return true;
    }

    public static int i(float f8, float f9, float f10, float f11) {
        int i8 = f8 != 0.0f ? (int) (527 * f8) : 17;
        if (f9 != 0.0f) {
            i8 = (int) (i8 * 31 * f9);
        }
        if (f10 != 0.0f) {
            i8 = (int) (i8 * 31 * f10);
        }
        return f11 != 0.0f ? (int) (i8 * 31 * f11) : i8;
    }

    public static boolean j(int i8, int i9, int i10, int i11, int i12, int i13) {
        if (i8 < i11) {
            return false;
        }
        if (i8 > i11) {
            return true;
        }
        if (i9 < i12) {
            return false;
        }
        return i9 > i12 || i10 >= i13;
    }

    public static boolean k(Throwable th) {
        if (!(th instanceof SocketException) && !(th instanceof ClosedChannelException) && !(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
            return false;
        }
        return true;
    }

    public static Bitmap l(Bitmap bitmap, int i8, int i9) {
        if (bitmap.getWidth() == i8 && bitmap.getHeight() == i9) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i8, i9, true);
        bitmap.recycle();
        return createScaledBitmap;
    }

    public static void m(Canvas canvas, RectF rectF, Paint paint) {
        n(canvas, rectF, paint, 31);
    }

    public static void n(Canvas canvas, RectF rectF, Paint paint, int i8) {
        L.a("Utils#saveLayer");
        if (Build.VERSION.SDK_INT < 23) {
            canvas.saveLayer(rectF, paint, i8);
        } else {
            canvas.saveLayer(rectF, paint);
        }
        L.b("Utils#saveLayer");
    }
}
