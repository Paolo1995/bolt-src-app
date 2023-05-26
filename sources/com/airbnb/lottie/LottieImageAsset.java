package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class LottieImageAsset {

    /* renamed from: a  reason: collision with root package name */
    private final int f8926a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8927b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8928c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8929d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8930e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f8931f;

    public LottieImageAsset(int i8, int i9, String str, String str2, String str3) {
        this.f8926a = i8;
        this.f8927b = i9;
        this.f8928c = str;
        this.f8929d = str2;
        this.f8930e = str3;
    }

    public Bitmap a() {
        return this.f8931f;
    }

    public String b() {
        return this.f8929d;
    }

    public int c() {
        return this.f8927b;
    }

    public String d() {
        return this.f8928c;
    }

    public int e() {
        return this.f8926a;
    }

    public void f(Bitmap bitmap) {
        this.f8931f = bitmap;
    }
}
