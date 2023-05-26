package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticateWithMagicLinkRequest.kt */
/* loaded from: classes3.dex */
public final class AuthenticateWithMagicLinkRequest {
    @SerializedName("token")

    /* renamed from: a  reason: collision with root package name */
    private final String f21477a;
    @SerializedName("version")

    /* renamed from: b  reason: collision with root package name */
    private final String f21478b;
    @SerializedName("device_uid")

    /* renamed from: c  reason: collision with root package name */
    private final String f21479c;
    @SerializedName("device_name")

    /* renamed from: d  reason: collision with root package name */
    private final String f21480d;
    @SerializedName("device_os_version")

    /* renamed from: e  reason: collision with root package name */
    private final String f21481e;
    @SerializedName("app_store_verification_result")

    /* renamed from: f  reason: collision with root package name */
    private final StoreIntegrityVerificationResultRequest f21482f;

    public AuthenticateWithMagicLinkRequest(String magicToken, String version, String deviceUid, String deviceName, String deviceOsVersion, StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest) {
        Intrinsics.f(magicToken, "magicToken");
        Intrinsics.f(version, "version");
        Intrinsics.f(deviceUid, "deviceUid");
        Intrinsics.f(deviceName, "deviceName");
        Intrinsics.f(deviceOsVersion, "deviceOsVersion");
        this.f21477a = magicToken;
        this.f21478b = version;
        this.f21479c = deviceUid;
        this.f21480d = deviceName;
        this.f21481e = deviceOsVersion;
        this.f21482f = storeIntegrityVerificationResultRequest;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AuthenticateWithMagicLinkRequest) {
            AuthenticateWithMagicLinkRequest authenticateWithMagicLinkRequest = (AuthenticateWithMagicLinkRequest) obj;
            return Intrinsics.a(this.f21477a, authenticateWithMagicLinkRequest.f21477a) && Intrinsics.a(this.f21478b, authenticateWithMagicLinkRequest.f21478b) && Intrinsics.a(this.f21479c, authenticateWithMagicLinkRequest.f21479c) && Intrinsics.a(this.f21480d, authenticateWithMagicLinkRequest.f21480d) && Intrinsics.a(this.f21481e, authenticateWithMagicLinkRequest.f21481e) && Intrinsics.a(this.f21482f, authenticateWithMagicLinkRequest.f21482f);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f21477a.hashCode() * 31) + this.f21478b.hashCode()) * 31) + this.f21479c.hashCode()) * 31) + this.f21480d.hashCode()) * 31) + this.f21481e.hashCode()) * 31;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest = this.f21482f;
        return hashCode + (storeIntegrityVerificationResultRequest == null ? 0 : storeIntegrityVerificationResultRequest.hashCode());
    }

    public String toString() {
        String str = this.f21477a;
        String str2 = this.f21478b;
        String str3 = this.f21479c;
        String str4 = this.f21480d;
        String str5 = this.f21481e;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest = this.f21482f;
        return "AuthenticateWithMagicLinkRequest(magicToken=" + str + ", version=" + str2 + ", deviceUid=" + str3 + ", deviceName=" + str4 + ", deviceOsVersion=" + str5 + ", appStoreVerificationResult=" + storeIntegrityVerificationResultRequest + ")";
    }
}
