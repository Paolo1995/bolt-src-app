package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements ExpandableWidget, Shapeable, CoordinatorLayout.AttachedBehavior {

    /* renamed from: u  reason: collision with root package name */
    private static final int f13428u = R$style.Widget_Design_FloatingActionButton;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f13429g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f13430h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f13431i;

    /* renamed from: j  reason: collision with root package name */
    private PorterDuff.Mode f13432j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f13433k;

    /* renamed from: l  reason: collision with root package name */
    private int f13434l;

    /* renamed from: m  reason: collision with root package name */
    private int f13435m;

    /* renamed from: n  reason: collision with root package name */
    private int f13436n;

    /* renamed from: o  reason: collision with root package name */
    private int f13437o;

    /* renamed from: p  reason: collision with root package name */
    boolean f13438p;

    /* renamed from: q  reason: collision with root package name */
    final Rect f13439q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f13440r;
    @NonNull

    /* renamed from: s  reason: collision with root package name */
    private final AppCompatImageHelper f13441s;

    /* renamed from: t  reason: collision with root package name */
    private FloatingActionButtonImpl f13442t;

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean E(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean I(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i8) {
            return super.l(coordinatorLayout, floatingActionButton, i8);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void g(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            super.g(layoutParams);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnVisibilityChangedListener {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void a(int i8, int i9, int i10, int i11) {
            FloatingActionButton.this.f13439q.set(i8, i9, i10, i11);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i8 + floatingActionButton.f13436n, i9 + FloatingActionButton.this.f13436n, i10 + FloatingActionButton.this.f13436n, i11 + FloatingActionButton.this.f13436n);
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public boolean b() {
            return FloatingActionButton.this.f13438p;
        }

        @Override // com.google.android.material.shadow.ShadowViewDelegate
        public void d(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    /* loaded from: classes.dex */
    class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final TransformationCallback<T> f13449a;

        TransformationCallbackWrapper(@NonNull TransformationCallback<T> transformationCallback) {
            this.f13449a = transformationCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void a() {
            this.f13449a.b(FloatingActionButton.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalTransformationCallback
        public void b() {
            this.f13449a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).f13449a.equals(this.f13449a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f13449a.hashCode();
        }
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.f13442t == null) {
            this.f13442t = h();
        }
        return this.f13442t;
    }

    @NonNull
    private FloatingActionButtonImpl h() {
        return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
    }

    private int k(int i8) {
        int i9 = this.f13435m;
        if (i9 != 0) {
            return i9;
        }
        Resources resources = getResources();
        if (i8 != -1) {
            if (i8 != 1) {
                return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return k(1);
        } else {
            return k(0);
        }
    }

    private void p(@NonNull Rect rect) {
        int i8 = rect.left;
        Rect rect2 = this.f13439q;
        rect.left = i8 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f13431i;
        if (colorStateList == null) {
            DrawableCompat.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f13432j;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.e(colorForState, mode));
    }

    private FloatingActionButtonImpl.InternalVisibilityChangedListener t(final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButtonImpl.InternalVisibilityChangedListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButton.1
            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public void a() {
                onVisibilityChangedListener.b(FloatingActionButton.this);
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.InternalVisibilityChangedListener
            public void b() {
                onVisibilityChangedListener.a(FloatingActionButton.this);
            }
        };
    }

    @Override // com.google.android.material.expandable.ExpandableWidget
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().C(getDrawableState());
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        getImpl().g(new TransformationCallbackWrapper(transformationCallback));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f13429g;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f13430h;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().m();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().p();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public Drawable getContentBackground() {
        return getImpl().l();
    }

    public int getCustomSize() {
        return this.f13435m;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().o();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f13433k;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f13433k;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return (ShapeAppearanceModel) Preconditions.g(getImpl().t());
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f13434l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSizeDimension() {
        return k(this.f13434l);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f13431i;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f13432j;
    }

    public boolean getUseCompatPadding() {
        return this.f13438p;
    }

    @Deprecated
    public boolean i(@NonNull Rect rect) {
        if (!ViewCompat.W(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        p(rect);
        return true;
    }

    public void j(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        p(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().y();
    }

    public void l(OnVisibilityChangedListener onVisibilityChangedListener) {
        m(onVisibilityChangedListener, true);
    }

    void m(OnVisibilityChangedListener onVisibilityChangedListener, boolean z7) {
        getImpl().v(t(onVisibilityChangedListener), z7);
    }

    public boolean n() {
        return getImpl().w();
    }

    public boolean o() {
        return getImpl().x();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i8, int i9) {
        int sizeDimension = getSizeDimension();
        this.f13436n = (sizeDimension - this.f13437o) / 2;
        getImpl().c0();
        int min = Math.min(View.resolveSize(sizeDimension, i8), View.resolveSize(sizeDimension, i9));
        Rect rect = this.f13439q;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        Bundle bundle = (Bundle) Preconditions.g(extendableSavedState.f14211h.get("expandableWidgetHelper"));
        throw null;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        new ExtendableSavedState(onSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && i(this.f13440r) && !this.f13440r.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void r(OnVisibilityChangedListener onVisibilityChangedListener) {
        s(onVisibilityChangedListener, true);
    }

    void s(OnVisibilityChangedListener onVisibilityChangedListener, boolean z7) {
        getImpl().Z(t(onVisibilityChangedListener), z7);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f13429g != colorStateList) {
            this.f13429g = colorStateList;
            getImpl().J(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f13430h != mode) {
            this.f13430h = mode;
            getImpl().K(mode);
        }
    }

    public void setCompatElevation(float f8) {
        getImpl().L(f8);
    }

    public void setCompatElevationResource(int i8) {
        setCompatElevation(getResources().getDimension(i8));
    }

    public void setCompatHoveredFocusedTranslationZ(float f8) {
        getImpl().O(f8);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i8) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i8));
    }

    public void setCompatPressedTranslationZ(float f8) {
        getImpl().R(f8);
    }

    public void setCompatPressedTranslationZResource(int i8) {
        setCompatPressedTranslationZ(getResources().getDimension(i8));
    }

    public void setCustomSize(int i8) {
        if (i8 >= 0) {
            if (i8 != this.f13435m) {
                this.f13435m = i8;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        getImpl().d0(f8);
    }

    public void setEnsureMinTouchTargetSize(boolean z7) {
        if (z7 != getImpl().n()) {
            getImpl().M(z7);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i8) {
        throw null;
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().N(motionSpec);
    }

    public void setHideMotionSpecResource(int i8) {
        setHideMotionSpec(MotionSpec.d(getContext(), i8));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().b0();
            if (this.f13431i != null) {
                q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i8) {
        this.f13441s.i(i8);
        q();
    }

    public void setMaxImageSize(int i8) {
        this.f13437o = i8;
        getImpl().Q(i8);
    }

    public void setRippleColor(int i8) {
        setRippleColor(ColorStateList.valueOf(i8));
    }

    @Override // android.view.View
    public void setScaleX(float f8) {
        super.setScaleX(f8);
        getImpl().G();
    }

    @Override // android.view.View
    public void setScaleY(float f8) {
        super.setScaleY(f8);
        getImpl().G();
    }

    public void setShadowPaddingEnabled(boolean z7) {
        getImpl().T(z7);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().U(shapeAppearanceModel);
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().V(motionSpec);
    }

    public void setShowMotionSpecResource(int i8) {
        setShowMotionSpec(MotionSpec.d(getContext(), i8));
    }

    public void setSize(int i8) {
        this.f13435m = 0;
        if (i8 != this.f13434l) {
            this.f13434l = i8;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f13431i != colorStateList) {
            this.f13431i = colorStateList;
            q();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f13432j != mode) {
            this.f13432j = mode;
            q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f8) {
        super.setTranslationX(f8);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationY(float f8) {
        super.setTranslationY(f8);
        getImpl().H();
    }

    @Override // android.view.View
    public void setTranslationZ(float f8) {
        super.setTranslationZ(f8);
        getImpl().H();
    }

    public void setUseCompatPadding(boolean z7) {
        if (this.f13438p != z7) {
            this.f13438p = z7;
            getImpl().A();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
    }

    /* loaded from: classes.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f13445a;

        /* renamed from: b  reason: collision with root package name */
        private OnVisibilityChangedListener f13446b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13447c;

        public BaseBehavior() {
            this.f13447c = true;
        }

        private static boolean F(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i8;
            Rect rect = floatingActionButton.f13439q;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                int i9 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) {
                    i8 = rect.right;
                } else if (floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) {
                    i8 = -rect.left;
                } else {
                    i8 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                    i9 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                    i9 = -rect.top;
                }
                if (i9 != 0) {
                    ViewCompat.d0(floatingActionButton, i9);
                }
                if (i8 != 0) {
                    ViewCompat.c0(floatingActionButton, i8);
                }
            }
        }

        private boolean J(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (!this.f13447c || layoutParams.e() != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            return true;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f13445a == null) {
                this.f13445a = new Rect();
            }
            Rect rect = this.f13445a;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m(this.f13446b, false);
                return true;
            }
            floatingActionButton.s(this.f13446b, false);
            return true;
        }

        private boolean L(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m(this.f13446b, false);
                return true;
            }
            floatingActionButton.s(this.f13446b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: E */
        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.f13439q;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (F(view)) {
                L(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: I */
        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i8) {
            List<View> s7 = coordinatorLayout.s(floatingActionButton);
            int size = s7.size();
            for (int i9 = 0; i9 < size; i9++) {
                View view = s7.get(i9);
                if (view instanceof AppBarLayout) {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.J(floatingActionButton, i8);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void g(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f5461h == 0) {
                layoutParams.f5461h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.N2);
            this.f13447c = obtainStyledAttributes.getBoolean(R$styleable.O2, true);
            obtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f13433k != colorStateList) {
            this.f13433k = colorStateList;
            getImpl().S(this.f13433k);
        }
    }
}
