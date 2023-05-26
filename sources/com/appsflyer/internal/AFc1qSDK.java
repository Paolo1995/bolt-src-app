package com.appsflyer.internal;

import android.os.Build;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFc1oSDK;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFc1qSDK implements AFc1nSDK {
    private static int[] AFLogger = {84034794, 1147463978, 1355501688, -1498289662, 1398696191, -692224148, 74284621, 393338626, 55061909, -312637553, 1399769626, -1380028196, -1350300435, 384163972, -248694641, -1057661601, -1354286904, -696761256};
    private static int AFVersionDeclaration = 0;
    private static int afErrorLogForExcManagerOnly = 1;
    private final Lazy AFInAppEventParameterName;
    private final Lazy AFInAppEventType;
    private final Lazy AFKeystoreWrapper;
    private final Lazy afDebugLog;
    private final String afErrorLog;
    private final Lazy afInfoLog;
    private final Lazy afRDLog;
    private AFc1vSDK valueOf;
    private final Lazy values;

    public AFc1qSDK(AFc1vSDK aFc1vSDK) {
        Lazy b8;
        Lazy b9;
        Lazy b10;
        Lazy b11;
        Lazy b12;
        Lazy b13;
        Lazy b14;
        Intrinsics.f(aFc1vSDK, "");
        this.valueOf = aFc1vSDK;
        b8 = LazyKt__LazyJVMKt.b(new Function0<AFb1rSDK>() { // from class: com.appsflyer.internal.AFc1qSDK.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: valueOf */
            public final AFb1rSDK invoke() {
                AFb1rSDK afRDLog = AFc1qSDK.AFKeystoreWrapper(AFc1qSDK.this).afRDLog();
                Intrinsics.e(afRDLog, "");
                return afRDLog;
            }
        });
        this.AFKeystoreWrapper = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<AFc1zSDK>() { // from class: com.appsflyer.internal.AFc1qSDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFInAppEventType */
            public final AFc1zSDK invoke() {
                AFc1zSDK values = AFc1qSDK.AFKeystoreWrapper(AFc1qSDK.this).values();
                Intrinsics.e(values, "");
                return values;
            }
        });
        this.AFInAppEventType = b9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<AFc1ySDK>() { // from class: com.appsflyer.internal.AFc1qSDK.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFKeystoreWrapper */
            public final AFc1ySDK invoke() {
                AFc1ySDK afInfoLog = AFc1qSDK.AFKeystoreWrapper(AFc1qSDK.this).afInfoLog();
                Intrinsics.e(afInfoLog, "");
                return afInfoLog;
            }
        });
        this.values = b10;
        b11 = LazyKt__LazyJVMKt.b(new Function0<AFe1nSDK>() { // from class: com.appsflyer.internal.AFc1qSDK.9
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: valueOf */
            public final AFe1nSDK invoke() {
                AFe1nSDK level = AFc1qSDK.AFKeystoreWrapper(AFc1qSDK.this).getLevel();
                Intrinsics.e(level, "");
                return level;
            }
        });
        this.AFInAppEventParameterName = b11;
        b12 = LazyKt__LazyJVMKt.b(new Function0<ExecutorService>() { // from class: com.appsflyer.internal.AFc1qSDK.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: valueOf */
            public final ExecutorService invoke() {
                ExecutorService AFKeystoreWrapper = AFc1qSDK.AFKeystoreWrapper(AFc1qSDK.this).AFKeystoreWrapper();
                Intrinsics.e(AFKeystoreWrapper, "");
                return AFKeystoreWrapper;
            }
        });
        this.afDebugLog = b12;
        this.afErrorLog = "6.10.2";
        b13 = LazyKt__LazyJVMKt.b(new Function0<AFa1bSDK>() { // from class: com.appsflyer.internal.AFc1qSDK.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFInAppEventType */
            public final AFa1bSDK invoke() {
                AFc1sSDK AFLogger$LogLevel = AFc1qSDK.AFKeystoreWrapper(AFc1qSDK.this).AFLogger$LogLevel();
                Intrinsics.e(AFLogger$LogLevel, "");
                return new AFa1bSDK(AFLogger$LogLevel);
            }
        });
        this.afInfoLog = b13;
        b14 = LazyKt__LazyJVMKt.b(new Function0<AFa1cSDK>() { // from class: com.appsflyer.internal.AFc1qSDK.6
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFInAppEventParameterName */
            public final AFa1cSDK invoke() {
                return new AFa1cSDK(AFc1qSDK.this.AFKeystoreWrapper());
            }
        });
        this.afRDLog = b14;
    }

    private final AFb1rSDK AFInAppEventParameterName() {
        int i8 = AFVersionDeclaration + 77;
        afErrorLogForExcManagerOnly = i8 % 128;
        if ((i8 % 2 == 0 ? '`' : '2') != '`') {
            return (AFb1rSDK) this.AFKeystoreWrapper.getValue();
        }
        int i9 = 38 / 0;
        return (AFb1rSDK) this.AFKeystoreWrapper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFInAppEventType(AFc1qSDK aFc1qSDK) {
        int i8 = AFVersionDeclaration + 67;
        afErrorLogForExcManagerOnly = i8 % 128;
        int i9 = i8 % 2;
        Intrinsics.f(aFc1qSDK, "");
        aFc1qSDK.AFLogger$LogLevel();
        int i10 = afErrorLogForExcManagerOnly + 67;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    public static final /* synthetic */ AFc1vSDK AFKeystoreWrapper(AFc1qSDK aFc1qSDK) {
        int i8 = AFVersionDeclaration;
        int i9 = i8 + 29;
        afErrorLogForExcManagerOnly = i9 % 128;
        int i10 = i9 % 2;
        AFc1vSDK aFc1vSDK = aFc1qSDK.valueOf;
        int i11 = i8 + 35;
        afErrorLogForExcManagerOnly = i11 % 128;
        if (i11 % 2 == 0) {
            throw null;
        }
        return aFc1vSDK;
    }

    private final AFe1nSDK AFLogger() {
        int i8 = AFVersionDeclaration + 109;
        afErrorLogForExcManagerOnly = i8 % 128;
        int i9 = i8 % 2;
        AFe1nSDK aFe1nSDK = (AFe1nSDK) this.AFInAppEventParameterName.getValue();
        int i10 = AFVersionDeclaration + 43;
        afErrorLogForExcManagerOnly = i10 % 128;
        int i11 = i10 % 2;
        return aFe1nSDK;
    }

    private final synchronized void AFLogger$LogLevel() {
        long j8;
        char c8;
        boolean z7;
        int i8 = afErrorLogForExcManagerOnly + 39;
        AFVersionDeclaration = i8 % 128;
        String str = null;
        if (i8 % 2 == 0) {
            AFb1qSDK afWarnLog = afWarnLog();
            if (afWarnLog != null) {
                j8 = afWarnLog.valueOf;
            } else {
                j8 = -1;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                AFb1qSDK afWarnLog2 = afWarnLog();
                if (afWarnLog2 != null) {
                    int i9 = afErrorLogForExcManagerOnly + 109;
                    AFVersionDeclaration = i9 % 128;
                    if (i9 % 2 != 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7) {
                        str = afWarnLog2.values;
                    } else {
                        throw null;
                    }
                }
                if (str == null) {
                    int i10 = AFVersionDeclaration + 23;
                    afErrorLogForExcManagerOnly = i10 % 128;
                    int i11 = i10 % 2;
                    str = "";
                }
            } catch (NullPointerException unused) {
                str = "NOT_DETECTED";
            }
            if (j8 < currentTimeMillis) {
                c8 = ',';
            } else {
                c8 = '\b';
            }
            if (c8 != '\b') {
                Intrinsics.f("TTL is already passed", "");
                AFLogger.afRDLog("[Exception Manager]: ".concat("TTL is already passed"));
                afInfoLog().valueOf("af_send_exc_to_server_window");
                AFKeystoreWrapper().values();
                return;
            } else if (AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(str) != -1 && AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(str) <= AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(afErrorLog())) {
                AFKeystoreWrapper().AFInAppEventType(afErrorLog());
                return;
            } else {
                afInfoLog().valueOf("af_send_exc_to_server_window");
                AFKeystoreWrapper().values();
                return;
            }
        }
        afWarnLog();
        throw null;
    }

    private final void AFVersionDeclaration() {
        AFb1qSDK afWarnLog;
        boolean z7;
        int i8 = AFVersionDeclaration + 59;
        afErrorLogForExcManagerOnly = i8 % 128;
        boolean z8 = false;
        if (i8 % 2 == 0) {
            afWarnLog = afWarnLog();
            int i9 = 66 / 0;
            if (afWarnLog != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                return;
            }
        } else {
            afWarnLog = afWarnLog();
            if (afWarnLog == null) {
                return;
            }
        }
        if (AFKeystoreWrapper(afWarnLog)) {
            z8 = true;
        }
        if (!z8) {
            Intrinsics.f("skipping", "");
            AFLogger.afRDLog("[Exception Manager]: ".concat("skipping"));
            int i10 = afErrorLogForExcManagerOnly + 91;
            AFVersionDeclaration = i10 % 128;
            int i11 = i10 % 2;
            return;
        }
        int i12 = afErrorLogForExcManagerOnly + 47;
        AFVersionDeclaration = i12 % 128;
        int i13 = i12 % 2;
        String str = AFLogger().values;
        if (str != null) {
            String jSONObject = new JSONObject(values(AFInAppEventType(afWarnLog), AFKeystoreWrapper().AFKeystoreWrapper())).toString();
            Intrinsics.e(jSONObject, "");
            Intrinsics.e(str, "");
            values(jSONObject, str);
        }
    }

    private final AFc1zSDK afDebugLog() {
        char c8;
        int i8 = AFVersionDeclaration + 69;
        afErrorLogForExcManagerOnly = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = 6;
        } else {
            c8 = 'D';
        }
        if (c8 != 'D') {
            int i9 = 5 / 0;
            return (AFc1zSDK) this.AFInAppEventType.getValue();
        }
        return (AFc1zSDK) this.AFInAppEventType.getValue();
    }

    private String afErrorLog() {
        char c8;
        int i8 = AFVersionDeclaration + 119;
        afErrorLogForExcManagerOnly = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = '7';
        } else {
            c8 = 'b';
        }
        if (c8 != 'b') {
            int i9 = 25 / 0;
            return this.afErrorLog;
        }
        return this.afErrorLog;
    }

    private final synchronized void afErrorLogForExcManagerOnly() {
        AFb1qSDK afWarnLog = afWarnLog();
        boolean z7 = true;
        if (afWarnLog != null) {
            int i8 = afErrorLogForExcManagerOnly;
            int i9 = i8 + 25;
            AFVersionDeclaration = i9 % 128;
            if (i9 % 2 == 0) {
                z7 = false;
            }
            if (!z7) {
                if (afWarnLog.AFInAppEventType == -1) {
                    int i10 = i8 + 125;
                    AFVersionDeclaration = i10 % 128;
                    int i11 = i10 % 2;
                    afInfoLog().valueOf("af_send_exc_to_server_window");
                    return;
                }
                if (afInfoLog().AFInAppEventParameterName("af_send_exc_to_server_window", -1L) == -1) {
                    int i12 = AFVersionDeclaration + 101;
                    afErrorLogForExcManagerOnly = i12 % 128;
                    int i13 = i12 % 2;
                    int i14 = afWarnLog.AFInAppEventParameterName;
                    int i15 = afWarnLog.AFInAppEventType;
                    AFc1ySDK afInfoLog = afInfoLog();
                    afInfoLog.AFInAppEventType("af_send_exc_to_server_window", System.currentTimeMillis() + TimeUnit.DAYS.toMillis(i15));
                    afInfoLog.AFKeystoreWrapper("af_send_exc_min", i14);
                }
                return;
            }
            throw null;
        }
        int i16 = AFVersionDeclaration + 111;
        afErrorLogForExcManagerOnly = i16 % 128;
        if (i16 % 2 == 0) {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw null;
    }

    private final AFc1ySDK afInfoLog() {
        int i8 = afErrorLogForExcManagerOnly + 121;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        AFc1ySDK aFc1ySDK = (AFc1ySDK) this.values.getValue();
        int i10 = AFVersionDeclaration + 81;
        afErrorLogForExcManagerOnly = i10 % 128;
        int i11 = i10 % 2;
        return aFc1ySDK;
    }

    private final ExecutorService afRDLog() {
        char c8;
        int i8 = afErrorLogForExcManagerOnly + 79;
        AFVersionDeclaration = i8 % 128;
        if (i8 % 2 != 0) {
            c8 = 'B';
        } else {
            c8 = '$';
        }
        if (c8 != 'B') {
            return (ExecutorService) this.afDebugLog.getValue();
        }
        ExecutorService executorService = (ExecutorService) this.afDebugLog.getValue();
        throw null;
    }

    private final AFb1qSDK afWarnLog() {
        char c8;
        char c9;
        int i8 = afErrorLogForExcManagerOnly + 13;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        AFb1iSDK aFb1iSDK = AFInAppEventParameterName().AFInAppEventParameterName.valueOf;
        if (aFb1iSDK != null) {
            c8 = 22;
        } else {
            c8 = '\'';
        }
        if (c8 == 22) {
            AFb1mSDK aFb1mSDK = aFb1iSDK.AFInAppEventType;
            if (aFb1mSDK != null) {
                c9 = 'D';
            } else {
                c9 = 'S';
            }
            if (c9 != 'S') {
                int i10 = AFVersionDeclaration + 101;
                afErrorLogForExcManagerOnly = i10 % 128;
                int i11 = i10 % 2;
                AFb1qSDK aFb1qSDK = aFb1mSDK.AFKeystoreWrapper;
                if (i11 == 0) {
                    int i12 = 77 / 0;
                    return aFb1qSDK;
                }
                return aFb1qSDK;
            }
            return null;
        }
        return null;
    }

    private AFc1oSDK getLevel() {
        int i8 = afErrorLogForExcManagerOnly + 93;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        AFc1oSDK aFc1oSDK = (AFc1oSDK) this.afRDLog.getValue();
        int i10 = AFVersionDeclaration + 43;
        afErrorLogForExcManagerOnly = i10 % 128;
        int i11 = i10 % 2;
        return aFc1oSDK;
    }

    @Override // com.appsflyer.internal.AFc1nSDK
    public final void valueOf(final Throwable th, final String str) {
        int i8 = AFVersionDeclaration + 1;
        afErrorLogForExcManagerOnly = i8 % 128;
        if ((i8 % 2 == 0 ? 'S' : '\r') == 'S') {
            Intrinsics.f(th, "");
            Intrinsics.f(str, "");
            afRDLog().execute(new Runnable() { // from class: com.appsflyer.internal.n
                @Override // java.lang.Runnable
                public final void run() {
                    AFc1qSDK.AFInAppEventParameterName(AFc1qSDK.this, th, str);
                }
            });
            throw null;
        }
        Intrinsics.f(th, "");
        Intrinsics.f(str, "");
        afRDLog().execute(new Runnable() { // from class: com.appsflyer.internal.n
            @Override // java.lang.Runnable
            public final void run() {
                AFc1qSDK.AFInAppEventParameterName(AFc1qSDK.this, th, str);
            }
        });
        int i9 = AFVersionDeclaration + 93;
        afErrorLogForExcManagerOnly = i9 % 128;
        if ((i9 % 2 == 0 ? '8' : 'R') == 'R') {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFc1nSDK
    public final void values() {
        int i8 = afErrorLogForExcManagerOnly + 113;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        afRDLog().execute(new Runnable() { // from class: com.appsflyer.internal.m
            @Override // java.lang.Runnable
            public final void run() {
                AFc1qSDK.AFInAppEventType(AFc1qSDK.this);
            }
        });
        int i10 = AFVersionDeclaration + 71;
        afErrorLogForExcManagerOnly = i10 % 128;
        int i11 = i10 % 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        if ((r5.AFInAppEventParameterName(r0)) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void AFInAppEventParameterName(com.appsflyer.internal.AFc1qSDK r5, java.lang.Throwable r6, java.lang.String r7) {
        /*
            int r0 = com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            com.appsflyer.internal.AFb1qSDK r0 = r5.afWarnLog()
            r1 = 27
            if (r0 == 0) goto L20
            r2 = 33
            goto L22
        L20:
            r2 = 27
        L22:
            r3 = 1
            r4 = 0
            if (r2 == r1) goto L32
            boolean r0 = r5.AFInAppEventParameterName(r0)
            if (r0 != r3) goto L2e
            r0 = 1
            goto L2f
        L2e:
            r0 = 0
        L2f:
            if (r0 == 0) goto L3c
            goto L3d
        L32:
            int r0 = com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly
            int r0 = r0 + 43
            int r1 = r0 % 128
            com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration = r1
            int r0 = r0 % 2
        L3c:
            r3 = 0
        L3d:
            r0 = 94
            if (r3 == 0) goto L44
            r1 = 94
            goto L45
        L44:
            r1 = 6
        L45:
            if (r1 == r0) goto L48
            goto L59
        L48:
            int r0 = com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration
            int r0 = r0 + 41
            int r1 = r0 % 128
            com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly = r1
            int r0 = r0 % 2
            com.appsflyer.internal.AFc1wSDK r5 = r5.AFKeystoreWrapper()
            r5.values(r6, r7)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1qSDK.AFInAppEventParameterName(com.appsflyer.internal.AFc1qSDK, java.lang.Throwable, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void values(AFc1qSDK aFc1qSDK) {
        int i8 = afErrorLogForExcManagerOnly + 87;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        Intrinsics.f(aFc1qSDK, "");
        aFc1qSDK.afErrorLogForExcManagerOnly();
        int i10 = AFVersionDeclaration + 53;
        afErrorLogForExcManagerOnly = i10 % 128;
        int i11 = i10 % 2;
    }

    public final AFc1wSDK AFKeystoreWrapper() {
        int i8 = afErrorLogForExcManagerOnly + 109;
        AFVersionDeclaration = i8 % 128;
        if (!(i8 % 2 == 0)) {
            AFc1wSDK aFc1wSDK = (AFc1wSDK) this.afInfoLog.getValue();
            throw null;
        }
        AFc1wSDK aFc1wSDK2 = (AFc1wSDK) this.afInfoLog.getValue();
        int i9 = AFVersionDeclaration + 99;
        afErrorLogForExcManagerOnly = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
        return aFc1wSDK2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
        if (AFKeystoreWrapper().AFInAppEventParameterName() < r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
        if (AFKeystoreWrapper().AFInAppEventParameterName() < r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
        r13 = r13.values;
        kotlin.jvm.internal.Intrinsics.e(r13, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
        if (com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(r13) != com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(afErrorLog())) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean AFKeystoreWrapper(com.appsflyer.internal.AFb1qSDK r13) {
        /*
            r12 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1ySDK r2 = r12.afInfoLog()
            java.lang.String r3 = "af_send_exc_to_server_window"
            r4 = -1
            long r2 = r2.AFInAppEventParameterName(r3, r4)
            long r6 = r13.valueOf
            r8 = 1000(0x3e8, double:4.94E-321)
            long r8 = r0 / r8
            r10 = 26
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 >= 0) goto L1f
            r6 = 48
            goto L21
        L1f:
            r6 = 26
        L21:
            r7 = 0
            if (r6 == r10) goto L2f
            int r13 = com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration
            int r13 = r13 + 37
            int r0 = r13 % 128
            com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly = r0
            int r13 = r13 % 2
            return r7
        L2f:
            r6 = 44
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L37
            r4 = 4
            goto L39
        L37:
            r4 = 44
        L39:
            if (r4 == r6) goto L93
            r4 = 99
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 >= 0) goto L44
            r0 = 99
            goto L46
        L44:
            r0 = 66
        L46:
            if (r0 == r4) goto L93
            com.appsflyer.internal.AFc1ySDK r0 = r12.afInfoLog()
            java.lang.String r1 = "af_send_exc_min"
            r2 = -1
            int r0 = r0.AFInAppEventType(r1, r2)
            if (r0 == r2) goto L93
            int r1 = com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly
            int r1 = r1 + 77
            int r2 = r1 % 128
            com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L71
            com.appsflyer.internal.AFc1wSDK r1 = r12.AFKeystoreWrapper()
            int r1 = r1.AFInAppEventParameterName()
            r2 = 46
            int r2 = r2 / r7
            if (r1 >= r0) goto L7c
            goto L93
        L6f:
            r13 = move-exception
            throw r13
        L71:
            com.appsflyer.internal.AFc1wSDK r1 = r12.AFKeystoreWrapper()
            int r1 = r1.AFInAppEventParameterName()
            if (r1 >= r0) goto L7c
            goto L93
        L7c:
            java.lang.String r13 = r13.values
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.e(r13, r0)
            int r13 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(r13)
            java.lang.String r0 = r12.afErrorLog()
            int r0 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(r0)
            if (r13 != r0) goto L93
            r13 = 1
            return r13
        L93:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1qSDK.AFKeystoreWrapper(com.appsflyer.internal.AFb1qSDK):boolean");
    }

    @Override // com.appsflyer.internal.AFc1nSDK
    public final void AFInAppEventType() {
        int i8 = afErrorLogForExcManagerOnly + 41;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        afRDLog().execute(new Runnable() { // from class: com.appsflyer.internal.k
            @Override // java.lang.Runnable
            public final void run() {
                AFc1qSDK.values(AFc1qSDK.this);
            }
        });
        int i10 = afErrorLogForExcManagerOnly + 111;
        AFVersionDeclaration = i10 % 128;
        if ((i10 % 2 != 0 ? '!' : ' ') != ' ') {
            int i11 = 73 / 0;
        }
    }

    @Override // com.appsflyer.internal.AFc1nSDK
    public final void valueOf() {
        int i8 = afErrorLogForExcManagerOnly + 53;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        afRDLog().execute(new Runnable() { // from class: com.appsflyer.internal.l
            @Override // java.lang.Runnable
            public final void run() {
                AFc1qSDK.AFInAppEventParameterName(AFc1qSDK.this);
            }
        });
        int i10 = AFVersionDeclaration + 23;
        afErrorLogForExcManagerOnly = i10 % 128;
        if ((i10 % 2 == 0 ? (char) 14 : (char) 2) == 2) {
            return;
        }
        throw null;
    }

    private final Map<String, String> AFInAppEventType(AFb1qSDK aFb1qSDK) {
        Map<String, String> i8;
        Object[] objArr = new Object[1];
        AFInAppEventParameterName(new int[]{1263239055, -682377407, 82681553, 1636572451}, (ViewConfiguration.getEdgeSlop() >> 16) + 5, objArr);
        i8 = MapsKt__MapsKt.i(TuplesKt.a(((String) objArr[0]).intern(), Build.BRAND), TuplesKt.a("model", Build.MODEL), TuplesKt.a("app_id", afDebugLog().AFKeystoreWrapper.AFKeystoreWrapper.getPackageName()), TuplesKt.a("p_ex", new AFb1vSDK().AFKeystoreWrapper()), TuplesKt.a("api", String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.a("sdk", afErrorLog()), TuplesKt.a("uid", AFb1wSDK.AFKeystoreWrapper(new WeakReference(afDebugLog().AFKeystoreWrapper.AFKeystoreWrapper))), TuplesKt.a("exc_config", aFb1qSDK.AFInAppEventType()));
        int i9 = AFVersionDeclaration + 45;
        afErrorLogForExcManagerOnly = i9 % 128;
        if (!(i9 % 2 == 0)) {
            return i8;
        }
        throw null;
    }

    private static Map<String, Object> values(Map<String, ? extends Object> map, List<AFc1uSDK> list) {
        Map<String, Object> i8;
        int i9 = afErrorLogForExcManagerOnly + 89;
        AFVersionDeclaration = i9 % 128;
        int i10 = i9 % 2;
        i8 = MapsKt__MapsKt.i(TuplesKt.a("deviceInfo", map), TuplesKt.a("excs", AFc1oSDK.AFa1xSDK.AFKeystoreWrapper(list)));
        int i11 = afErrorLogForExcManagerOnly + 83;
        AFVersionDeclaration = i11 % 128;
        if (i11 % 2 == 0) {
            return i8;
        }
        int i12 = 38 / 0;
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFInAppEventParameterName(AFc1qSDK aFc1qSDK) {
        int i8 = AFVersionDeclaration + 23;
        afErrorLogForExcManagerOnly = i8 % 128;
        int i9 = i8 % 2;
        Intrinsics.f(aFc1qSDK, "");
        aFc1qSDK.AFVersionDeclaration();
        int i10 = afErrorLogForExcManagerOnly + 95;
        AFVersionDeclaration = i10 % 128;
        if (i10 % 2 == 0) {
            return;
        }
        int i11 = 47 / 0;
    }

    private final void values(String str, String str2) {
        Map<String, String> c8;
        int i8 = afErrorLogForExcManagerOnly + 117;
        AFVersionDeclaration = i8 % 128;
        int i9 = i8 % 2;
        byte[] bytes = str.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "");
        c8 = MapsKt__MapsJVMKt.c(TuplesKt.a("Authorization", AFb1ySDK.AFKeystoreWrapper(str, str2)));
        getLevel().values(bytes, c8, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        int i10 = afErrorLogForExcManagerOnly + 111;
        AFVersionDeclaration = i10 % 128;
        int i11 = i10 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r4 < 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        if ((r2 < r0 ? 7 : '5') != '5') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        r13 = r13.values;
        kotlin.jvm.internal.Intrinsics.e(r13, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(r13) != com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(afErrorLog())) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
        if (r13 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:
        r13 = com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly + 101;
        com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration = r13 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
        if ((r13 % 2) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
        r13 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
        r13 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r13 != '_') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007a, code lost:
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean AFInAppEventParameterName(com.appsflyer.internal.AFb1qSDK r13) {
        /*
            r12 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.appsflyer.internal.AFc1ySDK r2 = r12.afInfoLog()
            java.lang.String r3 = "af_send_exc_to_server_window"
            r4 = -1
            long r2 = r2.AFInAppEventParameterName(r3, r4)
            long r6 = r13.valueOf
            r8 = 1000(0x3e8, double:4.94E-321)
            long r8 = r0 / r8
            r10 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 < 0) goto L7d
            r6 = 1
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L22
            r4 = 1
            goto L23
        L22:
            r4 = 0
        L23:
            if (r4 == r6) goto L26
            goto L48
        L26:
            int r4 = com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly
            int r4 = r4 + 15
            int r5 = r4 % 128
            com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration = r5
            int r4 = r4 % 2
            if (r4 == 0) goto L3c
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r0 = 85
            int r0 = r0 / r10
            if (r4 >= 0) goto L49
            goto L48
        L3a:
            r13 = move-exception
            throw r13
        L3c:
            r4 = 53
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 >= 0) goto L44
            r0 = 7
            goto L46
        L44:
            r0 = 53
        L46:
            if (r0 == r4) goto L49
        L48:
            return r10
        L49:
            java.lang.String r13 = r13.values
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.e(r13, r0)
            int r13 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(r13)
            java.lang.String r0 = r12.afErrorLog()
            int r0 = com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(r0)
            if (r13 != r0) goto L60
            r13 = 1
            goto L61
        L60:
            r13 = 0
        L61:
            if (r13 == 0) goto L7d
            int r13 = com.appsflyer.internal.AFc1qSDK.afErrorLogForExcManagerOnly
            int r13 = r13 + 101
            int r0 = r13 % 128
            com.appsflyer.internal.AFc1qSDK.AFVersionDeclaration = r0
            int r13 = r13 % 2
            r0 = 95
            if (r13 == 0) goto L74
            r13 = 13
            goto L76
        L74:
            r13 = 95
        L76:
            if (r13 != r0) goto L79
            return r6
        L79:
            r13 = 0
            throw r13     // Catch: java.lang.Throwable -> L7b
        L7b:
            r13 = move-exception
            throw r13
        L7d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1qSDK.AFInAppEventParameterName(com.appsflyer.internal.AFb1qSDK):boolean");
    }

    private static void AFInAppEventParameterName(int[] iArr, int i8, Object[] objArr) {
        String str;
        synchronized (AFg1mSDK.AFKeystoreWrapper) {
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length << 1];
            int[] iArr2 = (int[]) AFLogger.clone();
            AFg1mSDK.valueOf = 0;
            while (true) {
                int i9 = AFg1mSDK.valueOf;
                if (i9 < iArr.length) {
                    int i10 = iArr[i9];
                    char c8 = (char) (i10 >> 16);
                    cArr[0] = c8;
                    char c9 = (char) i10;
                    cArr[1] = c9;
                    char c10 = (char) (iArr[i9 + 1] >> 16);
                    cArr[2] = c10;
                    char c11 = (char) iArr[i9 + 1];
                    cArr[3] = c11;
                    AFg1mSDK.AFInAppEventParameterName = (c8 << 16) + c9;
                    AFg1mSDK.values = (c10 << 16) + c11;
                    AFg1mSDK.AFInAppEventParameterName(iArr2);
                    for (int i11 = 0; i11 < 16; i11++) {
                        int i12 = AFg1mSDK.AFInAppEventParameterName ^ iArr2[i11];
                        AFg1mSDK.AFInAppEventParameterName = i12;
                        AFg1mSDK.values = AFg1mSDK.AFInAppEventType(i12) ^ AFg1mSDK.values;
                        int i13 = AFg1mSDK.AFInAppEventParameterName;
                        AFg1mSDK.AFInAppEventParameterName = AFg1mSDK.values;
                        AFg1mSDK.values = i13;
                    }
                    int i14 = AFg1mSDK.AFInAppEventParameterName;
                    AFg1mSDK.AFInAppEventParameterName = AFg1mSDK.values;
                    AFg1mSDK.values = i14;
                    AFg1mSDK.values = i14 ^ iArr2[16];
                    AFg1mSDK.AFInAppEventParameterName ^= iArr2[17];
                    int i15 = AFg1mSDK.valueOf;
                    int i16 = AFg1mSDK.AFInAppEventParameterName;
                    cArr[0] = (char) (i16 >>> 16);
                    cArr[1] = (char) i16;
                    int i17 = AFg1mSDK.values;
                    cArr[2] = (char) (i17 >>> 16);
                    cArr[3] = (char) i17;
                    AFg1mSDK.AFInAppEventParameterName(iArr2);
                    int i18 = AFg1mSDK.valueOf;
                    cArr2[i18 << 1] = cArr[0];
                    cArr2[(i18 << 1) + 1] = cArr[1];
                    cArr2[(i18 << 1) + 2] = cArr[2];
                    cArr2[(i18 << 1) + 3] = cArr[3];
                    AFg1mSDK.valueOf = i18 + 2;
                } else {
                    str = new String(cArr2, 0, i8);
                }
            }
        }
        objArr[0] = str;
    }
}
