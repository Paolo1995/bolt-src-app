package com.appsflyer.internal;

import android.util.Base64;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;

/* loaded from: classes.dex */
public class AFd1wSDK {
    private static AFc1aSDK afErrorLog;
    private static final List<String> afInfoLog;
    private final AFc1zSDK AFKeystoreWrapper;
    private final Lazy afRDLog;
    private final AFc1ySDK valueOf;
    public final Lazy values;
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK(null);
    public static String AFInAppEventType = "https://%scdn-%ssettings.%s/android/v1/%s/settings";
    public static String AFInAppEventParameterName = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";

    /* loaded from: classes.dex */
    public /* synthetic */ class AFa1wSDK {
        public static final /* synthetic */ int[] AFInAppEventParameterName;

        static {
            int[] iArr = new int[AFd1vSDK.values().length];
            iArr[AFd1vSDK.DEFAULT.ordinal()] = 1;
            iArr[AFd1vSDK.API.ordinal()] = 2;
            iArr[AFd1vSDK.RC.ordinal()] = 3;
            AFInAppEventParameterName = iArr;
        }
    }

    /* loaded from: classes.dex */
    public static final class AFa1zSDK {
        private AFa1zSDK() {
        }

        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static void valueOf(AFc1aSDK aFc1aSDK) {
            AFd1wSDK.afErrorLog = aFc1aSDK;
        }

        public static List<String> values() {
            return AFd1wSDK.afInfoLog;
        }
    }

    static {
        List<String> n8;
        n8 = CollectionsKt__CollectionsKt.n("googleplay", "playstore", "googleplaystore");
        afInfoLog = n8;
    }

    public AFd1wSDK(AFc1zSDK aFc1zSDK, AFc1ySDK aFc1ySDK) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(aFc1zSDK, "");
        Intrinsics.f(aFc1ySDK, "");
        this.AFKeystoreWrapper = aFc1zSDK;
        this.valueOf = aFc1ySDK;
        b8 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.appsflyer.internal.AFd1wSDK.4
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFKeystoreWrapper */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.String invoke() {
                /*
                    r6 = this;
                    com.appsflyer.internal.AFd1wSDK r0 = com.appsflyer.internal.AFd1wSDK.this
                    com.appsflyer.internal.AFc1ySDK r0 = com.appsflyer.internal.AFd1wSDK.AFInAppEventType(r0)
                    com.appsflyer.internal.AFd1wSDK r1 = com.appsflyer.internal.AFd1wSDK.this
                    com.appsflyer.internal.AFc1zSDK r1 = com.appsflyer.internal.AFd1wSDK.valueOf(r1)
                    java.lang.String r1 = r1.AFInAppEventType()
                    java.lang.String r0 = com.appsflyer.internal.AFb1xSDK.AFInAppEventType(r0, r1)
                    r1 = 0
                    r2 = 1
                    if (r0 == 0) goto L21
                    boolean r3 = kotlin.text.StringsKt.y(r0)
                    if (r3 == 0) goto L1f
                    goto L21
                L1f:
                    r3 = 0
                    goto L22
                L21:
                    r3 = 1
                L22:
                    java.lang.String r4 = ""
                    if (r3 != 0) goto L64
                    java.lang.CharSequence r0 = kotlin.text.StringsKt.Y0(r0)
                    java.lang.String r0 = r0.toString()
                    java.util.List r3 = com.appsflyer.internal.AFd1wSDK.AFa1zSDK.values()
                    java.util.Locale r5 = java.util.Locale.getDefault()
                    kotlin.jvm.internal.Intrinsics.e(r5, r4)
                    java.lang.String r5 = r0.toLowerCase(r5)
                    kotlin.jvm.internal.Intrinsics.e(r5, r4)
                    boolean r3 = r3.contains(r5)
                    if (r3 != 0) goto L4d
                    java.lang.String r1 = "-"
                    java.lang.String r0 = r1.concat(r0)
                    goto L64
                L4d:
                    kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.f51021a
                    java.lang.Object[] r3 = new java.lang.Object[r2]
                    r3[r1] = r0
                    java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r2)
                    java.lang.String r1 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
                    java.lang.String r0 = java.lang.String.format(r1, r0)
                    kotlin.jvm.internal.Intrinsics.e(r0, r4)
                    com.appsflyer.AFLogger.afWarnLog(r0)
                    r0 = r4
                L64:
                    if (r0 != 0) goto L67
                    goto L68
                L67:
                    r4 = r0
                L68:
                    java.lang.CharSequence r0 = kotlin.text.StringsKt.Y0(r4)
                    java.lang.String r0 = r0.toString()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1wSDK.AnonymousClass4.invoke():java.lang.String");
            }
        });
        this.afRDLog = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.appsflyer.internal.AFd1wSDK.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: AFInAppEventType */
            public final String invoke() {
                String packageName = AFd1wSDK.this.AFKeystoreWrapper.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName();
                Intrinsics.e(packageName, "");
                return AFd1wSDK.AFKeystoreWrapper(packageName, AFd1wSDK.AFInAppEventParameterName(AFd1wSDK.this));
            }
        });
        this.values = b9;
    }

    public static final void AFInAppEventParameterName(AFc1aSDK aFc1aSDK) {
        AFa1zSDK.valueOf(aFc1aSDK);
    }

    public static boolean AFInAppEventParameterName() {
        return afErrorLog == null;
    }

    public static final /* synthetic */ String AFKeystoreWrapper(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        String obj = sb2.toString();
        Intrinsics.f(obj, "");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = obj.getBytes(Charsets.f51135b);
        Intrinsics.e(bytes, "");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.e(digest, "");
        String encodeToString = Base64.encodeToString(digest, 2);
        Intrinsics.e(encodeToString, "");
        String lowerCase = encodeToString.toLowerCase(Locale.ROOT);
        Intrinsics.e(lowerCase, "");
        String substring = new Regex("[^\\w]+").g(lowerCase, "").substring(0, 6);
        Intrinsics.e(substring, "");
        sb.append(substring);
        sb.append('-');
        return sb.toString();
    }

    public static final /* synthetic */ String AFInAppEventParameterName(AFd1wSDK aFd1wSDK) {
        return (String) aFd1wSDK.afRDLog.getValue();
    }

    public final String AFInAppEventType() {
        AFd1vSDK aFd1vSDK;
        if (AFInAppEventParameterName()) {
            aFd1vSDK = AFd1vSDK.DEFAULT;
        } else {
            aFd1vSDK = AFd1vSDK.API;
        }
        int i8 = AFa1wSDK.AFInAppEventParameterName[aFd1vSDK.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return "";
                }
                throw new NoWhenBranchMatchedException();
            }
            AFc1aSDK aFc1aSDK = afErrorLog;
            String str = aFc1aSDK != null ? aFc1aSDK.AFInAppEventParameterName : null;
            return str == null ? "" : str;
        }
        return (String) this.values.getValue();
    }

    public final String values() {
        AFd1vSDK aFd1vSDK;
        if (AFInAppEventParameterName()) {
            aFd1vSDK = AFd1vSDK.DEFAULT;
        } else {
            aFd1vSDK = AFd1vSDK.API;
        }
        int i8 = AFa1wSDK.AFInAppEventParameterName[aFd1vSDK.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    return "";
                }
                throw new NoWhenBranchMatchedException();
            }
            AFc1aSDK aFc1aSDK = afErrorLog;
            String str = aFc1aSDK != null ? aFc1aSDK.valueOf : null;
            return str == null ? "" : str;
        }
        return "appsflyersdk.com";
    }
}
