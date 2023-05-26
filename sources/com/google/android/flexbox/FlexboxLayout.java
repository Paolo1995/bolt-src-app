package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.FlexboxHelper;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes.dex */
public class FlexboxLayout extends ViewGroup implements FlexContainer {

    /* renamed from: f  reason: collision with root package name */
    private int f12396f;

    /* renamed from: g  reason: collision with root package name */
    private int f12397g;

    /* renamed from: h  reason: collision with root package name */
    private int f12398h;

    /* renamed from: i  reason: collision with root package name */
    private int f12399i;

    /* renamed from: j  reason: collision with root package name */
    private int f12400j;

    /* renamed from: k  reason: collision with root package name */
    private int f12401k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f12402l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f12403m;

    /* renamed from: n  reason: collision with root package name */
    private int f12404n;

    /* renamed from: o  reason: collision with root package name */
    private int f12405o;

    /* renamed from: p  reason: collision with root package name */
    private int f12406p;

    /* renamed from: q  reason: collision with root package name */
    private int f12407q;

    /* renamed from: r  reason: collision with root package name */
    private int[] f12408r;

    /* renamed from: s  reason: collision with root package name */
    private SparseIntArray f12409s;

    /* renamed from: t  reason: collision with root package name */
    private FlexboxHelper f12410t;

    /* renamed from: u  reason: collision with root package name */
    private List<FlexLine> f12411u;

