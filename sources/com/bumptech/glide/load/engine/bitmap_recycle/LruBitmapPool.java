package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class LruBitmapPool implements BitmapPool {

    /* renamed from: k  reason: collision with root package name */
    private static final Bitmap.Config f10210k = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final LruPoolStrategy f10211a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f10212b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10213c;

    /* renamed from: d  reason: collision with root package name */
    private final BitmapTracker f10214d;

    /* renamed from: e  reason: collision with root package name */
    private long f10215e;

    /* renamed from: f  reason: collision with root package name */
    private long f10216f;

    /* renamed from: g  reason: collision with root package name */
    private int f10217g;

    /* renamed from: h  reason: collision with root package name */
    private int f10218h;

    /* renamed from: i  reason: collision with root package name */
    private int f10219i;

    /* renamed from: j  reason: collision with root package name */
    private int f10220j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface BitmapTracker {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    private static final class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void b(Bitmap bitmap) {
        }
    }

    LruBitmapPool(long j8, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.f10213c = j8;
        this.f10215e = j8;
        this.f10211a = lruPoolStrategy;
        this.f10212b = set;
        this.f10214d = new NullBitmapTracker();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    @NonNull
    private static Bitmap g(int i8, int i9, Bitmap.Config config) {
        if (config == null) {
            config = f10210k;
        }
        return Bitmap.createBitmap(i8, i9, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f10217g + ", misses=" + this.f10218h + ", puts=" + this.f10219i + ", evictions=" + this.f10220j + ", currentSize=" + this.f10216f + ", maxSize=" + this.f10215e + "\nStrategy=" + this.f10211a);
    }

    private void j() {
        q(this.f10215e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i8 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i8 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy l() {
        return new SizeConfigStrategy();
    }

    private synchronized Bitmap m(int i8, int i9, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap d8;
        f(config);
        LruPoolStrategy lruPoolStrategy = this.f10211a;
        if (config != null) {
            config2 = config;
        } else {
            config2 = f10210k;
        }
        d8 = lruPoolStrategy.d(i8, i9, config2);
        if (d8 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f10211a.b(i8, i9, config));
            }
            this.f10218h++;
        } else {
            this.f10217g++;
            this.f10216f -= this.f10211a.e(d8);
            this.f10214d.a(d8);
            p(d8);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f10211a.b(i8, i9, config));
        }
        h();
        return d8;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j8) {
        while (this.f10216f > j8) {
            Bitmap removeLast = this.f10211a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f10216f = 0L;
                return;
            }
            this.f10214d.a(removeLast);
            this.f10216f -= this.f10211a.e(removeLast);
            this.f10220j++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f10211a.a(removeLast));
            }
            h();
            removeLast.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void a(int i8) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i8);
        }
        if (i8 < 40 && (Build.VERSION.SDK_INT < 23 || i8 < 20)) {
            if (i8 >= 20 || i8 == 15) {
                q(n() / 2);
                return;
            }
            return;
        }
        b();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f10211a.e(bitmap) <= this.f10215e && this.f10212b.contains(bitmap.getConfig())) {
                        int e8 = this.f10211a.e(bitmap);
                        this.f10211a.c(bitmap);
                        this.f10214d.b(bitmap);
                        this.f10219i++;
                        this.f10216f += e8;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f10211a.a(bitmap));
                        }
                        h();
                        j();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f10211a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f10212b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap d(int i8, int i9, Bitmap.Config config) {
        Bitmap m8 = m(i8, i9, config);
        if (m8 != null) {
            m8.eraseColor(0);
            return m8;
        }
        return g(i8, i9, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap e(int i8, int i9, Bitmap.Config config) {
        Bitmap m8 = m(i8, i9, config);
        if (m8 == null) {
            return g(i8, i9, config);
        }
        return m8;
    }

    public long n() {
        return this.f10215e;
    }

    public LruBitmapPool(long j8) {
        this(j8, l(), k());
    }
}
