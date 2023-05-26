package com.yalantis.ucrop.util;

import android.graphics.RectF;

/* loaded from: classes3.dex */
public class RectUtils {
    public static float[] getCenterFromRect(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static float[] getCornersFromRect(RectF rectF) {
        float f8 = rectF.left;
        float f9 = rectF.top;
        float f10 = rectF.right;
        float f11 = rectF.bottom;
        return new float[]{f8, f9, f10, f9, f10, f11, f8, f11};
    }

    public static float[] getRectSidesFromCorners(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow(fArr[0] - fArr[2], 2.0d) + Math.pow(fArr[1] - fArr[3], 2.0d)), (float) Math.sqrt(Math.pow(fArr[2] - fArr[4], 2.0d) + Math.pow(fArr[3] - fArr[5], 2.0d))};
    }

    public static RectF trapToRect(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i8 = 1; i8 < fArr.length; i8 += 2) {
            float round = Math.round(fArr[i8 - 1] * 10.0f) / 10.0f;
            float round2 = Math.round(fArr[i8] * 10.0f) / 10.0f;
            float f8 = rectF.left;
            if (round < f8) {
                f8 = round;
            }
            rectF.left = f8;
            float f9 = rectF.top;
            if (round2 < f9) {
                f9 = round2;
            }
            rectF.top = f9;
            float f10 = rectF.right;
            if (round <= f10) {
                round = f10;
            }
            rectF.right = round;
            float f11 = rectF.bottom;
            if (round2 <= f11) {
                round2 = f11;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }
}
