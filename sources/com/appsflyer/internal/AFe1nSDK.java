package com.appsflyer.internal;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFe1pSDK;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFe1nSDK {
    Map<String, Object> AFInAppEventParameterName;
    public volatile String AFInAppEventType;
    @NonNull
    private final AFe1pSDK afDebugLog;
    @NonNull
    public final AFc1sSDK valueOf;
    public volatile String values;
    private boolean afInfoLog = false;
    public volatile boolean AFKeystoreWrapper = false;

    public AFe1nSDK(@NonNull AFc1sSDK aFc1sSDK, @NonNull AFe1pSDK aFe1pSDK) {
        this.valueOf = aFc1sSDK;
        this.afDebugLog = aFe1pSDK;
    }

    private boolean AFInAppEventType() {
        Map<String, Object> map = this.AFInAppEventParameterName;
        if (map != null && !map.isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean AFInAppEventParameterName() {
        return this.AFKeystoreWrapper;
    }

    public final boolean AFKeystoreWrapper() {
        if (this.afInfoLog && !AFInAppEventType()) {
            return true;
        }
        return false;
    }

    @NonNull
    public final Map<String, Object> valueOf() {
        HashMap hashMap = new HashMap();
        if (AFInAppEventType()) {
            hashMap.put("lvl", this.AFInAppEventParameterName);
        } else if (this.afInfoLog) {
            HashMap hashMap2 = new HashMap();
            this.AFInAppEventParameterName = hashMap2;
            hashMap2.put("error", "operation timed out.");
            hashMap.put("lvl", this.AFInAppEventParameterName);
        }
        return hashMap;
    }

    public final String values(AFc1ySDK aFc1ySDK) {
        String str;
        boolean z7 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI, false);
        String values = aFc1ySDK.values("imeiCached", null);
        if (z7 && AFb1mSDK.valueOf(this.AFInAppEventType)) {
            Context context = this.valueOf.AFKeystoreWrapper;
            if (context != null && AFInAppEventParameterName(context)) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    str = (String) telephonyManager.getClass().getMethod("getDeviceId", new Class[0]).invoke(telephonyManager, new Object[0]);
                } catch (InvocationTargetException e8) {
                    if (values != null) {
                        AFLogger.afDebugLog("use cached IMEI: ".concat(values));
                    } else {
                        values = null;
                    }
                    StringBuilder sb = new StringBuilder("WARNING: Can't collect IMEI because of missing permissions: ");
                    sb.append(e8.getMessage());
                    AFLogger.afErrorLog(sb.toString(), e8);
                } catch (Exception e9) {
                    if (values != null) {
                        AFLogger.afDebugLog("use cached IMEI: ".concat(values));
                    } else {
                        values = null;
                    }
                    StringBuilder sb2 = new StringBuilder("WARNING: Can't collect IMEI: other reason: ");
                    sb2.append(e9.getMessage());
                    AFLogger.afErrorLog(sb2.toString(), e9);
                }
                if (str == null) {
                    if (values != null) {
                        AFLogger.afDebugLog("use cached IMEI: ".concat(values));
                    } else {
                        values = null;
                    }
                    str = values;
                }
            }
            str = null;
        } else {
            if (this.AFInAppEventType != null) {
                str = this.AFInAppEventType;
            }
            str = null;
        }
        if (!AFb1mSDK.valueOf(str)) {
            aFc1ySDK.valueOf("imeiCached", str);
            return str;
        }
        AFLogger.afInfoLog("IMEI was not collected.");
        return null;
    }

    private static boolean AFInAppEventParameterName(Context context) {
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false))) {
            AFb1xSDK.AFInAppEventType();
            if (AFb1xSDK.valueOf(context)) {
                return false;
            }
        }
        return true;
    }

    public final boolean values() {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            final AFe1pSDK aFe1pSDK = this.afDebugLog;
            Context context = this.valueOf.AFKeystoreWrapper;
            final AFe1pSDK.AFa1vSDK aFa1vSDK = new AFe1pSDK.AFa1vSDK() { // from class: com.appsflyer.internal.AFe1nSDK.5
                @Override // com.appsflyer.internal.AFe1pSDK.AFa1vSDK
                public final void valueOf(String str, Exception exc) {
                    AFe1nSDK.this.AFInAppEventParameterName = new ConcurrentHashMap();
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AFe1nSDK.this.AFInAppEventParameterName.put("error", message);
                    AFLogger.afErrorLog(str, exc, true, true, false);
                }

                @Override // com.appsflyer.internal.AFe1pSDK.AFa1vSDK
                public final void values(@NonNull String str, @NonNull String str2) {
                    AFe1nSDK.this.AFInAppEventParameterName = new ConcurrentHashMap();
                    AFe1nSDK.this.AFInAppEventParameterName.put("signedData", str);
                    AFe1nSDK.this.AFInAppEventParameterName.put("signature", str2);
                    AFe1nSDK.this.AFInAppEventParameterName.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }
            };
            try {
                try {
                    Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                    Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                    cls.getMethod("checkLicense", Long.TYPE, Context.class, cls2).invoke(null, Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.appsflyer.internal.AFe1pSDK.5
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            String str;
                            String str2;
                            if (method.getName().equals("onLvlResult")) {
                                Object obj2 = objArr[0];
                                if (obj2 != null) {
                                    str = (String) obj2;
                                } else {
                                    str = null;
                                }
                                Object obj3 = objArr[1];
                                if (obj3 != null) {
                                    str2 = (String) obj3;
                                } else {
                                    str2 = null;
                                }
                                AFa1vSDK aFa1vSDK2 = aFa1vSDK;
                                if (aFa1vSDK2 != null) {
                                    if (str != null && str2 != null) {
                                        aFa1vSDK2.values(str, str2);
                                    } else if (str2 == null) {
                                        aFa1vSDK2.valueOf("onLvlResult with error", new Exception("AFLVL Invalid signature"));
                                    } else {
                                        aFa1vSDK2.valueOf("onLvlResult with error", new Exception("AFLVL Invalid signedData"));
                                    }
                                } else {
                                    AFLogger.afDebugLog("onLvlResult invocation succeeded, but listener is null");
                                }
                            } else if (method.getName().equals("onLvlFailure")) {
                                AFa1vSDK aFa1vSDK3 = aFa1vSDK;
                                if (aFa1vSDK3 != null) {
                                    Object obj4 = objArr[0];
                                    if (obj4 != null) {
                                        aFa1vSDK3.valueOf("onLvlFailure with exception", (Exception) obj4);
                                    } else {
                                        aFa1vSDK3.valueOf("onLvlFailure", new Exception("unknown"));
                                    }
                                } else {
                                    AFLogger.afDebugLog("onLvlFailure: listener is null");
                                }
                            } else {
                                AFa1vSDK aFa1vSDK4 = aFa1vSDK;
                                if (aFa1vSDK4 != null) {
                                    aFa1vSDK4.valueOf("lvlInvocation failed", new Exception("com.appsflyer.lvl.AppsFlyerLVL$resultListener invocation failed"));
                                }
                            }
                            return null;
                        }
                    }));
                } catch (ClassNotFoundException e8) {
                    aFa1vSDK.valueOf(e8.getClass().getSimpleName(), e8);
                } catch (NoSuchMethodException e9) {
                    aFa1vSDK.valueOf(e9.getClass().getSimpleName(), e9);
                }
            } catch (IllegalAccessException e10) {
                aFa1vSDK.valueOf(e10.getClass().getSimpleName(), e10);
            } catch (InvocationTargetException e11) {
                aFa1vSDK.valueOf(e11.getClass().getSimpleName(), e11);
            }
            this.afInfoLog = true;
        } catch (ClassNotFoundException unused) {
            this.afInfoLog = false;
        }
        return this.afInfoLog;
    }
}
