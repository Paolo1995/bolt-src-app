package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatTextHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1917a;

    /* renamed from: b  reason: collision with root package name */
    private TintInfo f1918b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f1919c;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f1920d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f1921e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f1922f;

    /* renamed from: g  reason: collision with root package name */
    private TintInfo f1923g;

    /* renamed from: h  reason: collision with root package name */
    private TintInfo f1924h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final AppCompatTextViewAutoSizeHelper f1925i;

    /* renamed from: j  reason: collision with root package name */
    private int f1926j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1927k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1928l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1929m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
        }

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* loaded from: classes.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* loaded from: classes.dex */
    static class Api26Impl {
        private Api26Impl() {
        }

        static int a(TextView textView) {
            int autoSizeStepGranularity;
            autoSizeStepGranularity = textView.getAutoSizeStepGranularity();
            return autoSizeStepGranularity;
        }

        static void b(TextView textView, int i8, int i9, int i10, int i11) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i8, i9, i10, i11);
        }

        static void c(TextView textView, int[] iArr, int i8) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i8);
        }

        static boolean d(TextView textView, String str) {
            boolean fontVariationSettings;
            fontVariationSettings = textView.setFontVariationSettings(str);
            return fontVariationSettings;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static Typeface a(Typeface typeface, int i8, boolean z7) {
            Typeface create;
            create = Typeface.create(typeface, i8, z7);
            return create;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextHelper(@NonNull TextView textView) {
        this.f1917a = textView;
        this.f1925i = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void B(int i8, float f8) {
        this.f1925i.t(i8, f8);
    }

    private void C(Context context, TintTypedArray tintTypedArray) {
        String o8;
        boolean z7;
        boolean z8;
        this.f1926j = tintTypedArray.k(R$styleable.V2, this.f1926j);
        int i8 = Build.VERSION.SDK_INT;
        boolean z9 = false;
        if (i8 >= 28) {
            int k8 = tintTypedArray.k(R$styleable.f960a3, -1);
            this.f1927k = k8;
            if (k8 != -1) {
                this.f1926j = (this.f1926j & 2) | 0;
            }
        }
        int i9 = R$styleable.Z2;
        if (!tintTypedArray.s(i9) && !tintTypedArray.s(R$styleable.f965b3)) {
            int i10 = R$styleable.U2;
            if (tintTypedArray.s(i10)) {
                this.f1929m = false;
                int k9 = tintTypedArray.k(i10, 1);
                if (k9 != 1) {
                    if (k9 != 2) {
                        if (k9 == 3) {
                            this.f1928l = Typeface.MONOSPACE;
                            return;
                        }
                        return;
                    }
                    this.f1928l = Typeface.SERIF;
                    return;
                }
                this.f1928l = Typeface.SANS_SERIF;
                return;
            }
            return;
        }
        this.f1928l = null;
        int i11 = R$styleable.f965b3;
        if (tintTypedArray.s(i11)) {
            i9 = i11;
        }
        final int i12 = this.f1927k;
        final int i13 = this.f1926j;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.f1917a);
            try {
                Typeface j8 = tintTypedArray.j(i9, this.f1926j, new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void h(int i14) {
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void i(@NonNull Typeface typeface) {
                        int i14;
                        boolean z10;
                        if (Build.VERSION.SDK_INT >= 28 && (i14 = i12) != -1) {
                            if ((i13 & 2) != 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            typeface = Api28Impl.a(typeface, i14, z10);
                        }
                        AppCompatTextHelper.this.n(weakReference, typeface);
                    }
                });
                if (j8 != null) {
                    if (i8 >= 28 && this.f1927k != -1) {
                        Typeface create = Typeface.create(j8, 0);
                        int i14 = this.f1927k;
                        if ((this.f1926j & 2) != 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        this.f1928l = Api28Impl.a(create, i14, z8);
                    } else {
                        this.f1928l = j8;
                    }
                }
                if (this.f1928l == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                this.f1929m = z7;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1928l == null && (o8 = tintTypedArray.o(i9)) != null) {
            if (Build.VERSION.SDK_INT >= 28 && this.f1927k != -1) {
                Typeface create2 = Typeface.create(o8, 0);
                int i15 = this.f1927k;
                if ((this.f1926j & 2) != 0) {
                    z9 = true;
                }
                this.f1928l = Api28Impl.a(create2, i15, z9);
                return;
            }
            this.f1928l = Typeface.create(o8, this.f1926j);
        }
    }

    private void a(Drawable drawable, TintInfo tintInfo) {
        if (drawable != null && tintInfo != null) {
            AppCompatDrawableManager.i(drawable, tintInfo, this.f1917a.getDrawableState());
        }
    }

    private static TintInfo d(Context context, AppCompatDrawableManager appCompatDrawableManager, int i8) {
        ColorStateList f8 = appCompatDrawableManager.f(context, i8);
        if (f8 != null) {
            TintInfo tintInfo = new TintInfo();
            tintInfo.f2205d = true;
            tintInfo.f2202a = f8;
            return tintInfo;
        }
        return null;
    }

    private void y(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 == null && drawable6 == null) {
            if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
                Drawable[] a8 = Api17Impl.a(this.f1917a);
                Drawable drawable7 = a8[0];
                if (drawable7 == null && a8[2] == null) {
                    Drawable[] compoundDrawables = this.f1917a.getCompoundDrawables();
                    TextView textView = this.f1917a;
                    if (drawable == null) {
                        drawable = compoundDrawables[0];
                    }
                    if (drawable2 == null) {
                        drawable2 = compoundDrawables[1];
                    }
                    if (drawable3 == null) {
                        drawable3 = compoundDrawables[2];
                    }
                    if (drawable4 == null) {
                        drawable4 = compoundDrawables[3];
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
                    return;
                }
                TextView textView2 = this.f1917a;
                if (drawable2 == null) {
                    drawable2 = a8[1];
                }
                Drawable drawable8 = a8[2];
                if (drawable4 == null) {
                    drawable4 = a8[3];
                }
                Api17Impl.b(textView2, drawable7, drawable2, drawable8, drawable4);
                return;
            }
            return;
        }
        Drawable[] a9 = Api17Impl.a(this.f1917a);
        TextView textView3 = this.f1917a;
        if (drawable5 == null) {
            drawable5 = a9[0];
        }
        if (drawable2 == null) {
            drawable2 = a9[1];
        }
        if (drawable6 == null) {
            drawable6 = a9[2];
        }
        if (drawable4 == null) {
            drawable4 = a9[3];
        }
        Api17Impl.b(textView3, drawable5, drawable2, drawable6, drawable4);
    }

    private void z() {
        TintInfo tintInfo = this.f1924h;
        this.f1918b = tintInfo;
        this.f1919c = tintInfo;
        this.f1920d = tintInfo;
        this.f1921e = tintInfo;
        this.f1922f = tintInfo;
        this.f1923g = tintInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i8, float f8) {
        if (!ViewUtils.f2292b && !l()) {
            B(i8, f8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f1918b != null || this.f1919c != null || this.f1920d != null || this.f1921e != null) {
            Drawable[] compoundDrawables = this.f1917a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1918b);
            a(compoundDrawables[1], this.f1919c);
            a(compoundDrawables[2], this.f1920d);
            a(compoundDrawables[3], this.f1921e);
        }
        if (this.f1922f != null || this.f1923g != null) {
            Drawable[] a8 = Api17Impl.a(this.f1917a);
            a(a8[0], this.f1922f);
            a(a8[2], this.f1923g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1925i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f1925i.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f1925i.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1925i.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] h() {
        return this.f1925i.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f1925i.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList j() {
        TintInfo tintInfo = this.f1924h;
        if (tintInfo != null) {
            return tintInfo.f2202a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        TintInfo tintInfo = this.f1924h;
        if (tintInfo != null) {
            return tintInfo.f2203b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f1925i.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instructions count: 784
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.m(android.util.AttributeSet, int):void");
    }

    void n(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.f1929m) {
            this.f1928l = typeface;
            final TextView textView = weakReference.get();
            if (textView != null) {
                if (ViewCompat.V(textView)) {
                    final int i8 = this.f1926j;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.setTypeface(typeface, i8);
                        }
                    });
                    return;
                }
                textView.setTypeface(typeface, this.f1926j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z7, int i8, int i9, int i10, int i11) {
        if (!ViewUtils.f2292b) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Context context, int i8) {
        String o8;
        ColorStateList c8;
        ColorStateList c9;
        ColorStateList c10;
        TintTypedArray t7 = TintTypedArray.t(context, i8, R$styleable.S2);
        int i9 = R$styleable.f975d3;
        if (t7.s(i9)) {
            s(t7.a(i9, false));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23) {
            int i11 = R$styleable.W2;
            if (t7.s(i11) && (c10 = t7.c(i11)) != null) {
                this.f1917a.setTextColor(c10);
            }
            int i12 = R$styleable.Y2;
            if (t7.s(i12) && (c9 = t7.c(i12)) != null) {
                this.f1917a.setLinkTextColor(c9);
            }
            int i13 = R$styleable.X2;
            if (t7.s(i13) && (c8 = t7.c(i13)) != null) {
                this.f1917a.setHintTextColor(c8);
            }
        }
        int i14 = R$styleable.T2;
        if (t7.s(i14) && t7.f(i14, -1) == 0) {
            this.f1917a.setTextSize(0, 0.0f);
        }
        C(context, t7);
        if (i10 >= 26) {
            int i15 = R$styleable.f970c3;
            if (t7.s(i15) && (o8 = t7.o(i15)) != null) {
                Api26Impl.d(this.f1917a, o8);
            }
        }
        t7.w();
        Typeface typeface = this.f1928l;
        if (typeface != null) {
            this.f1917a.setTypeface(typeface, this.f1926j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(@NonNull TextView textView, InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            EditorInfoCompat.f(editorInfo, textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z7) {
        this.f1917a.setAllCaps(z7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i8, int i9, int i10, int i11) throws IllegalArgumentException {
        this.f1925i.p(i8, i9, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(@NonNull int[] iArr, int i8) throws IllegalArgumentException {
        this.f1925i.q(iArr, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i8) {
        this.f1925i.r(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(ColorStateList colorStateList) {
        boolean z7;
        if (this.f1924h == null) {
            this.f1924h = new TintInfo();
        }
        TintInfo tintInfo = this.f1924h;
        tintInfo.f2202a = colorStateList;
        if (colorStateList != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        tintInfo.f2205d = z7;
        z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(PorterDuff.Mode mode) {
        boolean z7;
        if (this.f1924h == null) {
            this.f1924h = new TintInfo();
        }
        TintInfo tintInfo = this.f1924h;
        tintInfo.f2203b = mode;
        if (mode != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        tintInfo.f2204c = z7;
        z();
    }
}
