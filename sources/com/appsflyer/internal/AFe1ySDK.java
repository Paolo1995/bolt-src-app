package com.appsflyer.internal;

import android.text.TextUtils;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class AFe1ySDK {
    private static boolean AFInAppEventParameterName = false;
    private static char[] AFInAppEventType = null;
    private static boolean AFKeystoreWrapper = false;
    private static int afInfoLog = 1;
    private static int valueOf;
    private static int values;

    static {
        AFKeystoreWrapper();
        ViewConfiguration.getJumpTapTimeout();
        int i8 = afInfoLog + 115;
        values = i8 % 128;
        int i9 = i8 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
        if (r9.length() < 45) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
        r10 = com.appsflyer.internal.AFe1ySDK.values + 39;
        com.appsflyer.internal.AFe1ySDK.afInfoLog = r10 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
        if ((r10 % 2) != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
        if (r10 == true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
        r10 = 13 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
        return r9.substring(0, 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r9.length() < 12) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String AFInAppEventParameterName(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            int r0 = com.appsflyer.internal.AFe1ySDK.afInfoLog
            int r0 = r0 + 43
            int r1 = r0 % 128
            com.appsflyer.internal.AFe1ySDK.values = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 57
            if (r0 == 0) goto L11
            r0 = 57
            goto L13
        L11:
            r0 = 54
        L13:
            r3 = 12
            java.lang.String r4 = ""
            r5 = 3
            r6 = 4
            r7 = 0
            r8 = 1
            if (r0 == r2) goto L39
            r0 = 5
            java.lang.String[] r0 = new java.lang.String[r0]
            r0[r7] = r10
            r0[r8] = r11
            r0[r1] = r12
            r0[r5] = r13
            r0[r6] = r4
            java.lang.String r10 = com.appsflyer.internal.AFb1ySDK.valueOf(r0)
            java.lang.String r9 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper(r10, r9)
            int r10 = r9.length()
            if (r10 >= r3) goto L6c
            goto L55
        L39:
            java.lang.String[] r0 = new java.lang.String[r6]
            r0[r8] = r10
            r0[r8] = r11
            r0[r5] = r12
            r0[r6] = r13
            r0[r1] = r4
            java.lang.String r10 = com.appsflyer.internal.AFb1ySDK.valueOf(r0)
            java.lang.String r9 = com.appsflyer.internal.AFb1ySDK.AFKeystoreWrapper(r10, r9)
            int r10 = r9.length()
            r11 = 45
            if (r10 >= r11) goto L6c
        L55:
            int r10 = com.appsflyer.internal.AFe1ySDK.values
            int r10 = r10 + 39
            int r11 = r10 % 128
            com.appsflyer.internal.AFe1ySDK.afInfoLog = r11
            int r10 = r10 % r1
            if (r10 != 0) goto L62
            r10 = 1
            goto L63
        L62:
            r10 = 0
        L63:
            if (r10 == r8) goto L66
            return r9
        L66:
            r10 = 13
            int r10 = r10 / r7
            return r9
        L6a:
            r9 = move-exception
            throw r9
        L6c:
            java.lang.String r9 = r9.substring(r7, r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1ySDK.AFInAppEventParameterName(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    static void AFKeystoreWrapper() {
        AFKeystoreWrapper = true;
        AFInAppEventType = new char[]{'f', 'j', 'i', 'l', 'e', 'g', 'h', 'k', 'c', 'w', 'd', 't', 'x'};
        AFInAppEventParameterName = true;
        valueOf = 51;
    }

    @NonNull
    private static AFe1tSDK values(@NonNull AFb1iSDK aFb1iSDK, String str, @NonNull String str2, @NonNull String str3) {
        AFf1tSDK aFf1tSDK;
        boolean z7 = false;
        if (str == null) {
            if (aFb1iSDK.valueOf == AFf1qSDK.DEFAULT) {
                z7 = true;
            }
            return new AFe1tSDK(z7, AFf1tSDK.NA);
        }
        String str4 = "";
        Object[] objArr = new Object[1];
        valueOf("\u008c\u0085\u0081\u0086\u0087\u0085\u008c\u0082\u008b\u0085\u0082\u0082\u0082\u0081\u0086\u0082\u0086\u0081\u008b\u0082\u008c\u0087\u008d\u0083\u0082\u0087\u008c\u0083\u0086\u0087\u0083\u0083\u008b\u0087\u0081\u0083\u008a\u0086\u0089\u0086\u0088\u0086\u0084\u0085\u0087\u0086\u0083\u0085\u0085\u0086\u0086\u0085\u0084\u0082\u0084\u0081\u0083\u0082\u0083\u0081\u0081\u0082\u0081\u0081", null, null, 127 - TextUtils.indexOf("", ""), objArr);
        String intern = ((String) objArr[0]).intern();
        if (aFb1iSDK.valueOf == AFf1qSDK.CUSTOM) {
            str4 = new StringBuilder(str2).reverse().toString();
        } else {
            str3 = intern;
        }
        boolean equals = AFInAppEventParameterName(new StringBuilder(str3).reverse().toString(), aFb1iSDK.values, "android", "v1", str4).equals(str);
        if (equals) {
            aFf1tSDK = AFf1tSDK.SUCCESS;
        } else {
            aFf1tSDK = AFf1tSDK.FAILURE;
        }
        return new AFe1tSDK(equals, aFf1tSDK);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        if ((r9 == null) != true) goto L10;
     */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.appsflyer.internal.AFe1tSDK valueOf(@androidx.annotation.NonNull com.appsflyer.internal.AFb1iSDK r6, java.lang.String r7, @androidx.annotation.NonNull java.lang.String r8, @androidx.annotation.NonNull java.lang.String r9) {
        /*
            r5 = this;
            int r0 = com.appsflyer.internal.AFe1ySDK.values
            int r1 = r0 + 67
            int r2 = r1 % 128
            com.appsflyer.internal.AFe1ySDK.afInfoLog = r2
            int r1 = r1 % 2
            if (r1 == 0) goto L3a
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L22
            if (r8 == 0) goto L22
            int r3 = r0 + 51
            int r4 = r3 % 128
            com.appsflyer.internal.AFe1ySDK.afInfoLog = r4
            int r3 = r3 % 2
            if (r9 == 0) goto L1e
            r3 = 0
            goto L1f
        L1e:
            r3 = 1
        L1f:
            if (r3 == r1) goto L22
            goto L2b
        L22:
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.appsflyer.internal.AFe1ySDK.afInfoLog = r1
            int r0 = r0 % 2
            r1 = 0
        L2b:
            if (r1 != 0) goto L35
            com.appsflyer.internal.AFe1tSDK r6 = new com.appsflyer.internal.AFe1tSDK
            com.appsflyer.internal.AFf1tSDK r7 = com.appsflyer.internal.AFf1tSDK.INTERNAL_ERROR
            r6.<init>(r2, r7)
            return r6
        L35:
            com.appsflyer.internal.AFe1tSDK r6 = values(r6, r7, r8, r9)
            return r6
        L3a:
            r6 = 0
            throw r6     // Catch: java.lang.Throwable -> L3c
        L3c:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1ySDK.valueOf(com.appsflyer.internal.AFb1iSDK, java.lang.String, java.lang.String, java.lang.String):com.appsflyer.internal.AFe1tSDK");
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void valueOf(java.lang.String r6, java.lang.String r7, int[] r8, int r9, java.lang.Object[] r10) {
        /*
            if (r7 == 0) goto L6
            char[] r7 = r7.toCharArray()
        L6:
            char[] r7 = (char[]) r7
            if (r6 == 0) goto L10
            java.lang.String r0 = "ISO-8859-1"
            byte[] r6 = r6.getBytes(r0)
        L10:
            byte[] r6 = (byte[]) r6
            java.lang.Object r0 = com.appsflyer.internal.AFg1rSDK.AFInAppEventParameterName
            monitor-enter(r0)
            char[] r1 = com.appsflyer.internal.AFe1ySDK.AFInAppEventType     // Catch: java.lang.Throwable -> La9
            int r2 = com.appsflyer.internal.AFe1ySDK.valueOf     // Catch: java.lang.Throwable -> La9
            boolean r3 = com.appsflyer.internal.AFe1ySDK.AFInAppEventParameterName     // Catch: java.lang.Throwable -> La9
            r4 = 0
            if (r3 == 0) goto L4b
            int r7 = r6.length     // Catch: java.lang.Throwable -> La9
            com.appsflyer.internal.AFg1rSDK.values = r7     // Catch: java.lang.Throwable -> La9
            char[] r7 = new char[r7]     // Catch: java.lang.Throwable -> La9
            com.appsflyer.internal.AFg1rSDK.valueOf = r4     // Catch: java.lang.Throwable -> La9
        L25:
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch: java.lang.Throwable -> La9
            if (r8 >= r3) goto L42
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch: java.lang.Throwable -> La9
            int r3 = r3 + (-1)
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r5
            r3 = r6[r3]     // Catch: java.lang.Throwable -> La9
            int r3 = r3 + r9
            char r3 = r1[r3]     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch: java.lang.Throwable -> La9
            r7[r8] = r3     // Catch: java.lang.Throwable -> La9
            int r5 = r5 + 1
            com.appsflyer.internal.AFg1rSDK.valueOf = r5     // Catch: java.lang.Throwable -> La9
            goto L25
        L42:
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> La9
            r6.<init>(r7)     // Catch: java.lang.Throwable -> La9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            r10[r4] = r6
            return
        L4b:
            boolean r6 = com.appsflyer.internal.AFe1ySDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> La9
            if (r6 == 0) goto L7c
            int r6 = r7.length     // Catch: java.lang.Throwable -> La9
            com.appsflyer.internal.AFg1rSDK.values = r6     // Catch: java.lang.Throwable -> La9
            char[] r6 = new char[r6]     // Catch: java.lang.Throwable -> La9
            com.appsflyer.internal.AFg1rSDK.valueOf = r4     // Catch: java.lang.Throwable -> La9
        L56:
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch: java.lang.Throwable -> La9
            if (r8 >= r3) goto L73
            int r8 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch: java.lang.Throwable -> La9
            int r3 = r3 + (-1)
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r5
            char r3 = r7[r3]     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r9
            char r3 = r1[r3]     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch: java.lang.Throwable -> La9
            r6[r8] = r3     // Catch: java.lang.Throwable -> La9
            int r5 = r5 + 1
            com.appsflyer.internal.AFg1rSDK.valueOf = r5     // Catch: java.lang.Throwable -> La9
            goto L56
        L73:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> La9
            r7.<init>(r6)     // Catch: java.lang.Throwable -> La9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            r10[r4] = r7
            return
        L7c:
            int r6 = r8.length     // Catch: java.lang.Throwable -> La9
            com.appsflyer.internal.AFg1rSDK.values = r6     // Catch: java.lang.Throwable -> La9
            char[] r6 = new char[r6]     // Catch: java.lang.Throwable -> La9
            com.appsflyer.internal.AFg1rSDK.valueOf = r4     // Catch: java.lang.Throwable -> La9
        L83:
            int r7 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch: java.lang.Throwable -> La9
            if (r7 >= r3) goto La0
            int r7 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = com.appsflyer.internal.AFg1rSDK.values     // Catch: java.lang.Throwable -> La9
            int r3 = r3 + (-1)
            int r5 = com.appsflyer.internal.AFg1rSDK.valueOf     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r5
            r3 = r8[r3]     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r9
            char r3 = r1[r3]     // Catch: java.lang.Throwable -> La9
            int r3 = r3 - r2
            char r3 = (char) r3     // Catch: java.lang.Throwable -> La9
            r6[r7] = r3     // Catch: java.lang.Throwable -> La9
            int r5 = r5 + 1
            com.appsflyer.internal.AFg1rSDK.valueOf = r5     // Catch: java.lang.Throwable -> La9
            goto L83
        La0:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> La9
            r7.<init>(r6)     // Catch: java.lang.Throwable -> La9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La9
            r10[r4] = r7
            return
        La9:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1ySDK.valueOf(java.lang.String, java.lang.String, int[], int, java.lang.Object[]):void");
    }
}
