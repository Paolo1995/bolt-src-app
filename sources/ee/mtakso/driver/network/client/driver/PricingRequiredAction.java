package ee.mtakso.driver.network.client.driver;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Block.kt */
/* loaded from: classes3.dex */
public final class PricingRequiredAction implements Parcelable {
    public static final Parcelable.Creator<PricingRequiredAction> CREATOR = new Creator();
    @SerializedName("type")

    /* renamed from: f  reason: collision with root package name */
    private final PricingRequiredActionType f21995f;
    @SerializedName("name")

    /* renamed from: g  reason: collision with root package name */
    private final String f21996g;
    @SerializedName(ImagesContract.URL)

    /* renamed from: h  reason: collision with root package name */
    private final String f21997h;

    /* compiled from: Block.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PricingRequiredAction> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PricingRequiredAction createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new PricingRequiredAction(PricingRequiredActionType.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PricingRequiredAction[] newArray(int i8) {
            return new PricingRequiredAction[i8];
        }
    }

    public PricingRequiredAction(PricingRequiredActionType type, String name, String str) {
        Intrinsics.f(type, "type");
        Intrinsics.f(name, "name");
        this.f21995f = type;
        this.f21996g = name;
        this.f21997h = str;
    }

    public final String a() {
        return this.f21996g;
    }

    public final String b() {
        return this.f21997h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PricingRequiredAction) {
            PricingRequiredAction pricingRequiredAction = (PricingRequiredAction) obj;
            return this.f21995f == pricingRequiredAction.f21995f && Intrinsics.a(this.f21996g, pricingRequiredAction.f21996g) && Intrinsics.a(this.f21997h, pricingRequiredAction.f21997h);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f21995f.hashCode() * 31) + this.f21996g.hashCode()) * 31;
        String str = this.f21997h;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        PricingRequiredActionType pricingRequiredActionType = this.f21995f;
        String str = this.f21996g;
        String str2 = this.f21997h;
        return "PricingRequiredAction(type=" + pricingRequiredActionType + ", name=" + str + ", url=" + str2 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f21995f.name());
        out.writeString(this.f21996g);
        out.writeString(this.f21997h);
    }
}
