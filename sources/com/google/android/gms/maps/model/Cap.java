package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "CapCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class Cap extends AbstractSafeParcelable {
    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getWrappedBitmapDescriptorImplBinder", id = 3, type = "android.os.IBinder")
    private final BitmapDescriptor zzc;
    @SafeParcelable.Field(getter = "getBitmapRefWidth", id = 4)
    private final Float zzd;
    private static final String zza = Cap.class.getSimpleName();
    @NonNull
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(int i8) {
        this(i8, (BitmapDescriptor) null, (Float) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        if (this.zzb == cap.zzb && Objects.equal(this.zzc, cap.zzc) && Objects.equal(this.zzd, cap.zzd)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    @NonNull
    public String toString() {
        int i8 = this.zzb;
        return "[Cap: type=" + i8 + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        BitmapDescriptor bitmapDescriptor = this.zzc;
        if (bitmapDescriptor == null) {
            asBinder = null;
        } else {
            asBinder = bitmapDescriptor.zza().asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, asBinder, false);
        SafeParcelWriter.writeFloatObject(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Cap zza() {
        boolean z7;
        int i8 = this.zzb;
        if (i8 != 0) {
            boolean z8 = true;
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 != 3) {
                        String str = zza;
                        Log.w(str, "Unknown Cap type: " + i8);
                        return this;
                    }
                    if (this.zzc != null) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Preconditions.checkState(z7, "bitmapDescriptor must not be null");
                    if (this.zzd == null) {
                        z8 = false;
                    }
                    Preconditions.checkState(z8, "bitmapRefWidth must not be null");
                    return new CustomCap(this.zzc, this.zzd.floatValue());
                }
                return new RoundCap();
            }
            return new SquareCap();
        }
        return new ButtCap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Cap(@SafeParcelable.Param(id = 2) int i8, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) Float f8) {
        this(i8, iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder)), f8);
    }

    private Cap(int i8, BitmapDescriptor bitmapDescriptor, Float f8) {
        boolean z7;
        boolean z8 = f8 != null && f8.floatValue() > 0.0f;
        if (i8 == 3) {
            if (bitmapDescriptor == null || !z8) {
                i8 = 3;
                z7 = false;
                Preconditions.checkArgument(z7, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i8), bitmapDescriptor, f8));
                this.zzb = i8;
                this.zzc = bitmapDescriptor;
                this.zzd = f8;
            }
            i8 = 3;
        }
        z7 = true;
        Preconditions.checkArgument(z7, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i8), bitmapDescriptor, f8));
        this.zzb = i8;
        this.zzc = bitmapDescriptor;
        this.zzd = f8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Cap(@NonNull BitmapDescriptor bitmapDescriptor, float f8) {
        this(3, bitmapDescriptor, Float.valueOf(f8));
    }
}
