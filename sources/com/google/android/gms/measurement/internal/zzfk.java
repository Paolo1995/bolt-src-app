package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zznv;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
final class zzfk implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbr zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzfl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfk(zzfl zzflVar, com.google.android.gms.internal.measurement.zzbr zzbrVar, ServiceConnection serviceConnection) {
        this.zzc = zzflVar;
        this.zza = zzbrVar;
        this.zzb = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Bundle bundle;
        zzfl zzflVar = this.zzc;
        zzfm zzfmVar = zzflVar.zza;
        str = zzflVar.zzb;
        com.google.android.gms.internal.measurement.zzbr zzbrVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzfmVar.zza.zzaz().zzg();
        Bundle bundle2 = new Bundle();
        bundle2.putString("package_name", str);
        try {
            bundle = zzbrVar.zzd(bundle2);
        } catch (Exception e8) {
            zzfmVar.zza.zzay().zzd().zzb("Exception occurred while retrieving the Install Referrer", e8.getMessage());
        }
        if (bundle == null) {
            zzfmVar.zza.zzay().zzd().zza("Install Referrer Service returned a null response");
            bundle = null;
        }
        zzfmVar.zza.zzaz().zzg();
        zzge.zzO();
        if (bundle != null) {
            long j8 = bundle.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j8 == 0) {
                zzfmVar.zza.zzay().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string != null && !string.isEmpty()) {
                    zzfmVar.zza.zzay().zzj().zzb("InstallReferrer API result", string);
                    zzln zzv = zzfmVar.zza.zzv();
                    Uri parse = Uri.parse("?".concat(string));
                    zznv.zzc();
                    boolean zzs = zzfmVar.zza.zzf().zzs(null, zzeh.zzal);
                    zznv.zzc();
                    Bundle zzs2 = zzv.zzs(parse, zzs, zzfmVar.zza.zzf().zzs(null, zzeh.zzao));
                    if (zzs2 == null) {
                        zzfmVar.zza.zzay().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzs2.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j9 = bundle.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j9 == 0) {
                                zzfmVar.zza.zzay().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzs2.putLong("click_timestamp", j9);
                            }
                        }
                        if (j8 == zzfmVar.zza.zzm().zzd.zza()) {
                            zzfmVar.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzfmVar.zza.zzJ()) {
                            zzfmVar.zza.zzm().zzd.zzb(j8);
                            zzfmVar.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzs2.putString("_cis", "referrer API v2");
                            zzfmVar.zza.zzq().zzF("auto", "_cmp", zzs2, str);
                        }
                    }
                } else {
                    zzfmVar.zza.zzay().zzd().zza("No referrer defined in Install Referrer response");
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzfmVar.zza.zzau(), serviceConnection);
    }
}
