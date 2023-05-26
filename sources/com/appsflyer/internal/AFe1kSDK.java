package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFe1kSDK extends AFa1sSDK {
    /* JADX WARN: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"VisibleForTests"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AFe1kSDK(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.appsflyer.internal.AFe1lSDK.values
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.appsflyer.AppsFlyerLib r3 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r3 = r3.getHostPrefix()
            r4 = 0
            r2[r4] = r3
            com.appsflyer.internal.AFb1xSDK r3 = com.appsflyer.internal.AFb1xSDK.AFInAppEventType()
            java.lang.String r3 = r3.getHostName()
            r4 = 1
            r2[r4] = r3
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.append(r1)
            java.lang.String r1 = r6.getPackageName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.String r2 = "Register"
            r5.<init>(r2, r0, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1kSDK.<init>(android.content.Context):void");
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final AFd1rSDK AFInAppEventType() {
        return AFd1rSDK.REGISTER;
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final boolean AFLogger() {
        return false;
    }
}
