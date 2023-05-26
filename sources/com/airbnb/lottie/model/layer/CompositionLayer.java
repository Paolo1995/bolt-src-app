package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CompositionLayer extends BaseLayer {
    private BaseKeyframeAnimation<Float, Float> D;
    private final List<BaseLayer> E;
    private final RectF F;
    private final RectF G;
    private final Paint H;
    private boolean I;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9471a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f9471a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9471a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i8;
        BaseLayer baseLayer;
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.I = true;
        AnimatableFloatValue u7 = layer.u();
        if (u7 != null) {
            BaseKeyframeAnimation<Float, Float> a8 = u7.a();
            this.D = a8;
            i(a8);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.k().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer u8 = BaseLayer.u(this, layer2, lottieDrawable, lottieComposition);
            if (u8 != null) {
                longSparseArray.l(u8.y().d(), u8);
                if (baseLayer2 != null) {
                    baseLayer2.I(u8);
                    baseLayer2 = null;
                } else {
                    this.E.add(0, u8);
                    int i9 = AnonymousClass1.f9471a[layer2.h().ordinal()];
                    if (i9 == 1 || i9 == 2) {
                        baseLayer2 = u8;
                    }
                }
            }
            size--;
        }
        for (i8 = 0; i8 < longSparseArray.o(); i8++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.f(longSparseArray.k(i8));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.f(baseLayer3.y().j())) != null) {
                baseLayer3.K(baseLayer);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected void H(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        for (int i9 = 0; i9 < this.E.size(); i9++) {
            this.E.get(i9).e(keyPath, i8, list, keyPath2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void J(boolean z7) {
        super.J(z7);
        for (BaseLayer baseLayer : this.E) {
            baseLayer.J(z7);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void L(float f8) {
        super.L(f8);
        if (this.D != null) {
            f8 = ((this.D.h().floatValue() * this.f9459q.b().i()) - this.f9459q.b().p()) / (this.f9458p.G().e() + 0.01f);
        }
        if (this.D == null) {
            f8 -= this.f9459q.r();
        }
        if (this.f9459q.v() != 0.0f && !"__container".equals(this.f9459q.i())) {
            f8 /= this.f9459q.v();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.E.get(size).L(f8);
        }
    }

    public void O(boolean z7) {
        this.I = z7;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        super.d(t7, lottieValueCallback);
        if (t7 == LottieProperty.E) {
            if (lottieValueCallback == null) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.D;
                if (baseKeyframeAnimation != null) {
                    baseKeyframeAnimation.n(null);
                    return;
                }
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.D = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            i(this.D);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        super.f(rectF, matrix, z7);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.E.get(size).f(this.F, this.f9457o, true);
            rectF.union(this.F);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void t(Canvas canvas, Matrix matrix, int i8) {
        boolean z7;
        boolean z8;
        boolean z9;
        L.a("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.f9459q.l(), this.f9459q.k());
        matrix.mapRect(this.G);
        if (this.f9458p.b0() && this.E.size() > 1 && i8 != 255) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.H.setAlpha(i8);
            Utils.m(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z7) {
            i8 = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (!this.I && "__container".equals(this.f9459q.i())) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (!z8 && !this.G.isEmpty()) {
                z9 = canvas.clipRect(this.G);
            } else {
                z9 = true;
            }
            if (z9) {
                this.E.get(size).h(canvas, matrix, i8);
            }
        }
        canvas.restore();
        L.b("CompositionLayer#draw");
    }
}
