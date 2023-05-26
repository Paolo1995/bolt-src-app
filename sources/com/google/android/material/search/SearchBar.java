package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;

/* loaded from: classes.dex */
public class SearchBar extends Toolbar {

    /* renamed from: p0  reason: collision with root package name */
    private static final int f13914p0 = R$style.Widget_Material3_SearchBar;

    /* renamed from: c0  reason: collision with root package name */
    private final TextView f13915c0;

    /* renamed from: d0  reason: collision with root package name */
    private final boolean f13916d0;

    /* renamed from: e0  reason: collision with root package name */
    private final boolean f13917e0;

    /* renamed from: f0  reason: collision with root package name */
    private final SearchBarAnimationHelper f13918f0;

    /* renamed from: g0  reason: collision with root package name */
    private final Drawable f13919g0;

    /* renamed from: h0  reason: collision with root package name */
    private final boolean f13920h0;

    /* renamed from: i0  reason: collision with root package name */
    private final boolean f13921i0;

    /* renamed from: j0  reason: collision with root package name */
    private View f13922j0;

    /* renamed from: k0  reason: collision with root package name */
    private Integer f13923k0;

    /* renamed from: l0  reason: collision with root package name */
    private Drawable f13924l0;

    /* renamed from: m0  reason: collision with root package name */
    private int f13925m0;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f13926n0;

    /* renamed from: o0  reason: collision with root package name */
    private MaterialShapeDrawable f13927o0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.search.SearchBar.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        String f13928h;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeString(this.f13928h);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13928h = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private int S(int i8, int i9) {
        return i8 == 0 ? i9 : i8;
    }

    private void T() {
        View view = this.f13922j0;
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i8 = measuredWidth2 + measuredWidth;
        int measuredHeight = this.f13922j0.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        U(this.f13922j0, measuredWidth2, measuredHeight2, i8, measuredHeight2 + measuredHeight);
    }

    private void U(View view, int i8, int i9, int i10, int i11) {
        if (ViewCompat.E(this) == 1) {
            view.layout(getMeasuredWidth() - i10, i9, getMeasuredWidth() - i8, i11);
        } else {
            view.layout(i8, i9, i10, i11);
        }
    }

    private Drawable V(Drawable drawable) {
        int i8;
        int d8;
        if (this.f13920h0 && drawable != null) {
            Integer num = this.f13923k0;
            if (num != null) {
                d8 = num.intValue();
            } else {
                if (drawable == this.f13919g0) {
                    i8 = R$attr.colorOnSurfaceVariant;
                } else {
                    i8 = R$attr.colorOnSurface;
                }
                d8 = MaterialColors.d(this, i8);
            }
            Drawable r7 = DrawableCompat.r(drawable.mutate());
            DrawableCompat.n(r7, d8);
            return r7;
        }
        return drawable;
    }

    private void W(int i8, int i9) {
        View view = this.f13922j0;
        if (view != null) {
            view.measure(i8, i9);
        }
    }

    private void X() {
        if (this.f13917e0 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.m3_searchbar_margin_vertical);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = S(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = S(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = S(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = S(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void Y() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.f13926n0) {
                if (layoutParams.c() == 0) {
                    layoutParams.g(53);
                }
            } else if (layoutParams.c() == 53) {
                layoutParams.g(0);
            }
        }
    }

    private void setNavigationIconDecorative(boolean z7) {
        Drawable drawable;
        ImageButton c8 = ToolbarUtils.c(this);
        if (c8 == null) {
            return;
        }
        c8.setClickable(!z7);
        c8.setFocusable(!z7);
        Drawable background = c8.getBackground();
        if (background != null) {
            this.f13924l0 = background;
        }
        if (z7) {
            drawable = null;
        } else {
            drawable = this.f13924l0;
        }
        c8.setBackgroundDrawable(drawable);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (this.f13916d0 && this.f13922j0 == null && !(view instanceof ActionMenuView)) {
            this.f13922j0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i8, layoutParams);
    }

    public View getCenterView() {
        return this.f13922j0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCompatElevation() {
        MaterialShapeDrawable materialShapeDrawable = this.f13927o0;
        if (materialShapeDrawable != null) {
            return materialShapeDrawable.w();
        }
        return ViewCompat.y(this);
    }

    public float getCornerSize() {
        return this.f13927o0.K();
    }

    public CharSequence getHint() {
        return this.f13915c0.getHint();
    }

    int getMenuResId() {
        return this.f13925m0;
    }

    public int getStrokeColor() {
        return this.f13927o0.G().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f13927o0.I();
    }

    public CharSequence getText() {
        return this.f13915c0.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.f13915c0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.f13927o0);
        X();
        Y();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i8, int i9, int i10, int i11) {
        super.onLayout(z7, i8, i9, i10, i11);
        T();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        W(i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setText(savedState.f13928h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        String charSequence;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        savedState.f13928h = charSequence;
        return savedState;
    }

    public void setCenterView(View view) {
        View view2 = this.f13922j0;
        if (view2 != null) {
            removeView(view2);
            this.f13922j0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z7) {
        this.f13926n0 = z7;
        Y();
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        MaterialShapeDrawable materialShapeDrawable = this.f13927o0;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.b0(f8);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f13915c0.setHint(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(V(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        boolean z7;
        if (this.f13921i0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        if (onClickListener == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        setNavigationIconDecorative(z7);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z7) {
        this.f13918f0.a(z7);
    }

    public void setStrokeColor(int i8) {
        if (getStrokeColor() != i8) {
            this.f13927o0.m0(ColorStateList.valueOf(i8));
        }
    }

    public void setStrokeWidth(float f8) {
        if (getStrokeWidth() != f8) {
            this.f13927o0.n0(f8);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(CharSequence charSequence) {
        this.f13915c0.setText(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i8) {
        super.x(i8);
        this.f13925m0 = i8;
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: h  reason: collision with root package name */
        private boolean f13929h;

        public ScrollingViewBehavior() {
            this.f13929h = false;
        }

        private void U(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            if (Build.VERSION.SDK_INT == 21) {
                appBarLayout.setOutlineProvider(null);
            } else {
                appBarLayout.setTargetElevation(0.0f);
            }
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        protected boolean P() {
            return true;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            boolean h8 = super.h(coordinatorLayout, view, view2);
            if (!this.f13929h && (view2 instanceof AppBarLayout)) {
                this.f13929h = true;
                U((AppBarLayout) view2);
            }
            return h8;
        }

        public ScrollingViewBehavior(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13929h = false;
        }
    }

    public void setHint(int i8) {
        this.f13915c0.setHint(i8);
    }

    public void setText(int i8) {
        this.f13915c0.setText(i8);
    }
}
