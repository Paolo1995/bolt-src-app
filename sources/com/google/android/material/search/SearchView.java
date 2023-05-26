package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.shape.MaterialShapeUtils;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: z  reason: collision with root package name */
    private static final int f13935z = R$style.Widget_Material3_SearchView;

    /* renamed from: f  reason: collision with root package name */
    final ClippableRoundedCornerLayout f13936f;

    /* renamed from: g  reason: collision with root package name */
    final View f13937g;

    /* renamed from: h  reason: collision with root package name */
    final View f13938h;

    /* renamed from: i  reason: collision with root package name */
    final FrameLayout f13939i;

    /* renamed from: j  reason: collision with root package name */
    final MaterialToolbar f13940j;

    /* renamed from: k  reason: collision with root package name */
    final TextView f13941k;

    /* renamed from: l  reason: collision with root package name */
    final EditText f13942l;

    /* renamed from: m  reason: collision with root package name */
    final TouchObserverFrameLayout f13943m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f13944n;

    /* renamed from: o  reason: collision with root package name */
    private final ElevationOverlayProvider f13945o;

    /* renamed from: p  reason: collision with root package name */
    private final Set<TransitionListener> f13946p;

    /* renamed from: q  reason: collision with root package name */
    private SearchBar f13947q;

    /* renamed from: r  reason: collision with root package name */
    private int f13948r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13949s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f13950t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f13951u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f13952v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f13953w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    private TransitionState f13954x;

    /* renamed from: y  reason: collision with root package name */
    private Map<View, Integer> f13955y;

    /* loaded from: classes.dex */
    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: E */
        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SearchView searchView, @NonNull View view) {
            if (!searchView.b() && (view instanceof SearchBar)) {
                searchView.setupWithSearchBar((SearchBar) view);
                return false;
            }
            return false;
        }

        public Behavior(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.search.SearchView.SavedState.1
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
        String f13956h;

        /* renamed from: i  reason: collision with root package name */
        int f13957i;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i8) {
            super.writeToParcel(parcel, i8);
            parcel.writeString(this.f13956h);
            parcel.writeInt(this.f13957i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13956h = parcel.readString();
            this.f13957i = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void a(@NonNull SearchView searchView, @NonNull TransitionState transitionState, @NonNull TransitionState transitionState2);
    }

    /* loaded from: classes.dex */
    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    @SuppressLint({"InlinedApi"})
    private void c(ViewGroup viewGroup, boolean z7) {
        for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
            View childAt = viewGroup.getChildAt(i8);
            if (childAt != this) {
                if (childAt.findViewById(this.f13936f.getId()) != null) {
                    c((ViewGroup) childAt, z7);
                } else if (!z7) {
                    Map<View, Integer> map = this.f13955y;
                    if (map != null && map.containsKey(childAt)) {
                        ViewCompat.D0(childAt, this.f13955y.get(childAt).intValue());
                    }
                } else {
                    this.f13955y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    ViewCompat.D0(childAt, 4);
                }
            }
        }
    }

    private void d() {
        int i8;
        ImageButton c8 = ToolbarUtils.c(this.f13940j);
        if (c8 == null) {
            return;
        }
        if (this.f13936f.getVisibility() == 0) {
            i8 = 1;
        } else {
            i8 = 0;
        }
        Drawable q8 = DrawableCompat.q(c8.getDrawable());
        if (q8 instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) q8).b(i8);
        }
        if (q8 instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) q8).a(i8);
        }
    }

    private Window getActivityWindow() {
        Activity a8 = ContextUtils.a(getContext());
        if (a8 == null) {
            return null;
        }
        return a8.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.f13947q;
        if (searchBar != null) {
            return searchBar.getCompatElevation();
        }
        return getResources().getDimension(R$dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z7) {
        int i8;
        View view = this.f13938h;
        if (z7) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        view.setVisibility(i8);
    }

    private void setUpBackgroundViewElevationOverlay(float f8) {
        ElevationOverlayProvider elevationOverlayProvider = this.f13945o;
        if (elevationOverlayProvider != null && this.f13937g != null) {
            this.f13937g.setBackgroundColor(elevationOverlayProvider.d(f8));
        }
    }

    private void setUpHeaderLayout(int i8) {
        if (i8 != -1) {
            a(LayoutInflater.from(getContext()).inflate(i8, (ViewGroup) this.f13939i, false));
        }
    }

    private void setUpStatusBarSpacer(int i8) {
        if (this.f13938h.getLayoutParams().height != i8) {
            this.f13938h.getLayoutParams().height = i8;
            this.f13938h.requestLayout();
        }
    }

    public void a(@NonNull View view) {
        this.f13939i.addView(view);
        this.f13939i.setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        if (this.f13944n) {
            this.f13943m.addView(view, i8, layoutParams);
        } else {
            super.addView(view, i8, layoutParams);
        }
    }

    public boolean b() {
        if (this.f13947q != null) {
            return true;
        }
        return false;
    }

    public void e() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f13948r = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.f13954x;
    }

    @NonNull
    public EditText getEditText() {
        return this.f13942l;
    }

    public CharSequence getHint() {
        return this.f13942l.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.f13941k;
    }

    public CharSequence getSearchPrefixText() {
        return this.f13941k.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f13948r;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f13942l.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.f13940j;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        e();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        boolean z7;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setText(savedState.f13956h);
        if (savedState.f13957i == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        setVisible(z7);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        String charSequence;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        if (text == null) {
            charSequence = null;
        } else {
            charSequence = text.toString();
        }
        savedState.f13956h = charSequence;
        savedState.f13957i = this.f13936f.getVisibility();
        return savedState;
    }

    public void setAnimatedNavigationIcon(boolean z7) {
        this.f13949s = z7;
    }

    public void setAutoShowKeyboard(boolean z7) {
        this.f13951u = z7;
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        setUpBackgroundViewElevationOverlay(f8);
    }

    public void setHint(CharSequence charSequence) {
        this.f13942l.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z7) {
        this.f13950t = z7;
    }

    public void setModalForAccessibility(boolean z7) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z7) {
            this.f13955y = new HashMap(viewGroup.getChildCount());
        }
        c(viewGroup, z7);
        if (!z7) {
            this.f13955y = null;
        }
    }

    public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.f13940j.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        int i8;
        this.f13941k.setText(charSequence);
        TextView textView = this.f13941k;
        if (TextUtils.isEmpty(charSequence)) {
            i8 = 8;
        } else {
            i8 = 0;
        }
        textView.setVisibility(i8);
    }

    public void setStatusBarSpacerEnabled(boolean z7) {
        this.f13953w = true;
        setStatusBarSpacerEnabledInternal(z7);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        this.f13942l.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z7) {
        this.f13940j.setTouchscreenBlocksFocus(z7);
    }

    void setTransitionState(@NonNull TransitionState transitionState) {
        if (this.f13954x.equals(transitionState)) {
            return;
        }
        TransitionState transitionState2 = this.f13954x;
        this.f13954x = transitionState;
        for (TransitionListener transitionListener : new LinkedHashSet(this.f13946p)) {
            transitionListener.a(this, transitionState2, transitionState);
        }
    }

    public void setUseWindowInsetsController(boolean z7) {
        this.f13952v = z7;
    }

    public void setVisible(boolean z7) {
        boolean z8;
        TransitionState transitionState;
        int i8 = 0;
        if (this.f13936f.getVisibility() == 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f13936f;
        if (!z7) {
            i8 = 8;
        }
        clippableRoundedCornerLayout.setVisibility(i8);
        d();
        if (z8 != z7) {
            setModalForAccessibility(z7);
        }
        if (z7) {
            transitionState = TransitionState.SHOWN;
        } else {
            transitionState = TransitionState.HIDDEN;
        }
        setTransitionState(transitionState);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.f13947q = searchBar;
        throw null;
    }

    public void setHint(int i8) {
        this.f13942l.setHint(i8);
    }

    public void setText(int i8) {
        this.f13942l.setText(i8);
    }
}
