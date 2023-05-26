package ee.mtakso.driver.ui.screens.order.arrived.fragments.problem_with_price;

import android.os.Parcel;
import android.os.Parcelable;
import ee.mtakso.driver.uicore.components.views.priceSelectorView.PriceSelectorView;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GivenPriceInfo.kt */
/* loaded from: classes3.dex */
public final class GivenPriceInfo implements Parcelable {
    public static final Parcelable.Creator<GivenPriceInfo> CREATOR = new Creator();

    /* renamed from: f  reason: collision with root package name */
    private final String f31140f;

    /* renamed from: g  reason: collision with root package name */
    private final PriceSelectorView.CurrencyGravity f31141g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31142h;

    /* renamed from: i  reason: collision with root package name */
    private final BigDecimal f31143i;

    /* compiled from: GivenPriceInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<GivenPriceInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final GivenPriceInfo createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new GivenPriceInfo(parcel.readString(), PriceSelectorView.CurrencyGravity.valueOf(parcel.readString()), parcel.readInt(), (BigDecimal) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final GivenPriceInfo[] newArray(int i8) {
            return new GivenPriceInfo[i8];
        }
    }

    public GivenPriceInfo(String currencySymbol, PriceSelectorView.CurrencyGravity currencyGravity, int i8, BigDecimal bigDecimal) {
        Intrinsics.f(currencySymbol, "currencySymbol");
        Intrinsics.f(currencyGravity, "currencyGravity");
        this.f31140f = currencySymbol;
        this.f31141g = currencyGravity;
        this.f31142h = i8;
        this.f31143i = bigDecimal;
    }

    public final PriceSelectorView.CurrencyGravity a() {
        return this.f31141g;
    }

    public final String b() {
        return this.f31140f;
    }

    public final int c() {
        return this.f31142h;
    }

    public final BigDecimal d() {
        return this.f31143i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GivenPriceInfo) {
            GivenPriceInfo givenPriceInfo = (GivenPriceInfo) obj;
            return Intrinsics.a(this.f31140f, givenPriceInfo.f31140f) && this.f31141g == givenPriceInfo.f31141g && this.f31142h == givenPriceInfo.f31142h && Intrinsics.a(this.f31143i, givenPriceInfo.f31143i);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f31140f.hashCode() * 31) + this.f31141g.hashCode()) * 31) + this.f31142h) * 31;
        BigDecimal bigDecimal = this.f31143i;
        return hashCode + (bigDecimal == null ? 0 : bigDecimal.hashCode());
    }

    public String toString() {
        String str = this.f31140f;
        PriceSelectorView.CurrencyGravity currencyGravity = this.f31141g;
        int i8 = this.f31142h;
        BigDecimal bigDecimal = this.f31143i;
        return "GivenPriceInfo(currencySymbol=" + str + ", currencyGravity=" + currencyGravity + ", priceDecimalsFormattingRules=" + i8 + ", totalPrice=" + bigDecimal + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f31140f);
        out.writeString(this.f31141g.name());
        out.writeInt(this.f31142h);
        out.writeSerializable(this.f31143i);
    }
}
