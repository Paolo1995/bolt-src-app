package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public final class Util {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f10786a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f10787b = new char[64];

    /* renamed from: c  reason: collision with root package name */
    private static volatile Handler f10788c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bumptech.glide.util.Util$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10789a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f10789a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10789a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10789a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10789a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10789a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private Util() {
    }

    public static void a() {
        if (q()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on a background thread");
    }

    public static void b() {
        if (r()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        } else if (obj instanceof Model) {
            return ((Model) obj).a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    @NonNull
    private static String e(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i8 = 0; i8 < bArr.length; i8++) {
            int i9 = bArr[i8] & 255;
            int i10 = i8 * 2;
            char[] cArr2 = f10786a;
            cArr[i10] = cArr2[i9 >>> 4];
            cArr[i10 + 1] = cArr2[i9 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> f(int i8) {
        return new ArrayDeque(i8);
    }

    public static int g(int i8, int i9, Bitmap.Config config) {
        return i8 * i9 * i(config);
    }

    @TargetApi(19)
    public static int h(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int i(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i8 = AnonymousClass1.f10789a[config.ordinal()];
        if (i8 != 1) {
            if (i8 != 2 && i8 != 3) {
                if (i8 != 4) {
                    return 4;
                }
                return 8;
            }
            return 2;
        }
        return 1;
    }

    @NonNull
    public static <T> List<T> j(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t7 : collection) {
            if (t7 != null) {
                arrayList.add(t7);
            }
        }
        return arrayList;
    }

    private static Handler k() {
        if (f10788c == null) {
            synchronized (Util.class) {
                if (f10788c == null) {
                    f10788c = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f10788c;
    }

    public static int l(float f8) {
        return m(f8, 17);
    }

    public static int m(float f8, int i8) {
        return n(Float.floatToIntBits(f8), i8);
    }

    public static int n(int i8, int i9) {
        return (i9 * 31) + i8;
    }

    public static int o(Object obj, int i8) {
        int hashCode;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return n(hashCode, i8);
    }

    public static int p(boolean z7, int i8) {
        return n(z7 ? 1 : 0, i8);
    }

    public static boolean q() {
        return !r();
    }

    public static boolean r() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    private static boolean s(int i8) {
        return i8 > 0 || i8 == Integer.MIN_VALUE;
    }

    public static boolean t(int i8, int i9) {
        if (s(i8) && s(i9)) {
            return true;
        }
        return false;
    }

    public static void u(Runnable runnable) {
        k().post(runnable);
    }

    public static void v(Runnable runnable) {
        k().removeCallbacks(runnable);
    }

    @NonNull
    public static String w(@NonNull byte[] bArr) {
        String e8;
        char[] cArr = f10787b;
        synchronized (cArr) {
            e8 = e(bArr, cArr);
        }
        return e8;
    }
}
