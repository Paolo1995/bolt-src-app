package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import org.jctools.util.Pow2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f12830d;

    /* renamed from: e  reason: collision with root package name */
    final Rect f12831e;

    /* renamed from: f  reason: collision with root package name */
    private int f12832f;

    /* renamed from: g  reason: collision with root package name */
    private int f12833g;

    public HeaderScrollingViewBehavior() {
        this.f12830d = new Rect();
        this.f12831e = new Rect();
        this.f12832f = 0;
    }

    private static int N(int i8) {
        if (i8 == 0) {
            return 8388659;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i8) {
        View H = H(coordinatorLayout.s(view));
        if (H != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f12830d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.B(coordinatorLayout) && !ViewCompat.B(view)) {
                rect.left += lastWindowInsets.j();
                rect.right -= lastWindowInsets.k();
            }
            Rect rect2 = this.f12831e;
            GravityCompat.a(N(layoutParams.f5456c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i8);
            int I = I(H);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            this.f12832f = rect2.top - H.getBottom();
            return;
        }
        super.F(coordinatorLayout, view, i8);
        this.f12832f = 0;
    }

    abstract View H(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int I(View view) {
        if (this.f12833g == 0) {
            return 0;
        }
        float J = J(view);
        int i8 = this.f12833g;
        return MathUtils.b((int) (J * i8), 0, i8);
    }

    float J(View view) {
        return 1.0f;
    }

    public final int K() {
        return this.f12833g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int L(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int M() {
        return this.f12832f;
    }

    public final void O(int i8) {
        this.f12833g = i8;
    }

    protected boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i8, int i9, int i10, int i11) {
        View H;
        int i12;
        WindowInsetsCompat lastWindowInsets;
        int i13 = view.getLayoutParams().height;
        if ((i13 == -1 || i13 == -2) && (H = H(coordinatorLayout.s(view))) != null) {
            int size = View.MeasureSpec.getSize(i10);
            if (size > 0) {
                if (ViewCompat.B(H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.l() + lastWindowInsets.i();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int L = size + L(H);
            int measuredHeight = H.getMeasuredHeight();
            if (P()) {
                view.setTranslationY(-measuredHeight);
            } else {
                view.setTranslationY(0.0f);
                L -= measuredHeight;
            }
            if (i13 == -1) {
                i12 = Pow2.MAX_POW2;
            } else {
                i12 = Integer.MIN_VALUE;
            }
            coordinatorLayout.K(view, i8, i9, View.MeasureSpec.makeMeasureSpec(L, i12), i11);
            return true;
        }
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12830d = new Rect();
        this.f12831e = new Rect();
        this.f12832f = 0;
    }
}
