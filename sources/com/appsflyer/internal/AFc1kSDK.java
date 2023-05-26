package com.appsflyer.internal;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFc1kSDK {
    private static String AFInAppEventParameterName = null;
    private static String AFInAppEventType = null;
    private static int AFLogger = 1;
    private static int afInfoLog;
    private static int[] afRDLog;
    public static String values;
    private final CreateOneLinkHttpTask AFKeystoreWrapper;
    private final AppsFlyerProperties afDebugLog;
    private final AFd1wSDK afErrorLog;
    private final AFc1zSDK valueOf;

    static {
        AFKeystoreWrapper();
        AFInAppEventType = "https://%smonitorsdk.%s/remote-debug?app_id=";
        values = "https://%sgcdsdk.%s/install_data/v5.0/";
        AFInAppEventParameterName = "https://%sonelink.%s/shortlink-sdk/v2";
        int i8 = afInfoLog + 41;
        AFLogger = i8 % 128;
        int i9 = i8 % 2;
    }

    public AFc1kSDK(CreateOneLinkHttpTask createOneLinkHttpTask, AFc1zSDK aFc1zSDK, AppsFlyerProperties appsFlyerProperties, AFd1wSDK aFd1wSDK) {
        this.AFKeystoreWrapper = createOneLinkHttpTask;
        this.valueOf = aFc1zSDK;
        this.afDebugLog = appsFlyerProperties;
        this.afErrorLog = aFd1wSDK;
    }

    static void AFKeystoreWrapper() {
        afRDLog = new int[]{-672765460, 973734950, -481961226, -2045304833, 25430739, 432217355, 64525102, 1055828195, 664986047, 1353405260, 512053792, 1366916719, -1888366569, 375619018, 1675056026, 1471284235, -566253957, -219256705};
    }

    @NonNull
    public final AFc1jSDK<String> AFInAppEventParameterName(Map<String, Object> map, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        sb.append(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        try {
            AFc1jSDK<String> valueOf = valueOf(new AFc1rSDK(sb.toString(), (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName(37 - (ViewConfiguration.getWindowTouchSlop() >> 8), Gravity.getAbsoluteGravity(0, 0) + 73, (char) ((Process.myTid() >> 22) + 48063))).getMethod("values", Map.class, String.class).invoke(null, map, str), "POST", Collections.emptyMap(), true), new AFc1dSDK());
            int i8 = AFLogger + 39;
            afInfoLog = i8 % 128;
            int i9 = i8 % 2;
            return valueOf;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final AFc1jSDK<Map<String, Object>> AFInAppEventType(String str, String str2) {
        AFc1jSDK<Map<String, Object>> valueOf = valueOf(AFc1mSDK.valueOf(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName(), AFb1wSDK.AFKeystoreWrapper(new WeakReference(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper)), str, str2), new AFc1eSDK());
        int i8 = afInfoLog + 21;
        AFLogger = i8 % 128;
        if ((i8 % 2 == 0 ? 'b' : 'a') != 'b') {
            return valueOf;
        }
        throw null;
    }

    @NonNull
    public final AFc1jSDK<String> AFKeystoreWrapper(Map<String, Object> map, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("https://%sars.%s/api/v2/android/validate_subscription?app_id=", AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        sb.append(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        try {
            AFc1jSDK<String> valueOf = valueOf(new AFc1rSDK(sb.toString(), (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName(37 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 73 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (48063 - ExpandableListView.getPackedPositionGroup(0L)))).getMethod("values", Map.class, String.class).invoke(null, map, str), "POST", Collections.emptyMap(), true), new AFc1dSDK());
            int i8 = AFLogger + 27;
            afInfoLog = i8 % 128;
            int i9 = i8 % 2;
            return valueOf;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    @NonNull
    public final AFc1jSDK<String> valueOf(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFInAppEventType, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        sb.append(this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        AFc1jSDK<String> valueOf = valueOf(new AFc1rSDK(sb.toString(), new JSONObject(map).toString().getBytes(), "POST", Collections.emptyMap(), false), new AFc1dSDK());
        int i8 = afInfoLog + 57;
        AFLogger = i8 % 128;
        int i9 = i8 % 2;
        return valueOf;
    }

    public final AFc1jSDK<String> values(@NonNull String str, @NonNull Map<String, String> map, String str2, @NonNull UUID uuid, @NonNull String str3) {
        String obj = uuid.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("ttl", "-1");
        hashMap.put("uuid", obj);
        hashMap.put("data", map);
        hashMap.put("meta", values());
        if (!(str2 == null)) {
            int i8 = afInfoLog + 3;
            AFLogger = i8 % 128;
            if (i8 % 2 == 0) {
                hashMap.put("brand_domain", str2);
                throw null;
            }
            hashMap.put("brand_domain", str2);
        }
        String jSONObject = AFa1oSDK.AFKeystoreWrapper(hashMap).toString();
        HashMap hashMap2 = new HashMap();
        Object[] objArr = new Object[1];
        valueOf(new int[]{80594839, 1788865157, -1077787898, -1986835446, 771314473, 1329780629}, (Process.myTid() >> 22) + 12, objArr);
        hashMap2.put(((String) objArr[0]).intern(), AFKeystoreWrapper(str3, obj, "POST", jSONObject));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFInAppEventParameterName, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        sb.append("/");
        sb.append(str);
        AFc1jSDK<String> AFKeystoreWrapper = AFKeystoreWrapper(new AFc1rSDK(sb.toString(), jSONObject.getBytes(Charset.forName("UTF-8")), "POST", hashMap2, false), (AFc1cSDK) new AFc1dSDK(), true);
        int i9 = AFLogger + 105;
        afInfoLog = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
        return AFKeystoreWrapper;
    }

    public final AFc1jSDK<String> AFInAppEventType(AFe1aSDK aFe1aSDK) {
        AFc1jSDK<String> valueOf = valueOf(new AFc1rSDK(aFe1aSDK.afErrorLog, aFe1aSDK.values(), "POST", Collections.emptyMap(), true), new AFc1dSDK());
        int i8 = afInfoLog + 79;
        AFLogger = i8 % 128;
        int i9 = i8 % 2;
        return valueOf;
    }

    private <T> AFc1jSDK<T> valueOf(AFc1rSDK aFc1rSDK, AFc1cSDK<T> aFc1cSDK) {
        int i8 = AFLogger + 123;
        afInfoLog = i8 % 128;
        if ((i8 % 2 != 0 ? '\r' : '@') != '\r') {
            return AFKeystoreWrapper(aFc1rSDK, aFc1cSDK, AFInAppEventType());
        }
        AFKeystoreWrapper(aFc1rSDK, aFc1cSDK, AFInAppEventType());
        throw null;
    }

    private <T> AFc1jSDK<T> AFKeystoreWrapper(AFc1rSDK aFc1rSDK, AFc1cSDK<T> aFc1cSDK, boolean z7) {
        aFc1rSDK.AFKeystoreWrapper(z7);
        CreateOneLinkHttpTask createOneLinkHttpTask = this.AFKeystoreWrapper;
        AFc1jSDK<T> aFc1jSDK = new AFc1jSDK<>(aFc1rSDK, createOneLinkHttpTask.valueOf, createOneLinkHttpTask.AFInAppEventParameterName, aFc1cSDK);
        int i8 = afInfoLog + 107;
        AFLogger = i8 % 128;
        if (i8 % 2 != 0) {
            return aFc1jSDK;
        }
        throw null;
    }

    @NonNull
    public final AFc1jSDK<AFb1iSDK> AFInAppEventParameterName(boolean z7, boolean z8, @NonNull String str, int i8) {
        String str2;
        int i9 = AFLogger + 43;
        afInfoLog = i9 % 128;
        int i10 = i9 % 2;
        AFd1wSDK aFd1wSDK = this.afErrorLog;
        Intrinsics.f(str, "");
        String str3 = !(z7) ? AFd1wSDK.AFInAppEventType : AFd1wSDK.AFInAppEventParameterName;
        if ((z8 ? (char) 4 : 'V') != 'V') {
            int i11 = afInfoLog + 15;
            AFLogger = i11 % 128;
            int i12 = i11 % 2;
            str2 = "stg";
        } else {
            int i13 = AFLogger + 17;
            afInfoLog = i13 % 128;
            int i14 = i13 % 2;
            str2 = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        Object[] objArr = new Object[4];
        objArr[0] = AFd1wSDK.AFInAppEventParameterName() ? (String) aFd1wSDK.values.getValue() : "";
        objArr[1] = str2;
        objArr[2] = aFd1wSDK.values();
        objArr[3] = str;
        String format = String.format(str3, Arrays.copyOf(objArr, 4));
        Intrinsics.e(format, "");
        AFc1rSDK aFc1rSDK = new AFc1rSDK(format, "GET");
        aFc1rSDK.valueOf(1500);
        return valueOf(aFc1rSDK, new AFc1gSDK());
    }

    private boolean AFInAppEventType() {
        int i8 = afInfoLog + 29;
        AFLogger = i8 % 128;
        int i9 = i8 % 2;
        if ((!this.afDebugLog.getBoolean(AppsFlyerProperties.HTTP_CACHE, true) ? '^' : 'D') == '^') {
            int i10 = AFLogger + 47;
            afInfoLog = i10 % 128;
            int i11 = i10 % 2;
            return true;
        }
        int i12 = AFLogger + 109;
        afInfoLog = i12 % 128;
        if (i12 % 2 != 0) {
            throw null;
        }
        return false;
    }

    private static String AFKeystoreWrapper(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, "v2");
        String valueOf = AFb1ySDK.valueOf((String[]) arrayList.toArray(new String[0]));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append("v2");
        String AFKeystoreWrapper = AFb1ySDK.AFKeystoreWrapper(valueOf, sb.toString());
        int i8 = afInfoLog + 83;
        AFLogger = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        return AFKeystoreWrapper;
    }

    private static void valueOf(int[] iArr, int i8, Object[] objArr) {
        String str;
        synchronized (AFg1mSDK.AFKeystoreWrapper) {
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length << 1];
            int[] iArr2 = (int[]) afRDLog.clone();
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

    public final AFc1jSDK<Map<String, String>> values(@NonNull String str, @NonNull String str2, @NonNull UUID uuid, @NonNull String str3) {
        String obj = uuid.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(AFInAppEventParameterName, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
        sb.append("/");
        sb.append(str);
        sb.append("?id=");
        sb.append(str2);
        String obj2 = sb.toString();
        Map<String, Object> values2 = values();
        String valueOf = String.valueOf(values2.get("build_number"));
        HashMap hashMap = new HashMap();
        hashMap.put("Af-UUID", uuid.toString());
        hashMap.put("Af-Meta-Sdk-Ver", valueOf);
        hashMap.put("Af-Meta-Counter", String.valueOf(values2.get("counter")));
        hashMap.put("Af-Meta-Model", String.valueOf(values2.get("model")));
        hashMap.put("Af-Meta-Platform", String.valueOf(values2.get("platformextension")));
        hashMap.put("Af-Meta-System-Version", String.valueOf(values2.get("sdk")));
        Object[] objArr = new Object[1];
        valueOf(new int[]{80594839, 1788865157, -1077787898, -1986835446, 771314473, 1329780629}, 12 - (Process.myPid() >> 22), objArr);
        hashMap.put(((String) objArr[0]).intern(), AFKeystoreWrapper(str3, obj, "GET", obj, str, str2, valueOf));
        AFc1jSDK<Map<String, String>> valueOf2 = valueOf(new AFc1rSDK(obj2, null, "GET", hashMap, false), new AFc1bSDK());
        int i8 = AFLogger + 59;
        afInfoLog = i8 % 128;
        if ((i8 % 2 != 0 ? 'J' : '2') != 'J') {
            return valueOf2;
        }
        throw null;
    }

    public final AFc1jSDK<String> AFInAppEventParameterName(AFa1sSDK aFa1sSDK, String str) {
        try {
            AFc1jSDK<String> valueOf = valueOf(new AFc1rSDK(aFa1sSDK.afErrorLog, (byte[]) ((Class) AFa1vSDK.AFInAppEventParameterName(TextUtils.indexOf("", "") + 37, 73 - TextUtils.indexOf("", "", 0), (char) (48064 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("AFKeystoreWrapper", AFa1sSDK.class, String.class).invoke(null, aFa1sSDK, str), "POST", Collections.emptyMap(), aFa1sSDK.valueOf()), new AFc1dSDK());
            int i8 = afInfoLog + 61;
            AFLogger = i8 % 128;
            int i9 = i8 % 2;
            return valueOf;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public final AFc1jSDK<String> values(@NonNull String str) {
        AFc1jSDK<String> valueOf = valueOf(new AFc1rSDK(str, null, "GET", Collections.emptyMap(), false).valueOf(10000).afErrorLogForExcManagerOnly(), new AFc1dSDK());
        int i8 = AFLogger + 101;
        afInfoLog = i8 % 128;
        if (i8 % 2 == 0) {
            return valueOf;
        }
        throw null;
    }

    private Map<String, Object> values() {
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.10.2");
        hashMap.put("counter", Integer.valueOf(this.valueOf.valueOf.AFInAppEventType("appsFlyerCount", 0)));
        hashMap.put("model", Build.MODEL);
        Object[] objArr = new Object[1];
        valueOf(new int[]{1178321395, -716875729, -127298173, -1662430870}, (-16777211) - Color.rgb(0, 0, 0), objArr);
        hashMap.put(((String) objArr[0]).intern(), Build.BRAND);
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        Context context = this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper;
        hashMap.put("app_version_name", AFa1cSDK.values(context, context.getPackageName()));
        hashMap.put("app_id", this.valueOf.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        hashMap.put("platformextension", new AFb1vSDK().AFKeystoreWrapper());
        int i8 = afInfoLog + 35;
        AFLogger = i8 % 128;
        int i9 = i8 % 2;
        return hashMap;
    }
}
