package eu.bolt.driver.core.network.response;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicServerResponse.kt */
/* loaded from: classes5.dex */
public final class EmptyServerResponse extends BasicServerResponse {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    private final int f40878a;
    @SerializedName("message")

    /* renamed from: b  reason: collision with root package name */
    private final String f40879b;
    @SerializedName("error_data")

    /* renamed from: c  reason: collision with root package name */
    private final ErrorData f40880c;

    public int a() {
        return this.f40878a;
    }

    public ErrorData b() {
        return this.f40880c;
    }

    public String c() {
        return this.f40879b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmptyServerResponse) {
            EmptyServerResponse emptyServerResponse = (EmptyServerResponse) obj;
            return a() == emptyServerResponse.a() && Intrinsics.a(c(), emptyServerResponse.c()) && Intrinsics.a(b(), emptyServerResponse.b());
        }
        return false;
    }

    public int hashCode() {
        return (((a() * 31) + c().hashCode()) * 31) + (b() == null ? 0 : b().hashCode());
    }

    public String toString() {
        int a8 = a();
        String c8 = c();
        ErrorData b8 = b();
        return "EmptyServerResponse(code=" + a8 + ", message=" + c8 + ", errorData=" + b8 + ")";
    }
}
