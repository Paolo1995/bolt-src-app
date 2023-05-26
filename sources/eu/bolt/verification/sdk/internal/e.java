package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f42683f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f42684g;

    public e(String eventName, Map<String, String> parameters) {
        Intrinsics.f(eventName, "eventName");
        Intrinsics.f(parameters, "parameters");
        this.f42683f = eventName;
        this.f42684g = parameters;
    }

    public final String a() {
        return this.f42683f;
    }

    public final Map<String, String> b() {
        return this.f42684g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return Intrinsics.a(this.f42683f, eVar.f42683f) && Intrinsics.a(this.f42684g, eVar.f42684g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f42683f.hashCode() * 31) + this.f42684g.hashCode();
    }

    public String toString() {
        String str = this.f42683f;
        Map<String, String> map = this.f42684g;
        return "ActionAnalytics(eventName=" + str + ", parameters=" + map + ")";
    }
}
