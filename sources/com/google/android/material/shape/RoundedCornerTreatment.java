package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class RoundedCornerTreatment extends CornerTreatment {

    /* renamed from: a  reason: collision with root package name */
    float f14026a = -1.0f;

    @Override // com.google.android.material.shape.CornerTreatment
    public void b(@NonNull ShapePath shapePath, float f8, float f9, float f10) {
        shapePath.o(0.0f, f10 * f9, 180.0f, 180.0f - f8);
        float f11 = f10 * 2.0f * f9;
        shapePath.a(0.0f, 0.0f, f11, f11, 180.0f, f8);
    }
}
