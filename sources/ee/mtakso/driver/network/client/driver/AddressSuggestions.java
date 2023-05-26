package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Address.kt */
/* loaded from: classes3.dex */
public final class AddressSuggestions {
    @SerializedName("list")

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<AddressSuggestion> f21878a;

    public AddressSuggestions() {
        this(null, 1, null);
    }

    public AddressSuggestions(ArrayList<AddressSuggestion> arrayList) {
        this.f21878a = arrayList;
    }

    public final ArrayList<AddressSuggestion> a() {
        return this.f21878a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AddressSuggestions) && Intrinsics.a(this.f21878a, ((AddressSuggestions) obj).f21878a);
    }

    public int hashCode() {
        ArrayList<AddressSuggestion> arrayList = this.f21878a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public String toString() {
        ArrayList<AddressSuggestion> arrayList = this.f21878a;
        return "AddressSuggestions(addressList=" + arrayList + ")";
    }

    public /* synthetic */ AddressSuggestions(ArrayList arrayList, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? new ArrayList() : arrayList);
    }
}
