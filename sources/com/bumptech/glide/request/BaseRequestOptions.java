package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import j$.util.Spliterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean E;

    /* renamed from: f  reason: collision with root package name */
    private int f10637f;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f10641j;

    /* renamed from: k  reason: collision with root package name */
    private int f10642k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f10643l;

    /* renamed from: m  reason: collision with root package name */
    private int f10644m;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10649r;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f10651t;

    /* renamed from: u  reason: collision with root package name */
    private int f10652u;

    /* renamed from: y  reason: collision with root package name */
    private boolean f10656y;

    /* renamed from: z  reason: collision with root package name */
    private Resources.Theme f10657z;

    /* renamed from: g  reason: collision with root package name */
    private float f10638g = 1.0f;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private DiskCacheStrategy f10639h = DiskCacheStrategy.f10073e;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private Priority f10640i = Priority.NORMAL;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10645n = true;

    /* renamed from: o  reason: collision with root package name */
    private int f10646o = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f10647p = -1;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    private Key f10648q = EmptySignature.c();

    /* renamed from: s  reason: collision with root package name */
    private boolean f10650s = true;
    @NonNull

    /* renamed from: v  reason: collision with root package name */
    private Options f10653v = new Options();
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    private Map<Class<?>, Transformation<?>> f10654w = new CachedHashCodeArrayMap();
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    private Class<?> f10655x = Object.class;
    private boolean D = true;

    private boolean M(int i8) {
        return N(this.f10637f, i8);
    }

    private static boolean N(int i8, int i9) {
        return (i8 & i9) != 0;
    }

    @NonNull
    private T W(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return e0(downsampleStrategy, transformation, false);
    }

    @NonNull
    private T d0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return e0(downsampleStrategy, transformation, true);
    }

    @NonNull
    private T e0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z7) {
        T X;
        if (z7) {
            X = n0(downsampleStrategy, transformation);
        } else {
            X = X(downsampleStrategy, transformation);
        }
        X.D = true;
        return X;
    }

    private T f0() {
        return this;
    }

    @NonNull
    public final Key A() {
        return this.f10648q;
    }

    public final float B() {
        return this.f10638g;
    }

    public final Resources.Theme C() {
        return this.f10657z;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> D() {
        return this.f10654w;
    }

    public final boolean E() {
        return this.E;
    }

    public final boolean G() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean H() {
        return this.A;
    }

    public final boolean J() {
        return this.f10645n;
    }

    public final boolean K() {
        return M(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean L() {
        return this.D;
    }

    public final boolean O() {
        return this.f10650s;
    }

    public final boolean P() {
        return this.f10649r;
    }

    public final boolean Q() {
        return M(2048);
    }

    public final boolean R() {
        return Util.t(this.f10647p, this.f10646o);
    }

    @NonNull
    public T S() {
        this.f10656y = true;
        return f0();
    }

    @NonNull
    public T T() {
        return X(DownsampleStrategy.f10438e, new CenterCrop());
    }

    @NonNull
    public T U() {
        return W(DownsampleStrategy.f10437d, new CenterInside());
    }

    @NonNull
    public T V() {
        return W(DownsampleStrategy.f10436c, new FitCenter());
    }

    @NonNull
    final T X(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.A) {
            return (T) clone().X(downsampleStrategy, transformation);
        }
        i(downsampleStrategy);
        return m0(transformation, false);
    }

    @NonNull
    public T Y(int i8) {
        return Z(i8, i8);
    }

    @NonNull
    public T Z(int i8, int i9) {
        if (this.A) {
            return (T) clone().Z(i8, i9);
        }
        this.f10647p = i8;
        this.f10646o = i9;
        this.f10637f |= 512;
        return g0();
    }

    @NonNull
    public T a(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        if (this.A) {
            return (T) clone().a(baseRequestOptions);
        }
        if (N(baseRequestOptions.f10637f, 2)) {
            this.f10638g = baseRequestOptions.f10638g;
        }
        if (N(baseRequestOptions.f10637f, 262144)) {
            this.B = baseRequestOptions.B;
        }
        if (N(baseRequestOptions.f10637f, 1048576)) {
            this.E = baseRequestOptions.E;
        }
        if (N(baseRequestOptions.f10637f, 4)) {
            this.f10639h = baseRequestOptions.f10639h;
        }
        if (N(baseRequestOptions.f10637f, 8)) {
            this.f10640i = baseRequestOptions.f10640i;
        }
        if (N(baseRequestOptions.f10637f, 16)) {
            this.f10641j = baseRequestOptions.f10641j;
            this.f10642k = 0;
            this.f10637f &= -33;
        }
        if (N(baseRequestOptions.f10637f, 32)) {
            this.f10642k = baseRequestOptions.f10642k;
            this.f10641j = null;
            this.f10637f &= -17;
        }
        if (N(baseRequestOptions.f10637f, 64)) {
            this.f10643l = baseRequestOptions.f10643l;
            this.f10644m = 0;
            this.f10637f &= -129;
        }
        if (N(baseRequestOptions.f10637f, 128)) {
            this.f10644m = baseRequestOptions.f10644m;
            this.f10643l = null;
            this.f10637f &= -65;
        }
        if (N(baseRequestOptions.f10637f, Spliterator.NONNULL)) {
            this.f10645n = baseRequestOptions.f10645n;
        }
        if (N(baseRequestOptions.f10637f, 512)) {
            this.f10647p = baseRequestOptions.f10647p;
            this.f10646o = baseRequestOptions.f10646o;
        }
        if (N(baseRequestOptions.f10637f, Spliterator.IMMUTABLE)) {
            this.f10648q = baseRequestOptions.f10648q;
        }
        if (N(baseRequestOptions.f10637f, 4096)) {
            this.f10655x = baseRequestOptions.f10655x;
        }
        if (N(baseRequestOptions.f10637f, FragmentTransaction.TRANSIT_EXIT_MASK)) {
            this.f10651t = baseRequestOptions.f10651t;
            this.f10652u = 0;
            this.f10637f &= -16385;
        }
        if (N(baseRequestOptions.f10637f, 16384)) {
            this.f10652u = baseRequestOptions.f10652u;
            this.f10651t = null;
            this.f10637f &= -8193;
        }
        if (N(baseRequestOptions.f10637f, 32768)) {
            this.f10657z = baseRequestOptions.f10657z;
        }
        if (N(baseRequestOptions.f10637f, 65536)) {
            this.f10650s = baseRequestOptions.f10650s;
        }
        if (N(baseRequestOptions.f10637f, 131072)) {
            this.f10649r = baseRequestOptions.f10649r;
        }
        if (N(baseRequestOptions.f10637f, 2048)) {
            this.f10654w.putAll(baseRequestOptions.f10654w);
            this.D = baseRequestOptions.D;
        }
        if (N(baseRequestOptions.f10637f, 524288)) {
            this.C = baseRequestOptions.C;
        }
        if (!this.f10650s) {
            this.f10654w.clear();
            this.f10649r = false;
            this.f10637f = this.f10637f & (-2049) & (-131073);
            this.D = true;
        }
        this.f10637f |= baseRequestOptions.f10637f;
        this.f10653v.d(baseRequestOptions.f10653v);
        return g0();
    }

    @NonNull
    public T a0(int i8) {
        if (this.A) {
            return (T) clone().a0(i8);
        }
        this.f10644m = i8;
        this.f10643l = null;
        this.f10637f = (this.f10637f | 128) & (-65);
        return g0();
    }

    @NonNull
    public T b() {
        if (this.f10656y && !this.A) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.A = true;
        return S();
    }

    @NonNull
    public T b0(Drawable drawable) {
        if (this.A) {
            return (T) clone().b0(drawable);
        }
        this.f10643l = drawable;
        this.f10644m = 0;
        this.f10637f = (this.f10637f | 64) & (-129);
        return g0();
    }

    @NonNull
    public T c() {
        return d0(DownsampleStrategy.f10437d, new CenterInside());
    }

    @NonNull
    public T c0(@NonNull Priority priority) {
        if (this.A) {
            return (T) clone().c0(priority);
        }
        this.f10640i = (Priority) Preconditions.d(priority);
        this.f10637f |= 8;
        return g0();
    }

    @NonNull
    public T d() {
        return n0(DownsampleStrategy.f10437d, new CircleCrop());
    }

    @Override // 
    /* renamed from: e */
    public T clone() {
        try {
            T t7 = (T) super.clone();
            Options options = new Options();
            t7.f10653v = options;
            options.d(this.f10653v);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t7.f10654w = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.f10654w);
            t7.f10656y = false;
            t7.A = false;
            return t7;
        } catch (CloneNotSupportedException e8) {
            throw new RuntimeException(e8);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        if (Float.compare(baseRequestOptions.f10638g, this.f10638g) != 0 || this.f10642k != baseRequestOptions.f10642k || !Util.d(this.f10641j, baseRequestOptions.f10641j) || this.f10644m != baseRequestOptions.f10644m || !Util.d(this.f10643l, baseRequestOptions.f10643l) || this.f10652u != baseRequestOptions.f10652u || !Util.d(this.f10651t, baseRequestOptions.f10651t) || this.f10645n != baseRequestOptions.f10645n || this.f10646o != baseRequestOptions.f10646o || this.f10647p != baseRequestOptions.f10647p || this.f10649r != baseRequestOptions.f10649r || this.f10650s != baseRequestOptions.f10650s || this.B != baseRequestOptions.B || this.C != baseRequestOptions.C || !this.f10639h.equals(baseRequestOptions.f10639h) || this.f10640i != baseRequestOptions.f10640i || !this.f10653v.equals(baseRequestOptions.f10653v) || !this.f10654w.equals(baseRequestOptions.f10654w) || !this.f10655x.equals(baseRequestOptions.f10655x) || !Util.d(this.f10648q, baseRequestOptions.f10648q) || !Util.d(this.f10657z, baseRequestOptions.f10657z)) {
            return false;
        }
        return true;
    }

    @NonNull
    public T f(@NonNull Class<?> cls) {
        if (this.A) {
            return (T) clone().f(cls);
        }
        this.f10655x = (Class) Preconditions.d(cls);
        this.f10637f |= 4096;
        return g0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public final T g0() {
        if (!this.f10656y) {
            return f0();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    public T h(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.A) {
            return (T) clone().h(diskCacheStrategy);
        }
        this.f10639h = (DiskCacheStrategy) Preconditions.d(diskCacheStrategy);
        this.f10637f |= 4;
        return g0();
    }

    @NonNull
    public <Y> T h0(@NonNull Option<Y> option, @NonNull Y y7) {
        if (this.A) {
            return (T) clone().h0(option, y7);
        }
        Preconditions.d(option);
        Preconditions.d(y7);
        this.f10653v.e(option, y7);
        return g0();
    }

    public int hashCode() {
        return Util.o(this.f10657z, Util.o(this.f10648q, Util.o(this.f10655x, Util.o(this.f10654w, Util.o(this.f10653v, Util.o(this.f10640i, Util.o(this.f10639h, Util.p(this.C, Util.p(this.B, Util.p(this.f10650s, Util.p(this.f10649r, Util.n(this.f10647p, Util.n(this.f10646o, Util.p(this.f10645n, Util.o(this.f10651t, Util.n(this.f10652u, Util.o(this.f10643l, Util.n(this.f10644m, Util.o(this.f10641j, Util.n(this.f10642k, Util.l(this.f10638g)))))))))))))))))))));
    }

    @NonNull
    public T i(@NonNull DownsampleStrategy downsampleStrategy) {
        return h0(DownsampleStrategy.f10441h, Preconditions.d(downsampleStrategy));
    }

    @NonNull
    public T i0(@NonNull Key key) {
        if (this.A) {
            return (T) clone().i0(key);
        }
        this.f10648q = (Key) Preconditions.d(key);
        this.f10637f |= Spliterator.IMMUTABLE;
        return g0();
    }

    @NonNull
    public T j(int i8) {
        if (this.A) {
            return (T) clone().j(i8);
        }
        this.f10642k = i8;
        this.f10641j = null;
        this.f10637f = (this.f10637f | 32) & (-17);
        return g0();
    }

    @NonNull
    public T j0(float f8) {
        if (this.A) {
            return (T) clone().j0(f8);
        }
        if (f8 >= 0.0f && f8 <= 1.0f) {
            this.f10638g = f8;
            this.f10637f |= 2;
            return g0();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    public T k(Drawable drawable) {
        if (this.A) {
            return (T) clone().k(drawable);
        }
        this.f10641j = drawable;
        this.f10642k = 0;
        this.f10637f = (this.f10637f | 16) & (-33);
        return g0();
    }

    @NonNull
    public T k0(boolean z7) {
        if (this.A) {
            return (T) clone().k0(true);
        }
        this.f10645n = !z7;
        this.f10637f |= Spliterator.NONNULL;
        return g0();
    }

    @NonNull
    public final DiskCacheStrategy l() {
        return this.f10639h;
    }

    @NonNull
    public T l0(@NonNull Transformation<Bitmap> transformation) {
        return m0(transformation, true);
    }

    public final int m() {
        return this.f10642k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T m0(@NonNull Transformation<Bitmap> transformation, boolean z7) {
        if (this.A) {
            return (T) clone().m0(transformation, z7);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z7);
        o0(Bitmap.class, transformation, z7);
        o0(Drawable.class, drawableTransformation, z7);
        o0(BitmapDrawable.class, drawableTransformation.c(), z7);
        o0(GifDrawable.class, new GifDrawableTransformation(transformation), z7);
        return g0();
    }

    public final Drawable n() {
        return this.f10641j;
    }

    @NonNull
    final T n0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.A) {
            return (T) clone().n0(downsampleStrategy, transformation);
        }
        i(downsampleStrategy);
        return l0(transformation);
    }

    public final Drawable o() {
        return this.f10651t;
    }

    @NonNull
    <Y> T o0(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation, boolean z7) {
        if (this.A) {
            return (T) clone().o0(cls, transformation, z7);
        }
        Preconditions.d(cls);
        Preconditions.d(transformation);
        this.f10654w.put(cls, transformation);
        this.f10650s = true;
        int i8 = this.f10637f | 2048 | 65536;
        this.f10637f = i8;
        this.D = false;
        if (z7) {
            this.f10637f = i8 | 131072;
            this.f10649r = true;
        }
        return g0();
    }

    public final int p() {
        return this.f10652u;
    }

    @NonNull
    public T p0(boolean z7) {
        if (this.A) {
            return (T) clone().p0(z7);
        }
        this.E = z7;
        this.f10637f |= 1048576;
        return g0();
    }

    public final boolean q() {
        return this.C;
    }

    @NonNull
    public final Options r() {
        return this.f10653v;
    }

    public final int s() {
        return this.f10646o;
    }

    public final int t() {
        return this.f10647p;
    }

    public final Drawable u() {
        return this.f10643l;
    }

    public final int v() {
        return this.f10644m;
    }

    @NonNull
    public final Priority x() {
        return this.f10640i;
    }

    @NonNull
    public final Class<?> z() {
        return this.f10655x;
    }
}
