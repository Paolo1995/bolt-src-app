package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    private boolean f1727f;

    /* renamed from: g  reason: collision with root package name */
    private View f1728g;

    /* renamed from: h  reason: collision with root package name */
    private View f1729h;

    /* renamed from: i  reason: collision with root package name */
    private View f1730i;

    /* renamed from: j  reason: collision with root package name */
    Drawable f1731j;

    /* renamed from: k  reason: collision with root package name */
    Drawable f1732k;

    /* renamed from: l  reason: collision with root package name */
    Drawable f1733l;

    /* renamed from: m  reason: collision with root package name */
    boolean f1734m;

    /* renamed from: n  reason: collision with root package name */
    boolean f1735n;

    /* renamed from: o  reason: collision with root package name */
    private int f1736o;

    /* loaded from: classes.dex */
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.w0(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f956a);
        this.f1731j = obtainStyledAttributes.getDrawable(R$styleable.f961b);
        this.f1732k = obtainStyledAttributes.getDrawable(R$styleable.f971d);
        this.f1736o = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1001j, -1);
        boolean z7 = true;
        if (getId() == R$id.H) {
            this.f1734m = true;
            this.f1733l = obtainStyledAttributes.getDrawable(R$styleable.f966c);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1734m ? this.f1731j != null || this.f1732k != null : this.f1733l != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        if (view != null && view.getVisibility() != 8 && view.getMeasuredHeight() != 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1731j;
        if (drawable != null && drawable.isStateful()) {
            this.f1731j.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1732k;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1732k.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1733l;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f1733l.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f1728g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1731j;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1732k;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1733l;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1729h = findViewById(R$id.f891a);
        this.f1730i = findViewById(R$id.f896f);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f1727f && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        boolean z8;
        Drawable drawable;
        super.onLayout(z7, i8, i9, i10, i11);
        View view = this.f1728g;
        boolean z9 = true;
        boolean z10 = false;
        if (view != null && view.getVisibility() != 8) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            int i12 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i8, (measuredHeight - view.getMeasuredHeight()) - i12, i10, measuredHeight - i12);
        }
        if (this.f1734m) {
            Drawable drawable2 = this.f1733l;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z9 = false;
            }
        } else {
            if (this.f1731j != null) {
                if (this.f1729h.getVisibility() == 0) {
                    this.f1731j.setBounds(this.f1729h.getLeft(), this.f1729h.getTop(), this.f1729h.getRight(), this.f1729h.getBottom());
                } else {
                    View view2 = this.f1730i;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f1731j.setBounds(this.f1730i.getLeft(), this.f1730i.getTop(), this.f1730i.getRight(), this.f1730i.getBottom());
                    } else {
                        this.f1731j.setBounds(0, 0, 0, 0);
                    }
                }
                z10 = true;
            }
            this.f1735n = z8;
            if (z8 && (drawable = this.f1732k) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z9 = z10;
            }
        }
        if (z9) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        int i10;
        int i11;
        int i12;
        if (this.f1729h == null && View.MeasureSpec.getMode(i9) == Integer.MIN_VALUE && (i12 = this.f1736o) >= 0) {
            i9 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i9)), Integer.MIN_VALUE);
        }
        super.onMeasure(i8, i9);
        if (this.f1729h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i9);
        View view = this.f1728g;
        if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
            if (!b(this.f1729h)) {
                i10 = a(this.f1729h);
            } else if (!b(this.f1730i)) {
                i10 = a(this.f1730i);
            } else {
                i10 = 0;
            }
            if (mode == Integer.MIN_VALUE) {
                i11 = View.MeasureSpec.getSize(i9);
            } else {
                i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            setMeasuredDimension(getMeasuredWidth(), Math.min(i10 + a(this.f1728g), i11));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1731j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1731j);
        }
        this.f1731j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1729h;
            if (view != null) {
                this.f1731j.setBounds(view.getLeft(), this.f1729h.getTop(), this.f1729h.getRight(), this.f1729h.getBottom());
            }
        }
        boolean z7 = true;
        if (!this.f1734m ? this.f1731j != null || this.f1732k != null : this.f1733l != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
        invalidate();
        Api21Impl.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1733l;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1733l);
        }
        this.f1733l = drawable;
        boolean z7 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1734m && (drawable2 = this.f1733l) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1734m ? !(this.f1731j != null || this.f1732k != null) : this.f1733l == null) {
            z7 = true;
        }
        setWillNotDraw(z7);
        invalidate();
        Api21Impl.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1732k;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1732k);
        }
        this.f1732k = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1735n && (drawable2 = this.f1732k) != null) {
                drawable2.setBounds(this.f1728g.getLeft(), this.f1728g.getTop(), this.f1728g.getRight(), this.f1728g.getBottom());
            }
        }
        boolean z7 = true;
        if (!this.f1734m ? this.f1731j != null || this.f1732k != null : this.f1733l != null) {
            z7 = false;
        }
        setWillNotDraw(z7);
        invalidate();
        Api21Impl.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f1728g;
        if (view != null) {
            removeView(view);
        }
        this.f1728g = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z7) {
        int i8;
        this.f1727f = z7;
        if (z7) {
            i8 = 393216;
        } else {
            i8 = 262144;
        }
        setDescendantFocusability(i8);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        boolean z7;
        super.setVisibility(i8);
        if (i8 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        Drawable drawable = this.f1731j;
        if (drawable != null) {
            drawable.setVisible(z7, false);
        }
        Drawable drawable2 = this.f1732k;
        if (drawable2 != null) {
            drawable2.setVisible(z7, false);
        }
        Drawable drawable3 = this.f1733l;
        if (drawable3 != null) {
            drawable3.setVisible(z7, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i8) {
        if (i8 != 0) {
            return super.startActionModeForChild(view, callback, i8);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if ((drawable == this.f1731j && !this.f1734m) || ((drawable == this.f1732k && this.f1735n) || ((drawable == this.f1733l && this.f1734m) || super.verifyDrawable(drawable)))) {
            return true;
        }
        return false;
    }
}
