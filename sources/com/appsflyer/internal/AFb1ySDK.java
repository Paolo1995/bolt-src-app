package com.appsflyer.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import j$.util.Spliterator;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFb1ySDK {
    private static int AFInAppEventParameterName = 1;
    private static int AFKeystoreWrapper = 0;
    private static long values = -3426542386320976008L;

    public static String AFInAppEventParameterName(String str) {
        int i8 = AFInAppEventParameterName + 59;
        AFKeystoreWrapper = i8 % 128;
        int i9 = i8 % 2;
        String str2 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            str2 = AFKeystoreWrapper(messageDigest.digest());
            int i10 = AFInAppEventParameterName + 67;
            AFKeystoreWrapper = i10 % 128;
            int i11 = i10 % 2;
        } catch (Exception e8) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA-256");
            AFLogger.afErrorLog(sb.toString(), e8);
        }
        return str2;
    }

    public static String AFKeystoreWrapper(String str) {
        String str2;
        int i8 = AFKeystoreWrapper + 35;
        AFInAppEventParameterName = i8 % 128;
        String str3 = null;
        try {
        } catch (Exception e8) {
            e = e8;
        }
        if (i8 % 2 != 0) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            str2 = values(messageDigest.digest());
            int i9 = AFKeystoreWrapper + 17;
            AFInAppEventParameterName = i9 % 128;
            int i10 = i9 % 2;
            return str2;
        }
        MessageDigest messageDigest2 = MessageDigest.getInstance("SHA-1");
        messageDigest2.reset();
        messageDigest2.update(str.getBytes("UTF-8"));
        String values2 = values(messageDigest2.digest());
        try {
            throw null;
        } catch (Exception e9) {
            str3 = values2;
            e = e9;
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA1");
            AFLogger.afErrorLog(sb.toString(), e);
            str2 = str3;
            int i92 = AFKeystoreWrapper + 17;
            AFInAppEventParameterName = i92 % 128;
            int i102 = i92 % 2;
            return str2;
        }
    }

    public static String valueOf(String... strArr) {
        int i8 = AFKeystoreWrapper + 35;
        AFInAppEventParameterName = i8 % 128;
        int i9 = i8 % 2;
        String join = TextUtils.join("\u2063", strArr);
        int i10 = AFInAppEventParameterName + 91;
        AFKeystoreWrapper = i10 % 128;
        int i11 = i10 % 2;
        return join;
    }

    public static String values(String str) {
        int i8 = AFKeystoreWrapper + 81;
        AFInAppEventParameterName = i8 % 128;
        String str2 = null;
        try {
            if ((i8 % 2 != 0 ? 'S' : (char) 2) == 'S') {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(str.getBytes("UTF-8"));
                return values(messageDigest.digest());
            }
            MessageDigest messageDigest2 = MessageDigest.getInstance("MD5");
            messageDigest2.reset();
            messageDigest2.update(str.getBytes("UTF-8"));
            String values2 = values(messageDigest2.digest());
            try {
                throw null;
            } catch (Exception e8) {
                str2 = values2;
                e = e8;
                StringBuilder sb = new StringBuilder("Error turning ");
                sb.append(str.substring(0, 6));
                sb.append(".. to MD5");
                AFLogger.afErrorLog(sb.toString(), e);
                return str2;
            }
        } catch (Exception e9) {
            e = e9;
        }
    }

    public static String AFInAppEventParameterName(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append((String) map.get("appsflyerKey"));
        Object[] objArr = new Object[1];
        AFInAppEventParameterName("휙⟛㚭Ճᐅ擌玃䉨儤ꇴ낧轿", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 61636, objArr);
        sb.append(map.get(((String) objArr[0]).intern()));
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(map.get("uid"));
        String obj2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj2);
        sb3.append(map.get("installDate"));
        String obj3 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(obj3);
        sb4.append(map.get("counter"));
        String obj4 = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj4);
        sb5.append(map.get("iaecounter"));
        String AFKeystoreWrapper2 = AFKeystoreWrapper(values(sb5.toString()));
        int i8 = AFKeystoreWrapper + 117;
        AFInAppEventParameterName = i8 % 128;
        int i9 = i8 % 2;
        return AFKeystoreWrapper2;
    }

    private static String values(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        int i8 = 0;
        while (true) {
            if (!(i8 < length)) {
                break;
            }
            int i9 = AFKeystoreWrapper + 33;
            AFInAppEventParameterName = i9 % 128;
            if (i9 % 2 == 0) {
                Object[] objArr = new Object[1];
                objArr[1] = Byte.valueOf(bArr[i8]);
                formatter.format("%02x", objArr);
                i8 += 19;
            } else {
                formatter.format("%02x", Byte.valueOf(bArr[i8]));
                i8++;
            }
        }
        String obj = formatter.toString();
        formatter.close();
        int i10 = AFInAppEventParameterName + 121;
        AFKeystoreWrapper = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 78 / 0;
            return obj;
        }
        return obj;
    }

    private static String AFKeystoreWrapper(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                String obj = sb.toString();
                int i9 = AFInAppEventParameterName + 109;
                AFKeystoreWrapper = i9 % 128;
                int i10 = i9 % 2;
                return obj;
            }
            int i11 = AFInAppEventParameterName + 93;
            AFKeystoreWrapper = i11 % 128;
            int i12 = i11 % 2;
            sb.append(Integer.toString((bArr[i8] & 255) + Spliterator.NONNULL, 16).substring(1));
            i8++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void AFInAppEventParameterName(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L6
            char[] r7 = r7.toCharArray()
        L6:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.appsflyer.internal.AFg1tSDK.AFKeystoreWrapper
            monitor-enter(r0)
            com.appsflyer.internal.AFg1tSDK.AFInAppEventType = r8     // Catch: java.lang.Throwable -> L37
            int r8 = r7.length     // Catch: java.lang.Throwable -> L37
            char[] r8 = new char[r8]     // Catch: java.lang.Throwable -> L37
            r1 = 0
            com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName = r1     // Catch: java.lang.Throwable -> L37
        L13:
            int r2 = com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName     // Catch: java.lang.Throwable -> L37
            int r3 = r7.length     // Catch: java.lang.Throwable -> L37
            if (r2 >= r3) goto L2e
            char r3 = r7[r2]     // Catch: java.lang.Throwable -> L37
            int r4 = com.appsflyer.internal.AFg1tSDK.AFInAppEventType     // Catch: java.lang.Throwable -> L37
            int r4 = r4 * r2
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L37
            long r5 = com.appsflyer.internal.AFb1ySDK.values     // Catch: java.lang.Throwable -> L37
            long r3 = r3 ^ r5
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L37
            char r3 = (char) r4     // Catch: java.lang.Throwable -> L37
            r8[r2] = r3     // Catch: java.lang.Throwable -> L37
            int r2 = com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName     // Catch: java.lang.Throwable -> L37
            int r2 = r2 + 1
            com.appsflyer.internal.AFg1tSDK.AFInAppEventParameterName = r2     // Catch: java.lang.Throwable -> L37
            goto L13
        L2e:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L37
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L37
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
            r9[r1] = r7
            return
        L37:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1ySDK.AFInAppEventParameterName(java.lang.String, int, java.lang.Object[]):void");
    }

    public static String AFKeystoreWrapper(String str, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            String lowerCase = AFKeystoreWrapper(mac.doFinal(str.getBytes())).toLowerCase(Locale.getDefault());
            int i8 = AFInAppEventParameterName + 23;
            AFKeystoreWrapper = i8 % 128;
            if ((i8 % 2 != 0 ? (char) 17 : '&') != 17) {
                return lowerCase;
            }
            throw null;
        } catch (InvalidKeyException | NoSuchAlgorithmException e8) {
            AFLogger.afErrorLog(e8.getMessage(), e8, true);
            return e8.getMessage();
        }
    }

    public static String values(Map<String, Object> map) {
        Object[] objArr = new Object[1];
        AFInAppEventParameterName("휙⟛㚭Ճᐅ擌玃䉨儤ꇴ낧轿", 61638 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr);
        String str = (String) map.get(((String) objArr[0]).intern());
        StringBuilder sb = new StringBuilder();
        sb.append(((String) map.get("appsflyerKey")).substring(0, 7));
        sb.append(((String) map.get("uid")).substring(0, 7));
        sb.append(str.substring(str.length() - 7));
        String AFKeystoreWrapper2 = AFKeystoreWrapper(sb.toString());
        int i8 = AFInAppEventParameterName + 81;
        AFKeystoreWrapper = i8 % 128;
        int i9 = i8 % 2;
        return AFKeystoreWrapper2;
    }

    public static boolean AFKeystoreWrapper(Map<String, Object> map, String[] strArr, AFc1zSDK aFc1zSDK) throws IllegalStateException {
        if (map == null || map.isEmpty()) {
            return false;
        }
        int length = strArr.length;
        int i8 = 0;
        while (i8 < length) {
            if (!(map.containsKey(strArr[i8]))) {
                int i9 = AFInAppEventParameterName + 31;
                AFKeystoreWrapper = i9 % 128;
                return i9 % 2 != 0;
            }
            i8++;
            int i10 = AFInAppEventParameterName + 107;
            AFKeystoreWrapper = i10 % 128;
            int i11 = i10 % 2;
        }
        String str = (String) map.remove("sig");
        if ((str == null ? ')' : (char) 25) != 25) {
            return false;
        }
        String valueOf = AFc1zSDK.valueOf();
        StringBuilder sb = new StringBuilder();
        sb.append(new JSONObject(map));
        sb.append(valueOf);
        return AFKeystoreWrapper(sb.toString(), AFb1wSDK.AFKeystoreWrapper(new WeakReference(aFc1zSDK.AFKeystoreWrapper.AFKeystoreWrapper))).equals(str);
    }
}
