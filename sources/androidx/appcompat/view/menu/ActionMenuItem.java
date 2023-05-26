package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

/* loaded from: classes.dex */
public class ActionMenuItem implements SupportMenuItem {

    /* renamed from: a  reason: collision with root package name */
    private final int f1497a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1498b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1499c;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f1500d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f1501e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f1502f;

    /* renamed from: g  reason: collision with root package name */
    private char f1503g;

    /* renamed from: i  reason: collision with root package name */
    private char f1505i;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f1507k;

    /* renamed from: l  reason: collision with root package name */
    private Context f1508l;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f1509m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f1510n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f1511o;

    /* renamed from: h  reason: collision with root package name */
    private int f1504h = 4096;

    /* renamed from: j  reason: collision with root package name */
    private int f1506j = 4096;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f1512p = null;

    /* renamed from: q  reason: collision with root package name */
    private PorterDuff.Mode f1513q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1514r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1515s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f1516t = 16;

    public ActionMenuItem(Context context, int i8, int i9, int i10, int i11, CharSequence charSequence) {
        this.f1508l = context;
        this.f1497a = i9;
        this.f1498b = i8;
        this.f1499c = i11;
        this.f1500d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f1507k;
        if (drawable != null) {
            if (this.f1514r || this.f1515s) {
                Drawable r7 = DrawableCompat.r(drawable);
                this.f1507k = r7;
                Drawable mutate = r7.mutate();
                this.f1507k = mutate;
                if (this.f1514r) {
                    DrawableCompat.o(mutate, this.f1512p);
                }
                if (this.f1515s) {
                    DrawableCompat.p(this.f1507k, this.f1513q);
                }
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ActionProvider a() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    @NonNull
    public SupportMenuItem b(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    /* renamed from: d */
    public SupportMenuItem setActionView(int i8) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    /* renamed from: e */
    public SupportMenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    /* renamed from: f */
    public SupportMenuItem setShowAsActionFlags(int i8) {
        setShowAsAction(i8);
        return this;
    }

    @Override // android.view.MenuItem
    public android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1506j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1505i;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1510n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1498b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1507k;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1512p;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1513q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1502f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1497a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1504h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1503g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1499c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1500d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1501e;
        if (charSequence == null) {
            return this.f1500d;
        }
        return charSequence;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1511o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f1516t & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f1516t & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f1516t & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.f1516t & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c8) {
        this.f1505i = Character.toLowerCase(c8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z7) {
        this.f1516t = (z7 ? 1 : 0) | (this.f1516t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z7) {
        int i8;
        int i9 = this.f1516t & (-3);
        if (z7) {
            i8 = 2;
        } else {
            i8 = 0;
        }
        this.f1516t = i8 | i9;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z7) {
        int i8;
        int i9 = this.f1516t & (-17);
        if (z7) {
            i8 = 16;
        } else {
            i8 = 0;
        }
        this.f1516t = i8 | i9;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1507k = drawable;
        c();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1512p = colorStateList;
        this.f1514r = true;
        c();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1513q = mode;
        this.f1515s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1502f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c8) {
        this.f1503g = c8;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1509m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c8, char c9) {
        this.f1503g = c8;
        this.f1505i = Character.toLowerCase(c9);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public void setShowAsAction(int i8) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1500d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1501e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z7) {
        int i8 = 8;
        int i9 = this.f1516t & 8;
        if (z7) {
            i8 = 0;
        }
        this.f1516t = i9 | i8;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setAlphabeticShortcut(char c8, int i8) {
        this.f1505i = Character.toLowerCase(c8);
        this.f1506j = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.f1510n = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setNumericShortcut(char c8, int i8) {
        this.f1503g = c8;
        this.f1504h = KeyEvent.normalizeMetaState(i8);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i8) {
        this.f1500d = this.f1508l.getResources().getString(i8);
        return this;
    }

    @Override // android.view.MenuItem
    @NonNull
    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.f1511o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i8) {
        this.f1507k = ContextCompat.getDrawable(this.f1508l, i8);
        c();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    @NonNull
    public MenuItem setShortcut(char c8, char c9, int i8, int i9) {
        this.f1503g = c8;
        this.f1504h = KeyEvent.normalizeMetaState(i8);
        this.f1505i = Character.toLowerCase(c9);
        this.f1506j = KeyEvent.normalizeMetaState(i9);
        return this;
    }
}
