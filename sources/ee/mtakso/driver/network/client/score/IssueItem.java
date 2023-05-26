package ee.mtakso.driver.network.client.score;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.GenericValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverScore.kt */
/* loaded from: classes3.dex */
public final class IssueItem {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f22737a;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: b  reason: collision with root package name */
    private final GenericValue f22738b;
    @SerializedName("hint")

    /* renamed from: c  reason: collision with root package name */
    private final String f22739c;

    public final String a() {
        return this.f22739c;
    }

    public final String b() {
        return this.f22737a;
    }

    public final GenericValue c() {
        return this.f22738b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IssueItem) {
            IssueItem issueItem = (IssueItem) obj;
            return Intrinsics.a(this.f22737a, issueItem.f22737a) && Intrinsics.a(this.f22738b, issueItem.f22738b) && Intrinsics.a(this.f22739c, issueItem.f22739c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22737a.hashCode() * 31;
        GenericValue genericValue = this.f22738b;
        int hashCode2 = (hashCode + (genericValue == null ? 0 : genericValue.hashCode())) * 31;
        String str = this.f22739c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22737a;
        GenericValue genericValue = this.f22738b;
        String str2 = this.f22739c;
        return "IssueItem(title=" + str + ", value=" + genericValue + ", hint=" + str2 + ")";
    }
}
