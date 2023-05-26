package eu.bolt.verification.sdk.internal;

import java.io.Serializable;

/* loaded from: classes5.dex */
public final class gh implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final int f43143f;

    /* renamed from: g  reason: collision with root package name */
    private final int f43144g;

    public gh(int i8, int i9) {
        this.f43143f = i8;
        this.f43144g = i9;
    }

    public final int a() {
        return this.f43144g;
    }

    public final int b() {
        return this.f43143f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gh) {
            gh ghVar = (gh) obj;
            return this.f43143f == ghVar.f43143f && this.f43144g == ghVar.f43144g;
        }
        return false;
    }

    public int hashCode() {
        return (this.f43143f * 31) + this.f43144g;
    }

    public String toString() {
        int i8 = this.f43143f;
        int i9 = this.f43144g;
        return "ShapeConfig(ratioWidth=" + i8 + ", ratioHeight=" + i9 + ")";
    }
}
