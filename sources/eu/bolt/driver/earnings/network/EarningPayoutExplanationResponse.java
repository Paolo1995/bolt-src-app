package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningPayoutExplanationResponse.kt */
/* loaded from: classes5.dex */
public final class EarningPayoutExplanationResponse {
    @SerializedName("title")

    /* renamed from: a  reason: collision with root package name */
    private final String f41444a;
    @SerializedName("items")

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f41445b;
    @SerializedName("info_blocks")

    /* renamed from: c  reason: collision with root package name */
    private final List<DriverInfoBlock> f41446c;

    public final List<DriverInfoBlock> a() {
        return this.f41446c;
    }

    public final List<String> b() {
        return this.f41445b;
    }

    public final String c() {
        return this.f41444a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningPayoutExplanationResponse) {
            EarningPayoutExplanationResponse earningPayoutExplanationResponse = (EarningPayoutExplanationResponse) obj;
            return Intrinsics.a(this.f41444a, earningPayoutExplanationResponse.f41444a) && Intrinsics.a(this.f41445b, earningPayoutExplanationResponse.f41445b) && Intrinsics.a(this.f41446c, earningPayoutExplanationResponse.f41446c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f41444a.hashCode() * 31) + this.f41445b.hashCode()) * 31) + this.f41446c.hashCode();
    }

    public String toString() {
        String str = this.f41444a;
        List<String> list = this.f41445b;
        List<DriverInfoBlock> list2 = this.f41446c;
        return "EarningPayoutExplanationResponse(title=" + str + ", items=" + list + ", infoBlocks=" + list2 + ")";
    }
}
