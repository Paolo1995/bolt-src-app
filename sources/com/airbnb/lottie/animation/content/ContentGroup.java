package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f9038a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f9039b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f9040c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f9041d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f9042e;

    /* renamed from: f  reason: collision with root package name */
    private final String f9043f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f9044g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Content> f9045h;

    /* renamed from: i  reason: collision with root package name */
    private final LottieDrawable f9046i;

    /* renamed from: j  reason: collision with root package name */
    private List<PathContent> f9047j;

    /* renamed from: k  reason: collision with root package name */
    private TransformKeyframeAnimation f9048k;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.c(), shapeGroup.d(), g(lottieDrawable, baseLayer, shapeGroup.b()), i(shapeGroup.b()));
    }

    private static List<Content> g(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i8 = 0; i8 < list.size(); i8++) {
            Content a8 = list.get(i8).a(lottieDrawable, baseLayer);
            if (a8 != null) {
                arrayList.add(a8);
            }
        }
        return arrayList;
    }

    static AnimatableTransform i(List<ContentModel> list) {
        for (int i8 = 0; i8 < list.size(); i8++) {
            ContentModel contentModel = list.get(i8);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    private boolean l() {
        int i8 = 0;
        for (int i9 = 0; i9 < this.f9045h.size(); i9++) {
            if ((this.f9045h.get(i9) instanceof DrawingContent) && (i8 = i8 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f9046i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f9045h.size());
        arrayList.addAll(list);
        for (int size = this.f9045h.size() - 1; size >= 0; size--) {
            Content content = this.f9045h.get(size);
            content.b(arrayList, this.f9045h.subList(0, size));
            arrayList.add(content);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f9048k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.c(t7, lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        if (!keyPath.g(getName(), i8) && !"__container".equals(getName())) {
            return;
        }
        if (!"__container".equals(getName())) {
            keyPath2 = keyPath2.a(getName());
            if (keyPath.c(getName(), i8)) {
                list.add(keyPath2.i(this));
            }
        }
        if (keyPath.h(getName(), i8)) {
            int e8 = i8 + keyPath.e(getName(), i8);
            for (int i9 = 0; i9 < this.f9045h.size(); i9++) {
                Content content = this.f9045h.get(i9);
                if (content instanceof KeyPathElement) {
                    ((KeyPathElement) content).e(keyPath, e8, list, keyPath2);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        this.f9040c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f9048k;
        if (transformKeyframeAnimation != null) {
            this.f9040c.preConcat(transformKeyframeAnimation.f());
        }
        this.f9042e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f9045h.size() - 1; size >= 0; size--) {
            Content content = this.f9045h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).f(this.f9042e, this.f9040c, z7);
                rectF.union(this.f9042e);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9043f;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.f9040c.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f9048k;
        if (transformKeyframeAnimation != null) {
            this.f9040c.set(transformKeyframeAnimation.f());
        }
        this.f9041d.reset();
        if (this.f9044g) {
            return this.f9041d;
        }
        for (int size = this.f9045h.size() - 1; size >= 0; size--) {
            Content content = this.f9045h.get(size);
            if (content instanceof PathContent) {
                this.f9041d.addPath(((PathContent) content).getPath(), this.f9040c);
            }
        }
        return this.f9041d;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        boolean z7;
        int intValue;
        if (this.f9044g) {
            return;
        }
        this.f9040c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f9048k;
        if (transformKeyframeAnimation != null) {
            this.f9040c.preConcat(transformKeyframeAnimation.f());
            if (this.f9048k.h() == null) {
                intValue = 100;
            } else {
                intValue = this.f9048k.h().h().intValue();
            }
            i8 = (int) ((((intValue / 100.0f) * i8) / 255.0f) * 255.0f);
        }
        if (this.f9046i.b0() && l() && i8 != 255) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f9039b.set(0.0f, 0.0f, 0.0f, 0.0f);
            f(this.f9039b, this.f9040c, true);
            this.f9038a.setAlpha(i8);
            Utils.m(canvas, this.f9039b, this.f9038a);
        }
        if (z7) {
            i8 = 255;
        }
        for (int size = this.f9045h.size() - 1; size >= 0; size--) {
            Content content = this.f9045h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).h(canvas, this.f9040c, i8);
            }
        }
        if (z7) {
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<PathContent> j() {
        if (this.f9047j == null) {
            this.f9047j = new ArrayList();
            for (int i8 = 0; i8 < this.f9045h.size(); i8++) {
                Content content = this.f9045h.get(i8);
                if (content instanceof PathContent) {
                    this.f9047j.add((PathContent) content);
                }
            }
        }
        return this.f9047j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix k() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f9048k;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.f();
        }
        this.f9040c.reset();
        return this.f9040c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z7, List<Content> list, AnimatableTransform animatableTransform) {
        this.f9038a = new LPaint();
        this.f9039b = new RectF();
        this.f9040c = new Matrix();
        this.f9041d = new Path();
        this.f9042e = new RectF();
        this.f9043f = str;
        this.f9046i = lottieDrawable;
        this.f9044g = z7;
        this.f9045h = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation b8 = animatableTransform.b();
            this.f9048k = b8;
            b8.a(baseLayer);
            this.f9048k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).g(list.listIterator(list.size()));
        }
    }
}
