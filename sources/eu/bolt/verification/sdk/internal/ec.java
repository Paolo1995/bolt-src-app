package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ec implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final hh f42756f;

    /* renamed from: g  reason: collision with root package name */
    private final gh f42757g;

    public ec(hh shapeType, gh shapeConfig) {
        Intrinsics.f(shapeType, "shapeType");
        Intrinsics.f(shapeConfig, "shapeConfig");
        this.f42756f = shapeType;
        this.f42757g = shapeConfig;
    }

    public final gh a() {
        return this.f42757g;
    }

    public final hh b() {
        return this.f42756f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ec) {
            ec ecVar = (ec) obj;
            return this.f42756f == ecVar.f42756f && Intrinsics.a(this.f42757g, ecVar.f42757g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f42756f.hashCode() * 31) + this.f42757g.hashCode();
    }

    public String toString() {
        hh hhVar = this.f42756f;
        gh ghVar = this.f42757g;
        return "MediaPreviewOverlay(shapeType=" + hhVar + ", shapeConfig=" + ghVar + ")";
    }
}
