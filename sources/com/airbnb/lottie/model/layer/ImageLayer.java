package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public class ImageLayer extends BaseLayer {
    private final Paint D;
    private final Rect E;
    private final Rect F;
    private final LottieImageAsset G;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> H;
    private BaseKeyframeAnimation<Bitmap, Bitmap> I;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.D = new LPaint(3);
        this.E = new Rect();
        this.F = new Rect();
        this.G = lottieDrawable.M(layer.m());
    }

    private Bitmap O() {
        Bitmap h8;
        BaseKeyframeAnimation<Bitmap, Bitmap> baseKeyframeAnimation = this.I;
        if (baseKeyframeAnimation != null && (h8 = baseKeyframeAnimation.h()) != null) {
            return h8;
        }
        Bitmap E = this.f9458p.E(this.f9459q.m());
        if (E != null) {
            return E;
        }
        LottieImageAsset lottieImageAsset = this.G;
        if (lottieImageAsset != null) {
            return lottieImageAsset.a();
        }
        return null;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        super.d(t7, lottieValueCallback);
        if (t7 == LottieProperty.K) {
            if (lottieValueCallback == null) {
                this.H = null;
            } else {
                this.H = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        } else if (t7 == LottieProperty.N) {
            if (lottieValueCallback == null) {
                this.I = null;
            } else {
                this.I = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        super.f(rectF, matrix, z7);
        if (this.G != null) {
            float e8 = Utils.e();
            rectF.set(0.0f, 0.0f, this.G.e() * e8, this.G.c() * e8);
            this.f9457o.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void t(@NonNull Canvas canvas, Matrix matrix, int i8) {
        Bitmap O = O();
        if (O != null && !O.isRecycled() && this.G != null) {
            float e8 = Utils.e();
            this.D.setAlpha(i8);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.H;
            if (baseKeyframeAnimation != null) {
                this.D.setColorFilter(baseKeyframeAnimation.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.E.set(0, 0, O.getWidth(), O.getHeight());
            if (this.f9458p.N()) {
                this.F.set(0, 0, (int) (this.G.e() * e8), (int) (this.G.c() * e8));
            } else {
                this.F.set(0, 0, (int) (O.getWidth() * e8), (int) (O.getHeight() * e8));
            }
            canvas.drawBitmap(O, this.E, this.F, this.D);
            canvas.restore();
        }
    }
}
