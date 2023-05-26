package eu.bolt.verification.sdk.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class k2 extends ob {

    /* renamed from: f  reason: collision with root package name */
    private final String f43796f;

    /* renamed from: g  reason: collision with root package name */
    private final h2 f43797g;

    /* renamed from: h  reason: collision with root package name */
    private final List<h2> f43798h;

    /* JADX WARN: Multi-variable type inference failed */
    public k2(String id, h2 defaultCountry, List<? extends h2> list) {
        Intrinsics.f(id, "id");
        Intrinsics.f(defaultCountry, "defaultCountry");
        this.f43796f = id;
        this.f43797g = defaultCountry;
        this.f43798h = list;
    }

    @Override // eu.bolt.verification.sdk.internal.ob
    public String a() {
        return this.f43796f;
    }

    public final List<h2> b() {
        return this.f43798h;
    }

    public final h2 c() {
        return this.f43797g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k2) {
            k2 k2Var = (k2) obj;
            return Intrinsics.a(a(), k2Var.a()) && this.f43797g == k2Var.f43797g && Intrinsics.a(this.f43798h, k2Var.f43798h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((a().hashCode() * 31) + this.f43797g.hashCode()) * 31;
        List<h2> list = this.f43798h;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String a8 = a();
        h2 h2Var = this.f43797g;
        List<h2> list = this.f43798h;
        return "CountryPicker(id=" + a8 + ", defaultCountry=" + h2Var + ", availableCountries=" + list + ")";
    }
}
