package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    private boolean A;
    private RenderMode B;
    private boolean C;
    private final Matrix D;
    private Bitmap E;
    private Canvas F;
    private Rect G;
    private RectF H;
    private Paint I;
    private Rect J;
    private Rect K;
    private RectF L;
    private RectF M;
    private Matrix N;
    private Matrix O;
    private boolean P;

    /* renamed from: f  reason: collision with root package name */
    private LottieComposition f8900f;

    /* renamed from: g  reason: collision with root package name */
    private final LottieValueAnimator f8901g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8902h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8903i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8904j;

    /* renamed from: k  reason: collision with root package name */
    private OnVisibleAction f8905k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<LazyCompositionTask> f8906l;

    /* renamed from: m  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f8907m;

    /* renamed from: n  reason: collision with root package name */
    private ImageAssetManager f8908n;

    /* renamed from: o  reason: collision with root package name */
    private String f8909o;

    /* renamed from: p  reason: collision with root package name */
    private ImageAssetDelegate f8910p;

    /* renamed from: q  reason: collision with root package name */
    private FontAssetManager f8911q;

    /* renamed from: r  reason: collision with root package name */
    FontAssetDelegate f8912r;

    /* renamed from: s  reason: collision with root package name */
    TextDelegate f8913s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8914t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f8915u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f8916v;

    /* renamed from: w  reason: collision with root package name */
    private CompositionLayer f8917w;

    /* renamed from: x  reason: collision with root package name */
    private int f8918x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f8919y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f8920z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface LazyCompositionTask {
        void a(LottieComposition lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.f8901g = lottieValueAnimator;
        this.f8902h = true;
        this.f8903i = false;
        this.f8904j = false;
        this.f8905k = OnVisibleAction.NONE;
        this.f8906l = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.LottieDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.f8917w != null) {
                    LottieDrawable.this.f8917w.L(LottieDrawable.this.f8901g.i());
                }
            }
        };
        this.f8907m = animatorUpdateListener;
        this.f8915u = false;
        this.f8916v = true;
        this.f8918x = 255;
        this.B = RenderMode.AUTOMATIC;
        this.C = false;
        this.D = new Matrix();
        this.P = false;
        lottieValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    private void C(int i8, int i9) {
        Bitmap bitmap = this.E;
        if (bitmap != null && bitmap.getWidth() >= i8 && this.E.getHeight() >= i9) {
            if (this.E.getWidth() > i8 || this.E.getHeight() > i9) {
                Bitmap createBitmap = Bitmap.createBitmap(this.E, 0, 0, i8, i9);
                this.E = createBitmap;
                this.F.setBitmap(createBitmap);
                this.P = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
        this.E = createBitmap2;
        this.F.setBitmap(createBitmap2);
        this.P = true;
    }

    private void D() {
        if (this.F != null) {
            return;
        }
        this.F = new Canvas();
        this.M = new RectF();
        this.N = new Matrix();
        this.O = new Matrix();
        this.G = new Rect();
        this.H = new RectF();
        this.I = new LPaint();
        this.J = new Rect();
        this.K = new Rect();
        this.L = new RectF();
    }

    private Context H() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    private FontAssetManager I() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f8911q == null) {
            this.f8911q = new FontAssetManager(getCallback(), this.f8912r);
        }
        return this.f8911q;
    }

    private ImageAssetManager K() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.f8908n;
        if (imageAssetManager != null && !imageAssetManager.b(H())) {
            this.f8908n = null;
        }
        if (this.f8908n == null) {
            this.f8908n = new ImageAssetManager(getCallback(), this.f8909o, this.f8910p, this.f8900f.j());
        }
        return this.f8908n;
    }

    private boolean Y() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (!(parent instanceof ViewGroup)) {
            return false;
        }
        return !((ViewGroup) parent).getClipChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback, LottieComposition lottieComposition) {
        q(keyPath, obj, lottieValueCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(LottieComposition lottieComposition) {
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(LottieComposition lottieComposition) {
        t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(int i8, LottieComposition lottieComposition) {
        z0(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(int i8, LottieComposition lottieComposition) {
        E0(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(String str, LottieComposition lottieComposition) {
        F0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(float f8, LottieComposition lottieComposition) {
        G0(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i8, int i9, LottieComposition lottieComposition) {
        H0(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(String str, LottieComposition lottieComposition) {
        I0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(int i8, LottieComposition lottieComposition) {
        J0(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(String str, LottieComposition lottieComposition) {
        K0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(float f8, LottieComposition lottieComposition) {
        L0(f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(float f8, LottieComposition lottieComposition) {
        O0(f8);
    }

    private boolean r() {
        if (!this.f8902h && !this.f8903i) {
            return false;
        }
        return true;
    }

    private void r0(Canvas canvas, CompositionLayer compositionLayer) {
        if (this.f8900f != null && compositionLayer != null) {
            D();
            canvas.getMatrix(this.N);
            canvas.getClipBounds(this.G);
            w(this.G, this.H);
            this.N.mapRect(this.H);
            x(this.H, this.G);
            if (this.f8916v) {
                this.M.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
            } else {
                compositionLayer.f(this.M, null, false);
            }
            this.N.mapRect(this.M);
            Rect bounds = getBounds();
            float width = bounds.width() / getIntrinsicWidth();
            float height = bounds.height() / getIntrinsicHeight();
            u0(this.M, width, height);
            if (!Y()) {
                RectF rectF = this.M;
                Rect rect = this.G;
                rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
            }
            int ceil = (int) Math.ceil(this.M.width());
            int ceil2 = (int) Math.ceil(this.M.height());
            if (ceil != 0 && ceil2 != 0) {
                C(ceil, ceil2);
                if (this.P) {
                    this.D.set(this.N);
                    this.D.preScale(width, height);
                    Matrix matrix = this.D;
                    RectF rectF2 = this.M;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    this.E.eraseColor(0);
                    compositionLayer.h(this.F, this.D, this.f8918x);
                    this.N.invert(this.O);
                    this.O.mapRect(this.L, this.M);
                    x(this.L, this.K);
                }
                this.J.set(0, 0, ceil, ceil2);
                canvas.drawBitmap(this.E, this.J, this.K, this.I);
            }
        }
    }

    private void s() {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            return;
        }
        CompositionLayer compositionLayer = new CompositionLayer(this, LayerParser.a(lottieComposition), lottieComposition.k(), lottieComposition);
        this.f8917w = compositionLayer;
        if (this.f8920z) {
            compositionLayer.J(true);
        }
        this.f8917w.O(this.f8916v);
    }

    private void u0(RectF rectF, float f8, float f9) {
        rectF.set(rectF.left * f8, rectF.top * f9, rectF.right * f8, rectF.bottom * f9);
    }

    private void v() {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            return;
        }
        this.C = this.B.a(Build.VERSION.SDK_INT, lottieComposition.q(), lottieComposition.m());
    }

    private void w(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void x(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void y(Canvas canvas) {
        CompositionLayer compositionLayer = this.f8917w;
        LottieComposition lottieComposition = this.f8900f;
        if (compositionLayer != null && lottieComposition != null) {
            this.D.reset();
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                float height = bounds.height() / lottieComposition.b().height();
                this.D.preScale(bounds.width() / lottieComposition.b().width(), height);
            }
            compositionLayer.h(canvas, this.D, this.f8918x);
        }
    }

    public boolean A() {
        return this.f8914t;
    }

    public void A0(boolean z7) {
        this.f8903i = z7;
    }

    public void B() {
        this.f8906l.clear();
        this.f8901g.h();
        if (!isVisible()) {
            this.f8905k = OnVisibleAction.NONE;
        }
    }

    public void B0(ImageAssetDelegate imageAssetDelegate) {
        this.f8910p = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.f8908n;
        if (imageAssetManager != null) {
            imageAssetManager.d(imageAssetDelegate);
        }
    }

    public void C0(String str) {
        this.f8909o = str;
    }

    public void D0(boolean z7) {
        this.f8915u = z7;
    }

    public Bitmap E(String str) {
        ImageAssetManager K = K();
        if (K != null) {
            return K.a(str);
        }
        return null;
    }

    public void E0(final int i8) {
        if (this.f8900f == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.s
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.g0(i8, lottieComposition);
                }
            });
        } else {
            this.f8901g.A(i8 + 0.99f);
        }
    }

    public boolean F() {
        return this.f8916v;
    }

    public void F0(final String str) {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.u
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.h0(str, lottieComposition2);
                }
            });
            return;
        }
        Marker l8 = lottieComposition.l(str);
        if (l8 != null) {
            E0((int) (l8.f9298b + l8.f9299c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public LottieComposition G() {
        return this.f8900f;
    }

    public void G0(final float f8) {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.w
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.i0(f8, lottieComposition2);
                }
            });
        } else {
            this.f8901g.A(MiscUtils.i(lottieComposition.p(), this.f8900f.f(), f8));
        }
    }

    public void H0(final int i8, final int i9) {
        if (this.f8900f == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.p
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.j0(i8, i9, lottieComposition);
                }
            });
        } else {
            this.f8901g.B(i8, i9 + 0.99f);
        }
    }

    public void I0(final String str) {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.n
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.k0(str, lottieComposition2);
                }
            });
            return;
        }
        Marker l8 = lottieComposition.l(str);
        if (l8 != null) {
            int i8 = (int) l8.f9298b;
            H0(i8, ((int) l8.f9299c) + i8);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public int J() {
        return (int) this.f8901g.j();
    }

    public void J0(final int i8) {
        if (this.f8900f == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.q
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.l0(i8, lottieComposition);
                }
            });
        } else {
            this.f8901g.C(i8);
        }
    }

    public void K0(final String str) {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.v
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.m0(str, lottieComposition2);
                }
            });
            return;
        }
        Marker l8 = lottieComposition.l(str);
        if (l8 != null) {
            J0((int) l8.f9298b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public String L() {
        return this.f8909o;
    }

    public void L0(final float f8) {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.r
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition2) {
                    LottieDrawable.this.n0(f8, lottieComposition2);
                }
            });
        } else {
            J0((int) MiscUtils.i(lottieComposition.p(), this.f8900f.f(), f8));
        }
    }

    public LottieImageAsset M(String str) {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            return null;
        }
        return lottieComposition.j().get(str);
    }

    public void M0(boolean z7) {
        if (this.f8920z == z7) {
            return;
        }
        this.f8920z = z7;
        CompositionLayer compositionLayer = this.f8917w;
        if (compositionLayer != null) {
            compositionLayer.J(z7);
        }
    }

    public boolean N() {
        return this.f8915u;
    }

    public void N0(boolean z7) {
        this.f8919y = z7;
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition != null) {
            lottieComposition.v(z7);
        }
    }

    public float O() {
        return this.f8901g.l();
    }

    public void O0(final float f8) {
        if (this.f8900f == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.m
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.o0(f8, lottieComposition);
                }
            });
            return;
        }
        L.a("Drawable#setProgress");
        this.f8901g.z(this.f8900f.h(f8));
        L.b("Drawable#setProgress");
    }

    public float P() {
        return this.f8901g.m();
    }

    public void P0(RenderMode renderMode) {
        this.B = renderMode;
        v();
    }

    public PerformanceTracker Q() {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition != null) {
            return lottieComposition.n();
        }
        return null;
    }

    public void Q0(int i8) {
        this.f8901g.setRepeatCount(i8);
    }

    public float R() {
        return this.f8901g.i();
    }

    public void R0(int i8) {
        this.f8901g.setRepeatMode(i8);
    }

    public RenderMode S() {
        if (this.C) {
            return RenderMode.SOFTWARE;
        }
        return RenderMode.HARDWARE;
    }

    public void S0(boolean z7) {
        this.f8904j = z7;
    }

    public int T() {
        return this.f8901g.getRepeatCount();
    }

    public void T0(float f8) {
        this.f8901g.D(f8);
    }

    @SuppressLint({"WrongConstant"})
    public int U() {
        return this.f8901g.getRepeatMode();
    }

    public void U0(Boolean bool) {
        this.f8902h = bool.booleanValue();
    }

    public float V() {
        return this.f8901g.n();
    }

    public void V0(TextDelegate textDelegate) {
        this.f8913s = textDelegate;
    }

    public TextDelegate W() {
        return this.f8913s;
    }

    public boolean W0() {
        if (this.f8913s == null && this.f8900f.c().k() > 0) {
            return true;
        }
        return false;
    }

    public Typeface X(String str, String str2) {
        FontAssetManager I = I();
        if (I != null) {
            return I.b(str, str2);
        }
        return null;
    }

    public boolean Z() {
        LottieValueAnimator lottieValueAnimator = this.f8901g;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a0() {
        if (isVisible()) {
            return this.f8901g.isRunning();
        }
        OnVisibleAction onVisibleAction = this.f8905k;
        if (onVisibleAction != OnVisibleAction.PLAY && onVisibleAction != OnVisibleAction.RESUME) {
            return false;
        }
        return true;
    }

    public boolean b0() {
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        L.a("Drawable#draw");
        if (this.f8904j) {
            try {
                if (this.C) {
                    r0(canvas, this.f8917w);
                } else {
                    y(canvas);
                }
            } catch (Throwable th) {
                Logger.b("Lottie crashed in draw!", th);
            }
        } else if (this.C) {
            r0(canvas, this.f8917w);
        } else {
            y(canvas);
        }
        this.P = false;
        L.b("Drawable#draw");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f8918x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.f8900f;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.P) {
            return;
        }
        this.P = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return Z();
    }

    public void p(Animator.AnimatorListener animatorListener) {
        this.f8901g.addListener(animatorListener);
    }

    public void p0() {
        this.f8906l.clear();
        this.f8901g.p();
        if (!isVisible()) {
            this.f8905k = OnVisibleAction.NONE;
        }
    }

    public <T> void q(final KeyPath keyPath, final T t7, final LottieValueCallback<T> lottieValueCallback) {
        CompositionLayer compositionLayer = this.f8917w;
        if (compositionLayer == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.c0(keyPath, t7, lottieValueCallback, lottieComposition);
                }
            });
            return;
        }
        boolean z7 = true;
        if (keyPath == KeyPath.f9292c) {
            compositionLayer.d(t7, lottieValueCallback);
        } else if (keyPath.d() != null) {
            keyPath.d().d(t7, lottieValueCallback);
        } else {
            List<KeyPath> s02 = s0(keyPath);
            for (int i8 = 0; i8 < s02.size(); i8++) {
                s02.get(i8).d().d(t7, lottieValueCallback);
            }
            z7 = true ^ s02.isEmpty();
        }
        if (z7) {
            invalidateSelf();
            if (t7 == LottieProperty.E) {
                O0(R());
            }
        }
    }

    public void q0() {
        float O;
        if (this.f8917w == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.x
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.d0(lottieComposition);
                }
            });
            return;
        }
        v();
        if (r() || T() == 0) {
            if (isVisible()) {
                this.f8901g.q();
                this.f8905k = OnVisibleAction.NONE;
            } else {
                this.f8905k = OnVisibleAction.PLAY;
            }
        }
        if (!r()) {
            if (V() < 0.0f) {
                O = P();
            } else {
                O = O();
            }
            z0((int) O);
            this.f8901g.h();
            if (!isVisible()) {
                this.f8905k = OnVisibleAction.NONE;
            }
        }
    }

    public List<KeyPath> s0(KeyPath keyPath) {
        if (this.f8917w == null) {
            Logger.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f8917w.e(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j8) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.f8918x = i8;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean z9 = !isVisible();
        boolean visible = super.setVisible(z7, z8);
        if (z7) {
            OnVisibleAction onVisibleAction = this.f8905k;
            if (onVisibleAction == OnVisibleAction.PLAY) {
                q0();
            } else if (onVisibleAction == OnVisibleAction.RESUME) {
                t0();
            }
        } else if (this.f8901g.isRunning()) {
            p0();
            this.f8905k = OnVisibleAction.RESUME;
        } else if (!z9) {
            this.f8905k = OnVisibleAction.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        q0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        B();
    }

    public void t() {
        this.f8906l.clear();
        this.f8901g.cancel();
        if (!isVisible()) {
            this.f8905k = OnVisibleAction.NONE;
        }
    }

    public void t0() {
        float O;
        if (this.f8917w == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.t
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.e0(lottieComposition);
                }
            });
            return;
        }
        v();
        if (r() || T() == 0) {
            if (isVisible()) {
                this.f8901g.u();
                this.f8905k = OnVisibleAction.NONE;
            } else {
                this.f8905k = OnVisibleAction.RESUME;
            }
        }
        if (!r()) {
            if (V() < 0.0f) {
                O = P();
            } else {
                O = O();
            }
            z0((int) O);
            this.f8901g.h();
            if (!isVisible()) {
                this.f8905k = OnVisibleAction.NONE;
            }
        }
    }

    public void u() {
        if (this.f8901g.isRunning()) {
            this.f8901g.cancel();
            if (!isVisible()) {
                this.f8905k = OnVisibleAction.NONE;
            }
        }
        this.f8900f = null;
        this.f8917w = null;
        this.f8908n = null;
        this.f8901g.f();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void v0(boolean z7) {
        this.A = z7;
    }

    public void w0(boolean z7) {
        if (z7 != this.f8916v) {
            this.f8916v = z7;
            CompositionLayer compositionLayer = this.f8917w;
            if (compositionLayer != null) {
                compositionLayer.O(z7);
            }
            invalidateSelf();
        }
    }

    public boolean x0(LottieComposition lottieComposition) {
        if (this.f8900f == lottieComposition) {
            return false;
        }
        this.P = true;
        u();
        this.f8900f = lottieComposition;
        s();
        this.f8901g.x(lottieComposition);
        O0(this.f8901g.getAnimatedFraction());
        Iterator it = new ArrayList(this.f8906l).iterator();
        while (it.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.a(lottieComposition);
            }
            it.remove();
        }
        this.f8906l.clear();
        lottieComposition.v(this.f8919y);
        v();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void y0(FontAssetDelegate fontAssetDelegate) {
        this.f8912r = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.f8911q;
        if (fontAssetManager != null) {
            fontAssetManager.c(fontAssetDelegate);
        }
    }

    public void z(boolean z7) {
        if (this.f8914t == z7) {
            return;
        }
        this.f8914t = z7;
        if (this.f8900f != null) {
            s();
        }
    }

    public void z0(final int i8) {
        if (this.f8900f == null) {
            this.f8906l.add(new LazyCompositionTask() { // from class: com.airbnb.lottie.y
                @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
                public final void a(LottieComposition lottieComposition) {
                    LottieDrawable.this.f0(i8, lottieComposition);
                }
            });
        } else {
            this.f8901g.z(i8);
        }
    }
}
