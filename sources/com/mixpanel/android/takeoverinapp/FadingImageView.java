package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class FadingImageView extends ImageView {

    /* renamed from: f  reason: collision with root package name */
    private Matrix f19400f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f19401g;

    /* renamed from: h  reason: collision with root package name */
    private Shader f19402h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f19403i;

    /* renamed from: j  reason: collision with root package name */
    private Shader f19404j;

    /* renamed from: k  reason: collision with root package name */
    private int f19405k;

    /* renamed from: l  reason: collision with root package name */
    private int f19406l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19407m;

    public FadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        this.f19400f = new Matrix();
        this.f19401g = new Paint();
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{-16777216, -16777216, -452984832, 0}, new float[]{0.0f, 0.2f, 0.4f, 1.0f}, Shader.TileMode.CLAMP);
        this.f19402h = linearGradient;
        this.f19401g.setShader(linearGradient);
        this.f19401g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f19403i = new Paint();
        LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{0, 0, -16777216, -16777216}, new float[]{0.0f, 0.85f, 0.98f, 1.0f}, Shader.TileMode.CLAMP);
        this.f19404j = linearGradient2;
        this.f19403i.setShader(linearGradient2);
        this.f19401g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void b(boolean z7) {
        this.f19407m = z7;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int saveLayer;
        if (this.f19407m) {
            Rect clipBounds = canvas.getClipBounds();
            if (Build.VERSION.SDK_INT >= 26) {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, clipBounds.width(), clipBounds.height(), null);
            } else {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, clipBounds.width(), clipBounds.height(), null, 31);
            }
            super.draw(canvas);
            canvas.drawRect(0.0f, 0.0f, this.f19406l, this.f19405k, this.f19401g);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (this.f19407m) {
            this.f19405k = getMeasuredHeight();
            this.f19406l = getMeasuredWidth();
            this.f19400f.setScale(1.0f, View.MeasureSpec.getSize(i9));
            this.f19402h.setLocalMatrix(this.f19400f);
            this.f19404j.setLocalMatrix(this.f19400f);
        }
    }
}
