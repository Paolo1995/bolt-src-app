package com.airbnb.lottie.model;

/* loaded from: classes.dex */
public class Marker {

    /* renamed from: a  reason: collision with root package name */
    private final String f9297a;

    /* renamed from: b  reason: collision with root package name */
    public final float f9298b;

    /* renamed from: c  reason: collision with root package name */
    public final float f9299c;

    public Marker(String str, float f8, float f9) {
        this.f9297a = str;
        this.f9299c = f9;
        this.f9298b = f8;
    }

    public boolean a(String str) {
        if (this.f9297a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f9297a.endsWith("\r")) {
            String str2 = this.f9297a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
