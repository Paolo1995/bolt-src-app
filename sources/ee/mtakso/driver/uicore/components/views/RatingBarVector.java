package ee.mtakso.driver.uicore.components.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.appcompat.widget.AppCompatRatingBar;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uikit.utils.LocaleExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: RatingBarVector.kt */
/* loaded from: classes5.dex */
public final class RatingBarVector extends AppCompatRatingBar {

    /* renamed from: g  reason: collision with root package name */
    private int f35477g;

    /* renamed from: h  reason: collision with root package name */
    private int f35478h;

    /* renamed from: i  reason: collision with root package name */
    private int f35479i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f35480j;

    /* renamed from: k  reason: collision with root package name */
    public Map<Integer, View> f35481k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RatingBarVector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingBarVector(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35481k = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Q2);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.RatingBarVector)");
        this.f35478h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.T2, 0);
        this.f35479i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.S2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.R2);
        if (drawable != null) {
            setProgressDrawableCompat(drawable);
            Unit unit = Unit.f50853a;
        } else {
            Drawable drawable2 = this.f35480j;
            if (drawable2 != null) {
                setProgressDrawable(drawable2);
                Unit unit2 = Unit.f50853a;
            }
        }
        obtainStyledAttributes.recycle();
    }

    @SuppressLint({"RestrictedApi"})
    private final Drawable a(Drawable drawable, boolean z7, Integer num) {
        IntRange o8;
        int v7;
        IntRange o9;
        int v8;
        Set f8;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            o8 = RangesKt___RangesKt.o(0, layerDrawable.getNumberOfLayers());
            v7 = CollectionsKt__IterablesKt.v(o8, 10);
            ArrayList arrayList = new ArrayList(v7);
            Iterator<Integer> it = o8.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                Drawable drawable2 = layerDrawable.getDrawable(nextInt);
                Intrinsics.e(drawable2, "getDrawable(it)");
                f8 = SetsKt__SetsKt.f(16908301, 16908303);
                arrayList.add(a(drawable2, f8.contains(Integer.valueOf(layerDrawable.getId(nextInt))), Integer.valueOf(layerDrawable.getId(nextInt))));
            }
            LayerDrawable layerDrawable2 = new LayerDrawable((Drawable[]) arrayList.toArray(new Drawable[0]));
            o9 = RangesKt___RangesKt.o(0, layerDrawable.getNumberOfLayers());
            v8 = CollectionsKt__IterablesKt.v(o9, 10);
            ArrayList arrayList2 = new ArrayList(v8);
            Iterator<Integer> it2 = o9.iterator();
            while (it2.hasNext()) {
                int nextInt2 = ((IntIterator) it2).nextInt();
                layerDrawable2.setId(nextInt2, layerDrawable.getId(nextInt2));
                arrayList2.add(Unit.f50853a);
            }
            return layerDrawable2;
        } else if (drawable instanceof DrawableWrapperCompat) {
            ((DrawableWrapperCompat) drawable).a(a(drawable, z7, null));
            return drawable;
        } else {
            return b(c(drawable, this.f35479i, this.f35478h, num), drawable.getColorFilter(), z7);
        }
    }

    private final Drawable b(Bitmap bitmap, ColorFilter colorFilter, boolean z7) {
        if (this.f35477g == 0) {
            this.f35477g = bitmap.getWidth();
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
        if (colorFilter != null) {
            shapeDrawable.getPaint().setColorFilter(colorFilter);
        }
        shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        if (z7) {
            return new ClipDrawable(shapeDrawable, 8388611, 1);
        }
        return shapeDrawable;
    }

    private final Bitmap c(Drawable drawable, int i8, int i9, Integer num) {
        float f8;
        int i10;
        if (i8 > 0 && drawable.getIntrinsicWidth() != 0) {
            f8 = i8 / drawable.getIntrinsicWidth();
        } else {
            f8 = 1.0f;
        }
        Bitmap bitmap = Bitmap.createBitmap(((int) (drawable.getIntrinsicWidth() * f8)) + i9, (int) (drawable.getIntrinsicHeight() * f8), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.save();
        canvas.scale(f8, f8);
        if (num == null || num.intValue() != 16908301) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int i11 = i9 / 2;
        drawable.setBounds(new Rect(i11 + i10, i10, (drawable.getIntrinsicWidth() + i11) - i10, drawable.getIntrinsicHeight() - i10));
        drawable.draw(canvas);
        canvas.restore();
        Intrinsics.e(bitmap, "bitmap");
        return bitmap;
    }

    private final Shape getDrawableShape() {
        return new RoundRectShape(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, null, null);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.e(locale, "getDefault()");
        if (LocaleExtKt.b(locale)) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.scale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        super.onDraw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatRatingBar, android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        int i10 = this.f35477g;
        if (i10 != 0) {
            setMeasuredDimension(View.resolveSizeAndState(i10 * getNumStars(), i8, 0), getMeasuredHeight());
        }
    }

    public final void setProgressDrawableCompat(Drawable drawable) {
        Intrinsics.f(drawable, "drawable");
        this.f35480j = drawable;
        this.f35477g = 0;
        Drawable a8 = a(drawable, false, null);
        Intrinsics.d(a8, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        super.setProgressDrawable((LayerDrawable) a8);
        requestLayout();
    }

    public /* synthetic */ RatingBarVector(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.f34584p : i8);
    }
}
