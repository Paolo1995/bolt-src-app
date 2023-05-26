package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "StrokeStyleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class StrokeStyle extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<StrokeStyle> CREATOR = new zzv();
    @SafeParcelable.Field(getter = "getWidth", id = 2)
    private final float zza;
    @SafeParcelable.Field(getter = "getColor", id = 3)
    private final int zzb;
    @SafeParcelable.Field(getter = "getToColor", id = 4)
    private final int zzc;
    @SafeParcelable.Field(getter = "isVisible", id = 5)
    private final boolean zzd;
    @SafeParcelable.Field(getter = "getStamp", id = 6)
    private final StampStyle zze;

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private float zza;
        private int zzb;
        private int zzc;
        private boolean zzd;
        private StampStyle zze;

        private Builder() {
        }

        public Builder(@NonNull StrokeStyle strokeStyle) {
            this.zza = strokeStyle.zza();
            Pair zzb = strokeStyle.zzb();
            this.zzb = ((Integer) zzb.first).intValue();
            this.zzc = ((Integer) zzb.second).intValue();
            this.zzd = strokeStyle.isVisible();
            this.zze = strokeStyle.getStamp();
        }

        /* synthetic */ Builder(zzu zzuVar) {
        }

        @NonNull
        public StrokeStyle build() {
            return new StrokeStyle(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        @NonNull
        public Builder stamp(@NonNull StampStyle stampStyle) {
            this.zze = stampStyle;
            return this;
        }

        @NonNull
        public final Builder zza(int i8) {
            this.zzb = i8;
            this.zzc = i8;
            return this;
        }

        @NonNull
        public final Builder zzb(int i8, int i9) {
            this.zzb = i8;
            this.zzc = i9;
            return this;
        }

        @NonNull
        public final Builder zzc(boolean z7) {
            this.zzd = z7;
            return this;
        }

        @NonNull
        public final Builder zzd(float f8) {
            this.zza = f8;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public StrokeStyle(@SafeParcelable.Param(id = 2) float f8, @SafeParcelable.Param(id = 3) int i8, @SafeParcelable.Param(id = 4) int i9, @SafeParcelable.Param(id = 5) boolean z7, @SafeParcelable.Param(id = 6) StampStyle stampStyle) {
        this.zza = f8;
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = z7;
        this.zze = stampStyle;
    }

    @NonNull
    public static Builder colorBuilder(int i8) {
        Builder builder = new Builder((zzu) null);
        builder.zza(i8);
        return builder;
    }

    @NonNull
    public static Builder gradientBuilder(int i8, int i9) {
        Builder builder = new Builder((zzu) null);
        builder.zzb(i8, i9);
        return builder;
    }

    @NonNull
    public static Builder transparentColorBuilder() {
        Builder builder = new Builder((zzu) null);
        builder.zza(0);
        return builder;
    }

    public StampStyle getStamp() {
        return this.zze;
    }

    public boolean isVisible() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.zza);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, isVisible());
        SafeParcelWriter.writeParcelable(parcel, 6, getStamp(), i8, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final float zza() {
        return this.zza;
    }

    @NonNull
    public final Pair zzb() {
        return new Pair(Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }
}
