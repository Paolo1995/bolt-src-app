package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    private boolean f2010f;

    /* renamed from: g  reason: collision with root package name */
    private int f2011g;

    /* renamed from: h  reason: collision with root package name */
    private int f2012h;

    /* renamed from: i  reason: collision with root package name */
    private int f2013i;

    /* renamed from: j  reason: collision with root package name */
    private int f2014j;

    /* renamed from: k  reason: collision with root package name */
    private int f2015k;

    /* renamed from: l  reason: collision with root package name */
    private float f2016l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2017m;

    /* renamed from: n  reason: collision with root package name */
    private int[] f2018n;

    /* renamed from: o  reason: collision with root package name */
    private int[] f2019o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f2020p;

    /* renamed from: q  reason: collision with root package name */
    private int f2021q;

    /* renamed from: r  reason: collision with root package name */
    private int f2022r;

    /* renamed from: s  reason: collision with root package name */
    private int f2023s;

    /* renamed from: t  reason: collision with root package name */
    private int f2024t;

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    private void i(int i8, int i9) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Pow2.MAX_POW2);
        for (int i10 = 0; i10 < i8; i10++) {
            View q8 = q(i10);
            if (q8.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) q8.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i11 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = q8.getMeasuredWidth();
                    measureChildWithMargins(q8, i9, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i11;
                }
            }
        }
    }

    private void j(int i8, int i9) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Pow2.MAX_POW2);
        for (int i10 = 0; i10 < i8; i10++) {
            View q8 = q(i10);
            if (q8.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) q8.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i11 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = q8.getMeasuredHeight();
                    measureChildWithMargins(q8, makeMeasureSpec, 0, i9, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i11;
                }
            }
        }
    }

    private void y(View view, int i8, int i9, int i10, int i11) {
        view.layout(i8, i9, i10 + i8, i11 + i9);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void e(Canvas canvas) {
        int right;
        int left;
        int i8;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean b8 = ViewUtils.b(this);
        for (int i9 = 0; i9 < virtualChildCount; i9++) {
            View q8 = q(i9);
            if (q8 != null && q8.getVisibility() != 8 && r(i9)) {
                LayoutParams layoutParams = (LayoutParams) q8.getLayoutParams();
                if (b8) {
                    left2 = q8.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else {
                    left2 = (q8.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f2021q;
                }
                h(canvas, left2);
            }
        }
        if (r(virtualChildCount)) {
            View q9 = q(virtualChildCount - 1);
            if (q9 == null) {
                if (b8) {
                    right = getPaddingLeft();
                } else {
                    left = getWidth() - getPaddingRight();
                    i8 = this.f2021q;
                    right = left - i8;
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) q9.getLayoutParams();
                if (b8) {
                    left = q9.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i8 = this.f2021q;
                    right = left - i8;
                } else {
                    right = q9.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            }
            h(canvas, right);
        }
    }

    void f(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            View q8 = q(i8);
            if (q8 != null && q8.getVisibility() != 8 && r(i8)) {
                g(canvas, (q8.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) q8.getLayoutParams())).topMargin) - this.f2022r);
            }
        }
        if (r(virtualChildCount)) {
            View q9 = q(virtualChildCount - 1);
            if (q9 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.f2022r;
            } else {
                bottom = q9.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) q9.getLayoutParams())).bottomMargin;
            }
            g(canvas, bottom);
        }
    }

    void g(Canvas canvas, int i8) {
        this.f2020p.setBounds(getPaddingLeft() + this.f2024t, i8, (getWidth() - getPaddingRight()) - this.f2024t, this.f2022r + i8);
        this.f2020p.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i8;
        if (this.f2011g < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i9 = this.f2011g;
        if (childCount > i9) {
            View childAt = getChildAt(i9);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f2011g == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i10 = this.f2012h;
            if (this.f2013i == 1 && (i8 = this.f2014j & 112) != 48) {
                if (i8 != 16) {
                    if (i8 == 80) {
                        i10 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2015k;
                    }
                } else {
                    i10 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2015k) / 2;
                }
            }
            return i10 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2011g;
    }

    public Drawable getDividerDrawable() {
        return this.f2020p;
    }

    public int getDividerPadding() {
        return this.f2024t;
    }

    public int getDividerWidth() {
        return this.f2021q;
    }

    public int getGravity() {
        return this.f2014j;
    }

    public int getOrientation() {
        return this.f2013i;
    }

    public int getShowDividers() {
        return this.f2023s;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2016l;
    }

    void h(Canvas canvas, int i8) {
        this.f2020p.setBounds(i8, getPaddingTop() + this.f2024t, this.f2021q + i8, (getHeight() - getPaddingBottom()) - this.f2024t);
        this.f2020p.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: k */
    public LayoutParams generateDefaultLayoutParams() {
        int i8 = this.f2013i;
        if (i8 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i8 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: l */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    int n(View view, int i8) {
        return 0;
    }

    int o(View view) {
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f2020p == null) {
            return;
        }
        if (this.f2013i == 1) {
            f(canvas);
        } else {
            e(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        if (this.f2013i == 1) {
            t(i8, i9, i10, i11);
        } else {
            s(i8, i9, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.f2013i == 1) {
            x(i8, i9);
        } else {
            v(i8, i9);
        }
    }

    int p(View view) {
        return 0;
    }

    View q(int i8) {
        return getChildAt(i8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r(int i8) {
        if (i8 == 0) {
            if ((this.f2023s & 1) == 0) {
                return false;
            }
            return true;
        } else if (i8 == getChildCount()) {
            if ((this.f2023s & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f2023s & 2) == 0) {
            return false;
        } else {
            for (int i9 = i8 - 1; i9 >= 0; i9--) {
                if (getChildAt(i9).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void s(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.s(int, int, int, int):void");
    }

    public void setBaselineAligned(boolean z7) {
        this.f2010f = z7;
    }

    public void setBaselineAlignedChildIndex(int i8) {
        if (i8 >= 0 && i8 < getChildCount()) {
            this.f2011g = i8;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2020p) {
            return;
        }
        this.f2020p = drawable;
        boolean z7 = false;
        if (drawable != null) {
            this.f2021q = drawable.getIntrinsicWidth();
            this.f2022r = drawable.getIntrinsicHeight();
        } else {
            this.f2021q = 0;
            this.f2022r = 0;
        }
        if (drawable == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        requestLayout();
    }

    public void setDividerPadding(int i8) {
        this.f2024t = i8;
    }

    public void setGravity(int i8) {
        if (this.f2014j != i8) {
            if ((8388615 & i8) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            this.f2014j = i8;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i8) {
        int i9 = i8 & 8388615;
        int i10 = this.f2014j;
        if ((8388615 & i10) != i9) {
            this.f2014j = i9 | ((-8388616) & i10);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z7) {
        this.f2017m = z7;
    }

    public void setOrientation(int i8) {
        if (this.f2013i != i8) {
            this.f2013i = i8;
            requestLayout();
        }
    }

    public void setShowDividers(int i8) {
        if (i8 != this.f2023s) {
            requestLayout();
        }
        this.f2023s = i8;
    }

    public void setVerticalGravity(int i8) {
        int i9 = i8 & 112;
        int i10 = this.f2014j;
        if ((i10 & 112) != i9) {
            this.f2014j = i9 | (i10 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f8) {
        this.f2016l = Math.max(0.0f, f8);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void t(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f2014j
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L3b
            r0 = 80
            if (r1 == r0) goto L2f
            int r0 = r17.getPaddingTop()
            goto L47
        L2f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f2015k
            int r0 = r0 - r1
            goto L47
        L3b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f2015k
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L47:
            r1 = 0
            r12 = 0
        L49:
            if (r12 >= r10) goto Lc8
            android.view.View r13 = r6.q(r12)
            r14 = 1
            if (r13 != 0) goto L59
            int r1 = r6.w(r12)
            int r0 = r0 + r1
            goto Lc5
        L59:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto Lc5
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L75
            r1 = r11
        L75:
            int r2 = androidx.core.view.ViewCompat.E(r17)
            int r1 = androidx.core.view.GravityCompat.b(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L8d
            r2 = 5
            if (r1 == r2) goto L88
            int r1 = r5.leftMargin
            int r1 = r1 + r7
            goto L98
        L88:
            int r1 = r8 - r4
            int r2 = r5.rightMargin
            goto L97
        L8d:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
            int r2 = r5.rightMargin
        L97:
            int r1 = r1 - r2
        L98:
            r2 = r1
            boolean r1 = r6.r(r12)
            if (r1 == 0) goto La2
            int r1 = r6.f2022r
            int r0 = r0 + r1
        La2:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.o(r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.y(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.p(r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.n(r13, r12)
            int r12 = r12 + r0
            r0 = r16
        Lc5:
            r1 = 1
            int r12 = r12 + r1
            goto L49
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.t(int, int, int, int):void");
    }

    void u(View view, int i8, int i9, int i10, int i11, int i12) {
        measureChildWithMargins(view, i9, i10, i11, i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void v(int r38, int r39) {
        /*
            Method dump skipped, instructions count: 1285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.v(int, int):void");
    }

    int w(int i8) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0323  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void x(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 911
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.x(int, int):void");
    }

    public LinearLayoutCompat(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f2010f = true;
        this.f2011g = -1;
        this.f2012h = 0;
        this.f2014j = 8388659;
        int[] iArr = R$styleable.f958a1;
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, iArr, i8, 0);
        ViewCompat.q0(this, context, iArr, attributeSet, v7.r(), i8, 0);
        int k8 = v7.k(R$styleable.f968c1, -1);
        if (k8 >= 0) {
            setOrientation(k8);
        }
        int k9 = v7.k(R$styleable.f963b1, -1);
        if (k9 >= 0) {
            setGravity(k9);
        }
        boolean a8 = v7.a(R$styleable.f973d1, true);
        if (!a8) {
            setBaselineAligned(a8);
        }
        this.f2016l = v7.i(R$styleable.f983f1, -1.0f);
        this.f2011g = v7.k(R$styleable.f978e1, -1);
        this.f2017m = v7.a(R$styleable.f998i1, false);
        setDividerDrawable(v7.g(R$styleable.f988g1));
        this.f2023s = v7.k(R$styleable.f1003j1, 0);
        this.f2024t = v7.f(R$styleable.f993h1, 0);
        v7.w();
    }
}
