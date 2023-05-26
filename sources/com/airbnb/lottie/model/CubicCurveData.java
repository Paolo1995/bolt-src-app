package com.airbnb.lottie.model;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CubicCurveData {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f9263a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f9264b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f9265c;

    public CubicCurveData() {
        this.f9263a = new PointF();
        this.f9264b = new PointF();
        this.f9265c = new PointF();
    }

    public PointF a() {
        return this.f9263a;
    }

    public PointF b() {
        return this.f9264b;
    }

    public PointF c() {
        return this.f9265c;
    }

    public void d(float f8, float f9) {
        this.f9263a.set(f8, f9);
    }

    public void e(float f8, float f9) {
        this.f9264b.set(f8, f9);
    }

    public void f(float f8, float f9) {
        this.f9265c.set(f8, f9);
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f9265c.x), Float.valueOf(this.f9265c.y), Float.valueOf(this.f9263a.x), Float.valueOf(this.f9263a.y), Float.valueOf(this.f9264b.x), Float.valueOf(this.f9264b.y));
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f9263a = pointF;
        this.f9264b = pointF2;
        this.f9265c = pointF3;
    }
}
