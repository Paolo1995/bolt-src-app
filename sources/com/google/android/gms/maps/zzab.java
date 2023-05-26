package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public final class zzab implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        CameraPosition cameraPosition = null;
        Float f8 = null;
        Float f9 = null;
        LatLngBounds latLngBounds = null;
        Integer num = null;
        String str = null;
        byte b8 = -1;
        byte b9 = -1;
        int i8 = 0;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        byte b13 = -1;
        byte b14 = -1;
        byte b15 = -1;
        byte b16 = -1;
        byte b17 = -1;
        byte b18 = -1;
        byte b19 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    b8 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 3:
                    b9 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 4:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.createParcelable(parcel, readHeader, CameraPosition.CREATOR);
                    break;
                case 6:
                    b10 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 7:
                    b11 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 8:
                    b12 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 9:
                    b13 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 10:
                    b14 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 11:
                    b15 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 12:
                    b16 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 13:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 14:
                    b17 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 15:
                    b18 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 16:
                    f8 = SafeParcelReader.readFloatObject(parcel, readHeader);
                    break;
                case 17:
                    f9 = SafeParcelReader.readFloatObject(parcel, readHeader);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, readHeader, LatLngBounds.CREATOR);
                    break;
                case 19:
                    b19 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 20:
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 21:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GoogleMapOptions(b8, b9, i8, cameraPosition, b10, b11, b12, b13, b14, b15, b16, b17, b18, f8, f9, latLngBounds, b19, num, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new GoogleMapOptions[i8];
    }
}
