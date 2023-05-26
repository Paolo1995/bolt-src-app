package com.airbnb.lottie.value;

/* loaded from: classes.dex */
public class ScaleXY {

    /* renamed from: a  reason: collision with root package name */
    private float f9686a;

    /* renamed from: b  reason: collision with root package name */
    private float f9687b;

    public ScaleXY(float f8, float f9) {
        this.f9686a = f8;
        this.f9687b = f9;
    }

    public boolean a(float f8, float f9) {
        if (this.f9686a == f8 && this.f9687b == f9) {
            return true;
        }
        return false;
    }

    public float b() {
        return this.f9686a;
    }

    public float c() {
        return this.f9687b;
    }

    public void d(float f8, float f9) {
        this.f9686a = f8;
        this.f9687b = f9;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
