package ee.mtakso.driver.ui.screens.order.incoming;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserRatingSpan.kt */
/* loaded from: classes3.dex */
public final class UserRatingSpan extends ReplacementSpan {

    /* renamed from: f  reason: collision with root package name */
    private final int f31350f;

    /* renamed from: g  reason: collision with root package name */
    private final Typeface f31351g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31352h;

    /* renamed from: i  reason: collision with root package name */
    private final int f31353i;

    /* renamed from: j  reason: collision with root package name */
    private final Drawable f31354j;

    public UserRatingSpan(Context context, int i8, int i9, Typeface typeface, int i10, int i11) {
        Drawable drawable;
        Intrinsics.f(context, "context");
        Intrinsics.f(typeface, "typeface");
        this.f31350f = i9;
        this.f31351g = typeface;
        this.f31352h = i10;
        this.f31353i = i11;
        Drawable drawable2 = ContextCompat.getDrawable(context, i8);
        if (drawable2 != null) {
            drawable = DrawableCompat.r(drawable2);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            this.f31354j = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            DrawableCompat.n(drawable, i9);
            return;
        }
        throw new IllegalArgumentException("Cannot load drawable res with id " + i8);
    }

    private final void a(Paint paint) {
        int i8;
        paint.setColor(this.f31350f);
        Typeface typeface = paint.getTypeface();
        if (typeface != null) {
            i8 = typeface.getStyle();
        } else {
            i8 = 0;
        }
        if ((i8 & (~this.f31351g.getStyle()) & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        paint.setTypeface(this.f31351g);
    }

    @Override // android.text.style.ReplacementSpan
    @SuppressLint({"RtlHardcoded"})
    public void draw(Canvas canvas, CharSequence charSequence, int i8, int i9, float f8, int i10, int i11, int i12, Paint paint) {
        int i13;
        Intrinsics.f(canvas, "canvas");
        Intrinsics.f(paint, "paint");
        a(paint);
        canvas.save();
        float height = (i10 + ((i12 - i10) / 2)) - (this.f31354j.getBounds().height() / 2);
        if (this.f31352h == 3) {
            canvas.translate(f8, height);
            this.f31354j.draw(canvas);
            canvas.restore();
            Rect bounds = this.f31354j.getBounds();
            Intrinsics.e(bounds, "drawable.bounds");
            i13 = bounds.width() + (this.f31353i / 2);
        } else {
            i13 = this.f31353i / 2;
        }
        float f9 = f8 + i13;
        if (charSequence != null) {
            canvas.drawText(charSequence, i8, i9, f9, i11, paint);
        }
        if (this.f31352h == 5) {
            canvas.translate(f9 + paint.measureText(charSequence, i8, i9) + this.f31353i, height);
            this.f31354j.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i8, int i9, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.f(paint, "paint");
        a(paint);
        Rect bounds = this.f31354j.getBounds();
        Intrinsics.e(bounds, "drawable.bounds");
        return (int) (bounds.width() + paint.measureText(charSequence, i8, i9) + this.f31353i);
    }
}
