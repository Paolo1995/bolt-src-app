package ee.mtakso.driver.ui.screens.earnings.v3.common;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CurrencyConfig.kt */
/* loaded from: classes3.dex */
public final class CurrencyConfig implements Parcelable {
    public static final Parcelable.Creator<CurrencyConfig> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f28998f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f28999g;

    /* compiled from: CurrencyConfig.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<CurrencyConfig> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final CurrencyConfig createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new CurrencyConfig(parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final CurrencyConfig[] newArray(int i8) {
            return new CurrencyConfig[i8];
        }
    }

    public CurrencyConfig() {
        this(null, false, 3, null);
    }

    public CurrencyConfig(String symbol, boolean z7) {
        Intrinsics.f(symbol, "symbol");
        this.f28998f = symbol;
        this.f28999g = z7;
    }

    public final String a() {
        return this.f28998f;
    }

    public final boolean b() {
        return this.f28999g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CurrencyConfig) {
            CurrencyConfig currencyConfig = (CurrencyConfig) obj;
            return Intrinsics.a(this.f28998f, currencyConfig.f28998f) && this.f28999g == currencyConfig.f28999g;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f28998f.hashCode() * 31;
        boolean z7 = this.f28999g;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        return hashCode + i8;
    }

    public String toString() {
        String str = this.f28998f;
        boolean z7 = this.f28999g;
        return "CurrencyConfig(symbol=" + str + ", isSuffix=" + z7 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f28998f);
        out.writeInt(this.f28999g ? 1 : 0);
    }

    public /* synthetic */ CurrencyConfig(String str, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "" : str, (i8 & 2) != 0 ? false : z7);
    }
}
