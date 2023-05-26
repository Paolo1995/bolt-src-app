package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.components.drawables.IndeterminateCircularProgressDrawable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndeterminateProgressView.kt */
/* loaded from: classes5.dex */
public final class IndeterminateProgressView extends AppCompatImageView {

    /* renamed from: f  reason: collision with root package name */
    private final IndeterminateCircularProgressDrawable f35458f;

    /* renamed from: g  reason: collision with root package name */
    public Map<Integer, View> f35459g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndeterminateProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndeterminateProgressView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35459g = new LinkedHashMap();
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = new IndeterminateCircularProgressDrawable();
        this.f35458f = indeterminateCircularProgressDrawable;
        d(context, attributeSet);
        setImageDrawable(indeterminateCircularProgressDrawable);
        indeterminateCircularProgressDrawable.start();
    }

    private final Paint.Cap c(int i8) {
        if (i8 != 0) {
            if (i8 != 1) {
                return Paint.Cap.BUTT;
            }
            return Paint.Cap.SQUARE;
        }
        return Paint.Cap.ROUND;
    }

    private final void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.G1);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…ndeterminateProgressView)");
        this.f35458f.n(obtainStyledAttributes.getDimension(R$styleable.J1, 10.0f));
        this.f35458f.i(obtainStyledAttributes.getColor(R$styleable.H1, -12303292));
        this.f35458f.j(c(obtainStyledAttributes.getInt(R$styleable.I1, 0)));
        obtainStyledAttributes.recycle();
    }

    public final int getColor() {
        return this.f35458f.f();
    }

    public final Paint.Cap getCornersMode() {
        return this.f35458f.g();
    }

    public final float getStrokeWidth() {
        return this.f35458f.h();
    }

    public final void setColor(int i8) {
        this.f35458f.i(i8);
    }

    public final void setCornersMode(Paint.Cap value) {
        Intrinsics.f(value, "value");
        this.f35458f.j(value);
    }

    public final void setStrokeWidth(float f8) {
        this.f35458f.n(f8);
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = this.f35458f;
        indeterminateCircularProgressDrawable.setBounds(0, 0, indeterminateCircularProgressDrawable.getIntrinsicWidth(), this.f35458f.getIntrinsicHeight());
    }

    public /* synthetic */ IndeterminateProgressView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
