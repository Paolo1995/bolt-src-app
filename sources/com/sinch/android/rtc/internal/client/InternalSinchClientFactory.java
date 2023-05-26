package com.sinch.android.rtc.internal.client;

import android.content.Context;
import com.sinch.android.rtc.PushConfiguration;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.internal.AndroidLooperCallbackHandler;
import com.sinch.android.rtc.internal.CallbackHandler;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.client.video.NullVideoController;
import com.sinch.android.rtc.internal.service.http.HttpClientInterface;
import com.sinch.android.rtc.internal.service.time.TimeService;
import java.io.IOException;

/* loaded from: classes3.dex */
public class InternalSinchClientFactory {
    public static synchronized SinchClient createSinchClient(Context context, CallbackHandler callbackHandler, TimeService timeService, HttpClientInterface httpClientInterface, String str, String str2, String str3, boolean z7, PushConfiguration pushConfiguration, String str4) throws IOException {
        DefaultSinchClient defaultSinchClient;
        synchronized (InternalSinchClientFactory.class) {
            String pathForPersistenceServiceDatabase = new SinchDBPathHelper(context).getPathForPersistenceServiceDatabase(str2);
            NullVideoController nullVideoController = new NullVideoController();
            defaultSinchClient = new DefaultSinchClient(context, new ServiceFactory(callbackHandler, timeService, httpClientInterface), DeviceId.getDeviceId(context), str, str3, str2, pushConfiguration, new ConnectivityListener(), pathForPersistenceServiceDatabase, nullVideoController, callbackHandler, z7, str4, InternalErrorCodes.ApiCallFailed);
        }
        return defaultSinchClient;
    }

    public static synchronized SinchClient createSinchClient(Context context, CallbackHandler callbackHandler, String str, String str2, String str3, boolean z7, PushConfiguration pushConfiguration, String str4) throws IOException {
        DefaultSinchClient defaultSinchClient;
        synchronized (InternalSinchClientFactory.class) {
            String pathForPersistenceServiceDatabase = new SinchDBPathHelper(context).getPathForPersistenceServiceDatabase(str2);
            NullVideoController nullVideoController = new NullVideoController();
            defaultSinchClient = new DefaultSinchClient(context, new ServiceFactory(callbackHandler), DeviceId.getDeviceId(context), str, str3, str2, pushConfiguration, new ConnectivityListener(), pathForPersistenceServiceDatabase, nullVideoController, callbackHandler, z7, str4, InternalErrorCodes.ApiCallFailed);
        }
        return defaultSinchClient;
    }

    public static synchronized SinchClient createSinchClient(Context context, String str, String str2, String str3, boolean z7, PushConfiguration pushConfiguration, String str4) throws IOException {
        DefaultSinchClient defaultSinchClient;
        synchronized (InternalSinchClientFactory.class) {
            String pathForPersistenceServiceDatabase = new SinchDBPathHelper(context).getPathForPersistenceServiceDatabase(str2);
            AndroidLooperCallbackHandler androidLooperCallbackHandler = new AndroidLooperCallbackHandler();
            defaultSinchClient = new DefaultSinchClient(context, new ServiceFactory(androidLooperCallbackHandler), DeviceId.getDeviceId(context), str, str3, str2, pushConfiguration, new ConnectivityListener(), pathForPersistenceServiceDatabase, null, androidLooperCallbackHandler, z7, str4, 10000);
        }
        return defaultSinchClient;
    }
}
