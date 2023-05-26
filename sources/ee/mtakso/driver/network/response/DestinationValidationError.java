package ee.mtakso.driver.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class DestinationValidationError implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f22989i = new Companion(null);
    @SerializedName("error")

    /* renamed from: f  reason: collision with root package name */
    private final String f22990f;
    @SerializedName("text")

    /* renamed from: g  reason: collision with root package name */
    private final String f22991g;
    @SerializedName("data")

    /* renamed from: h  reason: collision with root package name */
    private final DestinationsValidationErrorData f22992h;

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String a() {
        return this.f22990f;
    }

    public final String b() {
        return this.f22991g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DestinationValidationError) {
            DestinationValidationError destinationValidationError = (DestinationValidationError) obj;
            return Intrinsics.a(this.f22990f, destinationValidationError.f22990f) && Intrinsics.a(this.f22991g, destinationValidationError.f22991g) && Intrinsics.a(this.f22992h, destinationValidationError.f22992h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22990f.hashCode() * 31;
        String str = this.f22991g;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        DestinationsValidationErrorData destinationsValidationErrorData = this.f22992h;
        return hashCode2 + (destinationsValidationErrorData != null ? destinationsValidationErrorData.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22990f;
        String str2 = this.f22991g;
        DestinationsValidationErrorData destinationsValidationErrorData = this.f22992h;
        return "DestinationValidationError(error=" + str + ", text=" + str2 + ", data=" + destinationsValidationErrorData + ")";
    }
}
