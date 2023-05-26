package eu.bolt.driver.chat;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticChatConfig.kt */
/* loaded from: classes5.dex */
public final class StaticChatConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f40408a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40409b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40410c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40411d;

    public StaticChatConfig(String deviceUuid, String deviceName, String appVersion, String chatUrl) {
        Intrinsics.f(deviceUuid, "deviceUuid");
        Intrinsics.f(deviceName, "deviceName");
        Intrinsics.f(appVersion, "appVersion");
        Intrinsics.f(chatUrl, "chatUrl");
        this.f40408a = deviceUuid;
        this.f40409b = deviceName;
        this.f40410c = appVersion;
        this.f40411d = chatUrl;
    }

    public final String a() {
        return this.f40410c;
    }

    public final String b() {
        return this.f40411d;
    }

    public final String c() {
        return this.f40409b;
    }

    public final String d() {
        return this.f40408a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StaticChatConfig) {
            StaticChatConfig staticChatConfig = (StaticChatConfig) obj;
            return Intrinsics.a(this.f40408a, staticChatConfig.f40408a) && Intrinsics.a(this.f40409b, staticChatConfig.f40409b) && Intrinsics.a(this.f40410c, staticChatConfig.f40410c) && Intrinsics.a(this.f40411d, staticChatConfig.f40411d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f40408a.hashCode() * 31) + this.f40409b.hashCode()) * 31) + this.f40410c.hashCode()) * 31) + this.f40411d.hashCode();
    }

    public String toString() {
        String str = this.f40408a;
        String str2 = this.f40409b;
        String str3 = this.f40410c;
        String str4 = this.f40411d;
        return "StaticChatConfig(deviceUuid=" + str + ", deviceName=" + str2 + ", appVersion=" + str3 + ", chatUrl=" + str4 + ")";
    }
}
