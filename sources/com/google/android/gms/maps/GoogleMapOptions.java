package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "GoogleMapOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzab();
    private static final Integer zza = Integer.valueOf(Color.argb(255, 236, 233, 225));
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZOrderOnTopForParcel", id = 2, type = "byte")
    private Boolean zzb;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getUseViewLifecycleInFragmentForParcel", id = 3, type = "byte")
    private Boolean zzc;
    @SafeParcelable.Field(getter = "getMapType", id = 4)
    private int zzd;
    @SafeParcelable.Field(getter = "getCamera", id = 5)
    private CameraPosition zze;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZoomControlsEnabledForParcel", id = 6, type = "byte")
    private Boolean zzf;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getCompassEnabledForParcel", id = 7, type = "byte")
    private Boolean zzg;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getScrollGesturesEnabledForParcel", id = 8, type = "byte")
    private Boolean zzh;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getZoomGesturesEnabledForParcel", id = 9, type = "byte")
    private Boolean zzi;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getTiltGesturesEnabledForParcel", id = 10, type = "byte")
    private Boolean zzj;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getRotateGesturesEnabledForParcel", id = 11, type = "byte")
    private Boolean zzk;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getLiteModeForParcel", id = 12, type = "byte")
    private Boolean zzl;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getMapToolbarEnabledForParcel", id = 14, type = "byte")
    private Boolean zzm;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getAmbientEnabledForParcel", id = 15, type = "byte")
    private Boolean zzn;
    @SafeParcelable.Field(getter = "getMinZoomPreference", id = 16)
    private Float zzo;
    @SafeParcelable.Field(getter = "getMaxZoomPreference", id = 17)
    private Float zzp;
    @SafeParcelable.Field(getter = "getLatLngBoundsForCameraTarget", id = 18)
    private LatLngBounds zzq;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getScrollGesturesEnabledDuringRotateOrZoomForParcel", id = 19, type = "byte")
    private Boolean zzr;
    @SafeParcelable.Field(getter = "getBackgroundColor", id = 20)
    private Integer zzs;
    @SafeParcelable.Field(getter = "getMapId", id = 21)
    private String zzt;

    public GoogleMapOptions() {
        this.zzd = -1;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        String string;
        if (context != null && attributeSet != null) {
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
            GoogleMapOptions googleMapOptions = new GoogleMapOptions();
            int i8 = R.styleable.MapAttrs_mapType;
            if (obtainAttributes.hasValue(i8)) {
                googleMapOptions.mapType(obtainAttributes.getInt(i8, -1));
            }
            int i9 = R.styleable.MapAttrs_zOrderOnTop;
            if (obtainAttributes.hasValue(i9)) {
                googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(i9, false));
            }
            int i10 = R.styleable.MapAttrs_useViewLifecycle;
            if (obtainAttributes.hasValue(i10)) {
                googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(i10, false));
            }
            int i11 = R.styleable.MapAttrs_uiCompass;
            if (obtainAttributes.hasValue(i11)) {
                googleMapOptions.compassEnabled(obtainAttributes.getBoolean(i11, true));
            }
            int i12 = R.styleable.MapAttrs_uiRotateGestures;
            if (obtainAttributes.hasValue(i12)) {
                googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(i12, true));
            }
            int i13 = R.styleable.MapAttrs_uiScrollGesturesDuringRotateOrZoom;
            if (obtainAttributes.hasValue(i13)) {
                googleMapOptions.scrollGesturesEnabledDuringRotateOrZoom(obtainAttributes.getBoolean(i13, true));
            }
            int i14 = R.styleable.MapAttrs_uiScrollGestures;
            if (obtainAttributes.hasValue(i14)) {
                googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(i14, true));
            }
            int i15 = R.styleable.MapAttrs_uiTiltGestures;
            if (obtainAttributes.hasValue(i15)) {
                googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(i15, true));
            }
            int i16 = R.styleable.MapAttrs_uiZoomGestures;
            if (obtainAttributes.hasValue(i16)) {
                googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(i16, true));
            }
            int i17 = R.styleable.MapAttrs_uiZoomControls;
            if (obtainAttributes.hasValue(i17)) {
                googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(i17, true));
            }
            int i18 = R.styleable.MapAttrs_liteMode;
            if (obtainAttributes.hasValue(i18)) {
                googleMapOptions.liteMode(obtainAttributes.getBoolean(i18, false));
            }
            int i19 = R.styleable.MapAttrs_uiMapToolbar;
            if (obtainAttributes.hasValue(i19)) {
                googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(i19, true));
            }
            int i20 = R.styleable.MapAttrs_ambientEnabled;
            if (obtainAttributes.hasValue(i20)) {
                googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(i20, false));
            }
            int i21 = R.styleable.MapAttrs_cameraMinZoomPreference;
            if (obtainAttributes.hasValue(i21)) {
                googleMapOptions.minZoomPreference(obtainAttributes.getFloat(i21, Float.NEGATIVE_INFINITY));
            }
            if (obtainAttributes.hasValue(i21)) {
                googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
            }
            int i22 = R.styleable.MapAttrs_backgroundColor;
            if (obtainAttributes.hasValue(i22)) {
                googleMapOptions.backgroundColor(Integer.valueOf(obtainAttributes.getColor(i22, zza.intValue())));
            }
            int i23 = R.styleable.MapAttrs_mapId;
            if (obtainAttributes.hasValue(i23) && (string = obtainAttributes.getString(i23)) != null && !string.isEmpty()) {
                googleMapOptions.mapId(string);
            }
            googleMapOptions.latLngBoundsForCameraTarget(zzb(context, attributeSet));
            googleMapOptions.camera(zza(context, attributeSet));
            obtainAttributes.recycle();
            return googleMapOptions;
        }
        return null;
    }

    public static CameraPosition zza(Context context, AttributeSet attributeSet) {
        float f8;
        float f9;
        if (context != null && attributeSet != null) {
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
            int i8 = R.styleable.MapAttrs_cameraTargetLat;
            if (obtainAttributes.hasValue(i8)) {
                f8 = obtainAttributes.getFloat(i8, 0.0f);
            } else {
                f8 = 0.0f;
            }
            int i9 = R.styleable.MapAttrs_cameraTargetLng;
            if (obtainAttributes.hasValue(i9)) {
                f9 = obtainAttributes.getFloat(i9, 0.0f);
            } else {
                f9 = 0.0f;
            }
            LatLng latLng = new LatLng(f8, f9);
            CameraPosition.Builder builder = CameraPosition.builder();
            builder.target(latLng);
            int i10 = R.styleable.MapAttrs_cameraZoom;
            if (obtainAttributes.hasValue(i10)) {
                builder.zoom(obtainAttributes.getFloat(i10, 0.0f));
            }
            int i11 = R.styleable.MapAttrs_cameraBearing;
            if (obtainAttributes.hasValue(i11)) {
                builder.bearing(obtainAttributes.getFloat(i11, 0.0f));
            }
            int i12 = R.styleable.MapAttrs_cameraTilt;
            if (obtainAttributes.hasValue(i12)) {
                builder.tilt(obtainAttributes.getFloat(i12, 0.0f));
            }
            obtainAttributes.recycle();
            return builder.build();
        }
        return null;
    }

    public static LatLngBounds zzb(Context context, AttributeSet attributeSet) {
        Float f8;
        Float f9;
        Float f10;
        Float f11;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        int i8 = R.styleable.MapAttrs_latLngBoundsSouthWestLatitude;
        if (obtainAttributes.hasValue(i8)) {
            f8 = Float.valueOf(obtainAttributes.getFloat(i8, 0.0f));
        } else {
            f8 = null;
        }
        int i9 = R.styleable.MapAttrs_latLngBoundsSouthWestLongitude;
        if (obtainAttributes.hasValue(i9)) {
            f9 = Float.valueOf(obtainAttributes.getFloat(i9, 0.0f));
        } else {
            f9 = null;
        }
        int i10 = R.styleable.MapAttrs_latLngBoundsNorthEastLatitude;
        if (obtainAttributes.hasValue(i10)) {
            f10 = Float.valueOf(obtainAttributes.getFloat(i10, 0.0f));
        } else {
            f10 = null;
        }
        int i11 = R.styleable.MapAttrs_latLngBoundsNorthEastLongitude;
        if (obtainAttributes.hasValue(i11)) {
            f11 = Float.valueOf(obtainAttributes.getFloat(i11, 0.0f));
        } else {
            f11 = null;
        }
        obtainAttributes.recycle();
        if (f8 == null || f9 == null || f10 == null || f11 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(f8.floatValue(), f9.floatValue()), new LatLng(f10.floatValue(), f11.floatValue()));
    }

    @NonNull
    public GoogleMapOptions ambientEnabled(boolean z7) {
        this.zzn = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions backgroundColor(Integer num) {
        this.zzs = num;
        return this;
    }

    @NonNull
    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.zze = cameraPosition;
        return this;
    }

    @NonNull
    public GoogleMapOptions compassEnabled(boolean z7) {
        this.zzg = Boolean.valueOf(z7);
        return this;
    }

    public Boolean getAmbientEnabled() {
        return this.zzn;
    }

    public Integer getBackgroundColor() {
        return this.zzs;
    }

    public CameraPosition getCamera() {
        return this.zze;
    }

    public Boolean getCompassEnabled() {
        return this.zzg;
    }

    public LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.zzq;
    }

    public Boolean getLiteMode() {
        return this.zzl;
    }

    public String getMapId() {
        return this.zzt;
    }

    public Boolean getMapToolbarEnabled() {
        return this.zzm;
    }

    public int getMapType() {
        return this.zzd;
    }

    public Float getMaxZoomPreference() {
        return this.zzp;
    }

    public Float getMinZoomPreference() {
        return this.zzo;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.zzk;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.zzh;
    }

    public Boolean getScrollGesturesEnabledDuringRotateOrZoom() {
        return this.zzr;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.zzj;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzc;
    }

    public Boolean getZOrderOnTop() {
        return this.zzb;
    }

    public Boolean getZoomControlsEnabled() {
        return this.zzf;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzi;
    }

    @NonNull
    public GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.zzq = latLngBounds;
        return this;
    }

    @NonNull
    public GoogleMapOptions liteMode(boolean z7) {
        this.zzl = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions mapId(@NonNull String str) {
        this.zzt = str;
        return this;
    }

    @NonNull
    public GoogleMapOptions mapToolbarEnabled(boolean z7) {
        this.zzm = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions mapType(int i8) {
        this.zzd = i8;
        return this;
    }

    @NonNull
    public GoogleMapOptions maxZoomPreference(float f8) {
        this.zzp = Float.valueOf(f8);
        return this;
    }

    @NonNull
    public GoogleMapOptions minZoomPreference(float f8) {
        this.zzo = Float.valueOf(f8);
        return this;
    }

    @NonNull
    public GoogleMapOptions rotateGesturesEnabled(boolean z7) {
        this.zzk = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions scrollGesturesEnabled(boolean z7) {
        this.zzh = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions scrollGesturesEnabledDuringRotateOrZoom(boolean z7) {
        this.zzr = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions tiltGesturesEnabled(boolean z7) {
        this.zzj = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add("MapType", Integer.valueOf(this.zzd)).add("LiteMode", this.zzl).add("Camera", this.zze).add("CompassEnabled", this.zzg).add("ZoomControlsEnabled", this.zzf).add("ScrollGesturesEnabled", this.zzh).add("ZoomGesturesEnabled", this.zzi).add("TiltGesturesEnabled", this.zzj).add("RotateGesturesEnabled", this.zzk).add("ScrollGesturesEnabledDuringRotateOrZoom", this.zzr).add("MapToolbarEnabled", this.zzm).add("AmbientEnabled", this.zzn).add("MinZoomPreference", this.zzo).add("MaxZoomPreference", this.zzp).add("BackgroundColor", this.zzs).add("LatLngBoundsForCameraTarget", this.zzq).add("ZOrderOnTop", this.zzb).add("UseViewLifecycleInFragment", this.zzc).toString();
    }

    @NonNull
    public GoogleMapOptions useViewLifecycleInFragment(boolean z7) {
        this.zzc = Boolean.valueOf(z7);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, com.google.android.gms.maps.internal.zza.zza(this.zzb));
        SafeParcelWriter.writeByte(parcel, 3, com.google.android.gms.maps.internal.zza.zza(this.zzc));
        SafeParcelWriter.writeInt(parcel, 4, getMapType());
        SafeParcelWriter.writeParcelable(parcel, 5, getCamera(), i8, false);
        SafeParcelWriter.writeByte(parcel, 6, com.google.android.gms.maps.internal.zza.zza(this.zzf));
        SafeParcelWriter.writeByte(parcel, 7, com.google.android.gms.maps.internal.zza.zza(this.zzg));
        SafeParcelWriter.writeByte(parcel, 8, com.google.android.gms.maps.internal.zza.zza(this.zzh));
        SafeParcelWriter.writeByte(parcel, 9, com.google.android.gms.maps.internal.zza.zza(this.zzi));
        SafeParcelWriter.writeByte(parcel, 10, com.google.android.gms.maps.internal.zza.zza(this.zzj));
        SafeParcelWriter.writeByte(parcel, 11, com.google.android.gms.maps.internal.zza.zza(this.zzk));
        SafeParcelWriter.writeByte(parcel, 12, com.google.android.gms.maps.internal.zza.zza(this.zzl));
        SafeParcelWriter.writeByte(parcel, 14, com.google.android.gms.maps.internal.zza.zza(this.zzm));
        SafeParcelWriter.writeByte(parcel, 15, com.google.android.gms.maps.internal.zza.zza(this.zzn));
        SafeParcelWriter.writeFloatObject(parcel, 16, getMinZoomPreference(), false);
        SafeParcelWriter.writeFloatObject(parcel, 17, getMaxZoomPreference(), false);
        SafeParcelWriter.writeParcelable(parcel, 18, getLatLngBoundsForCameraTarget(), i8, false);
        SafeParcelWriter.writeByte(parcel, 19, com.google.android.gms.maps.internal.zza.zza(this.zzr));
        SafeParcelWriter.writeIntegerObject(parcel, 20, getBackgroundColor(), false);
        SafeParcelWriter.writeString(parcel, 21, getMapId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public GoogleMapOptions zOrderOnTop(boolean z7) {
        this.zzb = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions zoomControlsEnabled(boolean z7) {
        this.zzf = Boolean.valueOf(z7);
        return this;
    }

    @NonNull
    public GoogleMapOptions zoomGesturesEnabled(boolean z7) {
        this.zzi = Boolean.valueOf(z7);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GoogleMapOptions(@SafeParcelable.Param(id = 2) byte b8, @SafeParcelable.Param(id = 3) byte b9, @SafeParcelable.Param(id = 4) int i8, @SafeParcelable.Param(id = 5) CameraPosition cameraPosition, @SafeParcelable.Param(id = 6) byte b10, @SafeParcelable.Param(id = 7) byte b11, @SafeParcelable.Param(id = 8) byte b12, @SafeParcelable.Param(id = 9) byte b13, @SafeParcelable.Param(id = 10) byte b14, @SafeParcelable.Param(id = 11) byte b15, @SafeParcelable.Param(id = 12) byte b16, @SafeParcelable.Param(id = 14) byte b17, @SafeParcelable.Param(id = 15) byte b18, @SafeParcelable.Param(id = 16) Float f8, @SafeParcelable.Param(id = 17) Float f9, @SafeParcelable.Param(id = 18) LatLngBounds latLngBounds, @SafeParcelable.Param(id = 19) byte b19, @SafeParcelable.Param(id = 20) Integer num, @SafeParcelable.Param(id = 21) String str) {
        this.zzd = -1;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzb = com.google.android.gms.maps.internal.zza.zzb(b8);
        this.zzc = com.google.android.gms.maps.internal.zza.zzb(b9);
        this.zzd = i8;
        this.zze = cameraPosition;
        this.zzf = com.google.android.gms.maps.internal.zza.zzb(b10);
        this.zzg = com.google.android.gms.maps.internal.zza.zzb(b11);
        this.zzh = com.google.android.gms.maps.internal.zza.zzb(b12);
        this.zzi = com.google.android.gms.maps.internal.zza.zzb(b13);
        this.zzj = com.google.android.gms.maps.internal.zza.zzb(b14);
        this.zzk = com.google.android.gms.maps.internal.zza.zzb(b15);
        this.zzl = com.google.android.gms.maps.internal.zza.zzb(b16);
        this.zzm = com.google.android.gms.maps.internal.zza.zzb(b17);
        this.zzn = com.google.android.gms.maps.internal.zza.zzb(b18);
        this.zzo = f8;
        this.zzp = f9;
        this.zzq = latLngBounds;
        this.zzr = com.google.android.gms.maps.internal.zza.zzb(b19);
        this.zzs = num;
        this.zzt = str;
    }
}
