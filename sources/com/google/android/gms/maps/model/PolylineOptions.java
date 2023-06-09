package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.StrokeStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "PolylineOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class PolylineOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getPoints", id = 2)
    private final List zza;
    @SafeParcelable.Field(getter = "getWidth", id = 3)
    private float zzb;
    @SafeParcelable.Field(getter = "getColor", id = 4)
    private int zzc;
    @SafeParcelable.Field(getter = "getZIndex", id = 5)
    private float zzd;
    @SafeParcelable.Field(getter = "isVisible", id = 6)
    private boolean zze;
    @SafeParcelable.Field(getter = "isGeodesic", id = 7)
    private boolean zzf;
    @SafeParcelable.Field(getter = "isClickable", id = 8)
    private boolean zzg;
    @SafeParcelable.Field(getter = "getStartCap", id = 9)
    private Cap zzh;
    @SafeParcelable.Field(getter = "getEndCap", id = 10)
    private Cap zzi;
    @SafeParcelable.Field(getter = "getJointType", id = 11)
    private int zzj;
    @SafeParcelable.Field(getter = "getPattern", id = 12)
    private List zzk;
    @SafeParcelable.Field(getter = "getSpans", id = 13)
    private List zzl;

    public PolylineOptions() {
        this.zzb = 10.0f;
        this.zzc = -16777216;
        this.zzd = 0.0f;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = new ArrayList();
    }

    @NonNull
    public PolylineOptions add(@NonNull LatLng latLng) {
        Preconditions.checkNotNull(this.zza, "point must not be null.");
        this.zza.add(latLng);
        return this;
    }

    @NonNull
    public PolylineOptions addAll(@NonNull Iterable<LatLng> iterable) {
        Preconditions.checkNotNull(iterable, "points must not be null.");
        for (LatLng latLng : iterable) {
            this.zza.add(latLng);
        }
        return this;
    }

    @NonNull
    public PolylineOptions addAllSpans(@NonNull Iterable<StyleSpan> iterable) {
        for (StyleSpan styleSpan : iterable) {
            addSpan(styleSpan);
        }
        return this;
    }

    @NonNull
    public PolylineOptions addSpan(@NonNull StyleSpan styleSpan) {
        this.zzl.add(styleSpan);
        return this;
    }

    @NonNull
    public PolylineOptions clickable(boolean z7) {
        this.zzg = z7;
        return this;
    }

    @NonNull
    public PolylineOptions color(int i8) {
        this.zzc = i8;
        return this;
    }

    @NonNull
    public PolylineOptions endCap(@NonNull Cap cap) {
        this.zzi = (Cap) Preconditions.checkNotNull(cap, "endCap must not be null");
        return this;
    }

    @NonNull
    public PolylineOptions geodesic(boolean z7) {
        this.zzf = z7;
        return this;
    }

    public int getColor() {
        return this.zzc;
    }

    @NonNull
    public Cap getEndCap() {
        return this.zzi.zza();
    }

    public int getJointType() {
        return this.zzj;
    }

    public List<PatternItem> getPattern() {
        return this.zzk;
    }

    @NonNull
    public List<LatLng> getPoints() {
        return this.zza;
    }

    @NonNull
    public Cap getStartCap() {
        return this.zzh.zza();
    }

    public float getWidth() {
        return this.zzb;
    }

    public float getZIndex() {
        return this.zzd;
    }

    public boolean isClickable() {
        return this.zzg;
    }

    public boolean isGeodesic() {
        return this.zzf;
    }

    public boolean isVisible() {
        return this.zze;
    }

    @NonNull
    public PolylineOptions jointType(int i8) {
        this.zzj = i8;
        return this;
    }

    @NonNull
    public PolylineOptions pattern(List<PatternItem> list) {
        this.zzk = list;
        return this;
    }

    @NonNull
    public PolylineOptions startCap(@NonNull Cap cap) {
        this.zzh = (Cap) Preconditions.checkNotNull(cap, "startCap must not be null");
        return this;
    }

    @NonNull
    public PolylineOptions visible(boolean z7) {
        this.zze = z7;
        return this;
    }

    @NonNull
    public PolylineOptions width(float f8) {
        this.zzb = f8;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getPoints(), false);
        SafeParcelWriter.writeFloat(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getColor());
        SafeParcelWriter.writeFloat(parcel, 5, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 6, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 7, isGeodesic());
        SafeParcelWriter.writeBoolean(parcel, 8, isClickable());
        SafeParcelWriter.writeParcelable(parcel, 9, getStartCap(), i8, false);
        SafeParcelWriter.writeParcelable(parcel, 10, getEndCap(), i8, false);
        SafeParcelWriter.writeInt(parcel, 11, getJointType());
        SafeParcelWriter.writeTypedList(parcel, 12, getPattern(), false);
        ArrayList arrayList = new ArrayList(this.zzl.size());
        for (StyleSpan styleSpan : this.zzl) {
            StrokeStyle.Builder builder = new StrokeStyle.Builder(styleSpan.getStyle());
            builder.zzd(this.zzb);
            builder.zzc(this.zze);
            arrayList.add(new StyleSpan(builder.build(), styleSpan.getSegments()));
        }
        SafeParcelWriter.writeTypedList(parcel, 13, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public PolylineOptions zIndex(float f8) {
        this.zzd = f8;
        return this;
    }

    @NonNull
    public PolylineOptions addSpan(@NonNull StyleSpan... styleSpanArr) {
        for (StyleSpan styleSpan : styleSpanArr) {
            addSpan(styleSpan);
        }
        return this;
    }

    @NonNull
    public PolylineOptions add(@NonNull LatLng... latLngArr) {
        Preconditions.checkNotNull(latLngArr, "points must not be null.");
        Collections.addAll(this.zza, latLngArr);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PolylineOptions(@SafeParcelable.Param(id = 2) List list, @SafeParcelable.Param(id = 3) float f8, @SafeParcelable.Param(id = 4) int i8, @SafeParcelable.Param(id = 5) float f9, @SafeParcelable.Param(id = 6) boolean z7, @SafeParcelable.Param(id = 7) boolean z8, @SafeParcelable.Param(id = 8) boolean z9, @SafeParcelable.Param(id = 9) Cap cap, @SafeParcelable.Param(id = 10) Cap cap2, @SafeParcelable.Param(id = 11) int i9, @SafeParcelable.Param(id = 12) List list2, @SafeParcelable.Param(id = 13) List list3) {
        this.zzb = 10.0f;
        this.zzc = -16777216;
        this.zzd = 0.0f;
        this.zze = true;
        this.zzf = false;
        this.zzg = false;
        this.zzh = new ButtCap();
        this.zzi = new ButtCap();
        this.zzj = 0;
        this.zzk = null;
        this.zzl = new ArrayList();
        this.zza = list;
        this.zzb = f8;
        this.zzc = i8;
        this.zzd = f9;
        this.zze = z7;
        this.zzf = z8;
        this.zzg = z9;
        if (cap != null) {
            this.zzh = cap;
        }
        if (cap2 != null) {
            this.zzi = cap2;
        }
        this.zzj = i9;
        this.zzk = list2;
        if (list3 != null) {
            this.zzl = list3;
        }
    }
}
