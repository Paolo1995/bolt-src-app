package ee.mtakso.driver.network.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class EmptyDestinationServerResponse extends BasicServerResponse {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    private final int f22997a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f22998b;
    @SerializedName("error_data")

    /* renamed from: c  reason: collision with root package name */
    private final ErrorData f22999c;
    @SerializedName("validation_errors")

    /* renamed from: d  reason: collision with root package name */
    private final List<DestinationValidationError> f23000d;

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public int a() {
        return this.f22997a;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public ErrorData b() {
        return this.f22999c;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public String c() {
        return this.f22998b;
    }

    public final List<DestinationValidationError> d() {
        return this.f23000d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmptyDestinationServerResponse) {
            EmptyDestinationServerResponse emptyDestinationServerResponse = (EmptyDestinationServerResponse) obj;
            return a() == emptyDestinationServerResponse.a() && Intrinsics.a(c(), emptyDestinationServerResponse.c()) && Intrinsics.a(b(), emptyDestinationServerResponse.b()) && Intrinsics.a(this.f23000d, emptyDestinationServerResponse.f23000d);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((a() * 31) + c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
        List<DestinationValidationError> list = this.f23000d;
        return a8 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        int a8 = a();
        String c8 = c();
        ErrorData b8 = b();
        List<DestinationValidationError> list = this.f23000d;
        return "EmptyDestinationServerResponse(code=" + a8 + ", message=" + c8 + ", errorData=" + b8 + ", validationErrors=" + list + ")";
    }
}
