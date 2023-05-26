package com.google.android.gms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.GoogleMapOptions;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "CameraPositionCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<CameraPosition> CREATOR = new zza();
    @SafeParcelable.Field(id = 5)
    public final float bearing;
    @NonNull
    @SafeParcelable.Field(id = 2)
    public final LatLng target;
    @SafeParcelable.Field(id = 4)
    public final float tilt;
    @SafeParcelable.Field(id = 3)
    public final float zoom;

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private LatLng zza;
        private float zzb;
        private float zzc;
        private float zzd;

        public Builder() {
        }

        public Builder(@NonNull CameraPosition cameraPosition) {
            CameraPosition cameraPosition2 = (CameraPosition) Preconditions.checkNotNull(cameraPosition, "previous must not be null.");
            this.zza = cameraPosition2.target;
            this.zzb = cameraPosition2.zoom;
            this.zzc = cameraPosition2.tilt;
            this.zzd = cameraPosition2.bearing;
        }

        @NonNull
        public Builder bearing(float f8) {
            this.zzd = f8;
            return this;
        }

        @NonNull
        public CameraPosition build() {
            return new CameraPosition(this.zza, this.zzb, this.zzc, this.zzd);
        }

        @NonNull
        public Builder target(@NonNull LatLng latLng) {
            this.zza = (LatLng) Preconditions.checkNotNull(latLng, "location must not be null.");
            return this;
        }

        @NonNull
        public Builder tilt(float f8) {
            this.zzc = f8;
            return this;
        }

        @NonNull
        public Builder zoom(float f8) {
            this.zzb = f8;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CameraPosition(@NonNull @SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) float f8, @SafeParcelable.Param(id = 4) float f9, @SafeParcelable.Param(id = 5) float f10) {
        boolean z7;
        Preconditions.checkNotNull(latLng, "camera target must not be null.");
        if (f9 >= 0.0f && f9 <= 90.0f) {
            z7 = true;
        } else {
            z7 = false;
        }
        Preconditions.checkArgument(z7, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f9));
        this.target = latLng;
        this.zoom = f8;
        this.tilt = f9 + 0.0f;
        this.bearing = (((double) f10) <= 0.0d ? (f10 % 360.0f) + 360.0f : f10) % 360.0f;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public static Builder builder(@NonNull CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        return GoogleMapOptions.zza(context, attributeSet);
    }

    @NonNull
    public static final CameraPosition fromLatLngZoom(@NonNull LatLng latLng, float f8) {
        return new CameraPosition(latLng, f8, 0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("target", this.target).add("zoom", Float.valueOf(this.zoom)).add("tilt", Float.valueOf(this.tilt)).add("bearing", Float.valueOf(this.bearing)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.target, i8, false);
        SafeParcelWriter.writeFloat(parcel, 3, this.zoom);
        SafeParcelWriter.writeFloat(parcel, 4, this.tilt);
        SafeParcelWriter.writeFloat(parcel, 5, this.bearing);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
