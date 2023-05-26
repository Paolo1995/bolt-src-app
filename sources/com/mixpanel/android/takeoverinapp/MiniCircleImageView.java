package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class MiniCircleImageView extends ImageView {

    /* renamed from: f  reason: collision with root package name */
    private Paint f19408f;

    /* renamed from: g  reason: collision with root package name */
    private int f19409g;

    /* renamed from: h  reason: collision with root package name */
    private int f19410h;

    public MiniCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        int color;
        Paint paint = new Paint(1);
        this.f19408f = paint;
        if (Build.VERSION.SDK_INT >= 23) {
            color = getResources().getColor(17170443, null);
            paint.setColor(color);
        } else {
            paint.setColor(getResources().getColor(17170443));
        }
        this.f19408f.setStyle(Paint.Style.STROKE);
        this.f19408f.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f19409g = i8;
        this.f19410h = i9;
    }
}
