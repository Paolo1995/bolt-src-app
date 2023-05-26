package com.google.android.gms.internal.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public abstract class zzcz<T> {
    public static final /* synthetic */ int zzd = 0;
    @Nullable
    private static volatile zzcy zze = null;
    private static volatile boolean zzf = false;
    final zzcx zzb;
    final String zzc;
    private final T zzj;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;
    private static final Object zza = new Object();
    private static final AtomicReference<Collection<zzcz<?>>> zzg = new AtomicReference<>();
    private static final zzdb zzh = new zzdb(new Object() { // from class: com.google.android.gms.internal.auth.zzcr
    }, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ zzcz(zzcx zzcxVar, String str, Object obj, boolean z7, zzct zzctVar) {
        if (zzcxVar.zzb != null) {
            this.zzb = zzcxVar;
            this.zzc = str;
            this.zzj = obj;
            this.zzm = true;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd() {
        zzi.incrementAndGet();
    }

    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zza;
            synchronized (obj) {
                if (zze == null) {
                    synchronized (obj) {
                        zzcy zzcyVar = zze;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zzcyVar == null || zzcyVar.zza() != context) {
                            zzcg.zzd();
                            zzda.zzc();
                            zzcn.zze();
                            zze = new zzcd(context, zzdk.zza(new zzdg() { // from class: com.google.android.gms.internal.auth.zzcs
                                @Override // com.google.android.gms.internal.auth.zzdg
                                public final Object zza() {
                                    zzde zzc;
                                    zzde zzc2;
                                    String str;
                                    boolean isDeviceProtectedStorage;
                                    Context context2 = context;
                                    int i8 = zzcz.zzd;
                                    String str2 = Build.TYPE;
                                    String str3 = Build.TAGS;
                                    if ((!str2.equals("eng") && !str2.equals("userdebug")) || (!str3.contains("dev-keys") && !str3.contains("test-keys"))) {
                                        return zzde.zzc();
                                    }
                                    if (zzcc.zza()) {
                                        isDeviceProtectedStorage = context2.isDeviceProtectedStorage();
                                        if (!isDeviceProtectedStorage) {
                                            context2 = context2.createDeviceProtectedStorageContext();
                                        }
                                    }
                                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                                    try {
                                        StrictMode.allowThreadDiskWrites();
                                        try {
                                            File file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                                            if (file.exists()) {
                                                zzc = zzde.zzd(file);
                                            } else {
                                                zzc = zzde.zzc();
                                            }
                                        } catch (RuntimeException e8) {
                                            Log.e("HermeticFileOverrides", "no data dir", e8);
                                            zzc = zzde.zzc();
                                        }
                                        if (zzc.zzb()) {
                                            File file2 = (File) zzc.zza();
                                            try {
                                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                                try {
                                                    HashMap hashMap = new HashMap();
                                                    HashMap hashMap2 = new HashMap();
                                                    while (true) {
                                                        String readLine = bufferedReader.readLine();
                                                        if (readLine == null) {
                                                            break;
                                                        }
                                                        String[] split = readLine.split(" ", 3);
                                                        if (split.length != 3) {
                                                            if (readLine.length() != 0) {
                                                                str = "Invalid: ".concat(readLine);
                                                            } else {
                                                                str = new String("Invalid: ");
                                                            }
                                                            Log.e("HermeticFileOverrides", str);
                                                        } else {
                                                            String str4 = new String(split[0]);
                                                            String decode = Uri.decode(new String(split[1]));
                                                            String str5 = (String) hashMap2.get(split[2]);
                                                            if (str5 == null) {
                                                                String str6 = new String(split[2]);
                                                                str5 = Uri.decode(str6);
                                                                if (str5.length() < 1024 || str5 == str6) {
                                                                    hashMap2.put(str6, str5);
                                                                }
                                                            }
                                                            if (!hashMap.containsKey(str4)) {
                                                                hashMap.put(str4, new HashMap());
                                                            }
                                                            ((Map) hashMap.get(str4)).put(decode, str5);
                                                        }
                                                    }
                                                    String valueOf = String.valueOf(file2);
                                                    StringBuilder sb = new StringBuilder(valueOf.length() + 7);
                                                    sb.append("Parsed ");
                                                    sb.append(valueOf);
                                                    Log.i("HermeticFileOverrides", sb.toString());
                                                    zzco zzcoVar = new zzco(hashMap);
                                                    bufferedReader.close();
                                                    zzc2 = zzde.zzd(zzcoVar);
                                                } catch (Throwable th) {
                                                    try {
                                                        bufferedReader.close();
                                                    } catch (Throwable th2) {
                                                        th.addSuppressed(th2);
                                                    }
                                                    throw th;
                                                }
                                            } catch (IOException e9) {
                                                throw new RuntimeException(e9);
                                            }
                                        } else {
                                            zzc2 = zzde.zzc();
                                        }
                                        return zzc2;
                                    } finally {
                                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                                    }
                                }
                            }));
                            zzi.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    abstract T zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[Catch: all -> 0x011c, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003b, B:20:0x0047, B:22:0x0050, B:24:0x0062, B:26:0x006d, B:25:0x0067, B:53:0x00e4, B:55:0x00f4, B:57:0x0108, B:58:0x010b, B:59:0x010f, B:41:0x00bc, B:43:0x00c2, B:47:0x00d4, B:49:0x00da, B:52:0x00e2, B:46:0x00d2, B:28:0x0072, B:30:0x0078, B:32:0x0086, B:36:0x00ab, B:38:0x00b5, B:34:0x009d, B:60:0x0114, B:61:0x0119, B:62:0x011a), top: B:69:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e2 A[Catch: all -> 0x011c, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003b, B:20:0x0047, B:22:0x0050, B:24:0x0062, B:26:0x006d, B:25:0x0067, B:53:0x00e4, B:55:0x00f4, B:57:0x0108, B:58:0x010b, B:59:0x010f, B:41:0x00bc, B:43:0x00c2, B:47:0x00d4, B:49:0x00da, B:52:0x00e2, B:46:0x00d2, B:28:0x0072, B:30:0x0078, B:32:0x0086, B:36:0x00ab, B:38:0x00b5, B:34:0x009d, B:60:0x0114, B:61:0x0119, B:62:0x011a), top: B:69:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4 A[Catch: all -> 0x011c, TryCatch #0 {, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x003b, B:20:0x0047, B:22:0x0050, B:24:0x0062, B:26:0x006d, B:25:0x0067, B:53:0x00e4, B:55:0x00f4, B:57:0x0108, B:58:0x010b, B:59:0x010f, B:41:0x00bc, B:43:0x00c2, B:47:0x00d4, B:49:0x00da, B:52:0x00e2, B:46:0x00d2, B:28:0x0072, B:30:0x0078, B:32:0x0086, B:36:0x00ab, B:38:0x00b5, B:34:0x009d, B:60:0x0114, B:61:0x0119, B:62:0x011a), top: B:69:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T zzb() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcz.zzb():java.lang.Object");
    }

    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }
}
