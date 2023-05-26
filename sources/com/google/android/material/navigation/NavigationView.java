package com.google.android.material.navigation;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R$style;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: x  reason: collision with root package name */
    private static final int[] f13747x = {16842912};

    /* renamed from: y  reason: collision with root package name */
    private static final int[] f13748y = {-16842910};

    /* renamed from: z  reason: collision with root package name */
    private static final int f13749z = R$style.Widget_Design_NavigationView;

    /* renamed from: m  reason: collision with root package name */
    private final NavigationMenuPresenter f13750m;

    /* renamed from: n  reason: collision with root package name */
    OnNavigationItemSelectedListener f13751n;

    /* renamed from: o  reason: collision with root package name */
    private final int f13752o;

    /* renamed from: p  reason: collision with root package name */
    private MenuInflater f13753p;

    /* renamed from: q  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f13754q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13755r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13756s;

    /* renamed from: t  reason: collision with root package name */
    private int f13757t;

    /* renamed from: u  reason: collision with root package name */
    private int f13758u;

    /* renamed from: v  reason: collision with root package name */
    private Path f13759v;

    /* renamed from: w  reason: collision with root package name */
    private final RectF f13760w;

    /* loaded from: classes.dex */
    public interface OnNavigationItemSelectedListener {
    }

    private void a(int i8, int i9) {
        if ((getParent() instanceof DrawerLayout) && this.f13758u > 0 && (getBackground() instanceof MaterialShapeDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
            ShapeAppearanceModel.Builder v7 = materialShapeDrawable.F().v();
            if (GravityCompat.b(this.f13757t, ViewCompat.E(this)) == 3) {
                v7.E(this.f13758u);
                v7.w(this.f13758u);
            } else {
                v7.A(this.f13758u);
                v7.s(this.f13758u);
            }
            materialShapeDrawable.setShapeAppearanceModel(v7.m());
            if (this.f13759v == null) {
                this.f13759v = new Path();
            }
            this.f13759v.reset();
            this.f13760w.set(0.0f, 0.0f, i8, i9);
            ShapeAppearancePathProvider.k().d(materialShapeDrawable.F(), materialShapeDrawable.y(), this.f13760w, this.f13759v);
            invalidate();
            return;
        }
        this.f13759v = null;
        this.f13760w.setEmpty();
    }

    private MenuInflater getMenuInflater() {
        if (this.f13753p == null) {
            this.f13753p = new SupportMenuInflater(getContext());
        }
        return this.f13753p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        if (this.f13759v == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.f13759v);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public MenuItem getCheckedItem() {
        return this.f13750m.c();
    }

    public int getDividerInsetEnd() {
        return this.f13750m.k();
    }

    public int getDividerInsetStart() {
        return this.f13750m.l();
    }

    public int getHeaderCount() {
        return this.f13750m.m();
    }

    public Drawable getItemBackground() {
        return this.f13750m.n();
    }

    public int getItemHorizontalPadding() {
        return this.f13750m.o();
    }

    public int getItemIconPadding() {
        return this.f13750m.p();
    }

    public ColorStateList getItemIconTintList() {
        return this.f13750m.s();
    }

    public int getItemMaxLines() {
        return this.f13750m.q();
    }

    public ColorStateList getItemTextColor() {
        return this.f13750m.r();
    }

    public int getItemVerticalPadding() {
        return this.f13750m.t();
    }

    @NonNull
    public Menu getMenu() {
        return null;
    }

    public int getSubheaderInsetEnd() {
        return this.f13750m.u();
    }

    public int getSubheaderInsetStart() {
        return this.f13750m.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f13754q);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        int mode = View.MeasureSpec.getMode(i8);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i8 = View.MeasureSpec.makeMeasureSpec(this.f13752o, Pow2.MAX_POW2);
            }
        } else {
            i8 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i8), this.f13752o), Pow2.MAX_POW2);
        }
        super.onMeasure(i8, i9);
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
    protected Parcelable onSaveInstanceState() {
        new SavedState(super.onSaveInstanceState()).f13761h = new Bundle();
        throw null;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        a(i8, i9);
    }

    public void setBottomInsetScrimEnabled(boolean z7) {
        this.f13756s = z7;
    }

    public void setCheckedItem(int i8) {
        throw null;
    }

    public void setDividerInsetEnd(int i8) {
        this.f13750m.w(i8);
    }

    public void setDividerInsetStart(int i8) {
        this.f13750m.x(i8);
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        MaterialShapeUtils.d(this, f8);
    }

    public void setItemBackground(Drawable drawable) {
        this.f13750m.y(drawable);
    }

    public void setItemBackgroundResource(int i8) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i8));
    }

    public void setItemHorizontalPadding(int i8) {
        this.f13750m.z(i8);
    }

    public void setItemHorizontalPaddingResource(int i8) {
        this.f13750m.z(getResources().getDimensionPixelSize(i8));
    }

    public void setItemIconPadding(int i8) {
        this.f13750m.A(i8);
    }

    public void setItemIconPaddingResource(int i8) {
        this.f13750m.A(getResources().getDimensionPixelSize(i8));
    }

    public void setItemIconSize(int i8) {
        this.f13750m.B(i8);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f13750m.C(colorStateList);
    }

    public void setItemMaxLines(int i8) {
        this.f13750m.D(i8);
    }

    public void setItemTextAppearance(int i8) {
        this.f13750m.E(i8);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f13750m.F(colorStateList);
    }

    public void setItemVerticalPadding(int i8) {
        this.f13750m.G(i8);
    }

    public void setItemVerticalPaddingResource(int i8) {
        this.f13750m.G(getResources().getDimensionPixelSize(i8));
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f13751n = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i8) {
        super.setOverScrollMode(i8);
        NavigationMenuPresenter navigationMenuPresenter = this.f13750m;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.H(i8);
        }
    }

    public void setSubheaderInsetEnd(int i8) {
        this.f13750m.I(i8);
    }

    public void setSubheaderInsetStart(int i8) {
        this.f13750m.J(i8);
    }

    public void setTopInsetScrimEnabled(boolean z7) {
        this.f13755r = z7;
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
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
        public Bundle f13761h;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13761h = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeBundle(this.f13761h);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        menuItem.getItemId();
        throw null;
    }
}
