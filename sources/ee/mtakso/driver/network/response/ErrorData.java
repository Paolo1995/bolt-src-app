package ee.mtakso.driver.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class ErrorData implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f23012j = new Companion(null);
    @SerializedName("title")

    /* renamed from: f  reason: collision with root package name */
    private final String f23013f;
    @SerializedName("text")

    /* renamed from: g  reason: collision with root package name */
    private final String f23014g;
    @SerializedName("primary_action")

    /* renamed from: h  reason: collision with root package name */
    private final ErrorAction f23015h;
    @SerializedName("secondary_action")

    /* renamed from: i  reason: collision with root package name */
    private final ErrorAction f23016i;

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final ErrorAction a() {
        return this.f23015h;
    }

    public final ErrorAction b() {
        return this.f23016i;
    }

    public final String c() {
        return this.f23014g;
    }

    public final String d() {
        return this.f23013f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ErrorData) {
            ErrorData errorData = (ErrorData) obj;
            return Intrinsics.a(this.f23013f, errorData.f23013f) && Intrinsics.a(this.f23014g, errorData.f23014g) && Intrinsics.a(this.f23015h, errorData.f23015h) && Intrinsics.a(this.f23016i, errorData.f23016i);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f23013f;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f23014g;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ErrorAction errorAction = this.f23015h;
        int hashCode3 = (hashCode2 + (errorAction == null ? 0 : errorAction.hashCode())) * 31;
        ErrorAction errorAction2 = this.f23016i;
        return hashCode3 + (errorAction2 != null ? errorAction2.hashCode() : 0);
    }

    public String toString() {
        String str = this.f23013f;
        String str2 = this.f23014g;
        ErrorAction errorAction = this.f23015h;
        ErrorAction errorAction2 = this.f23016i;
        return "ErrorData(title=" + str + ", text=" + str2 + ", primaryAction=" + errorAction + ", secondaryAction=" + errorAction2 + ")";
    }
}
