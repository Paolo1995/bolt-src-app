package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.UserController;
import com.sinch.android.rtc.internal.RuntimeResources;
import com.sinch.android.rtc.internal.client.DeviceInformation;
import com.sinch.android.rtc.internal.service.serviceprovider.DefaultServiceProvider;
import com.sinch.android.rtc.internal.service.time.TimeService;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes3.dex */
public class UserControllerFactory {

    /* loaded from: classes3.dex */
    public static class Environment {
        public String host;
        public boolean useSSL;

        public Environment(String str, boolean z7) {
            this.host = str;
            this.useSSL = z7;
        }
    }

    private static native UserController createNativeUserController(NativeServiceProviderImpl nativeServiceProviderImpl, String str, String str2, String str3, boolean z7, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11);

    private static native UserController createNativeUserControllerWithTimeService(NativeServiceProviderImpl nativeServiceProviderImpl, String str, String str2, String str3, boolean z7, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, TimeService timeService);

    public static UserController createUserController(String str, String str2, String str3, RuntimeResources runtimeResources) {
        DeviceInformation deviceInformation = new DeviceInformation(runtimeResources.getDeviceId());
        DefaultServiceProvider defaultServiceProvider = new DefaultServiceProvider(runtimeResources.getDispatcher(), runtimeResources.getHttpService(), null);
        Environment environment = getEnvironment(str3);
        TimeService timeService = runtimeResources.getTimeService();
        return timeService != null ? createNativeUserControllerWithTimeService(defaultServiceProvider.getNativeServiceProvider(), str, str2, environment.host, environment.useSSL, deviceInformation.deviceId, runtimeResources.getPersistenceServiceDatabasePath(), DeviceInformation.modelName, DeviceInformation.modelId, "5.10.7", DeviceInformation.os, DeviceInformation.osName, DeviceInformation.osApiVersion, timeService) : createNativeUserController(defaultServiceProvider.getNativeServiceProvider(), str, str2, environment.host, environment.useSSL, deviceInformation.deviceId, runtimeResources.getPersistenceServiceDatabasePath(), DeviceInformation.modelName, DeviceInformation.modelId, "5.10.7", DeviceInformation.os, DeviceInformation.osName, DeviceInformation.osApiVersion);
    }

    public static Environment getEnvironment(String str) {
        if (str.startsWith("https://") || str.startsWith("http://")) {
            try {
                URL url = new URL(str);
                if ("http".equals(url.getProtocol())) {
                    return new Environment(url.getHost() + ":" + url.getPort(), false);
                }
                return new Environment(url.getHost(), true);
            } catch (MalformedURLException unused) {
                return new Environment(str, true);
            }
        }
        return new Environment(str, true);
    }
}
