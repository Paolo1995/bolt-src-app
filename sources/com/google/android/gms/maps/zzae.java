package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@VisibleForTesting
/* loaded from: classes.dex */
final class zzae extends DeferredLifecycleHelper {
    protected OnDelegateCreatedListener zza;
    private final Fragment zzb;
    private Activity zzc;
    private final List zzd = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzae(Fragment fragment) {
        this.zzb = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzae zzaeVar, Activity activity) {
        zzaeVar.zzc = activity;
        zzaeVar.zzc();
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void createDelegate(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.zza = onDelegateCreatedListener;
        zzc();
    }

    public final void zzb(OnMapReadyCallback onMapReadyCallback) {
        if (getDelegate() != null) {
            ((zzad) getDelegate()).getMapAsync(onMapReadyCallback);
        } else {
            this.zzd.add(onMapReadyCallback);
        }
    }

    public final void zzc() {
        if (this.zzc != null && this.zza != null && getDelegate() == null) {
            try {
                MapsInitializer.initialize(this.zzc);
                IMapFragmentDelegate zzf = zzcb.zza(this.zzc, null).zzf(ObjectWrapper.wrap(this.zzc));
                if (zzf == null) {
                    return;
                }
                this.zza.onDelegateCreated(new zzad(this.zzb, zzf));
                for (OnMapReadyCallback onMapReadyCallback : this.zzd) {
                    ((zzad) getDelegate()).getMapAsync(onMapReadyCallback);
                }
                this.zzd.clear();
            } catch (RemoteException e8) {
                throw new RuntimeRemoteException(e8);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }
}
