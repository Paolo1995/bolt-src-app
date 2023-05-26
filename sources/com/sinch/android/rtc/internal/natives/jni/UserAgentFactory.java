package com.sinch.android.rtc.internal.natives.jni;

import com.sinch.android.rtc.internal.service.time.TimeService;

/* loaded from: classes3.dex */
public class UserAgentFactory {
    public static native UserAgent createUserAgent(NativeServiceProviderImpl nativeServiceProviderImpl, String str, String str2, String str3, String str4, String str5, boolean z7, String str6, String str7, String str8, String str9, String str10, String str11);

    public static native UserAgent createUserAgentWithTimeService(TimeService timeService, NativeServiceProviderImpl nativeServiceProviderImpl, String str, String str2, String str3, String str4, String str5, boolean z7, String str6, String str7, String str8, String str9, String str10, String str11);
}
