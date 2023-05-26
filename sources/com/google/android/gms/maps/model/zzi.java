package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public final class zzi implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f8 = 0.0f;
        float f9 = 0.0f;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        float f10 = 0.0f;
        float f11 = 0.5f;
        float f12 = 0.0f;
        float f13 = 1.0f;
        float f14 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 6:
                    f8 = SafeParcelReader.readFloat(parcel, readHeader);
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
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    f10 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 12:
                    f11 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 13:
                    f12 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 14:
                    f13 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 15:
                    f14 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MarkerOptions(latLng, str, str2, iBinder, f8, f9, z7, z8, z9, f10, f11, f12, f13, f14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new MarkerOptions[i8];
    }
}
