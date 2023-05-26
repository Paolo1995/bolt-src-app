package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* loaded from: classes.dex */
class AppCompatCheckedTextViewHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CheckedTextView f1830a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1831b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1832c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1833d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1834e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1835f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatCheckedTextViewHelper(@NonNull CheckedTextView checkedTextView) {
        this.f1830a = checkedTextView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable a8 = CheckedTextViewCompat.a(this.f1830a);
        if (a8 != null) {
            if (this.f1833d || this.f1834e) {
                Drawable mutate = DrawableCompat.r(a8).mutate();
                if (this.f1833d) {
                    DrawableCompat.o(mutate, this.f1831b);
                }
                if (this.f1834e) {
                    DrawableCompat.p(mutate, this.f1832c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1830a.getDrawableState());
                }
                this.f1830a.setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f1831b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f1832c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002b, B:12:0x003e, B:14:0x0046, B:16:0x004c, B:17:0x0059, B:19:0x0061, B:20:0x006a, B:22:0x0072), top: B:30:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CheckedTextView r0 = r9.f1830a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R$styleable.P0
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.v(r0, r10, r3, r11, r8)
            android.widget.CheckedTextView r1 = r9.f1830a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.r()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.q0(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R$styleable.R0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L3b
            int r10 = r0.n(r10, r8)     // Catch: java.lang.Throwable -> L85
            if (r10 == 0) goto L3b
            android.widget.CheckedTextView r11 = r9.f1830a     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            android.content.Context r1 = r11.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            r11.setCheckMarkDrawable(r10)     // Catch: android.content.res.Resources.NotFoundException -> L3a java.lang.Throwable -> L85
            r10 = 1
            goto L3c
        L3a:
        L3b:
            r10 = 0
        L3c:
            if (r10 != 0) goto L59
            int r10 = androidx.appcompat.R$styleable.Q0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L59
            int r10 = r0.n(r10, r8)     // Catch: java.lang.Throwable -> L85
            if (r10 == 0) goto L59
            android.widget.CheckedTextView r11 = r9.f1830a     // Catch: java.lang.Throwable -> L85
            android.content.Context r1 = r11.getContext()     // Catch: java.lang.Throwable -> L85
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch: java.lang.Throwable -> L85
            r11.setCheckMarkDrawable(r10)     // Catch: java.lang.Throwable -> L85
        L59:
            int r10 = androidx.appcompat.R$styleable.S0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L6a
            android.widget.CheckedTextView r11 = r9.f1830a     // Catch: java.lang.Throwable -> L85
            android.content.res.ColorStateList r10 = r0.c(r10)     // Catch: java.lang.Throwable -> L85
            androidx.core.widget.CheckedTextViewCompat.b(r11, r10)     // Catch: java.lang.Throwable -> L85
        L6a:
            int r10 = androidx.appcompat.R$styleable.T0     // Catch: java.lang.Throwable -> L85
            boolean r11 = r0.s(r10)     // Catch: java.lang.Throwable -> L85
            if (r11 == 0) goto L81
            android.widget.CheckedTextView r11 = r9.f1830a     // Catch: java.lang.Throwable -> L85
            r1 = -1
            int r10 = r0.k(r10, r1)     // Catch: java.lang.Throwable -> L85
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.e(r10, r1)     // Catch: java.lang.Throwable -> L85
            androidx.core.widget.CheckedTextViewCompat.c(r11, r10)     // Catch: java.lang.Throwable -> L85
        L81:
            r0.w()
            return
        L85:
            r10 = move-exception
            r0.w()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextViewHelper.d(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f1835f) {
            this.f1835f = false;
            return;
        }
        this.f1835f = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f1831b = colorStateList;
        this.f1833d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(PorterDuff.Mode mode) {
        this.f1832c = mode;
        this.f1834e = true;
        a();
    }
}
