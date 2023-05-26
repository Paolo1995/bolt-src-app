package eu.bolt.client.design.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class DesignPointingTriangleView extends View {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f40035f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f40036g;

    /* renamed from: h  reason: collision with root package name */
    private final a f40037h;

    /* loaded from: classes5.dex */
    public enum a {
        START,
        TOP,
        BOTTOM
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40042a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f40042a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignPointingTriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        Intrinsics.f(attributeSet, "attributeSet");
        Paint paint = new Paint();
        this.f40035f = paint;
        this.f40036g = new Path();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.E1, 0, 0);
        Intrinsics.e(obtainStyledAttributes, "context.theme.obtainStyl…angleView, 0, 0\n        )");
        int integer = obtainStyledAttributes.getInteger(R$styleable.F1, 0);
        int color = obtainStyledAttributes.getColor(R$styleable.G1, 0);
        if (color != 0) {
            setColor(color);
        } else {
            setColor(ContextCompat.getColor(context, R$color.green_500));
        }
        this.f40037h = integer != 0 ? integer != 1 ? a.BOTTOM : a.TOP : a.START;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    private final void a(float f8, float f9, Canvas canvas) {
        if (uq.Z(this)) {
            float f10 = f9 / 2;
            this.f40036g.moveTo(f8, f10);
            this.f40036g.lineTo(0.0f, 0.0f);
            this.f40036g.lineTo(0.0f, f9);
            this.f40036g.lineTo(f8, f10);
        } else {
            float f11 = f9 / 2;
            this.f40036g.moveTo(0.0f, f11);
            this.f40036g.lineTo(f8, f9);
            this.f40036g.lineTo(f8, 0.0f);
            this.f40036g.lineTo(0.0f, f11);
        }
        canvas.drawPath(this.f40036g, this.f40035f);
    }

    private final void b(float f8, float f9, Canvas canvas) {
        float f10 = 2;
        float f11 = f8 / f10;
        float f12 = f9 / f10;
        this.f40036g.moveTo(f11, f12);
        this.f40036g.lineTo(0.0f, f9);
        this.f40036g.lineTo(f8, f9);
        this.f40036g.lineTo(f11, f12);
        canvas.drawPath(this.f40036g, this.f40035f);
    }

    public final a getDirection() {
        return this.f40037h;
    }

    public final Paint getP() {
        return this.f40035f;
    }

    public final Path getPath() {
        return this.f40036g;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        float width = getWidth();
        float height = getHeight();
        a aVar = this.f40037h;
        int i8 = aVar == null ? -1 : b.f40042a[aVar.ordinal()];
        if (i8 == 1) {
            a(width, height, canvas);
        } else if (i8 != 2) {
        } else {
            b(width, height, canvas);
        }
    }

    public final void setColor(int i8) {
        this.f40035f.setColor(i8);
        invalidate();
    }
}
