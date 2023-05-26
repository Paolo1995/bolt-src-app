package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public final class GroundOverlay {
    private final com.google.android.gms.internal.maps.zzo zza;

    public GroundOverlay(com.google.android.gms.internal.maps.zzo zzoVar) {
        this.zza = (com.google.android.gms.internal.maps.zzo) Preconditions.checkNotNull(zzoVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.zza.zzz(((GroundOverlay) obj).zza);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getBearing() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public LatLngBounds getBounds() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getHeight() {
        try {
            return this.zza.zze();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public String getId() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public LatLng getPosition() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zza.zzj());
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getTransparency() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getWidth() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean isClickable() {
        try {
            return this.zza.zzA();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzB();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void remove() {
        try {
            this.zza.zzn();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setBearing(float f8) {
        try {
            this.zza.zzo(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setClickable(boolean z7) {
        try {
            this.zza.zzp(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setDimensions(float f8) {
        try {
            this.zza.zzq(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setImage(@NonNull BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        try {
            this.zza.zzs(bitmapDescriptor.zza());
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setPosition(@NonNull LatLng latLng) {
        try {
            this.zza.zzt(latLng);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setPositionFromBounds(@NonNull LatLngBounds latLngBounds) {
        try {
            this.zza.zzu(latLngBounds);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setTag(Object obj) {
        try {
            this.zza.zzv(ObjectWrapper.wrap(obj));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setTransparency(float f8) {
        try {
            this.zza.zzw(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setVisible(boolean z7) {
        try {
            this.zza.zzx(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setZIndex(float f8) {
        try {
            this.zza.zzy(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setDimensions(float f8, float f9) {
        try {
            this.zza.zzr(f8, f9);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }
}
