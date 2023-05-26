package eu.bolt.driver.core.network.response;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorData.kt */
/* loaded from: classes5.dex */
public final class ErrorData {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f40886a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f40887b;
    @SerializedName("primary_action")

    /* renamed from: c  reason: collision with root package name */
    private final ErrorAction f40888c;
    @SerializedName("secondary_action")

    /* renamed from: d  reason: collision with root package name */
    private final ErrorAction f40889d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ErrorData) {
            ErrorData errorData = (ErrorData) obj;
            return Intrinsics.a(this.f40886a, errorData.f40886a) && Intrinsics.a(this.f40887b, errorData.f40887b) && Intrinsics.a(this.f40888c, errorData.f40888c) && Intrinsics.a(this.f40889d, errorData.f40889d);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f40886a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f40887b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ErrorAction errorAction = this.f40888c;
        int hashCode3 = (hashCode2 + (errorAction == null ? 0 : errorAction.hashCode())) * 31;
        ErrorAction errorAction2 = this.f40889d;
        return hashCode3 + (errorAction2 != null ? errorAction2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f40886a;
        String str2 = this.f40887b;
        ErrorAction errorAction = this.f40888c;
        ErrorAction errorAction2 = this.f40889d;
        return "ErrorData(title=" + str + ", text=" + str2 + ", primaryAction=" + errorAction + ", secondaryAction=" + errorAction2 + ")";
    }
}
