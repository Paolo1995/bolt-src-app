package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = "";
        String str2 = str;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str10 = null;
        String str11 = null;
        long j13 = -2147483648L;
        boolean z7 = true;
        boolean z8 = false;
        int i8 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    j8 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 7:
                    j9 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 8:
                    str7 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    j13 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    str8 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 13:
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 14:
                    j11 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 15:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 17:
                case 20:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 18:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 19:
                    str9 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 21:
                    bool = SafeParcelReader.readBooleanObject(parcel, readHeader);
                    break;
                case 22:
                    j12 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 23:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 24:
                    str10 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 25:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 26:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 27:
                    str11 = SafeParcelReader.createString(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzq(str3, str4, str5, str6, j8, j9, str7, z7, z8, j13, str8, j10, j11, i8, z9, z10, str9, bool, j12, arrayList, str10, str, str2, str11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i8) {
        return new zzq[i8];
    }
}
