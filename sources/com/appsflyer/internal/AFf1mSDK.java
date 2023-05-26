package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFf1mSDK extends AFf1oSDK {
    private final AFc1vSDK AFKeystoreWrapper;

    public AFf1mSDK(Runnable runnable, AFc1vSDK aFc1vSDK) {
        super("store", "huawei", runnable);
        this.AFKeystoreWrapper = aFc1vSDK;
    }

    @Override // com.appsflyer.internal.AFf1kSDK
    public final void valueOf(Context context) {
        AFInAppEventType(context, new AFb1jSDK<Map<String, Object>>(context, this.AFKeystoreWrapper, "com.huawei.appmarket.commondata", "FFE391E0EA186D0734ED601E4E70E3224B7309D48E2075BAC46D8C667EAE7212", "3BAF59A2E5331C30675FAB35FF5FFF0D116142D3D4664F1C3CB804068B40614F") { // from class: com.appsflyer.internal.AFf1mSDK.2
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x00f8, code lost:
                if (r2 != null) goto L18;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x010c, code lost:
                if (0 == 0) goto L15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x010e, code lost:
                r2.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x0111, code lost:
                r11.AFInAppEventParameterName.AFInAppEventType();
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x011a, code lost:
                return r11.AFInAppEventParameterName.AFInAppEventType;
             */
            @Override // com.appsflyer.internal.AFb1jSDK
            /* renamed from: AFKeystoreWrapper */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.Map<java.lang.String, java.lang.Object> values() {
                /*
                    Method dump skipped, instructions count: 289
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1mSDK.AnonymousClass2.values():java.util.Map");
            }
        });
    }
}
