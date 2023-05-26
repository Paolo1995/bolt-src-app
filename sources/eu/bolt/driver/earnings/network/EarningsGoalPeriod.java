package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalPeriod.kt */
/* loaded from: classes5.dex */
public final class EarningsGoalPeriod {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f41501a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f41502b;
    @SerializedName("is_default")

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41503c;

    public final String a() {
        return this.f41502b;
    }

    public final String b() {
        return this.f41501a;
    }

    public final boolean c() {
        return this.f41503c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalPeriod) {
            EarningsGoalPeriod earningsGoalPeriod = (EarningsGoalPeriod) obj;
            return Intrinsics.a(this.f41501a, earningsGoalPeriod.f41501a) && Intrinsics.a(this.f41502b, earningsGoalPeriod.f41502b) && this.f41503c == earningsGoalPeriod.f41503c;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f41501a.hashCode() * 31) + this.f41502b.hashCode()) * 31;
        boolean z7 = this.f41503c;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f41501a;
        String str2 = this.f41502b;
        boolean z7 = this.f41503c;
        return "EarningsGoalPeriod(type=" + str + ", title=" + str2 + ", isDefault=" + z7 + ")";
    }
}
