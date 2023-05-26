package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable {

    /* renamed from: f  reason: collision with root package name */
    private final GifState f10528f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10529g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10530h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10531i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10532j;

    /* renamed from: k  reason: collision with root package name */
    private int f10533k;

    /* renamed from: l  reason: collision with root package name */
    private int f10534l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10535m;

    /* renamed from: n  reason: collision with root package name */
    private Paint f10536n;

    /* renamed from: o  reason: collision with root package name */
    private Rect f10537o;

    /* renamed from: p  reason: collision with root package name */
    private List<Animatable2Compat$AnimationCallback> f10538p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class GifState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final GifFrameLoader f10539a;

        GifState(GifFrameLoader gifFrameLoader) {
            this.f10539a = gifFrameLoader;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i8, int i9, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.c(context), gifDecoder, i8, i9, transformation, bitmap)));
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f10537o == null) {
            this.f10537o = new Rect();
        }
        return this.f10537o;
    }

    private Paint h() {
        if (this.f10536n == null) {
            this.f10536n = new Paint(2);
        }
        return this.f10536n;
    }

    private void j() {
        List<Animatable2Compat$AnimationCallback> list = this.f10538p;
        if (list != null) {
            int size = list.size();
            for (int i8 = 0; i8 < size; i8++) {
                this.f10538p.get(i8).b(this);
            }
        }
    }

    private void l() {
        this.f10533k = 0;
    }

    private void n() {
        Preconditions.a(!this.f10531i, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f10528f.f10539a.f() == 1) {
            invalidateSelf();
        } else if (!this.f10529g) {
            this.f10529g = true;
            this.f10528f.f10539a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f10529g = false;
        this.f10528f.f10539a.s(this);
    }

    @Override // com.bumptech.glide.load.resource.gif.GifFrameLoader.FrameCallback
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f10533k++;
        }
        int i8 = this.f10534l;
        if (i8 != -1 && this.f10533k >= i8) {
            j();
            stop();
        }
    }

    public ByteBuffer c() {
        return this.f10528f.f10539a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f10531i) {
            return;
        }
        if (this.f10535m) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f10535m = false;
        }
        canvas.drawBitmap(this.f10528f.f10539a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f10528f.f10539a.e();
    }

    public int f() {
        return this.f10528f.f10539a.f();
    }

    public int g() {
        return this.f10528f.f10539a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f10528f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f10528f.f10539a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f10528f.f10539a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f10528f.f10539a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f10529g;
    }

    public void k() {
        this.f10531i = true;
        this.f10528f.f10539a.a();
    }

    public void m(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f10528f.f10539a.o(transformation, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f10535m = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        h().setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        Preconditions.a(!this.f10531i, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f10532j = z7;
        if (!z7) {
            o();
        } else if (this.f10530h) {
            n();
        }
        return super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f10530h = true;
        l();
        if (this.f10532j) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f10530h = false;
        o();
    }

    GifDrawable(GifState gifState) {
        this.f10532j = true;
        this.f10534l = -1;
        this.f10528f = (GifState) Preconditions.d(gifState);
    }
}
