package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class jl extends ob {

    /* renamed from: f  reason: collision with root package name */
    private final String f43753f;

    /* renamed from: g  reason: collision with root package name */
    private final String f43754g;

    /* renamed from: h  reason: collision with root package name */
    private final a f43755h;

    /* loaded from: classes5.dex */
    public enum a {
        TEXT,
        NUMBERS
    }

    public jl(String id, String str, a inputType) {
        Intrinsics.f(id, "id");
        Intrinsics.f(inputType, "inputType");
        this.f43753f = id;
        this.f43754g = str;
        this.f43755h = inputType;
    }

    @Override // eu.bolt.verification.sdk.internal.ob
    public String a() {
        return this.f43753f;
    }

    public final String b() {
        return this.f43754g;
    }

    public final a c() {
        return this.f43755h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof jl) {
            jl jlVar = (jl) obj;
            return Intrinsics.a(a(), jlVar.a()) && Intrinsics.a(this.f43754g, jlVar.f43754g) && this.f43755h == jlVar.f43755h;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = a().hashCode() * 31;
        String str = this.f43754g;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f43755h.hashCode();
    }

    public String toString() {
        String a8 = a();
        String str = this.f43754g;
        a aVar = this.f43755h;
        return "TextInput(id=" + a8 + ", hint=" + str + ", inputType=" + aVar + ")";
    }
}
