package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.simpleframework.xml.strategy.Name;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* loaded from: classes.dex */
public final class zziy extends zzf {
    @VisibleForTesting
    protected zziq zza;
    private volatile zziq zzb;
    private volatile zziq zzc;
    private final Map zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zziq zzg;
    private zziq zzh;
    private boolean zzi;
    private final Object zzj;
    private zziq zzk;
    private String zzl;

    public zziy(zzge zzgeVar) {
        super(zzgeVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(Activity activity, zziq zziqVar, boolean z7) {
        zziq zziqVar2;
        zziq zziqVar3;
        String str;
        if (this.zzb == null) {
            zziqVar2 = this.zzc;
        } else {
            zziqVar2 = this.zzb;
        }
        zziq zziqVar4 = zziqVar2;
        if (zziqVar.zzb == null) {
            if (activity != null) {
                str = zzl(activity.getClass(), "Activity");
            } else {
                str = null;
            }
            zziqVar3 = new zziq(zziqVar.zza, str, zziqVar.zzc, zziqVar.zze, zziqVar.zzf);
        } else {
            zziqVar3 = zziqVar;
        }
        this.zzc = this.zzb;
        this.zzb = zziqVar3;
        this.zzs.zzaz().zzp(new zzit(this, zziqVar3, zziqVar4, this.zzs.zzav().elapsedRealtime(), z7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzB(zziq zziqVar, zziq zziqVar2, long j8, boolean z7, Bundle bundle) {
        boolean z8;
        Bundle bundle2;
        String str;
        long j9;
        long j10;
        zzg();
        boolean z9 = false;
        if (zziqVar2 != null && zziqVar2.zzc == zziqVar.zzc && zzir.zza(zziqVar2.zzb, zziqVar.zzb) && zzir.zza(zziqVar2.zza, zziqVar.zza)) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z7 && this.zza != null) {
            z9 = true;
        }
        if (z8) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            zzln.zzK(zziqVar, bundle3, true);
            if (zziqVar2 != null) {
                String str2 = zziqVar2.zza;
                if (str2 != null) {
                    bundle3.putString("_pn", str2);
                }
                String str3 = zziqVar2.zzb;
                if (str3 != null) {
                    bundle3.putString("_pc", str3);
                }
                bundle3.putLong("_pi", zziqVar2.zzc);
            }
            if (z9) {
                zzkm zzkmVar = this.zzs.zzu().zzb;
                long j11 = j8 - zzkmVar.zzb;
                zzkmVar.zzb = j8;
                if (j11 > 0) {
                    this.zzs.zzv().zzI(bundle3, j11);
                }
            }
            if (!this.zzs.zzf().zzu()) {
                bundle3.putLong("_mst", 1L);
            }
            if (true != zziqVar.zze) {
                str = "auto";
            } else {
                str = "app";
            }
            String str4 = str;
            long currentTimeMillis = this.zzs.zzav().currentTimeMillis();
            if (zziqVar.zze) {
                j9 = currentTimeMillis;
                long j12 = zziqVar.zzf;
                if (j12 != 0) {
                    j10 = j12;
                    this.zzs.zzq().zzH(str4, "_vs", j10, bundle3);
                }
            } else {
                j9 = currentTimeMillis;
            }
            j10 = j9;
            this.zzs.zzq().zzH(str4, "_vs", j10, bundle3);
        }
        if (z9) {
            zzC(this.zza, true, j8);
        }
        this.zza = zziqVar;
        if (zziqVar.zze) {
            this.zzh = zziqVar;
        }
        this.zzs.zzt().zzG(zziqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzC(zziq zziqVar, boolean z7, long j8) {
        boolean z8;
        this.zzs.zzd().zzf(this.zzs.zzav().elapsedRealtime());
        if (zziqVar != null && zziqVar.zzd) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (this.zzs.zzu().zzb.zzd(z8, z7, j8) && zziqVar != null) {
            zziqVar.zzd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzp(zziy zziyVar, Bundle bundle, zziq zziqVar, zziq zziqVar2, long j8) {
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        zziyVar.zzB(zziqVar, zziqVar2, j8, true, zziyVar.zzs.zzv().zzy(null, "screen_view", bundle, null, false));
    }

    private final zziq zzz(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zziq zziqVar = (zziq) this.zzd.get(activity);
        if (zziqVar == null) {
            zziq zziqVar2 = new zziq(null, zzl(activity.getClass(), "Activity"), this.zzs.zzv().zzq());
            this.zzd.put(activity, zziqVar2);
            zziqVar = zziqVar2;
        }
        if (this.zzg != null) {
            return this.zzg;
        }
        return zziqVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final zziq zzi() {
        return this.zzb;
    }

    public final zziq zzj(boolean z7) {
        zza();
        zzg();
        if (!z7) {
            return this.zza;
        }
        zziq zziqVar = this.zza;
        if (zziqVar != null) {
            return zziqVar;
        }
        return this.zzh;
    }

    @VisibleForTesting
    final String zzl(Class cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        if (length > 0) {
            str2 = split[length - 1];
        } else {
            str2 = "";
        }
        int length2 = str2.length();
        this.zzs.zzf();
        if (length2 > 100) {
            this.zzs.zzf();
            return str2.substring(0, 100);
        }
        return str2;
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzs.zzf().zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zziq(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(Name.MARK)));
    }

    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (!this.zzs.zzf().zzu()) {
            return;
        }
        this.zzd.remove(activity);
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        if (!this.zzs.zzf().zzu()) {
            this.zzb = null;
            this.zzs.zzaz().zzp(new zziv(this, elapsedRealtime));
            return;
        }
        zziq zzz = zzz(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        this.zzs.zzaz().zzp(new zziw(this, zzz, elapsedRealtime));
    }

    public final void zzu(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzs.zzf().zzu()) {
                    this.zzg = null;
                    this.zzs.zzaz().zzp(new zzix(this));
                }
            }
        }
        if (!this.zzs.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzs.zzaz().zzp(new zziu(this));
            return;
        }
        zzA(activity, zzz(activity), false);
        zzd zzd = this.zzs.zzd();
        zzd.zzs.zzaz().zzp(new zzc(zzd, zzd.zzs.zzav().elapsedRealtime()));
    }

    public final void zzv(Activity activity, Bundle bundle) {
        zziq zziqVar;
        if (!this.zzs.zzf().zzu() || bundle == null || (zziqVar = (zziq) this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(Name.MARK, zziqVar.zzc);
        bundle2.putString("name", zziqVar.zza);
        bundle2.putString("referrer_name", zziqVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        if (r5.length() <= 100) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
        if (r6.length() <= 100) goto L36;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzw(@androidx.annotation.NonNull android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzu()
            if (r0 != 0) goto L1c
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L1c:
            com.google.android.gms.measurement.internal.zziq r0 = r3.zzb
            if (r0 != 0) goto L30
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L30:
            java.util.Map r1 = r3.zzd
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L48
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L48:
            if (r6 != 0) goto L54
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.zzl(r6, r1)
        L54:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzir.zza(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzir.zza(r0, r5)
            if (r1 == 0) goto L75
            if (r0 != 0) goto L65
            goto L75
        L65:
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L75:
            r0 = 100
            if (r5 == 0) goto La3
            int r1 = r5.length()
            if (r1 <= 0) goto L8b
            com.google.android.gms.measurement.internal.zzge r1 = r3.zzs
            r1.zzf()
            int r1 = r5.length()
            if (r1 > r0) goto L8b
            goto La3
        L8b:
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzl()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        La3:
            if (r6 == 0) goto Lcf
            int r1 = r6.length()
            if (r1 <= 0) goto Lb7
            com.google.android.gms.measurement.internal.zzge r1 = r3.zzs
            r1.zzf()
            int r1 = r6.length()
            if (r1 > r0) goto Lb7
            goto Lcf
        Lb7:
            com.google.android.gms.measurement.internal.zzge r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzl()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        Lcf:
            com.google.android.gms.measurement.internal.zzge r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzj()
            if (r5 != 0) goto Lde
            java.lang.String r1 = "null"
            goto Ldf
        Lde:
            r1 = r5
        Ldf:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zziq r0 = new com.google.android.gms.measurement.internal.zziq
            com.google.android.gms.measurement.internal.zzge r1 = r3.zzs
            com.google.android.gms.measurement.internal.zzln r1 = r1.zzv()
            long r1 = r1.zzq()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.zzd
            r5.put(r4, r0)
            r5 = 1
            r3.zzA(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r2 > 100) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        if (r4 > 100) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zzx(android.os.Bundle, long):void");
    }

    public final void zzy(String str, zziq zziqVar) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zziqVar != null) {
                this.zzl = str;
                this.zzk = zziqVar;
            }
        }
    }
}
