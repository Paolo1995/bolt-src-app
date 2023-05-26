package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StartAuthenticationRequest.kt */
/* loaded from: classes3.dex */
public final class StartAuthenticationRequest {
    @SerializedName("username")

    /* renamed from: a  reason: collision with root package name */
    private final String f21497a;
    @SerializedName("password")

    /* renamed from: b  reason: collision with root package name */
    private final String f21498b;
    @SerializedName("device_uid")

    /* renamed from: c  reason: collision with root package name */
    private final String f21499c;
    @SerializedName("device_name")

    /* renamed from: d  reason: collision with root package name */
    private final String f21500d;
    @SerializedName("device_os_version")

    /* renamed from: e  reason: collision with root package name */
    private final String f21501e;
    @SerializedName("client_secret")

    /* renamed from: f  reason: collision with root package name */
    private final String f21502f;
    @SerializedName("app_store_verification_result")

    /* renamed from: g  reason: collision with root package name */
    private final StoreIntegrityVerificationResultRequest f21503g;

    public StartAuthenticationRequest(String username, String password, String deviceUid, String deviceName, String deviceOsVersion, String str, StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest) {
        Intrinsics.f(username, "username");
        Intrinsics.f(password, "password");
        Intrinsics.f(deviceUid, "deviceUid");
        Intrinsics.f(deviceName, "deviceName");
        Intrinsics.f(deviceOsVersion, "deviceOsVersion");
        this.f21497a = username;
        this.f21498b = password;
        this.f21499c = deviceUid;
        this.f21500d = deviceName;
        this.f21501e = deviceOsVersion;
        this.f21502f = str;
        this.f21503g = storeIntegrityVerificationResultRequest;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StartAuthenticationRequest) {
            StartAuthenticationRequest startAuthenticationRequest = (StartAuthenticationRequest) obj;
            return Intrinsics.a(this.f21497a, startAuthenticationRequest.f21497a) && Intrinsics.a(this.f21498b, startAuthenticationRequest.f21498b) && Intrinsics.a(this.f21499c, startAuthenticationRequest.f21499c) && Intrinsics.a(this.f21500d, startAuthenticationRequest.f21500d) && Intrinsics.a(this.f21501e, startAuthenticationRequest.f21501e) && Intrinsics.a(this.f21502f, startAuthenticationRequest.f21502f) && Intrinsics.a(this.f21503g, startAuthenticationRequest.f21503g);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f21497a.hashCode() * 31) + this.f21498b.hashCode()) * 31) + this.f21499c.hashCode()) * 31) + this.f21500d.hashCode()) * 31) + this.f21501e.hashCode()) * 31;
        String str = this.f21502f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest = this.f21503g;
        return hashCode2 + (storeIntegrityVerificationResultRequest != null ? storeIntegrityVerificationResultRequest.hashCode() : 0);
    }

    public String toString() {
        String str = this.f21497a;
        String str2 = this.f21498b;
        String str3 = this.f21499c;
        String str4 = this.f21500d;
        String str5 = this.f21501e;
        String str6 = this.f21502f;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest = this.f21503g;
        return "StartAuthenticationRequest(username=" + str + ", password=" + str2 + ", deviceUid=" + str3 + ", deviceName=" + str4 + ", deviceOsVersion=" + str5 + ", clientSecret=" + str6 + ", storeVerificationResult=" + storeIntegrityVerificationResultRequest + ")";
    }
}
