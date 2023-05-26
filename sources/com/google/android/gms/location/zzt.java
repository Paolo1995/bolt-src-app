package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public final class zzt implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j8 = 50;
        long j9 = Long.MAX_VALUE;
        boolean z7 = true;
        float f8 = 0.0f;
        int i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 2) {
                    if (fieldId != 3) {
                        if (fieldId != 4) {
                            if (fieldId != 5) {
                                SafeParcelReader.skipUnknownField(parcel, readHeader);
                            } else {
                                i8 = SafeParcelReader.readInt(parcel, readHeader);
                            }
                        } else {
                            j9 = SafeParcelReader.readLong(parcel, readHeader);
                        }
                    } else {
                        f8 = SafeParcelReader.readFloat(parcel, readHeader);
                    }
                } else {
                    j8 = SafeParcelReader.readLong(parcel, readHeader);
                }
            } else {
                z7 = SafeParcelReader.readBoolean(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzs(z7, j8, f8, j9, i8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs[] newArray(int i8) {
        return new zzs[i8];
    }
}
