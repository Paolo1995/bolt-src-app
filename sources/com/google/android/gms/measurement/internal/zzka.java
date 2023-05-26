package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* loaded from: classes.dex */
public final class zzka extends zzkt {
    public final zzff zza;
    public final zzff zzb;
    public final zzff zzc;
    public final zzff zzd;
    public final zzff zze;
    private final Map zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzka(zzlf zzlfVar) {
        super(zzlfVar);
        this.zzg = new HashMap();
        zzfj zzm = this.zzs.zzm();
        zzm.getClass();
        this.zza = new zzff(zzm, "last_delete_stale", 0L);
        zzfj zzm2 = this.zzs.zzm();
        zzm2.getClass();
        this.zzb = new zzff(zzm2, "backoff", 0L);
        zzfj zzm3 = this.zzs.zzm();
        zzm3.getClass();
        this.zzc = new zzff(zzm3, "last_upload", 0L);
        zzfj zzm4 = this.zzs.zzm();
        zzm4.getClass();
        this.zzd = new zzff(zzm4, "last_upload_attempt", 0L);
        zzfj zzm5 = this.zzs.zzm();
        zzm5.getClass();
        this.zze = new zzff(zzm5, "midnight_offset", 0L);
    }

    @Deprecated
    final Pair zza(String str) {
        zzjz zzjzVar;
        AdvertisingIdClient.Info advertisingIdInfo;
        zzg();
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        zzjz zzjzVar2 = (zzjz) this.zzg.get(str);
        if (zzjzVar2 != null && elapsedRealtime < zzjzVar2.zzc) {
            return new Pair(zzjzVar2.zza, Boolean.valueOf(zzjzVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzi = elapsedRealtime + this.zzs.zzf().zzi(str, zzeh.zza);
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzau());
        } catch (Exception e8) {
            this.zzs.zzay().zzc().zzb("Unable to get advertising id", e8);
            zzjzVar = new zzjz("", false, zzi);
        }
        if (advertisingIdInfo == null) {
            return new Pair("", Boolean.FALSE);
        }
        String id = advertisingIdInfo.getId();
        if (id != null) {
            zzjzVar = new zzjz(id, advertisingIdInfo.isLimitAdTrackingEnabled(), zzi);
        } else {
            zzjzVar = new zzjz("", advertisingIdInfo.isLimitAdTrackingEnabled(), zzi);
        }
        this.zzg.put(str, zzjzVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(zzjzVar.zza, Boolean.valueOf(zzjzVar.zzb));
    }

    @Override // com.google.android.gms.measurement.internal.zzkt
    protected final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair zzd(String str, zzai zzaiVar) {
        if (zzaiVar.zzi(zzah.AD_STORAGE)) {
            return zza(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final String zzf(String str, boolean z7) {
        String str2;
        zzg();
        if (this.zzs.zzf().zzs(null, zzeh.zzaj) && !z7) {
            str2 = "00000000-0000-0000-0000-000000000000";
        } else {
            str2 = (String) zza(str).first;
        }
        MessageDigest zzF = zzln.zzF();
        if (zzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzF.digest(str2.getBytes())));
    }
}
