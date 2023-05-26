package ee.mtakso.driver.network.client.settings;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Settings.kt */
/* loaded from: classes3.dex */
public final class SettingsResponse implements Parcelable {
    public static final Parcelable.Creator<SettingsResponse> CREATOR = new Creator();
    @SerializedName("search_categories")

    /* renamed from: f  reason: collision with root package name */
    private final SearchCategories f22825f;
    @SerializedName("order_acceptance")

    /* renamed from: g  reason: collision with root package name */
    private final AutoOrderAcceptance f22826g;
    @SerializedName("combined_status")

    /* renamed from: h  reason: collision with root package name */
    private final String f22827h;
    @SerializedName("pricing")

    /* renamed from: i  reason: collision with root package name */
    private final DriverPricing f22828i;

    /* compiled from: Settings.kt */
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<SettingsResponse> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final SettingsResponse createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return new SettingsResponse(parcel.readInt() == 0 ? null : SearchCategories.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : AutoOrderAcceptance.valueOf(parcel.readString()), parcel.readString(), parcel.readInt() != 0 ? DriverPricing.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final SettingsResponse[] newArray(int i8) {
            return new SettingsResponse[i8];
        }
    }

    public SettingsResponse(SearchCategories searchCategories, AutoOrderAcceptance autoOrderAcceptance, String str, DriverPricing driverPricing) {
        this.f22825f = searchCategories;
        this.f22826g = autoOrderAcceptance;
        this.f22827h = str;
        this.f22828i = driverPricing;
    }

    public final AutoOrderAcceptance a() {
        return this.f22826g;
    }

    public final SearchCategories b() {
        return this.f22825f;
    }

    public final String c() {
        return this.f22827h;
    }

    public final DriverPricing d() {
        return this.f22828i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SettingsResponse) {
            SettingsResponse settingsResponse = (SettingsResponse) obj;
            return Intrinsics.a(this.f22825f, settingsResponse.f22825f) && this.f22826g == settingsResponse.f22826g && Intrinsics.a(this.f22827h, settingsResponse.f22827h) && Intrinsics.a(this.f22828i, settingsResponse.f22828i);
        }
        return false;
    }

    public int hashCode() {
        SearchCategories searchCategories = this.f22825f;
        int hashCode = (searchCategories == null ? 0 : searchCategories.hashCode()) * 31;
        AutoOrderAcceptance autoOrderAcceptance = this.f22826g;
        int hashCode2 = (hashCode + (autoOrderAcceptance == null ? 0 : autoOrderAcceptance.hashCode())) * 31;
        String str = this.f22827h;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        DriverPricing driverPricing = this.f22828i;
        return hashCode3 + (driverPricing != null ? driverPricing.hashCode() : 0);
    }

    public String toString() {
        SearchCategories searchCategories = this.f22825f;
        AutoOrderAcceptance autoOrderAcceptance = this.f22826g;
        String str = this.f22827h;
        DriverPricing driverPricing = this.f22828i;
        return "SettingsResponse(categories=" + searchCategories + ", autoOrderAcceptance=" + autoOrderAcceptance + ", combinedStatus=" + str + ", pricing=" + driverPricing + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        SearchCategories searchCategories = this.f22825f;
        if (searchCategories == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            searchCategories.writeToParcel(out, i8);
        }
        AutoOrderAcceptance autoOrderAcceptance = this.f22826g;
        if (autoOrderAcceptance == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(autoOrderAcceptance.name());
        }
        out.writeString(this.f22827h);
        DriverPricing driverPricing = this.f22828i;
        if (driverPricing == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        driverPricing.writeToParcel(out, i8);
    }
}
