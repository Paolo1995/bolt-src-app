package com.google.android.material.navigation;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuView;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final NavigationBarMenuView f13741f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final NavigationBarPresenter f13742g;

    /* renamed from: h  reason: collision with root package name */
    private MenuInflater f13743h;

    /* renamed from: i  reason: collision with root package name */
    private OnItemSelectedListener f13744i;

    /* renamed from: j  reason: collision with root package name */
    private OnItemReselectedListener f13745j;

    /* loaded from: classes.dex */
    public interface OnItemReselectedListener {
    }

    /* loaded from: classes.dex */
    public interface OnItemSelectedListener {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationBarView.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i8) {
                return new SavedState[i8];
            }
        };

        /* renamed from: h  reason: collision with root package name */
        Bundle f13746h;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.f13746h = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeBundle(this.f13746h);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.f13743h == null) {
            this.f13743h = new SupportMenuInflater(getContext());
        }
        return this.f13743h;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f13741f.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f13741f.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f13741f.getItemActiveIndicatorMarginHorizontal();
    }

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.f13741f.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f13741f.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f13741f.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f13741f.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f13741f.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f13741f.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f13741f.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f13741f.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f13741f.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f13741f.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f13741f.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f13741f.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f13741f.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return null;
    }

    @NonNull
    public MenuView getMenuView() {
        return this.f13741f;
    }

    @NonNull
    public NavigationBarPresenter getPresenter() {
        return this.f13742g;
    }

    public int getSelectedItemId() {
        return this.f13741f.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
        } else {
            super.onRestoreInstanceState(((SavedState) parcelable).a());
            throw null;
        }
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        new SavedState(super.onSaveInstanceState()).f13746h = new Bundle();
        throw null;
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        MaterialShapeUtils.d(this, f8);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f13741f.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z7) {
        this.f13741f.setItemActiveIndicatorEnabled(z7);
    }

    public void setItemActiveIndicatorHeight(int i8) {
        this.f13741f.setItemActiveIndicatorHeight(i8);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i8) {
        this.f13741f.setItemActiveIndicatorMarginHorizontal(i8);
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.f13741f.setItemActiveIndicatorShapeAppearance(shapeAppearanceModel);
    }

    public void setItemActiveIndicatorWidth(int i8) {
        this.f13741f.setItemActiveIndicatorWidth(i8);
    }

    public void setItemBackground(Drawable drawable) {
        this.f13741f.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i8) {
        this.f13741f.setItemBackgroundRes(i8);
    }

    public void setItemIconSize(int i8) {
        this.f13741f.setItemIconSize(i8);
    }

    public void setItemIconSizeRes(int i8) {
        setItemIconSize(getResources().getDimensionPixelSize(i8));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f13741f.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i8) {
        this.f13741f.setItemPaddingBottom(i8);
    }

    public void setItemPaddingTop(int i8) {
        this.f13741f.setItemPaddingTop(i8);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f13741f.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i8) {
        this.f13741f.setItemTextAppearanceActive(i8);
    }

    public void setItemTextAppearanceInactive(int i8) {
        this.f13741f.setItemTextAppearanceInactive(i8);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13741f.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i8) {
        if (this.f13741f.getLabelVisibilityMode() != i8) {
            this.f13741f.setLabelVisibilityMode(i8);
            this.f13742g.g(false);
        }
    }

    public void setOnItemReselectedListener(OnItemReselectedListener onItemReselectedListener) {
        this.f13745j = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f13744i = onItemSelectedListener;
    }

    public void setSelectedItemId(int i8) {
        throw null;
    }
}
