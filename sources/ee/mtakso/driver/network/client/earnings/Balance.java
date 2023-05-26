package ee.mtakso.driver.network.client.earnings;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.generic.ValueMark;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaymentSettingsResponse.kt */
/* loaded from: classes3.dex */
public final class Balance {
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: a  reason: collision with root package name */
    private final String f22086a;
    @SerializedName("comment")

    /* renamed from: b  reason: collision with root package name */
    private final String f22087b;
    @SerializedName("mark")

    /* renamed from: c  reason: collision with root package name */
    private final ValueMark f22088c;

    public final String a() {
        return this.f22087b;
    }

    public final ValueMark b() {
        return this.f22088c;
    }

    public final String c() {
        return this.f22086a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Balance) {
            Balance balance = (Balance) obj;
            return Intrinsics.a(this.f22086a, balance.f22086a) && Intrinsics.a(this.f22087b, balance.f22087b) && this.f22088c == balance.f22088c;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f22086a.hashCode() * 31;
        String str = this.f22087b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ValueMark valueMark = this.f22088c;
        return hashCode2 + (valueMark != null ? valueMark.hashCode() : 0);
    }

    public String toString() {
        String str = this.f22086a;
        String str2 = this.f22087b;
        ValueMark valueMark = this.f22088c;
        return "Balance(value=" + str + ", comment=" + str2 + ", mark=" + valueMark + ")";
    }
}
