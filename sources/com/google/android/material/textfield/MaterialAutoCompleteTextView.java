package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ListPopupWindow f14387j;

    /* renamed from: k  reason: collision with root package name */
    private final AccessibilityManager f14388k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final Rect f14389l;

    /* renamed from: m  reason: collision with root package name */
    private final int f14390m;

    /* renamed from: n  reason: collision with root package name */
    private final float f14391n;

    /* renamed from: o  reason: collision with root package name */
    private int f14392o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f14393p;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MaterialArrayAdapter<T> extends ArrayAdapter<String> {

        /* renamed from: f  reason: collision with root package name */
        private ColorStateList f14395f;

        /* renamed from: g  reason: collision with root package name */
        private ColorStateList f14396g;

        MaterialArrayAdapter(@NonNull Context context, int i8, @NonNull String[] strArr) {
            super(context, i8, strArr);
            f();
        }

        private ColorStateList a() {
            if (c() && d()) {
                int[] iArr = {16843623, -16842919};
                int[] iArr2 = {16842913, -16842919};
                return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{MaterialColors.i(MaterialAutoCompleteTextView.this.f14392o, MaterialAutoCompleteTextView.this.f14393p.getColorForState(iArr2, 0)), MaterialColors.i(MaterialAutoCompleteTextView.this.f14392o, MaterialAutoCompleteTextView.this.f14393p.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.f14392o});
            }
            return null;
        }

        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.f14392o);
            if (this.f14396g != null) {
                DrawableCompat.o(colorDrawable, this.f14395f);
                return new RippleDrawable(this.f14396g, colorDrawable, null);
            }
            return colorDrawable;
        }

        private boolean c() {
            if (MaterialAutoCompleteTextView.this.f14392o != 0) {
                return true;
            }
            return false;
        }

        private boolean d() {
            if (MaterialAutoCompleteTextView.this.f14393p != null) {
                return true;
            }
            return false;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {16842919};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.f14393p.getColorForState(iArr, 0), 0});
        }

        void f() {
            this.f14396g = e();
            this.f14395f = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i8, View view, ViewGroup viewGroup) {
            Drawable drawable;
            View view2 = super.getView(i8, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText())) {
                    drawable = b();
                } else {
                    drawable = null;
                }
                ViewCompat.w0(textView, drawable);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f12479b);
    }

    private TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean g() {
        AccessibilityManager accessibilityManager = this.f14388k;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        return false;
    }

    private int h() {
        ListAdapter adapter = getAdapter();
        TextInputLayout f8 = f();
        int i8 = 0;
        if (adapter == null || f8 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f14387j.x()) + 15);
        View view = null;
        int i9 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(max, view, f8);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i9 = Math.max(i9, view.getMeasuredWidth());
        }
        Drawable h8 = this.f14387j.h();
        if (h8 != null) {
            h8.getPadding(this.f14389l);
            Rect rect = this.f14389l;
            i9 += rect.left + rect.right;
        }
        return i9 + f8.getEndIconView().getMeasuredWidth();
    }

    private void i() {
        TextInputLayout f8 = f();
        if (f8 != null) {
            f8.n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void j(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f14387j.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout f8 = f();
        if (f8 != null && f8.P()) {
            return f8.getHint();
        }
        return super.getHint();
    }

    public float getPopupElevation() {
        return this.f14391n;
    }

    public int getSimpleItemSelectedColor() {
        return this.f14392o;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f14393p;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout f8 = f();
        if (f8 != null && f8.P() && super.getHint() == null && ManufacturerUtils.a()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f14387j.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (View.MeasureSpec.getMode(i8) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), h()), View.MeasureSpec.getSize(i8)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z7) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z7);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t7) {
        super.setAdapter(t7);
        this.f14387j.n(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.f14387j;
        if (listPopupWindow != null) {
            listPopupWindow.d(drawable);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f14387j.M(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i8) {
        super.setRawInputType(i8);
        i();
    }

    public void setSimpleItemSelectedColor(int i8) {
        this.f14392o = i8;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f14393p = colorStateList;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i8) {
        setSimpleItems(getResources().getStringArray(i8));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f14387j.b();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, AttributeSet attributeSet, int i8) {
        super(MaterialThemeOverlay.c(context, attributeSet, i8, 0), attributeSet, i8);
        this.f14389l = new Rect();
        Context context2 = getContext();
        TypedArray i9 = ThemeEnforcement.i(context2, attributeSet, R$styleable.f12660s3, i8, R$style.f12494g, new int[0]);
        int i10 = R$styleable.f12668t3;
        if (i9.hasValue(i10) && i9.getInt(i10, 0) == 0) {
            setKeyListener(null);
        }
        this.f14390m = i9.getResourceId(R$styleable.f12684v3, R$layout.mtrl_auto_complete_simple_item);
        this.f14391n = i9.getDimensionPixelOffset(R$styleable.f12676u3, R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        this.f14392o = i9.getColor(R$styleable.f12692w3, 0);
        this.f14393p = MaterialResources.a(context2, i9, R$styleable.f12700x3);
        this.f14388k = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f14387j = listPopupWindow;
        listPopupWindow.J(true);
        listPopupWindow.D(this);
        listPopupWindow.I(2);
        listPopupWindow.n(getAdapter());
        listPopupWindow.L(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.textfield.MaterialAutoCompleteTextView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j8) {
                Object item;
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                if (i11 < 0) {
                    item = materialAutoCompleteTextView.f14387j.v();
                } else {
                    item = materialAutoCompleteTextView.getAdapter().getItem(i11);
                }
                MaterialAutoCompleteTextView.this.j(item);
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i11 < 0) {
                        view = MaterialAutoCompleteTextView.this.f14387j.y();
                        i11 = MaterialAutoCompleteTextView.this.f14387j.x();
                        j8 = MaterialAutoCompleteTextView.this.f14387j.w();
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f14387j.p(), view, i11, j8);
                }
                MaterialAutoCompleteTextView.this.f14387j.dismiss();
            }
        });
        int i11 = R$styleable.f12708y3;
        if (i9.hasValue(i11)) {
            setSimpleItems(i9.getResourceId(i11, 0));
        }
        i9.recycle();
    }

    public void setSimpleItems(@NonNull String[] strArr) {
        setAdapter(new MaterialArrayAdapter(getContext(), this.f14390m, strArr));
    }
}
