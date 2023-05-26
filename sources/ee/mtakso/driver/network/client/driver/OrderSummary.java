package ee.mtakso.driver.network.client.driver;

import com.google.gson.annotations.SerializedName;
import ee.mtakso.driver.network.client.Coordinates;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Polling.kt */
/* loaded from: classes3.dex */
public final class OrderSummary {
    @SerializedName("order_handle")

    /* renamed from: a  reason: collision with root package name */
    private final OrderHandle f21966a;
    @SerializedName("version")

    /* renamed from: b  reason: collision with root package name */
    private final int f21967b;
    @SerializedName("state")

    /* renamed from: c  reason: collision with root package name */
    private final OrderState f21968c;
    @SerializedName("user_id")

    /* renamed from: d  reason: collision with root package name */
    private final Long f21969d;
    @SerializedName("seconds_till_expected_driver_arrived_to_client")

    /* renamed from: e  reason: collision with root package name */
    private final Long f21970e;
    @SerializedName("seconds_till_arrive_to_destination")

    /* renamed from: f  reason: collision with root package name */
    private final Long f21971f;
    @SerializedName("rider_location")

    /* renamed from: g  reason: collision with root package name */
    private final Coordinates f21972g;
    @SerializedName("b2b_state")

    /* renamed from: h  reason: collision with root package name */
    private final DriverOrderB2bState f21973h;

    public final DriverOrderB2bState a() {
        return this.f21973h;
    }

    public final OrderHandle b() {
        return this.f21966a;
    }

    public final Coordinates c() {
        return this.f21972g;
    }

    public final Long d() {
        return this.f21970e;
    }

    public final Long e() {
        return this.f21971f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderSummary) {
            OrderSummary orderSummary = (OrderSummary) obj;
            return Intrinsics.a(this.f21966a, orderSummary.f21966a) && this.f21967b == orderSummary.f21967b && this.f21968c == orderSummary.f21968c && Intrinsics.a(this.f21969d, orderSummary.f21969d) && Intrinsics.a(this.f21970e, orderSummary.f21970e) && Intrinsics.a(this.f21971f, orderSummary.f21971f) && Intrinsics.a(this.f21972g, orderSummary.f21972g) && this.f21973h == orderSummary.f21973h;
        }
        return false;
    }

    public final OrderState f() {
        return this.f21968c;
    }

    public final Long g() {
        return this.f21969d;
    }

    public final int h() {
        return this.f21967b;
    }

    public int hashCode() {
        int hashCode = ((((this.f21966a.hashCode() * 31) + this.f21967b) * 31) + this.f21968c.hashCode()) * 31;
        Long l8 = this.f21969d;
        int hashCode2 = (hashCode + (l8 == null ? 0 : l8.hashCode())) * 31;
        Long l9 = this.f21970e;
        int hashCode3 = (hashCode2 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.f21971f;
        int hashCode4 = (hashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Coordinates coordinates = this.f21972g;
        int hashCode5 = (hashCode4 + (coordinates == null ? 0 : coordinates.hashCode())) * 31;
        DriverOrderB2bState driverOrderB2bState = this.f21973h;
        return hashCode5 + (driverOrderB2bState != null ? driverOrderB2bState.hashCode() : 0);
    }

    public String toString() {
        OrderHandle orderHandle = this.f21966a;
        int i8 = this.f21967b;
        OrderState orderState = this.f21968c;
        Long l8 = this.f21969d;
        Long l9 = this.f21970e;
        Long l10 = this.f21971f;
        Coordinates coordinates = this.f21972g;
        DriverOrderB2bState driverOrderB2bState = this.f21973h;
        return "OrderSummary(orderHandle=" + orderHandle + ", version=" + i8 + ", state=" + orderState + ", userId=" + l8 + ", secondsToClient=" + l9 + ", secondsToDestination=" + l10 + ", riderLocation=" + coordinates + ", b2bState=" + driverOrderB2bState + ")";
    }
}
