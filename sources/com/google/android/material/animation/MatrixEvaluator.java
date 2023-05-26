package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f12730a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f12731b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f12732c = new Matrix();

    @Override // android.animation.TypeEvaluator
    @NonNull
    /* renamed from: a */
    public Matrix evaluate(float f8, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f12730a);
        matrix2.getValues(this.f12731b);
        for (int i8 = 0; i8 < 9; i8++) {
            float[] fArr = this.f12731b;
            float f9 = fArr[i8];
            float f10 = this.f12730a[i8];
            fArr[i8] = f10 + ((f9 - f10) * f8);
        }
        this.f12732c.setValues(this.f12731b);
        return this.f12732c;
    }
}
