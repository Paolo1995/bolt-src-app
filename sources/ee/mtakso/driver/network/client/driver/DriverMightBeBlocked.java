package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Block.kt */
/* loaded from: classes3.dex */
public final class DriverMightBeBlocked {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final MightBeBlockedType f21932a;
    @SerializedName("scheduled_blocking")

    /* renamed from: b  reason: collision with root package name */
    private final BlockData f21933b;
    @SerializedName("identity_verification")

    /* renamed from: c  reason: collision with root package name */
    private final BoltIdentityVerificationData f21934c;
    @SerializedName("pricing")

    /* renamed from: d  reason: collision with root package name */
    private final PricingRequireData f21935d;
    @SerializedName("confirmation_dialog")

    /* renamed from: e  reason: collision with root package name */
    private final PricingRequireData f21936e;
    @SerializedName("pricing_data")

    /* renamed from: f  reason: collision with root package name */
    private final PricingData f21937f;

    public final BlockData a() {
        return this.f21933b;
    }

    public final PricingRequireData b() {
        return this.f21936e;
    }

    public final BoltIdentityVerificationData c() {
        return this.f21934c;
    }

    public final PricingData d() {
        return this.f21937f;
    }

    public final PricingRequireData e() {
        return this.f21935d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DriverMightBeBlocked) {
            DriverMightBeBlocked driverMightBeBlocked = (DriverMightBeBlocked) obj;
            return this.f21932a == driverMightBeBlocked.f21932a && Intrinsics.a(this.f21933b, driverMightBeBlocked.f21933b) && Intrinsics.a(this.f21934c, driverMightBeBlocked.f21934c) && Intrinsics.a(this.f21935d, driverMightBeBlocked.f21935d) && Intrinsics.a(this.f21936e, driverMightBeBlocked.f21936e) && Intrinsics.a(this.f21937f, driverMightBeBlocked.f21937f);
        }
        return false;
    }

    public final MightBeBlockedType f() {
        return this.f21932a;
    }

    public int hashCode() {
        int hashCode = this.f21932a.hashCode() * 31;
        BlockData blockData = this.f21933b;
        int hashCode2 = (hashCode + (blockData == null ? 0 : blockData.hashCode())) * 31;
        BoltIdentityVerificationData boltIdentityVerificationData = this.f21934c;
        int hashCode3 = (hashCode2 + (boltIdentityVerificationData == null ? 0 : boltIdentityVerificationData.hashCode())) * 31;
        PricingRequireData pricingRequireData = this.f21935d;
        int hashCode4 = (hashCode3 + (pricingRequireData == null ? 0 : pricingRequireData.hashCode())) * 31;
        PricingRequireData pricingRequireData2 = this.f21936e;
        int hashCode5 = (hashCode4 + (pricingRequireData2 == null ? 0 : pricingRequireData2.hashCode())) * 31;
        PricingData pricingData = this.f21937f;
        return hashCode5 + (pricingData != null ? pricingData.hashCode() : 0);
    }

    public String toString() {
        MightBeBlockedType mightBeBlockedType = this.f21932a;
        BlockData blockData = this.f21933b;
        BoltIdentityVerificationData boltIdentityVerificationData = this.f21934c;
        PricingRequireData pricingRequireData = this.f21935d;
        PricingRequireData pricingRequireData2 = this.f21936e;
        PricingData pricingData = this.f21937f;
        return "DriverMightBeBlocked(type=" + mightBeBlockedType + ", blockData=" + blockData + ", driverIdentityVerificationData=" + boltIdentityVerificationData + ", pricingRequiredData=" + pricingRequireData + ", confirmationDialog=" + pricingRequireData2 + ", pricingData=" + pricingData + ")";
    }
}
