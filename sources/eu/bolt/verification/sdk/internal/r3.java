package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r3 extends ob {

    /* renamed from: f  reason: collision with root package name */
    private final String f44719f;

    /* renamed from: g  reason: collision with root package name */
    private final Long f44720g;

    public r3(String id, Long l8) {
        Intrinsics.f(id, "id");
        this.f44719f = id;
        this.f44720g = l8;
    }

    @Override // eu.bolt.verification.sdk.internal.ob
    public String a() {
        return this.f44719f;
    }

    public final Long b() {
        return this.f44720g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r3) {
            r3 r3Var = (r3) obj;
            return Intrinsics.a(a(), r3Var.a()) && Intrinsics.a(this.f44720g, r3Var.f44720g);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = a().hashCode() * 31;
        Long l8 = this.f44720g;
        return hashCode + (l8 == null ? 0 : l8.hashCode());
    }

    public String toString() {
        String a8 = a();
        Long l8 = this.f44720g;
        return "DatePicker(id=" + a8 + ", hintDate=" + l8 + ")";
    }
}
