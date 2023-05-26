package com.appsflyer.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AFKeystoreWrapper;
import com.appsflyer.AFLogger;
import com.appsflyer.AFVersionDeclaration;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.PurchaseHandler;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFa1rSDK;
import com.appsflyer.internal.AFb1bSDK;
import com.appsflyer.internal.AFb1dSDK;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.AFd1cSDK;
import com.appsflyer.internal.AFd1sSDK;
import com.appsflyer.internal.AFf1kSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.google.android.gms.common.GoogleApiAvailability;
import com.sinch.android.rtc.internal.client.DeviceInformation;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URI;
import java.security.KeyStoreException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFb1xSDK extends AppsFlyerLib {
    public static final String AFInAppEventParameterName;
    public static volatile AppsFlyerConversionListener AFInAppEventType = null;
    public static final String AFKeystoreWrapper;
    private static int AppsFlyerConversionListener = 0;
    private static String afDebugLog = null;
    private static AFb1xSDK afInfoLog = null;
    private static char onConversionDataFail = 0;
    private static char onDeepLinking = 0;
    private static char onResponse = 0;
    private static char onResponseError = 0;
    private static int onValidateInAppFailure = 1;
    static final String valueOf;
    static AppsFlyerInAppPurchaseValidatorListener values;
    public AFa1eSDK AFLogger;
    private Map<Long, String> AFVersionDeclaration;
    String afErrorLog;
    private String afWarnLog;
    private Application init;
    private boolean onAppOpenAttributionNative;
    @NonNull
    private final AFc1tSDK onAttributionFailure;
    private String onAttributionFailureNative;
    private AFb1eSDK onConversionDataSuccess;
    private boolean onInstallConversionFailureNative;
    private Map<String, Object> onResponseErrorNative;
    private SharedPreferences onResponseNative;
    private long afRDLog = -1;
    private long AFLogger$LogLevel = -1;
    private long getLevel = TimeUnit.SECONDS.toMillis(5);
    private boolean afErrorLogForExcManagerOnly = false;
    private final AFb1vSDK AppsFlyer2dXConversionCallback = new AFb1vSDK();
    private boolean onInstallConversionDataLoadedNative = false;
    private boolean onDeepLinkingNative = false;
    private final Executor onAppOpenAttribution = Executors.newSingleThreadExecutor();

    /* renamed from: com.appsflyer.internal.AFb1xSDK$4  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] AFKeystoreWrapper;

        static {
            int[] iArr = new int[AppsFlyerProperties.EmailsCryptType.values().length];
            AFKeystoreWrapper = iArr;
            try {
                iArr[AppsFlyerProperties.EmailsCryptType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                AFKeystoreWrapper[AppsFlyerProperties.EmailsCryptType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AFa1vSDK implements Runnable {
        private final AFa1sSDK AFKeystoreWrapper;

        /* synthetic */ AFa1vSDK(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK, byte b8) {
            this(aFa1sSDK);
        }

        @Override // java.lang.Runnable
        public final void run() {
            AFb1xSDK.AFInAppEventParameterName(AFb1xSDK.this, this.AFKeystoreWrapper);
        }

        private AFa1vSDK(AFa1sSDK aFa1sSDK) {
            this.AFKeystoreWrapper = aFa1sSDK;
        }
    }

    /* loaded from: classes.dex */
    class AFa1wSDK implements AFd1uSDK {
        private AFa1wSDK() {
        }

        private static boolean valueOf() {
            if (AFb1xSDK.AFInAppEventType != null) {
                return true;
            }
            return false;
        }

        @Override // com.appsflyer.internal.AFd1uSDK
        public final void AFInAppEventParameterName(AFd1pSDK<?> aFd1pSDK) {
        }

        @Override // com.appsflyer.internal.AFd1uSDK
        public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK) {
            if (aFd1pSDK instanceof AFd1aSDK) {
                AFb1xSDK.this.AFKeystoreWrapper().AFLogger().AFInAppEventType(((AFe1zSDK) aFd1pSDK).afRDLog.afInfoLog);
            }
        }

        /* synthetic */ AFa1wSDK(AFb1xSDK aFb1xSDK, byte b8) {
            this();
        }

        @Override // com.appsflyer.internal.AFd1uSDK
        public final void AFKeystoreWrapper(AFd1pSDK<?> aFd1pSDK, AFd1tSDK aFd1tSDK) {
            JSONObject values;
            AFb1uSDK AFKeystoreWrapper;
            if (aFd1pSDK instanceof AFe1zSDK) {
                AFe1zSDK aFe1zSDK = (AFe1zSDK) aFd1pSDK;
                boolean z7 = aFd1pSDK instanceof AFd1aSDK;
                if (z7 && valueOf()) {
                    AFd1aSDK aFd1aSDK = (AFd1aSDK) aFd1pSDK;
                    boolean z8 = true;
                    if (aFd1aSDK.valueOf != AFd1tSDK.SUCCESS && aFd1aSDK.AFInAppEventParameterName != 1) {
                        z8 = false;
                    }
                    if (z8) {
                        AFe1gSDK aFe1gSDK = new AFe1gSDK(aFd1aSDK, AFb1xSDK.this.AFKeystoreWrapper().afInfoLog());
                        AFd1sSDK afDebugLog = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
                        afDebugLog.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFe1gSDK));
                    }
                }
                if (aFd1tSDK == AFd1tSDK.SUCCESS) {
                    AFb1xSDK aFb1xSDK = AFb1xSDK.this;
                    aFb1xSDK.AFInAppEventType(AFb1xSDK.values(aFb1xSDK)).valueOf("sentSuccessfully", "true");
                    if (!(aFd1pSDK instanceof AFd1dSDK) && (AFKeystoreWrapper = new AFe1lSDK(AFb1xSDK.values(AFb1xSDK.this)).AFKeystoreWrapper()) != null && AFKeystoreWrapper.AFKeystoreWrapper()) {
                        String str = AFKeystoreWrapper.AFKeystoreWrapper;
                        AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(String.valueOf(str)));
                        AFe1lSDK.AFKeystoreWrapper(str);
                    }
                    ResponseNetwork responseNetwork = aFe1zSDK.afErrorLog;
                    if (responseNetwork != null && (values = AFb1qSDK.values((String) responseNetwork.getBody())) != null) {
                        AFb1xSDK.AFInAppEventType(AFb1xSDK.this, values.optBoolean("send_background", false));
                    }
                    if (z7) {
                        AFb1xSDK.valueOf(AFb1xSDK.this, System.currentTimeMillis());
                    }
                }
            } else if (!(aFd1pSDK instanceof AFe1gSDK) || aFd1tSDK == AFd1tSDK.SUCCESS) {
            } else {
                AFe1mSDK aFe1mSDK = new AFe1mSDK(AFb1xSDK.this.AFKeystoreWrapper());
                AFd1sSDK afDebugLog2 = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
                afDebugLog2.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFe1mSDK));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class AFa1ySDK implements Runnable {
        private final AFa1sSDK valueOf;

        /* synthetic */ AFa1ySDK(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK, byte b8) {
            this(aFa1sSDK);
        }

        @Override // java.lang.Runnable
        public final void run() {
            AFd1aSDK aFd1aSDK;
            if (this.valueOf.AFInAppEventParameterName()) {
                AFd1aSDK aFd1aSDK2 = new AFd1aSDK(this.valueOf, AFb1xSDK.this.AFKeystoreWrapper());
                aFd1aSDK2.afErrorLogForExcManagerOnly = AFb1xSDK.valueOf(AFb1xSDK.this);
                aFd1aSDK = aFd1aSDK2;
            } else {
                aFd1aSDK = new AFe1zSDK(this.valueOf, AFb1xSDK.this.AFKeystoreWrapper());
            }
            AFd1sSDK afDebugLog = AFb1xSDK.this.AFKeystoreWrapper().afDebugLog();
            afDebugLog.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1aSDK));
        }

        private AFa1ySDK(AFa1sSDK aFa1sSDK) {
            this.valueOf = aFa1sSDK;
        }
    }

    static {
        AFInAppEventParameterName();
        valueOf = "233";
        Object[] objArr = new Object[1];
        values("䩲읐", (ViewConfiguration.getScrollBarSize() >> 8) + 1, objArr);
        String substring = "6.10.2".substring(0, "6.10.2".lastIndexOf(((String) objArr[0]).intern()));
        AFKeystoreWrapper = substring;
        afDebugLog = "https://%sstats.%s/stats";
        StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append("/androidevent?buildnumber=6.10.2&app_id=");
        AFInAppEventParameterName = sb.toString();
        values = null;
        AFInAppEventType = null;
        afInfoLog = new AFb1xSDK();
        int i8 = AppsFlyerConversionListener + 81;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
    }

    public AFb1xSDK() {
        AFVersionDeclaration.init();
        this.onAttributionFailure = new AFc1tSDK();
        AFd1sSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
        afDebugLog2.values.add(new AFa1wSDK(this, (byte) 0));
    }

    static void AFInAppEventParameterName() {
        onDeepLinking = (char) 59415;
        onResponseError = (char) 21033;
        onConversionDataFail = (char) 39153;
        onResponse = (char) 61471;
    }

    static /* synthetic */ void AFInAppEventParameterName(AFb1xSDK aFb1xSDK, AFa1sSDK aFa1sSDK) {
        int i8 = AppsFlyerConversionListener + 109;
        onValidateInAppFailure = i8 % 128;
        char c8 = i8 % 2 == 0 ? '\f' : '\\';
        aFb1xSDK.valueOf(aFa1sSDK);
        if (c8 == '\\') {
            return;
        }
        throw null;
    }

    static /* synthetic */ boolean AFInAppEventType(AFb1xSDK aFb1xSDK, boolean z7) {
        int i8 = AppsFlyerConversionListener;
        int i9 = i8 + 79;
        onValidateInAppFailure = i9 % 128;
        int i10 = i9 % 2;
        aFb1xSDK.onInstallConversionDataLoadedNative = z7;
        int i11 = i8 + 97;
        onValidateInAppFailure = i11 % 128;
        if ((i11 % 2 == 0 ? 'L' : 'C') != 'L') {
            return z7;
        }
        int i12 = 17 / 0;
        return z7;
    }

    static /* synthetic */ void AFKeystoreWrapper(AFb1xSDK aFb1xSDK) {
        int i8 = AppsFlyerConversionListener + 41;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        aFb1xSDK.AFVersionDeclaration();
        int i10 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i10 % 128;
        if ((i10 % 2 == 0 ? '.' : '!') != '.') {
            return;
        }
        int i11 = 22 / 0;
    }

    private void AFLogger() {
        AFf1jSDK AFVersionDeclaration = AFKeystoreWrapper().AFVersionDeclaration();
        AFf1pSDK afDebugLog2 = afDebugLog();
        Runnable valueOf2 = valueOf(afDebugLog2);
        AFVersionDeclaration.AFKeystoreWrapper(afDebugLog2);
        AFVersionDeclaration.AFKeystoreWrapper(new AFf1gSDK(valueOf2));
        AFVersionDeclaration.AFKeystoreWrapper(new AFf1mSDK(valueOf2, AFKeystoreWrapper()));
        AFVersionDeclaration.AFKeystoreWrapper(new AFf1iSDK(valueOf2, AFKeystoreWrapper()));
        if ((!afInfoLog() ? 'V' : '2') != '2') {
            int i8 = onValidateInAppFailure + 107;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            AFVersionDeclaration.valueOf(this.init, valueOf2, AFKeystoreWrapper());
        }
        AFf1kSDK[] AFInAppEventParameterName2 = AFVersionDeclaration.AFInAppEventParameterName();
        int length = AFInAppEventParameterName2.length;
        int i10 = AppsFlyerConversionListener + 7;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                return;
            }
            AFInAppEventParameterName2[i12].valueOf(this.init);
            i12++;
        }
    }

    private boolean AFLogger$LogLevel() {
        int i8 = AppsFlyerConversionListener + 115;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        Map<String, Object> map = this.onResponseErrorNative;
        if ((map != null ? (char) 21 : 'R') == 21 && !map.isEmpty()) {
            return true;
        }
        int i10 = AppsFlyerConversionListener + 83;
        onValidateInAppFailure = i10 % 128;
        if ((i10 % 2 == 0 ? '\\' : '!') != '!') {
            int i11 = 17 / 0;
            return false;
        }
        return false;
    }

    private String AFVersionDeclaration(Context context) {
        int i8 = onValidateInAppFailure + 117;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 == 0) {
            SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(context);
            if ((AFKeystoreWrapper2.contains("INSTALL_STORE") ? (char) 21 : '6') != '6') {
                return AFKeystoreWrapper2.getString("INSTALL_STORE", null);
            }
            String AFLogger$LogLevel = afErrorLog(context) ? AFLogger$LogLevel(context) : null;
            AFInAppEventType(context).valueOf("INSTALL_STORE", AFLogger$LogLevel);
            int i9 = AppsFlyerConversionListener + 103;
            onValidateInAppFailure = i9 % 128;
            if (i9 % 2 == 0) {
                int i10 = 83 / 0;
                return AFLogger$LogLevel;
            }
            return AFLogger$LogLevel;
        }
        AFKeystoreWrapper(context).contains("INSTALL_STORE");
        throw null;
    }

    private AFf1pSDK afDebugLog() {
        AFf1pSDK aFf1pSDK = new AFf1pSDK(new Runnable() { // from class: com.appsflyer.internal.h
            @Override // java.lang.Runnable
            public final void run() {
                AFb1xSDK.this.afWarnLog();
            }
        }, AFKeystoreWrapper().AFKeystoreWrapper());
        int i8 = onValidateInAppFailure + 7;
        AppsFlyerConversionListener = i8 % 128;
        if ((i8 % 2 != 0 ? '2' : 'P') == 'P') {
            return aFf1pSDK;
        }
        throw null;
    }

    private static String afErrorLog() {
        int i8 = onValidateInAppFailure + 25;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        String AFInAppEventType2 = AFInAppEventType(AppsFlyerProperties.APP_ID);
        int i10 = AppsFlyerConversionListener + 17;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            return AFInAppEventType2;
        }
        throw null;
    }

    private String afErrorLogForExcManagerOnly(Context context) {
        File afDebugLog2 = afDebugLog(values("ro.appsflyer.preinstall.path"));
        if (values(afDebugLog2)) {
            afDebugLog2 = afDebugLog(AFInAppEventParameterName(context, "AF_PRE_INSTALL_PATH"));
        }
        if (values(afDebugLog2)) {
            int i8 = onValidateInAppFailure + 105;
            AppsFlyerConversionListener = i8 % 128;
            if (i8 % 2 != 0) {
                afDebugLog("/data/local/tmp/pre_install.appsflyer");
                throw null;
            }
            afDebugLog2 = afDebugLog("/data/local/tmp/pre_install.appsflyer");
        }
        if (!(values(afDebugLog2) ? false : true)) {
            afDebugLog2 = afDebugLog("/etc/pre_install.appsflyer");
        }
        if (values(afDebugLog2)) {
            int i9 = AppsFlyerConversionListener + 77;
            int i10 = i9 % 128;
            onValidateInAppFailure = i10;
            if (i9 % 2 == 0) {
                throw null;
            }
            int i11 = i10 + 61;
            AppsFlyerConversionListener = i11 % 128;
            int i12 = i11 % 2;
            return null;
        }
        return AFInAppEventType(afDebugLog2, context.getPackageName());
    }

    private boolean afInfoLog() {
        int i8 = AppsFlyerConversionListener + 59;
        onValidateInAppFailure = i8 % 128;
        if ((i8 % 2 == 0 ? 'K' : 'I') != 'I') {
            AFKeystoreWrapper().values().valueOf("AF_PREINSTALL_DISABLED");
            throw null;
        }
        boolean valueOf2 = AFKeystoreWrapper().values().valueOf("AF_PREINSTALL_DISABLED");
        int i9 = onValidateInAppFailure + 105;
        AppsFlyerConversionListener = i9 % 128;
        int i10 = i9 % 2;
        return valueOf2;
    }

    private void afRDLog(Context context) {
        this.onResponseErrorNative = new HashMap();
        final long currentTimeMillis = System.currentTimeMillis();
        final AFa1rSDK.AFa1vSDK aFa1vSDK = new AFa1rSDK.AFa1vSDK() { // from class: com.appsflyer.internal.AFb1xSDK.3
            @Override // com.appsflyer.internal.AFa1rSDK.AFa1vSDK
            public final void valueOf(String str) {
                AFb1xSDK.valueOf(AFb1xSDK.this).put("error", str);
            }

            @Override // com.appsflyer.internal.AFa1rSDK.AFa1vSDK
            public final void values(String str, String str2, String str3) {
                if (str != null) {
                    AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(str));
                    AFb1xSDK.valueOf(AFb1xSDK.this).put("link", str);
                    if (str2 != null) {
                        AFb1xSDK.valueOf(AFb1xSDK.this).put("target_url", str2);
                    }
                    if (str3 != null) {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("promo_code", str3);
                        hashMap.put("deeplink_context", hashMap2);
                        AFb1xSDK.valueOf(AFb1xSDK.this).put("extras", hashMap);
                    }
                } else {
                    AFb1xSDK.valueOf(AFb1xSDK.this).put("link", "");
                }
                AFb1xSDK.valueOf(AFb1xSDK.this).put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        };
        try {
            Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", Context.class).invoke(null, context);
            final Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
            Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
            Method method = cls.getMethod("fetchDeferredAppLinkData", Context.class, String.class, cls2);
            Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.appsflyer.internal.AFa1rSDK.1
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                    String str;
                    String str2;
                    String str3;
                    Bundle bundle;
                    if (method2.getName().equals("onDeferredAppLinkDataFetched")) {
                        Object obj2 = objArr[0];
                        if (obj2 != null) {
                            Bundle bundle2 = (Bundle) Bundle.class.cast(cls.getMethod("getArgumentBundle", new Class[0]).invoke(cls.cast(obj2), new Object[0]));
                            if (bundle2 != null) {
                                str2 = bundle2.getString("com.facebook.platform.APPLINK_NATIVE_URL");
                                str3 = bundle2.getString("target_url");
                                Bundle bundle3 = bundle2.getBundle("extras");
                                if (bundle3 != null && (bundle = bundle3.getBundle("deeplink_context")) != null) {
                                    str = bundle.getString("promo_code");
                                } else {
                                    str = null;
                                }
                            } else {
                                str = null;
                                str2 = null;
                                str3 = null;
                            }
                            AFa1vSDK aFa1vSDK2 = aFa1vSDK;
                            if (aFa1vSDK2 != null) {
                                aFa1vSDK2.values(str2, str3, str);
                            }
                        } else {
                            AFa1vSDK aFa1vSDK3 = aFa1vSDK;
                            if (aFa1vSDK3 != null) {
                                aFa1vSDK3.values(null, null, null);
                            }
                        }
                        return null;
                    }
                    AFa1vSDK aFa1vSDK4 = aFa1vSDK;
                    if (aFa1vSDK4 != null) {
                        aFa1vSDK4.valueOf("onDeferredAppLinkDataFetched invocation failed");
                    }
                    return null;
                }
            });
            String string = context.getString(context.getResources().getIdentifier("facebook_app_id", "string", context.getPackageName()));
            if ((TextUtils.isEmpty(string) ? '0' : 'R') != '0') {
                method.invoke(null, context, string, newProxyInstance);
                int i8 = onValidateInAppFailure + 71;
                AppsFlyerConversionListener = i8 % 128;
                int i9 = i8 % 2;
                return;
            }
            int i10 = onValidateInAppFailure + 77;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
            aFa1vSDK.valueOf("Facebook app id not defined in resources");
        } catch (ClassNotFoundException e8) {
            AFLogger.afErrorLogForExcManagerOnly("FB class missing error", e8);
            aFa1vSDK.valueOf(e8.toString());
        } catch (IllegalAccessException e9) {
            AFLogger.afErrorLogForExcManagerOnly("FB illegal access", e9);
            aFa1vSDK.valueOf(e9.toString());
        } catch (NoSuchMethodException e10) {
            AFLogger.afErrorLogForExcManagerOnly("FB method missing error", e10);
            aFa1vSDK.valueOf(e10.toString());
        } catch (InvocationTargetException e11) {
            AFLogger.afErrorLogForExcManagerOnly("FB invocation error", e11);
            aFa1vSDK.valueOf(e11.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void afWarnLog() {
        int i8 = onValidateInAppFailure + 105;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        values(AFKeystoreWrapper().AFInAppEventParameterName(), new Runnable() { // from class: com.appsflyer.internal.j
            @Override // java.lang.Runnable
            public final void run() {
                AFb1xSDK.this.getLevel();
            }
        }, 0L, TimeUnit.MILLISECONDS);
        int i10 = onValidateInAppFailure + 35;
        AppsFlyerConversionListener = i10 % 128;
        if (!(i10 % 2 == 0)) {
            int i11 = 11 / 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void getLevel() {
        try {
            AFe1eSDK aFe1eSDK = new AFe1eSDK();
            Application application = this.init;
            if (application != null) {
                int i8 = onValidateInAppFailure + 21;
                AppsFlyerConversionListener = i8 % 128;
                if ((i8 % 2 != 0 ? (char) 26 : 'Q') == 26) {
                    aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                    throw null;
                }
                aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                int i9 = onValidateInAppFailure + 101;
                AppsFlyerConversionListener = i9 % 128;
                int i10 = i9 % 2;
            }
            if (AFInAppEventType(aFe1eSDK, AFKeystoreWrapper(this.init))) {
                valueOf(aFe1eSDK);
                int i11 = onValidateInAppFailure + 81;
                AppsFlyerConversionListener = i11 % 128;
                int i12 = i11 % 2;
            }
            int i13 = onValidateInAppFailure + 85;
            AppsFlyerConversionListener = i13 % 128;
            if (i13 % 2 != 0) {
                int i14 = 61 / 0;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r1 != '%') goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        if (r1 != true) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        r8 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        r1 = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r1.hasNext() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        r3 = (java.net.NetworkInterface) r1.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
        if (r3.isUp() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        r8.add(r3.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
        return r8.contains("tun0");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        com.appsflyer.AFLogger.afErrorLog("Failed collecting ivc data", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        r8 = (android.net.ConnectivityManager) r8.getSystemService("connectivity");
        r1 = r8.getAllNetworks();
        r4 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
        if (r5 >= r4) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        r6 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener + 5;
        com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007f, code lost:
        if ((r6 % 2) != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0081, code lost:
        r6 = r8.getNetworkCapabilities(r1[r5]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008b, code lost:
        if (r6.hasTransport(4) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008e, code lost:
        r6 = r8.getNetworkCapabilities(r1[r5]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0098, code lost:
        if (r6.hasTransport(4) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
        if (r6.hasCapability(15) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:
        r8 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure + 91;
        com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ad, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
        com.appsflyer.AFLogger.afErrorLog("Failed collecting ivc data", r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean onInstallConversionFailureNative(android.content.Context r8) {
        /*
            r0 = 0
            if (r8 == 0) goto Lb5
            int r1 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r1 = r1 + 87
            int r2 = r1 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r2
            int r1 = r1 % 2
            java.lang.String r2 = "Failed collecting ivc data"
            r3 = 1
            if (r1 == 0) goto L22
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 67
            r5 = 37
            if (r1 < r4) goto L1d
            r1 = 37
            goto L1f
        L1d:
            r1 = 64
        L1f:
            if (r1 == r5) goto L64
            goto L2d
        L22:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r1 < r4) goto L2a
            r1 = 1
            goto L2b
        L2a:
            r1 = 0
        L2b:
            if (r1 == r3) goto L64
        L2d:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Exception -> L5f
            java.util.ArrayList r1 = java.util.Collections.list(r1)     // Catch: java.lang.Exception -> L5f
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L5f
        L3e:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Exception -> L5f
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Exception -> L5f
            java.net.NetworkInterface r3 = (java.net.NetworkInterface) r3     // Catch: java.lang.Exception -> L5f
            boolean r4 = r3.isUp()     // Catch: java.lang.Exception -> L5f
            if (r4 == 0) goto L3e
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L5f
            r8.add(r3)     // Catch: java.lang.Exception -> L5f
            goto L3e
        L58:
            java.lang.String r1 = "tun0"
            boolean r8 = r8.contains(r1)     // Catch: java.lang.Exception -> L5f
            return r8
        L5f:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLog(r2, r8)
            goto Lb5
        L64:
            java.lang.String r1 = "connectivity"
            java.lang.Object r8 = r8.getSystemService(r1)     // Catch: java.lang.Exception -> Lb1
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch: java.lang.Exception -> Lb1
            android.net.Network[] r1 = r8.getAllNetworks()     // Catch: java.lang.Exception -> Lb1
            int r4 = r1.length     // Catch: java.lang.Exception -> Lb1
            r5 = 0
        L72:
            if (r5 >= r4) goto Lb0
            int r6 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r6 = r6 + 5
            int r7 = r6 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r7
            int r6 = r6 % 2
            r7 = 4
            if (r6 != 0) goto L8e
            r6 = r1[r5]     // Catch: java.lang.Exception -> Lb1
            android.net.NetworkCapabilities r6 = r8.getNetworkCapabilities(r6)     // Catch: java.lang.Exception -> Lb1
            boolean r7 = r6.hasTransport(r7)     // Catch: java.lang.Exception -> Lb1
            if (r7 == 0) goto Lad
            goto L9a
        L8e:
            r6 = r1[r5]     // Catch: java.lang.Exception -> Lb1
            android.net.NetworkCapabilities r6 = r8.getNetworkCapabilities(r6)     // Catch: java.lang.Exception -> Lb1
            boolean r7 = r6.hasTransport(r7)     // Catch: java.lang.Exception -> Lb1
            if (r7 == 0) goto Lad
        L9a:
            r7 = 15
            boolean r6 = r6.hasCapability(r7)     // Catch: java.lang.Exception -> Lb1
            if (r6 != 0) goto Lad
            int r8 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r8 = r8 + 91
            int r0 = r8 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r0
            int r8 = r8 % 2
            return r3
        Lad:
            int r5 = r5 + 1
            goto L72
        Lb0:
            return r0
        Lb1:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLog(r2, r8)
        Lb5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.onInstallConversionFailureNative(android.content.Context):boolean");
    }

    static /* synthetic */ long valueOf(AFb1xSDK aFb1xSDK, long j8) {
        int i8 = onValidateInAppFailure + 111;
        int i9 = i8 % 128;
        AppsFlyerConversionListener = i9;
        int i10 = i8 % 2;
        aFb1xSDK.AFLogger$LogLevel = j8;
        int i11 = i9 + 49;
        onValidateInAppFailure = i11 % 128;
        if ((i11 % 2 == 0 ? (char) 11 : ' ') != 11) {
            return j8;
        }
        int i12 = 61 / 0;
        return j8;
    }

    static /* synthetic */ Application values(AFb1xSDK aFb1xSDK) {
        int i8 = AppsFlyerConversionListener + 79;
        onValidateInAppFailure = i8 % 128;
        char c8 = i8 % 2 == 0 ? 'U' : (char) 7;
        Application application = aFb1xSDK.init;
        if (c8 == 7) {
            return application;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void addPushNotificationDeepLinkPath(String... strArr) {
        boolean z7;
        List<String> asList = Arrays.asList(strArr);
        List<List<String>> list = AFKeystoreWrapper().onInstallConversionDataLoadedNative().afInfoLog;
        boolean z8 = false;
        if (!list.contains(asList)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            int i8 = onValidateInAppFailure + 41;
            AppsFlyerConversionListener = i8 % 128;
            if (i8 % 2 != 0) {
                z8 = true;
            }
            list.add(asList);
            if (!z8) {
                int i9 = AppsFlyerConversionListener + 65;
                onValidateInAppFailure = i9 % 128;
                int i10 = i9 % 2;
                return;
            }
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void anonymizeUser(boolean z7) {
        int i8 = onValidateInAppFailure + 65;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        boolean z8 = false;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("anonymizeUser", String.valueOf(z7));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z7);
        int i10 = onValidateInAppFailure + 35;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            z8 = true;
        }
        if (!z8) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void appendParametersToDeepLinkingURL(String str, Map<String, String> map) {
        char c8;
        int i8 = onValidateInAppFailure + 119;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            c8 = '-';
        } else {
            c8 = 'P';
        }
        if (c8 == 'P') {
            AFa1tSDK onInstallConversionDataLoadedNative = AFKeystoreWrapper().onInstallConversionDataLoadedNative();
            onInstallConversionDataLoadedNative.values = str;
            onInstallConversionDataLoadedNative.AFInAppEventType = map;
            int i9 = onValidateInAppFailure + 107;
            AppsFlyerConversionListener = i9 % 128;
            int i10 = i9 % 2;
            return;
        }
        AFa1tSDK onInstallConversionDataLoadedNative2 = AFKeystoreWrapper().onInstallConversionDataLoadedNative();
        onInstallConversionDataLoadedNative2.values = str;
        onInstallConversionDataLoadedNative2.AFInAppEventType = map;
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void enableFacebookDeferredApplinks(boolean z7) {
        char c8;
        int i8 = onValidateInAppFailure + 75;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            c8 = '%';
        } else {
            c8 = '?';
        }
        this.onDeepLinkingNative = z7;
        if (c8 != '?') {
            int i9 = 23 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAppsFlyerUID(@NonNull Context context) {
        boolean z7;
        char c8;
        boolean z8 = false;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("getAppsFlyerUID", new String[0]);
        if (context == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i8 = onValidateInAppFailure + 119;
            AppsFlyerConversionListener = i8 % 128;
            if (i8 % 2 != 0) {
                c8 = '.';
            } else {
                c8 = '(';
            }
            if (c8 != '.') {
                return null;
            }
            throw null;
        }
        values(context);
        String AFKeystoreWrapper2 = AFb1wSDK.AFKeystoreWrapper(new WeakReference(AFKeystoreWrapper().values().AFKeystoreWrapper.AFKeystoreWrapper));
        int i9 = AppsFlyerConversionListener + 97;
        onValidateInAppFailure = i9 % 128;
        if (i9 % 2 != 0) {
            z8 = true;
        }
        if (z8) {
            return AFKeystoreWrapper2;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getAttributionId(Context context) {
        boolean z7;
        try {
            String AFInAppEventType2 = new AFa1aSDK(context, AFKeystoreWrapper()).AFInAppEventType();
            int i8 = onValidateInAppFailure + 121;
            AppsFlyerConversionListener = i8 % 128;
            if (i8 % 2 != 0) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                return AFInAppEventType2;
            }
            throw null;
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostName() {
        int i8 = onValidateInAppFailure + 81;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        String values2 = AFKeystoreWrapper().init().values();
        int i10 = onValidateInAppFailure + 71;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
        return values2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getHostPrefix() {
        int i8 = AppsFlyerConversionListener + 99;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        String AFInAppEventType2 = AFKeystoreWrapper().init().AFInAppEventType();
        int i10 = AppsFlyerConversionListener + 37;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        return AFInAppEventType2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getOutOfStore(Context context) {
        boolean z7;
        int i8 = onValidateInAppFailure + 113;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        char c8 = 1;
        if (string != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i10 = onValidateInAppFailure + 55;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 == 0) {
                return string;
            }
            throw null;
        }
        String AFInAppEventParameterName2 = AFInAppEventParameterName(context, "AF_STORE");
        if (AFInAppEventParameterName2 == null) {
            c8 = 3;
        }
        if (c8 != 3) {
            int i11 = AppsFlyerConversionListener + 97;
            onValidateInAppFailure = i11 % 128;
            if (i11 % 2 != 0) {
                return AFInAppEventParameterName2;
            }
            throw null;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final String getSdkVersion() {
        char c8;
        AFc1vSDK AFKeystoreWrapper2;
        int i8 = AppsFlyerConversionListener + 81;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = '\n';
        } else {
            c8 = '/';
        }
        if (c8 != '/') {
            AFKeystoreWrapper2 = AFKeystoreWrapper();
            AFKeystoreWrapper2.afErrorLogForExcManagerOnly().AFInAppEventType("getSdkVersion", new String[0]);
        } else {
            AFKeystoreWrapper2 = AFKeystoreWrapper();
            AFKeystoreWrapper2.afErrorLogForExcManagerOnly().AFInAppEventType("getSdkVersion", new String[0]);
        }
        AFKeystoreWrapper2.values();
        return AFc1zSDK.valueOf();
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final AppsFlyerLib init(@NonNull String str, AppsFlyerConversionListener appsFlyerConversionListener, @NonNull Context context) {
        char c8;
        boolean z7;
        boolean z8;
        String str2;
        if (this.onAppOpenAttributionNative) {
            c8 = 14;
        } else {
            c8 = 15;
        }
        boolean z9 = false;
        if (c8 != 14) {
            this.onAppOpenAttributionNative = true;
            AFKeystoreWrapper().getLevel().values = str;
            AFc1rSDK.AFKeystoreWrapper(str);
            if (context != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                int i8 = AppsFlyerConversionListener + 125;
                onValidateInAppFailure = i8 % 128;
                int i9 = i8 % 2;
                this.init = (Application) context.getApplicationContext();
                values(context);
                AFKeystoreWrapper().AFLogger().AFKeystoreWrapper = System.currentTimeMillis();
                AFKeystoreWrapper().onConversionDataSuccess().values();
                AFKeystoreWrapper().afRDLog().values(new AFe1xSDK() { // from class: com.appsflyer.internal.i
                    @Override // com.appsflyer.internal.AFe1xSDK
                    public final void onRemoteConfigUpdateFinished(AFe1vSDK aFe1vSDK) {
                        AFb1xSDK.this.AFKeystoreWrapper(aFe1vSDK);
                    }
                });
                AFLogger();
                this.onAttributionFailure.getLevel().values();
                AFb1cSDK.AFKeystoreWrapper = this.init;
            } else {
                AFLogger.afWarnLog("context is null, Google Install Referrer will be not initialized");
            }
            AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[2];
            strArr[0] = str;
            if (appsFlyerConversionListener == null) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (!z8) {
                int i10 = AppsFlyerConversionListener + 121;
                onValidateInAppFailure = i10 % 128;
                int i11 = i10 % 2;
                str2 = "null";
            } else {
                str2 = "conversionDataListener";
            }
            strArr[1] = str2;
            afErrorLogForExcManagerOnly.AFInAppEventType("init", strArr);
            AFLogger.values(String.format("Initializing AppsFlyer SDK: (v%s.%s)", "6.10.2", valueOf));
            AFInAppEventType = appsFlyerConversionListener;
            return this;
        }
        int i12 = onValidateInAppFailure + 43;
        AppsFlyerConversionListener = i12 % 128;
        if (i12 % 2 == 0) {
            z9 = true;
        }
        if (z9) {
            return this;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final boolean isPreInstalledApp(Context context) {
        char c8;
        char c9;
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                c8 = '?';
            } else {
                c8 = '!';
            }
            if (c8 != '!') {
                int i8 = AppsFlyerConversionListener + 71;
                int i9 = i8 % 128;
                onValidateInAppFailure = i9;
                int i10 = i8 % 2;
                int i11 = i9 + 37;
                AppsFlyerConversionListener = i11 % 128;
                if (i11 % 2 != 0) {
                    c9 = '=';
                } else {
                    c9 = 19;
                }
                if (c9 != '=') {
                    return true;
                }
                throw null;
            }
        } catch (PackageManager.NameNotFoundException e8) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e8);
        }
        return false;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final boolean isStopped() {
        char c8;
        char c9;
        int i8 = AppsFlyerConversionListener + 97;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = 'G';
        } else {
            c8 = ',';
        }
        if (c8 == ',') {
            boolean AFInAppEventParameterName2 = AFKeystoreWrapper().getLevel().AFInAppEventParameterName();
            int i9 = onValidateInAppFailure + 99;
            AppsFlyerConversionListener = i9 % 128;
            if (i9 % 2 != 0) {
                c9 = 'b';
            } else {
                c9 = 16;
            }
            if (c9 != 16) {
                int i10 = 99 / 0;
                return AFInAppEventParameterName2;
            }
            return AFInAppEventParameterName2;
        }
        AFKeystoreWrapper().getLevel().AFInAppEventParameterName();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(Context context, String str, Map<String, Object> map) {
        int i8 = onValidateInAppFailure + 81;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        logEvent(context, str, map, null);
        int i10 = AppsFlyerConversionListener + 101;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logLocation(Context context, double d8, double d9) {
        char c8;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("logLocation", String.valueOf(d8), String.valueOf(d9));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d9));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d8));
        values(context, AFInAppEventType.LOCATION_COORDINATES, hashMap);
        int i8 = AppsFlyerConversionListener + 47;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = '\f';
        } else {
            c8 = '6';
        }
        if (c8 != '\f') {
            return;
        }
        int i9 = 44 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logSession(Context context) {
        int i8 = onValidateInAppFailure + 67;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("logSession", new String[0]);
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().valueOf();
        valueOf(context, AFe1hSDK.logSession);
        values(context, (String) null, (Map<String, Object>) null);
        int i10 = onValidateInAppFailure + 117;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void onPause(Context context) {
        char c8;
        int i8 = AppsFlyerConversionListener + 53;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = 27;
        } else {
            c8 = 'K';
        }
        if (c8 != 'K') {
            AFKeystoreWrapper().onAttributionFailureNative().AFKeystoreWrapper(context);
            int i9 = 86 / 0;
        } else {
            AFKeystoreWrapper().onAttributionFailureNative().AFKeystoreWrapper(context);
        }
        int i10 = onValidateInAppFailure + 123;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void performOnAppAttribution(@NonNull Context context, @NonNull URI uri) {
        boolean z7;
        char c8;
        int i8 = AppsFlyerConversionListener + 27;
        int i9 = i8 % 128;
        onValidateInAppFailure = i9;
        int i10 = i8 % 2;
        if (uri != null) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            int i11 = i9 + 79;
            AppsFlyerConversionListener = i11 % 128;
            int i12 = i11 % 2;
            if (!uri.toString().isEmpty()) {
                if (context == null) {
                    StringBuilder sb = new StringBuilder("Context is \"");
                    sb.append(context);
                    sb.append("\"");
                    AFb1nSDK.AFInAppEventType(sb.toString(), DeepLinkResult.Error.NETWORK);
                    return;
                }
                AFKeystoreWrapper().onInstallConversionDataLoadedNative();
                AFa1tSDK.values(context, new HashMap(), Uri.parse(uri.toString()));
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder("Link is \"");
        sb2.append(uri);
        sb2.append("\"");
        AFb1nSDK.AFInAppEventType(sb2.toString(), DeepLinkResult.Error.NETWORK);
        int i13 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i13 % 128;
        if (i13 % 2 == 0) {
            c8 = 'Y';
        } else {
            c8 = '6';
        }
        if (c8 == '6') {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void performOnDeepLinking(@NonNull final Intent intent, @NonNull Context context) {
        char c8;
        char c9;
        int i8 = onValidateInAppFailure + 85;
        int i9 = i8 % 128;
        AppsFlyerConversionListener = i9;
        if (i8 % 2 != 0) {
            c8 = '^';
        } else {
            c8 = 'F';
        }
        if (c8 != '^') {
            if (intent == null) {
                c9 = '@';
            } else {
                c9 = 29;
            }
            if (c9 != 29) {
                AFb1nSDK.AFInAppEventType("performOnDeepLinking was called with null intent", DeepLinkResult.Error.DEVELOPER_ERROR);
                return;
            } else if (context == null) {
                int i10 = i9 + 109;
                onValidateInAppFailure = i10 % 128;
                if (i10 % 2 == 0) {
                    AFb1nSDK.AFInAppEventType("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
                    int i11 = 61 / 0;
                    return;
                }
                AFb1nSDK.AFInAppEventType("performOnDeepLinking was called with null context", DeepLinkResult.Error.DEVELOPER_ERROR);
                return;
            } else {
                final Context applicationContext = context.getApplicationContext();
                values(applicationContext);
                AFKeystoreWrapper().AFKeystoreWrapper().execute(new Runnable() { // from class: com.appsflyer.internal.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AFb1xSDK.this.AFKeystoreWrapper(applicationContext, intent);
                    }
                });
                return;
            }
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        int i8 = onValidateInAppFailure + 71;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("registerConversionListener", new String[0]);
        AFInAppEventParameterName(appsFlyerConversionListener);
        int i10 = onValidateInAppFailure + 11;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        char c8;
        int i8 = AppsFlyerConversionListener + 11;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            c8 = '8';
        } else {
            c8 = '&';
        }
        if (c8 != '&') {
            int i10 = AppsFlyerConversionListener + 15;
            onValidateInAppFailure = i10 % 128;
            int i11 = i10 % 2;
            AFLogger.afDebugLog("registerValidatorListener null listener");
            int i12 = AppsFlyerConversionListener + 65;
            onValidateInAppFailure = i12 % 128;
            int i13 = i12 % 2;
            return;
        }
        values = appsFlyerInAppPurchaseValidatorListener;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendAdRevenue(Context context, Map<String, Object> map) {
        char c8;
        char c9;
        Activity activity;
        values(context);
        AFe1cSDK aFe1cSDK = new AFe1cSDK();
        if (context != null) {
            c8 = '?';
        } else {
            c8 = '.';
        }
        if (c8 == '?') {
            int i8 = AppsFlyerConversionListener + 67;
            onValidateInAppFailure = i8 % 128;
            int i9 = i8 % 2;
            aFe1cSDK.AFInAppEventType = (Application) context.getApplicationContext();
            int i10 = AppsFlyerConversionListener + 117;
            onValidateInAppFailure = i10 % 128;
            int i11 = i10 % 2;
        }
        int AFInAppEventType2 = AFInAppEventType(AFKeystoreWrapper(context));
        aFe1cSDK.AFKeystoreWrapper().put("ad_network", map);
        aFe1cSDK.AFKeystoreWrapper().put("adrevenue_counter", Integer.valueOf(AFInAppEventType2));
        if (context instanceof Activity) {
            c9 = ' ';
        } else {
            c9 = 29;
        }
        if (c9 != ' ') {
            activity = null;
        } else {
            int i12 = AppsFlyerConversionListener + 43;
            onValidateInAppFailure = i12 % 128;
            int i13 = i12 % 2;
            activity = (Activity) context;
        }
        AFKeystoreWrapper(aFe1cSDK, activity);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendInAppPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        int i8 = AppsFlyerConversionListener + 67;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        values(context);
        PurchaseHandler afErrorLog = AFKeystoreWrapper().afErrorLog();
        if (afErrorLog.values(map, purchaseValidationCallback, "purchases")) {
            AFd1hSDK aFd1hSDK = new AFd1hSDK(map, purchaseValidationCallback, afErrorLog.AFInAppEventParameterName);
            AFd1sSDK aFd1sSDK = afErrorLog.values;
            aFd1sSDK.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1hSDK));
            int i10 = AppsFlyerConversionListener + 125;
            onValidateInAppFailure = i10 % 128;
            int i11 = i10 % 2;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void sendPurchaseData(Context context, Map<String, Object> map, PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback) {
        int i8 = onValidateInAppFailure + 39;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        values(context);
        PurchaseHandler afErrorLog = AFKeystoreWrapper().afErrorLog();
        if (afErrorLog.values(map, purchaseValidationCallback, "subscriptions")) {
            AFd1nSDK aFd1nSDK = new AFd1nSDK(map, purchaseValidationCallback, afErrorLog.AFInAppEventParameterName);
            AFd1sSDK aFd1sSDK = afErrorLog.values;
            aFd1sSDK.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1nSDK));
            int i10 = onValidateInAppFailure + 123;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01aa  */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void sendPushNotificationData(@androidx.annotation.NonNull android.app.Activity r17) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.sendPushNotificationData(android.app.Activity):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAdditionalData(Map<String, Object> map) {
        boolean z7;
        int i8 = onValidateInAppFailure + 9;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            if (map != null) {
                AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setAdditionalData", map.toString());
                AppsFlyerProperties.getInstance().setCustomData(new JSONObject(map).toString());
            }
            int i9 = AppsFlyerConversionListener + 113;
            onValidateInAppFailure = i9 % 128;
            int i10 = i9 % 2;
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAndroidIdData(String str) {
        char c8;
        int i8 = AppsFlyerConversionListener + 25;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = 28;
        } else {
            c8 = '4';
        }
        if (c8 != '4') {
            AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[1] = str;
            afErrorLogForExcManagerOnly.AFInAppEventType("setAndroidIdData", strArr);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setAndroidIdData", str);
        }
        this.afErrorLog = str;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setAppId(String str) {
        char c8;
        int i8 = onValidateInAppFailure + 105;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setAppId", str);
        valueOf(AppsFlyerProperties.APP_ID, str);
        int i10 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            c8 = 26;
        } else {
            c8 = '=';
        }
        if (c8 == '=') {
            return;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004f, code lost:
        if (r1 != '^') goto L9;
     */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setAppInviteOneLink(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r0 = r0 + 95
            int r1 = r0 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r1
            int r0 = r0 % 2
            com.appsflyer.internal.AFc1vSDK r0 = r3.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1sSDK r0 = r0.afErrorLogForExcManagerOnly()
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = 0
            r1[r2] = r4
            java.lang.String r2 = "setAppInviteOneLink"
            r0.AFInAppEventType(r2, r1)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "setAppInviteOneLink = "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.lang.String r0 = "oneLinkSlug"
            if (r4 == 0) goto L61
            int r1 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r1 = r1 + 47
            int r2 = r1 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r2
            int r1 = r1 % 2
            if (r1 != 0) goto L52
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = r1.getString(r0)
            boolean r1 = r4.equals(r1)
            r2 = 94
            if (r1 != 0) goto L4d
            r1 = 94
            goto L4f
        L4d:
            r1 = 23
        L4f:
            if (r1 == r2) goto L61
            goto L7c
        L52:
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r1.getString(r0)
            r4.equals(r0)
            r4 = 0
            throw r4     // Catch: java.lang.Throwable -> L5f
        L5f:
            r4 = move-exception
            throw r4
        L61:
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkDomain"
            r1.remove(r2)
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkVersion"
            r1.remove(r2)
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "onelinkScheme"
            r1.remove(r2)
        L7c:
            valueOf(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.setAppInviteOneLink(java.lang.String):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectAndroidID(boolean z7) {
        boolean z8;
        char c8;
        int i8 = AppsFlyerConversionListener + 47;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z8) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectAndroidID", String.valueOf(z7));
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectAndroidID", String.valueOf(z7));
        }
        valueOf(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z7));
        valueOf(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z7));
        int i9 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i9 % 128;
        if (i9 % 2 == 0) {
            c8 = '1';
        } else {
            c8 = '\t';
        }
        if (c8 != '1') {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCollectIMEI(boolean z7) {
        char c8;
        int i8 = onValidateInAppFailure + 5;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectIMEI", String.valueOf(z7));
        valueOf(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z7));
        valueOf(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z7));
        int i10 = AppsFlyerConversionListener + 73;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            c8 = '\n';
        } else {
            c8 = 'W';
        }
        if (c8 != '\n') {
            return;
        }
        int i11 = 96 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setCollectOaid(boolean z7) {
        int i8 = onValidateInAppFailure + 39;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCollectOaid", String.valueOf(z7));
        valueOf(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z7));
        int i10 = onValidateInAppFailure + 63;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCurrencyCode(String str) {
        boolean z7;
        int i8 = AppsFlyerConversionListener + 29;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[0] = str;
            afErrorLogForExcManagerOnly.AFInAppEventType("setCurrencyCode", strArr);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCurrencyCode", str);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
        int i9 = AppsFlyerConversionListener + 9;
        onValidateInAppFailure = i9 % 128;
        int i10 = i9 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerIdAndLogSession(String str, @NonNull Context context) {
        char c8;
        char c9;
        boolean z7;
        if (context != null) {
            int i8 = AppsFlyerConversionListener + 53;
            onValidateInAppFailure = i8 % 128;
            int i9 = i8 % 2;
            if (valueOf()) {
                setCustomerUserId(str);
                StringBuilder sb = new StringBuilder("CustomerUserId set: ");
                sb.append(str);
                sb.append(" - Initializing AppsFlyer Tacking");
                AFLogger.afInfoLog(sb.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                valueOf(context, AFe1hSDK.setCustomerIdAndLogSession);
                String str2 = AFKeystoreWrapper().getLevel().values;
                if (referrer == null) {
                    c8 = 1;
                } else {
                    c8 = '\n';
                }
                if (c8 != '\n') {
                    referrer = "";
                }
                String str3 = referrer;
                if (context instanceof Activity) {
                    c9 = ')';
                } else {
                    c9 = '(';
                }
                if (c9 != '(') {
                    int i10 = AppsFlyerConversionListener + 63;
                    onValidateInAppFailure = i10 % 128;
                    if (i10 % 2 == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (!z7) {
                        ((Activity) context).getIntent();
                    } else {
                        ((Activity) context).getIntent();
                        throw null;
                    }
                }
                AFKeystoreWrapper(context, null, null, str3, null);
                return;
            }
            setCustomerUserId(str);
            AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
        }
        int i11 = AppsFlyerConversionListener + 57;
        onValidateInAppFailure = i11 % 128;
        int i12 = i11 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setCustomerUserId(String str) {
        int i8 = AppsFlyerConversionListener + 31;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        valueOf(AppsFlyerProperties.APP_USER_ID, str);
        valueOf(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        int i10 = AppsFlyerConversionListener + 63;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDebugLog(boolean z7) {
        char c8;
        AFLogger.LogLevel logLevel;
        if (z7) {
            c8 = 29;
        } else {
            c8 = 19;
        }
        if (c8 != 19) {
            int i8 = onValidateInAppFailure + 29;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            logLevel = AFLogger.LogLevel.DEBUG;
        } else {
            logLevel = AFLogger.LogLevel.NONE;
            int i10 = AppsFlyerConversionListener + 25;
            onValidateInAppFailure = i10 % 128;
            int i11 = i10 % 2;
        }
        setLogLevel(logLevel);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDisableAdvertisingIdentifiers(boolean z7) {
        boolean z8;
        boolean z9 = true;
        int i8 = AppsFlyerConversionListener + 1;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        AFLogger.afDebugLog("setDisableAdvertisingIdentifiers: ".concat(String.valueOf(z7)));
        if (!z7) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z8) {
            int i10 = onValidateInAppFailure + 107;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
            z9 = false;
        } else {
            int i12 = onValidateInAppFailure + 33;
            AppsFlyerConversionListener = i12 % 128;
            int i13 = i12 % 2;
        }
        AFa1bSDK.values = Boolean.valueOf(z9);
        AppsFlyerProperties.getInstance().remove("advertiserIdEnabled");
        AppsFlyerProperties.getInstance().remove("advertiserId");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setDisableNetworkData(boolean z7) {
        boolean z8;
        int i8 = onValidateInAppFailure + 17;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFLogger.afDebugLog("setDisableNetworkData: ".concat(String.valueOf(z7)));
        valueOf(AppsFlyerProperties.DISABLE_NETWORK_DATA, z7);
        int i10 = AppsFlyerConversionListener + 45;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z8) {
            return;
        }
        int i11 = 61 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setExtension(String str) {
        boolean z7;
        int i8 = onValidateInAppFailure + 13;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (z7) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setExtension", str);
        } else {
            AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[0] = str;
            afErrorLogForExcManagerOnly.AFInAppEventType("setExtension", strArr);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setHost(String str, @NonNull String str2) {
        boolean z7;
        String str3;
        if (!AFb1mSDK.values(str2)) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!z7) {
            int i8 = onValidateInAppFailure;
            int i9 = i8 + 73;
            int i10 = i9 % 128;
            AppsFlyerConversionListener = i10;
            if (i9 % 2 == 0) {
                if (str != null) {
                    int i11 = i8 + 29;
                    AppsFlyerConversionListener = i11 % 128;
                    int i12 = i11 % 2;
                    str3 = str.trim();
                    int i13 = AppsFlyerConversionListener + 29;
                    onValidateInAppFailure = i13 % 128;
                    int i14 = i13 % 2;
                } else {
                    int i15 = i10 + 9;
                    onValidateInAppFailure = i15 % 128;
                    int i16 = i15 % 2;
                    str3 = "";
                }
                AFd1wSDK.AFInAppEventParameterName(new AFc1aSDK(str3, str2.trim()));
                int i17 = AppsFlyerConversionListener + 93;
                onValidateInAppFailure = i17 % 128;
                int i18 = i17 % 2;
                return;
            }
            throw null;
        }
        AFLogger.afWarnLog("hostname was empty or null - call for setHost is skipped");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setImeiData(String str) {
        char c8;
        int i8 = onValidateInAppFailure + 113;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setImeiData", str);
        AFKeystoreWrapper().getLevel().AFInAppEventType = str;
        int i10 = onValidateInAppFailure + 49;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            c8 = 'W';
        } else {
            c8 = 22;
        }
        if (c8 == 22) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setIsUpdate(boolean z7) {
        boolean z8;
        char c8;
        int i8 = AppsFlyerConversionListener + 39;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (z8) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setIsUpdate", String.valueOf(z7));
        } else {
            AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[1] = String.valueOf(z7);
            afErrorLogForExcManagerOnly.AFInAppEventType("setIsUpdate", strArr);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z7);
        int i9 = onValidateInAppFailure + 121;
        AppsFlyerConversionListener = i9 % 128;
        if (i9 % 2 != 0) {
            c8 = 6;
        } else {
            c8 = 'E';
        }
        if (c8 != 6) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setLogLevel(@NonNull AFLogger.LogLevel logLevel) {
        char c8;
        boolean z7;
        int i8 = AppsFlyerConversionListener + 5;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 != 0) {
            if (logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel()) {
                c8 = 18;
            } else {
                c8 = 20;
            }
            if (c8 != 20) {
                z7 = true;
            } else {
                int i9 = onValidateInAppFailure + 109;
                AppsFlyerConversionListener = i9 % 128;
                int i10 = i9 % 2;
                z7 = false;
            }
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("log", String.valueOf(z7));
            AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
            int i11 = onValidateInAppFailure + 41;
            AppsFlyerConversionListener = i11 % 128;
            int i12 = i11 % 2;
            return;
        }
        logLevel.getLevel();
        AFLogger.LogLevel.NONE.getLevel();
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setMinTimeBetweenSessions(int i8) {
        int i9 = AppsFlyerConversionListener + 81;
        onValidateInAppFailure = i9 % 128;
        int i10 = i9 % 2;
        this.getLevel = TimeUnit.SECONDS.toMillis(i8);
        int i11 = onValidateInAppFailure + 97;
        AppsFlyerConversionListener = i11 % 128;
        int i12 = i11 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOaidData(String str) {
        char c8;
        int i8 = onValidateInAppFailure + 119;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            c8 = 'C';
        } else {
            c8 = 'M';
        }
        if (c8 != 'C') {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setOaidData", str);
        } else {
            AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
            String[] strArr = new String[0];
            strArr[1] = str;
            afErrorLogForExcManagerOnly.AFInAppEventType("setOaidData", strArr);
        }
        AFa1bSDK.AFKeystoreWrapper = str;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOneLinkCustomDomain(String... strArr) {
        int i8 = onValidateInAppFailure + 107;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", Arrays.toString(strArr)));
        AFa1tSDK.AFKeystoreWrapper = strArr;
        int i10 = AppsFlyerConversionListener + 39;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setOutOfStore(String str) {
        boolean z7;
        if (str != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i8 = onValidateInAppFailure + 105;
            AppsFlyerConversionListener = i8 % 128;
            if (i8 % 2 != 0) {
            }
            String lowerCase = str.toLowerCase(Locale.getDefault());
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.AFInAppEventParameterName("Cannot set setOutOfStore with null");
        int i9 = AppsFlyerConversionListener + 57;
        onValidateInAppFailure = i9 % 128;
        if (i9 % 2 == 0) {
            int i10 = 69 / 0;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPartnerData(@NonNull String str, Map<String, Object> map) {
        char c8;
        boolean z7;
        char c9;
        String concat;
        int i8 = onValidateInAppFailure + 11;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 == 0) {
            if (this.onConversionDataSuccess == null) {
                this.onConversionDataSuccess = new AFb1eSDK();
            }
            AFb1eSDK aFb1eSDK = this.onConversionDataSuccess;
            if (str != null) {
                c8 = '@';
            } else {
                c8 = '9';
            }
            if (c8 != '9') {
                int i9 = onValidateInAppFailure + 7;
                AppsFlyerConversionListener = i9 % 128;
                int i10 = i9 % 2;
                if (!str.isEmpty()) {
                    if (map != null) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    if (!z7 && !map.isEmpty()) {
                        StringBuilder sb = new StringBuilder("Setting partner data for ");
                        sb.append(str);
                        sb.append(": ");
                        sb.append(map);
                        AFLogger.afDebugLog(sb.toString());
                        int length = new JSONObject(map).toString().length();
                        if (length > 1000) {
                            AFLogger.afWarnLog("Partner data 1000 characters limit exceeded");
                            HashMap hashMap = new HashMap();
                            hashMap.put("error", "limit exceeded: ".concat(String.valueOf(length)));
                            aFb1eSDK.values.put(str, hashMap);
                            int i11 = onValidateInAppFailure + 97;
                            AppsFlyerConversionListener = i11 % 128;
                            int i12 = i11 % 2;
                            return;
                        }
                        aFb1eSDK.valueOf.put(str, map);
                        aFb1eSDK.values.remove(str);
                        return;
                    }
                    if (aFb1eSDK.valueOf.remove(str) == null) {
                        c9 = 17;
                    } else {
                        c9 = 2;
                    }
                    if (c9 != 2) {
                        int i13 = AppsFlyerConversionListener + 19;
                        onValidateInAppFailure = i13 % 128;
                        int i14 = i13 % 2;
                        concat = "Partner data is missing or `null`";
                    } else {
                        concat = "Cleared partner data for ".concat(str);
                    }
                    AFLogger.afWarnLog(concat);
                    return;
                }
            }
            AFLogger.afWarnLog("Partner ID is missing or `null`");
            int i15 = AppsFlyerConversionListener + 113;
            onValidateInAppFailure = i15 % 128;
            int i16 = i15 % 2;
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPhoneNumber(String str) {
        char c8;
        int i8 = AppsFlyerConversionListener + 13;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            c8 = 2;
        } else {
            c8 = '?';
        }
        this.onAttributionFailureNative = AFb1ySDK.AFInAppEventParameterName(str);
        if (c8 != 2) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPluginInfo(@NonNull PluginInfo pluginInfo) {
        boolean z7;
        int i8 = AppsFlyerConversionListener + 43;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        Objects.requireNonNull(pluginInfo);
        AFKeystoreWrapper().AppsFlyer2dXConversionCallback().values(pluginInfo);
        int i10 = AppsFlyerConversionListener + 61;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setPreinstallAttribution(String str, String str2, String str3) {
        char c8;
        boolean z7;
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        boolean z8 = false;
        if (str != null) {
            try {
                jSONObject.put("pid", str);
            } catch (JSONException e8) {
                AFLogger.afErrorLog(e8.getMessage(), e8);
            }
        }
        if (str2 != null) {
            jSONObject.put("c", str2);
        }
        if (str3 != null) {
            int i8 = AppsFlyerConversionListener + 119;
            onValidateInAppFailure = i8 % 128;
            if (i8 % 2 == 0) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z7) {
                jSONObject.put("af_siteid", str3);
            } else {
                jSONObject.put("af_siteid", str3);
                throw null;
            }
        }
        if (jSONObject.has("pid")) {
            z8 = true;
        }
        if (!z8) {
            AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
            int i9 = AppsFlyerConversionListener + 57;
            onValidateInAppFailure = i9 % 128;
            if (i9 % 2 != 0) {
                return;
            }
            throw null;
        }
        int i10 = onValidateInAppFailure + 37;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            c8 = '2';
        } else {
            c8 = 25;
        }
        if (c8 == 25) {
            valueOf("preInstallName", jSONObject.toString());
        } else {
            valueOf("preInstallName", jSONObject.toString());
            throw null;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setResolveDeepLinkURLs(String... strArr) {
        boolean z7;
        String format;
        int i8 = AppsFlyerConversionListener + 45;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            format = String.format("setResolveDeepLinkURLs %s", Arrays.toString(strArr));
        } else {
            format = String.format("setResolveDeepLinkURLs %s", Arrays.toString(strArr));
        }
        AFLogger.afDebugLog(format);
        List<String> list = AFa1tSDK.AFInAppEventParameterName;
        list.clear();
        list.addAll(Arrays.asList(strArr));
        int i9 = onValidateInAppFailure + 63;
        AppsFlyerConversionListener = i9 % 128;
        int i10 = i9 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilter(@NonNull String... strArr) {
        char c8;
        boolean z7;
        int i8 = onValidateInAppFailure + 107;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            c8 = '!';
        } else {
            c8 = '^';
        }
        setSharingFilterForPartners(strArr);
        if (c8 == '^') {
            int i9 = AppsFlyerConversionListener + 75;
            onValidateInAppFailure = i9 % 128;
            if (i9 % 2 == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7) {
                return;
            }
            throw null;
        }
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public final void setSharingFilterForAllPartners() {
        int i8 = onValidateInAppFailure + 23;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        setSharingFilterForPartners("all");
        int i10 = onValidateInAppFailure + 63;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setSharingFilterForPartners(String... strArr) {
        this.AFLogger = new AFa1eSDK(strArr);
        int i8 = AppsFlyerConversionListener + 111;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(String... strArr) {
        int i8 = AppsFlyerConversionListener + 111;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 != 0) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setUserEmails", strArr);
            setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
            return;
        }
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
        throw null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(@NonNull Context context) {
        int i8 = onValidateInAppFailure + 17;
        AppsFlyerConversionListener = i8 % 128;
        char c8 = i8 % 2 != 0 ? '\b' : '+';
        start(context, null);
        if (c8 != '+') {
            int i9 = 85 / 0;
        }
        int i10 = onValidateInAppFailure + 3;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void stop(boolean z7, Context context) {
        boolean z8;
        int i8 = onValidateInAppFailure + 1;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        values(context);
        AFKeystoreWrapper().getLevel().AFKeystoreWrapper = z7;
        AFKeystoreWrapper().afWarnLog().values();
        if (z7) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (!z8) {
            int i10 = onValidateInAppFailure + 13;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
            AFInAppEventType(context).AFInAppEventType("is_stop_tracking_used", true);
            int i12 = AppsFlyerConversionListener + 125;
            onValidateInAppFailure = i12 % 128;
            int i13 = i12 % 2;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener) {
        int i8 = onValidateInAppFailure + 45;
        AppsFlyerConversionListener = i8 % 128;
        if ((i8 % 2 != 0 ? 'T' : '\r') != '\r') {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3L));
            int i9 = 25 / 0;
        } else {
            subscribeForDeepLink(deepLinkListener, TimeUnit.SECONDS.toMillis(3L));
        }
        int i10 = onValidateInAppFailure + 69;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void unregisterConversionListener() {
        boolean z7;
        int i8 = onValidateInAppFailure + 79;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("unregisterConversionListener", new String[0]);
        } else {
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("unregisterConversionListener", new String[0]);
        }
        AFInAppEventType = null;
        int i9 = onValidateInAppFailure + 63;
        AppsFlyerConversionListener = i9 % 128;
        int i10 = i9 % 2;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void updateServerUninstallToken(Context context, String str) {
        boolean z7;
        values(context);
        AFe1lSDK aFe1lSDK = new AFe1lSDK(context);
        if (str != null && !str.trim().isEmpty()) {
            AFLogger.afInfoLog("[register] Firebase Refreshed Token = ".concat(str));
            AFb1uSDK AFKeystoreWrapper2 = aFe1lSDK.AFKeystoreWrapper();
            if (AFKeystoreWrapper2 == null || !str.equals(AFKeystoreWrapper2.AFKeystoreWrapper)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (AFKeystoreWrapper2 != null && currentTimeMillis - AFKeystoreWrapper2.AFInAppEventParameterName <= TimeUnit.SECONDS.toMillis(2L)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                AFb1uSDK aFb1uSDK = new AFb1uSDK(str, currentTimeMillis, !z7);
                aFe1lSDK.valueOf.valueOf("afUninstallToken", aFb1uSDK.AFKeystoreWrapper);
                aFe1lSDK.valueOf.AFInAppEventType("afUninstallToken_received_time", aFb1uSDK.AFInAppEventParameterName);
                aFe1lSDK.valueOf.AFInAppEventType("afUninstallToken_queued", aFb1uSDK.AFKeystoreWrapper());
                if (z7) {
                    AFe1lSDK.AFKeystoreWrapper(str);
                    return;
                }
                return;
            }
            return;
        }
        AFLogger.afWarnLog("[register] Firebase Token is either empty or null and was not registered.");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void validateAndLogInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        String obj;
        Intent intent;
        AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str3;
        strArr[3] = str4;
        strArr[4] = str5;
        if (map == null) {
            obj = "";
        } else {
            obj = map.toString();
        }
        strArr[5] = obj;
        afErrorLogForExcManagerOnly.AFInAppEventType("validateAndTrackInAppPurchase", strArr);
        if (!isStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str3);
            sb.append(" ");
            sb.append(str4);
            sb.append(" ");
            sb.append(str5);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str != null && str4 != null && str2 != null && str5 != null && str3 != null) {
            Context applicationContext = context.getApplicationContext();
            String str6 = AFKeystoreWrapper().getLevel().values;
            if (context instanceof Activity) {
                intent = ((Activity) context).getIntent();
            } else {
                intent = null;
            }
            new Thread(new AFa1fSDK(applicationContext, str6, str, str2, str3, str4, str5, map, intent)).start();
            return;
        }
        AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = values;
        if (appsFlyerInAppPurchaseValidatorListener != null) {
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void waitForCustomerUserId(boolean z7) {
        boolean z8;
        int i8 = AppsFlyerConversionListener + 119;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z7)), true);
        valueOf(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z7);
        int i10 = onValidateInAppFailure + 65;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z8) {
            return;
        }
        int i11 = 97 / 0;
    }

    public static AFb1xSDK AFInAppEventType() {
        int i8 = onValidateInAppFailure;
        int i9 = i8 + 113;
        AppsFlyerConversionListener = i9 % 128;
        if ((i9 % 2 != 0 ? 'c' : 'N') != 'N') {
            throw null;
        }
        AFb1xSDK aFb1xSDK = afInfoLog;
        int i10 = i8 + 71;
        AppsFlyerConversionListener = i10 % 128;
        if ((i10 % 2 != 0 ? 'F' : '0') != '0') {
            int i11 = 51 / 0;
            return aFb1xSDK;
        }
        return aFb1xSDK;
    }

    private String AFLogger$LogLevel(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (!(string != null)) {
            return AFInAppEventParameterName(context, "AF_STORE");
        }
        int i8 = onValidateInAppFailure;
        int i9 = i8 + 49;
        AppsFlyerConversionListener = i9 % 128;
        int i10 = i9 % 2;
        int i11 = i8 + 101;
        AppsFlyerConversionListener = i11 % 128;
        int i12 = i11 % 2;
        return string;
    }

    private static boolean afErrorLog(Context context) {
        int i8 = AppsFlyerConversionListener + 107;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        if (!(AFKeystoreWrapper(context).contains("appsFlyerCount"))) {
            return true;
        }
        int i10 = onValidateInAppFailure + 17;
        AppsFlyerConversionListener = i10 % 128;
        int i11 = i10 % 2;
        return false;
    }

    private static void afInfoLog(Context context) {
        try {
            boolean z7 = false;
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 32768) == 0) {
                z7 = true;
            }
            if (!z7) {
                if (context.getResources().getIdentifier("appsflyer_backup_rules", "xml", context.getPackageName()) != 0) {
                    int i8 = onValidateInAppFailure + 27;
                    AppsFlyerConversionListener = i8 % 128;
                    if (i8 % 2 != 0) {
                    }
                    AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    return;
                }
                AFLogger.AFInAppEventParameterName("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
            }
            int i9 = AppsFlyerConversionListener + 89;
            onValidateInAppFailure = i9 % 128;
            int i10 = i9 % 2;
        } catch (Exception e8) {
            AFLogger.afErrorLogForExcManagerOnly("checkBackupRules Exception", e8);
            AFLogger.afRDLog("checkBackupRules Exception: ".concat(String.valueOf(e8)));
        }
    }

    static /* synthetic */ Map valueOf(AFb1xSDK aFb1xSDK) {
        int i8 = onValidateInAppFailure;
        int i9 = i8 + 63;
        AppsFlyerConversionListener = i9 % 128;
        char c8 = i9 % 2 != 0 ? 'D' : '5';
        Map<String, Object> map = aFb1xSDK.onResponseErrorNative;
        if (c8 != '5') {
            int i10 = 61 / 0;
        }
        int i11 = i8 + 63;
        AppsFlyerConversionListener = i11 % 128;
        int i12 = i11 % 2;
        return map;
    }

    public static String values() {
        int i8 = onValidateInAppFailure + 47;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        String AFInAppEventType2 = AFInAppEventType(AppsFlyerProperties.APP_USER_ID);
        int i10 = AppsFlyerConversionListener + 49;
        onValidateInAppFailure = i10 % 128;
        if ((i10 % 2 == 0 ? 'D' : '/') == '/') {
            return AFInAppEventType2;
        }
        throw null;
    }

    public final void AFInAppEventParameterName(Context context, Intent intent) {
        int i8 = onValidateInAppFailure + 35;
        AppsFlyerConversionListener = i8 % 128;
        if (!(i8 % 2 == 0)) {
            intent.getStringExtra("appsflyer_preinstall");
            throw null;
        }
        if ((intent.getStringExtra("appsflyer_preinstall") != null ? '1' : 'F') != 'F') {
            valueOf(intent.getStringExtra("appsflyer_preinstall"));
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance();
        String stringExtra = intent.getStringExtra("referrer");
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra)));
        if (stringExtra != null) {
            int i9 = onValidateInAppFailure + 87;
            AppsFlyerConversionListener = i9 % 128;
            int i10 = i9 % 2;
            AFInAppEventType(context).valueOf("referrer", stringExtra);
            AppsFlyerProperties appsFlyerProperties = AppsFlyerProperties.getInstance();
            appsFlyerProperties.set("AF_REFERRER", stringExtra);
            appsFlyerProperties.valueOf = stringExtra;
            if ((AppsFlyerProperties.getInstance().AFKeystoreWrapper() ? '.' : ']') != ']') {
                int i11 = AppsFlyerConversionListener + 105;
                onValidateInAppFailure = i11 % 128;
                if ((i11 % 2 == 0 ? '\\' : '<') != '\\') {
                    AFLogger.afInfoLog("onReceive: isLaunchCalled");
                    valueOf(context, AFe1hSDK.onReceive);
                    AFInAppEventType(context, stringExtra);
                    return;
                }
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                valueOf(context, AFe1hSDK.onReceive);
                AFInAppEventType(context, stringExtra);
                int i12 = 20 / 0;
            }
        }
    }

    public final AFc1vSDK AFKeystoreWrapper() {
        int i8 = onValidateInAppFailure;
        int i9 = i8 + 29;
        AppsFlyerConversionListener = i9 % 128;
        int i10 = i9 % 2;
        AFc1tSDK aFc1tSDK = this.onAttributionFailure;
        int i11 = i8 + 97;
        AppsFlyerConversionListener = i11 % 128;
        int i12 = i11 % 2;
        return aFc1tSDK;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void logEvent(@NonNull Context context, String str, Map<String, Object> map, AppsFlyerRequestListener appsFlyerRequestListener) {
        HashMap hashMap = map == null ? null : new HashMap(map);
        values(context);
        AFf1ySDK aFf1ySDK = new AFf1ySDK();
        if (context != null) {
            aFf1ySDK.AFInAppEventType = (Application) context.getApplicationContext();
        }
        aFf1ySDK.afDebugLog = str;
        aFf1ySDK.values = appsFlyerRequestListener;
        if (hashMap != null && hashMap.containsKey(AFInAppEventParameterName.TOUCH_OBJ)) {
            HashMap hashMap2 = new HashMap();
            Object obj = hashMap.get(AFInAppEventParameterName.TOUCH_OBJ);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                HashMap hashMap3 = new HashMap();
                hashMap3.put("x", Float.valueOf(motionEvent.getX()));
                hashMap3.put("y", Float.valueOf(motionEvent.getY()));
                hashMap2.put("loc", hashMap3);
                hashMap2.put("pf", Float.valueOf(motionEvent.getPressure()));
                hashMap2.put("rad", Float.valueOf(motionEvent.getTouchMajor() / 2.0f));
            } else {
                hashMap2.put("error", "Parsing failed due to invalid input in 'af_touch_obj'.");
                AFLogger.AFInAppEventParameterName("Parsing failed due to invalid input in 'af_touch_obj'.");
            }
            Map<String, ?> singletonMap = Collections.singletonMap("tch_data", hashMap2);
            hashMap.remove(AFInAppEventParameterName.TOUCH_OBJ);
            aFf1ySDK.AFKeystoreWrapper(singletonMap);
        }
        aFf1ySDK.AFInAppEventParameterName = hashMap;
        AFb1sSDK afErrorLogForExcManagerOnly = AFKeystoreWrapper().afErrorLogForExcManagerOnly();
        String[] strArr = new String[2];
        strArr[0] = str;
        Map map2 = aFf1ySDK.AFInAppEventParameterName;
        if (map2 == null) {
            map2 = new HashMap();
        }
        strArr[1] = new JSONObject(map2).toString();
        afErrorLogForExcManagerOnly.AFInAppEventType("logEvent", strArr);
        if (str == null) {
            valueOf(context, AFe1hSDK.logEvent);
        }
        AFKeystoreWrapper(aFf1ySDK, context instanceof Activity ? (Activity) context : null);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(@NonNull Context context, String str) {
        int i8 = onValidateInAppFailure + 83;
        AppsFlyerConversionListener = i8 % 128;
        boolean z7 = i8 % 2 == 0;
        start(context, str, null);
        if (z7) {
            return;
        }
        int i9 = 92 / 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void subscribeForDeepLink(@NonNull DeepLinkListener deepLinkListener, long j8) {
        int i8 = AppsFlyerConversionListener + 119;
        onValidateInAppFailure = i8 % 128;
        if (i8 % 2 != 0) {
            AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf = deepLinkListener;
            AFb1oSDK.afWarnLog = j8;
        } else {
            AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf = deepLinkListener;
            AFb1oSDK.afWarnLog = j8;
            int i9 = 61 / 0;
        }
        int i10 = AppsFlyerConversionListener + 121;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 != 0) {
            return;
        }
        throw null;
    }

    private static String AFInAppEventType(String str) {
        int i8 = AppsFlyerConversionListener + 71;
        onValidateInAppFailure = i8 % 128;
        if ((i8 % 2 == 0 ? '=' : (char) 27) != 27) {
            AppsFlyerProperties.getInstance().getString(str);
            throw null;
        }
        String string = AppsFlyerProperties.getInstance().getString(str);
        int i9 = AppsFlyerConversionListener + 59;
        onValidateInAppFailure = i9 % 128;
        int i10 = i9 % 2;
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if ((r2 % 2) == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void AFKeystoreWrapper(android.content.Context r7, android.content.Intent r8) {
        /*
            r6 = this;
            r6.values(r7)
            com.appsflyer.internal.AFc1vSDK r0 = r6.AFKeystoreWrapper()
            com.appsflyer.internal.AFa1tSDK r0 = r0.onInstallConversionDataLoadedNative()
            com.appsflyer.internal.AFc1vSDK r1 = r6.AFKeystoreWrapper()
            com.appsflyer.internal.AFc1ySDK r1 = r1.afInfoLog()
            android.net.Uri r2 = com.appsflyer.internal.AFa1tSDK.valueOf(r8)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1d
            r5 = 1
            goto L1e
        L1d:
            r5 = 0
        L1e:
            if (r5 == r3) goto L21
            goto L39
        L21:
            java.lang.String r2 = r2.toString()
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L39
            int r2 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r2 = r2 + 87
            int r5 = r2 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r5
            int r2 = r2 % 2
            if (r2 != 0) goto L44
        L37:
            r3 = 0
            goto L44
        L39:
            int r2 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r2 = r2 + 103
            int r3 = r2 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r3
            int r2 = r2 % 2
            goto L37
        L44:
            java.lang.String r2 = "ddl_sent"
            boolean r1 = r1.AFKeystoreWrapper(r2)
            r2 = 80
            if (r1 == 0) goto L51
            r1 = 80
            goto L53
        L51:
            r1 = 75
        L53:
            if (r1 == r2) goto L56
            goto L78
        L56:
            if (r3 != 0) goto L78
            int r7 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r7 = r7 + 117
            int r8 = r7 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r8
            int r7 = r7 % 2
            java.lang.String r7 = "No direct deep link"
            r8 = 0
            com.appsflyer.internal.AFb1nSDK.AFInAppEventType(r7, r8)
            int r7 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r7 = r7 + 81
            int r0 = r7 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L75
            return
        L75:
            throw r8     // Catch: java.lang.Throwable -> L76
        L76:
            r7 = move-exception
            throw r7
        L78:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r0.valueOf(r1, r8, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(android.content.Context, android.content.Intent):void");
    }

    private static void afDebugLog(Context context) {
        int i8;
        if (AFa1cSDK.AFInAppEventType()) {
            i8 = 23;
            AFLogger.afRDLog("OPPO device found");
        } else {
            i8 = 18;
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= i8 && !AFInAppEventType(AppsFlyerProperties.DISABLE_KEYSTORE, true)) {
            StringBuilder sb = new StringBuilder("OS SDK is=");
            sb.append(i9);
            sb.append("; use KeyStore");
            AFLogger.afRDLog(sb.toString());
            AFKeystoreWrapper aFKeystoreWrapper = new AFKeystoreWrapper(context);
            if (!aFKeystoreWrapper.values()) {
                aFKeystoreWrapper.AFInAppEventParameterName = AFb1wSDK.AFKeystoreWrapper(new WeakReference(context));
                aFKeystoreWrapper.valueOf = 0;
                aFKeystoreWrapper.values(aFKeystoreWrapper.AFInAppEventParameterName());
            } else {
                String AFInAppEventParameterName2 = aFKeystoreWrapper.AFInAppEventParameterName();
                synchronized (aFKeystoreWrapper.values) {
                    aFKeystoreWrapper.valueOf++;
                    AFLogger.afInfoLog("Deleting key with alias: ".concat(String.valueOf(AFInAppEventParameterName2)));
                    try {
                        synchronized (aFKeystoreWrapper.values) {
                            aFKeystoreWrapper.AFInAppEventType.deleteEntry(AFInAppEventParameterName2);
                        }
                    } catch (KeyStoreException e8) {
                        StringBuilder sb2 = new StringBuilder("Exception ");
                        sb2.append(e8.getMessage());
                        sb2.append(" occurred");
                        AFLogger.afErrorLog(sb2.toString(), e8);
                    }
                }
                aFKeystoreWrapper.values(aFKeystoreWrapper.AFInAppEventParameterName());
            }
            valueOf("KSAppsFlyerId", aFKeystoreWrapper.AFInAppEventType());
            valueOf("KSAppsFlyerRICounter", String.valueOf(aFKeystoreWrapper.valueOf()));
            return;
        }
        StringBuilder sb3 = new StringBuilder("OS SDK is=");
        sb3.append(i9);
        sb3.append("; no KeyStore usage");
        AFLogger.afRDLog(sb3.toString());
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void start(@NonNull Context context, String str, final AppsFlyerRequestListener appsFlyerRequestListener) {
        int i8 = AppsFlyerConversionListener + 21;
        onValidateInAppFailure = i8 % 128;
        if ((i8 % 2 == 0 ? 'D' : '[') == '[') {
            if (AFKeystoreWrapper().onAttributionFailureNative().valueOf()) {
                return;
            }
            if ((!this.onAppOpenAttributionNative ? (char) 5 : '^') == 5) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'start()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
                if (str == null) {
                    if (appsFlyerRequestListener != null) {
                        int i9 = onValidateInAppFailure + 115;
                        AppsFlyerConversionListener = i9 % 128;
                        int i10 = i9 % 2;
                        appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.valueOf);
                        int i11 = onValidateInAppFailure + 39;
                        AppsFlyerConversionListener = i11 % 128;
                        int i12 = i11 % 2;
                        return;
                    }
                    return;
                }
            }
            values(context);
            final AFe1jSDK AFLogger = AFKeystoreWrapper().AFLogger();
            AFLogger.AFInAppEventParameterName(AFa1oSDK.AFInAppEventParameterName(context));
            this.init = (Application) context.getApplicationContext();
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("start", str);
            String str2 = valueOf;
            AFLogger.afInfoLog(String.format("Starting AppsFlyer: (v%s.%s)", "6.10.2", str2));
            StringBuilder sb = new StringBuilder("Build Number: ");
            sb.append(str2);
            AFLogger.afInfoLog(sb.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.init.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                AFKeystoreWrapper().getLevel().values = str;
                AFc1rSDK.AFKeystoreWrapper(str);
            } else if (TextUtils.isEmpty(AFKeystoreWrapper().getLevel().values)) {
                int i13 = AppsFlyerConversionListener + 61;
                onValidateInAppFailure = i13 % 128;
                int i14 = i13 % 2;
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the start() API (should be called on Activity's onCreate).");
                if ((appsFlyerRequestListener != null ? '?' : 'b') != 'b') {
                    appsFlyerRequestListener.onError(RequestError.NO_DEV_KEY, AFb1aSDK.valueOf);
                    return;
                }
                return;
            }
            AFKeystoreWrapper().afRDLog().values(null);
            AFVersionDeclaration();
            afInfoLog(this.init.getBaseContext());
            if (this.onDeepLinkingNative) {
                afRDLog(this.init.getApplicationContext());
                int i15 = AppsFlyerConversionListener + 49;
                onValidateInAppFailure = i15 % 128;
                int i16 = i15 % 2;
            }
            AFc1tSDK aFc1tSDK = this.onAttributionFailure;
            if (aFc1tSDK.values == null) {
                aFc1tSDK.values = new AFb1gSDK(aFc1tSDK.valueOf(), aFc1tSDK.onInstallConversionDataLoadedNative());
            }
            aFc1tSDK.values.values(context, new AFb1dSDK.AFa1wSDK() { // from class: com.appsflyer.internal.AFb1xSDK.2
                @Override // com.appsflyer.internal.AFb1dSDK.AFa1wSDK
                public final void AFKeystoreWrapper(Context context2) {
                    AFLogger.afInfoLog("onBecameBackground");
                    AFe1jSDK aFe1jSDK = AFLogger;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j8 = aFe1jSDK.AFLogger;
                    if (j8 != 0) {
                        long j9 = currentTimeMillis - j8;
                        if (j9 > 0 && j9 < 1000) {
                            j9 = 1000;
                        }
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(j9);
                        aFe1jSDK.afErrorLogForExcManagerOnly = seconds;
                        aFe1jSDK.values.AFInAppEventType("prev_session_dur", seconds);
                    } else {
                        AFLogger.afInfoLog("Metrics: fg ts is missing");
                    }
                    AFLogger.afInfoLog("callStatsBackground background call");
                    AFb1xSDK.this.values(new WeakReference<>(context2));
                    AFb1xSDK.this.AFKeystoreWrapper().onConversionDataSuccess().valueOf();
                    AFb1sSDK afErrorLogForExcManagerOnly = AFb1xSDK.this.AFKeystoreWrapper().afErrorLogForExcManagerOnly();
                    if (afErrorLogForExcManagerOnly.afInfoLog()) {
                        afErrorLogForExcManagerOnly.values();
                        if (context2 != null && !AppsFlyerLib.getInstance().isStopped()) {
                            afErrorLogForExcManagerOnly.AFInAppEventParameterName(context2.getPackageName(), context2.getPackageManager(), AFb1xSDK.this.AFKeystoreWrapper());
                        }
                        afErrorLogForExcManagerOnly.AFKeystoreWrapper();
                    } else {
                        AFLogger.afDebugLog("RD status is OFF");
                    }
                    AFa1dSDK.AFInAppEventType(context2).AFInAppEventType();
                }

                @Override // com.appsflyer.internal.AFb1dSDK.AFa1wSDK
                public final void valueOf(Activity activity) {
                    AFLogger.AFKeystoreWrapper();
                    AFb1xSDK.this.AFKeystoreWrapper().afRDLog().values(null);
                    AFb1xSDK.AFKeystoreWrapper(AFb1xSDK.this);
                    int valueOf2 = AFb1xSDK.this.valueOf(AFb1xSDK.AFKeystoreWrapper(activity), false);
                    AFLogger.afInfoLog("onBecameForeground");
                    if (valueOf2 < 2) {
                        AFa1dSDK AFInAppEventType2 = AFa1dSDK.AFInAppEventType(activity);
                        AFInAppEventType2.AFKeystoreWrapper.post(AFInAppEventType2.afRDLog);
                        AFInAppEventType2.AFKeystoreWrapper.post(AFInAppEventType2.values);
                    }
                    AFf1xSDK aFf1xSDK = new AFf1xSDK();
                    AFb1xSDK.this.AFKeystoreWrapper().onInstallConversionDataLoadedNative().valueOf(aFf1xSDK.AFKeystoreWrapper(), activity.getIntent(), activity.getApplication());
                    AFb1xSDK aFb1xSDK = AFb1xSDK.this;
                    aFf1xSDK.AFInAppEventType = (Application) activity.getApplicationContext();
                    aFf1xSDK.values = appsFlyerRequestListener;
                    aFb1xSDK.AFKeystoreWrapper(aFf1xSDK, activity);
                }
            });
            return;
        }
        AFKeystoreWrapper().onAttributionFailureNative().valueOf();
        throw null;
    }

    public final void valueOf(Context context, String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = AFKeystoreWrapper(context).getString("extraReferrers", null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray2 = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
                jSONArray2 = jSONArray;
                jSONObject = jSONObject2;
            }
            if ((((long) jSONArray2.length()) < 5 ? '4' : (char) 29) != 29) {
                jSONArray2.put(currentTimeMillis);
            }
            if (!(((long) jSONObject.length()) < 4)) {
                int i8 = AppsFlyerConversionListener + 113;
                onValidateInAppFailure = i8 % 128;
                int i9 = i8 % 2;
                AFInAppEventParameterName(jSONObject);
                int i10 = onValidateInAppFailure + 45;
                AppsFlyerConversionListener = i10 % 128;
                int i11 = i10 % 2;
            }
            jSONObject.put(str, jSONArray2.toString());
            AFInAppEventType(context).valueOf("extraReferrers", jSONObject.toString());
        } catch (JSONException e8) {
            AFLogger.afErrorLogForExcManagerOnly("error at addReferrer", e8);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    final void values(WeakReference<Context> weakReference) {
        if (weakReference.get() == null) {
            return;
        }
        AFLogger.afInfoLog("app went to background");
        SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(weakReference.get());
        AppsFlyerProperties.getInstance().saveProperties(AFKeystoreWrapper2);
        long j8 = AFKeystoreWrapper().AFLogger().afErrorLogForExcManagerOnly;
        HashMap hashMap = new HashMap();
        String str = AFKeystoreWrapper().getLevel().values;
        if (str == null) {
            int i8 = onValidateInAppFailure + 65;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        String AFInAppEventType2 = AFInAppEventType("KSAppsFlyerId");
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            int i10 = onValidateInAppFailure + 93;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
            hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        AFc1oSDK.AFa1xSDK values2 = AFa1bSDK.values(weakReference.get().getContentResolver());
        if (values2 != null) {
            hashMap.put("amazon_aid", values2.AFInAppEventParameterName);
            hashMap.put("amazon_aid_limit", String.valueOf(values2.valueOf));
        }
        String string = AppsFlyerProperties.getInstance().getString("advertiserId");
        if ((string != null ? '8' : '6') == '8') {
            hashMap.put("advertiserId", string);
        }
        hashMap.put("app_id", weakReference.get().getPackageName());
        hashMap.put("devkey", str);
        hashMap.put("uid", AFb1wSDK.AFKeystoreWrapper(weakReference));
        hashMap.put("time_in_app", String.valueOf(j8));
        hashMap.put("statType", "user_closed_app");
        hashMap.put("platform", DeviceInformation.osName);
        hashMap.put("launch_counter", Integer.toString(valueOf(AFKeystoreWrapper2, false)));
        hashMap.put(AppsFlyerProperties.CHANNEL, AFInAppEventParameterName(weakReference.get()));
        if (AFInAppEventType2 != null) {
            int i12 = AppsFlyerConversionListener + 105;
            int i13 = i12 % 128;
            onValidateInAppFailure = i13;
            int i14 = i12 % 2;
            int i15 = i13 + 51;
            AppsFlyerConversionListener = i15 % 128;
            int i16 = i15 % 2;
        } else {
            AFInAppEventType2 = "";
        }
        hashMap.put("originalAppsflyerId", AFInAppEventType2);
        if (this.onInstallConversionDataLoadedNative) {
            AFf1zSDK aFf1zSDK = new AFf1zSDK();
            ((AFe1bSDK) aFf1zSDK).AFVersionDeclaration = isStopped();
            AFe1zSDK aFe1zSDK = new AFe1zSDK((AFf1zSDK) aFf1zSDK.AFInAppEventParameterName(AFKeystoreWrapper().values().valueOf.AFInAppEventType("appsFlyerCount", 0)).AFKeystoreWrapper(hashMap).AFKeystoreWrapper(String.format(afDebugLog, AppsFlyerLib.getInstance().getHostPrefix(), AFInAppEventType().getHostName())), AFKeystoreWrapper());
            AFd1sSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
            afDebugLog2.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFe1zSDK));
            return;
        }
        AFLogger.afDebugLog("Stats call is disabled, ignore ...");
    }

    private static boolean AFInAppEventType(String str, boolean z7) {
        int i8 = AppsFlyerConversionListener + 117;
        onValidateInAppFailure = i8 % 128;
        if ((i8 % 2 == 0 ? (char) 20 : 'O') == 20) {
            AppsFlyerProperties.getInstance().getBoolean(str, z7);
            throw null;
        }
        boolean z8 = AppsFlyerProperties.getInstance().getBoolean(str, z7);
        int i9 = AppsFlyerConversionListener + 71;
        onValidateInAppFailure = i9 % 128;
        if (i9 % 2 != 0) {
            return z8;
        }
        throw null;
    }

    private long afWarnLog(Context context) {
        long j8;
        long currentTimeMillis;
        int i8 = onValidateInAppFailure + 37;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 == 0) {
            j8 = AFKeystoreWrapper(context).getLong("AppsFlyerTimePassedSincePrevLaunch", 0L);
            currentTimeMillis = System.currentTimeMillis();
            AFInAppEventType(context).AFInAppEventType("AppsFlyerTimePassedSincePrevLaunch", currentTimeMillis);
            if (j8 <= 0) {
                return -1L;
            }
        } else {
            j8 = AFKeystoreWrapper(context).getLong("AppsFlyerTimePassedSincePrevLaunch", 0L);
            currentTimeMillis = System.currentTimeMillis();
            AFInAppEventType(context).AFInAppEventType("AppsFlyerTimePassedSincePrevLaunch", currentTimeMillis);
            if (j8 <= 1) {
                return -1L;
            }
        }
        int i9 = AppsFlyerConversionListener;
        int i10 = i9 + 51;
        onValidateInAppFailure = i10 % 128;
        long j9 = (i10 % 2 == 0 ? 'A' : '/') != '/' ? currentTimeMillis & j8 : currentTimeMillis - j8;
        int i11 = i9 + 95;
        onValidateInAppFailure = i11 % 128;
        int i12 = i11 % 2;
        return j9 / 1000;
    }

    public static String AFInAppEventType(SimpleDateFormat simpleDateFormat, long j8) {
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(j8));
        int i8 = onValidateInAppFailure + 39;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        return format;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public final void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFInAppEventType("setUserEmails", (String[]) arrayList.toArray(new String[strArr.length + 1]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        String str = null;
        ArrayList arrayList2 = new ArrayList();
        int length = strArr.length;
        int i8 = 0;
        while (true) {
            if ((i8 < length ? (char) 4 : 'S') != 4) {
                hashMap.put(str, arrayList2);
                AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
                return;
            }
            int i9 = onValidateInAppFailure + 25;
            AppsFlyerConversionListener = i9 % 128;
            int i10 = i9 % 2;
            String str2 = strArr[i8];
            if (AnonymousClass4.AFKeystoreWrapper[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(AFb1ySDK.AFInAppEventParameterName(str2));
                int i11 = onValidateInAppFailure + 19;
                AppsFlyerConversionListener = i11 % 128;
                int i12 = i11 % 2;
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
            i8++;
        }
    }

    private void AFInAppEventType(Context context, String str) {
        AFe1dSDK aFe1dSDK = new AFe1dSDK();
        if (!(context == null)) {
            int i8 = onValidateInAppFailure + 13;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            aFe1dSDK.AFInAppEventType = (Application) context.getApplicationContext();
            int i10 = onValidateInAppFailure + 115;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
        }
        AFa1sSDK AFInAppEventParameterName2 = aFe1dSDK.AFInAppEventParameterName(AFKeystoreWrapper().values().valueOf.AFInAppEventType("appsFlyerCount", 0));
        AFInAppEventParameterName2.AFLogger = str;
        if (str != null) {
            int i12 = onValidateInAppFailure + 17;
            AppsFlyerConversionListener = i12 % 128;
            int i13 = i12 % 2;
            if ((str.length() > 5) && AFInAppEventType(AFInAppEventParameterName2, AFKeystoreWrapper(context))) {
                values(AFKeystoreWrapper().AFInAppEventParameterName(), new AFa1vSDK(this, AFInAppEventParameterName2, (byte) 0), 5L, TimeUnit.MILLISECONDS);
            }
        }
    }

    private String getLevel(Context context) {
        String str;
        SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(context);
        String AFInAppEventType2 = AFInAppEventType("preInstallName");
        if (AFInAppEventType2 != null) {
            return AFInAppEventType2;
        }
        if (AFKeystoreWrapper2.contains("preInstallName")) {
            str = AFKeystoreWrapper2.getString("preInstallName", null);
        } else {
            if (afErrorLog(context)) {
                int i8 = onValidateInAppFailure + 43;
                AppsFlyerConversionListener = i8 % 128;
                if (i8 % 2 == 0) {
                    AFInAppEventType2 = afErrorLogForExcManagerOnly(context);
                    if (!(AFInAppEventType2 != null)) {
                        AFInAppEventType2 = AFInAppEventParameterName(context, "AF_PRE_INSTALL_NAME");
                    }
                } else {
                    afErrorLogForExcManagerOnly(context);
                    throw null;
                }
            }
            if (AFInAppEventType2 != null) {
                int i9 = AppsFlyerConversionListener + 111;
                onValidateInAppFailure = i9 % 128;
                if (i9 % 2 == 0) {
                    AFInAppEventType(context).valueOf("preInstallName", AFInAppEventType2);
                    throw null;
                }
                AFInAppEventType(context).valueOf("preInstallName", AFInAppEventType2);
            }
            str = AFInAppEventType2;
        }
        if (!(str == null)) {
            int i10 = onValidateInAppFailure + 31;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 != 0) {
                valueOf("preInstallName", str);
                int i11 = 84 / 0;
            } else {
                valueOf("preInstallName", str);
            }
        }
        return str;
    }

    private void AFVersionDeclaration() {
        int i8 = AppsFlyerConversionListener + 19;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        if (AFd1gSDK.AFLogger()) {
            return;
        }
        AFc1vSDK AFKeystoreWrapper2 = AFKeystoreWrapper();
        AFd1sSDK afDebugLog2 = AFKeystoreWrapper2.afDebugLog();
        afDebugLog2.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(new AFd1gSDK(AFKeystoreWrapper2)));
        int i10 = onValidateInAppFailure + 17;
        AppsFlyerConversionListener = i10 % 128;
        if ((i10 % 2 != 0 ? 'E' : 'K') == 'K') {
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFKeystoreWrapper(AFe1vSDK aFe1vSDK) {
        int i8 = AppsFlyerConversionListener + 75;
        onValidateInAppFailure = i8 % 128;
        if ((i8 % 2 == 0 ? '-' : '9') != '-') {
            if (aFe1vSDK == AFe1vSDK.SUCCESS) {
                int i9 = onValidateInAppFailure + 11;
                AppsFlyerConversionListener = i9 % 128;
                int i10 = i9 % 2;
                AFKeystoreWrapper().onConversionDataSuccess().AFInAppEventType();
                return;
            }
            return;
        }
        AFe1vSDK aFe1vSDK2 = AFe1vSDK.SUCCESS;
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        if ((!com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, true)) != true) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean AFLogger(android.content.Context r4) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = "collectAndroidIdForceByUser"
            r2 = 0
            boolean r0 = r0.getBoolean(r1, r2)
            r1 = 1
            if (r0 != 0) goto L39
            int r0 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r0 = r0 + 19
            int r3 = r0 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r3
            int r0 = r0 % 2
            java.lang.String r3 = "collectIMEIForceByUser"
            if (r0 == 0) goto L2c
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r3, r1)
            if (r0 == 0) goto L28
            r0 = 0
            goto L29
        L28:
            r0 = 1
        L29:
            if (r0 == r1) goto L37
            goto L39
        L2c:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r0 = r0.getBoolean(r3, r2)
            if (r0 == 0) goto L37
            goto L39
        L37:
            r0 = 0
            goto L3a
        L39:
            r0 = 1
        L3a:
            r3 = 44
            if (r0 != 0) goto L41
            r0 = 44
            goto L42
        L41:
            r0 = 3
        L42:
            if (r0 == r3) goto L45
            goto L51
        L45:
            boolean r4 = valueOf(r4)
            if (r4 != 0) goto L4d
            r4 = 0
            goto L4e
        L4d:
            r4 = 1
        L4e:
            if (r4 == 0) goto L51
            return r2
        L51:
            int r4 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r4 = r4 + 57
            int r0 = r4 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r0
            int r4 = r4 % 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFLogger(android.content.Context):boolean");
    }

    @NonNull
    private AFf1kSDK[] afErrorLogForExcManagerOnly() {
        int i8 = onValidateInAppFailure + 1;
        AppsFlyerConversionListener = i8 % 128;
        if ((i8 % 2 != 0 ? '\f' : 'G') == '\f') {
            AFKeystoreWrapper().AFVersionDeclaration().AFInAppEventParameterName();
            throw null;
        }
        AFf1kSDK[] AFInAppEventParameterName2 = AFKeystoreWrapper().AFVersionDeclaration().AFInAppEventParameterName();
        int i9 = onValidateInAppFailure + 53;
        AppsFlyerConversionListener = i9 % 128;
        if (!(i9 % 2 != 0)) {
            return AFInAppEventParameterName2;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r5.trim().isEmpty() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r5.trim().isEmpty() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        r0 = new com.appsflyer.internal.AFf1ySDK();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void AFKeystoreWrapper(android.content.Context r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.Object> r6, java.lang.String r7, java.lang.String r8) {
        /*
            r3 = this;
            r0 = 59
            if (r5 == 0) goto L7
            r1 = 59
            goto L9
        L7:
            r1 = 96
        L9:
            if (r1 == r0) goto Lc
            goto L3c
        Lc:
            int r0 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r1
            int r0 = r0 % 2
            r1 = 21
            if (r0 != 0) goto L1d
            r0 = 49
            goto L1f
        L1d:
            r0 = 21
        L1f:
            if (r0 == r1) goto L32
            java.lang.String r0 = r5.trim()
            boolean r0 = r0.isEmpty()
            r1 = 14
            int r1 = r1 / 0
            if (r0 == 0) goto L42
            goto L3c
        L30:
            r4 = move-exception
            throw r4
        L32:
            java.lang.String r0 = r5.trim()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L42
        L3c:
            com.appsflyer.internal.AFf1xSDK r0 = new com.appsflyer.internal.AFf1xSDK
            r0.<init>()
            goto L47
        L42:
            com.appsflyer.internal.AFf1ySDK r0 = new com.appsflyer.internal.AFf1ySDK
            r0.<init>()
        L47:
            r1 = 69
            if (r4 == 0) goto L4e
            r2 = 69
            goto L50
        L4e:
            r2 = 26
        L50:
            if (r2 == r1) goto L53
            goto L6f
        L53:
            int r1 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r1 = r1 + 101
            int r2 = r1 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r2
            int r1 = r1 % 2
            android.content.Context r4 = r4.getApplicationContext()
            android.app.Application r4 = (android.app.Application) r4
            r0.AFInAppEventType = r4
            int r4 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r4 = r4 + 67
            int r1 = r4 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r1
            int r4 = r4 % 2
        L6f:
            r0.afDebugLog = r5
            r0.AFInAppEventParameterName = r6
            r0.AFLogger = r7
            r0.valueOf = r8
            r3.values(r0)
            int r4 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r4 = r4 + 25
            int r5 = r4 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L87
            return
        L87:
            r4 = 0
            throw r4     // Catch: java.lang.Throwable -> L89
        L89:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean AFInAppEventType(com.appsflyer.internal.AFa1sSDK r6, android.content.SharedPreferences r7) {
        /*
            r5 = this;
            r0 = 0
            int r1 = r5.valueOf(r7, r0)
            r2 = 1
            if (r1 != r2) goto La
            r3 = 1
            goto Lb
        La:
            r3 = 0
        Lb:
            if (r3 == r2) goto Le
            goto L1d
        Le:
            int r3 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r3 = r3 + r2
            int r4 = r3 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r4
            int r3 = r3 % 2
            boolean r6 = r6 instanceof com.appsflyer.internal.AFe1eSDK
            if (r6 != 0) goto L1d
            r6 = 1
            goto L1e
        L1d:
            r6 = 0
        L1e:
            java.lang.String r3 = "newGPReferrerSent"
            boolean r7 = r7.getBoolean(r3, r0)
            if (r7 != 0) goto L28
            r7 = 0
            goto L29
        L28:
            r7 = 1
        L29:
            if (r7 == 0) goto L2c
            goto L33
        L2c:
            if (r1 != r2) goto L30
            r7 = 0
            goto L31
        L30:
            r7 = 1
        L31:
            if (r7 == 0) goto L3f
        L33:
            int r7 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r7 = r7 + 35
            int r1 = r7 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r1
            int r7 = r7 % 2
            r7 = 0
            goto L40
        L3f:
            r7 = 1
        L40:
            r1 = 45
            if (r7 != 0) goto L47
            r7 = 88
            goto L49
        L47:
            r7 = 45
        L49:
            if (r7 == r1) goto L59
            int r7 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r7 = r7 + 29
            int r1 = r7 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r1
            int r7 = r7 % 2
            if (r6 == 0) goto L58
            goto L59
        L58:
            return r0
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(com.appsflyer.internal.AFa1sSDK, android.content.SharedPreferences):boolean");
    }

    private static void valueOf(String str, String str2) {
        int i8 = onValidateInAppFailure + 21;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AppsFlyerProperties.getInstance().set(str, str2);
        int i10 = AppsFlyerConversionListener + 111;
        onValidateInAppFailure = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 3 / 0;
        }
    }

    private static void AFInAppEventParameterName(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                while (r3 < jSONArray.length()) {
                    int i8 = AppsFlyerConversionListener + 61;
                    onValidateInAppFailure = i8 % 128;
                    if (i8 % 2 == 0) {
                        arrayList.add(Long.valueOf(jSONArray.getLong(r3)));
                        r3 += 42;
                    } else {
                        arrayList.add(Long.valueOf(jSONArray.getLong(r3)));
                        r3++;
                    }
                }
            } catch (JSONException e8) {
                AFLogger.afErrorLogForExcManagerOnly("error at timeStampArr", e8);
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2: while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i9 = AppsFlyerConversionListener + 109;
                    onValidateInAppFailure = i9 % 128;
                    int i10 = i9 % 2;
                    int i11 = 0;
                    while (i11 < jSONArray2.length()) {
                        if ((jSONArray2.getLong(i11) != ((Long) arrayList.get(0)).longValue() ? 'N' : (char) 24) != 24 && jSONArray2.getLong(i11) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i11) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            i11++;
                            str = next;
                        }
                    }
                    continue;
                } catch (JSONException e9) {
                    AFLogger.afErrorLogForExcManagerOnly("error at manageExtraReferrers", e9);
                }
            }
        }
        if ((str == null ? 1 : 0) != 0) {
            return;
        }
        jSONObject.remove(str);
    }

    private static void valueOf(String str, boolean z7) {
        int i8 = onValidateInAppFailure + 81;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        AppsFlyerProperties.getInstance().set(str, z7);
        int i10 = AppsFlyerConversionListener + 59;
        onValidateInAppFailure = i10 % 128;
        if ((i10 % 2 == 0 ? ':' : '\f') == '\f') {
            return;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        if ((com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) ? 'Q' : 'I') != 'I') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (com.appsflyer.AppsFlyerProperties.getInstance().getBoolean(com.appsflyer.AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void AFInAppEventType(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(java.util.Map):void");
    }

    private boolean afRDLog() {
        String format;
        if (this.afRDLog > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.afRDLog;
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", locale);
            String AFInAppEventType2 = AFInAppEventType(simpleDateFormat, this.afRDLog);
            String AFInAppEventType3 = AFInAppEventType(simpleDateFormat, this.AFLogger$LogLevel);
            if (currentTimeMillis < this.getLevel) {
                int i8 = AppsFlyerConversionListener + 43;
                onValidateInAppFailure = i8 % 128;
                int i9 = i8 % 2;
                if ((!isStopped() ? 'R' : '\b') != '\b') {
                    int i10 = onValidateInAppFailure + 125;
                    AppsFlyerConversionListener = i10 % 128;
                    if (i10 % 2 == 0) {
                        format = String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", AFInAppEventType2, AFInAppEventType3, Long.valueOf(currentTimeMillis), Long.valueOf(this.getLevel));
                    } else {
                        Object[] objArr = new Object[4];
                        objArr[0] = AFInAppEventType2;
                        objArr[0] = AFInAppEventType3;
                        objArr[3] = Long.valueOf(currentTimeMillis);
                        objArr[2] = Long.valueOf(this.getLevel);
                        format = String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", objArr);
                    }
                    AFLogger.afInfoLog(format);
                    return true;
                }
            }
            if (!isStopped()) {
                int i11 = AppsFlyerConversionListener + 93;
                onValidateInAppFailure = i11 % 128;
                int i12 = i11 % 2;
                AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", AFInAppEventType2, AFInAppEventType3, Long.valueOf(currentTimeMillis)));
            }
        } else if (!isStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
            int i13 = onValidateInAppFailure + 63;
            AppsFlyerConversionListener = i13 % 128;
            int i14 = i13 % 2;
        }
        return false;
    }

    public final boolean valueOf() {
        if (AFInAppEventType(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
            int i8 = AppsFlyerConversionListener + 23;
            onValidateInAppFailure = i8 % 128;
            int i9 = i8 % 2;
            if ((values() == null ? (char) 14 : (char) 22) == 14) {
                int i10 = AppsFlyerConversionListener + 39;
                onValidateInAppFailure = i10 % 128;
                int i11 = i10 % 2;
                return true;
            }
        }
        return false;
    }

    private Runnable valueOf(final AFf1pSDK aFf1pSDK) {
        Runnable runnable;
        int i8 = onValidateInAppFailure + 41;
        AppsFlyerConversionListener = i8 % 128;
        if ((i8 % 2 != 0 ? (char) 2 : (char) 25) != 25) {
            runnable = new Runnable() { // from class: com.appsflyer.internal.g
                @Override // java.lang.Runnable
                public final void run() {
                    AFb1xSDK.this.AFInAppEventParameterName(aFf1pSDK);
                }
            };
            int i9 = 38 / 0;
        } else {
            runnable = new Runnable() { // from class: com.appsflyer.internal.g
                @Override // java.lang.Runnable
                public final void run() {
                    AFb1xSDK.this.AFInAppEventParameterName(aFf1pSDK);
                }
            };
        }
        int i10 = onValidateInAppFailure + 59;
        AppsFlyerConversionListener = i10 % 128;
        if ((i10 % 2 != 0 ? '2' : 'Y') != '2') {
            return runnable;
        }
        throw null;
    }

    private static File afDebugLog(String str) {
        int i8 = AppsFlyerConversionListener + 59;
        int i9 = i8 % 128;
        onValidateInAppFailure = i9;
        int i10 = i8 % 2;
        if (str != null) {
            int i11 = i9 + 107;
            AppsFlyerConversionListener = i11 % 128;
            int i12 = i11 % 2;
            try {
                if (str.trim().length() > 0) {
                    return new File(str.trim());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
                return null;
            }
        }
        int i13 = onValidateInAppFailure + 51;
        AppsFlyerConversionListener = i13 % 128;
        int i14 = i13 % 2;
        return null;
    }

    private void valueOf(Context context, AFe1hSDK aFe1hSDK) {
        int i8 = onValidateInAppFailure + 81;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        values(context);
        AFe1jSDK AFLogger = AFKeystoreWrapper().AFLogger();
        AFe1fSDK AFInAppEventParameterName2 = AFa1oSDK.AFInAppEventParameterName(context);
        if ((AFLogger.AFInAppEventParameterName() ? 'G' : 'F') == 'G') {
            AFLogger.valueOf.put("api_name", aFe1hSDK.toString());
            AFLogger.AFInAppEventParameterName(AFInAppEventParameterName2);
        }
        AFLogger.AFKeystoreWrapper();
        int i10 = AppsFlyerConversionListener + 119;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
    }

    private void AFKeystoreWrapper(Map<String, Object> map, boolean z7) {
        int i8 = onValidateInAppFailure + 57;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        map.put("platformextension", this.AppsFlyer2dXConversionCallback.AFKeystoreWrapper());
        if (!(!z7)) {
            int i10 = onValidateInAppFailure + 1;
            AppsFlyerConversionListener = i10 % 128;
            int i11 = i10 % 2;
            map.put("platform_extension_v2", AFKeystoreWrapper().AppsFlyer2dXConversionCallback().values());
        }
    }

    public static Map<String, Object> AFKeystoreWrapper(Map<String, Object> map) {
        int i8 = AppsFlyerConversionListener + 71;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        if ((map.containsKey("meta") ? '#' : 'I') != '#') {
            HashMap hashMap = new HashMap();
            map.put("meta", hashMap);
            int i10 = AppsFlyerConversionListener + 35;
            onValidateInAppFailure = i10 % 128;
            int i11 = i10 % 2;
            return hashMap;
        }
        return (Map) map.get("meta");
    }

    public static boolean valueOf(Context context) {
        int i8 = onValidateInAppFailure + 1;
        AppsFlyerConversionListener = i8 % 128;
        try {
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        if (i8 % 2 == 0) {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                int i9 = onValidateInAppFailure + 55;
                AppsFlyerConversionListener = i9 % 128;
                int i10 = i9 % 2;
                return true;
            }
            try {
                context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
                return true;
            } catch (PackageManager.NameNotFoundException e8) {
                AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e8);
                return false;
            }
        }
        GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        throw null;
    }

    private static boolean AFKeystoreWrapper(@NonNull SharedPreferences sharedPreferences) {
        int i8 = AppsFlyerConversionListener + 45;
        onValidateInAppFailure = i8 % 128;
        char c8 = i8 % 2 == 0 ? '[' : '=';
        String string = sharedPreferences.getString("sentSuccessfully", null);
        if (c8 != '[') {
            return Boolean.parseBoolean(string);
        }
        Boolean.parseBoolean(string);
        throw null;
    }

    private static void AFKeystoreWrapper(Context context, Map<String, Object> map) {
        String str;
        int i8 = onValidateInAppFailure + 107;
        AppsFlyerConversionListener = i8 % 128;
        if ((i8 % 2 != 0 ? 'T' : (char) 18) == 18) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if ((windowManager != null ? (char) 15 : (char) 4) != 4) {
                int rotation = windowManager.getDefaultDisplay().getRotation();
                if (rotation == 0) {
                    str = "p";
                } else if (rotation == 1) {
                    str = "l";
                } else if (rotation == 2) {
                    str = "pr";
                } else if (rotation != 3) {
                    str = "";
                } else {
                    int i9 = onValidateInAppFailure + 123;
                    AppsFlyerConversionListener = i9 % 128;
                    int i10 = i9 % 2;
                    str = "lr";
                }
                map.put("sc_o", str);
                return;
            }
            return;
        }
        WindowManager windowManager2 = (WindowManager) context.getSystemService("window");
        throw null;
    }

    private static void valueOf(String str) {
        try {
            if ((new JSONObject(str).has("pid") ? '?' : (char) 18) != '?') {
                AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                int i8 = onValidateInAppFailure + 47;
                AppsFlyerConversionListener = i8 % 128;
                int i9 = i8 % 2;
                return;
            }
            int i10 = onValidateInAppFailure + 9;
            AppsFlyerConversionListener = i10 % 128;
            if (i10 % 2 != 0) {
                valueOf("preInstallName", str);
                int i11 = 31 / 0;
                return;
            }
            valueOf("preInstallName", str);
        } catch (JSONException e8) {
            AFLogger.afErrorLog("Error parsing JSON for preinstall", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AFInAppEventParameterName(AFf1pSDK aFf1pSDK) {
        boolean z7;
        SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(this.init);
        int AFInAppEventType2 = AFKeystoreWrapper().values().valueOf.AFInAppEventType("appsFlyerCount", 0);
        boolean z8 = AFKeystoreWrapper2.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false);
        if ((aFf1pSDK.afRDLog == AFf1kSDK.AFa1wSDK.NOT_STARTED ? (char) 25 : 'N') != 'N') {
            z7 = true;
        } else {
            int i8 = onValidateInAppFailure + 37;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            z7 = false;
        }
        if (AFInAppEventType2 == 1) {
            int i10 = AppsFlyerConversionListener + 65;
            onValidateInAppFailure = i10 % 128;
            if ((i10 % 2 == 0 ? '\'' : '7') == '\'') {
                throw null;
            } else if (z7 || z8) {
                AFe1eSDK aFe1eSDK = new AFe1eSDK();
                Application application = this.init;
                if ((application != null ? '%' : 'H') == '%') {
                    int i11 = AppsFlyerConversionListener + 113;
                    onValidateInAppFailure = i11 % 128;
                    if (i11 % 2 == 0) {
                        aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                        int i12 = 26 / 0;
                    } else {
                        aFe1eSDK.AFInAppEventType = (Application) application.getApplicationContext();
                    }
                }
                valueOf(aFe1eSDK);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
        if (r0 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        r2 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener + 65;
        com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        if ((r2 % 2) != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
        r2 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        r2 = 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r2 != 29) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
        r2 = r8.AFInAppEventParameterName;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
        if (r2 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0066, code lost:
        if (r4 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0069, code lost:
        r9.put("operator", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (r0 == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AFInAppEventType(android.content.Context r8, java.util.Map<java.lang.String, ? super java.lang.String> r9) {
        /*
            r7 = this;
            int r0 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r2
            int r0 = r0 % 2
            r2 = 98
            if (r0 == 0) goto L11
            r0 = 37
            goto L13
        L11:
            r0 = 98
        L13:
            r3 = 0
            java.lang.String r4 = "network"
            java.lang.String r5 = "disableCollectNetworkData"
            r6 = 0
            if (r0 == r2) goto L33
            boolean r0 = AFInAppEventType(r5, r1)
            com.appsflyer.internal.AFc1vSDK r2 = r7.AFKeystoreWrapper()
            com.appsflyer.internal.AFa1hSDK r2 = r2.onInstallConversionFailureNative()
            com.appsflyer.internal.AFa1hSDK$AFa1zSDK r8 = r2.valueOf(r8)
            java.lang.String r2 = r8.AFKeystoreWrapper
            r9.put(r4, r2)
            if (r0 != 0) goto L72
            goto L4a
        L33:
            boolean r0 = AFInAppEventType(r5, r6)
            com.appsflyer.internal.AFc1vSDK r2 = r7.AFKeystoreWrapper()
            com.appsflyer.internal.AFa1hSDK r2 = r2.onInstallConversionFailureNative()
            com.appsflyer.internal.AFa1hSDK$AFa1zSDK r8 = r2.valueOf(r8)
            java.lang.String r2 = r8.AFKeystoreWrapper
            r9.put(r4, r2)
            if (r0 != 0) goto L72
        L4a:
            int r2 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r2 = r2 + 65
            int r4 = r2 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r4
            int r2 = r2 % 2
            r4 = 29
            if (r2 != 0) goto L5b
            r2 = 95
            goto L5d
        L5b:
            r2 = 29
        L5d:
            if (r2 != r4) goto L6f
            java.lang.String r2 = r8.AFInAppEventParameterName
            if (r2 == 0) goto L65
            r4 = 0
            goto L66
        L65:
            r4 = 1
        L66:
            if (r4 == 0) goto L69
            goto L72
        L69:
            java.lang.String r4 = "operator"
            r9.put(r4, r2)
            goto L72
        L6f:
            throw r3     // Catch: java.lang.Throwable -> L70
        L70:
            r8 = move-exception
            throw r8
        L72:
            if (r0 != 0) goto La5
            int r0 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r2 = r0 + 115
            int r4 = r2 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r4
            int r2 = r2 % 2
            java.lang.String r8 = r8.AFInAppEventType
            if (r8 == 0) goto La5
            int r0 = r0 + 73
            int r2 = r0 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L8d
            r1 = 0
        L8d:
            java.lang.String r0 = "carrier"
            if (r1 == 0) goto L9f
            r9.put(r0, r8)
            int r8 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r8 = r8 + 119
            int r9 = r8 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r9
            int r8 = r8 % 2
            goto La5
        L9f:
            r9.put(r0, r8)
            throw r3     // Catch: java.lang.Throwable -> La3
        La3:
            r8 = move-exception
            throw r8
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(android.content.Context, java.util.Map):void");
    }

    private void AFKeystoreWrapper(Context context, boolean z7, Map<String, Object> map, int i8) {
        HashMap hashMap = new HashMap();
        hashMap.put("cpu_abi", values("ro.product.cpu.abi"));
        hashMap.put("cpu_abi2", values("ro.product.cpu.abi2"));
        hashMap.put("arch", values("os.arch"));
        hashMap.put("build_display_id", values("ro.build.display.id"));
        if (z7) {
            int i9 = onValidateInAppFailure + 69;
            AppsFlyerConversionListener = i9 % 128;
            int i10 = i9 % 2;
            AFInAppEventParameterName(context, hashMap);
            if ((i8 <= 2 ? '\'' : (char) 15) == '\'') {
                int i11 = AppsFlyerConversionListener + 63;
                onValidateInAppFailure = i11 % 128;
                int i12 = i11 % 2;
                hashMap.putAll(AFa1dSDK.AFInAppEventType(context).AFInAppEventParameterName());
                int i13 = onValidateInAppFailure + 123;
                AppsFlyerConversionListener = i13 % 128;
                int i14 = i13 % 2;
            }
        }
        hashMap.put("dim", AFc1lSDK.AFInAppEventType(context));
        map.put("deviceData", hashMap);
        int i15 = onValidateInAppFailure + 111;
        AppsFlyerConversionListener = i15 % 128;
        int i16 = i15 % 2;
    }

    private void values(Context context, String str, Map<String, Object> map) {
        AFf1ySDK aFf1ySDK = new AFf1ySDK();
        if (context != null) {
            int i8 = onValidateInAppFailure + 109;
            AppsFlyerConversionListener = i8 % 128;
            if (i8 % 2 == 0) {
                aFf1ySDK.AFInAppEventType = (Application) context.getApplicationContext();
            } else {
                aFf1ySDK.AFInAppEventType = (Application) context.getApplicationContext();
                throw null;
            }
        }
        aFf1ySDK.afDebugLog = str;
        aFf1ySDK.AFInAppEventParameterName = map;
        AFKeystoreWrapper(aFf1ySDK, context instanceof Activity ? (Activity) context : null);
        int i9 = AppsFlyerConversionListener + 69;
        onValidateInAppFailure = i9 % 128;
        int i10 = i9 % 2;
    }

    public final int valueOf(SharedPreferences sharedPreferences, boolean z7) {
        int i8 = AppsFlyerConversionListener + 97;
        onValidateInAppFailure = i8 % 128;
        if ((i8 % 2 == 0 ? (char) 28 : 'W') != 28) {
            return AFInAppEventType(sharedPreferences, "appsFlyerCount", z7);
        }
        AFInAppEventType(sharedPreferences, "appsFlyerCount", z7);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void valueOf(com.appsflyer.internal.AFa1sSDK r14) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.valueOf(com.appsflyer.internal.AFa1sSDK):void");
    }

    private static void AFInAppEventParameterName(AppsFlyerConversionListener appsFlyerConversionListener) {
        int i8 = onValidateInAppFailure + 113;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        } else if (appsFlyerConversionListener == null) {
        } else {
            AFInAppEventType = appsFlyerConversionListener;
            int i9 = AppsFlyerConversionListener + 39;
            onValidateInAppFailure = i9 % 128;
            if ((i9 % 2 == 0 ? (char) 24 : '\n') != '\n') {
                int i10 = 48 / 0;
            }
        }
    }

    private static void values(Map<String, Object> map) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
        String string2 = AppsFlyerProperties.getInstance().getString("onelinkVersion");
        if ((string != null ? '\n' : (char) 25) != 25) {
            int i8 = AppsFlyerConversionListener + 93;
            onValidateInAppFailure = i8 % 128;
            if (!(i8 % 2 != 0)) {
                map.put("onelink_id", string);
                throw null;
            }
            map.put("onelink_id", string);
        }
        if (string2 != null) {
            int i9 = AppsFlyerConversionListener + 93;
            onValidateInAppFailure = i9 % 128;
            if (i9 % 2 != 0) {
                map.put("onelink_ver", string2);
            } else {
                map.put("onelink_ver", string2);
                throw null;
            }
        }
    }

    private void AFInAppEventParameterName(Context context, Map<String, Object> map) {
        int i8 = onValidateInAppFailure + 5;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 == 0) {
            AFb1bSDK.AFa1ySDK AFInAppEventType2 = AFKeystoreWrapper().onAppOpenAttributionNative().AFInAppEventType(context);
            map.put("btl", Float.toString(AFInAppEventType2.AFKeystoreWrapper));
            String str = AFInAppEventType2.values;
            if (!(str == null)) {
                map.put("btch", str);
                int i9 = AppsFlyerConversionListener + 65;
                onValidateInAppFailure = i9 % 128;
                int i10 = i9 % 2;
                return;
            }
            return;
        }
        map.put("btl", Float.toString(AFKeystoreWrapper().onAppOpenAttributionNative().AFInAppEventType(context).AFKeystoreWrapper));
        throw null;
    }

    private int AFInAppEventType(SharedPreferences sharedPreferences) {
        int i8 = onValidateInAppFailure + 53;
        AppsFlyerConversionListener = i8 % 128;
        return !(i8 % 2 == 0) ? AFInAppEventType(sharedPreferences, "appsFlyerAdRevenueCount", false) : AFInAppEventType(sharedPreferences, "appsFlyerAdRevenueCount", true);
    }

    private static String AFInAppEventType(File file, String str) {
        FileReader fileReader;
        Properties properties;
        try {
            try {
                try {
                    properties = new Properties();
                    fileReader = new FileReader(file);
                } catch (FileNotFoundException unused) {
                    fileReader = null;
                } catch (Throwable th) {
                    th = th;
                    fileReader = null;
                }
                try {
                    properties.load(fileReader);
                    AFLogger.afInfoLog("Found PreInstall property!");
                    String property = properties.getProperty(str);
                    try {
                        fileReader.close();
                    } catch (Throwable th2) {
                        AFLogger.afErrorLog(th2.getMessage(), th2);
                    }
                    return property;
                } catch (FileNotFoundException unused2) {
                    StringBuilder sb = new StringBuilder("PreInstall file wasn't found: ");
                    sb.append(file.getAbsolutePath());
                    AFLogger.afDebugLog(sb.toString());
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    AFLogger.afErrorLog(th.getMessage(), th);
                    if (fileReader != null) {
                        fileReader.close();
                        int i8 = AppsFlyerConversionListener + 13;
                        onValidateInAppFailure = i8 % 128;
                        int i9 = i8 % 2;
                    }
                    int i10 = onValidateInAppFailure + 123;
                    AppsFlyerConversionListener = i10 % 128;
                    int i11 = i10 % 2;
                    return null;
                }
            } catch (Throwable th4) {
                AFLogger.afErrorLog(th4.getMessage(), th4);
                return null;
            }
        } catch (Throwable th5) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable th6) {
                    AFLogger.afErrorLog(th6.getMessage(), th6);
                }
            }
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0023, code lost:
        if ((r11 == null ? 'B' : 7) != 'B') goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (r11.matches("fb\\d*?://authorize.*") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
        if (r0 == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0033, code lost:
        r0 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener + 11;
        com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        if ((r0 % 2) != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        r5 = 76 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (r11.contains("access_token") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
        if (r11.contains("access_token") == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
        if (r0 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0059, code lost:
        r0 = AFInAppEventParameterName(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0061, code lost:
        if (r0.length() != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0064, code lost:
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006f, code lost:
        if (r0.contains("&") == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
        r5 = new java.util.ArrayList(java.util.Arrays.asList(r0.split("&")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
        r5.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0082, code lost:
        r7 = new java.lang.StringBuilder();
        r5 = r5.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
        if (r5.hasNext() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0091, code lost:
        r8 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener + 31;
        com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
        if ((r8 % 2) == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
        r8 = (java.lang.String) r5.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a7, code lost:
        if (r8.contains("access_token") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a9, code lost:
        r5.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b1, code lost:
        if (r7.length() == 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b3, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b5, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b6, code lost:
        if (r9 == true) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00be, code lost:
        if (r8.startsWith("?") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c0, code lost:
        r7.append("?");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c4, code lost:
        r9 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener + 35;
        com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r9 % 128;
        r9 = r9 % 2;
        r7.append("&");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d1, code lost:
        r7.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d5, code lost:
        ((java.lang.String) r5.next()).contains("access_token");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00de, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e9, code lost:
        return r11.replace(r0, r7.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ea, code lost:
        r0 = r0 + 63;
        com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f4, code lost:
        if ((r0 % 2) == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f6, code lost:
        r3 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f8, code lost:
        if (r3 == 'X') goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fa, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00fb, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        if (r11 == null) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String AFKeystoreWrapper(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(java.lang.String):java.lang.String");
    }

    public final void values(Context context, Map<String, Object> map, Uri uri) {
        values(context);
        if (!map.containsKey("af_deeplink")) {
            int i8 = onValidateInAppFailure + 41;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            String AFKeystoreWrapper2 = AFKeystoreWrapper(uri.toString());
            AFa1tSDK onInstallConversionDataLoadedNative = AFKeystoreWrapper().onInstallConversionDataLoadedNative();
            String str = onInstallConversionDataLoadedNative.values;
            if (str != null && onInstallConversionDataLoadedNative.AFInAppEventType != null && AFKeystoreWrapper2.contains(str)) {
                int i10 = onValidateInAppFailure + 11;
                AppsFlyerConversionListener = i10 % 128;
                if (i10 % 2 == 0) {
                    Uri.Builder buildUpon = Uri.parse(AFKeystoreWrapper2).buildUpon();
                    Uri.Builder buildUpon2 = Uri.EMPTY.buildUpon();
                    Iterator<Map.Entry<String, String>> it = onInstallConversionDataLoadedNative.AFInAppEventType.entrySet().iterator();
                    while (true) {
                        if ((it.hasNext() ? '&' : (char) 16) != '&') {
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        buildUpon.appendQueryParameter(next.getKey(), next.getValue());
                        buildUpon2.appendQueryParameter(next.getKey(), next.getValue());
                    }
                    AFKeystoreWrapper2 = buildUpon.build().toString();
                    map.put("appended_query_params", buildUpon2.build().getEncodedQuery());
                } else {
                    Uri.parse(AFKeystoreWrapper2).buildUpon();
                    Uri.EMPTY.buildUpon();
                    onInstallConversionDataLoadedNative.AFInAppEventType.entrySet().iterator();
                    throw null;
                }
            }
            map.put("af_deeplink", AFKeystoreWrapper2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        AFd1cSDK aFd1cSDK = new AFd1cSDK(AFKeystoreWrapper(), UUID.randomUUID(), uri);
        if (aFd1cSDK.AFVersionDeclaration()) {
            map.put("isBrandedDomain", Boolean.TRUE);
        }
        AFa1cSDK.AFInAppEventParameterName(context, hashMap, uri);
        if (aFd1cSDK.afErrorLogForExcManagerOnly()) {
            aFd1cSDK.afRDLog = AFInAppEventParameterName(hashMap);
            AFd1sSDK afDebugLog2 = AFKeystoreWrapper().afDebugLog();
            afDebugLog2.AFInAppEventType.execute(new AFd1sSDK.AnonymousClass3(aFd1cSDK));
            return;
        }
        AFb1nSDK.AFKeystoreWrapper(hashMap);
        int i11 = onValidateInAppFailure + 107;
        AppsFlyerConversionListener = i11 % 128;
        int i12 = i11 % 2;
    }

    private static String AFInAppEventParameterName(Activity activity) {
        String str = null;
        if ((activity != null ? (char) 0 : ',') == ',') {
            return null;
        }
        int i8 = AppsFlyerConversionListener + 119;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        int i10 = AppsFlyerConversionListener + 69;
        onValidateInAppFailure = i10 % 128;
        try {
            if (i10 % 2 != 0) {
                Bundle extras = intent.getExtras();
                if (!(extras != null)) {
                    return null;
                }
                String string = extras.getString("af");
                if (string != null) {
                    try {
                        AFLogger.afInfoLog("Push Notification received af payload = ".concat(string));
                        extras.remove("af");
                        activity.setIntent(intent.putExtras(extras));
                    } catch (Throwable th) {
                        th = th;
                        str = string;
                        AFLogger.afErrorLog(th.getMessage(), th);
                        return str;
                    }
                }
                return string;
            }
            intent.getExtras();
            throw null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String AFInAppEventType(AFc1ySDK aFc1ySDK, String str) {
        int i8 = onValidateInAppFailure + 109;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        String values2 = aFc1ySDK.values("CACHED_CHANNEL", null);
        if ((values2 != null ? '[' : 'G') != '[') {
            aFc1ySDK.valueOf("CACHED_CHANNEL", str);
            return str;
        }
        int i10 = AppsFlyerConversionListener + 9;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        return values2;
    }

    private static String AFInAppEventParameterName(String str) {
        int i8 = AppsFlyerConversionListener + 9;
        onValidateInAppFailure = i8 % 128;
        int i9 = i8 % 2;
        int indexOf = str.indexOf(63);
        if (indexOf == -1) {
            return "";
        }
        String substring = str.substring(indexOf);
        int i10 = AppsFlyerConversionListener + 41;
        onValidateInAppFailure = i10 % 128;
        if ((i10 % 2 == 0 ? '\b' : ')') == ')') {
            return substring;
        }
        throw null;
    }

    public final AFc1ySDK AFInAppEventType(Context context) {
        int i8 = onValidateInAppFailure + 75;
        AppsFlyerConversionListener = i8 % 128;
        if (!(i8 % 2 == 0)) {
            values(context);
            int i9 = 92 / 0;
            return AFKeystoreWrapper().afInfoLog();
        }
        values(context);
        return AFKeystoreWrapper().afInfoLog();
    }

    private AFd1cSDK.AFa1vSDK AFInAppEventParameterName(final Map<String, String> map) {
        AFd1cSDK.AFa1vSDK aFa1vSDK = new AFd1cSDK.AFa1vSDK() { // from class: com.appsflyer.internal.AFb1xSDK.5
            @Override // com.appsflyer.internal.AFd1cSDK.AFa1vSDK
            public final void valueOf(Map<String, String> map2) {
                for (String str : map2.keySet()) {
                    map.put(str, map2.get(str));
                }
                AFb1nSDK.AFKeystoreWrapper(map);
            }

            @Override // com.appsflyer.internal.AFd1cSDK.AFa1vSDK
            public final void valueOf(String str) {
                AFb1nSDK.AFInAppEventType(str, DeepLinkResult.Error.NETWORK);
            }
        };
        int i8 = AppsFlyerConversionListener + 85;
        onValidateInAppFailure = i8 % 128;
        if ((i8 % 2 == 0 ? '[' : 'O') != 'O') {
            int i9 = 66 / 0;
            return aFa1vSDK;
        }
        return aFa1vSDK;
    }

    private static void AFInAppEventParameterName(Context context, Map<String, Object> map, String str) {
        int i8 = onValidateInAppFailure + 111;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        SharedPreferences AFKeystoreWrapper2 = AFKeystoreWrapper(context);
        SharedPreferences.Editor edit = AFKeystoreWrapper2.edit();
        try {
            String string = AFKeystoreWrapper2.getString("prev_event_name", null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prev_event_timestamp", AFKeystoreWrapper2.getLong("prev_event_timestamp", -1L));
                jSONObject.put("prev_event_name", string);
                map.put("prev_event", jSONObject);
                int i10 = onValidateInAppFailure + 75;
                AppsFlyerConversionListener = i10 % 128;
                int i11 = i10 % 2;
            }
            edit.putString("prev_event_name", str).putLong("prev_event_timestamp", System.currentTimeMillis()).apply();
        } catch (Exception e8) {
            AFLogger.afErrorLog("Error while processing previous event.", e8);
        }
    }

    private int AFInAppEventType(SharedPreferences sharedPreferences, String str, boolean z7) {
        int i8 = sharedPreferences.getInt(str, 0);
        if (!(!z7)) {
            i8++;
            sharedPreferences.edit().putInt(str, i8).apply();
        }
        if (AFKeystoreWrapper().afErrorLogForExcManagerOnly().afInfoLog()) {
            int i9 = onValidateInAppFailure + 93;
            AppsFlyerConversionListener = i9 % 128;
            if ((i9 % 2 != 0 ? 'M' : (char) 4) != 4) {
                AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFKeystoreWrapper(String.valueOf(i8));
                throw null;
            }
            AFKeystoreWrapper().afErrorLogForExcManagerOnly().AFKeystoreWrapper(String.valueOf(i8));
        }
        int i10 = onValidateInAppFailure + 49;
        AppsFlyerConversionListener = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
        return i8;
    }

    public static synchronized SharedPreferences AFKeystoreWrapper(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (AFb1xSDK.class) {
            if ((AFInAppEventType().onResponseNative == null ? '9' : (char) 17) == '9') {
                int i8 = AppsFlyerConversionListener + 9;
                onValidateInAppFailure = i8 % 128;
                int i9 = i8 % 2;
                AFInAppEventType().onResponseNative = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                int i10 = onValidateInAppFailure + 117;
                AppsFlyerConversionListener = i10 % 128;
                int i11 = i10 % 2;
            }
            sharedPreferences = AFInAppEventType().onResponseNative;
        }
        return sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0429 A[Catch: all -> 0x0aee, TryCatch #4 {all -> 0x0aee, blocks: (B:14:0x00a4, B:16:0x00aa, B:20:0x00b7, B:22:0x00c7, B:23:0x00d2, B:25:0x00ee, B:26:0x00f3, B:28:0x00fb, B:29:0x0100, B:31:0x0106, B:33:0x010e, B:38:0x011b, B:40:0x019a, B:42:0x01a0, B:44:0x01a6, B:45:0x01bd, B:47:0x01c4, B:50:0x01d7, B:52:0x01de, B:53:0x01e5, B:55:0x01eb, B:48:0x01cd, B:56:0x01f2, B:58:0x0209, B:59:0x020e, B:62:0x0216, B:63:0x0219, B:65:0x0220, B:66:0x0223, B:68:0x022d, B:70:0x0233, B:71:0x0236, B:73:0x023e, B:74:0x0247, B:79:0x025a, B:81:0x0265, B:84:0x026f, B:85:0x0274, B:87:0x027c, B:90:0x0294, B:93:0x02a4, B:95:0x02ae, B:96:0x02b8, B:98:0x02c0, B:99:0x02c5, B:101:0x02d3, B:106:0x02e0, B:108:0x02e6, B:110:0x02ec, B:111:0x02ef, B:113:0x02fd, B:117:0x0307, B:118:0x030c, B:120:0x0312, B:121:0x031f, B:123:0x0325, B:124:0x0332, B:126:0x0338, B:129:0x0349, B:131:0x034f, B:137:0x0368, B:139:0x036e, B:140:0x0373, B:142:0x037b, B:147:0x0394, B:148:0x03a0, B:150:0x03a6, B:151:0x03af, B:153:0x03b8, B:155:0x03be, B:156:0x03d4, B:157:0x03d9, B:159:0x03e1, B:160:0x03e6, B:175:0x0429, B:173:0x041d, B:176:0x042e, B:177:0x0431, B:179:0x043c, B:184:0x0459, B:188:0x0469, B:189:0x046e, B:193:0x047e, B:194:0x0483, B:198:0x0493, B:199:0x0498, B:200:0x04a7, B:227:0x0589, B:229:0x05a6, B:231:0x05af, B:233:0x05b3, B:235:0x05bb, B:236:0x05c1, B:237:0x05d6, B:226:0x0583, B:204:0x04c2, B:183:0x0444, B:143:0x0381, B:145:0x0389, B:132:0x0353, B:134:0x035f, B:136:0x0365, B:105:0x02db, B:78:0x0250, B:89:0x028f, B:37:0x0116, B:21:0x00c2, B:162:0x03fc, B:163:0x0400), top: B:385:0x00a4, inners: #13, #15, #21, #22, #24, #26, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x043c A[Catch: Exception -> 0x0442, all -> 0x0aee, TRY_LEAVE, TryCatch #29 {Exception -> 0x0442, blocks: (B:177:0x0431, B:179:0x043c), top: B:428:0x0431, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04de A[Catch: all -> 0x057b, TryCatch #17 {all -> 0x057b, blocks: (B:205:0x04c7, B:207:0x04de, B:208:0x04e7), top: B:411:0x04c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05a6 A[Catch: all -> 0x0aee, TryCatch #4 {all -> 0x0aee, blocks: (B:14:0x00a4, B:16:0x00aa, B:20:0x00b7, B:22:0x00c7, B:23:0x00d2, B:25:0x00ee, B:26:0x00f3, B:28:0x00fb, B:29:0x0100, B:31:0x0106, B:33:0x010e, B:38:0x011b, B:40:0x019a, B:42:0x01a0, B:44:0x01a6, B:45:0x01bd, B:47:0x01c4, B:50:0x01d7, B:52:0x01de, B:53:0x01e5, B:55:0x01eb, B:48:0x01cd, B:56:0x01f2, B:58:0x0209, B:59:0x020e, B:62:0x0216, B:63:0x0219, B:65:0x0220, B:66:0x0223, B:68:0x022d, B:70:0x0233, B:71:0x0236, B:73:0x023e, B:74:0x0247, B:79:0x025a, B:81:0x0265, B:84:0x026f, B:85:0x0274, B:87:0x027c, B:90:0x0294, B:93:0x02a4, B:95:0x02ae, B:96:0x02b8, B:98:0x02c0, B:99:0x02c5, B:101:0x02d3, B:106:0x02e0, B:108:0x02e6, B:110:0x02ec, B:111:0x02ef, B:113:0x02fd, B:117:0x0307, B:118:0x030c, B:120:0x0312, B:121:0x031f, B:123:0x0325, B:124:0x0332, B:126:0x0338, B:129:0x0349, B:131:0x034f, B:137:0x0368, B:139:0x036e, B:140:0x0373, B:142:0x037b, B:147:0x0394, B:148:0x03a0, B:150:0x03a6, B:151:0x03af, B:153:0x03b8, B:155:0x03be, B:156:0x03d4, B:157:0x03d9, B:159:0x03e1, B:160:0x03e6, B:175:0x0429, B:173:0x041d, B:176:0x042e, B:177:0x0431, B:179:0x043c, B:184:0x0459, B:188:0x0469, B:189:0x046e, B:193:0x047e, B:194:0x0483, B:198:0x0493, B:199:0x0498, B:200:0x04a7, B:227:0x0589, B:229:0x05a6, B:231:0x05af, B:233:0x05b3, B:235:0x05bb, B:236:0x05c1, B:237:0x05d6, B:226:0x0583, B:204:0x04c2, B:183:0x0444, B:143:0x0381, B:145:0x0389, B:132:0x0353, B:134:0x035f, B:136:0x0365, B:105:0x02db, B:78:0x0250, B:89:0x028f, B:37:0x0116, B:21:0x00c2, B:162:0x03fc, B:163:0x0400), top: B:385:0x00a4, inners: #13, #15, #21, #22, #24, #26, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x05af A[Catch: all -> 0x0aee, TryCatch #4 {all -> 0x0aee, blocks: (B:14:0x00a4, B:16:0x00aa, B:20:0x00b7, B:22:0x00c7, B:23:0x00d2, B:25:0x00ee, B:26:0x00f3, B:28:0x00fb, B:29:0x0100, B:31:0x0106, B:33:0x010e, B:38:0x011b, B:40:0x019a, B:42:0x01a0, B:44:0x01a6, B:45:0x01bd, B:47:0x01c4, B:50:0x01d7, B:52:0x01de, B:53:0x01e5, B:55:0x01eb, B:48:0x01cd, B:56:0x01f2, B:58:0x0209, B:59:0x020e, B:62:0x0216, B:63:0x0219, B:65:0x0220, B:66:0x0223, B:68:0x022d, B:70:0x0233, B:71:0x0236, B:73:0x023e, B:74:0x0247, B:79:0x025a, B:81:0x0265, B:84:0x026f, B:85:0x0274, B:87:0x027c, B:90:0x0294, B:93:0x02a4, B:95:0x02ae, B:96:0x02b8, B:98:0x02c0, B:99:0x02c5, B:101:0x02d3, B:106:0x02e0, B:108:0x02e6, B:110:0x02ec, B:111:0x02ef, B:113:0x02fd, B:117:0x0307, B:118:0x030c, B:120:0x0312, B:121:0x031f, B:123:0x0325, B:124:0x0332, B:126:0x0338, B:129:0x0349, B:131:0x034f, B:137:0x0368, B:139:0x036e, B:140:0x0373, B:142:0x037b, B:147:0x0394, B:148:0x03a0, B:150:0x03a6, B:151:0x03af, B:153:0x03b8, B:155:0x03be, B:156:0x03d4, B:157:0x03d9, B:159:0x03e1, B:160:0x03e6, B:175:0x0429, B:173:0x041d, B:176:0x042e, B:177:0x0431, B:179:0x043c, B:184:0x0459, B:188:0x0469, B:189:0x046e, B:193:0x047e, B:194:0x0483, B:198:0x0493, B:199:0x0498, B:200:0x04a7, B:227:0x0589, B:229:0x05a6, B:231:0x05af, B:233:0x05b3, B:235:0x05bb, B:236:0x05c1, B:237:0x05d6, B:226:0x0583, B:204:0x04c2, B:183:0x0444, B:143:0x0381, B:145:0x0389, B:132:0x0353, B:134:0x035f, B:136:0x0365, B:105:0x02db, B:78:0x0250, B:89:0x028f, B:37:0x0116, B:21:0x00c2, B:162:0x03fc, B:163:0x0400), top: B:385:0x00a4, inners: #13, #15, #21, #22, #24, #26, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x095c  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0969 A[Catch: all -> 0x0adb, TryCatch #27 {all -> 0x0adb, blocks: (B:335:0x0941, B:337:0x0963, B:339:0x0969, B:343:0x0979, B:345:0x0983, B:347:0x098d, B:348:0x099f, B:320:0x0924), top: B:405:0x0924 }] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0981  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x098d A[Catch: all -> 0x0adb, TryCatch #27 {all -> 0x0adb, blocks: (B:335:0x0941, B:337:0x0963, B:339:0x0969, B:343:0x0979, B:345:0x0983, B:347:0x098d, B:348:0x099f, B:320:0x0924), top: B:405:0x0924 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x09c3  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x09c5  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x09d3  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x09e2  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x09e4  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0a20 A[Catch: all -> 0x0aec, TryCatch #3 {all -> 0x0aec, blocks: (B:350:0x09b2, B:354:0x09c6, B:358:0x09d6, B:359:0x09da, B:363:0x09e5, B:365:0x0a20, B:366:0x0a30, B:368:0x0ad1, B:370:0x0ad5, B:373:0x0ade), top: B:384:0x0347 }] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0ad1 A[Catch: all -> 0x0aec, TryCatch #3 {all -> 0x0aec, blocks: (B:350:0x09b2, B:354:0x09c6, B:358:0x09d6, B:359:0x09da, B:363:0x09e5, B:365:0x0a20, B:366:0x0a30, B:368:0x0ad1, B:370:0x0ad5, B:373:0x0ade), top: B:384:0x0347 }] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x05e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.appsflyer.internal.AFb1xSDK, com.appsflyer.AppsFlyerLib] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.appsflyer.internal.AFb1xSDK, com.appsflyer.AppsFlyerLib] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.Object> AFInAppEventType(com.appsflyer.internal.AFa1sSDK r34) {
        /*
            Method dump skipped, instructions count: 2811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFInAppEventType(com.appsflyer.internal.AFa1sSDK):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void values(android.content.Context r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.values(android.content.Context, java.util.Map):void");
    }

    private String AFInAppEventParameterName(Context context, String str) {
        int i8 = AppsFlyerConversionListener;
        int i9 = i8 + 119;
        onValidateInAppFailure = i9 % 128;
        int i10 = i9 % 2;
        if ((context == null ? 'P' : '\"') == '\"') {
            values(context);
            return AFKeystoreWrapper().values().AFInAppEventType(str);
        }
        int i11 = i8 + 7;
        onValidateInAppFailure = i11 % 128;
        int i12 = i11 % 2;
        return null;
    }

    private int AFKeystoreWrapper(SharedPreferences sharedPreferences, boolean z7) {
        int i8 = AppsFlyerConversionListener + 123;
        onValidateInAppFailure = i8 % 128;
        boolean z8 = i8 % 2 == 0;
        int AFInAppEventType2 = AFInAppEventType(sharedPreferences, "appsFlyerInAppEventCount", z7);
        if (z8) {
            int i9 = 57 / 0;
        }
        return AFInAppEventType2;
    }

    @NonNull
    @Deprecated
    public static String AFKeystoreWrapper(HttpURLConnection httpURLConnection) {
        String obj;
        InputStreamReader inputStreamReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                InputStream errorStream = httpURLConnection.getErrorStream();
                if (errorStream == null) {
                    int i8 = onValidateInAppFailure + 107;
                    AppsFlyerConversionListener = i8 % 128;
                    int i9 = i8 % 2;
                    errorStream = httpURLConnection.getInputStream();
                }
                inputStreamReader = new InputStreamReader(errorStream);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    boolean z7 = false;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            int i10 = AppsFlyerConversionListener + 95;
                            onValidateInAppFailure = i10 % 128;
                            int i11 = i10 % 2;
                            sb.append((z7 ? (char) 5 : (char) 17) != 17 ? '\n' : "");
                            sb.append(readLine);
                            z7 = true;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                StringBuilder sb2 = new StringBuilder("Could not read connection response from: ");
                                sb2.append(httpURLConnection.getURL().toString());
                                AFLogger.afErrorLog(sb2.toString(), th);
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                obj = sb.toString();
                                new JSONObject(obj);
                                return obj;
                            } catch (Throwable th2) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th3) {
                                        AFLogger.afErrorLogForExcManagerOnly("readServerResponse error", th3);
                                        throw th2;
                                    }
                                }
                                if (inputStreamReader != null) {
                                    int i12 = AppsFlyerConversionListener + 89;
                                    onValidateInAppFailure = i12 % 128;
                                    int i13 = i12 % 2;
                                    inputStreamReader.close();
                                }
                                throw th2;
                            }
                        }
                    }
                    bufferedReader2.close();
                    inputStreamReader.close();
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
            }
        } catch (Throwable th6) {
            AFLogger.afErrorLogForExcManagerOnly("readServerResponse error", th6);
        }
        obj = sb.toString();
        try {
            new JSONObject(obj);
            return obj;
        } catch (JSONException e8) {
            AFLogger.afErrorLogForExcManagerOnly("error while parsing readServerResponse", e8);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("string_response", obj);
                return jSONObject.toString();
            } catch (JSONException e9) {
                AFLogger.afErrorLogForExcManagerOnly("RESPONSE_NOT_JSON error", e9);
                return new JSONObject().toString();
            }
        }
    }

    @Deprecated
    public final String AFInAppEventParameterName(Context context) {
        int i8 = onValidateInAppFailure + 15;
        AppsFlyerConversionListener = i8 % 128;
        int i9 = i8 % 2;
        values(context);
        String AFInAppEventType2 = AFKeystoreWrapper().values().AFInAppEventType();
        int i10 = AppsFlyerConversionListener + 11;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        return AFInAppEventType2;
    }

    private String AFInAppEventParameterName(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = AFKeystoreWrapper(context).getString("appsFlyerFirstInstall", null);
        if (string == null) {
            int i8 = onValidateInAppFailure + 39;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            if (afErrorLog(context)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
                int i10 = onValidateInAppFailure + 13;
                AppsFlyerConversionListener = i10 % 128;
                int i11 = i10 % 2;
            } else {
                str = "";
            }
            string = str;
            AFInAppEventType(context).valueOf("appsFlyerFirstInstall", string);
            int i12 = AppsFlyerConversionListener + 107;
            onValidateInAppFailure = i12 % 128;
            int i13 = i12 % 2;
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void AFKeystoreWrapper(@androidx.annotation.NonNull com.appsflyer.internal.AFa1sSDK r5, android.app.Activity r6) {
        /*
            r4 = this;
            android.app.Application r0 = r5.AFInAppEventType
            java.lang.String r1 = ""
            if (r6 == 0) goto L20
            android.content.Intent r2 = r6.getIntent()
            r3 = 81
            if (r2 == 0) goto L11
            r2 = 34
            goto L13
        L11:
            r2 = 81
        L13:
            if (r2 == r3) goto L20
            android.net.Uri r6 = com.appsflyer.internal.AFb1iSDK.values(r6)
            if (r6 == 0) goto L20
            java.lang.String r6 = r6.toString()
            goto L21
        L20:
            r6 = r1
        L21:
            com.appsflyer.internal.AFc1vSDK r2 = r4.AFKeystoreWrapper()
            com.appsflyer.internal.AFe1nSDK r2 = r2.getLevel()
            java.lang.String r2 = r2.values
            if (r2 != 0) goto L71
            int r6 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            r0 = 93
            int r6 = r6 + r0
            int r1 = r6 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r1
            int r6 = r6 % 2
            java.lang.String r6 = "[LogEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r6)
            com.appsflyer.attribution.AppsFlyerRequestListener r5 = r5.values
            r6 = 25
            if (r5 == 0) goto L45
            r0 = 25
        L45:
            if (r0 == r6) goto L48
            goto L65
        L48:
            int r6 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r6 = r6 + 41
            int r0 = r6 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r0
            int r6 = r6 % 2
            if (r6 == 0) goto L66
            int r6 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.AFb1aSDK.valueOf
            r5.onError(r6, r0)
            int r5 = com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure
            int r5 = r5 + 47
            int r6 = r5 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r6
            int r5 = r5 % 2
        L65:
            return
        L66:
            int r6 = com.appsflyer.attribution.RequestError.NO_DEV_KEY
            java.lang.String r0 = com.appsflyer.internal.AFb1aSDK.valueOf
            r5.onError(r6, r0)
            r5 = 0
            throw r5     // Catch: java.lang.Throwable -> L6f
        L6f:
            r5 = move-exception
            throw r5
        L71:
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r2.getReferrer(r0)
            if (r0 != 0) goto L7c
            goto L7d
        L7c:
            r1 = r0
        L7d:
            r5.AFLogger = r1
            r5.valueOf = r6
            r4.values(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.AFKeystoreWrapper(com.appsflyer.internal.AFa1sSDK, android.app.Activity):void");
    }

    @SuppressLint({"PrivateApi"})
    private static String values(String str) {
        String str2 = null;
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            int i8 = onValidateInAppFailure + 67;
            AppsFlyerConversionListener = i8 % 128;
            int i9 = i8 % 2;
            str2 = str3;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
        }
        int i10 = AppsFlyerConversionListener + 11;
        onValidateInAppFailure = i10 % 128;
        int i11 = i10 % 2;
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if ((!r3 ? '+' : '?') != '+') goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        if ((!r3 ? 18 : 'W') != 18) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean values(java.io.File r3) {
        /*
            int r0 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r0 = r0 + 21
            int r1 = r0 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r1
            int r0 = r0 % 2
            r0 = 91
            if (r3 == 0) goto L11
            r2 = 36
            goto L13
        L11:
            r2 = 91
        L13:
            if (r2 == r0) goto L4a
            int r1 = r1 + 41
            int r0 = r1 % 128
            com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener = r0
            int r1 = r1 % 2
            r0 = 85
            if (r1 == 0) goto L24
            r1 = 85
            goto L26
        L24:
            r1 = 65
        L26:
            r2 = 0
            boolean r3 = r3.exists()
            if (r1 == r0) goto L39
            r0 = 43
            if (r3 != 0) goto L34
            r3 = 43
            goto L36
        L34:
            r3 = 63
        L36:
            if (r3 == r0) goto L4a
            goto L47
        L39:
            r0 = 96
            int r0 = r0 / r2
            r0 = 18
            if (r3 != 0) goto L43
            r3 = 18
            goto L45
        L43:
            r3 = 87
        L45:
            if (r3 == r0) goto L4a
        L47:
            return r2
        L48:
            r3 = move-exception
            throw r3
        L4a:
            r3 = 1
            int r0 = com.appsflyer.internal.AFb1xSDK.AppsFlyerConversionListener
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.appsflyer.internal.AFb1xSDK.onValidateInAppFailure = r1
            int r0 = r0 % 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.values(java.io.File):boolean");
    }

    private static void values(@NonNull ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j8, TimeUnit timeUnit) {
        int i8 = AppsFlyerConversionListener + 31;
        onValidateInAppFailure = i8 % 128;
        try {
            if (i8 % 2 != 0) {
                scheduledExecutorService.schedule(runnable, j8, timeUnit);
            } else {
                scheduledExecutorService.schedule(runnable, j8, timeUnit);
                int i9 = 12 / 0;
            }
            int i10 = AppsFlyerConversionListener + 17;
            onValidateInAppFailure = i10 % 128;
            int i11 = i10 % 2;
        } catch (RejectedExecutionException e8) {
            AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e8);
        } catch (Throwable th) {
            AFLogger.afErrorLog("scheduleJob failed with Exception", th);
        }
    }

    public final void values(@NonNull Context context) {
        int i8 = AppsFlyerConversionListener;
        int i9 = i8 + 17;
        onValidateInAppFailure = i9 % 128;
        int i10 = i9 % 2;
        AFc1tSDK aFc1tSDK = this.onAttributionFailure;
        if (context != null) {
            int i11 = i8 + 51;
            onValidateInAppFailure = i11 % 128;
            int i12 = i11 % 2;
            AFc1sSDK aFc1sSDK = aFc1tSDK.AFKeystoreWrapper;
            if (!(context == null)) {
                int i13 = i8 + 63;
                onValidateInAppFailure = i13 % 128;
                int i14 = i13 % 2;
                aFc1sSDK.AFKeystoreWrapper = context.getApplicationContext();
            }
        }
        int i15 = onValidateInAppFailure + 115;
        AppsFlyerConversionListener = i15 % 128;
        if (i15 % 2 == 0) {
            return;
        }
        throw null;
    }

    private void values(AFa1sSDK aFa1sSDK) {
        boolean z7 = aFa1sSDK.afDebugLog == null;
        if (valueOf()) {
            int i8 = AppsFlyerConversionListener + 65;
            onValidateInAppFailure = i8 % 128;
            if (i8 % 2 == 0) {
                AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", false);
            } else {
                AFLogger.afInfoLog("CustomerUserId not set, reporting is disabled", true);
            }
            int i9 = onValidateInAppFailure + 45;
            AppsFlyerConversionListener = i9 % 128;
            int i10 = i9 % 2;
            return;
        }
        if (!(!z7)) {
            if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true) ? 'D' : (char) 19) != 'D') {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
                int i11 = AppsFlyerConversionListener + 27;
                onValidateInAppFailure = i11 % 128;
                int i12 = i11 % 2;
            } else {
                int i13 = AppsFlyerConversionListener + 87;
                onValidateInAppFailure = i13 % 128;
                int i14 = i13 % 2;
                if (afRDLog()) {
                    AppsFlyerRequestListener appsFlyerRequestListener = aFa1sSDK.values;
                    if (!(appsFlyerRequestListener == null)) {
                        appsFlyerRequestListener.onError(RequestError.EVENT_TIMEOUT, AFb1aSDK.values);
                    }
                    int i15 = onValidateInAppFailure + 97;
                    AppsFlyerConversionListener = i15 % 128;
                    if ((i15 % 2 == 0 ? 'O' : (char) 0) != 0) {
                        return;
                    }
                    throw null;
                }
            }
            this.afRDLog = System.currentTimeMillis();
        }
        values(AFKeystoreWrapper().AFInAppEventParameterName(), new AFa1vSDK(this, aFa1sSDK, (byte) 0), 0L, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r12 = r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(java.lang.String r12, int r13, java.lang.Object[] r14) {
        /*
            if (r12 == 0) goto L6
            char[] r12 = r12.toCharArray()
        L6:
            char[] r12 = (char[]) r12
            java.lang.Object r0 = com.appsflyer.internal.AFg1nSDK.values
            monitor-enter(r0)
            int r1 = r12.length     // Catch: java.lang.Throwable -> L75
            char[] r1 = new char[r1]     // Catch: java.lang.Throwable -> L75
            r2 = 0
            com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper = r2     // Catch: java.lang.Throwable -> L75
            r3 = 2
            char[] r3 = new char[r3]     // Catch: java.lang.Throwable -> L75
        L14:
            int r4 = com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L75
            int r5 = r12.length     // Catch: java.lang.Throwable -> L75
            if (r4 >= r5) goto L6c
            char r5 = r12[r4]     // Catch: java.lang.Throwable -> L75
            r3[r2] = r5     // Catch: java.lang.Throwable -> L75
            int r4 = r4 + 1
            char r4 = r12[r4]     // Catch: java.lang.Throwable -> L75
            r5 = 1
            r3[r5] = r4     // Catch: java.lang.Throwable -> L75
            r4 = 58224(0xe370, float:8.1589E-41)
            r6 = 0
        L28:
            r7 = 16
            if (r6 >= r7) goto L5b
            char r7 = r3[r5]     // Catch: java.lang.Throwable -> L75
            char r8 = r3[r2]     // Catch: java.lang.Throwable -> L75
            int r9 = r8 + r4
            int r10 = r8 << 4
            char r11 = com.appsflyer.internal.AFb1xSDK.onResponse     // Catch: java.lang.Throwable -> L75
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r10 = r8 >>> 5
            char r11 = com.appsflyer.internal.AFb1xSDK.onResponseError     // Catch: java.lang.Throwable -> L75
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r7 = r7 - r9
            char r7 = (char) r7     // Catch: java.lang.Throwable -> L75
            r3[r5] = r7     // Catch: java.lang.Throwable -> L75
            int r9 = r7 + r4
            int r10 = r7 << 4
            char r11 = com.appsflyer.internal.AFb1xSDK.onDeepLinking     // Catch: java.lang.Throwable -> L75
            int r10 = r10 + r11
            r9 = r9 ^ r10
            int r7 = r7 >>> 5
            char r10 = com.appsflyer.internal.AFb1xSDK.onConversionDataFail     // Catch: java.lang.Throwable -> L75
            int r7 = r7 + r10
            r7 = r7 ^ r9
            int r8 = r8 - r7
            char r7 = (char) r8     // Catch: java.lang.Throwable -> L75
            r3[r2] = r7     // Catch: java.lang.Throwable -> L75
            r7 = 40503(0x9e37, float:5.6757E-41)
            int r4 = r4 - r7
            int r6 = r6 + 1
            goto L28
        L5b:
            int r4 = com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper     // Catch: java.lang.Throwable -> L75
            char r6 = r3[r2]     // Catch: java.lang.Throwable -> L75
            r1[r4] = r6     // Catch: java.lang.Throwable -> L75
            int r6 = r4 + 1
            char r5 = r3[r5]     // Catch: java.lang.Throwable -> L75
            r1[r6] = r5     // Catch: java.lang.Throwable -> L75
            int r4 = r4 + 2
            com.appsflyer.internal.AFg1nSDK.AFKeystoreWrapper = r4     // Catch: java.lang.Throwable -> L75
            goto L14
        L6c:
            java.lang.String r12 = new java.lang.String     // Catch: java.lang.Throwable -> L75
            r12.<init>(r1, r2, r13)     // Catch: java.lang.Throwable -> L75
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L75
            r14[r2] = r12
            return
        L75:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1xSDK.values(java.lang.String, int, java.lang.Object[]):void");
    }

    private static void AFInAppEventType(Map<String, Object> map, AFe1jSDK aFe1jSDK) {
        HashMap hashMap = new HashMap(aFe1jSDK.AFInAppEventType);
        aFe1jSDK.AFInAppEventType.clear();
        aFe1jSDK.values.valueOf("gcd");
        if ((!hashMap.isEmpty() ? '6' : 'Q') != '6') {
            return;
        }
        int i8 = onValidateInAppFailure + 49;
        AppsFlyerConversionListener = i8 % 128;
        if (i8 % 2 == 0) {
            AFKeystoreWrapper(map).put("gcd", hashMap);
        } else {
            AFKeystoreWrapper(map).put("gcd", hashMap);
            throw null;
        }
    }
}
