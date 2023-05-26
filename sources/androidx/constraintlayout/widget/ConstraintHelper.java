package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: f  reason: collision with root package name */
    protected int[] f4963f;

    /* renamed from: g  reason: collision with root package name */
    protected int f4964g;

    /* renamed from: h  reason: collision with root package name */
    protected Context f4965h;

    /* renamed from: i  reason: collision with root package name */
    protected Helper f4966i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f4967j;

    /* renamed from: k  reason: collision with root package name */
    protected String f4968k;

    /* renamed from: l  reason: collision with root package name */
    protected String f4969l;

    /* renamed from: m  reason: collision with root package name */
    private View[] f4970m;

    /* renamed from: n  reason: collision with root package name */
    protected HashMap<Integer, String> f4971n;

    public ConstraintHelper(Context context) {
        super(context);
        this.f4963f = new int[32];
        this.f4967j = false;
        this.f4970m = null;
        this.f4971n = new HashMap<>();
        this.f4965h = context;
        n(null);
    }

    private void e(String str) {
        if (str == null || str.length() == 0 || this.f4965h == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int l8 = l(trim);
        if (l8 != 0) {
            this.f4971n.put(Integer.valueOf(l8), trim);
            f(l8);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void f(int i8) {
        if (i8 == getId()) {
            return;
        }
        int i9 = this.f4964g + 1;
        int[] iArr = this.f4963f;
        if (i9 > iArr.length) {
            this.f4963f = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f4963f;
        int i10 = this.f4964g;
        iArr2[i10] = i8;
        this.f4964g = i10 + 1;
    }

    private void g(String str) {
        if (str == null || str.length() == 0 || this.f4965h == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = null;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        }
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).f4999c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    f(childAt.getId());
                }
            }
        }
    }

    private int k(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f4965h.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int l(String str) {
        ConstraintLayout constraintLayout;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        int i8 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object g8 = constraintLayout.g(0, str);
            if (g8 instanceof Integer) {
                i8 = ((Integer) g8).intValue();
            }
        }
        if (i8 == 0 && constraintLayout != null) {
            i8 = k(constraintLayout, str);
        }
        if (i8 == 0) {
            try {
                i8 = R$id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (i8 == 0) {
            return this.f4965h.getResources().getIdentifier(str, Name.MARK, this.f4965h.getPackageName());
        }
        return i8;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4963f, this.f4964g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            i((ConstraintLayout) parent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i8 = 0; i8 < this.f4964g; i8++) {
            View l8 = constraintLayout.l(this.f4963f[i8]);
            if (l8 != null) {
                l8.setVisibility(visibility);
                if (elevation > 0.0f) {
                    l8.setTranslationZ(l8.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(ConstraintLayout constraintLayout) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] m(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f4970m;
        if (viewArr == null || viewArr.length != this.f4964g) {
            this.f4970m = new View[this.f4964g];
        }
        for (int i8 = 0; i8 < this.f4964g; i8++) {
            this.f4970m[i8] = constraintLayout.l(this.f4963f[i8]);
        }
        return this.f4970m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f5303n1);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = obtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.G1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f4968k = string;
                    setIds(string);
                } else if (index == R$styleable.H1) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f4969l = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void o(ConstraintWidget constraintWidget, boolean z7) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f4968k;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f4969l;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i8, int i9) {
        if (this.f4967j) {
            super.onMeasure(i8, i9);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintLayout constraintLayout) {
    }

    public void q(ConstraintLayout constraintLayout) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
        String str;
        int k8;
        if (isInEditMode()) {
            setIds(this.f4968k);
        }
        Helper helper = this.f4966i;
        if (helper == null) {
            return;
        }
        helper.b();
        for (int i8 = 0; i8 < this.f4964g; i8++) {
            int i9 = this.f4963f[i8];
            View l8 = constraintLayout.l(i9);
            if (l8 == null && (k8 = k(constraintLayout, (str = this.f4971n.get(Integer.valueOf(i9))))) != 0) {
                this.f4963f[i8] = k8;
                this.f4971n.put(Integer.valueOf(k8), str);
                l8 = constraintLayout.l(k8);
            }
            if (l8 != null) {
                this.f4966i.a(constraintLayout.p(l8));
            }
        }
        this.f4966i.c(constraintLayout.f4974h);
    }

    protected void setIds(String str) {
        this.f4968k = str;
        if (str == null) {
            return;
        }
        int i8 = 0;
        this.f4964g = 0;
        while (true) {
            int indexOf = str.indexOf(44, i8);
            if (indexOf == -1) {
                e(str.substring(i8));
                return;
            } else {
                e(str.substring(i8, indexOf));
                i8 = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f4969l = str;
        if (str == null) {
            return;
        }
        int i8 = 0;
        this.f4964g = 0;
        while (true) {
            int indexOf = str.indexOf(44, i8);
            if (indexOf == -1) {
                g(str.substring(i8));
                return;
            } else {
                g(str.substring(i8, indexOf));
                i8 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f4968k = null;
        this.f4964g = 0;
        for (int i8 : iArr) {
            f(i8);
        }
    }

    @Override // android.view.View
    public void setTag(int i8, Object obj) {
        super.setTag(i8, obj);
        if (obj == null && this.f4968k == null) {
            f(i8);
        }
    }

    public void t() {
        if (this.f4966i == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).f5037v0 = (ConstraintWidget) this.f4966i;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4963f = new int[32];
        this.f4967j = false;
        this.f4970m = null;
        this.f4971n = new HashMap<>();
        this.f4965h = context;
        n(attributeSet);
    }
}
