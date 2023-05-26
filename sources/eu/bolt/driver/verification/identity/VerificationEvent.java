package eu.bolt.driver.verification.identity;

import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationEvent.kt */
/* loaded from: classes5.dex */
public final class VerificationEvent {

    /* renamed from: a  reason: collision with root package name */
    private final String f41590a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Serializable> f41591b;

    /* JADX WARN: Multi-variable type inference failed */
    public VerificationEvent(String name, Map<String, ? extends Serializable> parameters) {
        Intrinsics.f(name, "name");
        Intrinsics.f(parameters, "parameters");
        this.f41590a = name;
        this.f41591b = parameters;
    }

    public final String a() {
        return this.f41590a;
    }

    public final Map<String, Serializable> b() {
        return this.f41591b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerificationEvent) {
            VerificationEvent verificationEvent = (VerificationEvent) obj;
            return Intrinsics.a(this.f41590a, verificationEvent.f41590a) && Intrinsics.a(this.f41591b, verificationEvent.f41591b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f41590a.hashCode() * 31) + this.f41591b.hashCode();
    }

    public String toString() {
        String str = this.f41590a;
        Map<String, Serializable> map = this.f41591b;
        return "VerificationEvent(name=" + str + ", parameters=" + map + ")";
    }
}
