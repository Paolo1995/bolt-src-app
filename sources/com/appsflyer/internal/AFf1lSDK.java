package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ProviderInfo;

/* loaded from: classes.dex */
public final class AFf1lSDK extends AFf1kSDK {
    final ProviderInfo AFInAppEventParameterName;
    private final AFc1vSDK AFKeystoreWrapper;

    public AFf1lSDK(ProviderInfo providerInfo, Runnable runnable, AFc1vSDK aFc1vSDK) {
        super("af_referrer", providerInfo.authority, runnable);
        this.AFKeystoreWrapper = aFc1vSDK;
        this.AFInAppEventParameterName = providerInfo;
    }

    @Override // com.appsflyer.internal.AFf1kSDK
    public final void valueOf(final Context context) {
        this.AFKeystoreWrapper.AFKeystoreWrapper().execute(new Runnable() { // from class: com.appsflyer.internal.AFf1lSDK.4
            /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00de  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 284
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1lSDK.AnonymousClass4.run():void");
            }
        });
    }
}
