package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.location.Geofence;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public class GeofencingEvent {
    private final int zza;
    @Geofence.GeofenceTransition
    private final int zzb;
    private final List<Geofence> zzc;
    private final Location zzd;

    private GeofencingEvent(int i8, @Geofence.GeofenceTransition int i9, List<Geofence> list, Location location) {
        this.zza = i8;
        this.zzb = i9;
        this.zzc = list;
        this.zzd = location;
    }

    @RecentlyNonNull
    public static GeofencingEvent fromIntent(@RecentlyNonNull Intent intent) {
        ArrayList arrayList = null;
        if (intent == null) {
            return null;
        }
        int i8 = -1;
        int intExtra = intent.getIntExtra(Constants.KEY_GMS_ERROR_CODE, -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1) {
            if (intExtra2 != 1 && intExtra2 != 2) {
                if (intExtra2 == 4) {
                    i8 = 4;
                }
            } else {
                i8 = intExtra2;
            }
        }
        ArrayList arrayList2 = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList2 != null) {
            arrayList = new ArrayList(arrayList2.size());
            int size = arrayList2.size();
            for (int i9 = 0; i9 < size; i9++) {
                byte[] bArr = (byte[]) arrayList2.get(i9);
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                obtain.recycle();
                arrayList.add(com.google.android.gms.internal.location.zzbe.CREATOR.createFromParcel(obtain));
            }
        }
        return new GeofencingEvent(intExtra, i8, arrayList, (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    public int getErrorCode() {
        return this.zza;
    }

    @Geofence.GeofenceTransition
    public int getGeofenceTransition() {
        return this.zzb;
    }

    @RecentlyNonNull
    public List<Geofence> getTriggeringGeofences() {
        return this.zzc;
    }

    @RecentlyNonNull
    public Location getTriggeringLocation() {
        return this.zzd;
    }

    public boolean hasError() {
        return this.zza != -1;
    }
}
