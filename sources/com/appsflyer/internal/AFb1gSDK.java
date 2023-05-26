package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.appsflyer.internal.AFb1dSDK;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AFb1gSDK implements AFb1dSDK {
    private AFb1fSDK AFInAppEventParameterName;
    private final Executor AFKeystoreWrapper;
    private final AFa1tSDK valueOf;

    public AFb1gSDK(Executor executor, AFa1tSDK aFa1tSDK) {
        Intrinsics.f(executor, "");
        Intrinsics.f(aFa1tSDK, "");
        this.AFKeystoreWrapper = executor;
        this.valueOf = aFa1tSDK;
    }

    @Override // com.appsflyer.internal.AFb1dSDK
    public final void AFKeystoreWrapper(Context context) {
        AFb1dSDK.AFa1wSDK aFa1wSDK;
        Intrinsics.f(context, "");
        AFb1fSDK aFb1fSDK = this.AFInAppEventParameterName;
        if (aFb1fSDK != null && (aFa1wSDK = aFb1fSDK.AFKeystoreWrapper) != null) {
            aFa1wSDK.AFKeystoreWrapper(context);
        }
    }

    @Override // com.appsflyer.internal.AFb1dSDK
    public final boolean valueOf() {
        if (this.AFInAppEventParameterName != null) {
            return true;
        }
        return false;
    }

    @Override // com.appsflyer.internal.AFb1dSDK
    public final void values(Context context, AFb1dSDK.AFa1wSDK aFa1wSDK) {
        Intrinsics.f(context, "");
        Intrinsics.f(aFa1wSDK, "");
        Intrinsics.f(context, "");
        if (this.AFInAppEventParameterName != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.AFInAppEventParameterName);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
            }
        }
        this.AFInAppEventParameterName = null;
        AFb1fSDK aFb1fSDK = new AFb1fSDK(this.AFKeystoreWrapper, this.valueOf, aFa1wSDK);
        this.AFInAppEventParameterName = aFb1fSDK;
        if (context instanceof Activity) {
            aFb1fSDK.onActivityResumed((Activity) context);
        }
        Context applicationContext2 = context.getApplicationContext();
        if (applicationContext2 != null) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(this.AFInAppEventParameterName);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }
}
