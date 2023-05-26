package ee.mtakso.voip_client.sinch;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushProfileData.kt */
/* loaded from: classes5.dex */
public final class PushProfileData {

    /* renamed from: a  reason: collision with root package name */
    private final String f36543a;

    /* renamed from: b  reason: collision with root package name */
    private final String f36544b;

    public PushProfileData(String str, String token) {
        Intrinsics.f(token, "token");
        this.f36543a = str;
        this.f36544b = token;
    }

    public final String a() {
        return this.f36543a;
    }

    public final String b() {
        return this.f36544b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PushProfileData) {
            PushProfileData pushProfileData = (PushProfileData) obj;
            return Intrinsics.a(this.f36543a, pushProfileData.f36543a) && Intrinsics.a(this.f36544b, pushProfileData.f36544b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f36543a;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.f36544b.hashCode();
    }

    public String toString() {
        String str = this.f36543a;
        String str2 = this.f36544b;
        return "PushProfileData(id=" + str + ", token=" + str2 + ")";
    }
}
