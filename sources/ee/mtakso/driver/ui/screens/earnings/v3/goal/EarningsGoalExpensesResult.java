package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpensesResult.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesResult implements Parcelable {
    public static final Parcelable.Creator<EarningsGoalExpensesResult> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final List<EarningsGoalExpense> f29152f;

    /* compiled from: EarningsGoalExpensesResult.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<EarningsGoalExpensesResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final EarningsGoalExpensesResult createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(EarningsGoalExpense.CREATOR.createFromParcel(parcel));
            }
            return new EarningsGoalExpensesResult(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final EarningsGoalExpensesResult[] newArray(int i8) {
            return new EarningsGoalExpensesResult[i8];
        }
    }

    public EarningsGoalExpensesResult(List<EarningsGoalExpense> expenses) {
        Intrinsics.f(expenses, "expenses");
        this.f29152f = expenses;
    }

    public final List<EarningsGoalExpense> a() {
        return this.f29152f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EarningsGoalExpensesResult) && Intrinsics.a(this.f29152f, ((EarningsGoalExpensesResult) obj).f29152f);
    }

    public int hashCode() {
        return this.f29152f.hashCode();
    }

    public String toString() {
        List<EarningsGoalExpense> list = this.f29152f;
        return "EarningsGoalExpensesResult(expenses=" + list + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        List<EarningsGoalExpense> list = this.f29152f;
        out.writeInt(list.size());
        for (EarningsGoalExpense earningsGoalExpense : list) {
            earningsGoalExpense.writeToParcel(out, i8);
        }
    }
}
