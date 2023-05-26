package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "MapStyleOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {
    @SafeParcelable.Field(getter = "getJson", id = 2)
    private String zzb;
    private static final String zza = MapStyleOptions.class.getSimpleName();
    @NonNull
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzh();

    @SafeParcelable.Constructor
    public MapStyleOptions(@NonNull @SafeParcelable.Param(id = 2) String str) {
        Preconditions.checkNotNull(str, "json must not be null");
        this.zzb = str;
    }

    @NonNull
    public static MapStyleOptions loadRawResourceStyle(@NonNull Context context, int i8) throws Resources.NotFoundException {
        try {
            return new MapStyleOptions(new String(IOUtils.readInputStreamFully(context.getResources().openRawResource(i8)), "UTF-8"));
        } catch (IOException e8) {
            String obj = e8.toString();
            throw new Resources.NotFoundException("Failed to read resource " + i8 + ": " + obj);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
