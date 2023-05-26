package ee.mtakso.driver.platform.google.network.store_integrity;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayStoreVerificationResultRequest.kt */
/* loaded from: classes3.dex */
public final class PlayStoreVerificationResultRequest implements StoreIntegrityVerificationResultRequest {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f23329a;
    @SerializedName("version_code")

    /* renamed from: b  reason: collision with root package name */
    private final String f23330b;
    @SerializedName("integrity_token")

    /* renamed from: c  reason: collision with root package name */
    private final String f23331c;

    public PlayStoreVerificationResultRequest(String type, String str, String str2) {
        Intrinsics.f(type, "type");
        this.f23329a = type;
        this.f23330b = str;
        this.f23331c = str2;
    }

    public String a() {
        return this.f23329a;
    }

    public String b() {
        return this.f23330b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayStoreVerificationResultRequest) {
            PlayStoreVerificationResultRequest playStoreVerificationResultRequest = (PlayStoreVerificationResultRequest) obj;
            return Intrinsics.a(a(), playStoreVerificationResultRequest.a()) && Intrinsics.a(b(), playStoreVerificationResultRequest.b()) && Intrinsics.a(this.f23331c, playStoreVerificationResultRequest.f23331c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((a().hashCode() * 31) + (b() == null ? 0 : b().hashCode())) * 31;
        String str = this.f23331c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String a8 = a();
        String b8 = b();
        String str = this.f23331c;
        return "PlayStoreVerificationResultRequest(type=" + a8 + ", versionCode=" + b8 + ", token=" + str + ")";
    }
}
