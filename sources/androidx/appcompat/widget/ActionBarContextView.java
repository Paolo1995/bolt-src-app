package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f1737n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f1738o;

    /* renamed from: p  reason: collision with root package name */
    private View f1739p;

    /* renamed from: q  reason: collision with root package name */
    private View f1740q;

    /* renamed from: r  reason: collision with root package name */
    private View f1741r;

    /* renamed from: s  reason: collision with root package name */
    private LinearLayout f1742s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f1743t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f1744u;

    /* renamed from: v  reason: collision with root package name */
    private int f1745v;

    /* renamed from: w  reason: collision with root package name */
    private int f1746w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f1747x;

    /* renamed from: y  reason: collision with root package name */
    private int f1748y;

    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
    }

    private void i() {
        int i8;
        if (this.f1742s == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.f917a, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1742s = linearLayout;
            this.f1743t = (TextView) linearLayout.findViewById(R$id.f895e);
            this.f1744u = (TextView) this.f1742s.findViewById(R$id.f894d);
            if (this.f1745v != 0) {
                this.f1743t.setTextAppearance(getContext(), this.f1745v);
            }
            if (this.f1746w != 0) {
                this.f1744u.setTextAppearance(getContext(), this.f1746w);
            }
        }
        this.f1743t.setText(this.f1737n);
        this.f1744u.setText(this.f1738o);
        boolean z7 = !TextUtils.isEmpty(this.f1737n);
        boolean z8 = !TextUtils.isEmpty(this.f1738o);
        TextView textView = this.f1744u;
        int i9 = 0;
        if (z8) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        textView.setVisibility(i8);
        LinearLayout linearLayout2 = this.f1742s;
        if (!z7 && !z8) {
            i9 = 8;
        }
        linearLayout2.setVisibility(i9);
        if (this.f1742s.getParent() == null) {
            addView(this.f1742s);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat f(int i8, long j8) {
        return super.f(i8, j8);
    }

    public void g() {
        if (this.f1739p == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1738o;
    }

    public CharSequence getTitle() {
        return this.f1737n;
    }

    public void h(final ActionMode actionMode) {
        View view = this.f1739p;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f1748y, (ViewGroup) this, false);
            this.f1739p = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f1739p);
        }
        View findViewById = this.f1739p.findViewById(R$id.f899i);
        this.f1740q = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                actionMode.c();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.e();
        ActionMenuPresenter actionMenuPresenter = this.f1718i;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.y();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f1718i = actionMenuPresenter2;
        actionMenuPresenter2.J(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.c(this.f1718i, this.f1716g);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1718i.o(this);
        this.f1717h = actionMenuView;
        ViewCompat.w0(actionMenuView, null);
        addView(this.f1717h, layoutParams);
    }

    public boolean j() {
        return this.f1747x;
    }

    public void k() {
        removeAllViews();
        this.f1741r = null;
        this.f1717h = null;
        this.f1718i = null;
        View view = this.f1740q;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f1718i;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.K();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f1718i;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
            this.f1718i.C();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        int paddingLeft;
        int paddingRight;
        int i12;
        int i13;
        boolean b8 = ViewUtils.b(this);
        if (b8) {
            paddingLeft = (i10 - i8) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i11 - i9) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1739p;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1739p.getLayoutParams();
            if (b8) {
                i12 = marginLayoutParams.rightMargin;
            } else {
                i12 = marginLayoutParams.leftMargin;
            }
            if (b8) {
                i13 = marginLayoutParams.leftMargin;
            } else {
                i13 = marginLayoutParams.rightMargin;
            }
            int d8 = AbsActionBarView.d(paddingLeft, i12, b8);
            paddingLeft = AbsActionBarView.d(d8 + e(this.f1739p, d8, paddingTop, paddingTop2, b8), i13, b8);
        }
        int i14 = paddingLeft;
        LinearLayout linearLayout = this.f1742s;
        if (linearLayout != null && this.f1741r == null && linearLayout.getVisibility() != 8) {
            i14 += e(this.f1742s, i14, paddingTop, paddingTop2, b8);
        }
        int i15 = i14;
        View view2 = this.f1741r;
        if (view2 != null) {
            e(view2, i15, paddingTop, paddingTop2, b8);
        }
        if (b8) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i10 - i8) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f1717h;
        if (actionMenuView != null) {
            e(actionMenuView, paddingRight, paddingTop, paddingTop2, !b8);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        int i10;
        boolean z7;
        int i11;
        int mode = View.MeasureSpec.getMode(i8);
        int i12 = Pow2.MAX_POW2;
        if (mode == 1073741824) {
            if (View.MeasureSpec.getMode(i9) != 0) {
                int size = View.MeasureSpec.getSize(i8);
                int i13 = this.f1719j;
                if (i13 <= 0) {
                    i13 = View.MeasureSpec.getSize(i9);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i14 = i13 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, Integer.MIN_VALUE);
                View view = this.f1739p;
                if (view != null) {
                    int c8 = c(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1739p.getLayoutParams();
                    paddingLeft = c8 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f1717h;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = c(this.f1717h, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.f1742s;
                if (linearLayout != null && this.f1741r == null) {
                    if (this.f1747x) {
                        this.f1742s.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f1742s.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f1742s;
                        if (z7) {
                            i11 = 0;
                        } else {
                            i11 = 8;
                        }
                        linearLayout2.setVisibility(i11);
                    } else {
                        paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.f1741r;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i15 = layoutParams.width;
                    if (i15 != -2) {
                        i10 = Pow2.MAX_POW2;
                    } else {
                        i10 = Integer.MIN_VALUE;
                    }
                    if (i15 >= 0) {
                        paddingLeft = Math.min(i15, paddingLeft);
                    }
                    int i16 = layoutParams.height;
                    if (i16 == -2) {
                        i12 = Integer.MIN_VALUE;
                    }
                    if (i16 >= 0) {
                        i14 = Math.min(i16, i14);
                    }
                    this.f1741r.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i10), View.MeasureSpec.makeMeasureSpec(i14, i12));
                }
                if (this.f1719j <= 0) {
                    int childCount = getChildCount();
                    int i17 = 0;
                    for (int i18 = 0; i18 < childCount; i18++) {
                        int measuredHeight = getChildAt(i18).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i17) {
                            i17 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i17);
                    return;
                }
                setMeasuredDimension(size, i13);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i8) {
        this.f1719j = i8;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1741r;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1741r = view;
        if (view != null && (linearLayout = this.f1742s) != null) {
            removeView(linearLayout);
            this.f1742s = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1738o = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1737n = charSequence;
        i();
        ViewCompat.v0(this, charSequence);
    }

    public void setTitleOptional(boolean z7) {
        if (z7 != this.f1747x) {
            requestLayout();
        }
        this.f1747x = z7;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i8) {
        super.setVisibility(i8);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f824j);
    }

    public ActionBarContextView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, R$styleable.f1076y, i8, 0);
        ViewCompat.w0(this, v7.g(R$styleable.f1081z));
        this.f1745v = v7.n(R$styleable.D, 0);
        this.f1746w = v7.n(R$styleable.C, 0);
        this.f1719j = v7.m(R$styleable.B, 0);
        this.f1748y = v7.n(R$styleable.A, R$layout.f920d);
        v7.w();
    }
}
