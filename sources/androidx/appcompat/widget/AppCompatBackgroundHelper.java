package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class AppCompatBackgroundHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f1813a;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f1816d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f1817e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f1818f;

    /* renamed from: c  reason: collision with root package name */
    private int f1815c = -1;

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatDrawableManager f1814b = AppCompatDrawableManager.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatBackgroundHelper(@NonNull View view) {
        this.f1813a = view;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f1818f == null) {
            this.f1818f = new TintInfo();
        }
        TintInfo tintInfo = this.f1818f;
        tintInfo.a();
        ColorStateList u7 = ViewCompat.u(this.f1813a);
        if (u7 != null) {
            tintInfo.f2205d = true;
            tintInfo.f2202a = u7;
        }
        PorterDuff.Mode v7 = ViewCompat.v(this.f1813a);
        if (v7 != null) {
            tintInfo.f2204c = true;
            tintInfo.f2203b = v7;
        }
        if (!tintInfo.f2205d && !tintInfo.f2204c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f1813a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 > 21) {
            if (this.f1816d != null) {
                return true;
            }
            return false;
        } else if (i8 == 21) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f1813a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            TintInfo tintInfo = this.f1817e;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(background, tintInfo, this.f1813a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1816d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(background, tintInfo2, this.f1813a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        TintInfo tintInfo = this.f1817e;
        if (tintInfo != null) {
            return tintInfo.f2202a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        TintInfo tintInfo = this.f1817e;
        if (tintInfo != null) {
            return tintInfo.f2203b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i8) {
        Context context = this.f1813a.getContext();
        int[] iArr = R$styleable.M3;
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, iArr, i8, 0);
        View view = this.f1813a;
        ViewCompat.q0(view, view.getContext(), iArr, attributeSet, v7.r(), i8, 0);
        try {
            int i9 = R$styleable.N3;
            if (v7.s(i9)) {
                this.f1815c = v7.n(i9, -1);
                ColorStateList f8 = this.f1814b.f(this.f1813a.getContext(), this.f1815c);
                if (f8 != null) {
                    h(f8);
                }
            }
            int i10 = R$styleable.O3;
            if (v7.s(i10)) {
                ViewCompat.x0(this.f1813a, v7.c(i10));
            }
            int i11 = R$styleable.P3;
            if (v7.s(i11)) {
                ViewCompat.y0(this.f1813a, DrawableUtils.e(v7.k(i11, -1), null));
            }
        } finally {
            v7.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f1815c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i8) {
        ColorStateList colorStateList;
        this.f1815c = i8;
        AppCompatDrawableManager appCompatDrawableManager = this.f1814b;
        if (appCompatDrawableManager != null) {
            colorStateList = appCompatDrawableManager.f(this.f1813a.getContext(), i8);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1816d == null) {
                this.f1816d = new TintInfo();
            }
            TintInfo tintInfo = this.f1816d;
            tintInfo.f2202a = colorStateList;
            tintInfo.f2205d = true;
        } else {
            this.f1816d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f1817e == null) {
            this.f1817e = new TintInfo();
        }
        TintInfo tintInfo = this.f1817e;
        tintInfo.f2202a = colorStateList;
        tintInfo.f2205d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f1817e == null) {
            this.f1817e = new TintInfo();
        }
        TintInfo tintInfo = this.f1817e;
        tintInfo.f2203b = mode;
        tintInfo.f2204c = true;
        b();
    }
}
