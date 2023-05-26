package eu.bolt.verification.sdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j2 extends sb {

    /* renamed from: b  reason: collision with root package name */
    private final h2 f43623b;

    /* renamed from: c  reason: collision with root package name */
    private final String f43624c;

    /* renamed from: d  reason: collision with root package name */
    private final String f43625d;

    /* renamed from: e  reason: collision with root package name */
    private final int f43626e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(h2 country, String countryName, String countryCode, int i8) {
        super(country.toString(), null);
        Intrinsics.f(country, "country");
        Intrinsics.f(countryName, "countryName");
        Intrinsics.f(countryCode, "countryCode");
        this.f43623b = country;
        this.f43624c = countryName;
        this.f43625d = countryCode;
        this.f43626e = i8;
    }

    public final h2 b() {
        return this.f43623b;
    }

    public final String c() {
        return this.f43625d;
    }

    public final String d() {
        return this.f43624c;
    }

    public final int e() {
        return this.f43626e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j2) {
            j2 j2Var = (j2) obj;
            return this.f43623b == j2Var.f43623b && Intrinsics.a(this.f43624c, j2Var.f43624c) && Intrinsics.a(this.f43625d, j2Var.f43625d) && this.f43626e == j2Var.f43626e;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f43623b.hashCode() * 31) + this.f43624c.hashCode()) * 31) + this.f43625d.hashCode()) * 31) + this.f43626e;
    }

    public String toString() {
        h2 h2Var = this.f43623b;
        String str = this.f43624c;
        String str2 = this.f43625d;
        int i8 = this.f43626e;
        return "CountryListItem(country=" + h2Var + ", countryName=" + str + ", countryCode=" + str2 + ", flag=" + i8 + ")";
    }
}
