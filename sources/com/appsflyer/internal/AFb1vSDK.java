package com.appsflyer.internal;

import com.appsflyer.AFLogger;

@Deprecated
/* loaded from: classes.dex */
public final class AFb1vSDK implements AFa1vSDK {
    private final AFa1vSDK values = this;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface AFa1vSDK {
        Class<?> values(String str) throws ClassNotFoundException;
    }

    /* loaded from: classes.dex */
    enum AFa1ySDK {
        ADOBE_AIR("android_adobe_air", "com.appsflyer.adobeair.AppsFlyerExtension"),
        ADOBE_MOBILE_SDK("android_adobe_mobile", "com.appsflyer.adobeextension.AppsFlyerAdobeExtension"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        CORDOVA("android_cordova", "com.appsflyer.cordova.plugin.AppsFlyerPlugin"),
        DEFAULT("android_native", "android_native"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin"),
        M_PARTICLE("android_mparticle", "com.mparticle.kits.AppsFlyerKit"),
        NATIVE_SCRIPT("android_native_script", "com.tns.NativeScriptActivity"),
        EXPO("android_expo", "expo.modules.devmenu.react.DevMenuAwareReactActivity"),
        REACT_NATIVE("android_reactNative", "com.appsflyer.reactnative.RNAppsFlyerModule"),
        UNITY("android_unity", "com.appsflyer.unity.AppsFlyerAndroidWrapper"),
        UNREAL_ENGINE("android_unreal", "com.epicgames.ue4.GameActivity"),
        XAMARIN("android_xamarin", "mono.android.Runtime"),
        CAPACITOR("android_capacitor", "capacitor.plugin.appsflyer.sdk.AppsFlyerPlugin");
        
        private final String afWarnLog;
        private final String onInstallConversionFailureNative;

        AFa1ySDK(String str, String str2) {
            this.afWarnLog = str;
            this.onInstallConversionFailureNative = str2;
        }
    }

    private boolean AFInAppEventType(String str) {
        try {
            this.values.values(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException e8) {
            StringBuilder sb2 = new StringBuilder("Class: ");
            sb2.append(str);
            sb2.append(" is  not found. (Platform extension)");
            AFLogger.afErrorLogForExcManagerOnly(sb2.toString(), e8, true);
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    public final String AFKeystoreWrapper() {
        AFa1ySDK[] values;
        for (AFa1ySDK aFa1ySDK : AFa1ySDK.values()) {
            if (AFInAppEventType(aFa1ySDK.onInstallConversionFailureNative)) {
                return aFa1ySDK.afWarnLog;
            }
        }
        return AFa1ySDK.DEFAULT.afWarnLog;
    }

    @Override // com.appsflyer.internal.AFb1vSDK.AFa1vSDK
    public final Class<?> values(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
