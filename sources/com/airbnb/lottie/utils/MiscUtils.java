package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* loaded from: classes.dex */
public class MiscUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final PointF f9652a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f8, float f9, float f10) {
        return Math.max(f9, Math.min(f10, f8));
    }

    public static int c(int i8, int i9, int i10) {
        return Math.max(i9, Math.min(i10, i8));
    }

    public static boolean d(float f8, float f9, float f10) {
        return f8 >= f9 && f8 <= f10;
    }

    private static int e(int i8, int i9) {
        boolean z7;
        int i10 = i8 / i9;
        if ((i8 ^ i9) >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int i11 = i8 % i9;
        if (!z7 && i11 != 0) {
            return i10 - 1;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(float f8, float f9) {
        return g((int) f8, (int) f9);
    }

    private static int g(int i8, int i9) {
        return i8 - (i9 * e(i8, i9));
    }

    public static void h(ShapeData shapeData, Path path) {
        path.reset();
        PointF b8 = shapeData.b();
        path.moveTo(b8.x, b8.y);
        f9652a.set(b8.x, b8.y);
        for (int i8 = 0; i8 < shapeData.a().size(); i8++) {
            CubicCurveData cubicCurveData = shapeData.a().get(i8);
            PointF a8 = cubicCurveData.a();
            PointF b9 = cubicCurveData.b();
            PointF c8 = cubicCurveData.c();
            PointF pointF = f9652a;
            if (a8.equals(pointF) && b9.equals(c8)) {
                path.lineTo(c8.x, c8.y);
            } else {
                path.cubicTo(a8.x, a8.y, b9.x, b9.y, c8.x, c8.y);
            }
            pointF.set(c8.x, c8.y);
        }
        if (shapeData.d()) {
            path.close();
        }
    }

    public static float i(float f8, float f9, float f10) {
        return f8 + (f10 * (f9 - f8));
    }

    public static int j(int i8, int i9, float f8) {
        return (int) (i8 + (f8 * (i9 - i8)));
    }

    public static void k(KeyPath keyPath, int i8, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.c(keyPathElementContent.getName(), i8)) {
            list.add(keyPath2.a(keyPathElementContent.getName()).i(keyPathElementContent));
        }
    }
}
