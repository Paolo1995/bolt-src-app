package com.appsflyer.internal;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFc1iSDK {
    public static final AFa1wSDK AFa1wSDK = new AFa1wSDK(null);
    public static String valueOf = "https://%smonitorsdk.%s/remote-debug/exception-manager";
    public int AFInAppEventParameterName;
    public Map<String, String> AFInAppEventType;
    public byte[] AFKeystoreWrapper;

    /* loaded from: classes.dex */
    public static final class AFa1wSDK {
        private AFa1wSDK() {
        }

        public /* synthetic */ AFa1wSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFc1iSDK(byte[] bArr, Map<String, String> map, int i8) {
        Intrinsics.f(bArr, "");
        this.AFKeystoreWrapper = bArr;
        this.AFInAppEventType = map;
        this.AFInAppEventParameterName = i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0184, code lost:
        if (r10 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean AFInAppEventType() {
        /*
            Method dump skipped, instructions count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1iSDK.AFInAppEventType():boolean");
    }
}
