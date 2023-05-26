package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;

/* loaded from: classes.dex */
public class ShadowRenderer {

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f13963i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f13964j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f13965k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f13966l = {0.0f, 0.0f, 0.5f, 1.0f};
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Paint f13967a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f13968b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Paint f13969c;

    /* renamed from: d  reason: collision with root package name */
    private int f13970d;

    /* renamed from: e  reason: collision with root package name */
    private int f13971e;

    /* renamed from: f  reason: collision with root package name */
    private int f13972f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f13973g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f13974h;

    public ShadowRenderer() {
        this(-16777216);
    }

    public void a(@NonNull Canvas canvas, Matrix matrix, @NonNull RectF rectF, int i8, float f8, float f9) {
        boolean z7;
        if (f9 < 0.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        Path path = this.f13973g;
        if (z7) {
            int[] iArr = f13965k;
            iArr[0] = 0;
            iArr[1] = this.f13972f;
            iArr[2] = this.f13971e;
            iArr[3] = this.f13970d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f8, f9);
            path.close();
            float f10 = -i8;
            rectF.inset(f10, f10);
            int[] iArr2 = f13965k;
            iArr2[0] = 0;
            iArr2[1] = this.f13970d;
            iArr2[2] = this.f13971e;
            iArr2[3] = this.f13972f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f11 = 1.0f - (i8 / width);
        float[] fArr = f13966l;
        fArr[1] = f11;
        fArr[2] = ((1.0f - f11) / 2.0f) + f11;
        this.f13968b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f13965k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z7) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f13974h);
        }
        canvas.drawArc(rectF, f8, f9, true, this.f13968b);
        canvas.restore();
    }

    public void b(@NonNull Canvas canvas, Matrix matrix, @NonNull RectF rectF, int i8) {
        rectF.bottom += i8;
        rectF.offset(0.0f, -i8);
        int[] iArr = f13963i;
        iArr[0] = this.f13972f;
        iArr[1] = this.f13971e;
        iArr[2] = this.f13970d;
        Paint paint = this.f13969c;
        float f8 = rectF.left;
        paint.setShader(new LinearGradient(f8, rectF.top, f8, rectF.bottom, iArr, f13964j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f13969c);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.f13967a;
    }

    public void d(int i8) {
        this.f13970d = ColorUtils.j(i8, 68);
        this.f13971e = ColorUtils.j(i8, 20);
        this.f13972f = ColorUtils.j(i8, 0);
        this.f13967a.setColor(this.f13970d);
    }

    public ShadowRenderer(int i8) {
        this.f13973g = new Path();
        Paint paint = new Paint();
        this.f13974h = paint;
        this.f13967a = new Paint();
        d(i8);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f13968b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f13969c = new Paint(paint2);
    }
}
