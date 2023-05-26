package com.airbnb.lottie.utils;

/* loaded from: classes.dex */
public class MeanCalculator {

    /* renamed from: a  reason: collision with root package name */
    private float f9650a;

    /* renamed from: b  reason: collision with root package name */
    private int f9651b;

    public void a(float f8) {
        float f9 = this.f9650a + f8;
        this.f9650a = f9;
        int i8 = this.f9651b + 1;
        this.f9651b = i8;
        if (i8 == Integer.MAX_VALUE) {
            this.f9650a = f9 / 2.0f;
            this.f9651b = i8 / 2;
        }
    }
}
