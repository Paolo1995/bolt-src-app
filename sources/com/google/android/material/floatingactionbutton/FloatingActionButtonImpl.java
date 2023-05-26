package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FloatingActionButtonImpl {
    static final TimeInterpolator C = AnimationUtils.f12722c;
    private static final int D = R$attr.motionDurationLong2;
    private static final int E = R$attr.motionEasingEmphasizedInterpolator;
    private static final int F = R$attr.motionDurationMedium1;
    private static final int G = R$attr.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] H = {16842919, 16842910};
    static final int[] I = {16843623, 16842908, 16842910};
    static final int[] J = {16842908, 16842910};
    static final int[] K = {16843623, 16842910};
    static final int[] L = {16842910};
    static final int[] M = new int[0];
    private ViewTreeObserver.OnPreDrawListener B;

    /* renamed from: a  reason: collision with root package name */
    ShapeAppearanceModel f13451a;

    /* renamed from: b  reason: collision with root package name */
    MaterialShapeDrawable f13452b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f13453c;

    /* renamed from: d  reason: collision with root package name */
    Drawable f13454d;

    /* renamed from: e  reason: collision with root package name */
    boolean f13455e;

    /* renamed from: g  reason: collision with root package name */
    float f13457g;

    /* renamed from: h  reason: collision with root package name */
    float f13458h;

    /* renamed from: i  reason: collision with root package name */
    float f13459i;

    /* renamed from: j  reason: collision with root package name */
    int f13460j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final StateListAnimator f13461k;

    /* renamed from: l  reason: collision with root package name */
    private Animator f13462l;

    /* renamed from: m  reason: collision with root package name */
    private MotionSpec f13463m;

    /* renamed from: n  reason: collision with root package name */
    private MotionSpec f13464n;

    /* renamed from: o  reason: collision with root package name */
    private float f13465o;

    /* renamed from: q  reason: collision with root package name */
    private int f13467q;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f13469s;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f13470t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<InternalTransformationCallback> f13471u;

    /* renamed from: v  reason: collision with root package name */
    final FloatingActionButton f13472v;

    /* renamed from: w  reason: collision with root package name */
    final ShadowViewDelegate f13473w;

    /* renamed from: f  reason: collision with root package name */
    boolean f13456f = true;

    /* renamed from: p  reason: collision with root package name */
    private float f13466p = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    private int f13468r = 0;

    /* renamed from: x  reason: collision with root package name */
    private final Rect f13474x = new Rect();

    /* renamed from: y  reason: collision with root package name */
    private final RectF f13475y = new RectF();

    /* renamed from: z  reason: collision with root package name */
    private final RectF f13476z = new RectF();
    private final Matrix A = new Matrix();

    /* loaded from: classes.dex */
    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f13457g + floatingActionButtonImpl.f13458h;
        }
    }

    /* loaded from: classes.dex */
    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.f13457g + floatingActionButtonImpl.f13459i;
        }
    }

    /* loaded from: classes.dex */
    interface InternalTransformationCallback {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    interface InternalVisibilityChangedListener {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        protected float a() {
            return FloatingActionButtonImpl.this.f13457g;
        }
    }

    /* loaded from: classes.dex */
    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13501a;

        /* renamed from: b  reason: collision with root package name */
        private float f13502b;

        /* renamed from: c  reason: collision with root package name */
        private float f13503c;

        private ShadowAnimatorImpl() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.d0((int) this.f13503c);
            this.f13501a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float w7;
            if (!this.f13501a) {
                MaterialShapeDrawable materialShapeDrawable = FloatingActionButtonImpl.this.f13452b;
                if (materialShapeDrawable == null) {
                    w7 = 0.0f;
                } else {
                    w7 = materialShapeDrawable.w();
                }
                this.f13502b = w7;
                this.f13503c = a();
                this.f13501a = true;
            }
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float f8 = this.f13502b;
            floatingActionButtonImpl.d0((int) (f8 + ((this.f13503c - f8) * valueAnimator.getAnimatedFraction())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.f13472v = floatingActionButton;
        this.f13473w = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f13461k = stateListAnimator;
        stateListAnimator.a(H, k(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.a(I, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(J, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(K, k(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.a(L, k(new ResetElevationAnimation()));
        stateListAnimator.a(M, k(new DisabledElevationAnimation()));
        this.f13465o = floatingActionButton.getRotation();
    }

    private boolean X() {
        if (ViewCompat.W(this.f13472v) && !this.f13472v.isInEditMode()) {
            return true;
        }
        return false;
    }

    private void e0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new TypeEvaluator<Float>() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.5

            /* renamed from: a  reason: collision with root package name */
            FloatEvaluator f13494a = new FloatEvaluator();

            @Override // android.animation.TypeEvaluator
            /* renamed from: a */
            public Float evaluate(float f8, Float f9, Float f10) {
                float floatValue = this.f13494a.evaluate(f8, (Number) f9, (Number) f10).floatValue();
                if (floatValue < 0.1f) {
                    floatValue = 0.0f;
                }
                return Float.valueOf(floatValue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(float f8, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f13472v.getDrawable();
        if (drawable != null && this.f13467q != 0) {
            RectF rectF = this.f13475y;
            RectF rectF2 = this.f13476z;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            int i8 = this.f13467q;
            rectF2.set(0.0f, 0.0f, i8, i8);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i9 = this.f13467q;
            matrix.postScale(f8, f8, i9 / 2.0f, i9 / 2.0f);
        }
    }

    @NonNull
    private AnimatorSet i(@NonNull MotionSpec motionSpec, float f8, float f9, float f10) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13472v, View.ALPHA, f8);
        motionSpec.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f13472v, View.SCALE_X, f9);
        motionSpec.h("scale").a(ofFloat2);
        e0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f13472v, View.SCALE_Y, f9);
        motionSpec.h("scale").a(ofFloat3);
        e0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f10, this.A);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f13472v, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            /* renamed from: a */
            public Matrix evaluate(float f11, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
                FloatingActionButtonImpl.this.f13466p = f11;
                return super.evaluate(f11, matrix, matrix2);
            }
        }, new Matrix(this.A));
        motionSpec.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(final float f8, final float f9, final float f10, int i8, int i9) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.f13472v.getAlpha();
        final float scaleX = this.f13472v.getScaleX();
        final float scaleY = this.f13472v.getScaleY();
        final float f11 = this.f13466p;
        final Matrix matrix = new Matrix(this.A);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl.this.f13472v.setAlpha(AnimationUtils.b(alpha, f8, 0.0f, 0.2f, floatValue));
                FloatingActionButtonImpl.this.f13472v.setScaleX(AnimationUtils.a(scaleX, f9, floatValue));
                FloatingActionButtonImpl.this.f13472v.setScaleY(AnimationUtils.a(scaleY, f9, floatValue));
                FloatingActionButtonImpl.this.f13466p = AnimationUtils.a(f11, f10, floatValue);
                FloatingActionButtonImpl.this.h(AnimationUtils.a(f11, f10, floatValue), matrix);
                FloatingActionButtonImpl.this.f13472v.setImageMatrix(matrix);
            }
        });
        arrayList.add(ofFloat);
        AnimatorSetCompat.a(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.f(this.f13472v.getContext(), i8, this.f13472v.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.g(this.f13472v.getContext(), i9, AnimationUtils.f12721b));
        return animatorSet;
    }

    @NonNull
    private ValueAnimator k(@NonNull ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(C);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.B == null) {
            this.B = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.6
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.F();
                    return true;
                }
            };
        }
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        ViewTreeObserver viewTreeObserver = this.f13472v.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.B;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int[] iArr) {
        throw null;
    }

    void D(float f8, float f9, float f10) {
        throw null;
    }

    void E(@NonNull Rect rect) {
        Preconditions.h(this.f13454d, "Didn't initialize content background");
        if (W()) {
            this.f13473w.d(new InsetDrawable(this.f13454d, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.f13473w.d(this.f13454d);
    }

    void F() {
        float rotation = this.f13472v.getRotation();
        if (this.f13465o != rotation) {
            this.f13465o = rotation;
            a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        ArrayList<InternalTransformationCallback> arrayList = this.f13471u;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        ArrayList<InternalTransformationCallback> arrayList = this.f13471u;
        if (arrayList != null) {
            Iterator<InternalTransformationCallback> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    boolean I() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f13452b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.f13452b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(float f8) {
        if (this.f13457g != f8) {
            this.f13457g = f8;
            D(f8, this.f13458h, this.f13459i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(boolean z7) {
        this.f13455e = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(MotionSpec motionSpec) {
        this.f13464n = motionSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void O(float f8) {
        if (this.f13458h != f8) {
            this.f13458h = f8;
            D(this.f13457g, f8, this.f13459i);
        }
    }

    final void P(float f8) {
        this.f13466p = f8;
        Matrix matrix = this.A;
        h(f8, matrix);
        this.f13472v.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(int i8) {
        if (this.f13467q != i8) {
            this.f13467q = i8;
            b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void R(float f8) {
        if (this.f13459i != f8) {
            this.f13459i = f8;
            D(this.f13457g, this.f13458h, f8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ColorStateList colorStateList) {
        Drawable drawable = this.f13453c;
        if (drawable != null) {
            DrawableCompat.o(drawable, RippleUtils.e(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(boolean z7) {
        this.f13456f = z7;
        c0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f13451a = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f13452b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Drawable drawable = this.f13453c;
        if (drawable instanceof Shapeable) {
            ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void V(MotionSpec motionSpec) {
        this.f13463m = motionSpec;
    }

    boolean W() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean Y() {
        if (this.f13455e && this.f13472v.getSizeDimension() < this.f13460j) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z7) {
        boolean z8;
        AnimatorSet j8;
        float f8;
        float f9;
        if (x()) {
            return;
        }
        Animator animator = this.f13462l;
        if (animator != null) {
            animator.cancel();
        }
        if (this.f13463m == null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (X()) {
            if (this.f13472v.getVisibility() != 0) {
                float f10 = 0.0f;
                this.f13472v.setAlpha(0.0f);
                FloatingActionButton floatingActionButton = this.f13472v;
                if (z8) {
                    f8 = 0.4f;
                } else {
                    f8 = 0.0f;
                }
                floatingActionButton.setScaleY(f8);
                FloatingActionButton floatingActionButton2 = this.f13472v;
                if (z8) {
                    f9 = 0.4f;
                } else {
                    f9 = 0.0f;
                }
                floatingActionButton2.setScaleX(f9);
                if (z8) {
                    f10 = 0.4f;
                }
                P(f10);
            }
            MotionSpec motionSpec = this.f13463m;
            if (motionSpec != null) {
                j8 = i(motionSpec, 1.0f, 1.0f, 1.0f);
            } else {
                j8 = j(1.0f, 1.0f, 1.0f, D, E);
            }
            j8.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    FloatingActionButtonImpl.this.f13468r = 0;
                    FloatingActionButtonImpl.this.f13462l = null;
                    InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                    if (internalVisibilityChangedListener2 != null) {
                        internalVisibilityChangedListener2.a();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    FloatingActionButtonImpl.this.f13472v.b(0, z7);
                    FloatingActionButtonImpl.this.f13468r = 2;
                    FloatingActionButtonImpl.this.f13462l = animator2;
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.f13469s;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j8.addListener(it.next());
                }
            }
            j8.start();
            return;
        }
        this.f13472v.b(0, z7);
        this.f13472v.setAlpha(1.0f);
        this.f13472v.setScaleY(1.0f);
        this.f13472v.setScaleX(1.0f);
        P(1.0f);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.a();
        }
    }

    void a0() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b0() {
        P(this.f13466p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c0() {
        Rect rect = this.f13474x;
        r(rect);
        E(rect);
        this.f13473w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(float f8) {
        MaterialShapeDrawable materialShapeDrawable = this.f13452b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.b0(f8);
        }
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f13470t == null) {
            this.f13470t = new ArrayList<>();
        }
        this.f13470t.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.f13469s == null) {
            this.f13469s = new ArrayList<>();
        }
        this.f13469s.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(@NonNull InternalTransformationCallback internalTransformationCallback) {
        if (this.f13471u == null) {
            this.f13471u = new ArrayList<>();
        }
        this.f13471u.add(internalTransformationCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable l() {
        return this.f13454d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float m() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f13455e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MotionSpec o() {
        return this.f13464n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.f13458h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@NonNull Rect rect) {
        int i8;
        float f8;
        if (this.f13455e) {
            i8 = (this.f13460j - this.f13472v.getSizeDimension()) / 2;
        } else {
            i8 = 0;
        }
        if (this.f13456f) {
            f8 = m() + this.f13459i;
        } else {
            f8 = 0.0f;
        }
        int max = Math.max(i8, (int) Math.ceil(f8));
        int max2 = Math.max(i8, (int) Math.ceil(f8 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s() {
        return this.f13459i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ShapeAppearanceModel t() {
        return this.f13451a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MotionSpec u() {
        return this.f13463m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z7) {
        int i8;
        AnimatorSet j8;
        if (w()) {
            return;
        }
        Animator animator = this.f13462l;
        if (animator != null) {
            animator.cancel();
        }
        if (X()) {
            MotionSpec motionSpec = this.f13464n;
            if (motionSpec != null) {
                j8 = i(motionSpec, 0.0f, 0.0f, 0.0f);
            } else {
                j8 = j(0.0f, 0.4f, 0.4f, F, G);
            }
            j8.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1

                /* renamed from: a  reason: collision with root package name */
                private boolean f13477a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator2) {
                    this.f13477a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    int i9;
                    FloatingActionButtonImpl.this.f13468r = 0;
                    FloatingActionButtonImpl.this.f13462l = null;
                    if (!this.f13477a) {
                        FloatingActionButton floatingActionButton = FloatingActionButtonImpl.this.f13472v;
                        boolean z8 = z7;
                        if (z8) {
                            i9 = 8;
                        } else {
                            i9 = 4;
                        }
                        floatingActionButton.b(i9, z8);
                        InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                        if (internalVisibilityChangedListener2 != null) {
                            internalVisibilityChangedListener2.b();
                        }
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    FloatingActionButtonImpl.this.f13472v.b(0, z7);
                    FloatingActionButtonImpl.this.f13468r = 1;
                    FloatingActionButtonImpl.this.f13462l = animator2;
                    this.f13477a = false;
                }
            });
            ArrayList<Animator.AnimatorListener> arrayList = this.f13470t;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    j8.addListener(it.next());
                }
            }
            j8.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.f13472v;
        if (z7) {
            i8 = 8;
        } else {
            i8 = 4;
        }
        floatingActionButton.b(i8, z7);
        if (internalVisibilityChangedListener != null) {
            internalVisibilityChangedListener.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        if (this.f13472v.getVisibility() == 0) {
            if (this.f13468r != 1) {
                return false;
            }
            return true;
        } else if (this.f13468r == 2) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        if (this.f13472v.getVisibility() != 0) {
            if (this.f13468r != 2) {
                return false;
            }
            return true;
        } else if (this.f13468r == 1) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        MaterialShapeDrawable materialShapeDrawable = this.f13452b;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.f(this.f13472v, materialShapeDrawable);
        }
        if (I()) {
            this.f13472v.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }
}
