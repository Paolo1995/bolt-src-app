package ee.mtakso.driver.network.client.price;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriceReview.kt */
/* loaded from: classes3.dex */
public final class PriceReviewReason implements Parcelable {
    public static final Parcelable.Creator<PriceReviewReason> CREATOR = new Creator();
    @SerializedName("code")

    /* renamed from: f  reason: collision with root package name */
    private final String f22660f;
    @SerializedName("name")

    /* renamed from: g  reason: collision with root package name */
    private final String f22661g;
    @SerializedName("driver_allow_comment")

    /* renamed from: h  reason: collision with root package name */
    private final boolean f22662h;
    @SerializedName("driver_allow_set_price")

    /* renamed from: i  reason: collision with root package name */
    private final boolean f22663i;

    /* compiled from: PriceReview.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<PriceReviewReason> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PriceReviewReason createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new PriceReviewReason(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final PriceReviewReason[] newArray(int i8) {
            return new PriceReviewReason[i8];
        }
    }

    public PriceReviewReason(String reasonCode, String reasonName, boolean z7, boolean z8) {
        Intrinsics.f(reasonCode, "reasonCode");
        Intrinsics.f(reasonName, "reasonName");
        this.f22660f = reasonCode;
        this.f22661g = reasonName;
        this.f22662h = z7;
        this.f22663i = z8;
    }

    public final String a() {
        return this.f22660f;
    }

    public final String b() {
        return this.f22661g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PriceReviewReason) {
            PriceReviewReason priceReviewReason = (PriceReviewReason) obj;
            return Intrinsics.a(this.f22660f, priceReviewReason.f22660f) && Intrinsics.a(this.f22661g, priceReviewReason.f22661g) && this.f22662h == priceReviewReason.f22662h && this.f22663i == priceReviewReason.f22663i;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f22660f.hashCode() * 31) + this.f22661g.hashCode()) * 31;
        boolean z7 = this.f22662h;
        int i8 = z7;
        if (z7 != 0) {
            i8 = 1;
        }
        int i9 = (hashCode + i8) * 31;
        boolean z8 = this.f22663i;
        return i9 + (z8 ? 1 : z8 ? 1 : 0);
    }

    public String toString() {
        String str = this.f22660f;
        String str2 = this.f22661g;
        boolean z7 = this.f22662h;
        boolean z8 = this.f22663i;
        return "PriceReviewReason(reasonCode=" + str + ", reasonName=" + str2 + ", reasonCommentAllowed=" + z7 + ", reasonSetPriceAllowed=" + z8 + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(this.f22660f);
        out.writeString(this.f22661g);
        out.writeInt(this.f22662h ? 1 : 0);
        out.writeInt(this.f22663i ? 1 : 0);
    }
}
