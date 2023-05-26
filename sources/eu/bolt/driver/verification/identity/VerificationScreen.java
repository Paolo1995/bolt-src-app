package eu.bolt.driver.verification.identity;

import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VerificationScreen.kt */
/* loaded from: classes5.dex */
public final class VerificationScreen {

    /* renamed from: a  reason: collision with root package name */
    private final String f41592a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Serializable> f41593b;

    /* JADX WARN: Multi-variable type inference failed */
    public VerificationScreen(String name, Map<String, ? extends Serializable> parameters) {
        Intrinsics.f(name, "name");
        Intrinsics.f(parameters, "parameters");
        this.f41592a = name;
        this.f41593b = parameters;
    }

    public final String a() {
        return this.f41592a;
    }

    public final Map<String, Serializable> b() {
        return this.f41593b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerificationScreen) {
            VerificationScreen verificationScreen = (VerificationScreen) obj;
            return Intrinsics.a(this.f41592a, verificationScreen.f41592a) && Intrinsics.a(this.f41593b, verificationScreen.f41593b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f41592a.hashCode() * 31) + this.f41593b.hashCode();
    }

    public String toString() {
        String str = this.f41592a;
        Map<String, Serializable> map = this.f41593b;
        return "VerificationScreen(name=" + str + ", parameters=" + map + ")";
    }
}
