package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

/* loaded from: classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] J = {16842912};
    private static final ActiveIndicatorTransform K = new ActiveIndicatorTransform();
    private static final ActiveIndicatorTransform L = new ActiveIndicatorUnlabeledTransform();
    private ValueAnimator A;
    private ActiveIndicatorTransform B;
    private float C;
    private boolean D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private BadgeDrawable I;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13691f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f13692g;

    /* renamed from: h  reason: collision with root package name */
    Drawable f13693h;

    /* renamed from: i  reason: collision with root package name */
    private int f13694i;

    /* renamed from: j  reason: collision with root package name */
    private int f13695j;

    /* renamed from: k  reason: collision with root package name */
    private float f13696k;

    /* renamed from: l  reason: collision with root package name */
    private float f13697l;

    /* renamed from: m  reason: collision with root package name */
    private float f13698m;

    /* renamed from: n  reason: collision with root package name */
    private int f13699n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13700o;

    /* renamed from: p  reason: collision with root package name */
    private final FrameLayout f13701p;

    /* renamed from: q  reason: collision with root package name */
    private final View f13702q;

    /* renamed from: r  reason: collision with root package name */
    private final ImageView f13703r;

    /* renamed from: s  reason: collision with root package name */
    private final ViewGroup f13704s;

    /* renamed from: t  reason: collision with root package name */
    private final TextView f13705t;

    /* renamed from: u  reason: collision with root package name */
    private final TextView f13706u;

    /* renamed from: v  reason: collision with root package name */
    private int f13707v;

    /* renamed from: w  reason: collision with root package name */
    private MenuItemImpl f13708w;

    /* renamed from: x  reason: collision with root package name */
    private ColorStateList f13709x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f13710y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f13711z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ActiveIndicatorTransform {
        private ActiveIndicatorTransform() {
        }

        protected float a(float f8, float f9) {
            float f10;
            float f11;
            int i8 = (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1));
            if (i8 == 0) {
                f10 = 0.8f;
            } else {
                f10 = 0.0f;
            }
            if (i8 == 0) {
                f11 = 1.0f;
            } else {
                f11 = 0.2f;
            }
            return AnimationUtils.b(0.0f, 1.0f, f10, f11, f8);
        }

        protected float b(float f8, float f9) {
            return AnimationUtils.a(0.4f, 1.0f, f8);
        }

        protected float c(float f8, float f9) {
            return 1.0f;
        }

        public void d(float f8, float f9, @NonNull View view) {
            view.setScaleX(b(f8, f9));
            view.setScaleY(c(f8, f9));
            view.setAlpha(a(f8, f9));
        }
    }

    /* loaded from: classes.dex */
    private static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        protected float c(float f8, float f9) {
            return b(f8, f9);
        }
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        this.f13691f = false;
        this.f13707v = -1;
        this.B = K;
        this.C = 0.0f;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = false;
        this.H = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f13701p = (FrameLayout) findViewById(R$id.navigation_bar_item_icon_container);
        this.f13702q = findViewById(R$id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R$id.navigation_bar_item_icon_view);
        this.f13703r = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.navigation_bar_item_labels_group);
        this.f13704s = viewGroup;
        TextView textView = (TextView) findViewById(R$id.navigation_bar_item_small_label_view);
        this.f13705t = textView;
        TextView textView2 = (TextView) findViewById(R$id.navigation_bar_item_large_label_view);
        this.f13706u = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f13694i = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f13695j = viewGroup.getPaddingBottom();
        ViewCompat.D0(textView, 2);
        ViewCompat.D0(textView2, 2);
        setFocusable(true);
        g(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    if (NavigationBarItemView.this.f13703r.getVisibility() == 0) {
                        NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                        navigationBarItemView.w(navigationBarItemView.f13703r);
                    }
                }
            });
        }
    }

    private void g(float f8, float f9) {
        this.f13696k = f8 - f9;
        this.f13697l = (f9 * 1.0f) / f8;
        this.f13698m = (f8 * 1.0f) / f9;
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f13701p;
        if (frameLayout == null) {
            return this.f13703r;
        }
        return frameLayout;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i8 = 0;
        for (int i9 = 0; i9 < indexOfChild; i9++) {
            View childAt = viewGroup.getChildAt(i9);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i8++;
            }
        }
        return i8;
    }

    private int getSuggestedIconHeight() {
        int i8;
        BadgeDrawable badgeDrawable = this.I;
        if (badgeDrawable != null) {
            i8 = badgeDrawable.getMinimumHeight() / 2;
        } else {
            i8 = 0;
        }
        return Math.max(i8, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.f13703r.getMeasuredWidth() + i8;
    }

    private int getSuggestedIconWidth() {
        int minimumWidth;
        BadgeDrawable badgeDrawable = this.I;
        if (badgeDrawable == null) {
            minimumWidth = 0;
        } else {
            minimumWidth = badgeDrawable.getMinimumWidth() - this.I.h();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f13703r.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private static Drawable i(@NonNull ColorStateList colorStateList) {
        return new RippleDrawable(RippleUtils.a(colorStateList), null, null);
    }

    private FrameLayout j(View view) {
        ImageView imageView = this.f13703r;
        if (view != imageView || !BadgeUtils.f12903a) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private boolean k() {
        if (this.I != null) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (this.G && this.f13699n == 2) {
            return true;
        }
        return false;
    }

    private void m(final float f8) {
        if (this.D && this.f13691f && ViewCompat.V(this)) {
            ValueAnimator valueAnimator = this.A;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.A = null;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.C, f8);
            this.A = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    NavigationBarItemView.this.q(((Float) valueAnimator2.getAnimatedValue()).floatValue(), f8);
                }
            });
            this.A.setInterpolator(MotionUtils.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, AnimationUtils.f12721b));
            this.A.setDuration(MotionUtils.f(getContext(), R$attr.motionDurationLong2, getResources().getInteger(R$integer.material_motion_duration_long_1)));
            this.A.start();
            return;
        }
        q(f8, f8);
    }

    private void n() {
        MenuItemImpl menuItemImpl = this.f13708w;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    private void o() {
        Drawable drawable = this.f13693h;
        RippleDrawable rippleDrawable = null;
        boolean z7 = true;
        if (this.f13692g != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.D && getActiveIndicatorDrawable() != null && this.f13701p != null && activeIndicatorDrawable != null) {
                z7 = false;
                rippleDrawable = new RippleDrawable(RippleUtils.e(this.f13692g), null, activeIndicatorDrawable);
            } else if (drawable == null) {
                drawable = i(this.f13692g);
            }
        }
        FrameLayout frameLayout = this.f13701p;
        if (frameLayout != null) {
            ViewCompat.w0(frameLayout, rippleDrawable);
        }
        ViewCompat.w0(this, drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(float f8, float f9) {
        View view = this.f13702q;
        if (view != null) {
            this.B.d(f8, f9, view);
        }
        this.C = f8;
    }

    private static void r(TextView textView, int i8) {
        TextViewCompat.o(textView, i8);
        int h8 = MaterialResources.h(textView.getContext(), i8, 0);
        if (h8 != 0) {
            textView.setTextSize(0, h8);
        }
    }

    private static void s(@NonNull View view, float f8, float f9, int i8) {
        view.setScaleX(f8);
        view.setScaleY(f9);
        view.setVisibility(i8);
    }

    private static void t(@NonNull View view, int i8, int i9) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i8;
        layoutParams.bottomMargin = i8;
        layoutParams.gravity = i9;
        view.setLayoutParams(layoutParams);
    }

    private void u(View view) {
        if (k() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.a(this.I, view, j(view));
        }
    }

    private void v(View view) {
        if (!k()) {
            return;
        }
        if (view != null) {
            setClipChildren(true);
            setClipToPadding(true);
            BadgeUtils.b(this.I, view);
        }
        this.I = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(View view) {
        if (!k()) {
            return;
        }
        BadgeUtils.c(this.I, view, j(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i8) {
        int i9;
        if (this.f13702q == null) {
            return;
        }
        int min = Math.min(this.E, i8 - (this.H * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13702q.getLayoutParams();
        if (l()) {
            i9 = min;
        } else {
            i9 = this.F;
        }
        layoutParams.height = i9;
        layoutParams.width = min;
        this.f13702q.setLayoutParams(layoutParams);
    }

    private void y() {
        if (l()) {
            this.B = L;
        } else {
            this.B = K;
        }
    }

    private static void z(@NonNull View view, int i8) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i8);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(@NonNull MenuItemImpl menuItemImpl, int i8) {
        CharSequence title;
        int i9;
        this.f13708w = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            title = menuItemImpl.getTooltipText();
        } else {
            title = menuItemImpl.getTitle();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.a(this, title);
        }
        if (menuItemImpl.isVisible()) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        setVisibility(i9);
        this.f13691f = true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f13701p;
        if (frameLayout != null && this.D) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f13702q;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public BadgeDrawable getBadge() {
        return this.I;
    }

    protected int getItemBackgroundResId() {
        return R$drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f13708w;
    }

    protected int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_bar_item_default_margin;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f13707v;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13704s.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f13704s.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13704s.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f13704s.getMeasuredWidth() + layoutParams.rightMargin);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        p();
        this.f13708w = null;
        this.C = 0.0f;
        this.f13691f = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i8) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + 1);
        MenuItemImpl menuItemImpl = this.f13708w;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f13708w.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, J);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.I;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f13708w.getTitle();
            if (!TextUtils.isEmpty(this.f13708w.getContentDescription())) {
                title = this.f13708w.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.I.f()));
        }
        AccessibilityNodeInfoCompat A0 = AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo);
        A0.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            A0.Z(false);
            A0.Q(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6045i);
        }
        A0.q0(getResources().getString(R$string.item_view_role_description));
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public void run() {
                NavigationBarItemView.this.x(i8);
            }
        });
    }

    void p() {
        v(this.f13703r);
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f13702q;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        o();
    }

    public void setActiveIndicatorEnabled(boolean z7) {
        int i8;
        this.D = z7;
        o();
        View view = this.f13702q;
        if (view != null) {
            if (z7) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            view.setVisibility(i8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i8) {
        this.F = i8;
        x(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int i8) {
        this.H = i8;
        x(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z7) {
        this.G = z7;
    }

    public void setActiveIndicatorWidth(int i8) {
        this.E = i8;
        x(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        if (this.I == badgeDrawable) {
            return;
        }
        if (k() && this.f13703r != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            v(this.f13703r);
        }
        this.I = badgeDrawable;
        ImageView imageView = this.f13703r;
        if (imageView != null) {
            u(imageView);
        }
    }

    public void setCheckable(boolean z7) {
        refreshDrawableState();
    }

    public void setChecked(boolean z7) {
        float f8;
        TextView textView = this.f13706u;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f13706u;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f13705t;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f13705t;
        textView4.setPivotY(textView4.getBaseline());
        if (z7) {
            f8 = 1.0f;
        } else {
            f8 = 0.0f;
        }
        m(f8);
        int i8 = this.f13699n;
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 == 2) {
                        t(getIconOrContainer(), this.f13694i, 17);
                        this.f13706u.setVisibility(8);
                        this.f13705t.setVisibility(8);
                    }
                } else {
                    z(this.f13704s, this.f13695j);
                    if (z7) {
                        t(getIconOrContainer(), (int) (this.f13694i + this.f13696k), 49);
                        s(this.f13706u, 1.0f, 1.0f, 0);
                        TextView textView5 = this.f13705t;
                        float f9 = this.f13697l;
                        s(textView5, f9, f9, 4);
                    } else {
                        t(getIconOrContainer(), this.f13694i, 49);
                        TextView textView6 = this.f13706u;
                        float f10 = this.f13698m;
                        s(textView6, f10, f10, 4);
                        s(this.f13705t, 1.0f, 1.0f, 0);
                    }
                }
            } else {
                if (z7) {
                    t(getIconOrContainer(), this.f13694i, 49);
                    z(this.f13704s, this.f13695j);
                    this.f13706u.setVisibility(0);
                } else {
                    t(getIconOrContainer(), this.f13694i, 17);
                    z(this.f13704s, 0);
                    this.f13706u.setVisibility(4);
                }
                this.f13705t.setVisibility(4);
            }
        } else if (this.f13700o) {
            if (z7) {
                t(getIconOrContainer(), this.f13694i, 49);
                z(this.f13704s, this.f13695j);
                this.f13706u.setVisibility(0);
            } else {
                t(getIconOrContainer(), this.f13694i, 17);
                z(this.f13704s, 0);
                this.f13706u.setVisibility(4);
            }
            this.f13705t.setVisibility(4);
        } else {
            z(this.f13704s, this.f13695j);
            if (z7) {
                t(getIconOrContainer(), (int) (this.f13694i + this.f13696k), 49);
                s(this.f13706u, 1.0f, 1.0f, 0);
                TextView textView7 = this.f13705t;
                float f11 = this.f13697l;
                s(textView7, f11, f11, 4);
            } else {
                t(getIconOrContainer(), this.f13694i, 49);
                TextView textView8 = this.f13706u;
                float f12 = this.f13698m;
                s(textView8, f12, f12, 4);
                s(this.f13705t, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z7);
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        this.f13705t.setEnabled(z7);
        this.f13706u.setEnabled(z7);
        this.f13703r.setEnabled(z7);
        if (z7) {
            ViewCompat.I0(this, PointerIconCompat.b(getContext(), 1002));
        } else {
            ViewCompat.I0(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f13710y) {
            return;
        }
        this.f13710y = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.r(drawable).mutate();
            this.f13711z = drawable;
            ColorStateList colorStateList = this.f13709x;
            if (colorStateList != null) {
                DrawableCompat.o(drawable, colorStateList);
            }
        }
        this.f13703r.setImageDrawable(drawable);
    }

    public void setIconSize(int i8) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f13703r.getLayoutParams();
        layoutParams.width = i8;
        layoutParams.height = i8;
        this.f13703r.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f13709x = colorStateList;
        if (this.f13708w != null && (drawable = this.f13711z) != null) {
            DrawableCompat.o(drawable, colorStateList);
            this.f13711z.invalidateSelf();
        }
    }

    public void setItemBackground(int i8) {
        setItemBackground(i8 == 0 ? null : ContextCompat.getDrawable(getContext(), i8));
    }

    public void setItemPaddingBottom(int i8) {
        if (this.f13695j != i8) {
            this.f13695j = i8;
            n();
        }
    }

    public void setItemPaddingTop(int i8) {
        if (this.f13694i != i8) {
            this.f13694i = i8;
            n();
        }
    }

    public void setItemPosition(int i8) {
        this.f13707v = i8;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f13692g = colorStateList;
        o();
    }

    public void setLabelVisibilityMode(int i8) {
        if (this.f13699n != i8) {
            this.f13699n = i8;
            y();
            x(getWidth());
            n();
        }
    }

    public void setShifting(boolean z7) {
        if (this.f13700o != z7) {
            this.f13700o = z7;
            n();
        }
    }

    public void setTextAppearanceActive(int i8) {
        r(this.f13706u, i8);
        g(this.f13705t.getTextSize(), this.f13706u.getTextSize());
        TextView textView = this.f13706u;
        textView.setTypeface(textView.getTypeface(), 1);
    }

    public void setTextAppearanceInactive(int i8) {
        r(this.f13705t, i8);
        g(this.f13705t.getTextSize(), this.f13706u.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f13705t.setTextColor(colorStateList);
            this.f13706u.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f13705t.setText(charSequence);
        this.f13706u.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f13708w;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.f13708w;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.f13708w.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.a(this, charSequence);
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f13693h = drawable;
        o();
    }
}
