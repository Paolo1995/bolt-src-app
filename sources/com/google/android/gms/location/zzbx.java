package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzbx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbx> CREATOR = new zzby();
    @SafeParcelable.Field(getter = "getStartHour", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getStartMinute", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getEndHour", id = 3)
    private final int zzc;
    @SafeParcelable.Field(getter = "getEndMinute", id = 4)
    private final int zzd;

    @SafeParcelable.Constructor
    public zzbx(@SafeParcelable.Param(id = 1) int i8, @SafeParcelable.Param(id = 2) int i9, @SafeParcelable.Param(id = 3) int i10, @SafeParcelable.Param(id = 4) int i11) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (i8 >= 0 && i8 <= 23) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkState(z7, "Start hour must be in range [0, 23].");
        if (i9 >= 0 && i9 <= 59) {
            z8 = true;
        } else {
            z8 = false;
        }
        Preconditions.checkState(z8, "Start minute must be in range [0, 59].");
        if (i10 >= 0 && i10 <= 23) {
            z9 = true;
        } else {
            z9 = false;
        }
        Preconditions.checkState(z9, "End hour must be in range [0, 23].");
        if (i11 >= 0 && i11 <= 59) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i8 + i9) + i10) + i11 > 0, "Parameters can't be all 0.");
        this.zza = i8;
        this.zzb = i9;
        this.zzc = i10;
        this.zzd = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbx)) {
            return false;
        }
        zzbx zzbxVar = (zzbx) obj;
        if (this.zza == zzbxVar.zza && this.zzb == zzbxVar.zzb && this.zzc == zzbxVar.zzc && this.zzd == zzbxVar.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    public final String toString() {
        int i8 = this.zza;
        int i9 = this.zzb;
        int i10 = this.zzc;
        int i11 = this.zzd;
        StringBuilder sb = new StringBuilder(117);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i8);
        sb.append(", startMinute=");
        sb.append(i9);
        sb.append(", endHour=");
        sb.append(i10);
        sb.append(", endMinute=");
        sb.append(i11);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i8) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
