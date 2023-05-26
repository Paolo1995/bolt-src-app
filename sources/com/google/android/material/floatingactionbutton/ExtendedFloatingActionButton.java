package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int P = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> Q = new Property<View, Float>(Float.class, "width") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.6
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f8) {
            view.getLayoutParams().width = f8.intValue();
            view.requestLayout();
        }
    };
    static final Property<View, Float> R = new Property<View, Float>(Float.class, "height") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.7
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f8) {
            view.getLayoutParams().height = f8.intValue();
            view.requestLayout();
        }
    };
    static final Property<View, Float> S = new Property<View, Float>(Float.class, "paddingStart") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.8
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.J(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f8) {
            ViewCompat.H0(view, f8.intValue(), view.getPaddingTop(), ViewCompat.I(view), view.getPaddingBottom());
        }
    };
    static final Property<View, Float> T = new Property<View, Float>(Float.class, "paddingEnd") { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.9
        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.I(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull View view, @NonNull Float f8) {
            ViewCompat.H0(view, ViewCompat.J(view), view.getPaddingTop(), f8.intValue(), view.getPaddingBottom());
        }
    };
    @NonNull
    private final MotionStrategy A;
    @NonNull
    private final MotionStrategy B;
    private final MotionStrategy C;
    private final MotionStrategy D;
    private final int E;
    private int F;
    private int G;
    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> H;
    private boolean I;
    private boolean J;
    private boolean K;
    @NonNull
    protected ColorStateList L;
    private int M;
    private int N;
    private final int O;

    /* renamed from: y  reason: collision with root package name */
    private int f13404y;

    /* renamed from: z  reason: collision with root package name */
    private final AnimatorTracker f13405z;

    /* loaded from: classes.dex */
    class ChangeSizeStrategy extends BaseMotionStrategy {

        /* renamed from: g  reason: collision with root package name */
        private final Size f13417g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f13418h;

        ChangeSizeStrategy(AnimatorTracker animatorTracker, Size size, boolean z7) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.f13417g = size;
            this.f13418h = z7;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void a() {
            ExtendedFloatingActionButton.this.I = this.f13418h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.f13418h) {
                ExtendedFloatingActionButton.this.M = layoutParams.width;
                ExtendedFloatingActionButton.this.N = layoutParams.height;
            }
            layoutParams.width = this.f13417g.a().width;
            layoutParams.height = this.f13417g.a().height;
            ViewCompat.H0(ExtendedFloatingActionButton.this, this.f13417g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f13417g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean c() {
            if (this.f13418h != ExtendedFloatingActionButton.this.I && ExtendedFloatingActionButton.this.getIcon() != null && !TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText())) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int e() {
            if (this.f13418h) {
                return R$animator.mtrl_extended_fab_change_size_expand_motion_spec;
            }
            return R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void f() {
            super.f();
            ExtendedFloatingActionButton.this.J = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f13417g.a().width;
            layoutParams.height = this.f13417g.a().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        @NonNull
        public AnimatorSet h() {
            float f8;
            MotionSpec m8 = m();
            if (m8.j("width")) {
                PropertyValuesHolder[] g8 = m8.g("width");
                g8[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f13417g.getWidth());
                m8.l("width", g8);
            }
            if (m8.j("height")) {
                PropertyValuesHolder[] g9 = m8.g("height");
                g9[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f13417g.getHeight());
                m8.l("height", g9);
            }
            if (m8.j("paddingStart")) {
                PropertyValuesHolder[] g10 = m8.g("paddingStart");
                g10[0].setFloatValues(ViewCompat.J(ExtendedFloatingActionButton.this), this.f13417g.getPaddingStart());
                m8.l("paddingStart", g10);
            }
            if (m8.j("paddingEnd")) {
                PropertyValuesHolder[] g11 = m8.g("paddingEnd");
                g11[0].setFloatValues(ViewCompat.I(ExtendedFloatingActionButton.this), this.f13417g.getPaddingEnd());
                m8.l("paddingEnd", g11);
            }
            if (m8.j("labelOpacity")) {
                PropertyValuesHolder[] g12 = m8.g("labelOpacity");
                boolean z7 = this.f13418h;
                float f9 = 0.0f;
                if (z7) {
                    f8 = 0.0f;
                } else {
                    f8 = 1.0f;
                }
                if (z7) {
                    f9 = 1.0f;
                }
                g12[0].setFloatValues(f8, f9);
                m8.l("labelOpacity", g12);
            }
            return super.l(m8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void j(OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.f13418h) {
                onChangedCallback.a(ExtendedFloatingActionButton.this);
            } else {
                onChangedCallback.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.I = this.f13418h;
            ExtendedFloatingActionButton.this.J = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* loaded from: classes.dex */
    class HideStrategy extends BaseMotionStrategy {

        /* renamed from: g  reason: collision with root package name */
        private boolean f13425g;

        public HideStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void a() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean c() {
            return ExtendedFloatingActionButton.this.z();
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void d() {
            super.d();
            this.f13425g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int e() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void f() {
            super.f();
            ExtendedFloatingActionButton.this.f13404y = 0;
            if (!this.f13425g) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void j(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f13425g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f13404y = 1;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnChangedCallback {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    /* loaded from: classes.dex */
    class ShowStrategy extends BaseMotionStrategy {
        public ShowStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void a() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean c() {
            return ExtendedFloatingActionButton.this.A();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int e() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void f() {
            super.f();
            ExtendedFloatingActionButton.this.f13404y = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void j(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f13404y = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Size {
        ViewGroup.LayoutParams a();

        int getHeight();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        if (getVisibility() != 0) {
            if (this.f13404y != 2) {
                return false;
            }
            return true;
        } else if (this.f13404y == 1) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i8, final OnChangedCallback onChangedCallback) {
        final MotionStrategy motionStrategy;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        motionStrategy = this.B;
                    } else {
                        throw new IllegalStateException("Unknown strategy type: " + i8);
                    }
                } else {
                    motionStrategy = this.A;
                }
            } else {
                motionStrategy = this.D;
            }
        } else {
            motionStrategy = this.C;
        }
        if (motionStrategy.c()) {
            return;
        }
        if (!D()) {
            motionStrategy.a();
            motionStrategy.j(onChangedCallback);
            return;
        }
        if (i8 == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.M = layoutParams.width;
                this.N = layoutParams.height;
            } else {
                this.M = getWidth();
                this.N = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet h8 = motionStrategy.h();
        h8.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5

            /* renamed from: a  reason: collision with root package name */
            private boolean f13413a;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f13413a = true;
                motionStrategy.d();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                motionStrategy.f();
                if (!this.f13413a) {
                    motionStrategy.j(onChangedCallback);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                motionStrategy.onAnimationStart(animator);
                this.f13413a = false;
            }
        });
        for (Animator.AnimatorListener animatorListener : motionStrategy.i()) {
            h8.addListener(animatorListener);
        }
        h8.start();
    }

    private void C() {
        this.L = getTextColors();
    }

    private boolean D() {
        if ((ViewCompat.W(this) || (!A() && this.K)) && !isInEditMode()) {
            return true;
        }
        return false;
    }

    private Size x(int i8) {
        final Size size = new Size() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.2
            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public ViewGroup.LayoutParams a() {
                return new ViewGroup.LayoutParams(-2, -2);
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getHeight() {
                return ExtendedFloatingActionButton.this.getMeasuredHeight();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.G;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.F;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getWidth() {
                return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.F + ExtendedFloatingActionButton.this.G;
            }
        };
        final Size size2 = new Size() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.3
            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public ViewGroup.LayoutParams a() {
                int i9;
                if (ExtendedFloatingActionButton.this.N != 0) {
                    i9 = ExtendedFloatingActionButton.this.N;
                } else {
                    i9 = -2;
                }
                return new ViewGroup.LayoutParams(-1, i9);
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getHeight() {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                if (ExtendedFloatingActionButton.this.N == -1) {
                    if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                        return size.getHeight();
                    }
                    View view = (View) ExtendedFloatingActionButton.this.getParent();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == -2) {
                        return size.getHeight();
                    }
                    int i9 = 0;
                    int paddingTop = view.getPaddingTop() + view.getPaddingBottom() + 0;
                    if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                        i9 = 0 + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                    return (view.getHeight() - i9) - paddingTop;
                } else if (ExtendedFloatingActionButton.this.N != 0 && ExtendedFloatingActionButton.this.N != -2) {
                    return ExtendedFloatingActionButton.this.N;
                } else {
                    return size.getHeight();
                }
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.G;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.F;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getWidth() {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                    return size.getWidth();
                }
                View view = (View) ExtendedFloatingActionButton.this.getParent();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null && layoutParams.width == -2) {
                    return size.getWidth();
                }
                int i9 = 0;
                int paddingLeft = view.getPaddingLeft() + view.getPaddingRight() + 0;
                if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                    i9 = 0 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                }
                return (view.getWidth() - i9) - paddingLeft;
            }
        };
        Size size3 = new Size() { // from class: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.4
            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public ViewGroup.LayoutParams a() {
                int i9;
                int i10 = -2;
                if (ExtendedFloatingActionButton.this.M != 0) {
                    i9 = ExtendedFloatingActionButton.this.M;
                } else {
                    i9 = -2;
                }
                if (ExtendedFloatingActionButton.this.N != 0) {
                    i10 = ExtendedFloatingActionButton.this.N;
                }
                return new ViewGroup.LayoutParams(i9, i10);
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getHeight() {
                if (ExtendedFloatingActionButton.this.N == -1) {
                    return size2.getHeight();
                }
                if (ExtendedFloatingActionButton.this.N != 0 && ExtendedFloatingActionButton.this.N != -2) {
                    return ExtendedFloatingActionButton.this.N;
                }
                return size.getHeight();
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getPaddingEnd() {
                return ExtendedFloatingActionButton.this.G;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getPaddingStart() {
                return ExtendedFloatingActionButton.this.F;
            }

            @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
            public int getWidth() {
                if (ExtendedFloatingActionButton.this.M == -1) {
                    return size2.getWidth();
                }
                if (ExtendedFloatingActionButton.this.M != 0 && ExtendedFloatingActionButton.this.M != -2) {
                    return ExtendedFloatingActionButton.this.M;
                }
                return size.getWidth();
            }
        };
        if (i8 != 1) {
            if (i8 != 2) {
                return size3;
            }
            return size2;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        if (getVisibility() == 0) {
            if (this.f13404y != 1) {
                return false;
            }
            return true;
        } else if (this.f13404y == 2) {
            return false;
        } else {
            return true;
        }
    }

    public void E() {
        B(0, null);
    }

    public void F() {
        B(2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.H;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i8 = this.E;
        if (i8 < 0) {
            return (Math.min(ViewCompat.J(this), ViewCompat.I(this)) * 2) + getIconSize();
        }
        return i8;
    }

    public MotionSpec getExtendMotionSpec() {
        return this.B.b();
    }

    public MotionSpec getHideMotionSpec() {
        return this.D.b();
    }

    public MotionSpec getShowMotionSpec() {
        return this.C.b();
    }

    public MotionSpec getShrinkMotionSpec() {
        return this.A.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.I && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.I = false;
            this.A.a();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z7) {
        this.K = z7;
    }

    public void setExtendMotionSpec(MotionSpec motionSpec) {
        this.B.g(motionSpec);
    }

    public void setExtendMotionSpecResource(int i8) {
        setExtendMotionSpec(MotionSpec.d(getContext(), i8));
    }

    public void setExtended(boolean z7) {
        MotionStrategy motionStrategy;
        if (this.I == z7) {
            return;
        }
        if (z7) {
            motionStrategy = this.B;
        } else {
            motionStrategy = this.A;
        }
        if (motionStrategy.c()) {
            return;
        }
        motionStrategy.a();
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.D.g(motionSpec);
    }

    public void setHideMotionSpecResource(int i8) {
        setHideMotionSpec(MotionSpec.d(getContext(), i8));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i8, int i9, int i10, int i11) {
        super.setPadding(i8, i9, i10, i11);
        if (this.I && !this.J) {
            this.F = ViewCompat.J(this);
            this.G = ViewCompat.I(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i8, int i9, int i10, int i11) {
        super.setPaddingRelative(i8, i9, i10, i11);
        if (this.I && !this.J) {
            this.F = i8;
            this.G = i10;
        }
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.C.g(motionSpec);
    }

    public void setShowMotionSpecResource(int i8) {
        setShowMotionSpec(MotionSpec.d(getContext(), i8));
    }

    public void setShrinkMotionSpec(MotionSpec motionSpec) {
        this.A.g(motionSpec);
    }

    public void setShrinkMotionSpecResource(int i8) {
        setShrinkMotionSpec(MotionSpec.d(getContext(), i8));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i8) {
        super.setTextColor(i8);
        C();
    }

    public void w() {
        B(3, null);
    }

    public void y() {
        B(1, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.P
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.f13404y = r10
            com.google.android.material.floatingactionbutton.AnimatorTracker r1 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r1.<init>()
            r0.f13405z = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy
            r11.<init>(r1)
            r0.C = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy
            r12.<init>(r1)
            r0.D = r12
            r13 = 1
            r0.I = r13
            r0.J = r10
            r0.K = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.H = r1
            int[] r3 = com.google.android.material.R$styleable.C2
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.i(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R$styleable.H2
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.c(r14, r1, r2)
            int r3 = com.google.android.material.R$styleable.G2
            com.google.android.material.animation.MotionSpec r3 = com.google.android.material.animation.MotionSpec.c(r14, r1, r3)
            int r4 = com.google.android.material.R$styleable.E2
            com.google.android.material.animation.MotionSpec r4 = com.google.android.material.animation.MotionSpec.c(r14, r1, r4)
            int r5 = com.google.android.material.R$styleable.I2
            com.google.android.material.animation.MotionSpec r5 = com.google.android.material.animation.MotionSpec.c(r14, r1, r5)
            int r6 = com.google.android.material.R$styleable.D2
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.E = r6
            int r6 = com.google.android.material.R$styleable.F2
            int r6 = r1.getInt(r6, r13)
            r0.O = r6
            int r15 = androidx.core.view.ViewCompat.J(r16)
            r0.F = r15
            int r15 = androidx.core.view.ViewCompat.I(r16)
            r0.G = r15
            com.google.android.material.floatingactionbutton.AnimatorTracker r15 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r15.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$Size r6 = r0.x(r6)
            r10.<init>(r15, r6, r13)
            r0.B = r10
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r6 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1 r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1
            r13.<init>()
            r7 = 0
            r6.<init>(r15, r13, r7)
            r0.A = r6
            r11.g(r2)
            r12.g(r3)
            r10.g(r4)
            r6.g(r5)
            r1.recycle()
            com.google.android.material.shape.CornerSize r1 = com.google.android.material.shape.ShapeAppearanceModel.f14027m
            r2 = r18
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.g(r14, r2, r8, r9, r1)
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.m()
            r0.setShapeAppearanceModel(r1)
            r16.C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* loaded from: classes.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f13420a;

        /* renamed from: b  reason: collision with root package name */
        private OnChangedCallback f13421b;

        /* renamed from: c  reason: collision with root package name */
        private OnChangedCallback f13422c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f13423d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f13424e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f13423d = false;
            this.f13424e = true;
        }

        private static boolean G(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f13423d && !this.f13424e) || layoutParams.e() != view.getId()) {
                return false;
            }
            return true;
        }

        private boolean L(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f13420a == null) {
                this.f13420a = new Rect();
            }
            Rect rect = this.f13420a;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        protected void E(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            OnChangedCallback onChangedCallback;
            int i8;
            boolean z7 = this.f13424e;
            if (z7) {
                onChangedCallback = this.f13422c;
            } else {
                onChangedCallback = this.f13421b;
            }
            if (z7) {
                i8 = 3;
            } else {
                i8 = 0;
            }
            extendedFloatingActionButton.B(i8, onChangedCallback);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: F */
        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (G(view)) {
                M(view, extendedFloatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: I */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i8) {
            List<View> s7 = coordinatorLayout.s(extendedFloatingActionButton);
            int size = s7.size();
            for (int i9 = 0; i9 < size; i9++) {
                View view = s7.get(i9);
                if (view instanceof AppBarLayout) {
                    if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.J(extendedFloatingActionButton, i8);
            return true;
        }

        protected void K(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            OnChangedCallback onChangedCallback;
            int i8;
            boolean z7 = this.f13424e;
            if (z7) {
                onChangedCallback = this.f13422c;
            } else {
                onChangedCallback = this.f13421b;
            }
            if (z7) {
                i8 = 2;
            } else {
                i8 = 1;
            }
            extendedFloatingActionButton.B(i8, onChangedCallback);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void g(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f5461h == 0) {
                layoutParams.f5461h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.J2);
            this.f13423d = obtainStyledAttributes.getBoolean(R$styleable.K2, false);
            this.f13424e = obtainStyledAttributes.getBoolean(R$styleable.L2, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        C();
    }
}
