package ee.mtakso.driver.ui.screens.earnings.v3.goal;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.ui.screens.earnings.v3.common.CurrencyConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EarningsGoalExpensesArgs.kt */
/* loaded from: classes3.dex */
public final class EarningsGoalExpensesArgs implements Parcelable {
    public static final Parcelable.Creator<EarningsGoalExpensesArgs> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f29101f;

    /* renamed from: g  reason: collision with root package name */
    private final List<EarningsGoalExpense> f29102g;

    /* renamed from: h  reason: collision with root package name */
    private final CurrencyConfig f29103h;

    /* compiled from: EarningsGoalExpensesArgs.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<EarningsGoalExpensesArgs> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final EarningsGoalExpensesArgs createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i8 = 0; i8 != readInt; i8++) {
                arrayList.add(EarningsGoalExpense.CREATOR.createFromParcel(parcel));
            }
            return new EarningsGoalExpensesArgs(readString, arrayList, CurrencyConfig.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final EarningsGoalExpensesArgs[] newArray(int i8) {
            return new EarningsGoalExpensesArgs[i8];
        }
    }

    public EarningsGoalExpensesArgs(String requestCode, List<EarningsGoalExpense> expenses, CurrencyConfig currencyConfig) {
        Intrinsics.f(requestCode, "requestCode");
        Intrinsics.f(expenses, "expenses");
        Intrinsics.f(currencyConfig, "currencyConfig");
        this.f29101f = requestCode;
        this.f29102g = expenses;
        this.f29103h = currencyConfig;
    }

    public final CurrencyConfig a() {
        return this.f29103h;
    }

    public final List<EarningsGoalExpense> b() {
        return this.f29102g;
    }

    public final String c() {
        return this.f29101f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EarningsGoalExpensesArgs) {
            EarningsGoalExpensesArgs earningsGoalExpensesArgs = (EarningsGoalExpensesArgs) obj;
            return Intrinsics.a(this.f29101f, earningsGoalExpensesArgs.f29101f) && Intrinsics.a(this.f29102g, earningsGoalExpensesArgs.f29102g) && Intrinsics.a(this.f29103h, earningsGoalExpensesArgs.f29103h);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f29101f.hashCode() * 31) + this.f29102g.hashCode()) * 31) + this.f29103h.hashCode();
    }

    public String toString() {
        String str = this.f29101f;
        List<EarningsGoalExpense> list = this.f29102g;
        CurrencyConfig currencyConfig = this.f29103h;
        return "EarningsGoalExpensesArgs(requestCode=" + str + ", expenses=" + list + ", currencyConfig=" + currencyConfig + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f29101f);
        List<EarningsGoalExpense> list = this.f29102g;
        out.writeInt(list.size());
        for (EarningsGoalExpense earningsGoalExpense : list) {
            earningsGoalExpense.writeToParcel(out, i8);
        }
        this.f29103h.writeToParcel(out, i8);
    }
}
