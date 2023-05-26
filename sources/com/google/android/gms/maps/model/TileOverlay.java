package com.google.android.gms.maps.model;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzaj;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public final class TileOverlay {
    private final zzaj zza;

    public TileOverlay(zzaj zzajVar) {
        this.zza = (zzaj) Preconditions.checkNotNull(zzajVar);
    }

    public void clearTileCache() {
        try {
            this.zza.zzh();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.zza.zzn(((TileOverlay) obj).zza);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean getFadeIn() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public String getId() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getTransparency() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public float getZIndex() {
        try {
            return this.zza.zze();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public int hashCode() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean isVisible() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void remove() {
        try {
            this.zza.zzi();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setFadeIn(boolean z7) {
        try {
            this.zza.zzj(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setTransparency(float f8) {
        try {
            this.zza.zzk(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setVisible(boolean z7) {
        try {
            this.zza.zzl(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setZIndex(float f8) {
        try {
            this.zza.zzm(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }
}
