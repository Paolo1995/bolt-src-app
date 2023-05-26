package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] K = {16842912};
    private int A;
    private boolean B;
    boolean C;
    private final CheckedTextView D;
    private FrameLayout E;
    private MenuItemImpl F;
    private ColorStateList G;
    private boolean H;
    private Drawable I;
    private final AccessibilityDelegateCompat J;

    public NavigationMenuItemView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private StateListDrawable A() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(R$attr.f837w, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(K, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private boolean C() {
        if (this.F.getTitle() == null && this.F.getIcon() == null && this.F.getActionView() != null) {
            return true;
        }
        return false;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.E == null) {
                this.E = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.E.removeAllViews();
            this.E.addView(view);
        }
    }

    private void z() {
        if (C()) {
            this.D.setVisibility(8);
            FrameLayout frameLayout = this.E;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.E.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.D.setVisibility(0);
        FrameLayout frameLayout2 = this.E;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.E.setLayoutParams(layoutParams2);
        }
    }

    public void B() {
        FrameLayout frameLayout = this.E;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.D.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(@NonNull MenuItemImpl menuItemImpl, int i8) {
        int i9;
        this.F = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        if (menuItemImpl.isVisible()) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        setVisibility(i9);
        if (getBackground() == null) {
            ViewCompat.w0(this, A());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.a(this, menuItemImpl.getTooltipText());
        z();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.F;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i8 + 1);
        MenuItemImpl menuItemImpl = this.F;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.F.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, K);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z7) {
        refreshDrawableState();
        if (this.C != z7) {
            this.C = z7;
            this.J.l(this.D, 2048);
        }
    }

    public void setChecked(boolean z7) {
        refreshDrawableState();
        this.D.setChecked(z7);
        CheckedTextView checkedTextView = this.D;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), z7 ? 1 : 0);
    }

    public void setHorizontalPadding(int i8) {
        setPadding(i8, getPaddingTop(), i8, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.H) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.r(drawable).mutate();
                DrawableCompat.o(drawable, this.G);
            }
            int i8 = this.A;
            drawable.setBounds(0, 0, i8, i8);
        } else if (this.B) {
            if (this.I == null) {
                Drawable f8 = ResourcesCompat.f(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                this.I = f8;
                if (f8 != null) {
                    int i9 = this.A;
                    f8.setBounds(0, 0, i9, i9);
                }
            }
            drawable = this.I;
        }
        TextViewCompat.j(this.D, drawable, null, null, null);
    }

    public void setIconPadding(int i8) {
        this.D.setCompoundDrawablePadding(i8);
    }

    public void setIconSize(int i8) {
        this.A = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        boolean z7;
        this.G = colorStateList;
        if (colorStateList != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.H = z7;
        MenuItemImpl menuItemImpl = this.F;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i8) {
        this.D.setMaxLines(i8);
    }

    public void setNeedsEmptyIcon(boolean z7) {
        this.B = z7;
    }

    public void setTextAppearance(int i8) {
        TextViewCompat.o(this.D, i8);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.D.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.D.setText(charSequence);
    }

    public NavigationMenuItemView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        AccessibilityDelegateCompat accessibilityDelegateCompat = new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.W(NavigationMenuItemView.this.C);
            }
        };
        this.J = accessibilityDelegateCompat;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.D = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.s0(checkedTextView, accessibilityDelegateCompat);
    }
}
