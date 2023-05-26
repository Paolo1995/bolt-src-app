package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CutCornerTreatment extends CornerTreatment {

    /* renamed from: a  reason: collision with root package name */
    float f13978a = -1.0f;

    @Override // com.google.android.material.shape.CornerTreatment
    public void b(@NonNull ShapePath shapePath, float f8, float f9, float f10) {
        shapePath.o(0.0f, f10 * f9, 180.0f, 180.0f - f8);
        double d8 = f10;
        double d9 = f9;
        shapePath.m((float) (Math.sin(Math.toRadians(f8)) * d8 * d9), (float) (Math.sin(Math.toRadians(90.0f - f8)) * d8 * d9));
    }
}
