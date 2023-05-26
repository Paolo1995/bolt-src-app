package ee.mtakso.driver.ui.screens.order.arrived;

import ee.mtakso.driver.network.client.order.PricingData;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverPriceModels.kt */
/* loaded from: classes3.dex */
public final class DrivePriceInfoAndOrderDetails {

    /* renamed from: a  reason: collision with root package name */
    private final PricingData f30985a;

    /* renamed from: b  reason: collision with root package name */
    private final ActiveOrderDetails f30986b;

    public DrivePriceInfoAndOrderDetails(PricingData pricingData, ActiveOrderDetails model) {
        Intrinsics.f(pricingData, "pricingData");
        Intrinsics.f(model, "model");
        this.f30985a = pricingData;
        this.f30986b = model;
    }

    public final ActiveOrderDetails a() {
        return this.f30986b;
    }

    public final PricingData b() {
        return this.f30985a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrivePriceInfoAndOrderDetails) {
            DrivePriceInfoAndOrderDetails drivePriceInfoAndOrderDetails = (DrivePriceInfoAndOrderDetails) obj;
            return Intrinsics.a(this.f30985a, drivePriceInfoAndOrderDetails.f30985a) && Intrinsics.a(this.f30986b, drivePriceInfoAndOrderDetails.f30986b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f30985a.hashCode() * 31) + this.f30986b.hashCode();
    }

    public String toString() {
        PricingData pricingData = this.f30985a;
        ActiveOrderDetails activeOrderDetails = this.f30986b;
        return "DrivePriceInfoAndOrderDetails(pricingData=" + pricingData + ", model=" + activeOrderDetails + ")";
    }
}
