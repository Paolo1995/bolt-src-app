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
@SafeParcelable.Class(creator = "StampStyleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class StampStyle extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<StampStyle> CREATOR = new zzo();
    @NonNull
    @SafeParcelable.Field(getter = "getWrappedStampBinder", id = 2, type = "android.os.IBinder")
    protected final BitmapDescriptor zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        BitmapDescriptor zza;

        protected abstract T self();

        public T stamp(BitmapDescriptor bitmapDescriptor) {
            this.zza = bitmapDescriptor;
            return self();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public StampStyle(@SafeParcelable.Param(id = 2) IBinder iBinder) {
        this.zza = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(iBinder));
    }

    @NonNull
    public BitmapDescriptor getStamp() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.zza().asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StampStyle(@NonNull BitmapDescriptor bitmapDescriptor) {
        this.zza = bitmapDescriptor;
    }
}
