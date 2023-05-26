package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzfj extends zzgy {
    @VisibleForTesting
    static final Pair zza = new Pair("", 0L);
    public zzfh zzb;
    public final zzff zzc;
    public final zzff zzd;
    public final zzfi zze;
    public final zzff zzf;
    public final zzfd zzg;
    public final zzfi zzh;
    public final zzfd zzi;
    public final zzff zzj;
    public boolean zzk;
    public final zzfd zzl;
    public final zzfd zzm;
    public final zzff zzn;
    public final zzfi zzo;
    public final zzfi zzp;
    public final zzff zzq;
    public final zzfe zzr;
    private SharedPreferences zzt;
    private String zzu;
    private boolean zzv;
    private long zzw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfj(zzge zzgeVar) {
        super(zzgeVar);
        this.zzf = new zzff(this, "session_timeout", 1800000L);
        this.zzg = new zzfd(this, "start_new_session", true);
        this.zzj = new zzff(this, "last_pause_time", 0L);
        this.zzh = new zzfi(this, "non_personalized_ads", null);
        this.zzi = new zzfd(this, "allow_remote_dynamite", false);
        this.zzc = new zzff(this, "first_open_time", 0L);
        this.zzd = new zzff(this, "app_install_time", 0L);
        this.zze = new zzfi(this, "app_instance_id", null);
        this.zzl = new zzfd(this, "app_backgrounded", false);
        this.zzm = new zzfd(this, "deep_link_retrieval_complete", false);
        this.zzn = new zzff(this, "deep_link_retrieval_attempts", 0L);
        this.zzo = new zzfi(this, "firebase_feature_rollouts", null);
        this.zzp = new zzfi(this, "deferred_attribution_cache", null);
        this.zzq = new zzff(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzr = new zzfe(this, "default_event_parameters", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final SharedPreferences zza() {
        zzg();
        zzu();
        Preconditions.checkNotNull(this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    protected final void zzaA() {
        SharedPreferences sharedPreferences = this.zzs.zzau().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzt = sharedPreferences;
        boolean z7 = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzk = z7;
        if (!z7) {
            SharedPreferences.Editor edit = this.zzt.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzs.zzf();
        this.zzb = new zzfh(this, "health_monitor", Math.max(0L, ((Long) zzeh.zzb.zza(null)).longValue()), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair zzb(String str) {
        zzg();
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        String str2 = this.zzu;
        if (str2 != null && elapsedRealtime < this.zzw) {
            return new Pair(str2, Boolean.valueOf(this.zzv));
        }
        this.zzw = elapsedRealtime + this.zzs.zzf().zzi(str, zzeh.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzau());
            this.zzu = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzu = id;
            }
            this.zzv = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e8) {
            this.zzs.zzay().zzc().zzb("Unable to get advertising id", e8);
            this.zzu = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.zzu, Boolean.valueOf(this.zzv));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzai zzc() {
        zzg();
        return zzai.zzb(zza().getString("consent_settings", "G1"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzd() {
        zzg();
        if (zza().contains("measurement_enabled")) {
            return Boolean.valueOf(zza().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    protected final boolean zzf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zza().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(boolean z7) {
        zzg();
        this.zzs.zzay().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z7));
        SharedPreferences.Editor edit = zza().edit();
        edit.putBoolean("deferred_analytics_collection", z7);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj() {
        SharedPreferences sharedPreferences = this.zzt;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(long j8) {
        if (j8 - this.zzf.zza() > this.zzj.zza()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(int i8) {
        return zzai.zzj(i8, zza().getInt("consent_source", 100));
    }
}
