package ee.mtakso.driver.uikit.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import ee.mtakso.driver.uikit.R$styleable;
import ee.mtakso.driver.uikit.internal.drawable.IndeterminateCircularProgressDrawable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndeterminateProgressView.kt */
/* loaded from: classes5.dex */
public final class IndeterminateProgressView extends AppCompatImageView {

    /* renamed from: f  reason: collision with root package name */
    private final IndeterminateCircularProgressDrawable f36119f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36120g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f36121h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndeterminateProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndeterminateProgressView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f36121h = new LinkedHashMap();
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = new IndeterminateCircularProgressDrawable();
        this.f36119f = indeterminateCircularProgressDrawable;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f35879u0);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…ndeterminateProgressView)");
        setStrokeWidth(obtainStyledAttributes.getDimension(R$styleable.f35894x0, getStrokeWidth()));
        setColor(obtainStyledAttributes.getColor(R$styleable.f35884v0, getColor()));
        setCornersMode(c(obtainStyledAttributes.getInt(R$styleable.f35889w0, 0)));
        obtainStyledAttributes.recycle();
        setImageDrawable(indeterminateCircularProgressDrawable);
        this.f36120g = true;
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

    private final void d() {
        boolean z7;
        if (!this.f36120g) {
            return;
        }
        if (isAttachedToWindow()) {
            if (getVisibility() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && getWindowVisibility() == 0) {
                if (!this.f36119f.isRunning()) {
                    this.f36119f.start();
                    return;
                }
                return;
            }
        }
        this.f36119f.stop();
    }

    public final int getColor() {
        return this.f36119f.f();
    }

    public final Paint.Cap getCornersMode() {
        return this.f36119f.g();
    }

    public final float getStrokeWidth() {
        return this.f36119f.h();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int i8) {
        Intrinsics.f(changedView, "changedView");
        super.onVisibilityChanged(changedView, i8);
        d();
    }

    public final void setColor(int i8) {
        this.f36119f.i(i8);
    }

    public final void setCornersMode(Paint.Cap value) {
        Intrinsics.f(value, "value");
        this.f36119f.j(value);
    }

    public final void setStrokeWidth(float f8) {
        this.f36119f.n(f8);
        IndeterminateCircularProgressDrawable indeterminateCircularProgressDrawable = this.f36119f;
        indeterminateCircularProgressDrawable.setBounds(0, 0, indeterminateCircularProgressDrawable.getIntrinsicWidth(), this.f36119f.getIntrinsicHeight());
    }

    public /* synthetic */ IndeterminateProgressView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
