package com.clevertap.android.sdk.featureFlags;

import android.content.Context;
import com.clevertap.android.sdk.BaseAnalyticsManager;
import com.clevertap.android.sdk.BaseCallbackManager;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.utils.FileUtils;

/* loaded from: classes.dex */
public class CTFeatureFlagsFactory {
    public static CTFeatureFlagsController a(Context context, String str, CleverTapInstanceConfig cleverTapInstanceConfig, BaseCallbackManager baseCallbackManager, BaseAnalyticsManager baseAnalyticsManager) {
        return new CTFeatureFlagsController(str, cleverTapInstanceConfig, baseCallbackManager, baseAnalyticsManager, new FileUtils(context, cleverTapInstanceConfig));
    }
}
