package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.GoogleMapOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "LatLngBoundsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zzf();
    @NonNull
    @SafeParcelable.Field(id = 3)
    public final LatLng northeast;
    @NonNull
    @SafeParcelable.Field(id = 2)
    public final LatLng southwest;

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private double zza = Double.POSITIVE_INFINITY;
        private double zzb = Double.NEGATIVE_INFINITY;
        private double zzc = Double.NaN;
        private double zzd = Double.NaN;

        @NonNull
        public LatLngBounds build() {
            Preconditions.checkState(!Double.isNaN(this.zzc), "no included points");
            return new LatLngBounds(new LatLng(this.zza, this.zzc), new LatLng(this.zzb, this.zzd));
        }

        @NonNull
        public Builder include(@NonNull LatLng latLng) {
            Preconditions.checkNotNull(latLng, "point must not be null");
            this.zza = Math.min(this.zza, latLng.latitude);
            this.zzb = Math.max(this.zzb, latLng.latitude);
            double d8 = latLng.longitude;
            if (Double.isNaN(this.zzc)) {
                this.zzc = d8;
                this.zzd = d8;
            } else {
                double d9 = this.zzc;
                double d10 = this.zzd;
                if (d9 > d10 ? !(d9 <= d8 || d8 <= d10) : !(d9 <= d8 && d8 <= d10)) {
                    Parcelable.Creator<LatLngBounds> creator = LatLngBounds.CREATOR;
                    if (((d9 - d8) + 360.0d) % 360.0d < ((d8 - d10) + 360.0d) % 360.0d) {
                        this.zzc = d8;
                    } else {
                        this.zzd = d8;
                    }
                }
            }
            return this;
        }
    }

    @SafeParcelable.Constructor
    public LatLngBounds(@NonNull @SafeParcelable.Param(id = 2) LatLng latLng, @NonNull @SafeParcelable.Param(id = 3) LatLng latLng2) {
        boolean z7;
        Preconditions.checkNotNull(latLng, "southwest must not be null.");
        Preconditions.checkNotNull(latLng2, "northeast must not be null.");
        double d8 = latLng2.latitude;
        double d9 = latLng.latitude;
        if (d8 >= d9) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d9), Double.valueOf(latLng2.latitude));
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.zzb(context, attributeSet);
    }

    private final boolean zza(double d8) {
        double d9 = this.southwest.longitude;
        double d10 = this.northeast.longitude;
        if (d9 <= d10) {
            if (d9 > d8 || d8 > d10) {
                return false;
            }
            return true;
        } else if (d9 > d8 && d8 > d10) {
            return false;
        } else {
            return true;
        }
    }

    public boolean contains(@NonNull LatLng latLng) {
        LatLng latLng2 = (LatLng) Preconditions.checkNotNull(latLng, "point must not be null.");
        double d8 = latLng2.latitude;
        if (this.southwest.latitude <= d8 && d8 <= this.northeast.latitude && zza(latLng2.longitude)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    @NonNull
    public LatLng getCenter() {
        LatLng latLng = this.southwest;
        double d8 = latLng.latitude;
        LatLng latLng2 = this.northeast;
        double d9 = (d8 + latLng2.latitude) / 2.0d;
        double d10 = latLng2.longitude;
        double d11 = latLng.longitude;
        if (d11 > d10) {
            d10 += 360.0d;
        }
        return new LatLng(d9, (d10 + d11) / 2.0d);
    }

    public int hashCode() {
        return Objects.hashCode(this.southwest, this.northeast);
    }

    @NonNull
    public LatLngBounds including(@NonNull LatLng latLng) {
        LatLng latLng2 = (LatLng) Preconditions.checkNotNull(latLng, "point must not be null.");
        double min = Math.min(this.southwest.latitude, latLng2.latitude);
        double max = Math.max(this.northeast.latitude, latLng2.latitude);
        double d8 = this.northeast.longitude;
        double d9 = this.southwest.longitude;
        double d10 = latLng2.longitude;
        if (!zza(d10)) {
            if (((d9 - d10) + 360.0d) % 360.0d < ((d10 - d8) + 360.0d) % 360.0d) {
                d9 = d10;
            } else {
                d8 = d10;
            }
        }
        return new LatLngBounds(new LatLng(min, d9), new LatLng(max, d8));
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("southwest", this.southwest).add("northeast", this.northeast).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.southwest, i8, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.northeast, i8, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
