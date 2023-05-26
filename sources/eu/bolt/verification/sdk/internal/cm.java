package eu.bolt.verification.sdk.internal;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class cm implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f42523f;

    /* renamed from: g  reason: collision with root package name */
    private final d f42524g;

    public cm(String url, d action) {
        Intrinsics.f(url, "url");
        Intrinsics.f(action, "action");
        this.f42523f = url;
        this.f42524g = action;
    }

    public final d a() {
        return this.f42524g;
    }

    public final String b() {
        return this.f42523f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof cm) {
            cm cmVar = (cm) obj;
            return Intrinsics.a(this.f42523f, cmVar.f42523f) && Intrinsics.a(this.f42524g, cmVar.f42524g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f42523f.hashCode() * 31) + this.f42524g.hashCode();
    }

    public String toString() {
        String str = this.f42523f;
        d dVar = this.f42524g;
        return "UrlIntercept(url=" + str + ", action=" + dVar + ")";
    }
}
