package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l1 implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final Float f43930f;

    /* renamed from: g  reason: collision with root package name */
    private final hh f43931g;

    /* renamed from: h  reason: collision with root package name */
    private final gh f43932h;

    public l1(Float f8, hh shapeType, gh shapeConfig) {
        Intrinsics.f(shapeType, "shapeType");
        Intrinsics.f(shapeConfig, "shapeConfig");
        this.f43930f = f8;
        this.f43931g = shapeType;
        this.f43932h = shapeConfig;
    }

    public final Float a() {
        return this.f43930f;
    }

    public final gh b() {
        return this.f43932h;
    }

    public final hh c() {
        return this.f43931g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l1) {
            l1 l1Var = (l1) obj;
            return Intrinsics.a(this.f43930f, l1Var.f43930f) && this.f43931g == l1Var.f43931g && Intrinsics.a(this.f43932h, l1Var.f43932h);
        }
        return false;
    }

    public int hashCode() {
        Float f8 = this.f43930f;
        return ((((f8 == null ? 0 : f8.hashCode()) * 31) + this.f43931g.hashCode()) * 31) + this.f43932h.hashCode();
    }

    public String toString() {
        Float f8 = this.f43930f;
        hh hhVar = this.f43931g;
        gh ghVar = this.f43932h;
        return "CameraOverlay(alpha=" + f8 + ", shapeType=" + hhVar + ", shapeConfig=" + ghVar + ")";
    }
}
