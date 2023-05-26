package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f9022e;

    /* renamed from: f  reason: collision with root package name */
    protected final BaseLayer f9023f;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f9025h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f9026i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9027j;

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Integer> f9028k;

    /* renamed from: l  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<?, Float>> f9029l;

    /* renamed from: m  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f9030m;

    /* renamed from: n  reason: collision with root package name */
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> f9031n;

    /* renamed from: o  reason: collision with root package name */
    private BaseKeyframeAnimation<Float, Float> f9032o;

    /* renamed from: p  reason: collision with root package name */
    float f9033p;

    /* renamed from: q  reason: collision with root package name */
    private DropShadowKeyframeAnimation f9034q;

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f9018a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f9019b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f9020c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f9021d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final List<PathGroup> f9024g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class PathGroup {

        /* renamed from: a  reason: collision with root package name */
        private final List<PathContent> f9035a;

        /* renamed from: b  reason: collision with root package name */
        private final TrimPathContent f9036b;

        private PathGroup(TrimPathContent trimPathContent) {
            this.f9035a = new ArrayList();
            this.f9036b = trimPathContent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f8, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f9026i = lPaint;
        this.f9033p = 0.0f;
        this.f9022e = lottieDrawable;
        this.f9023f = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f8);
        this.f9028k = animatableIntegerValue.a();
        this.f9027j = animatableFloatValue.a();
        if (animatableFloatValue2 == null) {
            this.f9030m = null;
        } else {
            this.f9030m = animatableFloatValue2.a();
        }
        this.f9029l = new ArrayList(list.size());
        this.f9025h = new float[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.f9029l.add(list.get(i8).a());
        }
        baseLayer.i(this.f9028k);
        baseLayer.i(this.f9027j);
        for (int i9 = 0; i9 < this.f9029l.size(); i9++) {
            baseLayer.i(this.f9029l.get(i9));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f9030m;
        if (baseKeyframeAnimation != null) {
            baseLayer.i(baseKeyframeAnimation);
        }
        this.f9028k.a(this);
        this.f9027j.a(this);
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f9029l.get(i10).a(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f9030m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(this);
        }
        if (baseLayer.v() != null) {
            BaseKeyframeAnimation<Float, Float> a8 = baseLayer.v().a().a();
            this.f9032o = a8;
            a8.a(this);
            baseLayer.i(this.f9032o);
        }
        if (baseLayer.x() != null) {
            this.f9034q = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.x());
        }
    }

    private void g(Matrix matrix) {
        float floatValue;
        L.a("StrokeContent#applyDashPattern");
        if (this.f9029l.isEmpty()) {
            L.b("StrokeContent#applyDashPattern");
            return;
        }
        float g8 = Utils.g(matrix);
        for (int i8 = 0; i8 < this.f9029l.size(); i8++) {
            this.f9025h[i8] = this.f9029l.get(i8).h().floatValue();
            if (i8 % 2 == 0) {
                float[] fArr = this.f9025h;
                if (fArr[i8] < 1.0f) {
                    fArr[i8] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f9025h;
                if (fArr2[i8] < 0.1f) {
                    fArr2[i8] = 0.1f;
                }
            }
            float[] fArr3 = this.f9025h;
            fArr3[i8] = fArr3[i8] * g8;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f9030m;
        if (baseKeyframeAnimation == null) {
            floatValue = 0.0f;
        } else {
            floatValue = g8 * baseKeyframeAnimation.h().floatValue();
        }
        this.f9026i.setPathEffect(new DashPathEffect(this.f9025h, floatValue));
        L.b("StrokeContent#applyDashPattern");
    }

    private void i(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        float f8;
        float f9;
        float f10;
        L.a("StrokeContent#applyTrimPath");
        if (pathGroup.f9036b == null) {
            L.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f9019b.reset();
        for (int size = pathGroup.f9035a.size() - 1; size >= 0; size--) {
            this.f9019b.addPath(((PathContent) pathGroup.f9035a.get(size)).getPath(), matrix);
        }
        float floatValue = pathGroup.f9036b.i().h().floatValue() / 100.0f;
        float floatValue2 = pathGroup.f9036b.e().h().floatValue() / 100.0f;
        float floatValue3 = pathGroup.f9036b.g().h().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.f9019b, this.f9026i);
            L.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f9018a.setPath(this.f9019b, false);
        float length = this.f9018a.getLength();
        while (this.f9018a.nextContour()) {
            length += this.f9018a.getLength();
        }
        float f11 = floatValue3 * length;
        float f12 = (floatValue * length) + f11;
        float min = Math.min((floatValue2 * length) + f11, (f12 + length) - 1.0f);
        float f13 = 0.0f;
        for (int size2 = pathGroup.f9035a.size() - 1; size2 >= 0; size2--) {
            this.f9020c.set(((PathContent) pathGroup.f9035a.get(size2)).getPath());
            this.f9020c.transform(matrix);
            this.f9018a.setPath(this.f9020c, false);
            float length2 = this.f9018a.getLength();
            if (min > length) {
                float f14 = min - length;
                if (f14 < f13 + length2 && f13 < f14) {
                    if (f12 > length) {
                        f10 = (f12 - length) / length2;
                    } else {
                        f10 = 0.0f;
                    }
                    Utils.a(this.f9020c, f10, Math.min(f14 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f9020c, this.f9026i);
                    f13 += length2;
                }
            }
            float f15 = f13 + length2;
            if (f15 >= f12 && f13 <= min) {
                if (f15 <= min && f12 < f13) {
                    canvas.drawPath(this.f9020c, this.f9026i);
                } else {
                    if (f12 < f13) {
                        f8 = 0.0f;
                    } else {
                        f8 = (f12 - f13) / length2;
                    }
                    if (min > f15) {
                        f9 = 1.0f;
                    } else {
                        f9 = (min - f13) / length2;
                    }
                    Utils.a(this.f9020c, f8, f9, 0.0f);
                    canvas.drawPath(this.f9020c, this.f9026i);
                }
            }
            f13 += length2;
        }
        L.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f9022e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.d(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.f9024g.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3);
                    trimPathContent3.d(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent);
                }
                pathGroup.f9035a.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.f9024g.add(pathGroup);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t7 == LottieProperty.f8935d) {
            this.f9028k.n(lottieValueCallback);
        } else if (t7 == LottieProperty.f8950s) {
            this.f9027j.n(lottieValueCallback);
        } else if (t7 == LottieProperty.K) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9031n;
            if (baseKeyframeAnimation != null) {
                this.f9023f.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f9031n = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9031n = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f9023f.i(this.f9031n);
        } else if (t7 == LottieProperty.f8941j) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f9032o;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.n(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f9032o = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            this.f9023f.i(this.f9032o);
        } else if (t7 == LottieProperty.f8936e && (dropShadowKeyframeAnimation5 = this.f9034q) != null) {
            dropShadowKeyframeAnimation5.c(lottieValueCallback);
        } else if (t7 == LottieProperty.G && (dropShadowKeyframeAnimation4 = this.f9034q) != null) {
            dropShadowKeyframeAnimation4.f(lottieValueCallback);
        } else if (t7 == LottieProperty.H && (dropShadowKeyframeAnimation3 = this.f9034q) != null) {
            dropShadowKeyframeAnimation3.d(lottieValueCallback);
        } else if (t7 == LottieProperty.I && (dropShadowKeyframeAnimation2 = this.f9034q) != null) {
            dropShadowKeyframeAnimation2.e(lottieValueCallback);
        } else if (t7 == LottieProperty.J && (dropShadowKeyframeAnimation = this.f9034q) != null) {
            dropShadowKeyframeAnimation.g(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i8, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        L.a("StrokeContent#getBounds");
        this.f9019b.reset();
        for (int i8 = 0; i8 < this.f9024g.size(); i8++) {
            PathGroup pathGroup = this.f9024g.get(i8);
            for (int i9 = 0; i9 < pathGroup.f9035a.size(); i9++) {
                this.f9019b.addPath(((PathContent) pathGroup.f9035a.get(i9)).getPath(), matrix);
            }
        }
        this.f9019b.computeBounds(this.f9021d, false);
        float p8 = ((FloatKeyframeAnimation) this.f9027j).p();
        RectF rectF2 = this.f9021d;
        float f8 = p8 / 2.0f;
        rectF2.set(rectF2.left - f8, rectF2.top - f8, rectF2.right + f8, rectF2.bottom + f8);
        rectF.set(this.f9021d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        L.a("StrokeContent#draw");
        if (Utils.h(matrix)) {
            L.b("StrokeContent#draw");
            return;
        }
        this.f9026i.setAlpha(MiscUtils.c((int) ((((i8 / 255.0f) * ((IntegerKeyframeAnimation) this.f9028k).p()) / 100.0f) * 255.0f), 0, 255));
        this.f9026i.setStrokeWidth(((FloatKeyframeAnimation) this.f9027j).p() * Utils.g(matrix));
        if (this.f9026i.getStrokeWidth() <= 0.0f) {
            L.b("StrokeContent#draw");
            return;
        }
        g(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f9031n;
        if (baseKeyframeAnimation != null) {
            this.f9026i.setColorFilter(baseKeyframeAnimation.h());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.f9032o;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f9026i.setMaskFilter(null);
            } else if (floatValue != this.f9033p) {
                this.f9026i.setMaskFilter(this.f9023f.w(floatValue));
            }
            this.f9033p = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f9034q;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.b(this.f9026i);
        }
        for (int i9 = 0; i9 < this.f9024g.size(); i9++) {
            PathGroup pathGroup = this.f9024g.get(i9);
            if (pathGroup.f9036b != null) {
                i(canvas, pathGroup, matrix);
            } else {
                L.a("StrokeContent#buildPath");
                this.f9019b.reset();
                for (int size = pathGroup.f9035a.size() - 1; size >= 0; size--) {
                    this.f9019b.addPath(((PathContent) pathGroup.f9035a.get(size)).getPath(), matrix);
                }
                L.b("StrokeContent#buildPath");
                L.a("StrokeContent#drawPath");
                canvas.drawPath(this.f9019b, this.f9026i);
                L.b("StrokeContent#drawPath");
            }
        }
        L.b("StrokeContent#draw");
    }
}
