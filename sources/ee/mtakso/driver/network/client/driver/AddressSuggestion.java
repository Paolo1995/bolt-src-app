package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Address.kt */
/* loaded from: classes3.dex */
public final class AddressSuggestion {
    @SerializedName("destination_address")

    /* renamed from: a  reason: collision with root package name */
    private String f21874a;
    @SerializedName("destination_lat")

    /* renamed from: b  reason: collision with root package name */
    private final Double f21875b;
    @SerializedName("destination_lng")

    /* renamed from: c  reason: collision with root package name */
    private final Double f21876c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21877d;

    public AddressSuggestion() {
        this(null, null, null, 7, null);
    }

    public AddressSuggestion(String str, Double d8, Double d9) {
        this.f21874a = str;
        this.f21875b = d8;
        this.f21876c = d9;
        this.f21877d = true;
    }

    public final String a() {
        return this.f21874a;
    }

    public final Double b() {
        return this.f21875b;
    }

    public final Double c() {
        return this.f21876c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AddressSuggestion) {
            AddressSuggestion addressSuggestion = (AddressSuggestion) obj;
            return Intrinsics.a(this.f21874a, addressSuggestion.f21874a) && Intrinsics.a(this.f21875b, addressSuggestion.f21875b) && Intrinsics.a(this.f21876c, addressSuggestion.f21876c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f21874a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d8 = this.f21875b;
        int hashCode2 = (hashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Double d9 = this.f21876c;
        return hashCode2 + (d9 != null ? d9.hashCode() : 0);
    }

    public String toString() {
        String str = this.f21874a;
        Double d8 = this.f21875b;
        Double d9 = this.f21876c;
        return "AddressSuggestion(destinationAddress=" + str + ", destinationLat=" + d8 + ", destinationLng=" + d9 + ")";
    }

    public /* synthetic */ AddressSuggestion(String str, Double d8, Double d9, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : d8, (i8 & 4) != 0 ? null : d9);
    }
}
