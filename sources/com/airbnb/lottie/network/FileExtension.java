package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");
    

    /* renamed from: f  reason: collision with root package name */
    public final String f9520f;

    FileExtension(String str) {
        this.f9520f = str;
    }

    public String a() {
        return ".temp" + this.f9520f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f9520f;
    }
}
