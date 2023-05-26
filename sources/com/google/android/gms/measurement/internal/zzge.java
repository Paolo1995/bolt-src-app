package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzob;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzge implements zzgz {
    private static volatile zzge zzd;
    private zzel zzA;
    private Boolean zzC;
    private long zzD;
    private volatile Boolean zzE;
    private volatile boolean zzF;
    private int zzG;
    @VisibleForTesting
    protected Boolean zza;
    @VisibleForTesting
    protected Boolean zzb;
    @VisibleForTesting
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzab zzj;
    private final zzag zzk;
    private final zzfj zzl;
    private final zzeu zzm;
    private final zzgb zzn;
    private final zzko zzo;
    private final zzln zzp;
    private final zzep zzq;
    private final Clock zzr;
    private final zziy zzs;
    private final zzij zzt;
    private final zzd zzu;
    private final zzin zzv;
    private final String zzw;
    private zzen zzx;
    private zzjy zzy;
    private zzaq zzz;
    private boolean zzB = false;
    private final AtomicInteger zzH = new AtomicInteger(0);

    zzge(zzhh zzhhVar) {
        long currentTimeMillis;
        Bundle bundle;
        boolean z7 = false;
        Preconditions.checkNotNull(zzhhVar);
        Context context = zzhhVar.zza;
        zzab zzabVar = new zzab(context);
        this.zzj = zzabVar;
        zzee.zza = zzabVar;
        this.zze = context;
        this.zzf = zzhhVar.zzb;
        this.zzg = zzhhVar.zzc;
        this.zzh = zzhhVar.zzd;
        this.zzi = zzhhVar.zzh;
        this.zzE = zzhhVar.zze;
        this.zzw = zzhhVar.zzj;
        this.zzF = true;
        com.google.android.gms.internal.measurement.zzcl zzclVar = zzhhVar.zzg;
        if (zzclVar != null && (bundle = zzclVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzclVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzia.zze(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzr = defaultClock;
        Long l8 = zzhhVar.zzi;
        if (l8 != null) {
            currentTimeMillis = l8.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zzc = currentTimeMillis;
        this.zzk = new zzag(this);
        zzfj zzfjVar = new zzfj(this);
        zzfjVar.zzv();
        this.zzl = zzfjVar;
        zzeu zzeuVar = new zzeu(this);
        zzeuVar.zzv();
        this.zzm = zzeuVar;
        zzln zzlnVar = new zzln(this);
        zzlnVar.zzv();
        this.zzp = zzlnVar;
        this.zzq = new zzep(new zzhg(zzhhVar, this));
        this.zzu = new zzd(this);
        zziy zziyVar = new zziy(this);
        zziyVar.zzb();
        this.zzs = zziyVar;
        zzij zzijVar = new zzij(this);
        zzijVar.zzb();
        this.zzt = zzijVar;
        zzko zzkoVar = new zzko(this);
        zzkoVar.zzb();
        this.zzo = zzkoVar;
        zzin zzinVar = new zzin(this);
        zzinVar.zzv();
        this.zzv = zzinVar;
        zzgb zzgbVar = new zzgb(this);
        zzgbVar.zzv();
        this.zzn = zzgbVar;
        com.google.android.gms.internal.measurement.zzcl zzclVar2 = zzhhVar.zzg;
        z7 = (zzclVar2 == null || zzclVar2.zzb == 0) ? true : true;
        if (context.getApplicationContext() instanceof Application) {
            zzij zzq = zzq();
            if (zzq.zzs.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq.zzs.zze.getApplicationContext();
                if (zzq.zza == null) {
                    zzq.zza = new zzii(zzq, null);
                }
                if (z7) {
                    application.unregisterActivityLifecycleCallbacks(zzq.zza);
                    application.registerActivityLifecycleCallbacks(zzq.zza);
                    zzq.zzs.zzay().zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzay().zzk().zza("Application context is not an Application");
        }
        zzgbVar.zzp(new zzgd(this, zzhhVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzA(zzge zzgeVar, zzhh zzhhVar) {
        zzgeVar.zzaz().zzg();
        zzgeVar.zzk.zzn();
        zzaq zzaqVar = new zzaq(zzgeVar);
        zzaqVar.zzv();
        zzgeVar.zzz = zzaqVar;
        zzel zzelVar = new zzel(zzgeVar, zzhhVar.zzf);
        zzelVar.zzb();
        zzgeVar.zzA = zzelVar;
        zzen zzenVar = new zzen(zzgeVar);
        zzenVar.zzb();
        zzgeVar.zzx = zzenVar;
        zzjy zzjyVar = new zzjy(zzgeVar);
        zzjyVar.zzb();
        zzgeVar.zzy = zzjyVar;
        zzgeVar.zzp.zzw();
        zzgeVar.zzl.zzw();
        zzgeVar.zzA.zzc();
        zzes zzi = zzgeVar.zzay().zzi();
        zzgeVar.zzk.zzh();
        zzi.zzb("App measurement initialized, version", 68000L);
        zzgeVar.zzay().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzl = zzelVar.zzl();
        if (TextUtils.isEmpty(zzgeVar.zzf)) {
            if (zzgeVar.zzv().zzae(zzl)) {
                zzgeVar.zzay().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzgeVar.zzay().zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzl)));
            }
        }
        zzgeVar.zzay().zzc().zza("Debug-level message logging enabled");
        if (zzgeVar.zzG != zzgeVar.zzH.get()) {
            zzgeVar.zzay().zzd().zzc("Not all components initialized", Integer.valueOf(zzgeVar.zzG), Integer.valueOf(zzgeVar.zzH.get()));
        }
        zzgeVar.zzB = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzO() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzP(zzgx zzgxVar) {
        if (zzgxVar != null) {
            return;
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void zzQ(zzf zzfVar) {
        if (zzfVar != null) {
            if (zzfVar.zze()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzfVar.getClass())));
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void zzR(zzgy zzgyVar) {
        if (zzgyVar != null) {
            if (zzgyVar.zzx()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzgyVar.getClass())));
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzge zzp(Context context, com.google.android.gms.internal.measurement.zzcl zzclVar, Long l8) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.zze == null || zzclVar.zzf == null)) {
            zzclVar = new com.google.android.gms.internal.measurement.zzcl(zzclVar.zza, zzclVar.zzb, zzclVar.zzc, zzclVar.zzd, null, null, zzclVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzge.class) {
                if (zzd == null) {
                    zzd = new zzge(new zzhh(context, zzclVar, l8));
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzclVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzB() {
        this.zzH.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(String str, int i8, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        if (i8 != 200 && i8 != 204) {
            if (i8 == 304) {
                i8 = 304;
            }
            zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i8), th);
        }
        if (th == null) {
            zzm().zzm.zza(true);
            if (bArr != null && bArr.length != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String optString = jSONObject.optString("deeplink", "");
                    String optString2 = jSONObject.optString("gclid", "");
                    double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                    if (TextUtils.isEmpty(optString)) {
                        zzay().zzc().zza("Deferred Deep Link is empty.");
                        return;
                    }
                    zzln zzv = zzv();
                    zzge zzgeVar = zzv.zzs;
                    if (!TextUtils.isEmpty(optString) && (queryIntentActivities = zzv.zzs.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        this.zzt.zzG("auto", "_cmp", bundle);
                        zzln zzv2 = zzv();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                SharedPreferences.Editor edit = zzv2.zzs.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString("deeplink", optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzv2.zzs.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e8) {
                                zzv2.zzs.zzay().zzd().zzb("Failed to persist Deferred Deep Link. exception", e8);
                                return;
                            }
                        }
                        return;
                    }
                    zzay().zzk().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                    return;
                } catch (JSONException e9) {
                    zzay().zzd().zzb("Failed to parse the Deferred Deep Link response. exception", e9);
                    return;
                }
            }
            zzay().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i8), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD() {
        this.zzG++;
    }

    public final void zzE() {
        zzaz().zzg();
        zzR(zzr());
        String zzl = zzh().zzl();
        Pair zzb = zzm().zzb(zzl);
        if (this.zzk.zzr() && !((Boolean) zzb.second).booleanValue() && !TextUtils.isEmpty((CharSequence) zzb.first)) {
            zzin zzr = zzr();
            zzr.zzu();
            ConnectivityManager connectivityManager = (ConnectivityManager) zzr.zzs.zze.getSystemService("connectivity");
            NetworkInfo networkInfo = null;
            if (connectivityManager != null) {
                try {
                    networkInfo = connectivityManager.getActiveNetworkInfo();
                } catch (SecurityException unused) {
                }
            }
            if (networkInfo != null && networkInfo.isConnected()) {
                zzln zzv = zzv();
                zzh().zzs.zzk.zzh();
                URL zzE = zzv.zzE(68000L, zzl, (String) zzb.first, zzm().zzn.zza() - 1);
                if (zzE != null) {
                    zzin zzr2 = zzr();
                    zzgc zzgcVar = new zzgc(this);
                    zzr2.zzg();
                    zzr2.zzu();
                    Preconditions.checkNotNull(zzE);
                    Preconditions.checkNotNull(zzgcVar);
                    zzr2.zzs.zzaz().zzo(new zzim(zzr2, zzl, zzE, null, null, zzgcVar, null));
                    return;
                }
                return;
            }
            zzay().zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzay().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(boolean z7) {
        this.zzE = Boolean.valueOf(z7);
    }

    public final void zzG(boolean z7) {
        zzaz().zzg();
        this.zzF = z7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzH(com.google.android.gms.internal.measurement.zzcl zzclVar) {
        zzai zzaiVar;
        zzaz().zzg();
        zzai zzc = zzm().zzc();
        zzfj zzm = zzm();
        zzge zzgeVar = zzm.zzs;
        zzm.zzg();
        int i8 = 100;
        int i9 = zzm.zza().getInt("consent_source", 100);
        zzag zzagVar = this.zzk;
        zzge zzgeVar2 = zzagVar.zzs;
        Boolean zzk = zzagVar.zzk("google_analytics_default_allow_ad_storage");
        zzag zzagVar2 = this.zzk;
        zzge zzgeVar3 = zzagVar2.zzs;
        Boolean zzk2 = zzagVar2.zzk("google_analytics_default_allow_analytics_storage");
        if ((zzk != null || zzk2 != null) && zzm().zzl(-10)) {
            zzaiVar = new zzai(zzk, zzk2);
            i8 = -10;
        } else {
            if (!TextUtils.isEmpty(zzh().zzm()) && (i9 == 0 || i9 == 30 || i9 == 10 || i9 == 30 || i9 == 30 || i9 == 40)) {
                zzq().zzS(zzai.zza, -10, this.zzc);
            } else if (TextUtils.isEmpty(zzh().zzm()) && zzclVar != null && zzclVar.zzg != null && zzm().zzl(30)) {
                zzaiVar = zzai.zza(zzclVar.zzg);
                if (!zzaiVar.equals(zzai.zza)) {
                    i8 = 30;
                }
            }
            zzaiVar = null;
        }
        if (zzaiVar != null) {
            zzq().zzS(zzaiVar, i8, this.zzc);
            zzc = zzaiVar;
        }
        zzq().zzV(zzc);
        if (zzm().zzc.zza() == 0) {
            zzay().zzj().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzm().zzc.zzb(this.zzc);
        }
        zzq().zzb.zzc();
        if (!zzM()) {
            if (zzJ()) {
                if (!zzv().zzad("android.permission.INTERNET")) {
                    zzay().zzd().zza("App is missing INTERNET permission");
                }
                if (!zzv().zzad("android.permission.ACCESS_NETWORK_STATE")) {
                    zzay().zzd().zza("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzx()) {
                    if (!zzln.zzaj(this.zze)) {
                        zzay().zzd().zza("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzln.zzak(this.zze, false)) {
                        zzay().zzd().zza("AppMeasurementService not registered/enabled");
                    }
                }
                zzay().zzd().zza("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                zzln zzv = zzv();
                String zzm2 = zzh().zzm();
                zzfj zzm3 = zzm();
                zzm3.zzg();
                String string = zzm3.zza().getString("gmp_app_id", null);
                String zzk3 = zzh().zzk();
                zzfj zzm4 = zzm();
                zzm4.zzg();
                if (zzv.zzam(zzm2, string, zzk3, zzm4.zza().getString("admob_app_id", null))) {
                    zzay().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzfj zzm5 = zzm();
                    zzm5.zzg();
                    Boolean zzd2 = zzm5.zzd();
                    SharedPreferences.Editor edit = zzm5.zza().edit();
                    edit.clear();
                    edit.apply();
                    if (zzd2 != null) {
                        zzm5.zzh(zzd2);
                    }
                    zzi().zzj();
                    this.zzy.zzs();
                    this.zzy.zzr();
                    zzm().zzc.zzb(this.zzc);
                    zzm().zze.zzb(null);
                }
                zzfj zzm6 = zzm();
                String zzm7 = zzh().zzm();
                zzm6.zzg();
                SharedPreferences.Editor edit2 = zzm6.zza().edit();
                edit2.putString("gmp_app_id", zzm7);
                edit2.apply();
                zzfj zzm8 = zzm();
                String zzk4 = zzh().zzk();
                zzm8.zzg();
                SharedPreferences.Editor edit3 = zzm8.zza().edit();
                edit3.putString("admob_app_id", zzk4);
                edit3.apply();
            }
            if (!zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                zzm().zze.zzb(null);
            }
            zzq().zzO(zzm().zze.zza());
            zzob.zzc();
            if (this.zzk.zzs(null, zzeh.zzac)) {
                try {
                    zzv().zzs.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzm().zzo.zza())) {
                        zzay().zzk().zza("Remote config removed with active feature rollouts");
                        zzm().zzo.zzb(null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                boolean zzJ = zzJ();
                if (!zzm().zzj() && !this.zzk.zzv()) {
                    zzm().zzi(!zzJ);
                }
                if (zzJ) {
                    zzq().zzz();
                }
                zzu().zza.zza();
                zzt().zzu(new AtomicReference());
                zzt().zzH(zzm().zzr.zza());
            }
        }
        zzm().zzi.zza(true);
    }

    public final boolean zzI() {
        if (this.zzE != null && this.zzE.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzJ() {
        if (zza() == 0) {
            return true;
        }
        return false;
    }

    public final boolean zzK() {
        zzaz().zzg();
        return this.zzF;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzM() {
        boolean z7;
        if (this.zzB) {
            zzaz().zzg();
            Boolean bool = this.zzC;
            if (bool == null || this.zzD == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzD) > 1000)) {
                this.zzD = this.zzr.elapsedRealtime();
                boolean z8 = true;
                if (zzv().zzad("android.permission.INTERNET") && zzv().zzad("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzx() || (zzln.zzaj(this.zze) && zzln.zzak(this.zze, false)))) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Boolean valueOf = Boolean.valueOf(z7);
                this.zzC = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzv().zzX(zzh().zzm(), zzh().zzk()) && TextUtils.isEmpty(zzh().zzk())) {
                        z8 = false;
                    }
                    this.zzC = Boolean.valueOf(z8);
                }
            }
            return this.zzC.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzN() {
        return this.zzi;
    }

    public final int zza() {
        zzaz().zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        zzaz().zzg();
        if (!this.zzF) {
            return 8;
        }
        Boolean zzd2 = zzm().zzd();
        if (zzd2 != null) {
            if (zzd2.booleanValue()) {
                return 0;
            }
            return 3;
        }
        zzag zzagVar = this.zzk;
        zzab zzabVar = zzagVar.zzs.zzj;
        Boolean zzk = zzagVar.zzk("firebase_analytics_collection_enabled");
        if (zzk != null) {
            if (zzk.booleanValue()) {
                return 0;
            }
            return 4;
        }
        Boolean bool2 = this.zza;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                return 0;
            }
            return 5;
        } else if (this.zzE == null || this.zzE.booleanValue()) {
            return 0;
        } else {
            return 7;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final Context zzau() {
        return this.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final Clock zzav() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final zzab zzaw() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final zzeu zzay() {
        zzR(this.zzm);
        return this.zzm;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    @Pure
    public final zzgb zzaz() {
        zzR(this.zzn);
        return this.zzn;
    }

    @Pure
    public final zzd zzd() {
        zzd zzdVar = this.zzu;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzag zzf() {
        return this.zzk;
    }

    @Pure
    public final zzaq zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzel zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzen zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzep zzj() {
        return this.zzq;
    }

    public final zzeu zzl() {
        zzeu zzeuVar = this.zzm;
        if (zzeuVar == null || !zzeuVar.zzx()) {
            return null;
        }
        return zzeuVar;
    }

    @Pure
    public final zzfj zzm() {
        zzP(this.zzl);
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzgb zzo() {
        return this.zzn;
    }

    @Pure
    public final zzij zzq() {
        zzQ(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzin zzr() {
        zzR(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zziy zzs() {
        zzQ(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzjy zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzko zzu() {
        zzQ(this.zzo);
        return this.zzo;
    }

    @Pure
    public final zzln zzv() {
        zzP(this.zzp);
        return this.zzp;
    }

    @Pure
    public final String zzw() {
        return this.zzf;
    }

    @Pure
    public final String zzx() {
        return this.zzg;
    }

    @Pure
    public final String zzy() {
        return this.zzh;
    }

    @Pure
    public final String zzz() {
        return this.zzw;
    }
}
