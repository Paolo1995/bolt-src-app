package ee.mtakso.driver.uicore.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import ee.mtakso.driver.uicore.components.drawables.StrokeShapeDrawable;
import ee.mtakso.driver.uikit.R$attr;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RippleProvider.kt */
/* loaded from: classes5.dex */
public final class RippleProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final RippleProvider f35730a = new RippleProvider();

    private RippleProvider() {
    }

    public static /* synthetic */ void b(RippleProvider rippleProvider, View view, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            Context context = view.getContext();
            Intrinsics.e(context, "context");
            i9 = ContextUtilsKt.b(context, R$attr.f35747y);
        }
        rippleProvider.a(view, i8, i9);
    }

    private final ColorStateList c(int i8) {
        return new ColorStateList(new int[][]{new int[]{16842919}}, new int[]{i8});
    }

    private final StrokeShapeDrawable e(Integer num, CornerRadiuses cornerRadiuses, float f8, Paint.Style style) {
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
        return strokeShapeDrawable;
    }

    public final void a(View view, int i8, int i9) {
        Intrinsics.f(view, "<this>");
        Paint.Style style = Paint.Style.FILL;
        view.setBackground(d(i8, i9, new CornerRadiuses(0.0f, 0.0f, 0.0f, 0.0f), Dimens.c(2.0f), Paint.Style.FILL));
    }

    public final Drawable d(int i8, int i9, CornerRadiuses borderCorners, float f8, Paint.Style style) {
        Intrinsics.f(borderCorners, "borderCorners");
        Intrinsics.f(style, "style");
        RippleDrawable rippleDrawable = new RippleDrawable(c(i9), e(Integer.valueOf(i8), borderCorners, f8, style), e(null, borderCorners, f8, Paint.Style.FILL));
        rippleDrawable.setColor(new ColorStateList(new int[][]{new int[]{16842910}}, new int[]{i9}));
        return rippleDrawable;
    }

    /* compiled from: RippleProvider.kt */
    /* loaded from: classes5.dex */
    public static final class CornerRadiuses {

        /* renamed from: a  reason: collision with root package name */
        private final float f35731a;

        /* renamed from: b  reason: collision with root package name */
        private final float f35732b;

        /* renamed from: c  reason: collision with root package name */
        private final float f35733c;

        /* renamed from: d  reason: collision with root package name */
        private final float f35734d;

        public CornerRadiuses() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }

        public CornerRadiuses(float f8, float f9, float f10, float f11) {
            this.f35731a = f8;
            this.f35732b = f9;
            this.f35733c = f10;
            this.f35734d = f11;
        }

        public final float a() {
            return this.f35734d;
        }

        public final float b() {
            return this.f35733c;
        }

        public final float c() {
            return this.f35731a;
        }

        public final float d() {
            return this.f35732b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CornerRadiuses) {
                CornerRadiuses cornerRadiuses = (CornerRadiuses) obj;
                return Float.compare(this.f35731a, cornerRadiuses.f35731a) == 0 && Float.compare(this.f35732b, cornerRadiuses.f35732b) == 0 && Float.compare(this.f35733c, cornerRadiuses.f35733c) == 0 && Float.compare(this.f35734d, cornerRadiuses.f35734d) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.f35731a) * 31) + Float.floatToIntBits(this.f35732b)) * 31) + Float.floatToIntBits(this.f35733c)) * 31) + Float.floatToIntBits(this.f35734d);
        }

        public String toString() {
            float f8 = this.f35731a;
            float f9 = this.f35732b;
            float f10 = this.f35733c;
            float f11 = this.f35734d;
            return "CornerRadiuses(topLeftRoundRadius=" + f8 + ", topRightRoundRadius=" + f9 + ", bottomRightRoundRadius=" + f10 + ", bottomLeftRoundRadius=" + f11 + ")";
        }

        public /* synthetic */ CornerRadiuses(float f8, float f9, float f10, float f11, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? 0.0f : f8, (i8 & 2) != 0 ? 0.0f : f9, (i8 & 4) != 0 ? 0.0f : f10, (i8 & 8) != 0 ? 0.0f : f11);
        }
    }
}
