package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.AFc1uSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFa1bSDK implements AFc1wSDK {
    static String AFKeystoreWrapper;
    static Boolean values;
    private final AFc1sSDK valueOf;

    public AFa1bSDK() {
    }

    public AFa1bSDK(AFc1sSDK aFc1sSDK) {
        Intrinsics.f(aFc1sSDK, "");
        this.valueOf = aFc1sSDK;
    }

    private File AFInAppEventType() {
        Context context = this.valueOf.AFKeystoreWrapper;
        if (context != null) {
            File file = new File(context.getFilesDir(), "AFExceptionsCache");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    private File afRDLog() {
        File AFInAppEventType = AFInAppEventType();
        if (AFInAppEventType != null) {
            File file = new File(AFInAppEventType, "6.10.2");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.appsflyer.internal.AFc1oSDK.AFa1xSDK valueOf(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = com.appsflyer.internal.AFa1bSDK.AFKeystoreWrapper
            r2 = 1
            if (r1 == 0) goto Lb
            r3 = 1
            goto Lc
        Lb:
            r3 = 0
        Lc:
            r4 = 0
            if (r3 == 0) goto L11
        Lf:
            r5 = r4
            goto L53
        L11:
            java.lang.Boolean r1 = com.appsflyer.internal.AFa1bSDK.values
            if (r1 == 0) goto L1b
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L27
        L1b:
            java.lang.Boolean r1 = com.appsflyer.internal.AFa1bSDK.values
            if (r1 != 0) goto L51
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L51
        L27:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch: java.lang.Throwable -> L46
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L46
            boolean r5 = r0.isEnableLog()     // Catch: java.lang.Throwable -> L46
            r1.setLogging(r5)     // Catch: java.lang.Throwable -> L46
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch: java.lang.Throwable -> L46
            if (r5 == 0) goto L51
            java.lang.String r0 = r5.getId()     // Catch: java.lang.Throwable -> L46
            java.lang.Boolean r5 = r5.getLat()     // Catch: java.lang.Throwable -> L43
            r1 = r0
            goto L53
        L43:
            r5 = move-exception
            r1 = r0
            goto L48
        L46:
            r5 = move-exception
            r1 = r4
        L48:
            java.lang.String r0 = "No OAID library"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto Lf
        L51:
            r5 = r4
            r1 = r5
        L53:
            if (r1 == 0) goto L61
            com.appsflyer.internal.AFc1oSDK$AFa1xSDK r0 = new com.appsflyer.internal.AFc1oSDK$AFa1xSDK
            r0.<init>(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r0.AFInAppEventType = r5
            return r0
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.valueOf(android.content.Context):com.appsflyer.internal.AFc1oSDK$AFa1xSDK");
    }

    public static AFc1oSDK.AFa1xSDK values(ContentResolver contentResolver) {
        String str;
        if (valueOf() && contentResolver != null && AppsFlyerProperties.getInstance().getString("amazon_aid") == null && "Amazon".equals(Build.MANUFACTURER)) {
            int i8 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
            if (i8 == 0) {
                return new AFc1oSDK.AFa1xSDK(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
            }
            if (i8 == 2) {
                return null;
            }
            try {
                str = Settings.Secure.getString(contentResolver, "advertising_id");
            } catch (Throwable th) {
                AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                str = "";
            }
            return new AFc1oSDK.AFa1xSDK(str, Boolean.TRUE);
        }
        return null;
    }

    @Override // com.appsflyer.internal.AFc1wSDK
    public final int AFInAppEventParameterName() {
        int i8 = 0;
        for (AFc1uSDK aFc1uSDK : AFKeystoreWrapper()) {
            i8 += aFc1uSDK.AFKeystoreWrapper;
        }
        return i8;
    }

    @Override // com.appsflyer.internal.AFc1wSDK
    public final List<AFc1uSDK> AFKeystoreWrapper() {
        List<AFc1uSDK> list;
        File[] listFiles;
        String c8;
        synchronized (this) {
            File afRDLog = afRDLog();
            list = null;
            if (afRDLog != null && (listFiles = afRDLog.listFiles()) != null) {
                Intrinsics.e(listFiles, "");
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    AFc1uSDK.AFa1xSDK aFa1xSDK = AFc1uSDK.AFa1xSDK;
                    Intrinsics.e(file, "");
                    c8 = FilesKt__FileReadWriteKt.c(file, null, 1, null);
                    AFc1uSDK AFInAppEventType = AFc1uSDK.AFa1xSDK.AFInAppEventType(c8);
                    if (AFInAppEventType != null) {
                        arrayList.add(AFInAppEventType);
                    }
                }
                list = arrayList;
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.k();
            }
        }
        return list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cd, code lost:
        if (((java.lang.Boolean) r15).booleanValue() != false) goto L38;
     */
    @Override // com.appsflyer.internal.AFc1wSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean AFInAppEventType(java.lang.String... r15) {
        /*
            r14 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.f(r15, r0)
            monitor-enter(r14)
            java.io.File r0 = r14.AFInAppEventType()     // Catch: java.lang.Throwable -> Ld2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lcf
            int r3 = r15.length     // Catch: java.lang.Throwable -> Ld2
            if (r3 != 0) goto L13
            r3 = 1
            goto L14
        L13:
            r3 = 0
        L14:
            if (r3 == 0) goto L2c
            java.lang.String r15 = "delete all exceptions"
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.f(r15, r1)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r1 = "[Exception Manager]: "
            java.lang.String r15 = r1.concat(r15)     // Catch: java.lang.Throwable -> Ld2
            com.appsflyer.AFLogger.afRDLog(r15)     // Catch: java.lang.Throwable -> Ld2
            boolean r1 = kotlin.io.FilesKt.j(r0)     // Catch: java.lang.Throwable -> Ld2
            goto Ld0
        L2c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r4 = "delete all exceptions except for: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r6 = ", "
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 62
            r13 = 0
            r5 = r15
            java.lang.String r4 = kotlin.collections.ArraysKt.T(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> Ld2
            r3.append(r4)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.f(r3, r4)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r4 = "[Exception Manager]: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r3 = r4.concat(r3)     // Catch: java.lang.Throwable -> Ld2
            com.appsflyer.AFLogger.afRDLog(r3)     // Catch: java.lang.Throwable -> Ld2
            java.io.File[] r0 = r0.listFiles()     // Catch: java.lang.Throwable -> Ld2
            if (r0 == 0) goto Lcf
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.e(r0, r3)     // Catch: java.lang.Throwable -> Ld2
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ld2
            r3.<init>()     // Catch: java.lang.Throwable -> Ld2
            int r4 = r0.length     // Catch: java.lang.Throwable -> Ld2
            r5 = 0
        L6d:
            if (r5 >= r4) goto L81
            r6 = r0[r5]     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r7 = r6.getName()     // Catch: java.lang.Throwable -> Ld2
            boolean r7 = kotlin.collections.ArraysKt.z(r15, r7)     // Catch: java.lang.Throwable -> Ld2
            if (r7 != 0) goto L7e
            r3.add(r6)     // Catch: java.lang.Throwable -> Ld2
        L7e:
            int r5 = r5 + 1
            goto L6d
        L81:
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Ld2
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.v(r3, r0)     // Catch: java.lang.Throwable -> Ld2
            r15.<init>(r0)     // Catch: java.lang.Throwable -> Ld2
            java.util.Iterator r0 = r3.iterator()     // Catch: java.lang.Throwable -> Ld2
        L90:
            boolean r3 = r0.hasNext()     // Catch: java.lang.Throwable -> Ld2
            if (r3 == 0) goto Lad
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Throwable -> Ld2
            java.io.File r3 = (java.io.File) r3     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.e(r3, r4)     // Catch: java.lang.Throwable -> Ld2
            boolean r3 = kotlin.io.FilesKt.j(r3)     // Catch: java.lang.Throwable -> Ld2
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> Ld2
            r15.add(r3)     // Catch: java.lang.Throwable -> Ld2
            goto L90
        Lad:
            java.util.Set r15 = kotlin.collections.CollectionsKt.L0(r15)     // Catch: java.lang.Throwable -> Ld2
            boolean r0 = r15.isEmpty()     // Catch: java.lang.Throwable -> Ld2
            if (r0 == 0) goto Lbd
            java.lang.Boolean r15 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Ld2
            java.util.Set r15 = kotlin.collections.SetsKt.a(r15)     // Catch: java.lang.Throwable -> Ld2
        Lbd:
            int r0 = r15.size()     // Catch: java.lang.Throwable -> Ld2
            if (r0 != r2) goto Ld0
            java.lang.Object r15 = kotlin.collections.CollectionsKt.V(r15)     // Catch: java.lang.Throwable -> Ld2
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch: java.lang.Throwable -> Ld2
            boolean r15 = r15.booleanValue()     // Catch: java.lang.Throwable -> Ld2
            if (r15 == 0) goto Ld0
        Lcf:
            r1 = 1
        Ld0:
            monitor-exit(r14)
            return r1
        Ld2:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFInAppEventType(java.lang.String[]):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
        if (r8.length() == 0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.appsflyer.internal.AFc1oSDK.AFa1xSDK values(android.content.Context r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.values(android.content.Context, java.util.Map):com.appsflyer.internal.AFc1oSDK$AFa1xSDK");
    }

    private static boolean valueOf() {
        Boolean bool = values;
        return bool == null || bool.booleanValue();
    }

    @Override // com.appsflyer.internal.AFc1wSDK
    public final String values(Throwable th, String str) {
        String str2;
        String f02;
        String b8;
        String c8;
        Intrinsics.f(th, "");
        Intrinsics.f(str, "");
        synchronized (this) {
            File afRDLog = afRDLog();
            str2 = null;
            if (afRDLog != null) {
                try {
                    Intrinsics.f(th, "");
                    Intrinsics.f(str, "");
                    StringBuilder sb = new StringBuilder();
                    Intrinsics.f(th, "");
                    String name = th.getClass().getName();
                    Intrinsics.e(name, "");
                    sb.append(name);
                    sb.append(": ");
                    sb.append(str);
                    String obj = sb.toString();
                    Intrinsics.f(th, "");
                    Intrinsics.f(th, "");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(th);
                    sb2.append('\n');
                    f02 = CollectionsKt___CollectionsKt.f0(AFc1lSDK.AFKeystoreWrapper(th), "\n", null, null, 0, null, new Function1<StackTraceElement, CharSequence>() { // from class: com.appsflyer.internal.AFc1lSDK.1
                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: values */
                        public final CharSequence invoke(StackTraceElement stackTraceElement) {
                            Intrinsics.f(stackTraceElement, "");
                            return "at ".concat(String.valueOf(stackTraceElement));
                        }
                    }, 30, null);
                    sb2.append(f02);
                    String valueOf = AFc1oSDK.AFa1xSDK.valueOf(sb2.toString());
                    b8 = ExceptionsKt__ExceptionsKt.b(th);
                    AFc1uSDK aFc1uSDK = new AFc1uSDK(obj, valueOf, b8, 0, 8, null);
                    String str3 = aFc1uSDK.AFInAppEventParameterName;
                    File file = new File(afRDLog, str3);
                    if (file.exists()) {
                        c8 = FilesKt__FileReadWriteKt.c(file, null, 1, null);
                        AFc1uSDK AFInAppEventType = AFc1uSDK.AFa1xSDK.AFInAppEventType(c8);
                        if (AFInAppEventType != null) {
                            AFInAppEventType.AFKeystoreWrapper++;
                            aFc1uSDK = AFInAppEventType;
                        }
                    }
                    StringBuilder sb3 = new StringBuilder("label=");
                    sb3.append(AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(aFc1uSDK.valueOf));
                    sb3.append("\nhashName=");
                    sb3.append(AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(aFc1uSDK.AFInAppEventParameterName));
                    sb3.append("\nstackTrace=");
                    sb3.append(AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(aFc1uSDK.values));
                    sb3.append("\nc=");
                    sb3.append(aFc1uSDK.AFKeystoreWrapper);
                    FilesKt__FileReadWriteKt.f(file, sb3.toString(), null, 2, null);
                    str2 = str3;
                } catch (Exception e8) {
                    StringBuilder sb4 = new StringBuilder("Could not cache exception\n");
                    StringBuilder sb5 = new StringBuilder(" ");
                    sb5.append(e8.getMessage());
                    String obj2 = sb5.toString();
                    Intrinsics.f(obj2, "");
                    sb4.append("[Exception Manager]: ".concat(String.valueOf(obj2)));
                    AFLogger.afRDLog(sb4.toString());
                }
            }
        }
        return str2;
    }

    @Override // com.appsflyer.internal.AFc1wSDK
    public final boolean values() {
        return AFInAppEventType(new String[0]);
    }
}
