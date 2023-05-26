package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.StaticLayout$Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.api.Api;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatTextViewAutoSizeHelper {

    /* renamed from: l  reason: collision with root package name */
    private static final RectF f1940l = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f1941m = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: n  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f1942n = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private int f1943a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1944b = false;

    /* renamed from: c  reason: collision with root package name */
    private float f1945c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f1946d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f1947e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1948f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    private boolean f1949g = false;

    /* renamed from: h  reason: collision with root package name */
    private TextPaint f1950h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f1951i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f1952j;

    /* renamed from: k  reason: collision with root package name */
    private final Impl f1953k;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Api16Impl {
        private Api16Impl() {
        }

        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i8, @NonNull TextView textView, @NonNull TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i8, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        static int b(@NonNull TextView textView) {
            return textView.getMaxLines();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Api18Impl {
        private Api18Impl() {
        }

        static boolean a(@NonNull View view) {
            return view.isInLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        static StaticLayout a(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i8, int i9, @NonNull TextView textView, @NonNull TextPaint textPaint, @NonNull Impl impl) {
            int breakStrategy;
            int hyphenationFrequency;
            StaticLayout$Builder obtain = StaticLayout$Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i8);
            StaticLayout$Builder includePad = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding());
            breakStrategy = textView.getBreakStrategy();
            StaticLayout$Builder breakStrategy2 = includePad.setBreakStrategy(breakStrategy);
            hyphenationFrequency = textView.getHyphenationFrequency();
            StaticLayout$Builder hyphenationFrequency2 = breakStrategy2.setHyphenationFrequency(hyphenationFrequency);
            if (i9 == -1) {
                i9 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            hyphenationFrequency2.setMaxLines(i9);
            try {
                impl.a(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Impl {
        Impl() {
        }

        void a(StaticLayout$Builder staticLayout$Builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.m(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    private static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void a(StaticLayout$Builder staticLayout$Builder, TextView textView) {
            staticLayout$Builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* loaded from: classes.dex */
    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void a(StaticLayout$Builder staticLayout$Builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            staticLayout$Builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean b(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextViewAutoSizeHelper(@NonNull TextView textView) {
        this.f1951i = textView;
        this.f1952j = textView.getContext();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 29) {
            this.f1953k = new Impl29();
        } else if (i8 >= 23) {
            this.f1953k = new Impl23();
        } else {
            this.f1953k = new Impl();
        }
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i8 : iArr) {
            if (i8 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i8)) < 0) {
                arrayList.add(Integer.valueOf(i8));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i9 = 0; i9 < size; i9++) {
            iArr2[i9] = ((Integer) arrayList.get(i9)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f1943a = 0;
        this.f1946d = -1.0f;
        this.f1947e = -1.0f;
        this.f1945c = -1.0f;
        this.f1948f = new int[0];
        this.f1944b = false;
    }

    private int e(RectF rectF) {
        int length = this.f1948f.length;
        if (length != 0) {
            int i8 = length - 1;
            int i9 = 1;
            int i10 = 0;
            while (i9 <= i8) {
                int i11 = (i9 + i8) / 2;
                if (x(this.f1948f[i11], rectF)) {
                    int i12 = i11 + 1;
                    i10 = i9;
                    i9 = i12;
                } else {
                    i10 = i11 - 1;
                    i8 = i10;
                }
            }
            return this.f1948f[i10];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Method k(@NonNull String str) {
        try {
            Method method = f1941m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1941m.put(str, method);
            }
            return method;
        } catch (Exception e8) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e8);
            return null;
        }
    }

    static <T> T m(@NonNull Object obj, @NonNull String str, @NonNull T t7) {
        try {
            return (T) k(str).invoke(obj, new Object[0]);
        } catch (Exception e8) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e8);
            return t7;
        }
    }

    private void s(float f8) {
        if (f8 != this.f1951i.getPaint().getTextSize()) {
            this.f1951i.getPaint().setTextSize(f8);
            boolean a8 = Api18Impl.a(this.f1951i);
            if (this.f1951i.getLayout() != null) {
                this.f1944b = false;
                try {
                    Method k8 = k("nullLayouts");
                    if (k8 != null) {
                        k8.invoke(this.f1951i, new Object[0]);
                    }
                } catch (Exception e8) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e8);
                }
                if (!a8) {
                    this.f1951i.requestLayout();
                } else {
                    this.f1951i.forceLayout();
                }
                this.f1951i.invalidate();
            }
        }
    }

    private boolean u() {
        if (y() && this.f1943a == 1) {
            if (!this.f1949g || this.f1948f.length == 0) {
                int floor = ((int) Math.floor((this.f1947e - this.f1946d) / this.f1945c)) + 1;
                int[] iArr = new int[floor];
                for (int i8 = 0; i8 < floor; i8++) {
                    iArr[i8] = Math.round(this.f1946d + (i8 * this.f1945c));
                }
                this.f1948f = b(iArr);
            }
            this.f1944b = true;
        } else {
            this.f1944b = false;
        }
        return this.f1944b;
    }

    private void v(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i8 = 0; i8 < length; i8++) {
                iArr[i8] = typedArray.getDimensionPixelSize(i8, -1);
            }
            this.f1948f = b(iArr);
            w();
        }
    }

    private boolean w() {
        boolean z7;
        int[] iArr = this.f1948f;
        int length = iArr.length;
        if (length > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.f1949g = z7;
        if (z7) {
            this.f1943a = 1;
            this.f1946d = iArr[0];
            this.f1947e = iArr[length - 1];
            this.f1945c = -1.0f;
        }
        return z7;
    }

    private boolean x(int i8, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1951i.getText();
        TransformationMethod transformationMethod = this.f1951i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1951i)) != null) {
            text = transformation;
        }
        int b8 = Api16Impl.b(this.f1951i);
        l(i8);
        StaticLayout d8 = d(text, (Layout.Alignment) m(this.f1951i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), b8);
        if ((b8 != -1 && (d8.getLineCount() > b8 || d8.getLineEnd(d8.getLineCount() - 1) != text.length())) || d8.getHeight() > rectF.bottom) {
            return false;
        }
        return true;
    }

    private boolean y() {
        return !(this.f1951i instanceof AppCompatEditText);
    }

    private void z(float f8, float f9, float f10) throws IllegalArgumentException {
        if (f8 > 0.0f) {
            if (f9 > f8) {
                if (f10 > 0.0f) {
                    this.f1943a = 1;
                    this.f1946d = f8;
                    this.f1947e = f9;
                    this.f1945c = f10;
                    this.f1949g = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f10 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f9 + "px) is less or equal to minimum auto-size text size (" + f8 + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f8 + "px) is less or equal to (0px)");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int measuredWidth;
        if (!n()) {
            return;
        }
        if (this.f1944b) {
            if (this.f1951i.getMeasuredHeight() > 0 && this.f1951i.getMeasuredWidth() > 0) {
                if (this.f1953k.b(this.f1951i)) {
                    measuredWidth = 1048576;
                } else {
                    measuredWidth = (this.f1951i.getMeasuredWidth() - this.f1951i.getTotalPaddingLeft()) - this.f1951i.getTotalPaddingRight();
                }
                int height = (this.f1951i.getHeight() - this.f1951i.getCompoundPaddingBottom()) - this.f1951i.getCompoundPaddingTop();
                if (measuredWidth > 0 && height > 0) {
                    RectF rectF = f1940l;
                    synchronized (rectF) {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float e8 = e(rectF);
                        if (e8 != this.f1951i.getTextSize()) {
                            t(0, e8);
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f1944b = true;
    }

    @NonNull
    StaticLayout d(@NonNull CharSequence charSequence, @NonNull Layout.Alignment alignment, int i8, int i9) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(charSequence, alignment, i8, i9, this.f1951i, this.f1950h, this.f1953k);
        }
        return Api16Impl.a(charSequence, alignment, i8, this.f1951i, this.f1950h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return Math.round(this.f1947e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f1946d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f1945c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] i() {
        return this.f1948f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f1943a;
    }

    void l(int i8) {
        TextPaint textPaint = this.f1950h;
        if (textPaint == null) {
            this.f1950h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1950h.set(this.f1951i.getPaint());
        this.f1950h.setTextSize(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        if (y() && this.f1943a != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(AttributeSet attributeSet, int i8) {
        float f8;
        float f9;
        float f10;
        int resourceId;
        Context context = this.f1952j;
        int[] iArr = R$styleable.f987g0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i8, 0);
        TextView textView = this.f1951i;
        ViewCompat.q0(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i8, 0);
        int i9 = R$styleable.f1012l0;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.f1943a = obtainStyledAttributes.getInt(i9, 0);
        }
        int i10 = R$styleable.f1007k0;
        if (obtainStyledAttributes.hasValue(i10)) {
            f8 = obtainStyledAttributes.getDimension(i10, -1.0f);
        } else {
            f8 = -1.0f;
        }
        int i11 = R$styleable.f997i0;
        if (obtainStyledAttributes.hasValue(i11)) {
            f9 = obtainStyledAttributes.getDimension(i11, -1.0f);
        } else {
            f9 = -1.0f;
        }
        int i12 = R$styleable.f992h0;
        if (obtainStyledAttributes.hasValue(i12)) {
            f10 = obtainStyledAttributes.getDimension(i12, -1.0f);
        } else {
            f10 = -1.0f;
        }
        int i13 = R$styleable.f1002j0;
        if (obtainStyledAttributes.hasValue(i13) && (resourceId = obtainStyledAttributes.getResourceId(i13, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            v(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (y()) {
            if (this.f1943a == 1) {
                if (!this.f1949g) {
                    DisplayMetrics displayMetrics = this.f1952j.getResources().getDisplayMetrics();
                    if (f9 == -1.0f) {
                        f9 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (f10 == -1.0f) {
                        f10 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (f8 == -1.0f) {
                        f8 = 1.0f;
                    }
                    z(f9, f10, f8);
                }
                u();
                return;
            }
            return;
        }
        this.f1943a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i8, int i9, int i10, int i11) throws IllegalArgumentException {
        if (y()) {
            DisplayMetrics displayMetrics = this.f1952j.getResources().getDisplayMetrics();
            z(TypedValue.applyDimension(i11, i8, displayMetrics), TypedValue.applyDimension(i11, i9, displayMetrics), TypedValue.applyDimension(i11, i10, displayMetrics));
            if (u()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(@NonNull int[] iArr, int i8) throws IllegalArgumentException {
        if (y()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i8 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1952j.getResources().getDisplayMetrics();
                    for (int i9 = 0; i9 < length; i9++) {
                        iArr2[i9] = Math.round(TypedValue.applyDimension(i8, iArr[i9], displayMetrics));
                    }
                }
                this.f1948f = b(iArr2);
                if (!w()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1949g = false;
            }
            if (u()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i8) {
        if (y()) {
            if (i8 != 0) {
                if (i8 == 1) {
                    DisplayMetrics displayMetrics = this.f1952j.getResources().getDisplayMetrics();
                    z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (u()) {
                        a();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Unknown auto-size text type: " + i8);
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i8, float f8) {
        Resources resources;
        Context context = this.f1952j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        s(TypedValue.applyDimension(i8, f8, resources.getDisplayMetrics()));
    }
}
