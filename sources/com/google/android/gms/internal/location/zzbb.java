package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public final class zzbb implements Parcelable.Creator<zzba> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzba createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayList = zzba.zza;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        long j8 = Long.MAX_VALUE;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                switch (fieldId) {
                    case 5:
                        arrayList = SafeParcelReader.createTypedList(parcel, readHeader, ClientIdentity.CREATOR);
                        continue;
                    case 6:
                        str = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 7:
                        z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 8:
                        z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 9:
                        z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 10:
                        str2 = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 11:
                        z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 12:
                        z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 13:
                        str3 = SafeParcelReader.createString(parcel, readHeader);
                        continue;
                    case 14:
                        j8 = SafeParcelReader.readLong(parcel, readHeader);
                        continue;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        continue;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel, readHeader, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzba(locationRequest, arrayList, str, z7, z8, z9, str2, z10, z11, str3, j8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzba[] newArray(int i8) {
        return new zzba[i8];
    }
}
