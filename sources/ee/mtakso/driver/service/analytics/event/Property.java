package ee.mtakso.driver.service.analytics.event;

import ee.mtakso.driver.service.analytics.AnalyticScope;
import ee.mtakso.driver.service.analytics.Scopes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Property.kt */
/* loaded from: classes3.dex */
public final class Property {

    /* renamed from: a  reason: collision with root package name */
    private final String f23475a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23476b;

    /* renamed from: c  reason: collision with root package name */
    private final AnalyticScope f23477c;

    public Property(String key, String value, AnalyticScope scope) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        Intrinsics.f(scope, "scope");
        this.f23475a = key;
        this.f23476b = value;
        this.f23477c = scope;
    }

    public final String a() {
        return this.f23475a;
    }

    public final AnalyticScope b() {
        return this.f23477c;
    }

    public final String c() {
        return this.f23476b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Property) {
            Property property = (Property) obj;
            return Intrinsics.a(this.f23475a, property.f23475a) && Intrinsics.a(this.f23476b, property.f23476b) && Intrinsics.a(this.f23477c, property.f23477c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f23475a.hashCode() * 31) + this.f23476b.hashCode()) * 31) + this.f23477c.hashCode();
    }

    public String toString() {
        String str = this.f23475a;
        String str2 = this.f23476b;
        AnalyticScope analyticScope = this.f23477c;
        return "Property(key=" + str + ", value=" + str2 + ", scope=" + analyticScope + ")";
    }

    public /* synthetic */ Property(String str, String str2, AnalyticScope analyticScope, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i8 & 4) != 0 ? Scopes.f23428a.b() : analyticScope);
    }
}
