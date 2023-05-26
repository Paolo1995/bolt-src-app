package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        ArrayList arrayList = null;
        double d8 = 0.0d;
        float f8 = 0.0f;
        int i8 = 0;
        int i9 = 0;
        float f9 = 0.0f;
        boolean z7 = false;
        boolean z8 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 3:
                    d8 = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                case 4:
                    f8 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 5:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    i9 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    f9 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new CircleOptions(latLng, d8, f8, i8, i9, f9, z7, z8, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new CircleOptions[i8];
    }
}
