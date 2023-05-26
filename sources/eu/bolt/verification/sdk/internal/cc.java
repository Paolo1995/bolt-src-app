package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
public final class cc implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final float f42491f;

    /* renamed from: g  reason: collision with root package name */
    private final float f42492g;

    /* renamed from: h  reason: collision with root package name */
    private final float f42493h;

    /* renamed from: i  reason: collision with root package name */
    private final float f42494i;

    public cc() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public cc(float f8, float f9, float f10, float f11) {
        this.f42491f = f8;
        this.f42492g = f9;
        this.f42493h = f10;
        this.f42494i = f11;
    }

    public /* synthetic */ cc(float f8, float f9, float f10, float f11, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? 0.0f : f8, (i8 & 2) != 0 ? 0.0f : f9, (i8 & 4) != 0 ? 0.0f : f10, (i8 & 8) != 0 ? 0.0f : f11);
    }

    public final float a() {
        return this.f42494i;
    }

    public final float b() {
        return this.f42491f;
    }

    public final float c() {
        return this.f42493h;
    }

    public final float d() {
        return this.f42492g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cc) {
            cc ccVar = (cc) obj;
            return Float.compare(this.f42491f, ccVar.f42491f) == 0 && Float.compare(this.f42492g, ccVar.f42492g) == 0 && Float.compare(this.f42493h, ccVar.f42493h) == 0 && Float.compare(this.f42494i, ccVar.f42494i) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f42491f) * 31) + Float.floatToIntBits(this.f42492g)) * 31) + Float.floatToIntBits(this.f42493h)) * 31) + Float.floatToIntBits(this.f42494i);
    }

    public String toString() {
        float f8 = this.f42491f;
        float f9 = this.f42492g;
        float f10 = this.f42493h;
        float f11 = this.f42494i;
        return "MarginsDataModel(left=" + f8 + ", top=" + f9 + ", right=" + f10 + ", bottom=" + f11 + ")";
    }
}
