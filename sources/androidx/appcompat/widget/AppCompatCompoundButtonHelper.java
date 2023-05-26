package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

/* loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1836a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1837b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1838c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1839d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1840e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1841f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        this.f1836a = compoundButton;
    }

    void a() {
        Drawable a8 = CompoundButtonCompat.a(this.f1836a);
        if (a8 != null) {
            if (this.f1839d || this.f1840e) {
                Drawable mutate = DrawableCompat.r(a8).mutate();
                if (this.f1839d) {
                    DrawableCompat.o(mutate, this.f1837b);
                }
                if (this.f1840e) {
                    DrawableCompat.p(mutate, this.f1838c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1836a.getDrawableState());
                }
                this.f1836a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i8) {
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f1837b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f1838c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f1836a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R$styleable.U0
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.v(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.f1836a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.r()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.q0(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R$styleable.W0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L3b
            int r10 = r0.n(r10, r8)     // Catch: java.lang.Throwable -> L85
            if (r10 == 0) goto L3b
            android.widget.CompoundButton r11 = r9.f1836a     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            android.content.Context r1 = r11.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            r11.setButtonDrawable(r10)     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            r10 = 1
            goto L3c
        L3a:
        L3b:
            r10 = 0
        L3c:
            if (r10 != 0) goto L59
            int r10 = androidx.appcompat.R$styleable.V0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L59
            int r10 = r0.n(r10, r8)     // Catch: java.lang.Throwable -> L85
            if (r10 == 0) goto L59
            android.widget.CompoundButton r11 = r9.f1836a     // Catch: java.lang.Throwable -> L85
            android.content.Context r1 = r11.getContext()     // Catch: java.lang.Throwable -> L85
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch: java.lang.Throwable -> L85
            r11.setButtonDrawable(r10)     // Catch: java.lang.Throwable -> L85
        L59:
            int r10 = androidx.appcompat.R$styleable.X0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L6a
            android.widget.CompoundButton r11 = r9.f1836a     // Catch: java.lang.Throwable -> L85
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch: java.lang.Throwable -> L85
            androidx.core.widget.CompoundButtonCompat.d(r11, r10)     // Catch: java.lang.Throwable -> L85
        L6a:
            int r10 = androidx.appcompat.R$styleable.Y0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L81
            android.widget.CompoundButton r11 = r9.f1836a     // Catch: java.lang.Throwable -> L85
            r1 = -1
            int r10 = r0.k(r10, r1)     // Catch: java.lang.Throwable -> L85
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.e(r10, r1)     // Catch: java.lang.Throwable -> L85
            androidx.core.widget.CompoundButtonCompat.e(r11, r10)     // Catch: java.lang.Throwable -> L85
        L81:
            r0.w()
            return
        L85:
            r10 = move-exception
            r0.w()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.e(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f1841f) {
            this.f1841f = false;
            return;
        }
        this.f1841f = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f1837b = colorStateList;
        this.f1839d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f1838c = mode;
        this.f1840e = true;
        a();
    }
}
