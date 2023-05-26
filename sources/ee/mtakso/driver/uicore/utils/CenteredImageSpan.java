package ee.mtakso.driver.uicore.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CenteredImageSpan.kt */
/* loaded from: classes5.dex */
public final class CenteredImageSpan extends ImageSpan {

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<Drawable> f35724f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenteredImageSpan(Context context, int i8) {
        super(context, i8);
        Intrinsics.f(context, "context");
    }

    private final Drawable a() {
        Drawable drawable;
        WeakReference<Drawable> weakReference = this.f35724f;
        if (weakReference == null || (drawable = weakReference.get()) == null) {
            Drawable drawable2 = getDrawable();
            this.f35724f = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i8, int i9, float f8, int i10, int i11, int i12, Paint paint) {
        Intrinsics.f(canvas, "canvas");
        Intrinsics.f(text, "text");
        Intrinsics.f(paint, "paint");
        Drawable a8 = a();
        if (a8 != null) {
            canvas.save();
            int intrinsicHeight = a8.getIntrinsicHeight();
            canvas.translate(f8, (i12 - a8.getBounds().bottom) + (((intrinsicHeight - paint.getFontMetricsInt().descent) + paint.getFontMetricsInt().ascent) / 2));
            a8.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int i8, int i9, Paint.FontMetricsInt fontMetricsInt) {
        Rect rect;
        Intrinsics.f(paint, "paint");
        Intrinsics.f(text, "text");
        Drawable a8 = a();
        if (a8 != null) {
            rect = a8.getBounds();
        } else {
            rect = null;
        }
        if (rect == null) {
            return 0;
        }
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return rect.right;
    }
}
