package com.appsflyer.internal;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class AFe1bSDK extends AFa1sSDK {
    private final boolean AFLogger$LogLevel;
    public boolean AFVersionDeclaration;
    private final boolean afWarnLog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AFe1bSDK() {
        this(null, null, null, null, null, null);
    }

    public final boolean AFLogger$LogLevel() {
        return this.AFLogger$LogLevel;
    }

    public final boolean afErrorLogForExcManagerOnly() {
        return this.AFVersionDeclaration;
    }

    public final boolean afWarnLog() {
        return this.afWarnLog;
    }

    public AFe1bSDK(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        this.afWarnLog = bool != null ? bool.booleanValue() : true;
        this.AFLogger$LogLevel = bool2 != null ? bool2.booleanValue() : true;
    }
}
