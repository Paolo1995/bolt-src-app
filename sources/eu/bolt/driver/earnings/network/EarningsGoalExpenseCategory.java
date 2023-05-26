package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import eu.bolt.driver.earnings.network.DriverImage;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpenseCategory.kt */
/* loaded from: classes5.dex */
public final class EarningsGoalExpenseCategory {
    @SerializedName("type")

    /* renamed from: a  reason: collision with root package name */
    private final String f41497a;
    @SerializedName("title")

    /* renamed from: b  reason: collision with root package name */
    private final String f41498b;
    @SerializedName("icon")

    /* renamed from: c  reason: collision with root package name */
    private final DriverImage.Normal f41499c;
    @SerializedName("is_default")

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f41500d;

    public final DriverImage.Normal a() {
        return this.f41499c;
    }

    public final String b() {
        return this.f41498b;
    }

    public final String c() {
        return this.f41497a;
    }

    public final Boolean d() {
        return this.f41500d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalExpenseCategory) {
            EarningsGoalExpenseCategory earningsGoalExpenseCategory = (EarningsGoalExpenseCategory) obj;
            return Intrinsics.a(this.f41497a, earningsGoalExpenseCategory.f41497a) && Intrinsics.a(this.f41498b, earningsGoalExpenseCategory.f41498b) && Intrinsics.a(this.f41499c, earningsGoalExpenseCategory.f41499c) && Intrinsics.a(this.f41500d, earningsGoalExpenseCategory.f41500d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f41497a.hashCode() * 31) + this.f41498b.hashCode()) * 31;
        DriverImage.Normal normal = this.f41499c;
        int hashCode2 = (hashCode + (normal == null ? 0 : normal.hashCode())) * 31;
        Boolean bool = this.f41500d;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        String str = this.f41497a;
        String str2 = this.f41498b;
        DriverImage.Normal normal = this.f41499c;
        Boolean bool = this.f41500d;
        return "EarningsGoalExpenseCategory(type=" + str + ", title=" + str2 + ", icon=" + normal + ", isDefault=" + bool + ")";
    }
}
