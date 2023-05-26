package ee.mtakso.driver.network.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class DestinationServerResponse<Data> extends BasicServerResponse {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    private final int f22984a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f22985b;
    @SerializedName("error_data")

    /* renamed from: c  reason: collision with root package name */
    private final ErrorData f22986c;
    @SerializedName("data")

    /* renamed from: d  reason: collision with root package name */
    private final Data f22987d;
    @SerializedName("validation_errors")

    /* renamed from: e  reason: collision with root package name */
    private final List<DestinationValidationError> f22988e;

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public int a() {
        return this.f22984a;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public ErrorData b() {
        return this.f22986c;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public String c() {
        return this.f22985b;
    }

    public final Data d() {
        return this.f22987d;
    }

    public final List<DestinationValidationError> e() {
        return this.f22988e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DestinationServerResponse) {
            DestinationServerResponse destinationServerResponse = (DestinationServerResponse) obj;
            return a() == destinationServerResponse.a() && Intrinsics.a(c(), destinationServerResponse.c()) && Intrinsics.a(b(), destinationServerResponse.b()) && Intrinsics.a(this.f22987d, destinationServerResponse.f22987d) && Intrinsics.a(this.f22988e, destinationServerResponse.f22988e);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((a() * 31) + c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
        Data data = this.f22987d;
        int hashCode = (a8 + (data == null ? 0 : data.hashCode())) * 31;
        List<DestinationValidationError> list = this.f22988e;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        int a8 = a();
        String c8 = c();
        ErrorData b8 = b();
        Data data = this.f22987d;
        List<DestinationValidationError> list = this.f22988e;
        return "DestinationServerResponse(code=" + a8 + ", message=" + c8 + ", errorData=" + b8 + ", data=" + data + ", validationErrors=" + list + ")";
    }
}
