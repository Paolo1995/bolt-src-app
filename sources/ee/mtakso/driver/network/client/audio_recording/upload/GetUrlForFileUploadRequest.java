package ee.mtakso.driver.network.client.audio_recording.upload;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUrlForFileUploadRequest.kt */
/* loaded from: classes3.dex */
public final class GetUrlForFileUploadRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f21393a;
    @SerializedName("file_index")

    /* renamed from: b  reason: collision with root package name */
    private final int f21394b;
    @SerializedName("total_files")

    /* renamed from: c  reason: collision with root package name */
    private final int f21395c;

    public GetUrlForFileUploadRequest(OrderHandle orderHandle, int i8, int i9) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f21393a = orderHandle;
        this.f21394b = i8;
        this.f21395c = i9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetUrlForFileUploadRequest) {
            GetUrlForFileUploadRequest getUrlForFileUploadRequest = (GetUrlForFileUploadRequest) obj;
            return Intrinsics.a(this.f21393a, getUrlForFileUploadRequest.f21393a) && this.f21394b == getUrlForFileUploadRequest.f21394b && this.f21395c == getUrlForFileUploadRequest.f21395c;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f21393a.hashCode() * 31) + this.f21394b) * 31) + this.f21395c;
    }

    public String toString() {
        OrderHandle orderHandle = this.f21393a;
        int i8 = this.f21394b;
        int i9 = this.f21395c;
        return "GetUrlForFileUploadRequest(orderHandle=" + orderHandle + ", fileIndex=" + i8 + ", totalFiles=" + i9 + ")";
    }
}
