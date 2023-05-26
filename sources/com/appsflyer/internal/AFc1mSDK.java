package com.appsflyer.internal;

import com.appsflyer.AppsFlyerLib;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFc1mSDK extends AFc1rSDK {
    public static final AFa1xSDK AFa1xSDK = new AFa1xSDK(null);

    /* synthetic */ AFc1mSDK(String str, Map map, byte[] bArr, String str2, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i8 & 4) != 0 ? null : bArr, (i8 & 8) != 0 ? "GET" : str2, (i8 & 16) != 0 ? false : z7);
    }

    public static final AFc1mSDK valueOf(String str, String str2, String str3, String str4) {
        Map i8;
        Intrinsics.f(str, "");
        Intrinsics.f(str3, "");
        Intrinsics.f(str4, "");
        String AFKeystoreWrapper = AFa1xSDK.AFKeystoreWrapper(str, str2, str3);
        String valueOf = String.valueOf(System.currentTimeMillis());
        i8 = MapsKt__MapsKt.i(TuplesKt.a("Connection", "close"), TuplesKt.a("af_request_epoch_ms", valueOf), TuplesKt.a("af_sig", AFa1xSDK.AFKeystoreWrapper(str, str3, str2, str4, valueOf)));
        AFc1mSDK aFc1mSDK = new AFc1mSDK(AFKeystoreWrapper, i8, null, null, false, 28, null);
        aFc1mSDK.valueOf(10000);
        return aFc1mSDK;
    }

    private AFc1mSDK(String str, Map<String, String> map, byte[] bArr, String str2, boolean z7) {
        super(str, bArr, str2, map, z7);
    }

    /* loaded from: classes.dex */
    public static final class AFa1xSDK {
        private AFa1xSDK() {
        }

        public /* synthetic */ AFa1xSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        static String AFKeystoreWrapper(String str, String str2, String str3) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(AFc1kSDK.values, AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()));
            sb.append(str);
            sb.append(str3);
            sb.append("?device_id=");
            sb.append(str2);
            return sb.toString();
        }

        public static String AFKeystoreWrapper(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.f(str, "");
            Intrinsics.f(str2, "");
            Intrinsics.f(str4, "");
            Intrinsics.f(str5, "");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            return AFb1ySDK.AFKeystoreWrapper(AFb1ySDK.valueOf(str5, str3, sb.toString()), str4);
        }
    }
}
