package eu.bolt.driver.earnings.network;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BalanceHeader.kt */
/* loaded from: classes5.dex */
public final class BalanceHeader {
    @SerializedName("state")

    /* renamed from: a  reason: collision with root package name */
    private final EarningsBalanceStateType f41323a;
    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.VALUE)

    /* renamed from: b  reason: collision with root package name */
    private final String f41324b;
    @SerializedName("text")

    /* renamed from: c  reason: collision with root package name */
    private final String f41325c;
    @SerializedName("warning_text")

    /* renamed from: d  reason: collision with root package name */
    private final String f41326d;
    @SerializedName("button")

    /* renamed from: e  reason: collision with root package name */
    private final DriverButton f41327e;
    @SerializedName("info_block")

    /* renamed from: f  reason: collision with root package name */
    private final DriverInfoBlock f41328f;
    @SerializedName("banner")

    /* renamed from: g  reason: collision with root package name */
    private final DriverBanner f41329g;

    public final DriverBanner a() {
        return this.f41329g;
    }

    public final DriverButton b() {
        return this.f41327e;
    }

    public final DriverInfoBlock c() {
        return this.f41328f;
    }

    public final EarningsBalanceStateType d() {
        return this.f41323a;
    }

    public final String e() {
        return this.f41325c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BalanceHeader) {
            BalanceHeader balanceHeader = (BalanceHeader) obj;
            return this.f41323a == balanceHeader.f41323a && Intrinsics.a(this.f41324b, balanceHeader.f41324b) && Intrinsics.a(this.f41325c, balanceHeader.f41325c) && Intrinsics.a(this.f41326d, balanceHeader.f41326d) && Intrinsics.a(this.f41327e, balanceHeader.f41327e) && Intrinsics.a(this.f41328f, balanceHeader.f41328f) && Intrinsics.a(this.f41329g, balanceHeader.f41329g);
        }
        return false;
    }

    public final String f() {
        return this.f41324b;
    }

    public int hashCode() {
        int hashCode = ((this.f41323a.hashCode() * 31) + this.f41324b.hashCode()) * 31;
        String str = this.f41325c;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f41326d;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        DriverButton driverButton = this.f41327e;
        int hashCode4 = (hashCode3 + (driverButton == null ? 0 : driverButton.hashCode())) * 31;
        DriverInfoBlock driverInfoBlock = this.f41328f;
        int hashCode5 = (hashCode4 + (driverInfoBlock == null ? 0 : driverInfoBlock.hashCode())) * 31;
        DriverBanner driverBanner = this.f41329g;
        return hashCode5 + (driverBanner != null ? driverBanner.hashCode() : 0);
    }

    public String toString() {
        EarningsBalanceStateType earningsBalanceStateType = this.f41323a;
        String str = this.f41324b;
        String str2 = this.f41325c;
        String str3 = this.f41326d;
        DriverButton driverButton = this.f41327e;
        DriverInfoBlock driverInfoBlock = this.f41328f;
        DriverBanner driverBanner = this.f41329g;
        return "BalanceHeader(state=" + earningsBalanceStateType + ", value=" + str + ", text=" + str2 + ", warningText=" + str3 + ", button=" + driverButton + ", infoBlock=" + driverInfoBlock + ", banner=" + driverBanner + ")";
    }
}
