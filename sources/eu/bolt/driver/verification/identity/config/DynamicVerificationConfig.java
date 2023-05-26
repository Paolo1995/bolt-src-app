package eu.bolt.driver.verification.identity.config;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicVerificationConfig.kt */
/* loaded from: classes5.dex */
public final class DynamicVerificationConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f41594a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41595b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41596c;

    public DynamicVerificationConfig(String language, String authHeader, String str) {
        Intrinsics.f(language, "language");
        Intrinsics.f(authHeader, "authHeader");
        this.f41594a = language;
        this.f41595b = authHeader;
        this.f41596c = str;
    }

    public final String a() {
        return this.f41595b;
    }

    public final String b() {
        return this.f41596c;
    }

    public final String c() {
        return this.f41594a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DynamicVerificationConfig) {
            DynamicVerificationConfig dynamicVerificationConfig = (DynamicVerificationConfig) obj;
            return Intrinsics.a(this.f41594a, dynamicVerificationConfig.f41594a) && Intrinsics.a(this.f41595b, dynamicVerificationConfig.f41595b) && Intrinsics.a(this.f41596c, dynamicVerificationConfig.f41596c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f41594a.hashCode() * 31) + this.f41595b.hashCode()) * 31;
        String str = this.f41596c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.f41594a;
        String str2 = this.f41595b;
        String str3 = this.f41596c;
        return "DynamicVerificationConfig(language=" + str + ", authHeader=" + str2 + ", country=" + str3 + ")";
    }
}
