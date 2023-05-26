package ee.mtakso.driver.network.client.audio_recording.upload;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.OrderHandle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUploadFinishedRequest.kt */
/* loaded from: classes3.dex */
public final class FileUploadFinishedRequest {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f21390a;
    @SerializedName("file_index")

    /* renamed from: b  reason: collision with root package name */
    private final int f21391b;

    public FileUploadFinishedRequest(OrderHandle orderHandle, int i8) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f21390a = orderHandle;
        this.f21391b = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileUploadFinishedRequest) {
            FileUploadFinishedRequest fileUploadFinishedRequest = (FileUploadFinishedRequest) obj;
            return Intrinsics.a(this.f21390a, fileUploadFinishedRequest.f21390a) && this.f21391b == fileUploadFinishedRequest.f21391b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f21390a.hashCode() * 31) + this.f21391b;
    }

    public String toString() {
        OrderHandle orderHandle = this.f21390a;
        int i8 = this.f21391b;
        return "FileUploadFinishedRequest(orderHandle=" + orderHandle + ", fileIndex=" + i8 + ")";
    }
}
