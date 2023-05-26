package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class NestedScrollingChildHelper {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f5948a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f5949b;

    /* renamed from: c  reason: collision with root package name */
    private final View f5950c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5951d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f5952e;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.f5950c = view;
    }

    private boolean g(int i8, int i9, int i10, int i11, int[] iArr, int i12, int[] iArr2) {
        ViewParent h8;
        int i13;
        int i14;
        int[] iArr3;
        if (!l() || (h8 = h(i12)) == null) {
            return false;
        }
        if (i8 == 0 && i9 == 0 && i10 == 0 && i11 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f5950c.getLocationInWindow(iArr);
            i13 = iArr[0];
            i14 = iArr[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr2 == null) {
            int[] i15 = i();
            i15[0] = 0;
            i15[1] = 0;
            iArr3 = i15;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.d(h8, this.f5950c, i8, i9, i10, i11, i12, iArr3);
        if (iArr != null) {
            this.f5950c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i13;
            iArr[1] = iArr[1] - i14;
        }
        return true;
    }

    private ViewParent h(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                return null;
            }
            return this.f5949b;
        }
        return this.f5948a;
    }

    private int[] i() {
        if (this.f5952e == null) {
            this.f5952e = new int[2];
        }
        return this.f5952e;
    }

    private void n(int i8, ViewParent viewParent) {
        if (i8 != 0) {
            if (i8 == 1) {
                this.f5949b = viewParent;
                return;
            }
            return;
        }
        this.f5948a = viewParent;
    }

    public boolean a(float f8, float f9, boolean z7) {
        ViewParent h8;
        if (!l() || (h8 = h(0)) == null) {
            return false;
        }
        return ViewParentCompat.a(h8, this.f5950c, f8, f9, z7);
    }

    public boolean b(float f8, float f9) {
        ViewParent h8;
        if (!l() || (h8 = h(0)) == null) {
            return false;
        }
        return ViewParentCompat.b(h8, this.f5950c, f8, f9);
    }

    public boolean c(int i8, int i9, int[] iArr, int[] iArr2) {
        return d(i8, i9, iArr, iArr2, 0);
    }

    public boolean d(int i8, int i9, int[] iArr, int[] iArr2, int i10) {
        ViewParent h8;
        int i11;
        int i12;
        if (!l() || (h8 = h(i10)) == null) {
            return false;
        }
        if (i8 == 0 && i9 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f5950c.getLocationInWindow(iArr2);
            i11 = iArr2[0];
            i12 = iArr2[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (iArr == null) {
            iArr = i();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.c(h8, this.f5950c, i8, i9, iArr, i10);
        if (iArr2 != null) {
            this.f5950c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i11;
            iArr2[1] = iArr2[1] - i12;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public void e(int i8, int i9, int i10, int i11, int[] iArr, int i12, int[] iArr2) {
        g(i8, i9, i10, i11, iArr, i12, iArr2);
    }

    public boolean f(int i8, int i9, int i10, int i11, int[] iArr) {
        return g(i8, i9, i10, i11, iArr, 0, null);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i8) {
        if (h(i8) != null) {
            return true;
        }
        return false;
    }

    public boolean l() {
        return this.f5951d;
    }

    public void m(boolean z7) {
        if (this.f5951d) {
            ViewCompat.R0(this.f5950c);
        }
        this.f5951d = z7;
    }

    public boolean o(int i8) {
        return p(i8, 0);
    }

    public boolean p(int i8, int i9) {
        if (k(i9)) {
            return true;
        }
        if (l()) {
            View view = this.f5950c;
            for (ViewParent parent = this.f5950c.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.f(parent, view, this.f5950c, i8, i9)) {
                    n(i9, parent);
                    ViewParentCompat.e(parent, view, this.f5950c, i8, i9);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int i8) {
        ViewParent h8 = h(i8);
        if (h8 != null) {
            ViewParentCompat.g(h8, this.f5950c, i8);
            n(i8, null);
        }
    }
}
