package eu.bolt.driver.core.network.response;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicServerResponse.kt */
/* loaded from: classes5.dex */
public final class ServerResponse<Data> extends BasicServerResponse {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    private final int f40890a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f40891b;
    @SerializedName("error_data")

    /* renamed from: c  reason: collision with root package name */
    private final ErrorData f40892c;
    @SerializedName("data")

    /* renamed from: d  reason: collision with root package name */
    private final Data f40893d;

    public int a() {
        return this.f40890a;
    }

    public final Data b() {
        return this.f40893d;
    }

    public ErrorData c() {
        return this.f40892c;
    }

    public String d() {
        return this.f40891b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ServerResponse) {
            ServerResponse serverResponse = (ServerResponse) obj;
            return a() == serverResponse.a() && Intrinsics.a(d(), serverResponse.d()) && Intrinsics.a(c(), serverResponse.c()) && Intrinsics.a(this.f40893d, serverResponse.f40893d);
        }
        return false;
    }

    public int hashCode() {
        int a8 = ((((a() * 31) + d().hashCode()) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
        Data data = this.f40893d;
        return a8 + (data != null ? data.hashCode() : 0);
    }

    public String toString() {
        int a8 = a();
        String d8 = d();
        ErrorData c8 = c();
        Data data = this.f40893d;
        return "ServerResponse(code=" + a8 + ", message=" + d8 + ", errorData=" + c8 + ", data=" + data + ")";
    }
}
