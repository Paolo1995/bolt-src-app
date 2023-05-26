package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private Paint A;
    float B;
    BlurMaskFilter C;

    /* renamed from: a  reason: collision with root package name */
    private final Path f9443a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f9444b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f9445c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private final Paint f9446d = new LPaint(1);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f9447e = new LPaint(1, PorterDuff.Mode.DST_IN);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f9448f = new LPaint(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: g  reason: collision with root package name */
    private final Paint f9449g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f9450h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f9451i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f9452j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f9453k;

    /* renamed from: l  reason: collision with root package name */
    private final RectF f9454l;

    /* renamed from: m  reason: collision with root package name */
    private final RectF f9455m;

    /* renamed from: n  reason: collision with root package name */
    private final String f9456n;

    /* renamed from: o  reason: collision with root package name */
    final Matrix f9457o;

    /* renamed from: p  reason: collision with root package name */
    final LottieDrawable f9458p;

    /* renamed from: q  reason: collision with root package name */
    final Layer f9459q;

    /* renamed from: r  reason: collision with root package name */
    private MaskKeyframeAnimation f9460r;

    /* renamed from: s  reason: collision with root package name */
    private FloatKeyframeAnimation f9461s;

    /* renamed from: t  reason: collision with root package name */
    private BaseLayer f9462t;

    /* renamed from: u  reason: collision with root package name */
    private BaseLayer f9463u;

    /* renamed from: v  reason: collision with root package name */
    private List<BaseLayer> f9464v;

    /* renamed from: w  reason: collision with root package name */
    private final List<BaseKeyframeAnimation<?, ?>> f9465w;

    /* renamed from: x  reason: collision with root package name */
    final TransformKeyframeAnimation f9466x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f9467y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f9468z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9469a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f9470b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f9470b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9470b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9470b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9470b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f9469a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9469a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9469a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9469a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9469a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9469a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9469a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        LPaint lPaint = new LPaint(1);
        this.f9449g = lPaint;
        this.f9450h = new LPaint(PorterDuff.Mode.CLEAR);
        this.f9451i = new RectF();
        this.f9452j = new RectF();
        this.f9453k = new RectF();
        this.f9454l = new RectF();
        this.f9455m = new RectF();
        this.f9457o = new Matrix();
        this.f9465w = new ArrayList();
        this.f9467y = true;
        this.B = 0.0f;
        this.f9458p = lottieDrawable;
        this.f9459q = layer;
        this.f9456n = layer.i() + "#draw";
        if (layer.h() == Layer.MatteType.INVERT) {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        TransformKeyframeAnimation b8 = layer.w().b();
        this.f9466x = b8;
        b8.b(this);
        if (layer.g() != null && !layer.g().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.g());
            this.f9460r = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation : maskKeyframeAnimation.a()) {
                baseKeyframeAnimation.a(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 : this.f9460r.c()) {
                i(baseKeyframeAnimation2);
                baseKeyframeAnimation2.a(this);
            }
        }
        N();
    }

    private void B(RectF rectF, Matrix matrix) {
        this.f9453k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!z()) {
            return;
        }
        int size = this.f9460r.b().size();
        for (int i8 = 0; i8 < size; i8++) {
            Mask mask = this.f9460r.b().get(i8);
            Path h8 = this.f9460r.a().get(i8).h();
            if (h8 != null) {
                this.f9443a.set(h8);
                this.f9443a.transform(matrix);
                int i9 = AnonymousClass1.f9470b[mask.a().ordinal()];
                if (i9 != 1 && i9 != 2) {
                    if ((i9 == 3 || i9 == 4) && mask.d()) {
                        return;
                    }
                    this.f9443a.computeBounds(this.f9455m, false);
                    if (i8 == 0) {
                        this.f9453k.set(this.f9455m);
                    } else {
                        RectF rectF2 = this.f9453k;
                        rectF2.set(Math.min(rectF2.left, this.f9455m.left), Math.min(this.f9453k.top, this.f9455m.top), Math.max(this.f9453k.right, this.f9455m.right), Math.max(this.f9453k.bottom, this.f9455m.bottom));
                    }
                } else {
                    return;
                }
            }
        }
        if (!rectF.intersect(this.f9453k)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void C(RectF rectF, Matrix matrix) {
        if (!A() || this.f9459q.h() == Layer.MatteType.INVERT) {
            return;
        }
        this.f9454l.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.f9462t.f(this.f9454l, matrix, true);
        if (!rectF.intersect(this.f9454l)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void D() {
        this.f9458p.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        boolean z7;
        if (this.f9461s.p() == 1.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        M(z7);
    }

    private void F(float f8) {
        this.f9458p.G().n().a(this.f9459q.i(), f8);
    }

    private void M(boolean z7) {
        if (z7 != this.f9467y) {
            this.f9467y = z7;
            D();
        }
    }

    private void N() {
        boolean z7 = true;
        if (!this.f9459q.e().isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.f9459q.e());
            this.f9461s = floatKeyframeAnimation;
            floatKeyframeAnimation.l();
            this.f9461s.a(new BaseKeyframeAnimation.AnimationListener() { // from class: r.a
                @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
                public final void a() {
                    BaseLayer.this.E();
                }
            });
            if (this.f9461s.h().floatValue() != 1.0f) {
                z7 = false;
            }
            M(z7);
            i(this.f9461s);
            return;
        }
        M(true);
    }

    private void j(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.f9443a.set(baseKeyframeAnimation.h());
        this.f9443a.transform(matrix);
        this.f9446d.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        canvas.drawPath(this.f9443a, this.f9446d);
    }

    private void k(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.m(canvas, this.f9451i, this.f9447e);
        this.f9443a.set(baseKeyframeAnimation.h());
        this.f9443a.transform(matrix);
        this.f9446d.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        canvas.drawPath(this.f9443a, this.f9446d);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.m(canvas, this.f9451i, this.f9446d);
        canvas.drawRect(this.f9451i, this.f9446d);
        this.f9443a.set(baseKeyframeAnimation.h());
        this.f9443a.transform(matrix);
        this.f9446d.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        canvas.drawPath(this.f9443a, this.f9448f);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.m(canvas, this.f9451i, this.f9447e);
        canvas.drawRect(this.f9451i, this.f9446d);
        this.f9448f.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        this.f9443a.set(baseKeyframeAnimation.h());
        this.f9443a.transform(matrix);
        canvas.drawPath(this.f9443a, this.f9448f);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.m(canvas, this.f9451i, this.f9448f);
        canvas.drawRect(this.f9451i, this.f9446d);
        this.f9448f.setAlpha((int) (baseKeyframeAnimation2.h().intValue() * 2.55f));
        this.f9443a.set(baseKeyframeAnimation.h());
        this.f9443a.transform(matrix);
        canvas.drawPath(this.f9443a, this.f9448f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        L.a("Layer#saveLayer");
        Utils.n(canvas, this.f9451i, this.f9447e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        L.b("Layer#saveLayer");
        for (int i8 = 0; i8 < this.f9460r.b().size(); i8++) {
            Mask mask = this.f9460r.b().get(i8);
            BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation = this.f9460r.a().get(i8);
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f9460r.c().get(i8);
            int i9 = AnonymousClass1.f9470b[mask.a().ordinal()];
            if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 == 4) {
                            if (mask.d()) {
                                l(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                            } else {
                                j(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                            }
                        }
                    } else if (mask.d()) {
                        m(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        k(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                    }
                } else {
                    if (i8 == 0) {
                        this.f9446d.setColor(-16777216);
                        this.f9446d.setAlpha(255);
                        canvas.drawRect(this.f9451i, this.f9446d);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        p(canvas, matrix, baseKeyframeAnimation);
                    }
                }
            } else if (q()) {
                this.f9446d.setAlpha(255);
                canvas.drawRect(this.f9451i, this.f9446d);
            }
        }
        L.a("Layer#restoreLayer");
        canvas.restore();
        L.b("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation) {
        this.f9443a.set(baseKeyframeAnimation.h());
        this.f9443a.transform(matrix);
        canvas.drawPath(this.f9443a, this.f9448f);
    }

    private boolean q() {
        if (this.f9460r.a().isEmpty()) {
            return false;
        }
        for (int i8 = 0; i8 < this.f9460r.b().size(); i8++) {
            if (this.f9460r.b().get(i8).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.f9464v != null) {
            return;
        }
        if (this.f9463u == null) {
            this.f9464v = Collections.emptyList();
            return;
        }
        this.f9464v = new ArrayList();
        for (BaseLayer baseLayer = this.f9463u; baseLayer != null; baseLayer = baseLayer.f9463u) {
            this.f9464v.add(baseLayer);
        }
    }

    private void s(Canvas canvas) {
        L.a("Layer#clearLayer");
        RectF rectF = this.f9451i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f9450h);
        L.b("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BaseLayer u(CompositionLayer compositionLayer, Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (AnonymousClass1.f9469a[layer.f().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer, compositionLayer);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.o(layer.m()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                Logger.c("Unknown layer type " + layer.f());
                return null;
        }
    }

    boolean A() {
        if (this.f9462t != null) {
            return true;
        }
        return false;
    }

    public void G(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.f9465w.remove(baseKeyframeAnimation);
    }

    void H(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(BaseLayer baseLayer) {
        this.f9462t = baseLayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(boolean z7) {
        if (z7 && this.A == null) {
            this.A = new LPaint();
        }
        this.f9468z = z7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(BaseLayer baseLayer) {
        this.f9463u = baseLayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(float f8) {
        this.f9466x.j(f8);
        if (this.f9460r != null) {
            for (int i8 = 0; i8 < this.f9460r.a().size(); i8++) {
                this.f9460r.a().get(i8).m(f8);
            }
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f9461s;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.m(f8);
        }
        BaseLayer baseLayer = this.f9462t;
        if (baseLayer != null) {
            baseLayer.L(f8);
        }
        for (int i9 = 0; i9 < this.f9465w.size(); i9++) {
            this.f9465w.get(i9).m(f8);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        D();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void d(T t7, LottieValueCallback<T> lottieValueCallback) {
        this.f9466x.c(t7, lottieValueCallback);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2) {
        BaseLayer baseLayer = this.f9462t;
        if (baseLayer != null) {
            KeyPath a8 = keyPath2.a(baseLayer.getName());
            if (keyPath.c(this.f9462t.getName(), i8)) {
                list.add(a8.i(this.f9462t));
            }
            if (keyPath.h(getName(), i8)) {
                this.f9462t.H(keyPath, keyPath.e(this.f9462t.getName(), i8) + i8, list, a8);
            }
        }
        if (!keyPath.g(getName(), i8)) {
            return;
        }
        if (!"__container".equals(getName())) {
            keyPath2 = keyPath2.a(getName());
            if (keyPath.c(getName(), i8)) {
                list.add(keyPath2.i(this));
            }
        }
        if (keyPath.h(getName(), i8)) {
            H(keyPath, i8 + keyPath.e(getName(), i8), list, keyPath2);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z7) {
        this.f9451i.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f9457o.set(matrix);
        if (z7) {
            List<BaseLayer> list = this.f9464v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f9457o.preConcat(this.f9464v.get(size).f9466x.f());
                }
            } else {
                BaseLayer baseLayer = this.f9463u;
                if (baseLayer != null) {
                    this.f9457o.preConcat(baseLayer.f9466x.f());
                }
            }
        }
        this.f9457o.preConcat(this.f9466x.f());
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f9459q.i();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void h(Canvas canvas, Matrix matrix, int i8) {
        int intValue;
        Paint paint;
        L.a(this.f9456n);
        if (this.f9467y && !this.f9459q.x()) {
            r();
            L.a("Layer#parentMatrix");
            this.f9444b.reset();
            this.f9444b.set(matrix);
            for (int size = this.f9464v.size() - 1; size >= 0; size--) {
                this.f9444b.preConcat(this.f9464v.get(size).f9466x.f());
            }
            L.b("Layer#parentMatrix");
            if (this.f9466x.h() == null) {
                intValue = 100;
            } else {
                intValue = this.f9466x.h().h().intValue();
            }
            int i9 = (int) ((((i8 / 255.0f) * intValue) / 100.0f) * 255.0f);
            if (!A() && !z()) {
                this.f9444b.preConcat(this.f9466x.f());
                L.a("Layer#drawLayer");
                t(canvas, this.f9444b, i9);
                L.b("Layer#drawLayer");
                F(L.b(this.f9456n));
                return;
            }
            L.a("Layer#computeBounds");
            f(this.f9451i, this.f9444b, false);
            C(this.f9451i, matrix);
            this.f9444b.preConcat(this.f9466x.f());
            B(this.f9451i, this.f9444b);
            this.f9452j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.f9445c);
            if (!this.f9445c.isIdentity()) {
                Matrix matrix2 = this.f9445c;
                matrix2.invert(matrix2);
                this.f9445c.mapRect(this.f9452j);
            }
            if (!this.f9451i.intersect(this.f9452j)) {
                this.f9451i.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            L.b("Layer#computeBounds");
            if (this.f9451i.width() >= 1.0f && this.f9451i.height() >= 1.0f) {
                L.a("Layer#saveLayer");
                this.f9446d.setAlpha(255);
                Utils.m(canvas, this.f9451i, this.f9446d);
                L.b("Layer#saveLayer");
                s(canvas);
                L.a("Layer#drawLayer");
                t(canvas, this.f9444b, i9);
                L.b("Layer#drawLayer");
                if (z()) {
                    o(canvas, this.f9444b);
                }
                if (A()) {
                    L.a("Layer#drawMatte");
                    L.a("Layer#saveLayer");
                    Utils.n(canvas, this.f9451i, this.f9449g, 19);
                    L.b("Layer#saveLayer");
                    s(canvas);
                    this.f9462t.h(canvas, matrix, i9);
                    L.a("Layer#restoreLayer");
                    canvas.restore();
                    L.b("Layer#restoreLayer");
                    L.b("Layer#drawMatte");
                }
                L.a("Layer#restoreLayer");
                canvas.restore();
                L.b("Layer#restoreLayer");
            }
            if (this.f9468z && (paint = this.A) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.A.setColor(-251901);
                this.A.setStrokeWidth(4.0f);
                canvas.drawRect(this.f9451i, this.A);
                this.A.setStyle(Paint.Style.FILL);
                this.A.setColor(1357638635);
                canvas.drawRect(this.f9451i, this.A);
            }
            F(L.b(this.f9456n));
            return;
        }
        L.b(this.f9456n);
    }

    public void i(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.f9465w.add(baseKeyframeAnimation);
    }

    abstract void t(Canvas canvas, Matrix matrix, int i8);

    public BlurEffect v() {
        return this.f9459q.a();
    }

    public BlurMaskFilter w(float f8) {
        if (this.B == f8) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f8 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f8;
        return blurMaskFilter;
    }

    public DropShadowEffect x() {
        return this.f9459q.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer y() {
        return this.f9459q;
    }

    boolean z() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.f9460r;
        if (maskKeyframeAnimation != null && !maskKeyframeAnimation.a().isEmpty()) {
            return true;
        }
        return false;
    }
}
