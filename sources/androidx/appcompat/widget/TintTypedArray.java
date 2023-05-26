package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public class TintTypedArray {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2207a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f2208b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f2209c;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.f2207a = context;
        this.f2208b = typedArray;
    }

    public static TintTypedArray t(Context context, int i8, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i8, iArr));
    }

    public static TintTypedArray u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray v(Context context, AttributeSet attributeSet, int[] iArr, int i8, int i9) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i8, i9));
    }

    public boolean a(int i8, boolean z7) {
        return this.f2208b.getBoolean(i8, z7);
    }

    public int b(int i8, int i9) {
        return this.f2208b.getColor(i8, i9);
    }

    public ColorStateList c(int i8) {
        int resourceId;
        ColorStateList a8;
        if (this.f2208b.hasValue(i8) && (resourceId = this.f2208b.getResourceId(i8, 0)) != 0 && (a8 = AppCompatResources.a(this.f2207a, resourceId)) != null) {
            return a8;
        }
        return this.f2208b.getColorStateList(i8);
    }

    public float d(int i8, float f8) {
        return this.f2208b.getDimension(i8, f8);
    }

    public int e(int i8, int i9) {
        return this.f2208b.getDimensionPixelOffset(i8, i9);
    }

    public int f(int i8, int i9) {
        return this.f2208b.getDimensionPixelSize(i8, i9);
    }

    public Drawable g(int i8) {
        int resourceId;
        if (this.f2208b.hasValue(i8) && (resourceId = this.f2208b.getResourceId(i8, 0)) != 0) {
            return AppCompatResources.b(this.f2207a, resourceId);
        }
        return this.f2208b.getDrawable(i8);
    }

    public Drawable h(int i8) {
        int resourceId;
        if (this.f2208b.hasValue(i8) && (resourceId = this.f2208b.getResourceId(i8, 0)) != 0) {
            return AppCompatDrawableManager.b().d(this.f2207a, resourceId, true);
        }
        return null;
    }

    public float i(int i8, float f8) {
        return this.f2208b.getFloat(i8, f8);
    }

    public Typeface j(int i8, int i9, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.f2208b.getResourceId(i8, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f2209c == null) {
            this.f2209c = new TypedValue();
        }
        return ResourcesCompat.i(this.f2207a, resourceId, this.f2209c, i9, fontCallback);
    }

    public int k(int i8, int i9) {
        return this.f2208b.getInt(i8, i9);
    }

    public int l(int i8, int i9) {
        return this.f2208b.getInteger(i8, i9);
    }

    public int m(int i8, int i9) {
        return this.f2208b.getLayoutDimension(i8, i9);
    }

    public int n(int i8, int i9) {
        return this.f2208b.getResourceId(i8, i9);
    }

    public String o(int i8) {
        return this.f2208b.getString(i8);
    }

    public CharSequence p(int i8) {
        return this.f2208b.getText(i8);
    }

    public CharSequence[] q(int i8) {
        return this.f2208b.getTextArray(i8);
    }

    public TypedArray r() {
        return this.f2208b;
    }

    public boolean s(int i8) {
        return this.f2208b.hasValue(i8);
    }

    public void w() {
        this.f2208b.recycle();
    }
}
