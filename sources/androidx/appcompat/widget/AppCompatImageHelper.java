package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/* loaded from: classes.dex */
public class AppCompatImageHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1865a;

    /* renamed from: b  reason: collision with root package name */
    private TintInfo f1866b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f1867c;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f1868d;

    /* renamed from: e  reason: collision with root package name */
    private int f1869e = 0;

    public AppCompatImageHelper(@NonNull ImageView imageView) {
        this.f1865a = imageView;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f1868d == null) {
            this.f1868d = new TintInfo();
        }
        TintInfo tintInfo = this.f1868d;
        tintInfo.a();
        ColorStateList a8 = ImageViewCompat.a(this.f1865a);
        if (a8 != null) {
            tintInfo.f2205d = true;
            tintInfo.f2202a = a8;
        }
        PorterDuff.Mode b8 = ImageViewCompat.b(this.f1865a);
        if (b8 != null) {
            tintInfo.f2204c = true;
            tintInfo.f2203b = b8;
        }
        if (!tintInfo.f2205d && !tintInfo.f2204c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f1865a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 > 21) {
            if (this.f1866b != null) {
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
        if (this.f1865a.getDrawable() != null) {
            this.f1865a.getDrawable().setLevel(this.f1869e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1865a.getDrawable();
        if (drawable != null) {
            DrawableUtils.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            TintInfo tintInfo = this.f1867c;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(drawable, tintInfo, this.f1865a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1866b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(drawable, tintInfo2, this.f1865a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList d() {
        TintInfo tintInfo = this.f1867c;
        if (tintInfo != null) {
            return tintInfo.f2202a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        TintInfo tintInfo = this.f1867c;
        if (tintInfo != null) {
            return tintInfo.f2203b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (this.f1865a.getBackground() instanceof RippleDrawable) {
            return false;
        }
        return true;
    }

    public void g(AttributeSet attributeSet, int i8) {
        int n8;
        Context context = this.f1865a.getContext();
        int[] iArr = R$styleable.P;
        TintTypedArray v7 = TintTypedArray.v(context, attributeSet, iArr, i8, 0);
        ImageView imageView = this.f1865a;
        ViewCompat.q0(imageView, imageView.getContext(), iArr, attributeSet, v7.r(), i8, 0);
        try {
            Drawable drawable = this.f1865a.getDrawable();
            if (drawable == null && (n8 = v7.n(R$styleable.Q, -1)) != -1 && (drawable = AppCompatResources.b(this.f1865a.getContext(), n8)) != null) {
                this.f1865a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.b(drawable);
            }
            int i9 = R$styleable.R;
            if (v7.s(i9)) {
                ImageViewCompat.c(this.f1865a, v7.c(i9));
            }
            int i10 = R$styleable.S;
            if (v7.s(i10)) {
                ImageViewCompat.d(this.f1865a, DrawableUtils.e(v7.k(i10, -1), null));
            }
        } finally {
            v7.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(@NonNull Drawable drawable) {
        this.f1869e = drawable.getLevel();
    }

    public void i(int i8) {
        if (i8 != 0) {
            Drawable b8 = AppCompatResources.b(this.f1865a.getContext(), i8);
            if (b8 != null) {
                DrawableUtils.b(b8);
            }
            this.f1865a.setImageDrawable(b8);
        } else {
            this.f1865a.setImageDrawable(null);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (this.f1867c == null) {
            this.f1867c = new TintInfo();
        }
        TintInfo tintInfo = this.f1867c;
        tintInfo.f2202a = colorStateList;
        tintInfo.f2205d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(PorterDuff.Mode mode) {
        if (this.f1867c == null) {
            this.f1867c = new TintInfo();
        }
        TintInfo tintInfo = this.f1867c;
        tintInfo.f2203b = mode;
        tintInfo.f2204c = true;
        c();
    }
}
