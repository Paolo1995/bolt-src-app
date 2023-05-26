package com.clevertap.android.sdk.product_config;

import android.content.Context;
import com.clevertap.android.sdk.BaseAnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.utils.FileUtils;

/* loaded from: classes.dex */
public class CTProductConfigFactory {
    public static CTProductConfigController a(Context context, DeviceInfo deviceInfo, CleverTapInstanceConfig cleverTapInstanceConfig, BaseAnalyticsManager baseAnalyticsManager, CoreMetaData coreMetaData, BaseCallbackManager baseCallbackManager) {
        String x7 = deviceInfo.x();
        FileUtils fileUtils = new FileUtils(context, cleverTapInstanceConfig);
        return new CTProductConfigController(context, cleverTapInstanceConfig, baseAnalyticsManager, coreMetaData, baseCallbackManager, new ProductConfigSettings(x7, cleverTapInstanceConfig, fileUtils), fileUtils);
    }
}
