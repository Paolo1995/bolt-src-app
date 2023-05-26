package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzag extends zzgx {
    private Boolean zza;
    private zzaf zzb;
    private Boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(zzge zzgeVar) {
        super(zzgeVar);
        this.zzb = new zzaf() { // from class: com.google.android.gms.measurement.internal.zzae
            @Override // com.google.android.gms.measurement.internal.zzaf
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    public static final long zzA() {
        return ((Long) zzeh.zzC.zza(null)).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e8) {
            this.zzs.zzay().zzd().zzb("Could not find SystemProperties class", e8);
            return "";
        } catch (IllegalAccessException e9) {
            this.zzs.zzay().zzd().zzb("Could not access SystemProperties.get()", e9);
            return "";
        } catch (NoSuchMethodException e10) {
            this.zzs.zzay().zzd().zzb("Could not find SystemProperties.get() method", e10);
            return "";
        } catch (InvocationTargetException e11) {
            this.zzs.zzay().zzd().zzb("SystemProperties.get() threw an exception", e11);
            return "";
        }
    }

    public static final long zzz() {
        return ((Long) zzeh.zzc.zza(null)).longValue();
    }

    public final double zza(String str, zzeg zzegVar) {
        if (str == null) {
            return ((Double) zzegVar.zza(null)).doubleValue();
        }
        String zza = this.zzb.zza(str, zzegVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzegVar.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzegVar.zza(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzegVar.zza(null)).doubleValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(String str) {
        return zzf(str, zzeh.zzG, CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }

    public final int zzc() {
        zzln zzv = this.zzs.zzv();
        Boolean zzj = zzv.zzs.zzt().zzj();
        if (zzv.zzm() < 201500) {
            if (zzj == null || zzj.booleanValue()) {
                return 25;
            }
            return 100;
        }
        return 100;
    }

    public final int zzd(String str) {
        return zzf(str, zzeh.zzH, 25, 100);
    }

    public final int zze(String str, zzeg zzegVar) {
        if (str == null) {
            return ((Integer) zzegVar.zza(null)).intValue();
        }
        String zza = this.zzb.zza(str, zzegVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzegVar.zza(null)).intValue();
        }
        try {
            return ((Integer) zzegVar.zza(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzegVar.zza(null)).intValue();
        }
    }

    public final int zzf(String str, zzeg zzegVar, int i8, int i9) {
        return Math.max(Math.min(zze(str, zzegVar), i9), i8);
    }

    public final long zzh() {
        this.zzs.zzaw();
        return 68000L;
    }

    public final long zzi(String str, zzeg zzegVar) {
        if (str == null) {
            return ((Long) zzegVar.zza(null)).longValue();
        }
        String zza = this.zzb.zza(str, zzegVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzegVar.zza(null)).longValue();
        }
        try {
            return ((Long) zzegVar.zza(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzegVar.zza(null)).longValue();
        }
    }

    @VisibleForTesting
    final Bundle zzj() {
        try {
            if (this.zzs.zzau().getPackageManager() == null) {
                this.zzs.zzay().zzd().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzs.zzau()).getApplicationInfo(this.zzs.zzau().getPackageName(), 128);
            if (applicationInfo == null) {
                this.zzs.zzay().zzd().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e8) {
            this.zzs.zzay().zzd().zzb("Failed to load metadata: Package name not found", e8);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean zzk(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzj = zzj();
        if (zzj == null) {
            this.zzs.zzay().zzd().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzj.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzj.getBoolean(str));
        }
    }

    public final String zzl() {
        return zzB("debug.firebase.analytics.app", "");
    }

    public final String zzm() {
        return zzB("debug.deferred.deeplink", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzn() {
        this.zzs.zzaw();
        return "FA";
    }

    public final String zzo(String str, zzeg zzegVar) {
        if (str == null) {
            return (String) zzegVar.zza(null);
        }
        return (String) zzegVar.zza(this.zzb.zza(str, zzegVar.zzb()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzp(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzj()
            r1 = 0
            if (r0 != 0) goto L1d
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzs     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.zzau()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzd()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzag.zzp(java.lang.String):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzq(zzaf zzafVar) {
        this.zzb = zzafVar;
    }

    public final boolean zzr() {
        Boolean zzk = zzk("google_analytics_adid_collection_enabled");
        if (zzk != null && !zzk.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzs(String str, zzeg zzegVar) {
        if (str == null) {
            return ((Boolean) zzegVar.zza(null)).booleanValue();
        }
        String zza = this.zzb.zza(str, zzegVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzegVar.zza(null)).booleanValue();
        }
        return ((Boolean) zzegVar.zza(Boolean.valueOf("1".equals(zza)))).booleanValue();
    }

    public final boolean zzt(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean zzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        if (zzk != null && !zzk.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzv() {
        this.zzs.zzaw();
        Boolean zzk = zzk("firebase_analytics_collection_deactivated");
        if (zzk != null && zzk.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzx() {
        if (this.zza == null) {
            Boolean zzk = zzk("app_measurement_lite");
            this.zza = zzk;
            if (zzk == null) {
                this.zza = Boolean.FALSE;
            }
        }
        if (!this.zza.booleanValue() && this.zzs.zzN()) {
            return false;
        }
        return true;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = this.zzs.zzau().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z7 = false;
                        if (str != null && str.equals(myProcessName)) {
                            z7 = true;
                        }
                        this.zzc = Boolean.valueOf(z7);
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        this.zzs.zzay().zzd().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }
}
