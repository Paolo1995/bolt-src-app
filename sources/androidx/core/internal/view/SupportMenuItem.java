package androidx.core.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public interface SupportMenuItem extends MenuItem {
    ActionProvider a();

    @NonNull
    SupportMenuItem b(ActionProvider actionProvider);

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setActionView(int i8);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setAlphabeticShortcut(char c8, int i8);

    @Override // android.view.MenuItem
    @NonNull
    SupportMenuItem setContentDescription(CharSequence charSequence);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setNumericShortcut(char c8, int i8);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setShortcut(char c8, char c9, int i8, int i9);

    @Override // android.view.MenuItem
    void setShowAsAction(int i8);

    @Override // android.view.MenuItem
    @NonNull
    MenuItem setShowAsActionFlags(int i8);

    @Override // android.view.MenuItem
    @NonNull
    SupportMenuItem setTooltipText(CharSequence charSequence);
}
