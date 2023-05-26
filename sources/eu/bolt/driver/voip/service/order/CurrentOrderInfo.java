package eu.bolt.driver.voip.service.order;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CurrentOrderInfo.kt */
/* loaded from: classes5.dex */
public final class CurrentOrderInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f41651a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f41652b;

    public CurrentOrderInfo(String str, Long l8) {
        this.f41651a = str;
        this.f41652b = l8;
    }

    public final String a() {
        return this.f41651a;
    }

    public final Long b() {
        return this.f41652b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CurrentOrderInfo) {
            CurrentOrderInfo currentOrderInfo = (CurrentOrderInfo) obj;
            return Intrinsics.a(this.f41651a, currentOrderInfo.f41651a) && Intrinsics.a(this.f41652b, currentOrderInfo.f41652b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f41651a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l8 = this.f41652b;
        return hashCode + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        String str = this.f41651a;
        Long l8 = this.f41652b;
        return "CurrentOrderInfo(address=" + str + ", secondsToDestination=" + l8 + ")";
    }
}
