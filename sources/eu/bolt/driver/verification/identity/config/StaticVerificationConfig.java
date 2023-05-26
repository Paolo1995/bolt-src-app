package eu.bolt.driver.verification.identity.config;

import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* compiled from: StaticVerificationConfig.kt */
/* loaded from: classes5.dex */
public final class StaticVerificationConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Retrofit.Builder f41597a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41598b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41599c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41600d;

    /* renamed from: e  reason: collision with root package name */
    private final String f41601e;

    public StaticVerificationConfig(Retrofit.Builder retrofitBuilder, String baseUrl, String osVersion, String deviceId, String appVersion) {
        Intrinsics.f(retrofitBuilder, "retrofitBuilder");
        Intrinsics.f(baseUrl, "baseUrl");
        Intrinsics.f(osVersion, "osVersion");
        Intrinsics.f(deviceId, "deviceId");
        Intrinsics.f(appVersion, "appVersion");
        this.f41597a = retrofitBuilder;
        this.f41598b = baseUrl;
        this.f41599c = osVersion;
        this.f41600d = deviceId;
        this.f41601e = appVersion;
    }

    public final String a() {
        return this.f41601e;
    }

    public final String b() {
        return this.f41598b;
    }

    public final String c() {
        return this.f41600d;
    }

    public final String d() {
        return this.f41599c;
    }

    public final Retrofit.Builder e() {
        return this.f41597a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticVerificationConfig) {
            StaticVerificationConfig staticVerificationConfig = (StaticVerificationConfig) obj;
            return Intrinsics.a(this.f41597a, staticVerificationConfig.f41597a) && Intrinsics.a(this.f41598b, staticVerificationConfig.f41598b) && Intrinsics.a(this.f41599c, staticVerificationConfig.f41599c) && Intrinsics.a(this.f41600d, staticVerificationConfig.f41600d) && Intrinsics.a(this.f41601e, staticVerificationConfig.f41601e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f41597a.hashCode() * 31) + this.f41598b.hashCode()) * 31) + this.f41599c.hashCode()) * 31) + this.f41600d.hashCode()) * 31) + this.f41601e.hashCode();
    }

    public String toString() {
        Retrofit.Builder builder = this.f41597a;
        String str = this.f41598b;
        String str2 = this.f41599c;
        String str3 = this.f41600d;
        String str4 = this.f41601e;
        return "StaticVerificationConfig(retrofitBuilder=" + builder + ", baseUrl=" + str + ", osVersion=" + str2 + ", deviceId=" + str3 + ", appVersion=" + str4 + ")";
    }
}
