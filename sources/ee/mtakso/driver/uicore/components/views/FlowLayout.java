package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowLayout.kt */
/* loaded from: classes5.dex */
public final class FlowLayout extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f35457f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35457f = new LinkedHashMap();
    }

    private final ViewGroup.MarginLayoutParams a(View view) {
        ViewGroup.LayoutParams rawParams = view.getLayoutParams();
        Intrinsics.e(rawParams, "rawParams");
        if (!checkLayoutParams(rawParams)) {
            rawParams = generateDefaultLayoutParams();
        }
        Intrinsics.d(rawParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        return (ViewGroup.MarginLayoutParams) rawParams;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p8) {
        Intrinsics.f(p8, "p");
        return p8 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        Intrinsics.f(attrs, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        FlowLayout flowLayout = this;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int i12 = measuredWidth - paddingLeft;
        int measuredHeight = (getMeasuredHeight() - getPaddingBottom()) - paddingTop;
        int i13 = paddingLeft;
        int i14 = 0;
        int i15 = 0;
        while (i14 < childCount) {
            View child = flowLayout.getChildAt(i14);
            Intrinsics.e(child, "child");
            ViewGroup.MarginLayoutParams a8 = flowLayout.a(child);
            if (child.getVisibility() != 8) {
                child.measure(View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE));
                int measuredWidth2 = child.getMeasuredWidth() + a8.leftMargin + a8.rightMargin;
                int measuredHeight2 = child.getMeasuredHeight();
                int i16 = a8.topMargin;
                int i17 = measuredHeight2 + i16 + a8.bottomMargin;
                if (i13 + measuredWidth2 > measuredWidth) {
                    paddingTop += i15;
                    i13 = paddingLeft;
                    i15 = 0;
                }
                child.layout(a8.leftMargin + i13, i16 + paddingTop, i13 + child.getMeasuredWidth() + a8.leftMargin, paddingTop + child.getMeasuredHeight() + a8.topMargin);
                if (i15 < i17) {
                    i15 = i17;
                }
                i13 += measuredWidth2;
            }
            i14++;
            flowLayout = this;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        int childCount = getChildCount();
        int size = (View.MeasureSpec.getSize(i8) - getPaddingLeft()) - getPaddingRight();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View child = getChildAt(i14);
            Intrinsics.e(child, "child");
            ViewGroup.MarginLayoutParams a8 = a(child);
            if (child.getVisibility() != 8) {
                int i15 = a8.leftMargin + a8.rightMargin;
                int i16 = a8.topMargin + a8.bottomMargin;
                measureChildWithMargins(child, i8, 0, i9, 0);
                i11 += Math.max(i11, child.getMeasuredWidth() + i15);
                i13 += child.getMeasuredWidth() + i15;
                if (i13 > size) {
                    i10 += child.getMeasuredHeight() + i16;
                    i13 = child.getMeasuredWidth() + i15;
                } else {
                    i10 = Math.max(i10, child.getMeasuredHeight() + i16);
                }
                i12 = View.combineMeasuredStates(i12, child.getMeasuredState());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i11, getSuggestedMinimumWidth()), i8, i12), View.resolveSizeAndState(Math.max(i10, getSuggestedMinimumHeight()), i9, i12 << 16));
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p8) {
        Intrinsics.f(p8, "p");
        return new ViewGroup.MarginLayoutParams(p8);
    }

    public /* synthetic */ FlowLayout(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
