package ee.mtakso.driver.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
/* loaded from: classes3.dex */
public final class DestinationsValidationErrorData implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f22993i = new Companion(null);
    @SerializedName("min_distance")

    /* renamed from: f  reason: collision with root package name */
    private final Double f22994f;
    @SerializedName("max_distance")

    /* renamed from: g  reason: collision with root package name */
    private final Double f22995g;
    @SerializedName("limit_max")

    /* renamed from: h  reason: collision with root package name */
    private final Integer f22996h;

    /* compiled from: ServerResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DestinationsValidationErrorData) {
            DestinationsValidationErrorData destinationsValidationErrorData = (DestinationsValidationErrorData) obj;
            return Intrinsics.a(this.f22994f, destinationsValidationErrorData.f22994f) && Intrinsics.a(this.f22995g, destinationsValidationErrorData.f22995g) && Intrinsics.a(this.f22996h, destinationsValidationErrorData.f22996h);
        }
        return false;
    }

    public int hashCode() {
        Double d8 = this.f22994f;
        int hashCode = (d8 == null ? 0 : d8.hashCode()) * 31;
        Double d9 = this.f22995g;
        int hashCode2 = (hashCode + (d9 == null ? 0 : d9.hashCode())) * 31;
        Integer num = this.f22996h;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        Double d8 = this.f22994f;
        Double d9 = this.f22995g;
        Integer num = this.f22996h;
        return "DestinationsValidationErrorData(minDistanceKm=" + d8 + ", maxDistanceKm=" + d9 + ", limitMax=" + num + ")";
    }
}
