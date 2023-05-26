package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public final class Marker {
    private final com.google.android.gms.internal.maps.zzaa zza;

    public Marker(com.google.android.gms.internal.maps.zzaa zzaaVar) {
        this.zza = (com.google.android.gms.internal.maps.zzaa) Preconditions.checkNotNull(zzaaVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Marker)) {
            return false;
        }
        try {
            return this.zza.zzC(((Marker) obj).zza);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getAlpha() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public String getId() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public LatLng getPosition() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getRotation() {
        try {
            return this.zza.zze();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public String getSnippet() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public Object getTag() {
        try {
            return ObjectWrapper.unwrap(this.zza.zzh());
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public String getTitle() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void hideInfoWindow() {
        try {
            this.zza.zzm();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean isDraggable() {
        try {
            return this.zza.zzD();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean isFlat() {
        try {
            return this.zza.zzE();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean isInfoWindowShown() {
        try {
            return this.zza.zzF();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzG();
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

    public void setAlpha(float f8) {
        try {
            this.zza.zzo(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setAnchor(float f8, float f9) {
        try {
            this.zza.zzp(f8, f9);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setDraggable(boolean z7) {
        try {
            this.zza.zzq(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setFlat(boolean z7) {
        try {
            this.zza.zzr(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        try {
            if (bitmapDescriptor == null) {
                this.zza.zzs(null);
                return;
            }
            this.zza.zzs(bitmapDescriptor.zza());
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setInfoWindowAnchor(float f8, float f9) {
        try {
            this.zza.zzt(f8, f9);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setPosition(@NonNull LatLng latLng) {
        if (latLng != null) {
            try {
                this.zza.zzu(latLng);
                return;
            } catch (RemoteException e8) {
                throw new RuntimeRemoteException(e8);
            }
        }
        throw new IllegalArgumentException("latlng cannot be null - a position is required.");
    }

    public void setRotation(float f8) {
        try {
            this.zza.zzv(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setSnippet(String str) {
        try {
            this.zza.zzw(str);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setTag(Object obj) {
        try {
            this.zza.zzx(ObjectWrapper.wrap(obj));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setTitle(String str) {
        try {
            this.zza.zzy(str);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setVisible(boolean z7) {
        try {
            this.zza.zzz(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setZIndex(float f8) {
        try {
            this.zza.zzA(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void showInfoWindow() {
        try {
            this.zza.zzB();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }
}
