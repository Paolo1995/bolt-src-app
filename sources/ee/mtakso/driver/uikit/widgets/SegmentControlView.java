package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.R$id;
import ee.mtakso.driver.uikit.R$layout;
import ee.mtakso.driver.uikit.R$style;
import ee.mtakso.driver.uikit.R$styleable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SegmentControlView.kt */
/* loaded from: classes5.dex */
public final class SegmentControlView extends ConstraintLayout {
    private final View E;
    private Drawable F;
    private int G;
    private Function2<? super View, ? super Boolean, Unit> H;
    public Map<Integer, View> I;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SegmentControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentControlView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.I = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Q2, i8, R$style.Widget_UIKit_SegmentControlView);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…mentControlView\n        )");
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R$styleable.R2, R$layout.content_segment_control), (ViewGroup) this, true);
        View findViewById = findViewById(R$id.f35753a);
        Intrinsics.e(findViewById, "findViewById(R.id.background)");
        this.E = findViewById;
        findViewById.setBackground(obtainStyledAttributes.getDrawable(R$styleable.S2));
        ViewCompat.x0(findViewById, obtainStyledAttributes.getColorStateList(R$styleable.T2));
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.U2);
        if (drawable != null) {
            Drawable r7 = DrawableCompat.r(drawable);
            Intrinsics.e(r7, "wrap(it)");
            DrawableCompat.o(r7, obtainStyledAttributes.getColorStateList(R$styleable.V2));
            this.F = r7;
        }
        obtainStyledAttributes.recycle();
    }

    private final void C(View view) {
        F(view, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(SegmentControlView this$0, View it) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.C(it);
    }

    private final void F(View view, boolean z7) {
        boolean z8;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt == view) {
                z8 = true;
            } else {
                z8 = false;
            }
            childAt.setActivated(z8);
        }
        invalidate();
        Function2<? super View, ? super Boolean, Unit> function2 = this.H;
        if (function2 != null) {
            function2.s(view, Boolean.valueOf(z7));
        }
    }

    private final void G() {
        int[] G0;
        float[] E0;
        List r02;
        int[] G02;
        List r03;
        float[] E02;
        ConstraintLayout.LayoutParams layoutParams;
        int i8;
        int m8;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ConstraintSet constraintSet = new ConstraintSet();
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt instanceof SegmentControlItemView) {
                SegmentControlItemView segmentControlItemView = (SegmentControlItemView) childAt;
                if (segmentControlItemView.getVisibility() != 8) {
                    arrayList.add(Integer.valueOf(segmentControlItemView.getId()));
                    arrayList2.add(Float.valueOf(1.0f));
                    arrayList3.add(Integer.valueOf(i9));
                    constraintSet.l(segmentControlItemView.getId(), segmentControlItemView.getMinimumHeight());
                }
            }
        }
        if (arrayList.size() < 1) {
            return;
        }
        if (arrayList.size() < 2) {
            constraintSet.i(((Number) arrayList.get(0)).intValue(), 6, 0, 6);
            constraintSet.i(((Number) arrayList.get(0)).intValue(), 7, 0, 7);
        } else if (r()) {
            r02 = CollectionsKt___CollectionsKt.r0(arrayList);
            G02 = CollectionsKt___CollectionsKt.G0(r02);
            r03 = CollectionsKt___CollectionsKt.r0(arrayList2);
            E02 = CollectionsKt___CollectionsKt.E0(r03);
            constraintSet.n(0, 1, 0, 2, G02, E02, 0);
        } else {
            G0 = CollectionsKt___CollectionsKt.G0(arrayList);
            E0 = CollectionsKt___CollectionsKt.E0(arrayList2);
            constraintSet.n(0, 1, 0, 2, G0, E0, 0);
        }
        constraintSet.c(this);
        int size = arrayList3.size();
        for (int i10 = 0; i10 < size; i10++) {
            ViewGroup.LayoutParams layoutParams2 = getChildAt(((Number) arrayList3.get(i10)).intValue()).getLayoutParams();
            if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
                layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                Drawable drawable = this.F;
                if (drawable != null) {
                    i8 = drawable.getIntrinsicWidth();
                } else {
                    i8 = 0;
                }
                int i11 = i8 / 2;
                if (i10 == 0) {
                    layoutParams.setMarginEnd(i11);
                } else {
                    m8 = CollectionsKt__CollectionsKt.m(arrayList3);
                    if (i10 == m8) {
                        layoutParams.setMarginStart(i11);
                    } else {
                        layoutParams.setMarginStart(i11);
                        layoutParams.setMarginEnd(i11);
                    }
                }
            }
        }
    }

    public final void E(View view) {
        Intrinsics.f(view, "view");
        F(view, false);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof SegmentControlItemView) {
            SegmentControlItemView segmentControlItemView = (SegmentControlItemView) view;
            if (segmentControlItemView.getId() == -1) {
                segmentControlItemView.setId(View.generateViewId());
            }
        }
        super.addView(view, i8, layoutParams);
        G();
    }

    public final Function2<View, Boolean, Unit> getOnSelectedListener() {
        return this.H;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z7;
        Intrinsics.f(canvas, "canvas");
        super.onDraw(canvas);
        Drawable drawable = this.F;
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
        int childCount = getChildCount();
        for (int i8 = 1; i8 < childCount; i8++) {
            View childAt = getChildAt(i8 - 1);
            View cur = getChildAt(i8);
            if (!childAt.isActivated() && !cur.isActivated()) {
                Intrinsics.e(cur, "cur");
                if (cur.getVisibility() == 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    int right = (childAt.getRight() + cur.getLeft()) / 2;
                    drawable.setBounds(right - intrinsicWidth, 0, right + intrinsicWidth, getHeight());
                    drawable.draw(canvas);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof SegmentControlItemView) {
            ((SegmentControlItemView) view).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uikit.widgets.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SegmentControlView.D(SegmentControlView.this, view2);
                }
            });
            this.G++;
            G();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof SegmentControlItemView) {
            this.G--;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        G();
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i8) {
        super.removeViewAt(i8);
        G();
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i8, int i9) {
        super.removeViews(i8, i9);
        G();
    }

    public final void setOnSelectedListener(Function2<? super View, ? super Boolean, Unit> function2) {
        this.H = function2;
    }

    public /* synthetic */ SegmentControlView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.segmentControlViewStyle : i8);
    }
}
