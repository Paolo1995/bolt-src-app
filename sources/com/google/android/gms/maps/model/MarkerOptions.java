package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "MarkerOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class MarkerOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzi();
    @SafeParcelable.Field(getter = "getPosition", id = 2)
    private LatLng zza;
    @SafeParcelable.Field(getter = "getTitle", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getSnippet", id = 4)
    private String zzc;
    @SafeParcelable.Field(getter = "getWrappedIconDescriptorImplBinder", id = 5, type = "android.os.IBinder")
    private BitmapDescriptor zzd;
    @SafeParcelable.Field(getter = "getAnchorU", id = 6)
    private float zze;
    @SafeParcelable.Field(getter = "getAnchorV", id = 7)
    private float zzf;
    @SafeParcelable.Field(getter = "isDraggable", id = 8)
    private boolean zzg;
    @SafeParcelable.Field(getter = "isVisible", id = 9)
    private boolean zzh;
    @SafeParcelable.Field(getter = "isFlat", id = 10)
    private boolean zzi;
    @SafeParcelable.Field(getter = "getRotation", id = 11)
    private float zzj;
    @SafeParcelable.Field(defaultValue = "0.5f", getter = "getInfoWindowAnchorU", id = 12)
    private float zzk;
    @SafeParcelable.Field(getter = "getInfoWindowAnchorV", id = 13)
    private float zzl;
    @SafeParcelable.Field(defaultValue = "1.0f", getter = "getAlpha", id = 14)
    private float zzm;
    @SafeParcelable.Field(getter = "getZIndex", id = 15)
    private float zzn;

    public MarkerOptions() {
        this.zze = 0.5f;
        this.zzf = 1.0f;
        this.zzh = true;
        this.zzi = false;
        this.zzj = 0.0f;
        this.zzk = 0.5f;
        this.zzl = 0.0f;
        this.zzm = 1.0f;
    }

    @NonNull
    public MarkerOptions alpha(float f8) {
        this.zzm = f8;
        return this;
    }

    @NonNull
    public MarkerOptions anchor(float f8, float f9) {
        this.zze = f8;
        this.zzf = f9;
        return this;
    }

    @NonNull
    public MarkerOptions draggable(boolean z7) {
        this.zzg = z7;
        return this;
    }

    @NonNull
    public MarkerOptions flat(boolean z7) {
        this.zzi = z7;
        return this;
    }

    public float getAlpha() {
        return this.zzm;
    }

    public float getAnchorU() {
        return this.zze;
    }

    public float getAnchorV() {
        return this.zzf;
    }

    public BitmapDescriptor getIcon() {
        return this.zzd;
    }

    public float getInfoWindowAnchorU() {
        return this.zzk;
    }

    public float getInfoWindowAnchorV() {
        return this.zzl;
    }

    @NonNull
    public LatLng getPosition() {
        return this.zza;
    }

    public float getRotation() {
        return this.zzj;
    }

    public String getSnippet() {
        return this.zzc;
    }

    public String getTitle() {
        return this.zzb;
    }

    public float getZIndex() {
        return this.zzn;
    }

    @NonNull
    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.zzd = bitmapDescriptor;
        return this;
    }

    @NonNull
    public MarkerOptions infoWindowAnchor(float f8, float f9) {
        this.zzk = f8;
        this.zzl = f9;
        return this;
    }

    public boolean isDraggable() {
        return this.zzg;
    }

    public boolean isFlat() {
        return this.zzi;
    }

    public boolean isVisible() {
        return this.zzh;
    }

    @NonNull
    public MarkerOptions position(@NonNull LatLng latLng) {
        if (latLng != null) {
            this.zza = latLng;
            return this;
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    @NonNull
    public MarkerOptions rotation(float f8) {
        this.zzj = f8;
        return this;
    }

    @NonNull
    public MarkerOptions snippet(String str) {
        this.zzc = str;
        return this;
    }

    @NonNull
    public MarkerOptions title(String str) {
        this.zzb = str;
        return this;
    }

    @NonNull
    public MarkerOptions visible(boolean z7) {
        this.zzh = z7;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getPosition(), i8, false);
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeString(parcel, 4, getSnippet(), false);
        BitmapDescriptor bitmapDescriptor = this.zzd;
        if (bitmapDescriptor == null) {
            asBinder = null;
        } else {
            asBinder = bitmapDescriptor.zza().asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, asBinder, false);
        SafeParcelWriter.writeFloat(parcel, 6, getAnchorU());
        SafeParcelWriter.writeFloat(parcel, 7, getAnchorV());
        SafeParcelWriter.writeBoolean(parcel, 8, isDraggable());
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 10, isFlat());
        SafeParcelWriter.writeFloat(parcel, 11, getRotation());
        SafeParcelWriter.writeFloat(parcel, 12, getInfoWindowAnchorU());
        SafeParcelWriter.writeFloat(parcel, 13, getInfoWindowAnchorV());
        SafeParcelWriter.writeFloat(parcel, 14, getAlpha());
        SafeParcelWriter.writeFloat(parcel, 15, getZIndex());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public MarkerOptions zIndex(float f8) {
        this.zzn = f8;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public MarkerOptions(@SafeParcelable.Param(id = 2) LatLng latLng, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) float f8, @SafeParcelable.Param(id = 7) float f9, @SafeParcelable.Param(id = 8) boolean z7, @SafeParcelable.Param(id = 9) boolean z8, @SafeParcelable.Param(id = 10) boolean z9, @SafeParcelable.Param(id = 11) float f10, @SafeParcelable.Param(id = 12) float f11, @SafeParcelable.Param(id = 13) float f12, @SafeParcelable.Param(id = 14) float f13, @SafeParcelable.Param(id = 15) float f14) {
        this.zze = 0.5f;
        this.zzf = 1.0f;
        this.zzh = true;
        this.zzi = false;
        this.zzj = 0.0f;
        this.zzk = 0.5f;
        this.zzl = 0.0f;
        this.zzm = 1.0f;
        this.zza = latLng;
        this.zzb = str;
        this.zzc = str2;
        if (iBinder == null) {
            this.zzd = null;
        } else {
            this.zzd = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
        }
        this.zze = f8;
        this.zzf = f9;
        this.zzg = z7;
        this.zzh = z8;
        this.zzi = z9;
        this.zzj = f10;
        this.zzk = f11;
        this.zzl = f12;
        this.zzm = f13;
        this.zzn = f14;
    }
}
