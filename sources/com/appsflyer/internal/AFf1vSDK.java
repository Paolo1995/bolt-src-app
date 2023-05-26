package com.appsflyer.internal;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class AFf1vSDK extends AFe1bSDK {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AFf1vSDK() {
        this(null, null, null);
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final boolean AFLogger() {
        return false;
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final boolean afDebugLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFa1sSDK
    public final boolean afErrorLog() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AFf1vSDK(String str, Boolean bool, Context context) {
        super(str, null, Boolean.FALSE, null, bool, context);
    }
}
