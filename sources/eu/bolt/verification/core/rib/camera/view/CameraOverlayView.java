package eu.bolt.verification.core.rib.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import eu.bolt.verification.R$color;
import eu.bolt.verification.sdk.internal.uq;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class CameraOverlayView extends View {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f41918f;

    /* renamed from: g  reason: collision with root package name */
    private int f41919g;

    /* renamed from: h  reason: collision with root package name */
    private Path f41920h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f41921i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        Paint paint = new Paint();
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f41918f = paint;
        this.f41919g = uq.d(this, R$color.black);
        this.f41920h = new Path();
        setLayerType(1, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.f(canvas, "canvas");
        super.onDraw(canvas);
        if (getMeasuredWidth() == 0) {
            return;
        }
        canvas.save();
        canvas.drawColor(this.f41919g);
        canvas.drawPath(this.f41920h, this.f41918f);
        Drawable drawable = this.f41921i;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restore();
    }

    public final void setCutoffPath(Path path) {
        Intrinsics.f(path, "path");
        this.f41920h = path;
    }

    public final void setFrameDrawable(Drawable drawable) {
        Intrinsics.f(drawable, "drawable");
        this.f41921i = drawable;
    }

    public final void setOverlayColor(Integer num) {
        if (num != null) {
            this.f41919g = num.intValue();
        }
    }
}
