package com.airbnb.lottie.model;

/* loaded from: classes.dex */
public class DocumentData {

    /* renamed from: a  reason: collision with root package name */
    public String f9266a;

    /* renamed from: b  reason: collision with root package name */
    public String f9267b;

    /* renamed from: c  reason: collision with root package name */
    public float f9268c;

    /* renamed from: d  reason: collision with root package name */
    public Justification f9269d;

    /* renamed from: e  reason: collision with root package name */
    public int f9270e;

    /* renamed from: f  reason: collision with root package name */
    public float f9271f;

    /* renamed from: g  reason: collision with root package name */
    public float f9272g;

    /* renamed from: h  reason: collision with root package name */
    public int f9273h;

    /* renamed from: i  reason: collision with root package name */
    public int f9274i;

    /* renamed from: j  reason: collision with root package name */
    public float f9275j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9276k;

    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f8, Justification justification, int i8, float f9, float f10, int i9, int i10, float f11, boolean z7) {
        a(str, str2, f8, justification, i8, f9, f10, i9, i10, f11, z7);
    }

    public void a(String str, String str2, float f8, Justification justification, int i8, float f9, float f10, int i9, int i10, float f11, boolean z7) {
        this.f9266a = str;
        this.f9267b = str2;
        this.f9268c = f8;
        this.f9269d = justification;
        this.f9270e = i8;
        this.f9271f = f9;
        this.f9272g = f10;
        this.f9273h = i9;
        this.f9274i = i10;
        this.f9275j = f11;
        this.f9276k = z7;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f9266a.hashCode() * 31) + this.f9267b.hashCode()) * 31) + this.f9268c)) * 31) + this.f9269d.ordinal()) * 31) + this.f9270e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f9271f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f9273h;
    }

    public DocumentData() {
    }
}
