package com.clevertap.android.sdk.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.clevertap.android.sdk.Logger;

/* loaded from: classes.dex */
public final class CloseImageView extends AppCompatImageView {

    /* renamed from: f  reason: collision with root package name */
    private final int f11093f;

    @SuppressLint({"ResourceType"})
    public CloseImageView(Context context) {
        super(context);
        this.f11093f = c(40);
        setId(199272);
    }

    private int c(int i8) {
        return (int) TypedValue.applyDimension(1, i8, getResources().getDisplayMetrics());
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Context context = getContext();
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier("ct_close", "drawable", context.getPackageName()), null);
            if (decodeResource != null) {
                int i8 = this.f11093f;
                canvas.drawBitmap(Bitmap.createScaledBitmap(decodeResource, i8, i8, true), 0.0f, 0.0f, new Paint());
            } else {
                Logger.n("Unable to find inapp notif close button image");
            }
        } catch (Throwable th) {
            Logger.q("Error displaying the inapp notif close button image:", th);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i8, int i9) {
        int i10 = this.f11093f;
        setMeasuredDimension(i10, i10);
    }

    @SuppressLint({"ResourceType"})
    public CloseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11093f = c(40);
        setId(199272);
    }
}
