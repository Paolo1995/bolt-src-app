package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public final class zzbf implements Parcelable.Creator<LocationRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationRequest createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j8 = 3600000;
        long j9 = 600000;
        long j10 = Long.MAX_VALUE;
        long j11 = 0;
        int i8 = 102;
        boolean z7 = false;
        int i9 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        float f8 = 0.0f;
        boolean z8 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    j8 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 3:
                    j9 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 4:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 6:
                    i9 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    f8 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 8:
                    j11 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 9:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LocationRequest(i8, j8, j9, z7, j10, i9, f8, j11, z8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ LocationRequest[] newArray(int i8) {
        return new LocationRequest[i8];
    }
}
