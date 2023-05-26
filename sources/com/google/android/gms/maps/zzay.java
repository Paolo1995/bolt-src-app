package com.google.android.gms.maps;

import android.app.Activity;
import android.os.RemoteException;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@VisibleForTesting
/* loaded from: classes.dex */
final class zzay extends DeferredLifecycleHelper {
    protected OnDelegateCreatedListener zza;
    private final Fragment zzb;
    private Activity zzc;
    private final List zzd = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzay(Fragment fragment) {
        this.zzb = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzay zzayVar, Activity activity) {
        zzayVar.zzc = activity;
        zzayVar.zzc();
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    protected final void createDelegate(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.zza = onDelegateCreatedListener;
        zzc();
    }

    public final void zzb(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        if (getDelegate() != null) {
            ((zzax) getDelegate()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
        } else {
            this.zzd.add(onStreetViewPanoramaReadyCallback);
        }
    }

    public final void zzc() {
        if (this.zzc != null && this.zza != null && getDelegate() == null) {
            try {
                MapsInitializer.initialize(this.zzc);
                this.zza.onDelegateCreated(new zzax(this.zzb, zzcb.zza(this.zzc, null).zzh(ObjectWrapper.wrap(this.zzc))));
                for (OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback : this.zzd) {
                    ((zzax) getDelegate()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
                }
                this.zzd.clear();
            } catch (RemoteException e8) {
                throw new RuntimeRemoteException(e8);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }
}
