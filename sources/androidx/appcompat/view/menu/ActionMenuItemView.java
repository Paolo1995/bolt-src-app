package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;
import org.jctools.util.Pow2;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {

    /* renamed from: f  reason: collision with root package name */
    MenuItemImpl f1517f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f1518g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f1519h;

    /* renamed from: i  reason: collision with root package name */
    MenuBuilder.ItemInvoker f1520i;

    /* renamed from: j  reason: collision with root package name */
    private ForwardingListener f1521j;

    /* renamed from: k  reason: collision with root package name */
    PopupCallback f1522k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1523l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1524m;

    /* renamed from: n  reason: collision with root package name */
    private int f1525n;

    /* renamed from: o  reason: collision with root package name */
    private int f1526o;

    /* renamed from: p  reason: collision with root package name */
    private int f1527p;

    /* loaded from: classes.dex */
    private class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu b() {
            PopupCallback popupCallback = ActionMenuItemView.this.f1522k;
            if (popupCallback != null) {
                return popupCallback.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean c() {
            ShowableListMenu b8;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.f1520i;
            if (itemInvoker == null || !itemInvoker.b(actionMenuItemView.f1517f) || (b8 = b()) == null || !b8.c()) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PopupCallback {
        public abstract ShowableListMenu a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i8 = configuration.screenWidthDp;
        int i9 = configuration.screenHeightDp;
        if (i8 < 480 && ((i8 < 640 || i9 < 480) && configuration.orientation != 2)) {
            return false;
        }
        return true;
    }

    private void g() {
        CharSequence charSequence;
        CharSequence title;
        boolean z7 = true;
        boolean z8 = !TextUtils.isEmpty(this.f1518g);
        if (this.f1519h != null && (!this.f1517f.B() || (!this.f1523l && !this.f1524m))) {
            z7 = false;
        }
        boolean z9 = z8 & z7;
        CharSequence charSequence2 = null;
        if (z9) {
            charSequence = this.f1518g;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f1517f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z9) {
                title = null;
            } else {
                title = this.f1517f.getTitle();
            }
            setContentDescription(title);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1517f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z9) {
                charSequence2 = this.f1517f.getTitle();
            }
            TooltipCompat.a(this, charSequence2);
            return;
        }
        TooltipCompat.a(this, tooltipText);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean a() {
        return e();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean b() {
        if (e() && this.f1517f.getIcon() == null) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(MenuItemImpl menuItemImpl, int i8) {
        int i9;
        this.f1517f = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.i(this));
        setId(menuItemImpl.getItemId());
        if (menuItemImpl.isVisible()) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        setVisibility(i9);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f1521j == null) {
            this.f1521j = new ActionMenuItemForwardingListener();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return true;
    }

    public boolean e() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f1517f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.f1520i;
        if (itemInvoker != null) {
            itemInvoker.b(this.f1517f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1523l = f();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        int i10;
        int i11;
        boolean e8 = e();
        if (e8 && (i11 = this.f1526o) >= 0) {
            super.setPadding(i11, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i10 = Math.min(size, this.f1525n);
        } else {
            i10 = this.f1525n;
        }
        if (mode != 1073741824 && this.f1525n > 0 && measuredWidth < i10) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10, Pow2.MAX_POW2), i9);
        }
        if (!e8 && this.f1519h != null) {
            super.setPadding((getMeasuredWidth() - this.f1519h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.f1517f.hasSubMenu() && (forwardingListener = this.f1521j) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z7) {
    }

    public void setChecked(boolean z7) {
    }

    public void setExpandedFormat(boolean z7) {
        if (this.f1524m != z7) {
            this.f1524m = z7;
            MenuItemImpl menuItemImpl = this.f1517f;
            if (menuItemImpl != null) {
                menuItemImpl.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1519h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i8 = this.f1527p;
            if (intrinsicWidth > i8) {
                intrinsicHeight = (int) (intrinsicHeight * (i8 / intrinsicWidth));
                intrinsicWidth = i8;
            }
            if (intrinsicHeight > i8) {
                intrinsicWidth = (int) (intrinsicWidth * (i8 / intrinsicHeight));
            } else {
                i8 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i8);
        }
        setCompoundDrawables(drawable, null, null, null);
        g();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f1520i = itemInvoker;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i8, int i9, int i10, int i11) {
        this.f1526o = i8;
        super.setPadding(i8, i9, i10, i11);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f1522k = popupCallback;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1518g = charSequence;
        g();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Resources resources = context.getResources();
        this.f1523l = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1061v, i8, 0);
        this.f1525n = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f1066w, 0);
        obtainStyledAttributes.recycle();
        this.f1527p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1526o = -1;
        setSaveEnabled(false);
    }
}
