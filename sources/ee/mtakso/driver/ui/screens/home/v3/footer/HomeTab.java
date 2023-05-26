package ee.mtakso.driver.ui.screens.home.v3.footer;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeTab.kt */
/* loaded from: classes3.dex */
public enum HomeTab implements Parcelable {
    WORK,
    NEWS,
    HISTORY,
    SETTINGS;
    
    public static final Parcelable.Creator<HomeTab> CREATOR = new Parcelable.Creator<HomeTab>() { // from class: ee.mtakso.driver.ui.screens.home.v3.footer.HomeTab.Creator
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final HomeTab createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return HomeTab.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final HomeTab[] newArray(int i8) {
            return new HomeTab[i8];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i8) {
        Intrinsics.f(out, "out");
        out.writeString(name());
    }
}
