package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes.dex */
class CutoutDrawable extends MaterialShapeDrawable {
    @NonNull
    protected final RectF E;

    @TargetApi(18)
    /* loaded from: classes.dex */
    private static class ImplApi18 extends CutoutDrawable {
        ImplApi18(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public void r(@NonNull Canvas canvas) {
            if (this.E.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.E);
            } else {
                canvas.clipRect(this.E, Region.Op.DIFFERENCE);
            }
            super.r(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CutoutDrawable r0(ShapeAppearanceModel shapeAppearanceModel) {
        return new ImplApi18(shapeAppearanceModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s0() {
        return !this.E.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0() {
        u0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void u0(float f8, float f9, float f10, float f11) {
        RectF rectF = this.E;
        if (f8 != rectF.left || f9 != rectF.top || f10 != rectF.right || f11 != rectF.bottom) {
            rectF.set(f8, f9, f10, f11);
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v0(@NonNull RectF rectF) {
        u0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private CutoutDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new ShapeAppearanceModel() : shapeAppearanceModel);
        this.E = new RectF();
    }
}
