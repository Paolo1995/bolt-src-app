package eu.bolt.driver.chat;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DynamicChatConfig.kt */
/* loaded from: classes5.dex */
public final class DynamicChatConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f40392a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40393b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40394c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40395d;

    /* renamed from: e  reason: collision with root package name */
    private final String f40396e;

    public DynamicChatConfig(String language, String driverId, String mqttDriverId, String sessionId, String country) {
        Intrinsics.f(language, "language");
        Intrinsics.f(driverId, "driverId");
        Intrinsics.f(mqttDriverId, "mqttDriverId");
        Intrinsics.f(sessionId, "sessionId");
        Intrinsics.f(country, "country");
        this.f40392a = language;
        this.f40393b = driverId;
        this.f40394c = mqttDriverId;
        this.f40395d = sessionId;
        this.f40396e = country;
    }

    public final String a() {
        return this.f40396e;
    }

    public final String b() {
        return this.f40393b;
    }

    public final String c() {
        return this.f40392a;
    }

    public final String d() {
        return this.f40394c;
    }

    public final String e() {
        return this.f40395d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DynamicChatConfig) {
            DynamicChatConfig dynamicChatConfig = (DynamicChatConfig) obj;
            return Intrinsics.a(this.f40392a, dynamicChatConfig.f40392a) && Intrinsics.a(this.f40393b, dynamicChatConfig.f40393b) && Intrinsics.a(this.f40394c, dynamicChatConfig.f40394c) && Intrinsics.a(this.f40395d, dynamicChatConfig.f40395d) && Intrinsics.a(this.f40396e, dynamicChatConfig.f40396e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f40392a.hashCode() * 31) + this.f40393b.hashCode()) * 31) + this.f40394c.hashCode()) * 31) + this.f40395d.hashCode()) * 31) + this.f40396e.hashCode();
    }

    public String toString() {
        String str = this.f40392a;
        String str2 = this.f40393b;
        String str3 = this.f40394c;
        String str4 = this.f40395d;
        String str5 = this.f40396e;
        return "DynamicChatConfig(language=" + str + ", driverId=" + str2 + ", mqttDriverId=" + str3 + ", sessionId=" + str4 + ", country=" + str5 + ")";
    }
}
