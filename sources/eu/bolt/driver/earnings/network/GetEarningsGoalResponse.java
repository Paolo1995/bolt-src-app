package eu.bolt.driver.earnings.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetEarningsGoalResponse.kt */
/* loaded from: classes5.dex */
public final class GetEarningsGoalResponse {
    @SerializedName("goal")

    /* renamed from: a  reason: collision with root package name */
    private final EarningsGoal f41504a;
    @SerializedName("periods")

    /* renamed from: b  reason: collision with root package name */
    private final List<EarningsGoalPeriod> f41505b;
    @SerializedName("expense_categories")

    /* renamed from: c  reason: collision with root package name */
    private final List<EarningsGoalExpenseCategory> f41506c;
    @SerializedName("currency_symbol_before")

    /* renamed from: d  reason: collision with root package name */
    private final String f41507d;
    @SerializedName("currency_symbol_after")

    /* renamed from: e  reason: collision with root package name */
    private final String f41508e;

    public final String a() {
        return this.f41508e;
    }

    public final String b() {
        return this.f41507d;
    }

    public final List<EarningsGoalExpenseCategory> c() {
        return this.f41506c;
    }

    public final EarningsGoal d() {
        return this.f41504a;
    }

    public final List<EarningsGoalPeriod> e() {
        return this.f41505b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetEarningsGoalResponse) {
            GetEarningsGoalResponse getEarningsGoalResponse = (GetEarningsGoalResponse) obj;
            return Intrinsics.a(this.f41504a, getEarningsGoalResponse.f41504a) && Intrinsics.a(this.f41505b, getEarningsGoalResponse.f41505b) && Intrinsics.a(this.f41506c, getEarningsGoalResponse.f41506c) && Intrinsics.a(this.f41507d, getEarningsGoalResponse.f41507d) && Intrinsics.a(this.f41508e, getEarningsGoalResponse.f41508e);
        }
        return false;
    }

    public int hashCode() {
        EarningsGoal earningsGoal = this.f41504a;
        int hashCode = (((((earningsGoal == null ? 0 : earningsGoal.hashCode()) * 31) + this.f41505b.hashCode()) * 31) + this.f41506c.hashCode()) * 31;
        String str = this.f41507d;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f41508e;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        EarningsGoal earningsGoal = this.f41504a;
        List<EarningsGoalPeriod> list = this.f41505b;
        List<EarningsGoalExpenseCategory> list2 = this.f41506c;
        String str = this.f41507d;
        String str2 = this.f41508e;
        return "GetEarningsGoalResponse(goal=" + earningsGoal + ", periods=" + list + ", expenseCategories=" + list2 + ", currencySymbolBefore=" + str + ", currencySymbolAfter=" + str2 + ")";
    }
}
