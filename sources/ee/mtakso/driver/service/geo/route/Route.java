package ee.mtakso.driver.service.geo.route;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Route.kt */
/* loaded from: classes3.dex */
public final class Route {

    /* renamed from: a  reason: collision with root package name */
    private final String f24419a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24420b;

    public Route(String str, String str2) {
        this.f24419a = str;
        this.f24420b = str2;
    }

    public final String a() {
        return this.f24420b;
    }

    public final String b() {
        return this.f24419a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return Intrinsics.a(this.f24419a, route.f24419a) && Intrinsics.a(this.f24420b, route.f24420b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f24419a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f24420b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f24419a;
        String str2 = this.f24420b;
        return "Route(polyline=" + str + ", distance=" + str2 + ")";
    }
}
