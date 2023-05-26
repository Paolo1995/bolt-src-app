package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    private static final int[] D = {16842919};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.OnScrollListener C;

    /* renamed from: a  reason: collision with root package name */
    private final int f7013a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7014b;

    /* renamed from: c  reason: collision with root package name */
    final StateListDrawable f7015c;

    /* renamed from: d  reason: collision with root package name */
    final Drawable f7016d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7017e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7018f;

    /* renamed from: g  reason: collision with root package name */
    private final StateListDrawable f7019g;

    /* renamed from: h  reason: collision with root package name */
    private final Drawable f7020h;

    /* renamed from: i  reason: collision with root package name */
    private final int f7021i;

    /* renamed from: j  reason: collision with root package name */
    private final int f7022j;

    /* renamed from: k  reason: collision with root package name */
    int f7023k;

    /* renamed from: l  reason: collision with root package name */
    int f7024l;

    /* renamed from: m  reason: collision with root package name */
    float f7025m;

    /* renamed from: n  reason: collision with root package name */
    int f7026n;

    /* renamed from: o  reason: collision with root package name */
    int f7027o;

    /* renamed from: p  reason: collision with root package name */
    float f7028p;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f7031s;

    /* renamed from: z  reason: collision with root package name */
    final ValueAnimator f7038z;

    /* renamed from: q  reason: collision with root package name */
    private int f7029q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f7030r = 0;

    /* renamed from: t  reason: collision with root package name */
    private boolean f7032t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f7033u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f7034v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f7035w = 0;

    /* renamed from: x  reason: collision with root package name */
    private final int[] f7036x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    private final int[] f7037y = new int[2];

    /* loaded from: classes.dex */
    private class AnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f7041a = false;

        AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f7041a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f7041a) {
                this.f7041a = false;
            } else if (((Float) FastScroller.this.f7038z.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.A = 0;
                fastScroller.A(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.A = 2;
                fastScroller2.x();
            }
        }
    }

    /* loaded from: classes.dex */
    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f7015c.setAlpha(floatValue);
            FastScroller.this.f7016d.setAlpha(floatValue);
            FastScroller.this.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i8, int i9, int i10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7038z = ofFloat;
        this.A = 0;
        this.B = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            @Override // java.lang.Runnable
            public void run() {
                FastScroller.this.s(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION);
            }
        };
        this.C = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(RecyclerView recyclerView2, int i11, int i12) {
                FastScroller.this.D(recyclerView2.computeHorizontalScrollOffset(), recyclerView2.computeVerticalScrollOffset());
            }
        };
        this.f7015c = stateListDrawable;
        this.f7016d = drawable;
        this.f7019g = stateListDrawable2;
        this.f7020h = drawable2;
        this.f7017e = Math.max(i8, stateListDrawable.getIntrinsicWidth());
        this.f7018f = Math.max(i8, drawable.getIntrinsicWidth());
        this.f7021i = Math.max(i8, stateListDrawable2.getIntrinsicWidth());
        this.f7022j = Math.max(i8, drawable2.getIntrinsicWidth());
        this.f7013a = i9;
        this.f7014b = i10;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new AnimatorListener());
        ofFloat.addUpdateListener(new AnimatorUpdater());
        l(recyclerView);
    }

    private void B() {
        this.f7031s.h(this);
        this.f7031s.k(this);
        this.f7031s.l(this.C);
    }

    private void E(float f8) {
        int[] r7 = r();
        float max = Math.max(r7[0], Math.min(r7[1], f8));
        if (Math.abs(this.f7024l - max) < 2.0f) {
            return;
        }
        int z7 = z(this.f7025m, max, r7, this.f7031s.computeVerticalScrollRange(), this.f7031s.computeVerticalScrollOffset(), this.f7030r);
        if (z7 != 0) {
            this.f7031s.scrollBy(0, z7);
        }
        this.f7025m = max;
    }

    private void m() {
        this.f7031s.removeCallbacks(this.B);
    }

    private void n() {
        this.f7031s.d1(this);
        this.f7031s.f1(this);
        this.f7031s.g1(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i8 = this.f7030r;
        int i9 = this.f7021i;
        int i10 = i8 - i9;
        int i11 = this.f7027o;
        int i12 = this.f7026n;
        int i13 = i11 - (i12 / 2);
        this.f7019g.setBounds(0, 0, i12, i9);
        this.f7020h.setBounds(0, 0, this.f7029q, this.f7022j);
        canvas.translate(0.0f, i10);
        this.f7020h.draw(canvas);
        canvas.translate(i13, 0.0f);
        this.f7019g.draw(canvas);
        canvas.translate(-i13, -i10);
    }

    private void p(Canvas canvas) {
        int i8 = this.f7029q;
        int i9 = this.f7017e;
        int i10 = i8 - i9;
        int i11 = this.f7024l;
        int i12 = this.f7023k;
        int i13 = i11 - (i12 / 2);
        this.f7015c.setBounds(0, 0, i9, i12);
        this.f7016d.setBounds(0, 0, this.f7018f, this.f7030r);
        if (u()) {
            this.f7016d.draw(canvas);
            canvas.translate(this.f7017e, i13);
            canvas.scale(-1.0f, 1.0f);
            this.f7015c.draw(canvas);
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.f7017e, -i13);
            return;
        }
        canvas.translate(i10, 0.0f);
        this.f7016d.draw(canvas);
        canvas.translate(0.0f, i13);
        this.f7015c.draw(canvas);
        canvas.translate(-i10, -i13);
    }

    private int[] q() {
        int[] iArr = this.f7037y;
        int i8 = this.f7014b;
        iArr[0] = i8;
        iArr[1] = this.f7029q - i8;
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.f7036x;
        int i8 = this.f7014b;
        iArr[0] = i8;
        iArr[1] = this.f7030r - i8;
        return iArr;
    }

    private void t(float f8) {
        int[] q8 = q();
        float max = Math.max(q8[0], Math.min(q8[1], f8));
        if (Math.abs(this.f7027o - max) < 2.0f) {
            return;
        }
        int z7 = z(this.f7028p, max, q8, this.f7031s.computeHorizontalScrollRange(), this.f7031s.computeHorizontalScrollOffset(), this.f7029q);
        if (z7 != 0) {
            this.f7031s.scrollBy(z7, 0);
        }
        this.f7028p = max;
    }

    private boolean u() {
        if (ViewCompat.E(this.f7031s) == 1) {
            return true;
        }
        return false;
    }

    private void y(int i8) {
        m();
        this.f7031s.postDelayed(this.B, i8);
    }

    private int z(float f8, float f9, int[] iArr, int i8, int i9, int i10) {
        int i11 = iArr[1] - iArr[0];
        if (i11 == 0) {
            return 0;
        }
        int i12 = i8 - i10;
        int i13 = (int) (((f9 - f8) / i11) * i12);
        int i14 = i9 + i13;
        if (i14 >= i12 || i14 < 0) {
            return 0;
        }
        return i13;
    }

    void A(int i8) {
        if (i8 == 2 && this.f7034v != 2) {
            this.f7015c.setState(D);
            m();
        }
        if (i8 == 0) {
            x();
        } else {
            C();
        }
        if (this.f7034v == 2 && i8 != 2) {
            this.f7015c.setState(E);
            y(1200);
        } else if (i8 == 1) {
            y(1500);
        }
        this.f7034v = i8;
    }

    public void C() {
        int i8 = this.A;
        if (i8 != 0) {
            if (i8 == 3) {
                this.f7038z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f7038z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f7038z.setDuration(500L);
        this.f7038z.setStartDelay(0L);
        this.f7038z.start();
    }

    void D(int i8, int i9) {
        boolean z7;
        boolean z8;
        int computeVerticalScrollRange = this.f7031s.computeVerticalScrollRange();
        int i10 = this.f7030r;
        if (computeVerticalScrollRange - i10 > 0 && i10 >= this.f7013a) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f7032t = z7;
        int computeHorizontalScrollRange = this.f7031s.computeHorizontalScrollRange();
        int i11 = this.f7029q;
        if (computeHorizontalScrollRange - i11 > 0 && i11 >= this.f7013a) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.f7033u = z8;
        boolean z9 = this.f7032t;
        if (!z9 && !z8) {
            if (this.f7034v != 0) {
                A(0);
                return;
            }
            return;
        }
        if (z9) {
            float f8 = i10;
            this.f7024l = (int) ((f8 * (i9 + (f8 / 2.0f))) / computeVerticalScrollRange);
            this.f7023k = Math.min(i10, (i10 * i10) / computeVerticalScrollRange);
        }
        if (this.f7033u) {
            float f9 = i11;
            this.f7027o = (int) ((f9 * (i8 + (f9 / 2.0f))) / computeHorizontalScrollRange);
            this.f7026n = Math.min(i11, (i11 * i11) / computeHorizontalScrollRange);
        }
        int i12 = this.f7034v;
        if (i12 == 0 || i12 == 1) {
            A(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void a(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (this.f7034v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean w7 = w(motionEvent.getX(), motionEvent.getY());
            boolean v7 = v(motionEvent.getX(), motionEvent.getY());
            if (w7 || v7) {
                if (v7) {
                    this.f7035w = 1;
                    this.f7028p = (int) motionEvent.getX();
                } else if (w7) {
                    this.f7035w = 2;
                    this.f7025m = (int) motionEvent.getY();
                }
                A(2);
            }
        } else if (motionEvent.getAction() == 1 && this.f7034v == 2) {
            this.f7025m = 0.0f;
            this.f7028p = 0.0f;
            A(1);
            this.f7035w = 0;
        } else if (motionEvent.getAction() == 2 && this.f7034v == 2) {
            C();
            if (this.f7035w == 1) {
                t(motionEvent.getX());
            }
            if (this.f7035w == 2) {
                E(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean c(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        int i8 = this.f7034v;
        if (i8 == 1) {
            boolean w7 = w(motionEvent.getX(), motionEvent.getY());
            boolean v7 = v(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!w7 && !v7) {
                return false;
            }
            if (v7) {
                this.f7035w = 1;
                this.f7028p = (int) motionEvent.getX();
            } else if (w7) {
                this.f7035w = 2;
                this.f7025m = (int) motionEvent.getY();
            }
            A(2);
        } else if (i8 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void e(boolean z7) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f7029q == this.f7031s.getWidth() && this.f7030r == this.f7031s.getHeight()) {
            if (this.A != 0) {
                if (this.f7032t) {
                    p(canvas);
                }
                if (this.f7033u) {
                    o(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.f7029q = this.f7031s.getWidth();
        this.f7030r = this.f7031s.getHeight();
        A(0);
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f7031s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.f7031s = recyclerView;
        if (recyclerView != null) {
            B();
        }
    }

    void s(int i8) {
        int i9 = this.A;
        if (i9 != 1) {
            if (i9 != 2) {
                return;
            }
        } else {
            this.f7038z.cancel();
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f7038z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f7038z.setDuration(i8);
        this.f7038z.start();
    }

    boolean v(float f8, float f9) {
        if (f9 >= this.f7030r - this.f7021i) {
            int i8 = this.f7027o;
            int i9 = this.f7026n;
            if (f8 >= i8 - (i9 / 2) && f8 <= i8 + (i9 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean w(float f8, float f9) {
        if (!u() ? f8 >= this.f7029q - this.f7017e : f8 <= this.f7017e) {
            int i8 = this.f7024l;
            int i9 = this.f7023k;
            if (f9 >= i8 - (i9 / 2) && f9 <= i8 + (i9 / 2)) {
                return true;
            }
        }
        return false;
    }

    void x() {
        this.f7031s.invalidate();
    }
}
