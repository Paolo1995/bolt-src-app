package ee.mtakso.driver.network.client.audio_recording.upload;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUrlForFileUploadResponse.kt */
/* loaded from: classes3.dex */
public final class GetUrlForFileUploadResponse {
    @SerializedName(ImagesContract.URL)

    /* renamed from: a  reason: collision with root package name */
    private final String f21396a;
    @SerializedName("crypto_key")

    /* renamed from: b  reason: collision with root package name */
    private final String f21397b;

    public final String a() {
        return this.f21397b;
    }

    public final String b() {
        return this.f21396a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetUrlForFileUploadResponse) {
            GetUrlForFileUploadResponse getUrlForFileUploadResponse = (GetUrlForFileUploadResponse) obj;
            return Intrinsics.a(this.f21396a, getUrlForFileUploadResponse.f21396a) && Intrinsics.a(this.f21397b, getUrlForFileUploadResponse.f21397b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f21396a.hashCode() * 31) + this.f21397b.hashCode();
    }

    public String toString() {
        String str = this.f21396a;
        String str2 = this.f21397b;
        return "GetUrlForFileUploadResponse(url=" + str + ", cryptoKey=" + str2 + ")";
    }
}
