package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzob;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zzij extends zzf {
    @VisibleForTesting
    protected zzii zza;
    final zzs zzb;
    @VisibleForTesting
    protected boolean zzc;
    private zzhe zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private zzai zzi;
    private int zzj;
    private final AtomicLong zzk;
    private long zzl;
    private int zzm;
    private final zzlm zzn;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzij(zzge zzgeVar) {
        super(zzgeVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzc = true;
        this.zzn = new zzhx(this);
        this.zzg = new AtomicReference();
        this.zzi = new zzai(null, null);
        this.zzj = 100;
        this.zzl = -1L;
        this.zzm = 100;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzs(zzgeVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(Boolean bool, boolean z7) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.zzs.zzm().zzh(bool);
        if (z7) {
            zzfj zzm = this.zzs.zzm();
            zzge zzgeVar = zzm.zzs;
            zzm.zzg();
            SharedPreferences.Editor edit = zzm.zza().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (!this.zzs.zzK() && (bool == null || bool.booleanValue())) {
            return;
        }
        zzab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzab() {
        long j8;
        zzg();
        String zza = this.zzs.zzm().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zzY("app", "_npa", null, this.zzs.zzav().currentTimeMillis());
            } else {
                if (true != "true".equals(zza)) {
                    j8 = 0;
                } else {
                    j8 = 1;
                }
                zzY("app", "_npa", Long.valueOf(j8), this.zzs.zzav().currentTimeMillis());
            }
        }
        if (this.zzs.zzJ() && this.zzc) {
            this.zzs.zzay().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzz();
            zzok.zzc();
            if (this.zzs.zzf().zzs(null, zzeh.zzad)) {
                this.zzs.zzu().zza.zza();
            }
            this.zzs.zzaz().zzp(new zzhm(this));
            return;
        }
        this.zzs.zzay().zzc().zza("Updating Scion state (FE)");
        this.zzs.zzt().zzI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzv(zzij zzijVar, zzai zzaiVar, zzai zzaiVar2) {
        boolean z7;
        zzah[] zzahVarArr = {zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE};
        int i8 = 0;
        while (true) {
            if (i8 < 2) {
                zzah zzahVar = zzahVarArr[i8];
                if (!zzaiVar2.zzi(zzahVar) && zzaiVar.zzi(zzahVar)) {
                    z7 = true;
                    break;
                }
                i8++;
            } else {
                z7 = false;
                break;
            }
        }
        boolean zzl = zzaiVar.zzl(zzaiVar2, zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE);
        if (!z7 && !zzl) {
            return;
        }
        zzijVar.zzs.zzh().zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzw(zzij zzijVar, zzai zzaiVar, int i8, long j8, boolean z7, boolean z8) {
        zzijVar.zzg();
        zzijVar.zza();
        if (j8 <= zzijVar.zzl && zzai.zzj(zzijVar.zzm, i8)) {
            zzijVar.zzs.zzay().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzaiVar);
            return;
        }
        zzfj zzm = zzijVar.zzs.zzm();
        zzge zzgeVar = zzm.zzs;
        zzm.zzg();
        if (zzm.zzl(i8)) {
            SharedPreferences.Editor edit = zzm.zza().edit();
            edit.putString("consent_settings", zzaiVar.zzh());
            edit.putInt("consent_source", i8);
            edit.apply();
            zzijVar.zzl = j8;
            zzijVar.zzm = i8;
            zzijVar.zzs.zzt().zzF(z7);
            if (z8) {
                zzijVar.zzs.zzt().zzu(new AtomicReference());
                return;
            }
            return;
        }
        zzijVar.zzs.zzay().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i8));
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzs.zzav().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzs.zzaz().zzp(new zzht(this, bundle2));
    }

    public final void zzB() {
        if ((this.zzs.zzau().getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) this.zzs.zzau().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(Bundle bundle) {
        if (bundle == null) {
            this.zzs.zzm().zzr.zzb(new Bundle());
            return;
        }
        Bundle zza = this.zzs.zzm().zzr.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzs.zzv().zzaf(obj)) {
                    this.zzs.zzv().zzN(this.zzn, null, 27, null, null, 0);
                }
                this.zzs.zzay().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzln.zzah(str)) {
                this.zzs.zzay().zzl().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza.remove(str);
            } else {
                zzln zzv = this.zzs.zzv();
                this.zzs.zzf();
                if (zzv.zzaa("param", str, 100, obj)) {
                    this.zzs.zzv().zzO(zza, str, obj);
                }
            }
        }
        this.zzs.zzv();
        int zzc = this.zzs.zzf().zzc();
        if (zza.size() > zzc) {
            int i8 = 0;
            for (String str2 : new TreeSet(zza.keySet())) {
                i8++;
                if (i8 > zzc) {
                    zza.remove(str2);
                }
            }
            this.zzs.zzv().zzN(this.zzn, null, 26, null, null, 0);
            this.zzs.zzay().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzs.zzm().zzr.zzb(zza);
        this.zzs.zzt().zzH(zza);
    }

    public final void zzD(String str, String str2, Bundle bundle) {
        zzE(str, str2, bundle, true, true, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z7, boolean z8, long j8) {
        String str3;
        Bundle bundle2;
        boolean z9;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (str2 != "screen_view" && (str2 == null || !str2.equals("screen_view"))) {
            if (z8 && this.zzd != null && !zzln.zzah(str2)) {
                z9 = false;
            } else {
                z9 = true;
            }
            zzM(str3, str2, j8, bundle2, z8, z9, z7, null);
            return;
        }
        this.zzs.zzs().zzx(bundle2, j8);
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) {
        zzge.zzO();
        zzM("auto", str2, this.zzs.zzav().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        zzH(str, str2, this.zzs.zzav().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzH(String str, String str2, long j8, Bundle bundle) {
        boolean z7;
        zzg();
        if (this.zzd != null && !zzln.zzah(str2)) {
            z7 = false;
        } else {
            z7 = true;
        }
        zzI(str, str2, j8, bundle, true, z7, true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzI(String str, String str2, long j8, Bundle bundle, boolean z7, boolean z8, boolean z9, String str3) {
        boolean z10;
        String str4;
        long j9;
        String str5;
        String str6;
        Bundle[] bundleArr;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        if (this.zzs.zzJ()) {
            List zzn = this.zzs.zzh().zzn();
            if (zzn != null && !zzn.contains(str2)) {
                this.zzs.zzay().zzc().zzc("Dropping non-safelisted event. event name, origin", str2, str);
                return;
            }
            if (!this.zzf) {
                this.zzf = true;
                try {
                    if (!this.zzs.zzN()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzs.zzau().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", Context.class).invoke(null, this.zzs.zzau());
                    } catch (Exception e8) {
                        this.zzs.zzay().zzk().zzb("Failed to invoke Tag Manager's initialize() method", e8);
                    }
                } catch (ClassNotFoundException unused) {
                    this.zzs.zzay().zzi().zza("Tag Manager is not found and thus will not be used");
                }
            }
            if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
                this.zzs.zzaw();
                zzY("auto", "_lgclid", bundle.getString("gclid"), this.zzs.zzav().currentTimeMillis());
            }
            this.zzs.zzaw();
            if (z7 && zzln.zzal(str2)) {
                this.zzs.zzv().zzL(bundle, this.zzs.zzm().zzr.zza());
            }
            if (!z9) {
                this.zzs.zzaw();
                if (!"_iap".equals(str2)) {
                    zzln zzv = this.zzs.zzv();
                    int i8 = 2;
                    if (zzv.zzac("event", str2)) {
                        if (zzv.zzZ("event", zzhb.zza, zzhb.zzb, str2)) {
                            zzv.zzs.zzf();
                            if (zzv.zzY("event", 40, str2)) {
                                i8 = 0;
                            }
                        } else {
                            i8 = 13;
                        }
                    }
                    if (i8 != 0) {
                        this.zzs.zzay().zze().zzb("Invalid public event name. Event will not be logged (FE)", this.zzs.zzj().zzd(str2));
                        zzln zzv2 = this.zzs.zzv();
                        this.zzs.zzf();
                        this.zzs.zzv().zzN(this.zzn, null, i8, "_ev", zzv2.zzD(str2, 40, true), str2 != null ? str2.length() : 0);
                        return;
                    }
                }
            }
            zzpf.zzc();
            if (this.zzs.zzf().zzs(null, zzeh.zzak)) {
                this.zzs.zzaw();
                zziq zzj = this.zzs.zzs().zzj(false);
                if (zzj != null && !bundle.containsKey("_sc")) {
                    zzj.zzd = true;
                }
                zzln.zzK(zzj, bundle, z7 && !z9);
            } else {
                this.zzs.zzaw();
                zziq zzj2 = this.zzs.zzs().zzj(false);
                if (zzj2 != null && !bundle.containsKey("_sc")) {
                    zzj2.zzd = true;
                }
                zzln.zzK(zzj2, bundle, z7 && !z9);
            }
            boolean equals = "am".equals(str);
            boolean zzah = zzln.zzah(str2);
            if (!z7 || this.zzd == null || zzah) {
                z10 = equals;
            } else if (!equals) {
                this.zzs.zzay().zzc().zzc("Passing event to registered event handler (FE)", this.zzs.zzj().zzd(str2), this.zzs.zzj().zzb(bundle));
                Preconditions.checkNotNull(this.zzd);
                this.zzd.interceptEvent(str, str2, bundle, j8);
                return;
            } else {
                z10 = true;
            }
            if (this.zzs.zzM()) {
                int zzh = this.zzs.zzv().zzh(str2);
                if (zzh != 0) {
                    this.zzs.zzay().zze().zzb("Invalid event name. Event will not be logged (FE)", this.zzs.zzj().zzd(str2));
                    zzln zzv3 = this.zzs.zzv();
                    this.zzs.zzf();
                    this.zzs.zzv().zzN(this.zzn, str3, zzh, "_ev", zzv3.zzD(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
                Bundle zzy = this.zzs.zzv().zzy(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z9);
                Preconditions.checkNotNull(zzy);
                this.zzs.zzaw();
                if (this.zzs.zzs().zzj(false) != null && "_ae".equals(str2)) {
                    zzkm zzkmVar = this.zzs.zzu().zzb;
                    long elapsedRealtime = zzkmVar.zzc.zzs.zzav().elapsedRealtime();
                    long j10 = elapsedRealtime - zzkmVar.zzb;
                    zzkmVar.zzb = elapsedRealtime;
                    if (j10 > 0) {
                        this.zzs.zzv().zzI(zzy, j10);
                    }
                }
                zzob.zzc();
                if (this.zzs.zzf().zzs(null, zzeh.zzac)) {
                    if (!"auto".equals(str) && "_ssr".equals(str2)) {
                        zzln zzv4 = this.zzs.zzv();
                        String string = zzy.getString("_ffr");
                        if (Strings.isEmptyOrWhitespace(string)) {
                            string = null;
                        } else if (string != null) {
                            string = string.trim();
                        }
                        if (!zzll.zza(string, zzv4.zzs.zzm().zzo.zza())) {
                            zzv4.zzs.zzm().zzo.zzb(string);
                        } else {
                            zzv4.zzs.zzay().zzc().zza("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                    } else if ("_ae".equals(str2)) {
                        String zza = this.zzs.zzv().zzs.zzm().zzo.zza();
                        if (!TextUtils.isEmpty(zza)) {
                            zzy.putString("_ffr", zza);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(zzy);
                if (this.zzs.zzm().zzj.zza() > 0 && this.zzs.zzm().zzk(j8) && this.zzs.zzm().zzl.zzb()) {
                    this.zzs.zzay().zzj().zza("Current session is expired, remove the session number, ID, and engagement time");
                    str4 = "_ae";
                    j9 = 0;
                    zzY("auto", "_sid", null, this.zzs.zzav().currentTimeMillis());
                    zzY("auto", "_sno", null, this.zzs.zzav().currentTimeMillis());
                    zzY("auto", "_se", null, this.zzs.zzav().currentTimeMillis());
                } else {
                    str4 = "_ae";
                    j9 = 0;
                }
                if (zzy.getLong("extend_session", j9) == 1) {
                    this.zzs.zzay().zzj().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    this.zzs.zzu().zza.zzb(j8, true);
                }
                ArrayList arrayList2 = new ArrayList(zzy.keySet());
                Collections.sort(arrayList2);
                int size = arrayList2.size();
                for (int i9 = 0; i9 < size; i9++) {
                    String str7 = (String) arrayList2.get(i9);
                    if (str7 != null) {
                        this.zzs.zzv();
                        Object obj = zzy.get(str7);
                        if (obj instanceof Bundle) {
                            bundleArr = new Bundle[]{(Bundle) obj};
                        } else if (obj instanceof Parcelable[]) {
                            Parcelable[] parcelableArr = (Parcelable[]) obj;
                            bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                        } else if (obj instanceof ArrayList) {
                            ArrayList arrayList3 = (ArrayList) obj;
                            bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                        } else {
                            bundleArr = null;
                        }
                        if (bundleArr != null) {
                            zzy.putParcelableArray(str7, bundleArr);
                        }
                    }
                }
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    Bundle bundle2 = (Bundle) arrayList.get(i10);
                    if (i10 != 0) {
                        str6 = "_ep";
                        str5 = str;
                    } else {
                        str5 = str;
                        str6 = str2;
                    }
                    bundle2.putString("_o", str5);
                    if (z8) {
                        bundle2 = this.zzs.zzv().zzt(bundle2);
                    }
                    Bundle bundle3 = bundle2;
                    this.zzs.zzt().zzA(new zzaw(str6, new zzau(bundle3), str, j8), str3);
                    if (!z10) {
                        for (zzhf zzhfVar : this.zze) {
                            zzhfVar.onEvent(str, str2, new Bundle(bundle3), j8);
                        }
                    }
                }
                this.zzs.zzaw();
                if (this.zzs.zzs().zzj(false) == null || !str4.equals(str2)) {
                    return;
                }
                this.zzs.zzu().zzb.zzd(true, true, this.zzs.zzav().elapsedRealtime());
                return;
            }
            return;
        }
        this.zzs.zzay().zzc().zza("Event not sent since app measurement is disabled");
    }

    public final void zzJ(zzhf zzhfVar) {
        zza();
        Preconditions.checkNotNull(zzhfVar);
        if (!this.zze.add(zzhfVar)) {
            this.zzs.zzay().zzk().zza("OnEventListener already registered");
        }
    }

    public final void zzK(long j8) {
        this.zzg.set(null);
        this.zzs.zzaz().zzp(new zzhr(this, j8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzL(long j8, boolean z7) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zza("Resetting analytics data (FE)");
        zzko zzu = this.zzs.zzu();
        zzu.zzg();
        zzu.zzb.zza();
        zzpi.zzc();
        if (this.zzs.zzf().zzs(null, zzeh.zzaz)) {
            this.zzs.zzh().zzo();
        }
        boolean zzJ = this.zzs.zzJ();
        zzfj zzm = this.zzs.zzm();
        zzm.zzc.zzb(j8);
        if (!TextUtils.isEmpty(zzm.zzs.zzm().zzo.zza())) {
            zzm.zzo.zzb(null);
        }
        zzok.zzc();
        zzag zzf = zzm.zzs.zzf();
        zzeg zzegVar = zzeh.zzad;
        if (zzf.zzs(null, zzegVar)) {
            zzm.zzj.zzb(0L);
        }
        if (!zzm.zzs.zzf().zzv()) {
            zzm.zzi(!zzJ);
        }
        zzm.zzp.zzb(null);
        zzm.zzq.zzb(0L);
        zzm.zzr.zzb(null);
        if (z7) {
            this.zzs.zzt().zzC();
        }
        zzok.zzc();
        if (this.zzs.zzf().zzs(null, zzegVar)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzc = !zzJ;
    }

    protected final void zzM(String str, String str2, long j8, Bundle bundle, boolean z7, boolean z8, boolean z9, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i8 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i8 < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i8];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i8] = new Bundle((Bundle) parcelable);
                        }
                        i8++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i8 < list.size()) {
                        Object obj2 = list.get(i8);
                        if (obj2 instanceof Bundle) {
                            list.set(i8, new Bundle((Bundle) obj2));
                        }
                        i8++;
                    }
                }
            }
        }
        this.zzs.zzaz().zzp(new zzho(this, str, str2, j8, bundle2, z7, z8, z9, str3));
    }

    final void zzN(String str, String str2, long j8, Object obj) {
        this.zzs.zzaz().zzp(new zzhp(this, str, str2, obj, j8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzO(String str) {
        this.zzg.set(str);
    }

    public final void zzP(Bundle bundle) {
        zzQ(bundle, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j8) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzs.zzay().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzha.zza(bundle2, "app_id", String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.ORIGIN, String.class, null);
        zzha.zza(bundle2, "name", String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.VALUE, Object.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN));
        Preconditions.checkNotNull(bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j8);
        String string = bundle2.getString("name");
        Object obj = bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (this.zzs.zzv().zzl(string) == 0) {
            if (this.zzs.zzv().zzd(string, obj) == 0) {
                Object zzB = this.zzs.zzv().zzB(string, obj);
                if (zzB == null) {
                    this.zzs.zzay().zzd().zzc("Unable to normalize conditional user property value", this.zzs.zzj().zzf(string), obj);
                    return;
                }
                zzha.zzb(bundle2, zzB);
                long j9 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    this.zzs.zzf();
                    if (j9 > 15552000000L || j9 < 1) {
                        this.zzs.zzay().zzd().zzc("Invalid conditional user property timeout", this.zzs.zzj().zzf(string), Long.valueOf(j9));
                        return;
                    }
                }
                long j10 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                this.zzs.zzf();
                if (j10 <= 15552000000L && j10 >= 1) {
                    this.zzs.zzaz().zzp(new zzhs(this, bundle2));
                    return;
                } else {
                    this.zzs.zzay().zzd().zzc("Invalid conditional user property time to live", this.zzs.zzj().zzf(string), Long.valueOf(j10));
                    return;
                }
            }
            this.zzs.zzay().zzd().zzc("Invalid conditional user property value", this.zzs.zzj().zzf(string), obj);
            return;
        }
        this.zzs.zzay().zzd().zzb("Invalid conditional user property name", this.zzs.zzj().zzf(string));
    }

    public final void zzR(Bundle bundle, int i8, long j8) {
        zza();
        String zzg = zzai.zzg(bundle);
        if (zzg != null) {
            this.zzs.zzay().zzl().zzb("Ignoring invalid consent setting", zzg);
            this.zzs.zzay().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzai.zza(bundle), i8, j8);
    }

    public final void zzS(zzai zzaiVar, int i8, long j8) {
        zzai zzaiVar2;
        boolean z7;
        boolean z8;
        boolean z9;
        zzai zzaiVar3 = zzaiVar;
        zza();
        if (i8 != -10 && zzaiVar.zze() == null && zzaiVar.zzf() == null) {
            this.zzs.zzay().zzl().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            zzaiVar2 = this.zzi;
            z7 = true;
            z8 = false;
            if (zzai.zzj(i8, this.zzj)) {
                boolean zzk = zzaiVar3.zzk(this.zzi);
                zzah zzahVar = zzah.ANALYTICS_STORAGE;
                if (zzaiVar3.zzi(zzahVar) && !this.zzi.zzi(zzahVar)) {
                    z8 = true;
                }
                zzaiVar3 = zzaiVar3.zzd(this.zzi);
                this.zzi = zzaiVar3;
                this.zzj = i8;
                z9 = z8;
                z8 = zzk;
            } else {
                z7 = false;
                z9 = false;
            }
        }
        if (!z7) {
            this.zzs.zzay().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzaiVar3);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z8) {
            this.zzg.set(null);
            this.zzs.zzaz().zzq(new zzid(this, zzaiVar3, j8, i8, andIncrement, z9, zzaiVar2));
            return;
        }
        zzie zzieVar = new zzie(this, zzaiVar3, i8, andIncrement, z9, zzaiVar2);
        if (i8 != 30 && i8 != -10) {
            this.zzs.zzaz().zzp(zzieVar);
        } else {
            this.zzs.zzaz().zzq(zzieVar);
        }
    }

    public final void zzT(zzhe zzheVar) {
        zzhe zzheVar2;
        boolean z7;
        zzg();
        zza();
        if (zzheVar != null && zzheVar != (zzheVar2 = this.zzd)) {
            if (zzheVar2 == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkState(z7, "EventInterceptor already set.");
        }
        this.zzd = zzheVar;
    }

    public final void zzU(Boolean bool) {
        zza();
        this.zzs.zzaz().zzp(new zzic(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzV(zzai zzaiVar) {
        boolean z7;
        Boolean bool;
        zzg();
        if ((zzaiVar.zzi(zzah.ANALYTICS_STORAGE) && zzaiVar.zzi(zzah.AD_STORAGE)) || this.zzs.zzt().zzM()) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 != this.zzs.zzK()) {
            this.zzs.zzG(z7);
            zzfj zzm = this.zzs.zzm();
            zzge zzgeVar = zzm.zzs;
            zzm.zzg();
            if (zzm.zza().contains("measurement_enabled_from_api")) {
                bool = Boolean.valueOf(zzm.zza().getBoolean("measurement_enabled_from_api", true));
            } else {
                bool = null;
            }
            if (!z7 || bool == null || bool.booleanValue()) {
                zzaa(Boolean.valueOf(z7), false);
            }
        }
    }

    public final void zzW(String str, String str2, Object obj, boolean z7) {
        zzX("auto", "_ldl", obj, true, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzX(String str, String str2, Object obj, boolean z7, long j8) {
        String str3;
        int i8;
        int length;
        int i9;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (z7) {
            i8 = this.zzs.zzv().zzl(str2);
        } else {
            zzln zzv = this.zzs.zzv();
            if (zzv.zzac("user property", str2)) {
                if (!zzv.zzZ("user property", zzhd.zza, null, str2)) {
                    i8 = 15;
                } else {
                    zzv.zzs.zzf();
                    if (zzv.zzY("user property", 24, str2)) {
                        i8 = 0;
                    }
                }
            }
            i8 = 6;
        }
        if (i8 != 0) {
            zzln zzv2 = this.zzs.zzv();
            this.zzs.zzf();
            String zzD = zzv2.zzD(str2, 24, true);
            if (str2 != null) {
                i9 = str2.length();
            } else {
                i9 = 0;
            }
            this.zzs.zzv().zzN(this.zzn, null, i8, "_ev", zzD, i9);
        } else if (obj != null) {
            int zzd = this.zzs.zzv().zzd(str2, obj);
            if (zzd != 0) {
                zzln zzv3 = this.zzs.zzv();
                this.zzs.zzf();
                String zzD2 = zzv3.zzD(str2, 24, true);
                if (!(obj instanceof String) && !(obj instanceof CharSequence)) {
                    length = 0;
                } else {
                    length = obj.toString().length();
                }
                this.zzs.zzv().zzN(this.zzn, null, zzd, "_ev", zzD2, length);
                return;
            }
            Object zzB = this.zzs.zzv().zzB(str2, obj);
            if (zzB != null) {
                zzN(str3, str2, j8, zzB);
            }
        } else {
            zzN(str3, str2, j8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzY(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzg()
            r8.zza()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L64
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L52
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L52
            r10 = 1
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r0 = "false"
            boolean r11 = r0.equals(r11)
            r2 = 1
            if (r10 == r11) goto L37
            r10 = 0
            goto L38
        L37:
            r10 = r2
        L38:
            java.lang.Long r11 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzs
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzh
            long r4 = r11.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L4e
            java.lang.String r0 = "true"
        L4e:
            r10.zzb(r0)
            goto L61
        L52:
            if (r11 != 0) goto L64
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzs
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzm()
            com.google.android.gms.measurement.internal.zzfi r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zzb(r0)
        L61:
            r6 = r11
            r3 = r1
            goto L66
        L64:
            r3 = r10
            r6 = r11
        L66:
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzs
            boolean r10 = r10.zzJ()
            if (r10 != 0) goto L7e
            com.google.android.gms.measurement.internal.zzge r9 = r8.zzs
            com.google.android.gms.measurement.internal.zzeu r9 = r9.zzay()
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzj()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L7e:
            com.google.android.gms.measurement.internal.zzge r10 = r8.zzs
            boolean r10 = r10.zzM()
            if (r10 != 0) goto L87
            return
        L87:
            com.google.android.gms.measurement.internal.zzli r10 = new com.google.android.gms.measurement.internal.zzli
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzge r9 = r8.zzs
            com.google.android.gms.measurement.internal.zzjy r9 = r9.zzt()
            r9.zzK(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzij.zzY(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzZ(zzhf zzhfVar) {
        zza();
        Preconditions.checkNotNull(zzhfVar);
        if (!this.zze.remove(zzhfVar)) {
            this.zzs.zzay().zzk().zza("OnEventListener had not been registered");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzs.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzs.zzaz().zzd(atomicReference, 15000L, "boolean test flag value", new zzhv(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzs.zzaz().zzd(atomicReference, 15000L, "double test flag value", new zzib(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzs.zzaz().zzd(atomicReference, 15000L, "int test flag value", new zzia(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzs.zzaz().zzd(atomicReference, 15000L, "long test flag value", new zzhz(this, atomicReference));
    }

    public final String zzo() {
        return (String) this.zzg.get();
    }

    public final String zzp() {
        zziq zzi = this.zzs.zzs().zzi();
        if (zzi != null) {
            return zzi.zzb;
        }
        return null;
    }

    public final String zzq() {
        zziq zzi = this.zzs.zzs().zzi();
        if (zzi != null) {
            return zzi.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzs.zzaz().zzd(atomicReference, 15000L, "String test flag value", new zzhy(this, atomicReference));
    }

    public final ArrayList zzs(String str, String str2) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.zzs.zzaw();
        if (zzab.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get conditional user properties", new zzhu(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            this.zzs.zzay().zzd().zzb("Timed out waiting for get conditional user properties", null);
            return new ArrayList();
        }
        return zzln.zzH(list);
    }

    public final List zzt(boolean z7) {
        zza();
        this.zzs.zzay().zzj().zza("Getting user properties (FE)");
        if (!this.zzs.zzaz().zzs()) {
            this.zzs.zzaw();
            if (zzab.zza()) {
                this.zzs.zzay().zzd().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzs.zzaz().zzd(atomicReference, 5000L, "get user properties", new zzhq(this, atomicReference, z7));
            List list = (List) atomicReference.get();
            if (list == null) {
                this.zzs.zzay().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z7));
                return Collections.emptyList();
            }
            return list;
        }
        this.zzs.zzay().zzd().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzu(String str, String str2, boolean z7) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzs.zzaw();
        if (zzab.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get user properties", new zzhw(this, atomicReference, null, str, str2, z7));
        List<zzli> list = (List) atomicReference.get();
        if (list == null) {
            this.zzs.zzay().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z7));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzli zzliVar : list) {
            Object zza = zzliVar.zza();
            if (zza != null) {
                arrayMap.put(zzliVar.zzb, zza);
            }
        }
        return arrayMap;
    }

    public final void zzz() {
        zzg();
        zza();
        if (this.zzs.zzM()) {
            if (this.zzs.zzf().zzs(null, zzeh.zzX)) {
                zzag zzf = this.zzs.zzf();
                zzf.zzs.zzaw();
                Boolean zzk = zzf.zzk("google_analytics_deferred_deep_link_enabled");
                if (zzk != null && zzk.booleanValue()) {
                    this.zzs.zzay().zzc().zza("Deferred Deep Link feature enabled.");
                    this.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhl
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzij zzijVar = zzij.this;
                            zzijVar.zzg();
                            if (!zzijVar.zzs.zzm().zzm.zzb()) {
                                long zza = zzijVar.zzs.zzm().zzn.zza();
                                zzijVar.zzs.zzm().zzn.zzb(1 + zza);
                                zzijVar.zzs.zzf();
                                if (zza >= 5) {
                                    zzijVar.zzs.zzay().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                    zzijVar.zzs.zzm().zzm.zza(true);
                                    return;
                                }
                                zzijVar.zzs.zzE();
                                return;
                            }
                            zzijVar.zzs.zzay().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
                        }
                    });
                }
            }
            this.zzs.zzt().zzq();
            this.zzc = false;
            zzfj zzm = this.zzs.zzm();
            zzm.zzg();
            String string = zzm.zza().getString("previous_os_version", null);
            zzm.zzs.zzg().zzu();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm.zza().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.zzs.zzg().zzu();
                if (!string.equals(str)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzG("auto", "_ou", bundle);
                }
            }
        }
    }
}
