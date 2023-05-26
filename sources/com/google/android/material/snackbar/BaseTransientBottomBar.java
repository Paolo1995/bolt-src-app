package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a  reason: collision with root package name */
    private final int f14135a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14136b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14137c;

    /* renamed from: d  reason: collision with root package name */
    private final TimeInterpolator f14138d;

    /* renamed from: e  reason: collision with root package name */
    private final TimeInterpolator f14139e;

    /* renamed from: f  reason: collision with root package name */
    private final TimeInterpolator f14140f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f14141g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f14142h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    protected final SnackbarBaseLayout f14143i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ContentViewCallback f14144j;

    /* renamed from: k  reason: collision with root package name */
    private int f14145k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14146l;

    /* renamed from: m  reason: collision with root package name */
    private Anchor f14147m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14148n;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f14149o;

    /* renamed from: p  reason: collision with root package name */
    private int f14150p;

    /* renamed from: q  reason: collision with root package name */
    private int f14151q;

    /* renamed from: r  reason: collision with root package name */
    private int f14152r;

    /* renamed from: s  reason: collision with root package name */
    private int f14153s;

    /* renamed from: t  reason: collision with root package name */
    private int f14154t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f14155u;

    /* renamed from: v  reason: collision with root package name */
    private List<BaseCallback<B>> f14156v;

    /* renamed from: w  reason: collision with root package name */
    private Behavior f14157w;

    /* renamed from: x  reason: collision with root package name */
    private final AccessibilityManager f14158x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    SnackbarManager.Callback f14159y;

    /* renamed from: z  reason: collision with root package name */
    private static final TimeInterpolator f14134z = AnimationUtils.f12721b;
    private static final TimeInterpolator A = AnimationUtils.f12720a;
    private static final TimeInterpolator B = AnimationUtils.f12723d;
    private static final boolean D = false;
    private static final int[] E = {R$attr.snackbarStyle};
    private static final String F = BaseTransientBottomBar.class.getSimpleName();
    @NonNull
    static final Handler C = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i8 = message.what;
            if (i8 != 0) {
                if (i8 != 1) {
                    return false;
                }
                ((BaseTransientBottomBar) message.obj).N(message.arg1);
                return true;
            }
            ((BaseTransientBottomBar) message.obj).f0();
            return true;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Anchor implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private final WeakReference<BaseTransientBottomBar> f14180f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        private final WeakReference<View> f14181g;

        private Anchor(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            this.f14180f = new WeakReference<>(baseTransientBottomBar);
            this.f14181g = new WeakReference<>(view);
        }

        static Anchor a(@NonNull BaseTransientBottomBar baseTransientBottomBar, @NonNull View view) {
            Anchor anchor = new Anchor(baseTransientBottomBar, view);
            if (ViewCompat.V(view)) {
                ViewUtils.a(view, anchor);
            }
            view.addOnAttachStateChangeListener(anchor);
            return anchor;
        }

        private boolean d() {
            if (this.f14180f.get() == null) {
                c();
                return true;
            }
            return false;
        }

        View b() {
            return this.f14181g.get();
        }

        void c() {
            if (this.f14181g.get() != null) {
                this.f14181g.get().removeOnAttachStateChangeListener(this);
                ViewUtils.h(this.f14181g.get(), this);
            }
            this.f14181g.clear();
            this.f14180f.clear();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d() && this.f14180f.get().f14148n) {
                this.f14180f.get().W();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (d()) {
                return;
            }
            ViewUtils.a(view, this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d()) {
                return;
            }
            ViewUtils.h(view, this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class BaseCallback<B> {
        public void a(B b8, int i8) {
        }

        public void b(B b8) {
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        private final BehaviorDelegate f14182l = new BehaviorDelegate(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void Q(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f14182l.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean F(View view) {
            return this.f14182l.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f14182l.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    /* loaded from: classes.dex */
    public static class BehaviorDelegate {

        /* renamed from: a  reason: collision with root package name */
        private SnackbarManager.Callback f14183a;

        public BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.M(0.1f);
            swipeDismissBehavior.K(0.6f);
            swipeDismissBehavior.N(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    SnackbarManager.c().l(this.f14183a);
                }
            } else if (coordinatorLayout.C(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                SnackbarManager.c().k(this.f14183a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f14183a = baseTransientBottomBar.f14159y;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: q  reason: collision with root package name */
        private static final View.OnTouchListener f14184q = new View.OnTouchListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };

        /* renamed from: f  reason: collision with root package name */
        private BaseTransientBottomBar<?> f14185f;

        /* renamed from: g  reason: collision with root package name */
        ShapeAppearanceModel f14186g;

        /* renamed from: h  reason: collision with root package name */
        private int f14187h;

        /* renamed from: i  reason: collision with root package name */
        private final float f14188i;

        /* renamed from: j  reason: collision with root package name */
        private final float f14189j;

        /* renamed from: k  reason: collision with root package name */
        private final int f14190k;

        /* renamed from: l  reason: collision with root package name */
        private final int f14191l;

        /* renamed from: m  reason: collision with root package name */
        private ColorStateList f14192m;

        /* renamed from: n  reason: collision with root package name */
        private PorterDuff.Mode f14193n;

        /* renamed from: o  reason: collision with root package name */
        private Rect f14194o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f14195p;

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(MaterialThemeOverlay.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.f12663s6);
            int i8 = R$styleable.f12719z6;
            if (obtainStyledAttributes.hasValue(i8)) {
                ViewCompat.A0(this, obtainStyledAttributes.getDimensionPixelSize(i8, 0));
            }
            this.f14187h = obtainStyledAttributes.getInt(R$styleable.f12687v6, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.B6) || obtainStyledAttributes.hasValue(R$styleable.C6)) {
                this.f14186g = ShapeAppearanceModel.e(context2, attributeSet, 0, 0).m();
            }
            this.f14188i = obtainStyledAttributes.getFloat(R$styleable.f12695w6, 1.0f);
            setBackgroundTintList(MaterialResources.a(context2, obtainStyledAttributes, R$styleable.f12703x6));
            setBackgroundTintMode(ViewUtils.g(obtainStyledAttributes.getInt(R$styleable.f12711y6, -1), PorterDuff.Mode.SRC_IN));
            this.f14189j = obtainStyledAttributes.getFloat(R$styleable.f12679u6, 1.0f);
            this.f14190k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f12671t6, -1);
            this.f14191l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.A6, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f14184q);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.w0(this, d());
            }
        }

        @NonNull
        private Drawable d() {
            int k8 = MaterialColors.k(this, R$attr.colorSurface, R$attr.colorOnSurface, getBackgroundOverlayColorAlpha());
            ShapeAppearanceModel shapeAppearanceModel = this.f14186g;
            Drawable z7 = shapeAppearanceModel != null ? BaseTransientBottomBar.z(k8, shapeAppearanceModel) : BaseTransientBottomBar.y(k8, getResources());
            if (this.f14192m != null) {
                Drawable r7 = DrawableCompat.r(z7);
                DrawableCompat.o(r7, this.f14192m);
                return r7;
            }
            return DrawableCompat.r(z7);
        }

        private void e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f14194o = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f14185f = baseTransientBottomBar;
        }

        void c(ViewGroup viewGroup) {
            this.f14195p = true;
            viewGroup.addView(this);
            this.f14195p = false;
        }

        float getActionTextColorAlpha() {
            return this.f14189j;
        }

        int getAnimationMode() {
            return this.f14187h;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f14188i;
        }

        int getMaxInlineActionWidth() {
            return this.f14191l;
        }

        int getMaxWidth() {
            return this.f14190k;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f14185f;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.R();
            }
            ViewCompat.p0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f14185f;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.S();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
            super.onLayout(z7, i8, i9, i10, i11);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f14185f;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.T();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i8, int i9) {
            super.onMeasure(i8, i9);
            if (this.f14190k > 0) {
                int measuredWidth = getMeasuredWidth();
                int i10 = this.f14190k;
                if (measuredWidth > i10) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10, Pow2.MAX_POW2), i9);
                }
            }
        }

        void setAnimationMode(int i8) {
            this.f14187h = i8;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f14192m != null) {
                drawable = DrawableCompat.r(drawable.mutate());
                DrawableCompat.o(drawable, this.f14192m);
                DrawableCompat.p(drawable, this.f14193n);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f14192m = colorStateList;
            if (getBackground() != null) {
                Drawable r7 = DrawableCompat.r(getBackground().mutate());
                DrawableCompat.o(r7, colorStateList);
                DrawableCompat.p(r7, this.f14193n);
                if (r7 != getBackground()) {
                    super.setBackgroundDrawable(r7);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f14193n = mode;
            if (getBackground() != null) {
                Drawable r7 = DrawableCompat.r(getBackground().mutate());
                DrawableCompat.p(r7, mode);
                if (r7 != getBackground()) {
                    super.setBackgroundDrawable(r7);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.f14195p && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                e((ViewGroup.MarginLayoutParams) layoutParams);
                BaseTransientBottomBar<?> baseTransientBottomBar = this.f14185f;
                if (baseTransientBottomBar != null) {
                    baseTransientBottomBar.l0();
                }
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = f14184q;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        this(viewGroup.getContext(), viewGroup, view, contentViewCallback);
    }

    private ValueAnimator C(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f14138d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.f14143i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator G(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f14140f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.12
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.f14143i.setScaleX(floatValue);
                BaseTransientBottomBar.this.f14143i.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f14142h.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int J() {
        int height = this.f14143i.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f14143i.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L() {
        int[] iArr = new int[2];
        this.f14143i.getLocationOnScreen(iArr);
        return iArr[1] + this.f14143i.getHeight();
    }

    private boolean Q() {
        ViewGroup.LayoutParams layoutParams = this.f14143i.getLayoutParams();
        if ((layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof SwipeDismissBehavior)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        int x7 = x();
        if (x7 == this.f14154t) {
            return;
        }
        this.f14154t = x7;
        l0();
    }

    private void b0(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f14157w;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = F();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).Q(this);
        }
        swipeDismissBehavior.L(new SwipeDismissBehavior.OnDismissListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.7
            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void a(@NonNull View view) {
                if (view.getParent() != null) {
                    view.setVisibility(8);
                }
                BaseTransientBottomBar.this.B(0);
            }

            @Override // com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener
            public void b(int i8) {
                if (i8 != 0) {
                    if (i8 == 1 || i8 == 2) {
                        SnackbarManager.c().k(BaseTransientBottomBar.this.f14159y);
                        return;
                    }
                    return;
                }
                SnackbarManager.c().l(BaseTransientBottomBar.this.f14159y);
            }
        });
        layoutParams.o(swipeDismissBehavior);
        if (D() == null) {
            layoutParams.f5460g = 80;
        }
    }

    private boolean d0() {
        if (this.f14153s > 0 && !this.f14146l && Q()) {
            return true;
        }
        return false;
    }

    private void g0() {
        if (c0()) {
            v();
            return;
        }
        if (this.f14143i.getParent() != null) {
            this.f14143i.setVisibility(0);
        }
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        ValueAnimator C2 = C(0.0f, 1.0f);
        ValueAnimator G = G(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(C2, G);
        animatorSet.setDuration(this.f14135a);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.V();
            }
        });
        animatorSet.start();
    }

    private void i0(final int i8) {
        ValueAnimator C2 = C(1.0f, 0.0f);
        C2.setDuration(this.f14136b);
        C2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.U(i8);
            }
        });
        C2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        int J = J();
        if (D) {
            ViewCompat.d0(this.f14143i, J);
        } else {
            this.f14143i.setTranslationY(J);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(J, 0);
        valueAnimator.setInterpolator(this.f14139e);
        valueAnimator.setDuration(this.f14137c);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.V();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f14144j.a(BaseTransientBottomBar.this.f14137c - BaseTransientBottomBar.this.f14135a, BaseTransientBottomBar.this.f14135a);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(J) { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.14

            /* renamed from: a  reason: collision with root package name */
            private int f14165a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f14166b;

            {
                this.f14166b = J;
                this.f14165a = J;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.D) {
                    ViewCompat.d0(BaseTransientBottomBar.this.f14143i, intValue - this.f14165a);
                } else {
                    BaseTransientBottomBar.this.f14143i.setTranslationY(intValue);
                }
                this.f14165a = intValue;
            }
        });
        valueAnimator.start();
    }

    private void k0(final int i8) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, J());
        valueAnimator.setInterpolator(this.f14139e);
        valueAnimator.setDuration(this.f14137c);
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.15
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.U(i8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f14144j.b(0, BaseTransientBottomBar.this.f14136b);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.16

            /* renamed from: a  reason: collision with root package name */
            private int f14170a = 0;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                int intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.D) {
                    ViewCompat.d0(BaseTransientBottomBar.this.f14143i, intValue - this.f14170a);
                } else {
                    BaseTransientBottomBar.this.f14143i.setTranslationY(intValue);
                }
                this.f14170a = intValue;
            }
        });
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        int i8;
        ViewGroup.LayoutParams layoutParams = this.f14143i.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.f14143i.f14194o != null) {
            if (this.f14143i.getParent() == null) {
                return;
            }
            if (D() != null) {
                i8 = this.f14154t;
            } else {
                i8 = this.f14150p;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = this.f14143i.f14194o.bottom + i8;
            marginLayoutParams.leftMargin = this.f14143i.f14194o.left + this.f14151q;
            marginLayoutParams.rightMargin = this.f14143i.f14194o.right + this.f14152r;
            marginLayoutParams.topMargin = this.f14143i.f14194o.top;
            this.f14143i.requestLayout();
            if (Build.VERSION.SDK_INT >= 29 && d0()) {
                this.f14143i.removeCallbacks(this.f14149o);
                this.f14143i.post(this.f14149o);
                return;
            }
            return;
        }
        Log.w(F, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    private void w(int i8) {
        if (this.f14143i.getAnimationMode() == 1) {
            i0(i8);
        } else {
            k0(i8);
        }
    }

    private int x() {
        if (D() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        D().getLocationOnScreen(iArr);
        int i8 = iArr[1];
        int[] iArr2 = new int[2];
        this.f14141g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f14141g.getHeight()) - i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static GradientDrawable y(int i8, @NonNull Resources resources) {
        float dimension = resources.getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i8);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static MaterialShapeDrawable z(int i8, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        materialShapeDrawable.c0(ColorStateList.valueOf(i8));
        return materialShapeDrawable;
    }

    public void A() {
        B(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i8) {
        SnackbarManager.c().b(this.f14159y, i8);
    }

    public View D() {
        Anchor anchor = this.f14147m;
        if (anchor == null) {
            return null;
        }
        return anchor.b();
    }

    public int E() {
        return this.f14145k;
    }

    @NonNull
    protected SwipeDismissBehavior<? extends View> F() {
        return new Behavior();
    }

    protected int I() {
        if (M()) {
            return R$layout.mtrl_layout_snackbar;
        }
        return R$layout.design_layout_snackbar;
    }

    @NonNull
    public View K() {
        return this.f14143i;
    }

    protected boolean M() {
        TypedArray obtainStyledAttributes = this.f14142h.obtainStyledAttributes(E);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            return false;
        }
        return true;
    }

    final void N(int i8) {
        if (c0() && this.f14143i.getVisibility() == 0) {
            w(i8);
        } else {
            U(i8);
        }
    }

    public boolean O() {
        return SnackbarManager.c().e(this.f14159y);
    }

    public boolean P() {
        return SnackbarManager.c().f(this.f14159y);
    }

    void R() {
        WindowInsets rootWindowInsets;
        Insets mandatorySystemGestureInsets;
        if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = this.f14143i.getRootWindowInsets()) != null) {
            mandatorySystemGestureInsets = rootWindowInsets.getMandatorySystemGestureInsets();
            this.f14153s = mandatorySystemGestureInsets.bottom;
            l0();
        }
    }

    void S() {
        if (P()) {
            C.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
                @Override // java.lang.Runnable
                public void run() {
                    BaseTransientBottomBar.this.U(3);
                }
            });
        }
    }

    void T() {
        if (this.f14155u) {
            g0();
            this.f14155u = false;
        }
    }

    void U(int i8) {
        SnackbarManager.c().i(this.f14159y);
        List<BaseCallback<B>> list = this.f14156v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f14156v.get(size).a(this, i8);
            }
        }
        ViewParent parent = this.f14143i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f14143i);
        }
    }

    void V() {
        SnackbarManager.c().j(this.f14159y);
        List<BaseCallback<B>> list = this.f14156v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f14156v.get(size).b(this);
            }
        }
    }

    @NonNull
    public B X(View view) {
        Anchor a8;
        Anchor anchor = this.f14147m;
        if (anchor != null) {
            anchor.c();
        }
        if (view == null) {
            a8 = null;
        } else {
            a8 = Anchor.a(this, view);
        }
        this.f14147m = a8;
        return this;
    }

    @NonNull
    public B Y(int i8) {
        this.f14143i.setAnimationMode(i8);
        return this;
    }

    @NonNull
    public B Z(Behavior behavior) {
        this.f14157w = behavior;
        return this;
    }

    @NonNull
    public B a0(int i8) {
        this.f14145k = i8;
        return this;
    }

    boolean c0() {
        AccessibilityManager accessibilityManager = this.f14158x;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void e0() {
        SnackbarManager.c().n(E(), this.f14159y);
    }

    final void f0() {
        if (this.f14143i.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f14143i.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                b0((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.f14143i.c(this.f14141g);
            W();
            this.f14143i.setVisibility(4);
        }
        if (ViewCompat.W(this.f14143i)) {
            g0();
        } else {
            this.f14155u = true;
        }
    }

    @NonNull
    public B u(BaseCallback<B> baseCallback) {
        if (baseCallback == null) {
            return this;
        }
        if (this.f14156v == null) {
            this.f14156v = new ArrayList();
        }
        this.f14156v.add(baseCallback);
        return this;
    }

    void v() {
        this.f14143i.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // java.lang.Runnable
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f14143i;
                if (snackbarBaseLayout == null) {
                    return;
                }
                if (snackbarBaseLayout.getParent() != null) {
                    BaseTransientBottomBar.this.f14143i.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f14143i.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.h0();
                } else {
                    BaseTransientBottomBar.this.j0();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseTransientBottomBar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull ContentViewCallback contentViewCallback) {
        this.f14148n = false;
        this.f14149o = new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.2
            @Override // java.lang.Runnable
            public void run() {
                int H;
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                if (baseTransientBottomBar.f14143i == null || baseTransientBottomBar.f14142h == null || (H = (BaseTransientBottomBar.this.H() - BaseTransientBottomBar.this.L()) + ((int) BaseTransientBottomBar.this.f14143i.getTranslationY())) >= BaseTransientBottomBar.this.f14153s) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f14143i.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    Log.w(BaseTransientBottomBar.F, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f14153s - H;
                BaseTransientBottomBar.this.f14143i.requestLayout();
            }
        };
        this.f14159y = new SnackbarManager.Callback() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.5
            @Override // com.google.android.material.snackbar.SnackbarManager.Callback
            public void a(int i8) {
                Handler handler = BaseTransientBottomBar.C;
                handler.sendMessage(handler.obtainMessage(1, i8, 0, BaseTransientBottomBar.this));
            }

            @Override // com.google.android.material.snackbar.SnackbarManager.Callback
            public void b() {
                Handler handler = BaseTransientBottomBar.C;
                handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
            }
        };
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (contentViewCallback != null) {
            this.f14141g = viewGroup;
            this.f14144j = contentViewCallback;
            this.f14142h = context;
            ThemeEnforcement.a(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(I(), viewGroup, false);
            this.f14143i = snackbarBaseLayout;
            snackbarBaseLayout.setBaseTransientBottomBar(this);
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                snackbarContentLayout.c(snackbarBaseLayout.getActionTextColorAlpha());
                snackbarContentLayout.setMaxInlineActionWidth(snackbarBaseLayout.getMaxInlineActionWidth());
            }
            snackbarBaseLayout.addView(view);
            ViewCompat.u0(snackbarBaseLayout, 1);
            ViewCompat.D0(snackbarBaseLayout, 1);
            ViewCompat.B0(snackbarBaseLayout, true);
            ViewCompat.G0(snackbarBaseLayout, new OnApplyWindowInsetsListener() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.3
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                @NonNull
                public WindowInsetsCompat a(View view2, @NonNull WindowInsetsCompat windowInsetsCompat) {
                    BaseTransientBottomBar.this.f14150p = windowInsetsCompat.i();
                    BaseTransientBottomBar.this.f14151q = windowInsetsCompat.j();
                    BaseTransientBottomBar.this.f14152r = windowInsetsCompat.k();
                    BaseTransientBottomBar.this.l0();
                    return windowInsetsCompat;
                }
            });
            ViewCompat.s0(snackbarBaseLayout, new AccessibilityDelegateCompat() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.4
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void g(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.g(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.a(1048576);
                    accessibilityNodeInfoCompat.d0(true);
                }

                @Override // androidx.core.view.AccessibilityDelegateCompat
                public boolean j(View view2, int i8, Bundle bundle) {
                    if (i8 == 1048576) {
                        BaseTransientBottomBar.this.A();
                        return true;
                    }
                    return super.j(view2, i8, bundle);
                }
            });
            this.f14158x = (AccessibilityManager) context.getSystemService("accessibility");
            int i8 = R$attr.motionDurationLong2;
            this.f14137c = MotionUtils.f(context, i8, 250);
            this.f14135a = MotionUtils.f(context, i8, 150);
            this.f14136b = MotionUtils.f(context, R$attr.motionDurationMedium1, 75);
            int i9 = R$attr.motionEasingEmphasizedInterpolator;
            this.f14138d = MotionUtils.g(context, i9, A);
            this.f14140f = MotionUtils.g(context, i9, B);
            this.f14139e = MotionUtils.g(context, i9, f14134z);
            return;
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
    }
}
