package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzbf();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_PRIORITY", id = 1)
    int zza;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_INTERVAL", id = 2)
    long zzb;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_FASTEST_INTERVAL", id = 3)
    long zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_EXPLICIT_FASTEST_INTERVAL", id = 4)
    boolean zzd;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_EXPIRE_AT", id = 5)
    long zze;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_NUM_UPDATES", id = 6)
    int zzf;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_SMALLEST_DISPLACEMENT", id = 7)
    float zzg;
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequest.DEFAULT_MAX_WAIT_TIME", id = 8)
    long zzh;
    @SafeParcelable.Field(defaultValue = "false", id = 9)
    boolean zzi;

    @Deprecated
    public LocationRequest() {
        this.zza = 102;
        this.zzb = 3600000L;
        this.zzc = 600000L;
        this.zzd = false;
        this.zze = Long.MAX_VALUE;
        this.zzf = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.zzg = 0.0f;
        this.zzh = 0L;
        this.zzi = false;
    }

    @RecentlyNonNull
    public static LocationRequest create() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setWaitForAccurateLocation(true);
        return locationRequest;
    }

    private static void zza(long j8) {
        if (j8 >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("invalid interval: ");
        sb.append(j8);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && this.zzb == locationRequest.zzb && this.zzc == locationRequest.zzc && this.zzd == locationRequest.zzd && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && getMaxWaitTime() == locationRequest.getMaxWaitTime() && this.zzi == locationRequest.zzi) {
                return true;
            }
        }
        return false;
    }

    public long getExpirationTime() {
        return this.zze;
    }

    public long getFastestInterval() {
        return this.zzc;
    }

    public long getInterval() {
        return this.zzb;
    }

    public long getMaxWaitTime() {
        long j8 = this.zzh;
        long j9 = this.zzb;
        return j8 < j9 ? j9 : j8;
    }

    public int getNumUpdates() {
        return this.zzf;
    }

    public int getPriority() {
        return this.zza;
    }

    public float getSmallestDisplacement() {
        return this.zzg;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzg), Long.valueOf(this.zzh));
    }

    public boolean isFastestIntervalExplicitlySet() {
        return this.zzd;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzi;
    }

    @RecentlyNonNull
    public LocationRequest setExpirationDuration(long j8) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j9 = Long.MAX_VALUE;
        if (j8 <= Long.MAX_VALUE - elapsedRealtime) {
            j9 = j8 + elapsedRealtime;
        }
        this.zze = j9;
        if (j9 < 0) {
            this.zze = 0L;
        }
        return this;
    }

    @RecentlyNonNull
    public LocationRequest setExpirationTime(long j8) {
        this.zze = j8;
        if (j8 < 0) {
            this.zze = 0L;
        }
        return this;
    }

    @RecentlyNonNull
    public LocationRequest setFastestInterval(long j8) {
        zza(j8);
        this.zzd = true;
        this.zzc = j8;
        return this;
    }

    @RecentlyNonNull
    public LocationRequest setInterval(long j8) {
        zza(j8);
        this.zzb = j8;
        if (!this.zzd) {
            this.zzc = (long) (j8 / 6.0d);
        }
        return this;
    }

    @RecentlyNonNull
    public LocationRequest setMaxWaitTime(long j8) {
        zza(j8);
        this.zzh = j8;
        return this;
    }

    @RecentlyNonNull
    public LocationRequest setNumUpdates(int i8) {
        if (i8 > 0) {
            this.zzf = i8;
            return this;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("invalid numUpdates: ");
        sb.append(i8);
        throw new IllegalArgumentException(sb.toString());
    }

    @RecentlyNonNull
    public LocationRequest setPriority(int i8) {
        if (i8 != 100 && i8 != 102 && i8 != 104 && i8 != 105) {
            StringBuilder sb = new StringBuilder(28);
            sb.append("invalid quality: ");
            sb.append(i8);
            throw new IllegalArgumentException(sb.toString());
        }
        this.zza = i8;
        return this;
    }

    @RecentlyNonNull
    public LocationRequest setSmallestDisplacement(float f8) {
        if (f8 >= 0.0f) {
            this.zzg = f8;
            return this;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f8);
        throw new IllegalArgumentException(sb.toString());
    }

    @RecentlyNonNull
    public LocationRequest setWaitForAccurateLocation(boolean z7) {
        this.zzi = z7;
        return this;
    }

    @RecentlyNonNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i8 = this.zza;
        if (i8 != 100) {
            if (i8 != 102) {
                if (i8 != 104) {
                    if (i8 != 105) {
                        str = "???";
                    } else {
                        str = "PRIORITY_NO_POWER";
                    }
                } else {
                    str = "PRIORITY_LOW_POWER";
                }
            } else {
                str = "PRIORITY_BALANCED_POWER_ACCURACY";
            }
        } else {
            str = "PRIORITY_HIGH_ACCURACY";
        }
        sb.append(str);
        if (this.zza != 105) {
            sb.append(" requested=");
            sb.append(this.zzb);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzc);
        sb.append("ms");
        if (this.zzh > this.zzb) {
            sb.append(" maxWait=");
            sb.append(this.zzh);
            sb.append("ms");
        }
        if (this.zzg > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.zzg);
            sb.append("m");
        }
        long j8 = this.zze;
        if (j8 != Long.MAX_VALUE) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j8 - elapsedRealtime);
            sb.append("ms");
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.zzf);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public LocationRequest(@SafeParcelable.Param(id = 1) int i8, @SafeParcelable.Param(id = 2) long j8, @SafeParcelable.Param(id = 3) long j9, @SafeParcelable.Param(id = 4) boolean z7, @SafeParcelable.Param(id = 5) long j10, @SafeParcelable.Param(id = 6) int i9, @SafeParcelable.Param(id = 7) float f8, @SafeParcelable.Param(id = 8) long j11, @SafeParcelable.Param(id = 9) boolean z8) {
        this.zza = i8;
        this.zzb = j8;
        this.zzc = j9;
        this.zzd = z7;
        this.zze = j10;
        this.zzf = i9;
        this.zzg = f8;
        this.zzh = j11;
        this.zzi = z8;
    }
}
