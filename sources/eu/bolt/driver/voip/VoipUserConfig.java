package eu.bolt.driver.voip;

import ee.mtakso.voip_client.sinch.PushProfileData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipUserConfig.kt */
/* loaded from: classes5.dex */
public final class VoipUserConfig {

    /* renamed from: a  reason: collision with root package name */
    private final String f41624a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41625b;

    /* renamed from: c  reason: collision with root package name */
    private final String f41626c;

    /* renamed from: d  reason: collision with root package name */
    private final PushServiceType f41627d;

    /* renamed from: e  reason: collision with root package name */
    private final PushProfileData f41628e;

    public VoipUserConfig(String userId, String applicationKey, String token, PushServiceType pushServiceType, PushProfileData pushProfileData) {
        Intrinsics.f(userId, "userId");
        Intrinsics.f(applicationKey, "applicationKey");
        Intrinsics.f(token, "token");
        Intrinsics.f(pushServiceType, "pushServiceType");
        Intrinsics.f(pushProfileData, "pushProfileData");
        this.f41624a = userId;
        this.f41625b = applicationKey;
        this.f41626c = token;
        this.f41627d = pushServiceType;
        this.f41628e = pushProfileData;
    }

    public final String a() {
        return this.f41625b;
    }

    public final PushProfileData b() {
        return this.f41628e;
    }

    public final PushServiceType c() {
        return this.f41627d;
    }

    public final String d() {
        return this.f41626c;
    }

    public final String e() {
        return this.f41624a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VoipUserConfig) {
            VoipUserConfig voipUserConfig = (VoipUserConfig) obj;
            return Intrinsics.a(this.f41624a, voipUserConfig.f41624a) && Intrinsics.a(this.f41625b, voipUserConfig.f41625b) && Intrinsics.a(this.f41626c, voipUserConfig.f41626c) && this.f41627d == voipUserConfig.f41627d && Intrinsics.a(this.f41628e, voipUserConfig.f41628e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f41624a.hashCode() * 31) + this.f41625b.hashCode()) * 31) + this.f41626c.hashCode()) * 31) + this.f41627d.hashCode()) * 31) + this.f41628e.hashCode();
    }

    public String toString() {
        String str = this.f41624a;
        String str2 = this.f41625b;
        String str3 = this.f41626c;
        PushServiceType pushServiceType = this.f41627d;
        PushProfileData pushProfileData = this.f41628e;
        return "VoipUserConfig(userId=" + str + ", applicationKey=" + str2 + ", token=" + str3 + ", pushServiceType=" + pushServiceType + ", pushProfileData=" + pushProfileData + ")";
    }
}
