package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: f0  reason: collision with root package name */
    private static final int f14215f0 = R$style.Widget_Design_TabLayout;

    /* renamed from: g0  reason: collision with root package name */
    private static final Pools$Pool<Tab> f14216g0 = new Pools$SynchronizedPool(16);
    int A;
    private final int B;
    private final int C;
    private final int D;
    private int E;
    int F;
    int G;
    int H;
    int I;
    boolean J;
    boolean K;
    int L;
    int M;
    boolean N;
    private TabIndicatorInterpolator O;
    private final TimeInterpolator P;
    private BaseOnTabSelectedListener Q;
    private final ArrayList<BaseOnTabSelectedListener> R;
    private BaseOnTabSelectedListener S;
    private ValueAnimator T;
    ViewPager U;
    private PagerAdapter V;
    private DataSetObserver W;

    /* renamed from: a0  reason: collision with root package name */
    private TabLayoutOnPageChangeListener f14217a0;

    /* renamed from: b0  reason: collision with root package name */
    private AdapterChangeListener f14218b0;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f14219c0;

    /* renamed from: d0  reason: collision with root package name */
    private int f14220d0;

    /* renamed from: e0  reason: collision with root package name */
    private final Pools$Pool<TabView> f14221e0;

    /* renamed from: f  reason: collision with root package name */
    int f14222f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<Tab> f14223g;

    /* renamed from: h  reason: collision with root package name */
    private Tab f14224h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    final SlidingTabIndicator f14225i;

    /* renamed from: j  reason: collision with root package name */
    int f14226j;

    /* renamed from: k  reason: collision with root package name */
    int f14227k;

    /* renamed from: l  reason: collision with root package name */
    int f14228l;

    /* renamed from: m  reason: collision with root package name */
    int f14229m;

    /* renamed from: n  reason: collision with root package name */
    private final int f14230n;

    /* renamed from: o  reason: collision with root package name */
    private final int f14231o;

    /* renamed from: p  reason: collision with root package name */
    private int f14232p;

    /* renamed from: q  reason: collision with root package name */
    ColorStateList f14233q;

    /* renamed from: r  reason: collision with root package name */
    ColorStateList f14234r;

    /* renamed from: s  reason: collision with root package name */
    ColorStateList f14235s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    Drawable f14236t;

    /* renamed from: u  reason: collision with root package name */
    private int f14237u;

    /* renamed from: v  reason: collision with root package name */
    PorterDuff.Mode f14238v;

    /* renamed from: w  reason: collision with root package name */
    float f14239w;

    /* renamed from: x  reason: collision with root package name */
    float f14240x;

    /* renamed from: y  reason: collision with root package name */
    float f14241y;

    /* renamed from: z  reason: collision with root package name */
    final int f14242z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f14244a;

        AdapterChangeListener() {
        }

        void a(boolean z7) {
            this.f14244a = z7;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void b(@NonNull ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.U == viewPager) {
                tabLayout.N(pagerAdapter2, this.f14244a);
            }
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void a(T t7);

        void b(T t7);

        void c(T t7);
    }

    /* loaded from: classes.dex */
    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.F();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SlidingTabIndicator extends LinearLayout {

        /* renamed from: f  reason: collision with root package name */
        ValueAnimator f14247f;

        /* renamed from: g  reason: collision with root package name */
        private int f14248g;

        SlidingTabIndicator(Context context) {
            super(context);
            this.f14248g = -1;
            setWillNotDraw(false);
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f14222f == -1) {
                tabLayout.f14222f = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f14222f);
        }

        private void f(int i8) {
            if (TabLayout.this.f14220d0 != 0) {
                return;
            }
            View childAt = getChildAt(i8);
            TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.O;
            TabLayout tabLayout = TabLayout.this;
            tabIndicatorInterpolator.c(tabLayout, childAt, tabLayout.f14236t);
            TabLayout.this.f14222f = i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(View view, View view2, float f8) {
            boolean z7;
            if (view != null && view.getWidth() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                TabIndicatorInterpolator tabIndicatorInterpolator = TabLayout.this.O;
                TabLayout tabLayout = TabLayout.this;
                tabIndicatorInterpolator.d(tabLayout, view, view2, f8, tabLayout.f14236t);
            } else {
                Drawable drawable = TabLayout.this.f14236t;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f14236t.getBounds().bottom);
            }
            ViewCompat.j0(this);
        }

        private void k(boolean z7, int i8, int i9) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f14222f == i8) {
                return;
            }
            final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            final View childAt2 = getChildAt(i8);
            if (childAt2 == null) {
                g();
                return;
            }
            TabLayout.this.f14222f = i8;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    SlidingTabIndicator.this.j(childAt, childAt2, valueAnimator.getAnimatedFraction());
                }
            };
            if (z7) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f14247f = valueAnimator;
                valueAnimator.setInterpolator(TabLayout.this.P);
                valueAnimator.setDuration(i9);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(animatorUpdateListener);
                valueAnimator.start();
                return;
            }
            this.f14247f.removeAllUpdateListeners();
            this.f14247f.addUpdateListener(animatorUpdateListener);
        }

        void c(int i8, int i9) {
            ValueAnimator valueAnimator = this.f14247f;
            if (valueAnimator != null && valueAnimator.isRunning() && TabLayout.this.f14222f != i8) {
                this.f14247f.cancel();
            }
            k(true, i8, i9);
        }

        boolean d() {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            int height = TabLayout.this.f14236t.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.f14236t.getIntrinsicHeight();
            }
            int i8 = TabLayout.this.H;
            int i9 = 0;
            if (i8 != 0) {
                if (i8 != 1) {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            height = 0;
                        } else {
                            height = getHeight();
                        }
                    }
                } else {
                    i9 = (getHeight() - height) / 2;
                    height = (getHeight() + height) / 2;
                }
            } else {
                i9 = getHeight() - height;
                height = getHeight();
            }
            if (TabLayout.this.f14236t.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f14236t.getBounds();
                TabLayout.this.f14236t.setBounds(bounds.left, i9, bounds.right, height);
                TabLayout.this.f14236t.draw(canvas);
            }
            super.draw(canvas);
        }

        void h(int i8, float f8) {
            TabLayout.this.f14222f = Math.round(i8 + f8);
            ValueAnimator valueAnimator = this.f14247f;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f14247f.cancel();
            }
            j(getChildAt(i8), getChildAt(i8 + 1), f8);
        }

        void i(int i8) {
            Rect bounds = TabLayout.this.f14236t.getBounds();
            TabLayout.this.f14236t.setBounds(bounds.left, 0, bounds.right, i8);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
            super.onLayout(z7, i8, i9, i10, i11);
            ValueAnimator valueAnimator = this.f14247f;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            } else {
                e();
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i8, int i9) {
            super.onMeasure(i8, i9);
            if (View.MeasureSpec.getMode(i8) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z7 = true;
            if (tabLayout.F == 1 || tabLayout.I == 2) {
                int childCount = getChildCount();
                int i10 = 0;
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = getChildAt(i11);
                    if (childAt.getVisibility() == 0) {
                        i10 = Math.max(i10, childAt.getMeasuredWidth());
                    }
                }
                if (i10 <= 0) {
                    return;
                }
                if (i10 * childCount <= getMeasuredWidth() - (((int) ViewUtils.c(getContext(), 16)) * 2)) {
                    boolean z8 = false;
                    for (int i12 = 0; i12 < childCount; i12++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i12).getLayoutParams();
                        if (layoutParams.width != i10 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i10;
                            layoutParams.weight = 0.0f;
                            z8 = true;
                        }
                    }
                    z7 = z8;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.F = 0;
                    tabLayout2.V(false);
                }
                if (z7) {
                    super.onMeasure(i8, i9);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i8) {
            super.onRtlPropertiesChanged(i8);
            if (Build.VERSION.SDK_INT < 23 && this.f14248g != i8) {
                requestLayout();
                this.f14248g = i8;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Tab {

        /* renamed from: a  reason: collision with root package name */
        private Object f14253a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f14254b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f14255c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f14256d;

        /* renamed from: f  reason: collision with root package name */
        private View f14258f;

        /* renamed from: h  reason: collision with root package name */
        public TabLayout f14260h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public TabView f14261i;

        /* renamed from: e  reason: collision with root package name */
        private int f14257e = -1;

        /* renamed from: g  reason: collision with root package name */
        private int f14259g = 1;

        /* renamed from: j  reason: collision with root package name */
        private int f14262j = -1;

        public View e() {
            return this.f14258f;
        }

        public Drawable f() {
            return this.f14254b;
        }

        public int g() {
            return this.f14257e;
        }

        public int h() {
            return this.f14259g;
        }

        public Object i() {
            return this.f14253a;
        }

        public CharSequence j() {
            return this.f14255c;
        }

        public boolean k() {
            TabLayout tabLayout = this.f14260h;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition != -1 && selectedTabPosition == this.f14257e) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void l() {
            this.f14260h = null;
            this.f14261i = null;
            this.f14253a = null;
            this.f14254b = null;
            this.f14262j = -1;
            this.f14255c = null;
            this.f14256d = null;
            this.f14257e = -1;
            this.f14258f = null;
        }

        public void m() {
            TabLayout tabLayout = this.f14260h;
            if (tabLayout != null) {
                tabLayout.L(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public Tab n(CharSequence charSequence) {
            this.f14256d = charSequence;
            u();
            return this;
        }

        @NonNull
        public Tab o(int i8) {
            return p(LayoutInflater.from(this.f14261i.getContext()).inflate(i8, (ViewGroup) this.f14261i, false));
        }

        @NonNull
        public Tab p(View view) {
            this.f14258f = view;
            u();
            return this;
        }

        @NonNull
        public Tab q(Drawable drawable) {
            this.f14254b = drawable;
            TabLayout tabLayout = this.f14260h;
            if (tabLayout.F == 1 || tabLayout.I == 2) {
                tabLayout.V(true);
            }
            u();
            if (BadgeUtils.f12903a && this.f14261i.l() && this.f14261i.f14270j.isVisible()) {
                this.f14261i.invalidate();
            }
            return this;
        }

        void r(int i8) {
            this.f14257e = i8;
        }

        @NonNull
        public Tab s(Object obj) {
            this.f14253a = obj;
            return this;
        }

        @NonNull
        public Tab t(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f14256d) && !TextUtils.isEmpty(charSequence)) {
                this.f14261i.setContentDescription(charSequence);
            }
            this.f14255c = charSequence;
            u();
            return this;
        }

        void u() {
            TabView tabView = this.f14261i;
            if (tabView != null) {
                tabView.t();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f14263a;

        /* renamed from: b  reason: collision with root package name */
        private int f14264b;

        /* renamed from: c  reason: collision with root package name */
        private int f14265c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f14263a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void a(int i8, float f8, int i9) {
            boolean z7;
            TabLayout tabLayout = this.f14263a.get();
            if (tabLayout != null) {
                int i10 = this.f14265c;
                boolean z8 = false;
                if (i10 == 2 && this.f14264b != 1) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                tabLayout.P(i8, f8, z7, (i10 == 2 && this.f14264b == 0) ? true : true);
            }
        }

        void b() {
            this.f14265c = 0;
            this.f14264b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void c(int i8) {
            this.f14264b = this.f14265c;
            this.f14265c = i8;
            TabLayout tabLayout = this.f14263a.get();
            if (tabLayout != null) {
                tabLayout.W(this.f14265c);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void d(int i8) {
            boolean z7;
            TabLayout tabLayout = this.f14263a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i8 && i8 < tabLayout.getTabCount()) {
                int i9 = this.f14265c;
                if (i9 != 0 && (i9 != 2 || this.f14264b != 0)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                tabLayout.M(tabLayout.B(i8), z7);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class TabView extends LinearLayout {

        /* renamed from: f  reason: collision with root package name */
        private Tab f14266f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f14267g;

        /* renamed from: h  reason: collision with root package name */
        private ImageView f14268h;

        /* renamed from: i  reason: collision with root package name */
        private View f14269i;

        /* renamed from: j  reason: collision with root package name */
        private BadgeDrawable f14270j;

        /* renamed from: k  reason: collision with root package name */
        private View f14271k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f14272l;

        /* renamed from: m  reason: collision with root package name */
        private ImageView f14273m;

        /* renamed from: n  reason: collision with root package name */
        private Drawable f14274n;

        /* renamed from: o  reason: collision with root package name */
        private int f14275o;

        public TabView(@NonNull Context context) {
            super(context);
            this.f14275o = 2;
            u(context);
            ViewCompat.H0(this, TabLayout.this.f14226j, TabLayout.this.f14227k, TabLayout.this.f14228l, TabLayout.this.f14229m);
            setGravity(17);
            setOrientation(!TabLayout.this.J ? 1 : 0);
            setClickable(true);
            ViewCompat.I0(this, PointerIconCompat.b(getContext(), 1002));
        }

        private void f(final View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.tabs.TabLayout.TabView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
                    if (view.getVisibility() == 0) {
                        TabView.this.s(view);
                    }
                }
            });
        }

        private float g(@NonNull Layout layout, int i8, float f8) {
            return layout.getLineWidth(i8) * (f8 / layout.getPaint().getTextSize());
        }

        private BadgeDrawable getBadge() {
            return this.f14270j;
        }

        @NonNull
        private BadgeDrawable getOrCreateBadge() {
            if (this.f14270j == null) {
                this.f14270j = BadgeDrawable.c(getContext());
            }
            r();
            BadgeDrawable badgeDrawable = this.f14270j;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void h(boolean z7) {
            setClipChildren(z7);
            setClipToPadding(z7);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z7);
                viewGroup.setClipToPadding(z7);
            }
        }

        @NonNull
        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(@NonNull Canvas canvas) {
            Drawable drawable = this.f14274n;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f14274n.draw(canvas);
            }
        }

        private FrameLayout k(@NonNull View view) {
            if ((view != this.f14268h && view != this.f14267g) || !BadgeUtils.f12903a) {
                return null;
            }
            return (FrameLayout) view.getParent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean l() {
            if (this.f14270j != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void m() {
            FrameLayout frameLayout;
            if (BadgeUtils.f12903a) {
                frameLayout = i();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.f14268h = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void n() {
            FrameLayout frameLayout;
            if (BadgeUtils.f12903a) {
                frameLayout = i();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.f14267g = textView;
            frameLayout.addView(textView);
        }

        private void p(View view) {
            if (l() && view != null) {
                h(false);
                BadgeUtils.a(this.f14270j, view, k(view));
                this.f14269i = view;
            }
        }

        private void q() {
            if (!l()) {
                return;
            }
            h(true);
            View view = this.f14269i;
            if (view != null) {
                BadgeUtils.b(this.f14270j, view);
                this.f14269i = null;
            }
        }

        private void r() {
            Tab tab;
            Tab tab2;
            if (!l()) {
                return;
            }
            if (this.f14271k != null) {
                q();
            } else if (this.f14268h != null && (tab2 = this.f14266f) != null && tab2.f() != null) {
                View view = this.f14269i;
                ImageView imageView = this.f14268h;
                if (view != imageView) {
                    q();
                    p(this.f14268h);
                    return;
                }
                s(imageView);
            } else if (this.f14267g != null && (tab = this.f14266f) != null && tab.h() == 1) {
                View view2 = this.f14269i;
                TextView textView = this.f14267g;
                if (view2 != textView) {
                    q();
                    p(this.f14267g);
                    return;
                }
                s(textView);
            } else {
                q();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(@NonNull View view) {
            if (l() && view == this.f14269i) {
                BadgeUtils.c(this.f14270j, view, k(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        public void u(Context context) {
            int i8 = TabLayout.this.f14242z;
            GradientDrawable gradientDrawable = null;
            if (i8 != 0) {
                Drawable b8 = AppCompatResources.b(context, i8);
                this.f14274n = b8;
                if (b8 != null && b8.isStateful()) {
                    this.f14274n.setState(getDrawableState());
                }
            } else {
                this.f14274n = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.f14235s != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList a8 = RippleUtils.a(TabLayout.this.f14235s);
                boolean z7 = TabLayout.this.N;
                if (z7) {
                    gradientDrawable2 = null;
                }
                if (!z7) {
                    gradientDrawable = gradientDrawable3;
                }
                gradientDrawable2 = new RippleDrawable(a8, gradientDrawable2, gradientDrawable);
            }
            ViewCompat.w0(this, gradientDrawable2);
            TabLayout.this.invalidate();
        }

        private void x(TextView textView, ImageView imageView, boolean z7) {
            Drawable drawable;
            CharSequence charSequence;
            int i8;
            CharSequence charSequence2;
            int i9;
            Tab tab = this.f14266f;
            CharSequence charSequence3 = null;
            if (tab != null && tab.f() != null) {
                drawable = DrawableCompat.r(this.f14266f.f()).mutate();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                DrawableCompat.o(drawable, TabLayout.this.f14234r);
                PorterDuff.Mode mode = TabLayout.this.f14238v;
                if (mode != null) {
                    DrawableCompat.p(drawable, mode);
                }
            }
            Tab tab2 = this.f14266f;
            if (tab2 != null) {
                charSequence = tab2.j();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z8 = true;
            boolean z9 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                z8 = (z9 && this.f14266f.f14259g == 1) ? false : false;
                if (z9) {
                    charSequence2 = charSequence;
                } else {
                    charSequence2 = null;
                }
                textView.setText(charSequence2);
                if (z8) {
                    i9 = 0;
                } else {
                    i9 = 8;
                }
                textView.setVisibility(i9);
                if (z9) {
                    setVisibility(0);
                }
            } else {
                z8 = false;
            }
            if (z7 && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z8 && imageView.getVisibility() == 0) {
                    i8 = (int) ViewUtils.c(getContext(), 8);
                } else {
                    i8 = 0;
                }
                if (TabLayout.this.J) {
                    if (i8 != MarginLayoutParamsCompat.a(marginLayoutParams)) {
                        MarginLayoutParamsCompat.c(marginLayoutParams, i8);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i8 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i8;
                    MarginLayoutParamsCompat.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.f14266f;
            if (tab3 != null) {
                charSequence3 = tab3.f14256d;
            }
            if (Build.VERSION.SDK_INT > 23) {
                if (!z9) {
                    charSequence = charSequence3;
                }
                TooltipCompat.a(this, charSequence);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f14274n;
            boolean z7 = false;
            if (drawable != null && drawable.isStateful()) {
                z7 = false | this.f14274n.setState(drawableState);
            }
            if (z7) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.f14267g, this.f14268h, this.f14271k};
            int i8 = 0;
            int i9 = 0;
            boolean z7 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    if (z7) {
                        i9 = Math.min(i9, view.getTop());
                    } else {
                        i9 = view.getTop();
                    }
                    if (z7) {
                        i8 = Math.max(i8, view.getBottom());
                    } else {
                        i8 = view.getBottom();
                    }
                    z7 = true;
                }
            }
            return i8 - i9;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.f14267g, this.f14268h, this.f14271k};
            int i8 = 0;
            int i9 = 0;
            boolean z7 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    if (z7) {
                        i9 = Math.min(i9, view.getLeft());
                    } else {
                        i9 = view.getLeft();
                    }
                    if (z7) {
                        i8 = Math.max(i8, view.getRight());
                    } else {
                        i8 = view.getRight();
                    }
                    z7 = true;
                }
            }
            return i8 - i9;
        }

        public Tab getTab() {
            return this.f14266f;
        }

        void o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f14270j;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.f14270j.f()));
            }
            AccessibilityNodeInfoCompat A0 = AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo);
            A0.b0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, this.f14266f.g(), 1, false, isSelected()));
            if (isSelected()) {
                A0.Z(false);
                A0.Q(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6045i);
            }
            A0.q0(getResources().getString(R$string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i8, int i9) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i8);
            int mode = View.MeasureSpec.getMode(i8);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i8 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.A, Integer.MIN_VALUE);
            }
            super.onMeasure(i8, i9);
            if (this.f14267g != null) {
                float f8 = TabLayout.this.f14239w;
                int i10 = this.f14275o;
                ImageView imageView = this.f14268h;
                boolean z7 = true;
                if (imageView != null && imageView.getVisibility() == 0) {
                    i10 = 1;
                } else {
                    TextView textView = this.f14267g;
                    if (textView != null && textView.getLineCount() > 1) {
                        f8 = TabLayout.this.f14241y;
                    }
                }
                float textSize = this.f14267g.getTextSize();
                int lineCount = this.f14267g.getLineCount();
                int d8 = TextViewCompat.d(this.f14267g);
                int i11 = (f8 > textSize ? 1 : (f8 == textSize ? 0 : -1));
                if (i11 != 0 || (d8 >= 0 && i10 != d8)) {
                    if (TabLayout.this.I == 1 && i11 > 0 && lineCount == 1 && ((layout = this.f14267g.getLayout()) == null || g(layout, 0, f8) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z7 = false;
                    }
                    if (z7) {
                        this.f14267g.setTextSize(0, f8);
                        this.f14267g.setMaxLines(i10);
                        super.onMeasure(i8, i9);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f14266f != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.f14266f.m();
                return true;
            }
            return performClick;
        }

        @Override // android.view.View
        public void setSelected(boolean z7) {
            if (isSelected() != z7) {
            }
            super.setSelected(z7);
            TextView textView = this.f14267g;
            if (textView != null) {
                textView.setSelected(z7);
            }
            ImageView imageView = this.f14268h;
            if (imageView != null) {
                imageView.setSelected(z7);
            }
            View view = this.f14271k;
            if (view != null) {
                view.setSelected(z7);
            }
        }

        void setTab(Tab tab) {
            if (tab != this.f14266f) {
                this.f14266f = tab;
                t();
            }
        }

        final void t() {
            boolean z7;
            w();
            Tab tab = this.f14266f;
            if (tab != null && tab.k()) {
                z7 = true;
            } else {
                z7 = false;
            }
            setSelected(z7);
        }

        final void v() {
            setOrientation(!TabLayout.this.J ? 1 : 0);
            TextView textView = this.f14272l;
            if (textView == null && this.f14273m == null) {
                x(this.f14267g, this.f14268h, true);
            } else {
                x(textView, this.f14273m, false);
            }
        }

        final void w() {
            View view;
            ViewParent parent;
            Tab tab = this.f14266f;
            if (tab != null) {
                view = tab.e();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent2 = view.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(view);
                    }
                    View view2 = this.f14271k;
                    if (view2 != null && (parent = view2.getParent()) != null) {
                        ((ViewGroup) parent).removeView(this.f14271k);
                    }
                    addView(view);
                }
                this.f14271k = view;
                TextView textView = this.f14267g;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f14268h;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f14268h.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.f14272l = textView2;
                if (textView2 != null) {
                    this.f14275o = TextViewCompat.d(textView2);
                }
                this.f14273m = (ImageView) view.findViewById(16908294);
            } else {
                View view3 = this.f14271k;
                if (view3 != null) {
                    removeView(view3);
                    this.f14271k = null;
                }
                this.f14272l = null;
                this.f14273m = null;
            }
            if (this.f14271k == null) {
                if (this.f14268h == null) {
                    m();
                }
                if (this.f14267g == null) {
                    n();
                    this.f14275o = TextViewCompat.d(this.f14267g);
                }
                TextViewCompat.o(this.f14267g, TabLayout.this.f14230n);
                if (isSelected() && TabLayout.this.f14232p != -1) {
                    TextViewCompat.o(this.f14267g, TabLayout.this.f14232p);
                } else {
                    TextViewCompat.o(this.f14267g, TabLayout.this.f14231o);
                }
                ColorStateList colorStateList = TabLayout.this.f14233q;
                if (colorStateList != null) {
                    this.f14267g.setTextColor(colorStateList);
                }
                x(this.f14267g, this.f14268h, true);
                r();
                f(this.f14268h);
                f(this.f14267g);
            } else {
                TextView textView3 = this.f14272l;
                if (textView3 != null || this.f14273m != null) {
                    x(textView3, this.f14273m, false);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.f14256d)) {
                setContentDescription(tab.f14256d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f14279a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f14279a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void a(@NonNull Tab tab) {
            this.f14279a.setCurrentItem(tab.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void b(Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void c(Tab tab) {
        }
    }

    public TabLayout(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    private void A() {
        if (this.T == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.T = valueAnimator;
            valueAnimator.setInterpolator(this.P);
            this.T.setDuration(this.G);
            this.T.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.tabs.TabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator2) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private boolean C() {
        if (getTabMode() != 0 && getTabMode() != 2) {
            return false;
        }
        return true;
    }

    private void K(int i8) {
        TabView tabView = (TabView) this.f14225i.getChildAt(i8);
        this.f14225i.removeViewAt(i8);
        if (tabView != null) {
            tabView.o();
            this.f14221e0.a(tabView);
        }
        requestLayout();
    }

    private void S(ViewPager viewPager, boolean z7, boolean z8) {
        ViewPager viewPager2 = this.U;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.f14217a0;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.J(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.f14218b0;
            if (adapterChangeListener != null) {
                this.U.I(adapterChangeListener);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.S;
        if (baseOnTabSelectedListener != null) {
            I(baseOnTabSelectedListener);
            this.S = null;
        }
        if (viewPager != null) {
            this.U = viewPager;
            if (this.f14217a0 == null) {
                this.f14217a0 = new TabLayoutOnPageChangeListener(this);
            }
            this.f14217a0.b();
            viewPager.c(this.f14217a0);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.S = viewPagerOnTabSelectedListener;
            g(viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                N(adapter, z7);
            }
            if (this.f14218b0 == null) {
                this.f14218b0 = new AdapterChangeListener();
            }
            this.f14218b0.a(z7);
            viewPager.b(this.f14218b0);
            O(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.U = null;
            N(null, false);
        }
        this.f14219c0 = z8;
    }

    private void T() {
        int size = this.f14223g.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.f14223g.get(i8).u();
        }
    }

    private void U(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.I == 1 && this.F == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int getDefaultHeight() {
        int size = this.f14223g.size();
        boolean z7 = false;
        int i8 = 0;
        while (true) {
            if (i8 < size) {
                Tab tab = this.f14223g.get(i8);
                if (tab != null && tab.f() != null && !TextUtils.isEmpty(tab.j())) {
                    z7 = true;
                    break;
                }
                i8++;
            } else {
                break;
            }
        }
        if (z7 && !this.J) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i8 = this.B;
        if (i8 != -1) {
            return i8;
        }
        int i9 = this.I;
        if (i9 != 0 && i9 != 2) {
            return 0;
        }
        return this.D;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f14225i.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void l(@NonNull TabItem tabItem) {
        Tab E = E();
        CharSequence charSequence = tabItem.f14212f;
        if (charSequence != null) {
            E.t(charSequence);
        }
        Drawable drawable = tabItem.f14213g;
        if (drawable != null) {
            E.q(drawable);
        }
        int i8 = tabItem.f14214h;
        if (i8 != 0) {
            E.o(i8);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            E.n(tabItem.getContentDescription());
        }
        i(E);
    }

    private void m(@NonNull Tab tab) {
        TabView tabView = tab.f14261i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f14225i.addView(tabView, tab.g(), u());
    }

    private void n(View view) {
        if (view instanceof TabItem) {
            l((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void o(int i8) {
        if (i8 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.W(this) && !this.f14225i.d()) {
            int scrollX = getScrollX();
            int r7 = r(i8, 0.0f);
            if (scrollX != r7) {
                A();
                this.T.setIntValues(scrollX, r7);
                this.T.start();
            }
            this.f14225i.c(i8, this.G);
            return;
        }
        O(i8, 0.0f, true);
    }

    private void p(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    return;
                }
            } else {
                this.f14225i.setGravity(1);
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        this.f14225i.setGravity(8388611);
    }

    private void q() {
        int max;
        int i8 = this.I;
        if (i8 != 0 && i8 != 2) {
            max = 0;
        } else {
            max = Math.max(0, this.E - this.f14226j);
        }
        ViewCompat.H0(this.f14225i, max, 0, 0, 0);
        int i9 = this.I;
        if (i9 != 0) {
            if (i9 == 1 || i9 == 2) {
                if (this.F == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.f14225i.setGravity(1);
            }
        } else {
            p(this.F);
        }
        V(true);
    }

    private int r(int i8, float f8) {
        View childAt;
        View view;
        int i9 = this.I;
        int i10 = 0;
        if ((i9 != 0 && i9 != 2) || (childAt = this.f14225i.getChildAt(i8)) == null) {
            return 0;
        }
        int i11 = i8 + 1;
        if (i11 < this.f14225i.getChildCount()) {
            view = this.f14225i.getChildAt(i11);
        } else {
            view = null;
        }
        int width = childAt.getWidth();
        if (view != null) {
            i10 = view.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i12 = (int) ((width + i10) * 0.5f * f8);
        if (ViewCompat.E(this) == 0) {
            return left + i12;
        }
        return left - i12;
    }

    private void s(@NonNull Tab tab, int i8) {
        tab.r(i8);
        this.f14223g.add(i8, tab);
        int size = this.f14223g.size();
        int i9 = -1;
        for (int i10 = i8 + 1; i10 < size; i10++) {
            if (this.f14223g.get(i10).g() == this.f14222f) {
                i9 = i10;
            }
            this.f14223g.get(i10).r(i10);
        }
        this.f14222f = i9;
    }

    private void setSelectedTabView(int i8) {
        boolean z7;
        boolean z8;
        int childCount = this.f14225i.getChildCount();
        if (i8 < childCount) {
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = this.f14225i.getChildAt(i9);
                boolean z9 = true;
                if ((i9 == i8 && !childAt.isSelected()) || (i9 != i8 && childAt.isSelected())) {
                    if (i9 == i8) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    childAt.setSelected(z8);
                    if (i9 != i8) {
                        z9 = false;
                    }
                    childAt.setActivated(z9);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).w();
                    }
                } else {
                    if (i9 == i8) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    childAt.setSelected(z7);
                    if (i9 != i8) {
                        z9 = false;
                    }
                    childAt.setActivated(z9);
                }
            }
        }
    }

    @NonNull
    private static ColorStateList t(int i8, int i9) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i9, i8});
    }

    @NonNull
    private LinearLayout.LayoutParams u() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        U(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView w(@NonNull Tab tab) {
        TabView tabView;
        Pools$Pool<TabView> pools$Pool = this.f14221e0;
        if (pools$Pool != null) {
            tabView = pools$Pool.b();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.f14256d)) {
            tabView.setContentDescription(tab.f14255c);
        } else {
            tabView.setContentDescription(tab.f14256d);
        }
        return tabView;
    }

    private void x(@NonNull Tab tab) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            this.R.get(size).c(tab);
        }
    }

    private void y(@NonNull Tab tab) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            this.R.get(size).a(tab);
        }
    }

    private void z(@NonNull Tab tab) {
        for (int size = this.R.size() - 1; size >= 0; size--) {
            this.R.get(size).b(tab);
        }
    }

    public Tab B(int i8) {
        if (i8 >= 0 && i8 < getTabCount()) {
            return this.f14223g.get(i8);
        }
        return null;
    }

    public boolean D() {
        return this.K;
    }

    @NonNull
    public Tab E() {
        Tab v7 = v();
        v7.f14260h = this;
        v7.f14261i = w(v7);
        if (v7.f14262j != -1) {
            v7.f14261i.setId(v7.f14262j);
        }
        return v7;
    }

    void F() {
        int currentItem;
        H();
        PagerAdapter pagerAdapter = this.V;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i8 = 0; i8 < count; i8++) {
                k(E().t(this.V.getPageTitle(i8)), false);
            }
            ViewPager viewPager = this.U;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                L(B(currentItem));
            }
        }
    }

    protected boolean G(Tab tab) {
        return f14216g0.a(tab);
    }

    public void H() {
        for (int childCount = this.f14225i.getChildCount() - 1; childCount >= 0; childCount--) {
            K(childCount);
        }
        Iterator<Tab> it = this.f14223g.iterator();
        while (it.hasNext()) {
            Tab next = it.next();
            it.remove();
            next.l();
            G(next);
        }
        this.f14224h = null;
    }

    @Deprecated
    public void I(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.R.remove(baseOnTabSelectedListener);
    }

    public void J(@NonNull OnTabSelectedListener onTabSelectedListener) {
        I(onTabSelectedListener);
    }

    public void L(Tab tab) {
        M(tab, true);
    }

    public void M(Tab tab, boolean z7) {
        int i8;
        Tab tab2 = this.f14224h;
        if (tab2 == tab) {
            if (tab2 != null) {
                x(tab);
                o(tab.g());
                return;
            }
            return;
        }
        if (tab != null) {
            i8 = tab.g();
        } else {
            i8 = -1;
        }
        if (z7) {
            if ((tab2 == null || tab2.g() == -1) && i8 != -1) {
                O(i8, 0.0f, true);
            } else {
                o(i8);
            }
            if (i8 != -1) {
                setSelectedTabView(i8);
            }
        }
        this.f14224h = tab;
        if (tab2 != null && tab2.f14260h != null) {
            z(tab2);
        }
        if (tab != null) {
            y(tab);
        }
    }

    void N(PagerAdapter pagerAdapter, boolean z7) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.V;
        if (pagerAdapter2 != null && (dataSetObserver = this.W) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.V = pagerAdapter;
        if (z7 && pagerAdapter != null) {
            if (this.W == null) {
                this.W = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.W);
        }
        F();
    }

    public void O(int i8, float f8, boolean z7) {
        P(i8, f8, z7, true);
    }

    public void P(int i8, float f8, boolean z7, boolean z8) {
        int r7;
        int round = Math.round(i8 + f8);
        if (round >= 0 && round < this.f14225i.getChildCount()) {
            if (z8) {
                this.f14225i.h(i8, f8);
            }
            ValueAnimator valueAnimator = this.T;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.T.cancel();
            }
            if (i8 < 0) {
                r7 = 0;
            } else {
                r7 = r(i8, f8);
            }
            scrollTo(r7, 0);
            if (z7) {
                setSelectedTabView(round);
            }
        }
    }

    public void Q(int i8, int i9) {
        setTabTextColors(t(i8, i9));
    }

    public void R(ViewPager viewPager, boolean z7) {
        S(viewPager, z7, false);
    }

    void V(boolean z7) {
        for (int i8 = 0; i8 < this.f14225i.getChildCount(); i8++) {
            View childAt = this.f14225i.getChildAt(i8);
            childAt.setMinimumWidth(getTabMinWidth());
            U((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z7) {
                childAt.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i8) {
        this.f14220d0 = i8;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        n(view);
    }

    @Deprecated
    public void g(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.R.contains(baseOnTabSelectedListener)) {
            this.R.add(baseOnTabSelectedListener);
        }
    }

    public int getSelectedTabPosition() {
        Tab tab = this.f14224h;
        if (tab != null) {
            return tab.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f14223g.size();
    }

    public int getTabGravity() {
        return this.F;
    }

    public ColorStateList getTabIconTint() {
        return this.f14234r;
    }

    public int getTabIndicatorAnimationMode() {
        return this.M;
    }

    public int getTabIndicatorGravity() {
        return this.H;
    }

    int getTabMaxWidth() {
        return this.A;
    }

    public int getTabMode() {
        return this.I;
    }

    public ColorStateList getTabRippleColor() {
        return this.f14235s;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f14236t;
    }

    public ColorStateList getTabTextColors() {
        return this.f14233q;
    }

    public void h(@NonNull OnTabSelectedListener onTabSelectedListener) {
        g(onTabSelectedListener);
    }

    public void i(@NonNull Tab tab) {
        k(tab, this.f14223g.isEmpty());
    }

    public void j(@NonNull Tab tab, int i8, boolean z7) {
        if (tab.f14260h == this) {
            s(tab, i8);
            m(tab);
            if (z7) {
                tab.m();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void k(@NonNull Tab tab, boolean z7) {
        j(tab, this.f14223g.size(), z7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
        if (this.U == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                S((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f14219c0) {
            setupWithViewPager(null);
            this.f14219c0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i8 = 0; i8 < this.f14225i.getChildCount(); i8++) {
            View childAt = this.f14225i.getChildAt(i8);
            if (childAt instanceof TabView) {
                ((TabView) childAt).j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.A0(accessibilityNodeInfo).a0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (C() && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r0 != 2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L25;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.ViewUtils.c(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.C
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.ViewUtils.c(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.A = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.I
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 8 && !C()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        MaterialShapeUtils.d(this, f8);
    }

    public void setInlineLabel(boolean z7) {
        if (this.J != z7) {
            this.J = z7;
            for (int i8 = 0; i8 < this.f14225i.getChildCount(); i8++) {
                View childAt = this.f14225i.getChildAt(i8);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).v();
                }
            }
            q();
        }
    }

    public void setInlineLabelResource(int i8) {
        setInlineLabel(getResources().getBoolean(i8));
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        A();
        this.T.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = DrawableCompat.r(drawable).mutate();
        this.f14236t = mutate;
        DrawableUtils.g(mutate, this.f14237u);
        int i8 = this.L;
        if (i8 == -1) {
            i8 = this.f14236t.getIntrinsicHeight();
        }
        this.f14225i.i(i8);
    }

    public void setSelectedTabIndicatorColor(int i8) {
        this.f14237u = i8;
        DrawableUtils.g(this.f14236t, i8);
        V(false);
    }

    public void setSelectedTabIndicatorGravity(int i8) {
        if (this.H != i8) {
            this.H = i8;
            ViewCompat.j0(this.f14225i);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i8) {
        this.L = i8;
        this.f14225i.i(i8);
    }

    public void setTabGravity(int i8) {
        if (this.F != i8) {
            this.F = i8;
            q();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f14234r != colorStateList) {
            this.f14234r = colorStateList;
            T();
        }
    }

    public void setTabIconTintResource(int i8) {
        setTabIconTint(AppCompatResources.a(getContext(), i8));
    }

    public void setTabIndicatorAnimationMode(int i8) {
        this.M = i8;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 == 2) {
                    this.O = new FadeTabIndicatorInterpolator();
                    return;
                }
                throw new IllegalArgumentException(i8 + " is not a valid TabIndicatorAnimationMode");
            }
            this.O = new ElasticTabIndicatorInterpolator();
            return;
        }
        this.O = new TabIndicatorInterpolator();
    }

    public void setTabIndicatorFullWidth(boolean z7) {
        this.K = z7;
        this.f14225i.g();
        ViewCompat.j0(this.f14225i);
    }

    public void setTabMode(int i8) {
        if (i8 != this.I) {
            this.I = i8;
            q();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f14235s != colorStateList) {
            this.f14235s = colorStateList;
            for (int i8 = 0; i8 < this.f14225i.getChildCount(); i8++) {
                View childAt = this.f14225i.getChildAt(i8);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i8) {
        setTabRippleColor(AppCompatResources.a(getContext(), i8));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f14233q != colorStateList) {
            this.f14233q = colorStateList;
            T();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        N(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z7) {
        if (this.N != z7) {
            this.N = z7;
            for (int i8 = 0; i8 < this.f14225i.getChildCount(); i8++) {
                View childAt = this.f14225i.getChildAt(i8);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i8) {
        setUnboundedRipple(getResources().getBoolean(i8));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        R(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    protected Tab v() {
        Tab b8 = f14216g0.b();
        if (b8 == null) {
            return new Tab();
        }
        return b8;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i8) {
        n(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.Q;
        if (baseOnTabSelectedListener2 != null) {
            I(baseOnTabSelectedListener2);
        }
        this.Q = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            g(baseOnTabSelectedListener);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        n(view);
    }

    public void setSelectedTabIndicator(int i8) {
        if (i8 != 0) {
            setSelectedTabIndicator(AppCompatResources.b(getContext(), i8));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
