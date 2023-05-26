package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

/* loaded from: classes.dex */
public class FontCharacter {

    /* renamed from: a  reason: collision with root package name */
    private final List<ShapeGroup> f9286a;

    /* renamed from: b  reason: collision with root package name */
    private final char f9287b;

    /* renamed from: c  reason: collision with root package name */
    private final double f9288c;

    /* renamed from: d  reason: collision with root package name */
    private final double f9289d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9290e;

    /* renamed from: f  reason: collision with root package name */
    private final String f9291f;

    public FontCharacter(List<ShapeGroup> list, char c8, double d8, double d9, String str, String str2) {
        this.f9286a = list;
        this.f9287b = c8;
        this.f9288c = d8;
        this.f9289d = d9;
        this.f9290e = str;
        this.f9291f = str2;
    }

    public static int c(char c8, String str, String str2) {
        return ((((0 + c8) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<ShapeGroup> a() {
        return this.f9286a;
    }

    public double b() {
        return this.f9289d;
    }

    public int hashCode() {
        return c(this.f9287b, this.f9291f, this.f9290e);
    }
}
