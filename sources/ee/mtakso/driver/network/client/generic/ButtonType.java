package ee.mtakso.driver.network.client.generic;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ButtonType.kt */
/* loaded from: classes3.dex */
public enum ButtonType implements Parcelable {
    ACTION,
    PRIMARY,
    CRITICAL,
    SECONDARY,
    TEXT_PRIMARY,
    TEXT_SECONDARY;
    
    public static final Parcelable.Creator<ButtonType> CREATOR = new Parcelable.Creator<ButtonType>() { // from class: ee.mtakso.driver.network.client.generic.ButtonType.Creator
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final ButtonType createFromParcel(Parcel parcel) {
            Intrinsics.f(parcel, "parcel");
            return ButtonType.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public final ButtonType[] newArray(int i8) {
            return new ButtonType[i8];
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
