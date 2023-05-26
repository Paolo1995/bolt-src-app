package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeData {

    /* renamed from: a  reason: collision with root package name */
    private final List<CubicCurveData> f9398a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f9399b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9400c;

    public ShapeData(PointF pointF, boolean z7, List<CubicCurveData> list) {
        this.f9399b = pointF;
        this.f9400c = z7;
        this.f9398a = new ArrayList(list);
    }

    public List<CubicCurveData> a() {
        return this.f9398a;
    }

    public PointF b() {
        return this.f9399b;
    }

    public void c(ShapeData shapeData, ShapeData shapeData2, float f8) {
        boolean z7;
        if (this.f9399b == null) {
            this.f9399b = new PointF();
        }
        if (!shapeData.d() && !shapeData2.d()) {
            z7 = false;
        } else {
            z7 = true;
        }
        this.f9400c = z7;
        if (shapeData.a().size() != shapeData2.a().size()) {
            Logger.c("Curves must have the same number of control points. Shape 1: " + shapeData.a().size() + "\tShape 2: " + shapeData2.a().size());
        }
        int min = Math.min(shapeData.a().size(), shapeData2.a().size());
        if (this.f9398a.size() < min) {
            for (int size = this.f9398a.size(); size < min; size++) {
                this.f9398a.add(new CubicCurveData());
            }
        } else if (this.f9398a.size() > min) {
            for (int size2 = this.f9398a.size() - 1; size2 >= min; size2--) {
                List<CubicCurveData> list = this.f9398a;
                list.remove(list.size() - 1);
            }
        }
        PointF b8 = shapeData.b();
        PointF b9 = shapeData2.b();
        f(MiscUtils.i(b8.x, b9.x, f8), MiscUtils.i(b8.y, b9.y, f8));
        for (int size3 = this.f9398a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.a().get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.a().get(size3);
            PointF a8 = cubicCurveData.a();
            PointF b10 = cubicCurveData.b();
            PointF c8 = cubicCurveData.c();
            PointF a9 = cubicCurveData2.a();
            PointF b11 = cubicCurveData2.b();
            PointF c9 = cubicCurveData2.c();
            this.f9398a.get(size3).d(MiscUtils.i(a8.x, a9.x, f8), MiscUtils.i(a8.y, a9.y, f8));
            this.f9398a.get(size3).e(MiscUtils.i(b10.x, b11.x, f8), MiscUtils.i(b10.y, b11.y, f8));
            this.f9398a.get(size3).f(MiscUtils.i(c8.x, c9.x, f8), MiscUtils.i(c8.y, c9.y, f8));
        }
    }

    public boolean d() {
        return this.f9400c;
    }

    public void e(boolean z7) {
        this.f9400c = z7;
    }

    public void f(float f8, float f9) {
        if (this.f9399b == null) {
            this.f9399b = new PointF();
        }
        this.f9399b.set(f8, f9);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f9398a.size() + "closed=" + this.f9400c + '}';
    }

    public ShapeData() {
        this.f9398a = new ArrayList();
    }
}
