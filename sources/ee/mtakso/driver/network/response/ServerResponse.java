package ee.mtakso.driver.network.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class ServerResponse<Data> extends BasicServerResponse {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    private final int f23020a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f23021b;
    @SerializedName("error_data")

    /* renamed from: c  reason: collision with root package name */
    private final ErrorData f23022c;
    @SerializedName("data")

    /* renamed from: d  reason: collision with root package name */
    private final Data f23023d;
    @SerializedName("validation_errors")

    /* renamed from: e  reason: collision with root package name */
    private final List<Object> f23024e;

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public int a() {
        return this.f23020a;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public ErrorData b() {
        return this.f23022c;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public String c() {
        return this.f23021b;
    }

    public final Data d() {
        return this.f23023d;
    }

    public final List<Object> e() {
        return this.f23024e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerResponse) {
            ServerResponse serverResponse = (ServerResponse) obj;
            return a() == serverResponse.a() && Intrinsics.a(c(), serverResponse.c()) && Intrinsics.a(b(), serverResponse.b()) && Intrinsics.a(this.f23023d, serverResponse.f23023d) && Intrinsics.a(this.f23024e, serverResponse.f23024e);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((a() * 31) + c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
        Data data = this.f23023d;
        int hashCode = (a8 + (data == null ? 0 : data.hashCode())) * 31;
        List<Object> list = this.f23024e;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        int a8 = a();
        String c8 = c();
        ErrorData b8 = b();
        Data data = this.f23023d;
        List<Object> list = this.f23024e;
        return "ServerResponse(code=" + a8 + ", message=" + c8 + ", errorData=" + b8 + ", data=" + data + ", validationErrors=" + list + ")";
    }
}
