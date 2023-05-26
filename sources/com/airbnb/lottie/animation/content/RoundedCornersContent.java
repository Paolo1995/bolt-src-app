package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    private final LottieDrawable f9144a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9145b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseKeyframeAnimation<Float, Float> f9146c;

    /* renamed from: d  reason: collision with root package name */
    private ShapeData f9147d;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.f9144a = lottieDrawable;
        this.f9145b = roundedCorners.c();
        BaseKeyframeAnimation<Float, Float> a8 = roundedCorners.b().a();
        this.f9146c = a8;
        baseLayer.i(a8);
        a8.a(this);
    }

    private static int d(int i8, int i9) {
        int i10 = i8 / i9;
        if ((i8 ^ i9) < 0 && i9 * i10 != i8) {
            return i10 - 1;
        }
        return i10;
    }

    private static int e(int i8, int i9) {
        return i8 - (d(i8, i9) * i9);
    }

    @NonNull
    private ShapeData i(ShapeData shapeData) {
        PointF c8;
        PointF b8;
        boolean z7;
        List<CubicCurveData> a8 = shapeData.a();
        boolean d8 = shapeData.d();
        int i8 = 0;
        for (int size = a8.size() - 1; size >= 0; size--) {
            CubicCurveData cubicCurveData = a8.get(size);
            CubicCurveData cubicCurveData2 = a8.get(e(size - 1, a8.size()));
            if (size == 0 && !d8) {
                c8 = shapeData.b();
            } else {
                c8 = cubicCurveData2.c();
            }
            if (size == 0 && !d8) {
                b8 = c8;
            } else {
                b8 = cubicCurveData2.b();
            }
            PointF a9 = cubicCurveData.a();
            if (!shapeData.d() && size == 0 && size == a8.size() - 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (b8.equals(c8) && a9.equals(c8) && !z7) {
                i8 += 2;
            } else {
                i8++;
            }
        }
        ShapeData shapeData2 = this.f9147d;
        if (shapeData2 == null || shapeData2.a().size() != i8) {
            ArrayList arrayList = new ArrayList(i8);
            for (int i9 = 0; i9 < i8; i9++) {
                arrayList.add(new CubicCurveData());
            }
            this.f9147d = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f9147d.e(d8);
        return this.f9147d;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f9144a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public ShapeData c(ShapeData shapeData) {
        PointF c8;
        PointF b8;
        boolean z7;
        List<CubicCurveData> list;
        List<CubicCurveData> a8 = shapeData.a();
        if (a8.size() <= 2) {
            return shapeData;
        }
        float floatValue = this.f9146c.h().floatValue();
        if (floatValue == 0.0f) {
            return shapeData;
        }
        ShapeData i8 = i(shapeData);
        i8.f(shapeData.b().x, shapeData.b().y);
        List<CubicCurveData> a9 = i8.a();
        boolean d8 = shapeData.d();
        int i9 = 0;
        int i10 = 0;
        while (i9 < a8.size()) {
            CubicCurveData cubicCurveData = a8.get(i9);
            CubicCurveData cubicCurveData2 = a8.get(e(i9 - 1, a8.size()));
            CubicCurveData cubicCurveData3 = a8.get(e(i9 - 2, a8.size()));
            if (i9 == 0 && !d8) {
                c8 = shapeData.b();
            } else {
                c8 = cubicCurveData2.c();
            }
            if (i9 == 0 && !d8) {
                b8 = c8;
            } else {
                b8 = cubicCurveData2.b();
            }
            PointF a10 = cubicCurveData.a();
            PointF c9 = cubicCurveData3.c();
            PointF c10 = cubicCurveData.c();
            if (!shapeData.d() && i9 == 0 && i9 == a8.size() - 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (b8.equals(c8) && a10.equals(c8) && !z7) {
                float f8 = c8.x;
                float f9 = f8 - c9.x;
                float f10 = c8.y;
                float f11 = c10.x - f8;
                list = a8;
                float min = Math.min(floatValue / ((float) Math.hypot(f9, f10 - c9.y)), 0.5f);
                float min2 = Math.min(floatValue / ((float) Math.hypot(f11, c10.y - f10)), 0.5f);
                float f12 = c8.x;
                float f13 = ((c9.x - f12) * min) + f12;
                float f14 = c8.y;
                float f15 = ((c9.y - f14) * min) + f14;
                float f16 = ((c10.x - f12) * min2) + f12;
                float f17 = ((c10.y - f14) * min2) + f14;
                float f18 = f13 - ((f13 - f12) * 0.5519f);
                float f19 = f15 - ((f15 - f14) * 0.5519f);
                float f20 = f16 - ((f16 - f12) * 0.5519f);
                float f21 = f17 - ((f17 - f14) * 0.5519f);
                CubicCurveData cubicCurveData4 = a9.get(e(i10 - 1, a9.size()));
                CubicCurveData cubicCurveData5 = a9.get(i10);
                cubicCurveData4.e(f13, f15);
                cubicCurveData4.f(f13, f15);
                if (i9 == 0) {
                    i8.f(f13, f15);
                }
                cubicCurveData5.d(f18, f19);
                i10++;
                cubicCurveData5.e(f20, f21);
                cubicCurveData5.f(f16, f17);
                a9.get(i10).d(f16, f17);
            } else {
                list = a8;
                CubicCurveData cubicCurveData6 = a9.get(e(i10 - 1, a9.size()));
                cubicCurveData6.e(cubicCurveData2.c().x, cubicCurveData2.c().y);
                cubicCurveData6.f(cubicCurveData2.c().x, cubicCurveData2.c().y);
                a9.get(i10).d(cubicCurveData.c().x, cubicCurveData.c().y);
            }
            i10++;
            i9++;
            a8 = list;
        }
        return i8;
    }

    public BaseKeyframeAnimation<Float, Float> g() {
        return this.f9146c;
    }
}
