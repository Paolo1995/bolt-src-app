package com.appsflyer.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes.dex */
public final class AFc1lSDK implements AFb1zSDK {
    private final AFc1sSDK valueOf;

    AFc1lSDK() {
    }

    public AFc1lSDK(AFc1sSDK aFc1sSDK) {
        this.valueOf = aFc1sSDK;
    }

    public static Map<String, String> AFInAppEventType(Context context) {
        HashMap hashMap = new HashMap();
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
            hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
            hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            hashMap.put("size", String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
            hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
            hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't aggregate screen stats: ", th);
        }
        return hashMap;
    }

    public static final List<StackTraceElement> AFKeystoreWrapper(Throwable th) {
        boolean L;
        Intrinsics.f(th, "");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.e(stackTrace, "");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.e(className, "");
            L = StringsKt__StringsJVMKt.L(className, "com.appsflyer", false, 2, null);
            if (!L) {
                stackTraceElement = null;
            }
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.appsflyer.internal.AFa1oSDK valueOf(java.io.File r5) {
        /*
            java.lang.String r0 = "could not close load reader"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            long r3 = r5.length()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            int r4 = (int) r3     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            char[] r3 = new char[r4]     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            r2.read(r3)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            com.appsflyer.internal.AFa1oSDK r4 = new com.appsflyer.internal.AFa1oSDK     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            r4.<init>(r3)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            r4.AFInAppEventType = r5     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L3c
            r2.close()     // Catch: java.io.IOException -> L21
            goto L25
        L21:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L25:
            return r4
        L26:
            r5 = move-exception
            goto L2c
        L28:
            r5 = move-exception
            goto L3e
        L2a:
            r5 = move-exception
            r2 = r1
        L2c:
            java.lang.String r3 = "error while loading request from cache"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r5)     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L3b
            r2.close()     // Catch: java.io.IOException -> L37
            goto L3b
        L37:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L3b:
            return r1
        L3c:
            r5 = move-exception
            r1 = r2
        L3e:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r1 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L48:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.valueOf(java.io.File):com.appsflyer.internal.AFa1oSDK");
    }

    @Override // com.appsflyer.internal.AFb1zSDK
    public final void values() {
        try {
            File file = new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                StringBuilder sb = new StringBuilder("CACHE: Found cached request");
                sb.append(file2.getName());
                AFLogger.afInfoLog(sb.toString());
                StringBuilder sb2 = new StringBuilder("CACHE: Deleting ");
                sb2.append(file2.getName());
                sb2.append(" from cache");
                AFLogger.afInfoLog(sb2.toString());
                file2.delete();
            }
        } catch (Exception e8) {
            AFLogger.afErrorLog("CACHE: Could not cache request", e8);
        }
    }

    @Override // com.appsflyer.internal.AFb1zSDK
    @NonNull
    public final List<AFa1oSDK> AFKeystoreWrapper() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            }
            listFiles = file.listFiles();
        } catch (Exception e8) {
            AFLogger.afErrorLog("CACHE: Could not get cached requests", e8);
        }
        if (listFiles == null) {
            return arrayList;
        }
        for (File file2 : listFiles) {
            StringBuilder sb = new StringBuilder("CACHE: Found cached request");
            sb.append(file2.getName());
            AFLogger.afInfoLog(sb.toString());
            arrayList.add(valueOf(file2));
        }
        return arrayList;
    }

    @Override // com.appsflyer.internal.AFb1zSDK
    public final void AFInAppEventType() {
        try {
            if (new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache").exists()) {
                return;
            }
            new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache").mkdir();
        } catch (Exception e8) {
            AFLogger.afErrorLog("CACHE: Could not create cache directory", e8);
        }
    }

    @Override // com.appsflyer.internal.AFb1zSDK
    public final boolean AFKeystoreWrapper(String str) {
        File file = new File(new File(this.valueOf.AFKeystoreWrapper.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("CACHE: Deleting ");
        sb.append(str);
        sb.append(" from cache");
        AFLogger.afInfoLog(sb.toString());
        if (file.exists()) {
            try {
                return file.delete();
            } catch (Exception e8) {
                StringBuilder sb2 = new StringBuilder("CACHE: Could not delete ");
                sb2.append(str);
                sb2.append(" from cache");
                AFLogger.afErrorLog(sb2.toString(), e8);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.appsflyer.internal.AFb1zSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String AFInAppEventType(com.appsflyer.internal.AFa1oSDK r8) {
        /*
            r7 = this;
            java.lang.String r0 = "AFRequestCache"
            java.lang.String r1 = "could not close cache writer"
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            com.appsflyer.internal.AFc1sSDK r4 = r7.valueOf     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            android.content.Context r4 = r4.AFKeystoreWrapper     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            if (r4 != 0) goto L1c
            r3.mkdir()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            return r2
        L1c:
            java.io.File[] r3 = r3.listFiles()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            if (r3 == 0) goto L2d
            int r3 = r3.length     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r4 = 40
            if (r3 <= r4) goto L2d
            java.lang.String r8 = "CACHE: reached cache limit, not caching request"
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            return r2
        L2d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.lang.String r4 = "CACHE: caching request with URL: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.lang.String r4 = r8.values     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r3.append(r4)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            com.appsflyer.internal.AFc1sSDK r6 = r7.valueOf     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            android.content.Context r6 = r6.AFKeystoreWrapper     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.io.File r6 = r6.getFilesDir()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r5.<init>(r6, r0)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r4.createNewFile()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.lang.String r4 = r4.getPath()     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r6 = 1
            r5.<init>(r4, r6)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            r0.<init>(r5)     // Catch: java.lang.Throwable -> Lca java.lang.Exception -> Lcc
            java.lang.String r4 = "version="
            r0.write(r4)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            java.lang.String r4 = r8.AFInAppEventParameterName     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.write(r4)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r4 = 10
            r0.write(r4)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            java.lang.String r5 = "url="
            r0.write(r5)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            java.lang.String r5 = r8.values     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.write(r5)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.write(r4)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            java.lang.String r5 = "data="
            r0.write(r5)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            byte[] r5 = r8.valueOf()     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r6 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.write(r5)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.write(r4)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            com.appsflyer.internal.AFd1rSDK r8 = r8.valueOf     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            if (r8 == 0) goto Laf
            java.lang.String r5 = "type="
            r0.write(r5)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            java.lang.String r8 = r8.name()     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.write(r8)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.write(r4)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
        Laf:
            r0.flush()     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            java.lang.String r8 = "CACHE: done, cacheKey: "
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            java.lang.String r8 = r8.concat(r4)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch: java.lang.Exception -> Lc8 java.lang.Throwable -> Lde
            r0.close()     // Catch: java.io.IOException -> Lc3
            goto Lc7
        Lc3:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        Lc7:
            return r3
        Lc8:
            r8 = move-exception
            goto Lce
        Lca:
            r8 = move-exception
            goto Le0
        Lcc:
            r8 = move-exception
            r0 = r2
        Lce:
            java.lang.String r3 = "CACHE: Could not cache request"
            com.appsflyer.AFLogger.afErrorLog(r3, r8)     // Catch: java.lang.Throwable -> Lde
            if (r0 == 0) goto Ldd
            r0.close()     // Catch: java.io.IOException -> Ld9
            goto Ldd
        Ld9:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        Ldd:
            return r2
        Lde:
            r8 = move-exception
            r2 = r0
        Le0:
            if (r2 == 0) goto Lea
            r2.close()     // Catch: java.io.IOException -> Le6
            goto Lea
        Le6:
            r0 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r0)
        Lea:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.AFInAppEventType(com.appsflyer.internal.AFa1oSDK):java.lang.String");
    }
}
