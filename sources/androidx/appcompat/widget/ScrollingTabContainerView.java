package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: o  reason: collision with root package name */
    private static final Interpolator f2076o = new DecelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    Runnable f2077f;

    /* renamed from: g  reason: collision with root package name */
    private TabClickListener f2078g;

    /* renamed from: h  reason: collision with root package name */
    LinearLayoutCompat f2079h;

    /* renamed from: i  reason: collision with root package name */
    private Spinner f2080i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2081j;

    /* renamed from: k  reason: collision with root package name */
    int f2082k;

    /* renamed from: l  reason: collision with root package name */
    int f2083l;

    /* renamed from: m  reason: collision with root package name */
    private int f2084m;

    /* renamed from: n  reason: collision with root package name */
    private int f2085n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TabAdapter extends BaseAdapter {
        TabAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f2079h.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i8) {
            return ((TabView) ScrollingTabContainerView.this.f2079h.getChildAt(i8)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i8) {
            return i8;
        }

        @Override // android.widget.Adapter
        public View getView(int i8, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.c((ActionBar.Tab) getItem(i8), true);
            }
            ((TabView) view).a((ActionBar.Tab) getItem(i8));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z7;
            ((TabView) view).b().e();
            int childCount = ScrollingTabContainerView.this.f2079h.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = ScrollingTabContainerView.this.f2079h.getChildAt(i8);
                if (childAt == view) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                childAt.setSelected(z7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class TabView extends LinearLayout {

        /* renamed from: f  reason: collision with root package name */
        private final int[] f2090f;

        /* renamed from: g  reason: collision with root package name */
        private ActionBar.Tab f2091g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f2092h;

        /* renamed from: i  reason: collision with root package name */
        private ImageView f2093i;

        /* renamed from: j  reason: collision with root package name */
        private View f2094j;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public TabView(android.content.Context r6, androidx.appcompat.app.ActionBar.Tab r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r5
                int r5 = androidx.appcompat.R$attr.f818d
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f2090f = r1
                r4.f2091g = r7
                androidx.appcompat.widget.TintTypedArray r5 = androidx.appcompat.widget.TintTypedArray.v(r6, r0, r1, r5, r3)
                boolean r6 = r5.s(r3)
                if (r6 == 0) goto L26
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L26:
                r5.w()
                if (r8 == 0) goto L31
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L31:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.TabView.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        public void a(ActionBar.Tab tab) {
            this.f2091g = tab;
            c();
        }

        public ActionBar.Tab b() {
            return this.f2091g;
        }

        public void c() {
            ActionBar.Tab tab = this.f2091g;
            View b8 = tab.b();
            CharSequence charSequence = null;
            if (b8 != null) {
                ViewParent parent = b8.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b8);
                    }
                    addView(b8);
                }
                this.f2094j = b8;
                TextView textView = this.f2092h;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2093i;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2093i.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f2094j;
            if (view != null) {
                removeView(view);
                this.f2094j = null;
            }
            Drawable c8 = tab.c();
            CharSequence d8 = tab.d();
            if (c8 != null) {
                if (this.f2093i == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2093i = appCompatImageView;
                }
                this.f2093i.setImageDrawable(c8);
                this.f2093i.setVisibility(0);
            } else {
                ImageView imageView2 = this.f2093i;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f2093i.setImageDrawable(null);
                }
            }
            boolean z7 = !TextUtils.isEmpty(d8);
            if (z7) {
                if (this.f2092h == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.f819e);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2092h = appCompatTextView;
                }
                this.f2092h.setText(d8);
                this.f2092h.setVisibility(0);
            } else {
                TextView textView2 = this.f2092h;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f2092h.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f2093i;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.a());
            }
            if (!z7) {
                charSequence = tab.a();
            }
            TooltipCompat.a(this, charSequence);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i8, int i9) {
            super.onMeasure(i8, i9);
            if (ScrollingTabContainerView.this.f2082k > 0) {
                int measuredWidth = getMeasuredWidth();
                int i10 = ScrollingTabContainerView.this.f2082k;
                if (measuredWidth > i10) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10, Pow2.MAX_POW2), i9);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z7) {
            boolean z8;
            if (isSelected() != z7) {
                z8 = true;
            } else {
                z8 = false;
            }
            super.setSelected(z7);
            if (z8 && z7) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.f822h);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private boolean d() {
        Spinner spinner = this.f2080i;
        if (spinner != null && spinner.getParent() == this) {
            return true;
        }
        return false;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f2080i == null) {
            this.f2080i = b();
        }
        removeView(this.f2079h);
        addView(this.f2080i, new ViewGroup.LayoutParams(-2, -1));
        if (this.f2080i.getAdapter() == null) {
            this.f2080i.setAdapter((SpinnerAdapter) new TabAdapter());
        }
        Runnable runnable = this.f2077f;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f2077f = null;
        }
        this.f2080i.setSelection(this.f2085n);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f2080i);
        addView(this.f2079h, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f2080i.getSelectedItemPosition());
        return false;
    }

    public void a(int i8) {
        final View childAt = this.f2079h.getChildAt(i8);
        Runnable runnable = this.f2077f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.appcompat.widget.ScrollingTabContainerView.1
            @Override // java.lang.Runnable
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.f2077f = null;
            }
        };
        this.f2077f = runnable2;
        post(runnable2);
    }

    TabView c(ActionBar.Tab tab, boolean z7) {
        TabView tabView = new TabView(getContext(), tab, z7);
        if (z7) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2084m));
        } else {
            tabView.setFocusable(true);
            if (this.f2078g == null) {
                this.f2078g = new TabClickListener();
            }
            tabView.setOnClickListener(this.f2078g);
        }
        return tabView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2077f;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy b8 = ActionBarPolicy.b(getContext());
        setContentHeight(b8.f());
        this.f2083l = b8.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2077f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i8, long j8) {
        ((TabView) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        boolean z7;
        int mode = View.MeasureSpec.getMode(i8);
        boolean z8 = true;
        if (mode == 1073741824) {
            z7 = true;
        } else {
            z7 = false;
        }
        setFillViewport(z7);
        int childCount = this.f2079h.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.f2082k = (int) (View.MeasureSpec.getSize(i8) * 0.4f);
            } else {
                this.f2082k = View.MeasureSpec.getSize(i8) / 2;
            }
            this.f2082k = Math.min(this.f2082k, this.f2083l);
        } else {
            this.f2082k = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2084m, Pow2.MAX_POW2);
        if ((z7 || !this.f2081j) ? false : false) {
            this.f2079h.measure(0, makeMeasureSpec);
            if (this.f2079h.getMeasuredWidth() > View.MeasureSpec.getSize(i8)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i8, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (z7 && measuredWidth != measuredWidth2) {
            setTabSelected(this.f2085n);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z7) {
        this.f2081j = z7;
    }

    public void setContentHeight(int i8) {
        this.f2084m = i8;
        requestLayout();
    }

    public void setTabSelected(int i8) {
        boolean z7;
        this.f2085n = i8;
        int childCount = this.f2079h.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = this.f2079h.getChildAt(i9);
            if (i9 == i8) {
                z7 = true;
            } else {
                z7 = false;
            }
            childAt.setSelected(z7);
            if (z7) {
                a(i8);
            }
        }
        Spinner spinner = this.f2080i;
        if (spinner != null && i8 >= 0) {
            spinner.setSelection(i8);
        }
    }
}
