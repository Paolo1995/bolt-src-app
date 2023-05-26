package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: t  reason: collision with root package name */
    private static final int[] f8034t = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: u  reason: collision with root package name */
    private static final int[] f8035u = {16843660};

    /* renamed from: f  reason: collision with root package name */
    ViewPager f8036f;

    /* renamed from: g  reason: collision with root package name */
    TextView f8037g;

    /* renamed from: h  reason: collision with root package name */
    TextView f8038h;

    /* renamed from: i  reason: collision with root package name */
    TextView f8039i;

    /* renamed from: j  reason: collision with root package name */
    private int f8040j;

    /* renamed from: k  reason: collision with root package name */
    float f8041k;

    /* renamed from: l  reason: collision with root package name */
    private int f8042l;

    /* renamed from: m  reason: collision with root package name */
    private int f8043m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8044n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8045o;

    /* renamed from: p  reason: collision with root package name */
    private final PageListener f8046p;

    /* renamed from: q  reason: collision with root package name */
    private WeakReference<PagerAdapter> f8047q;

    /* renamed from: r  reason: collision with root package name */
    private int f8048r;

    /* renamed from: s  reason: collision with root package name */
    int f8049s;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f8050a;

        PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void a(int i8, float f8, int i9) {
            if (f8 > 0.5f) {
                i8++;
            }
            PagerTitleStrip.this.d(i8, f8, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void b(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.b(pagerAdapter, pagerAdapter2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void c(int i8) {
            this.f8050a = i8;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void d(int i8) {
            if (this.f8050a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.c(pagerTitleStrip.f8036f.getCurrentItem(), PagerTitleStrip.this.f8036f.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f8 = pagerTitleStrip2.f8041k;
                if (f8 < 0.0f) {
                    f8 = 0.0f;
                }
                pagerTitleStrip2.d(pagerTitleStrip2.f8036f.getCurrentItem(), f8, true);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.c(pagerTitleStrip.f8036f.getCurrentItem(), PagerTitleStrip.this.f8036f.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f8 = pagerTitleStrip2.f8041k;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            pagerTitleStrip2.d(pagerTitleStrip2.f8036f.getCurrentItem(), f8, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* renamed from: f  reason: collision with root package name */
        private Locale f8052f;

        SingleLineAllCapsTransform(Context context) {
            this.f8052f = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f8052f);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8040j = -1;
        this.f8041k = -1.0f;
        this.f8046p = new PageListener();
        TextView textView = new TextView(context);
        this.f8037g = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f8038h = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f8039i = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8034t);
        boolean z7 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.o(this.f8037g, resourceId);
            TextViewCompat.o(this.f8038h, resourceId);
            TextViewCompat.o(this.f8039i, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f8037g.setTextColor(color);
            this.f8038h.setTextColor(color);
            this.f8039i.setTextColor(color);
        }
        this.f8043m = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f8049s = this.f8038h.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f8037g.setEllipsize(TextUtils.TruncateAt.END);
        this.f8038h.setEllipsize(TextUtils.TruncateAt.END);
        this.f8039i.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f8035u);
            z7 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z7) {
            setSingleLineAllCaps(this.f8037g);
            setSingleLineAllCaps(this.f8038h);
            setSingleLineAllCaps(this.f8039i);
        } else {
            this.f8037g.setSingleLine();
            this.f8038h.setSingleLine();
            this.f8039i.setSingleLine();
        }
        this.f8042l = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    public void a(int i8, float f8) {
        this.f8037g.setTextSize(i8, f8);
        this.f8038h.setTextSize(i8, f8);
        this.f8039i.setTextSize(i8, f8);
    }

    void b(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.f8046p);
            this.f8047q = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.f8046p);
            this.f8047q = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.f8036f;
        if (viewPager != null) {
            this.f8040j = -1;
            this.f8041k = -1.0f;
            c(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    void c(int i8, PagerAdapter pagerAdapter) {
        int i9;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (pagerAdapter != null) {
            i9 = pagerAdapter.getCount();
        } else {
            i9 = 0;
        }
        this.f8044n = true;
        CharSequence charSequence3 = null;
        if (i8 >= 1 && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i8 - 1);
        } else {
            charSequence = null;
        }
        this.f8037g.setText(charSequence);
        TextView textView = this.f8038h;
        if (pagerAdapter != null && i8 < i9) {
            charSequence2 = pagerAdapter.getPageTitle(i8);
        } else {
            charSequence2 = null;
        }
        textView.setText(charSequence2);
        int i10 = i8 + 1;
        if (i10 < i9 && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i10);
        }
        this.f8039i.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f8037g.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f8038h.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f8039i.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f8040j = i8;
        if (!this.f8045o) {
            d(i8, this.f8041k, false);
        }
        this.f8044n = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i8, float f8, boolean z7) {
        int i9;
        int i10;
        int i11;
        int i12;
        if (i8 != this.f8040j) {
            c(i8, this.f8036f.getAdapter());
        } else if (!z7 && f8 == this.f8041k) {
            return;
        }
        this.f8045o = true;
        int measuredWidth = this.f8037g.getMeasuredWidth();
        int measuredWidth2 = this.f8038h.getMeasuredWidth();
        int measuredWidth3 = this.f8039i.getMeasuredWidth();
        int i13 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i14 = paddingRight + i13;
        int i15 = (width - (paddingLeft + i13)) - i14;
        float f9 = 0.5f + f8;
        if (f9 > 1.0f) {
            f9 -= 1.0f;
        }
        int i16 = ((width - i14) - ((int) (i15 * f9))) - i13;
        int i17 = measuredWidth2 + i16;
        int baseline = this.f8037g.getBaseline();
        int baseline2 = this.f8038h.getBaseline();
        int baseline3 = this.f8039i.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i18 = max - baseline;
        int i19 = max - baseline2;
        int i20 = max - baseline3;
        int max2 = Math.max(Math.max(this.f8037g.getMeasuredHeight() + i18, this.f8038h.getMeasuredHeight() + i19), this.f8039i.getMeasuredHeight() + i20);
        int i21 = this.f8043m & 112;
        if (i21 != 16) {
            if (i21 != 80) {
                i10 = i18 + paddingTop;
                i11 = i19 + paddingTop;
                i12 = paddingTop + i20;
                TextView textView = this.f8038h;
                textView.layout(i16, i11, i17, textView.getMeasuredHeight() + i11);
                int min = Math.min(paddingLeft, (i16 - this.f8042l) - measuredWidth);
                TextView textView2 = this.f8037g;
                textView2.layout(min, i10, measuredWidth + min, textView2.getMeasuredHeight() + i10);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i17 + this.f8042l);
                TextView textView3 = this.f8039i;
                textView3.layout(max3, i12, max3 + measuredWidth3, textView3.getMeasuredHeight() + i12);
                this.f8041k = f8;
                this.f8045o = false;
            }
            i9 = (height - paddingBottom) - max2;
        } else {
            i9 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        }
        i10 = i18 + i9;
        i11 = i19 + i9;
        i12 = i9 + i20;
        TextView textView4 = this.f8038h;
        textView4.layout(i16, i11, i17, textView4.getMeasuredHeight() + i11);
        int min2 = Math.min(paddingLeft, (i16 - this.f8042l) - measuredWidth);
        TextView textView22 = this.f8037g;
        textView22.layout(min2, i10, measuredWidth + min2, textView22.getMeasuredHeight() + i10);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i17 + this.f8042l);
        TextView textView32 = this.f8039i;
        textView32.layout(max32, i12, max32 + measuredWidth3, textView32.getMeasuredHeight() + i12);
        this.f8041k = f8;
        this.f8045o = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f8042l;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.Q(this.f8046p);
            viewPager.b(this.f8046p);
            this.f8036f = viewPager;
            WeakReference<PagerAdapter> weakReference = this.f8047q;
            if (weakReference != null) {
                pagerAdapter = weakReference.get();
            } else {
                pagerAdapter = null;
            }
            b(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f8036f;
        if (viewPager != null) {
            b(viewPager.getAdapter(), null);
            this.f8036f.Q(null);
            this.f8036f.I(this.f8046p);
            this.f8036f = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        if (this.f8036f != null) {
            float f8 = this.f8041k;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            d(this.f8040j, f8, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        int max;
        if (View.MeasureSpec.getMode(i8) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i8);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i8, (int) (size * 0.2f), -2);
            this.f8037g.measure(childMeasureSpec2, childMeasureSpec);
            this.f8038h.measure(childMeasureSpec2, childMeasureSpec);
            this.f8039i.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i9) == 1073741824) {
                max = View.MeasureSpec.getSize(i9);
            } else {
                max = Math.max(getMinHeight(), this.f8038h.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i9, this.f8038h.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f8044n) {
            super.requestLayout();
        }
    }

    public void setGravity(int i8) {
        this.f8043m = i8;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f8) {
        int i8 = ((int) (f8 * 255.0f)) & 255;
        this.f8048r = i8;
        int i9 = (i8 << 24) | (this.f8049s & 16777215);
        this.f8037g.setTextColor(i9);
        this.f8039i.setTextColor(i9);
    }

    public void setTextColor(int i8) {
        this.f8049s = i8;
        this.f8038h.setTextColor(i8);
        int i9 = (this.f8048r << 24) | (this.f8049s & 16777215);
        this.f8037g.setTextColor(i9);
        this.f8039i.setTextColor(i9);
    }

    public void setTextSpacing(int i8) {
        this.f8042l = i8;
        requestLayout();
    }
}
