package com.clevertap.android.sdk.product_config;

import com.clevertap.android.sdk.CleverTapInstanceConfig;

/* loaded from: classes.dex */
class ProductConfigUtil {
    ProductConfigUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(CleverTapInstanceConfig cleverTapInstanceConfig) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (cleverTapInstanceConfig != null) {
            str = cleverTapInstanceConfig.c();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("[Product Config]");
        return sb.toString();
    }
}
