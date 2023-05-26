package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: f  reason: collision with root package name */
    protected final VisibilityAnimListener f1715f;

    /* renamed from: g  reason: collision with root package name */
    protected final Context f1716g;

    /* renamed from: h  reason: collision with root package name */
    protected ActionMenuView f1717h;

    /* renamed from: i  reason: collision with root package name */
    protected ActionMenuPresenter f1718i;

    /* renamed from: j  reason: collision with root package name */
    protected int f1719j;

    /* renamed from: k  reason: collision with root package name */
    protected ViewPropertyAnimatorCompat f1720k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1721l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1722m;

    /* loaded from: classes.dex */
    protected class VisibilityAnimListener implements ViewPropertyAnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1723a = false;

        /* renamed from: b  reason: collision with root package name */
        int f1724b;

        protected VisibilityAnimListener() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void a(View view) {
            this.f1723a = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void b(View view) {
            if (this.f1723a) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.f1720k = null;
            AbsActionBarView.super.setVisibility(this.f1724b);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void c(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f1723a = false;
        }

        public VisibilityAnimListener d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i8) {
            AbsActionBarView.this.f1720k = viewPropertyAnimatorCompat;
            this.f1724b = i8;
            return this;
        }
    }

    AbsActionBarView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i8, int i9, boolean z7) {
        return z7 ? i8 - i9 : i8 + i9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i8, int i9, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE), i9);
        return Math.max(0, (i8 - view.getMeasuredWidth()) - i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i8, int i9, int i10, boolean z7) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i9 + ((i10 - measuredHeight) / 2);
        if (z7) {
            view.layout(i8 - measuredWidth, i11, i8, measuredHeight + i11);
        } else {
            view.layout(i8, i11, i8 + measuredWidth, measuredHeight + i11);
        }
        if (z7) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public ViewPropertyAnimatorCompat f(int i8, long j8) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1720k;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
        }
        if (i8 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat b8 = ViewCompat.e(this).b(1.0f);
            b8.f(j8);
            b8.h(this.f1715f.d(b8, i8));
            return b8;
        }
        ViewPropertyAnimatorCompat b9 = ViewCompat.e(this).b(0.0f);
        b9.f(j8);
        b9.h(this.f1715f.d(b9, i8));
        return b9;
    }

    public int getAnimatedVisibility() {
        if (this.f1720k != null) {
            return this.f1715f.f1724b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f1719j;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.f956a, R$attr.f817c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.f1001j, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1718i;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.F(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1722m = false;
        }
        if (!this.f1722m) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1722m = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1722m = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1721l = false;
        }
        if (!this.f1721l) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1721l = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1721l = false;
        }
        return true;
    }

    public void setContentHeight(int i8) {
        this.f1719j = i8;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        if (i8 != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1720k;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.c();
            }
            super.setVisibility(i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsActionBarView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f1715f = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.f815a, typedValue, true) && typedValue.resourceId != 0) {
            this.f1716g = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f1716g = context;
        }
    }
}
