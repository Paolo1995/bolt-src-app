package ee.mtakso.driver.network.client.auth.anonymous;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.platform.network.store_integrity.StoreIntegrityVerificationResultRequest;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhoneAuthenticationRequest.kt */
/* loaded from: classes3.dex */
public final class PhoneAuthenticationRequest {
    @SerializedName("phone")

    /* renamed from: a  reason: collision with root package name */
    private final String f21489a;
    @SerializedName("client_secret")

    /* renamed from: b  reason: collision with root package name */
    private final String f21490b;
    @SerializedName("app_store_verification_result")

    /* renamed from: c  reason: collision with root package name */
    private final StoreIntegrityVerificationResultRequest f21491c;

    public PhoneAuthenticationRequest(String phone, String str, StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest) {
        Intrinsics.f(phone, "phone");
        this.f21489a = phone;
        this.f21490b = str;
        this.f21491c = storeIntegrityVerificationResultRequest;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PhoneAuthenticationRequest) {
            PhoneAuthenticationRequest phoneAuthenticationRequest = (PhoneAuthenticationRequest) obj;
            return Intrinsics.a(this.f21489a, phoneAuthenticationRequest.f21489a) && Intrinsics.a(this.f21490b, phoneAuthenticationRequest.f21490b) && Intrinsics.a(this.f21491c, phoneAuthenticationRequest.f21491c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f21489a.hashCode() * 31;
        String str = this.f21490b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest = this.f21491c;
        return hashCode2 + (storeIntegrityVerificationResultRequest != null ? storeIntegrityVerificationResultRequest.hashCode() : 0);
    }

    public String toString() {
        String str = this.f21489a;
        String str2 = this.f21490b;
        StoreIntegrityVerificationResultRequest storeIntegrityVerificationResultRequest = this.f21491c;
        return "PhoneAuthenticationRequest(phone=" + str + ", clientSecret=" + str2 + ", appStoreVerificationResult=" + storeIntegrityVerificationResultRequest + ")";
    }
}
