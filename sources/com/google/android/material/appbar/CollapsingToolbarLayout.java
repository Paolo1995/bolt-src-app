package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int K = R$style.Widget_Design_CollapsingToolbar;
    private final TimeInterpolator A;
    private int B;
    private AppBarLayout.OnOffsetChangedListener C;
    int D;
    private int E;
    WindowInsetsCompat F;
    private int G;
    private boolean H;
    private int I;
    private boolean J;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12794f;

    /* renamed from: g  reason: collision with root package name */
    private int f12795g;

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f12796h;

    /* renamed from: i  reason: collision with root package name */
    private View f12797i;

    /* renamed from: j  reason: collision with root package name */
    private View f12798j;

    /* renamed from: k  reason: collision with root package name */
    private int f12799k;

    /* renamed from: l  reason: collision with root package name */
    private int f12800l;

    /* renamed from: m  reason: collision with root package name */
    private int f12801m;

    /* renamed from: n  reason: collision with root package name */
    private int f12802n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f12803o;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    final CollapsingTextHelper f12804p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    final ElevationOverlayProvider f12805q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12806r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12807s;

    /* renamed from: t  reason: collision with root package name */
    private Drawable f12808t;

    /* renamed from: u  reason: collision with root package name */
    Drawable f12809u;

    /* renamed from: v  reason: collision with root package name */
    private int f12810v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f12811w;

    /* renamed from: x  reason: collision with root package name */
    private ValueAnimator f12812x;

    /* renamed from: y  reason: collision with root package name */
    private long f12813y;

    /* renamed from: z  reason: collision with root package name */
    private final TimeInterpolator f12814z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void a(AppBarLayout appBarLayout, int i8) {
            int i9;
            int height;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.D = i8;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.F;
            if (windowInsetsCompat != null) {
                i9 = windowInsetsCompat.l();
            } else {
                i9 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i10);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper k8 = CollapsingToolbarLayout.k(childAt);
                int i11 = layoutParams.f12817a;
                if (i11 != 1) {
                    if (i11 == 2) {
                        k8.f(Math.round((-i8) * layoutParams.f12818b));
                    }
                } else {
                    k8.f(MathUtils.b(-i8, 0, CollapsingToolbarLayout.this.i(childAt)));
                }
            }
            CollapsingToolbarLayout.this.v();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f12809u != null && i9 > 0) {
                ViewCompat.j0(collapsingToolbarLayout2);
            }
            int height2 = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.F(CollapsingToolbarLayout.this)) - i9;
            float f8 = height2;
            CollapsingToolbarLayout.this.f12804p.A0(Math.min(1.0f, (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f8));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f12804p.n0(collapsingToolbarLayout3.D + height2);
            CollapsingToolbarLayout.this.f12804p.y0(Math.abs(i8) / f8);
        }
    }

    /* loaded from: classes.dex */
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    public CollapsingToolbarLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    private void a(int i8) {
        TimeInterpolator timeInterpolator;
        d();
        ValueAnimator valueAnimator = this.f12812x;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f12812x = valueAnimator2;
            if (i8 > this.f12810v) {
                timeInterpolator = this.f12814z;
            } else {
                timeInterpolator = this.A;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.f12812x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator3) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator3.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.f12812x.cancel();
        }
        this.f12812x.setDuration(this.f12813y);
        this.f12812x.setIntValues(this.f12810v, i8);
        this.f12812x.start();
    }

    private TextUtils.TruncateAt b(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 3) {
                    return TextUtils.TruncateAt.END;
                }
                return TextUtils.TruncateAt.MARQUEE;
            }
            return TextUtils.TruncateAt.MIDDLE;
        }
        return TextUtils.TruncateAt.START;
    }

    private void c(AppBarLayout appBarLayout) {
        if (l()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void d() {
        if (!this.f12794f) {
            return;
        }
        ViewGroup viewGroup = null;
        this.f12796h = null;
        this.f12797i = null;
        int i8 = this.f12795g;
        if (i8 != -1) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(i8);
            this.f12796h = viewGroup2;
            if (viewGroup2 != null) {
                this.f12797i = e(viewGroup2);
            }
        }
        if (this.f12796h == null) {
            int childCount = getChildCount();
            int i9 = 0;
            while (true) {
                if (i9 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i9);
                if (m(childAt)) {
                    viewGroup = (ViewGroup) childAt;
                    break;
                }
                i9++;
            }
            this.f12796h = viewGroup;
        }
        u();
        this.f12794f = false;
    }

    @NonNull
    private View e(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return view;
    }

    private static int h(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getMeasuredHeight();
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    static ViewOffsetHelper k(@NonNull View view) {
        int i8 = R$id.view_offset_helper;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i8);
        if (viewOffsetHelper == null) {
            ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
            view.setTag(i8, viewOffsetHelper2);
            return viewOffsetHelper2;
        }
        return viewOffsetHelper;
    }

    private boolean l() {
        if (this.E == 1) {
            return true;
        }
        return false;
    }

    private static boolean m(View view) {
        if (!(view instanceof Toolbar) && !(view instanceof android.widget.Toolbar)) {
            return false;
        }
        return true;
    }

    private boolean n(View view) {
        View view2 = this.f12797i;
        if (view2 != null && view2 != this) {
            if (view == view2) {
                return true;
            }
        } else if (view == this.f12796h) {
            return true;
        }
        return false;
    }

    private void q(boolean z7) {
        int i8;
        int i9;
        int i10;
        int i11;
        View view = this.f12797i;
        if (view == null) {
            view = this.f12796h;
        }
        int i12 = i(view);
        DescendantOffsetUtils.a(this, this.f12798j, this.f12803o);
        ViewGroup viewGroup = this.f12796h;
        int i13 = 0;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i13 = toolbar.getTitleMarginStart();
            i9 = toolbar.getTitleMarginEnd();
            i10 = toolbar.getTitleMarginTop();
            i8 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT >= 24 && (viewGroup instanceof android.widget.Toolbar)) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i13 = toolbar2.getTitleMarginStart();
            i9 = toolbar2.getTitleMarginEnd();
            i10 = toolbar2.getTitleMarginTop();
            i8 = toolbar2.getTitleMarginBottom();
        } else {
            i8 = 0;
            i9 = 0;
            i10 = 0;
        }
        CollapsingTextHelper collapsingTextHelper = this.f12804p;
        Rect rect = this.f12803o;
        int i14 = rect.left;
        if (z7) {
            i11 = i9;
        } else {
            i11 = i13;
        }
        int i15 = i14 + i11;
        int i16 = rect.top + i12 + i10;
        int i17 = rect.right;
        if (!z7) {
            i13 = i9;
        }
        collapsingTextHelper.e0(i15, i16, i17 - i13, (rect.bottom + i12) - i8);
    }

    private void r() {
        setContentDescription(getTitle());
    }

    private void s(@NonNull Drawable drawable, int i8, int i9) {
        t(drawable, this.f12796h, i8, i9);
    }

    private void t(@NonNull Drawable drawable, View view, int i8, int i9) {
        if (l() && view != null && this.f12806r) {
            i9 = view.getBottom();
        }
        drawable.setBounds(0, 0, i8, i9);
    }

    private void u() {
        View view;
        if (!this.f12806r && (view = this.f12798j) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f12798j);
            }
        }
        if (this.f12806r && this.f12796h != null) {
            if (this.f12798j == null) {
                this.f12798j = new View(getContext());
            }
            if (this.f12798j.getParent() == null) {
                this.f12796h.addView(this.f12798j, -1, -1);
            }
        }
    }

    private void w(int i8, int i9, int i10, int i11, boolean z7) {
        View view;
        boolean z8;
        int i12;
        int i13;
        if (this.f12806r && (view = this.f12798j) != null) {
            boolean z9 = false;
            if (ViewCompat.V(view) && this.f12798j.getVisibility() == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            this.f12807s = z8;
            if (z8 || z7) {
                if (ViewCompat.E(this) == 1) {
                    z9 = true;
                }
                q(z9);
                CollapsingTextHelper collapsingTextHelper = this.f12804p;
                if (z9) {
                    i12 = this.f12801m;
                } else {
                    i12 = this.f12799k;
                }
                int i14 = this.f12803o.top + this.f12800l;
                int i15 = i10 - i8;
                if (z9) {
                    i13 = this.f12799k;
                } else {
                    i13 = this.f12801m;
                }
                collapsingTextHelper.o0(i12, i14, i15 - i13, (i11 - i9) - this.f12802n);
                this.f12804p.b0(z7);
            }
        }
    }

    private void x() {
        if (this.f12796h != null && this.f12806r && TextUtils.isEmpty(this.f12804p.O())) {
            setTitle(j(this.f12796h));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        int i8;
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f12796h == null && (drawable = this.f12808t) != null && this.f12810v > 0) {
            drawable.mutate().setAlpha(this.f12810v);
            this.f12808t.draw(canvas);
        }
        if (this.f12806r && this.f12807s) {
            if (this.f12796h != null && this.f12808t != null && this.f12810v > 0 && l() && this.f12804p.F() < this.f12804p.G()) {
                int save = canvas.save();
                canvas.clipRect(this.f12808t.getBounds(), Region.Op.DIFFERENCE);
                this.f12804p.l(canvas);
                canvas.restoreToCount(save);
            } else {
                this.f12804p.l(canvas);
            }
        }
        if (this.f12809u != null && this.f12810v > 0) {
            WindowInsetsCompat windowInsetsCompat = this.F;
            if (windowInsetsCompat != null) {
                i8 = windowInsetsCompat.l();
            } else {
                i8 = 0;
            }
            if (i8 > 0) {
                this.f12809u.setBounds(0, -this.D, getWidth(), i8 - this.D);
                this.f12809u.mutate().setAlpha(this.f12810v);
                this.f12809u.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j8) {
        boolean z7;
        if (this.f12808t != null && this.f12810v > 0 && n(view)) {
            t(this.f12808t, view, getWidth(), getHeight());
            this.f12808t.mutate().setAlpha(this.f12810v);
            this.f12808t.draw(canvas);
            z7 = true;
        } else {
            z7 = false;
        }
        if (super.drawChild(canvas, view, j8) || z7) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f12809u;
        boolean z7 = false;
        if (drawable != null && drawable.isStateful()) {
            z7 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f12808t;
        if (drawable2 != null && drawable2.isStateful()) {
            z7 |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.f12804p;
        if (collapsingTextHelper != null) {
            z7 |= collapsingTextHelper.I0(drawableState);
        }
        if (z7) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: g */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f12804p.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.f12804p.u();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f12804p.v();
    }

    public Drawable getContentScrim() {
        return this.f12808t;
    }

    public int getExpandedTitleGravity() {
        return this.f12804p.B();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f12802n;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f12801m;
    }

    public int getExpandedTitleMarginStart() {
        return this.f12799k;
    }

    public int getExpandedTitleMarginTop() {
        return this.f12800l;
    }

    public float getExpandedTitleTextSize() {
        return this.f12804p.D();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f12804p.E();
    }

    public int getHyphenationFrequency() {
        return this.f12804p.H();
    }

    public int getLineCount() {
        return this.f12804p.I();
    }

    public float getLineSpacingAdd() {
        return this.f12804p.J();
    }

    public float getLineSpacingMultiplier() {
        return this.f12804p.K();
    }

    public int getMaxLines() {
        return this.f12804p.L();
    }

    int getScrimAlpha() {
        return this.f12810v;
    }

    public long getScrimAnimationDuration() {
        return this.f12813y;
    }

    public int getScrimVisibleHeightTrigger() {
        int i8;
        int i9 = this.B;
        if (i9 >= 0) {
            return i9 + this.G + this.I;
        }
        WindowInsetsCompat windowInsetsCompat = this.F;
        if (windowInsetsCompat != null) {
            i8 = windowInsetsCompat.l();
        } else {
            i8 = 0;
        }
        int F = ViewCompat.F(this);
        if (F > 0) {
            return Math.min((F * 2) + i8, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f12809u;
    }

    public CharSequence getTitle() {
        if (this.f12806r) {
            return this.f12804p.O();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.E;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f12804p.N();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f12804p.R();
    }

    final int i(@NonNull View view) {
        return ((getHeight() - k(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    WindowInsetsCompat o(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.B(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.a(this.F, windowInsetsCompat2)) {
            this.F = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            ViewCompat.B0(this, ViewCompat.B(appBarLayout));
            if (this.C == null) {
                this.C = new OffsetUpdateListener();
            }
            appBarLayout.d(this.C);
            ViewCompat.p0(this);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f12804p.Y(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.C;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).v(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        WindowInsetsCompat windowInsetsCompat = this.F;
        if (windowInsetsCompat != null) {
            int l8 = windowInsetsCompat.l();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!ViewCompat.B(childAt) && childAt.getTop() < l8) {
                    ViewCompat.d0(childAt, l8);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            k(getChildAt(i13)).d();
        }
        w(i8, i9, i10, i11, false);
        x();
        v();
        int childCount3 = getChildCount();
        for (int i14 = 0; i14 < childCount3; i14++) {
            k(getChildAt(i14)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        int i10;
        d();
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i9);
        WindowInsetsCompat windowInsetsCompat = this.F;
        if (windowInsetsCompat != null) {
            i10 = windowInsetsCompat.l();
        } else {
            i10 = 0;
        }
        if ((mode == 0 || this.H) && i10 > 0) {
            this.G = i10;
            super.onMeasure(i8, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i10, Pow2.MAX_POW2));
        }
        if (this.J && this.f12804p.L() > 1) {
            x();
            w(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int z7 = this.f12804p.z();
            if (z7 > 1) {
                this.I = Math.round(this.f12804p.A()) * (z7 - 1);
                super.onMeasure(i8, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.I, Pow2.MAX_POW2));
            }
        }
        ViewGroup viewGroup = this.f12796h;
        if (viewGroup != null) {
            View view = this.f12797i;
            if (view != null && view != this) {
                setMinimumHeight(h(view));
            } else {
                setMinimumHeight(h(viewGroup));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        Drawable drawable = this.f12808t;
        if (drawable != null) {
            s(drawable, i8, i9);
        }
    }

    public void p(boolean z7, boolean z8) {
        if (this.f12811w != z7) {
            int i8 = 255;
            if (z8) {
                if (!z7) {
                    i8 = 0;
                }
                a(i8);
            } else {
                if (!z7) {
                    i8 = 0;
                }
                setScrimAlpha(i8);
            }
            this.f12811w = z7;
        }
    }

    public void setCollapsedTitleGravity(int i8) {
        this.f12804p.j0(i8);
    }

    public void setCollapsedTitleTextAppearance(int i8) {
        this.f12804p.g0(i8);
    }

    public void setCollapsedTitleTextColor(int i8) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i8));
    }

    public void setCollapsedTitleTextSize(float f8) {
        this.f12804p.k0(f8);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f12804p.l0(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f12808t;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f12808t = drawable3;
            if (drawable3 != null) {
                s(drawable3, getWidth(), getHeight());
                this.f12808t.setCallback(this);
                this.f12808t.setAlpha(this.f12810v);
            }
            ViewCompat.j0(this);
        }
    }

    public void setContentScrimColor(int i8) {
        setContentScrim(new ColorDrawable(i8));
    }

    public void setContentScrimResource(int i8) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i8));
    }

    public void setExpandedTitleColor(int i8) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i8));
    }

    public void setExpandedTitleGravity(int i8) {
        this.f12804p.u0(i8);
    }

    public void setExpandedTitleMarginBottom(int i8) {
        this.f12802n = i8;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i8) {
        this.f12801m = i8;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i8) {
        this.f12799k = i8;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i8) {
        this.f12800l = i8;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i8) {
        this.f12804p.r0(i8);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f12804p.t0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f8) {
        this.f12804p.v0(f8);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f12804p.w0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z7) {
        this.J = z7;
    }

    public void setForceApplySystemWindowInsetTop(boolean z7) {
        this.H = z7;
    }

    public void setHyphenationFrequency(int i8) {
        this.f12804p.B0(i8);
    }

    public void setLineSpacingAdd(float f8) {
        this.f12804p.D0(f8);
    }

    public void setLineSpacingMultiplier(float f8) {
        this.f12804p.E0(f8);
    }

    public void setMaxLines(int i8) {
        this.f12804p.F0(i8);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z7) {
        this.f12804p.H0(z7);
    }

    void setScrimAlpha(int i8) {
        ViewGroup viewGroup;
        if (i8 != this.f12810v) {
            if (this.f12808t != null && (viewGroup = this.f12796h) != null) {
                ViewCompat.j0(viewGroup);
            }
            this.f12810v = i8;
            ViewCompat.j0(this);
        }
    }

    public void setScrimAnimationDuration(long j8) {
        this.f12813y = j8;
    }

    public void setScrimVisibleHeightTrigger(int i8) {
        if (this.B != i8) {
            this.B = i8;
            v();
        }
    }

    public void setScrimsShown(boolean z7) {
        boolean z8;
        if (ViewCompat.W(this) && !isInEditMode()) {
            z8 = true;
        } else {
            z8 = false;
        }
        p(z7, z8);
    }

    public void setStaticLayoutBuilderConfigurer(StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.f12804p.J0(staticLayoutBuilderConfigurer);
    }

    public void setStatusBarScrim(Drawable drawable) {
        boolean z7;
        Drawable drawable2 = this.f12809u;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f12809u = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f12809u.setState(getDrawableState());
                }
                DrawableCompat.m(this.f12809u, ViewCompat.E(this));
                Drawable drawable4 = this.f12809u;
                if (getVisibility() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                drawable4.setVisible(z7, false);
                this.f12809u.setCallback(this);
                this.f12809u.setAlpha(this.f12810v);
            }
            ViewCompat.j0(this);
        }
    }

    public void setStatusBarScrimColor(int i8) {
        setStatusBarScrim(new ColorDrawable(i8));
    }

    public void setStatusBarScrimResource(int i8) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i8));
    }

    public void setTitle(CharSequence charSequence) {
        this.f12804p.K0(charSequence);
        r();
    }

    public void setTitleCollapseMode(int i8) {
        this.E = i8;
        boolean l8 = l();
        this.f12804p.z0(l8);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (l8 && this.f12808t == null) {
            setContentScrimColor(this.f12805q.d(getResources().getDimension(R$dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.f12804p.M0(truncateAt);
    }

    public void setTitleEnabled(boolean z7) {
        if (z7 != this.f12806r) {
            this.f12806r = z7;
            r();
            u();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        this.f12804p.G0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        boolean z7;
        super.setVisibility(i8);
        if (i8 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Drawable drawable = this.f12809u;
        if (drawable != null && drawable.isVisible() != z7) {
            this.f12809u.setVisible(z7, false);
        }
        Drawable drawable2 = this.f12808t;
        if (drawable2 != null && drawable2.isVisible() != z7) {
            this.f12808t.setVisible(z7, false);
        }
    }

    final void v() {
        boolean z7;
        if (this.f12808t != null || this.f12809u != null) {
            if (getHeight() + this.D < getScrimVisibleHeightTrigger()) {
                z7 = true;
            } else {
                z7 = false;
            }
            setScrimsShown(z7);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f12808t && drawable != this.f12809u) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.f12804p.i0(colorStateList);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f12817a;

        /* renamed from: b  reason: collision with root package name */
        float f12818b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12817a = 0;
            this.f12818b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f12624o2);
            this.f12817a = obtainStyledAttributes.getInt(R$styleable.f12633p2, 0);
            a(obtainStyledAttributes.getFloat(R$styleable.f12642q2, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f8) {
            this.f12818b = f8;
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
            this.f12817a = 0;
            this.f12818b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12817a = 0;
            this.f12818b = 0.5f;
        }
    }
}
