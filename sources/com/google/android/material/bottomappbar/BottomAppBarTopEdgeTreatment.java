package com.google.android.material.bottomappbar;

import androidx.annotation.NonNull;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* loaded from: classes.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    private float f12981f;

    /* renamed from: g  reason: collision with root package name */
    private float f12982g;

    /* renamed from: h  reason: collision with root package name */
    private float f12983h;

    /* renamed from: i  reason: collision with root package name */
    private float f12984i;

    /* renamed from: j  reason: collision with root package name */
    private float f12985j;

    /* renamed from: k  reason: collision with root package name */
    private float f12986k;

    @Override // com.google.android.material.shape.EdgeTreatment
    public void b(float f8, float f9, float f10, @NonNull ShapePath shapePath) {
        boolean z7;
        float f11;
        float f12;
        float f13 = this.f12983h;
        if (f13 == 0.0f) {
            shapePath.m(f8, 0.0f);
            return;
        }
        float f14 = ((this.f12982g * 2.0f) + f13) / 2.0f;
        float f15 = f10 * this.f12981f;
        float f16 = f9 + this.f12985j;
        float f17 = (this.f12984i * f10) + ((1.0f - f10) * f14);
        if (f17 / f14 >= 1.0f) {
            shapePath.m(f8, 0.0f);
            return;
        }
        float f18 = this.f12986k;
        float f19 = f18 * f10;
        if (f18 != -1.0f && Math.abs((f18 * 2.0f) - f13) >= 0.1f) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            f12 = 1.75f;
            f11 = 0.0f;
        } else {
            f11 = f17;
            f12 = 0.0f;
        }
        float f20 = f14 + f15;
        float f21 = f11 + f15;
        float sqrt = (float) Math.sqrt((f20 * f20) - (f21 * f21));
        float f22 = f16 - sqrt;
        float f23 = f16 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f21));
        float f24 = (90.0f - degrees) + f12;
        shapePath.m(f22, 0.0f);
        float f25 = f15 * 2.0f;
        shapePath.a(f22 - f15, 0.0f, f22 + f15, f25, 270.0f, degrees);
        if (z7) {
            shapePath.a(f16 - f14, (-f14) - f11, f16 + f14, f14 - f11, 180.0f - f24, (f24 * 2.0f) - 180.0f);
        } else {
            float f26 = this.f12982g;
            float f27 = f19 * 2.0f;
            float f28 = f16 - f14;
            shapePath.a(f28, -(f19 + f26), f28 + f26 + f27, f26 + f19, 180.0f - f24, ((f24 * 2.0f) - 180.0f) / 2.0f);
            float f29 = f16 + f14;
            float f30 = this.f12982g;
            shapePath.m(f29 - ((f30 / 2.0f) + f19), f30 + f19);
            float f31 = this.f12982g;
            shapePath.a(f29 - (f27 + f31), -(f19 + f31), f29, f31 + f19, 90.0f, f24 - 90.0f);
        }
        shapePath.a(f23 - f15, 0.0f, f23 + f15, f25, 270.0f - degrees, degrees);
        shapePath.m(f8, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f12984i;
    }

    public float d() {
        return this.f12986k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f12982g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f12981f;
    }

    public float h() {
        return this.f12983h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(float f8) {
        if (f8 >= 0.0f) {
            this.f12984i = f8;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void j(float f8) {
        this.f12986k = f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(float f8) {
        this.f12982g = f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f8) {
        this.f12981f = f8;
    }

    public void m(float f8) {
        this.f12983h = f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(float f8) {
        this.f12985j = f8;
    }
}
