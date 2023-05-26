package ee.mtakso.driver.platform.google.network.store_integrity;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayStoreVerificationResultErrorRequest.kt */
/* loaded from: classes3.dex */
public final class PlayStoreVerificationResultErrorRequest implements StoreIntegrityVerificationResultRequest {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f23325a;
    @SerializedName("version_code")

    /* renamed from: b  reason: collision with root package name */
    private final String f23326b;
    @SerializedName("error_message")

    /* renamed from: c  reason: collision with root package name */
    private final String f23327c;
    @SerializedName("integrity_token")

    /* renamed from: d  reason: collision with root package name */
    private final String f23328d;

    public PlayStoreVerificationResultErrorRequest(String type, String str, String message, String str2) {
        Intrinsics.f(type, "type");
        Intrinsics.f(message, "message");
        this.f23325a = type;
        this.f23326b = str;
        this.f23327c = message;
        this.f23328d = str2;
    }

    public String a() {
        return this.f23327c;
    }

    public String b() {
        return this.f23325a;
    }

    public String c() {
        return this.f23326b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayStoreVerificationResultErrorRequest) {
            PlayStoreVerificationResultErrorRequest playStoreVerificationResultErrorRequest = (PlayStoreVerificationResultErrorRequest) obj;
            return Intrinsics.a(b(), playStoreVerificationResultErrorRequest.b()) && Intrinsics.a(c(), playStoreVerificationResultErrorRequest.c()) && Intrinsics.a(a(), playStoreVerificationResultErrorRequest.a()) && Intrinsics.a(this.f23328d, playStoreVerificationResultErrorRequest.f23328d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((b().hashCode() * 31) + (c() == null ? 0 : c().hashCode())) * 31) + a().hashCode()) * 31;
        String str = this.f23328d;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String b8 = b();
        String c8 = c();
        String a8 = a();
        String str = this.f23328d;
        return "PlayStoreVerificationResultErrorRequest(type=" + b8 + ", versionCode=" + c8 + ", message=" + a8 + ", token=" + str + ")";
    }
}
