package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFf1eSDK implements AFf1fSDK {
    @Override // com.appsflyer.internal.AFf1fSDK
    public final String AFKeystoreWrapper(String str) {
        Intrinsics.f(str, "");
        String format = String.format(str, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName());
        Intrinsics.e(format, "");
        return format;
    }
}