    /* renamed from: v  reason: collision with root package name */
    private FlexboxHelper.FlexLinesResult f12412v;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.f12402l == null && this.f12403m == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean a(int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.f12411u.get(i9).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean d(int i8, int i9) {
        for (int i10 = 1; i10 <= i9; i10++) {
            View r7 = r(i8 - i10);
            if (r7 != null && r7.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void m(Canvas canvas, boolean z7, boolean z8) {
        int i8;
        int i9;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f12411u.size();
        for (int i10 = 0; i10 < size; i10++) {
            FlexLine flexLine = this.f12411u.get(i10);
            for (int i11 = 0; i11 < flexLine.f12376h; i11++) {
                int i12 = flexLine.f12383o + i11;
                View r7 = r(i12);
                if (r7 != null && r7.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) r7.getLayoutParams();
                    if (s(i12, i11)) {
                        if (z7) {
                            left = r7.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            left = (r7.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f12407q;
                        }
                        p(canvas, left, flexLine.f12370b, flexLine.f12375g);
                    }
                    if (i11 == flexLine.f12376h - 1 && (this.f12405o & 4) > 0) {
                        if (z7) {
                            right = (r7.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f12407q;
                        } else {
                            right = r7.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        p(canvas, right, flexLine.f12370b, flexLine.f12375g);
                    }
                }
            }
            if (t(i10)) {
                if (z8) {
                    i9 = flexLine.f12372d;
                } else {
                    i9 = flexLine.f12370b - this.f12406p;
                }
                o(canvas, paddingLeft, i9, max);
            }
            if (u(i10) && (this.f12404n & 4) > 0) {
                if (z8) {
                    i8 = flexLine.f12370b - this.f12406p;
                } else {
                    i8 = flexLine.f12372d;
                }
                o(canvas, paddingLeft, i8, max);
            }
        }
    }

    private void n(Canvas canvas, boolean z7, boolean z8) {
        int i8;
        int i9;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f12411u.size();
        for (int i10 = 0; i10 < size; i10++) {
            FlexLine flexLine = this.f12411u.get(i10);
            for (int i11 = 0; i11 < flexLine.f12376h; i11++) {
                int i12 = flexLine.f12383o + i11;
                View r7 = r(i12);
                if (r7 != null && r7.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) r7.getLayoutParams();
                    if (s(i12, i11)) {
                        if (z8) {
                            top = r7.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            top = (r7.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f12406p;
                        }
                        o(canvas, flexLine.f12369a, top, flexLine.f12375g);
                    }
                    if (i11 == flexLine.f12376h - 1 && (this.f12404n & 4) > 0) {
                        if (z8) {
                            bottom = (r7.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f12406p;
                        } else {
                            bottom = r7.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        o(canvas, flexLine.f12369a, bottom, flexLine.f12375g);
                    }
                }
            }
            if (t(i10)) {
                if (z7) {
                    i9 = flexLine.f12371c;
                } else {
                    i9 = flexLine.f12369a - this.f12407q;
                }
                p(canvas, i9, paddingTop, max);
            }
            if (u(i10) && (this.f12405o & 4) > 0) {
                if (z7) {
                    i8 = flexLine.f12369a - this.f12407q;
                } else {
                    i8 = flexLine.f12371c;
                }
                p(canvas, i8, paddingTop, max);
            }
        }
    }

    private void o(Canvas canvas, int i8, int i9, int i10) {
        Drawable drawable = this.f12402l;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i8, i9, i10 + i8, this.f12406p + i9);
        this.f12402l.draw(canvas);
    }

    private void p(Canvas canvas, int i8, int i9, int i10) {
        Drawable drawable = this.f12403m;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i8, i9, this.f12407q + i8, i10 + i9);
        this.f12403m.draw(canvas);
    }

    private boolean s(int i8, int i9) {
        if (d(i8, i9)) {
            if (l()) {
                if ((this.f12405o & 1) == 0) {
                    return false;
                }
                return true;
            } else if ((this.f12404n & 1) == 0) {
                return false;
            } else {
                return true;
            }
        } else if (l()) {
            if ((this.f12405o & 2) == 0) {
                return false;
            }
            return true;
        } else if ((this.f12404n & 2) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean t(int i8) {
        if (i8 < 0 || i8 >= this.f12411u.size()) {
            return false;
        }
        if (a(i8)) {
            if (l()) {
                if ((this.f12404n & 1) == 0) {
                    return false;
                }
                return true;
            } else if ((this.f12405o & 1) == 0) {
                return false;
            } else {
                return true;
            }
        } else if (l()) {
            if ((this.f12404n & 2) == 0) {
                return false;
            }
            return true;
        } else if ((this.f12405o & 2) == 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean u(int i8) {
        if (i8 < 0 || i8 >= this.f12411u.size()) {
            return false;
        }
        for (int i9 = i8 + 1; i9 < this.f12411u.size(); i9++) {
            if (this.f12411u.get(i9).c() > 0) {
                return false;
            }
        }
        if (l()) {
            if ((this.f12404n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f12405o & 4) == 0) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.v(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.w(boolean, boolean, int, int, int, int):void");
    }

    private void x(int i8, int i9) {
        this.f12411u.clear();
        this.f12412v.a();
        this.f12410t.c(this.f12412v, i8, i9);
        this.f12411u = this.f12412v.f12392a;
        this.f12410t.p(i8, i9);
        if (this.f12399i == 3) {
            for (FlexLine flexLine : this.f12411u) {
                int i10 = Integer.MIN_VALUE;
                for (int i11 = 0; i11 < flexLine.f12376h; i11++) {
                    View r7 = r(flexLine.f12383o + i11);
                    if (r7 != null && r7.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) r7.getLayoutParams();
                        if (this.f12397g != 2) {
                            i10 = Math.max(i10, r7.getMeasuredHeight() + Math.max(flexLine.f12380l - r7.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        } else {
                            i10 = Math.max(i10, r7.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((flexLine.f12380l - r7.getMeasuredHeight()) + r7.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                        }
                    }
                }
                flexLine.f12375g = i10;
            }
        }
        this.f12410t.o(i8, i9, getPaddingTop() + getPaddingBottom());
        this.f12410t.X();
        z(this.f12396f, i8, i9, this.f12412v.f12393b);
    }

    private void y(int i8, int i9) {
        this.f12411u.clear();
        this.f12412v.a();
        this.f12410t.f(this.f12412v, i8, i9);
        this.f12411u = this.f12412v.f12392a;
        this.f12410t.p(i8, i9);
        this.f12410t.o(i8, i9, getPaddingLeft() + getPaddingRight());
        this.f12410t.X();
        z(this.f12396f, i8, i9, this.f12412v.f12393b);
    }

    private void z(int i8, int i9, int i10, int i11) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (i8 != 0 && i8 != 1) {
            if (i8 != 2 && i8 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + i8);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        }
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    if (size < largestMainSize) {
                        i11 = View.combineMeasuredStates(i11, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                    }
                    resolveSizeAndState = View.resolveSizeAndState(size, i9, i11);
                } else {
                    throw new IllegalStateException("Unknown width mode is set: " + mode);
                }
            } else {
                resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i9, i11);
            }
        } else {
            if (size < largestMainSize) {
                i11 = View.combineMeasuredStates(i11, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i9, i11);
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 != 0) {
                if (mode2 == 1073741824) {
                    if (size2 < sumOfCrossSize) {
                        i11 = View.combineMeasuredStates(i11, Spliterator.NONNULL);
                    }
                    resolveSizeAndState2 = View.resolveSizeAndState(size2, i10, i11);
                } else {
                    throw new IllegalStateException("Unknown height mode is set: " + mode2);
                }
            } else {
                resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i10, i11);
            }
        } else {
            if (size2 < sumOfCrossSize) {
                i11 = View.combineMeasuredStates(i11, Spliterator.NONNULL);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i10, i11);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (this.f12409s == null) {
            this.f12409s = new SparseIntArray(getChildCount());
        }
        this.f12408r = this.f12410t.n(view, i8, layoutParams, this.f12409s);
        super.addView(view, i8, layoutParams);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void b(View view, int i8, int i9, FlexLine flexLine) {
        if (s(i8, i9)) {
            if (l()) {
                int i10 = flexLine.f12373e;
                int i11 = this.f12407q;
                flexLine.f12373e = i10 + i11;
                flexLine.f12374f += i11;
                return;
            }
            int i12 = flexLine.f12373e;
            int i13 = this.f12406p;
            flexLine.f12373e = i12 + i13;
            flexLine.f12374f += i13;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int c(int i8, int i9, int i10) {
        return ViewGroup.getChildMeasureSpec(i8, i9, i10);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View e(int i8) {
        return getChildAt(i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int f(int i8, int i9, int i10) {
        return ViewGroup.getChildMeasureSpec(i8, i9, i10);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int g(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return this.f12400j;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.f12399i;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f12402l;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f12403m;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.f12396f;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f12411u.size());
        for (FlexLine flexLine : this.f12411u) {
            if (flexLine.c() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.f12411u;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.f12397g;
    }

    public int getJustifyContent() {
        return this.f12398h;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        int i8 = Integer.MIN_VALUE;
        for (FlexLine flexLine : this.f12411u) {
            i8 = Math.max(i8, flexLine.f12373e);
        }
        return i8;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.f12401k;
    }

    public int getShowDividerHorizontal() {
        return this.f12404n;
    }

    public int getShowDividerVertical() {
        return this.f12405o;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int i8;
        int i9;
        int size = this.f12411u.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            FlexLine flexLine = this.f12411u.get(i11);
            if (t(i11)) {
                if (l()) {
                    i9 = this.f12406p;
                } else {
                    i9 = this.f12407q;
                }
                i10 += i9;
            }
            if (u(i11)) {
                if (l()) {
                    i8 = this.f12406p;
                } else {
                    i8 = this.f12407q;
                }
                i10 += i8;
            }
            i10 += flexLine.f12375g;
        }
        return i10;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void h(FlexLine flexLine) {
        if (l()) {
            if ((this.f12405o & 4) > 0) {
                int i8 = flexLine.f12373e;
                int i9 = this.f12407q;
                flexLine.f12373e = i8 + i9;
                flexLine.f12374f += i9;
            }
        } else if ((this.f12404n & 4) > 0) {
            int i10 = flexLine.f12373e;
            int i11 = this.f12406p;
            flexLine.f12373e = i10 + i11;
            flexLine.f12374f += i11;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View i(int i8) {
        return r(i8);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void j(int i8, View view) {
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int k(View view, int i8, int i9) {
        int i10;
        int i11 = 0;
        if (l()) {
            if (s(i8, i9)) {
                i11 = 0 + this.f12407q;
            }
            if ((this.f12405o & 4) > 0) {
                i10 = this.f12407q;
            } else {
                return i11;
            }
        } else {
            if (s(i8, i9)) {
                i11 = 0 + this.f12406p;
            }
            if ((this.f12404n & 4) > 0) {
                i10 = this.f12406p;
            } else {
                return i11;
            }
        }
        return i11 + i10;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean l() {
        int i8 = this.f12396f;
        if (i8 == 0 || i8 == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z7;
        boolean z8;
        if (this.f12403m == null && this.f12402l == null) {
            return;
        }
        if (this.f12404n == 0 && this.f12405o == 0) {
            return;
        }
        int E = ViewCompat.E(this);
        int i8 = this.f12396f;
        boolean z9 = false;
        boolean z10 = true;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        if (E == 1) {
                            z9 = true;
                        }
                        if (this.f12397g == 2) {
                            z9 = !z9;
                        }
                        n(canvas, z9, true);
                        return;
                    }
                    return;
                }
                if (E != 1) {
                    z10 = false;
                }
                if (this.f12397g == 2) {
                    z10 = !z10;
                }
                n(canvas, z10, false);
                return;
            }
            if (E != 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (this.f12397g == 2) {
                z9 = true;
            }
            m(canvas, z8, z9);
            return;
        }
        if (E == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f12397g == 2) {
            z9 = true;
        }
        m(canvas, z7, z9);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int E = ViewCompat.E(this);
        int i12 = this.f12396f;
        boolean z12 = false;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 == 3) {
                        if (E == 1) {
                            z12 = true;
                        }
                        if (this.f12397g == 2) {
                            z11 = !z12;
                        } else {
                            z11 = z12;
                        }
                        w(z11, true, i8, i9, i10, i11);
                        return;
                    }
                    throw new IllegalStateException("Invalid flex direction is set: " + this.f12396f);
                }
                if (E == 1) {
                    z12 = true;
                }
                if (this.f12397g == 2) {
                    z10 = !z12;
                } else {
                    z10 = z12;
                }
                w(z10, false, i8, i9, i10, i11);
                return;
            }
            if (E != 1) {
                z9 = true;
            } else {
                z9 = false;
            }
            v(z9, i8, i9, i10, i11);
            return;
        }
        if (E == 1) {
            z8 = true;
        } else {
            z8 = false;
        }
        v(z8, i8, i9, i10, i11);
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        if (this.f12409s == null) {
            this.f12409s = new SparseIntArray(getChildCount());
        }
        if (this.f12410t.O(this.f12409s)) {
            this.f12408r = this.f12410t.m(this.f12409s);
        }
        int i10 = this.f12396f;
        if (i10 != 0 && i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f12396f);
            }
            y(i8, i9);
            return;
        }
        x(i8, i9);
    }

    @Override // android.view.ViewGroup
    /* renamed from: q */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public View r(int i8) {
        if (i8 >= 0) {
            int[] iArr = this.f12408r;
            if (i8 < iArr.length) {
                return getChildAt(iArr[i8]);
            }
            return null;
        }
        return null;
    }

    public void setAlignContent(int i8) {
        if (this.f12400j != i8) {
            this.f12400j = i8;
            requestLayout();
        }
    }

    public void setAlignItems(int i8) {
        if (this.f12399i != i8) {
            this.f12399i = i8;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.f12402l) {
            return;
        }
        this.f12402l = drawable;
        if (drawable != null) {
            this.f12406p = drawable.getIntrinsicHeight();
        } else {
            this.f12406p = 0;
        }
        A();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.f12403m) {
            return;
        }
        this.f12403m = drawable;
        if (drawable != null) {
            this.f12407q = drawable.getIntrinsicWidth();
        } else {
            this.f12407q = 0;
        }
        A();
        requestLayout();
    }

    public void setFlexDirection(int i8) {
        if (this.f12396f != i8) {
            this.f12396f = i8;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<FlexLine> list) {
        this.f12411u = list;
    }

    public void setFlexWrap(int i8) {
        if (this.f12397g != i8) {
            this.f12397g = i8;
            requestLayout();
        }
    }

    public void setJustifyContent(int i8) {
        if (this.f12398h != i8) {
            this.f12398h = i8;
            requestLayout();
        }
    }

    public void setMaxLine(int i8) {
        if (this.f12401k != i8) {
            this.f12401k = i8;
            requestLayout();
        }
    }

    public void setShowDivider(int i8) {
        setShowDividerVertical(i8);
        setShowDividerHorizontal(i8);
    }

    public void setShowDividerHorizontal(int i8) {
        if (i8 != this.f12404n) {
            this.f12404n = i8;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i8) {
        if (i8 != this.f12405o) {
            this.f12405o = i8;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f12401k = -1;
        this.f12410t = new FlexboxHelper(this);
        this.f12411u = new ArrayList();
        this.f12412v = new FlexboxHelper.FlexLinesResult();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f12455a, i8, 0);
        this.f12396f = obtainStyledAttributes.getInt(R$styleable.f12461g, 0);
        this.f12397g = obtainStyledAttributes.getInt(R$styleable.f12462h, 0);
        this.f12398h = obtainStyledAttributes.getInt(R$styleable.f12463i, 0);
        this.f12399i = obtainStyledAttributes.getInt(R$styleable.f12457c, 0);
        this.f12400j = obtainStyledAttributes.getInt(R$styleable.f12456b, 0);
        this.f12401k = obtainStyledAttributes.getInt(R$styleable.f12464j, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f12458d);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.f12459e);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R$styleable.f12460f);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i9 = obtainStyledAttributes.getInt(R$styleable.f12465k, 0);
        if (i9 != 0) {
            this.f12405o = i9;
            this.f12404n = i9;
        }
        int i10 = obtainStyledAttributes.getInt(R$styleable.f12467m, 0);
        if (i10 != 0) {
            this.f12405o = i10;
        }
        int i11 = obtainStyledAttributes.getInt(R$styleable.f12466l, 0);
        if (i11 != 0) {
            this.f12404n = i11;
        }
        obtainStyledAttributes.recycle();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public LayoutParams[] newArray(int i8) {
                return new LayoutParams[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        private int f12413f;

        /* renamed from: g  reason: collision with root package name */
        private float f12414g;

        /* renamed from: h  reason: collision with root package name */
        private float f12415h;

        /* renamed from: i  reason: collision with root package name */
        private int f12416i;

        /* renamed from: j  reason: collision with root package name */
        private float f12417j;

        /* renamed from: k  reason: collision with root package name */
        private int f12418k;

        /* renamed from: l  reason: collision with root package name */
        private int f12419l;

        /* renamed from: m  reason: collision with root package name */
        private int f12420m;

        /* renamed from: n  reason: collision with root package name */
        private int f12421n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f12422o;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12413f = 1;
            this.f12414g = 0.0f;
            this.f12415h = 1.0f;
            this.f12416i = -1;
            this.f12417j = -1.0f;
            this.f12418k = -1;
            this.f12419l = -1;
            this.f12420m = 16777215;
            this.f12421n = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f12468n);
            this.f12413f = obtainStyledAttributes.getInt(R$styleable.f12477w, 1);
            this.f12414g = obtainStyledAttributes.getFloat(R$styleable.f12471q, 0.0f);
            this.f12415h = obtainStyledAttributes.getFloat(R$styleable.f12472r, 1.0f);
            this.f12416i = obtainStyledAttributes.getInt(R$styleable.f12469o, -1);
            this.f12417j = obtainStyledAttributes.getFraction(R$styleable.f12470p, 1, 1, -1.0f);
            this.f12418k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f12476v, -1);
            this.f12419l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f12475u, -1);
            this.f12420m = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f12474t, 16777215);
            this.f12421n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f12473s, 16777215);
            this.f12422o = obtainStyledAttributes.getBoolean(R$styleable.f12478x, false);
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        public void C0(int i8) {
            this.f12418k = i8;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int D0() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void F(int i8) {
            this.f12419l = i8;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int G0() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float N() {
            return this.f12414g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float Y() {
            return this.f12417j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean Z() {
            return this.f12422o;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int Z0() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int c0() {
            return this.f12420m;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int c1() {
            return this.f12419l;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int f1() {
            return this.f12421n;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f12413f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int k() {
            return this.f12416i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float m() {
            return this.f12415h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int w() {
            return this.f12418k;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            parcel.writeInt(this.f12413f);
            parcel.writeFloat(this.f12414g);
            parcel.writeFloat(this.f12415h);
            parcel.writeInt(this.f12416i);
            parcel.writeFloat(this.f12417j);
            parcel.writeInt(this.f12418k);
            parcel.writeInt(this.f12419l);
            parcel.writeInt(this.f12420m);
            parcel.writeInt(this.f12421n);
            parcel.writeByte(this.f12422o ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int y() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f12413f = 1;
            this.f12414g = 0.0f;
            this.f12415h = 1.0f;
            this.f12416i = -1;
            this.f12417j = -1.0f;
            this.f12418k = -1;
            this.f12419l = -1;
            this.f12420m = 16777215;
            this.f12421n = 16777215;
            this.f12413f = layoutParams.f12413f;
            this.f12414g = layoutParams.f12414g;
            this.f12415h = layoutParams.f12415h;
            this.f12416i = layoutParams.f12416i;
            this.f12417j = layoutParams.f12417j;
            this.f12418k = layoutParams.f12418k;
            this.f12419l = layoutParams.f12419l;
            this.f12420m = layoutParams.f12420m;
            this.f12421n = layoutParams.f12421n;
            this.f12422o = layoutParams.f12422o;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12413f = 1;
            this.f12414g = 0.0f;
            this.f12415h = 1.0f;
            this.f12416i = -1;
            this.f12417j = -1.0f;
            this.f12418k = -1;
            this.f12419l = -1;
            this.f12420m = 16777215;
            this.f12421n = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12413f = 1;
            this.f12414g = 0.0f;
            this.f12415h = 1.0f;
            this.f12416i = -1;
            this.f12417j = -1.0f;
            this.f12418k = -1;
            this.f12419l = -1;
            this.f12420m = 16777215;
            this.f12421n = 16777215;
        }

        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f12413f = 1;
            this.f12414g = 0.0f;
            this.f12415h = 1.0f;
            this.f12416i = -1;
            this.f12417j = -1.0f;
            this.f12418k = -1;
            this.f12419l = -1;
            this.f12420m = 16777215;
            this.f12421n = 16777215;
            this.f12413f = parcel.readInt();
            this.f12414g = parcel.readFloat();
            this.f12415h = parcel.readFloat();
            this.f12416i = parcel.readInt();
            this.f12417j = parcel.readFloat();
            this.f12418k = parcel.readInt();
            this.f12419l = parcel.readInt();
            this.f12420m = parcel.readInt();
            this.f12421n = parcel.readInt();
            this.f12422o = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
