package ee.mtakso.driver.uikit.internal.drawable;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import ee.mtakso.driver.uikit.utils.Dimens;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RippleDrawableHelper.kt */
/* loaded from: classes5.dex */
public final class RippleDrawableHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final RippleDrawableHelper f35939a = new RippleDrawableHelper();

    private RippleDrawableHelper() {
    }

    private final ColorStateList b(int i8) {
        return new ColorStateList(new int[][]{new int[]{16842919}}, new int[]{i8});
    }

    private final InsetDrawable d(Integer num, CornerRadiuses cornerRadiuses, float f8, Paint.Style style, Rect rect) {
        StrokeShapeDrawable strokeShapeDrawable = new StrokeShapeDrawable(new RoundRectShape(new float[]{cornerRadiuses.c(), cornerRadiuses.c(), cornerRadiuses.d(), cornerRadiuses.d(), cornerRadiuses.b(), cornerRadiuses.b(), cornerRadiuses.a(), cornerRadiuses.a()}, null, null));
        if (num != null) {
            if (style == Paint.Style.FILL) {
                strokeShapeDrawable.d(num.intValue());
            } else if (style == Paint.Style.STROKE) {
                strokeShapeDrawable.e(num.intValue());
                strokeShapeDrawable.f(f8);
                strokeShapeDrawable.d(0);
            }
        }
        return new InsetDrawable((Drawable) strokeShapeDrawable, rect.left, rect.top, rect.right, rect.bottom);
    }

    static /* synthetic */ InsetDrawable e(RippleDrawableHelper rippleDrawableHelper, Integer num, CornerRadiuses cornerRadiuses, float f8, Paint.Style style, Rect rect, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i8 & 4) != 0) {
            f8 = Dimens.b(2.0f);
        }
        float f9 = f8;
        if ((i8 & 16) != 0) {
            rect = new Rect();
        }
        return rippleDrawableHelper.d(num2, cornerRadiuses, f9, style, rect);
    }

    public final void a(View view, int i8, int i9) {
        Intrinsics.f(view, "<this>");
        Paint.Style style = Paint.Style.FILL;
        view.setBackground(c(i8, i9, new CornerRadiuses(0.0f, 0.0f, 0.0f, 0.0f), Dimens.b(2.0f), style, new Rect()));
    }

    public final Drawable c(int i8, int i9, CornerRadiuses borderCorners, float f8, Paint.Style style, Rect insets) {
        Intrinsics.f(borderCorners, "borderCorners");
        Intrinsics.f(style, "style");
        Intrinsics.f(insets, "insets");
        RippleDrawable rippleDrawable = new RippleDrawable(b(i9), d(Integer.valueOf(i8), borderCorners, f8, style, insets), e(this, null, borderCorners, f8, Paint.Style.FILL, null, 16, null));
        rippleDrawable.setColor(new ColorStateList(new int[][]{new int[]{16842910}}, new int[]{i9}));
        return rippleDrawable;
    }

    /* compiled from: RippleDrawableHelper.kt */
    /* loaded from: classes5.dex */
    public static final class CornerRadiuses {

        /* renamed from: a  reason: collision with root package name */
        private final float f35940a;

        /* renamed from: b  reason: collision with root package name */
        private final float f35941b;

        /* renamed from: c  reason: collision with root package name */
        private final float f35942c;

        /* renamed from: d  reason: collision with root package name */
        private final float f35943d;

        public CornerRadiuses() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }

        public CornerRadiuses(float f8, float f9, float f10, float f11) {
            this.f35940a = f8;
            this.f35941b = f9;
            this.f35942c = f10;
            this.f35943d = f11;
        }

        public final float a() {
            return this.f35943d;
        }

        public final float b() {
            return this.f35942c;
        }

        public final float c() {
            return this.f35940a;
        }

        public final float d() {
            return this.f35941b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CornerRadiuses) {
                CornerRadiuses cornerRadiuses = (CornerRadiuses) obj;
                return Float.compare(this.f35940a, cornerRadiuses.f35940a) == 0 && Float.compare(this.f35941b, cornerRadiuses.f35941b) == 0 && Float.compare(this.f35942c, cornerRadiuses.f35942c) == 0 && Float.compare(this.f35943d, cornerRadiuses.f35943d) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f35940a) * 31) + Float.floatToIntBits(this.f35941b)) * 31) + Float.floatToIntBits(this.f35942c)) * 31) + Float.floatToIntBits(this.f35943d);
        }

        public String toString() {
            float f8 = this.f35940a;
            float f9 = this.f35941b;
            float f10 = this.f35942c;
            float f11 = this.f35943d;
            return "CornerRadiuses(topLeftRoundRadius=" + f8 + ", topRightRoundRadius=" + f9 + ", bottomRightRoundRadius=" + f10 + ", bottomLeftRoundRadius=" + f11 + ")";
        }

        public /* synthetic */ CornerRadiuses(float f8, float f9, float f10, float f11, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? 0.0f : f8, (i8 & 2) != 0 ? 0.0f : f9, (i8 & 4) != 0 ? 0.0f : f10, (i8 & 8) != 0 ? 0.0f : f11);
        }
    }
}
