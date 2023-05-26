package ee.mtakso.driver.network.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class EmptyServerResponse extends BasicServerResponse {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    private final int f23001a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f23002b;
    @SerializedName("error_data")

    /* renamed from: c  reason: collision with root package name */
    private final ErrorData f23003c;
    @SerializedName("validation_errors")

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f23004d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyServerResponse(int i8, String message, ErrorData errorData, List<Object> list) {
        super(null);
        Intrinsics.f(message, "message");
        this.f23001a = i8;
        this.f23002b = message;
        this.f23003c = errorData;
        this.f23004d = list;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public int a() {
        return this.f23001a;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public ErrorData b() {
        return this.f23003c;
    }

    @Override // ee.mtakso.driver.network.response.BasicServerResponse
    public String c() {
        return this.f23002b;
    }

    public final List<Object> d() {
        return this.f23004d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmptyServerResponse) {
            EmptyServerResponse emptyServerResponse = (EmptyServerResponse) obj;
            return a() == emptyServerResponse.a() && Intrinsics.a(c(), emptyServerResponse.c()) && Intrinsics.a(b(), emptyServerResponse.b()) && Intrinsics.a(this.f23004d, emptyServerResponse.f23004d);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((a() * 31) + c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode())) * 31;
        List<Object> list = this.f23004d;
        return a8 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        int a8 = a();
        String c8 = c();
        ErrorData b8 = b();
        List<Object> list = this.f23004d;
        return "EmptyServerResponse(code=" + a8 + ", message=" + c8 + ", errorData=" + b8 + ", validationErrors=" + list + ")";
    }
}
