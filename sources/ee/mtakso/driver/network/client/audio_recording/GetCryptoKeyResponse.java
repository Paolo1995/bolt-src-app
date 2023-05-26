package ee.mtakso.driver.network.client.audio_recording;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetCryptoKeyResponse.kt */
/* loaded from: classes3.dex */
public final class GetCryptoKeyResponse {
    @SerializedName("crypto_key")

    /* renamed from: a  reason: collision with root package name */
    private final String f21382a;

    public final String a() {
        return this.f21382a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetCryptoKeyResponse) && Intrinsics.a(this.f21382a, ((GetCryptoKeyResponse) obj).f21382a);
    }

    public int hashCode() {
        return this.f21382a.hashCode();
    }

    public String toString() {
        String str = this.f21382a;
        return "GetCryptoKeyResponse(cryptoKey=" + str + ")";
    }
}
