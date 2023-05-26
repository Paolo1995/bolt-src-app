package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class TransformationUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Paint f10497a = new Paint(6);

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f10498b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f10499c;

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f10500d;

    /* renamed from: e  reason: collision with root package name */
    private static final Lock f10501e;

    /* loaded from: classes.dex */
    private static final class NoLock implements Lock {
        NoLock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j8, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        Lock noLock;
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f10500d = hashSet;
        if (hashSet.contains(Build.MODEL)) {
            noLock = new ReentrantLock();
        } else {
            noLock = new NoLock();
        }
        f10501e = noLock;
        Paint paint = new Paint(7);
        f10499c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private TransformationUtils() {
    }

    private static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f10501e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f10497a);
            e(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f10501e.unlock();
            throw th;
        }
    }

    public static Bitmap b(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i8, int i9) {
        float width;
        float height;
        if (bitmap.getWidth() == i8 && bitmap.getHeight() == i9) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f8 = 0.0f;
        if (bitmap.getWidth() * i9 > bitmap.getHeight() * i8) {
            width = i9 / bitmap.getHeight();
            f8 = (i8 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i8 / bitmap.getWidth();
            height = (i9 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f8 + 0.5f), (int) (height + 0.5f));
        Bitmap d8 = bitmapPool.d(i8, i9, k(bitmap));
        o(bitmap, d8);
        a(bitmap, d8, matrix);
        return d8;
    }

    public static Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i8, int i9) {
        if (bitmap.getWidth() <= i8 && bitmap.getHeight() <= i9) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
            }
            return bitmap;
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
        }
        return f(bitmapPool, bitmap, i8, i9);
    }

    public static Bitmap d(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i8, int i9) {
        int min = Math.min(i8, i9);
        float f8 = min;
        float f9 = f8 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f8 / width, f8 / height);
        float f10 = width * max;
        float f11 = max * height;
        float f12 = (f8 - f10) / 2.0f;
        float f13 = (f8 - f11) / 2.0f;
        RectF rectF = new RectF(f12, f13, f10 + f12, f11 + f13);
        Bitmap g8 = g(bitmapPool, bitmap);
        Bitmap d8 = bitmapPool.d(min, min, h(bitmap));
        d8.setHasAlpha(true);
        Lock lock = f10501e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(d8);
            canvas.drawCircle(f9, f9, f9, f10498b);
            canvas.drawBitmap(g8, (Rect) null, rectF, f10499c);
            e(canvas);
            lock.unlock();
            if (!g8.equals(bitmap)) {
                bitmapPool.c(g8);
            }
            return d8;
        } catch (Throwable th) {
            f10501e.unlock();
            throw th;
        }
    }

    private static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i8, int i9) {
        if (bitmap.getWidth() == i8 && bitmap.getHeight() == i9) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i8 / bitmap.getWidth(), i9 / bitmap.getHeight());
        int round = Math.round(bitmap.getWidth() * min);
        int round2 = Math.round(bitmap.getHeight() * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap d8 = bitmapPool.d((int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), k(bitmap));
        o(bitmap, d8);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i8 + "x" + i9);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + d8.getWidth() + "x" + d8.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, d8, matrix);
        return d8;
    }

    private static Bitmap g(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap) {
        Bitmap.Config h8 = h(bitmap);
        if (h8.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap d8 = bitmapPool.d(bitmap.getWidth(), bitmap.getHeight(), h8);
        new Canvas(d8).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return d8;
    }

    @NonNull
    private static Bitmap.Config h(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    public static Lock i() {
        return f10501e;
    }

    public static int j(int i8) {
        switch (i8) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    private static Bitmap.Config k(@NonNull Bitmap bitmap) {
        if (bitmap.getConfig() != null) {
            return bitmap.getConfig();
        }
        return Bitmap.Config.ARGB_8888;
    }

    static void l(int i8, Matrix matrix) {
        switch (i8) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static boolean m(int i8) {
        switch (i8) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i8) {
        if (!m(i8)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i8, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap d8 = bitmapPool.d(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        d8.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, d8, matrix);
        return d8;
    }

    public static void o(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
