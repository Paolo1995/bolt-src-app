package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: f  reason: collision with root package name */
    private MenuItemImpl f1575f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f1576g;

    /* renamed from: h  reason: collision with root package name */
    private RadioButton f1577h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f1578i;

    /* renamed from: j  reason: collision with root package name */
    private CheckBox f1579j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f1580k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f1581l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f1582m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f1583n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f1584o;

    /* renamed from: p  reason: collision with root package name */
    private int f1585p;

    /* renamed from: q  reason: collision with root package name */
    private Context f1586q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1587r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f1588s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1589t;

    /* renamed from: u  reason: collision with root package name */
    private LayoutInflater f1590u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f1591v;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.D);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i8) {
        LinearLayout linearLayout = this.f1583n;
        if (linearLayout != null) {
            linearLayout.addView(view, i8);
        } else {
            addView(view, i8);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.f924h, (ViewGroup) this, false);
        this.f1579j = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.f925i, (ViewGroup) this, false);
        this.f1576g = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.f927k, (ViewGroup) this, false);
        this.f1577h = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f1590u == null) {
            this.f1590u = LayoutInflater.from(getContext());
        }
        return this.f1590u;
    }

    private void setSubMenuArrowVisible(boolean z7) {
        int i8;
        ImageView imageView = this.f1581l;
        if (imageView != null) {
            if (z7) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            imageView.setVisibility(i8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1582m;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1582m.getLayoutParams();
            rect.top += this.f1582m.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void c(MenuItemImpl menuItemImpl, int i8) {
        int i9;
        this.f1575f = menuItemImpl;
        if (menuItemImpl.isVisible()) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        setVisibility(i9);
        setTitle(menuItemImpl.i(this));
        setCheckable(menuItemImpl.isCheckable());
        h(menuItemImpl.A(), menuItemImpl.g());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f1575f;
    }

    public void h(boolean z7, char c8) {
        int i8;
        if (z7 && this.f1575f.A()) {
            i8 = 0;
        } else {
            i8 = 8;
        }
        if (i8 == 0) {
            this.f1580k.setText(this.f1575f.h());
        }
        if (this.f1580k.getVisibility() != i8) {
            this.f1580k.setVisibility(i8);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.w0(this, this.f1584o);
        TextView textView = (TextView) findViewById(R$id.M);
        this.f1578i = textView;
        int i8 = this.f1585p;
        if (i8 != -1) {
            textView.setTextAppearance(this.f1586q, i8);
        }
        this.f1580k = (TextView) findViewById(R$id.F);
        ImageView imageView = (ImageView) findViewById(R$id.I);
        this.f1581l = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1588s);
        }
        this.f1582m = (ImageView) findViewById(R$id.f908r);
        this.f1583n = (LinearLayout) findViewById(R$id.f902l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i8, int i9) {
        if (this.f1576g != null && this.f1587r) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1576g.getLayoutParams();
            int i10 = layoutParams.height;
            if (i10 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i10;
            }
        }
        super.onMeasure(i8, i9);
    }

    public void setCheckable(boolean z7) {
        CompoundButton compoundButton;
        View view;
        if (!z7 && this.f1577h == null && this.f1579j == null) {
            return;
        }
        if (this.f1575f.m()) {
            if (this.f1577h == null) {
                g();
            }
            compoundButton = this.f1577h;
            view = this.f1579j;
        } else {
            if (this.f1579j == null) {
                e();
            }
            compoundButton = this.f1579j;
            view = this.f1577h;
        }
        if (z7) {
            compoundButton.setChecked(this.f1575f.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view != null && view.getVisibility() != 8) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox = this.f1579j;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1577h;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z7) {
        CompoundButton compoundButton;
        if (this.f1575f.m()) {
            if (this.f1577h == null) {
                g();
            }
            compoundButton = this.f1577h;
        } else {
            if (this.f1579j == null) {
                e();
            }
            compoundButton = this.f1579j;
        }
        compoundButton.setChecked(z7);
    }

    public void setForceShowIcon(boolean z7) {
        this.f1591v = z7;
        this.f1587r = z7;
    }

    public void setGroupDividerEnabled(boolean z7) {
        int i8;
        ImageView imageView = this.f1582m;
        if (imageView != null) {
            if (!this.f1589t && z7) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            imageView.setVisibility(i8);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z7;
        if (!this.f1575f.z() && !this.f1591v) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7 && !this.f1587r) {
            return;
        }
        ImageView imageView = this.f1576g;
        if (imageView == null && drawable == null && !this.f1587r) {
            return;
        }
        if (imageView == null) {
            f();
        }
        if (drawable == null && !this.f1587r) {
            this.f1576g.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.f1576g;
        if (!z7) {
            drawable = null;
        }
        imageView2.setImageDrawable(drawable);
        if (this.f1576g.getVisibility() != 0) {
            this.f1576g.setVisibility(0);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1578i.setText(charSequence);
            if (this.f1578i.getVisibility() != 0) {
                this.f1578i.setVisibility(0);
            }
        } else if (this.f1578i.getVisibility() != 8) {
            this.f1578i.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet);
        TintTypedArray v7 = TintTypedArray.v(getContext(), attributeSet, R$styleable.T1, i8, 0);
        this.f1584o = v7.g(R$styleable.V1);
        this.f1585p = v7.n(R$styleable.U1, -1);
        this.f1587r = v7.a(R$styleable.W1, false);
        this.f1586q = context;
        this.f1588s = v7.g(R$styleable.X1);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R$attr.A, 0);
        this.f1589t = obtainStyledAttributes.hasValue(0);
        v7.w();
        obtainStyledAttributes.recycle();
    }
}
