package eu.bolt.verification.sdk.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q9 {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f44639a;
    @SerializedName(ImagesContract.URL)

    /* renamed from: b  reason: collision with root package name */
    private final String f44640b;
    @SerializedName("size")

    /* renamed from: c  reason: collision with root package name */
    private final w9 f44641c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q9) {
            q9 q9Var = (q9) obj;
            return Intrinsics.a(this.f44639a, q9Var.f44639a) && Intrinsics.a(this.f44640b, q9Var.f44640b) && Intrinsics.a(this.f44641c, q9Var.f44641c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f44639a.hashCode() * 31;
        String str = this.f44640b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        w9 w9Var = this.f44641c;
        return hashCode2 + (w9Var != null ? w9Var.hashCode() : 0);
    }

    public String toString() {
        String str = this.f44639a;
        String str2 = this.f44640b;
        w9 w9Var = this.f44641c;
        return "ImageDataResponse(type=" + str + ", url=" + str2 + ", size=" + w9Var + ")";
    }
}
